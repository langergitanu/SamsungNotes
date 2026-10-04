package com.samsung.android.app.notes.receiver;

import android.content.ComponentName;
import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenEventBroadcastReceiverSwitcher {
    private static final String CLASS_NAME_SPEN_EVENT_BROADCAST_RECEIVER = "com.samsung.android.app.notes.receiver.SPenEventBroadcastReceiver";
    private static final String TAG = "SpenEventBroadcastReceiverSwitcher";

    public static void disableSpenEventBroadcastReceiver(@NonNull Context context) {
        Logger.m8697d(TAG, "disableSpenEventBroadcastReceiver");
        PackageManagerCompat.INSTANCE.getInstance().setComponentEnabledSetting(context, new ComponentName(context.getPackageName(), CLASS_NAME_SPEN_EVENT_BROADCAST_RECEIVER), 2, 1);
    }

    public static void enableSpenEventBroadcastReceiver(@NonNull Context context) {
        Logger.m8697d(TAG, "enableSpenEventBroadcastReceiver");
        PackageManagerCompat.INSTANCE.getInstance().setComponentEnabledSetting(context, new ComponentName(context.getPackageName(), CLASS_NAME_SPEN_EVENT_BROADCAST_RECEIVER), 1, 1);
    }

    public static int getComponentEnabledSetting(@NonNull Context context) {
        return PackageManagerCompat.INSTANCE.getInstance().getComponentEnabledSetting(context, new ComponentName(context.getPackageName(), CLASS_NAME_SPEN_EVENT_BROADCAST_RECEIVER));
    }
}
