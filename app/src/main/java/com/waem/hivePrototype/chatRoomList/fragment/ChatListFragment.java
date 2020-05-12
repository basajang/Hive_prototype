package com.waem.hivePrototype.chatRoomList.fragment;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.BuildConfig;
import com.waem.hivePrototype.GlobalConst;
import com.waem.hivePrototype.MainActivity;
import com.waem.hivePrototype.R;
import com.waem.hivePrototype.chatRoomList.adapter.MainChatAdapter;
import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;
import com.waem.hivePrototype.chatRoomList.vo.Message;
import com.waem.hivePrototype.chatRoomList.vo.RoomFile;
import com.waem.hivePrototype.util.dbmanager.RealmManager;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;


/**
 * 채팅방 리스트 프래그먼트 (채팅 리스트 아님)
 * */
public class ChatListFragment extends Fragment {

	private View view;
	private RecyclerView rvMainChatList;
	private MainChatAdapter mainChatAdapter;
	private RecyclerView.LayoutManager chatLayoutManager;

	/*테스트용 변수*/
	private List<ChatRoom> chatRoomList =new ArrayList<>();
	private RealmList<String> roomProfilePath = new RealmList<>();
	private RealmList<Message> messageList = new RealmList<>();
	private RealmList<RoomFile> fileList = new RealmList<>();
	private Button btnMainChatlistTestInsert,btnMainChatlistTestDelete;
	private LinearLayout liMainChatListTest;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		view= inflater.inflate(R.layout.fragment_chat_list, container, false);

		Log.i(GlobalConst.TAG, "onCreateView: ");
		init();
		listener();
		test();
		return view;
	}
	private void init(){

		btnMainChatlistTestInsert = (Button) view.findViewById(R.id.btn_main_chat_list_test_insert);
		btnMainChatlistTestDelete = (Button) view.findViewById(R.id.btn_main_chat_list_test_delete);
		liMainChatListTest = (LinearLayout) view.findViewById(R.id.li_main_chat_list_test);
		rvMainChatList = (RecyclerView)view.findViewById(R.id.rv_main_chat_list);

		chatLayoutManager = new LinearLayoutManager(getActivity());
		mainChatAdapter = new MainChatAdapter(chatRoomList);
		rvMainChatList.setLayoutManager(chatLayoutManager);
		rvMainChatList.setAdapter(mainChatAdapter);

		if(RealmManager.getInstance().getChatRoom().getChatRoomList().size() == 0){

			ChatRoom chatRoom1= new ChatRoom("친구1",roomProfilePath,messageList,fileList,"qwe",false,false,false,false,false,1,1,1,false);

			ChatRoom chatRoom2= new ChatRoom("대학교 단체 톡",roomProfilePath,messageList,fileList,"qwe",false,false,false,false,false,1,1,1,false);

			ChatRoom chatRoom3= new ChatRoom("친구2",roomProfilePath,messageList,fileList,"qwe",false,false,false,false,false,1,1,1,false);

			ChatRoom chatRoom4= new ChatRoom("동아리 톡",roomProfilePath,messageList,fileList,"qwe",false,false,false,false,false,1,1,1,false);

			ChatRoom chatRoom5= new ChatRoom("친구3",roomProfilePath,messageList,fileList,"qwe",false,false,false,false,false,1,1,1,false);

			RealmManager.getInstance().getChatRoom().insert(chatRoom1);
			RealmManager.getInstance().getChatRoom().insert(chatRoom2);
			RealmManager.getInstance().getChatRoom().insert(chatRoom3);
			RealmManager.getInstance().getChatRoom().insert(chatRoom4);
			RealmManager.getInstance().getChatRoom().insert(chatRoom5);

		}


	}

	private void listener(){

		btnMainChatlistTestInsert.setOnClickListener(v -> {
			ChatRoom chatRoom6= new ChatRoom("친구3",roomProfilePath,messageList,fileList,"qwe",false,false,false,false,false,1,1,1,false);
			RealmManager.getInstance().getChatRoom().insert(chatRoom6);
			mainChatAdapter.notifyDataSetChanged();
		});

		btnMainChatlistTestDelete.setOnClickListener(v -> {
			RealmManager.getInstance().getChatRoom().delete();
			mainChatAdapter.notifyDataSetChanged();
		});

		Log.d(GlobalConst.TAG, "채팅방: "+RealmManager.getInstance().getChatRoom().getChatRoomList());
		Log.d(GlobalConst.TAG, "채팅방: "+RealmManager.getInstance().getChatRoom().getChatRoomList().size());

		chatRoomList = RealmManager.getInstance().getChatRoom().getChatRoomList();

		for(ChatRoom chatRoom : chatRoomList){

			mainChatAdapter.addChatroom(chatRoom);

		}

		mainChatAdapter.setItem(chatRoomList);
	}

	public void test(){
		if(GlobalConst.DEVKEY.equals(BuildConfig.DEVKEY)){

			liMainChatListTest.setVisibility(View.VISIBLE);

		}
	}

}
