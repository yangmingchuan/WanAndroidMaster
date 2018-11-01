package cn.white.ymc.wanandroidmaster.ui.wx.wxdetail;


import cn.white.ymc.wanandroidmaster.base.contract.BasePresenter;

/**
 * 微信公众号详情列表 presenter
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.wx.wxdetail
 * @fileName: WxDetailPresenter
 * @date: 2018/11/1  17:15
 * @author: ymc
 * @QQ:745612618
 */

public class WxDetailPresenter extends BasePresenter<WxDetailContract.View> implements WxDetailContract.Presenter{

    private WxDetailContract.View view;

    public WxDetailPresenter(WxDetailContract.View view) {
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
