package cn.white.ymc.wanandroidmaster.ui.fragment.home.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseViewHolder;
import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;

/**
 * @packageName: cn.white.ymc.wanandroidmaster.ui.fragment.home.adapter
 * @fileName: HomePageAdaper
 * @date: 2018/8/8  14:31
 * @author: ymc
 * @QQ:745612618
 */

public class HomePageHolder extends BaseViewHolder {

    @BindView(R.id.tv_author)
    TextView mTvAuthor;
    @BindView(R.id.tv_type)
    TextView mTvType;
    @BindView(R.id.tv_content)
    TextView mTvContent;
    @BindView(R.id.image_collect)
    ImageView mImageCollect;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.tv_tag)
    TextView mTvTag;

    public HomePageHolder(View view) {
        super(view);
    }

}
