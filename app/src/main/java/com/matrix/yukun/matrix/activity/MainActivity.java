package com.matrix.yukun.matrix.activity;


import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.matrix.yukun.matrix.BaseActivity;
import com.matrix.yukun.matrix.R;
import com.matrix.yukun.matrix.fragment.CalandarFragment;
import com.matrix.yukun.matrix.fragment.MainFragment;
import com.matrix.yukun.matrix.fragment.MineFragment;
import com.matrix.yukun.matrix.fragment.SearchFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_layout)
    FrameLayout mFlLayout;
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.index)
    RadioButton mIndex;
    @BindView(R.id.collect)
    RadioButton mCollect;
    @BindView(R.id.me)
    RadioButton mMe;
    @BindView(R.id.rg)
    RadioGroup mRg;
    List<Fragment> mFragmentList=new ArrayList<>();
    private int lastPos=0;

    @Override
    protected int getLayout() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        addFragment();
    }

    @Override
    protected void addListener() {
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.index:
                        ((RadioButton) (mRg.getChildAt(0))).setChecked(true);
                        show(0);
                        break;
                    case R.id.collect:
                        ((RadioButton) (mRg.getChildAt(1))).setChecked(true);
                        show(1);
                        break;
                    case R.id.calandar:
                        ((RadioButton) (mRg.getChildAt(2))).setChecked(true);
                        show(2);
                        break;
                    case R.id.me:
                        ((RadioButton) (mRg.getChildAt(3))).setChecked(true);
                        show(3);
                        break;
                }
            }
        });
    }

    /**
     * fragment 的show和hide
     * @param pos
     */
    public void show(int pos) {
        Fragment fragment = mFragmentList.get(pos);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(mFragmentList.get(lastPos));

        if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.add(R.id.fl_layout, fragment);
        }
        fragmentTransaction.commit();
        lastPos = pos;
    }


    private void addFragment() {
        MainFragment mainFragment= MainFragment.getInstance();
        SearchFragment searchFragment=SearchFragment.getInstance();
        MineFragment mineFragment=MineFragment.getInstance();
        CalandarFragment calandarFragment=CalandarFragment.getInstance();
        mFragmentList.add(mainFragment);
        mFragmentList.add(searchFragment);
        mFragmentList.add(calandarFragment);
        mFragmentList.add(mineFragment);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_layout, mainFragment);
        fragmentTransaction.commit();

        ((RadioButton) (mRg.getChildAt(0))).setChecked(true);
    }

}
