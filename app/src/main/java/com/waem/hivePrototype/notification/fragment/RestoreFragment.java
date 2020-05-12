package com.waem.hivePrototype.notification.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.R;
import com.waem.hivePrototype.chatRoomList.adapter.MainChatAdapter;
import com.waem.hivePrototype.notification.adapter.MainRestoreAdapter;
import com.waem.hivePrototype.notification.notiEnum.NotiType;
import com.waem.hivePrototype.notification.vo.Notification;
import com.waem.hivePrototype.util.dbmanager.RealmManager;

import java.util.ArrayList;
import java.util.Date;

import static com.waem.hivePrototype.notification.notiEnum.NotiType.RESTORE_REQUEST_SUCCESS;

/**
 * 복구화면 프래그먼트
 * */
public class RestoreFragment extends Fragment {

	private View view;
	private RecyclerView rvMainRestorelist;
	private MainRestoreAdapter mainRestoreAdapter;
	private RecyclerView.LayoutManager restoreLayoutManager;

	/*테스트용 변수*/
	private ArrayList<Notification> restoreList = new ArrayList<>();

	private Date time = new Date();
	private NotiType notiType= RESTORE_REQUEST_SUCCESS;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		view= inflater.inflate(R.layout.fragment_restore, container, false);

		init();

		return view;
	}

	private void init(){

		rvMainRestorelist=(RecyclerView)view.findViewById(R.id.rv_main_restore_list);

		restoreLayoutManager = new LinearLayoutManager(getActivity());
		mainRestoreAdapter = new MainRestoreAdapter(restoreList);
		rvMainRestorelist.setLayoutManager(restoreLayoutManager);
		rvMainRestorelist.setAdapter(mainRestoreAdapter);


		Notification notification1 = new Notification("1","복구하게 수락해주세요.","q","홍길동","1",time,notiType,false);
		Notification notification2 = new Notification("2","복구하게 수락해주세요.","q","홍길순","1",time,notiType,false);
		Notification notification3 = new Notification("3","복구하게 수락해주세요.","q","홍길복","1",time,notiType,false);
		Notification notification4 = new Notification("4","복구하게 수락해주세요.","q","홍길현","1",time,notiType,false);
		Notification notification5 = new Notification("5","복구하게 수락해주세요.","q","홍길준","1",time,notiType,false);
		Notification notification6 = new Notification("6","복구하게 수락해주세요.","q","홍길운","1",time,notiType,false);
		Notification notification7 = new Notification("7","복구하게 수락해주세요.","q","홍길한","1",time,notiType,false);
		Notification notification8 = new Notification("8","복구하게 수락해주세요.","q","홍길운","1",time,notiType,false);

		restoreList.add(notification1);
		restoreList.add(notification2);
		restoreList.add(notification3);
		restoreList.add(notification4);
		restoreList.add(notification5);
		restoreList.add(notification6);
		restoreList.add(notification7);
		restoreList.add(notification8);

	}

}
