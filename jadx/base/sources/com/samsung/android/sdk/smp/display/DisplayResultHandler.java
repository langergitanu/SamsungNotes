package com.samsung.android.sdk.smp.display;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.constants.FeedbackEvent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.constants.MarketingState;
import com.samsung.android.sdk.smp.common.database.DBHandler;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.marketing.FeedbackManager;
import com.samsung.android.sdk.smp.marketing.Marketing;
import com.samsung.android.sdk.smp.task.SMarketingTask;
import com.samsung.android.sdk.smp.task.STask;
import com.samsung.android.sdk.smp.task.STaskDispatcher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DisplayResultHandler {
    private static final String TAG = "DisplayResultHandler";
    private final long mClearTime;
    private final boolean mIsFirstDisplay;
    private final String mMid;

    private DisplayResultHandler(String str, boolean z) {
        this.mMid = str;
        this.mClearTime = 0L;
        this.mIsFirstDisplay = z;
    }

    public static void handlePopupDisplayResult(Context context, Bundle bundle) {
        if (bundle == null) {
            SmpLog.m6494e(TAG, "fail to handle display result. data null");
        }
        String string = bundle.getString(Constants.EXTRA_KEY_POPUP_DISPLAY_RESULT, "");
        boolean z = bundle.getBoolean(Constants.EXTRA_KEY_IS_FIRST_DISPLAY);
        String string2 = bundle.getString("mid");
        if (TextUtils.isEmpty(string2)) {
            SmpLog.m6494e(TAG, "fail to handle display result. mid null");
            return;
        }
        string.getClass();
        switch (string) {
            case "success":
                new DisplayResultHandler(string2, bundle.getLong(Constants.EXTRA_KEY_CLEAR_TIME, -1L), z).onSuccess(context, null, false);
                break;
            case "fail_but_retry":
                new DisplayResultHandler(string2, z).onFailButRetry(context);
                break;
            case "fail":
                FeedbackEvent feedbackEventFromInt = FeedbackEvent.fromInt(bundle.getInt(Constants.EXTRA_KEY_FEEDBACK_EVENT, -1));
                if (feedbackEventFromInt != null) {
                    new DisplayResultHandler(string2, z).onFail(context, feedbackEventFromInt, bundle.getString(Constants.EXTRA_KEY_FEEDBACK_DETAIL));
                    break;
                }
                break;
            case "no_action":
                Marketing.setToGone(context, string2, false);
                FeedbackManager.addFeedback(context, string2, FeedbackEvent.NONE_REACTION, null);
                break;
        }
    }

    private void onFailButRetry(Context context) {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6495e(TAG, getMid(), "fail to retry display. db open fail");
            return;
        }
        try {
            int marketingFailCount = dBHandlerOpen.getMarketingFailCount(getMid());
            dBHandlerOpen.updateMarketingFailCount(getMid(), marketingFailCount + 1);
            if (marketingFailCount < 5) {
                dBHandlerOpen.close();
                setAlarmForRetryDisplay(context);
            } else {
                SmpLog.m6502w(TAG, getMid(), "fail to retry display. over retry count");
                if (isFirstDisplay()) {
                    Marketing.setToFail(context, getMid(), FeedbackEvent.CONSUME_FAIL, "C1009");
                }
            }
        } finally {
            dBHandlerOpen.close();
        }
    }

    private void setAlarmForCheckNotificationCleared(Context context, String str) {
        if (DeviceInfoUtil.getTargetSdkVersion(context) < 31 || Build.VERSION.SDK_INT < 31) {
            return;
        }
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6495e(TAG, str, "db open fail");
        } else if (dBHandlerOpen.isMarketingLandingRedirected(str)) {
            SmpLog.m6499i(TAG, str, "landing is redirected. skip to set check notification cleared alarm");
        } else {
            dBHandlerOpen.close();
            STaskDispatcher.setDispatchAlarm(context, new SMarketingTask(STask.MarketingAction.CHECK_NOTIFICATION_CLEARED, null, str), System.currentTimeMillis() + MarketingConstants.INITIAL_CHECK_NOTIFICATION_CLEARED_DELAY_MILLIS, 0);
        }
    }

    private void setAlarmForClearMarketing(Context context, long j, String str) {
        if (j >= 0) {
            STaskDispatcher.setDispatchAlarm(context, new SMarketingTask(STask.MarketingAction.CLEAR, null, str), j, 0);
            return;
        }
        SmpLog.m6494e(TAG, "Fail to set clear alarm. Invalid clearTime : " + j);
    }

    public long getClearTime() {
        return this.mClearTime;
    }

    public String getMid() {
        return this.mMid;
    }

    public boolean isFirstDisplay() {
        return this.mIsFirstDisplay;
    }

    public void onFail(Context context, FeedbackEvent feedbackEvent, String str) {
        if (isFirstDisplay()) {
            Marketing.setToFail(context, getMid(), feedbackEvent, str);
        }
    }

    public void onSuccess(Context context, String str, boolean z) {
        if (isFirstDisplay()) {
            DBHandler dBHandlerOpen = DBHandler.open(context);
            if (dBHandlerOpen == null) {
                SmpLog.m6494e(TAG, "Fail to handle display success. dbHandler null");
                return;
            }
            dBHandlerOpen.updateMarketingState(getMid(), MarketingState.DISPLAYED);
            FeedbackManager.addFeedback(context, getMid(), FeedbackEvent.CONSUMED, str);
            dBHandlerOpen.updateMarketingDisplayedTime(getMid(), System.currentTimeMillis());
            dBHandlerOpen.close();
        }
        setAlarmForClearMarketing(context, getClearTime(), getMid());
        if (z) {
            setAlarmForCheckNotificationCleared(context, getMid());
        }
    }

    public void setAlarmForRetryDisplay(Context context) {
        Bundle bundleM2215f = AbstractC2821a.m2215f(Constants.EXTRA_KEY_MARKETING_SUB_ACTION, "display");
        bundleM2215f.putBoolean(Constants.EXTRA_KEY_IS_FIRST_DISPLAY, isFirstDisplay());
        STaskDispatcher.setDispatchAlarm(context, new SMarketingTask(STask.MarketingAction.BASIC, bundleM2215f, getMid()), System.currentTimeMillis() + MarketingConstants.DISPLAY_RETRY_DELAY_MILLIS, 0);
    }

    public DisplayResultHandler(String str, long j, boolean z) {
        this.mMid = str;
        this.mClearTime = j;
        this.mIsFirstDisplay = z;
    }
}
