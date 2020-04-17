//
// Created by root on 2020-04-17.
//

#include "com_waem_ndklib_NativeWrapper.h"

JNIEXPORT jint JNICALL Java_com_waem_ndklib_NativeWrapper_nativeSum
(JNIEnv *env, jobject obj, jint a, jint b)
{
     return a+b;
}
