package com.matrix.yukun.matrix.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.matrix.yukun.matrix.R;
import com.matrix.yukun.matrix.bean.SortModel;

import java.util.List;

/**
 * Created by yukun on 17-12-19.
 */

public class LVSortAdapter extends BaseAdapter {
    private List<SortModel> list = null;
    private Context mContext;

    public LVSortAdapter(Context context,List<SortModel> list) {
        this.list = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.city_item_layout, null);
            viewHolder.tvTitle = view.findViewById(R.id.tv_city_name);
            viewHolder.tvLetter = view.findViewById(R.id.tv);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        int section = getSectionForPosition(position);
        if(position == getPositionForSection(section)){
            viewHolder.tvLetter.setVisibility(View.VISIBLE);
            viewHolder.tvLetter.setText(list.get(position).getSortLetters());
        }else{
            viewHolder.tvLetter.setVisibility(View.GONE);
        }
        viewHolder.tvTitle.setText(list.get(position).getName());
        return view;
    }

    final static class ViewHolder {
        TextView tvLetter;
        TextView tvTitle;
    }

    /**
     * 选中的位置
     */
    public int getSectionForPosition(int position) {
        return list.get(position).getSortLetters().charAt(0);
    }

    /**
     * 位置是否有,基本就能实现了，
     */
    public int getPositionForSection(int section) {
        for (int i = 0; i < getCount(); i++) {
            String sortStr = list.get(i).getSortLetters();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }
}
