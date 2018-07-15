package com.matrix.yukun.matrix.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.matrix.yukun.matrix.R;
import com.matrix.yukun.matrix.activity.PositionActivity;
import com.matrix.yukun.matrix.content.HeaderConfig;
import com.matrix.yukun.matrix.myholder.MainHeader2Holder;
import com.matrix.yukun.matrix.myholder.MainHeaderCommonHolder;
import com.matrix.yukun.matrix.myholder.MainHeaderHolder;
import com.matrix.yukun.matrix.myholder.MainHeaderListHolder;
import com.matrix.yukun.matrix.util.ActivityUtils;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/7/7.
 */

public class MainRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    Context mContext;

    public MainRVAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == HeaderConfig.MAINHEADER_1) {
            view = LayoutInflater.from(mContext).inflate(R.layout.rv_header_layout, null);
            return new MainHeaderHolder(view);
        }  else if (viewType == HeaderConfig.MAINHEADER_2) {
            view = LayoutInflater.from(mContext).inflate(R.layout.rv_header_item2_layout, null);
            return new MainHeader2Holder(view);
        } else if (viewType == HeaderConfig.MAINHEADER_3) {
            view = LayoutInflater.from(mContext).inflate(R.layout.rv_header_content_item, null);
            return new MainHeaderListHolder(view);
        } else if (viewType == HeaderConfig.MAINHEADER_4) {
            view = LayoutInflater.from(mContext).inflate(R.layout.rv_header_common_item, null);
            return new MainHeaderCommonHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MainHeaderHolder) {

        }else if(holder instanceof MainHeader2Holder) {
            ((MainHeader2Holder) holder).mLlHeaderPosition.setOnClickListener(this);

        } else if (holder instanceof MainHeaderListHolder) {
            RecyclerView recyclerView = ((MainHeaderListHolder) holder).mRecyclerView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            RVHorizontalAdapter rvHorizontalAdapter = new RVHorizontalAdapter(mContext);
            recyclerView.setAdapter(rvHorizontalAdapter);

        } else if (holder instanceof MainHeaderCommonHolder) {

        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HeaderConfig.MAINHEADER_1;
        }else if(position == 1 ){
            return HeaderConfig.MAINHEADER_2;
        } else if (position == 2 || position == 3) {
            return HeaderConfig.MAINHEADER_3;
        } else {
            return HeaderConfig.MAINHEADER_4;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_header_position:
                ActivityUtils.startPositionActivity(mContext);
                break;
        }
    }
}
