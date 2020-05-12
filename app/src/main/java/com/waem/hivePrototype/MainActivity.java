package com.waem.hivePrototype;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.tabs.TabLayout;
import com.waem.hivePrototype.chatRoomList.adapter.MainChatAdapter;
import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;
import com.waem.hivePrototype.peopleList.FriendPlusActivity;
import com.waem.hivePrototype.peopleList.adapter.TabPagerAdapter;
import com.waem.hivePrototype.peopleList.fragment.FriendListFragment;

import com.waem.hivePrototype.util.BackPressClose;
import com.waem.hivePrototype.util.FileUtil;
import com.waem.hivePrototype.util.requestHelper.BaseResult;
import com.waem.hivePrototype.util.requestHelper.Request.HttpTask;
import com.waem.ndklib.NativeWrapper;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.waem.hivePrototype.util.BackPressClose.backPressClose;


/**
 * 메인 화면 액티비티
 * */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tab_main) TabLayout tabMain;
    @BindView(R.id.viewer) ViewPager viewPager;
    @BindView(R.id.tv_main_title) TextView tvMainTitle;
    @BindView(R.id.iv_main_friend_plus_test) ImageView ivMainFriendPlusTest;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private FriendListFragment fragment;

    private TabPagerAdapter tabPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ConfigureManager.getInstance().setActivity(this);
        ButterKnife.bind(this);

        // ndk 샘플 실행
        NativeWrapper wrapper = new NativeWrapper();

        Log.d(GlobalConst.TAG, "onCreate: nativeSum "+wrapper.nativeSum(10, 20));
        Log.d(GlobalConst.TAG, "onCreate: nativeSub "+wrapper.nativeSub(30, 10));
       /* fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragment = new FriendListFragment();
        fragmentTransaction.add(R.id.viewer, fragment);
        fragmentTransaction.commit();*/



//        Map<String, String> map = new HashMap<>();
//        map.put("key", "val");
//
//        new HttpTask().get("http://www.google.co.kr/").execute();
        new HttpTask().get("http://www.google.co.kr/").enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(GlobalConst.TAG, "onFailure: ");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d(GlobalConst.TAG, "onResponse: "+response.body().string());

                BaseResult baseResult = new BaseResult();
                baseResult.getCode();
                baseResult.getMessages();
                ConfigureManager.getInstance().showToast(baseResult.getMessages(), Toast.LENGTH_LONG);

            }
        });
        Log.d(GlobalConst.TAG, "onCreate: ");

        init();
        listener();

        /*뒤로가기 두번 누르면 앱 종료 되는 함수*/
        backPressClose = new BackPressClose(this);

    }

    private void init(){

        tabMain.addTab(tabMain.newTab().setText("친구"));
        tabMain.addTab(tabMain.newTab().setText("채팅"));
        tabMain.addTab(tabMain.newTab().setText("복원"));

    }

    private void listener(){

        /*텝 레이아웃 관련 코드*/
        tabPagerAdapter =new TabPagerAdapter(getSupportFragmentManager(), tabMain.getTabCount());
        viewPager.setAdapter(tabPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabMain));
        tabMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()){

                    case 0:
                        tvMainTitle.setText("친구");
                        return;
                    case 1:
                        tvMainTitle.setText("채팅");
                        return;
                    case 2:
                        tvMainTitle.setText("복원알림");
                        return;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

        ivMainFriendPlusTest.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FriendPlusActivity.class);
            startActivity(intent);
        });

    }
    @Override
    public void onBackPressed() {
        /*super.onBackPressed();*/
        backPressClose.OnBackPressed();
    }
}
