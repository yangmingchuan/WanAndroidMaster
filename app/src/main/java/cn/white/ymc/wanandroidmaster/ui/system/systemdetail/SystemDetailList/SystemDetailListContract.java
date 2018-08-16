package cn.white.ymc.wanandroidmaster.ui.system.systemdetail.SystemDetailList;

import cn.white.ymc.wanandroidmaster.base.contract.BasePre;
import cn.white.ymc.wanandroidmaster.base.contract.BaseView;
import cn.white.ymc.wanandroidmaster.data.bean.SystemDetailListBean;

/**
 * 体系二级 列表 契约类
 * Created by yangmingchuan on 2018/8/15.
 * Email:18768880074@163.com
 * cn.white.ymc.wanandroidmaster.ui.system.systemdetail.SystemDetailList
 */

public class SystemDetailListContract {

    public interface View extends BaseView{
        /**
         * 获取 体系 二级 数据成功
         * @param systemDetailListBean
         * @param isRefresh
         */
        void getSystemDetailListResultOK(SystemDetailListBean systemDetailListBean ,boolean isRefresh);

        /**
         * 获取 数据失败
         * @param info
         */
        void getSystemDetailListResultErr(String info);
    }

    public interface Presenter extends BasePre<View>{

        void autoRefresh();

        void loadMore();

        void getSystemDetailList(int page,int id);
    }

}
