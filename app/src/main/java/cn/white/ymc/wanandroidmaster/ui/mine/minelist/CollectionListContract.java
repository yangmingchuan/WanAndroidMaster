package cn.white.ymc.wanandroidmaster.ui.mine.minelist;

import cn.white.ymc.wanandroidmaster.base.contract.BasePre;
import cn.white.ymc.wanandroidmaster.base.contract.BaseView;
import cn.white.ymc.wanandroidmaster.data.bean.CollectBean;

/**
 * 我的收藏 契约类
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.mine.minelist
 * @fileName: CollectionListContract
 * @date: 2018/8/23  13:19
 * @author: ymc
 * @QQ:745612618
 */

public class CollectionListContract {

    public interface View extends BaseView{
        /**
         * 获取我的收藏列表成功
         */
        void getCollectionListOK(CollectBean collectBean , boolean isRefresh);

        /**
         * 获取我的收藏列表失败
         */
        void getCollectionListErr(String err);

    }

    public interface Presenter extends BasePre<View>{

        void onRefresh();

        void onLoadMore();

        void getCollectionList(int page );
    }

}
