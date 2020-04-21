package com.waem.hivePrototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
/**
 * 로딩 화면 클래스
 * */
public class LodingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_loding);
		startLoading();

	}
	/**
	 로딩 화면 2초동안 나오게 하는 함수
	 */
	private void startLoading() {

		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {

			@Override
			public void run() {
				Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
				startActivity(intent1);
				finish();
			}
		}, 2000);
	}
}
