package com.tajpure.scheme.compiler.llvm

import org.jllvm.InstructionBuilder
import org.jllvm.Module
import org.jllvm.NativeLibrary
import org.jllvm._type.FunctionType
import org.jllvm._type.IdentifiedStructType
import org.jllvm._type.IntegerType
import org.jllvm._type.PointerType
import org.jllvm._type.Type
import org.jllvm.bindings.LLVMLinkage
import org.jllvm.value.BasicBlock
import org.jllvm.value.user.constant.ConstantInteger
import org.jllvm.value.user.constant.ConstantReal
import org.jllvm.value.user.constant.Function
import org.jllvm.value.user.instruction.ReturnInstruction
import com.tajpure.scheme.compiler.Scope
import com.tajpure.scheme.compiler.ast.Func
import com.tajpure.scheme.compiler.ast.Node
import com.tajpure.scheme.compiler.value.FloatValue
import com.tajpure.scheme.compiler.value.IntValue
import com.tajpure.scheme.compiler.value.Value
import org.jllvm.value.user.instruction.StackAllocation
import org.jllvm.value.user.instruction.GetElementPointerInstruction
import org.jllvm.value.user.instruction.LoadInstruction
import org.jllvm.value.user.instruction.StoreInstruction
import org.jllvm.value.user.instruction.PhiNode

/**
 * A wrapper for LLVM API.
 */
class CodeGen(_source: String) {

  val module: Module = new Module(_source)

  val llvmTypes: LLVMTypes = new LLVMTypes()

  val builder: InstructionBuilder = new InstructionBuilder()
  
//  val any: IdentifiedStructType = new IdentifiedStructType("Any")
//  
//  any.setBody(Array[org.jllvm._type.Type](
//      org.jllvm._type.IntegerType.i32, 
//      org.jllvm._type.IntegerType.i8, 
//      org.jllvm._type.IntegerType.i32, 
//      new org.jllvm._type.FloatType()),
//      false)
  
  val any: IntegerType = IntegerType.i32

  def buildAdd(lhs: org.jllvm.value.Value, rhs: org.jllvm.value.Value): org.jllvm.value.Value = {
    builder.buildAdd(lhs, rhs, "")
  }

  def buildSub(lhs: org.jllvm.value.Value, rhs: org.jllvm.value.Value): org.jllvm.value.Value = {
    builder.buildSub(lhs, rhs, "")
  }

  def builDiv(lhs: org.jllvm.value.Value, rhs: org.jllvm.value.Value): org.jllvm.value.Value = {
    builder.buildSDiv(lhs, rhs, "")
  }

  def buildMult(lhs: org.jllvm.value.Value, rhs: org.jllvm.value.Value): org.jllvm.value.Value = {
    builder.buildMul(lhs, rhs, "")
  }
  
  def buildLoad(value: org.jllvm.value.Value, name: String): org.jllvm.value.Value = {
    builder.buildLoad(value, name)
  }
  
  def buildFunc(pattern: Node, value: Node, s: Scope): org.jllvm.value.Value = {
      val _value: Func = value.asInstanceOf[Func]
//      val _type: PointerType = new PointerType(s.codegen.any, 0)
      val _params: Array[Type] = _value.params.map { param => new PointerType(s.codegen.any, 0) }.toArray
      val function: Function = new Function(s.codegen.module, pattern.toString(), new FunctionType(any, _params, false))
      
      function.setLinkage(LLVMLinkage.LLVMExternalLinkage)
      s.put("this", "function", function)
      
      _value.params.zipWithIndex.foreach {
        case (param, i) => s.put(param.id, "parameter", function.getParameter(i)) }
      
      val block: BasicBlock = function.appendBasicBlock("entry")
      builder.positionBuilderAtEnd(block)
      val last = _value.body.codegen(s)
      s.codegen.builder.buildRet(last)
      function
  }
  
  def valueOf(alloc: StackAllocation, s: Scope): org.jllvm.value.Value = {
     null
  }

  def buildInt(value: Value): org.jllvm.value.Value = {
    ConstantInteger.constI32(value.asInstanceOf[IntValue].value)
  }
  
  def buildFloat(value: Value): org.jllvm.value.Value = {
    new ConstantReal(new org.jllvm._type.FloatType(), value.asInstanceOf[FloatValue].value)
  }
  
  def print(): Unit = {
    module.dump()
  }
  
  def save(_path: String): Unit = {
    module.printToFile(_path)
  }
  
  def execute(): Unit = {
    module.dump()
  }

}

object CodeGen extends App {

  NativeLibrary.load()
  
  val codegen: CodeGen = new CodeGen("test")
  
  val _type: IntegerType = new IntegerType(32)
  val Doubles:  Array[Type] = new Array[Type](0)
  val function: org.jllvm.value.user.constant.Function = 
    new org.jllvm.value.user.constant.Function(codegen.module, "test", new FunctionType(_type, Doubles, false))
  
  function.setLinkage(LLVMLinkage.LLVMExternalLinkage)
  
  val block: BasicBlock = function.appendBasicBlock("entry");
  codegen.builder.positionBuilderAtEnd(block)
  
  new ReturnInstruction(codegen.builder, ConstantInteger.constI32(0));
  codegen.print()

}