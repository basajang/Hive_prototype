package com.waem.hivePrototype.util.requestHelper.Request;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CallbackToDownloadFile implements Callback {

    private File directory;
    private File fileToBeDownloaded;

    public CallbackToDownloadFile(String directory, String fileName) {
        this.directory = new File(directory);
        this.fileToBeDownloaded = new File(this.directory.getAbsolutePath() + "/" + fileName);
    }


    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {

    }

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        if (!this.directory.exists()) {
            this.directory.mkdirs();
        }

        if (this.fileToBeDownloaded.exists()) {
            this.fileToBeDownloaded.delete();
        }

        try {
            this.fileToBeDownloaded.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        InputStream is = response.body().byteStream();
        OutputStream os = new FileOutputStream(this.fileToBeDownloaded);

        final int BUFFER_SIZE = 2048;
        byte[] data = new byte[BUFFER_SIZE];

        int count;
        long total = 0;

        while ((count = is.read(data)) != -1) {
            total += count;
            os.write(data, 0, count);
        }

        os.flush();
        os.close();
        is.close();
    }
}