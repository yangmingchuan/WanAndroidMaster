package cn.white.ymc.wanandroidmaster.ui.fragment.system;

import cn.white.ymc.wanandroidmaster.base.contract.BasePresenter;

/**
 * 体系 presenter 层
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.fragment.system
 * @fileName: SystemPresenter
 * @date: 2018/8/13  13:52
 * @author: ymc
 * @QQ:745612618
 */

public class SystemPresenter extends BasePresenter<SystemContract.View> implements SystemContract.Presenter {

    private SystemContract.View view;

    public SystemPresenter(SystemContract.View view) {
        this.view = view;
    }

    @Override
    public void autoRefresh() {

    }

    @Override
    public void loadMore() {

    }

    @Override
    public void getKnowledgeList() {

    }

}
