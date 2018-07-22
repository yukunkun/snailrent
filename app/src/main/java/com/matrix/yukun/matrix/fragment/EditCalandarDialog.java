package com.matrix.yukun.matrix.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.matrix.yukun.matrix.BaseCenterDialog;
import com.matrix.yukun.matrix.R;
import com.matrix.yukun.matrix.util.ScreenUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/7/22.
 */

public class EditCalandarDialog extends DialogFragment {
    @BindView(R.id.tv_add_con)
    TextView mTvAddCon;
    @BindView(R.id.tv_categray)
    TextView mTvCategray;
    @BindView(R.id.et_categray)
    EditText mEtCategray;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.tv_real_time)
    TextView mTvRealTime;
    @BindView(R.id.et_time)
    EditText mEtTime;
    @BindView(R.id.tv_please)
    TextView mTvPlease;
    @BindView(R.id.et_please)
    EditText mEtPlease;
    @BindView(R.id.et_content)
    EditText mEtContent;
    String time="";

    public static EditCalandarDialog getInstance(String time){
        EditCalandarDialog editCalandarDialog=null;
        if(editCalandarDialog==null){
            editCalandarDialog=new EditCalandarDialog();
            Bundle bundle=new Bundle();
            bundle.putString("time",time);
            editCalandarDialog.setArguments(bundle);
        }
        return editCalandarDialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        time=getArguments().getString("time");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题
        View view=inflater.from(getContext()).inflate(R.layout.dialog_edit_calandar,null);
        ButterKnife.bind(this, view);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(200,0,0,0)));//设置背景透明
        mTvRealTime.setText(time);
        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        //得到dialog对应的window
        Window window = getDialog().getWindow();
        if (window != null) {
            // 设置弹出框布局参数，宽度铺满全屏，底部。
            WindowManager.LayoutParams wlp = window.getAttributes();
            wlp.gravity = Gravity.BOTTOM;
            wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
            window.setAttributes(wlp);
        }
    }

    @OnClick(R.id.tv_add_con)
    public void onViewClicked() {
        if(TextUtils.isEmpty(mEtCategray.getText().toString().trim())||
                TextUtils.isEmpty(mEtPlease.getText().toString().trim())||
                TextUtils.isEmpty(mEtTime.getText().toString().trim())||
                TextUtils.isEmpty(mEtContent.getText().toString().trim())){
            Toast.makeText(getContext(), "请填写完整内容", Toast.LENGTH_SHORT).show();
        }else {
            getDialog().dismiss();
        }
    }
}
