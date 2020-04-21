package com.waem.hivePrototype.util.requestHelper.Request.file;

/**
 * The sound of the package, processing progress
 */
public interface ProgressResponseListener {
    void onResponseProgress(long bytesRead, long contentLength, boolean done);
}