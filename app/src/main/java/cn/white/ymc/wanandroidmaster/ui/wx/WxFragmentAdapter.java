package cn.white.ymc.wanandroidmaster.ui.wx;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

import cn.white.ymc.wanandroidmaster.ui.wx.wxdetail.WxDetailFragment;

/**
 * 微信fragment 适配器
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.wx
 * @fileName: WxFragmentAdapter
 * @date: 2018/11/1  15:58
 * @author: ymc
 * @QQ:745612618
 */

public class WxFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments;
    WxDetailFragment fragment;


    public WxFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        if(fragments==null){
            return 0;
        }else{
            return fragments.size();
        }
    }

    /**
     * 获取当前显示的fragment
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        fragment = (WxDetailFragment) object;
        super.setPrimaryItem(container, position, object);
    }

    public WxDetailFragment getCurrentFragment() {
        return fragment;
    }

}
