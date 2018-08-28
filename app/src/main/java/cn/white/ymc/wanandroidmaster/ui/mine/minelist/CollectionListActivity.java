package cn.white.ymc.wanandroidmaster.ui.mine.minelist;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseActivity;
import cn.white.ymc.wanandroidmaster.base.BaseResultActivity;
import cn.white.ymc.wanandroidmaster.data.bean.CollectBean;
import cn.white.ymc.wanandroidmaster.ui.home.homedetail.HomeDetailActivity;
import cn.white.ymc.wanandroidmaster.ui.mine.minelist.adapter.CollectionListAdapter;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import cn.white.ymc.wanandroidmaster.util.toast.ToastUtil;

/**
 * 已收藏列表
 *
 * @author ymc
 */

public class CollectionListActivity extends BaseResultActivity implements CollectionListContract.View
        , CollectionListAdapter.OnItemClickListener{
    @BindView(R.id.toolbar_collect)
    Toolbar toolbarCollect;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.normal_view)
    SmartRefreshLayout normalView;

    private CollectionListPresenter presenter;
    private CollectionListAdapter adapter;
    private List<CollectBean.DatasBean> datasBeanList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collection_list;
    }

    @Override
    protected void initView() {
        super.initView();
        setSupportActionBar(toolbarCollect);
        getSupportActionBar().setTitle(getString(R.string.my_collect));
        rv.setLayoutManager(new LinearLayoutManager(this));
        toolbarCollect.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
        showLoading();
        datasBeanList = new LinkedList<>();
        presenter = new CollectionListPresenter(this);
        adapter = new CollectionListAdapter(R.layout.item_homepage,datasBeanList);
        adapter.setOnItemClickListener(this);
        rv.setAdapter(adapter);
        presenter.getCollectionList(0);
    }

    @Override
    public void getCollectionListOK(CollectBean collectBean, boolean isRefresh) {
        if(isRefresh){
            datasBeanList = collectBean.getDatas();
            adapter.replaceData(datasBeanList);
        }else {
            datasBeanList.addAll(collectBean.getDatas());
            adapter.addData(collectBean.getDatas());
        }
        if(collectBean.getDatas().size()==0){
            ToastUtil.show(context,getString(R.string.load_more_no_data));
        }
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

    /**
     * item 点击事件
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onItemClick(BaseQuickAdapter madapter, View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(ConstantUtil.HOME_DETAIL_ID,adapter.getData().get(position).getId());
        bundle.putString(ConstantUtil.HOME_DETAIL_PATH,adapter.getData().get(position).getLink());
        bundle.putString(ConstantUtil.HOME_DETAIL_TITLE,adapter.getData().get(position).getTitle());
        bundle.putBoolean(ConstantUtil.HOME_DETAIL_IS_COLLECT, ConstantUtil.TRUE);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(activity, view, getString(R.string.web_view));
        startActivity(new Intent(activity, HomeDetailActivity.class).putExtras(bundle), options.toBundle());
    }
}
