package com.google.android.gms.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Base64;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.messaging.Constants;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class GcmReceiver extends WakefulBroadcastReceiver {
    private static boolean zzr = false;
    private static com.google.android.gms.iid.zzk zzs;
    private static com.google.android.gms.iid.zzk zzt;

    private final int zzd(Context context, Intent intent) {
        if (Log.isLoggable("GcmReceiver", 3)) {
            Log.d("GcmReceiver", "Binding to service");
        }
        if (isOrderedBroadcast()) {
            setResultCode(-1);
        }
        zzd(context, intent.getAction()).zzd(intent, goAsync());
        return -1;
    }

    private static int zze(Context context, Intent intent) {
        ComponentName componentNameStartService;
        ServiceInfo serviceInfo;
        String strConcat;
        if (Log.isLoggable("GcmReceiver", 3)) {
            Log.d("GcmReceiver", "Starting service");
        }
        ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveInfoResolveService == null || (serviceInfo = resolveInfoResolveService.serviceInfo) == null) {
            Log.e("GcmReceiver", "Failed to resolve target intent service, skipping classname enforcement");
        } else if (!context.getPackageName().equals(serviceInfo.packageName) || (strConcat = serviceInfo.name) == null) {
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            StringBuilder sb = new StringBuilder(AbstractC4539a.m3194d(AbstractC4539a.m3194d(94, str), str2));
            sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
            sb.append(str);
            sb.append("/");
            sb.append(str2);
            Log.e("GcmReceiver", sb.toString());
        } else {
            if (strConcat.startsWith(Extension.DOT)) {
                String strValueOf = String.valueOf(context.getPackageName());
                strConcat = strConcat.length() != 0 ? strValueOf.concat(strConcat) : new String(strValueOf);
            }
            if (Log.isLoggable("GcmReceiver", 3)) {
                String strValueOf2 = String.valueOf(strConcat);
                Log.d("GcmReceiver", strValueOf2.length() != 0 ? "Restricting intent to a specific service: ".concat(strValueOf2) : new String("Restricting intent to a specific service: "));
            }
            intent.setClassName(context.getPackageName(), strConcat);
        }
        try {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                componentNameStartService = WakefulBroadcastReceiver.startWakefulService(context, intent);
            } else {
                componentNameStartService = context.startService(intent);
                Log.d("GcmReceiver", "Missing wake lock permission, service start may be delayed");
            }
            if (componentNameStartService != null) {
                return -1;
            }
            Log.e("GcmReceiver", "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (IllegalStateException e) {
            String strValueOf3 = String.valueOf(e);
            StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 45);
            sb2.append("Failed to start service while in background: ");
            sb2.append(strValueOf3);
            Log.e("GcmReceiver", sb2.toString());
            return 402;
        } catch (SecurityException e2) {
            Log.e("GcmReceiver", "Error while delivering the message to the serviceIntent", e2);
            return 401;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int iZzd;
        if (Log.isLoggable("GcmReceiver", 3)) {
            Log.d("GcmReceiver", "received new intent");
        }
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if ("google.com/iid".equals(intent.getStringExtra(Constants.MessagePayloadKeys.FROM))) {
            intent.setAction("com.google.android.gms.iid.InstanceID");
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra(Constants.MessagePayloadKeys.RAW_DATA, Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if (isOrderedBroadcast()) {
            setResultCode(500);
        }
        boolean z = PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26;
        boolean z2 = (intent.getFlags() & 268435456) != 0;
        if (!z || z2) {
            int iZze = "com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction()) ? zze(context, intent) : zze(context, intent);
            if (PlatformVersion.isAtLeastO() && iZze == 402) {
                zzd(context, intent);
                iZzd = 403;
            } else {
                iZzd = iZze;
            }
        } else {
            iZzd = zzd(context, intent);
        }
        if (isOrderedBroadcast()) {
            setResultCode(iZzd);
        }
    }

    private final synchronized com.google.android.gms.iid.zzk zzd(Context context, String str) {
        try {
            if ("com.google.android.c2dm.intent.RECEIVE".equals(str)) {
                if (zzt == null) {
                    zzt = new com.google.android.gms.iid.zzk(context, str);
                }
                return zzt;
            }
            if (zzs == null) {
                zzs = new com.google.android.gms.iid.zzk(context, str);
            }
            return zzs;
        } catch (Throwable th) {
            throw th;
        }
    }
}
