package com.matrix.yukun.matrix.myholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.matrix.yukun.matrix.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/7/14.
 */

public class MainHeader2Holder extends RecyclerView.ViewHolder {
    @BindView(R.id.ll_header_search)
    public LinearLayout mLlHeaderSearch;
    @BindView(R.id.ll_header_position)
    public LinearLayout mLlHeaderPosition;
    @BindView(R.id.ll_header_more)
    public LinearLayout mLlHeaderMore;
    @BindView(R.id.rl_adv)
    public RelativeLayout mRlAdv;
    @BindView(R.id.ll_search)
    public LinearLayout mLlSearch;
    @BindView(R.id.ll_position)
    public LinearLayout mLlPosition;
    @BindView(R.id.ll_baike)
    public LinearLayout mLlBaike;
    @BindView(R.id.ll_)
    public LinearLayout mLl;
    public MainHeader2Holder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}
