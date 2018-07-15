package com.matrix.yukun.matrix.activity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.matrix.yukun.matrix.R;
import com.matrix.yukun.matrix.ToolBarActivity;
import com.matrix.yukun.matrix.adapter.LVSortAdapter;
import com.matrix.yukun.matrix.bean.PinyinComparator;
import com.matrix.yukun.matrix.bean.SortModel;
import com.matrix.yukun.matrix.selfview.SideBar;
import com.matrix.yukun.matrix.util.Cn2Spell;
import com.matrix.yukun.matrix.util.ISideBarSelectCallBack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

public class PositionActivity extends ToolBarActivity {
    List<String> mStringList = new ArrayList<>();
//    @BindView(R.id.tv_city)
//    TextView mTvCity;
//    @BindView(R.id.tv_click_position)
//    TextView mTvClickPosition;
//    @BindView(R.id.lv_list)
    ListView mLvList;
//    @BindView(R.id.bar)
    SideBar mBar;
    private List<SortModel> mSortModule;


    @Override
    protected void initView() {
        super.initView();
        setTitle("位置");
        mLvList=getView().findViewById(R.id.lv_list);
        mBar=getView().findViewById(R.id.bar);
        infoMethod();
    }

    private void infoMethod() {
        mStringList = getCityList();
        mSortModule = getSortModule();
        LVSortAdapter cityAdapter = new LVSortAdapter(this, mSortModule);
        mLvList.setAdapter(cityAdapter);
    }

    private List<String> getCityList() {
        String json = getJson("city.json");
        try {
            JSONArray jsonA=new JSONArray(json);
            for (int j = 0; j < jsonA.length(); j++) {
                JSONObject jsonO = jsonA.optJSONObject(j);
                JSONArray jsonArray = jsonO.optJSONArray("cities");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.optJSONObject(i);
                    String areaName = jsonObject.optString("areaName");
                    mStringList.add(areaName);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mStringList;
    }

    private List<SortModel> getSortModule() {
        List<SortModel> filterDateList = new ArrayList<>();
        for (int i = 0; i < mStringList.size(); i++) {
            String pinYinFirstLetter = Cn2Spell.getPinYinFirstLetter(mStringList.get(i));
            filterDateList.add(new SortModel(mStringList.get(i),pinYinFirstLetter.toUpperCase().charAt(0)+""));
        }
        Collections.sort(filterDateList,new PinyinComparator());
        return filterDateList;
    }

    @Override
    protected int getChildLayout() {
        return R.layout.activity_position;
    }

    @Override
    protected void addListener() {
        super.addListener();
        mBar.setOnStrSelectCallBack(new ISideBarSelectCallBack() {
            @Override
            public void onSelectStr(int index, String selectStr) {
                if(mSortModule==null){
                    return;
                }
                for (int i = 0; i < mStringList.size() ; i++){
                    if(mSortModule.get(i).getSortLetters().equals(selectStr)){
                        mLvList.setSelection(i);
                        return;
                    }
                }
            }

            @Override
            public void onSelectEnd() {

            }

            @Override
            public void onSelectStart() {

            }
        });
    }

    public String getJson(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = this.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
