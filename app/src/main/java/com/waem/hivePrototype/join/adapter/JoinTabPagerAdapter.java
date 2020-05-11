package com.waem.hivePrototype.join.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.waem.hivePrototype.find.fragment.FindIdFragment;
import com.waem.hivePrototype.find.fragment.FindPasswordFragment;
import com.waem.hivePrototype.join.fragment.JoinEmailFragment;
import com.waem.hivePrototype.join.fragment.JoinPhoneFragment;

/**
 * 회원가입 인증 부분 탭페이저 어뎁터
 * */
public class JoinTabPagerAdapter extends FragmentStatePagerAdapter {

	private int tabCount;

	public JoinTabPagerAdapter(@NonNull FragmentManager fm, int tabCount) {
		super(fm);
		this.tabCount = tabCount;
	}

	/**
	 * 특정 탭을 누르면 그에 맞는 프래그먼트로 이동
	 * */
	@NonNull
	@Override
	public Fragment getItem(int position) {

		switch (position){
			case 0:
				JoinEmailFragment joinEmailFragment =new JoinEmailFragment();
				return joinEmailFragment;
			case 1:
				JoinPhoneFragment joinPhoneFragment =new JoinPhoneFragment();
				return joinPhoneFragment;
			default:
				return null;
		}

	}

	@Override
	public int getCount() {
		return tabCount;
	}
}
