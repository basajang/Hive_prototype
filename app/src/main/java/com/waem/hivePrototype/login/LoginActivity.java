package com.waem.hivePrototype.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.waem.hivePrototype.ConfigureManager;
import com.waem.hivePrototype.MainActivity;
import com.waem.hivePrototype.R;
import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;
import com.waem.hivePrototype.find.FindActivity;
import com.waem.hivePrototype.join.SignupActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 로그인 화면 액티비티
 * */

public class LoginActivity extends AppCompatActivity {

	@BindView(R.id.et_login_id) EditText etLoginId;
	@BindView(R.id.et_login_pw) EditText etLoginPw;

	@BindView(R.id.btn_login) Button btnLogin;
	@BindView(R.id.tv_login_signup) TextView tvLoginSignup;
	@BindView(R.id.tv_login_find) TextView tvLoginFind;
	@BindView(R.id.tv_login) TextView tvLogin;

	@BindView(R.id.login_pager) ViewPager login_pager;


	/**
	 * You shouldn't define first page = 0.
	 * Let define firstpage = 'number viewpager size' to make endless carousel
	 */

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		ButterKnife.bind(this);

        ConfigureManager.getInstance().setActivity(this);
		init();
		listener();

        CardFragmentPagerAdapter pagerAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(), dpToPixels(2, this));
        ShadowTransformer fragmentCardShadowTransformer = new ShadowTransformer(login_pager, pagerAdapter);
        fragmentCardShadowTransformer.enableScaling(true);

        login_pager.setAdapter(pagerAdapter);
        login_pager.setPageTransformer(false, fragmentCardShadowTransformer);
        login_pager.setOffscreenPageLimit(3);
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
//
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
	private void init(){

	/*	etLoginId=(EditText)findViewById(R.id.et_login_id);
		etLoginPw=(EditText)findViewById(R.id.et_login_pw);

		tvLoginSignup=(TextView) findViewById(R.id.tv_login_signup);

		btnLogin=(Button) findViewById(R.id.btn_login);*/

	}
	private void listener(){

		tvLoginSignup.setOnClickListener(view -> {
			Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
			startActivity(intent);
		});
		btnLogin.setOnClickListener(view -> {
			Intent intent = new Intent(LoginActivity.this, MainActivity.class);
			startActivity(intent);
		});
		tvLoginFind.setOnClickListener(view ->{
			Intent intent = new Intent(LoginActivity.this, FindActivity.class);
			startActivity(intent);
			finish();
		});
		tvLogin.setOnClickListener(view ->{
			Intent intent = new Intent(LoginActivity.this, MainActivity.class);
			startActivity(intent);
		} );

	}

	/**
	 * Change value in dp to pixels
	 * @param dp
	 * @param context
	 */
	public static float dpToPixels(int dp, Context context) {
		return dp * (context.getResources().getDisplayMetrics().density);
	}
}
