package com.samsung.android.support.senl.p148nt.app.main.common.coedit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.deletecore.CoeditDeleteLocalSharedSdocTask;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditGroupReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6716p;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.group.GroupApi;
import com.samsung.android.sdk.mobileservice.social.group.InvitationLink;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationListResult;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationResult;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupMemberResult;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupResult;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.Space;
import com.samsung.android.sdk.mobileservice.social.share.SyncOption;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceListResult;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceResult;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.sdk.mobileservice.social.social.SocialPickerRequest;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback;
import com.samsung.android.support.senl.p148nt.app.common.dialog.AppUpdateDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.updater.BaseUpdater;
import com.samsung.android.support.senl.p148nt.app.common.updater.CoeditUpdater;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.DataTask;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.presenter.GcsGroupNetworkUtils;
import com.samsung.android.support.senl.p148nt.app.updater.UpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SesUiListener;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.stt.common.constant.DialogConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import p001A.AbstractC0000a;
import p024F.InterfaceC0085b;
import p044K.C0158a;
import p075S.AbstractC0248O;
import p075S.AbstractC0254f;
import p075S.AbstractC0267s;
import p075S.C0261m;
import p079T.AbstractC0291i;
import p079T.AbstractC0294l;
import p207n1.C13540g;
import p207n1.C13541h;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditSessionConnectorImpl implements CoeditSessionConnector {
    private static final String TAG = "CoeditSessionConnectorImpl";
    private final String CALLER_TAG;
    private final CoeditSessionConnector.ActivityContract mActivityContract;
    private final Context mContext;
    private CoeditPickerInfo mPickerInfo;
    private CoeditSessionConnector.ActionResult mSpaceDeleteCallback;
    private boolean mIsRequestSocialSignUp = false;
    private final SesUiAllListener mSesUiAllListener = new SesUiAllListener(this, 0);

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl$17 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RunnableC817917 implements Runnable {
        final /* synthetic */ CoeditSessionConnector.CoeditCreateResult val$callback;
        final /* synthetic */ String val$groupId;
        final /* synthetic */ boolean val$isStandalone;

        public RunnableC817917(String str, CoeditSessionConnector.CoeditCreateResult coeditCreateResult, boolean z) {
            this.val$groupId = str;
            this.val$callback = coeditCreateResult;
            this.val$isStandalone = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AbstractC0267s.m543a().requestSpaceList(this.val$groupId, new ShareApi.SpaceListResultCallback() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.17.1
                    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.SpaceListResultCallback
                    public void onResult(final SpaceListResult spaceListResult) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.17.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                List<Space> result = spaceListResult.getResult();
                                if (result == null || result.isEmpty()) {
                                    CoeditSessionConnector.CoeditCreateResult coeditCreateResult = RunnableC817917.this.val$callback;
                                    if (coeditCreateResult != null) {
                                        coeditCreateResult.onFail();
                                        return;
                                    }
                                    return;
                                }
                                RunnableC817917 runnableC817917 = RunnableC817917.this;
                                CoeditSessionConnector.CoeditCreateResult coeditCreateResult2 = runnableC817917.val$callback;
                                if (coeditCreateResult2 != null) {
                                    coeditCreateResult2.onSuccess(runnableC817917.val$groupId, result.get(0).getSpaceId(), RunnableC817917.this.val$isStandalone);
                                }
                            }
                        });
                    }
                });
            } catch (Exception e) {
                MainCoeditLogger.m7251e(CoeditSessionConnectorImpl.this.CALLER_TAG, "" + e.getMessage());
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.17.2
                    @Override // java.lang.Runnable
                    public void run() {
                        CoeditSessionConnector.CoeditCreateResult coeditCreateResult = RunnableC817917.this.val$callback;
                        if (coeditCreateResult != null) {
                            coeditCreateResult.onFail();
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C81875 implements WorkerTask.Callback {
        final /* synthetic */ Intent[] val$intent;
        final /* synthetic */ CoeditPickerInfo val$pickerInfo;

        public C81875(Intent[] intentArr, CoeditPickerInfo coeditPickerInfo) {
            this.val$intent = intentArr;
            this.val$pickerInfo = coeditPickerInfo;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
        public void onEnd(@NonNull WorkerTask.Result result) {
            ViewModeUtils.runOnUiThread(CoeditSessionConnectorImpl.this.mActivityContract.getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.5.1
                @Override // java.lang.Runnable
                public void run() {
                    C81875 c81875 = C81875.this;
                    if (c81875.val$intent[0] == null) {
                        return;
                    }
                    MainCoeditLogger.m7250d(CoeditSessionConnectorImpl.this.CALLER_TAG, "launchSocialPicker# IsStandalone : " + C81875.this.val$pickerInfo.isStandalone());
                    CoeditSessionConnectorImpl.this.mActivityContract.launchActivity(C81875.this.val$intent[0], new NotesActivityResultCallback() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.5.1.1
                        @Override // com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback
                        public void onActivityResult(int i, @Nullable Intent intent) {
                            MainCoeditLogger.m7250d(CoeditSessionConnectorImpl.this.CALLER_TAG, "launchSocialPicker# resultCode: " + i);
                            if (i == 55) {
                                CoeditSessionConnectorImpl coeditSessionConnectorImpl = CoeditSessionConnectorImpl.this;
                                coeditSessionConnectorImpl.requestSpaceCreateWithLink(coeditSessionConnectorImpl.mPickerInfo);
                            } else {
                                if (i != -1 || intent == null) {
                                    CoeditSessionConnectorImpl.this.mPickerInfo.onFail();
                                    return;
                                }
                                HashMap mapM577d = AbstractC0294l.m577d(intent.getStringExtra("jsonResult"));
                                if (mapM577d != null) {
                                    CoeditSessionConnectorImpl.this.requestSpaceCreate((ArrayList) mapM577d.get(DialogConstant.BUNDLE_IDS), (ArrayList) mapM577d.get("optIds"));
                                }
                            }
                        }
                    });
                }
            });
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
        public void onStart(@NonNull WorkerTask<?> workerTask) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class GroupInvitationListCallback implements GroupApi.GroupResultCallback<GroupInvitationListResult> {
        private final WeakReference<CoeditSessionConnector.InvitationResult> mCallback;
        private final WeakReference<CoeditSessionConnectorImpl> mConnectorWeakReference;

        public GroupInvitationListCallback(CoeditSessionConnectorImpl coeditSessionConnectorImpl, CoeditSessionConnector.InvitationResult invitationResult) {
            this.mConnectorWeakReference = new WeakReference<>(coeditSessionConnectorImpl);
            this.mCallback = new WeakReference<>(invitationResult);
        }

        public static String substringUntilParen(String str, String str2) {
            if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
                return "";
            }
            int iIndexOf = str.indexOf(40, str2.length() + 1);
            return iIndexOf == -1 ? str : str.substring(0, iIndexOf);
        }

        @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
        public void onResult(GroupInvitationListResult groupInvitationListResult) {
            boolean z;
            CoeditSessionConnectorImpl coeditSessionConnectorImpl = this.mConnectorWeakReference.get();
            if (coeditSessionConnectorImpl != null) {
                MainCoeditLogger.m7253i(coeditSessionConnectorImpl.CALLER_TAG, "requestInvitationList() setInvitationList.");
                final ArrayList arrayList = new ArrayList();
                List<GroupInvitationListResult.GroupInvitation> invitationList = groupInvitationListResult.getInvitationList();
                if (invitationList != null) {
                    for (GroupInvitationListResult.GroupInvitation groupInvitation : invitationList) {
                        String groupId = groupInvitation.getGroupId();
                        HashMap map = AbstractC0291i.f755d;
                        Long l = (Long) map.get(groupId);
                        if (l == null) {
                            z = false;
                        } else if (System.currentTimeMillis() - l.longValue() < 30000) {
                            z = true;
                        } else {
                            map.remove(groupId);
                            z = false;
                        }
                        if (groupId != null && groupId.startsWith("UNM") && !z) {
                            if (groupInvitation.getGroupName() == null || !AbstractC0291i.m570g(groupInvitation.getGroupName())) {
                                arrayList.add(groupInvitation);
                            } else {
                                String groupName = groupInvitation.getGroupName();
                                int i = 0;
                                for (int i2 = 0; i2 < invitationList.size(); i2++) {
                                    if (invitationList.get(i2).getRequesterId().equals(groupInvitation.getRequesterId()) && invitationList.get(i2).getGroupName() != null && groupName.equals(substringUntilParen(invitationList.get(i2).getGroupName(), groupName))) {
                                        i++;
                                        if (invitationList.get(i2).equals(groupInvitation)) {
                                            break;
                                        }
                                    }
                                }
                                if (i > 1) {
                                    StringBuilder sbM781w = AbstractC0541b.m781w(groupName, " (");
                                    sbM781w.append(i - 1);
                                    sbM781w.append(")");
                                    groupName = sbM781w.toString();
                                }
                                arrayList.add(new GroupInvitationListResult.GroupInvitation(groupInvitation.getGroupId(), groupName, groupInvitation.getMessage(), groupInvitation.getRequesterId(), groupInvitation.getRequesterName(), groupInvitation.getRequesterImageUrl(), groupInvitation.getRequesterImageFileUri(), groupInvitation.getRequesterImageContentUri(), groupInvitation.getRequestedTime(), groupInvitation.getExpiredTime()));
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.GroupInvitationListCallback.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GroupInvitationListCallback.this.mCallback.get() != null) {
                                ((CoeditSessionConnector.InvitationResult) GroupInvitationListCallback.this.mCallback.get()).onResult(arrayList);
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GroupSyncResultCallback implements GroupApi.GroupSyncResultCallback {
        private static GroupSyncResultCallback mInstance;
        private CoeditSessionConnector.ActionResult mActionResult;

        private GroupSyncResultCallback() {
        }

        public static synchronized GroupSyncResultCallback getInstance() {
            try {
                if (mInstance == null) {
                    mInstance = new GroupSyncResultCallback();
                }
            } catch (Throwable th) {
                throw th;
            }
            return mInstance;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupSyncResultCallback
        public void onResult(BooleanResult booleanResult) {
            CoeditSessionConnector.ActionResult actionResult;
            if (booleanResult == null) {
                MainCoeditLogger.m7251e(CoeditSessionConnectorImpl.TAG, "GroupSyncResultCallback# onResult : actionResult is null!");
                return;
            }
            boolean result = booleanResult.getResult();
            MainCoeditLogger.m7250d(CoeditSessionConnectorImpl.TAG, "GroupSyncResultCallback# onResult : " + result);
            if (!result || (actionResult = this.mActionResult) == null) {
                return;
            }
            try {
                actionResult.onSuccess();
            } catch (Exception e) {
                MainCoeditLogger.m7251e(CoeditSessionConnectorImpl.TAG, "GroupSyncResultCallback# onResult : " + e.toString());
            }
            this.mActionResult = null;
        }

        public void setActionResult(CoeditSessionConnector.ActionResult actionResult) {
            this.mActionResult = actionResult;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MemberResultCallback implements GroupApi.GroupResultCallback<GroupMemberResult> {
        private static MemberResultCallback mInstance;

        private MemberResultCallback() {
        }

        public static synchronized MemberResultCallback getInstance() {
            try {
                if (mInstance == null) {
                    mInstance = new MemberResultCallback();
                }
            } catch (Throwable th) {
                throw th;
            }
            return mInstance;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
        public void onResult(GroupMemberResult groupMemberResult) {
            MainCoeditLogger.m7250d(CoeditSessionConnectorImpl.TAG, "MemberResultCallback# onResult : " + groupMemberResult.getStatus().getCode());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SesOldUiAllListener implements SesUiListener {
        public /* synthetic */ SesOldUiAllListener(CoeditSessionConnectorImpl coeditSessionConnectorImpl, int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.SesUiListener
        public void onConnected() {
            MainCoeditLogger.m7253i(CoeditSessionConnectorImpl.this.CALLER_TAG, "[CS0] SesOldUiAllListener# onConnected#");
            try {
                try {
                    AbstractC0248O.m534h(ShareSyncResultCallback.getInstance());
                } catch (Exception e) {
                    MainCoeditLogger.m7251e(CoeditSessionConnectorImpl.this.CALLER_TAG, "[CS1-2] requestOldSharedNotebooks Exception : " + e.getMessage());
                }
            } finally {
                C6716p.m4809q().m4797d(1, this);
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.SesUiListener
        public void onDisConnected(int i) {
        }

        private SesOldUiAllListener() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SesUiAllListener implements SesUiListener {
        public /* synthetic */ SesUiAllListener(CoeditSessionConnectorImpl coeditSessionConnectorImpl, int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.SesUiListener
        public void onConnected() {
            if (CoeditSessionConnectorImpl.this.mActivityContract == null) {
                return;
            }
            if (!GcsGroupNetworkUtils.checkCoeditNetworkConnection(CoeditSessionConnectorImpl.this.mActivityContract.getActivity(), GcsConstants.RequestType.Member, false)) {
                MainCoeditLogger.m7253i(CoeditSessionConnectorImpl.this.CALLER_TAG, "SesUiAllListener#onConnected# wifi only");
                CoeditSessionConnectorImpl.this.mActivityContract.onSessionConnected(false);
            } else {
                MainCoeditLogger.m7253i(CoeditSessionConnectorImpl.this.CALLER_TAG, "SesUiAllListener#onConnected#");
                if (CoeditSessionConnectorImpl.this.checkReadyToUseSharedService()) {
                    CoeditSessionConnectorImpl.this.mActivityContract.onSessionConnected(true);
                }
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.SesUiListener
        public void onDisConnected(int i) {
            if (i == SeMobileServiceSession.ConnectionResultCallback.CAUSE_AGENT_NOT_INSTALLED) {
                MainCoeditLogger.m7251e(CoeditSessionConnectorImpl.this.CALLER_TAG, "onDisConnected# Agent is not installed properly.");
                return;
            }
            if (i == SeMobileServiceSession.ConnectionResultCallback.CAUSE_AGENT_FORCE_UPDATE_REQUIRED) {
                MainCoeditLogger.m7251e(CoeditSessionConnectorImpl.this.CALLER_TAG, "onDisConnected# Force update required.");
                return;
            }
            MainCoeditLogger.m7251e(CoeditSessionConnectorImpl.this.CALLER_TAG, "onDisConnected# reason code : " + i);
        }

        private SesUiAllListener() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ShareSyncResultCallback implements ShareApi.ShareSyncResultCallback {
        private static ShareSyncResultCallback mInstance;
        private CoeditSessionConnector.ActionResult mCallback;

        private ShareSyncResultCallback() {
        }

        public static synchronized ShareSyncResultCallback getInstance() {
            try {
                if (mInstance == null) {
                    mInstance = new ShareSyncResultCallback();
                }
            } catch (Throwable th) {
                throw th;
            }
            return mInstance;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ShareSyncResultCallback
        public void onResult(BooleanResult booleanResult) {
            MainCoeditLogger.m7250d(CoeditSessionConnectorImpl.TAG, "ShareSyncResultCallback# onResult : " + booleanResult.getResult());
            if (this.mCallback == null || !booleanResult.getResult()) {
                return;
            }
            this.mCallback.onSuccess();
            this.mCallback = null;
        }

        public void setActionResult(CoeditSessionConnector.ActionResult actionResult) {
            this.mCallback = actionResult;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SpaceResultCallback implements ShareApi.SpaceResultCallback {
        private static SpaceResultCallback mInstance;

        private SpaceResultCallback() {
        }

        public static synchronized SpaceResultCallback getInstance() {
            try {
                if (mInstance == null) {
                    mInstance = new SpaceResultCallback();
                }
            } catch (Throwable th) {
                throw th;
            }
            return mInstance;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.SpaceResultCallback
        public void onResult(SpaceResult spaceResult) {
            MainCoeditLogger.m7250d(CoeditSessionConnectorImpl.TAG, "SpaceResultCallback# onResult : " + spaceResult.getStatus().getCode());
        }
    }

    public CoeditSessionConnectorImpl(Context context, String str, CoeditSessionConnector.ActivityContract activityContract) {
        this.CALLER_TAG = str;
        this.mContext = context;
        this.mActivityContract = activityContract;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkReadyToUseSharedService() {
        try {
            if (AbstractC14517a.m15159s().isAgreementProcedureNeeded(0)) {
                MainCoeditLogger.m7253i(this.CALLER_TAG, "checkReadyToUseSharedService# false - start social sign up.");
                if (!((C13540g) C13541h.m14287e().f9588a).m14285a()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ToastHandler.show(CoeditSessionConnectorImpl.this.mContext, CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.need_login_first_jpn : C8003R.string.need_login_first, 1);
                        }
                    });
                }
                Intent intentForAgreementProcedure = AbstractC14517a.m15159s().getIntentForAgreementProcedure(0);
                if (!this.mIsRequestSocialSignUp) {
                    this.mIsRequestSocialSignUp = true;
                    this.mActivityContract.launchActivity(intentForAgreementProcedure, new NotesActivityResultCallback() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.2
                        @Override // com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback
                        public void onActivityResult(int i, @Nullable Intent intent) {
                            CoeditSessionConnectorImpl.this.mIsRequestSocialSignUp = false;
                            if (i != -1) {
                                MainCoeditLogger.m7253i(CoeditSessionConnectorImpl.this.CALLER_TAG, "onActivityResult# Social sign up fail");
                                CoeditSessionConnectorImpl.this.mActivityContract.finishActivity();
                            } else if (!CoeditSessionConnectorImpl.this.checkReadyToUseSharedService()) {
                                CoeditSessionConnectorImpl.this.mActivityContract.finishActivity();
                            } else {
                                CoeditSessionConnectorImpl.this.requestSync();
                                CoeditSessionConnectorImpl.this.mActivityContract.onSessionConnected(GcsGroupNetworkUtils.checkCoeditNetworkConnection(CoeditSessionConnectorImpl.this.mActivityContract.getActivity(), GcsConstants.RequestType.None, false));
                            }
                        }
                    });
                }
                return false;
            }
        } catch (Exception e) {
            MainCoeditLogger.m7251e(this.CALLER_TAG, "checkReadyToUseSharedService# Exception : " + e.toString());
        }
        if (!CoeditUpdater.getInstance().checkForceUpdateSESAgentVersion(this.mContext)) {
            MainCoeditLogger.m7253i(this.CALLER_TAG, "checkReadyToUseSharedService# true.");
            return true;
        }
        MainCoeditLogger.m7253i(this.CALLER_TAG, "checkReadyToUseSharedService# false - need to update SES.");
        showSESAgentUpdateDialog(new NotesActivityResultCallback() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.3
            @Override // com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback
            public void onActivityResult(int i, @Nullable Intent intent) {
                if (i == 0) {
                    MainCoeditLogger.m7253i(CoeditSessionConnectorImpl.this.CALLER_TAG, "REQUEST_INTENT_SES_FORCE_UPDATE result canceled");
                    CoeditSessionConnectorImpl.this.mActivityContract.finishActivity();
                }
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSessionConnection(GcsConstants.RequestType requestType, boolean z) {
        return GcsGroupNetworkUtils.checkCoeditSessionConnection(this.mActivityContract.getActivity(), requestType, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable createRequestSpaceListRunnable(String str, boolean z, CoeditSessionConnector.CoeditCreateResult coeditCreateResult) {
        return new RunnableC817917(str, coeditCreateResult, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean createSharedNotebooks(final String str) {
        if (TextUtils.isEmpty(str)) {
            MainCoeditLogger.m7251e(this.CALLER_TAG, "[C3-2] createSharedNotebooks# groupId is null or empty.");
            return false;
        }
        if (TextUtils.isEmpty(this.mPickerInfo.getSpaceName())) {
            MainCoeditLogger.m7251e(this.CALLER_TAG, "[C3-2] createSharedNotebooks# space name is null or empty.");
            return false;
        }
        MainCoeditLogger.m7253i(this.CALLER_TAG, "[C3] createSharedNotebooks#");
        try {
            if (!checkSessionConnection(GcsConstants.RequestType.Create, this.mPickerInfo.isStandalone())) {
                return false;
            }
            ShareApi.SpaceWithUriRequest spaceWithUriRequest = new ShareApi.SpaceWithUriRequest(this.mPickerInfo.getSpaceName());
            spaceWithUriRequest.setStandAlone(this.mPickerInfo.isStandalone());
            AbstractC0267s.m543a().requestSpaceCreation(str, spaceWithUriRequest, new ShareApi.SpaceResultCallback() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.8
                @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.SpaceResultCallback
                public void onResult(SpaceResult spaceResult) {
                    if (spaceResult.getStatus().getCode() != 1) {
                        MainCoeditLogger.m7251e(CoeditSessionConnectorImpl.this.CALLER_TAG, "[CS3-2] createSharedNotebooks#, fail to requestSpaceCreation#");
                        GcsGroupNetworkUtils.showUnknownFailToast(CoeditSessionConnectorImpl.this.mContext, GcsConstants.RequestType.Create, CoeditSessionConnectorImpl.this.mPickerInfo.isStandalone(), spaceResult.getStatus().getCode());
                        CoeditSessionConnectorImpl.this.mPickerInfo.onFail();
                        return;
                    }
                    String spaceId = spaceResult.getResult().getSpaceId();
                    MainCoeditLogger.m7253i(CoeditSessionConnectorImpl.this.CALLER_TAG, "[CS3-1] createSharedNotebooks#, succeed to requestSpaceCreation#, groupId = " + str + ", spaceId = " + spaceId);
                    CoeditSessionConnectorImpl.this.mPickerInfo.onSuccess(str, spaceResult.getResult().getSpaceId());
                }
            });
            return true;
        } catch (Exception e) {
            AbstractC4539a.m3204n(e, new StringBuilder("[C3-2] createSharedNotebooks#, fail to requestSpaceCreation# Exception : "), this.CALLER_TAG);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteLocalDocInternal(BooleanResult booleanResult, final String str, final String str2, boolean z, String str3, GcsConstants.RequestType requestType) {
        CoeditSessionConnectorImpl coeditSessionConnectorImpl;
        final boolean z2;
        final GcsConstants.RequestType requestType2;
        String str4 = this.CALLER_TAG;
        StringBuilder sbM12325j = AbstractC11014a.m12325j("[CS8] deleteLocalDocInternal(). ", str3);
        sbM12325j.append(booleanResult.getResult());
        MainCoeditLogger.m7253i(str4, sbM12325j.toString());
        if (booleanResult.getResult()) {
            deleteLocalSharedSdoc(str, str2, requestType);
            return;
        }
        try {
            MainCoeditLogger.m7253i(this.CALLER_TAG, "[CS8] deleteLocalDocInternal() : requestGroup()");
            coeditSessionConnectorImpl = this;
            z2 = z;
            requestType2 = requestType;
        } catch (Exception e) {
            e = e;
            coeditSessionConnectorImpl = this;
            z2 = z;
            requestType2 = requestType;
        }
        try {
            AbstractC0254f.m535a().requestGroup(str, new GroupApi.GroupResultCallback<GroupResult>() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.13
                @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
                public void onResult(GroupResult groupResult) {
                    if (101 == groupResult.getStatus().getCode()) {
                        MainCoeditLogger.m7253i(CoeditSessionConnectorImpl.this.CALLER_TAG, "[CS8-1] deleteLocalDocInternal() : onResult()");
                        CoeditSessionConnectorImpl.this.deleteLocalSharedSdoc(str, str2, requestType2);
                        return;
                    }
                    MainCoeditLogger.m7251e(CoeditSessionConnectorImpl.this.CALLER_TAG, "[CS8-2] deleteLocalDocInternal() : onResult() , statusCode = " + groupResult.getStatus().getCode());
                    GcsGroupNetworkUtils.showUnknownFailToast(CoeditSessionConnectorImpl.this.mContext, requestType2, z2);
                    if (CoeditSessionConnectorImpl.this.mSpaceDeleteCallback != null) {
                        CoeditSessionConnectorImpl.this.mSpaceDeleteCallback.onFail();
                        CoeditSessionConnectorImpl.this.mSpaceDeleteCallback = null;
                    }
                }
            });
        } catch (Exception e2) {
            e = e2;
            Exception exc = e;
            GcsGroupNetworkUtils.showUnknownFailToast(coeditSessionConnectorImpl.mContext, requestType2, z2);
            CoeditSessionConnector.ActionResult actionResult = coeditSessionConnectorImpl.mSpaceDeleteCallback;
            if (actionResult != null) {
                actionResult.onFail();
                coeditSessionConnectorImpl.mSpaceDeleteCallback = null;
            }
            MainCoeditLogger.m7253i(coeditSessionConnectorImpl.CALLER_TAG, "deleteLocalDocInternal(). " + exc.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteLocalSharedSdoc(String str, final String str2, GcsConstants.RequestType requestType) {
        MainCoeditLogger.m7253i(this.CALLER_TAG, "[CS8] deleteLocalSharedSdoc() : run CoeditDeleteLocalSharedSdocTask");
        CoeditDeleteLocalSharedSdocTask.DeleteType deleteType = CoeditDeleteLocalSharedSdocTask.DeleteType.GROUP;
        if (requestType == GcsConstants.RequestType.Leave) {
            deleteType = CoeditDeleteLocalSharedSdocTask.DeleteType.GROUP_LEAVE;
        }
        new CoeditDeleteLocalSharedSdocTask(deleteType, str, new InterfaceC0085b() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.15
            @Override // p024F.InterfaceC0085b
            public void onDeleteLocalSharedSdocFinished() {
                MainCoeditLogger.m7253i(CoeditSessionConnectorImpl.this.CALLER_TAG, "[CS8-1] deleteLocalSharedSdoc() : onDeleteLocalSharedSdocFinished()");
                CoeditSessionConnectorImpl.this.requestSpace(str2);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CoeditSessionConnectorImpl.this.mSpaceDeleteCallback != null) {
                            CoeditSessionConnectorImpl.this.mSpaceDeleteCallback.onSuccess();
                            CoeditSessionConnectorImpl.this.mSpaceDeleteCallback = null;
                        }
                    }
                });
            }
        }).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSpaceCreate(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (this.mPickerInfo == null) {
            MainCoeditLogger.m7251e(this.CALLER_TAG, "requestSpaceCreate# picker info is null.");
            return;
        }
        MainCoeditLogger.m7250d(this.CALLER_TAG, "[CS3] requestSpaceCreate : try to create a group first!");
        try {
            if (!checkSessionConnection(GcsConstants.RequestType.Create, this.mPickerInfo.isStandalone())) {
                this.mPickerInfo.onFail();
                return;
            }
            this.mPickerInfo.onSocialActivityFinished(false);
            AbstractC0254f.m535a().requestGroupCreation(new GroupApi.GroupRequest(this.mPickerInfo.getSpaceName(), "UNM1"), new GroupApi.InvitationRequest("", arrayList, arrayList2), new GroupApi.GroupResultCallback<GroupInvitationResult>() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.7
                @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
                public void onResult(GroupInvitationResult groupInvitationResult) {
                    boolean z = groupInvitationResult.getStatus().getCode() == 1;
                    String displayMessage = groupInvitationResult.getDisplayMessage();
                    MainCoeditLogger.m7253i(CoeditSessionConnectorImpl.this.CALLER_TAG, "[CS3] requestSpaceCreate, requestGroupCreation# onResult : " + z + ", displayMessage : " + displayMessage);
                    if (!z) {
                        GcsGroupNetworkUtils.showUnknownFailToast(CoeditSessionConnectorImpl.this.mContext, GcsConstants.RequestType.Create, CoeditSessionConnectorImpl.this.mPickerInfo.isStandalone());
                        CoeditSessionConnectorImpl.this.mPickerInfo.onFail();
                    } else {
                        CoeditSessionConnectorImpl.this.requestMember(groupInvitationResult.getGroup().getGroupId());
                        if (CoeditSessionConnectorImpl.this.createSharedNotebooks(groupInvitationResult.getGroup().getGroupId())) {
                            return;
                        }
                        CoeditSessionConnectorImpl.this.mPickerInfo.onFail();
                    }
                }
            });
        } catch (Exception e) {
            AbstractC4539a.m3204n(e, new StringBuilder("requestSpaceCreate# Exception : "), this.CALLER_TAG);
            this.mPickerInfo.onFail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAppUpdateDialog() {
        AppUpdateDialogFragment appUpdateDialogFragment = new AppUpdateDialogFragment();
        appUpdateDialogFragment.setDialogListener(new AppUpdateDialogFragment.AppUpdateDialogListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.21
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                CoeditSessionConnectorImpl.this.mActivityContract.finishActivity();
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (-1 == i) {
                    UpdateManager.getInstance().goToGalaxyAppStore();
                }
                CoeditSessionConnectorImpl.this.mActivityContract.finishActivity();
            }
        });
        appUpdateDialogFragment.showAllowingStateLoss(this.mActivityContract.getActivity().getSupportFragmentManager(), AppUpdateDialogFragment.FOR_COEDIT);
        MainCoeditLogger.m7250d(this.CALLER_TAG, "showAppUpdateDialog#");
    }

    private void showSESAgentUpdateDialog(NotesActivityResultCallback notesActivityResultCallback) {
        try {
            Intent intentForForceUpdate = AbstractC14517a.m15159s().getIntentForForceUpdate();
            if (intentForForceUpdate == null) {
                MainCoeditLogger.m7251e(this.CALLER_TAG, "showSESAgentUpdateDialog# Exception : intent is null");
            } else {
                MainCoeditLogger.m7253i(this.CALLER_TAG, "showSESAgentUpdateDialog#");
                this.mActivityContract.launchActivity(intentForForceUpdate, notesActivityResultCallback);
            }
        } catch (Exception e) {
            MainCoeditLogger.m7251e(this.CALLER_TAG, "showSESAgentUpdateDialog# Exception : " + e.toString());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public boolean connect() {
        return C6715o.m4808q().m4795b(1, this.mSesUiAllListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public void disconnect() {
        C6715o.m4808q().m4797d(1, this.mSesUiAllListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public boolean isConnected() {
        return C6715o.m4808q().m4801j();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public boolean isLatestNotesVersion() {
        BaseUpdater.AppStoreResult appStoreResultCheckForceUpdateNotesVersion = CoeditUpdater.getInstance().checkForceUpdateNotesVersion(new BaseUpdater.AppStoreResultListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.20
            @Override // com.samsung.android.support.senl.nt.app.common.updater.BaseUpdater.AppStoreResultListener
            public void onResult(final BaseUpdater.AppStoreResult appStoreResult) {
                ViewModeUtils.runOnUiThread(CoeditSessionConnectorImpl.this.mActivityContract.getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.20.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (appStoreResult == BaseUpdater.AppStoreResult.NEED_UPDATE) {
                            CoeditSessionConnectorImpl.this.showAppUpdateDialog();
                        }
                    }
                });
            }
        });
        MainCoeditLogger.m7253i(this.CALLER_TAG, "isLatestNotesVersion# appStoreResult : " + appStoreResultCheckForceUpdateNotesVersion);
        if (appStoreResultCheckForceUpdateNotesVersion == BaseUpdater.AppStoreResult.ERROR) {
            this.mActivityContract.finishActivity();
            return false;
        }
        if (appStoreResultCheckForceUpdateNotesVersion != BaseUpdater.AppStoreResult.NEED_UPDATE) {
            return true;
        }
        showAppUpdateDialog();
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public boolean isStorageFull() {
        return AbstractC0267s.m544b();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    @SuppressLint({"StaticFieldLeak"})
    public void launchSocialPicker(@NonNull final CoeditPickerInfo coeditPickerInfo) {
        if (!C0158a.m409d(this.mContext)) {
            MainCoeditLogger.m7250d(this.CALLER_TAG, "launchSocialPicker# return - isCoeditFeatureSupported false");
            showSESAgentUpdateDialog(new NotesActivityResultCallback() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.4
                @Override // com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback
                public void onActivityResult(int i, @Nullable Intent intent) {
                }
            });
        } else {
            final Intent[] intentArr = {null};
            DataTask dataTask = new DataTask(this.mActivityContract.getActivity());
            dataTask.setCallback(new C81875(intentArr, coeditPickerInfo));
            dataTask.run(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    if (CoeditSessionConnectorImpl.this.isStorageFull()) {
                        MainCoeditLogger.m7250d(CoeditSessionConnectorImpl.this.CALLER_TAG, "launchSocialPicker# return - isStorageFull");
                        ToastHandler.show(CoeditSessionConnectorImpl.this.mContext, CoeditSessionConnectorImpl.this.mContext.getResources().getString(C8003R.string.co_edit_cannot_create_shared_note_storage_full), 1, false);
                        return;
                    }
                    if (!CoeditSessionConnectorImpl.this.checkSessionConnection(GcsConstants.RequestType.Create, coeditPickerInfo.isStandalone())) {
                        MainCoeditLogger.m7250d(CoeditSessionConnectorImpl.this.CALLER_TAG, "launchSocialPicker# return - checkSessionConnection false");
                        return;
                    }
                    Intent[] intentArr2 = intentArr;
                    boolean zIsStandalone = coeditPickerInfo.isStandalone();
                    ExecutorService executorService = AbstractC0294l.f760a;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(501);
                    intentArr2[0] = new OpenSessionApi().getIntentForSocialPicker(BaseUtils.getApplicationContext(), new SocialPickerRequest.Builder(CommonUtils.getNewNotesServiceId(), arrayList).setExceptionGuidList(Collections.singletonList(C13541h.m14287e().m14293g())).setEnableSharingAccount(true).setMaxRecipientCount(9).setShowInvitationChoice(Boolean.TRUE).setStandalone(zIsStandalone).build()).setPackage("com.samsung.android.mobileservice");
                    intentArr[0].setFlags(603979776);
                    CoeditSessionConnectorImpl.this.mPickerInfo = coeditPickerInfo;
                }
            });
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public void releaseSpaceDeleteActionResult() {
        MainCoeditLogger.m7250d(this.CALLER_TAG, "releaseSpaceDeleteActionResult");
        this.mSpaceDeleteCallback = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public void requestInvitationAccept(final String str, final boolean z, final CoeditSessionConnector.CoeditCreateResult coeditCreateResult) {
        MainCoeditLogger.m7253i(this.CALLER_TAG, "requestInvitationAccept() groupId " + str);
        try {
            if (!C6715o.m4808q().m4801j()) {
                MainCoeditLogger.m7251e(this.CALLER_TAG, "requestInvitationAccept() session not connected");
                coeditCreateResult.onFail();
                return;
            }
            HashMap map = AbstractC0291i.f755d;
            if (!map.containsKey(str)) {
                map.put(str, Long.valueOf(System.currentTimeMillis()));
            }
            AbstractC0254f.m535a().requestGroupInvitationAcceptance(str, new GroupApi.GroupResultCallback<BooleanResult>() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.16
                @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
                public void onResult(BooleanResult booleanResult) {
                    boolean result = booleanResult.getResult();
                    String displayMessage = booleanResult.getStatus().getDisplayMessage();
                    AbstractC0291i.f755d.remove(str);
                    MainCoeditLogger.m7253i(CoeditSessionConnectorImpl.this.CALLER_TAG, "requestInvitationAccept() onResult: " + result + ", displayMessage: " + displayMessage + ", message : " + booleanResult.getStatus().getMessage());
                    if (result) {
                        try {
                            new SenlThreadFactory(CoeditSessionConnectorImpl.TAG).newThread(CoeditSessionConnectorImpl.this.createRequestSpaceListRunnable(str, z, coeditCreateResult)).start();
                        } catch (Exception e) {
                            AbstractC4539a.m3204n(e, new StringBuilder(""), CoeditSessionConnectorImpl.this.CALLER_TAG);
                            CoeditSessionConnector.CoeditCreateResult coeditCreateResult2 = coeditCreateResult;
                            if (coeditCreateResult2 != null) {
                                coeditCreateResult2.onFail();
                            }
                        }
                        GcsGroupNetworkUtils.showDisplayMessageToast(CoeditSessionConnectorImpl.this.mContext, z ? C8003R.string.co_edit_shared_notebook_invitations_success_message : C8003R.string.gcs_invitations_success_message);
                        return;
                    }
                    if (TextUtils.isEmpty(displayMessage)) {
                        GcsGroupNetworkUtils.showDisplayMessageToast(CoeditSessionConnectorImpl.this.mContext, z ? C8003R.string.co_edit_shared_notebook_invitations_already_expired : C8003R.string.gcs_invitations_already_expired);
                    } else if (booleanResult.getStatus().getCode() == 115) {
                        GcsGroupNetworkUtils.showDisplayMessageToast(CoeditSessionConnectorImpl.this.mContext, z ? C8003R.string.co_edit_invitations_already_joined_this_shared_note_message : C8003R.string.co_edit_invitations_already_joined_this_shared_notebook_message);
                    } else {
                        GcsGroupNetworkUtils.showDisplayMessageToast(CoeditSessionConnectorImpl.this.mContext, displayMessage);
                    }
                    CoeditSessionConnector.CoeditCreateResult coeditCreateResult3 = coeditCreateResult;
                    if (coeditCreateResult3 != null) {
                        coeditCreateResult3.onFail();
                    }
                }
            });
        } catch (Exception e) {
            MainCoeditLogger.m7251e(this.CALLER_TAG, "requestInvitationAccept() Exception : " + e.getMessage());
            coeditCreateResult.onFail();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public void requestInvitationDecline(final String str) {
        MainCoeditLogger.m7253i(this.CALLER_TAG, "requestInvitationDecline() groupId " + str);
        try {
            if (!C6715o.m4808q().m4801j()) {
                MainCoeditLogger.m7251e(this.CALLER_TAG, "requestInvitationDecline() session not connected");
                return;
            }
            HashMap map = AbstractC0291i.f755d;
            if (!map.containsKey(str)) {
                map.put(str, Long.valueOf(System.currentTimeMillis()));
            }
            AbstractC0254f.m535a().requestGroupInvitationRejection(str, new GroupApi.GroupResultCallback<BooleanResult>() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.18
                @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
                public void onResult(BooleanResult booleanResult) {
                    boolean result = booleanResult.getResult();
                    AbstractC0291i.f755d.remove(str);
                    String str2 = CoeditSessionConnectorImpl.this.CALLER_TAG;
                    StringBuilder sbM3200j = AbstractC4539a.m3200j("requestInvitationDecline() onResult: ", ", displayMessage: ", result);
                    sbM3200j.append(booleanResult.getStatus().getDisplayMessage());
                    MainCoeditLogger.m7253i(str2, sbM3200j.toString());
                }
            });
        } catch (Exception e) {
            AbstractC4539a.m3204n(e, new StringBuilder("requestInvitationDecline() Exception : "), this.CALLER_TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public void requestInvitationList(@NonNull CoeditSessionConnector.InvitationResult invitationResult) {
        try {
            if (!C6715o.m4808q().m4801j()) {
                MainCoeditLogger.m7251e(this.CALLER_TAG, "requestInvitationList() session not connected");
            } else {
                AbstractC0254f.m535a().requestMyInvitationList(new GroupInvitationListCallback(this, invitationResult));
            }
        } catch (Exception e) {
            AbstractC4539a.m3204n(e, new StringBuilder("requestInvitationList() Exception : "), this.CALLER_TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public void requestMember() {
        try {
            MainCoeditLogger.m7250d(this.CALLER_TAG, "requestMember#");
            AbstractC0254f.m535a().requestSync(GroupSyncResultCallback.getInstance());
        } catch (Exception e) {
            AbstractC4539a.m3204n(e, new StringBuilder("requestMember Exception : "), this.CALLER_TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public void requestMemberRemove(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            MainCoeditLogger.m7253i(this.CALLER_TAG, "requestMemberRemove(). groupId is null or empty.");
            return;
        }
        MainCoeditLogger.m7253i(this.CALLER_TAG, "requestMemberRemove() groupId " + str + ", newLeaderId " + str2);
        try {
            if (checkSessionConnection(GcsConstants.RequestType.Member, false)) {
                GroupApi.GroupResultCallback<BooleanResult> groupResultCallback = new GroupApi.GroupResultCallback<BooleanResult>() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.19
                    @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
                    public void onResult(BooleanResult booleanResult) {
                        if (booleanResult.getResult()) {
                            CoeditSessionConnectorImpl.this.requestMember();
                        }
                    }
                };
                synchronized (AbstractC0254f.class) {
                    AbstractC0254f.m535a().requestGroupMemberRemoval(str, str2, groupResultCallback);
                }
            }
        } catch (Exception e) {
            AbstractC4539a.m3204n(e, new StringBuilder("requestMemberRemove() Exception : "), this.CALLER_TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public void requestOldSharedNotebooks(CoeditSessionConnector.ActionResult actionResult) {
        MainCoeditLogger.m7250d(this.CALLER_TAG, "requestOldSharedNotebooks#");
        if (!C6716p.m4809q().m4801j()) {
            C6716p.m4809q().m4795b(1, new SesOldUiAllListener(this, 0));
        }
        ShareSyncResultCallback.getInstance().setActionResult(actionResult);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public void requestSpace(String str) {
        try {
            MainCoeditLogger.m7250d(this.CALLER_TAG, "requestSpace# spaceId : " + str);
            AbstractC0267s.m543a().requestSpace(str, SpaceResultCallback.getInstance());
        } catch (Exception e) {
            AbstractC4539a.m3204n(e, new StringBuilder("requestSpace# e : "), this.CALLER_TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public void requestSpaceCreateWithLink(@NonNull CoeditPickerInfo coeditPickerInfo) {
        MainCoeditLogger.m7250d(this.CALLER_TAG, "requestSpaceCreateWithLink");
        this.mPickerInfo = coeditPickerInfo;
        try {
            if (!checkSessionConnection(GcsConstants.RequestType.Create, coeditPickerInfo.isStandalone())) {
                this.mPickerInfo.onFail();
                return;
            }
            this.mPickerInfo.onSocialActivityFinished(true);
            AbstractC0254f.m535a().requestGroupCreation(new GroupApi.GroupRequest(this.mPickerInfo.getSpaceName(), "UNM1", true), new GroupApi.GroupResultCallback<GroupInvitationResult>() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.9
                @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
                public void onResult(GroupInvitationResult groupInvitationResult) {
                    boolean z = groupInvitationResult.getStatus().getCode() == 1;
                    String displayMessage = groupInvitationResult.getDisplayMessage();
                    MainCoeditLogger.m7253i(CoeditSessionConnectorImpl.this.CALLER_TAG, "requestSpaceCreateWithLink# onResult : " + z + ", displayMessage : " + displayMessage);
                    if (!z) {
                        GcsGroupNetworkUtils.showUnknownFailToast(CoeditSessionConnectorImpl.this.mContext, GcsConstants.RequestType.Create, CoeditSessionConnectorImpl.this.mPickerInfo.isStandalone());
                        CoeditSessionConnectorImpl.this.mPickerInfo.onFail();
                        return;
                    }
                    InvitationLink invitationLink = groupInvitationResult.getGroup().getInvitationLink();
                    CoeditSessionConnectorImpl.this.mPickerInfo.setInvitationLink(invitationLink);
                    MainCoeditLogger.m7250d(CoeditSessionConnectorImpl.this.CALLER_TAG, "requestSpaceCreateWithLink# uri :  " + MainLogger.getEncode(invitationLink.getUrl()));
                    if (CoeditSessionConnectorImpl.this.createSharedNotebooks(groupInvitationResult.getGroup().getGroupId())) {
                        return;
                    }
                    CoeditSessionConnectorImpl.this.mPickerInfo.onFail();
                }
            });
        } catch (Exception e) {
            AbstractC4539a.m3204n(e, new StringBuilder("requestSpaceCreate# Exception : "), this.CALLER_TAG);
            this.mPickerInfo.onFail();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public boolean requestSpaceDelete(final String str, final String str2, final boolean z, CoeditSessionConnector.ActionResult actionResult, String str3, long j) {
        if (TextUtils.isEmpty(str)) {
            MainCoeditLogger.m7251e(this.CALLER_TAG, "[CS8-2] requestSpaceDelete(). groupId is null or empty.");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            MainCoeditLogger.m7251e(this.CALLER_TAG, "[CS8-2] requestSpaceDelete(). spaceId is null or empty.");
            return false;
        }
        MainCoeditLogger.m7253i(this.CALLER_TAG, "[CS8] requestSpaceDelete()");
        try {
            if (!checkSessionConnection(GcsConstants.RequestType.Delete, z)) {
                MainCoeditLogger.m7251e(this.CALLER_TAG, "[CS8-2] requestSpaceDelete(). No session!");
                return false;
            }
            this.mSpaceDeleteCallback = actionResult;
            if (!z) {
                MainCoeditLogger.m7253i(this.CALLER_TAG, "[CS8] not standalone and requestSpaceDelete() : requestGroupDeletion()");
                AbstractC0254f.m535a().requestGroupDeletion(str, new GroupApi.GroupResultCallback<BooleanResult>() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.12
                    @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
                    public void onResult(BooleanResult booleanResult) {
                        if (booleanResult.getResult()) {
                            MainCoeditLogger.m7253i(CoeditSessionConnectorImpl.this.CALLER_TAG, "[CS8-1] requestSpaceDelete() : requestGroupDeletion() : onResult() = " + booleanResult.getResult());
                        } else {
                            MainCoeditLogger.m7251e(CoeditSessionConnectorImpl.this.CALLER_TAG, "[CS8-2] requestSpaceDelete() : requestGroupDeletion() : onResult() = " + booleanResult.getResult());
                        }
                        CoeditSessionConnectorImpl.this.deleteLocalDocInternal(booleanResult, str, str2, z, "requestGroupDelete(). onResult() : ", GcsConstants.RequestType.Delete);
                    }
                });
                return true;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "Group://Standalone " + this.mContext.getResources().getString(C8003R.string.co_edit_note_auto_title, SesCoeditGroupReadResolver.getInstance().getUserName(str, SesCoeditGroupReadResolver.getInstance().getLeaderId(str)), WidgetUtils.getTitleTime(j));
            }
            MainCoeditLogger.m7253i(this.CALLER_TAG, "[CS8] requestSpaceDelete() : requestSpaceUpdate()");
            AbstractC0267s.m543a().requestSpaceUpdate(SesCoeditShareReadResolver.getInstance().getSpaceIdByGroupId(str), str3, "", new ShareApi.SpaceResultCallback() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.11
                @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.SpaceResultCallback
                public void onResult(SpaceResult spaceResult) {
                    MainCoeditLogger.m7253i(CoeditSessionConnectorImpl.this.CALLER_TAG, "[CS8-1] requestSpaceDelete() : requestSpaceUpdate() : onResult()");
                    try {
                        MainCoeditLogger.m7253i(CoeditSessionConnectorImpl.this.CALLER_TAG, "[CS8] requestSpaceDelete() : requestSpaceUpdate() : requestGroupDeletion()");
                        AbstractC0254f.m535a().requestGroupDeletion(str, new GroupApi.GroupResultCallback<BooleanResult>() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.11.1
                            @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
                            public void onResult(BooleanResult booleanResult) {
                                if (booleanResult.getResult()) {
                                    MainCoeditLogger.m7253i(CoeditSessionConnectorImpl.this.CALLER_TAG, "[CS8-1] requestSpaceDelete() : requestSpaceUpdate() : requestGroupDeletion() : onResult()");
                                } else {
                                    MainCoeditLogger.m7251e(CoeditSessionConnectorImpl.this.CALLER_TAG, "[CS8-2] requestSpaceDelete() : requestSpaceUpdate() : requestGroupDeletion() : onResult()");
                                }
                                C817311 c817311 = C817311.this;
                                CoeditSessionConnectorImpl.this.deleteLocalDocInternal(booleanResult, str, str2, z, "requestGroupDelete(). onResult() : ", GcsConstants.RequestType.Delete);
                            }
                        });
                    } catch (Exception e) {
                        MainCoeditLogger.m7253i(CoeditSessionConnectorImpl.this.CALLER_TAG, "requestSpaceDelete() : requestSpaceUpdate(). " + e.getMessage());
                        if (CoeditSessionConnectorImpl.this.mSpaceDeleteCallback != null) {
                            CoeditSessionConnectorImpl.this.mSpaceDeleteCallback.onFail();
                            CoeditSessionConnectorImpl.this.mSpaceDeleteCallback = null;
                        }
                    }
                }
            });
            return true;
        } catch (Exception e) {
            AbstractC4539a.m3204n(e, new StringBuilder("[CS8-2] requestSpaceDelete(). Exception "), this.CALLER_TAG);
            return false;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public boolean requestSpaceLeave(final String str, final String str2, @NonNull CoeditSessionConnector.ActionResult actionResult) {
        if (TextUtils.isEmpty(str)) {
            MainCoeditLogger.m7253i(this.CALLER_TAG, "requestSpaceLeave(). groupId is null or empty.");
            return false;
        }
        MainCoeditLogger.m7253i(this.CALLER_TAG, "requestSpaceLeave()");
        try {
            if (!checkSessionConnection(GcsConstants.RequestType.Leave, false)) {
                return false;
            }
            this.mSpaceDeleteCallback = actionResult;
            AbstractC0254f.m535a().requestLeave(str, new GroupApi.GroupResultCallback<BooleanResult>() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.14
                @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
                public void onResult(BooleanResult booleanResult) {
                    CoeditSessionConnectorImpl.this.deleteLocalDocInternal(booleanResult, str, str2, false, "requestSpaceLeave(). onResult() ", GcsConstants.RequestType.Leave);
                }
            });
            return true;
        } catch (Exception e) {
            MainCoeditLogger.m7253i(this.CALLER_TAG, "requestSpaceLeave(). Exception " + e.getMessage());
            return false;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public void requestSpaceLeaveAfterLeaderAssignSuccess(String str, String str2, CoeditSessionConnector.ActionResult actionResult) {
        MainCoeditLogger.m7253i(this.CALLER_TAG, "requestSpaceLeaveAfterLeaderAssignSuccess()");
        try {
            GcsConstants.RequestType requestType = GcsConstants.RequestType.Leave;
            if (checkSessionConnection(requestType, false)) {
                this.mSpaceDeleteCallback = actionResult;
                BooleanResult booleanResultM539e = AbstractC0254f.m539e(str);
                if (booleanResultM539e == null || !booleanResultM539e.getResult()) {
                    GcsGroupNetworkUtils.showUnknownFailToast(this.mContext, requestType, false);
                } else {
                    deleteLocalSharedSdoc(str, str2, requestType);
                }
            }
        } catch (Exception e) {
            AbstractC4539a.m3204n(e, new StringBuilder("requestSpaceLeaveAfterLeaderAssign() Exception : "), this.CALLER_TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public void requestSpaceMove(String str, String str2, boolean z) {
        SpaceResult spaceResultM545c;
        if (TextUtils.isEmpty(str)) {
            MainCoeditLogger.m7253i(this.CALLER_TAG, "requestSpaceMove(). spaceId is null or empty.");
            return;
        }
        String str3 = this.CALLER_TAG;
        StringBuilder sbM16m = AbstractC0000a.m16m("requestSpaceMove() spaceId ", str, ", spaceName ", str2, ", moveToStandalone ");
        sbM16m.append(z);
        MainCoeditLogger.m7253i(str3, sbM16m.toString());
        try {
            GcsConstants.RequestType requestType = GcsConstants.RequestType.Create;
            if (checkSessionConnection(requestType, z)) {
                if (z) {
                    CompletableFuture completableFuture = new CompletableFuture();
                    if (AbstractC0267s.m543a().requestSpaceUpdate(str, true, (ShareApi.SpaceResultCallback) new C0261m(completableFuture)) == 1) {
                        spaceResultM545c = (SpaceResult) completableFuture.get(100000L, TimeUnit.MILLISECONDS);
                    } else {
                        Debugger.m8609e("SesShareApi", "Fail to requestSpaceUpdate");
                        spaceResultM545c = null;
                    }
                } else {
                    spaceResultM545c = AbstractC0267s.m545c(str, str2);
                }
                if (spaceResultM545c != null && spaceResultM545c.getStatus().getCode() == 1) {
                    return;
                }
                GcsGroupNetworkUtils.showUnknownFailToast(this.mContext, requestType, z);
            }
        } catch (Exception e) {
            AbstractC4539a.m3204n(e, new StringBuilder("requestSpaceMove() Exception : "), this.CALLER_TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public void requestSpaceUpdate(final String str, String str2, @NonNull final CoeditSessionConnector.ActionResult actionResult) {
        if (str2 == null || str2.length() < 1) {
            MainCoeditLogger.m7251e(this.CALLER_TAG, "requestSpaceUpdate# invalid spaceName.");
            return;
        }
        MainCoeditLogger.m7250d(this.CALLER_TAG, "requestSpaceUpdate#");
        try {
            if (checkSessionConnection(GcsConstants.RequestType.Rename, false)) {
                AbstractC0267s.m543a().requestSpaceUpdate(str, str2, "", new ShareApi.SpaceResultCallback() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.10
                    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.SpaceResultCallback
                    public void onResult(SpaceResult spaceResult) {
                        boolean z = spaceResult.getStatus().getCode() == 1;
                        MainCoeditLogger.m7253i(CoeditSessionConnectorImpl.this.CALLER_TAG, "requestSpaceUpdate# onResult : " + z);
                        if (!z) {
                            GcsGroupNetworkUtils.showUnknownFailToast(CoeditSessionConnectorImpl.this.mContext, GcsConstants.RequestType.Rename, false);
                        } else {
                            CoeditSessionConnectorImpl.this.requestSpace(str);
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnectorImpl.10.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    actionResult.onSuccess();
                                }
                            });
                        }
                    }
                });
            }
        } catch (Exception e) {
            AbstractC4539a.m3204n(e, new StringBuilder("requestSpaceUpdate# Exception "), this.CALLER_TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public void requestSync() {
        try {
            MainCoeditLogger.m7250d(this.CALLER_TAG, "requestSync#");
            AbstractC0267s.m543a().requestSync(new SyncOption(SyncOption.SyncType.FULL_SYNC, true, true), ShareSyncResultCallback.getInstance());
            AbstractC0254f.m535a().requestSync(GroupSyncResultCallback.getInstance());
        } catch (Exception e) {
            AbstractC4539a.m3204n(e, new StringBuilder("requestSync Exception : "), this.CALLER_TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public void requestMember(String str) {
        try {
            MainCoeditLogger.m7250d(this.CALLER_TAG, "requestMember(groupId)#");
            AbstractC0254f.m535a().requestGroupMemberList(str, MemberResultCallback.getInstance());
        } catch (Exception e) {
            AbstractC4539a.m3204n(e, new StringBuilder("requestMember Exception : "), this.CALLER_TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector
    public void requestSync(CoeditSessionConnector.ActionResult actionResult) {
        try {
            MainCoeditLogger.m7250d(this.CALLER_TAG, "requestSync#actionResult");
            AbstractC0267s.m543a().requestSync(new SyncOption(SyncOption.SyncType.FULL_SYNC, true, true), ShareSyncResultCallback.getInstance());
            AbstractC0254f.m535a().requestSync(GroupSyncResultCallback.getInstance());
            GroupSyncResultCallback.getInstance().setActionResult(actionResult);
        } catch (Exception e) {
            AbstractC4539a.m3204n(e, new StringBuilder("requestSync#actionResult Exception : "), this.CALLER_TAG);
        }
    }
}
