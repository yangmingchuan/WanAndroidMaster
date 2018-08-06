package cn.white.ymc.wanandroidmaster.util.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * 检测网络工具类
 *
 * @packageName: cn.white.ymc.wanandroidmaster.util
 * @fileName: NetUtil
 * @date: 2018/7/19  14:30
 * @author: ymc
 * @QQ:745612618
 */

public class NetUtil {

    /**
     * 没有连接网络
     */
    public static final int NETWORK_NONE = -1;
    /**
     * 移动网络
     */
    public static final int NETWORK_MOBILE = 0;
    /**
     * 无线网络
     */
    public static final int NETWORK_WIFI = 1;

    public static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static int getNetWorkState() {
        if (mContext == null) {
            throw new UnsupportedOperationException("please use NetUtils before init it");
        }
        // 得到连接管理器对象
        ConnectivityManager connMgr = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        //获取所有网络连接的信息
        Network[] networks = connMgr.getAllNetworks();
        //通过循环将网络信息逐个取出来
        for (Network network : networks) {
            //获取ConnectivityManager对象对应的NetworkInfo对象
            NetworkInfo networkInfo = connMgr.getNetworkInfo(network);
            if (networkInfo.isConnected()) {
                if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                    return NETWORK_MOBILE;
                } else {
                    return NETWORK_WIFI;
                }
            }
        }
        return NETWORK_NONE;
    }

}
