package cn.white.ymc.wanandroidmaster.ui.system.systemdetail.SystemDetailList.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

/**
 * 体系 详细界面 viewpager 适配器
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.system.systemdetail
 * @fileName: SystemDetailListAdapter
 * @date: 2018/8/14  11:27
 * @author: ymc
 * @QQ:745612618
 */

public class SystemDetailListAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public SystemDetailListAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        if(list==null){
            return 0;
        }
        return list.size();
    }
}
