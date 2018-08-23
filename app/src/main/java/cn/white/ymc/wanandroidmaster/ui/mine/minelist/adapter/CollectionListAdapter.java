package cn.white.ymc.wanandroidmaster.ui.mine.minelist.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.data.bean.CollectBean;

/**
 *  我的界面列表 adapter
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.mine.minelist.adapter
 * @fileName: CollectionListAdapter
 * @date: 2018/8/23  15:25
 * @author: ymc
 * @QQ:745612618
 */

public class CollectionListAdapter extends BaseQuickAdapter<CollectBean.DatasBean,BaseViewHolder>{

    public CollectionListAdapter(int layoutResId, @Nullable List<CollectBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CollectBean.DatasBean item) {
        helper.getView(R.id.tv_tag).setVisibility(View.GONE);
        if (!TextUtils.isEmpty(item.getTitle())) {
            helper.setText(R.id.tv_content, item.getTitle());
        }
        if (!TextUtils.isEmpty(item.getAuthor())) {
            helper.setText(R.id.tv_author, item.getAuthor());
        }
        if (!TextUtils.isEmpty(item.getNiceDate())) {
            helper.setText(R.id.tv_time, item.getNiceDate());
        }
        if (!TextUtils.isEmpty(item.getChapterName())) {
            String classifyName = item.getChapterName();
            helper.setText(R.id.tv_type, classifyName);
        }
        helper.setImageResource(R.id.image_collect, R.drawable.icon_collect );

    }
}
