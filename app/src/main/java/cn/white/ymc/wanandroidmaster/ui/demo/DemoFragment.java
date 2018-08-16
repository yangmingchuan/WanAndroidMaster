package cn.white.ymc.wanandroidmaster.ui.demo;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.List;

import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseFragment;
import cn.white.ymc.wanandroidmaster.data.bean.DemoBean;

/**
 * 项目 fragment
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.demo
 * @fileName: DemoFragment
 * @date: 2018/8/13  16:48
 * @author: ymc
 * @QQ:745612618
 */

public class DemoFragment extends BaseFragment {

    @BindView(R.id.project_tab_layout)
    SlidingTabLayout projectTabLayout;
    @BindView(R.id.pager_project)
    ViewPager pagerProject;

    List<DemoBean> demoBeanList;
    List<Fragment> fragmentList;

    public static DemoFragment getInstance() {
        return new DemoFragment();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_demo;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initUI() {
        super.initUI();

    }
}
