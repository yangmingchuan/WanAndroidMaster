package cn.white.ymc.wanandroidmaster.ui.demo.demolist;

import cn.white.ymc.wanandroidmaster.base.contract.BasePresenter;
import cn.white.ymc.wanandroidmaster.data.BaseResp;
import cn.white.ymc.wanandroidmaster.data.bean.DemoDetailListBean;
import cn.white.ymc.wanandroidmaster.model.ApiService;
import cn.white.ymc.wanandroidmaster.model.ApiStore;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 项目
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.demo.demolist
 * @fileName: DemoDetailListPresenter
 * @date: 2018/8/17  13:02
 * @author: ymc
 * @QQ:745612618
 */

public class DemoDetailListPresenter extends BasePresenter<DemoDetailListContract.View> implements
            DemoDetailListContract.Presenter{

    DemoDetailListContract.View view;

    private int id = -1;
    private int page;
    private boolean isRefresh = true;

    public DemoDetailListPresenter(DemoDetailListContract.View view) {
        this.view = view;
    }

    /**
     * 获取项目 详细信息列表
     * @param page
     * @param id
     */
    @Override
    public void getDemoList(int page, int id) {
        this.id = id;
        this.page = page;
        ApiStore.createApi(ApiService.class)
                .getDemoDetailList(page,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<DemoDetailListBean>>() {
                    @Override
                    public void onError(Throwable e) {
                        view.getDemoListErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResp<DemoDetailListBean> listBaseResp) {
                        if(listBaseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR){
                            view.getDemoListErr(listBaseResp.getErrorMsg());
                        }else if(listBaseResp.getErrorCode() == ConstantUtil.REQUEST_SUCCESS){
                            view.getDemoListOK(listBaseResp.getData(),isRefresh);
                        }
                    }
                });

    }

    @Override
    public void autoRefresh() {
        isRefresh = true;
        page = 1;
        if(id!=-1){
            getDemoList(page,id);
        }
    }

    @Override
    public void loadMore() {
        isRefresh = false;
        page++;
        if(id!=-1){
            getDemoList(page,id);
        }
    }
}
