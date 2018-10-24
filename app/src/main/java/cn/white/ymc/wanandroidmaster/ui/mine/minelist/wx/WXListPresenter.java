package cn.white.ymc.wanandroidmaster.ui.mine.minelist.wx;

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
 *  微信列表获取
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.mine.minelist.wx
 * @fileName: WXListPresenter
 * @date: 2018/10/24  14:05
 * @author: ymc
 * @QQ:745612618
 */

public class WXListPresenter extends BasePresenter<WXListContract.view> implements WXListContract.presenter {

    private WXListContract.view view;

    public WXListPresenter(WXListContract.view view) {
        this.view = view;
    }

    @Override
    public void getWXList() {
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
                            view.getWXListResultOk(listBaseResp.data);
                        }else if(listBaseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR){
                            view.getWXListErr(listBaseResp.getErrorMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.getWXListErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
