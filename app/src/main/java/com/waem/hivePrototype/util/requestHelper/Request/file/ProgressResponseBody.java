package com.waem.hivePrototype.util.requestHelper.Request.file;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * The sound of the package, processing progress
 */
public class ProgressResponseBody extends ResponseBody {
    // Actual to be packaged response body
    private final ResponseBody responseBody;
    // Progress callback interface
    private final ProgressResponseListener progressListener;
    //Packaged completed BufferedSource
    private BufferedSource bufferedSource;

    /**
     * constructor, assignment
     *
     * @param responseBody     The response body to be wrapped
     * @param progressListener callback interface
     */
    public ProgressResponseBody(ResponseBody responseBody, ProgressResponseListener progressListener) {
        this.responseBody = responseBody;
        this.progressListener = progressListener;
    }


    /**
     * Rewrite the contentType of the actual response body
     *
     * @return MediaType
     */
    @Override
    public MediaType contentType() {
        return responseBody.contentType();
    }

    /**
     * Rewrite the contentLength that calls the actual response body
     *
     * @return contentLength
     * @throws IOException exception
     */
    @Override
    public long contentLength() {
        return responseBody.contentLength();
    }

    /**
     * Rewrite to wrap the source
     *
     * @return BufferedSource
     * @throws IOException exception
     */
    @Override
    public BufferedSource source() {
        if (bufferedSource == null) {
            //Packing
            Source source = source(responseBody.source());

            bufferedSource = Okio.buffer(source);
        }
        return bufferedSource;
    }

    /**
     * Read, callback progress interface
     *
     * @param source Source
     * @return Source
     */
    private Source source(Source source) {

        return new ForwardingSource(source) {
            // The current number of bytes read
            long totalBytesRead = 0L;

            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                long bytesRead = super.read(sink, byteCount);
                // Increase the number of bytes currently read, if the reading is completed, bytesRead will return -1
                totalBytesRead += bytesRead != -1 ? bytesRead : 0;
                //callback, if contentLength() doesn't know the length, it will return -1
                progressListener.onResponseProgress(totalBytesRead, responseBody.contentLength(), bytesRead == -1);
                return bytesRead;
            }
        };
    }
}