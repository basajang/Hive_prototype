package com.waem.hivePrototype.chatRoomList;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.ConfigureManager;
import com.waem.hivePrototype.GlobalConst;
import com.waem.hivePrototype.R;
import com.waem.hivePrototype.util.dbmanager.RealmManager;
import com.waem.hivePrototype.chatRoomList.adapter.ChatRoomAdapter;
import com.waem.hivePrototype.chatRoomList.roomEnum.FileType;
import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;
import com.waem.hivePrototype.chatRoomList.vo.Message;

import java.util.ArrayList;

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

	private ArrayList<Message> messages =new ArrayList<>();
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

		layoutManager = new LinearLayoutManager(this);
		chatRoomAdapter = new ChatRoomAdapter(messages);
		rvChatRoom.setLayoutManager(layoutManager);
		rvChatRoom.setAdapter(chatRoomAdapter);

	}
	private void init(){
		rvChatRoom=(RecyclerView) findViewById(R.id.rv_chat_room);

        fileType = FileType.IMAGE;

		//ChatRoom chatRoom = realm.where(ChatRoom.class).equalTo("roomId", "0c91e078-f1f7-4b1a-af34-5e6893b85652").findFirst();

		/*렐름 매니저 사용예제*/
		Log.d(GlobalConst.TAG, "init: "+RealmManager.getInstance().getChatRoom().getChatRoomList());
		Log.d(GlobalConst.TAG, "init: "+RealmManager.getInstance().getChatRoom().getChatRoomList().size());

		ChatRoom chatRoom = RealmManager.getInstance().getChatRoom().getChatRoomList().get(0);

		Log.d(GlobalConst.TAG, "init: " + chatRoom.getRoomId());
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


			LinearLayout liChatroomMenu =findViewById(R.id.li_chatroom_menu);
			liChatroomMenu.setOnClickListener(v -> {
				DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
				if (!drawer.isDrawerOpen(Gravity.RIGHT)) {
					drawer.openDrawer(Gravity.RIGHT);
				}
			});
		});

	}
}
