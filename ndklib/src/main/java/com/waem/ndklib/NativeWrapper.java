package com.waem.ndklib;

public class NativeWrapper {
    static {

        System.loadLibrary("ndklib");

    }

    public native int nativeSum(int a, int b);

    public native int nativeSub(int a, int b);

}
