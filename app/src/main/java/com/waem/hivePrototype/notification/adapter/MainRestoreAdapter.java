package com.waem.hivePrototype.notification.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.R;
import com.waem.hivePrototype.notification.vo.Notification;
import com.waem.hivePrototype.ui.CustomDialog;

import java.util.ArrayList;

/**
 *복구리스트 리사이클러뷰 어뎁터
 * */
public class MainRestoreAdapter extends RecyclerView.Adapter<MainRestoreAdapter.RestoreViewHolder> {

	private ArrayList<Notification> notifications;
	private Context context= null;


	public MainRestoreAdapter(ArrayList<Notification> restoreList) {

		this.notifications = restoreList;

	}

	public class RestoreViewHolder extends RecyclerView.ViewHolder {

		private TextView tvRestoreUserName,tvRestoreRequestText;

		public RestoreViewHolder(@NonNull View itemView) {

			super(itemView);
			tvRestoreUserName = (TextView) itemView.findViewById(R.id.tv_restore_user_name);
			tvRestoreRequestText = (TextView) itemView.findViewById(R.id.tv_restore_request_text);

		}
	}

	@NonNull
	@Override
	public MainRestoreAdapter.RestoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_restore_item,parent,false);
		RestoreViewHolder rvh = new RestoreViewHolder(view);
		context=parent.getContext();
		return rvh;

	}

	@Override
	public void onBindViewHolder(@NonNull MainRestoreAdapter.RestoreViewHolder holder, int position) {

		holder.tvRestoreUserName.setText(notifications.get(position).getUserName());
		holder.tvRestoreRequestText.setText(notifications.get(position).getTitle());

		holder.tvRestoreRequestText.setOnClickListener(v -> {

			CustomDialog customDialog = new CustomDialog(context);
			customDialog.setMessage(holder.tvRestoreUserName.getText().toString()+"님의 요청을 수락하시겠습니까.");
			customDialog.setPositiveBtnText("예");
			customDialog.setNegativeBtnText("아니요");
			customDialog.setOnDialogListener(new CustomDialog.DialogListener() {
				@Override
				public void onPositiveClick() {
					Toast.makeText(context,"예를 눌렀습니다.",Toast.LENGTH_SHORT).show();
				}
				@Override
				public void onNegativeClick() {
					Toast.makeText(context,"아니오를 눌렀습니다.",Toast.LENGTH_SHORT).show();
				}
			});

			customDialog.show();
		});

	}

	@Override
	public int getItemCount() {
		return notifications.size();
	}


}
