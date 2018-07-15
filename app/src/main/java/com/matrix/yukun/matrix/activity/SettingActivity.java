package com.matrix.yukun.matrix.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.matrix.yukun.matrix.BaseActivity;
import com.matrix.yukun.matrix.R;
import com.matrix.yukun.matrix.ToolBarActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class SettingActivity extends ToolBarActivity implements View.OnClickListener {

    private RelativeLayout mRl_cover;
    private RelativeLayout mLl_re_name;
    private CircleImageView mCv_cover;

    @Override
    protected int getChildLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {
        super.initView();
        setTitle("设置");
        mRl_cover = getView().findViewById(R.id.rl_header);
        mLl_re_name = getView().findViewById(R.id.ll_rname);
        mCv_cover = getView().findViewById(R.id.cv_cover);
    }

    @Override
    protected void addListener() {
        super.addListener();
        mLl_re_name.setOnClickListener(this);
        mLl_re_name.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_re_cover:

                break;
            case R.id.ll_rname:

                break;
        }
    }
}
