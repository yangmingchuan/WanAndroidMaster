package cn.white.ymc.wanandroidmaster.ui.system.systemdetail;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.flyco.tablayout.SlidingTabLayout;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseActivity;
import cn.white.ymc.wanandroidmaster.data.bean.SystemBean;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;

/**
 * 体系详细界面
 * https://github.com/H07000223/FlycoTabLayout/blob/master/README_CN.md    FlycoTabLayout使用
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

    private List<String> titles;
    private List<Fragment> fragments;
    private SystemDetailListAdapter adapter;

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
                ActivityCompat.finishAfterTransition(SystemDetailActivity.this);
            }
        });
    }

    @Override
    protected void initData() {
        titles = new ArrayList<>();
        fragments = new ArrayList<>();
        adapter = new SystemDetailListAdapter(getSupportFragmentManager(),fragments);
        getSystemBundleData();
    }

    /**
     * 获取体系界面传过来的参数
     */
    private void getSystemBundleData() {
        SystemBean systemBean = (SystemBean) getIntent().getSerializableExtra(ConstantUtil.SYSTEM);
        if (systemBean != null) {
            fragments.clear();
            getSupportActionBar().setTitle(systemBean.getName());
            for (SystemBean.ChildrenBean childrenBean : systemBean.getChildren()) {
                titles.add(childrenBean.getName());
                fragments.add(SystemDetailListFragment.getInstance(childrenBean.getId()));
            }
        }
        systemViewpager.setAdapter(adapter);
        systemTabLayout.setViewPager(systemViewpager,titles.toArray(new String[titles.size()]));
        adapter.notifyDataSetChanged();
    }



}
