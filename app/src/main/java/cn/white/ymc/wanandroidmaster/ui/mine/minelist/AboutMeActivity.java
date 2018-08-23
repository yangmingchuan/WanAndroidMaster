package cn.white.ymc.wanandroidmaster.ui.mine.minelist;

import android.support.design.widget.AppBarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseActivity;

/**
 * 关于我们界面
 * @author ymc
 */

public class AboutMeActivity extends BaseActivity {
    @BindView(R.id.article_toolbar)
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
        setSupportActionBar(toolbarCommon);
        getSupportActionBar().setTitle(R.string.about_us);
        toolbarCommon.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvContent.setText(Html.fromHtml(getString(R.string.about_content)));
    }

    @Override
    protected void initData() {

    }

}
