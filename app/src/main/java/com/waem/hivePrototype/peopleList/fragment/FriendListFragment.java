package com.waem.hivePrototype.peopleList.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.R;
import com.waem.hivePrototype.peopleList.adapter.MainFriendAdapter;
import com.waem.hivePrototype.peopleList.adapter.MainFriendFavoriteAdapter;
import com.waem.hivePrototype.peopleList.vo.People;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



/**
 * 친구 리스트 프래그먼트
 * */
public class FriendListFragment extends Fragment {

	private ArrayList<People> friendArray =new ArrayList<>();
	private ArrayList<People> friendFavoriteArray =new ArrayList<>();
	private View view;

	private RecyclerView.LayoutManager allLayoutManager,FavoriteLayoutManager;
	private MainFriendAdapter mainFriendAdapter;
	private MainFriendFavoriteAdapter mainFriendFavoriteAdapter;
	private RecyclerView rvMainFriendList,rvMainFriendFavoriteList;

	private Date time = new Date();

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

		People people1 =new People("qwer1","김홍도","123","123",false,time,false,false);
		People people2 =new People("qwer2","김아무개","123","123",false,time,false,false);
		People people3 =new People("qwer3","홍길동","123","123", false,time,false,false);
		People people4 =new People("qwer4","홍동길","123","123",false,time,false,false);
		People people5 =new People("qwer5","동길홍","123","123",false,time,false,false);
		People people6 =new People("qwer6","동길홍","123","123",false,time,false,false);
		People people7 =new People("qwer7","동길홍","123","123",false,time,false,false);
		People people8 =new People("qwer8","동길홍","123","123",false,time,false,false);
		People people9 =new People("qwer9","동길홍","123","123",false,time,false,false);
		People people10 =new People("qwer10","동길홍","123","123",false,time,false,false);

		friendArray.add(people1);
		friendArray.add(people2);
		friendArray.add(people3);
		friendArray.add(people4);
		friendArray.add(people5);
		friendArray.add(people6);
		friendArray.add(people7);
		friendArray.add(people8);
		friendArray.add(people9);
		friendArray.add(people10);

	}

	private void listener(){

	}
}
