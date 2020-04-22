package com.waem.hivePrototype.util.requestHelper.Request;

import com.waem.hivePrototype.util.requestHelper.Request.file.ProgressRequestListener;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class RequestTesk {

    private OkHttpClient okHttpClient;
    private String url;
    private RequestBody requestBody;
    private ProgressRequestListener uiProgressRequestListener;

    public RequestTesk(OkHttpClient okHttpClient, String url) {
        this.okHttpClient = okHttpClient;
        this.url = url;
    }

    protected void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }

    protected void setUiProgressRequestListener(ProgressRequestListener uiProgressRequestListener) {
        this.uiProgressRequestListener = uiProgressRequestListener;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public String getUrl() {
        return url;
    }

    public RequestBody getRequestBody() {
        return requestBody;
    }

    public ProgressRequestListener getUiProgressRequestListener() {
        return uiProgressRequestListener;
    }
}
