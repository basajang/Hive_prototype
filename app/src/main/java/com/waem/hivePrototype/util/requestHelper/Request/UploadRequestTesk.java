package com.waem.hivePrototype.util.requestHelper.Request;

import com.waem.hivePrototype.util.requestHelper.Request.file.ProgressHelper;
import com.waem.hivePrototype.util.requestHelper.Request.file.ProgressRequestListener;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class UploadRequestTesk extends RequestTesk {

    private OkHttpClient okHttpClient;
    private String url;
    private RequestBody requestBody;
    private ProgressRequestListener uiProgressRequestListener;

    public UploadRequestTesk(OkHttpClient okHttpClient, String url) {
        super(okHttpClient, url);
    }

    @Override
    protected void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
        super.setRequestBody(requestBody);
    }

    public CreateFileRequestBody setFile(String formDataName, String fileName) {
        return new CreateFileRequestBody(this, formDataName, fileName);
    }

    @Override
    protected void setUiProgressRequestListener(ProgressRequestListener uiProgressRequestListener) {
        this.uiProgressRequestListener = uiProgressRequestListener;
        super.setUiProgressRequestListener(uiProgressRequestListener);
    }

    public void upload(Callback callback) {
        okHttpClient.newCall(new Request.Builder().url(url)
                .post(ProgressHelper.addProgressRequestListener(this.requestBody, this.uiProgressRequestListener)).build()).enqueue(callback);
    }


}
