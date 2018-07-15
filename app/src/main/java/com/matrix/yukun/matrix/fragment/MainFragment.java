package com.matrix.yukun.matrix.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.matrix.yukun.matrix.BaseFragment;
import com.matrix.yukun.matrix.R;
import com.matrix.yukun.matrix.adapter.MainRVAdapter;
import com.scwang.smartrefresh.header.WaterDropHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;

/**
 * Created by Administrator on 2018/7/8.
 */

public class MainFragment extends BaseFragment {

    @BindView(R.id.rv_list)
    RecyclerView mRvList;
    @BindView(R.id.sm_layout)
    SmartRefreshLayout mSmLayout;
    @BindView(R.id.rl_header)
    RelativeLayout mRlHeader;
    boolean isScrol=false;
    private LinearLayoutManager mLinearLayoutManager;

    public static MainFragment getInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView(View view) {
        mSmLayout.setRefreshHeader(new WaterDropHeader(getContext()));
        mSmLayout.setRefreshFooter(new BallPulseFooter(getContext()));
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRvList.setLayoutManager(mLinearLayoutManager);
        MainRVAdapter mainRVAdapter = new MainRVAdapter(getContext());
        mRvList.setAdapter(mainRVAdapter);
    }

    @Override
    protected void addListener() {
        mRvList.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState== RecyclerView.SCROLL_STATE_IDLE){
                    isScrol=false;
                }else if(newState==RecyclerView.SCROLL_STATE_DRAGGING ){
                    isScrol=true;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int position = mLinearLayoutManager.findFirstVisibleItemPosition();
                if(position>=1&&dy>0){
                    mRlHeader.setVisibility(View.VISIBLE);
                }else if(dy<0){
                    mRlHeader.setVisibility(View.GONE);
                }
            }
        });
    }
}
