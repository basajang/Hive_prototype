package com.waem.hivePrototype.util;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

/**
 * 사용자 관련 메서드
 */
public class UserUtil {

    /**
     * password 난독화 시키는 메서드
     * @param text
     * @return
     */
    public static String encodePassword(String text) {
        String encodePass = "";
        try {
            encodePass = Base64.encodeToString(String.format("%s",
                    text).getBytes("UTF-8"),
                    Base64.NO_WRAP | Base64.NO_PADDING | Base64.URL_SAFE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            encodePass = text;
        }
        return encodePass;
    }
}