package cn.white.ymc.wanandroidmaster.ui.demo;

import java.util.List;

import cn.white.ymc.wanandroidmaster.base.contract.BasePresenter;
import cn.white.ymc.wanandroidmaster.data.BaseResp;
import cn.white.ymc.wanandroidmaster.data.bean.DemoTitleBean;
import cn.white.ymc.wanandroidmaster.model.ApiService;
import cn.white.ymc.wanandroidmaster.model.ApiStore;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 项目 presenter 层
 *
 * Created by yangmingchuan on 2018/8/16.
 * Email:18768880074@163.com
 * cn.white.ymc.wanandroidmaster.ui.demo
 */

public class DemoPresenter extends BasePresenter<DemoContract.View> implements DemoContract.Presenter {

    private DemoContract.View view;

    public DemoPresenter(DemoContract.View view) {
        this.view = view;
    }

    @Override
    public void getDemoTitleList() {
        ApiStore.createApi(ApiService.class)
                .getDemoTitleList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<List<DemoTitleBean>>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.getDemoResultErr(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseResp<List<DemoTitleBean>> listBaseResp) {
                        if(listBaseResp.getErrorCode() == ConstantUtil.REQUEST_SUCCESS){
                            view.getDemoResultOK(listBaseResp.getData());
                        }else if(listBaseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR){
                            view.getDemoResultErr(listBaseResp.getErrorMsg());
                        }
                    }
                });
    }
}
