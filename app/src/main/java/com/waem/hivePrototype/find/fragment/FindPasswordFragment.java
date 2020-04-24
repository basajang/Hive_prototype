package com.waem.hivePrototype.find.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.waem.hivePrototype.R;
import com.waem.hivePrototype.peopleList.adapter.MainFriendAdapter;
import com.waem.hivePrototype.peopleList.adapter.MainFriendFavoriteAdapter;

public class FindPasswordFragment extends Fragment {

	private View view;
	private EditText etFindPwEmail,etFindPwCode,etFindPwPassword;
	private Button btnFindPwEmail,btnFindPwCode;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view =  inflater.inflate(R.layout.fragment_find_password, container, false);

		init();
		listener();

		return view;
	}
	private void init(){
		etFindPwEmail=(EditText) view.findViewById(R.id.et_find_pw_email);
		etFindPwCode=(EditText) view.findViewById(R.id.et_find_pw_code);
		etFindPwPassword=(EditText) view.findViewById(R.id.et_find_pw_password);

		btnFindPwEmail=(Button) view.findViewById(R.id.btn_find_pw_email);
		btnFindPwCode=(Button) view.findViewById(R.id.btn_find_pw_code);

	}

	private void listener(){

	}
}
