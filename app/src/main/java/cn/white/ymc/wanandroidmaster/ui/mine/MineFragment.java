package cn.white.ymc.wanandroidmaster.ui.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import butterknife.BindView;
import butterknife.OnClick;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseFragment;
import cn.white.ymc.wanandroidmaster.ui.login.LoginActivity;
import cn.white.ymc.wanandroidmaster.ui.mine.minelist.AboutMeActivity;
import cn.white.ymc.wanandroidmaster.ui.mine.minelist.CollectionListActivity;
import cn.white.ymc.wanandroidmaster.ui.mine.minelist.adapter.CollectionListAdapter;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import cn.white.ymc.wanandroidmaster.util.JumpUtil;
import cn.white.ymc.wanandroidmaster.util.SharedPreferenceUtil;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 我的界面
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.mine
 * @fileName: MineFragment
 * @date: 2018/7/27  9:07
 * @author: ymc
 * @QQ:745612618
 */

public class MineFragment extends BaseFragment {

    @BindView(R.id.image_head)
    CircleImageView imageHead;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.image_collect)
    ImageView imageCollect;
    @BindView(R.id.view_collect)
    RelativeLayout viewCollect;
    @BindView(R.id.image_todo)
    ImageView imageTodo;
    @BindView(R.id.view_todo)
    RelativeLayout viewTodo;
    @BindView(R.id.image_about)
    ImageView imageAbout;
    @BindView(R.id.view_about)
    RelativeLayout viewAbout;
    @BindView(R.id.tv_logout)
    TextView tvLogout;

    private boolean haslogin;
    private String userName;

    public static MineFragment getInstance() {
        return new MineFragment();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initUI() {
        super.initUI();
        Glide.with(context).load(R.drawable.icon_head).into(imageHead);
    }

    @Override
    protected void initData() {
        haslogin = (boolean) SharedPreferenceUtil.get(context, ConstantUtil.ISLOGIN,false);
        userName = (String) SharedPreferenceUtil.get(context,ConstantUtil.USERNAME,ConstantUtil.USERNAME);
        tvUsername.setText(haslogin? userName : getString(R.string.click_head_login));
        imageHead.setEnabled(!haslogin);
    }

    @OnClick({R.id.view_collect, R.id.view_todo, R.id.view_about,R.id.image_head})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.view_collect:
                JumpUtil.overlay(context, CollectionListActivity.class);
                break;
            case R.id.view_todo:

                break;
            case R.id.view_about:
                JumpUtil.overlay(context, AboutMeActivity.class);
                break;
            case R.id.image_head:
                JumpUtil.overlay(context, LoginActivity.class);
                break;
                default:
                    break;
        }
    }
}
