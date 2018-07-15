package com.matrix.yukun.matrix.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matrix.yukun.matrix.R;
import com.matrix.yukun.matrix.myholder.HeaderHorizontalHolder;
import com.matrix.yukun.matrix.myholder.MainHeaderCommonHolder;
import com.matrix.yukun.matrix.myholder.MainHeaderHolder;

/**
 * Created by Administrator on 2018/7/8.
 */

public class RVHorizontalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;

    public RVHorizontalAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.horizontal_item,null);
        return new HeaderHorizontalHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
