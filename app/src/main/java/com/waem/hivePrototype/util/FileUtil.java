package com.waem.hivePrototype.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

import com.waem.hivePrototype.ConfigureManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class FileUtil {
    private static final String TAG = FileUtil.class.getSimpleName();

    private FileUtil() {
    }

    public static File getBaseDir() {
        return ConfigureManager.getInstance().getContext().getFilesDir();
    }

    public static File mkdirIfNotExist(File dir) {
        if (!dir.exists()) {
            if (!dir.mkdir()) {
                Log.e(TAG, "Could not create directory. PATH : " + dir.getAbsolutePath());
            }
        }
        return dir;
    }
    private static File cacheDir = null;


    public static File getCacheDir(Context context) {

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            cacheDir = context.getCacheDir();
            if(!cacheDir.isDirectory()) {
                cacheDir.mkdirs();
            }
        }
        if(!cacheDir.isDirectory()) {
            cacheDir = context.getCacheDir();
        }
        return cacheDir;
    }

    public static String getRootDir(){
        String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        File contentsDir = new File(sdPath+"/Pictures/");
        contentsDir.mkdirs();
        return contentsDir.getAbsolutePath();
    }


    public static String loadJSON(File file) {
        String json = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int size = fileInputStream.available();
            byte[] buffer = new byte[size];
            fileInputStream.read(buffer);
            fileInputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    /**
     * 디렉토리 생성
     * @return dir
     */
    public static File makeDirectory(String dir_path){
        File dir = new File(dir_path);
        if (!dir.exists())
        {
            dir.mkdirs();
        }else{
        }

        return dir;
    }

    /**
     * 파일 생성
     * @param dir
     * @return file
     */
    public static File makeFile(File dir , String file_path){
        File file = null;
        boolean isSuccess = false;
        if(dir.isDirectory()){
            file = new File(dir.getAbsoluteFile(), file_path);
            if(file!=null&&!file.exists()){
                Log.i( TAG , "!file.exists" );
                try {
                    isSuccess = file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally{
                    Log.i(TAG, "파일생성 여부 = " + isSuccess);
                }
            }else{
                Log.i( TAG , "file.exists" );
            }
        }
        return file;
    }

    /**
     * (dir/file) 절대 경로 얻어오기
     * @param file
     * @return String
     */
    public static String getAbsolutePath(File file){
        return ""+file.getAbsolutePath();
    }

    /**
     * (dir/file) 삭제 하기
     * @param file
     */
    public static boolean deleteFile(File file){
        boolean result;
        if(file!=null&&file.exists()){
            file.delete();
            result = true;
        }else{
            result = false;
        }
        return result;
    }

    /**
     * 파일여부 체크 하기
     * @param file
     * @return
     */
    public static boolean isFile(File file){
        boolean result;
        if(file!=null&&file.exists()&&file.isFile()){
            result=true;
        }else{
            result=false;
        }
        return result;
    }

    /**
     * 디렉토리 여부 체크 하기
     * @param dir
     * @return
     */
    public static boolean isDirectory(File dir){
        boolean result;
        if(dir!=null&&dir.isDirectory()){
            result=true;
        }else{
            result=false;
        }
        return result;
    }

    /**
     * 파일 존재 여부 확인 하기
     * @param file
     * @return
     */
    public static boolean isFileExist(File file){
        boolean result;
        if(file!=null&&file.exists()){
            result=true;
        }else{
            result=false;
        }
        return result;
    }

    /**
     * 파일 이름 바꾸기
     * @param file
     */
    public static boolean reNameFile(File file , File new_name){
        boolean result;
        if(file!=null&&file.exists()&&file.renameTo(new_name)){
            result=true;
        }else{
            result=false;
        }
        return result;
    }

    /**
     * 디렉토리에 안에 내용을 보여 준다.
     * @param dir
     * @return
     */
    public static String[] getList(File dir){
        if(dir!=null&&dir.exists())
            return dir.list();
        return null;
    }

    /**
     * 파일에 내용 쓰기
     * @param file
     * @param file_content
     * @return
     */
    public static boolean writeFile(File file , byte[] file_content){
        boolean result;
        FileOutputStream fos;
        if(file!=null&&file.exists()&&file_content!=null){
            try {
                fos = new FileOutputStream(file);
                try {
                    fos.write(file_content);
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            result = true;
        }else{
            result = false;
        }
        return result;
    }

    /**
     * 파일 읽어 오기
     * @param file
     */
    public static void readFile(File file){
        int readcount=0;
        if(file!=null&&file.exists()){
            try {
                FileInputStream fis = new FileInputStream(file);
                readcount = (int)file.length();
                byte[] buffer = new byte[readcount];
                fis.read(buffer);
                for(int i=0 ; i<file.length();i++){
                    Log.d(TAG, ""+buffer[i]);
                }
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 파일 복사
     * @param file
     * @param save_file
     * @return
     */
    public static boolean copyFile(File file , String save_file){
        boolean result;
        if(file!=null&&file.exists()){
            try {
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream newfos = new FileOutputStream(save_file);
                int readcount=0;
                byte[] buffer = new byte[1024];
                while((readcount = fis.read(buffer,0,1024))!= -1){
                    newfos.write(buffer,0,readcount);
                }
                newfos.close();
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            result = true;
        }else{
            result = false;
        }
        return result;
    }

    /**
     * 남은공간 확인
     * @return
     */
    public static long getBytesAvailable (){
        long result = 0;
        try{
            StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
            result = stat.getFreeBytes();
            Log.d("########", ">>>> getFreeBytes : " + result);

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

}