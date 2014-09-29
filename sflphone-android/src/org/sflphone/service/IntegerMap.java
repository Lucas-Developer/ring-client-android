/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.sflphone.service;

public class IntegerMap {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected IntegerMap(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(IntegerMap obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        SFLPhoneserviceJNI.delete_IntegerMap(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public IntegerMap() {
    this(SFLPhoneserviceJNI.new_IntegerMap__SWIG_0(), true);
  }

  public IntegerMap(IntegerMap arg0) {
    this(SFLPhoneserviceJNI.new_IntegerMap__SWIG_1(IntegerMap.getCPtr(arg0), arg0), true);
  }

  public long size() {
    return SFLPhoneserviceJNI.IntegerMap_size(swigCPtr, this);
  }

  public boolean empty() {
    return SFLPhoneserviceJNI.IntegerMap_empty(swigCPtr, this);
  }

  public void clear() {
    SFLPhoneserviceJNI.IntegerMap_clear(swigCPtr, this);
  }

  public int get(String key) {
    return SFLPhoneserviceJNI.IntegerMap_get(swigCPtr, this, key);
  }

  public void set(String key, int x) {
    SFLPhoneserviceJNI.IntegerMap_set(swigCPtr, this, key, x);
  }

  public void del(String key) {
    SFLPhoneserviceJNI.IntegerMap_del(swigCPtr, this, key);
  }

  public boolean has_key(String key) {
    return SFLPhoneserviceJNI.IntegerMap_has_key(swigCPtr, this, key);
  }

}