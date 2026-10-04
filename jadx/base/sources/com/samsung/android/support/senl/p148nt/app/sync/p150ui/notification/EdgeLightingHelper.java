package com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class EdgeLightingHelper {
    private static final String TAG = "EdgeLightingHelper";

    public static Intent getIntentSupportEdgeLighting(Context context) {
        return new Intent(context, (Class<?>) SyncNotificationReceiverActivity.class);
    }

    public static PendingIntent getPendingIntentSupportEdgeLighting(Context context, int i, Intent intent) {
        return PendingIntent.getActivity(context, i, intent, 1275068416);
    }
}
