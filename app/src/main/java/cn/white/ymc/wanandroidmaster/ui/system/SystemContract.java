package cn.white.ymc.wanandroidmaster.ui.system;

import java.util.List;

import cn.white.ymc.wanandroidmaster.base.contract.BasePre;
import cn.white.ymc.wanandroidmaster.base.contract.BaseView;
import cn.white.ymc.wanandroidmaster.data.bean.SystemBean;

/**
 *  接口契约类
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.fragment.system
 * @fileName: SystemContract
 * @date: 2018/8/13  13:33
 * @author: ymc
 * @QQ:745612618
 */

public class SystemContract {

    interface View extends BaseView{

        void getKnowledgeListOk(List<SystemBean> dataBean);

        void getKnowledgeListErr(String info);
    }

    interface Presenter extends BasePre<View>{

        void autoRefresh();

        void getKnowledgeList();

    }

}
