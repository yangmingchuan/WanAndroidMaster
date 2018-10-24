package cn.white.ymc.wanandroidmaster.ui.mine.minelist.wx;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseResultActivity;

/**
 * 微信列表界面
 *
 * @author ymc
 * 2018年10月24日 13:32:10
 */

public class WXListActivity extends BaseResultActivity {

    @BindView(R.id.toolbar_wx_list)
    Toolbar toolbarWxList;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.normal_view)
    SmartRefreshLayout normalView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wxlist;
    }

    @Override
    protected void initView() {
        setSupportActionBar(toolbarWxList);
        getSupportActionBar().setTitle(getString(R.string.wx_list));
        rv.setLayoutManager(new LinearLayoutManager(this));
        toolbarWxList.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void initData() {

    }

}
