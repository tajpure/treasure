package com.tajpure.scheme.compiler.value.premitives

import com.tajpure.scheme.compiler.value.PrimFunc
import com.tajpure.scheme.compiler.value.Value
import com.tajpure.scheme.compiler.ast.Node

class And extends PrimFunc("and" , 2) {
  
  def apply(args: List[Value], location: Node): Value = {
//    args.foldLeft(true)( (result, arg) => result && arg.
    null
  }
  
  def typecheck(args: List[Value], location: Node): Value= {
    null
  }

  override
  def toString: String = {
    "and"
  }
  
}