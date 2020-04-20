package com.waem.hivePrototype;


import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.google.android.material.tabs.TabLayout;
import com.waem.hivePrototype.peopleList.fragment.FriendListFragment;
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

    private TabLayout tabMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        NativeWrapper wrapper = new NativeWrapper();
        wrapper.nativeSum(10, 20);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FriendListFragment fragment = new FriendListFragment();
        fragmentTransaction.add(R.id.viewer, fragment);
        fragmentTransaction.commit();

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
        //new HttpTask().get(Constants.APIURL).execute();
     /*   new HttpTask().post("asdf").addParam("key", "val").Build().enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            }
        });*/
        //new HttpTask().post("http://www.google.co.kr/").addParam("key", "Value").addParam("key", "Value").Build().execute();
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
