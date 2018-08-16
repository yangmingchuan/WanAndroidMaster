package cn.white.ymc.wanandroidmaster.ui.demo;

import java.util.List;

import cn.white.ymc.wanandroidmaster.base.contract.BasePre;
import cn.white.ymc.wanandroidmaster.base.contract.BaseView;
import cn.white.ymc.wanandroidmaster.data.bean.DemoBean;

/**
 * @packageName: cn.white.ymc.wanandroidmaster.ui.demo
 * @fileName: DemoContract
 * @date: 2018/8/16  17:13
 * @author: ymc
 * @QQ:745612618
 */

public class DemoContract {

    public interface View extends BaseView{

        void getDemoResultOK(List<DemoBean> demoBeans);

        void getDemoResultErr(String info);
    }

    public interface Presenter extends BasePre<View>{

        void getDemoList();

    }

}
