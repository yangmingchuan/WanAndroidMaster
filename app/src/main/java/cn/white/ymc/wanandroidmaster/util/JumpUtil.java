package cn.white.ymc.wanandroidmaster.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * 界面跳转 工具类
 *
 * @packageName: cn.white.ymc.wanandroidmaster.util
 * @fileName: JumpUtil
 * @date: 2018/7/20  17:17
 * @author: ymc
 * @QQ:745612618
 */

public class JumpUtil {

    /**
     * 不带参数的跳转
     *
     * @param context
     * @param targetClazz
     */
    public static void overlay(Context context, Class<? extends Activity> targetClazz) {
        Intent mIntent = new Intent(context, targetClazz);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(mIntent);
    }

    /**
     * 带参数不带动画的跳转
     *
     * @param context
     * @param targetClazz
     * @param bundle
     */
    public static void overlay(Context context, Class<? extends Activity> targetClazz, Bundle bundle) {
        Intent mIntent = new Intent(context, targetClazz);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (bundle != null) {
            mIntent.putExtras(bundle);
        }
        context.startActivity(mIntent);
    }

    /**
     * 带参数,共享元素跳转
     *
     * @param context
     * @param targetClazz
     * @param bundle
     */
    public static void overlay(Context context, Class<? extends Activity> targetClazz, Bundle bundle, Bundle options) {
        Intent mIntent = new Intent(context, targetClazz);
        if (bundle != null) {
            mIntent.putExtras(bundle);
        }
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(mIntent, options);
    }

    /**
     *
     *
     * @param context
     * @param targetClazz
     * @param bundle
     * @param flags
     */
    public static void overlay(Context context, Class<? extends Activity> targetClazz, Bundle bundle, Integer flags) {
        Intent mIntent = new Intent(context, targetClazz);
        if (bundle != null) {
            mIntent.putExtras(bundle);
        }
        if (flags != null) {
            mIntent.setFlags(flags);
        }
        context.startActivity(mIntent);
    }


    /**
     * 界面跳转带 result
     *
     * @param context
     * @param targetClazz
     * @param requestCode
     * @param bundle
     */
    public static void startForResult(Activity context, Class<? extends Activity> targetClazz, int requestCode, Bundle bundle) {
        Intent mIntent = new Intent(context, targetClazz);
        if (bundle != null) {
            mIntent.putExtras(bundle);
        }
        context.startActivityForResult(mIntent, requestCode);
    }

    /**
     * fragment 界面跳转 带result
     *
     * @param fragment
     * @param targetClazz
     * @param requestCode
     * @param bundle
     */
    public static void startForResult(Fragment fragment, Class<? extends Activity> targetClazz, int requestCode, Bundle bundle) {
        Intent mIntent = new Intent(fragment.getActivity(), targetClazz);
        if (bundle != null) {
            mIntent.putExtras(bundle);
        }
        fragment.startActivityForResult(mIntent, requestCode);
    }

}
