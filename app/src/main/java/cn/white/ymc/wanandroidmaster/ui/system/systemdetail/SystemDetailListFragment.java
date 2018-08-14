package cn.white.ymc.wanandroidmaster.ui.system.systemdetail;

import android.os.Bundle;
import cn.white.ymc.wanandroidmaster.base.BaseFragment;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;

/**
 * 体系详情界面 碎片
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.system.systemdetail
 * @fileName: SystemDetailListFragment
 * @date: 2018/8/14  9:43
 * @author: ymc
 * @QQ:745612618
 */

public class SystemDetailListFragment extends BaseFragment {

    public static SystemDetailListFragment getInstance(int id) {
        SystemDetailListFragment fragment = new SystemDetailListFragment();
        Bundle args = new Bundle();
        args.putInt(ConstantUtil.SYSTEM_FRAGMENT_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResID() {
        return 0;
    }

    @Override
    protected void initData() {

    }
}
