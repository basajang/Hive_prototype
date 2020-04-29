package com.waem.hivePrototype.peopleList.vo;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

import io.realm.RealmObject;

public class User {
    /*people 상속 받아야 되는 거 같은데 Realm에서 상속/다형성에 대한 문제가 있어서
    extends로 people 상속하면 Valid model classes must either extend RealmObject or implement RealmModel. 에러 뜸*/

    // 사용자 ID
    @NotNull
    /*사용자 아이디*/
    private String id = "";
    @NotNull
    private String name = "";

    // 사용자 로그인 토큰
    private String accessToken = null;
    // 푸시 토큰
    private String fcmToken = null;

    // 기기 아이디 https://brunch.co.kr/magazine/androidq widevine ID 조사 
    private String deviceId = null;
    private String liveCertOPT = null;
    private String divisionKey = null;

    // 상태메세지
    private String statusMessage = "";

    // SNS 토큰
    private String facebookAt = null;
    private String kakaoAt = null;
    private String googleAt = null;
    private String naverat = null;

    private boolean openPrivacy = false;

    public User() {

    }

    public User(@NotNull String id, @NotNull String name, String profilePath, String statusMessage, boolean favorites, Date lastUpdate, boolean block, boolean hide, @NotNull String id1, @NotNull String name1, String accessToken, String fcmToken, String deviceId, String liveCertOPT, String divisionKey, String statusMessage1, String facebookAt, String kakaoAt, String googleAt, String naverat, boolean openPrivacy) {
        super(id, name, profilePath, statusMessage, favorites, lastUpdate, block, hide);

        this.id = id1;
        this.name = name1;
        this.accessToken = accessToken;
        this.fcmToken = fcmToken;
        this.deviceId = deviceId;
        this.liveCertOPT = liveCertOPT;
        this.divisionKey = divisionKey;
        this.statusMessage = statusMessage1;
        this.facebookAt = facebookAt;
        this.kakaoAt = kakaoAt;
        this.googleAt = googleAt;
        this.naverat = naverat;
        this.openPrivacy = openPrivacy;
    }

    @Override
    @NotNull
    public String getId() {
        return id;
    }

    @Override
    public void setId(@NotNull String id) {
        this.id = id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", fcmToken='" + fcmToken + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", liveCertOPT='" + liveCertOPT + '\'' +
                ", divisionKey='" + divisionKey + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                ", facebookAt='" + facebookAt + '\'' +
                ", kakaoAt='" + kakaoAt + '\'' +
                ", googleAt='" + googleAt + '\'' +
                ", naverat='" + naverat + '\'' +
                ", openPrivacy=" + openPrivacy +
                '}';
    }
}
