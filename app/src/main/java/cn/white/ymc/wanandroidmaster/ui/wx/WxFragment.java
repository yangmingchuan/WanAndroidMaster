package cn.white.ymc.wanandroidmaster.ui.wx;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseFragment;
import cn.white.ymc.wanandroidmaster.data.bean.WxListBean;
import cn.white.ymc.wanandroidmaster.ui.wx.wxdetail.WxDetailFragment;

/**
 * 微信公众号fragment
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.wx
 * @fileName: WxFragment
 * @date: 2018/11/1  13:43
 * @author: ymc
 * @QQ:745612618
 */

public class WxFragment extends BaseFragment implements WxContract.View{

    @BindView(R.id.wx_tab_layout)
    SlidingTabLayout wxTabLayout;
    @BindView(R.id.wx_view_pager)
    ViewPager wxViewPager;

    List<WxListBean> wxBeanList;
    List<Fragment> fragmentList;
    List<String> titles;
    private WxPresenter presenter;
    private WxFragmentAdapter adapter;

    public static WxFragment getInstance() {
        return new WxFragment();
    }
    @Override
    public int getLayoutResID() {
        return R.layout.fragment_wx;
    }

    @Override
    protected void initUI() {
        super.initUI();
    }

    @Override
    protected void initData() {
        presenter = new WxPresenter(this);
        fragmentList = new ArrayList<>();
        wxBeanList = new ArrayList<>();
        titles = new LinkedList<>();
        adapter = new WxFragmentAdapter(getChildFragmentManager(),fragmentList);
        showLoading();
        presenter.getWxTitleList();
    }

    @Override
    public void getWxResultOK(List<WxListBean> demoBeans) {
        wxBeanList.clear();
        titles.clear();
        fragmentList.clear();
        wxBeanList.addAll(demoBeans);
        if(wxBeanList.size()>0){
            for(WxListBean bean : wxBeanList){
                fragmentList.add(WxDetailFragment.getInstance(bean.getId()));
                titles.add(bean.getName());
            }
            wxViewPager.setAdapter(adapter);
            wxTabLayout.setViewPager(wxViewPager, titles.toArray(new String[titles.size()]));
            adapter.notifyDataSetChanged();
        }
        showNormal();
    }

    @Override
    public void getWxResultErr(String info) {
        showError(info);
    }

    @Override
    public void reload() {
        super.reload();
        presenter.getWxTitleList();
    }
}
