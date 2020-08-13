package cn.white.ymc.wanandroidmaster.ui.mine;

import cn.white.ymc.wanandroidmaster.base.contract.BasePresenter;
import cn.white.ymc.wanandroidmaster.data.BaseResp;
import cn.white.ymc.wanandroidmaster.data.bean.IntegralBean;
import cn.white.ymc.wanandroidmaster.model.ApiService;
import cn.white.ymc.wanandroidmaster.model.ApiStore;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Author : ymc
 * Date   : 2020/8/13  17:30
 * Class  : MinePresenter
 */
public class MinePresenter extends BasePresenter<MineContract.View> implements MineContract.Presenter{

    private MineContract.View view;

    public MinePresenter(MineContract.View view) {
        this.view = view;
    }

    @Override
    public void getUserIntegral() {
        ApiStore.createApi(ApiService.class)
                .getUserIntegral()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<IntegralBean>>() {
                    @Override
                    public void onError(Throwable e) {
                        view.getIntegralResultErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResp<IntegralBean> listBaseResp) {
                        if(listBaseResp.getErrorCode() == ConstantUtil.REQUEST_SUCCESS){
                            view.getIntegralResultOK(listBaseResp.getData());
                        }else if(listBaseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR){
                            view.getIntegralResultErr(listBaseResp.getErrorMsg());
                        }
                    }
                });
    }


}
