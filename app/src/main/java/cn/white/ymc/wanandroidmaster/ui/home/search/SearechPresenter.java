package cn.white.ymc.wanandroidmaster.ui.home.search;

import android.content.Context;
import java.util.List;
import cn.white.ymc.wanandroidmaster.base.contract.BasePresenter;
import cn.white.ymc.wanandroidmaster.data.BaseResp;
import cn.white.ymc.wanandroidmaster.data.bean.HotKeyBean;
import cn.white.ymc.wanandroidmaster.model.ApiService;
import cn.white.ymc.wanandroidmaster.model.ApiStore;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 搜索界面 presenter 层
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.home.search
 * @fileName: SearechPresenter
 * @date: 2018/8/24  15:27
 * @author: ymc
 * @QQ:745612618
 */

public class SearechPresenter extends BasePresenter<SearechContract.View> implements SearechContract.Presenter{

    private SearechContract.View view;
    private SearechModel model;

    public SearechPresenter(SearechContract.View view) {
        this.view = view;
        this.model = new SearechModel();
    }

    /**
     * 获取 搜索 热度 词语结果
     */
    @Override
    public void getHotListResult() {
        ApiStore.createApi(ApiService.class)
                .getHitKeyBean()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<List<HotKeyBean>>>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                        view.getHotListErr(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseResp<List<HotKeyBean>> listBaseResp) {
                        if(listBaseResp.getErrorCode() == ConstantUtil.REQUEST_SUCCESS){
                            view.getHotListOk(listBaseResp.getData());
                        }else if(listBaseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR){
                            view.getHotListErr(listBaseResp.getErrorMsg());
                        }
                    }
                });
    }

    /**
     * 保存 搜索历史
     * @param context
     * @param historyList
     */
    @Override
    public void saveHistory(Context context, List<String> historyList) {
        model.saveHistory(context,historyList);
    }

    /**
     * 获取 搜索历史
     * @param context
     * @param historyList
     */
    @Override
    public void getHistoryList(Context context, List<String> historyList) {
        model.getHistory(context,historyList);
    }


}
