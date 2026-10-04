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
import com.samsung.android.support.senl.p145cm.base.framework.app.StatusBarManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.sync.ReceiverAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.NotificationConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditNotificationManager {
    private static final String GROUP_KEY_COEDIT_NOTE = "com.samsung.android.app.notes.GROUP_KEY_COEDIT_NOTE";
    private static final int GROUP_SUMMARY_KEY_COEDIT_NOTE = 5011;
    private static final String TAG = "CoeditNotificationManager";
    private final Context mContext;

    public CoeditNotificationManager(Context context) {
        this.mContext = context;
    }

    private void cancelInviteSummaryNotification(NotificationManager notificationManager) {
        int i = 0;
        for (StatusBarNotification statusBarNotification : notificationManager.getActiveNotifications()) {
            String groupKey = statusBarNotification.getGroupKey();
            if (groupKey != null && groupKey.contains(GROUP_KEY_COEDIT_NOTE)) {
                i++;
            }
        }
        if (i == 1) {
            notificationManager.cancel(TAG, 5011);
        }
    }

    @NonNull
    private PendingIntent getAcceptPendingIntent(int i, String str, String str2) {
        Intent intent = new Intent(CoeditNotificationConstants.COEDIT_NOTIFICATION_INTENT_FILTER);
        intent.setClass(this.mContext, ReceiverAccessHandler.getCoeditPushReceiverClass());
        intent.putExtra(CoeditNotificationConstants.COEDIT_NOTIFICATION_KEY, Integer.toString(i));
        intent.putExtra(CoeditNotificationConstants.COEDIT_INVITATION_ACTION_DATA_GROUP_ID, str);
        intent.putExtra(CoeditNotificationConstants.COEDIT_INVITATION_ACTION_DATA_GROUP_NAME, str2);
        intent.putExtra(CoeditNotificationConstants.COEDIT_INVITATION_ACTION_KEY, CoeditNotificationConstants.COEDIT_ACTION_OK);
        intent.setPackage(this.mContext.getPackageName());
        return PendingIntent.getBroadcast(this.mContext, i, intent, 201326592);
    }

    private PendingIntent getActivityShowPendingIntent(int i) {
        Intent intent = new Intent(this.mContext, NoteListAccessHandler.getNoteListBaseActivityClass());
        intent.setPackage(this.mContext.getPackageName());
        intent.setAction(NotesConstants.ACTION_VIEW_CO_EDIT);
        return PendingIntent.getActivity(this.mContext, i, intent, 201326592);
    }

    @NonNull
    private PendingIntent getCancelPendingIntent(int i, String str, String str2) {
        Intent intent = new Intent(CoeditNotificationConstants.COEDIT_NOTIFICATION_INTENT_FILTER);
        intent.setClass(this.mContext, ReceiverAccessHandler.getCoeditPushReceiverClass());
        intent.putExtra(CoeditNotificationConstants.COEDIT_NOTIFICATION_KEY, Integer.toString(i));
        intent.putExtra(CoeditNotificationConstants.COEDIT_INVITATION_ACTION_DATA_GROUP_ID, str);
        intent.putExtra(CoeditNotificationConstants.COEDIT_INVITATION_ACTION_DATA_GROUP_NAME, str2);
        intent.putExtra(CoeditNotificationConstants.COEDIT_INVITATION_ACTION_KEY, CoeditNotificationConstants.COEDIT_ACTION_CANCEL);
        intent.setPackage(this.mContext.getPackageName());
        return PendingIntent.getBroadcast(this.mContext, i, intent, 201326592);
    }

    @NonNull
    private Notification.Builder getGroupNotificationBuilder(String str, PendingIntent pendingIntent) {
        int i = C8003R.drawable.stat_notify_notes;
        Notification.Builder builderCreateNotification = NotificationUtils.createNotification(this.mContext, NotificationConstants.MDE_NOTIFICATION_CHANNEL_ID, this.mContext.getString(C8003R.string.shared_notebooks), 4, false);
        builderCreateNotification.setContentTitle(str);
        builderCreateNotification.setSmallIcon(i);
        builderCreateNotification.setColor(this.mContext.getColor(C8003R.color.notification_primary));
        builderCreateNotification.setContentIntent(pendingIntent);
        builderCreateNotification.setGroup(GROUP_KEY_COEDIT_NOTE);
        builderCreateNotification.setAutoCancel(true);
        builderCreateNotification.setGroupSummary(true);
        return builderCreateNotification;
    }

    @NonNull
    private Notification.Builder getNotificationBuilder(String str, String str2, PendingIntent pendingIntent) {
        int i = C8003R.drawable.stat_notify_notes;
        Notification.Builder builderCreateNotification = NotificationUtils.createNotification(this.mContext, NotificationConstants.MDE_NOTIFICATION_CHANNEL_ID, this.mContext.getString(C8003R.string.shared_notebooks), 4, false);
        builderCreateNotification.setContentTitle(str);
        builderCreateNotification.setContentText(str2);
        builderCreateNotification.setSmallIcon(i);
        builderCreateNotification.setColor(this.mContext.getColor(C8003R.color.notification_primary));
        builderCreateNotification.setContentIntent(pendingIntent);
        builderCreateNotification.setAutoCancel(true);
        builderCreateNotification.setStyle(new Notification.BigTextStyle().bigText(str2));
        builderCreateNotification.setPriority(1);
        builderCreateNotification.setGroup(GROUP_KEY_COEDIT_NOTE);
        return builderCreateNotification;
    }

    public void cancelAllInvitationNotification() {
        Notification notification;
        Bundle bundle;
        Context context = this.mContext;
        if (context == null) {
            MainCoeditLogger.m7251e(TAG, "cancelAllInvitationNotification# Cannot cancel invitation notification!");
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager == null) {
            MainCoeditLogger.m7251e(TAG, "cancelAllInvitationNotification# notificationManager is null");
            return;
        }
        MainCoeditLogger.m7253i(TAG, "cancelAllInvitationNotification# [Notification] remove the MDE notification!");
        StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
        if (activeNotifications == null || activeNotifications.length == 0) {
            return;
        }
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            if (statusBarNotification != null && (notification = statusBarNotification.getNotification()) != null && (bundle = notification.extras) != null && bundle.getInt(CoeditNotificationConstants.MADE_NOTIFICATION_TYPE, -1) == 112) {
                try {
                    notificationManager.cancel(TAG, statusBarNotification.getId());
                } catch (Exception e) {
                    AbstractC4539a.m3204n(e, new StringBuilder("cancelAllInvitationNotification# Exception while canceling notification. "), TAG);
                }
            }
        }
    }

    public void cancelCoeditNotification(String str) {
        Context context = this.mContext;
        if (context == null) {
            MainCoeditLogger.m7251e(TAG, "cancelCoeditNotification# Cannot cancel notification!");
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager == null) {
            MainCoeditLogger.m7251e(TAG, "cancelCoeditNotification# notificationManager is null");
            return;
        }
        try {
            MainCoeditLogger.m7253i(TAG, "cancelCoeditNotification# [Notification] remove the MDE notification!");
            notificationManager.cancel(TAG, str.hashCode());
            cancelInviteSummaryNotification(notificationManager);
        } catch (Exception e) {
            AbstractC4539a.m3204n(e, new StringBuilder("cancelCoeditNotification# Exception while canceling notification. "), TAG);
        }
    }

    public void closeSystemDialogIntent(String str) {
        MainCoeditLogger.m7253i(TAG, "closeSystemDialogIntent# groupId: " + str);
        cancelCoeditNotification(str);
        StatusBarManagerCompat.INSTANCE.getInstance().collapsePanels(this.mContext);
    }

    public void createInfoNotification(String str, String str2, String str3, PendingIntent pendingIntent) {
        int iHashCode = str.hashCode();
        MainCoeditLogger.m7253i(TAG, "createInfoNotification# start key:" + iHashCode);
        ((NotificationManager) this.mContext.getSystemService("notification")).notify(TAG, iHashCode, getNotificationBuilder(str2, str3, pendingIntent).build());
        MainCoeditLogger.m7253i(TAG, "createButtonNotification() notify : " + iHashCode + " (" + MainLogger.getEncode(str2) + ")");
    }

    public void createInvitedNotification(String str, String str2, String str3, String str4) {
        int iHashCode = str.hashCode();
        MainCoeditLogger.m7253i(TAG, "createInvitedNotification# start key:" + iHashCode);
        PendingIntent cancelPendingIntent = getCancelPendingIntent(iHashCode, str, str2);
        PendingIntent acceptPendingIntent = getAcceptPendingIntent(iHashCode + 1, str, str2);
        PendingIntent activityShowPendingIntent = getActivityShowPendingIntent(iHashCode + 2);
        Notification.Builder groupNotificationBuilder = getGroupNotificationBuilder(this.mContext.getString(C8003R.string.shared_notebooks), activityShowPendingIntent);
        NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        Notification.Builder notificationBuilder = getNotificationBuilder(str3, str4, activityShowPendingIntent);
        notificationBuilder.addAction(new Notification.Action.Builder((Icon) null, this.mContext.getString(C8003R.string.gcs_invitations_join_dialog_decline), cancelPendingIntent).build());
        notificationBuilder.addAction(new Notification.Action.Builder((Icon) null, this.mContext.getString(C8003R.string.co_edit_invitation_join), acceptPendingIntent).build());
        Notification notificationBuild = notificationBuilder.build();
        notificationBuild.extras.putInt(CoeditNotificationConstants.COEDIT_NOTIFICATION_KEY, iHashCode);
        notificationBuild.extras.putInt(CoeditNotificationConstants.MADE_NOTIFICATION_TYPE, 112);
        notificationManager.notify(TAG, iHashCode, notificationBuild);
        MainCoeditLogger.m7253i(TAG, "[CS2] createInvitedNotification() notify : " + iHashCode + "(" + str3 + ")");
        notificationManager.notify(TAG, 5011, groupNotificationBuilder.build());
    }
}
