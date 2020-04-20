package com.waem.hivePrototype;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PopupFriendActivity extends AppCompatActivity {
	private Button btnYes,btnNo;
	private LinearLayout liTransparent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_popup_friend);


		init();
		listener();
	}
	private void init(){
		btnNo=(Button)findViewById(R.id.btn_no);
		btnYes=(Button)findViewById(R.id.btn_yes);

		liTransparent=(LinearLayout)findViewById(R.id.li_transparent);
	}
	private void listener(){
		btnNo.setOnClickListener(v -> {
			this.finish();
		});
		btnYes.setOnClickListener(v -> {

		});
		liTransparent.setOnClickListener(v -> {
			this.finish();
		});
	}
}
