package com.waem.hivePrototype;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;
import com.waem.hivePrototype.chatRoomList.vo.RoomFile;

import java.io.File;

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




}
