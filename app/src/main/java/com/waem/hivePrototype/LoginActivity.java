package com.waem.hivePrototype;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.waem.hivePrototype.util.requestHelper.Request.HttpTask;
import com.waem.hivePrototype.util.requestHelper.Request.file.UIProgressResponseListener;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

	private EditText etLoginId,etLoginPw;
	private TextView tvLoginSignup;
	private Button btnLogin;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		init();
		listener();

		// 테스트 코드
//		LoginActivity.this.runOnUiThread(new Runnable() {
//			@Override
//			public void run() {
//				new HttpTask().fileDownload("https://www.google.co.kr/logos/doodles/2020/stay-home-save-lives-april-20-copy-6753651837108785-law.gif").download(new UIProgressResponseListener() {
//					@Override
//					public void onUIResponseProgress(long bytesRead, long contentLength, boolean done) {
//						Log.d(Constants.TAG, "onUIResponseProgress: "+bytesRead);
//					}
//				}).enqueue(new Callback() {
//					@Override
//					public void onFailure(@NotNull Call call, @NotNull IOException e) {
//						Log.d(Constants.TAG, "onFailure: "+call.request().body());
//						try {
//							Log.d(Constants.TAG, "onFailure: "+call.execute().body());
//
//						} catch (IOException ex) {
//							ex.printStackTrace();
//						}
//					}
//
//					@Override
//					public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//						Log.d(Constants.TAG, "onResponse: "+response.body());
//					}
//				});
//			}
//		});
		// 테스트 코드

	}
	private void init(){
		etLoginId=(EditText)findViewById(R.id.et_login_id);
		etLoginPw=(EditText)findViewById(R.id.et_login_pw);

		tvLoginSignup=(TextView) findViewById(R.id.tv_login_signup);

		btnLogin=(Button) findViewById(R.id.btn_login);

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
