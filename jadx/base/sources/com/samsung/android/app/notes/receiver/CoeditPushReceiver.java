package com.samsung.android.app.notes.receiver;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.app.notes.sync.coedit.deletecore.CoeditDeleteLocalSharedSdocTask;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditGroupReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.util.HashUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification.CoeditNotificationConstants;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification.CoeditNotificationHelper;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification.CoeditNotificationManager;
import com.samsung.android.support.senl.p148nt.app.sync.receiver.CoeditGroupOwnerDelegationReceivedReceiver;
import com.samsung.android.support.senl.p148nt.app.sync.receiver.CoeditInviteReceivedReceiver;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.CoeditBaseConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.FTUConstants;
import com.samsung.android.support.senl.p148nt.base.common.livesharing.LiveSharingManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.ActivityManagerUtil;
import com.samsung.android.support.senl.p148nt.coedit.caller.CoeditNoteUpDownloader;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.DownloadResponse;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Event;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.EventManager;
import com.samsung.android.support.senl.p148nt.model.domain.coedit.DeleteCoeditNoteUseCase;
import java.util.ArrayList;
import p001A.AbstractC0000a;
import p024F.InterfaceC0085b;
import p042J1.C0145c;
import p044K.C0158a;
import p079T.AbstractC0291i;
import p079T.C0283a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CoeditPushReceiver extends BroadcastReceiver {
    private static final String TAG = "CoeditPushReceiver";
    private static final ArrayList<String> sDeleteNotifiedStandaloneGroupIdList = new ArrayList<>();

    private boolean checkMobileServiceStoragePermission(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_EXTERNAL_STORAGE", "com.samsung.android.mobileservice") == 0;
    }

    @Nullable
    private static String getAction(Context context, Intent intent) {
        if (context == null) {
            MainCoeditLogger.m7251e(TAG, "[CS2-2] onReceive context is null");
            return null;
        }
        if (intent == null) {
            MainCoeditLogger.m7251e(TAG, "[CS2-2] onReceive intent is null");
            return null;
        }
        String action = intent.getAction();
        if (action == null || action.isEmpty()) {
            MainCoeditLogger.m7251e(TAG, "[CS2-2] onReceive action is null");
            return null;
        }
        MainCoeditLogger.m7253i(TAG, "[CS2] onReceive start ( Action = " + action + " )");
        if (C0158a.m412j(context)) {
            return action;
        }
        return null;
    }

    private void handleAddItem(Intent intent, final CoeditNotificationHelper coeditNotificationHelper) {
        MainCoeditLogger.m7253i(TAG, "[CS2] handleAddItem#");
        if (!ActivityManagerUtil.isAppInBackground(BaseUtils.getApplicationContext()) || (checkMobileServiceStoragePermission(BaseUtils.getApplicationContext()) && !C0145c.m333r(BaseUtils.getApplicationContext()))) {
            CoeditNoteUpDownloader.getInstance().requestDownloadAddedNoteByPush(intent.getStringExtra("space_id"), intent.getStringExtra("item_id"), new DownloadResponse() { // from class: com.samsung.android.app.notes.receiver.CoeditPushReceiver.6
                @Override // com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.DownloadResponse
                public void onCompleted(String str, String str2, boolean z) {
                    CoeditNotificationHelper coeditNotificationHelper2;
                    if (z && (coeditNotificationHelper2 = coeditNotificationHelper) != null) {
                        if (ActivityManagerUtil.isAppInBackground(BaseUtils.getApplicationContext())) {
                            coeditNotificationHelper2.notifyItemAdded();
                        } else {
                            MainCoeditLogger.m7253i(CoeditPushReceiver.TAG, "[CS2-1] handleAddItem, ignore notifyItemAdded");
                        }
                    }
                }
            });
        } else {
            MainCoeditLogger.m7251e(TAG, "handleAddItem# app is background and mobileservice storage permission not granted or wifi only option applied");
            coeditNotificationHelper.notifyItemAdded();
        }
    }

    private void handleAddSpace(Intent intent) {
        final String stringExtra = intent.getStringExtra("space_id");
        CoeditGroupAndSpaceSyncAsyncTask.requestSync(intent.getStringExtra("group_id"), null, new Runnable() { // from class: com.samsung.android.app.notes.receiver.CoeditPushReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                boolean standAlone = SesCoeditShareReadResolver.getInstance().getStandAlone(stringExtra);
                MainCoeditLogger.m7250d(CoeditPushReceiver.TAG, "[CS2] handleAddSpace isStandaloneSpace " + standAlone);
                if (standAlone) {
                    Event event = new Event("COEDIT_ITEM_EVENT");
                    event.setEventData(stringExtra);
                    EventManager.getEventBus().publish(event);
                }
            }
        });
    }

    private void handleDelegationOwner(final Context context, Intent intent) {
        final String stringExtra = intent.getStringExtra("group_id");
        CoeditGroupAndSpaceSyncAsyncTask.requestSync(stringExtra, intent.getStringExtra("space_id"), new Runnable() { // from class: com.samsung.android.app.notes.receiver.CoeditPushReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                MainCoeditLogger.m7253i(CoeditPushReceiver.TAG, "handleDelegationOwner() sync finished");
                Intent intent2 = new Intent(CoeditGroupOwnerDelegationReceivedReceiver.GROUP_OWNER_DELEGATION_RECEIVED_INTENT_FILTER);
                intent2.putExtra(CoeditGroupOwnerDelegationReceivedReceiver.COEDIT_DELEGATION_GROUP_ID, stringExtra);
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent2);
            }
        });
    }

    private void handleDeleteItem(Intent intent, @NonNull final CoeditNotificationHelper coeditNotificationHelper, final boolean z) {
        MainCoeditLogger.m7253i(TAG, "handleDeleteItem#");
        String stringExtra = intent.getStringExtra("space_id");
        final String stringExtra2 = intent.getStringExtra("group_id");
        String stringExtra3 = intent.getStringExtra("item_id");
        int intExtra = intent.getIntExtra("item_count", 0);
        final String titleByItemId = coeditNotificationHelper.getTitleByItemId(stringExtra, stringExtra3);
        String leaderId = SesCoeditGroupReadResolver.getInstance().getLeaderId(stringExtra2);
        final String userName = !TextUtils.isEmpty(leaderId) ? SesCoeditGroupReadResolver.getInstance().getUserName(stringExtra2, leaderId) : null;
        final String docUuidByItemId = coeditNotificationHelper.getDocUuidByItemId(stringExtra, stringExtra3);
        if (TextUtils.isEmpty(docUuidByItemId)) {
            if (TextUtils.isEmpty(userName)) {
                return;
            }
            coeditNotificationHelper.notifyItemDeleted(titleByItemId, z, userName);
            sDeleteNotifiedStandaloneGroupIdList.add(stringExtra2);
            return;
        }
        CoeditNoteUpDownloader.getInstance().requestDeleteLocalNoteByPush(docUuidByItemId, new DeleteCoeditNoteUseCase.ResultCallback() { // from class: com.samsung.android.app.notes.receiver.a
            @Override // com.samsung.android.support.senl.nt.model.domain.coedit.DeleteCoeditNoteUseCase.ResultCallback
            public final void onResult(int i) {
                CoeditPushReceiver.lambda$handleDeleteItem$0(docUuidByItemId, userName, coeditNotificationHelper, titleByItemId, z, stringExtra2, i);
            }
        });
        if (intExtra <= 1 || C0145c.m333r(BaseUtils.getApplicationContext())) {
            return;
        }
        CoeditNoteUpDownloader.getInstance().requestDownloadByPush(stringExtra, null);
    }

    private void handleGroupAcceptInvite(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("group_id");
        if (TextUtils.isEmpty(stringExtra)) {
            MainCoeditLogger.m7251e(TAG, "handleGroupAcceptInvite# : null groupId");
            return;
        }
        MainCoeditLogger.m7253i(TAG, "handleGroupAcceptInvite# : groupId: " + stringExtra);
        Intent intent2 = new Intent();
        intent2.setAction(CoeditNotificationConstants.ACTION_DETAIL_REFRESH);
        intent2.setPackage("com.samsung.android.mobileservice");
        intent2.putExtra("group_id", stringExtra);
        context.sendBroadcast(intent2);
    }

    private void handleGroupIAcceptInvite(Context context, Intent intent) {
        final String stringExtra = intent.getStringExtra("group_id");
        if (TextUtils.isEmpty(stringExtra)) {
            MainCoeditLogger.m7251e(TAG, "handleGroupIAcceptInvite# : null groupId");
            return;
        }
        MainCoeditLogger.m7253i(TAG, "handleGroupIAcceptInvite# groupId: " + stringExtra);
        new CoeditNotificationManager(context).cancelCoeditNotification(stringExtra);
        CoeditGroupAndGroupMemberSyncRequestAsyncTask.requestSync(stringExtra, new Runnable() { // from class: com.samsung.android.app.notes.receiver.CoeditPushReceiver.4
            @Override // java.lang.Runnable
            public void run() {
                MainCoeditLogger.m7253i(CoeditPushReceiver.TAG, "requestCoeditInviteAcceptanceReceiver()");
                Event event = new Event("COEDIT_I_INVITE_EVENT");
                event.setEventData(stringExtra);
                EventManager.getEventBus().publish(event);
            }
        });
    }

    private void handleGroupInvite(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("group_id");
        if (TextUtils.isEmpty(stringExtra)) {
            MainCoeditLogger.m7251e(TAG, "[CS2-2] handleGroupAcceptInvite# : null groupId");
            return;
        }
        MainCoeditLogger.m7253i(TAG, "[CS2] handleGroupInvite# groupId: " + stringExtra);
        intent.setAction(CoeditInviteReceivedReceiver.GROUP_INVITATION_RECEIVED_INTENT_FILTER);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    private void handleGroupInviteCanceled(Context context, Intent intent) {
        new CoeditNotificationHelper(context, intent).cancelNotifyByInviteCanceled();
    }

    private void handleNotificationAction(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(CoeditNotificationConstants.COEDIT_INVITATION_ACTION_DATA_GROUP_ID);
        if (!TextUtils.isEmpty(stringExtra)) {
            new CoeditNotificationManager(context).closeSystemDialogIntent(stringExtra);
            return;
        }
        MainCoeditLogger.m7251e(TAG, "handleNotificationAction# null error. groupId: " + stringExtra);
    }

    private void handleSpaceDelete(Context context, Intent intent, boolean z) {
        String stringExtra = intent.getStringExtra("group_id");
        if (TextUtils.isEmpty(stringExtra)) {
            MainCoeditLogger.m7251e(TAG, "[CS8-2] handleSpaceDelete# : null groupId");
            return;
        }
        MainCoeditLogger.m7253i(TAG, "[CS8] handleSpaceDelete# groupId: " + stringExtra);
        handleSpaceDeleted(stringExtra, z);
        Intent intent2 = new Intent(CoeditBaseConstants.SPACE_DELTE_RECEIVED_INTENT_FILTER);
        intent2.putExtra(CoeditBaseConstants.COEDIT_DELETED_GROUP_ID, stringExtra);
        intent2.putExtra(CoeditBaseConstants.COEDIT_DELETED_GROUP_NAME, intent.getStringExtra("group_name"));
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent2);
        handleGroupInviteCanceled(context, intent);
    }

    private void handleSpaceDeleted(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            Debugger.m8607d(TAG, "[CS8-2] handleSpaceDeleted() : empty groupId");
            return;
        }
        AbstractC4539a.m3190D("[CS8] handleSpaceDeleted() : group id = ", str, TAG);
        CoeditDeleteLocalSharedSdocTask.DeleteType deleteType = CoeditDeleteLocalSharedSdocTask.DeleteType.GROUP;
        if (z) {
            deleteType = CoeditDeleteLocalSharedSdocTask.DeleteType.GROUP_LEAVE;
        }
        new CoeditDeleteLocalSharedSdocTask(deleteType, str, new InterfaceC0085b() { // from class: com.samsung.android.app.notes.receiver.CoeditPushReceiver.5
            @Override // p024F.InterfaceC0085b
            public void onDeleteLocalSharedSdocFinished() {
                MainCoeditLogger.m7253i(CoeditPushReceiver.TAG, "[CS8-1] deleteLocalSharedSdoc() : onDeleteLocalSharedSdocFinished()");
            }
        }).execute(new Void[0]);
    }

    private void handleSpaceLeave(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(CoeditNotificationConstants.EXTRA_GROUP_DELETED_MEMBER_ID);
        String strGenerateSha256 = HashUtils.generateSha256(stringExtra);
        if (!TextUtils.isEmpty(strGenerateSha256)) {
            C0283a.m562d().getClass();
            if (strGenerateSha256.equals(HashUtils.generateSha256(C0283a.m561c()))) {
                handleSpaceDelete(context, intent, false);
                return;
            }
        }
        MainCoeditLogger.m7253i(TAG, "handleSpaceLeave# deletedMemberId is wrong : " + stringExtra);
    }

    @SuppressLint({WarningType.NewApi})
    private void handleUpdateItem(Context context, Intent intent) {
        new CoeditItemUpdatePushAsyncTask(intent.getStringExtra("space_id"), intent.getStringExtra("item_id")).execute(new Void[0]);
    }

    private static void initialize(Context context, String str) {
        PostLaunchManager.getInstance().executeBaseLogic(301);
        PostLaunchManager.getInstance().executeBaseLogic(1);
        if (CoeditNotificationConstants.SES_ACTION_SERVICE_STATUS_CHANGED.equals(str)) {
            C0158a.f489i = false;
            C0158a.m409d(context);
            C6715o c6715oM4808q = C6715o.m4808q();
            c6715oM4808q.getClass();
            Debugger.m8607d("SesSession$SesSessionCoEdit", "[CS0] reconnect() : Start, callee = " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                c6715oM4808q.f4048j.mo4789e(c6715oM4808q.f4049k);
                Debugger.m8615i("SesSession$SesSessionCoEdit", "[CS0-1] reconnect() Finish, et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            } catch (Exception e) {
                AbstractC0000a.m21r(e, new StringBuilder("[CS0-2] reconnect() Fail, Exception = "), "SesSession$SesSessionCoEdit");
            }
        }
    }

    private boolean isCoeditUnableConditions(Intent intent, Context context, String str) {
        if (C0158a.m409d(context)) {
            return (isFeatureIdCoedit(intent) || CoeditNotificationConstants.COEDIT_NOTIFICATION_INTENT_FILTER.equals(str) || CoeditNotificationConstants.SES_ACTIVATED.equals(str)) ? false : true;
        }
        MainCoeditLogger.m7253i(TAG, "[CS2] onReceive# is not CoeditFeatureSupported");
        return true;
    }

    private boolean isFeatureIdCoedit(Intent intent) {
        return intent.getIntExtra("feature_id", 0) == 501;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleDeleteItem$0(String str, String str2, CoeditNotificationHelper coeditNotificationHelper, String str3, boolean z, String str4, int i) {
        MainCoeditLogger.m7250d(TAG, "handleDeleteItem# onResult, uuid: " + str + ", result: " + i);
        if (i != 300 || TextUtils.isEmpty(str2)) {
            return;
        }
        coeditNotificationHelper.notifyItemDeleted(str3, z, str2);
        sDeleteNotifiedStandaloneGroupIdList.add(str4);
    }

    private void requestGroupAndSpaceSync(Intent intent) {
        CoeditGroupAndSpaceSyncAsyncTask.requestSync(intent.getStringExtra("group_id"), intent.getStringExtra("space_id"), null);
    }

    private void requestGroupAndSpaceSyncAndNotify(Intent intent) {
        final String stringExtra = intent.getStringExtra("group_id");
        if (LiveSharingManager.getInstance().getIsInvitationLinkOpenRequested()) {
            return;
        }
        CoeditGroupAndSpaceSyncAsyncTask.requestSync(stringExtra, null, new Runnable() { // from class: com.samsung.android.app.notes.receiver.CoeditPushReceiver.3
            @Override // java.lang.Runnable
            public void run() {
                MainCoeditLogger.m7253i(CoeditPushReceiver.TAG, "requestCoeditInviteAcceptanceReceiver()");
                Event event = new Event("COEDIT_I_INVITE_EVENT");
                event.setEventData(stringExtra);
                EventManager.getEventBus().publish(event);
            }
        });
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        CoeditNotificationHelper coeditNotificationHelper;
        String action = getAction(context, intent);
        if (action == null) {
            return;
        }
        initialize(context, action);
        Context applicationContext = context.getApplicationContext();
        if (isCoeditUnableConditions(intent, applicationContext, action)) {
            return;
        }
        coeditNotificationHelper = new CoeditNotificationHelper(applicationContext, intent);
        switch (action) {
            case "com.samsung.android.mobileservice.social.ACTION_SHARE_ADD_ITEM_WITH_FEATURE_ID_PUSH":
                handleAddItem(intent, coeditNotificationHelper);
                break;
            case "com.samsung.android.mobileservice.social.ACTION_GROUP_I_ACCEPT_INVITE_WITH_FEATURE_ID_PUSH":
                handleGroupIAcceptInvite(context, intent);
                break;
            case "com.samsung.android.mobileservice.social.ACTION_GROUP_I_JOIN_GROUP_WITH_FEATURE_ID_PUSH":
                FTUConstants.isFirstTimeToCoeditJoin(true);
                requestGroupAndSpaceSyncAndNotify(intent);
                break;
            case "com.samsung.android.mobileservice.social.ACTION_SHARE_DELETE_ITEM_WITH_FEATURE_ID_PUSH":
                handleDeleteItem(intent, coeditNotificationHelper, SesCoeditShareReadResolver.getInstance().getStandAlone(intent.getStringExtra("space_id")));
                break;
            case "com.samsung.android.mobileservice.social.ACTION_SHARE_ADD_SPACE_WITH_FEATURE_ID_PUSH":
                handleAddSpace(intent);
                break;
            case "com.samsung.android.mobileservice.social.ACTION_GROUP_MEMBER_DELETE_WITH_FEATURE_ID_PUSH":
                handleSpaceLeave(applicationContext, intent);
                requestGroupAndSpaceSync(intent);
                break;
            case "com.samsung.android.mobileservice.social.ACTION_GROUP_I_MEMBER_DELETE_WITH_FEATURE_ID_PUSH":
                ComposerManager.getInstance().setCoeditMemberManagerLeaveResult(intent.getStringExtra("group_id"), true);
                handleSpaceDelete(applicationContext, intent, true);
                break;
            case "com.samsung.android.mobileservice.social.ACTION_GROUP_DELETE_WITH_FEATURE_ID_PUSH":
                String stringExtra = intent.getStringExtra("group_name");
                ArrayList<String> arrayList = sDeleteNotifiedStandaloneGroupIdList;
                if (arrayList.contains(intent.getStringExtra("group_id"))) {
                    arrayList.remove(intent.getStringExtra("group_id"));
                } else if (stringExtra != null) {
                    if (AbstractC0291i.m570g(stringExtra)) {
                        coeditNotificationHelper.notifyStandaloneNoteDeletedWhenNotDownloaded();
                    } else {
                        handleSpaceDelete(applicationContext, intent, false);
                        coeditNotificationHelper.notifyGroupDeleted();
                    }
                }
                requestGroupAndSpaceSync(intent);
                break;
            case "com.samsung.android.mobileservice.social.ACTION_SHARE_UPDATE_ITEM_WITH_FEATURE_ID_PUSH":
                handleUpdateItem(applicationContext, intent);
                break;
            case "com.samsung.android.mobileservice.social.ACTION_GROUP_REJECTED_INVITE_WITH_FEATURE_ID_PUSH":
            case "com.samsung.android.mobileservice.social.ACTION_GROUP_I_DELEGATE_AUTHORITY_WITH_FEATURE_ID_PUSH":
                requestGroupAndSpaceSync(intent);
                break;
            case "com.samsung.android.mobileservice.social.ACTION_GROUP_INVITATION_CANCELED_WITH_FEATURE_ID_PUSH":
                handleGroupInviteCanceled(applicationContext, intent);
                break;
            case "com.samsung.android.mobileservice.ACTION_ACTIVATED":
                if (!ActivityManagerUtil.isAppInBackground(BaseUtils.getApplicationContext())) {
                    requestGroupAndSpaceSync(intent);
                    break;
                }
                break;
            case "com.samsung.android.mobileservice.social.ACTION_GROUP_INVITE_WITH_FEATURE_ID_PUSH":
                coeditNotificationHelper.notifyGroupInvite();
                handleGroupInvite(applicationContext, intent);
                break;
            case "com.samsung.android.mobileservice.social.ACTION_GROUP_DELEGATE_AUTHORITY_WITH_FEATURE_ID_PUSH":
                coeditNotificationHelper.notifyGroupDelegateAuthorityOfOwner();
                requestGroupAndSpaceSync(intent);
                handleDelegationOwner(applicationContext, intent);
                break;
            case "com.samsung.android.mobileservice.social.ACTION_GROUP_FORCE_MEMBER_DELETE_WITH_FEATURE_ID_PUSH":
                handleSpaceLeave(applicationContext, intent);
                requestGroupAndSpaceSync(intent);
                coeditNotificationHelper.notifyMemberDeleted();
                break;
            case "com.samsung.android.app.notes.sync.ui.COEDIT_NOTIFICATION_INTENT_FILTER":
                coeditNotificationHelper.notifyInviteResult(context, intent);
                handleNotificationAction(context, intent);
                break;
            case "com.samsung.android.mobileservice.social.ACTION_SHARE_UPDATE_SPACE_WITH_FEATURE_ID_PUSH":
                String stringExtra2 = intent.getStringExtra("space_id");
                if (!ActivityManagerUtil.isAppInBackground(BaseUtils.getApplicationContext()) && !TextUtils.isEmpty(stringExtra2)) {
                    new CoeditSpaceInfoSyncAsyncTask(stringExtra2).execute(new Void[0]);
                    break;
                }
                break;
            case "com.samsung.android.mobileservice.social.ACTION_GROUP_ACCEPT_INVITE_WITH_FEATURE_ID_PUSH":
                handleGroupAcceptInvite(context, intent);
                requestGroupAndSpaceSync(intent);
                break;
            default:
                MainCoeditLogger.m7253i(TAG, "[CS2-2] onReceive# action is not handled!");
                break;
        }
    }
}
