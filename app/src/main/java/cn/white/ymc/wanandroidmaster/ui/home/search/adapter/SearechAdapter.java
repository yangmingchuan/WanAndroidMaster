package cn.white.ymc.wanandroidmaster.ui.home.search.adapter;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.white.ymc.wanandroidmaster.R;

/**
 * 搜索界面 适配器
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.home.search.adapter
 * @fileName: SearechAdapter
 * @date: 2018/8/27  11:25
 * @author: ymc
 * @QQ:745612618
 */

public class SearechAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public SearechAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_history,item);
        helper.addOnClickListener(R.id.image_close);
    }
}
