package com.waem.hivePrototype.util.requestHelper.Request;

import com.waem.hivePrototype.util.requestHelper.Request.file.ProgressHelper;
import com.waem.hivePrototype.util.requestHelper.Request.file.UIProgressResponseListener;

import org.jetbrains.annotations.NotNull;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class DownloadRequestTesk extends RequestTesk {


    //todo : 안드로이드 워커를 사용 하는 방향으로 바꿀것


    private RequestBody requestBody;
    private UIProgressResponseListener uiProgressResponseListener;

    public DownloadRequestTesk(OkHttpClient okHttpClient, String url) {
        super(okHttpClient, url);
    }

    public AddDownloadCallback download(@NotNull UIProgressResponseListener uiProgressResponseListener){

        return new AddDownloadCallback(ProgressHelper.addProgressResponseListener(this.getOkHttpClient(), uiProgressResponseListener).newCall(new Request.Builder()
//                    .addHeader("x-api-key", RestTestCommon.API_KEY)
                .url(this.getUrl())
                .build()));

    }

}
