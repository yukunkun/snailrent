package com.matrix.yukun.matrix.myholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.matrix.yukun.matrix.R;

/**
 * Created by Administrator on 2018/7/8.
 */

public class HeaderHorizontalHolder extends RecyclerView.ViewHolder {
    ImageView mImageView;
    public HeaderHorizontalHolder(View itemView) {
        super(itemView);
        mImageView=itemView.findViewById(R.id.iv_cover);
    }
}
