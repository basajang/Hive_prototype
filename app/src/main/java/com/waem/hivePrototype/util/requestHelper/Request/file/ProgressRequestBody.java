package com.waem.hivePrototype.util.requestHelper.Request.file;

import android.util.Log;

import com.waem.hivePrototype.Constants;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/**
 * The request body of the package, processing progress
 */
public class ProgressRequestBody extends RequestBody {
    // Actual to-be-packaged request body
    private final RequestBody requestBody;
    // Progress callback interface
    private final ProgressRequestListener progressListener;
    //Packaged completed BufferedSink
    private BufferedSink bufferedSink;

    /**
     * constructor, assignment
     *
     * @param requestBody      Request body to be wrapped
     * @param progressListener callback interface
     */
    public ProgressRequestBody(RequestBody requestBody, ProgressRequestListener progressListener) {
        this.requestBody = requestBody;
        this.progressListener = progressListener;
    }

    /**
     * Rewrite the contentType of the actual response body
     *
     * @return MediaType
     */
    @Override
    public MediaType contentType() {
        return requestBody.contentType();
    }

    /**
     * Rewrite the contentLength that calls the actual response body
     *
     * @return contentLength
     * @throws IOException exception
     */
    @Override
    public long contentLength() throws IOException {
        return requestBody.contentLength();
    }

    /**
     * Rewrite to write
     *
     * @param sink BufferedSink
     * @throws IOException exception
     */
    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        if (bufferedSink == null) {
            //Packing
            Sink sk = sink(sink);
            bufferedSink = Okio.buffer(sk);
        }
        //write
        requestBody.writeTo(bufferedSink);
        // must call flush, otherwise the last part of the data may not be written
        bufferedSink.flush();

    }

    /**
     * Write, callback progress interface
     *
     * @param sink Sink
     * @return Sink
     */
    private Sink sink(Sink sink) {
        return new ForwardingSink(sink) {
            // The current number of bytes written
            long bytesWritten = 0L;
            // total byte length, avoid calling the contentLength () method multiple times
            long contentLength = 0L;

            @Override
            public void write(Buffer source, long byteCount) throws IOException {
                super.write(source, byteCount);
                if (contentLength == 0) {
                    // Get the value of contentLength, no longer call later
                    contentLength = contentLength();
                }
                // Increase the number of bytes currently written
                bytesWritten += byteCount;
                Log.d(Constants.TAG, "write: bytesWritten = "+bytesWritten);
                //callback
                progressListener.onRequestProgress(bytesWritten, contentLength, bytesWritten == contentLength);
            }
        };
    }
}