package com.waem.hivePrototype.util.requestHelper.Request;

import android.util.Log;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetRequest {

    private OkHttpClient okHttpClient;
    private Request request;
    private String TAG = "HttpTask";

    public GetRequest(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    protected GetRequest setRequest(Request request) {
        this.request = request;
        return this;
    }

    //todo 디플리케이트 메소드  사용 하지 말것
    @Deprecated
    public void execute(){
        new Thread(){
            @Override
            public void run() {
                try(Response response = okHttpClient.newCall(request).execute()){
                    String message = response.body().string();
                    Log.d(TAG, "run: "+message);
                }catch (Exception e){
                    e.printStackTrace();

                }
                super.run();
            }
        }.start();

    }

    //todo 추가 테스트 필요
    public void enqueue(Callback callback){
        if(null != callback){
            //비동기 처리 (enqueue 사용)
            okHttpClient.newCall(request).enqueue(callback);
        }
    }
}
