package com.waem.hivePrototype.chatRoomList.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.MainActivity;
import com.waem.hivePrototype.R;
import com.waem.hivePrototype.chatRoomList.adapter.MainChatAdapter;
import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;
import com.waem.hivePrototype.chatRoomList.vo.Message;
import com.waem.hivePrototype.chatRoomList.vo.RoomFile;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;


/**
 * 채팅 리스트 프래그먼트
 * */
public class ChatListFragment extends Fragment {

	private View view;
	private RecyclerView rvMainChatList;
	private MainChatAdapter mainChatAdapter;
	private RecyclerView.LayoutManager chatLayoutManager;

	/*테스트용 변수*/
	private ArrayList<ChatRoom> chatRooms =new ArrayList<>();
	private RealmList<String> roomProfilePath = new RealmList<>();
	private RealmList<Message> messageList = new RealmList<>();
	private RealmList<RoomFile> fileList = new RealmList<>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		view= inflater.inflate(R.layout.fragment_chat_list, container, false);



		init();
		listener();

		return view;
	}
	private void init(){
		rvMainChatList=(RecyclerView)view.findViewById(R.id.rv_main_chat_list);

		chatLayoutManager = new LinearLayoutManager(getActivity());
		mainChatAdapter = new MainChatAdapter(chatRooms);
		rvMainChatList.setLayoutManager(chatLayoutManager);
		rvMainChatList.setAdapter(mainChatAdapter);




		ChatRoom chatRoom1= new ChatRoom("친구1",roomProfilePath,messageList,fileList,"qwe",false,false,false,false,false,1,1,1,false);

		ChatRoom chatRoom2= new ChatRoom("대학교 단체 톡",roomProfilePath,messageList,fileList,"qwe",false,false,false,false,false,1,1,1,false);

		ChatRoom chatRoom3= new ChatRoom("친구2",roomProfilePath,messageList,fileList,"qwe",false,false,false,false,false,1,1,1,false);

		ChatRoom chatRoom4= new ChatRoom("동아리 톡",roomProfilePath,messageList,fileList,"qwe",false,false,false,false,false,1,1,1,false);

		ChatRoom chatRoom5= new ChatRoom("친구3",roomProfilePath,messageList,fileList,"qwe",false,false,false,false,false,1,1,1,false);
//		ChatRoom chatRoom2= new ChatRoom("b","김홍도",roomProfilePath,messageList,fileList,"123",false,false,false,false,false,1,1,10,false);
//		ChatRoom chatRoom3= new ChatRoom("c","동아리 톡방",roomProfilePath,messageList,fileList,"123",false,false,false,false,false,1,1,10,false);
//		ChatRoom chatRoom4= new ChatRoom("d","봉사활동",roomProfilePath,messageList,fileList,"123",false,false,false,false,false,1,1,10,false);
//		ChatRoom chatRoom5= new ChatRoom("e","고등학교 친구들",roomProfilePath,messageList,fileList,"123",false,false,false,false,false,1,1,10,false);
//		ChatRoom chatRoom6= new ChatRoom("f","중학교 친구들",roomProfilePath,messageList,fileList,"123",false,false,false,false,false,1,1,10,false);
//		ChatRoom chatRoom7= new ChatRoom("g","동길홍",roomProfilePath,messageList,fileList,"123",false,false,false,false,false,1,1,10,false);
//		ChatRoom chatRoom8= new ChatRoom("h","대학교 단체 톡1",roomProfilePath,messageList,fileList,"123",false,false,false,false,false,1,1,10,false);
//		ChatRoom chatRoom9= new ChatRoom("i","대학교 단체 톡2",roomProfilePath,messageList,fileList,"123",false,false,false,false,false,1,1,10,false);
//		ChatRoom chatRoom10= new ChatRoom("j","대학교 단체 톡3",roomProfilePath,messageList,fileList,"123",false,false,false,false,false,1,1,10,false);
//
//
		chatRooms.add(chatRoom1);
		chatRooms.add(chatRoom2);
		chatRooms.add(chatRoom3);
		chatRooms.add(chatRoom4);
		chatRooms.add(chatRoom5);

//		chatRooms.add(chatRoom2);
//		chatRooms.add(chatRoom3);
//		chatRooms.add(chatRoom4);
//		chatRooms.add(chatRoom5);
//		chatRooms.add(chatRoom6);
//		chatRooms.add(chatRoom7);
//		chatRooms.add(chatRoom8);
//		chatRooms.add(chatRoom9);
//		chatRooms.add(chatRoom10);

	}
	private void listener(){

	}

}
