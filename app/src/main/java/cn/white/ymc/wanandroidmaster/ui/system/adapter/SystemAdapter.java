package cn.white.ymc.wanandroidmaster.ui.system.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.data.bean.SystemBean;

/**
 * 体系界面列表 适配器
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.fragment.system.adapter
 * @fileName: SystemAdapter
 * @date: 2018/8/13  14:21
 * @author: ymc
 * @QQ:745612618
 */

public class SystemAdapter extends BaseQuickAdapter<SystemBean,BaseViewHolder> {

    public SystemAdapter(int layoutResId, @Nullable List<SystemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SystemBean item) {
        helper.setText(R.id.tv_knowledge_title, item.getName());
        StringBuilder sb = new StringBuilder();
        for (SystemBean.ChildrenBean childrenBean : item.getChildren()) {
            sb.append(childrenBean.getName()).append("      ");
        }
        helper.setText(R.id.tv_knowledge_content, sb.toString());
    }
}
