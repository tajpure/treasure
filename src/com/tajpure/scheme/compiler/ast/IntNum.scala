package com.tajpure.scheme.compiler.ast

import com.tajpure.scheme.compiler.Scope
import com.tajpure.scheme.compiler.value.Value
import com.tajpure.scheme.compiler.value.IntValue
import com.tajpure.scheme.compiler.value.Type

class IntNum(_content: String, _file: String, _start: Int, _end: Int, _row: Int, _col: Int)
  extends Node(_file, _start, _end, _row, _col) {
  
  var content: String = _content
  
  var value: Int = 0
  
  var sign: Int = 1

  if (content.startsWith("+")) {
    sign = 1
    content = content.substring(1)
  } else if (content.startsWith("-")) {
    sign = -1
    content = content.substring(1)
  }

  value = content.toInt * sign

  def interp(s: Scope): Value = {
    new IntValue(value)
  }

  def typeCheck(s: Scope): Value = {
    Type.INT
  }
  
  def codegen(s: Scope): Value = {
    null
  }
  
  override
  def toString(): String = {
    content
  }
  
}