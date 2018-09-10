package cn.white.ymc.wanandroidmaster.ui;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import java.util.concurrent.TimeUnit;
import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseActivity;
import cn.white.ymc.wanandroidmaster.ui.home.HomeActivity;
import cn.white.ymc.wanandroidmaster.ui.login.LoginActivity;
import cn.white.ymc.wanandroidmaster.util.JumpUtil;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 2018年7月23日 10:48:06
 * 欢迎界面
 * @author ymc
 */
public class SplashActivity extends BaseActivity {

    @BindView(R.id.iv_splash)
    ImageView ivSplash;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        Glide.with(context).load(R.mipmap.splash).into(ivSplash);
    }

    @Override
    protected void initData() {
        Observable.timer(1500, TimeUnit.MILLISECONDS)
                //.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        JumpUtil.overlay(SplashActivity.this, HomeActivity.class);
                        finish();
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
