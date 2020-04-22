package com.waem.hivePrototype;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.tabs.TabLayout;
import com.waem.hivePrototype.util.requestHelper.Request.HttpTask;
import com.waem.hivePrototype.util.requestHelper.Request.file.UIProgressRequestListener;
import com.waem.hivePrototype.util.requestHelper.Request.file.UIProgressResponseListener;
import com.waem.hivePrototype.peopleList.adapter.TabPagerAdapter;
import com.waem.hivePrototype.peopleList.fragment.FriendListFragment;

import com.waem.ndklib.NativeWrapper;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
/**
 * 메인 화면 액티비티
 * */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tab_main) TabLayout tabMain;
    @BindView(R.id.viewer) ViewPager viewPager;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private FriendListFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // ndk 샘플 실행
        NativeWrapper wrapper = new NativeWrapper();
        wrapper.nativeSum(10, 20);

       /* fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragment = new FriendListFragment();
        fragmentTransaction.add(R.id.viewer, fragment);
        fragmentTransaction.commit();*/


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


        init();
        listener();

    }
    private void init(){

      /*  viewPager =(ViewPager) findViewById(R.id.viewer);

        tabMain=(TabLayout) findViewById(R.id.tab_main);*/

        tabMain.addTab(tabMain.newTab().setText("친구"));
        tabMain.addTab(tabMain.newTab().setText("채팅"));
        tabMain.addTab(tabMain.newTab().setText("복원"));

    }
    private void listener(){

        /*텝 레이아웃 관련 코드*/
        TabPagerAdapter tabPagerAdapter =new TabPagerAdapter(getSupportFragmentManager(), tabMain.getTabCount());
        viewPager.setAdapter(tabPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabMain));
        tabMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

    }
}
