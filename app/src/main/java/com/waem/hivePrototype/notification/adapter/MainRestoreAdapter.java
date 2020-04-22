package com.waem.hivePrototype.notification.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.waem.hivePrototype.R;
import com.waem.hivePrototype.notification.vo.Notification;

import java.util.ArrayList;

public class MainRestoreAdapter extends RecyclerView.Adapter<MainRestoreAdapter.RestoreViewHolder> {

	private ArrayList<Notification> notifications;

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
		return rvh;

	}

	@Override
	public void onBindViewHolder(@NonNull MainRestoreAdapter.RestoreViewHolder holder, int position) {

		holder.tvRestoreUserName.setText(notifications.get(position).getUserName());
		holder.tvRestoreRequestText.setText(notifications.get(position).getTitle());

	}

	@Override
	public int getItemCount() {
		return notifications.size();
	}


}
