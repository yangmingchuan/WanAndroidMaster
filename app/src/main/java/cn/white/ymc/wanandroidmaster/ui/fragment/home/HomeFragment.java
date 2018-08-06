package cn.white.ymc.wanandroidmaster.ui.fragment.home;

import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;

import java.util.List;

import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseFragment;
import cn.white.ymc.wanandroidmaster.data.bean.HomePageArticleBean;
import cn.white.ymc.wanandroidmaster.ui.fragment.home.adapter.HomePageAdapter;

/**
 * 首页 fragment 界面
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.fragment.home
 * @fileName: HomeFragment
 * @date: 2018/7/26  9:10
 * @author: ymc
 * @QQ:745612618
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.normal_view)
    SmartRefreshLayout normalView;

    private List<HomePageArticleBean.DatasBean> articleList;
    private List<String> linkList;
    private List<String> imageList;
    private List<String> titleList;
    private HomePageAdapter mAdapter;
    private HomePagePresenter presenter;
    private Banner banner;
    private LinearLayout bannerView;
    private int clickPosition;

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_home;
    }

    /**
     * 数据 初始化
     */
    @Override
    protected void initData() {

    }

    /**
     *  初始化 ui
     */
    @Override
    protected void initUI() {
        super.initUI();

    }

}
