package com.matrix.yukun.matrix.adapter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.matrix.yukun.matrix.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/11.
 */

public class LVAdapter extends BaseAdapter {
    Context mContext;
    List<Integer> mIntegerList=new ArrayList<>();
    String[] mStringList;

    public LVAdapter(Context context) {
        mContext = context;
        mStringList=context.getResources().getStringArray(R.array.setting);
        mIntegerList.add(R.mipmap.icon_small_bird);
        mIntegerList.add(R.mipmap.icon_chris);
        mIntegerList.add(R.mipmap.icon_snowman);
        mIntegerList.add(R.mipmap.icon_tree);
        mIntegerList.add(R.mipmap.icon_bird);
        mIntegerList.add(R.mipmap.icon_ball);
    }

    @Override
    public int getCount() {
        return mStringList.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=LayoutInflater.from(mContext).inflate(R.layout.setting_item_layout,null);
        ImageView imageView=convertView.findViewById(R.id.iv_icon);
        TextView tv_setting=convertView.findViewById(R.id.tv_setting);
        TextView tv_num=convertView.findViewById(R.id.tv_con);
        ImageView iv_next=convertView.findViewById(R.id.iv_next);
        imageView.setImageResource(mIntegerList.get(position));
        tv_setting.setText(mStringList[position]);
        if(position==3){
            iv_next.setVisibility(View.GONE);
            try {
                PackageManager pm = mContext.getPackageManager();
                PackageInfo pi = pm.getPackageInfo(mContext.getPackageName(), 0);
                String versionName = pi.versionName;
                tv_num.setText("V " + versionName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            iv_next.setVisibility(View.VISIBLE);
        }
        return convertView;
    }
}
