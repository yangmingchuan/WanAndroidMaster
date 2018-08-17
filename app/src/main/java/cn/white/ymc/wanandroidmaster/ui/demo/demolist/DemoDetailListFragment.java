package cn.white.ymc.wanandroidmaster.ui.demo.demolist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseFragment;
import cn.white.ymc.wanandroidmaster.data.bean.DemoDetailListBean;
import cn.white.ymc.wanandroidmaster.ui.demo.demolist.adapter.DemoDetailListAdapter;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;

/**
 * 项目 列表fragment
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.demo
 * @fileName: DemoDetailListFragment
 * @date: 2018/8/17  10:18
 * @author: ymc
 * @QQ:745612618
 */

public class DemoDetailListFragment extends BaseFragment {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.normal_view)
    SmartRefreshLayout normalView;

    DemoDetailListAdapter adapter;
    List<DemoDetailListBean> demoDetailListBeans;

    public static DemoDetailListFragment getInstance(int id) {
        DemoDetailListFragment fragment = new DemoDetailListFragment();
        Bundle args = new Bundle();
        args.putInt(ConstantUtil.DEMO_FRAGMENT_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 布局复用 体系 的列表界面
     *
     * @return
     */
    @Override
    public int getLayoutResID() {
        return R.layout.fragment_system_detail;
    }

    @Override
    protected void initUI() {
        super.initUI();
        normalView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }
        });
        normalView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

            }
        });
        showLoading();
        rv.setLayoutManager(new LinearLayoutManager(activity));
    }

    @Override
    protected void initData() {

    }

    @Override
    public void reload() {
        super.reload();

    }
}
