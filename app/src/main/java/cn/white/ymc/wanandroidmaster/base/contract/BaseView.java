package cn.white.ymc.wanandroidmaster.base.contract;

/**
 * view 基础接口
 *
 * @packageName: cn.white.ymc.wanandroidmaster.base.contract
 * @fileName: BaseView
 * @date: 2018/7/23  14:14
 * @author: ymc
 * @QQ:745612618
 */

public interface BaseView {

    /**
     * showNormal
     */
    void showNormal();

    /**
     * Show error
     */
    void showError();

    /**
     * Show loading
     */
    void showLoading();

    /**
     * Show empty
     */
    void showEmpty();

    /**
     * Reload
     */
    void reload();
}
