package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6716p;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SesUiListener;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import java.lang.ref.WeakReference;
import p044K.C0158a;
import p075S.AbstractC0248O;
import p079T.AbstractC0299q;
import p207n1.C13540g;
import p207n1.C13541h;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class BaseSesSessionActivity extends AbsAppCompatActivity {
    public static final int RESULT_ERROR = 1;
    private static final String TAG = "BaseSesSessionActivity";
    private delayedRequest mDelayedRequest;
    private RequestSyncCallback mRequestSyncCallback;
    private boolean isConnecting = false;
    private boolean isDestroyCalled = false;
    private boolean mFinishActivityBySesPermissionError = false;
    private int mRetryRequestSyncByDelayedActivateCount = 0;
    private boolean mRetryRequestSyncByDelayedActivate = false;
    private boolean mIsSocialSignUpResultOk = false;
    private boolean mIsRequestSocialSignUp = false;
    private SesUiAllListener mSesUiAllListener = null;
    private int sessionCount = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RequestSyncCallback implements ShareApi.ShareSyncResultCallback {
        final WeakReference<BaseSesSessionActivity> mActivity;

        public RequestSyncCallback(BaseSesSessionActivity baseSesSessionActivity) {
            this.mActivity = new WeakReference<>(baseSesSessionActivity);
        }

        @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ShareSyncResultCallback
        public void onResult(BooleanResult booleanResult) {
            BaseSesSessionActivity baseSesSessionActivity = this.mActivity.get();
            if (baseSesSessionActivity != null) {
                MainLogger.m7258i(baseSesSessionActivity.getTag(), "requestSync onResult() - " + booleanResult.getResult());
                if (booleanResult.getResult() || booleanResult.getStatus() == null) {
                    return;
                }
                MainLogger.m7258i(baseSesSessionActivity.getTag(), "requestSync : error code = " + booleanResult.getStatus().getCode());
                if (booleanResult.getStatus().getCode() == 102) {
                    baseSesSessionActivity.mFinishActivityBySesPermissionError = true;
                } else {
                    if (booleanResult.getStatus().getCode() != 7 || baseSesSessionActivity.mRetryRequestSyncByDelayedActivateCount >= 1) {
                        return;
                    }
                    baseSesSessionActivity.mRetryRequestSyncByDelayedActivate = true;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SesUiAllListener implements SesUiListener {
        public /* synthetic */ SesUiAllListener(BaseSesSessionActivity baseSesSessionActivity, int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.SesUiListener
        public void onConnected() {
            Debugger.m8607d(BaseSesSessionActivity.TAG, "onConnected() start");
            if (BaseSesSessionActivity.this.onSesSessionConnected()) {
                MainLogger.m7258i(BaseSesSessionActivity.this.getTag(), "create Social SessionInstance : onConnected() requestSync ");
                BaseSesSessionActivity.this.requestSync("SesUiAllListener : onConnected");
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.SesUiListener
        public void onDisConnected(int i) {
            if (i == SeMobileServiceSession.ConnectionResultCallback.CAUSE_AGENT_NOT_INSTALLED) {
                MainLogger.m7258i(BaseSesSessionActivity.this.getTag(), "onDisConnected(). Agent is not installed properly.");
            } else if (i == SeMobileServiceSession.ConnectionResultCallback.CAUSE_AGENT_FORCE_UPDATE_REQUIRED) {
                MainLogger.m7258i(BaseSesSessionActivity.this.getTag(), "onDisConnected(). Force update required.");
            }
            AbstractC8014b.m7201c(i, "onDisConnected() reason code : ", BaseSesSessionActivity.this.getTag());
        }

        private SesUiAllListener() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class delayedRequest implements Runnable {
        private final WeakReference<BaseSesSessionActivity> weakReference;

        public delayedRequest(BaseSesSessionActivity baseSesSessionActivity) {
            this.weakReference = new WeakReference<>(baseSesSessionActivity);
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSesSessionActivity baseSesSessionActivity = this.weakReference.get();
            if (baseSesSessionActivity == null || !baseSesSessionActivity.isSesSessionConnected()) {
                return;
            }
            baseSesSessionActivity.onSesSessionConnected();
            if (baseSesSessionActivity.mSesUiAllListener != null) {
                baseSesSessionActivity.mSesUiAllListener.onConnected();
            }
        }
    }

    private boolean checkReadyToUseSharedService() {
        try {
            if (!AbstractC0299q.m605O()) {
                MainLogger.m7258i(getTag(), "checkReadyToUseSharedService# start social sign up.");
                if (this.mIsRequestSocialSignUp) {
                    return false;
                }
                this.mIsRequestSocialSignUp = true;
                Intent intentForSocialSignUp = Build.VERSION.SDK_INT < 29 ? AbstractC0299q.m648s().getIntentForSocialSignUp() : AbstractC0299q.m598H().getIntentForAgreementProcedure();
                Debugger.m8607d(TAG, "getIntentForSocialSignUp() start activity");
                startActivityForResult(intentForSocialSignUp, 8);
                return false;
            }
        } catch (Exception e) {
            MainLogger.m7255e(getTag(), "checkReadyToUseSharedService# Exception : " + e.toString());
        }
        if (DesktopModeCompat.INSTANCE.getInstance().isDexMode(getBaseContext())) {
            Debugger.m8607d(TAG, "reconnectShareContentProvider() start");
            reconnectShareContentProvider();
        }
        return true;
    }

    private void clearListeners() {
        this.mSesUiAllListener = null;
        this.mRequestSyncCallback = null;
    }

    private void createSessionInstance() {
        MainLogger.m7258i(getTag(), "createSessionInstance()");
        this.sessionCount++;
        this.isConnecting = true;
        if (this.mSesUiAllListener == null) {
            this.mSesUiAllListener = new SesUiAllListener(this, 0);
        }
        C6716p.m4809q().m4795b(1, this.mSesUiAllListener);
        MainLogger.m7258i(getTag(), "createSessionInstance() finished");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSesSessionConnected() {
        boolean zM4801j = C6716p.m4809q().m4801j();
        StringBuilder sbM3200j = AbstractC4539a.m3200j("isSesSessionConnected# connected : ", ", isDestroyCalled : ", zM4801j);
        sbM3200j.append(this.isDestroyCalled);
        MainLogger.m7254d(TAG, sbM3200j.toString());
        return zM4801j && !this.isDestroyCalled;
    }

    private void removeSessionInstance() {
        MainLogger.m7258i(getTag(), "removeSessionInstance()");
        this.sessionCount--;
        this.isConnecting = false;
        this.isDestroyCalled = false;
        C6716p.m4809q().m4797d(1, this.mSesUiAllListener);
        this.mDelayedRequest = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSync(final String str) {
        runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.view.BaseSesSessionActivity.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MainLogger.m7254d(BaseSesSessionActivity.TAG, "[CS1] requestSync# caller : " + str);
                    if (BaseSesSessionActivity.this.mRequestSyncCallback == null) {
                        BaseSesSessionActivity baseSesSessionActivity = BaseSesSessionActivity.this;
                        baseSesSessionActivity.mRequestSyncCallback = new RequestSyncCallback(baseSesSessionActivity);
                    }
                    AbstractC0248O.m534h(BaseSesSessionActivity.this.mRequestSyncCallback);
                } catch (Exception e) {
                    AbstractC14516b.m15115c(e, new StringBuilder("[CS1-2] requestSync Exception : "), BaseSesSessionActivity.this.getTag());
                }
            }
        });
    }

    public String getTag() {
        return "BaseSesSessionActivity$";
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        MainLogger.m7254d(TAG, "onActivityResult# requestCode : " + i + ", resultCode : " + i2);
        if (i == 8) {
            this.mIsRequestSocialSignUp = false;
            if (i2 == -1) {
                this.mIsSocialSignUpResultOk = true;
                requestSync("onActivityResult : REQUEST_INTENT_SOCIAL_SIGN_UP");
            } else {
                MainLogger.m7258i(getTag(), "onActivityResult Social sign up fail, app finish");
                setResult(1, null);
                finish();
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        MainLogger.m7258i(getTag(), "onCreate()");
        this.sessionCount = 0;
        super.onCreate(bundle);
        if (C0158a.m407a().m415h()) {
            final String[] storagePermissions = PermissionCompat.getStoragePermissions(4);
            if ((Build.VERSION.SDK_INT > 33 || PermissionHelper.isPermissionGranted(this, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.view.BaseSesSessionActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    PermissionHelper.requestPermissions(BaseSesSessionActivity.this, 203, storagePermissions);
                }
            }, storagePermissions)) && NotesUtils.getPreferenceMDESupported()) {
                createSessionInstance();
            }
            MainLogger.m7258i(getTag(), "onCreate() finished");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MainLogger.m7258i(getTag(), "onDestroy()");
        this.isDestroyCalled = true;
        clearListeners();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 203) {
            if (!PermissionHelper.verifyRequestResult(this, iArr, strArr)) {
                MainLogger.m7258i(getTag(), "onRequestPermissionsResult(). permission is not granted.");
                setResult(1, null);
                finish();
            } else {
                MainLogger.m7258i(getTag(), "onRequestPermissionsResult(). permission is granted.");
                if (NotesUtils.getPreferenceMDESupported()) {
                    createSessionInstance();
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MainLogger.m7258i(getTag(), "onResume() ");
        if (!C0158a.m407a().m415h()) {
            finish();
            return;
        }
        ((C13540g) C13541h.m14287e().f9588a).m14285a();
        if (!isSesSessionConnected()) {
            if (!this.isConnecting) {
                createSessionInstance();
                return;
            }
            if (this.mDelayedRequest == null) {
                this.mDelayedRequest = new delayedRequest(this);
            }
            new Handler(Looper.getMainLooper()).postDelayed(this.mDelayedRequest, 300L);
            return;
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
        MainLogger.m7258i(getTag(), "onResume# checkPermission");
        this.mFinishActivityBySesPermissionError = false;
        PackageManager packageManager = getPackageManager();
        int iCheckPermission = packageManager.checkPermission("android.permission.READ_EXTERNAL_STORAGE", "com.samsung.android.mobileservice");
        int iCheckPermission2 = packageManager.checkPermission("android.permission.READ_CONTACTS", "com.samsung.android.mobileservice");
        if (iCheckPermission == 0 && iCheckPermission2 == 0) {
            requestSync("initConnection : connected, has permission");
        } else if (!this.mIsSocialSignUpResultOk) {
            finish();
        } else {
            this.mIsSocialSignUpResultOk = false;
            requestSync("initConnection : connected, no permission");
        }
    }

    public boolean onSesSessionConnected() {
        MainLogger.m7258i(getTag(), "onSesSessionConnected()");
        this.isConnecting = false;
        this.isDestroyCalled = false;
        return checkReadyToUseSharedService();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        MainLogger.m7258i(getTag(), "onStop() sesSessionCount : " + this.sessionCount);
        if (NotesUtils.getPreferenceMDESupported()) {
            removeSessionInstance();
        }
        super.onStop();
    }

    public void reconnectShareContentProvider() {
    }
}
