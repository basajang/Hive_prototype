package com.waem.hivePrototype.join;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.waem.hivePrototype.login.LoginActivity;
import com.waem.hivePrototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 회원가입 화면 액티비티
 * */
public class SignupActivity extends AppCompatActivity {

	@BindView(R.id.btn_signup) Button btnSignup;

	@BindView(R.id.et_signup_id) EditText etSignupId;
	@BindView(R.id.et_signup_pw) EditText etSignupPw;
	@BindView(R.id.et_signup_name) EditText etSignupName;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);

		ButterKnife.bind(this);

		init();
		listener();

	}

	private void init(){

		/*etSignupId=(EditText)findViewById(R.id.et_signup_id);
		etSignupPw=(EditText)findViewById(R.id.et_signup_pw);
		etSignupName=(EditText)findViewById(R.id.et_signup_name);

		btnSignup=(Button)findViewById(R.id.btn_signup);*/

	}

	private void listener(){

		btnSignup.setOnClickListener(view -> {
			Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
			startActivity(intent);
		});

	}
}
