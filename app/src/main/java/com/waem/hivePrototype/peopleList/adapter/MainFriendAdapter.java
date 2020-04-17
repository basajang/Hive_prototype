package com.waem.hivePrototype.peopleList.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.R;
import com.waem.hivePrototype.peopleList.vo.People;

import java.util.ArrayList;

public class MainFriendAdapter extends RecyclerView.Adapter<MainFriendAdapter.FriendViewHolder>  {
	private ArrayList<People> friendList;
	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder
	public static class FriendViewHolder extends RecyclerView.ViewHolder {
		// each data item is just a string in this case

		public TextView uname;

		public FriendViewHolder(View v) {

			super(v);
			uname = (TextView) v.findViewById(R.id.tv_friend_name);

		}
	}

	// Provide a suitable constructor (depends on the kind of dataset)
	public MainFriendAdapter(ArrayList<People> myDataset) {
		this.friendList = myDataset;
	}


	/**
	 * 이 메소드는 뷰 홀더가 콘텐츠를 표시하기 위해 사용하는 뷰를 설정해야합니다.
	 * */
	@Override
	public MainFriendAdapter.FriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// create a new view
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_friendlist_item, parent, false);

		FriendViewHolder fvh = new FriendViewHolder(v);
		return fvh;
	}


	/**
	 * position에 해당하는 데이터를 뷰 홀더의 아이템뷰에 표시
	 * */
	@Override
	public void onBindViewHolder(FriendViewHolder holder, int position) {
		// - get element from your dataset at this position
		// - replace the contents of the view with that element
		holder.uname.setText(friendList.get(position).getName());

	}

	// Return the size of your dataset (invoked by the layout manager)
	/**
	 * 전체아이템 갯수 리턴
	 * */
	@Override
	public int getItemCount() {
		return friendList.size();
	}
}
