package cn.white.ymc.wanandroidmaster.ui.home.search.searechdetail;

import cn.white.ymc.wanandroidmaster.base.contract.BasePresenter;
import cn.white.ymc.wanandroidmaster.data.BaseResp;
import cn.white.ymc.wanandroidmaster.data.bean.HomePageArticleBean;
import cn.white.ymc.wanandroidmaster.model.ApiService;
import cn.white.ymc.wanandroidmaster.model.ApiStore;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 搜索详情界面
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.home.search.searechdetail
 * @fileName: SearechDetailPresenter
 * @date: 2018/8/28  13:14
 * @author: ymc
 * @QQ:745612618
 */

public class SearechDetailPresenter extends BasePresenter<SearechDetailContract.View> implements
        SearechDetailContract.Presenter {

    private SearechDetailContract.View view;

    private int currentPage;

    private boolean hasRefresh = true;

    public SearechDetailPresenter(SearechDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void autoRefresh(String key) {
        hasRefresh = true;
        currentPage  = 0;
        getSearechResult(currentPage,key);
    }

    @Override
    public void loadMore(String key) {
        hasRefresh = false;
        currentPage ++;
        getSearechResult(0,key);
    }

    @Override
    public void getSearechResult(int page, String key) {
        this.currentPage = page;
        ApiStore.createApi(ApiService.class)
                .getSearechResult(page, key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<HomePageArticleBean>>() {
                    @Override
                    public void onError(Throwable e) {
                        view.getSearechResultErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResp<HomePageArticleBean> listBaseResp) {
                        if (listBaseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR) {
                            view.getSearechResultErr(listBaseResp.getErrorMsg());
                        } else if (listBaseResp.getErrorCode() == ConstantUtil.REQUEST_SUCCESS) {
                            view.getSearechResultOk(listBaseResp.getData(), hasRefresh);
                        }
                    }
                });
    }

}
