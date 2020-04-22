package com.waem.hivePrototype;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 친구목록에서 친구 누르면 뜨는 팝업 화면 액티비티
 * */
public class PopupFriendActivity extends AppCompatActivity {

	@BindView(R.id.btn_yes) Button btnYes;
	@BindView(R.id.btn_no) Button btnNo;
	@BindView(R.id.li_transparent) LinearLayout liTransparent;
	@BindView(R.id.tv_popup_friend_name) TextView tvPopupFriendName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_popup_friend);

		ButterKnife.bind(this);

		init();
		listener();

		Intent intent =getIntent();
		tvPopupFriendName.setText(intent.getStringExtra("friendName"));

	}

	private void init(){

	/*	btnNo=(Button)findViewById(R.id.btn_no);
		btnYes=(Button)findViewById(R.id.btn_yes);

		tvPopupFriendName=(TextView) findViewById(R.id.tv_popup_friend_name);

		liTransparent=(LinearLayout)findViewById(R.id.li_transparent);*/

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