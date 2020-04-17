package com.waem.hivePrototype;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

	private Button btnSignup;
	private EditText etSignupId,etSignupPw,etSignupName;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);

		init();
		listener();
	}
	private void init(){
		etSignupId=(EditText)findViewById(R.id.et_signup_id);
		etSignupPw=(EditText)findViewById(R.id.et_signup_pw);
		etSignupName=(EditText)findViewById(R.id.et_signup_name);
		btnSignup=(Button)findViewById(R.id.btn_signup);

	}
	private void listener(){
		btnSignup.setOnClickListener(view -> {
			Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
			startActivity(intent);
		});
	}
}
