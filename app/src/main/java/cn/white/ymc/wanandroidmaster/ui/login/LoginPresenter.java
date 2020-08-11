package cn.white.ymc.wanandroidmaster.ui.login;

import cn.white.ymc.wanandroidmaster.base.contract.BasePresenter;
import cn.white.ymc.wanandroidmaster.base.contract.BaseView;
import cn.white.ymc.wanandroidmaster.data.BaseResp;
import cn.white.ymc.wanandroidmaster.data.bean.UserInfo;
import cn.white.ymc.wanandroidmaster.model.ApiStore;
import cn.white.ymc.wanandroidmaster.model.ApiService;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import cn.white.ymc.wanandroidmaster.util.SharedPreferenceUtil;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 登陆 presenter 层
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.login
 * @fileName: LoginPresenter
 * @date: 2018/7/23  15:25
 * @author: ymc
 * @QQ:745612618
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void login(final String name, final String password) {
        ApiStore.createApi(ApiService.class)
                .login(name,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResp<UserInfo>>() {
                    @Override
                    public void onError(Throwable e) {
                        if (e.getMessage() != null) {
                            view.loginErr(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResp<UserInfo> baseResp) {
                        if (baseResp.getErrorCode() == ConstantUtil.REQUEST_SUCCESS) {
                            SharedPreferenceUtil.put(ConstantUtil.USERNAME, name);
                            SharedPreferenceUtil.put(ConstantUtil.PASSWORD, password);
                            SharedPreferenceUtil.put(ConstantUtil.ISLOGIN, true);
                            view.loginOk(baseResp.getData());
                        } else if (baseResp.getErrorCode() == ConstantUtil.REQUEST_ERROR) {
                            view.loginErr(baseResp.getErrorMsg());
                        }
                    }
                });

    }

}
