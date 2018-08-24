package cn.white.ymc.wanandroidmaster.ui.home.hot;

import java.util.List;
import cn.white.ymc.wanandroidmaster.base.contract.BasePresenter;
import cn.white.ymc.wanandroidmaster.data.BaseResp;
import cn.white.ymc.wanandroidmaster.data.bean.HotBean;
import cn.white.ymc.wanandroidmaster.model.ApiService;
import cn.white.ymc.wanandroidmaster.model.ApiStore;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 最热网站 presenter 层 实现
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.home.hot
 * @fileName: HotPresenter
 * @date: 2018/8/24  13:42
 * @author: ymc
 * @QQ:745612618
 */

public class HotPresenter extends BasePresenter<HotContract.View> implements HotContract.Presenter {

    private HotContract.View view;

    public HotPresenter(HotContract.View view) {
        this.view = view;
    }

    @Override
    public void getHotList() {
        ApiStore.createApi(ApiService.class)
                .getHotList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<List<HotBean>>>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                        view.getHotResultErr(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseResp<List<HotBean>> listBaseResp) {
                        if(listBaseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR){
                            view.getHotResultErr(listBaseResp.getErrorMsg());
                        }else if(listBaseResp.getErrorCode() == ConstantUtil.REQUEST_SUCCESS){
                            view.getHotResultOK(listBaseResp.getData());
                        }
                    }
                });
    }
}
