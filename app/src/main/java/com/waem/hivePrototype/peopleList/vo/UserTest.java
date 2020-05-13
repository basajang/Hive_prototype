package com.waem.hivePrototype.peopleList.vo;

import org.jetbrains.annotations.NotNull;

import io.realm.RealmList;
import io.realm.RealmObject;

/*테스트용*/
public class UserTest extends RealmObject {

	@NotNull
	/*사용자 아이디*/
	private String id = "";
	@NotNull
	private String password ="";
	@NotNull
	private String name = "";

	private String email = "";

	// 사용자 로그인 토큰
	private String accessToken = null;
	// 푸시 토큰
	private String fcmToken = null;

	// 기기 아이디 https://brunch.co.kr/magazine/androidq widevine ID 조사
	private String deviceId = null; /*디바이스 아이디가 곧 사용자 고유 아이디인가?*/
	private String liveCertOPT = null;
	private String divisionKey = null;

	// 상태메세지
	private String statusMessage = "";

	// SNS 토큰
	private String facebookAt = null;
	private String kakaoAt = null;
	private String googleAt = null;
	private String naverat = null;

	// 개인정보 공개 여부
	private boolean openPrivacy = false;

	private RealmList<People> peopleRealmList;

	public UserTest() {

	}


	public UserTest(@NotNull String id, @NotNull String password, @NotNull String name,String email, String accessToken, String fcmToken, String deviceId, String liveCertOPT, String divisionKey, String statusMessage, String facebookAt, String kakaoAt, String googleAt, String naverat, Boolean openPrivacy){

		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.accessToken = accessToken;
		this.fcmToken = fcmToken;
		this.deviceId = deviceId;
		this.liveCertOPT = liveCertOPT;
		this.divisionKey = divisionKey;
		this.statusMessage = statusMessage;
		this.facebookAt = facebookAt;
		this.kakaoAt = kakaoAt;
		this.googleAt = googleAt;
		this.naverat = naverat;
		this.openPrivacy = openPrivacy;

	}

	@NotNull
	public String getId() {
		return id;
	}

	public void setId(@NotNull String id) {
		this.id = id;
	}

	@NotNull
	public String getPassword() {
		return password;
	}

	public void setPassword(@NotNull String password) {
		this.password = password;
	}

	@NotNull
	public String getName() {
		return name;
	}

	public void setName(@NotNull String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getFcmToken() {
		return fcmToken;
	}

	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getLiveCertOPT() {
		return liveCertOPT;
	}

	public void setLiveCertOPT(String liveCertOPT) {
		this.liveCertOPT = liveCertOPT;
	}

	public String getDivisionKey() {
		return divisionKey;
	}

	public void setDivisionKey(String divisionKey) {
		this.divisionKey = divisionKey;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getFacebookAt() {
		return facebookAt;
	}

	public void setFacebookAt(String facebookAt) {
		this.facebookAt = facebookAt;
	}

	public String getKakaoAt() {
		return kakaoAt;
	}

	public void setKakaoAt(String kakaoAt) {
		this.kakaoAt = kakaoAt;
	}

	public String getGoogleAt() {
		return googleAt;
	}

	public void setGoogleAt(String googleAt) {
		this.googleAt = googleAt;
	}

	public String getNaverat() {
		return naverat;
	}

	public void setNaverat(String naverat) {
		this.naverat = naverat;
	}

	public boolean isOpenPrivacy() {
		return openPrivacy;
	}

	public void setOpenPrivacy(boolean openPrivacy) {
		this.openPrivacy = openPrivacy;
	}

	public RealmList<People> getPeopleRealmList() {
		return peopleRealmList;
	}

	public void setPeopleRealmList(RealmList<People> peopleRealmList) {
		this.peopleRealmList = peopleRealmList;
	}
}
