package com.waem.hivePrototype.chatRoomList;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.waem.hivePrototype.ConfigureManager;
import com.waem.hivePrototype.R;

import org.jetbrains.annotations.Nullable;
/**
 * 채팅방 메뉴 액티비티
 * */
public class ChatRoomMenuActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_chat_room_menu);
		ConfigureManager.getInstance().setActivity(this);

		init();
		listener();
	}
	private void init(){

	}
	private void listener(){

	}

}
