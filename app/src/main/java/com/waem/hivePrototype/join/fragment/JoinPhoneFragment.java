package com.waem.hivePrototype.join.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.waem.hivePrototype.R;

/**
 * 회원가입 핸드폰 번호 인증 프래그먼트
 * */
public class JoinPhoneFragment extends Fragment {

	private View view;
	private Context context;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view =  inflater.inflate(R.layout.fragment_join_phone_authentication, container, false);

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
