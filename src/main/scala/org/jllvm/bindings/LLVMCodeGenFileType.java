/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.jllvm.bindings;

public final class LLVMCodeGenFileType {
  public final static LLVMCodeGenFileType LLVMAssemblyFile = new LLVMCodeGenFileType("LLVMAssemblyFile");
  public final static LLVMCodeGenFileType LLVMObjectFile = new LLVMCodeGenFileType("LLVMObjectFile");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static LLVMCodeGenFileType swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + LLVMCodeGenFileType.class + " with value " + swigValue);
  }

  private LLVMCodeGenFileType(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private LLVMCodeGenFileType(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private LLVMCodeGenFileType(String swigName, LLVMCodeGenFileType swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static LLVMCodeGenFileType[] swigValues = { LLVMAssemblyFile, LLVMObjectFile };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

