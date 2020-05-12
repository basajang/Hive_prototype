package com.waem.hivePrototype.chatRoomList.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.GlobalConst;
import com.waem.hivePrototype.chatRoomList.ChatRoomActivity;
import com.waem.hivePrototype.R;
import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;

import java.util.ArrayList;
import java.util.List;

/**
 * 채팅방리스트 리사이클러뷰 어댑터
 * */
public class MainChatAdapter extends RecyclerView.Adapter<MainChatAdapter.ChatViewHolder> {

	private List<ChatRoom> chatRooms = new ArrayList<>();
	private Context context=null;

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

		View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_chat_room_list_item,parent,false);
		ChatViewHolder cvh= new ChatViewHolder(view);
		context=parent.getContext();

		return cvh;
	}

	public MainChatAdapter(List<ChatRoom> myDataset) {
		this.chatRooms = myDataset;
	}

	@Override
	public void onBindViewHolder(@NonNull MainChatAdapter.ChatViewHolder holder, int position) {

		Log.d(GlobalConst.TAG, "onBindViewHolder: "+position);
		holder.tvChatName.setText(chatRooms.get(position).getRoomName());

		holder.tvChatName.setOnClickListener(view -> {
			Intent intent =new Intent(context, ChatRoomActivity.class);
			context.startActivity(intent);
		});
	}

	public void addChatroom(ChatRoom chatRoom){
		chatRooms.add(chatRoom);
		notifyDataSetChanged();
	}

	public void setItem(List<ChatRoom> chatRoomList){
		this.chatRooms= chatRoomList;
	}

	@Override
	public int getItemCount() {
		return chatRooms.size();
	}

}

