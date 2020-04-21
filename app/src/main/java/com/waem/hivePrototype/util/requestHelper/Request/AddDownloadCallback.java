package com.waem.hivePrototype.util.requestHelper.Request;

import okhttp3.Call;
import okhttp3.Callback;

public class AddDownloadCallback {

    private Call call;

    public AddDownloadCallback(Call call) {
        this.call = call;
    }

    //todo 추가 테스트 필요
    public void enqueue(Callback callback){
        if(null != callback){
            //비동기 처리 (enqueue 사용)
            call.enqueue(callback);
        }
    }
}
