package com.matrix.yukun.matrix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iflytek.sunflower.FlowerCollector;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    //  讯飞统计的 Appid： 	58833c92

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initView();
        addListener();
    }

    protected  void addListener(){

    }

    protected abstract int getLayout();

    protected abstract void initView();

    @Override
    protected void onResume() {
        super.onResume();
        FlowerCollector.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        FlowerCollector.onPause(this);
    }
}
