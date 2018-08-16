package cn.white.ymc.wanandroidmaster.ui.system.systemdetail.SystemDetailList;

import cn.white.ymc.wanandroidmaster.base.contract.BasePresenter;
import cn.white.ymc.wanandroidmaster.data.BaseResp;
import cn.white.ymc.wanandroidmaster.data.bean.SystemDetailListBean;
import cn.white.ymc.wanandroidmaster.model.ApiService;
import cn.white.ymc.wanandroidmaster.model.ApiStore;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 体系 二级 列表 presenter 层
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.system.systemdetail.SystemDetailList
 * @fileName: SystemDetailListPresenter
 * @date: 2018/8/16  10:00
 * @author: ymc
 * @QQ:745612618
 */

public class SystemDetailListPresenter extends BasePresenter<SystemDetailListContract.View>
        implements SystemDetailListContract.Presenter{

    private SystemDetailListContract.View view;
    private int currentPage;
    private int id = -1;
    private boolean isRefresh = true;

    public SystemDetailListPresenter(SystemDetailListContract.View view) {
        this.view = view;
    }

    @Override
    public void autoRefresh() {
        isRefresh = true;
        if(id!=-1){
            currentPage = 0;
            getSystemDetailList(currentPage,id);
        }
    }

    @Override
    public void loadMore() {
        isRefresh = false;
        if(id!=-1) {
            currentPage++;
            getSystemDetailList(currentPage, id);
        }
    }

    @Override
    public void getSystemDetailList(int page, int id) {
        this.id = id;
        this.currentPage = page;
        ApiStore.createApi(ApiService.class)
                .getSystemDetailList(page,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<SystemDetailListBean>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.getSystemDetailListResultErr(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseResp<SystemDetailListBean> systemDetailListBeanBaseResp) {
                        if(systemDetailListBeanBaseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR){
                            view.getSystemDetailListResultErr(systemDetailListBeanBaseResp.getErrorMsg());
                        }else if(systemDetailListBeanBaseResp.getErrorCode() == ConstantUtil.REQUEST_SUCCESS){
                            view.getSystemDetailListResultOK(systemDetailListBeanBaseResp.getData(),isRefresh);
                        }
                    }
                });
    }
}
