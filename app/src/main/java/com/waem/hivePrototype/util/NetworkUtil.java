package com.waem.hivePrototype.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {

    public static boolean isWiFiMode(Context context) {
        return getNetworkStatus(context) == ConnectivityManager.TYPE_WIFI;
    }

    public static boolean isDataNetworkMode(Context context) {
        return getNetworkStatus(context) == ConnectivityManager.TYPE_MOBILE;
    }

    public static boolean isNoConnectivity(Context context) {
        int status = getNetworkStatus(context);
        return !(status == ConnectivityManager.TYPE_WIFI || status == ConnectivityManager.TYPE_MOBILE);
    }

    private static int getNetworkStatus(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = cm.getActiveNetworkInfo();

        if (network != null) {
            return network.getType();
        }

        return -1;
    }
}
