package cn.white.ymc.wanandroidmaster.ui.wx.wxdetail;

import cn.white.ymc.wanandroidmaster.base.contract.BasePre;
import cn.white.ymc.wanandroidmaster.base.contract.BaseView;
import cn.white.ymc.wanandroidmaster.data.bean.WxPublicListBean;
import cn.white.ymc.wanandroidmaster.ui.mine.minelist.wx.wxpublic.WxPublicContract;

/**
 * @packageName: cn.white.ymc.wanandroidmaster.ui.wx.wxdetail
 * @fileName: WxDetailContract
 * @date: 2018/11/1  16:41
 * @author: ymc
 * @QQ:745612618
 */

public class WxDetailContract {

    interface View extends BaseView{

        void getWxPublicListOk(WxPublicListBean bean, boolean hasRefresh);

        void getWxPublicErr(String err);

    }

    interface Presenter extends BasePre<View> {

        void onRefresh();

        void onLoadMore();

        void getWxPublicListResult(int id,int page);

    }
}
