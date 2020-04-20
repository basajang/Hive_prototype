package com.waem.hivePrototype.notification.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.waem.hivePrototype.R;
import com.waem.hivePrototype.chatRoomList.adapter.MainChatAdapter;

public class RestoreFragment extends Fragment {
	private View view;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		view= inflater.inflate(R.layout.fragment_restore, container, false);
		init();
		listener();


		return view;
	}
	private void init(){

	}
	private void listener(){

	}
}
