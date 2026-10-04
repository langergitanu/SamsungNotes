package com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.appcompat.util.SeslKoreanGeneralizer;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import p079T.AbstractC0291i;
import p079T.AbstractC0294l;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditLaunchNotification {
    private static final String TAG = "CoeditLaunchNotification";
    private final CoeditNotificationManager mCoeditNotificationManager;
    private final Context mContext;

    public CoeditLaunchNotification(Context context) {
        this.mContext = context;
        this.mCoeditNotificationManager = new CoeditNotificationManager(context);
    }

    private PendingIntent getCoeditMemberDetailIntent(String str, String str2) {
        MainCoeditLogger.m7253i(TAG, "getCoeditMemberDetailIntent# groupId:" + str);
        return PendingIntent.getActivity(this.mContext, str.hashCode(), AbstractC0294l.m574a(str, str2, false), 201326592);
    }

    private PendingIntent getSharedNotesListIntent(int i, String str, String str2) {
        StringBuilder sbM1629s = AbstractC2322a.m1629s("getSharedNotesListIntent# key:", i, ", groupId:", str, ", spaceId:");
        sbM1629s.append(str2);
        MainCoeditLogger.m7253i(TAG, sbM1629s.toString());
        Intent intent = new Intent(this.mContext, NoteListAccessHandler.getNoteListBaseActivityClass());
        intent.putExtra("groupId", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("spaceId", str2);
        }
        intent.setPackage(this.mContext.getPackageName());
        intent.setAction(NotesConstants.ACTION_VIEW_CO_EDIT);
        return PendingIntent.getActivity(this.mContext, i, intent, 201326592);
    }

    private PendingIntent getSharedNotesMainIntent(int i) {
        MainCoeditLogger.m7253i(TAG, "getSharedNotesMainIntent# key:" + i);
        Intent intent = new Intent(this.mContext, NoteListAccessHandler.getNoteListBaseActivityClass());
        intent.setPackage(this.mContext.getPackageName());
        intent.setAction(NotesConstants.ACTION_VIEW_CO_EDIT);
        return PendingIntent.getActivity(this.mContext, i, intent, 201326592);
    }

    private String getStandaloneNoteName(String str) {
        String[] strArrSplit = str.split(" ", 2);
        return strArrSplit.length < 2 ? str : strArrSplit[1];
    }

    public void cancelGroupInvitedNotification(String str) {
        MainCoeditLogger.m7253i(TAG, "cancelGroupInvitedNotification# groupId:" + str);
        this.mCoeditNotificationManager.cancelCoeditNotification(str);
    }

    public void launchGroupDeletedNotification(String str, String str2) {
        MainCoeditLogger.m7253i(TAG, "launchGroupDeletedNotification# groupId:" + str);
        PendingIntent sharedNotesMainIntent = getSharedNotesMainIntent(str.hashCode());
        String string = this.mContext.getString(C8003R.string.gcs_space_deleted_title);
        String strNaturalizeText = new SeslKoreanGeneralizer().naturalizeText(this.mContext.getString(C8003R.string.gcs_space_deleted_body, str2));
        this.mCoeditNotificationManager.cancelCoeditNotification(str);
        this.mCoeditNotificationManager.createInfoNotification(str, string, strNaturalizeText, sharedNotesMainIntent);
    }

    public void launchInvitationNotification(String str, String str2, String str3) {
        String string;
        String str4;
        MainCoeditLogger.m7253i(TAG, "[CS2] launchInvitationNotification#");
        if (AbstractC0291i.m570g(str2)) {
            string = this.mContext.getResources().getString(C8003R.string.co_edit_notification_shared_note_invitation);
            str4 = this.mContext.getString(C8003R.string.co_edit_notification_shared_note_invitation_message, str3) + "\n" + getStandaloneNoteName(str2);
        } else {
            string = this.mContext.getResources().getString(C8003R.string.co_edit_notification_shared_notebook_invitation);
            str4 = this.mContext.getString(C8003R.string.co_edit_notification_shared_notebook_invitation_message, str3) + "\n" + str2;
        }
        this.mCoeditNotificationManager.createInvitedNotification(str, str2, string, str4);
    }

    public void launchItemAddedNotification(String str, String str2, String str3, String str4, int i) {
        MainCoeditLogger.m7253i(TAG, "[CS2] launchItemAddedNotification# itemNumber:" + i);
        if (AbstractC0291i.m570g(str3)) {
            return;
        }
        PendingIntent sharedNotesListIntent = getSharedNotesListIntent(str.hashCode(), str, str2);
        String quantityString = this.mContext.getResources().getQuantityString(C8003R.plurals.plurals_gcs_item_added_title, i, Integer.valueOf(i));
        if (str4 == null) {
            str4 = this.mContext.getString(C8003R.string.co_edit_member_manage_sub_header);
        }
        this.mCoeditNotificationManager.createInfoNotification(str, quantityString, i <= 1 ? this.mContext.getString(C8003R.string.gcs_item_added_body_single, str4, str3) : this.mContext.getResources().getQuantityString(C8003R.plurals.plurals_gcs_item_added_body, i, str4, Integer.valueOf(i), str3), sharedNotesListIntent);
    }

    public void launchItemDeletedNotification(String str, String str2, String str3, String str4, boolean z, String str5) {
        String string;
        PendingIntent sharedNotesListIntent;
        MainCoeditLogger.m7253i(TAG, "launchItemDeletedNotification# groupId:" + str);
        String string2 = this.mContext.getString(C8003R.string.co_edit_notification_item_deleted_title);
        if (TextUtils.isEmpty(str5)) {
            str5 = this.mContext.getString(C8003R.string.co_edit_invitation_default_name);
        }
        if (z) {
            if (str4 != null) {
                str4 = str4.replace("Group://Standalone ", "");
            }
            StringBuilder sbM781w = AbstractC0541b.m781w(str4, "\n");
            sbM781w.append(this.mContext.getString(C8003R.string.co_edit_notification_item_deleted_body, str5, str4));
            string = sbM781w.toString();
            sharedNotesListIntent = getSharedNotesMainIntent(str.hashCode());
        } else {
            StringBuilder sbM781w2 = AbstractC0541b.m781w(str4, "\n");
            sbM781w2.append(this.mContext.getString(C8003R.string.co_edit_notification_item_deleted_notebook_by_leader_body, str5, str4, str2));
            string = sbM781w2.toString();
            sharedNotesListIntent = getSharedNotesListIntent(str.hashCode(), str, str3);
        }
        this.mCoeditNotificationManager.createInfoNotification(str, string2, string, sharedNotesListIntent);
    }

    public void launchLeaderDelegationNotification(String str, String str2, String str3) {
        MainCoeditLogger.m7253i(TAG, "launchLeaderDelegationNotification# groupId:" + str);
        this.mCoeditNotificationManager.createInfoNotification(str, this.mContext.getString(C8003R.string.co_edit_notification_leader_changed_title), str3, getCoeditMemberDetailIntent(str, str2));
    }

    public void launchMemberDeletedNotification(String str, String str2, String str3) {
        String string;
        String string2;
        MainCoeditLogger.m7253i(TAG, "launchMemberDeletedNotification# groupId:" + str);
        PendingIntent sharedNotesMainIntent = getSharedNotesMainIntent(str.hashCode());
        if (AbstractC0291i.m570g(str2)) {
            string = this.mContext.getString(C8003R.string.gcs_member_removed_title_for_shared_note);
            string2 = getStandaloneNoteName(str2) + "\n" + new SeslKoreanGeneralizer().naturalizeText(this.mContext.getString(C8003R.string.gcs_member_removed_body_for_shared_note, str3));
        } else {
            string = this.mContext.getString(C8003R.string.gcs_member_removed_title_for_shared_notebook);
            StringBuilder sbM781w = AbstractC0541b.m781w(str2, "\n");
            sbM781w.append(new SeslKoreanGeneralizer().naturalizeText(this.mContext.getString(C8003R.string.gcs_member_removed_body_for_shared_notebook, str3)));
            string2 = sbM781w.toString();
        }
        this.mCoeditNotificationManager.createInfoNotification(str, string, string2, sharedNotesMainIntent);
    }
}
