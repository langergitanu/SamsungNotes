package com.microsoft.identity.client;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;
import androidx.collection.AbstractC0622a;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.internal.providers.oauth2.CurrentTaskBrowserAuthorizationFragment;
import com.microsoft.identity.common.internal.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class CurrentTaskBrowserTabActivity extends Activity {
    private static final int REDIRECT_RECEIVED_CODE = 2;
    private static final String TAG = "CurrentTaskBrowserTabActivity";
    private BroadcastReceiver mCloseBroadcastReceiver;

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        final String strM1170p = AbstractC0622a.m1170p(TAG, ":onActivityResult", new StringBuilder());
        if (i2 == 0) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(AuthenticationConstants.AuthorizationIntentAction.REDIRECT_RETURNED_ACTION));
            this.mCloseBroadcastReceiver = new BroadcastReceiver() { // from class: com.microsoft.identity.client.CurrentTaskBrowserTabActivity.1
                /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
                @Override // android.content.BroadcastReceiver
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onReceive(Context context, Intent intent2) {
                    PackageManager packageManager = CurrentTaskBrowserTabActivity.this.getApplicationContext().getPackageManager();
                    boolean z = false;
                    try {
                        ComponentName componentName = CurrentTaskBrowserTabActivity.this.getComponentName();
                        ActivityInfo activityInfo = componentName != null ? packageManager.getActivityInfo(componentName, 0) : null;
                        if (activityInfo != null) {
                            if (activityInfo.taskAffinity == null) {
                                z = true;
                            }
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        com.microsoft.identity.common.logging.Logger.warn(strM1170p, null, "Package name not found for: " + CurrentTaskBrowserTabActivity.this.getComponentName());
                    }
                    CurrentTaskBrowserTabActivity.this.finishActivity(2);
                    if (z) {
                        CurrentTaskBrowserTabActivity.this.finishAndRemoveTask();
                    } else {
                        CurrentTaskBrowserTabActivity.this.finish();
                    }
                }
            };
            LocalBroadcastManager.getInstance(this).registerReceiver(this.mCloseBroadcastReceiver, new IntentFilter(AuthenticationConstants.AuthorizationIntentAction.DESTROY_REDIRECT_RECEIVING_ACTIVITY_ACTION));
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String strM1170p = AbstractC0622a.m1170p(TAG, ":onCreate", new StringBuilder());
        String dataString = getIntent().getDataString();
        if (bundle != null || getIntent() == null || StringUtil.isEmpty(getIntent().getDataString())) {
            return;
        }
        Intent intentCreateCustomTabResponseIntent = CurrentTaskBrowserAuthorizationFragment.createCustomTabResponseIntent(this, dataString);
        if (intentCreateCustomTabResponseIntent != null) {
            startActivityForResult(intentCreateCustomTabResponseIntent, 2);
        } else {
            com.microsoft.identity.common.logging.Logger.warn(strM1170p, "Received NULL response intent. Unable to complete authorization.");
            Toast.makeText(getApplicationContext(), "Unable to complete authorization as there is no interactive call in progress. This can be due to closing the app while the authorization was in process.", 1).show();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mCloseBroadcastReceiver);
        super.onDestroy();
    }
}
