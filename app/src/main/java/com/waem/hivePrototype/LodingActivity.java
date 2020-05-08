package com.waem.hivePrototype;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.waem.hivePrototype.login.LoginActivity;
import com.waem.hivePrototype.util.dbmanager.RealmManager;

import java.util.ArrayList;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

/**
 * 로딩 화면 클래스
 * */

/**
 * 테마 관련 소스
 * https://github.com/android/user-interface-samples/tree/master/DarkTheme
 *
 * 기타 구글 도큐먼트 샘플
 * https://github.com/android/user-interface-samples
 *
 */
public class LodingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_loding);
		ConfigureManager.getInstance().setActivity(this);

		/** 개발 버전에서 테스트 및 개발 편의 성을 위하여
		 * BuildConfig.DEVKEY 가 GlobalConst.DEVKEY와 같을때 동작하는 소스를 하기에 기입
 		 */
		if(GlobalConst.DEVKEY.equals(BuildConfig.DEVKEY)){
			Log.d(GlobalConst.TAG, "onCreate: "+BuildConfig.DEVKEY);

		}

		// 사용자에게 권한을 요청 하고 응답 받는 리스너
		PermissionListener permissionlistener = new PermissionListener() {
			@Override
			public void onPermissionGranted() {
				Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
				startActivity(intent1);
				finish();
			}

			@Override
			public void onPermissionDenied(ArrayList<String> deniedPermissions) {
				//권한 거부시 작업할 코드를 작성

				Toast.makeText(ConfigureManager.getInstance().getActivity(), "권한 거부\n"
						+ deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
			}

		};


		/**
		 * 권한 요청 팝업 출력 시킬 코드
		 * setPermissions 에 권한 들을 입력
		 */
		TedPermission.with(this).setPermissionListener(permissionlistener)
				.setRationaleMessage("접근 권한이 필요해요")
				.setDeniedMessage("왜 거부하셨어요...\n하지만 [설정] > [권한] 에서 권한을 허용할 수 있어요.")
				.setPermissions(Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.ACCESS_WIFI_STATE
						, Manifest.permission.INTERNET
						, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE
						, Manifest.permission.ACCESS_COARSE_LOCATION)
				.check();

		ConfigureManager.getInstance().checkExternalStorage();

		/**
		 * Realm db를 사용 하기 위하여 init
		 */

		// realm DB 설정 참고 https://black-jin0427.tistory.com/98
//		RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().schemaVersion(3).migration(new RealmMigration() {
//			@Override
//			public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
//				RealmSchema realmSchema = realm.getSchema();
//
//				if(oldVersion == 2){
//					RealmObjectSchema realmObjectSchema = realmSchema.get("Message");
//					realmObjectSchema.addField("itemViewType", int.class, null);
//				}
//
//
//			}
//		}).build();
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

			}
		}, 2000);
	}
}
