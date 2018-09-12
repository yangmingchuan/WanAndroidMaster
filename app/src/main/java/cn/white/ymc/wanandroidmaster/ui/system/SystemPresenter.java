package cn.white.ymc.wanandroidmaster.ui.system;

import java.util.List;

import cn.white.ymc.wanandroidmaster.base.contract.BasePresenter;
import cn.white.ymc.wanandroidmaster.data.BaseResp;
import cn.white.ymc.wanandroidmaster.data.bean.SystemBean;
import cn.white.ymc.wanandroidmaster.model.ApiService;
import cn.white.ymc.wanandroidmaster.model.ApiStore;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 体系 presenter 层
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.fragment.system
 * @fileName: SystemPresenter
 * @date: 2018/8/13  13:52
 * @author: ymc
 * @QQ:745612618
 */

public class SystemPresenter extends BasePresenter<SystemContract.View> implements SystemContract.Presenter {

    private SystemContract.View view;

    public SystemPresenter(SystemContract.View view) {
        this.view = view;
    }

    @Override
    public void autoRefresh() {
        getSystemList();
    }

    @Override
    public void getSystemList() {
        ApiStore.createApi(ApiService.class)
                .getSystemList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<List<SystemBean>>>() {
                    @Override
                    public void onError(Throwable e) {
                        view.getSystemListErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResp<List<SystemBean>> listBaseResp) {
                        if (listBaseResp.getErrorCode() == ConstantUtil.REQUEST_SUCCESS) {
                            view.getSystemListOk(listBaseResp.getData());
                        } else if (listBaseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR) {
                            view.getSystemListErr(listBaseResp.getErrorMsg());
                        }
                    }
                });
    }

}
