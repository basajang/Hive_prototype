package com.waem.hivePrototype.join;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.waem.hivePrototype.ConfigureManager;
import com.waem.hivePrototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 약관동의 화면 액티비티
 * */
public class TermsActivity extends AppCompatActivity {

	@BindView(R.id.btn_terms_agree) Button btnTermsAgree;
	@BindView(R.id.btn_terms_cancel) Button btnTermsCancel;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_terms);
		ConfigureManager.getInstance().setActivity(this);

		ButterKnife.bind(this);

		init();
		listener();

	}
	private void init(){

	}
	private void listener(){

		btnTermsAgree.setOnClickListener(v ->{
			Intent intent = new Intent(TermsActivity.this,SignupActivity.class);
			startActivity(intent);
		} );

		btnTermsCancel.setOnClickListener(v -> {
			finish();
		});
	}
}
