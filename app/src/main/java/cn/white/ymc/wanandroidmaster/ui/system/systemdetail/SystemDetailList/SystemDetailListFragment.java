package cn.white.ymc.wanandroidmaster.ui.system.systemdetail.SystemDetailList;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseFragment;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;

/**
 * 体系详情界面 碎片  ( 体系 二级数据详细信息列表)
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.system.systemdetail
 * @fileName: SystemDetailListFragment
 * @date: 2018/8/14  9:43
 * @author: ymc
 * @QQ:745612618
 */

public class SystemDetailListFragment extends BaseFragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.normal_view)
    SmartRefreshLayout normalView;

    public static SystemDetailListFragment getInstance(int id) {
        SystemDetailListFragment fragment = new SystemDetailListFragment();
        Bundle args = new Bundle();
        args.putInt(ConstantUtil.SYSTEM_FRAGMENT_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_system_detail;
    }

    @Override
    protected void initData() {

    }

}
