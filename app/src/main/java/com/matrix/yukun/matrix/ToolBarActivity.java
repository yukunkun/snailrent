package com.matrix.yukun.matrix;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public abstract class ToolBarActivity extends BaseActivity {

    @BindView(R.id.toobar)
    Toolbar mToobar;
    @BindView(R.id.ll_content)
    LinearLayout mLlContent;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    private View mInflate;

    @Override
    protected int getLayout() {
        return R.layout.activity_tool_bar;
    }

    @Override
    protected void initView() {
        mLlContent.addView(addView());
    }

    private View addView() {
        mInflate = LayoutInflater.from(this).inflate(getChildLayout(), null);
        return mInflate;
    }

    public View getView() {
        return mInflate;
    }

    ;

    protected abstract int getChildLayout();

    @Override
    protected void addListener() {
        super.addListener();

    }

    protected void setTitle(String txt) {
        mTvTitle.setText(txt);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
