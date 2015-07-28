/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.jllvm.bindings;

public class BitReader {
  public static LLVMOpaqueModuleRefArray new_LLVMModuleRefArray(int nelements) {
    long cPtr = BitReaderJNI.new_LLVMModuleRefArray(nelements);
    return (cPtr == 0) ? null : new LLVMOpaqueModuleRefArray(cPtr, false);
  }

  public static void delete_LLVMModuleRefArray(LLVMOpaqueModuleRefArray ary) {
    BitReaderJNI.delete_LLVMModuleRefArray(LLVMOpaqueModuleRefArray.getCPtr(ary));
  }

  public static LLVMOpaqueModule LLVMModuleRefArray_getitem(LLVMOpaqueModuleRefArray ary, int index) {
    long cPtr = BitReaderJNI.LLVMModuleRefArray_getitem(LLVMOpaqueModuleRefArray.getCPtr(ary), index);
    return (cPtr == 0) ? null : new LLVMOpaqueModule(cPtr, false);
  }

  public static void LLVMModuleRefArray_setitem(LLVMOpaqueModuleRefArray ary, int index, LLVMOpaqueModule value) {
    BitReaderJNI.LLVMModuleRefArray_setitem(LLVMOpaqueModuleRefArray.getCPtr(ary), index, LLVMOpaqueModule.getCPtr(value));
  }

  public static LLVMOpaqueStringRefArray new_StringArray(int nelements) {
    long cPtr = BitReaderJNI.new_StringArray(nelements);
    return (cPtr == 0) ? null : new LLVMOpaqueStringRefArray(cPtr, false);
  }

  public static void delete_StringArray(LLVMOpaqueStringRefArray ary) {
    BitReaderJNI.delete_StringArray(LLVMOpaqueStringRefArray.getCPtr(ary));
  }

  public static String StringArray_getitem(LLVMOpaqueStringRefArray ary, int index) {
    return BitReaderJNI.StringArray_getitem(LLVMOpaqueStringRefArray.getCPtr(ary), index);
  }

  public static void StringArray_setitem(LLVMOpaqueStringRefArray ary, int index, String value) {
    BitReaderJNI.StringArray_setitem(LLVMOpaqueStringRefArray.getCPtr(ary), index, value);
  }

  public static int LLVMParseBitcode(LLVMOpaqueMemoryBuffer MemBuf, LLVMOpaqueModuleRefArray OutModule, LLVMOpaqueStringRefArray OutMessage) {
    return BitReaderJNI.LLVMParseBitcode(LLVMOpaqueMemoryBuffer.getCPtr(MemBuf), LLVMOpaqueModuleRefArray.getCPtr(OutModule), LLVMOpaqueStringRefArray.getCPtr(OutMessage));
  }

  public static int LLVMParseBitcodeInContext(LLVMOpaqueContext ContextRef, LLVMOpaqueMemoryBuffer MemBuf, LLVMOpaqueModuleRefArray OutModule, LLVMOpaqueStringRefArray OutMessage) {
    return BitReaderJNI.LLVMParseBitcodeInContext(LLVMOpaqueContext.getCPtr(ContextRef), LLVMOpaqueMemoryBuffer.getCPtr(MemBuf), LLVMOpaqueModuleRefArray.getCPtr(OutModule), LLVMOpaqueStringRefArray.getCPtr(OutMessage));
  }

  public static int LLVMGetBitcodeModuleInContext(LLVMOpaqueContext ContextRef, LLVMOpaqueMemoryBuffer MemBuf, LLVMOpaqueModuleRefArray OutM, LLVMOpaqueStringRefArray OutMessage) {
    return BitReaderJNI.LLVMGetBitcodeModuleInContext(LLVMOpaqueContext.getCPtr(ContextRef), LLVMOpaqueMemoryBuffer.getCPtr(MemBuf), LLVMOpaqueModuleRefArray.getCPtr(OutM), LLVMOpaqueStringRefArray.getCPtr(OutMessage));
  }

  public static int LLVMGetBitcodeModule(LLVMOpaqueMemoryBuffer MemBuf, LLVMOpaqueModuleRefArray OutM, LLVMOpaqueStringRefArray OutMessage) {
    return BitReaderJNI.LLVMGetBitcodeModule(LLVMOpaqueMemoryBuffer.getCPtr(MemBuf), LLVMOpaqueModuleRefArray.getCPtr(OutM), LLVMOpaqueStringRefArray.getCPtr(OutMessage));
  }

  public static int LLVMGetBitcodeModuleProviderInContext(LLVMOpaqueContext ContextRef, LLVMOpaqueMemoryBuffer MemBuf, LLVMOpaqueModuleProviderRefArray OutMP, LLVMOpaqueStringRefArray OutMessage) {
    return BitReaderJNI.LLVMGetBitcodeModuleProviderInContext(LLVMOpaqueContext.getCPtr(ContextRef), LLVMOpaqueMemoryBuffer.getCPtr(MemBuf), LLVMOpaqueModuleProviderRefArray.getCPtr(OutMP), LLVMOpaqueStringRefArray.getCPtr(OutMessage));
  }

  public static int LLVMGetBitcodeModuleProvider(LLVMOpaqueMemoryBuffer MemBuf, LLVMOpaqueModuleProviderRefArray OutMP, LLVMOpaqueStringRefArray OutMessage) {
    return BitReaderJNI.LLVMGetBitcodeModuleProvider(LLVMOpaqueMemoryBuffer.getCPtr(MemBuf), LLVMOpaqueModuleProviderRefArray.getCPtr(OutMP), LLVMOpaqueStringRefArray.getCPtr(OutMessage));
  }

}
