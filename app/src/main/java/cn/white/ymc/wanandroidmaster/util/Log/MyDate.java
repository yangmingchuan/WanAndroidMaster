package cn.white.ymc.wanandroidmaster.util.Log;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * 2018年7月19日 15:29:18
 */

class MyDate {
    static String getFileName() {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date(System.currentTimeMillis()));
    }

    static String getDateEN() {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format1.format(new Date(System.currentTimeMillis()));
    }
}
