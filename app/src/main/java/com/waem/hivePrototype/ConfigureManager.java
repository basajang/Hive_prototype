package com.waem.hivePrototype;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Environment;
import android.util.Log;

import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;
import com.waem.hivePrototype.chatRoomList.vo.RoomFile;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

public class ConfigureManager {

    private static ConfigureManager instance = new ConfigureManager();
    private static final int PERMISSION_REQUEST_CODE = 1;
    private Activity activity;
    private Context context;

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
    public static void addBadge(Context context, int badgeCount) {
        Intent badgeIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        badgeIntent.putExtra("badge_count", badgeCount);
        badgeIntent.putExtra("badge_count_package_name", context.getPackageName());
        badgeIntent.putExtra("badge_count_class_name", getLauncherClass(context));
        context.sendBroadcast(badgeIntent);
    }

    //해당 패키지의 런처클래스의 이름을 반환한다
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
