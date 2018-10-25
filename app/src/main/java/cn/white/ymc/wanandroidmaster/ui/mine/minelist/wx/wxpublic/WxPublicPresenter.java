package cn.white.ymc.wanandroidmaster.ui.mine.minelist.wx.wxpublic;

import cn.white.ymc.wanandroidmaster.base.contract.BasePresenter;

/**
 * 微信文章 presenter层
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.mine.minelist.wx.wxpublic
 * @fileName: WxPublicPresenter
 * @date: 2018/10/24  16:47
 * @author: ymc
 * @QQ:745612618
 */

public class WxPublicPresenter extends BasePresenter<WxPublicContract.View> implements WxPublicContract.Presenter{

    private WxPublicContract.View view;

    public WxPublicPresenter(WxPublicContract.View view) {
        this.view = view;
    }

    @Override
    public void onRefresh() {
    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void getWxPublicListResult(int id, int page) {

    }
}
