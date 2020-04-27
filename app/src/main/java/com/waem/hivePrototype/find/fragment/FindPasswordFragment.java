package com.waem.hivePrototype.find.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.waem.hivePrototype.ConfigureManager;
import com.waem.hivePrototype.R;
import com.waem.hivePrototype.login.LoginActivity;
import com.waem.hivePrototype.peopleList.adapter.MainFriendAdapter;
import com.waem.hivePrototype.peopleList.adapter.MainFriendFavoriteAdapter;

public class FindPasswordFragment extends Fragment {

	private View view;
	private EditText etFindPwEmail,etFindPwCode,etFindPwPassword1,etFindPwPassword2;
	private Button btnFindPwEmail,btnFindPwCode,btnFindPw;
	private LinearLayout liFindPw;
	private TextView tvFindPw,tvFindPwText;


	private Context context;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view =  inflater.inflate(R.layout.fragment_find_password, container, false);

		context= container.getContext();

		init();
		listener();

		return view;
	}
	private void init(){

		etFindPwEmail=(EditText) view.findViewById(R.id.et_find_pw_email);
		etFindPwCode=(EditText) view.findViewById(R.id.et_find_pw_code);

		etFindPwPassword1=(EditText) view.findViewById(R.id.et_find_pw_password1);
		etFindPwPassword2=(EditText) view.findViewById(R.id.et_find_pw_password2);

		btnFindPwEmail=(Button) view.findViewById(R.id.btn_find_pw_email);
		btnFindPwCode=(Button) view.findViewById(R.id.btn_find_pw_code);
		btnFindPw= (Button) view.findViewById(R.id.btn_find_pw);
		liFindPw=(LinearLayout) view.findViewById(R.id.li_find_pw);

		tvFindPw = (TextView) view.findViewById(R.id.tv_find_pw);
		tvFindPwText = (TextView) view.findViewById(R.id.tv_find_pw_text);
	}

	private void listener(){
		btnFindPwEmail.setOnClickListener(view ->{
			if(etFindPwEmail.getText().toString().replace(" ", "").equals("")){
				Toast.makeText(context, "이메일을 입력하세요", Toast.LENGTH_SHORT).show();
			}
		} );
		btnFindPwCode.setOnClickListener(view ->{
			if(etFindPwEmail.getText().toString().replace(" ", "").equals("")){
				Toast.makeText(context, "이메일을 입력하세요", Toast.LENGTH_SHORT).show();
			}else if(etFindPwCode.getText().toString().replace(" ", "").equals("")){
				Toast.makeText(context, "인증 코드를 입력하세요.", Toast.LENGTH_SHORT).show();
			}else {
				liFindPw.setBackgroundColor(getResources().getColor(R.color.colorWhite));

				tvFindPw.setTextColor(getResources().getColor(R.color.colorBlack));
				tvFindPwText.setTextColor(getResources().getColor(R.color.colorBlack));

				etFindPwPassword1.setBackground(getResources().getDrawable(R.drawable.edit_border_line));
				etFindPwPassword2.setBackground(getResources().getDrawable(R.drawable.edit_border_line));

				etFindPwPassword1.setClickable(true);
				etFindPwPassword1.setFocusableInTouchMode(true);

				etFindPwPassword2.setClickable(true);
				etFindPwPassword2.setFocusableInTouchMode(true);
			}
		} );
		btnFindPw.setOnClickListener(view ->{
			if(etFindPwPassword1.getText().toString().replace(" ", "").equals("") || etFindPwPassword2.getText().toString().replace(" ", "").equals("")){
				Toast.makeText(context, "비밀번호를 입력하시오", Toast.LENGTH_SHORT).show();
			}else {
				Toast.makeText(context, "비밀번호가 변경되었습니다.", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(context, LoginActivity.class);
				startActivity(intent);
				ConfigureManager.getInstance().getActivity().finish();
				FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
				fragmentManager.beginTransaction().remove(FindPasswordFragment.this).commit();
				fragmentManager.popBackStack();
			}
		} );
	}
}
