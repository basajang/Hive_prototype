package com.waem.hivePrototype.peopleList.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.waem.hivePrototype.chatRoomList.fragment.ChatListFragment;
import com.waem.hivePrototype.notification.fragment.RestoreFragment;
import com.waem.hivePrototype.peopleList.fragment.FriendListFragment;
/**
 * 탭 레이아웃 어댑터
 * */
public class TabPagerAdapter extends FragmentStatePagerAdapter {

	private int tabCount;

	public TabPagerAdapter(@NonNull FragmentManager fm, int tabCount) {
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
				FriendListFragment friendListFragment =new FriendListFragment();
				return friendListFragment;
			case 1:
				ChatListFragment chatListFragment =new ChatListFragment();
				return chatListFragment;
			case 2:
				RestoreFragment restoreFragment= new RestoreFragment();
				return restoreFragment;
			default:
				return null;
		}

	}

	@Override
	public int getItemPosition(@NonNull Object object) {
		return POSITION_NONE;
	}

	@Override
	public int getCount() {
		return tabCount;
	}
}
