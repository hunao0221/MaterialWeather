package com.hugo.materialweather.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * @auther Hugo
 * Created on 2016/4/17 20:39.
 */
public class CheckUpdate {

    /*
    * 获得本地版本号*/
    public static String getVersionName(Context context) {
        //首先拿到packageManager对象
        PackageManager packageManager = context.getPackageManager();
        try {
            //获取PackageInfo
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            //获得版本号
            String mVersionName = packageInfo.versionName;
            int mVersionCode = packageInfo.versionCode;
            return mVersionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
