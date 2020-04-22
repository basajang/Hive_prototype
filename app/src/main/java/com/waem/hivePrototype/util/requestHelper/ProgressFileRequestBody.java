package com.waem.hivePrototype.util.requestHelper;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;


// 테스트 필요
public class ProgressFileRequestBody extends RequestBody {

    private static final int SEGMENT_SIZE = 2048; // okio.Segment.SIZE

    private File file;
    private byte[] byteFile;
    private ProgressListener listener;
    private String contentType;

    public ProgressFileRequestBody(File file, ProgressListener listener, String contentType) {
        this.file = file;
        this.listener = listener;
        this.contentType = contentType;
    }

    public ProgressFileRequestBody(byte[]  byteFile, ProgressListener listener, String contentType) {
        this.byteFile = byteFile;
        this.listener = listener;
        this.contentType = contentType;
    }

    @Override
    public long contentLength() throws IOException {

        if(null != file){
            return file.length();
        }else{
            ByteBuffer buf = ByteBuffer.wrap(byteFile);
            return buf.getLong();
        }
    }

    @Nullable
    @Override
    public MediaType contentType() {
        return MediaType.parse(contentType);
    }

    @Override
    public void writeTo(@NotNull BufferedSink bufferedSink) throws IOException {
        Source source = null;
        try {
            source = Okio.source(file);
            long total = 0;
            long read;

            while ((read = source.read(bufferedSink.buffer(), SEGMENT_SIZE)) != -1) {
                total += read;
                bufferedSink.flush();
                this.listener.progress(total);

            }
        } finally {
            Util.closeQuietly(source);
        }
    }

    public interface ProgressListener {
        void progress(long num);
    }

}
