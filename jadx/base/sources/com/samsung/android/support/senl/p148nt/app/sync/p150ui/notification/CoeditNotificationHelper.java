package com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.CoeditInvitationMenuBadgeUpdater;
import com.samsung.android.support.senl.p148nt.app.common.data.RepositoryManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import com.samsung.android.support.senl.p148nt.app.sync.receiver.CoeditInviteReceivedReceiver;
import com.samsung.android.support.senl.p148nt.base.common.MultiTaskManager;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.sync.UserInfo;
import com.samsung.android.support.senl.p148nt.base.framework.support.ActivityManagerUtil;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import p001A.AbstractC0000a;
import p033H0.C0112b;
import p075S.AbstractC0254f;
import p075S.AbstractC0267s;
import p079T.AbstractC0291i;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditNotificationHelper {
    private static final String TAG = "CoeditNotificationHelper";
    private final CoeditLaunchNotification mCoeditLaunchNotification;
    private final Context mContext;
    private final Intent mIntent;
    private final SyncNoteDataRepository mSyncNoteDataRepository = new SyncNoteDataRepository();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CoeditInviteResultAsyncTask extends AsyncTask<Void, Void, String> {
        private static final String TAG = "CoeditInviteResultAsyncTask";
        private final String MSG_SUCCESS = "SUCCESS";
        private final Context mContext;
        private final String mGroupId;
        private final String mGroupName;
        private final String mIsAccept;

        public CoeditInviteResultAsyncTask(Context context, String str, String str2, String str3) {
            this.mContext = context;
            this.mGroupId = str;
            this.mGroupName = str2;
            this.mIsAccept = str3;
        }

        private String getNoteName() {
            return AbstractC0291i.m570g(this.mGroupName) ? this.mContext.getResources().getString(C8003R.string.co_edit_notification_shared_note) : this.mContext.getResources().getString(C8003R.string.co_edit_notification_shared_notebook);
        }

        @Override // android.os.AsyncTask
        public String doInBackground(Void... voidArr) {
            String string;
            try {
                try {
                    C6715o.m4808q().m4796c(3);
                } catch (Exception e) {
                    MainCoeditLogger.m7251e(TAG, "doInBackground# e : " + e.getMessage());
                }
                if (!CoeditNotificationConstants.COEDIT_ACTION_OK.equals(this.mIsAccept)) {
                    if (CoeditNotificationConstants.COEDIT_ACTION_CANCEL.equals(this.mIsAccept)) {
                        AbstractC0254f.m537c(this.mGroupId);
                        MainCoeditLogger.m7253i(TAG, "doInBackground# COEDIT_ACTION_CANCEL invite bye");
                        CoeditInvitationMenuBadgeUpdater.setInvitationListHasBadgePref(this.mGroupId, false);
                        string = this.mContext.getResources().getString(C8003R.string.co_edit_notification_invite_decline_message, getNoteName());
                    }
                    return null;
                }
                MainCoeditLogger.m7253i(TAG, "doInBackground# isFirstTimeToCoeditJoinAndAADC");
                CoeditInvitationMenuBadgeUpdater.setInvitationListHasBadgePref(this.mGroupId, false);
                string = "SUCCESS";
                return string;
            } finally {
                C6715o.m4808q().m4797d(3, null);
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            MainCoeditLogger.m7253i(TAG, "onPostExecute#");
            if (!"SUCCESS".equals(str)) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                ToastHandler.show(this.mContext.getApplicationContext(), str, 0);
                return;
            }
            Intent intent = new Intent(this.mContext, NoteListAccessHandler.getNoteListClass());
            intent.setAction(Constants.ACTION_START_COEDIT);
            intent.setFlags(402653184);
            intent.putExtra("group_id", this.mGroupId);
            intent.putExtra("group_name", this.mGroupName);
            intent.putExtra(GcsConstants.SES_ACCEPTED_BY_NOTIFICATION, true);
            MultiTaskManager.getInstance().startActivity(this.mContext.getApplicationContext(), intent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CoeditUserNameAsyncTask extends AsyncTask<Void, Void, String> {
        private static final String TAG = "CoeditUserNameAsyncTask";
        private final Context mContext;
        private final OwnerNameRunnable mFinishedRunnable;
        private final String mGroupId;
        private final String mItemId;
        private final String mSpaceId;

        public CoeditUserNameAsyncTask(Context context, String str, String str2, String str3, OwnerNameRunnable ownerNameRunnable) {
            this.mContext = context;
            this.mGroupId = str;
            this.mSpaceId = str2;
            this.mItemId = str3;
            this.mFinishedRunnable = ownerNameRunnable;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00e0 A[Catch: all -> 0x006f, Exception -> 0x0072, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0072, blocks: (B:3:0x0019, B:5:0x004e, B:12:0x0074, B:14:0x007a, B:16:0x008c, B:17:0x009e, B:19:0x00c1, B:22:0x00e0), top: B:28:0x0019, outer: #1 }] */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String doInBackground(Void... voidArr) {
            String creatorName;
            MainCoeditLogger.m7253i(TAG, "[CS2] doInBackground#");
            try {
                try {
                    C6715o.m4808q().m4796c(3);
                    AbstractC0267s.m547e(this.mSpaceId);
                    MainCoeditLogger.m7250d(TAG, "[CS2-2] doInBackground# mSpaceId:" + this.mSpaceId + ",mItemId:" + this.mItemId);
                    UserInfo coeditNoteUserInfo = SesCoeditShareReadResolver.getInstance().getCoeditNoteUserInfo(this.mContext, this.mSpaceId, this.mItemId);
                    if (coeditNoteUserInfo != null) {
                        if (coeditNoteUserInfo.getCreatorName() == null) {
                            MainCoeditLogger.m7250d(TAG, "[CS2-2] userInfo.getCreatorName() == null");
                            C0112b c0112b = new C0112b(this.mGroupId);
                            if (c0112b.m265b()) {
                                String coeditNoteCreatorId = SesCoeditShareReadResolver.getInstance().getCoeditNoteCreatorId(this.mContext, this.mSpaceId, this.mItemId);
                                MainCoeditLogger.m7250d(TAG, "[CS2-2] doInBackground# getItemCreatorId:" + MainLogger.getEncode(coeditNoteCreatorId));
                                if (coeditNoteCreatorId != null) {
                                    creatorName = c0112b.m266j(coeditNoteCreatorId);
                                    MainCoeditLogger.m7250d(TAG, "[CS2-2] doInBackground# getUserNameByOwnerGuid:" + MainLogger.getEncode(creatorName));
                                } else {
                                    creatorName = coeditNoteUserInfo.getCreatorName();
                                }
                            } else {
                                MainCoeditLogger.m7250d(TAG, "[CS2-2] doInBackground# cacheGroupMemberInfo is fail. mGroupId:" + this.mGroupId);
                            }
                        }
                        return creatorName;
                    }
                    MainCoeditLogger.m7251e(TAG, "[CS2-2] doInBackground# getCoeditNoteUserInfo is null. mSpaceId:" + this.mSpaceId + ",mItemId:" + this.mItemId);
                } catch (Exception e) {
                    MainCoeditLogger.m7251e(TAG, "[CS2-2] doInBackground# " + e.getMessage());
                }
                return "";
            } finally {
                C6715o.m4808q().m4797d(3, null);
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            MainCoeditLogger.m7253i(TAG, "[CS2-2] onPostExecute#" + MainLogger.getEncode(str));
            OwnerNameRunnable ownerNameRunnable = this.mFinishedRunnable;
            if (ownerNameRunnable != null) {
                ownerNameRunnable.init(str).run();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class OwnerNameRunnable implements Runnable {
        private String mUserName;

        public String getUserName() {
            return this.mUserName;
        }

        public Runnable init(String str) {
            this.mUserName = str;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainCoeditLogger.m7253i(CoeditNotificationHelper.TAG, "OwnerNameRunnable#");
        }
    }

    public CoeditNotificationHelper(Context context, Intent intent) {
        this.mContext = context;
        this.mIntent = intent;
        this.mCoeditLaunchNotification = new CoeditLaunchNotification(context);
    }

    private String getAutoTitleStandAlone(String str, String str2) {
        MainCoeditLogger.m7253i(TAG, "getAutoTitleStandAlone# title is null : " + MainLogger.getEncode(str));
        return this.mContext.getString(C8003R.string.co_edit_notification_invite_auto_title, str, getDateStringByGroupIdStandAlone(str2));
    }

    private String getCreatedAt(@NonNull String str) {
        NotesDocumentEntity notesDocumentEntity;
        NotesDocumentRepository noteRepository = RepositoryManager.getInstance().getNoteRepository();
        return (noteRepository == null || (notesDocumentEntity = noteRepository.get(str)) == null) ? "" : WidgetUtils.getTitleTime(notesDocumentEntity.getCreatedAt());
    }

    private String getDateStringByGroupIdStandAlone(String str) {
        String uuidByGroupIdStandAlone = this.mSyncNoteDataRepository.getUuidByGroupIdStandAlone(str);
        return !TextUtils.isEmpty(uuidByGroupIdStandAlone) ? getCreatedAt(uuidByGroupIdStandAlone) : "";
    }

    private String getTitleByGroupIdStandAlone(String str) {
        String uuidByGroupIdStandAlone = this.mSyncNoteDataRepository.getUuidByGroupIdStandAlone(str);
        return !TextUtils.isEmpty(uuidByGroupIdStandAlone) ? this.mSyncNoteDataRepository.getTitle(uuidByGroupIdStandAlone) : "";
    }

    public void cancelNotifyByInviteCanceled() {
        MainCoeditLogger.m7253i(TAG, "cancelNotifyByInviteCanceled#");
        String stringExtra = this.mIntent.getStringExtra("group_id");
        String stringExtra2 = this.mIntent.getStringExtra("group_name");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            MainCoeditLogger.m7251e(TAG, "cancelNotifyByInviteCanceled# Null : " + stringExtra + SQLKeyword.COMMA + stringExtra2);
        }
        this.mCoeditLaunchNotification.cancelGroupInvitedNotification(stringExtra);
    }

    public String getDocUuidByItemId(String str, String str2) {
        return this.mSyncNoteDataRepository.getUuidByItemId(str, str2);
    }

    public String getTitleByItemId(String str, String str2) {
        String uuidByItemId = this.mSyncNoteDataRepository.getUuidByItemId(str, str2);
        if (!TextUtils.isEmpty(uuidByItemId)) {
            String title = this.mSyncNoteDataRepository.getTitle(uuidByItemId);
            if (!TextUtils.isEmpty(title)) {
                return title;
            }
        }
        UserInfo coeditNoteUserInfo = SesCoeditShareReadResolver.getInstance().getCoeditNoteUserInfo(this.mContext, str, str2);
        if (coeditNoteUserInfo != null && !TextUtils.isEmpty(coeditNoteUserInfo.getCreatorName()) && !TextUtils.isEmpty(uuidByItemId)) {
            return this.mContext.getString(C8003R.string.co_edit_notification_invite_auto_title, coeditNoteUserInfo.getCreatorName(), getCreatedAt(uuidByItemId));
        }
        MainCoeditLogger.m7251e(TAG, "getTitleByItemId# getCoeditNoteUserInfo is null. mSpaceId:" + str + ",mItemId:" + str2);
        return this.mContext.getString(C8003R.string.base_title_no_title);
    }

    public void notifyGroupDelegateAuthorityOfOwner() {
        String string;
        MainCoeditLogger.m7253i(TAG, "notifyGroupDelegateAuthorityOfOwner#");
        String stringExtra = this.mIntent.getStringExtra("group_id");
        String stringExtra2 = this.mIntent.getStringExtra("group_name");
        String stringExtra3 = this.mIntent.getStringExtra(CoeditNotificationConstants.EXTRA_GROUP_REQUESTR_NAME);
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra3)) {
            StringBuilder sbM16m = AbstractC0000a.m16m("notifyGroupDelegateAuthorityOfOwner# null : ", stringExtra, SQLKeyword.COMMA, stringExtra2, SQLKeyword.COMMA);
            sbM16m.append(stringExtra3);
            MainCoeditLogger.m7251e(TAG, sbM16m.toString());
        } else {
            if (!AbstractC0291i.m570g(stringExtra2)) {
                this.mCoeditLaunchNotification.launchLeaderDelegationNotification(stringExtra, stringExtra2, this.mContext.getString(C8003R.string.co_edit_notification_leader_changed_notebook_body, stringExtra3, stringExtra2));
                return;
            }
            String titleByGroupIdStandAlone = getTitleByGroupIdStandAlone(stringExtra);
            if (TextUtils.isEmpty(titleByGroupIdStandAlone)) {
                titleByGroupIdStandAlone = getAutoTitleStandAlone(stringExtra3, stringExtra);
                string = this.mContext.getString(C8003R.string.co_edit_notification_leader_changed_note_auto_title_body, stringExtra3, titleByGroupIdStandAlone);
            } else {
                string = this.mContext.getString(C8003R.string.co_edit_notification_leader_changed_note_body, stringExtra3, titleByGroupIdStandAlone);
            }
            this.mCoeditLaunchNotification.launchLeaderDelegationNotification(stringExtra, titleByGroupIdStandAlone, string);
        }
    }

    public void notifyGroupDeleted() {
        String stringExtra = this.mIntent.getStringExtra("group_id");
        String stringExtra2 = this.mIntent.getStringExtra("group_name");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            MainCoeditLogger.m7251e(TAG, "notifyGroupDeleted# Null : " + stringExtra + SQLKeyword.COMMA + stringExtra2);
        }
        this.mCoeditLaunchNotification.launchGroupDeletedNotification(stringExtra, stringExtra2);
    }

    public void notifyGroupInvite() {
        if (!ActivityManagerUtil.isAppInBackground(this.mContext)) {
            MainCoeditLogger.m7253i(TAG, "[CS2] notifyGroupInvite# ignore");
            return;
        }
        String stringExtra = this.mIntent.getStringExtra("group_id");
        String stringExtra2 = this.mIntent.getStringExtra("group_name");
        String stringExtra3 = this.mIntent.getStringExtra(CoeditNotificationConstants.EXTRA_GROUP_REQUESTR_NAME);
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra3)) {
            StringBuilder sbM16m = AbstractC0000a.m16m("[CS2-2] notifyGroupInvite# null : ", stringExtra, SQLKeyword.COMMA, stringExtra2, SQLKeyword.COMMA);
            sbM16m.append(stringExtra3);
            MainCoeditLogger.m7251e(TAG, sbM16m.toString());
        } else {
            MainCoeditLogger.m7253i(TAG, "[CS2] notifyGroupInvite# launch");
            CoeditInvitationMenuBadgeUpdater.setInvitationListHasBadgePref(stringExtra, true);
            this.mCoeditLaunchNotification.launchInvitationNotification(stringExtra, stringExtra2, stringExtra3);
        }
    }

    public void notifyInviteResult(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(CoeditNotificationConstants.COEDIT_INVITATION_ACTION_KEY);
        String stringExtra2 = intent.getStringExtra(CoeditNotificationConstants.COEDIT_INVITATION_ACTION_DATA_GROUP_ID);
        String stringExtra3 = intent.getStringExtra(CoeditNotificationConstants.COEDIT_INVITATION_ACTION_DATA_GROUP_NAME);
        if (TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra)) {
            MainCoeditLogger.m7251e(TAG, "notifyInviteResult# null error. groupId: " + stringExtra2 + ", isAccept: " + stringExtra);
            return;
        }
        new CoeditInviteResultAsyncTask(context, stringExtra2, stringExtra3, stringExtra).execute(new Void[0]);
        if (CoeditNotificationConstants.COEDIT_ACTION_OK.equals(stringExtra) || CoeditNotificationConstants.COEDIT_ACTION_CANCEL.equals(stringExtra)) {
            Intent intent2 = new Intent(CoeditNotificationConstants.COEDIT_NOTIFICATION_INTENT_FILTER);
            intent2.putExtra(CoeditInviteReceivedReceiver.COEDIT_NOTIFICATION_GROUP_ID, stringExtra2);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent2);
            MainCoeditLogger.m7253i(TAG, "notifyInviteResult# COEDIT_NOTIFICATION_INTENT_FILTER sendBroadcast");
            if (CoeditNotificationConstants.COEDIT_ACTION_OK.equals(stringExtra)) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_QUICK_PANEL, NotesSAConstants.EVENT_COEDIT_INVITE_JOIN_NOTIFICATION);
            } else {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_QUICK_PANEL, NotesSAConstants.EVENT_COEDIT_INVITE_DECLINE_NOTIFICATION);
            }
        }
    }

    public void notifyItemAdded() {
        final String stringExtra = this.mIntent.getStringExtra("group_id");
        final String stringExtra2 = this.mIntent.getStringExtra("space_id");
        final String stringExtra3 = this.mIntent.getStringExtra(CoeditNotificationConstants.EXTRA_SPACE_NAME);
        String stringExtra4 = this.mIntent.getStringExtra("item_id");
        final int intExtra = this.mIntent.getIntExtra("item_count", 0);
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra3) && !TextUtils.isEmpty(stringExtra4)) {
            new CoeditUserNameAsyncTask(this.mContext, stringExtra, stringExtra2, stringExtra4, new OwnerNameRunnable() { // from class: com.samsung.android.support.senl.nt.app.sync.ui.notification.CoeditNotificationHelper.1
                @Override // com.samsung.android.support.senl.nt.app.sync.ui.notification.CoeditNotificationHelper.OwnerNameRunnable, java.lang.Runnable
                public void run() {
                    CoeditNotificationHelper.this.mCoeditLaunchNotification.launchItemAddedNotification(stringExtra, stringExtra2, stringExtra3, getUserName(), intExtra);
                }
            }).execute(new Void[0]);
            return;
        }
        StringBuilder sbM16m = AbstractC0000a.m16m("[CS2-2] notifyItemAdded# Null : ", stringExtra, SQLKeyword.COMMA, stringExtra2, SQLKeyword.COMMA);
        sbM16m.append(stringExtra3);
        sbM16m.append(SQLKeyword.COMMA);
        sbM16m.append(stringExtra4);
        MainCoeditLogger.m7251e(TAG, sbM16m.toString());
    }

    public void notifyItemDeleted(String str, boolean z, String str2) {
        MainCoeditLogger.m7253i(TAG, "notifyItemDeleted#");
        String stringExtra = this.mIntent.getStringExtra("group_id");
        String stringExtra2 = this.mIntent.getStringExtra("group_name");
        String stringExtra3 = this.mIntent.getStringExtra("space_id");
        String stringExtra4 = this.mIntent.getStringExtra("item_id");
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra3) && !TextUtils.isEmpty(stringExtra4)) {
            this.mCoeditLaunchNotification.launchItemDeletedNotification(stringExtra, stringExtra2, stringExtra3, str, AbstractC0291i.m570g(stringExtra2) || z, str2);
            return;
        }
        StringBuilder sbM16m = AbstractC0000a.m16m("notifyItemDeleted# null : ", stringExtra, SQLKeyword.COMMA, stringExtra2, SQLKeyword.COMMA);
        sbM16m.append(stringExtra3);
        sbM16m.append(SQLKeyword.COMMA);
        sbM16m.append(stringExtra4);
        MainCoeditLogger.m7251e(TAG, sbM16m.toString());
    }

    public void notifyMemberDeleted() {
        String stringExtra = this.mIntent.getStringExtra("group_id");
        String stringExtra2 = this.mIntent.getStringExtra("group_name");
        String stringExtra3 = this.mIntent.getStringExtra(CoeditNotificationConstants.EXTRA_GROUP_REQUESTR_NAME);
        if (TextUtils.isEmpty(stringExtra3)) {
            stringExtra3 = this.mContext.getString(C8003R.string.co_edit_invitation_default_name);
        }
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra3)) {
            this.mCoeditLaunchNotification.launchMemberDeletedNotification(stringExtra, stringExtra2, stringExtra3);
            return;
        }
        MainCoeditLogger.m7251e(TAG, "notifyMemberDeleted# Null : " + stringExtra);
    }

    public void notifyStandaloneNoteDeletedWhenNotDownloaded() {
        MainCoeditLogger.m7253i(TAG, "notifyStandaloneNoteDeletedWhenNotDownloaded#");
        String stringExtra = this.mIntent.getStringExtra("group_id");
        String stringExtra2 = this.mIntent.getStringExtra("group_name");
        String stringExtra3 = this.mIntent.getStringExtra(CoeditNotificationConstants.EXTRA_GROUP_REQUESTR_NAME);
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            this.mCoeditLaunchNotification.launchItemDeletedNotification(stringExtra, stringExtra2, null, stringExtra2, true, stringExtra3);
            return;
        }
        MainCoeditLogger.m7251e(TAG, "notifyStandaloneNoteDeletedWhenNotDownloaded# null : " + stringExtra + SQLKeyword.COMMA + stringExtra2);
    }
}
