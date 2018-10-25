package cn.white.ymc.wanandroidmaster.ui.mine.minelist.wx;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseResultActivity;
import cn.white.ymc.wanandroidmaster.data.bean.WxListBean;
import cn.white.ymc.wanandroidmaster.ui.mine.minelist.wx.wxpublic.WxPublicListActivity;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;

/**
 * 微信列表界面
 *
 * @author ymc
 * 2018年10月24日 13:32:10
 */

public class WXListActivity extends BaseResultActivity implements WXListContract.view,BaseQuickAdapter.OnItemClickListener{

    @BindView(R.id.toolbar_wx_list)
    Toolbar toolbarWxList;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.normal_view)
    SmartRefreshLayout normalView;

    private WXListPresenter presenter;
    private WXListAdapter adapter;
    private List<WxListBean> wxListBeanList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wxlist;
    }

    @Override
    protected void initView() {
        super.initView();
        setSupportActionBar(toolbarWxList);
        getSupportActionBar().setTitle(getString(R.string.wx_list));
        rv.setLayoutManager(new LinearLayoutManager(this));
        toolbarWxList.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        normalView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                presenter.getWXList();
                refreshLayout.finishRefresh(1000);
            }
        });
    }

    @Override
    protected void initData() {
        showLoading();
        wxListBeanList = new ArrayList<>();
        presenter = new WXListPresenter(this);
        adapter = new WXListAdapter(R.layout.item_wx_list,wxListBeanList);
        adapter.setOnItemClickListener(this);
        rv.setAdapter(adapter);
        presenter.getWXList();
    }

    @Override
    public void reload() {
        super.reload();
        showLoading();
    }

    @Override
    public void getWXListResultOk(List<WxListBean> wxListBeans) {
        showNormal();
        wxListBeanList = wxListBeans;
        adapter.replaceData(wxListBeanList);
    }

    @Override
    public void getWXListErr(String msg) {
        showError(msg);
    }

    /**
     * 查看公众号详情
     * @param madapter
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(BaseQuickAdapter madapter, View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(ConstantUtil.HOME_DETAIL_ID,adapter.getData().get(position).getId());
        bundle.putString(ConstantUtil.HOME_DETAIL_TITLE,adapter.getData().get(position).getName());
        startActivity(new Intent(activity, WxPublicListActivity.class).putExtras(bundle));
    }
}
