package com.waem.hivePrototype.util;

import android.app.Activity;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUtil {
    private Activity activity;
    private String zipFile;
    private String _location;
    private Object object;
    private String id;
    private boolean unzip;
    private ZipListener zipListener;

    public ZipUtil (Activity activity){
        this.activity = activity;
    }

    public ZipUtil unZipInit(String zipFile, String _location, Object object, String id){
        this.zipFile = zipFile;
        this._location = _location;
        this.object = object;
        this.id = id;
        unzip = true;
        return this;
    }

    public ZipUtil setZipListener(ZipListener zipListener){
        this.zipListener = zipListener;
        return this;
    }

    public ZipUtil run(){

        if(null == zipFile || null == _location){
            return this;
        }

        try  {
            FileInputStream fin = new FileInputStream(zipFile);
            ZipInputStream zin = new ZipInputStream(fin);
            ZipEntry ze = null;

            if(null != zipListener){
                zipListener.onStart(id);
            }


            while ((ze = zin.getNextEntry()) != null) {
                Log.v("Decompress", "Unzipping " + ze.getName());   //압축이 풀리면서 logcat으로 zip 안에 있던 파일      들을 볼 수 있습니다.
                if(ze.isDirectory()) {
                    _dirChecker(ze.getName());
                } else {
                    Log.v("Decompress", "Unzipping =" + _location +"!   ze.getName() = "+ ze.getName());
                    /*서버에서 /data/video/file/286/image/01.png 이렇게 주기때문에 변경*/
                    String replacePathFile = _location + ze.getName().replace("/data/video/file/", "");
                    String replacePath = replacePathFile.substring(0, replacePathFile.lastIndexOf("/"));
                    FileUtil.makeDirectory(replacePath);

                    FileOutputStream out = new FileOutputStream(replacePathFile, false);
                    BufferedInputStream in = new BufferedInputStream(zin);  //이렇게 지정하지 않고 unzip을수행하면 속도가 매우 느려 집니다.
//                    FileOutputStream out = new FileOutputStream(unzipFile, false);
//                    BufferedOutputStream fout = new BufferedOutputStream(out, 1024* 8);
//                    try {
//                        for (int c = zin.read(); c != -1; c = zin.read()) {
//                            fout.write(c);
//                            zipListener.onProgress(id, object, c, ze.getSize());
//                        }
//                        zin.closeEntry();
//                    }
//                    finally {
//                        fout.close();
//                    }

                    BufferedOutputStream bout = new BufferedOutputStream(out);
                    byte [] b = new byte[1024];
                    int n;
                    while ((n = in.read(b,0,1024)) != -1 ){
                        bout.write(b, 0 , n);
                        if(null != zipListener){
                            zipListener.onProgress(id, object, n, ze.getSize());
                        }
                    }
                    zin.closeEntry();
                    bout.close();
                 }

            }
            zin.close();
            if(null != zipListener){
                zipListener.onComplete(id, _location);
            }

        } catch(Exception e) {
            if(null != zipListener){
                zipListener.onException(id,e);
            }
        }

        return this;
    }

    private void _dirChecker(String dir) {
        File f = new File(_location + dir);

        if(!f.isDirectory()) {
            f.mkdirs();
        }
    }

    public interface ZipListener{
        void onStart(String id);
        void onProgress(String id, Object object, long readBytes, long contentTotalBytes);
        void onException(String id, Exception e);
        void onComplete(String id, String _location);
    }
}