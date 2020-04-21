package com.waem.hivePrototype;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

public class ChatRoomActivity extends AppCompatActivity {

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

	}
}
