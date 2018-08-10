package cn.white.ymc.wanandroidmaster.ui.home.homedetail;

import cn.white.ymc.wanandroidmaster.base.contract.BasePresenter;
import cn.white.ymc.wanandroidmaster.data.BaseResp;
import cn.white.ymc.wanandroidmaster.model.ApiService;
import cn.white.ymc.wanandroidmaster.model.ApiStore;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 首页详细界面 presenter 层
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.home.homedetail
 * @fileName: HomePresenter
 * @date: 2018/8/10  13:16
 * @author: ymc
 * @QQ:745612618
 */

public class HomeDetailPresenter extends BasePresenter<HomeDetailContract.view> implements HomeDetailContract.presenter {

    private HomeDetailContract.view view;

    public HomeDetailPresenter(HomeDetailContract.view view) {
        this.view = view;
    }

    /**
     * 收藏文章
     * @param id
     */
    @Override
    public void collectArticle(int id) {
        ApiStore.createApi(ApiService.class)
                .collectArticle(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                        view.collectArticleErr(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseResp baseResp) {
                        if(baseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR){
                            view.collectArticleErr(baseResp.getErrorMsg());
                        }else if(baseResp.getErrorCode() == ConstantUtil.REQUEST_SUCCESS){
                            view.collectArticleOK((String) baseResp.getData());
                        }
                    }
                });
    }

    /**
     * 取消收藏文章
     * @param id
     */
    @Override
    public void cancelCollectArticle(int id) {
        ApiStore.createApi(ApiService.class)
                .cancelCollectArticle(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                        view.cancelCollectArticleErr(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseResp baseResp) {
                        if(baseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR){
                            view.cancelCollectArticleErr(baseResp.getErrorMsg());
                        }else if(baseResp.getErrorCode() == ConstantUtil.REQUEST_SUCCESS){
                            view.cancelCollectArticleOK((String) baseResp.getData());
                        }
                    }
                });
    }
}
