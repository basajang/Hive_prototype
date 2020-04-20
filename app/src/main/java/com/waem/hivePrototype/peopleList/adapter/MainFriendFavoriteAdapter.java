package com.waem.hivePrototype.peopleList.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.R;
import com.waem.hivePrototype.peopleList.vo.People;

import java.util.ArrayList;
/**
 *  친구 즐겨찾기 리사이클러뷰 어댑터
* */
public class MainFriendFavoriteAdapter extends RecyclerView.Adapter<MainFriendFavoriteAdapter.FriendFavoriteViewHolder> {

	private ArrayList<People> friendFavoriteList;

	public class FriendFavoriteViewHolder extends RecyclerView.ViewHolder {

		private TextView uname;

		public FriendFavoriteViewHolder(@NonNull View view) {

			super(view);
			uname = (TextView) view.findViewById(R.id.tv_friend_name);

		}
	}
	public MainFriendFavoriteAdapter(ArrayList<People> mydataset){

		this.friendFavoriteList = mydataset;

	}

	@NonNull
	@Override
	public MainFriendFavoriteAdapter.FriendFavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_friendlist_item, parent, false);
		FriendFavoriteViewHolder ffvh =new FriendFavoriteViewHolder(view);
		return ffvh;

	}

	@Override
	public void onBindViewHolder(@NonNull MainFriendFavoriteAdapter.FriendFavoriteViewHolder holder, int position) {

		holder.uname.setText(friendFavoriteList.get(position).getName());

	}

	@Override
	public int getItemCount() {
		return friendFavoriteList.size();
	}

}