package cn.white.ymc.wanandroidmaster.ui.register;

import cn.white.ymc.wanandroidmaster.data.BaseResp;
import cn.white.ymc.wanandroidmaster.data.bean.UserInfo;
import cn.white.ymc.wanandroidmaster.model.ApiService;
import cn.white.ymc.wanandroidmaster.model.ApiStore;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 注册 presenter 层
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.register
 * @fileName: RegisterPresenter
 * @date: 2018/7/24  16:25
 * @author: ymc
 * @QQ:745612618
 */

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View view;

    public RegisterPresenter(RegisterContract.View view) {
        this.view = view;
    }

    @Override
    public void register(String name, String password, String rePassWord) {
        ApiStore.createApi(ApiService.class)
                .register(name,password,rePassWord)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<UserInfo>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.registerErr(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseResp<UserInfo> userInfoBaseResp) {
                        if (userInfoBaseResp.getErrorCode() == ConstantUtil.REQUEST_SUCCESS) {
                            view.registerOk(userInfoBaseResp.getData());
                        } else if (userInfoBaseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR) {
                            view.registerErr(userInfoBaseResp.getErrorMsg());
                        }
                    }
                });
    }

}
