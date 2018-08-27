package cn.white.ymc.wanandroidmaster.ui.home.search;

import android.content.Context;

import java.util.List;

/**
 *  搜索记录 model 契约
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.home.search
 * @fileName: ISearechModelImpl
 * @date: 2018/8/27  14:27
 * @author: ymc
 * @QQ:745612618
 */

public interface ISearechModelImpl {

    void  saveHistory(Context context, List<String> historyList);

    void  getHistory(Context context, List<String> historyList );

    interface ISearechGetResult {

        void getHistoryOk(List<String> historyList);

    }

}
