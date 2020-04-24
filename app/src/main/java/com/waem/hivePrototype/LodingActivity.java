package com.waem.hivePrototype;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.waem.hivePrototype.login.LoginActivity;

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
public class LodingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_loding);
		ConfigureManager.getInstance().setActivity(this);

		PermissionListener permissionlistener = new PermissionListener() {
			@Override
			public void onPermissionGranted() {
				Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
				startActivity(intent1);
				finish();
			}

			@Override
			public void onPermissionDenied(ArrayList<String> deniedPermissions) {
				Toast.makeText(ConfigureManager.getInstance().getActivity(), "권한 거부\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
			}

		};


		TedPermission.with(this).setPermissionListener(permissionlistener)
				.setRationaleMessage("접근 권한이 필요해요")
				.setDeniedMessage("왜 거부하셨어요...\n하지만 [설정] > [권한] 에서 권한을 허용할 수 있어요.")
				.setPermissions(Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.ACCESS_WIFI_STATE , Manifest.permission.INTERNET
						, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.ACCESS_COARSE_LOCATION)
				.check();

		ConfigureManager.getInstance().checkExternalStorage();
        Realm.init(getApplicationContext());
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
