package cn.white.ymc.wanandroidmaster.ui.demo;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseFragment;
import cn.white.ymc.wanandroidmaster.data.bean.DemoTitleBean;
import cn.white.ymc.wanandroidmaster.ui.demo.adapter.DemoFragmentAdapter;
import cn.white.ymc.wanandroidmaster.ui.demo.demolist.DemoDetailListFragment;

/**
 * 项目 fragment
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.demo
 * @fileName: DemoFragment
 * @date: 2018/8/13  16:48
 * @author: ymc
 * @QQ:745612618
 */

public class DemoFragment extends BaseFragment implements DemoContract.View{

    @BindView(R.id.demo_tab_layout)
    SlidingTabLayout demoTabLayout;
    @BindView(R.id.demo_view_pager)
    ViewPager demoViewPager;

    List<DemoTitleBean> demoBeanList;
    List<Fragment> fragmentList;
    List<String> titles;
    DemoPresenter demoPresenter;
    DemoFragmentAdapter adapter;

    public static DemoFragment getInstance() {
        return new DemoFragment();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_demo;
    }

    @Override
    protected void initData() {
        demoBeanList = new ArrayList<>();
        fragmentList = new ArrayList<>();
        demoPresenter = new DemoPresenter(this);
        adapter = new DemoFragmentAdapter(getChildFragmentManager(),fragmentList);
        demoPresenter.getDemoTitleList();
    }

    @Override
    protected void initUI() {
        super.initUI();
    }

    @Override
    public void getDemoResultOK(List<DemoTitleBean> demoBeans) {
        demoBeanList.clear();
        fragmentList.clear();
        demoBeanList.addAll(demoBeans);
        if(demoBeanList.size()>0){
            for(DemoTitleBean demoTitleBean : demoBeanList){
                fragmentList.add(DemoDetailListFragment.getInstance(demoTitleBean.getId()));
                titles.add(demoTitleBean.getName());
            }
            demoViewPager.setAdapter(adapter);
            demoTabLayout.setViewPager(demoViewPager, titles.toArray(new String[titles.size()]));
            adapter.notifyDataSetChanged();
        }
        showNormal();
    }

    @Override
    public void getDemoResultErr(String info) {
        showError(info);
    }

    @Override
    public void reload() {
        super.reload();
        showLoading();
        demoPresenter.getDemoTitleList();
    }
}
