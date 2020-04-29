package com.waem.hivePrototype.join;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.waem.hivePrototype.join.adapter.JoinTabPagerAdapter;
import com.waem.hivePrototype.login.LoginActivity;
import com.waem.hivePrototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 회원가입 화면 액티비티
 * */
public class SignupActivity extends AppCompatActivity {

	@BindView(R.id.btn_signup) Button btnSignup;
	@BindView(R.id.tab_signup) TabLayout tabSignup;
	@BindView(R.id.view_signup) ViewPager viewSignup;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);

		ButterKnife.bind(this);

		init();
		listener();

	}

	private void init(){

		tabSignup.addTab(tabSignup.newTab().setText("이메일 인증"));
		tabSignup.addTab(tabSignup.newTab().setText("휴대폰 인증"));

	}

	private void listener(){

		JoinTabPagerAdapter joinTabPagerAdapter = new JoinTabPagerAdapter(getSupportFragmentManager(),tabSignup.getTabCount());
		viewSignup.setAdapter(joinTabPagerAdapter);
		viewSignup.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabSignup));
		tabSignup.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				viewSignup.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {

			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {

			}

		});




		btnSignup.setOnClickListener(view -> {
			Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
			startActivity(intent);
		});

	}
}
