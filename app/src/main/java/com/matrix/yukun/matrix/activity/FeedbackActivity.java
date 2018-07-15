package com.matrix.yukun.matrix.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.matrix.yukun.matrix.R;
import com.matrix.yukun.matrix.ToolBarActivity;

public class FeedbackActivity extends ToolBarActivity implements View.OnClickListener {

    private EditText mEt_con;
    private EditText mEt_phone;
    private TextView mTv_send;

    @Override
    protected int getChildLayout() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void initView() {
        super.initView();
        setTitle("反馈");
        mEt_con = getView().findViewById(R.id.et_con);
        mEt_phone = getView().findViewById(R.id.et_phone);
        mTv_send = getView().findViewById(R.id.tv_send);

    }

    @Override
    protected void addListener() {
        super.addListener();
        mTv_send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(mEt_con.getText().toString().trim())){
            Toast.makeText(this, "请输入反馈内容", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(mEt_con.getText().toString().trim())){
            Toast.makeText(this, "请输入联系方式", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "反馈成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}
