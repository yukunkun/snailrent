package com.matrix.yukun.matrix;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/7/8.
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(getLayout(),null);
        ButterKnife.bind(this,view);
        initView(view);
        addListener();
        return view;
    }

    protected abstract int getLayout();

    protected abstract void initView(View view);

    protected void addListener() {

    }
}
