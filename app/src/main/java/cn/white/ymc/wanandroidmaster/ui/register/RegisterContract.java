package cn.white.ymc.wanandroidmaster.ui.register;

import cn.white.ymc.wanandroidmaster.base.contract.BaseView;
import cn.white.ymc.wanandroidmaster.data.bean.UserInfo;

/**
 * 注册合同类
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.register
 * @fileName: RegisterContract
 * @date: 2018/7/24  16:08
 * @author: ymc
 * @QQ:745612618
 */

public class RegisterContract {

    public interface View extends BaseView {

        void registerOk(UserInfo userInfo);

        void registerErr(String info);

    }

    public interface Presenter {

        void register(String name, String password,String rePassWord);

    }

}
