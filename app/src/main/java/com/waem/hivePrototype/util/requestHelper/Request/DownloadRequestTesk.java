package com.waem.hivePrototype.util.requestHelper.Request;

import com.waem.hivePrototype.util.requestHelper.Request.file.ProgressHelper;
import com.waem.hivePrototype.util.requestHelper.Request.file.UIProgressResponseListener;

import org.jetbrains.annotations.NotNull;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class DownloadRequestTesk extends RequestTesk {

    private OkHttpClient okHttpClient;
    private String url;
    private RequestBody requestBody;
    private UIProgressResponseListener uiProgressResponseListener;

    public DownloadRequestTesk(OkHttpClient okHttpClient, String url) {
        super(okHttpClient, url);
    }

    protected void setUrl(String url) {
        this.url = url;
    }

    public AddDownloadCallback download(@NotNull UIProgressResponseListener uiProgressResponseListener){

        return new AddDownloadCallback(ProgressHelper.addProgressResponseListener(okHttpClient, uiProgressResponseListener).newCall(new Request.Builder()
//                    .addHeader("x-api-key", RestTestCommon.API_KEY)
                .url(url)
                .build()));

    }

}
