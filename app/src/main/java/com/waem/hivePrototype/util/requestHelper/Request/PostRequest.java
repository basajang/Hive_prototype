package com.waem.hivePrototype.util.requestHelper.Request;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class PostRequest {

    private OkHttpClient okHttpClient;
    private Request request;
    private Map<String, String> map = new HashMap<>();
    private String url;

    public PostRequest(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    protected PostRequest setUrl(String url) {
        this.url = url;
        return this;
    }


    public PostRequest addParam(String key, String value){
        map.put(key, value);
        return this;
    }


    public GetRequest Build(){

        GetRequest getRequest = new GetRequest(okHttpClient);

        getRequest.setRequest(new Request.Builder()
//                    .addHeader("x-api-key", RestTestCommon.API_KEY)
                .url(url)
                .post(RequestBody.create(MediaType.parse("application/json"), map.toString()))
                .build());
        return getRequest;
    }


}
