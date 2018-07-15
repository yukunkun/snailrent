package com.matrix.yukun.matrix.fragment;

import android.view.View;

import com.matrix.yukun.matrix.BaseFragment;
import com.matrix.yukun.matrix.R;

/**
 * Created by Administrator on 2018/7/8.
 */

public class SearchFragment extends BaseFragment {

    public static SearchFragment getInstance(){
        SearchFragment searchFragment=new SearchFragment();
        return searchFragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_search;
    }

    @Override
    protected void initView(View view) {

    }
}
