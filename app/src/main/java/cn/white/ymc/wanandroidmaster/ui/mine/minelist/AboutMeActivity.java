package cn.white.ymc.wanandroidmaster.ui.mine.minelist;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseActivity;

/**
 * 关于我们界面
 * @author ymc
 */

public class AboutMeActivity extends BaseActivity {
    @BindView(R.id.toolbar_common)
    Toolbar toolbarCommon;
    @BindView(R.id.applayout)
    AppBarLayout applayout;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_me;
    }

    @Override
    protected void initView() {
        tvContent.setText(Html.escapeHtml(getString(R.string.about_content)));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
