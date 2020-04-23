package com.waem.hivePrototype;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.waem.hivePrototype.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PopupRestoreActivity extends AppCompatActivity {

	@BindView(R.id.tv_popup_restore_name) TextView tvPopupRestoreName;
	@BindView(R.id.li_transparent) LinearLayout liTransparent;
	@BindView(R.id.btn_popup_restore_yes) Button btnPopupRestoreYes;
	@BindView(R.id.btn_popup_restore_no) Button btnPopupRestoreNo;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_popup_restore);

		ButterKnife.bind(this);

		init();
		listener();

		Intent intent =getIntent();
		tvPopupRestoreName.setText(intent.getStringExtra("UserName"));

	}

	private void init(){

	}

	private void listener(){
		liTransparent.setOnClickListener(v -> {
			finish();
		});
		btnPopupRestoreNo.setOnClickListener(v -> {
			finish();
		});
		btnPopupRestoreYes.setOnClickListener(v -> {

		});
	}

}
