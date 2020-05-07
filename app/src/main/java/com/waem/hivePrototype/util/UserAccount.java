package com.waem.hivePrototype.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class UserAccount {

    private final static String USER_ID_KEY = "UserId";
    private final static String ACCESS_TOKEN_KEY = "AccessToken";
    private final static String NICKNAME_KEY = "Nickname";
    private final static String PROFILE_IMAGE_PATH_KEY = "ProfileImagePath";
    private final static String STATUS_MESSAGE_KEY = "StatusMessage";
    private final static String SOCIAL_TYPE = "socialType";

    private final static String LIVE_CERT_OPT = "LiveCertOPT";
    private final static String DIVISION_KEY = "DivisionKey";

    private final static String FACEBOOK_ACCESS_TOKEN_KEY = "facebookAt";
    private final static String KAKAO_ACCESS_TOKEN_KEY = "kakaoAt";
    private final static String GOOGLE_ACCESS_TOKEN_KEY = "googleAt";
    private final static String NAVER_ACCESS_TOKEN_KEY = "naverAt";

    private final static String OPEN_PRIVACY = "openPrivacy";
    private final static String FCMTOKEN = "fcmToken";


    private static UserAccount instance;
    private SharedPreferences pref;

    private UserAccount(Context context) {
        pref = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * 인스턴스 색성
     * 사용자가 캐시 삭제 or 데이터 삭제시 해당 정보 삭제됨
     * @param context activity 를 넣어도 무방
     * @return
     */
    public static UserAccount getInstance(Context context) {
        if (instance == null) {
            instance = new UserAccount(context);
        }
        return instance;
    }


    /**
     * 사용자 정보를 캐시에서 삭제
     */
    public void logout(){
        setUserId(0);
        setAccessToken("");
        setNickname("");
        setProfileImagePath("");
        setStatusMessage("");
        setSocialType("");
        setDivisionKey("");
        setLiveCertOPT("");
    }


    public int getUserId() {
        return pref.getInt(USER_ID_KEY, 0);
    }

    public void setUserId(int userId) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(USER_ID_KEY, userId);
        editor.apply();
    }

    public String getAccessToken() {
        return pref.getString(ACCESS_TOKEN_KEY, "");
    }

    public void setAccessToken(String accessToken) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(ACCESS_TOKEN_KEY, accessToken);
        editor.apply();
    }

    public String getNickname() {
        return pref.getString(NICKNAME_KEY, "");
    }

    public void setNickname(String nickname) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(NICKNAME_KEY, nickname);
        editor.apply();
    }

    public String getProfileImagePath() {
        return pref.getString(PROFILE_IMAGE_PATH_KEY, "");
    }

    public void setProfileImagePath(String profileImagePath) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(PROFILE_IMAGE_PATH_KEY, profileImagePath);
        editor.apply();
    }

    public String getStatusMessage() {
        return pref.getString(STATUS_MESSAGE_KEY, "");
    }

    public void setStatusMessage(String statusMessage) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(STATUS_MESSAGE_KEY, statusMessage);
        editor.apply();
    }

    public String getSocialType() {
        return pref.getString(SOCIAL_TYPE, "");
    }

    public void setSocialType(String statusMessage) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(SOCIAL_TYPE, statusMessage);
        editor.apply();
    }

    public String getLiveCertOPT() {
        return pref.getString(LIVE_CERT_OPT, "");
    }

    public void setLiveCertOPT(String statusMessage) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(LIVE_CERT_OPT, statusMessage);
        editor.apply();
    }

    public String getDivisionKey() {
        return pref.getString(DIVISION_KEY, "");
    }

    public void setDivisionKey(String statusMessage) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(DIVISION_KEY, statusMessage);
        editor.apply();
    }

    public String getFacebookAt() {
        return pref.getString(FACEBOOK_ACCESS_TOKEN_KEY, "");
    }

    public void setFacebookAt(String facebookAt) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(FACEBOOK_ACCESS_TOKEN_KEY, facebookAt);
        editor.apply();
    }

    public String getKakaoAt() {
        return pref.getString(KAKAO_ACCESS_TOKEN_KEY, "");
    }

    public void setKakaoAt(String kakaoAt) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(KAKAO_ACCESS_TOKEN_KEY, kakaoAt);
        editor.apply();
    }

    public String getGoogleAt() {
        return pref.getString(GOOGLE_ACCESS_TOKEN_KEY, "");
    }

    public void setGoogleAt(String googleAt) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(GOOGLE_ACCESS_TOKEN_KEY, googleAt);
        editor.apply();
    }

    public String getNaverat() {
        return pref.getString(NAVER_ACCESS_TOKEN_KEY, "");
    }

    public void setNaverat(String naverat) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(NAVER_ACCESS_TOKEN_KEY, naverat);
        editor.apply();
    }

    public boolean isOpenPrivacy() {
        return pref.getBoolean(OPEN_PRIVACY, false);
    }

    public void setOpenPrivacy(boolean openPrivacy) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(OPEN_PRIVACY, openPrivacy);
        editor.apply();
    }

    public String getFcmToken() {
        return pref.getString(FCMTOKEN, "");
    }

    public void setFcmToken(String fcmToken) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(FCMTOKEN, fcmToken);
        editor.apply();
    }
}
