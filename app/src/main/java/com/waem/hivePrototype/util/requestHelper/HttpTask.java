package com.waem.hivePrototype.util.requestHelper;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpTask {

    private String TAG = "HttpTask";
    private GetRequestInterface requestInterface;

    public HttpTask() {
    }
    public GetRequestInterface get(String url) {
        return new GetRequestInterface(new OkHttpClient()).setRequest(new Request.Builder()
//                    .addHeader("x-api-key", RestTestCommon.API_KEY)
                .url(url).build());
    }

    public PostRequestInterface post(String url) {
        return new PostRequestInterface(new OkHttpClient()).setUrl(url);
    }



}
