package cn.white.ymc.wanandroidmaster.ui.system.systemdetail;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;

import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseActivity;

/**
 * 体系详细界面
 *
 * @author ymc
 */

public class SystemDetailActivity extends BaseActivity {

    @BindView(R.id.system_toolbar)
    Toolbar systemToolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.system_tab_layout)
    SlidingTabLayout systemTabLayout;
    @BindView(R.id.system_viewpager)
    ViewPager systemViewpager;
    @BindView(R.id.float_button)
    FloatingActionButton floatButton;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_system_detail;
    }

    @Override
    protected void initView() {
        setSupportActionBar(systemToolbar);
        systemToolbar.setNavigationOnClickListener(new View.OnClickListener() {
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
