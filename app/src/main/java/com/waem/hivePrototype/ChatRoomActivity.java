package com.waem.hivePrototype;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.chatRoomList.adapter.ChatRoomAdapter;
import com.waem.hivePrototype.chatRoomList.roomEnum.FileType;
import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;
import com.waem.hivePrototype.chatRoomList.vo.Message;
import com.waem.hivePrototype.peopleList.adapter.MainFriendAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

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

		Realm realm = Realm.getDefaultInstance();
		//ChatRoom chatRoom = realm.where(ChatRoom.class).equalTo("roomId", "0c91e078-f1f7-4b1a-af34-5e6893b85652").findFirst();
		ChatRoom chatRoom = realm.where(ChatRoom.class).findFirst();

		Log.d(Constants.TAG, "init: " + chatRoom);
		if(chatRoom != null ){

			Message message1 = new Message("1", chatRoom.getRoomId(),"전지민",true,fileType,"1","안녕하신가?","123",false,false,0);
			Message message2 = new Message("2", chatRoom.getRoomId(),"홍길동",true,fileType,"1","오! 그래 안녕하신가?","123",false,false,1);

			messages.add(message1);
			messages.add(message2);

		}

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
