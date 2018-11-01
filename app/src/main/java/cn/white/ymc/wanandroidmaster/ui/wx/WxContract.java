package cn.white.ymc.wanandroidmaster.ui.wx;

import java.util.List;

import cn.white.ymc.wanandroidmaster.base.contract.BasePre;
import cn.white.ymc.wanandroidmaster.base.contract.BaseView;
import cn.white.ymc.wanandroidmaster.data.bean.WxListBean;
import cn.white.ymc.wanandroidmaster.data.bean.WxPublicListBean;

/**
 * 微信公众号界面
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.wx
 * @fileName: WxContract
 * @date: 2018/11/1  14:16
 * @author: ymc
 * @QQ:745612618
 */

public class WxContract {

    public interface View extends BaseView{

        void getWxResultOK(List<WxListBean> demoBeans);

        void getWxResultErr(String info);
    }

    public interface Presenter extends BasePre<View>{

        void getWxTitleList();

    }

}
