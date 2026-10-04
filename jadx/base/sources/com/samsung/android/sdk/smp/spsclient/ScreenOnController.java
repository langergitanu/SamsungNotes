package com.samsung.android.sdk.smp.spsclient;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.common.util.TimeUtil;
import com.samsung.android.sdk.smp.task.SMarketingTask;
import com.samsung.android.sdk.smp.task.STask;
import com.samsung.android.sdk.smp.task.STaskDispatcher;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ScreenOnController {
    private static final String TAG = "ScreenOnController";
    private static ScreenOnController sController;
    private Map<String, TimeData> mScreenOnMap = new HashMap();
    private BroadcastReceiver mScreenOnReceiver = new BroadcastReceiver() { // from class: com.samsung.android.sdk.smp.spsclient.ScreenOnController.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SmpLog.m6498i(ScreenOnController.TAG, "screen unlock");
            for (String str : ScreenOnController.this.mScreenOnMap.keySet()) {
                TimeData timeData = (TimeData) ScreenOnController.this.mScreenOnMap.get(str);
                if (timeData == null) {
                    SmpLog.m6502w(ScreenOnController.TAG, str, "fail to get timedata");
                } else if (timeData.screenOnEndTime < System.currentTimeMillis()) {
                    SmpLog.m6499i(ScreenOnController.TAG, str, "already passed screen on end time");
                    ScreenOnController.this.stopCheckingScreenOn(context, str);
                } else if (ScreenOnController.this.canDisplayNow(timeData.displayTimeStart, timeData.displayTimeEnd, timeData.doNotDisturbTimeStart, timeData.doNotDisturbTimeEnd)) {
                    STaskDispatcher.dispatchOnService(context, new SMarketingTask(STask.MarketingAction.SCREEN_ON, AbstractC2821a.m2215f(Constants.EXTRA_KEY_MARKETING_SUB_ACTION, Constants.EXTRA_ACTION_SCREEN_ON_FIRED), str));
                    ScreenOnController.this.stopCheckingScreenOn(context, str);
                } else {
                    SmpLog.m6499i(ScreenOnController.TAG, str, "not yet display time. keep on waiting screen on event");
                }
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TimeData {
        private TimeUtil.Time displayTimeEnd;
        private TimeUtil.Time displayTimeStart;
        private TimeUtil.Time doNotDisturbTimeEnd;
        private TimeUtil.Time doNotDisturbTimeStart;
        private long screenOnEndTime;

        private TimeData(TimeUtil.Time time, TimeUtil.Time time2, TimeUtil.Time time3, TimeUtil.Time time4, long j) {
            this.displayTimeStart = time;
            this.displayTimeEnd = time2;
            this.doNotDisturbTimeStart = time3;
            this.doNotDisturbTimeEnd = time4;
            this.screenOnEndTime = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canDisplayNow(TimeUtil.Time time, TimeUtil.Time time2, TimeUtil.Time time3, TimeUtil.Time time4) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (time3.getHour() != -1 && TimeUtil.isTimeInBetween(time3, time4, jCurrentTimeMillis)) {
            SmpLog.m6498i(TAG, "can't display now due to doNotDisturbTime");
            return false;
        }
        if (TimeUtil.isTimeInBetween(time, time2, jCurrentTimeMillis)) {
            return true;
        }
        SmpLog.m6498i(TAG, "can't display now. not yet display time");
        return false;
    }

    public static synchronized ScreenOnController getInstance() {
        try {
            if (sController == null) {
                sController = new ScreenOnController();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void stopCheckingScreenOn(Context context, String str) {
        String str2 = TAG;
        SmpLog.m6499i(str2, str, "stop checking screen on event");
        this.mScreenOnMap.remove(str);
        if (this.mScreenOnMap.isEmpty()) {
            SmpLog.m6498i(str2, "unregister screenOnReceiver");
            try {
                context.getApplicationContext().unregisterReceiver(this.mScreenOnReceiver);
            } catch (Exception e) {
                SmpLog.m6494e(TAG, "error while unregister receiver. " + e.toString());
            }
        }
    }

    public synchronized void clear(Context context) {
        SmpLog.m6492d(TAG, "clear screen on controller");
        if (this.mScreenOnMap.size() == 0) {
            return;
        }
        this.mScreenOnMap.clear();
        try {
            context.getApplicationContext().unregisterReceiver(this.mScreenOnReceiver);
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while unregister receiver. " + e.toString());
        }
    }

    public synchronized void startCheckingScreenOn(Context context, String str, TimeUtil.Time time, TimeUtil.Time time2, TimeUtil.Time time3, TimeUtil.Time time4, long j) {
        TimeUtil.Time time5;
        if (j < System.currentTimeMillis()) {
            SmpLog.m6499i(TAG, str, "already screen on end time. skip screen on listening");
            return;
        }
        if (DeviceInfoUtil.isScreenOn(context)) {
            time5 = time4;
            if (canDisplayNow(time, time2, time3, time5)) {
                SmpLog.m6499i(TAG, str, "already screen on. create screen on event");
                Bundle bundle = new Bundle();
                bundle.putString(Constants.EXTRA_KEY_MARKETING_SUB_ACTION, Constants.EXTRA_ACTION_SCREEN_ON_FIRED);
                STaskDispatcher.dispatchOnService(context, new SMarketingTask(STask.MarketingAction.SCREEN_ON, bundle, str));
                return;
            }
        } else {
            time5 = time4;
        }
        String str2 = TAG;
        SmpLog.m6499i(str2, str, "start checking screen on event");
        this.mScreenOnMap.put(str, new TimeData(time, time2, time3, time5, j));
        if (this.mScreenOnMap.size() > 1) {
            return;
        }
        SmpLog.m6498i(str2, "register screenOnReceiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        if (Build.VERSION.SDK_INT >= 33) {
            context.getApplicationContext().registerReceiver(this.mScreenOnReceiver, intentFilter, 2);
        } else {
            context.getApplicationContext().registerReceiver(this.mScreenOnReceiver, intentFilter);
        }
    }
}
