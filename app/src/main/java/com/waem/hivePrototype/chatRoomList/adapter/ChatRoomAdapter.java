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
	private Context context;
	public static final int VIEW_TYPE_A = 0;
	public static final int VIEW_TYPE_B = 1;

	public ChatRoomAdapter(ArrayList<Message> messages) {

		this.messages = messages;

	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

		View view;
		Context context = parent.getContext();
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		//senderId가 (People)사용자 아이디랑 같으면 자기 메세지

		if(viewType==VIEW_TYPE_A){

			//	자기 메시지 item
			view = inflater.inflate(R.layout.recyclerview_my_chatting_item,parent,false);
			return new MyViewHolder(view);

		}else if(viewType==VIEW_TYPE_B){

			//	다른 유저 메시지 item
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
	public int getItemViewType(int position) {
		if(messages.get(position).getItemViewType()==0){
			return VIEW_TYPE_A;
		}else {
			return VIEW_TYPE_B;
		}

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

	@Override
	public int getItemCount() {

		return messages.size();

	}
}
