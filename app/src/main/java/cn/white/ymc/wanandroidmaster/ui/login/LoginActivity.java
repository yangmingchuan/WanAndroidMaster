package cn.white.ymc.wanandroidmaster.ui.login;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.OnClick;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseActivity;
import cn.white.ymc.wanandroidmaster.data.bean.UserInfo;
import cn.white.ymc.wanandroidmaster.ui.home.HomeActivity;
import cn.white.ymc.wanandroidmaster.ui.register.RegisterActivity;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import cn.white.ymc.wanandroidmaster.util.JumpUtil;
import cn.white.ymc.wanandroidmaster.util.SharedPreferenceUtil;
import cn.white.ymc.wanandroidmaster.util.toast.ToastUtil;

/**
 * 2018年7月23日 11:37:33
 * 登录界面
 *
 * @author ymc
 */
public class LoginActivity extends BaseActivity implements LoginContract.View{

    @BindView(R.id.toolbar_login)
    Toolbar toolbarLogin;
    @BindView(R.id.et_ensure_username)
    EditText etEnsureUsername;
    @BindView(R.id.et_ensure_password)
    EditText etEnsurePassword;

    private String username, password;
    LoginContract.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        presenter = new LoginPresenter(this);
    }

    @Override
    protected void initToolbar() {
        setSupportActionBar(toolbarLogin);
        getSupportActionBar().setTitle(getString(R.string.login));
        toolbarLogin.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_register, R.id.btn_login})
    void click(View view) {
        switch (view.getId()) {
            case R.id.tv_register:
                JumpUtil.overlay(context, RegisterActivity.class);
                break;
            case R.id.btn_login:
                if (check()){
                    presenter.login(username, password);
                }
                break;
                default:
                    break;
        }
    }

    private boolean check() {
        username = etEnsureUsername.getText().toString().trim();
        password = etEnsurePassword.getText().toString().trim();
        if (username.length() < 6 || password.length() < 6) {
            ToastUtil.show(context, getString(R.string.username_incorrect));
            return false;
        }
        return true;
    }

    @Override
    public void loginOk(UserInfo userInfo) {
        ToastUtil.show(activity, getString(R.string.login_ok));
        finish();
    }

    @Override
    public void loginErr(String info) {
        ToastUtil.show(activity, info);
    }

    @Override
    public void showNormal() {

    }

    @Override
    public void showError(String info) {

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
