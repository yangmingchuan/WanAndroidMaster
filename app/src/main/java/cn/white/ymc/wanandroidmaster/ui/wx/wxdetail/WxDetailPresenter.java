package cn.white.ymc.wanandroidmaster.ui.wx.wxdetail;


import cn.white.ymc.wanandroidmaster.base.contract.BasePresenter;
import cn.white.ymc.wanandroidmaster.data.BaseResp;
import cn.white.ymc.wanandroidmaster.data.bean.DemoDetailListBean;
import cn.white.ymc.wanandroidmaster.data.bean.WxPublicListBean;
import cn.white.ymc.wanandroidmaster.model.ApiService;
import cn.white.ymc.wanandroidmaster.model.ApiStore;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
    private int wxId = -1;
    private int wxPage = -1;
    private boolean isRefresh = true;

    public WxDetailPresenter(WxDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void onRefresh() {
        isRefresh = true;
        if(wxId !=-1 && wxPage != -1){
            getWxPublicListResult(wxId,1);
        }
    }

    @Override
    public void onLoadMore() {
        isRefresh = false;
        if(wxId !=-1 && wxPage != -1){
            wxPage ++;
            getWxPublicListResult(wxId,wxPage);
        }
    }

    @Override
    public void getWxPublicListResult(int id, int page) {
        this.wxId = id;
        this.wxPage = page;
        ApiStore.createApi(ApiService.class)
                .getWXDetailList(page,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<WxPublicListBean>>() {
                    @Override
                    public void onError(Throwable e) {
                        view.getWxPublicErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(BaseResp<WxPublicListBean> datasBeanBaseResp) {
                        if(datasBeanBaseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR){
                            view.getWxPublicErr(datasBeanBaseResp.getErrorMsg());
                        }else if(datasBeanBaseResp.getErrorCode() == ConstantUtil.REQUEST_SUCCESS){
                            view.getWxPublicListOk(datasBeanBaseResp.getData(),isRefresh);
                        }
                    }

                });
    }
}
