package cn.white.ymc.wanandroidmaster.util.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import cn.white.ymc.wanandroidmaster.base.BaseActivity;

/**
 * 监听 网络变化
 *
 * @packageName: cn.white.ymc.wanandroidmaster.util
 * @fileName: NetWorkBroadcastReceiver
 * @date: 2018/7/19  14:42
 * @author: ymc
 * @QQ:745612618
 */

public class NetWorkBroadcastReceiver extends BroadcastReceiver {
    public NetEvent netEvent = BaseActivity.netEvent;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onReceive(Context context, Intent intent) {
        // 如果相等的话就说明网络状态发生了变化
        if (intent.getAction().equals("CONNECTIVITY_CHANGE")) {
            NetUtil.init(context);
            int netWorkState = NetUtil.getNetWorkState();
            // 接口回调传过去状态的类型
            netEvent.onNetChange(netWorkState);
        }
    }

    // 自定义接口
    public interface NetEvent {
        void onNetChange(int netMobile);
    }
}

