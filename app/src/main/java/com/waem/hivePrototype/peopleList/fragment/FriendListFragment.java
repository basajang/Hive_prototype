package com.waem.hivePrototype.peopleList.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.BuildConfig;
import com.waem.hivePrototype.GlobalConst;
import com.waem.hivePrototype.R;
import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;
import com.waem.hivePrototype.peopleList.adapter.MainFriendAdapter;
import com.waem.hivePrototype.peopleList.adapter.MainFriendFavoriteAdapter;
import com.waem.hivePrototype.peopleList.vo.People;
import com.waem.hivePrototype.util.dbmanager.RealmManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.RealmQuery;
import io.realm.RealmResults;


/**
 * 친구 리스트 프래그먼트
 * */
public class FriendListFragment extends Fragment {

	private List<People> friendArray = new ArrayList<>();
	private List<People> friendFavoriteArray = new ArrayList<>();
	private View view;

	private RecyclerView.LayoutManager allLayoutManager,FavoriteLayoutManager;
	private MainFriendAdapter mainFriendAdapter;
	private MainFriendFavoriteAdapter mainFriendFavoriteAdapter;
	private RecyclerView rvMainFriendList,rvMainFriendFavoriteList;

	private Date time = new Date();

	private LinearLayout liMainFriendListTest;
	private Button btnMainFriendListTestInsert,btnMainFriendListTestDelete,btnMainFriendListTestDeleteAll;
	private EditText etMainFriendTestId,etMainFriendTestName;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view =  inflater.inflate(R.layout.fragment_friend_list, container, false);

		init();
		test();



		return view;

	}

	private void init(){

		rvMainFriendList = (RecyclerView) view.findViewById(R.id.rv_main_friend_list);
		rvMainFriendFavoriteList = (RecyclerView) view.findViewById(R.id.rv_main_friend_favorite_list);

		liMainFriendListTest = (LinearLayout) view.findViewById(R.id.li_main_friend_list_test);
		btnMainFriendListTestInsert = (Button) view.findViewById(R.id.btn_main_friend_list_test_insert);
		btnMainFriendListTestDelete = (Button) view.findViewById(R.id.btn_main_friend_list_test_delete);
		btnMainFriendListTestDeleteAll = (Button) view.findViewById(R.id.btn_main_friend_list_test_delete_all);
		etMainFriendTestId = (EditText) view.findViewById(R.id.et_main_friend_test_id);
		etMainFriendTestName = (EditText) view.findViewById(R.id.et_main_friend_test_name);

		/*친구목록 리사이클러뷰를 사용하기 위해 필요한 부분*/
		allLayoutManager = new LinearLayoutManager(getActivity());
		mainFriendAdapter = new MainFriendAdapter(friendArray);
		rvMainFriendList.setLayoutManager(allLayoutManager);
		rvMainFriendList.setAdapter(mainFriendAdapter);

		//rvMainFriendList.setHasFixedSize(true);
		//rvMainFriendFavoriteList.setHasFixedSize(true);
		/*친구목록 즐겨찾기 리사이클러뷰를 사용하기 위해 필요한 부분*/
		FavoriteLayoutManager = new LinearLayoutManager(getActivity());
		mainFriendFavoriteAdapter = new MainFriendFavoriteAdapter(friendFavoriteArray);
		rvMainFriendFavoriteList.setLayoutManager(FavoriteLayoutManager);
		rvMainFriendFavoriteList.setAdapter(mainFriendFavoriteAdapter);

		if(RealmManager.getInstance().getPeople().getActivPeopleList().size()==0){
			People people1 =new People("qwer1","김홍도","123","123",false,time,false,false);
			People people2 =new People("qwer2","김아무개","123","123",false,time,false,false);
			People people3 =new People("qwer3","홍길동","123","123",false,time,false,false);
			People people4 =new People("qwer4","홍동길","123","123",false,time,false,false);
			People people5 =new People("qwer5","동길홍","123","123",false,time,false,false);
			People people6 =new People("qwer6","동길홍","123","123",false,time,false,false);
			People people7 =new People("qwer7","동길홍","123","123",false,time,false,false);
			People people8 =new People("qwer8","동길홍","123","123",false,time,false,false);
			People people9 =new People("qwer9","동길홍","123","123",false,time,false,false);
			People people10 =new People("qwer10","동길홍","123","123",false,time,false,false);

			/*테스트 중*/
			RealmManager.getInstance().getPeople().insert(people1);
			RealmManager.getInstance().getPeople().insert(people2);
			RealmManager.getInstance().getPeople().insert(people3);
			RealmManager.getInstance().getPeople().insert(people4);
			RealmManager.getInstance().getPeople().insert(people5);
			RealmManager.getInstance().getPeople().insert(people6);
			RealmManager.getInstance().getPeople().insert(people7);
			RealmManager.getInstance().getPeople().insert(people8);
			RealmManager.getInstance().getPeople().insert(people9);
			RealmManager.getInstance().getPeople().insert(people10);

		}

		btnMainFriendListTestInsert.setOnClickListener(v -> {
			String testId = etMainFriendTestId.getText().toString();
			String testName = etMainFriendTestName.getText().toString();

			People people =new People(testId,testName,"123","123",false,time,false,false);
			RealmManager.getInstance().getPeople().insert(people);
			mainFriendAdapter.notifyDataSetChanged();

			Log.d(GlobalConst.TAG,"입력한 친구 id : "+testId);
			Log.d(GlobalConst.TAG,"입력한 친구 name : "+testName);
		});
		btnMainFriendListTestDelete.setOnClickListener(v -> {
			String testid = etMainFriendTestId.getText().toString();
			RealmManager.getInstance().getPeople().delete(testid);
			mainFriendAdapter.notifyDataSetChanged();
		});
		btnMainFriendListTestDeleteAll.setOnClickListener(v -> {
			RealmManager.getInstance().getPeople().deleteAll();
			mainFriendAdapter.notifyDataSetChanged();
		});

		Log.d(GlobalConst.TAG, "친구목록: "+RealmManager.getInstance().getPeople().getActivPeopleList());
		Log.d(GlobalConst.TAG, "친구목록: "+RealmManager.getInstance().getPeople().getActivPeopleList().size());

		friendArray = RealmManager.getInstance().getPeople().getActivPeopleList();

		for(People people : friendArray){

			mainFriendAdapter.addPeople(people);

		}

		mainFriendAdapter.setItem(friendArray);
	}

	private void test(){
		if(GlobalConst.DEVKEY.equals(BuildConfig.DEVKEY)){
			liMainFriendListTest.setVisibility(View.VISIBLE);
		}
	}
}
