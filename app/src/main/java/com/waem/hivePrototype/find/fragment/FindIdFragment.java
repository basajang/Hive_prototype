package com.waem.hivePrototype.find.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.waem.hivePrototype.R;
import com.waem.hivePrototype.peopleList.adapter.MainFriendAdapter;
import com.waem.hivePrototype.peopleList.adapter.MainFriendFavoriteAdapter;

public class FindIdFragment extends Fragment {

	private View view;
	private EditText etFindIdName;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view =  inflater.inflate(R.layout.fragment_find_id, container, false);

		init();
		listener();

		return view;
	}
	private void init(){
		etFindIdName=(EditText) view.findViewById(R.id.et_find_id_name);
	}

	private void listener(){

	}
}
