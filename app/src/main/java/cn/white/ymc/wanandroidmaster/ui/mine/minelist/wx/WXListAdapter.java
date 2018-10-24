package cn.white.ymc.wanandroidmaster.ui.mine.minelist.wx;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.data.bean.WxListBean;

/**
 * 微信列表 卡片布局adapter
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.mine.minelist.wx
 * @fileName: WXListAdapter
 * @date: 2018/10/24  13:50
 * @author: ymc
 * @QQ:745612618
 */

public class WXListAdapter extends BaseQuickAdapter<WxListBean,BaseViewHolder> {

    public WXListAdapter(int layoutResId, @Nullable List<WxListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WxListBean item) {
        if(!TextUtils.isEmpty(item.getName())){
            helper.setText(R.id.tv_name,item.getName());
            if(item.getName().contains("鸿洋")){
                helper.setImageResource(R.id.iv_head, R.drawable.hongyang );
            }else if(item.getName().contains("郭霖")){
                helper.setImageResource(R.id.iv_head, R.drawable.guolin );
            }else if(item.getName().contains("美团技术团队")){
                helper.setImageResource(R.id.iv_head, R.drawable.meituan );
            }else if(item.getName().contains("谷歌开发者")){
                helper.setImageResource(R.id.iv_head, R.drawable.icon_google );
            }else{
                helper.setImageResource(R.id.iv_head, R.drawable.icon_wx );
            }
        }
    }
}
