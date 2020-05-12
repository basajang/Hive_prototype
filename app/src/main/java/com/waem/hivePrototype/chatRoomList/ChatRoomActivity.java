package com.waem.hivePrototype.chatRoomList;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.BuildConfig;
import com.waem.hivePrototype.ConfigureManager;
import com.waem.hivePrototype.GlobalConst;
import com.waem.hivePrototype.R;
import com.waem.hivePrototype.util.dbmanager.RealmManager;
import com.waem.hivePrototype.chatRoomList.adapter.ChatRoomAdapter;
import com.waem.hivePrototype.chatRoomList.roomEnum.FileType;
import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;
import com.waem.hivePrototype.chatRoomList.vo.Message;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import retrofit2.http.HEAD;

/**
 *채팅방 액티비티
 * */
public class ChatRoomActivity extends AppCompatActivity {

	@BindView(R.id.li_chatroom_back) LinearLayout liChatroomBack;
	@BindView(R.id.li_chatroom_menu) LinearLayout liChatroomMenu;
	@BindView(R.id.li_chat_room_test) LinearLayout liChatRoomTest;
	@BindView(R.id.btn_chat_room_user) Button btnChatRoomUser;
	@BindView(R.id.btn_chat_room_my) Button btnChatRoomMy;
	@BindView(R.id.et_chat_room_chatting) EditText etChatRoomChatting;
	@BindView(R.id.drawer_layout) DrawerLayout drawer;

	private List<Message> messages =new ArrayList<>();
	private RecyclerView rvChatRoom;
	private RecyclerView.LayoutManager layoutManager;
	private ChatRoomAdapter chatRoomAdapter;
	private Context context;
	private FileType fileType=null;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_chat_room_menu);
		ConfigureManager.getInstance().setActivity(this);
		/*버터나이프 호출*/
		ButterKnife.bind(this);

		init();
		listener();
		test();

	}
	private void init(){
		rvChatRoom=(RecyclerView) findViewById(R.id.rv_chat_room);

		layoutManager = new LinearLayoutManager(this);
		chatRoomAdapter = new ChatRoomAdapter(messages);
		rvChatRoom.setLayoutManager(layoutManager);
		rvChatRoom.setAdapter(chatRoomAdapter);

        fileType = FileType.IMAGE;

		//ChatRoom chatRoom = realm.where(ChatRoom.class).equalTo("roomId", "0c91e078-f1f7-4b1a-af34-5e6893b85652").findFirst();

		/*렐름 매니저 사용예제*/
		Log.d(GlobalConst.TAG, "init: "+RealmManager.getInstance().getChatRoom().getChatRoomList());
		Log.d(GlobalConst.TAG, "init: "+RealmManager.getInstance().getChatRoom().getChatRoomList().size());

		ChatRoom chatRoom = RealmManager.getInstance().getChatRoom().getChatRoomList().get(0);

		Log.d(GlobalConst.TAG, "init: " + chatRoom.getRoomId());

		if(chatRoom != null ){


		/*	Message message1 = new Message(chatRoom.getRoomId(),"전지민",true,fileType,"1","안녕하신가?","123",false,false,0);
			Message message2 = new Message(chatRoom.getRoomId(),"홍길동",true,fileType,"1","오! 그래 안녕하신가?","123",false,false,1);
			Message message3 = new Message(chatRoom.getRoomId(),"전지민",true,fileType,"1","오! 그래 안녕하신가?","123",false,false,1);
			Message message4 = new Message(chatRoom.getRoomId(),"전지민",true,fileType,"1","오! 그래 안녕하신가?","123",false,false,0);
			Message message5 = new Message(chatRoom.getRoomId(),"홍길동",true,fileType,"1","오! 그래 안녕하신가?","123",false,false,1);
			Message message6 = new Message(chatRoom.getRoomId(),"전지민",true,fileType,"1","오! 그래 안녕하신가?","123",false,false,0);
			Message message7 = new Message(chatRoom.getRoomId(),"홍길동",true,fileType,"1","오! 그래 안녕하신가?","123",false,false,0);
			Message message8 = new Message(chatRoom.getRoomId(),"홍길동",true,fileType,"1","오! 그래 안녕하신가?","123",false,false,1);
			Message message9 = new Message(chatRoom.getRoomId(),"홍길동",true,fileType,"1","오! 그래 안녕하신가?","123",false,false,1);

			RealmManager.getInstance().getMessage().userInsert(message1);
			RealmManager.getInstance().getMessage().userInsert(message2);
			RealmManager.getInstance().getMessage().userInsert(message3);
			RealmManager.getInstance().getMessage().userInsert(message4);
			RealmManager.getInstance().getMessage().userInsert(message5);
			RealmManager.getInstance().getMessage().userInsert(message6);
			RealmManager.getInstance().getMessage().userInsert(message7);
			RealmManager.getInstance().getMessage().userInsert(message8);
			RealmManager.getInstance().getMessage().userInsert(message9);*/

		}

	}
	private void listener(){

		liChatroomBack.setOnClickListener(view -> {

			finish();

		});
		btnChatRoomUser.setOnClickListener(v -> {

			String chat = etChatRoomChatting.getText().toString();
			ChatRoom chatRoom = RealmManager.getInstance().getChatRoom().getChatRoomList().get(0);

			if(chatRoom != null ){
				Message message = new Message(chatRoom.getRoomId(),"홍길동",true,fileType,"1",chat,"123",false,false,1);
				RealmManager.getInstance().getMessage().userInsert(message);
				chatRoomAdapter.notifyDataSetChanged();

				Log.d(GlobalConst.TAG,"입력한 text : "+chat);
			}

		});
		btnChatRoomMy.setOnClickListener(v -> {

			String chat =etChatRoomChatting.getText().toString();
			/*첫번째 방을 가져옴*/
			ChatRoom chatRoom = RealmManager.getInstance().getChatRoom().getChatRoomList().get(0);

			if(chatRoom != null){
				/*여기까지 했음*/
				Message message = new Message(chatRoom.getRoomId(),"전지민",true,fileType,"1",chat,"123",false,false,0);
				RealmManager.getInstance().getMessage().userInsert(message);
				chatRoomAdapter.notifyDataSetChanged();

				Log.d(GlobalConst.TAG,"내가 입력한 text : "+chat);
			}
		});

		/*roomid를 가져와야 할듯*/
		messages = RealmManager.getInstance().getMessage().getMessageList();

		for (Message message : messages){
			chatRoomAdapter.addMessage(message);
		}

		chatRoomAdapter.setItem(messages);


		liChatroomMenu.setOnClickListener(v -> {
				if(!drawer.isDrawerOpen(Gravity.RIGHT)) {
					drawer.openDrawer(Gravity.RIGHT);
				}
		});

	}
	private void test(){
		if(GlobalConst.DEVKEY.equals(BuildConfig.DEVKEY)){
			liChatRoomTest.setVisibility(View.VISIBLE);
		}

	}
}
