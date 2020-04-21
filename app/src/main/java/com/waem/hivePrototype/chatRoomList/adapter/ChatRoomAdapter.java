package com.waem.hivePrototype.chatRoomList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.R;
import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;
import com.waem.hivePrototype.chatRoomList.vo.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * 채팅방의 리사이클러뷰 어뎁터입니다.
 * */
public class ChatRoomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	private ArrayList<ChatRoom> chatRooms;
	private ArrayList<Message> messages;

	public ChatRoomAdapter(ArrayList<Message> messages) {

		this.messages= messages;

	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

		View view;
		Context context = parent.getContext();
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if(true){

			view = inflater.inflate(R.layout.recyclerview_my_chatting_item,parent,false);
			return new MyViewHolder(view);

		}else if(true){

			view = inflater.inflate(R.layout.recyclerview_user_chatting_item,parent,false);
			return new UserViewHolder(view);

		}

		return null;
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

		if(holder instanceof MyViewHolder){

			((MyViewHolder) holder).tvMyChatting.setText(messages.get(position).getText());

		}else if(holder instanceof UserViewHolder){

			((UserViewHolder) holder).tvUserName.setText(messages.get(position).getSenderId());
			((UserViewHolder) holder).tvUserSetting.setText(messages.get(position).getText());

		}

	}

	@Override
	public int getItemCount() {

		return messages.size();

	}

	public class MyViewHolder extends RecyclerView.ViewHolder{

		TextView tvMyChatting;

		public MyViewHolder(@NonNull View itemView) {

			super(itemView);
			tvMyChatting =(TextView) itemView.findViewById(R.id.tv_my_chatting);

		}

	}

	public class UserViewHolder extends RecyclerView.ViewHolder{

		TextView tvUserName,tvUserSetting;

		public UserViewHolder(@NonNull View itemView) {

			super(itemView);
			tvUserName=(TextView)itemView.findViewById(R.id.tv_user_name);
			tvUserSetting=(TextView)itemView.findViewById(R.id.tv_user_chatting);

		}

	}
}
