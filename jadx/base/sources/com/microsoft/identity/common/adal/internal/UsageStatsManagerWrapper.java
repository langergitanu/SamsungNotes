package com.microsoft.identity.common.adal.internal;

import android.annotation.TargetApi;
import android.app.usage.UsageStatsManager;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class UsageStatsManagerWrapper {
    private static UsageStatsManagerWrapper sInstance;

    public static synchronized UsageStatsManagerWrapper getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new UsageStatsManagerWrapper();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public static synchronized void setInstance(UsageStatsManagerWrapper usageStatsManagerWrapper) {
        sInstance = usageStatsManagerWrapper;
    }

    @TargetApi(23)
    public boolean isAppInactive(Context context) {
        return ((UsageStatsManager) context.getSystemService("usagestats")).isAppInactive(context.getPackageName());
    }
}
