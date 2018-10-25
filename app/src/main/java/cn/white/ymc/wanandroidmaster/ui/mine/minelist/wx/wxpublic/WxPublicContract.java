package cn.white.ymc.wanandroidmaster.ui.mine.minelist.wx.wxpublic;

import cn.white.ymc.wanandroidmaster.base.contract.BasePre;
import cn.white.ymc.wanandroidmaster.base.contract.BaseView;
import cn.white.ymc.wanandroidmaster.data.bean.WxPublicListBean;

/**
 * 微信公众号 契约类
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.mine.minelist.wx.wxpublic
 * @fileName: WxPublicContract
 * @date: 2018/10/24  16:47
 * @author: ymc
 * @QQ:745612618
 */

public class WxPublicContract {

    interface View extends BaseView{

        void getWxPublicListOk(WxPublicListBean bean,boolean hasRefresh);

        void getWxPublicErr(String err);

    }

    interface Presenter extends BasePre<View>{

        void onRefresh();

        void onLoadMore();

        void getWxPublicListResult(int id,int page);

    }

}
