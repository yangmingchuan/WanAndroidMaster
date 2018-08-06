package cn.white.ymc.wanandroidmaster.util;

import android.annotation.SuppressLint;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;

import java.lang.reflect.Field;

/**
 * 通过反射 修改 bottomnavigation 的 shiftMode
 * ( ShiftingMode，通过查看源码发现，只要 Item 的数量达到 4 个的时候，就会开启 ShiftingMode。)
 *
 * @packageName: cn.white.ymc.wanandroidmaster.util
 * @fileName: BottomNavigationViewHepler
 * @date: 2018/7/23  11:12
 * @author: ymc
 * @QQ:745612618
 */

public class BottomNavigationViewHelper {
    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e) {
        }
    }
}
