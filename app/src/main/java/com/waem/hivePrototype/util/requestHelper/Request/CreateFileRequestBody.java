package com.waem.hivePrototype.util.requestHelper.Request;

import com.waem.hivePrototype.util.requestHelper.ProgressFileRequestBody;

import java.io.File;

import okhttp3.MultipartBody;

public class CreateFileRequestBody  {

    private UploadRequestTesk uploadRequest;
    private String formDataName;
    private String fileName;

    public CreateFileRequestBody(UploadRequestTesk uploadRequest, String formDataName, String fileName) {
        this.uploadRequest = uploadRequest;
        this.formDataName = formDataName;
        this.fileName = fileName;
    }

    public AddUploadListener createBody(String contentType, byte[] byteFile, ProgressFileRequestBody.ProgressListener listener){
        uploadRequest.setRequestBody(new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(this.formDataName, this.fileName, new ProgressFileRequestBody(byteFile, listener, contentType))
                .build());

        return new AddUploadListener(uploadRequest);
    }

    public AddUploadListener createBody(String contentType, File file, ProgressFileRequestBody.ProgressListener listener){
        uploadRequest.setRequestBody(new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(this.formDataName, this.fileName, new ProgressFileRequestBody(file, listener, contentType))
                .build());
        return new AddUploadListener(uploadRequest);
    }
}
