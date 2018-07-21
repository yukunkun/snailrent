package com.matrix.yukun.matrix.fragment;

import android.view.View;

import com.matrix.yukun.matrix.BaseFragment;
import com.matrix.yukun.matrix.R;

/**
 * Created by Administrator on 2018/7/20.
 */

public class CalandarFragment extends BaseFragment {

    public static CalandarFragment getInstance() {
        CalandarFragment mineFragment = new CalandarFragment();
        return mineFragment;
    }
    @Override
    protected int getLayout() {
        return R.layout.fragment_calandar_layout;
    }

    @Override
    protected void initView(View view) {

    }
}
