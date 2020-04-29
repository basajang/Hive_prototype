package com.waem.hivePrototype.util.requestHelper.Request;

import android.telephony.mbms.DownloadRequest;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpTask {

    private String TAG = "HttpTask";

    public HttpTask() {
    }
    public GetRequest get(String url) {
        return new GetRequest(new OkHttpClient()).setRequest(new Request.Builder()
//                    .addHeader("x-api-key", RestTestCommon.API_KEY)
                .url(url).build());
    }

    public PostRequest post(String url) {
        return new PostRequest(new OkHttpClient()).setUrl(url);
    }

    public UploadRequestTesk fileUpload(String url){
        return new UploadRequestTesk(new OkHttpClient(), url);
    }

    public DownloadRequestTesk fileDownload(String url){
        return new DownloadRequestTesk(new OkHttpClient(), url);
    }

}
