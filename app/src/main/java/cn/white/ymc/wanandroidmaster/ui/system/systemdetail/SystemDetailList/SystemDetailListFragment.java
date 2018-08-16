package cn.white.ymc.wanandroidmaster.ui.system.systemdetail.SystemDetailList;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseFragment;
import cn.white.ymc.wanandroidmaster.data.bean.SystemDetailListBean;
import cn.white.ymc.wanandroidmaster.ui.home.homedetail.HomeDetailActivity;
import cn.white.ymc.wanandroidmaster.ui.system.SystemContract;
import cn.white.ymc.wanandroidmaster.ui.system.systemdetail.SystemDetailActivity;
import cn.white.ymc.wanandroidmaster.ui.system.systemdetail.SystemDetailList.adapter.SystemDetailItemAdapter;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import cn.white.ymc.wanandroidmaster.util.toast.ToastUtil;

/**
 * 体系详情界面 碎片  ( 体系 二级数据详细信息列表)
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.system.systemdetail
 * @fileName: SystemDetailListFragment
 * @date: 2018/8/14  9:43
 * @author: ymc
 * @QQ:745612618
 */

public class SystemDetailListFragment extends BaseFragment implements SystemDetailListContract.View
            ,SystemDetailItemAdapter.OnItemClickListener {
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.normal_view)
    SmartRefreshLayout normalView;

    private int id;
    private SystemDetailListPresenter presenter;
    private List<SystemDetailListBean.DatasBean> datasBeanList;
    private SystemDetailItemAdapter adapter;

    public static SystemDetailListFragment getInstance(int id) {
        SystemDetailListFragment fragment = new SystemDetailListFragment();
        Bundle args = new Bundle();
        args.putInt(ConstantUtil.SYSTEM_FRAGMENT_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_system_detail;
    }

    @Override
    protected void initUI() {
        super.initUI();
        showLoading();
        rv.setLayoutManager(new LinearLayoutManager(activity));
    }

    @Override
    protected void initData() {
        presenter = new SystemDetailListPresenter(this);
        if (getArguments() != null) {
            id = getArguments().getInt(ConstantUtil.SYSTEM_FRAGMENT_ID);
            presenter.getSystemDetailList(0, id);
        }
        normalView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                presenter.autoRefresh();
                refreshLayout.finishRefresh(1000);
            }
        });
        normalView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                presenter.loadMore();
                refreshLayout.finishLoadMore(1000);
            }
        });
        datasBeanList = new ArrayList<>();
        adapter = new SystemDetailItemAdapter(R.layout.item_homepage,datasBeanList);
        adapter.setOnItemClickListener(this);
        rv.setAdapter(adapter);

    }

    @Override
    public void getSystemDetailListResultOK(SystemDetailListBean systemDetailListBean, boolean isRefresh) {
        showNormal();
        if(isRefresh){
            datasBeanList = systemDetailListBean.getDatas();
            adapter.replaceData(systemDetailListBean.getDatas());
        }else{
            if (systemDetailListBean.getDatas().size() > 0) {
                datasBeanList.addAll(systemDetailListBean.getDatas());
                adapter.addData(systemDetailListBean.getDatas());
            } else {
                ToastUtil.show(context, getString(R.string.load_more_no_data));
            }
        }
    }

    @Override
    public void getSystemDetailListResultErr(String info) {
        showError(info);
    }


    /**
     *  item 点击事件
     * @param madapter
     * @param view
     * @param position
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onItemClick(BaseQuickAdapter madapter, View view, int position) {
        SystemDetailListBean.DatasBean bean = adapter.getData().get(position);
        Bundle bundle = new Bundle();
        bundle.putInt(ConstantUtil.HOME_DETAIL_ID,bean.getId());
        bundle.putString(ConstantUtil.HOME_DETAIL_PATH,bean.getLink());
        bundle.putString(ConstantUtil.HOME_DETAIL_TITLE,bean.getTitle());
        bundle.putBoolean(ConstantUtil.HOME_DETAIL_IS_COLLECT,bean.isCollect());
        // webview 和跳转的界面布局 transitionName 一定要相同
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(activity, view, getString(R.string.web_view));
        startActivity(new Intent(activity, HomeDetailActivity.class).putExtras(bundle), options.toBundle());
    }

    public void scrollToTop() {
        rv.smoothScrollToPosition(0);
    }


    @Override
    public void reload() {
        super.reload();
        if(presenter!=null && id!=-1){
            presenter.getSystemDetailList(0,id);
        }
        showLoading();
    }
}
