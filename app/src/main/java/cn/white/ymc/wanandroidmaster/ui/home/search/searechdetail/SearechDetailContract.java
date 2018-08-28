package cn.white.ymc.wanandroidmaster.ui.home.search.searechdetail;

import cn.white.ymc.wanandroidmaster.base.contract.BasePre;
import cn.white.ymc.wanandroidmaster.base.contract.BaseView;
import cn.white.ymc.wanandroidmaster.data.bean.HomePageArticleBean;

/**
 * 搜索结果 界面 契约类
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.home.search.searechdetail
 * @fileName: SearechDetailContract
 * @date: 2018/8/28  11:22
 * @author: ymc
 * @QQ:745612618
 */

public class SearechDetailContract {

    public interface View extends BaseView{

        void getSearechResultOk(HomePageArticleBean bean , boolean isRefresh);

        void getSearechResultErr(String err);

    }

    public interface Presenter extends BasePre<View>{

        void getSearechResult(int page ,String key);

        void autoRefresh(String key);

        void loadMore(String key);

    }

}
