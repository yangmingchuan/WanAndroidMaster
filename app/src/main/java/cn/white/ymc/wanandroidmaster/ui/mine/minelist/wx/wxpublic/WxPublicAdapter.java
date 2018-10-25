package cn.white.ymc.wanandroidmaster.ui.mine.minelist.wx.wxpublic;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.white.ymc.wanandroidmaster.data.bean.WxPublicListBean;

/**
 *  微信公众号文章 adapter
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.mine.minelist.wx.wxpublic
 * @fileName: WxPublicAdapter
 * @date: 2018/10/25  11:23
 * @author: ymc
 * @QQ:745612618
 */

public class WxPublicAdapter extends BaseQuickAdapter<WxPublicListBean.DatasBean,BaseViewHolder>{

    public WxPublicAdapter(int layoutResId, @Nullable List<WxPublicListBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WxPublicListBean.DatasBean item) {

    }
}
