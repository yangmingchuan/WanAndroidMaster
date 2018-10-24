package cn.white.ymc.wanandroidmaster.ui.mine.minelist.wx;

import java.util.List;

import cn.white.ymc.wanandroidmaster.base.contract.BasePre;
import cn.white.ymc.wanandroidmaster.base.contract.BaseView;
import cn.white.ymc.wanandroidmaster.data.bean.WxListBean;

/**
 * 微信列表 契约类
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.mine.minelist.wx
 * @fileName: WXListContract
 * @date: 2018/10/24  13:52
 * @author: ymc
 * @QQ:745612618
 */

public class WXListContract {

    interface view extends BaseView{

        void getWXListResultOk(List<WxListBean> wxListBeans);

        void getWXListErr(String msg);
    }

    interface presenter extends BasePre<view>{

        void getWXList();

    }


}
