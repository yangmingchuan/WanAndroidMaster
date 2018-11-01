package cn.white.ymc.wanandroidmaster.ui.wx;

import java.util.List;

import cn.white.ymc.wanandroidmaster.base.contract.BasePresenter;
import cn.white.ymc.wanandroidmaster.data.BaseResp;
import cn.white.ymc.wanandroidmaster.data.bean.WxListBean;
import cn.white.ymc.wanandroidmaster.model.ApiService;
import cn.white.ymc.wanandroidmaster.model.ApiStore;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 微信公众号 presenter
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.wx
 * @fileName: WxPresenter
 * @date: 2018/11/1  15:46
 * @author: ymc
 * @QQ:745612618
 */

public class WxPresenter extends BasePresenter<WxContract.View> implements WxContract.Presenter{

    private WxContract.View view;

    public WxPresenter(WxContract.View view) {
        this.view = view;
    }

    @Override
    public void getWxTitleList() {
        ApiStore.createApi(ApiService.class)
                .getWXList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<List<WxListBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(BaseResp<List<WxListBean>> listBaseResp) {
                        if(listBaseResp.getErrorCode() == ConstantUtil.REQUEST_SUCCESS){
                            view.getWxResultOK(listBaseResp.data);
                        }else if(listBaseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR){
                            view.getWxResultErr(listBaseResp.getErrorMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.getWxResultErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
