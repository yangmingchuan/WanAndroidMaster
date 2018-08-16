package cn.white.ymc.wanandroidmaster.ui.system.systemdetail.SystemDetailList.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.data.bean.SystemDetailListBean;

/**
 * 体系 二级 列表界面 item 适配器 （和 home adapter 类似）
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.system.systemdetail.SystemDetailList.adapter
 * @fileName: SystemDetailItemAdapter
 * @date: 2018/8/16  14:53
 * @author: ymc
 * @QQ:745612618
 */

public class SystemDetailItemAdapter extends BaseQuickAdapter<SystemDetailListBean.DatasBean,BaseViewHolder> {

    public SystemDetailItemAdapter(int layoutResId, @Nullable List<SystemDetailListBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SystemDetailListBean.DatasBean item) {
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
            String classifyName = item.getSuperChapterName() + " / " + item.getChapterName();
            helper.setText(R.id.tv_type, classifyName);
        }
        helper.addOnClickListener(R.id.image_collect);
        helper.setImageResource(R.id.image_collect, item.isCollect() ? R.drawable.icon_collect : R.drawable.icon_no_collect);
    }
}
