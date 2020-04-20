package com.waem.hivePrototype.chatRoomList.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.R;
import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;
import com.waem.hivePrototype.peopleList.vo.People;

import java.util.ArrayList;

public class MainChatAdapter extends RecyclerView.Adapter<MainChatAdapter.ChatViewHolder> {
	private ArrayList<ChatRoom> chatRooms;

	public static class ChatViewHolder extends RecyclerView.ViewHolder {
		// each data item is just a string in this case
		private TextView tvChatName;
		public ChatViewHolder(@NonNull View itemView) {

			super(itemView);
			tvChatName = (TextView) itemView.findViewById(R.id.tv_chat_name);

		}
	}
	@NonNull
	@Override
	public MainChatAdapter.ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_chatlist_item,parent,false);
		ChatViewHolder cvh= new ChatViewHolder(view);
		return cvh;
	}

	public MainChatAdapter(ArrayList<ChatRoom> myDataset) {

		this.chatRooms = myDataset;
	}

	@Override
	public void onBindViewHolder(@NonNull MainChatAdapter.ChatViewHolder holder, int position) {

		holder.tvChatName.setText(chatRooms.get(position).getRoomName());

	}

	@Override
	public int getItemCount() {

		return chatRooms.size();

	}


}
