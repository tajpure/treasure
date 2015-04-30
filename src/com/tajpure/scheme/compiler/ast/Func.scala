package com.tajpure.scheme.compiler.ast

import com.tajpure.scheme.compiler.Scope
import com.tajpure.scheme.compiler.value.Value
import com.tajpure.scheme.compiler.value.IntValue
import com.tajpure.scheme.compiler.value.FloatValue
import com.tajpure.scheme.compiler.value.Closure
import org.jllvm._type.FunctionType
import org.jllvm.bindings.LLVMLinkage
import org.jllvm._type.IntegerType
import org.jllvm._type.Type
import org.jllvm.value.BasicBlock
import org.jllvm._type.PointerType
import org.jllvm.value.user.constant.Function
import com.tajpure.scheme.compiler.exception.CompilerException
import org.jllvm.value.user.instruction.LoadInstruction
import org.jllvm.value.user.instruction.StoreInstruction

class Func(_params: List[Name], _propertyForm: Scope, _body: Node, _file: String, _start: Int, _end: Int, _row: Int, _col: Int)
  extends Node(_file, _start, _end, _row, _col) {
  
  val params: List[Name] = _params
  
  val propertyForm: Scope = _propertyForm
  
  val body: Node = _body
  
  def interp(s: Scope): Value = {
    val properties: Scope = 
      if (propertyForm == null) {
      null
    } else {
      Scope.evalProperties(propertyForm, s)
    }
    new Closure(this, properties, s)
  }

  def typecheck(s: Scope): Value = {
    null
  }
  
  def codegen(s: Scope): org.jllvm.value.Value = {
    val _params: Array[Type] = params.map { param => s.codegen.any }.toArray
    val function: Function = new Function(s.codegen.module, "anonymous", new FunctionType(s.codegen.any, _params, false))
    
    function.setLinkage(LLVMLinkage.LLVMExternalLinkage)

    params.zipWithIndex.foreach {
      case (param, i) => s.putValue0(param.id, function.getParameter(i)) 
    }
      
    val block: BasicBlock = function.appendBasicBlock("entry")
    s.codegen.builder.positionBuilderAtEnd(block)
    val last = body.codegen(s)
    s.codegen.builder.buildRet(last)
    function
  }
  
  override
  def codegen(node: Node, s: Scope): org.jllvm.value.Value = {
    val _params: Array[Type] = params.map { param => s.codegen.any }.toArray
    val function: Function = new Function(s.codegen.module, node.toString(), new FunctionType(s.codegen.any, _params, false))
      
    function.setLinkage(LLVMLinkage.LLVMExternalLinkage)
    s.putValue0(node.toString(), function)
    
    params.zipWithIndex.foreach {
      case (param, i) => s.putValue0(param.id, function.getParameter(i)) 
    }
      
    val block: BasicBlock = function.appendBasicBlock("entry")
    s.codegen.builder.positionBuilderAtEnd(block)
    val last = body.codegen(s)
    val ret =
      if (last.isInstanceOf[Function] || last.isInstanceOf[LoadInstruction] || last.isInstanceOf[StoreInstruction]) {
       val void = s.codegen.builder.buildAlloca(s.codegen.any, "ret")
       s.codegen.builder.buildLoad(void, "void")
      } else {
        last
      }
    s.codegen.builder.buildRet(ret)
    function
  }
  
  override
  def toString: String = {
    "function args:" + params + " body:" + body
  }
  
}