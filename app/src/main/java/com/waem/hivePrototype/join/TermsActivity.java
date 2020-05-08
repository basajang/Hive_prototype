package com.waem.hivePrototype.join;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.waem.hivePrototype.ConfigureManager;
import com.waem.hivePrototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TermsActivity extends AppCompatActivity {

	@BindView(R.id.btn_terms_agree) Button btnTermsAgree;

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

		btnTermsAgree.setOnClickListener(view ->{
			Intent intent =new Intent(TermsActivity.this,SignupActivity.class);
			startActivity(intent);
		} );

	}
}
