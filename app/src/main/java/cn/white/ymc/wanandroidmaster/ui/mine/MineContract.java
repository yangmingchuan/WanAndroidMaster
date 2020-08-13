package cn.white.ymc.wanandroidmaster.ui.mine;

import cn.white.ymc.wanandroidmaster.base.contract.BasePre;
import cn.white.ymc.wanandroidmaster.base.contract.BaseView;
import cn.white.ymc.wanandroidmaster.data.bean.IntegralBean;

/**
 * Author : ymc
 * Date   : 2020/8/13  17:26
 * Class  : MineContract
 */
public class MineContract {

    public interface View extends BaseView {

        void getIntegralResultOK(IntegralBean demoBeans);

        void getIntegralResultErr(String info);
    }

    public interface Presenter extends BasePre<MineContract.View> {

        void getUserIntegral();

    }

}
