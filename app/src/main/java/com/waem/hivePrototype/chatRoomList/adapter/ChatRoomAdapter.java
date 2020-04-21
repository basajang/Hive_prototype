package com.waem.hivePrototype.chatRoomList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

	public ChatRoomAdapter(ArrayList<ChatRoom> myDataset, ArrayList<Message> messages) {

		this.chatRooms = myDataset;
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

		}else if(false){

			view = inflater.inflate(R.layout.recyclerview_user_chatting_item,parent,false);
			return new UserViewHolder(view);

		}

		return null;
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

		if(holder instanceof MyViewHolder){

			//((MyViewHolder) holder).messageList.set();

		}else if(holder instanceof UserViewHolder){

		/*	((UserViewHolder) holder).senderId.setText(myDataList.get(position).getName());
			((UserViewHolder) holder).content.setText(myDataList.get(position).getContent());*/

		}

	}

	@Override
	public int getItemCount() {

		return chatRooms.size();

	}

	public class MyViewHolder extends RecyclerView.ViewHolder{

		private List<Message> messageList ;

		public MyViewHolder(@NonNull View itemView) {

			super(itemView);
			messageList = itemView.findViewById(R.id.tv_my_chatting);

		}

	}

	public class UserViewHolder extends RecyclerView.ViewHolder{

		public UserViewHolder(@NonNull View itemView) {
			super(itemView);
		}

	}
}
