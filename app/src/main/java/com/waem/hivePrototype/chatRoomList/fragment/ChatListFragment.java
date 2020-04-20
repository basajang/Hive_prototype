package com.waem.hivePrototype.chatRoomList.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.R;
import com.waem.hivePrototype.chatRoomList.adapter.MainChatAdapter;
import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;
import com.waem.hivePrototype.chatRoomList.vo.Message;
import com.waem.hivePrototype.chatRoomList.vo.RoomFile;

import java.util.ArrayList;
import java.util.List;

public class ChatListFragment extends Fragment {
	private ArrayList<ChatRoom> chatRooms =new ArrayList<>();
	private View view;
	private RecyclerView rvMainChatList;
	private MainChatAdapter mainChatAdapter;
	private RecyclerView.LayoutManager chatLayoutManager;

	private List<String> roomProfilePath =new ArrayList<>();
	private List<Message> messageList =new ArrayList<>();
	private List<RoomFile> fileList =new ArrayList<>();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		view= inflater.inflate(R.layout.fragment_chat_list, container, false);

		init();
		listener();

		chatLayoutManager = new LinearLayoutManager(getActivity());
		mainChatAdapter = new MainChatAdapter(chatRooms);
		rvMainChatList.setLayoutManager(chatLayoutManager);
		rvMainChatList.setAdapter(mainChatAdapter);

		return view;
	}
	private void init(){
		rvMainChatList=(RecyclerView)view.findViewById(R.id.rv_main_chat_list);


		ChatRoom chatRoom1= new ChatRoom("a","와임 단체톡",roomProfilePath,messageList,fileList,"123",false,false,false,false,false,1,1,10,false);

		chatRooms.add(chatRoom1);
	}
	private void listener(){

	}

}
