package cn.white.ymc.wanandroidmaster.ui.demo.demolist.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.data.bean.DemoDetailListBean;

/**
 * 项目 内容列表适配器
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.demo.adapter
 * @fileName: DemoDetailListAdapter
 * @date: 2018/8/17  10:36
 * @author: ymc
 * @QQ:745612618
 */

public class DemoDetailListAdapter extends BaseQuickAdapter<DemoDetailListBean.DatasBean,BaseViewHolder>{

    public DemoDetailListAdapter(int layoutResId, @Nullable List<DemoDetailListBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DemoDetailListBean.DatasBean item) {
        if (!TextUtils.isEmpty(item.getTitle())) {
            helper.setText(R.id.tv_title, item.getTitle());
        }
        if (!TextUtils.isEmpty(item.getDesc())) {
            helper.setText(R.id.tv_content, item.getDesc());
        }
        if (!TextUtils.isEmpty(item.getNiceDate())) {
            helper.setText(R.id.tv_time, item.getNiceDate());
        }
        if (!TextUtils.isEmpty(item.getAuthor())) {
            helper.setText(R.id.tv_author, item.getAuthor());
        }
        Glide.with(mContext).load(item.getEnvelopePic()).into((ImageView) helper.getView(R.id.image_simple));
    }
}
