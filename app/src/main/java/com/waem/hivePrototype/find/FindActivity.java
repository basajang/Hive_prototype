package com.waem.hivePrototype.find;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.waem.hivePrototype.ConfigureManager;
import com.waem.hivePrototype.R;
import com.waem.hivePrototype.find.adapter.FindTabPagerAdapter;


import butterknife.BindView;
import butterknife.ButterKnife;

public class FindActivity extends AppCompatActivity {

	@BindView(R.id.tab_find) TabLayout tabFind;
	@BindView(R.id.view_find) ViewPager viewFind;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find);
		ConfigureManager.getInstance().setActivity(this);

		ButterKnife.bind(this);

		init();
		listener();


	}
	private void init(){

		tabFind.addTab(tabFind.newTab().setText("비밀번호 찾기"));
		tabFind.addTab(tabFind.newTab().setText("아이디 찾기"));

	}
	private void listener(){
		/*텝 레이아웃 관련 코드*/
		FindTabPagerAdapter findTabPagerAdapter =new FindTabPagerAdapter(getSupportFragmentManager(), tabFind.getTabCount());
		viewFind.setAdapter(findTabPagerAdapter);
		viewFind.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabFind));
		tabFind.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				viewFind.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {

			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {

			}

		});

	}
}
