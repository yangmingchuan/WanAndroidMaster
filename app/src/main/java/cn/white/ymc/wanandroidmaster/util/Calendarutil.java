package cn.white.ymc.wanandroidmaster.util;

import java.util.Calendar;

/**
 * Created by yangmingchuan on 2020/4/6.
 * Email:18768880074@163.com
 * cn.white.ymc.wanandroidmaster.util
 */
public class Calendarutil {
    private static final int QING_MING_MONTH = 3;
    private static final int QING_MING_DAY = 4;

    public static boolean isQingMing(){
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        if(month==QING_MING_MONTH && day == QING_MING_DAY){
            return true;
        }
        return false;
    }
}
