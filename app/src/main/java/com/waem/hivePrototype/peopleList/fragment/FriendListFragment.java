package com.waem.hivePrototype.peopleList.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waem.hivePrototype.R;
import com.waem.hivePrototype.peopleList.vo.People;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FriendListFragment extends Fragment {
	private ArrayList<People> friendArray =new ArrayList<>();
	private View view;
	private Date time = new Date();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view =  inflater.inflate(R.layout.fragment_friend_list, container, false);

		init();
		return view;
	}
	private void init(){
		People people1 =new People("qwer","김홍도","123","123","hi",false,false,time,false,false);

		friendArray.add(people1);
	}
}
