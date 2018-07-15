package com.matrix.yukun.matrix.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.matrix.yukun.matrix.R;
import com.matrix.yukun.matrix.ToolBarActivity;

import uk.co.senab.photoview.PhotoView;

public class CoverActivity extends ToolBarActivity {

    private PhotoView mPhotoView;

    @Override
    protected int getChildLayout() {
        return R.layout.activity_cover;
    }
    @Override
    protected void initView() {
        super.initView();
        setTitle("头像");
        mPhotoView = getView().findViewById(R.id.pv_cover);
        mPhotoView.setImageResource(R.mipmap.tool_app_ic);
    }
}
