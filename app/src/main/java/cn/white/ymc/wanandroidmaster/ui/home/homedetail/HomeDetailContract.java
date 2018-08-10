package cn.white.ymc.wanandroidmaster.ui.home.homedetail;

import cn.white.ymc.wanandroidmaster.base.contract.BasePre;
import cn.white.ymc.wanandroidmaster.base.contract.BaseView;

/**
 * 首页详情界面
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.home.homedetail
 * @fileName: HomeDetailCon
 * @date: 2018/8/9  17:30
 * @author: ymc
 * @QQ:745612618
 */

public class HomeDetailContract {

    public interface view extends BaseView{

        /**
         * 收藏 成功 失败
         * @param info
         */
        void collectArticleOK(String info);

        void collectArticleErr(String info);

        /**
         * 取消收藏 成功 失败
         * @param info
         */
        void cancelCollectArticleOK(String info);

        void cancelCollectArticleErr(String info);
    }

    public interface presenter extends BasePre<view>{

        void collectArticle(int id);

        void cancelCollectArticle(int id);
    }

}
