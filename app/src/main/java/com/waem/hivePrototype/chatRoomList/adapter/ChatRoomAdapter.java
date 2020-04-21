package com.waem.hivePrototype.chatRoomList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;

import java.util.ArrayList;

/**
 * 채팅방의 리사이클러뷰 어뎁터입니다.
 * */
public class ChatRoomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	private ArrayList<ChatRoom> chatRooms;

	public ChatRoomAdapter(ArrayList<ChatRoom> myDataset) {

		this.chatRooms = myDataset;

	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view;
		Context context = parent.getContext();
		LayoutInflater layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if(viewType == Code.View){

		}
		return null;

	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

	}

	@Override
	public int getItemCount() {
		return 0;
	}
}
