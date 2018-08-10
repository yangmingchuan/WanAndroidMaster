package cn.white.ymc.wanandroidmaster.ui.fragment.home;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseFragment;
import cn.white.ymc.wanandroidmaster.data.bean.BenarBean;
import cn.white.ymc.wanandroidmaster.data.bean.HomePageArticleBean;
import cn.white.ymc.wanandroidmaster.ui.fragment.home.adapter.HomePageAdapter;
import cn.white.ymc.wanandroidmaster.ui.home.homedetail.HomeDetailActivity;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import cn.white.ymc.wanandroidmaster.util.GlideImageLoader;
import cn.white.ymc.wanandroidmaster.util.JumpUtil;

/**
 * 首页 fragment 界面
 *
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.fragment.home
 * @fileName: HomeFragment
 * @date: 2018/7/26  9:10
 * @author: ymc
 * @QQ:745612618
 */

public class HomeFragment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener,
        BaseQuickAdapter.OnItemChildClickListener ,HomeContract.View {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.normal_view)
    SmartRefreshLayout normalView;

    private List<HomePageArticleBean.DatasBean> articleList;
    private List<String> linkList;
    private List<String> imageList;
    private List<String> titleList;
    private HomePageAdapter mAdapter;
    private HomePagePresenter presenter;
    private Banner banner;
    private LinearLayout bannerView;
    private int clickPosition;

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_home;
    }

    /**
     * 数据 初始化
     */
    @Override
    protected void initData() {
        setRefresh();
        articleList = new ArrayList<>();
        linkList = new ArrayList<>();
        imageList = new ArrayList<>();
        titleList = new ArrayList<>();
        presenter = new HomePagePresenter(this);
        presenter.getBanner();
        presenter.getHomepageListData(0);
        mAdapter = new HomePageAdapter(R.layout.item_homepage, articleList);
        mAdapter.addHeaderView(bannerView);
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnItemChildClickListener(this);
        rv.setAdapter(mAdapter);
    }

    /**
     * 初始化 ui
     */
    @Override
    protected void initUI() {
        super.initUI();
        showLoading();
        rv.setLayoutManager(new LinearLayoutManager(context));
        bannerView = (LinearLayout) getLayoutInflater().inflate(R.layout.view_banner, null);
        banner = bannerView.findViewById(R.id.banner);
        bannerView.removeView(banner);
        bannerView.addView(banner);
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

    /**
     * 点击item 事件  （共享元素跳转）
     * @param adapter
     * @param view
     * @param position
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        HomePageArticleBean.DatasBean bean = (HomePageArticleBean.DatasBean) adapter.getData().get(position);
        Bundle bundle = new Bundle();
        bundle.putInt(ConstantUtil.HOME_DETAIL_ID,bean.getId());
        bundle.putString(ConstantUtil.HOME_DETAIL_PATH,bean.getLink());
        bundle.putString(ConstantUtil.HOME_DETAIL_TITLE,bean.getTitle());
        bundle.putBoolean(ConstantUtil.HOME_DETAIL_IS_COLLECT,bean.isCollect());
        // webview 和跳转的界面布局 transitionName 一定要相同
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(activity, view, getString(R.string.web_view));
        startActivity(new Intent(activity, HomeDetailActivity.class).putExtras(bundle), options.toBundle());
    }

    /**
     * 点击 设置选中非选中
     *
     * @param adapter
     * @param view
     * @param position
     */
    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    /**
     * 获取 首页列表成功
     * @param dataBean
     * @param isRefresh
     */
    @Override
    public void getHomepageListOk(HomePageArticleBean dataBean, boolean isRefresh) {
        showNormal();
        // 是 刷新adapter 则 添加数据到adapter
        if(isRefresh){
            articleList = dataBean.getDatas();
            mAdapter.replaceData(articleList);
        }else{
            articleList.addAll(dataBean.getDatas());
            mAdapter.addData(dataBean.getDatas());
        }
    }

    /**
     * 获取首页信息失败
     * @param info
     */
    @Override
    public void getHomepageListErr(String info) {
        showError(info);
    }

    /**
     * 获取轮播成功
     * @param bannerBean
     */
    @Override
    public void getBannerOk(List<BenarBean> bannerBean) {
        imageList.clear();
        titleList.clear();
        linkList.clear();
        for(BenarBean benarBean:bannerBean){
            imageList.add(benarBean.getImagePath());
            titleList.add(benarBean.getTitle());
            linkList.add(benarBean.getUrl());
        }
        if(!activity.isDestroyed()){
            // banner git 地址 https://github.com/youth5201314/banner
            banner.setImageLoader(new GlideImageLoader())
                    .setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE)
                    .setImages(imageList)
                    .setBannerAnimation(Transformer.Accordion)
                    .setBannerTitles(titleList)
                    .isAutoPlay(true)
                    .setDelayTime(5000)
                    .setIndicatorGravity(BannerConfig.RIGHT)
                    .start();
        }
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                if(!TextUtils.isEmpty(linkList.get(position))){
                    Bundle bundle = new Bundle();
                    bundle.putString(ConstantUtil.HOME_DETAIL_TITLE,titleList.get(position));
                    bundle.putString(ConstantUtil.HOME_DETAIL_PATH,linkList.get(position));
                    JumpUtil.overlay(context, HomeDetailActivity.class,bundle);
                }
            }
        });
    }

    /**
     * 获取轮播失败
     * @param info
     */
    @Override
    public void getBannerErr(String info) {
        showError(info);
    }

    @Override
    public void reload() {
        showLoading();
        presenter.getBanner();
        presenter.autoRefresh();
    }
}
