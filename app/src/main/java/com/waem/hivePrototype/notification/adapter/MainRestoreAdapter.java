package com.waem.hivePrototype.notification.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainRestoreAdapter extends RecyclerView.Adapter<MainRestoreAdapter.RestoreViewHolder> {

	public class RestoreViewHolder extends RecyclerView.ViewHolder {
		public RestoreViewHolder(@NonNull View itemView) {
			super(itemView);
		}
	}

	@NonNull
	@Override
	public MainRestoreAdapter.RestoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return null;
	}

	@Override
	public void onBindViewHolder(@NonNull MainRestoreAdapter.RestoreViewHolder holder, int position) {

	}

	@Override
	public int getItemCount() {
		return 0;
	}


}
