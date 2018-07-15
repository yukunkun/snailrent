package com.matrix.yukun.matrix.myholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.matrix.yukun.matrix.R;

/**
 * Created by Administrator on 2018/7/8.
 */

public class MainHeaderListHolder extends RecyclerView.ViewHolder {
    public TextView mTextView;
    public RecyclerView mRecyclerView;
    public MainHeaderListHolder(View itemView) {
        super(itemView);
        mTextView=itemView.findViewById(R.id.tv_hot);
        mRecyclerView=itemView.findViewById(R.id.rv_vertical_list);
    }
}
