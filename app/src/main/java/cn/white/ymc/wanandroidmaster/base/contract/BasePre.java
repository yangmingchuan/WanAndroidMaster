package cn.white.ymc.wanandroidmaster.base.contract;

/**
 * @packageName: cn.white.ymc.wanandroidmaster.base.contract
 * @fileName: BasePer
 * @date: 2018/8/6  13:25
 * @author: ymc
 * @QQ:745612618
 */

public interface BasePre<T extends BaseView> {

    /**
     * 注入View
     *
     * @param view view
     */
    void attachView(T view);

    /**
     * 回收View
     */
    void detachView();

}
