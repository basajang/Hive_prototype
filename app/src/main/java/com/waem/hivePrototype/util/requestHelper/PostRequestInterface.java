package com.waem.hivePrototype.util.requestHelper;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class PostRequestInterface  {

    private OkHttpClient okHttpClient;
    private Request request;
    private Map<String, String> map = new HashMap<>();
    private String url;

    public PostRequestInterface(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    protected PostRequestInterface setUrl(String url) {
        this.url = url;
        return this;
    }


    public PostRequestInterface addParam(String key, String value){
        map.put(key, value);
        return this;
    }


    public GetRequestInterface Build(){

        GetRequestInterface getRequestInterface = new GetRequestInterface(okHttpClient);

        getRequestInterface.setRequest(new Request.Builder()
//                    .addHeader("x-api-key", RestTestCommon.API_KEY)
                .url(url)
                .post(RequestBody.create(MediaType.parse("application/json"), map.toString()))
                .build());
        return getRequestInterface;
    }


}
