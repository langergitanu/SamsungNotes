package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6716p;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.group.GroupApi;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.Space;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.GcsImpl;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.view.GcsGroupFragment;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SesUiListener;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Executor;
import p001A.AbstractC0000a;
import p042J1.C0145c;
import p044K.C0158a;
import p052M.C0171a;
import p075S.AbstractC0248O;
import p075S.AbstractC0272x;
import p079T.AbstractC0294l;
import p079T.AbstractC0299q;
import p079T.RunnableC0292j;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GcsBaseMode extends BaseMode implements GcsImpl {
    private static final String TAG = "GcsBaseMode";
    private boolean isConnecting;
    protected final FragmentActivity mActivity;
    private boolean mFinishActivityBySesPermissionError;
    private GroupSyncResultCallback mGroupSyncResultCallback;
    private boolean mIsRequestSocialSignUp;
    private boolean mIsSocialSignUpResultOk;
    private boolean mRetryRequestSyncByDelayedActivate;
    private int mRetryRequestSyncByDelayedActivateCount;
    private SesUiAllListener mSesUiAllListener;
    private final Executor mWorkerExecutor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DelayedRequest implements Runnable {
        private final WeakReference<GcsBaseMode> weakReference;

        public DelayedRequest(GcsBaseMode gcsBaseMode) {
            this.weakReference = new WeakReference<>(gcsBaseMode);
        }

        @Override // java.lang.Runnable
        public void run() {
            GcsBaseMode gcsBaseMode = this.weakReference.get();
            if (gcsBaseMode == null || !gcsBaseMode.isSesSessionConnected()) {
                return;
            }
            gcsBaseMode.onSesSessionConnected();
            if (gcsBaseMode.mSesUiAllListener != null) {
                gcsBaseMode.mSesUiAllListener.onConnected();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GroupSyncResultCallback implements GroupApi.GroupSyncResultCallback {
        private WeakReference<FragmentActivity> mActivityWeakReference;

        public GroupSyncResultCallback(WeakReference<FragmentActivity> weakReference) {
            this.mActivityWeakReference = weakReference;
        }

        @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupSyncResultCallback
        public void onResult(BooleanResult booleanResult) {
            WeakReference<FragmentActivity> weakReference = this.mActivityWeakReference;
            if (weakReference == null) {
                return;
            }
            final FragmentActivity fragmentActivity = weakReference.get();
            ViewModeUtils.runOnUiThread(fragmentActivity, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.GcsBaseMode.GroupSyncResultCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    GcsGroupFragment gcsGroupFragment = (GcsGroupFragment) fragmentActivity.getSupportFragmentManager().findFragmentByTag(GcsGroupFragment.TAG);
                    if (gcsGroupFragment != null) {
                        MainLogger.m7254d(GcsBaseMode.TAG, "GroupSyncResultCallback# notifyDataSetChanged");
                        gcsGroupFragment.notifyDataSetChanged();
                    }
                }
            });
        }

        public void release() {
            this.mActivityWeakReference.clear();
            this.mActivityWeakReference = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RequestSyncCallback implements ShareApi.ShareSyncResultCallback {
        private final WeakReference<GcsBaseMode> mode;

        public RequestSyncCallback(GcsBaseMode gcsBaseMode) {
            this.mode = new WeakReference<>(gcsBaseMode);
        }

        @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ShareSyncResultCallback
        public void onResult(BooleanResult booleanResult) {
            GcsBaseMode gcsBaseMode = this.mode.get();
            if (gcsBaseMode != null) {
                MainLogger.m7258i(gcsBaseMode.getTag(), "RequestSyncCallback onResult# " + booleanResult.getResult());
                if (booleanResult.getResult() || booleanResult.getStatus() == null) {
                    return;
                }
                MainLogger.m7258i(gcsBaseMode.getTag(), "RequestSyncCallback onResult# error code : " + booleanResult.getStatus().getCode());
                if (booleanResult.getStatus().getCode() == 102) {
                    gcsBaseMode.mFinishActivityBySesPermissionError = true;
                } else {
                    if (booleanResult.getStatus().getCode() != 7 || gcsBaseMode.mRetryRequestSyncByDelayedActivateCount >= 1) {
                        return;
                    }
                    gcsBaseMode.mRetryRequestSyncByDelayedActivate = true;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SesUiAllListener implements SesUiListener {
        public /* synthetic */ SesUiAllListener(GcsBaseMode gcsBaseMode, int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.SesUiListener
        public void onConnected() {
            Debugger.m8607d(GcsBaseMode.TAG, "SesUiAllListener# onConnected() start");
            if (GcsBaseMode.this.onSesSessionConnected()) {
                MainLogger.m7258i(GcsBaseMode.this.getTag(), "SesUiAllListener# create Social SessionInstance : onConnected() requestSync ");
                GcsBaseMode.this.requestSync("SesUiAllListener# onConnected");
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.SesUiListener
        public void onDisConnected(int i) {
            if (i == SeMobileServiceSession.ConnectionResultCallback.CAUSE_AGENT_NOT_INSTALLED) {
                MainLogger.m7258i(GcsBaseMode.TAG, "SesUiAllListener#onDisConnected : Agent is not installed properly.");
            } else if (i == SeMobileServiceSession.ConnectionResultCallback.CAUSE_AGENT_FORCE_UPDATE_REQUIRED) {
                MainLogger.m7258i(GcsBaseMode.TAG, "SesUiAllListener#onDisConnected : Force update required.");
            } else {
                AbstractC8014b.m7201c(i, "SesUiAllListener#onDisConnected reason code : ", GcsBaseMode.TAG);
            }
        }

        private SesUiAllListener() {
        }
    }

    public GcsBaseMode(ModeParams modeParams) {
        super(modeParams);
        this.isConnecting = false;
        this.mFinishActivityBySesPermissionError = false;
        this.mRetryRequestSyncByDelayedActivate = false;
        this.mRetryRequestSyncByDelayedActivateCount = 0;
        this.mIsSocialSignUpResultOk = false;
        this.mIsRequestSocialSignUp = false;
        this.mWorkerExecutor = AbstractC4539a.m3201k(TAG);
        this.mActivity = this.mFragment.getActivity();
        this.mSesUiAllListener = new SesUiAllListener(this, 0);
        PostLaunchManager.getInstance().executeBaseLogics();
        NotificationUtils.checkedNotificationPermissions(this.mFragment);
    }

    private boolean checkReadyToUseSharedService() {
        MainLogger.m7254d(getTag(), "checkReadyToUseSharedService");
        try {
            if (!AbstractC0299q.m605O()) {
                MainLogger.m7258i(getTag(), "checkReadyToUseSharedService# start social sign up.");
                if (this.mIsRequestSocialSignUp) {
                    return false;
                }
                this.mIsRequestSocialSignUp = true;
                Intent intentForSocialSignUp = Build.VERSION.SDK_INT < 29 ? AbstractC0299q.m648s().getIntentForSocialSignUp() : AbstractC0299q.m598H().getIntentForAgreementProcedure();
                MainLogger.m7254d(getTag(), "checkReadyToUseSharedService# getIntentForSocialSignUp() start activity");
                this.mActivity.startActivityForResult(intentForSocialSignUp, 8);
                return false;
            }
        } catch (Exception e) {
            MainLogger.m7255e(getTag(), "checkReadyToUseSharedService# Exception : " + e);
        }
        if (DesktopModeCompat.INSTANCE.getInstance().isDexMode(this.mContext)) {
            MainLogger.m7254d(getTag(), "checkReadyToUseSharedService# reconnectShareContentProvider() start");
            reconnectShareContentProvider();
        }
        return true;
    }

    private void createSessionInstance(String str) {
        AbstractC8014b.m7209k("createSessionInstance# caller :", str, getTag());
        this.isConnecting = true;
        C6716p.m4809q().m4795b(1, this.mSesUiAllListener);
        MainLogger.m7258i(getTag(), "createSessionInstance# finished");
    }

    private void initConnection(String str) {
        AbstractC0000a.m25v("initConnection# caller : ", str, getTag());
        if (!isSesSessionConnected()) {
            if (this.isConnecting) {
                new Handler(Looper.getMainLooper()).postDelayed(new DelayedRequest(this), 300L);
                return;
            } else {
                createSessionInstance("initConnection, no connecting");
                return;
            }
        }
        onSesSessionConnected();
        if (!this.mFinishActivityBySesPermissionError) {
            if (this.mRetryRequestSyncByDelayedActivate) {
                this.mRetryRequestSyncByDelayedActivateCount++;
                this.mRetryRequestSyncByDelayedActivate = false;
                requestSync("initConnection : connected, mFinishActivityBySesPermissionError false");
                return;
            }
            return;
        }
        MainLogger.m7258i(getTag(), "initConnection# checkPermission");
        this.mFinishActivityBySesPermissionError = false;
        PackageManager packageManager = this.mFragment.getActivity().getPackageManager();
        int iCheckPermission = packageManager.checkPermission("android.permission.READ_EXTERNAL_STORAGE", "com.samsung.android.mobileservice");
        int iCheckPermission2 = packageManager.checkPermission("android.permission.READ_CONTACTS", "com.samsung.android.mobileservice");
        if (iCheckPermission == 0 && iCheckPermission2 == 0) {
            requestSync("initConnection : connected, has permission");
        } else if (!this.mIsSocialSignUpResultOk) {
            onBackKeyDown();
        } else {
            this.mIsSocialSignUpResultOk = false;
            requestSync("initConnection : connected, no permission");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSesSessionConnected() {
        boolean zM4801j = C6716p.m4809q().m4801j();
        AbstractC8014b.m7210l("isSesSessionConnected# connected : ", getTag(), zM4801j);
        return zM4801j;
    }

    private void removeSessionInstance() {
        MainLogger.m7258i(getTag(), "removeSessionInstance()");
        this.isConnecting = false;
        C6716p.m4809q().m4797d(1, this.mSesUiAllListener);
        this.mSesUiAllListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSync(String str) {
        try {
            MainLogger.m7254d(getTag(), "[CS1] requestSync# caller : " + str);
            AbstractC0248O.m534h(new RequestSyncCallback(this));
            List<Space> listRequestSpaceList = SesShareReadResolver.getInstance().requestSpaceList();
            if (listRequestSpaceList == null || !listRequestSpaceList.isEmpty()) {
                return;
            }
            Context context = this.mAppContext;
            SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
            NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository();
            NotesDataRepositoryFactory.newInstance(context).createNotesDocumentPageRepository();
            NotesDataRepositoryFactory.newInstance(context).createMappedDocumentRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            if (syncNoteDataRepositoryCreateSyncNoteDataRepository.getUuidListMde().isEmpty()) {
                return;
            }
            MainLogger.m7254d(getTag(), "requestShare for ghost group or note");
            C0171a c0171aM429a = C0171a.m429a();
            String spaceId = this.mPresenter.getStateInfo().getSpaceId();
            Context context2 = this.mAppContext;
            c0171aM429a.getClass();
            if (C0145c.m333r(context2)) {
                return;
            }
            c0171aM429a.m432d(spaceId);
        } catch (Exception e) {
            AbstractC14516b.m15115c(e, new StringBuilder("[CS1-2] requestSync# Exception : "), getTag());
        }
    }

    public void initGcsInfo() {
        try {
            if (!AbstractC0294l.m576c(this.mActivity.getPackageManager())) {
                AbstractC0294l.f760a.execute(new RunnableC0292j(this.mGroupSyncResultCallback));
            } else {
                GroupSyncResultCallback groupSyncResultCallback = this.mGroupSyncResultCallback;
                if (C0145c.m333r(BaseUtils.getApplicationContext())) {
                    throw new ShareException(ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION, "requestSync sync failed - wifi only");
                }
                AbstractC0272x.m550a().requestSync(groupSyncResultCallback);
            }
        } catch (Exception e) {
            AbstractC14516b.m15115c(e, new StringBuilder("initGcsInfo# SesGroupApi.requestSync : "), getTag());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.GcsImpl
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        AbstractC8014b.m7200b(i, i2, "onActivityResult# requestCode : ", ", resultCode : ", getTag());
        if (i == 8) {
            this.mIsRequestSocialSignUp = false;
            if (i2 == -1) {
                this.mIsSocialSignUpResultOk = true;
                requestSync("onActivityResult : REQUEST_INTENT_SOCIAL_SIGN_UP");
            } else {
                MainLogger.m7258i(getTag(), "onActivityResult# Social sign up fail, app finish");
                onBackKeyDown();
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        if (!C0158a.m407a().m415h()) {
            MainLogger.m7254d(getTag(), "onLayout# Mde not supported");
            onBackKeyDown();
            return;
        }
        super.onLayout();
        this.mActionMenuController.setDisplayHomeAsUpEnabled(true);
        this.mActionMenuController.releaseCoeditBetaView();
        final String[] storagePermissions = PermissionCompat.getStoragePermissions(4);
        if (Build.VERSION.SDK_INT > 33 || PermissionHelper.isPermissionGranted(this.mActivity, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.GcsBaseMode.1
            @Override // java.lang.Runnable
            public void run() {
                PermissionHelper.requestPermissions(GcsBaseMode.this.mFragment, 203, storagePermissions);
            }
        }, storagePermissions)) {
            initConnection("onLayout");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        MainLogger.m7254d(getTag(), "onModeEnd");
        if (NotesUtils.getPreferenceMDESupported()) {
            removeSessionInstance();
        }
        releaseGroupSyncResult();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.GcsImpl
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (!PermissionHelper.verifyRequestResult(this.mActivity, iArr, strArr)) {
            MainLogger.m7258i(getTag(), "onRequestPermissionsResult(). permission is not granted.");
            onBackKeyDown();
        } else {
            MainLogger.m7258i(getTag(), "onRequestPermissionsResult(). permission is granted.");
            if (NotesUtils.getPreferenceMDESupported()) {
                createSessionInstance("onRequestPermissionsResult");
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onResume() {
        super.onResume();
        if (!C0158a.m407a().m415h()) {
            MainLogger.m7254d(getTag(), "onResume# Mde not supported");
            onBackKeyDown();
        } else {
            if (PermissionHelper.isPermissionGrantedWithoutNotice(this.mActivity, PermissionCompat.getStoragePermissions(4))) {
                initConnection("onResume");
            }
        }
    }

    public boolean onSesSessionConnected() {
        MainLogger.m7258i(getTag(), "onSesSessionConnected()");
        this.isConnecting = false;
        if (this.mGroupSyncResultCallback == null) {
            this.mGroupSyncResultCallback = new GroupSyncResultCallback(new WeakReference(this.mActivity));
            this.mWorkerExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.GcsBaseMode.2
                @Override // java.lang.Runnable
                public void run() {
                    GcsBaseMode.this.initGcsInfo();
                }
            });
        }
        return checkReadyToUseSharedService();
    }

    public void reconnectShareContentProvider() {
    }

    public void releaseGroupSyncResult() {
        GroupSyncResultCallback groupSyncResultCallback = this.mGroupSyncResultCallback;
        if (groupSyncResultCallback != null) {
            groupSyncResultCallback.release();
            this.mGroupSyncResultCallback = null;
        }
    }
}
