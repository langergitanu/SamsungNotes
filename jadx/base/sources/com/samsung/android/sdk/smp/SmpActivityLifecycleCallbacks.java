package com.samsung.android.sdk.smp;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.data.UsageManager;
import com.samsung.android.sdk.smp.marketing.FeedbackManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private static String TAG = "SmpActivityLifecycleCallbacks";

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        SmpLog.m6500v(TAG, "onActivityCreated");
        if (activity != null) {
            UsageManager.getInstance(activity).activityCreated(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        SmpLog.m6500v(TAG, "onActivityDestroyed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        SmpLog.m6500v(TAG, "onActivityStarted");
        if (activity != null) {
            UsageManager.getInstance(activity).activityStarted(activity);
            FeedbackManager.handleClickFeedbackIntent(activity.getApplicationContext(), activity.getIntent());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        SmpLog.m6500v(TAG, "onActivityStopped");
        if (activity != null) {
            UsageManager.getInstance(activity).activityStopped(activity);
        }
    }
}
