package com.waem.hivePrototype.util.requestHelper.Request.file;

import java.io.Serializable;

/**
 * UI progress callback entity class
 */
public class ProgressModel implements Serializable {
    // Current read byte length
    private long currentBytes;
    // total byte length
    private long contentLength;
    // Is the reading completed?
    private boolean done;

    public ProgressModel(long currentBytes, long contentLength, boolean done) {
        this.currentBytes = currentBytes;
        this.contentLength = contentLength;
        this.done = done;
    }

    public long getCurrentBytes() {
        return currentBytes;
    }

    public void setCurrentBytes(long currentBytes) {
        this.currentBytes = currentBytes;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "ProgressModel{" +
                "currentBytes=" + currentBytes +
                ", contentLength=" + contentLength +
                ", done=" + done +
                '}';
    }
}