package com.waem.hivePrototype;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.tabs.TabLayout;
import com.waem.hivePrototype.util.requestHelper.Request.HttpTask;
import com.waem.hivePrototype.util.requestHelper.Request.file.UIProgressRequestListener;
import com.waem.hivePrototype.util.requestHelper.Request.file.UIProgressResponseListener;
import com.waem.ndklib.NativeWrapper;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // ndk 샘플 실행
        NativeWrapper wrapper = new NativeWrapper();
        wrapper.nativeSum(10, 20);


//        Map<String, String> map = new HashMap<>();
//        map.put("key", "val");
//
//        new HttpTask().get("http://www.google.co.kr/").execute();
//        new HttpTask().get("http://www.google.co.kr/").enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                Log.d(TAG, "onFailure: ");
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                Log.d(TAG, "onResponse: "+response.body().string());
//            }
//        });
        Log.d(Constants.TAG, "onCreate: ");
        new HttpTask().get(Constants.APIURL).execute();

        // 파일 다운로드 샘플
        new HttpTask().fileDownload("http://www.google.co.kr/").download(new UIProgressResponseListener() {
            @Override
            public void onUIResponseProgress(long bytesRead, long contentLength, boolean done) {
                Log.d(Constants.TAG, "onUIResponseProgress: "+bytesRead);
            }
        }).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            }
        });

        init();
        listener();
    }
    private void init(){
        tabMain=(TabLayout) findViewById(R.id.tab_main);

        tabMain.addTab(tabMain.newTab().setText("친구"));

        tabMain.addTab(tabMain.newTab().setText("채팅"));

        tabMain.addTab(tabMain.newTab().setText("복원"));

    }
    private void listener(){

    }
}
