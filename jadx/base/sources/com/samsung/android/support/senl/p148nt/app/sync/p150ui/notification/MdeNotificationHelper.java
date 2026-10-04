package com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditGroupReadResolver;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.sync.ReceiverAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.NotificationConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import p001A.AbstractC0000a;
import p079T.AbstractC0291i;
import p079T.AbstractC0294l;
import p079T.C0283a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class MdeNotificationHelper {
    public static final String MADE_NOTIFICATION_TYPE = "mde_notification_type";
    public static final String MDE_ACTION_CANCEL = "mde_cancel";
    public static final String MDE_ACTION_OK = "mde_ok";
    public static final String MDE_INVITATION_ACTION_DATA_GROUP_ID = "mde_invitation_action_data_group_id";
    public static final String MDE_INVITATION_ACTION_KEY = "mde_invitation_action_key";
    public static final String MDE_NOTIFICATION_ADDED_ITEM_OPENED_FROM_SES = "com.samsung.android.app.notes.sync.ui.MDE_NOTIFICATION_ADDED_ITEM_OPENED_FROM_SES";
    public static final String MDE_NOTIFICATION_INTENT_FILTER = "com.samsung.android.app.notes.sync.ui.MDE_NOTIFICATION_INTENT_FILTER";
    public static final String MDE_NOTIFICATION_KEY = "mde_notification_key";
    public static final int MDE_NOTIFICATION_TYPE_INVITE = 111;
    private static final String TAG = "MdeNotificationHelper";
    private final Context mContext;

    public MdeNotificationHelper(Context context) {
        this.mContext = context;
    }

    public static void cancelMdeNotification(Context context, String str) throws Exception {
        if (context == null) {
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                Debugger.m8607d(TAG, "[Notification] remove the MDE notification!");
                notificationManager.cancel(TAG, str.hashCode());
            }
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("Exception while canceling notification. "), TAG);
            throw e;
        }
    }

    private static void createButtonNotification(Context context, String str, String str2, String str3) {
        String string = context.getString(C8003R.string.co_edit_notification_shared_notebook_invitation);
        String str4 = context.getString(C8003R.string.co_edit_notification_shared_notebook_invitation_message, str2) + "\n" + str3;
        int i = C8003R.string.gcs_invitations_join_dialog_accept;
        int iHashCode = str.hashCode();
        int i2 = C8003R.drawable.stat_notify_notes;
        Notification.Builder builderCreateNotification = NotificationUtils.createNotification(context, NotificationConstants.MDE_NOTIFICATION_CHANNEL_ID, context.getString(C8003R.string.shared_notebooks), 4, false);
        PendingIntent cancelPendingIntent = getCancelPendingIntent(context, iHashCode, str);
        PendingIntent acceptPendingIntent = getAcceptPendingIntent(context, iHashCode + 1, str);
        PendingIntent activityShowPendingIntent = getActivityShowPendingIntent(context, iHashCode + 2);
        builderCreateNotification.setContentTitle(string);
        builderCreateNotification.setContentText(str4);
        builderCreateNotification.setSmallIcon(i2);
        builderCreateNotification.setColor(context.getResources().getColor(C8003R.color.notes_primary_color, context.getTheme()));
        builderCreateNotification.setContentIntent(activityShowPendingIntent);
        builderCreateNotification.setAutoCancel(true);
        builderCreateNotification.setStyle(new Notification.BigTextStyle().bigText(str4));
        builderCreateNotification.setPriority(1);
        if (acceptPendingIntent != null) {
            if (cancelPendingIntent != null) {
                builderCreateNotification.addAction(new Notification.Action.Builder((Icon) null, context.getString(C8003R.string.gcs_invitations_join_dialog_decline).toUpperCase(), cancelPendingIntent).build());
            }
            String upperCase = context.getString(i).toUpperCase();
            if (!TextUtils.isEmpty(upperCase)) {
                builderCreateNotification.addAction(new Notification.Action.Builder((Icon) null, upperCase, acceptPendingIntent).build());
            }
        }
        Notification notificationBuild = builderCreateNotification.build();
        notificationBuild.extras.putInt(MDE_NOTIFICATION_KEY, iHashCode);
        notificationBuild.extras.putInt(MADE_NOTIFICATION_TYPE, 111);
        ((NotificationManager) context.getSystemService("notification")).notify(TAG, iHashCode, notificationBuild);
        Debugger.m8607d(TAG, String.format("createButtonNotification() notify : %d (%s)", Integer.valueOf(iHashCode), string));
    }

    private static void createInfoNotification(Context context, String str, String str2, String str3, PendingIntent pendingIntent, boolean z) {
        int iHashCode = str.hashCode();
        int i = C8003R.drawable.stat_notify_notes;
        Notification.Builder builderCreateNotification = NotificationUtils.createNotification(context, NotificationConstants.MDE_NOTIFICATION_CHANNEL_ID, context.getString(C8003R.string.shared_notebooks), 4, z);
        builderCreateNotification.setContentTitle(str2);
        builderCreateNotification.setContentText(str3);
        builderCreateNotification.setSmallIcon(i);
        builderCreateNotification.setContentIntent(pendingIntent);
        builderCreateNotification.setAutoCancel(true);
        builderCreateNotification.setStyle(new Notification.BigTextStyle().bigText(str3));
        builderCreateNotification.setPriority(1);
        builderCreateNotification.setColor(context.getResources().getColor(C8003R.color.notes_primary_color, context.getTheme()));
        ((NotificationManager) context.getSystemService("notification")).notify(TAG, iHashCode, builderCreateNotification.build());
        Debugger.m8607d(TAG, String.format("createButtonNotification() notify : %d (%s)", Integer.valueOf(iHashCode), str2));
    }

    private static PendingIntent getAcceptPendingIntent(Context context, int i, String str) {
        Intent intent = new Intent(MDE_NOTIFICATION_INTENT_FILTER);
        intent.setClass(context, ReceiverAccessHandler.getMdePushReceiverClass());
        intent.putExtra(MDE_NOTIFICATION_KEY, Integer.toString(i));
        intent.putExtra(MDE_INVITATION_ACTION_DATA_GROUP_ID, str);
        intent.putExtra(MDE_INVITATION_ACTION_KEY, MDE_ACTION_OK);
        intent.setPackage(context.getPackageName());
        return PendingIntent.getBroadcast(context, i, intent, 201326592);
    }

    private static PendingIntent getActivityShowPendingIntent(Context context, int i) {
        Intent intent = new Intent(context, NoteListAccessHandler.getSharedInvitationListClass());
        intent.setPackage(context.getPackageName());
        return PendingIntent.getActivity(context, i, intent, 201326592);
    }

    private static PendingIntent getCancelPendingIntent(Context context, int i, String str) {
        Intent intent = new Intent(MDE_NOTIFICATION_INTENT_FILTER);
        intent.setClass(context, ReceiverAccessHandler.getMdePushReceiverClass());
        intent.putExtra(MDE_NOTIFICATION_KEY, Integer.toString(i));
        intent.putExtra(MDE_INVITATION_ACTION_DATA_GROUP_ID, str);
        intent.putExtra(MDE_INVITATION_ACTION_KEY, MDE_ACTION_CANCEL);
        intent.setPackage(context.getPackageName());
        return PendingIntent.getBroadcast(context, i, intent, 201326592);
    }

    private static PendingIntent getSharedNotebookActivityShowPendingIntent(Context context, int i) {
        return getSharedNotebookActivityShowPendingIntent(context, i, null, null);
    }

    public PendingIntent getMemberDetailIntent(String str) {
        return PendingIntent.getActivity(this.mContext, str.hashCode(), AbstractC0294l.m575b(str, null), 201326592);
    }

    public void launchMdeInvitationNotification(String str, String str2, String str3) {
        createButtonNotification(this.mContext, str, str2, str3);
    }

    public void launchMdeItemAddedNotification(String str, String str2, String str3, String str4, int i) {
        createInfoNotification(this.mContext, str, this.mContext.getResources().getQuantityString(C8003R.plurals.plurals_gcs_item_added_title, i, Integer.valueOf(i)), TextUtils.isEmpty(str4) ? i <= 1 ? this.mContext.getString(C8003R.string.gcs_item_added_body_single_no_member_name, str3) : this.mContext.getString(C8003R.string.gcs_item_added_body_multi_no_member_name, str3) : i <= 1 ? this.mContext.getString(C8003R.string.gcs_item_added_body_single, str4, str3) : this.mContext.getResources().getQuantityString(C8003R.plurals.plurals_gcs_item_added_body, i, str4, Integer.valueOf(i), str3), getSharedNotebookActivityShowPendingIntent(this.mContext, str2.hashCode(), str, str2), false);
    }

    public void launchMdeMemberJoinNotification(String str, String str2, String str3) {
        PendingIntent memberDetailIntent = getMemberDetailIntent(str);
        Context context = this.mContext;
        createInfoNotification(context, str, context.getString(C8003R.string.gcs_new_member_joined_title), this.mContext.getString(C8003R.string.gcs_new_member_joined_body, str2, str3), memberDetailIntent, false);
    }

    public void launchMdeMemberLeftNotification(String str, String str2, String str3) {
        PendingIntent memberDetailIntent = getMemberDetailIntent(str);
        Context context = this.mContext;
        createInfoNotification(context, str, context.getString(C8003R.string.gcs_member_left_title), this.mContext.getString(C8003R.string.gcs_member_left_body, str2, str3), memberDetailIntent, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void launchMdeMemberRemovedNotification(String str, String str2, String str3, String str4) {
        PendingIntent sharedNotebookActivityShowPendingIntent;
        if (str4 != null) {
            C0283a.m562d().getClass();
            sharedNotebookActivityShowPendingIntent = str4.equals(C0283a.m561c()) ? getSharedNotebookActivityShowPendingIntent(this.mContext, str.hashCode()) : getMemberDetailIntent(str);
        }
        PendingIntent pendingIntent = sharedNotebookActivityShowPendingIntent;
        if (AbstractC0291i.m570g(str3)) {
            StringBuilder sbM781w = AbstractC0541b.m781w(str3, "\n");
            sbM781w.append(this.mContext.getString(C8003R.string.gcs_member_removed_body_for_shared_note, str2));
            String string = sbM781w.toString();
            Context context = this.mContext;
            createInfoNotification(context, str, context.getString(C8003R.string.gcs_member_removed_title_for_shared_note), string, pendingIntent, false);
            return;
        }
        StringBuilder sbM781w2 = AbstractC0541b.m781w(str3, "\n");
        sbM781w2.append(this.mContext.getString(C8003R.string.gcs_member_removed_body_for_shared_notebook, str2));
        String string2 = sbM781w2.toString();
        Context context2 = this.mContext;
        createInfoNotification(context2, str, context2.getString(C8003R.string.gcs_member_removed_title_for_shared_notebook), string2, pendingIntent, false);
    }

    public void launchMdeSpaceDeletedNotification(String str, String str2) {
        PendingIntent sharedNotebookActivityShowPendingIntent = getSharedNotebookActivityShowPendingIntent(this.mContext, str.hashCode());
        String userName = SesCoeditGroupReadResolver.getInstance().getUserName(str, SesCoeditGroupReadResolver.getInstance().getLeaderId(str));
        StringBuilder sbM781w = AbstractC0541b.m781w(str2, "\n");
        sbM781w.append(this.mContext.getString(C8003R.string.co_edit_notification_item_deleted_body, userName, str2));
        String string = sbM781w.toString();
        Context context = this.mContext;
        createInfoNotification(context, str, context.getString(C8003R.string.co_edit_notification_item_deleted_title), string, sharedNotebookActivityShowPendingIntent, false);
    }

    private static PendingIntent getSharedNotebookActivityShowPendingIntent(Context context, int i, String str, String str2) {
        Intent intent = new Intent(context, NoteListAccessHandler.getNoteListBaseActivityClass());
        if (str != null && !str.isEmpty()) {
            intent.putExtra("spaceId", str);
        }
        if (str2 != null && !str2.isEmpty()) {
            intent.putExtra("groupId", str2);
        }
        intent.setPackage(context.getPackageName());
        intent.setAction(Constants.ACTION_START_SHARED_NOTES);
        return PendingIntent.getActivity(context, i, intent, 201326592);
    }
}
