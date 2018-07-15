package com.matrix.yukun.matrix.myholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.matrix.yukun.matrix.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/7/7.
 */

public class MainHeaderHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.cb_banner)
    public ConvenientBanner mCbBanner;
    @BindView(R.id.ll_header_main_search)
    public LinearLayout mLlHeaderMainSearch;
    public MainHeaderHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
