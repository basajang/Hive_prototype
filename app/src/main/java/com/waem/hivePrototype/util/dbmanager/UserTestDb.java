package com.waem.hivePrototype.util.dbmanager;

import android.content.Context;
import android.util.Log;

import com.waem.hivePrototype.GlobalConst;
import com.waem.hivePrototype.peopleList.vo.UserTest;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;

/*테스트 용*/
public class UserTestDb {

	private Realm realm;
	private Context context;

	public  UserTestDb(Realm realm) {
		this.realm = realm;
	}

	public RealmQuery getUserTestDb(){
		return realm.where(UserTest.class);
	}

	public List<UserTest> getAllUser(){
		return getUserTestDb().findAll();
	}
	public List<UserTest> getIdLoginUser(String id, String password){
		return getUserTestDb().equalTo("id",id).equalTo("password",password).findAll();
	}

	/*테스트 용*/
	public void insert(UserTest userTest){
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				UserTest realmUserTest = realm.createObject(UserTest.class);

				realmUserTest.setId(userTest.getId());
				realmUserTest.setPassword(userTest.getPassword());
				realmUserTest.setName(userTest.getName());
				realmUserTest.setAccessToken(userTest.getAccessToken());
				realmUserTest.setFcmToken(userTest.getFcmToken());
				realmUserTest.setDeviceId(userTest.getDeviceId());
				realmUserTest.setLiveCertOPT(userTest.getLiveCertOPT());
				realmUserTest.setDivisionKey(userTest.getDivisionKey());
				realmUserTest.setStatusMessage(userTest.getStatusMessage());
				realmUserTest.setFacebookAt(userTest.getFacebookAt());
				realmUserTest.setKakaoAt(userTest.getKakaoAt());
				realmUserTest.setGoogleAt(userTest.getGoogleAt());
				realmUserTest.setNaverat(userTest.getNaverat());
				realmUserTest.setOpenPrivacy(userTest.isOpenPrivacy());

				Log.d(GlobalConst.TAG,"new save -> realm transaction 완료"+userTest.toString());
			}
		});
	}

}
