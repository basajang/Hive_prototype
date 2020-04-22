package com.waem.hivePrototype;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.chatRoomList.adapter.ChatRoomAdapter;
import com.waem.hivePrototype.chatRoomList.roomEnum.FileType;
import com.waem.hivePrototype.chatRoomList.vo.Message;
import com.waem.hivePrototype.peopleList.adapter.MainFriendAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatRoomActivity extends AppCompatActivity {

	@BindView(R.id.li_chatroom_back) LinearLayout liChatroomBack;
	@BindView(R.id.li_chatroom_menu) LinearLayout liChatroomMenu;

	private ArrayList<Message> messages =new ArrayList<>();
	private RecyclerView rvChatRoom;
	private RecyclerView.LayoutManager layoutManager;
	private ChatRoomAdapter chatRoomAdapter;

	private FileType fileType=null;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat_room);

		ButterKnife.bind(this);

		init();
		listener();

		layoutManager = new LinearLayoutManager(this);
		chatRoomAdapter = new ChatRoomAdapter(messages);
		rvChatRoom.setLayoutManager(layoutManager);
		rvChatRoom.setAdapter(chatRoomAdapter);

	}
	private void init(){
		rvChatRoom=(RecyclerView) findViewById(R.id.rv_chat_room);

        fileType = FileType.IMAGE;
		Message message1 = new Message("1","qwer",true,fileType,"1","안녕하신가?","123",false,false);
		Message message2 = new Message("2","q",true,fileType,"1","오! 그래 안녕하신가?","123",false,false);


		messages.add(message1);
		messages.add(message2);
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
