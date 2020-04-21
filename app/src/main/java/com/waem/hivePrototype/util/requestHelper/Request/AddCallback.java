package com.waem.hivePrototype.util.requestHelper.Request;

import com.waem.hivePrototype.util.requestHelper.Request.file.ProgressHelper;

import okhttp3.Callback;
import okhttp3.Request;

public class AddCallback {

    private RequestTesk requestTesk;

    public AddCallback(RequestTesk requestTesk) {
        this.requestTesk = requestTesk;
    }


    public void upload(Callback callback){
        requestTesk.getOkHttpClient().newCall(new Request.Builder().url(requestTesk.getUrl())
                .post(ProgressHelper.addProgressRequestListener(requestTesk.getRequestBody(), requestTesk.getUiProgressRequestListener())).build())
        .enqueue(callback);
    }
}
