package com.waem.hivePrototype;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;
import com.waem.hivePrototype.chatRoomList.vo.Message;
import com.waem.hivePrototype.util.requestHelper.Request.CallbackToDownloadFile;
import com.waem.hivePrototype.util.requestHelper.Request.HttpTask;
import com.waem.hivePrototype.util.requestHelper.Request.file.UIProgressResponseListener;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * 로그인 화면 액티비티
 * */

public class LoginActivity extends AppCompatActivity {

	@BindView(R.id.et_login_id) EditText etLoginId;
	@BindView(R.id.et_login_pw) EditText etLoginPw;

	@BindView(R.id.btn_login) Button btnLogin;
	@BindView(R.id.tv_login_signup) TextView tvLoginSignup;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		ButterKnife.bind(this);

        ConfigureManager.getInstance().setActivity(this);
		init();
		listener();

		// 테스트 코드
		Realm.init(this);
		RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().schemaVersion(1).build();
		Realm realm = Realm.getDefaultInstance();



		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				ChatRoom chatRoom = new ChatRoom();
				chatRoom.getRoomId();
				chatRoom.setRoomName("썩어질");
				realm.copyToRealmOrUpdate(chatRoom);
			}
		});

		List<ChatRoom> chatRooms =  realm.where(ChatRoom.class).findAll();
		for(ChatRoom room : chatRooms){
			Log.d(Constants.TAG, "onCreate: room"+room);
		}



        new HttpTask().fileDownload("https://www.google.co.kr/logos/doodles/2020/stay-home-save-lives-april-20-copy-6753651837108785-law.gif")
				.download(new UIProgressResponseListener() {
            @Override
            public void onUIResponseProgress(long bytesRead, long contentLength, boolean done) {
                Log.d(Constants.TAG, "onUIResponseProgress: " + bytesRead);
            }
        }).enqueue(new CallbackToDownloadFile(ConfigureManager.getInstance().getImageDir(chatRooms.get(chatRooms.size()-1)), "stay-home-save-lives-april-20-copy-6753651837108785-law.gif") );

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
			Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
			startActivity(intent);
		});
		btnLogin.setOnClickListener(view -> {
			Intent intent = new Intent(LoginActivity.this,MainActivity.class);
			startActivity(intent);
		});

	}
}
