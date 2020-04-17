package com.waem.hivePrototype;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.waem.hivePrototype.util.requestHelper.HttpTask;
import com.waem.ndklib.NativeWrapper;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @BindView(R2.id.test)
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        NativeWrapper wrapper = new NativeWrapper();
        wrapper.nativeSum(10, 20);
        test.setText(wrapper.nativeSum(10, 20)+"");
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
//
//        new HttpTask().get("asdf").execute();
//        new HttpTask().post("asdf").addParam("key", "val").Build().enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//
//            }
//        });
//        new HttpTask().post("http://www.google.co.kr/").addParam("key", "Value").addParam("key", "Value").Build().execute();


    }
}
