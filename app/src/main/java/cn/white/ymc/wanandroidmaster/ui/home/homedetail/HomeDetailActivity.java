package cn.white.ymc.wanandroidmaster.ui.home.homedetail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.transition.Visibility;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.LogUtils;

import java.lang.reflect.Method;

import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseActivity;
import cn.white.ymc.wanandroidmaster.ui.fragment.home.HomeContract;
import cn.white.ymc.wanandroidmaster.ui.login.LoginActivity;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import cn.white.ymc.wanandroidmaster.util.JumpUtil;
import cn.white.ymc.wanandroidmaster.util.Log.AppLogMessageUtil;
import cn.white.ymc.wanandroidmaster.util.SharedPreferenceUtil;
import cn.white.ymc.wanandroidmaster.util.toast.ToastUtil;

/**
 * 首页详细信息界面
 *
 * @author ymc
 */

@SuppressLint("SetJavaScriptEnabled")
public class HomeDetailActivity extends BaseActivity implements HomeDetailContract.view{
    @BindView(R.id.article_toolbar)
    Toolbar articleToolbar;
    @BindView(R.id.article_detail_web_view)
    FrameLayout articleDetailWebView;
    private AgentWeb agentWeb;
    private String title;
    private String detailLink;
    private int detailId;
    private boolean isCollect;
    private HomeDetailPresenter presenter;
    // 收藏状态
    private int collectInt = 0;

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
                // 共享元素 退出
                ActivityCompat.finishAfterTransition(HomeDetailActivity.this);
            }
        });
    }

    @Override
    protected void initData() {
        presenter = new HomeDetailPresenter(this);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            title = bundle.getString(ConstantUtil.HOME_DETAIL_TITLE);
            getSupportActionBar().setTitle(title);
            detailLink = bundle.getString(ConstantUtil.HOME_DETAIL_PATH);
            detailId = bundle.getInt(ConstantUtil.HOME_DETAIL_ID, ConstantUtil.REQUEST_ERROR);
            isCollect = bundle.getBoolean(ConstantUtil.HOME_DETAIL_IS_COLLECT);
        }

        agentWeb = AgentWeb.with(this)
                //传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams
                .setAgentWebParent(articleDetailWebView, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()// 使用默认进度条
                .createAgentWeb()//
                .ready()
                .go(detailLink);
        WebView mWebView = agentWeb.getWebCreator().getWebView();
        WebSettings mSettings = mWebView.getSettings();
        mSettings.setJavaScriptEnabled(true);
        mSettings.setSupportZoom(true);
        mSettings.setBuiltInZoomControls(true);
        //不显示缩放按钮
        mSettings.setDisplayZoomControls(false);
        //设置自适应屏幕，两者合用
        //将图片调整到适合WebView的大小
        mSettings.setUseWideViewPort(true);
        //缩放至屏幕的大小
        mSettings.setLoadWithOverviewMode(true);
        //自适应屏幕
        mSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail,menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 让菜单同时显示图标和文字
     *
     * @param featureId Feature id
     * @param menu      Menu
     * @return menu if opened
     */
    @SuppressLint("PrivateApi")
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equalsIgnoreCase("MenuBuilder")) {
                try {
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        switch (collectInt){
            case 1:
            case 4:
                isCollect = true;
                break;
            case 2:
            case 3:
                isCollect = false;
                break;
                default:
                    break;
        }
        menu.findItem(R.id.menu_article_collect).setIcon(isCollect ?
                R.drawable.icon_collect:R.drawable.icon_no_collect);
        menu.findItem(R.id.menu_article_collect).setTitle(isCollect ?
                getString(R.string.already_collect_title) : getString(R.string.like_title));
        return super.onPrepareOptionsMenu(menu);
    }

    /**
     * 菜单点击事件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            // 分享
            case R.id.menu_article_share:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "来自WanAndroid 【" + title + "】" + detailLink);
                startActivity(Intent.createChooser(shareIntent, "分享"));
                break;
            // 收藏
            case R.id.menu_article_collect:
                AppLogMessageUtil.e("homeDetailActivity: id :"+detailId +" - "+title);
                if((boolean)SharedPreferenceUtil.get(activity,ConstantUtil.ISLOGIN,ConstantUtil.FALSE)){
                    if(!isCollect){
                        presenter.collectArticle(detailId);
                    }else{
                        presenter.cancelCollectArticle(detailId);
                    }
                }else {
                    ToastUtil.show(activity, getString(R.string.please_login));
                    JumpUtil.overlay(activity, LoginActivity.class);
                }
                break;
                default:
                    break;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * 收藏成功
     * @param info
     */
    @Override
    public void collectArticleOK(String info) {
        collectInt = 1;
        ToastUtil.show(activity,getString(R.string.collect_success));
    }

    @Override
    public void collectArticleErr(String info) {
        collectInt = 2;
        if(info.contains(getString(R.string.please_login))){
            ToastUtil.show(activity, getString(R.string.please_login));
            JumpUtil.overlay(activity, LoginActivity.class);
        }else{
            ToastUtil.show(activity,getString(R.string.collect_fail)+info);
        }
    }

    /**
     * 取消收藏成功
     * @param info
     */
    @Override
    public void cancelCollectArticleOK(String info) {
        collectInt = 3;
        ToastUtil.show(activity,getString(R.string.cancel_collect_success));
    }

    @Override
    public void cancelCollectArticleErr(String info) {
        collectInt = 4;
        if(info.contains(getString(R.string.please_login))){
            ToastUtil.show(activity, getString(R.string.please_login));
            JumpUtil.overlay(activity, LoginActivity.class);
        }else{
            ToastUtil.show(activity,getString(R.string.cancel_collect_fail)+info);
        }
    }

    @Override
    public void showNormal() {

    }

    @Override
    public void showError(String err) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void reload() {

    }
}
