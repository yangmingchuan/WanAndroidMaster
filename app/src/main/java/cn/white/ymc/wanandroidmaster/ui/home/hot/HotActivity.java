package cn.white.ymc.wanandroidmaster.ui.home.hot;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import cn.white.ymc.wanandroidmaster.R;
import cn.white.ymc.wanandroidmaster.base.BaseResultActivity;
import cn.white.ymc.wanandroidmaster.data.bean.HotBean;
import cn.white.ymc.wanandroidmaster.ui.home.homedetail.HomeDetailActivity;
import cn.white.ymc.wanandroidmaster.util.ColorUtil;
import cn.white.ymc.wanandroidmaster.util.ConstantUtil;
import cn.white.ymc.wanandroidmaster.util.JumpUtil;

/**
 * 最热网站
 *
 * 2018年8月23日 16:46:25
 *
 * @author ymc
 */

public class HotActivity extends BaseResultActivity implements HotContract.View{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.id_flowlayout)
    TagFlowLayout idFlowlayout;

    private HotContract.Presenter presenter;
    private List<HotBean> beanList;
    private TagAdapter<HotBean> adapter;

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
        showLoading();
    }

    @Override
    protected void initData() {
        presenter = new HotPresenter(this);
        beanList = new LinkedList<>();
        presenter.getHotList();
    }

    @Override
    public void getHotResultOK(List<HotBean> hotBeans) {
        beanList.clear();
        beanList.addAll(hotBeans);
        adapter = new TagAdapter<HotBean>(hotBeans) {
            @Override
            public View getView(FlowLayout parent, int position, HotBean hotBean) {
                TextView textView = (TextView) getLayoutInflater().inflate(R.layout.textview_item_hot,null);
                textView.setText(hotBean.getName());
                textView.setTextColor(ColorUtil.getRandomColor());
                return textView;
            }
        };
        idFlowlayout.setAdapter(adapter);
        idFlowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Bundle bundle = new Bundle();
                bundle.putString(ConstantUtil.HOME_DETAIL_TITLE, beanList.get(position).getName());
                bundle.putString(ConstantUtil.HOME_DETAIL_PATH, beanList.get(position).getLink());
                JumpUtil.overlay(activity, HomeDetailActivity.class, bundle);
                return false;
            }
        });
        showNormal();
    }

    @Override
    public void getHotResultErr(String err) {
        showError(err);
    }

    @Override
    public void reload() {
        super.reload();
        showLoading();
        presenter.getHotList();
    }
}
