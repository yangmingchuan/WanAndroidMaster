package cn.white.ymc.wanandroidmaster.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.white.ymc.wanandroidmaster.util.davik.AppDavikActivityUtil;
import cn.white.ymc.wanandroidmaster.util.Log.AppLogMessageUtil;
import cn.white.ymc.wanandroidmaster.util.network.NetUtil;
import cn.white.ymc.wanandroidmaster.util.network.NetWorkBroadcastReceiver;

/**
 *  基础 activity
 *
 * @packageName: cn.white.ymc.wanandroidmaster.base
 * @fileName: BaseActivity
 * @date: 2018/7/19  14:48
 * @author: ymc
 * @QQ:745612618
 */

public abstract class BaseActivity extends AppCompatActivity implements NetWorkBroadcastReceiver.NetEvent {
    public static NetWorkBroadcastReceiver.NetEvent netEvent;
    public AppDavikActivityUtil appDavikActivityUtil = AppDavikActivityUtil.getScreenManager();

    protected MyApplication context;
    protected BaseActivity activity;

    private Unbinder bun;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bun = ButterKnife.bind(this);
        appDavikActivityUtil.addActivity(this);
        context = MyApplication.getInstance();
        activity = this;
        netEvent = this;
        initView();
        initToolbar();
        initData();
    }

    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract void initData();
    /**
     * 初始化toolbar
     */
    protected void initToolbar(){}

    @Override
    public void onNetChange(int netMobile) {
        if (netMobile == NetUtil.NETWORK_NONE) {
            AppLogMessageUtil.e("NETWORK_NONE");
        } else{
            AppLogMessageUtil.e("NETWORK_NORMAL");
        }
    }

    @Override
    protected void onDestroy() {
        appDavikActivityUtil.removeActivity(this);
        bun.unbind();
        super.onDestroy();
    }
}
