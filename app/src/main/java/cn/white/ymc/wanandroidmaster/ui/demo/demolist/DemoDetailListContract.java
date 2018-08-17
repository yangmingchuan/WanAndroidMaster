package cn.white.ymc.wanandroidmaster.ui.demo.demolist;

import java.util.List;

import cn.white.ymc.wanandroidmaster.base.contract.BasePre;
import cn.white.ymc.wanandroidmaster.base.contract.BaseView;
import cn.white.ymc.wanandroidmaster.data.bean.DemoDetailListBean;

/**
 * @packageName: cn.white.ymc.wanandroidmaster.ui.demo.demolist
 * @fileName: DemoDetailListContract
 * @date: 2018/8/17  11:05
 * @author: ymc
 * @QQ:745612618
 */

public class DemoDetailListContract {

    public interface View extends BaseView{

        /**
         * 获取 项目列表成功
         * @param beans
         * @param isRefresh
         */
        void getDemoListOK(List<DemoDetailListBean> beans, boolean isRefresh);

        /**
         * 获取 项目失败
         * @param err
         */
        void getDemoListErr(String err);
    }

    public interface Presenter extends BasePre<View>{




    }

}
