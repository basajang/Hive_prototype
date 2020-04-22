package com.waem.hivePrototype.util.requestHelper.Request.file;

public interface ProgressRequestListener {
    void onRequestProgress(long bytesWritten, long contentLength, boolean done);
}