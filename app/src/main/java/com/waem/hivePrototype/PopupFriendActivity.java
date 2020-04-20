package com.waem.hivePrototype;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
/**
 * 친구목록에서 친구 누르면 뜨는 팝업 화면 액티비티
 * */
public class PopupFriendActivity extends AppCompatActivity {

	private Button btnYes,btnNo;
	private LinearLayout liTransparent;
	private TextView tvPopupFriendName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_popup_friend);

		init();
		listener();

		Intent intent =getIntent();
		tvPopupFriendName.setText(intent.getStringExtra("friendName"));

	}

	private void init(){

		btnNo=(Button)findViewById(R.id.btn_no);
		btnYes=(Button)findViewById(R.id.btn_yes);

		tvPopupFriendName=(TextView) findViewById(R.id.tv_popup_friend_name);

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
