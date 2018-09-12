package cn.white.ymc.wanandroidmaster.ui.mine.minelist;

import cn.white.ymc.wanandroidmaster.base.contract.BasePresenter;
import cn.white.ymc.wanandroidmaster.data.BaseResp;
import cn.white.ymc.wanandroidmaster.data.bean.CollectBean;
import cn.white.ymc.wanandroidmaster.model.ApiService;
import cn.white.ymc.wanandroidmaster.model.ApiStore;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 我的收藏列表 presenter 层
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.mine.minelist
 * @fileName: CollectionListPresenter
 * @date: 2018/8/23  13:54
 * @author: ymc
 * @QQ:745612618
 */

public class CollectionListPresenter extends BasePresenter<CollectionListContract.View> implements CollectionListContract.Presenter{

    private CollectionListContract.View view;
    private int currentPage;
    private boolean hasRefresh = true;

    public CollectionListPresenter(CollectionListContract.View view) {
        this.view = view;
    }

    @Override
    public void onRefresh() {
        hasRefresh = true;
        getCollectionList(0);
    }

    @Override
    public void onLoadMore() {
        hasRefresh = false;
        currentPage ++;
        getCollectionList(currentPage);
    }

    @Override
    public void getCollectionList(int page) {
        this.currentPage = page;
        ApiStore.createApi(ApiService.class)
                .getCollectionList(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<CollectBean>>() {
                    @Override
                    public void onError(Throwable e) {
                        view.getCollectionListErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResp<CollectBean> listBaseResp) {
                        if(listBaseResp.getErrorCode() == ConstantUtil.REQUEST_SUCCESS){
                            view.getCollectionListOK(listBaseResp.getData(),hasRefresh);
                        }else if(listBaseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR){
                            view.getCollectionListErr(listBaseResp.getErrorMsg());
                        }
                    }
                });
    }
}
