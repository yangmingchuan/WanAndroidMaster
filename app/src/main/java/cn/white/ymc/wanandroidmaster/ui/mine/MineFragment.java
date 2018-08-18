package cn.white.ymc.wanandroidmaster.ui.mine;

import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseFragment;


/**
 * 我的界面
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.mine
 * @fileName: MineFragment
 * @date: 2018/7/27  9:07
 * @author: ymc
 * @QQ:745612618
 */

public class MineFragment extends BaseFragment {

    public static MineFragment getInstance() {
        return new MineFragment();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initData() {

    }
}
