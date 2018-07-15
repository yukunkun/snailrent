package com.matrix.yukun.matrix.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.matrix.yukun.matrix.BaseFragment;
import com.matrix.yukun.matrix.R;
import com.matrix.yukun.matrix.adapter.LVAdapter;
import com.matrix.yukun.matrix.selfview.MyListView;
import com.matrix.yukun.matrix.util.ActivityUtils;
import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

/**
 * Created by Administrator on 2018/7/8.
 */

public class MineFragment extends BaseFragment {

    @BindView(R.id.iv_setting)
    ImageView mIvSetting;
    @BindView(R.id.cv_head)
    CircleImageView mCvHead;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.ll_history)
    LinearLayout mLlHistory;
    @BindView(R.id.ll_collect)
    LinearLayout mLlCollect;
    @BindView(R.id.ll_more)
    LinearLayout mLlMore;
    @BindView(R.id.ll_adv)
    LinearLayout mLlAdv;
    @BindView(R.id.lv_list)
    MyListView mLvList;
    @BindView(R.id.tv_logout)
    TextView mTvLogout;
    @BindView(R.id.scrollview)
    ScrollView mScrollView;
    private String PATH="http://sj.qq.com/myapp/detail.htm?apkName=com.matrix.yukun.matrix";
    public static MineFragment getInstance() {
        MineFragment mineFragment = new MineFragment();
        return mineFragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View view) {
        OverScrollDecoratorHelper.setUpOverScroll(mScrollView);
        LVAdapter lvAdapter=new LVAdapter(getContext());
        mLvList.setAdapter(lvAdapter);
        mLvList.setFocusable(false);
    }

    @Override
    protected void addListener() {
        mLvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                }else if(position==1){
                    ActivityUtils.startFeedbackActivity(getContext());
                }else if(position==2){
                    ActivityUtils.startUriSearch(getContext());
                }else if(position==3){
                    ActivityUtils.startAPPDownload(getContext(),PATH);
                }else if(position==4){

                }
            }
        });
    }

    @OnClick({R.id.iv_setting, R.id.cv_head, R.id.tv_name, R.id.tv_phone, R.id.ll_history, R.id.ll_collect,
            R.id.ll_more, R.id.tv_logout})
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id==R.id.iv_setting){
            ActivityUtils.startSetingActivity(getContext());
        }
        if(id==R.id.cv_head){
            ActivityUtils.startPhotoActivity(getContext());
        }if(id==R.id.tv_name){
            ActivityUtils.startSetingActivity(getContext());
        }if(id==R.id.tv_phone){
            ActivityUtils.startSetingActivity(getContext());
        }if(id==R.id.ll_history){

        }if(id==R.id.ll_collect){

        }if(id==R.id.ll_more){

        }if(id==R.id.tv_logout){

        }
    }
}
