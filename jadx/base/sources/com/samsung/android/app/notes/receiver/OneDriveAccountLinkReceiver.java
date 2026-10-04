package com.samsung.android.app.notes.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.content.ContextCompat;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.HashSet;
import p212o1.C13573a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class OneDriveAccountLinkReceiver extends BroadcastReceiver {
    public static final String ACTION_MIGRATION_STATUS_CHANGED = "com.samsung.android.scloud.app.broadcast.ACTION_MIGRATION_STATUS_CHANGED";
    private static final String AllowedOperations = "AllowedOperations";
    private static final String OneDriveAccountActivated = "OneDriveAccountActivated";
    private static final String OneDriveAccountAvailable = "OneDriveAccountAvailable";
    public static final String SCLOUD_APP_PERMISSION_BROADCAST = "com.samsung.android.scloud.app.permission.BROADCAST";
    private static final String TAG = "ODReceiver";

    public static BroadcastReceiver registerReceiver(@NonNull Context context) {
        OneDriveAccountLinkReceiver oneDriveAccountLinkReceiver = new OneDriveAccountLinkReceiver();
        ContextCompat.INSTANCE.getInstance().registerReceiver(context, oneDriveAccountLinkReceiver, new IntentFilter(ACTION_MIGRATION_STATUS_CHANGED), SCLOUD_APP_PERMISSION_BROADCAST, null, 2);
        return oneDriveAccountLinkReceiver;
    }

    public static void unregisterReceiver(@NonNull Context context, BroadcastReceiver broadcastReceiver) {
        context.unregisterReceiver(broadcastReceiver);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean zContains;
        boolean z;
        if (context == null || intent == null) {
            Logger.m8697d(TAG, "OD received but null");
            return;
        }
        Logger.m8697d(TAG, "OD received 0");
        boolean zContains2 = false;
        if (intent.hasExtra(AllowedOperations)) {
            try {
                HashSet hashSet = (HashSet) intent.getSerializableExtra(AllowedOperations);
                if (hashSet != null) {
                    zContains = hashSet.contains(OneDriveAccountActivated);
                    try {
                        zContains2 = hashSet.contains(OneDriveAccountAvailable);
                    } catch (Exception e) {
                        e = e;
                        Logger.m8698e(TAG, "OD received error" + e.toString());
                    }
                } else {
                    zContains = false;
                }
            } catch (Exception e2) {
                e = e2;
                zContains = false;
            }
            z = zContains2;
            zContains2 = zContains;
        } else {
            z = false;
        }
        Logger.m8697d(TAG, "OD received 1-1");
        if (zContains2) {
            Logger.m8697d(TAG, "OD received 2");
            C13573a.m14384j(context, true);
        }
        if (z) {
            Logger.m8697d(TAG, "OD received 3");
        }
    }
}
