package com.waem.hivePrototype;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
/**
 * 로그인 화면 액티비티
 * */
public class LoginActivity extends AppCompatActivity {

	private EditText etLoginId,etLoginPw;
	private TextView tvLoginSignup;
	private Button btnLogin;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		init();
		listener();

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
