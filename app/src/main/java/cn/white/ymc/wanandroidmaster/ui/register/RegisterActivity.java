package cn.white.ymc.wanandroidmaster.ui.register;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.OnClick;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseActivity;
import cn.white.ymc.wanandroidmaster.data.bean.UserInfo;
import cn.white.ymc.wanandroidmaster.ui.login.LoginActivity;
import cn.white.ymc.wanandroidmaster.util.JumpUtil;
import cn.white.ymc.wanandroidmaster.util.toast.ToastUtil;

/**
 * 用户注册界面
 *
 * @author ymc
 * @date 2018年7月24日 16:07:12
 */

public class RegisterActivity extends BaseActivity implements RegisterContract.View {

    @BindView(R.id.toolbar_register)
    Toolbar toolbarRegister;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_ensure_password)
    EditText etEnsurePassword;
    @BindView(R.id.btn_register)
    Button btnRegister;

    private RegisterPresenter presenter;
    private String username;
    private String password;
    private String ensurePassword;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        presenter = new RegisterPresenter(this);
    }

    @Override
    protected void initToolbar() {
        setSupportActionBar(toolbarRegister);
        getSupportActionBar().setTitle(getString(R.string.register));
        toolbarRegister.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.btn_register})
    public void onClick(View v){
        if(checkRegisterMsg()){
            presenter.register(username,password,ensurePassword);
        }
    }

    private boolean checkRegisterMsg() {
        username = etUsername.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        ensurePassword = etEnsurePassword.getText().toString().trim();
        if (username.length() < 6 || password.length() < 6) {
            ToastUtil.show(context, getString(R.string.username_incorrect));
            return false;
        } else if (!password.equals(ensurePassword)) {
            ToastUtil.show(context, getString(R.string.password_incorrect));
            return false;
        }
        return true;
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

    @Override
    public void registerOk(UserInfo userInfo) {
        ToastUtil.show(activity, getString(R.string.register_ok));
        JumpUtil.overlay(activity, LoginActivity.class);
        finish();
    }

    @Override
    public void registerErr(String info) {
        ToastUtil.show(activity, info);
    }

}
