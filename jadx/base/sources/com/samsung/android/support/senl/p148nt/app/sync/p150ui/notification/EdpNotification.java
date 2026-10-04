package com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class EdpNotification {
    private static final String TAG = "EdpNotification";
    private final EdpNotificationManager mEdpNotificationManager = new EdpNotificationManager();

    public void cancelAllEdpNotification() {
        MainCoeditLogger.m7253i(TAG, "cancelAllEdpNotification");
        this.mEdpNotificationManager.cancelAllEdpNotification();
    }

    public void notifyEdpFtu() {
        MainCoeditLogger.m7253i(TAG, "notifyEdpFtu");
        Context applicationContext = BaseUtils.getApplicationContext();
        this.mEdpNotificationManager.notifyEdpFtu(applicationContext.getResources().getString(C8003R.string.edp_notification_ftu_notify_title), applicationContext.getResources().getString(C8003R.string.edp_notification_ftu_notify_message));
    }

    public void notifyEdpKeyError() {
        MainCoeditLogger.m7253i(TAG, "notifyEdpKeyError");
        Context applicationContext = BaseUtils.getApplicationContext();
        this.mEdpNotificationManager.notifyEdpKeyError(applicationContext.getResources().getString(C8003R.string.tipcard_edp_key_error_title), applicationContext.getResources().getString(C8003R.string.tipcard_edp_key_error_content), applicationContext.getResources().getString(C8003R.string.tipcard_button_not_now), applicationContext.getResources().getString(C8003R.string.tipcard_edp_key_error_enter));
    }

    public void notifyEdpNotSupportedRemmendedAppUpdate() {
        MainCoeditLogger.m7253i(TAG, "notifyEdpNotSupportedRemmendedAppUpdate");
        Context applicationContext = BaseUtils.getApplicationContext();
        this.mEdpNotificationManager.notifyEdpNotSupportedRemmendedAppUpdate(applicationContext.getResources().getString(C8003R.string.tipcard_edp_not_supported_title), applicationContext.getResources().getString(C8003R.string.tipcard_edp_not_supported_recommend_update_content), applicationContext.getResources().getString(C8003R.string.tipcard_button_not_now), applicationContext.getResources().getString(C8003R.string.string_update));
    }

    public void setAction(Intent intent) {
        this.mEdpNotificationManager.setAction(intent);
    }
}
