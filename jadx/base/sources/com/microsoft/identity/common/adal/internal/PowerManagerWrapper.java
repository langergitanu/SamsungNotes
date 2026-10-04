package com.microsoft.identity.common.adal.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.PowerManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PowerManagerWrapper {
    private static PowerManagerWrapper sInstance;

    public static synchronized PowerManagerWrapper getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new PowerManagerWrapper();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public static void setInstance(PowerManagerWrapper powerManagerWrapper) {
        sInstance = powerManagerWrapper;
    }

    @TargetApi(23)
    public boolean isDeviceIdleMode(Context context) {
        return ((PowerManager) context.getSystemService("power")).isDeviceIdleMode();
    }

    @TargetApi(23)
    public boolean isIgnoringBatteryOptimizations(Context context) {
        return ((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName());
    }
}
