package cn.white.ymc.wanandroidmaster.ui.home.hot;

import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;

import com.zhy.view.flowlayout.TagFlowLayout;

import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseResultActivity;

/**
 * 最热网站
 *
 * 2018年8月23日 16:46:25
 *
 * @author ymc
 */

public class HotActivity extends BaseResultActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.id_flowlayout)
    TagFlowLayout idFlowlayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hot;
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.hot_title));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initView() {
        super.initView();

    }

    @Override
    protected void initData() {

    }

}
