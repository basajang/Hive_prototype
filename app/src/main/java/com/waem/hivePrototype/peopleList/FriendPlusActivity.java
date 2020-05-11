package com.waem.hivePrototype.peopleList;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.waem.hivePrototype.ConfigureManager;
import com.waem.hivePrototype.R;

import butterknife.ButterKnife;

/**
 *친구추가 화면 클래스
 * */
public class FriendPlusActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_friend_plus);
		ConfigureManager.getInstance().setActivity(this);
		ButterKnife.bind(this);


	}

	private void init(){

	}
}
