package com.waem.hivePrototype.join;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.waem.hivePrototype.ConfigureManager;
import com.waem.hivePrototype.GlobalConst;
import com.waem.hivePrototype.join.adapter.JoinTabPagerAdapter;
import com.waem.hivePrototype.join.fragment.JoinEmailFragment;
import com.waem.hivePrototype.login.LoginActivity;
import com.waem.hivePrototype.R;
import com.waem.hivePrototype.peopleList.vo.UserTest;
import com.waem.hivePrototype.util.dbmanager.RealmManager;
import com.waem.hivePrototype.util.dbmanager.UserTestDb;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.waem.hivePrototype.join.fragment.JoinEmailFragment.getJoinEmail;
import static com.waem.hivePrototype.join.fragment.JoinEmailFragment.joinEmail;

/**
 * 회원가입 화면 액티비티
 * */
public class JoinActivity extends AppCompatActivity {

	@BindView(R.id.btn_join) Button btnJoin;
	@BindView(R.id.tab_join) TabLayout tabJoin;
	@BindView(R.id.vp_join) ViewPager vpSignup;
	@BindView(R.id.et_join_name) EditText etJoinName;
	@BindView(R.id.et_join_id) EditText etJoinId;
	@BindView(R.id.et_join_pw) EditText etJoinPw;
	@BindView(R.id.et_join_pw_confirm) EditText etJoinPwConfirm;


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_join);
		ConfigureManager.getInstance().setActivity(this);

		ButterKnife.bind(this);

		init();
		listener();

	}

	private void init(){

		tabJoin.addTab(tabJoin.newTab().setText("이메일 인증"));
		tabJoin.addTab(tabJoin.newTab().setText("휴대폰 인증"));

	}

	private void listener(){

		JoinTabPagerAdapter joinTabPagerAdapter = new JoinTabPagerAdapter(getSupportFragmentManager(),tabJoin.getTabCount());
		vpSignup.setAdapter(joinTabPagerAdapter);
		vpSignup.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabJoin));
		tabJoin.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				vpSignup.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {

			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {

			}

		});

		btnJoin.setOnClickListener(view -> {

			String joinId = etJoinId.getText().toString();
			String joinName = etJoinName.getText().toString();
			String joinPw = etJoinPw.getText().toString();


			UserTest userTest = new UserTest(joinId,joinPw,joinName,getJoinEmail(),"","","","","","","","","","",false);
			RealmManager.getInstance().getUserTest().join(userTest);
			Log.d(GlobalConst.TAG,"회원가입 이메일 : "+getJoinEmail());
			Log.d(GlobalConst.TAG,"회원가입 : "+RealmManager.getInstance().getUserTest().getAllUser());
			Log.d(GlobalConst.TAG,"회원가입 : "+RealmManager.getInstance().getUserTest().getAllUser().size());
			/*Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
			startActivity(intent);*/
			this.finish();
		});

	}
}
