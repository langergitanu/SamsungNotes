package com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p042J1.C0145c;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p248v0.C14497a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SyncNotificationReceiverActivity extends AppCompatActivity {
    private static final String TAG = "SyncNotificationReceiverActivity";

    private void processDefaultNotification(int i) {
        Debugger.m8607d(TAG, "NOTIFICATION_TYPE_DEFAULT");
        PackageManager packageManager = getApplicationContext().getPackageManager();
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(getApplicationContext().getPackageName());
        Debugger.m8607d(TAG, "Notification startActivity : " + getApplicationContext().getPackageName());
        SyncNotificationHelper.cancelSyncNotification(getApplicationContext(), i);
        if (packageManager.queryIntentActivities(launchIntentForPackage, 0).size() > 0) {
            getApplicationContext().startActivity(launchIntentForPackage);
        } else {
            Debugger.m8609e(TAG, "Activity Not Found");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Signature[] signatureArr;
        super.onCreate(bundle);
        Debugger.m8607d(TAG, "onCreate");
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                Object obj = extras.get(SyncNotificationHelper.SYNC_NOTIFICATION_KEY);
                if (obj != null) {
                    int iIntValue = Integer.valueOf((String) obj).intValue();
                    Debugger.m8607d("SyncNotificationType", String.format("isNetworkErrKey(key & SyncNotificationHelper.IMPORT_ERROR_TYPE_NETWORK) : %d", Integer.valueOf(iIntValue & 4)));
                    if ((iIntValue & 48) != 0) {
                        processDefaultNotification(iIntValue);
                        new Handler(getMainLooper()).postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.sync.ui.notification.SyncNotificationReceiverActivity.1
                            @Override // java.lang.Runnable
                            public void run() {
                                C14497a.m15078a().m15079b(C0145c.m334s(SyncNotificationReceiverActivity.this.getApplicationContext()), C0145c.m298F(SyncNotificationReceiverActivity.this.getApplicationContext()));
                            }
                        }, 1000L);
                    } else {
                        Debugger.m8607d("SyncPermissionHelper", " startAppDetailSettings()");
                        Context appContext = C0322h.m670a().f815a.getAppContext();
                        if (appContext == null) {
                            Debugger.m8609e("AppUtil", "isSystemPackage() : appContext is null!");
                        } else {
                            String packageName = appContext.getApplicationContext().getPackageName();
                            PackageManager packageManager = appContext.getApplicationContext().getPackageManager();
                            try {
                                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 64);
                                PackageInfo packageInfo2 = packageManager.getPackageInfo(TelemetryEventStrings.C6439Os.OS_NAME, 64);
                                if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && (packageInfo.applicationInfo.flags & 129) != 0) {
                                    for (Signature signature : signatureArr) {
                                        int length = packageInfo2.signatures.length;
                                        for (int i = 0; i < length; i++) {
                                            if (packageInfo2.signatures[i].equals(signature)) {
                                                String packageName2 = getPackageName();
                                                Debugger.m8607d("SyncPermissionHelper", "\t showPermissionSettingDialog()");
                                                Intent intent2 = new Intent("android.intent.action.MANAGE_APP_PERMISSIONS");
                                                intent2.putExtra("android.intent.extra.PACKAGE_NAME", packageName2);
                                                try {
                                                    intent2.addFlags(268435456);
                                                    intent2.addFlags(1073741824);
                                                    intent2.addFlags(8388608);
                                                    if (getPackageManager().queryIntentActivities(intent2, 0).size() > 0) {
                                                        startActivity(intent2);
                                                    } else {
                                                        Debugger.m8609e("SyncPermissionHelper", "\t Permission Settings Activity Not Found");
                                                    }
                                                } catch (ActivityNotFoundException unused) {
                                                    Debugger.m8609e("SyncPermissionHelper", "\t ActivityNotFoundExceptionP : ermission Activity Open Failed : android.intent.action.MANAGE_APP_PERMISSIONS");
                                                    AbstractC0299q.m622c0(this);
                                                } catch (SecurityException unused2) {
                                                    Debugger.m8609e("SyncPermissionHelper", "\t SecurityException : Permission Activity Open Failed : android.intent.action.MANAGE_APP_PERMISSIONS");
                                                    AbstractC0299q.m622c0(this);
                                                }
                                            }
                                        }
                                    }
                                }
                            } catch (PackageManager.NameNotFoundException e) {
                                Debugger.m8611e("AppUtil", e);
                            }
                        }
                        AbstractC0299q.m622c0(this);
                    }
                }
            } else {
                Debugger.m8609e(TAG, "bundle is null!");
            }
        } else {
            Debugger.m8609e(TAG, "intent is null!");
        }
        finish();
    }
}
