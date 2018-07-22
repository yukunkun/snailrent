package com.matrix.yukun.matrix.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.matrix.yukun.matrix.activity.CalandarActivity;
import com.matrix.yukun.matrix.activity.CoverActivity;
import com.matrix.yukun.matrix.activity.FeedbackActivity;
import com.matrix.yukun.matrix.activity.PositionActivity;
import com.matrix.yukun.matrix.activity.SettingActivity;

import java.util.List;

/**
 * Created by Administrator on 2018/7/15.
 */

public class ActivityUtils {

    public static void startSetingActivity(Context context){
        Intent intent=new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }
    public static void startPositionActivity(Context context){
        Intent intent = new Intent(context, PositionActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
    public static void startPhotoActivity(Context context){
        Intent intent=new Intent(context, CoverActivity.class);
        context.startActivity(intent);
    }

    public static void startFeedbackActivity(Context context){
        Intent intent=new Intent(context, FeedbackActivity.class);
        context.startActivity(intent);
    }
    public static void startUriSearch(Context context){
        Uri uri = Uri.parse("market://details?id="+getAppProcessName(context));
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void startAPPDownload(Context context,String path){
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(path);
        intent.setData(content_url);
        context.startActivity(intent);
    }

    public static String getAppProcessName(Context context) {
        //当前应用pid
        int pid = android.os.Process.myPid();
        //任务管理类
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        //遍历所有应用
        List<ActivityManager.RunningAppProcessInfo> infos = manager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo info : infos) {
            if (info.pid == pid)//得到当前应用
                return info.processName;//返回包名
        }
        return "";
    }

    public static void startCalandarActivity(Context context){
        Intent intent=new Intent(context, CalandarActivity.class);
        context.startActivity(intent);
    }
}
