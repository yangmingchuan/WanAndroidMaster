package cn.white.ymc.wanandroidmaster.ui.home.search;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.zhy.view.flowlayout.TagFlowLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseResultActivity;

/**
 * 搜索界面
 * <p>
 * 2018年8月24日 15:23:08
 *
 * @author ymc
 */
public class SearechActivity extends BaseResultActivity {

    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.flow_search)
    TagFlowLayout flowSearch;
    @BindView(R.id.tv_clear)
    TextView tvClear;
    @BindView(R.id.rv_history)
    RecyclerView rvHistory;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_searech;
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initView() {
        super.initView();

    }

    @Override
    protected void initData() {

    }

}
