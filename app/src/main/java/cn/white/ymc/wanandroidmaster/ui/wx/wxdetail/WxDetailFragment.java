package cn.white.ymc.wanandroidmaster.ui.wx.wxdetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseFragment;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;

/**
 * 微信详情界面
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.wx.wxdetail
 * @fileName: WxDetailFragment
 * @date: 2018/11/1  16:37
 * @author: ymc
 * @QQ:745612618
 */

public class WxDetailFragment extends BaseFragment {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.normal_view)
    SmartRefreshLayout normalView;

    private WxDetailPresenter presenter;

    /**
     *  id 编号
     */
    private int id = -1;

    public static WxDetailFragment getInstance(int id) {
        WxDetailFragment fragment = new WxDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ConstantUtil.WX_FRAGMENT_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_system_detail;
    }

    @Override
    public void reload() {
        super.reload();

    }

    @Override
    protected void initData() {
        normalView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                presenter.onRefresh();
                refreshLayout.finishRefresh(1200);
            }
        });
        normalView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                presenter.onLoadMore();
                refreshLayout.finishLoadMore(1200);
            }
        });
        showLoading();
        rv.setLayoutManager(new LinearLayoutManager(activity));
    }

}
