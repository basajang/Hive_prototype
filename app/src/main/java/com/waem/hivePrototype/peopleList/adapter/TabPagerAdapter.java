package com.waem.hivePrototype.peopleList.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.waem.hivePrototype.chatRoomList.fragment.ChatListFragment;
import com.waem.hivePrototype.notification.fragment.RestoreFragment;
import com.waem.hivePrototype.peopleList.fragment.FriendListFragment;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
	private int tabCount;
	public TabPagerAdapter(@NonNull FragmentManager fm, int tabCount) {
		super(fm);
		this.tabCount = tabCount;
	}

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
	public int getCount() {
		return tabCount;
	}
}
