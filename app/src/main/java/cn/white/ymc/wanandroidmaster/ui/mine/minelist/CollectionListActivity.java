package cn.white.ymc.wanandroidmaster.ui.mine.minelist;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseActivity;
import cn.white.ymc.wanandroidmaster.base.BaseResultActivity;
import cn.white.ymc.wanandroidmaster.data.bean.CollectBean;

/**
 * 已收藏列表
 *
 * @author ymc
 */

public class CollectionListActivity extends BaseResultActivity implements CollectionListContract.View{
    @BindView(R.id.toolbar_collect)
    Toolbar toolbarCollect;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.normal_view)
    SmartRefreshLayout normalView;

    private CollectionListPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collection_list;
    }

    @Override
    protected void initView() {
        setSupportActionBar(toolbarCollect);
        getSupportActionBar().setTitle(getString(R.string.my_collect));
        normalView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                presenter.onRefresh();
                refreshLayout.finishRefresh(1000);
            }
        });
        normalView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                presenter.onLoadMore();
                refreshLayout.finishLoadMore(1000);
            }
        });
    }

    @Override
    protected void initData() {
        presenter = new CollectionListPresenter(this);

        presenter.getCollectionList(0);
    }

    @Override
    public void getCollectionListOK(CollectBean collectBean, boolean isRefresh) {

        showNormal();
    }

    @Override
    public void getCollectionListErr(String err) {
        showError(err);
    }

    @Override
    public void reload() {
        super.reload();
        showLoading();
        presenter.onRefresh();
    }
}
