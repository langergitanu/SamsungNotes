package com.samsung.android.sdk.smp.task;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobWorkItem;
import android.app.usage.UsageStatsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.samsung.android.sdk.smp.SmpJobService;
import com.samsung.android.sdk.smp.SmpReceiver;
import com.samsung.android.sdk.smp.SmpService;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.sharedvariable.SharedMemoryVariableManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.common.util.TimeUtil;
import com.samsung.android.sdk.smp.data.DebugDataManager;
import com.samsung.android.sdk.smp.taskhandler.STaskHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class STaskDispatcher {
    private static final String PREFIX_ALARM_DATA = "smp_timer";
    private static final String TAG = "STaskDispatcher";

    public static void cancelDispatchAlarm(Context context, STask sTask) {
        PendingIntent service;
        if (context == null || sTask == null || sTask.getAction() == null) {
            SmpLog.m6494e(TAG, "fail to cancel. invalid params");
            return;
        }
        int taskId = sTask.getTaskId(context);
        SmpLog.m6498i(TAG, "cancel alarm if exists - " + sTask.toString() + " [" + taskId + "]");
        if (DeviceInfoUtil.isSamsungPushService(context)) {
            Intent intent = new Intent(context, (Class<?>) SmpService.class);
            intent.setData(Uri.parse(PREFIX_ALARM_DATA + taskId));
            service = PendingIntent.getService(context, 0, intent, 201326592);
        } else {
            Intent intent2 = new Intent(context, (Class<?>) SmpReceiver.class);
            intent2.setAction(Constants.ACTION_TASK_ALARM);
            intent2.setData(Uri.parse(PREFIX_ALARM_DATA + taskId));
            service = PendingIntent.getBroadcast(context, 0, intent2, 201326592);
        }
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(service);
    }

    public static void dispatchOnService(Context context, STask sTask) {
        if (context == null || sTask == null || sTask.getAction() == null) {
            SmpLog.m6494e(TAG, "fail to dispatch. invalid params");
            return;
        }
        if (DeviceInfoUtil.isAppDisabled(context)) {
            SmpLog.m6496he(TAG, context.getPackageName() + " is disabled. finish...");
            return;
        }
        int taskId = sTask.getTaskId(context);
        if (sTask instanceof SMarketingTask) {
            if (SharedMemoryVariableManager.getInstance(context).isRunningRealtimeMidInFcmService(((SMarketingTask) sTask).getMid())) {
                SmpLog.m6498i(TAG, "dispatch on FcmService - " + sTask.toString() + " [" + taskId + "]");
                STaskHandler.handle(context, sTask);
                return;
            }
        }
        SmpLog.m6498i(TAG, "dispatch service - " + sTask.toString() + " [" + taskId + "]");
        if (DeviceInfoUtil.isSamsungPushService(context)) {
            try {
                Intent intent = new Intent(context, (Class<?>) SmpService.class);
                intent.setData(Uri.parse(PREFIX_ALARM_DATA + taskId));
                intent.putExtras(sTask.toBundle(context));
                context.startService(intent);
                return;
            } catch (Exception unused) {
                SmpLog.m6496he(TAG, "dispatch service error. cannot start service");
                return;
            }
        }
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null) {
            return;
        }
        JobInfo jobInfoBuild = new JobInfo.Builder(taskId, new ComponentName(context, (Class<?>) SmpJobService.class)).setMinimumLatency(0L).setOverrideDeadline(0L).build();
        DebugDataManager.putTimeDataForDelay(sTask.getData(), System.currentTimeMillis(), true);
        Intent intent2 = new Intent();
        intent2.putExtras(sTask.toBundle(context));
        jobScheduler.enqueue(jobInfoBuild, new JobWorkItem(intent2));
    }

    public static void dispatchOnThread(Context context, STask sTask) {
        if (context == null || sTask == null || sTask.getAction() == null) {
            SmpLog.m6494e(TAG, "fail to dispatch. invalid params");
            return;
        }
        if (DeviceInfoUtil.isAppDisabled(context)) {
            SmpLog.m6496he(TAG, context.getPackageName() + " is disabled. finish...");
            return;
        }
        int taskId = sTask.getTaskId(context);
        SmpLog.m6498i(TAG, "dispatch - " + sTask.toString() + " [" + taskId + "]");
        ThreadController.execute(context, sTask);
    }

    private static void setAlarm(Context context, long j, PendingIntent pendingIntent, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        try {
            if (Build.VERSION.SDK_INT < 31) {
                alarmManager.setExactAndAllowWhileIdle(i, j, pendingIntent);
                return;
            }
            if (((UsageStatsManager) context.getApplicationContext().getSystemService("usagestats")).getAppStandbyBucket() > 5 && !alarmManager.canScheduleExactAlarms()) {
                alarmManager.set(i, j, pendingIntent);
                return;
            }
            alarmManager.setExactAndAllowWhileIdle(i, j, pendingIntent);
        } catch (Exception e) {
            SmpLog.m6501w(TAG, "setAlarm exception. " + e.getMessage());
            try {
                alarmManager.set(i, j, pendingIntent);
            } catch (Exception e2) {
                SmpLog.m6501w(TAG, "setAlarm exception. " + e2.getMessage());
            }
        }
    }

    public static void setDispatchAlarm(Context context, STask sTask, long j, int i) {
        PendingIntent service;
        if (context == null || sTask == null || sTask.getAction() == null) {
            SmpLog.m6494e(TAG, "fail to dispatch. invalid params");
            return;
        }
        if (DeviceInfoUtil.isAppDisabled(context)) {
            SmpLog.m6496he(TAG, context.getPackageName() + " is disabled. finish...");
            return;
        }
        if (System.currentTimeMillis() >= j) {
            SmpLog.m6498i(TAG, sTask.toString() + " alarm dispatched but need to go off now. time: " + j + "(" + TimeUtil.getString(j) + ")");
            cancelDispatchAlarm(context, sTask);
            dispatchOnService(context, sTask);
            return;
        }
        int taskId = sTask.getTaskId(context);
        SmpLog.m6498i(TAG, "dispatch alarm - " + sTask.toString() + " [" + taskId + "] - time: " + j + "(" + TimeUtil.getString(j) + "), wakeOption:" + i);
        DebugDataManager.putTimeDataForDelay(sTask.getData(), j, false);
        if (DeviceInfoUtil.isSamsungPushService(context)) {
            Intent intent = new Intent(context, (Class<?>) SmpService.class);
            intent.setData(Uri.parse(PREFIX_ALARM_DATA + taskId));
            intent.putExtras(sTask.toBundle(context));
            service = PendingIntent.getService(context, 0, intent, 201326592);
        } else {
            Intent intent2 = new Intent(context, (Class<?>) SmpReceiver.class);
            intent2.setAction(Constants.ACTION_TASK_ALARM);
            intent2.setData(Uri.parse(PREFIX_ALARM_DATA + taskId));
            intent2.putExtras(sTask.toBundle(context));
            service = PendingIntent.getBroadcast(context, 0, intent2, 201326592);
        }
        setAlarm(context, j, service, i);
    }
}
