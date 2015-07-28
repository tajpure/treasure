/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.jllvm.bindings;

public class lto implements ltoConstants {
  public static LLVMOpaqueStringRefArray new_StringArray(int nelements) {
    long cPtr = ltoJNI.new_StringArray(nelements);
    return (cPtr == 0) ? null : new LLVMOpaqueStringRefArray(cPtr, false);
  }

  public static void delete_StringArray(LLVMOpaqueStringRefArray ary) {
    ltoJNI.delete_StringArray(LLVMOpaqueStringRefArray.getCPtr(ary));
  }

  public static String StringArray_getitem(LLVMOpaqueStringRefArray ary, int index) {
    return ltoJNI.StringArray_getitem(LLVMOpaqueStringRefArray.getCPtr(ary), index);
  }

  public static void StringArray_setitem(LLVMOpaqueStringRefArray ary, int index, String value) {
    ltoJNI.StringArray_setitem(LLVMOpaqueStringRefArray.getCPtr(ary), index, value);
  }

  public static String lto_get_version() {
    return ltoJNI.lto_get_version();
  }

  public static String lto_get_error_message() {
    return ltoJNI.lto_get_error_message();
  }

  public static boolean lto_module_is_object_file(String path) {
    return ltoJNI.lto_module_is_object_file(path);
  }

  public static boolean lto_module_is_object_file_for_target(String path, String target_triple_prefix) {
    return ltoJNI.lto_module_is_object_file_for_target(path, target_triple_prefix);
  }

  public static boolean lto_module_is_object_file_in_memory(LLVMOpaqueVoid mem, long length) {
    return ltoJNI.lto_module_is_object_file_in_memory(LLVMOpaqueVoid.getCPtr(mem), length);
  }

  public static boolean lto_module_is_object_file_in_memory_for_target(LLVMOpaqueVoid mem, long length, String target_triple_prefix) {
    return ltoJNI.lto_module_is_object_file_in_memory_for_target(LLVMOpaqueVoid.getCPtr(mem), length, target_triple_prefix);
  }

  public static ltoModule lto_module_create(String path) {
    long cPtr = ltoJNI.lto_module_create(path);
    return (cPtr == 0) ? null : new ltoModule(cPtr, false);
  }

  public static ltoModule lto_module_create_from_memory(LLVMOpaqueVoid mem, long length) {
    long cPtr = ltoJNI.lto_module_create_from_memory(LLVMOpaqueVoid.getCPtr(mem), length);
    return (cPtr == 0) ? null : new ltoModule(cPtr, false);
  }

  public static ltoModule lto_module_create_from_fd(int fd, String path, long file_size) {
    long cPtr = ltoJNI.lto_module_create_from_fd(fd, path, file_size);
    return (cPtr == 0) ? null : new ltoModule(cPtr, false);
  }

  public static ltoModule lto_module_create_from_fd_at_offset(int fd, String path, long file_size, long map_size, LLVMOpaqueOff_t offset) {
    long cPtr = ltoJNI.lto_module_create_from_fd_at_offset(fd, path, file_size, map_size, LLVMOpaqueOff_t.getCPtr(offset));
    return (cPtr == 0) ? null : new ltoModule(cPtr, false);
  }

  public static void lto_module_dispose(ltoModule mod) {
    ltoJNI.lto_module_dispose(ltoModule.getCPtr(mod));
  }

  public static String lto_module_get_target_triple(ltoModule mod) {
    return ltoJNI.lto_module_get_target_triple(ltoModule.getCPtr(mod));
  }

  public static void lto_module_set_target_triple(ltoModule mod, String triple) {
    ltoJNI.lto_module_set_target_triple(ltoModule.getCPtr(mod), triple);
  }

  public static long lto_module_get_num_symbols(ltoModule mod) {
    return ltoJNI.lto_module_get_num_symbols(ltoModule.getCPtr(mod));
  }

  public static String lto_module_get_symbol_name(ltoModule mod, long index) {
    return ltoJNI.lto_module_get_symbol_name(ltoModule.getCPtr(mod), index);
  }

  public static ltoSymbolAttributes lto_module_get_symbol_attribute(ltoModule mod, long index) {
    return ltoSymbolAttributes.swigToEnum(ltoJNI.lto_module_get_symbol_attribute(ltoModule.getCPtr(mod), index));
  }

  public static ltoCodeGenerator lto_codegen_create() {
    long cPtr = ltoJNI.lto_codegen_create();
    return (cPtr == 0) ? null : new ltoCodeGenerator(cPtr, false);
  }

  public static void lto_codegen_dispose(ltoCodeGenerator arg0) {
    ltoJNI.lto_codegen_dispose(ltoCodeGenerator.getCPtr(arg0));
  }

  public static boolean lto_codegen_add_module(ltoCodeGenerator cg, ltoModule mod) {
    return ltoJNI.lto_codegen_add_module(ltoCodeGenerator.getCPtr(cg), ltoModule.getCPtr(mod));
  }

  public static boolean lto_codegen_set_debug_model(ltoCodeGenerator cg, ltoDebugModel arg1) {
    return ltoJNI.lto_codegen_set_debug_model(ltoCodeGenerator.getCPtr(cg), arg1.swigValue());
  }

  public static boolean lto_codegen_set_pic_model(ltoCodeGenerator cg, ltoCodegenModel arg1) {
    return ltoJNI.lto_codegen_set_pic_model(ltoCodeGenerator.getCPtr(cg), arg1.swigValue());
  }

  public static void lto_codegen_set_cpu(ltoCodeGenerator cg, String cpu) {
    ltoJNI.lto_codegen_set_cpu(ltoCodeGenerator.getCPtr(cg), cpu);
  }

  public static void lto_codegen_set_assembler_path(ltoCodeGenerator cg, String path) {
    ltoJNI.lto_codegen_set_assembler_path(ltoCodeGenerator.getCPtr(cg), path);
  }

  public static void lto_codegen_set_assembler_args(ltoCodeGenerator cg, LLVMOpaqueStringRefArray args, int nargs) {
    ltoJNI.lto_codegen_set_assembler_args(ltoCodeGenerator.getCPtr(cg), LLVMOpaqueStringRefArray.getCPtr(args), nargs);
  }

  public static void lto_codegen_add_must_preserve_symbol(ltoCodeGenerator cg, String symbol) {
    ltoJNI.lto_codegen_add_must_preserve_symbol(ltoCodeGenerator.getCPtr(cg), symbol);
  }

  public static boolean lto_codegen_write_merged_modules(ltoCodeGenerator cg, String path) {
    return ltoJNI.lto_codegen_write_merged_modules(ltoCodeGenerator.getCPtr(cg), path);
  }

  public static LLVMOpaqueVoid lto_codegen_compile(ltoCodeGenerator cg, LLVMOpaqueSize_t length) {
    long cPtr = ltoJNI.lto_codegen_compile(ltoCodeGenerator.getCPtr(cg), LLVMOpaqueSize_t.getCPtr(length));
    return (cPtr == 0) ? null : new LLVMOpaqueVoid(cPtr, false);
  }

  public static boolean lto_codegen_compile_to_file(ltoCodeGenerator cg, LLVMOpaqueStringRefArray name) {
    return ltoJNI.lto_codegen_compile_to_file(ltoCodeGenerator.getCPtr(cg), LLVMOpaqueStringRefArray.getCPtr(name));
  }

  public static void lto_codegen_debug_options(ltoCodeGenerator cg, String arg1) {
    ltoJNI.lto_codegen_debug_options(ltoCodeGenerator.getCPtr(cg), arg1);
  }

}
