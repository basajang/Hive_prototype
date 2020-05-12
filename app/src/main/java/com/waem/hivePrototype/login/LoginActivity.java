package com.waem.hivePrototype.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.waem.hivePrototype.ConfigureManager;
import com.waem.hivePrototype.GlobalConst;
import com.waem.hivePrototype.MainActivity;
import com.waem.hivePrototype.R;
import com.waem.hivePrototype.find.FindActivity;

import com.waem.hivePrototype.join.TermsActivity;
import com.waem.hivePrototype.login.adapter.CardFragmentPagerAdapter;
import com.waem.hivePrototype.login.fragment.BasicLogin;
import com.waem.hivePrototype.login.fragment.Biometric;
import com.waem.hivePrototype.login.fragment.LiveCERT;
import com.waem.hivePrototype.login.fragment.SNSLogin;
import com.waem.hivePrototype.ui.CustomDialog;
import com.waem.hivePrototype.util.BackPressClose;
import com.waem.ndklib.NativeWrapper;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.waem.hivePrototype.util.BackPressClose.backPressClose;

/**
 * 로그인 화면 액티비티
 */

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_login_id)
    EditText etLoginId;
    @BindView(R.id.et_login_pw)
    EditText etLoginPw;

    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_login_signup)
    TextView tvLoginSignup;
    @BindView(R.id.tv_login_find)
    TextView tvLoginFind;

    @BindView(R.id.vp_login)
    ViewPager vpLogin;

    public final static int PAGES = 4;
    // You can choose a bigger number for LOOPS, but you know, nobody will fling
    // more than 1000 times just in order to test your "infinite" ViewPager :D
    public final static int LOOPS = 2;
    public final static int FIRST_PAGE = PAGES * LOOPS / 2;

    /**
     * You shouldn't define first page = 0.
     * Let define firstpage = 'number viewpager size' to make endless carousel
     */

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        ConfigureManager.getInstance().setActivity(this);


        listener();

        /*뒤로가기 두번 누르면 앱종료*/
        backPressClose = new BackPressClose(this);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Biometric());
        fragments.add(new BasicLogin());
        fragments.add(new LiveCERT());
        fragments.add(new SNSLogin());
        CardFragmentPagerAdapter pagerAdapter = new CardFragmentPagerAdapter(this,
                this.getSupportFragmentManager(), fragments);

//		pagerAdapter.addFragment(new MyFragment());
//		pagerAdapter.addFragment(new MyFragment());
//		pagerAdapter.addFragment(new MyFragment());
//		pagerAdapter.addFragment(new MyFragment());
//        ShadowTransformer fragmentCardShadowTransformer = new ShadowTransformer(login_pager, pagerAdapter);
//        fragmentCardShadowTransformer.enableScaling(true);

        vpLogin.setAdapter(pagerAdapter);
//        login_pager.setPageTransformer(false, fragmentCardShadowTransformer);
//        login_pager.setOffscreenPageLimit(3);

        vpLogin.setPageMargin(100);
        vpLogin.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                int pageWidth = vpLogin.getMeasuredWidth() -
                        vpLogin.getPaddingLeft() - vpLogin.getPaddingRight();
                int pageHeight = vpLogin.getHeight();
                int paddingLeft = vpLogin.getPaddingLeft();
                float transformPos = (float) (page.getLeft() -
                        (vpLogin.getScrollX() + paddingLeft)) / pageWidth;
                int max = pageHeight / 10;
                if (transformPos < -1) {
                    // [-Infinity,-1)
                    // This page is way off-screen to the left.
//					page.setAlpha(0.5f);// to make left transparent
                    page.setScaleY(0.7f);
                } else if (transformPos <= 1) {
                    // [-1,1]
                    page.setScaleY(1f);
                } else {
                    // (1,+Infinity]
                    // This page is way off-screen to the right.
//					page.setAlpha(0.5f);// to make right transparent
                    page.setScaleY(0.7f);
                }
            }
        });
        vpLogin.setCurrentItem(1);
        Log.d(GlobalConst.TAG, "onCreate: " + vpLogin.getAdapter().getCount());

        CustomDialog customDialog = new CustomDialog(this).setMessage("dkdkdk")
                .setNegativeBtnText("아니요").setPositiveBtnText("ㅁ").setDefaultTime(3)
                .setOnDialogListener(new CustomDialog.DialogListener() {
                    @Override
                    public void onPositiveClick() {

                    }

                    @Override
                    public void onNegativeClick() {

                    }
                });
        customDialog.show();

        // ndk 샘플 실행
        NativeWrapper wrapper = new NativeWrapper();

        Log.d(GlobalConst.TAG, "onCreate: nativeSum " + wrapper.nativeSum(10, 20));
        Log.d(GlobalConst.TAG, "onCreate: nativeSub " + wrapper.nativeSub(30, 10));

       /* fragmentManager = getSupportFragmentManager();
        // 테스트 코드

//		Realm realm = Realm.getDefaultInstance();
//
//		if(realm.where(ChatRoom.class).count() == 0){
//			realm.executeTransaction(new Realm.Transaction() {
//				@Override
//				public void execute(Realm realm) {
//					ChatRoom chatRoom = new ChatRoom();
//					chatRoom.getRoomId();
//					chatRoom.setRoomName("썩어질");
//					realm.copyToRealmOrUpdate(chatRoom);
//				}
//			});
//		}
//		List<ChatRoom> chatRooms =  realm.where(ChatRoom.class).findAll();
//		for(ChatRoom room : chatRooms){
//			Log.d(Constants.TAG, "onCreate: room "+room);
//		}
//
//        new HttpTask().fileDownload("https://www.google.co.kr/logos/doodles/2020/stay-home-save-lives-april-20-copy-6753651837108785-law.gif")
//				.download(new UIProgressResponseListener() {
//            @Override
//            public void onUIResponseProgress(long bytesRead, long contentLength, boolean done) {
//                Log.d(Constants.TAG, "onUIResponseProgress: " + bytesRead);
//            }
//        }).enqueue(new CallbackToDownloadFile(ConfigureManager.getInstance().getImageDir(chatRooms.get(chatRooms.size()-1)), "stay-home-save-lives-april-20-copy-6753651837108785-law.gif") );

        // 테스트 코드

    }

    }
    private void init() {

	    etLoginId=(EditText)findViewById(R.id.et_login_id);
		etLoginPw=(EditText)findViewById(R.id.et_login_pw);

		tvLoginSignup=(TextView) findViewById(R.id.tv_login_signup);

		btnLogin=(Button) findViewById(R.id.btn_login);
		}
		*/

    }
    private void listener() {

        tvLoginSignup.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, TermsActivity.class);
            startActivity(intent);
        });

        btnLogin.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        });

        tvLoginFind.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, FindActivity.class);
            startActivity(intent);

        });

    }

    /**
     * Change value in dp to pixels
     *
     * @param dp
     * @param context
     */
    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }
    @Override
    public void onBackPressed() {
        /*super.onBackPressed();*/
        backPressClose.OnBackPressed();
    }
}
