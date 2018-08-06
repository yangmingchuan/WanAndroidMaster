package cn.white.ymc.wanandroidmaster.ui.login;

import cn.white.ymc.wanandroidmaster.base.contract.BasePre;
import cn.white.ymc.wanandroidmaster.base.contract.BaseView;
import cn.white.ymc.wanandroidmaster.data.bean.UserInfo;

/**
 * login 登陆
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.login
 * @fileName: LoginContrat
 * @date: 2018/7/23  14:27
 * @author: ymc
 * @QQ:745612618
 */

public class LoginContract {

    public interface View extends BaseView {

        void loginOk(UserInfo userInfo);

        void loginErr(String info);

    }

    public interface Presenter extends BasePre<View> {

        void login(String name, String password);

    }
}
