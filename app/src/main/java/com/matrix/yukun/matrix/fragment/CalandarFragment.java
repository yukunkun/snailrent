package com.matrix.yukun.matrix.fragment;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.matrix.yukun.matrix.BaseFragment;
import com.matrix.yukun.matrix.R;
import com.matrix.yukun.matrix.selfview.calendar.OnCalendarClickListener;
import com.matrix.yukun.matrix.selfview.calendar.month.MonthCalendarView;
import com.matrix.yukun.matrix.selfview.calendar.schedule.ScheduleLayout;
import com.matrix.yukun.matrix.selfview.calendar.schedule.ScheduleRecyclerView;
import com.matrix.yukun.matrix.selfview.calendar.week.WeekCalendarView;
import com.matrix.yukun.matrix.util.ActivityUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/7/20.
 */

public class CalandarFragment extends BaseFragment implements OnCalendarClickListener {

    @BindView(R.id.iv_all)
    ImageView mIvAll;
    @BindView(R.id.iv_today)
    ImageView mIvToday;
    @BindView(R.id.tv_calandar)
    TextView mTvCalandar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout mToolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout mAppBar;
    @BindView(R.id.mcvCalendar)
    MonthCalendarView mMcvCalendar;
    @BindView(R.id.rlMonthCalendar)
    RelativeLayout mRlMonthCalendar;
    @BindView(R.id.wcvCalendar)
    WeekCalendarView mWcvCalendar;
    @BindView(R.id.rvScheduleList)
    ScheduleRecyclerView mRvScheduleList;
    @BindView(R.id.rlNoTask)
    RelativeLayout mRlNoTask;
    @BindView(R.id.rlScheduleList)
    RelativeLayout mRlScheduleList;
    @BindView(R.id.slSchedule)
    ScheduleLayout mSlSchedule;
    @BindView(R.id.fab_edit)
    FloatingActionButton mFabEdit;

    public static CalandarFragment getInstance() {
        CalandarFragment mineFragment = new CalandarFragment();
        return mineFragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_calandar_layout;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void addListener() {
        super.addListener();
        mSlSchedule.setOnCalendarClickListener(this);
    }

    @OnClick({R.id.iv_all, R.id.iv_today, R.id.fab_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_all:
                ActivityUtils.startCalandarActivity(getContext());
                break;
            case R.id.iv_today:
                mSlSchedule.getMonthCalendar().setTodayToView();
                break;
            case R.id.fab_edit:
                String time = mSlSchedule.getCurrentSelectYear() + "/" + (mSlSchedule.getCurrentSelectMonth()+1) + "/" + mSlSchedule.getCurrentSelectDay();
                EditCalandarDialog editCalandarDialog=EditCalandarDialog.getInstance(time);
                editCalandarDialog.show(getChildFragmentManager(),"");
                break;
        }
    }

    @Override
    public void onClickDate(int year, int month, int day) {
    }

    @Override
    public void onPageChange(int year, int month, int day) {
        Log.i("----------",month+"");
        String today=year+"年/"+(month+1)+"月";
        mTvCalandar.setText(today);
    }
}
