package cn.white.ymc.wanandroidmaster.ui.home.search;

import android.content.Context;

import java.util.Arrays;
import java.util.List;

import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import cn.white.ymc.wanandroidmaster.util.SharedPreferenceUtil;

/**
 * 搜索记录 model 层
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.home.search
 * @fileName: SearechModel
 * @date: 2018/8/27  14:26
 * @author: ymc
 * @QQ:745612618
 */

public class SearechModel implements ISearechModelImpl{

    /**
     * 保存 搜索 历史
     * @param context
     * @param historyList
     */
    @Override
    public void saveHistory(Context context, List<String> historyList) {
        //保存之前先清空之前的存储
        SharedPreferenceUtil.remove(context, ConstantUtil.SEARCH_HISTORY);
        //存储
        StringBuilder sb = new StringBuilder();
        if (historyList.size() > 0) {
            for (String s : historyList) {
                sb.append(s).append(",");
            }
            sb.delete(sb.length() - 1, sb.length());
            SharedPreferenceUtil.put(ConstantUtil.SEARCH_HISTORY, sb.toString().trim());
        }
    }

    @Override
    public void getHistory(Context context, List<String> historyList) {
        historyList.clear();
        String histories = (String) SharedPreferenceUtil.get(context, ConstantUtil.SEARCH_HISTORY, ConstantUtil.DEFAULT);
        if (!histories.equals(ConstantUtil.DEFAULT)) {
            String[] history = histories.split(",");
            historyList.addAll(Arrays.asList(history));
        }
    }

}
