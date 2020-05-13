package com.waem.hivePrototype.join.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.waem.hivePrototype.R;

import butterknife.BindView;

/**
 * 회원가입 이메일 인증 프래그먼트
 * */
public class JoinEmailFragment extends Fragment {

	private View view;
	private Context context;
	public static EditText etJoinEmail,etJoinEmailCode;
	public static String joinEmail;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view =  inflater.inflate(R.layout.fragment_join_email_authentication, container, false);

		context= container.getContext();

		init();
		listener();

		return view;
	}
	private void init(){

		etJoinEmail = view.findViewById(R.id.et_join_email);
		etJoinEmailCode = view.findViewById(R.id.et_join_email_code);

	}
	public static String getJoinEmail(){
		return joinEmail = etJoinEmail.getText().toString();
	}

	private void listener(){

	}

}
