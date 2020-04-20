package com.waem.hivePrototype.peopleList.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.R;
import com.waem.hivePrototype.peopleList.adapter.MainFriendAdapter;
import com.waem.hivePrototype.peopleList.adapter.MainFriendFavoriteAdapter;
import com.waem.hivePrototype.peopleList.vo.People;

import java.util.ArrayList;

public class FriendListFragment extends Fragment {
	private ArrayList<People> friendArray =new ArrayList<>();
	private ArrayList<People> friendFavoriteArray =new ArrayList<>();
	private View view;
	private RecyclerView.LayoutManager allLayoutManager,FavoriteLayoutManager;
	private MainFriendAdapter mainFriendAdapter;
	private MainFriendFavoriteAdapter mainFriendFavoriteAdapter;
	private RecyclerView rvMainFriendList,rvMainFriendFavoriteList;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view =  inflater.inflate(R.layout.fragment_friend_list, container, false);

		init();
		listener();

		/*친구목록 리사이클러뷰를 사용하기 위해 필요한 부분*/
		allLayoutManager = new LinearLayoutManager(getActivity());
		mainFriendAdapter = new MainFriendAdapter(friendArray);
		rvMainFriendList.setLayoutManager(allLayoutManager);
		rvMainFriendList.setAdapter(mainFriendAdapter);

		//rvMainFriendList.setHasFixedSize(true);
		//rvMainFriendFavoriteList.setHasFixedSize(true);
		/*친구목록 즐겨찾기 리사이클러뷰를 사용하기 위해 필요한 부분*/
		FavoriteLayoutManager = new LinearLayoutManager(getActivity());
		mainFriendFavoriteAdapter = new MainFriendFavoriteAdapter(friendFavoriteArray);
		rvMainFriendFavoriteList.setLayoutManager(FavoriteLayoutManager);
		rvMainFriendFavoriteList.setAdapter(mainFriendFavoriteAdapter);


		return view;
	}
	private void init(){
		rvMainFriendList =(RecyclerView) view.findViewById(R.id.rv_main_friend_list);
		rvMainFriendFavoriteList =(RecyclerView) view.findViewById(R.id.rv_main_friend_favorite_list);
		People people1 =new People();

		friendArray.add(people1);
	}
	private void listener(){

	}
}
