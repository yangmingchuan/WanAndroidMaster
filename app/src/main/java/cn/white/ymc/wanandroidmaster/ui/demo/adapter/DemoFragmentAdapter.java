package cn.white.ymc.wanandroidmaster.ui.demo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 类似 体系界面  适配器
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.demo.adapter
 * @fileName: DemoFragmentAdapter
 * @date: 2018/8/16  17:39
 * @author: ymc
 * @QQ:745612618
 */

public class DemoFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments;

    public DemoFragmentAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        if(fragments ==null){
            return 0;
        }
        return fragments.size();
    }
}
