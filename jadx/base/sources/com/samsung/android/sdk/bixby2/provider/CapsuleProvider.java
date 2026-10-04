package com.samsung.android.sdk.bixby2.provider;

import android.app.PendingIntent;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.bixby2.Constants;
import com.samsung.android.sdk.bixby2.LogUtil;
import com.samsung.android.sdk.bixby2.PermissionType;
import com.samsung.android.sdk.bixby2.Sbixby;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.bixby2.action.ResponseCallback;
import com.samsung.android.sdk.bixby2.data.CapsuleAction;
import com.samsung.android.sdk.bixby2.labs.ScreenLayoutHandler;
import com.samsung.android.sdk.bixby2.labs.UserGuideHandler;
import com.samsung.android.sdk.bixby2.receiver.ApplicationTriggerReceiver;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sdk.bixby2.util.BixbySignatureChecker;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CapsuleProvider extends ContentProvider {
    private static final String ACTION_APPLICATION_TRIGGER = "com.samsung.android.sdk.bixby2.ACTION_APPLICATION_TRIGGER";
    private static final int ACTION_EXECUTION_FAILURE = -1;
    private static final int ACTION_EXECUTION_SUCCESS = 0;
    private static final int ACTION_EXECUTION_TIMEOUT = 30000;
    private static final int ACTION_NOT_ALLOWED = -3;
    private static final int ACTION_NOT_IMPLEMENTED = -2;
    private static final String APP_CONTENT = "result";
    private static final String PENDING_INTENT = "pending_intent";
    private static final String STATUS_CODE = "status_code";
    private static final String STATUS_MESSAGE = "status_message";
    private static final String TAG = "CapsuleProvider_1.1.0";
    private static final int WAIT_FOR_HANDLER_TIMEOUT = 3000;
    private final Object sActionExecutionLock = new Object();
    private static final boolean mIsUserBuild = IdentityApiContract.Token.USER.equals(Build.TYPE);
    private static final Map<String, CapsuleAction> actionMap = new HashMap();
    private static boolean mIsAppInitialized = false;
    private static boolean mWaitForHandler = false;
    private static final Object sWaitLock = new Object();
    private static String mActionId = null;

    public static void addActionHandler(String str, ActionHandler actionHandler, Boolean bool) {
        Object obj = sWaitLock;
        synchronized (obj) {
            try {
                Map<String, CapsuleAction> map = actionMap;
                if (map.get(str) == null) {
                    map.put(str, new CapsuleAction(actionHandler, bool.booleanValue()));
                    String str2 = mActionId;
                    if (str2 != null && str2.equals(str)) {
                        LogUtil.m5747i(TAG, "handler added: " + str);
                        obj.notify();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private synchronized Bundle executeAction(PermissionType permissionType, final String str, final Bundle bundle) throws Throwable {
        Throwable th;
        Exception exc;
        String str2;
        final CapsuleAction capsuleAction;
        try {
            try {
                str2 = TAG;
                LogUtil.m5747i(str2, "executeAction()");
                capsuleAction = getCapsuleAction(str);
            } catch (Throwable th2) {
                th = th2;
                th = th;
                throw th;
            }
        } catch (Exception e) {
            e = e;
        } catch (Throwable th3) {
            th = th3;
            th = th;
            throw th;
        }
        try {
            if (capsuleAction == null) {
                LogUtil.m5746e(str2, "Handler not found!!..");
                return updateStatus(-2, "Action handler not found");
            }
            if (permissionType == PermissionType.EXPORTED_ACTION_ALLOWED && !capsuleAction.isExported()) {
                LogUtil.m5746e(str2, "Handler is not allowed..");
                return updateStatus(-3, "Action handler is not allowed");
            }
            try {
                if (bundle == null || !bundle.containsKey("actionType")) {
                    LogUtil.m5746e(str2, "params missing");
                    return updateStatus(-1, "params missing..");
                }
                final CapsuleResponseCallback capsuleResponseCallback = new CapsuleResponseCallback();
                Thread thread = new Thread(new Runnable() { // from class: com.samsung.android.sdk.bixby2.provider.CapsuleProvider.2
                    @Override // java.lang.Runnable
                    public void run() {
                        capsuleAction.getActionHandler().executeAction(CapsuleProvider.this.getContext(), str, bundle, capsuleResponseCallback);
                    }
                });
                thread.start();
                synchronized (this.sActionExecutionLock) {
                    try {
                        if (!capsuleResponseCallback.actionExecuted) {
                            this.sActionExecutionLock.wait(30000L);
                        }
                        if (capsuleResponseCallback.actionExecuted) {
                            Bundle resultBundle = capsuleResponseCallback.getResultBundle();
                            if (resultBundle != null) {
                                return resultBundle;
                            }
                        } else {
                            LogUtil.m5746e(str2, "timeout occurred..");
                            capsuleResponseCallback.setActionTimedOut(true);
                            thread.interrupt();
                        }
                        return updateStatus(-1, "action execution timed out");
                    } finally {
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            exc = e3;
        } catch (Throwable th4) {
            th = th4;
            throw th;
        }
        exc = e;
        LogUtil.m5746e(TAG, "Unable to execute action." + exc);
        exc.printStackTrace();
        return updateStatus(-1, exc.toString());
    }

    private void executeProcessTriggerReceiver() {
        if (getContext() != null) {
            ApplicationTriggerReceiver applicationTriggerReceiver = new ApplicationTriggerReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ACTION_APPLICATION_TRIGGER);
            if (Build.VERSION.SDK_INT < 34 || getContext().getApplicationInfo().targetSdkVersion < 34) {
                getContext().registerReceiver(applicationTriggerReceiver, intentFilter);
            } else {
                getContext().registerReceiver(applicationTriggerReceiver, intentFilter, 4);
            }
            LogUtil.m5747i(TAG, "ApplicationTriggerReceiver registered");
            Intent intent = new Intent();
            intent.setPackage(getContext().getPackageName());
            intent.setAction(ACTION_APPLICATION_TRIGGER);
            intent.addFlags(268435456);
            getContext().sendBroadcast(intent);
        }
    }

    private CapsuleAction getCapsuleAction(String str) {
        Map<String, CapsuleAction> map = actionMap;
        CapsuleAction capsuleAction = map.get(str);
        Object obj = sWaitLock;
        synchronized (obj) {
            if (capsuleAction == null) {
                try {
                    if (mWaitForHandler) {
                        mActionId = str;
                        obj.wait(AiSTTListView.USER_SCROLL_INTERVAL);
                        capsuleAction = map.get(str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return capsuleAction;
    }

    private boolean isAllowedSignature(PackageManager packageManager, String str) {
        try {
            return isBixbySignature(packageManager.getPackageInfo(str, 64).signatures);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isBixbySignature(Signature[] signatureArr) {
        return signatureArr != null && signatureArr.length > 0 && (BixbySignatureChecker.isBixbyAgentSignature(signatureArr[0]) || BixbySignatureChecker.isBixbyAgentSignatureForIot(signatureArr[0]));
    }

    private PermissionType isCallerAllowed() {
        int callingUid = Binder.getCallingUid();
        PackageManager packageManager = getContext().getPackageManager();
        String[] packagesForUid = packageManager.getPackagesForUid(callingUid);
        if (packagesForUid == null) {
            LogUtil.m5746e(TAG, "packages is null");
            return PermissionType.DENIED;
        }
        for (String str : packagesForUid) {
            if (Constants.BIXBY_AGENT_PKG_NAME.equals(str) || Constants.ROUTINE_PKG_NAME.equals(str)) {
                if (!mIsUserBuild || isAllowedSignature(packageManager, str)) {
                    return PermissionType.ALLOWED;
                }
            } else if (Constants.LINK_TO_WINDOWS_PKG_NAME.equals(str)) {
                if (!mIsUserBuild || isAllowedSignature(packageManager, str)) {
                    return PermissionType.EXPORTED_ACTION_ALLOWED;
                }
            } else if (Constants.ACTION_URI_TESTER_PKG_NAME.equals(str) && !mIsUserBuild) {
                return PermissionType.ALLOWED;
            }
        }
        LogUtil.m5746e(TAG, "Not allowed to access capsule provider. package (s): " + Arrays.toString(packagesForUid));
        return PermissionType.DENIED;
    }

    public static void removeActionHandler(String str) {
        Map<String, CapsuleAction> map = actionMap;
        if (map.containsKey(str)) {
            map.remove(str);
            LogUtil.m5745d(TAG, "action handler corresponding to action : " + str + " is removed");
        }
    }

    public static void removeAllActionHandlers() {
        actionMap.clear();
        LogUtil.m5747i(TAG, "Removed all action handlers");
    }

    public static void setAppInitialized(boolean z) {
        Object obj = sWaitLock;
        synchronized (obj) {
            try {
                if (!mIsAppInitialized && z) {
                    mIsAppInitialized = z;
                    LogUtil.m5747i(TAG, "releasing initialize wait lock.");
                    obj.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        new Timer().schedule(new TimerTask() { // from class: com.samsung.android.sdk.bixby2.provider.CapsuleProvider.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                boolean unused = CapsuleProvider.mWaitForHandler = false;
            }
        }, AiSTTListView.USER_SCROLL_INTERVAL);
    }

    private Bundle updateStatus(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("status_code", i);
        if (TextUtils.isEmpty(str) && i == -1) {
            str = "Failed to execute action.";
            LogUtil.m5746e(TAG, "Failed to execute action.");
        }
        bundle.putString("status_message", str);
        return bundle;
    }

    private void waitForAppInitialization() {
        Object obj = sWaitLock;
        synchronized (obj) {
            if (!mIsAppInitialized) {
                try {
                    obj.wait(5000L);
                } catch (InterruptedException e) {
                    LogUtil.m5746e(TAG, "interrupted exception");
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        String str3 = TAG;
        LogUtil.m5747i(str3, "call()");
        StringBuilder sb = new StringBuilder("call(): method --> ");
        sb.append(str);
        sb.append(" args --> ");
        sb.append(str2);
        sb.append(" extras --> ");
        sb.append(bundle != null ? bundle.toString() : null);
        LogUtil.m5745d(str3, sb.toString());
        PermissionType permissionTypeIsCallerAllowed = isCallerAllowed();
        if (permissionTypeIsCallerAllowed == PermissionType.DENIED) {
            throw new SecurityException("not permission to access capsule provider.");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("method is null or empty. pass valid action name.");
        }
        if (!mIsAppInitialized) {
            executeProcessTriggerReceiver();
        }
        waitForAppInitialization();
        if (!mIsAppInitialized) {
            LogUtil.m5746e(str3, "App initialization error.");
            return updateStatus(-1, "Initialization Failure..");
        }
        if (bundle != null) {
            LogUtil.setEngineeringMode(bundle.getBoolean(LogUtil.KEY_ENGINEERING_MODE, false));
        }
        if (str.equals(StateHandler.ACTION_GET_APP_STATE)) {
            Sbixby.getInstance();
            String appState = Sbixby.getStateHandler().getAppState(getContext(), bundle);
            if (appState != null) {
                return AbstractC2821a.m2215f(StateHandler.KEY_APP_STATE, appState);
            }
            return null;
        }
        if (str.equals(ScreenLayoutHandler.ACTION_GET_SCREEN_LAYOUT)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(ScreenLayoutHandler.KEY_SCREEN_LAYOUT_INFO, ScreenLayoutHandler.INSTANCE.getScreenLayout(bundle));
            return bundle2;
        }
        if (str.equals(UserGuideHandler.ACTION_GET_USER_GUIDE)) {
            Bundle bundle3 = new Bundle();
            bundle3.putString(UserGuideHandler.KEY_USER_GUIDE_DATA, UserGuideHandler.INSTANCE.getUserGuide(getContext(), bundle));
            return bundle3;
        }
        if (bundle != null) {
            return executeAction(permissionTypeIsCallerAllowed, str, bundle);
        }
        throw new IllegalArgumentException("action params are EMPTY.");
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(@NonNull Uri uri) {
        return "actionUri";
    }

    @Override // android.content.ContentProvider
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        LogUtil.m5747i(TAG, "onCreate");
        mWaitForHandler = true;
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CapsuleResponseCallback implements ResponseCallback {
        private final Bundle resultBundle = new Bundle();
        private boolean actionExecuted = false;
        private boolean actionTimedOut = false;

        public CapsuleResponseCallback() {
        }

        public Bundle getResultBundle() {
            return this.resultBundle;
        }

        @Override // com.samsung.android.sdk.bixby2.action.ResponseCallback
        public void onComplete(String str) {
            LogUtil.m5747i(CapsuleProvider.TAG, "onComplete()");
            synchronized (CapsuleProvider.this.sActionExecutionLock) {
                try {
                    if (this.actionTimedOut) {
                        return;
                    }
                    if (!this.actionExecuted) {
                        LogUtil.m5747i(CapsuleProvider.TAG, "Action Execution Success");
                        this.resultBundle.putInt("status_code", 0);
                        this.resultBundle.putString("result", str);
                        LogUtil.m5745d(CapsuleProvider.TAG, "action result: " + str);
                        this.actionExecuted = true;
                        CapsuleProvider.this.sActionExecutionLock.notify();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void setActionTimedOut(boolean z) {
            this.actionTimedOut = z;
        }

        @Override // com.samsung.android.sdk.bixby2.action.ResponseCallback
        public void onComplete(String str, PendingIntent pendingIntent) {
            synchronized (CapsuleProvider.this.sActionExecutionLock) {
                try {
                    if (this.actionTimedOut) {
                        return;
                    }
                    if (!this.actionExecuted) {
                        this.resultBundle.putParcelable("pending_intent", pendingIntent);
                        LogUtil.m5747i(CapsuleProvider.TAG, "action result: pending intent");
                    }
                    onComplete(str);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
