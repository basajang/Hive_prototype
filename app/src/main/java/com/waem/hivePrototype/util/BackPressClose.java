package com.waem.hivePrototype.util;

import android.app.Activity;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.waem.hivePrototype.ConfigureManager;

/**
 *뒤로가기 버튼 눌렀을 때 앱 종료 시키는 클래스
 * */
public class BackPressClose extends AppCompatActivity {

	private long backKeyPressedTime = 0;
	private Toast toast;
	private Activity activity;


	public static BackPressClose backPressClose;

	/*생성자*/
	public BackPressClose(Activity activity) {
		this.activity = activity;
	}

	/*뒤로가기 눌렀을 때 2초안에 다시 한번 누르면 실행*/
	public void OnBackPressed() {
		if (System.currentTimeMillis() > backKeyPressedTime + 2000) {

			backKeyPressedTime = System.currentTimeMillis(); showGuide();
			return;

		} if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {

			activity.finish();
			toast.cancel();

		}
	}
	/*토스트 메세지 띄우는 함수*/
	private void showGuide() {
		toast = Toast.makeText(activity, "\'뒤로\'버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT); toast.show();
	}

}
