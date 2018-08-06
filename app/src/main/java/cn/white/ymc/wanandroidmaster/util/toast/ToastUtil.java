package cn.white.ymc.wanandroidmaster.util.toast;

/**
 * Created by Administrator on 2017/4/17.
 */

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Toast统一管理类
 */
public class ToastUtil {

    private ToastUtil() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isShow = true;

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showShort(Context context, CharSequence message) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 短时间显示Toast
     *Mai
     * @param context
     * @param message
     */
    public static void showShortCenter(Context context, CharSequence message) {
        if (isShow){
            message = "\b\b"+message+"\b\b";
            Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
    }

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showShort(Context context, int message) {
        if (isShow){
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, CharSequence message) {
        if (isShow){
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, int message) {
        if (isShow){
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, CharSequence message, int duration) {
        if (isShow){
            Toast.makeText(context, message, duration).show();
        }
    }

    public static void show(Context context, CharSequence message) {
        if (isShow){
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, int message, int duration) {
        if (isShow){
            Toast.makeText(context, message, duration).show();
        }
    }

}