package cn.white.ymc.wanandroidmaster.ui.home.homedetail;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import com.just.agentweb.AgentWeb;
import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseActivity;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;

/**
 * 首页详细信息界面
 *
 * @author ymc
 */

public class HomeDetailActivity extends BaseActivity {
    @BindView(R.id.article_toolbar)
    Toolbar articleToolbar;
    @BindView(R.id.article_detail_web_view)
    FrameLayout articleDetailWebView;
    private AgentWeb agentWeb;
    private String title;
    private String detailLink;
    private int detailId;
    private boolean isCollect;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_detail;
    }

    @Override
    protected void initView() {
        setSupportActionBar(articleToolbar);
        getSupportActionBar().setTitle(title);
        articleToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            title = bundle.getString(ConstantUtil.HOME_DETAIL_TITLE);
            detailLink = bundle.getString(ConstantUtil.HOME_DETAIL_PATH);
            detailId = bundle.getInt(ConstantUtil.HOME_DETAIL_ID, ConstantUtil.REQUEST_ERROR);
            isCollect = bundle.getBoolean(ConstantUtil.HOME_DETAIL_IS_COLLECT);
        }

    }

}
