package cn.white.ymc.wanandroidmaster.ui.demo.demolist.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

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

    }
}
