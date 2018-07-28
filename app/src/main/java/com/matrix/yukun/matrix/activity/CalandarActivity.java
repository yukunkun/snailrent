package com.matrix.yukun.matrix.activity;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.matrix.yukun.matrix.R;
import com.matrix.yukun.matrix.ToolBarActivity;


public class CalandarActivity extends ToolBarActivity implements SwipeRefreshLayout.OnRefreshListener {

    RecyclerView mRvList;
    SwipeRefreshLayout mSw;

    @Override
    protected void initView() {
        super.initView();
        setTitle("备忘录");
        mSw=getView().findViewById(R.id.sw);
        mRvList=getView().findViewById(R.id.rv_list);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        mRvList.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void addListener() {
        super.addListener();
        mSw.setOnRefreshListener(this);
    }

    @Override
    protected int getChildLayout() {
        return R.layout.activity_calandar;
    }

    @Override
    public void onRefresh() {
        mSw.setRefreshing(false);
    }
}
