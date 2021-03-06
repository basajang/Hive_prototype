package com.waem.hivePrototype.peopleList.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.peopleList.PopupFriendActivity;
import com.waem.hivePrototype.R;
import com.waem.hivePrototype.peopleList.vo.People;

import java.util.ArrayList;
/**
 * 친구 리사이클러뷰 어댑터
 * */
public class MainFriendAdapter extends RecyclerView.Adapter<MainFriendAdapter.FriendViewHolder>  {

	private ArrayList<People> friendList;
	private Context context=null;

	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder
	public static class FriendViewHolder extends RecyclerView.ViewHolder {
		// each data item is just a string in this case

		private TextView tvFriendName;

		public FriendViewHolder(View v) {

			super(v);
			tvFriendName = (TextView) v.findViewById(R.id.tv_friend_name);

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
		context=parent.getContext();
		return fvh;
	}

	/**
	 * position에 해당하는 데이터를 뷰 홀더의 아이템뷰에 표시
	 * */
	@Override
	public void onBindViewHolder(FriendViewHolder holder, int position) {
		// - get element from your dataset at this position
		// - replace the contents of the view with that element
		holder.tvFriendName.setText(friendList.get(position).getName());

		holder.tvFriendName.setOnClickListener(view -> {
			Intent intent =new Intent(context, PopupFriendActivity.class);
			intent.putExtra("friendName",friendList.get(position).getName());
			context.startActivity(intent);
		});

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
