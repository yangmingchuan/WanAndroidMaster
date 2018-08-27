package cn.white.ymc.wanandroidmaster.ui.home.search;

import android.content.Context;

import java.util.List;

import cn.white.ymc.wanandroidmaster.base.contract.BasePre;
import cn.white.ymc.wanandroidmaster.base.contract.BaseView;
import cn.white.ymc.wanandroidmaster.data.bean.HotBean;
import cn.white.ymc.wanandroidmaster.data.bean.HotKeyBean;

/**
 *  搜索 界面契约类
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.home.search
 * @fileName: SearechContract
 * @date: 2018/8/24  15:24
 * @author: ymc
 * @QQ:745612618
 */

public class SearechContract {

    public interface View extends BaseView{

        void getHotListOk(List<HotKeyBean> beanList);

        void getHotListErr(String err);

    }

    public interface Presenter extends BasePre<View> {

        void getHotListResult();

        void saveHistory(Context context, List<String> historyList);

        void getHistoryList(Context context, List<String> historyList);

    }

}
