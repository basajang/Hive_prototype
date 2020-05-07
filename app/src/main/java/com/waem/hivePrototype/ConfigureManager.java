package com.waem.hivePrototype;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;
import com.waem.hivePrototype.chatRoomList.vo.RoomFile;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

import static android.os.Looper.getMainLooper;

/**
 * 원활한 사용을 위해서 activity를 생성하거나 activity할경우 반드시
 * setActivity(this) 함수를 사용할것을 권장
 * ex :
 * setContentView(R.layout.activity_loding);
 * ConfigureManager.getInstance().setActivity(this);
 */
public class ConfigureManager {


    private static ConfigureManager instance = new ConfigureManager();
    private static final int PERMISSION_REQUEST_CODE = 1;
    private Activity activity;
    private Context context;

    private Activity currentActivity;

    private int currVersionCode = 1;
    private String currVersionName = "";
    private int sessioncount = 1;
    String androidId = "";
    boolean isInitalize = false;


    public ConfigureManager() {
    }

    public static ConfigureManager getInstance() {

        if (null == instance) {
            instance = new ConfigureManager();
        }

        return instance;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
        this.context = activity;
    }

    public Context getContext() {
        return context;
    }

    /**
     * 외부메모리 상태 확인 메서드
     */
    public boolean checkExternalStorage() {
        String state = Environment.getExternalStorageState();
        // 외부메모리 상태
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // 읽기 쓰기 모두 가능
            Log.d("test", "외부메모리 읽기 쓰기 모두 가능");

            return true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            //읽기전용
            Log.d("test", "외부메모리 읽기만 가능");
            return false;
        } else {
            // 읽기쓰기 모두 안됨
            Log.d("test", "외부메모리 읽기쓰기 모두 안됨 : "+ state);
            return false;
        }
    }

    public void checkNetworkStrength() {
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            try{
                ConnectivityManager cm = (ConnectivityManager) currentActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo Info = cm.getActiveNetworkInfo();

                if (Info == null){
                    showToast("인터넷이 연결 되어 있지 않습니다.", Toast.LENGTH_LONG);
                }

                if ( !Info.isConnectedOrConnecting()) {
                    int netType = Info.getType();
                    int netSubtype = Info.getSubtype();

                    if (netType == ConnectivityManager.TYPE_WIFI) {
                        WifiManager wifiManager = (WifiManager) currentActivity.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                        int numberOfLevels = 5;
                        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                        int level = WifiManager.calculateSignalLevel(wifiInfo.getRssi(), numberOfLevels);
                        if(level <= 1){
                            showToast("네트워크 연결이 불안정 합니다.", Toast.LENGTH_LONG);
                        }
                    } else if (netType == ConnectivityManager.TYPE_MOBILE) {
                        TelephonyManager telephonyManager = (TelephonyManager) currentActivity.getSystemService(Context.TELEPHONY_SERVICE);
                        for(CellInfo cellInfo : telephonyManager.getAllCellInfo()){
                            if (cellInfo.isRegistered()) {
                                if (cellInfo instanceof CellInfoWcdma) {
                                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                                    CellSignalStrengthWcdma cellSignalStrengthWcdma = cellInfoWcdma.getCellSignalStrength();
                                    Log.d(GlobalConst.TAG, "checkNetworkStrength: cellSignalStrengthWcdma : "+cellSignalStrengthWcdma.getLevel());
                                    if(cellSignalStrengthWcdma.getLevel() <= 1){
                                        showToast("네트워크 연결이 불안정 합니다.", Toast.LENGTH_LONG);
                                    }
                                } else if (cellInfo instanceof CellInfoGsm) {
                                    CellInfoGsm cellInfogsm = (CellInfoGsm) cellInfo;
                                    CellSignalStrengthGsm cellSignalStrengthGsm = cellInfogsm.getCellSignalStrength();
                                    Log.d(GlobalConst.TAG, "checkNetworkStrength: cellSignalStrengthGsm : "+cellSignalStrengthGsm.getLevel());
                                    if(cellSignalStrengthGsm.getLevel() <= 1){
                                        showToast("네트워크 연결이 불안정 합니다.", Toast.LENGTH_LONG);
                                    }
                                } else if (cellInfo instanceof CellInfoLte) {
                                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                                    CellSignalStrengthLte cellSignalStrengthLte = cellInfoLte.getCellSignalStrength();
                                    Log.d(GlobalConst.TAG, "checkNetworkStrength: cellSignalStrengthLte : "+cellSignalStrengthLte.getLevel());
                                    if(cellSignalStrengthLte.getLevel() <= 1){
                                        showToast("네트워크 연결이 불안정 합니다.", Toast.LENGTH_LONG);
                                    }
                                } else if (cellInfo instanceof CellInfoCdma) {
                                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                                    CellSignalStrengthCdma cellSignalStrengthCdma = cellInfoCdma.getCellSignalStrength();
                                    Log.d(GlobalConst.TAG, "checkNetworkStrength: cellSignalStrengthCdma : "+cellSignalStrengthCdma.getLevel());
                                    if(cellSignalStrengthCdma.getLevel() <= 1){
                                        showToast("네트워크 연결이 불안정 합니다.", Toast.LENGTH_LONG);
                                    }
                                }
                            }
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public boolean grantPermission() {
        if (Build.VERSION.SDK_INT >= 23) {

            if (currentActivity.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                return true;
            }else{
                ActivityCompat.requestPermissions(currentActivity, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
                return false;
            }
        }else{
            return true;
        }

    }

    public int getCurrVersionCode() {
        return currVersionCode;
    }

    /*디바이스 ID*/
    public void initialize(Context context) {
        if (isInitalize) {
            return;
        }

        loadCurrentVersion();
        if (getAppCache("androidId") == null) {
            // 디바이스 id  저장 하는 부분 android 10 에서는 다른 방식으로 가져오길 권장
            androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            setAppCache("androidId", androidId);
        } else {
            androidId = getAppCache("androidId");
        }
        isInitalize = true;
    }


    public void loadCurrentVersion() {
        PackageInfo pi = null;

        try {
            pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            currVersionCode = pi.versionCode;
            currVersionName = pi.versionName;

        } catch (PackageManager.NameNotFoundException e) {

            currVersionName = "";
        } catch (NullPointerException e) {

            currVersionName = "";
        }
    }

    /**
     * 백그라운드에서 포그라운드의 토스트 를 출력하기위한 메서드
     * @param text 출력할 메세지
     * @param LENGTH 시간 시간은 Toast.LENGTH_LONG or Toast.LENGTH_SHORT 으로만 출력 가능
     */
    public void showToast(String text, int LENGTH){
        if(this.currentActivity!= null){

            try{
                Handler mHandler = new Handler(getMainLooper());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(currentActivity, text, LENGTH).show();
                    }
                });
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    public String getCurrVersionName() {
        return currVersionName;
    }

    public String getAndroidId() {
        return androidId;
    }


    /**
     *  앱캐시에 데이터를 저장 하는 메서드
     * @param key 저장 되는 값의 키
     * @param data 저장 되는 값.  Integer일 경우 문자열로 캐스팅 하여 사용
     */
    public void setAppCache(String key, String data) {

        SharedPreferences settings = this.activity.getSharedPreferences(GlobalConst.APP_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, data);
        editor.commit();
    }

    /**
     * 앱캐시에 데이터를 가져오는 메서드
     * @param key 값의 키
     * @return
     */
    public String getAppCache(String key) {
        SharedPreferences settings = this.activity.getSharedPreferences(GlobalConst.APP_NAME, 0);
        return settings.getString(key, null);
    }

    /**
     * 앱캐시를 전체 삭제 하는 메서드
     * 사용자가 로그아웃 할경우 이용을 권장
     * @param activity
     */
    public void clearAppCache(Activity activity) {
        SharedPreferences settings = activity.getSharedPreferences(GlobalConst.APP_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();

        editor.clear();
        editor.commit();
    }

    /**
     * 해당 어플리케이션이 설치 되어 있는지 확인 하는 메서드
     *
     * @param packagename 확인할 어플리케이션 패키지명
     * @return
     */

    public boolean isPackageInstalled(String packagename) {
        PackageManager pm = this.activity.getPackageManager();
        try {
            pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }


    public String getImageDir(ChatRoom chatRoom){
        String path = activity.getCacheDir().getAbsolutePath()+"/"+chatRoom.getRoomId()+"/image";
        if(isExists(path)){
            makeDir(path);
        }
        return path;
    }

    public String getMovieDir(ChatRoom chatRoom){
        String path = activity.getCacheDir().getAbsolutePath()+"/"+chatRoom.getRoomId()+"/movie";
        if(isExists(path)){
            makeDir(path);
        }
        return path;
    }

    public String getDocDir(ChatRoom chatRoom){
        String path = activity.getCacheDir().getAbsolutePath()+"/"+chatRoom.getRoomId()+"/doc";
        if(isExists(path)){
            makeDir(path);
        }

        return path;
    }

    public String getMessageDir(ChatRoom chatRoom){
        String path = activity.getCacheDir().getAbsolutePath()+"/"+chatRoom.getRoomId()+"/msg";
        if(isExists(path)){
            makeDir(path);
        }
        return path;
    }

    public boolean isExists(String path){
        File file = new File(path);
        if(file.exists()){
            return true;
        }
        return false;
    }

    public boolean makeDir(String path){
        File file = new File(path);
        return file.mkdirs();

    }

    //해당 디바이스가 뱃지가 달린다면, 어플리케이션에 뱃지(숫자 넘버링)을 달아준다.
    /*public void addBadge(int badgeCount) { //오레오 버전 전까지만 씀
        Intent badgeIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        badgeIntent.putExtra("badge_count", badgeCount);
        badgeIntent.putExtra("badge_count_package_name", context.getPackageName());
        badgeIntent.putExtra("badge_count_class_name", getLauncherClass(context));
        context.sendBroadcast(badgeIntent);
    }*/

    /**
     * 해당 패키지의 런처클래스의 이름을 반환
     * @param context
     * @return
     */
    private static String getLauncherClass(Context context) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setPackage(context.getPackageName());

        List<ResolveInfo> list = context.getPackageManager().queryIntentActivities(intent, 0);
        if (list != null && list.size() > 0) {
            return list.get(0).activityInfo.name;
        }
        return "";
    }

    //메일주소 정규식 패턴 확인
    public static boolean checkMail(String mail) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches();
    }

    //이름 정규식 패턴 확인
    public static boolean checkName(String name) {
        return Pattern.matches("^[a-zA-Z가-힣].{1,8}$", name);
    }

    //비밀번호 정규식 패턴 확인
    public static boolean checkPass(String pass) {
        if (Pattern.matches("^(?=.*\\d)(?=.*[a-zA-Z]).{6,20}$", pass))
            for (int i = 0; i < pass.length(); i++) {
                if (!Character.isLetterOrDigit(pass.charAt(i)))
                    return true;
            }
        return false;
    }

    //폰번호 정규식 패턴 확인
    public static boolean checkPhone(String num) {
        return Pattern.matches("^01(?:0|1|[6-9]) - (?:\\d{3}|\\d{4}) - \\d{4}$", num);
    }

}
