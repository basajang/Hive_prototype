package com.waem.hivePrototype;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatRoomActivity extends AppCompatActivity {

	@BindView(R.id.li_chatroom_back) LinearLayout liChatroomBack;
	@BindView(R.id.li_chatroom_menu) LinearLayout liChatroomMenu;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat_room);

		ButterKnife.bind(this);

		init();
		listener();

	}
	private void init(){

	}
	private void listener(){
		liChatroomBack.setOnClickListener(view -> {

			finish();

		});
		liChatroomMenu.setOnClickListener(view -> {

			Intent intent =new Intent(ChatRoomActivity.this,ChatRoomMenuActivity.class);
			startActivity(intent);

		});
	}
}
