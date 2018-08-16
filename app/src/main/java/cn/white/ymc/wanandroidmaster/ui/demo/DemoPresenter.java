package cn.white.ymc.wanandroidmaster.ui.demo;

import cn.white.ymc.wanandroidmaster.base.contract.BasePresenter;

/**
 * Created by yangmingchuan on 2018/8/16.
 * Email:18768880074@163.com
 * cn.white.ymc.wanandroidmaster.ui.demo
 */

public class DemoPresenter extends BasePresenter<DemoContract.View> implements DemoContract.Presenter {

    private DemoContract.View view;

    public DemoPresenter(DemoContract.View view) {
        this.view = view;
    }

    @Override
    public void getDemoList() {

    }
}
