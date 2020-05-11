package com.waem.hivePrototype.find.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.waem.hivePrototype.chatRoomList.fragment.ChatListFragment;
import com.waem.hivePrototype.find.fragment.FindIdFragment;
import com.waem.hivePrototype.find.fragment.FindPasswordFragment;
import com.waem.hivePrototype.notification.fragment.RestoreFragment;
import com.waem.hivePrototype.peopleList.fragment.FriendListFragment;

/**
 * id/password 탭 레이아웃 어댑터
 * */
public class FindTabPagerAdapter extends FragmentStatePagerAdapter {

	private int tabCount;

	public FindTabPagerAdapter(@NonNull FragmentManager fm, int tabCount) {
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
				FindPasswordFragment findPasswordFragment =new FindPasswordFragment();
				return findPasswordFragment;
			case 1:
				FindIdFragment findIdFragment =new FindIdFragment();
				return findIdFragment;
			default:
				return null;
		}

	}

	@Override
	public int getCount() {
		return tabCount;
	}
}
