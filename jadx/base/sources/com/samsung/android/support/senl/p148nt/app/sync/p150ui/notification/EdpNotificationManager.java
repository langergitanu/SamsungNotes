package com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import androidx.annotation.NonNull;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.EdpManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.updater.UpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class EdpNotificationManager {
    private static final int ACCEPT = 1;
    public static final String CHANNEL_ID_NOTIFICATION_EDP = "channel_id_notification_edp";
    private static final int DECLINE = 0;
    private static final String EDP_NOTIFICATION_INTENT_FILTER = "com.samsung.android.support.senl.nt.app.sync.ui.notification.EDP_NOTIFICATION_INTENT_FILTER";
    private static final String GROUP_KEY_EDP_NOTE = "com.samsung.android.app.notes.GROUP_KEY_EDP_NOTE";
    public static final String MADE_NOTIFICATION_EDP_ACCEPT_TYPE = "edp_notification_accecpt";
    public static final String MADE_NOTIFICATION_EDP_TYPE = "edp_notification_type";
    private static final String NOTIFY_APP_UPDATE = "NOTIFY_APP_UPDATE";
    private static final int NOTIFY_APP_UPDATE_VALUE = 1;
    private static final String NOTIFY_FTU = "NOTIFY_FTU";
    private static final int NOTIFY_FTU_VALUE = 0;
    private static final String NOTIFY_KEY_ERROR = "NOTIFY_KEY_ERROR";
    private static final int NOTIFY_KEY_ERROR_VALUE = 2;
    private static final String TAG = "EdpNotificationManager";
    private static final int UNKNOWN = -1;

    @NonNull
    private PendingIntent getAcceptPendingIntent(int i, int i2) {
        Context applicationContext = BaseUtils.getApplicationContext();
        Intent intent = new Intent(EDP_NOTIFICATION_INTENT_FILTER);
        intent.putExtra(MADE_NOTIFICATION_EDP_TYPE, i2);
        intent.putExtra(MADE_NOTIFICATION_EDP_ACCEPT_TYPE, 1);
        intent.setPackage(applicationContext.getPackageName());
        return PendingIntent.getBroadcast(applicationContext, i, intent, 201326592);
    }

    @NonNull
    private PendingIntent getCancelPendingIntent(int i, int i2) {
        Context applicationContext = BaseUtils.getApplicationContext();
        Intent intent = new Intent(EDP_NOTIFICATION_INTENT_FILTER);
        intent.putExtra(MADE_NOTIFICATION_EDP_TYPE, i2);
        intent.putExtra(MADE_NOTIFICATION_EDP_ACCEPT_TYPE, 0);
        intent.setPackage(applicationContext.getPackageName());
        return PendingIntent.getBroadcast(applicationContext, i, intent, 201326592);
    }

    @NonNull
    private Notification.Builder getNotificationBuilder(String str, String str2) {
        int i = C8003R.drawable.stat_notify_notes;
        Context applicationContext = BaseUtils.getApplicationContext();
        Notification.Builder builderCreateNotification = NotificationUtils.createNotification(applicationContext, CHANNEL_ID_NOTIFICATION_EDP, applicationContext.getString(C8003R.string.app_name), 4, false);
        builderCreateNotification.setContentTitle(str);
        builderCreateNotification.setContentText(str2);
        builderCreateNotification.setSmallIcon(i);
        builderCreateNotification.setAutoCancel(true);
        builderCreateNotification.setStyle(new Notification.BigTextStyle().bigText(str2));
        builderCreateNotification.setPriority(1);
        builderCreateNotification.setGroup(GROUP_KEY_EDP_NOTE);
        return builderCreateNotification;
    }

    public void cancelAllEdpNotification() {
        Notification notification;
        Bundle bundle;
        int i;
        NotificationManager notificationManager = (NotificationManager) BaseUtils.getApplicationContext().getSystemService("notification");
        if (notificationManager == null) {
            MainCoeditLogger.m7251e(TAG, "cancelAllEdpNotification# notificationManager is null");
            return;
        }
        MainCoeditLogger.m7253i(TAG, "cancelAllEdpNotification# [Notification] remove the edp notification!");
        StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
        if (activeNotifications == null || activeNotifications.length == 0) {
            return;
        }
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            if (statusBarNotification != null && (notification = statusBarNotification.getNotification()) != null && (bundle = notification.extras) != null && ((i = bundle.getInt(MADE_NOTIFICATION_EDP_TYPE, -1)) == 1 || i == 2)) {
                try {
                    notificationManager.cancel(TAG, statusBarNotification.getId());
                } catch (Exception e) {
                    AbstractC4539a.m3204n(e, new StringBuilder("cancelAllEdpNotification# Exception while canceling notification. "), TAG);
                }
            }
        }
    }

    public void notifyEdpFtu(String str, String str2) {
        Notification notificationBuild = getNotificationBuilder(str, str2).build();
        notificationBuild.extras.putInt(MADE_NOTIFICATION_EDP_TYPE, 0);
        ((NotificationManager) BaseUtils.getApplicationContext().getSystemService("notification")).notify(TAG, -678559919, notificationBuild);
    }

    public void notifyEdpKeyError(String str, String str2, String str3, String str4) {
        MainCoeditLogger.m7253i(TAG, "notifyEdpKeyError# start key:-1804062094");
        Context applicationContext = BaseUtils.getApplicationContext();
        PendingIntent cancelPendingIntent = getCancelPendingIntent(-1804062094, 2);
        PendingIntent acceptPendingIntent = getAcceptPendingIntent(-1804062093, 2);
        NotificationManager notificationManager = (NotificationManager) applicationContext.getSystemService("notification");
        Notification.Builder notificationBuilder = getNotificationBuilder(str, str2);
        notificationBuilder.addAction(new Notification.Action.Builder((Icon) null, str3, cancelPendingIntent).build());
        notificationBuilder.addAction(new Notification.Action.Builder((Icon) null, str4, acceptPendingIntent).build());
        Notification notificationBuild = notificationBuilder.build();
        notificationBuild.extras.putInt(MADE_NOTIFICATION_EDP_TYPE, 2);
        notificationManager.notify(TAG, -1804062094, notificationBuild);
    }

    public void notifyEdpNotSupportedRemmendedAppUpdate(String str, String str2, String str3, String str4) {
        MainCoeditLogger.m7253i(TAG, "notifyEdpNotSupportedRemmendedAppUpdate# start key:1122020221");
        Context applicationContext = BaseUtils.getApplicationContext();
        PendingIntent cancelPendingIntent = getCancelPendingIntent(1122020221, 1);
        PendingIntent acceptPendingIntent = getAcceptPendingIntent(1122020222, 1);
        NotificationManager notificationManager = (NotificationManager) applicationContext.getSystemService("notification");
        Notification.Builder notificationBuilder = getNotificationBuilder(str, str2);
        notificationBuilder.addAction(new Notification.Action.Builder((Icon) null, str3, cancelPendingIntent).build());
        notificationBuilder.addAction(new Notification.Action.Builder((Icon) null, str4, acceptPendingIntent).build());
        Notification notificationBuild = notificationBuilder.build();
        notificationBuild.extras.putInt(MADE_NOTIFICATION_EDP_TYPE, 1);
        notificationManager.notify(TAG, 1122020221, notificationBuild);
    }

    public void setAction(Intent intent) {
        int intExtra = intent.getIntExtra(MADE_NOTIFICATION_EDP_ACCEPT_TYPE, -1);
        int intExtra2 = intent.getIntExtra(MADE_NOTIFICATION_EDP_TYPE, -1);
        if (intExtra2 == 1) {
            EdpManager.getInstance().setUpdateNotify(true);
            if (intExtra == 1) {
                UpdateManager.getInstance().goToGalaxyAppStore();
            }
        }
        if (intExtra2 == 2 && intExtra == 1) {
            ToastHandler.show(BaseUtils.getApplicationContext(), BaseUtils.getApplicationContext().getResources().getString(DeviceUtils.isTabletModel() ? C8003R.string.settings_sync_accounts_summary_tablet_edp_notice : C8003R.string.settings_sync_accounts_summary_phone_edp_notice), 0, false);
        }
    }
}
