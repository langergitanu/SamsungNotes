package com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.service.notification.StatusBarNotification;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import java.util.Locale;
import java.util.concurrent.Executor;
import p038I1.C0137m;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SyncNotificationHelper {
    public static final String CHANNEL_ID_NOTIFICATION_SYNC = "CHANNEL_ID_NOTIFICATION_SYNC";
    public static final String SYNC_NOFITICATION_TYPE = "SYNC_NOFITICATION_TYPE";
    public static final String SYNC_NOTIFICATION_KEY = "SYNC_NOTIFICATION_KEY";
    public static final int SYNC_NOTIFICATION_TYPE_CLOUD = 6;
    public static final int SYNC_NOTIFICATION_TYPE_IMPORT = 7;
    private static Locale mCurrentLocale;
    private static NotificationInfo mNotiInfo;
    private final Context mContext;
    private static final String TAG = "SyncNotificationHelper";
    private static final Executor mExecutor = AbstractC4539a.m3201k(TAG);

    public SyncNotificationHelper(Context context) {
        this.mContext = context;
    }

    public static void cancelSyncNotification(Context context, int i) {
        if (context == null) {
            return;
        }
        Debugger.m8607d(TAG, String.format("cancelSyncNotification(%d)", Integer.valueOf(i)));
        ((NotificationManager) context.getSystemService("notification")).cancel(TAG, i);
    }

    public static void changeConfiguration(final Context context, Configuration configuration) {
        Locale locale = mCurrentLocale;
        Locale locale2 = configuration.locale;
        if (locale == locale2) {
            return;
        }
        mCurrentLocale = locale2;
        mExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.sync.ui.notification.SyncNotificationHelper.1
            @Override // java.lang.Runnable
            public void run() {
                StatusBarNotification[] activeNotifications;
                try {
                    activeNotifications = ((NotificationManager) context.getSystemService("notification")).getActiveNotifications();
                } catch (Exception e) {
                    AbstractC4539a.m3213w(e, new StringBuilder("changeConfiguration() : "), SyncNotificationHelper.TAG);
                    activeNotifications = null;
                }
                if (activeNotifications == null || SyncNotificationHelper.mNotiInfo == null) {
                    return;
                }
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    Debugger.m8607d(SyncNotificationHelper.TAG, "changeConfiguration(), StatusBarNotification : " + statusBarNotification.getTag());
                    if (statusBarNotification.getNotification().extras.getInt(SyncNotificationHelper.SYNC_NOTIFICATION_KEY) == SyncNotificationHelper.mNotiInfo.key) {
                        Debugger.m8607d(SyncNotificationHelper.TAG, "mNotiInfo key : " + SyncNotificationHelper.mNotiInfo.key);
                        int i = statusBarNotification.getNotification().extras.getInt(SyncNotificationHelper.SYNC_NOFITICATION_TYPE);
                        if (i == 6) {
                            SyncNotificationHelper.createSyncNotification(context, SyncNotificationHelper.mNotiInfo.tipCard);
                        } else if (i != 7) {
                            Debugger.m8607d(SyncNotificationHelper.TAG, "invalid key ");
                        } else {
                            SyncNotificationHelper.createImportNotification(context, SyncNotificationHelper.mNotiInfo.key, SyncNotificationHelper.mNotiInfo.errorType, SyncNotificationHelper.mNotiInfo.importType);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void createImportNotification(Context context, int i, int i2, int i4) {
        saveNotiInfo(new NotificationInfo(i, i2, i4));
        createNotification(context, 7, i, context.getString(C8003R.string.sync_tipcard_fail_to_import_server_error_title), i2 == 3 ? context.getString(C8003R.string.sync_notification_server_import_failed_body) : i2 == 4 ? context.getString(C8003R.string.sync_notification_network_import_failed_body) : context.getString(C8003R.string.sync_tipcard_device_storage_full));
    }

    private static void createNotification(Context context, int i, int i2, String str, String str2) {
        int i4 = C8003R.drawable.stat_notify_notes;
        int i5 = C8003R.string.notes;
        if (CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy()) {
            i5 = C8003R.string.notes_jp;
        }
        Notification.Builder builderCreateNotification = NotificationUtils.createNotification(context, CHANNEL_ID_NOTIFICATION_SYNC, context.getString(C8003R.string.sync_notification_channel_name_sync, context.getString(i5)), 4);
        PendingIntent tipCardPendingIntent = getTipCardPendingIntent(context, i2);
        builderCreateNotification.setContentTitle(str);
        builderCreateNotification.setContentText(str2);
        builderCreateNotification.setSmallIcon(i4);
        builderCreateNotification.setContentIntent(tipCardPendingIntent);
        builderCreateNotification.setPriority(1);
        builderCreateNotification.setDefaults(1);
        builderCreateNotification.setTicker(str);
        builderCreateNotification.setAutoCancel(true);
        builderCreateNotification.setOngoing(false);
        builderCreateNotification.setShowWhen(false);
        builderCreateNotification.setStyle(new Notification.BigTextStyle().bigText(str2));
        Notification notificationBuild = builderCreateNotification.build();
        notificationBuild.extras.putInt(SYNC_NOTIFICATION_KEY, i2);
        notificationBuild.extras.putInt(SYNC_NOFITICATION_TYPE, i);
        ((NotificationManager) context.getSystemService("notification")).notify(TAG, i2, notificationBuild);
        Debugger.m8607d(TAG, String.format("createNotification() notify : %d (%s)", Integer.valueOf(i2), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void createSyncNotification(Context context, TipCard tipCard) {
        String string;
        saveNotiInfo(new NotificationInfo(tipCard.getType(), tipCard));
        SyncNotificationTypeStrings.getInstance();
        String string2 = context.getString(SyncNotificationTypeStrings.getResIdTipCardTitle(tipCard.getType()));
        if (tipCard.getType() == 5) {
            SyncNotificationTypeStrings.getInstance();
            string = String.format(context.getString(SyncNotificationTypeStrings.getResIdTipCardBody(tipCard.getType())), PerfConstants.ScenarioConstants.SCENARIO_NON_BROKERED_ACQUIRE_TOKEN_SILENTLY, "MB");
        } else {
            SyncNotificationTypeStrings.getInstance();
            string = context.getString(SyncNotificationTypeStrings.getResIdTipCardBody(tipCard.getType()));
        }
        createNotification(context, 6, tipCard.getType(), string2, string);
    }

    private static PendingIntent getTipCardPendingIntent(Context context, int i) {
        Intent intentSupportEdgeLighting = EdgeLightingHelper.getIntentSupportEdgeLighting(context);
        intentSupportEdgeLighting.setFlags(603979776);
        intentSupportEdgeLighting.putExtra(SYNC_NOTIFICATION_KEY, Integer.toString(i));
        intentSupportEdgeLighting.setPackage(context.getPackageName());
        return EdgeLightingHelper.getPendingIntentSupportEdgeLighting(context, i, intentSupportEdgeLighting);
    }

    public static void saveNotiInfo(NotificationInfo notificationInfo) {
        mNotiInfo = notificationInfo;
    }

    public void cancelAllImportNotification() {
        if (this.mContext == null) {
            return;
        }
        Debugger.m8607d(TAG, "cancelAllImportNotification()");
        NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        notificationManager.cancel(TAG, AbstractC14517a.m15157q(0, 3));
        notificationManager.cancel(TAG, AbstractC14517a.m15157q(0, 4));
        notificationManager.cancel(TAG, AbstractC14517a.m15157q(0, 5));
        notificationManager.cancel(TAG, AbstractC14517a.m15157q(1, 3));
        notificationManager.cancel(TAG, AbstractC14517a.m15157q(1, 4));
        notificationManager.cancel(TAG, AbstractC14517a.m15157q(1, 5));
        notificationManager.cancel(TAG, AbstractC14517a.m15157q(2, 3));
        notificationManager.cancel(TAG, AbstractC14517a.m15157q(2, 4));
        notificationManager.cancel(TAG, AbstractC14517a.m15157q(2, 5));
    }

    public void cancelAllSyncNotification() {
        if (this.mContext == null) {
            return;
        }
        Debugger.m8607d(TAG, "cancelAllSyncNotification()");
        NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        notificationManager.cancel(TAG, 16);
        notificationManager.cancel(TAG, 2048);
        notificationManager.cancel(TAG, 128);
        notificationManager.cancel(TAG, 8192);
        notificationManager.cancel(TAG, 512);
        notificationManager.cancel(TAG, 1024);
    }

    public void cancelNetworkErrNotification() {
        if (this.mContext == null) {
            return;
        }
        Debugger.m8607d(TAG, "cancelNetworkErrNotification()");
        NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        notificationManager.cancel(TAG, AbstractC14517a.m15157q(0, 4));
        notificationManager.cancel(TAG, AbstractC14517a.m15157q(1, 4));
        notificationManager.cancel(TAG, AbstractC14517a.m15157q(2, 4));
    }

    public void launchImportNotification(DocTypeConstants docTypeConstants, int i) {
        if (this.mContext == null) {
            return;
        }
        int iM15154n = AbstractC14517a.m15154n(docTypeConstants);
        int iM15152l = AbstractC14517a.m15152l(i);
        if (iM15154n == -1 || iM15152l == -1) {
            return;
        }
        if (iM15152l != 4) {
            Debugger.m8609e(TAG, String.format("can't launchImportNotification(%s, %d)", docTypeConstants.toString(), Integer.valueOf(i)));
        } else {
            Debugger.m8607d(TAG, String.format("launchImportTipCardNotification(%s, %d)", docTypeConstants.toString(), Integer.valueOf(i)));
            createImportNotification(this.mContext, AbstractC14517a.m15157q(iM15154n, iM15152l), iM15152l, iM15154n);
        }
    }

    public void launchImportTipCardNotification(DocTypeConstants docTypeConstants, int i) {
        if (this.mContext == null) {
            return;
        }
        int iM15154n = AbstractC14517a.m15154n(docTypeConstants);
        int iM15152l = AbstractC14517a.m15152l(i);
        if (iM15154n == -1 || iM15152l == -1) {
            return;
        }
        if (iM15152l != 3 && iM15152l != 5) {
            Debugger.m8609e(TAG, String.format("can't launchImportTipCardNotification(%s, %d)", docTypeConstants.toString(), Integer.valueOf(i)));
        } else {
            Debugger.m8607d(TAG, String.format("launchImportTipCardNotification(%s, %d)", docTypeConstants.toString(), Integer.valueOf(i)));
            createImportNotification(this.mContext, AbstractC14517a.m15157q(iM15154n, iM15152l), iM15152l, iM15154n);
        }
    }

    public void launchSyncNotification(TipCard tipCard) {
        if (this.mContext == null) {
            return;
        }
        Debugger.m8607d(TAG, "launch sync notification of ".concat(C0137m.m282j(tipCard.getType())));
        if (tipCard.getType() != 10) {
            Debugger.m8607d(TAG, "launchSyncNotification() : No Noti!");
        } else {
            createSyncNotification(this.mContext, tipCard);
        }
    }

    public void launchSyncTipCardNotification(TipCard tipCard) {
        if (this.mContext == null) {
            return;
        }
        Debugger.m8607d(TAG, "launch sync notification of ".concat(C0137m.m282j(tipCard.getType())));
        int type = tipCard.getType();
        if (type == 5 || type == 8 || type == 12) {
            createSyncNotification(this.mContext, tipCard);
        } else {
            Debugger.m8607d(TAG, "launchSyncTipCardNotification() : No Noti!");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NotificationInfo {
        int errorType;
        int importType;
        final int key;
        String[] permission;
        TipCard tipCard;

        public NotificationInfo(int i, int i2, int i4) {
            this.key = i;
            this.errorType = i2;
            this.importType = i4;
        }

        public NotificationInfo(int i, TipCard tipCard) {
            this.key = i;
            this.tipCard = tipCard;
        }

        public NotificationInfo(int i, String[] strArr) {
            this.key = i;
            this.permission = strArr;
        }
    }
}
