package cn.white.ymc.wanandroidmaster.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldoublem.loadingviewlib.LVChromeLogo;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.contract.BasePre;
import cn.white.ymc.wanandroidmaster.base.contract.BaseView;
import cn.white.ymc.wanandroidmaster.util.network.NetUtil;
import cn.white.ymc.wanandroidmaster.util.network.NetWorkBroadcastReceiver;

/**
 * fragment 基础类
 * @packageName: cn.white.ymc.wanandroidmaster.base
 * @fileName: BaseFragment
 * @date: 2018/7/27  9:39
 * @author: ymc
 * @QQ:745612618
 */

public abstract class BaseFragment extends Fragment implements BaseView, NetWorkBroadcastReceiver.NetEvent{
    public View rootView;
    protected Activity activity;
    protected MyApplication context;
    private Unbinder bind;
    public static NetWorkBroadcastReceiver.NetEvent eventFragment;
    private int netMobile;

    /**
     * 处理页面加载中、页面加载失败、页面没数据
     */
    private static final int NORMAL_STATE = 0;
    private static final int LOADING_STATE = 1;
    public static final int ERROR_STATE = 2;
    public static final int EMPTY_STATE = 3;

    private View mErrorView;
    private View mLoadingView;
    private View mEmptyView;
    private LVChromeLogo lvChromeLogo;
    private ViewGroup mNormalView;
    /**
     * 当前状态
     */
    private int currentState = NORMAL_STATE;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResID(), container,false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rootView = view;
        activity = getActivity();
        context = MyApplication.getInstance();
        bind = ButterKnife.bind(this, view);
    }

    /**
     * 网络改变的监听
     * @param netMobile
     */
    @Override
    public void onNetChange(int netMobile) {
        this.netMobile = netMobile;
        isNetConnect();
    }

    @Override
    public void onDestroy() {
        bind.unbind();
        super.onDestroy();
    }

    /**
     * 获取 布局信息
     * @return
     */
    public abstract int getLayoutResID();

    /**
     * 数据初始化
     */
    protected abstract void initData();

    /**
     * 初始化 ui 布局
     */
    protected void initUI(){
        if (getView() == null) {
            return;
        }
        mNormalView = getView().findViewById(R.id.normal_view);

        ViewGroup parent = (ViewGroup) mNormalView.getParent();
        View.inflate(activity, R.layout.view_loading, parent);
        View.inflate(activity, R.layout.view_error, parent);
        View.inflate(activity, R.layout.view_empty, parent);
        mLoadingView = parent.findViewById(R.id.loading_group);
        lvChromeLogo = mLoadingView.findViewById(R.id.lv_load);
        mErrorView = parent.findViewById(R.id.error_group);
        mEmptyView = parent.findViewById(R.id.empty_group);

        mErrorView.setVisibility(View.GONE);
        mEmptyView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.GONE);
        mNormalView.setVisibility(View.VISIBLE);
    }

    /**
     * 判断有无网络
     *
     * @return true 有网, false 没有网络.
     */
    public boolean isNetConnect() {
        if (netMobile == NetUtil.NETWORK_WIFI) {
            return true;
        } else if (netMobile == NetUtil.NETWORK_MOBILE) {
            return true;
        } else if (netMobile == NetUtil.NETWORK_NONE) {
            return false;
        }
        return false;
    }

    @Override
    public void showNormal() {
        if (currentState == NORMAL_STATE) {
            return;
        }
        hideCurrentView();
        currentState = NORMAL_STATE;
        mNormalView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError() {
        if (currentState == ERROR_STATE) {
            return;
        }
        hideCurrentView();
        currentState = ERROR_STATE;
        mErrorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoading() {
        if (currentState == LOADING_STATE) {
            return;
        }
        hideCurrentView();
        currentState = LOADING_STATE;
        mLoadingView.setVisibility(View.VISIBLE);
        lvChromeLogo.startAnim();
    }

    @Override
    public void showEmpty() {
        if (currentState == EMPTY_STATE) {
            return;
        }
        hideCurrentView();
        currentState = EMPTY_STATE;
        mEmptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void reload() {

    }

    private void hideCurrentView() {
        switch (currentState) {
            case NORMAL_STATE:
                if (mNormalView == null) {
                    return;
                }
                mNormalView.setVisibility(View.GONE);
                break;
            case LOADING_STATE:
                lvChromeLogo.stopAnim();
                mLoadingView.setVisibility(View.GONE);
                break;
            case ERROR_STATE:
                mErrorView.setVisibility(View.GONE);
                break;
            case EMPTY_STATE:
                mEmptyView.setVisibility(View.GONE);
            default:
                break;
        }
    }
}
