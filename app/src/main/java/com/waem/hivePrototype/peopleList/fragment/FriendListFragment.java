package com.waem.hivePrototype.peopleList.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waem.hivePrototype.R;
import com.waem.hivePrototype.peopleList.vo.People;

import java.util.ArrayList;

public class FriendListFragment extends Fragment {
	private ArrayList<People> friendArray =new ArrayList<>();
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view =  inflater.inflate(R.layout.fragment_friend_list, container, false);

		init();
		return view;
	}
	private void init(){
		People people1 =new People();

		friendArray.add(people1);
	}
}
