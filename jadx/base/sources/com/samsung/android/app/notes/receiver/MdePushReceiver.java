package com.samsung.android.app.notes.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;
import com.samsung.android.app.notes.sync.contentsharing.deletecore.DeleteLocalSharedSdocTask;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.C6700n;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6716p;
import com.samsung.android.app.notes.sync.contentsharing.sessession.SesInviteReceivedReceiver;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.share.SharedItem;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.GcsInvitationMenuBadgeUpdater;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification.MdeNotificationHelper;
import com.samsung.android.support.senl.p148nt.app.sync.receiver.GcsSpaceDeleteReceivedReceiver;
import com.samsung.android.support.senl.p148nt.app.sync.receiver.GcsSpaceMemberUpdateReceivedReceiver;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import java.util.HashSet;
import p001A.AbstractC0000a;
import p042J1.C0145c;
import p044K.C0158a;
import p052M.C0171a;
import p056N.InterfaceC0179a;
import p075S.AbstractC0248O;
import p075S.AbstractC0272x;
import p079T.AbstractC0299q;
import p079T.C0283a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MdePushReceiver extends BroadcastReceiver {
    private static final String ACTION_DETAIL_REFRESH = "com.samsung.android.mobileservice.ACTION_DETAIL_REFRESH";
    private static final String KEY_GROUP_ACCEPTED_MEMBER_NAME = "group_accepted_member_name";
    private static final String KEY_GROUP_DELETED_MEMBER_ID = "group_deleted_member_id";
    private static final String KEY_GROUP_ID = "group_id";
    private static final String KEY_GROUP_MEMBER_NAME = "member_name";
    private static final String KEY_GROUP_NAME = "group_name";
    private static final String KEY_GROUP_REQUESTER_NAME = "group_requester_name";
    private static final String KEY_ITEM_ID = "item_id";
    private static final String KEY_PENDING_MEMBER = "pending_member";
    private static final String KEY_SPACE_ID = "space_id";
    private static final String KEY_SPACE_NAME = "space_name";
    private static final String SES_ADD_ITEM = "com.samsung.android.mobileservice.social.ACTION_SHARE_ADD_ITEM_PUSH";
    private static final String SES_DELETE_ITEM = "com.samsung.android.mobileservice.social.ACTION_SHARE_DELETE_ITEM_PUSH";
    private static final String SES_GROUP_ACCEPT_INVITE = "com.samsung.android.mobileservice.social.ACTION_GROUP_ACCEPT_INVITE_PUSH";
    private static final String SES_GROUP_DELETE_PUSH = "com.samsung.android.mobileservice.social.ACTION_GROUP_DELETE_PUSH";
    private static final String SES_GROUP_FORCE_MEMBER_DELETE = "com.samsung.android.mobileservice.social.ACTION_GROUP_FORCE_MEMBER_DELETE_PUSH";
    private static final String SES_GROUP_INVITE = "com.samsung.android.mobileservice.social.ACTION_GROUP_INVITE_PUSH";
    private static final String SES_GROUP_I_ACCEPT_INVITE = "com.samsung.android.mobileservice.social.ACTION_GROUP_I_ACCEPT_INVITE_PUSH";
    private static final String SES_GROUP_I_CREATE_GROUP = "com.samsung.android.mobileservice.social.ACTION_GROUP_I_CREATE_GROUP_PUSH";
    private static final String SES_GROUP_I_MEMBER_DELETE = "com.samsung.android.mobileservice.social.ACTION_GROUP_I_MEMBER_DELETE_PUSH";
    private static final String SES_GROUP_MEMBER_DELETE = "com.samsung.android.mobileservice.social.ACTION_GROUP_MEMBER_DELETE_PUSH";
    private static final String SES_MESSAGESHARE = "com.samsung.android.mobileservice.social.ACTION_MESSAGESHARE_PUSH";
    private static final String SES_SPACE_ADD = "com.samsung.android.mobileservice.social.ACTION_SHARE_ADD_SPACE_PUSH";
    private static final String SES_SPACE_DELETED = "com.samsung.android.mobileservice.social.ACTION_SHARE_DELETE_SPACE_PUSH";
    private static final String SES_UPDATE_ITEM = "com.samsung.android.mobileservice.social.ACTION_SHARE_UPDATE_ITEM_PUSH";
    private static final String TAG = "MdePushReceiver";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MdeAsyncTask extends AsyncTask<Void, Void, Void> {
        final String mAction;
        final Context mContext;
        final Intent mIntent;

        public MdeAsyncTask(String str, Context context, Intent intent) {
            this.mAction = str;
            this.mContext = context;
            this.mIntent = intent;
        }

        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) throws Exception {
            if (MdeNotificationHelper.MDE_NOTIFICATION_INTENT_FILTER.equals(this.mAction)) {
                String stringExtra = this.mIntent.getStringExtra(MdeNotificationHelper.MDE_INVITATION_ACTION_KEY);
                String stringExtra2 = this.mIntent.getStringExtra(MdeNotificationHelper.MDE_INVITATION_ACTION_DATA_GROUP_ID);
                if (stringExtra != null && stringExtra2 != null) {
                    MdeNotificationHelper.cancelMdeNotification(this.mContext, stringExtra2);
                    if (Build.VERSION.SDK_INT < 31) {
                        this.mContext.getApplicationContext().sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
                    } else {
                        Debugger.m8615i(MdePushReceiver.TAG, "onReceive ACTION_CLOSE_SYSTEM_DIALOGS not supported ");
                    }
                    try {
                        try {
                            try {
                                C6716p.m4809q().m4796c(3);
                                if (MdeNotificationHelper.MDE_ACTION_OK.equals(stringExtra)) {
                                    Debugger.m8607d(MdePushReceiver.TAG, "onReceive invite ok");
                                    BooleanResult booleanResultM553d = AbstractC0272x.m553d(stringExtra2);
                                    if (booleanResultM553d != null) {
                                        if (booleanResultM553d.getResult()) {
                                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.app.notes.receiver.MdePushReceiver.MdeAsyncTask.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    ToastHandler.show(MdeAsyncTask.this.mContext, C8003R.string.gcs_invitations_success_message, 1);
                                                }
                                            });
                                            GcsInvitationMenuBadgeUpdater.setInvitationListHasBadgePref(false);
                                        } else {
                                            int code = booleanResultM553d.getStatus().getCode();
                                            Debugger.m8607d(MdePushReceiver.TAG, "onReceive code : " + code);
                                            if (code == 115) {
                                                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.app.notes.receiver.MdePushReceiver.MdeAsyncTask.2
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        ToastHandler.show(MdeAsyncTask.this.mContext, C8003R.string.gcs_invitations_already_joined_message, 1);
                                                    }
                                                });
                                                GcsInvitationMenuBadgeUpdater.setInvitationListHasBadgePref(false);
                                            }
                                        }
                                    }
                                } else if (MdeNotificationHelper.MDE_ACTION_CANCEL.equals(stringExtra)) {
                                    AbstractC0272x.m555f(stringExtra2);
                                    Debugger.m8607d(MdePushReceiver.TAG, "onReceive invite bye");
                                    GcsInvitationMenuBadgeUpdater.setInvitationListHasBadgePref(false);
                                }
                                C6716p.m4809q().m4797d(3, null);
                                return null;
                            } catch (ShareException e) {
                                if (e.getExceptionCode() == ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION) {
                                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.app.notes.receiver.MdePushReceiver.MdeAsyncTask.3
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            ToastHandler.show(MdeAsyncTask.this.mContext, C8003R.string.sync_network_dialog_wifi_not_available_body, 1);
                                        }
                                    });
                                }
                                C6716p.m4809q().m4797d(3, null);
                                return null;
                            }
                        } catch (Exception e2) {
                            Debugger.m8607d(MdePushReceiver.TAG, "MdeAsyncTask : " + e2.toString() + ", MSG : " + e2.getMessage());
                            C6716p.m4809q().m4797d(3, null);
                            return null;
                        }
                    } catch (Throwable th) {
                        C6716p.m4809q().m4797d(3, null);
                        throw th;
                    }
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MdeItemOwnerNameRequestAsyncTask extends AsyncTask<Void, Void, String> {
        final Context mContext;
        final String mGroupId;
        final String mItemId;
        final int mItemNumber;
        final String mSpaceId;
        final String mSpaceName;

        public MdeItemOwnerNameRequestAsyncTask(Context context, String str, String str2, String str3, String str4, int i) {
            this.mContext = context;
            this.mItemId = str3;
            this.mSpaceId = str;
            this.mGroupId = str2;
            this.mSpaceName = str4;
            this.mItemNumber = i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
        
            if (r8 != null) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
        
            return r8;
         */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String doInBackground(Void... voidArr) {
            String strM4858p;
            try {
                try {
                    C6716p.m4809q().m4796c(3);
                    AbstractC0248O.m530d(this.mSpaceId);
                    SharedItem sharedItemByItemId = SesShareReadResolver.getInstance().getSharedItemByItemId(this.mContext, this.mSpaceId, this.mItemId);
                    if (sharedItemByItemId == null) {
                        Debugger.m8609e(MdePushReceiver.TAG, "doInBackground, no item!");
                    } else {
                        String leaderId = sharedItemByItemId.getLeaderId();
                        strM4858p = !TextUtils.isEmpty(leaderId) ? C6700n.m4785b().m4786a(this.mGroupId).m4858p(leaderId) : null;
                    }
                    return null;
                } catch (ShareException e) {
                    if (e.getExceptionCode() == ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION) {
                        strM4858p = "";
                    }
                    return null;
                } catch (Exception e2) {
                    Debugger.m8607d(MdePushReceiver.TAG, "doInBackground, e: " + e2.getMessage());
                    return null;
                }
            } finally {
                C6716p.m4809q().m4797d(3, null);
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (str != null) {
                MdePushReceiver.showItemAddedNotification(this.mContext, this.mSpaceId, this.mGroupId, this.mSpaceName, str, this.mItemNumber);
            }
        }
    }

    private void handleGroupAcceptInvite(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("group_id");
        if (stringExtra == null) {
            Debugger.m8607d(TAG, "handleGroupAcceptInvite() : null groupId");
            return;
        }
        Debugger.m8607d(TAG, "handleGroupAcceptInvite() : group id = ".concat(stringExtra));
        Intent intent2 = new Intent();
        intent2.setAction("com.samsung.android.mobileservice.ACTION_DETAIL_REFRESH");
        intent2.setPackage("com.samsung.android.mobileservice");
        intent2.putExtra("group_id", stringExtra);
        context.sendBroadcast(intent2);
    }

    private void handleGroupDelete(Intent intent) {
        String stringExtra = intent.getStringExtra("group_id");
        if (stringExtra == null) {
            Debugger.m8607d(TAG, "handleGroupDelete() : null groupId");
        } else {
            Debugger.m8607d(TAG, "handleGroupDelete() : group id = ".concat(stringExtra));
            new DeleteLocalSharedSdocTask(DeleteLocalSharedSdocTask.DeleteType.GROUP, stringExtra, new InterfaceC0179a() { // from class: com.samsung.android.app.notes.receiver.MdePushReceiver.2
                @Override // p056N.InterfaceC0179a
                public void onDeleteLocalSharedSdocFinished() {
                    Debugger.m8607d(MdePushReceiver.TAG, "onReceive DeleteLocalSharedSdocTask finish!");
                }
            }).execute(new Void[0]);
        }
    }

    private void handleGroupInvite(Context context, Intent intent) {
        Debugger.m8607d(TAG, "handleGroupInvite()");
        String stringExtra = intent.getStringExtra("group_id");
        String stringExtra2 = intent.getStringExtra("group_requester_name");
        String stringExtra3 = intent.getStringExtra("group_name");
        if (stringExtra == null) {
            Debugger.m8607d(TAG, "handleGroupInvite() null groupId");
            return;
        }
        showAcceptInviteNotification(context, stringExtra, stringExtra2, stringExtra3);
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(SesInviteReceivedReceiver.GROUP_INVITATION_RECEIVED_INTENT_FILTER));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleMemberDelete(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("group_id");
        String stringExtra2 = intent.getStringExtra("group_deleted_member_id");
        if (stringExtra == null && stringExtra2 == null) {
            Debugger.m8607d(TAG, "handleMemberDelete() null args");
            return;
        }
        Debugger.m8607d(TAG, "handleMemberDelete() : group id = " + stringExtra + ", member id : " + stringExtra2);
        if (stringExtra2 != null) {
            C0283a.m562d().getClass();
            if (stringExtra2.equals(C0283a.m561c())) {
                handleSpaceDelete(context, intent);
            }
        }
        new DeleteLocalSharedSdocTask(DeleteLocalSharedSdocTask.DeleteType.MEMBER, stringExtra, stringExtra2, new InterfaceC0179a() { // from class: com.samsung.android.app.notes.receiver.MdePushReceiver.3
            @Override // p056N.InterfaceC0179a
            public void onDeleteLocalSharedSdocFinished() {
                Debugger.m8607d(MdePushReceiver.TAG, "onReceive DeleteLocalSharedSdocTask finish!");
            }
        }).execute(new Void[0]);
    }

    private void handleSpaceDelete(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("group_id");
        if (TextUtils.isEmpty(stringExtra)) {
            Debugger.m8607d(TAG, "handleSpaceDelete() null args");
            return;
        }
        Debugger.m8607d(TAG, "handleSpaceDelete() : group id = " + stringExtra);
        Intent intent2 = new Intent(GcsSpaceDeleteReceivedReceiver.SPACE_DELTE_RECEIVED_INTENT_FILTER);
        intent2.putExtra(GcsSpaceDeleteReceivedReceiver.GCS_DELETED_GROUP_ID, stringExtra);
        intent2.putExtra(GcsSpaceDeleteReceivedReceiver.GCS_DELETED_GROUP_NAME, intent.getStringExtra("group_name"));
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent2);
    }

    private void handleSpaceDeleted(Intent intent) {
        String stringExtra = intent.getStringExtra("space_id");
        if (stringExtra == null) {
            Debugger.m8607d(TAG, "handleSpaceDeleted() : null spaceId");
        } else {
            Debugger.m8607d(TAG, "handleSpaceDeleted() : space id = ".concat(stringExtra));
            new DeleteLocalSharedSdocTask(DeleteLocalSharedSdocTask.DeleteType.SPACE, stringExtra, new InterfaceC0179a() { // from class: com.samsung.android.app.notes.receiver.MdePushReceiver.1
                @Override // p056N.InterfaceC0179a
                public void onDeleteLocalSharedSdocFinished() {
                    Debugger.m8607d(MdePushReceiver.TAG, "onReceive DeleteLocalSharedSdocTask finish!");
                }
            }).execute(new Void[0]);
        }
    }

    private void handleUpdateMemberCount(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("group_id");
        if (TextUtils.isEmpty(stringExtra)) {
            Debugger.m8607d(TAG, "handleUpdateMemberCount() null args");
            return;
        }
        Debugger.m8607d(TAG, "handleUpdateMemberCount() : group id = " + stringExtra);
        Intent intent2 = new Intent(GcsSpaceMemberUpdateReceivedReceiver.SPACE_MEMBER_UPDATED_RECEIVED_INTENT_FILTER);
        intent2.putExtra(GcsSpaceMemberUpdateReceivedReceiver.GCS_MEMBER_UPDATED_GROUP_ID, stringExtra);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent2);
    }

    private void notifyGroupDeleted(Context context, Intent intent) {
        showSpaceDeletedNotification(context, intent.getStringExtra("group_id"), intent.getStringExtra("group_name"));
    }

    private void notifyItemAdded(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("group_id");
        String stringExtra2 = intent.getStringExtra("space_name");
        String stringExtra3 = intent.getStringExtra("item_id");
        String stringExtra4 = intent.getStringExtra("space_id");
        int intExtra = intent.getIntExtra("item_count", 0);
        if (stringExtra != null && stringExtra2 != null && stringExtra3 != null && stringExtra4 != null) {
            new MdeItemOwnerNameRequestAsyncTask(context, stringExtra4, stringExtra, stringExtra3, stringExtra2, intExtra).execute(new Void[0]);
            return;
        }
        StringBuilder sbM16m = AbstractC0000a.m16m("notifyItemAdded() null ", stringExtra, " ", stringExtra4, " ");
        sbM16m.append(stringExtra2);
        sbM16m.append(" ");
        sbM16m.append(stringExtra3);
        Debugger.m8607d(TAG, sbM16m.toString());
    }

    private void notifyMemberJoined(Context context, Intent intent) {
        showMemberJoinNotification(context, intent.getStringExtra("group_id"), intent.getStringExtra(KEY_GROUP_ACCEPTED_MEMBER_NAME), intent.getStringExtra("group_name"));
    }

    private void notifyMemberLeft(Context context, Intent intent) {
        Debugger.m8607d(TAG, "notifyMemberLeft()");
        String stringExtra = intent.getStringExtra("group_id");
        String stringExtra2 = intent.getStringExtra(KEY_GROUP_MEMBER_NAME);
        String stringExtra3 = intent.getStringExtra("group_name");
        String stringExtra4 = intent.getStringExtra("group_deleted_member_id");
        if (stringExtra4 != null) {
            C0283a.m562d().getClass();
            if (stringExtra4.equals(C0283a.m561c())) {
                return;
            }
            showMemberLeftNotification(context, stringExtra, stringExtra2, stringExtra3);
        }
    }

    private void notifyMemberRemoved(Context context, Intent intent) {
        showMemberRemovedNotification(context, intent.getStringExtra("group_id"), intent.getStringExtra(KEY_GROUP_MEMBER_NAME), intent.getStringExtra("group_name"), intent.getStringExtra("group_deleted_member_id"));
    }

    private void notifySpaceDeleted(Context context, Intent intent) {
        showSpaceDeletedNotification(context, intent.getStringExtra("group_id"), intent.getStringExtra("space_name"));
    }

    private void requestShareNowFromReceiver(Context context) {
        if (!C6716p.m4809q().m4801j()) {
            AbstractC0299q.m618a0(context, Boolean.TRUE);
            return;
        }
        C0171a c0171aM429a = C0171a.m429a();
        c0171aM429a.getClass();
        if (C0145c.m333r(BaseUtils.getApplicationContext())) {
            return;
        }
        c0171aM429a.f543a.m4778b(null, false);
    }

    private void requestSync() {
        if (C6716p.m4809q().m4801j()) {
            try {
                if (C0145c.m333r(BaseUtils.getApplicationContext())) {
                    throw new ShareException(ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION, "requestSync failed - wifi only");
                }
                AbstractC0248O.m527a().requestSync(null);
            } catch (Exception e) {
                AbstractC0000a.m21r(e, new StringBuilder("requestSync Exception : "), TAG);
            }
        }
    }

    private boolean showAcceptInviteNotification(Context context, String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            StringBuilder sbM16m = AbstractC0000a.m16m("showAcceptInviteNotification Null ", str, " ", str2, " ");
            sbM16m.append(str3);
            Debugger.m8607d(TAG, sbM16m.toString());
        } else {
            GcsInvitationMenuBadgeUpdater.setInvitationListHasBadgePref(true);
            new MdeNotificationHelper(context).launchMdeInvitationNotification(str, str2, str3);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean showItemAddedNotification(Context context, String str, String str2, String str3, String str4, int i) {
        new MdeNotificationHelper(context).launchMdeItemAddedNotification(str, str2, str3, str4, i);
        return true;
    }

    private boolean showMemberJoinNotification(Context context, String str, String str2, String str3) {
        MdeNotificationHelper mdeNotificationHelper = new MdeNotificationHelper(context);
        if (str != null && str2 != null && str3 != null) {
            mdeNotificationHelper.launchMdeMemberJoinNotification(str, str2, str3);
            return true;
        }
        StringBuilder sbM16m = AbstractC0000a.m16m("showMemberJoinNotification Null ", str, " ", str2, " ");
        sbM16m.append(str3);
        Debugger.m8607d(TAG, sbM16m.toString());
        return true;
    }

    private boolean showMemberLeftNotification(Context context, String str, String str2, String str3) {
        MdeNotificationHelper mdeNotificationHelper = new MdeNotificationHelper(context);
        if (str != null && str2 != null && str3 != null) {
            mdeNotificationHelper.launchMdeMemberLeftNotification(str, str2, str3);
            return true;
        }
        StringBuilder sbM16m = AbstractC0000a.m16m("showMemberLeftNotification Null ", str, " ", str2, " ");
        sbM16m.append(str3);
        Debugger.m8607d(TAG, sbM16m.toString());
        return true;
    }

    private boolean showMemberRemovedNotification(Context context, String str, String str2, String str3, String str4) {
        if (str != null && str2 != null && str3 != null) {
            new MdeNotificationHelper(context).launchMdeMemberRemovedNotification(str, str2, str3, str4);
            return true;
        }
        StringBuilder sbM16m = AbstractC0000a.m16m("showMemberRemovedNotification Null ", str, " ", str2, " ");
        sbM16m.append(str3);
        Debugger.m8607d(TAG, sbM16m.toString());
        return true;
    }

    private boolean showSpaceDeletedNotification(Context context, String str, String str2) {
        if (str != null && str2 != null) {
            new MdeNotificationHelper(context).launchMdeSpaceDeletedNotification(str, str2);
            return true;
        }
        Debugger.m8607d(TAG, "showSpaceDeletedNotification Null " + str + " " + str2);
        return true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Exception {
        Debugger.m8607d(TAG, "onReceive");
        if (context == null) {
            Debugger.m8607d(TAG, "onReceive context is null");
            return;
        }
        if (intent == null) {
            Debugger.m8607d(TAG, "onReceive intent is null");
            return;
        }
        String action = intent.getAction();
        if (action == null || action.isEmpty()) {
            Debugger.m8607d(TAG, "onReceive action is null");
            return;
        }
        Debugger.m8607d(TAG, "onReceive start ( Action = " + action + " )");
        PostLaunchManager.getInstance().executeBaseLogic(301);
        PostLaunchManager.getInstance().executeBaseLogic(1);
        Context applicationContext = context.getApplicationContext();
        if (C0158a.m407a().m415h()) {
            switch (action) {
                case "com.samsung.android.mobileservice.social.ACTION_GROUP_I_MEMBER_DELETE_PUSH":
                case "com.samsung.android.mobileservice.social.ACTION_GROUP_MEMBER_DELETE_PUSH":
                    notifyMemberLeft(applicationContext, intent);
                    handleMemberDelete(applicationContext, intent);
                    handleUpdateMemberCount(applicationContext, intent);
                    requestSync();
                    break;
                case "com.samsung.android.app.notes.sync.ui.MDE_NOTIFICATION_ADDED_ITEM_OPENED_FROM_SES":
                    String stringExtra = intent.getStringExtra("spaceId");
                    String stringExtra2 = intent.getStringExtra("groupId");
                    if (stringExtra != null) {
                        MdeNotificationHelper.cancelMdeNotification(context, stringExtra);
                    }
                    Intent intent2 = new Intent(context, NoteListAccessHandler.getNoteListBaseActivityClass());
                    intent2.setAction(Constants.ACTION_START_SHARED_NOTES);
                    intent2.addFlags(268435456);
                    if (stringExtra != null && !stringExtra.isEmpty()) {
                        intent2.putExtra("spaceId", stringExtra);
                    }
                    if (stringExtra2 != null && !stringExtra2.isEmpty()) {
                        intent2.putExtra("groupId", stringExtra2);
                    }
                    context.startActivity(intent2);
                    break;
                case "com.samsung.android.mobileservice.social.ACTION_GROUP_ACCEPT_INVITE_PUSH":
                    notifyMemberJoined(context, intent);
                    handleGroupAcceptInvite(context, intent);
                    handleUpdateMemberCount(applicationContext, intent);
                    break;
                case "com.samsung.android.mobileservice.social.ACTION_SHARE_DELETE_ITEM_PUSH":
                case "com.samsung.android.mobileservice.social.ACTION_SHARE_UPDATE_ITEM_PUSH":
                    requestShareNowFromReceiver(applicationContext, intent, true);
                    break;
                case "com.samsung.android.mobileservice.social.ACTION_GROUP_FORCE_MEMBER_DELETE_PUSH":
                    notifyMemberRemoved(applicationContext, intent);
                    handleMemberDelete(applicationContext, intent);
                    handleUpdateMemberCount(applicationContext, intent);
                    requestSync();
                    break;
                case "com.samsung.android.mobileservice.social.ACTION_SHARE_DELETE_SPACE_PUSH":
                    notifySpaceDeleted(applicationContext, intent);
                    handleSpaceDeleted(intent);
                    break;
                case "com.samsung.android.mobileservice.social.ACTION_SHARE_ADD_ITEM_PUSH":
                    notifyItemAdded(applicationContext, intent);
                    requestShareNowFromReceiver(applicationContext, intent, true);
                    break;
                case "com.samsung.android.mobileservice.social.ACTION_GROUP_INVITE_PUSH":
                    handleGroupInvite(applicationContext, intent);
                    break;
                case "com.samsung.android.mobileservice.social.ACTION_GROUP_I_CREATE_GROUP_PUSH":
                    Debugger.m8607d(TAG, "SES_GROUP_I_CREATE_GROUP");
                    break;
                case "com.samsung.android.mobileservice.social.ACTION_MESSAGESHARE_PUSH":
                    Debugger.m8607d(TAG, "SES_MESSAGESHARE");
                    break;
                case "com.samsung.android.app.notes.sync.ui.MDE_NOTIFICATION_INTENT_FILTER":
                    new MdeAsyncTask(action, context, intent).execute(new Void[0]);
                    break;
                case "com.samsung.android.mobileservice.social.ACTION_GROUP_DELETE_PUSH":
                    if (!intent.getBooleanExtra(KEY_PENDING_MEMBER, false)) {
                        notifyGroupDeleted(applicationContext, intent);
                        handleSpaceDelete(applicationContext, intent);
                        handleGroupDelete(intent);
                        break;
                    } else {
                        Debugger.m8607d(TAG, "I am a pending member. Do nothing.");
                        break;
                    }
                    break;
                case "com.samsung.android.mobileservice.social.ACTION_SHARE_ADD_SPACE_PUSH":
                    requestShareNowFromReceiver(applicationContext, intent, false);
                    break;
                case "com.samsung.android.mobileservice.social.ACTION_GROUP_I_ACCEPT_INVITE_PUSH":
                    if (intent.hasExtra("group_id")) {
                        String stringExtra3 = intent.getStringExtra("group_id");
                        MdeNotificationHelper.cancelMdeNotification(context, stringExtra3);
                        new MdeGroupSyncRequestAsyncTask(stringExtra3).execute(new Void[0]);
                    }
                    requestShareNowFromReceiver(applicationContext);
                    break;
                default:
                    Debugger.m8607d(TAG, "Not supported!");
                    break;
            }
        }
        Debugger.m8607d(TAG, "onReceive finish ( Action = " + action + " )");
    }

    private void requestShareNowFromReceiver(Context context, Intent intent, boolean z) {
        String stringExtra = intent.getStringExtra("space_id");
        String stringExtra2 = intent.getStringExtra("item_id");
        if (stringExtra == null) {
            Debugger.m8607d(TAG, "requestShareNowFromReceiver() null spaceId");
            return;
        }
        Debugger.m8607d(TAG, "requestShareNowFromReceiver() : space id = ".concat(stringExtra));
        if (stringExtra2 != null) {
            synchronized (AbstractC0299q.class) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("SesSkipItemManagerPref", 0);
                if (sharedPreferences != null && sharedPreferences.contains("SesSkipItemManagerPref_Key_FileNames")) {
                    HashSet hashSet = new HashSet(sharedPreferences.getStringSet("SesSkipItemManagerPref_Key_FileNames", new HashSet()));
                    hashSet.remove(stringExtra.concat(stringExtra2));
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    if (editorEdit != null) {
                        editorEdit.putStringSet("SesSkipItemManagerPref_Key_FileNames", hashSet);
                        editorEdit.apply();
                    }
                }
            }
        }
        if (z) {
            C0171a.m429a().m433e(stringExtra, false);
        } else if (!C6716p.m4809q().m4801j()) {
            AbstractC0299q.m618a0(context, Boolean.TRUE);
        } else {
            C0171a.m429a().m433e(stringExtra, false);
        }
    }
}
