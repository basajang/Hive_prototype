package com.waem.hivePrototype.join.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.waem.hivePrototype.R;

public class JoinEmailFragment extends Fragment {

	private View view;
	private Context context;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view =  inflater.inflate(R.layout.fragment_join_email_authentication, container, false);

		context= container.getContext();

		init();
		listener();

		return view;
	}
	private void init(){

	}
	private void listener(){

	}

}
