package cn.white.ymc.wanandroidmaster.ui.home.search.searechdetail;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseResultActivity;
import cn.white.ymc.wanandroidmaster.data.bean.HomePageArticleBean;
import cn.white.ymc.wanandroidmaster.ui.home.adapter.HomePageAdapter;
import cn.white.ymc.wanandroidmaster.ui.home.homedetail.HomeDetailActivity;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import cn.white.ymc.wanandroidmaster.util.toast.ToastUtil;

/**
 * 搜索结果列表界面
 *
 * @author ymc
 * @date 2018年8月28日 10:13:15
 */

public class SearechDetailActivity extends BaseResultActivity implements SearechDetailContract.View,
        BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_searech_result)
    RecyclerView rvSearechResult;
    @BindView(R.id.normal_view)
    SmartRefreshLayout smallLabel;

    private String key;
    private SearechDetailPresenter presenter;
    private List<HomePageArticleBean.DatasBean> datasBeanList;
    private HomePageAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_searech_detail;
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        Bundle bundle = getIntent().getExtras();
        key = bundle.getString(ConstantUtil.SEARCH_RESULT_KEY);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if(!TextUtils.isEmpty(key)){
            getSupportActionBar().setTitle(key);
        }
    }

    @Override
    protected void initView() {
        super.initView();
        presenter = new SearechDetailPresenter(this);
        rvSearechResult.setLayoutManager(new LinearLayoutManager(this));
        smallLabel.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                presenter.autoRefresh(key);
                refreshLayout.finishRefresh(1000);
            }
        });
        smallLabel.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                presenter.loadMore(key);
                refreshLayout.finishLoadMore(1000);
            }
        });
    }


    @Override
    protected void initData() {
        showLoading();
        datasBeanList = new LinkedList<>();
        mAdapter = new HomePageAdapter(R.layout.item_homepage,datasBeanList);
        mAdapter.setOnItemClickListener(this);
        rvSearechResult.setAdapter(mAdapter);
        presenter.getSearechResult(0,key);
    }


    @Override
    public void getSearechResultOk(HomePageArticleBean bean , boolean isRefresh) {
        if(isRefresh){
            datasBeanList = bean.getDatas();
            mAdapter.replaceData(datasBeanList);
            if (datasBeanList.size() == 0){
                showEmpty();
            }
        }else{
            if (bean.getDatas().size() > 0) {
                datasBeanList.addAll(bean.getDatas());
                mAdapter.addData(bean.getDatas());
            } else {
                ToastUtil.show(context, getString(R.string.load_more_no_data));
            }
        }
        showNormal();
    }


    @Override
    public void getSearechResultErr(String err) {
        showError(err);
    }

    /**
     * 重新请求
     */
    @Override
    public void reload() {
        super.reload();
        if(!TextUtils.isEmpty(key)){
            presenter.getSearechResult(0,key);
        }
    }

    /**
     *  item 点击事件
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putString(ConstantUtil.HOME_DETAIL_TITLE, mAdapter.getData().get(position).getTitle());
        bundle.putString(ConstantUtil.HOME_DETAIL_PATH, mAdapter.getData().get(position).getLink());
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(activity, view, getString(R.string.web_view));
        startActivity(new Intent(activity, HomeDetailActivity.class).putExtras(bundle), options.toBundle());
    }
}
