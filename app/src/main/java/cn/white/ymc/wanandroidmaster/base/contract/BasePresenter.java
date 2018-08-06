package cn.white.ymc.wanandroidmaster.base.contract;

/**
 * @packageName: cn.white.ymc.wanandroidmaster.base.contract
 * @fileName: BasePresenter
 * @date: 2018/8/6  14:25
 * @author: ymc
 * @QQ:745612618
 */

public class BasePresenter<T extends BaseView> implements BasePre<T> {

    protected T mView;
    protected int currentPage;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
