package cn.white.ymc.wanandroidmaster.ui.fragment.system;

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
import cn.white.ymc.wanandroidmaster.data.bean.SystemBean;

/**
 * 体系 fragment
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.fragment.system
 * @fileName: SystemFragment
 * @date: 2018/7/27  9:10
 * @author: ymc
 * @QQ:745612618
 */

public class SystemFragment extends BaseFragment implements SystemContract.View{
    @BindView(R.id.rv_system)
    RecyclerView rvSystem;
    @BindView(R.id.normal_view)
    SmartRefreshLayout normalView;

    private List<SystemBean> systemBeanList;
    private SystemPresenter presenter;

    public static SystemFragment getInstance() {
        return new SystemFragment();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_system;
    }

    @Override
    protected void initData() {
        presenter = new SystemPresenter(this);
    }

    @Override
    protected void initUI() {
        super.initUI();
        setRefresh();
        rvSystem.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public void getKnowledgeListOk(List<SystemBean> dataBean, boolean isRefresh) {

    }

    @Override
    public void getKnowledgeListErr(String info) {

    }

    /**
     * SmartRefreshLayout刷新加载
     */
    private void setRefresh() {
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
    }
}
