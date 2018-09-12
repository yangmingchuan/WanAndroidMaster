package cn.white.ymc.wanandroidmaster.ui;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseActivity;
import cn.white.ymc.wanandroidmaster.ui.home.HomeActivity;
import cn.white.ymc.wanandroidmaster.util.JumpUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.observers.DisposableLambdaObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * 2018年7月23日 10:48:06
 * 欢迎界面
 *
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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Long>() {
                    @Override
                    public void onNext(Long aLong) {
                        JumpUtil.overlay(SplashActivity.this, HomeActivity.class);
                        finish();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
