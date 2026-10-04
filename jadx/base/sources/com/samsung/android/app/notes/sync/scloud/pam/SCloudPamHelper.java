package com.samsung.android.app.notes.sync.scloud.pam;

import android.content.Context;
import android.os.SystemClock;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.scsp.common.ContextFactory;
import com.samsung.scsp.framework.core.Scsp;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.ScspSuppliers;
import com.samsung.scsp.framework.core.ScspUserAgentFactory;
import com.samsung.scsp.framework.core.ers.ScspErs;
import p001A.AbstractC0000a;
import p044K.C0158a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SCloudPamHelper {
    private static final String TAG = "SCloudPamHelper";
    private static final AccountInfoSupplierImpl mAccountInfoSupplier;
    private static final DeviceIdSupplierImpl mDeviceIdSupplier;
    private static final E2eeInfoSupplierImpl mE2eeInfoSupplier;
    private static final Object mInitialLock;
    private static Boolean mIsInitialized;
    private static Boolean mIsInitializedForAccount;
    private static final PushInfoSupplierImpl mPushInfoSupplier;

    static {
        Boolean bool = Boolean.FALSE;
        mIsInitialized = bool;
        mIsInitializedForAccount = bool;
        mInitialLock = new Object();
        mAccountInfoSupplier = new AccountInfoSupplierImpl();
        mPushInfoSupplier = new PushInfoSupplierImpl();
        mDeviceIdSupplier = new DeviceIdSupplierImpl();
        mE2eeInfoSupplier = new E2eeInfoSupplierImpl();
    }

    public static String getBaseUrlOfPath() {
        if (!mIsInitialized.booleanValue() && !mIsInitializedForAccount.booleanValue()) {
            initialize();
        }
        return ScspErs.getDomain().defaultUrl;
    }

    public static String getToken() {
        String token;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            token = Scsp.getToken();
        } catch (ScspException e) {
            if (e.rcode == 80000000) {
                Debugger.m8609e(TAG, "[PAM] getToken() : Bad implementation");
            } else if (e.rcode >= 500000000) {
                Debugger.m8609e(TAG, "[PAM] getToken() : Server error!");
            } else {
                Debugger.m8609e(TAG, "[PAM] getToken() : Unknown error!");
            }
            token = null;
        }
        Debugger.m8615i(TAG, "[PAM] getToken() : et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        return token;
    }

    public static String getUserAgent() {
        if (!mIsInitialized.booleanValue() && !mIsInitializedForAccount.booleanValue()) {
            initialize();
        }
        return ScspUserAgentFactory.get();
    }

    public static void handleExpiredCloudToken() {
        Debugger.m8615i(TAG, "[PAM] handleExpiredCloudToken()");
        mAccountInfoSupplier.requestAccessTokenWithExpiredTokenToSamsungAccount();
    }

    public static void handleExpiredSAToken() {
        Debugger.m8615i(TAG, "[PAM] handleExpiredSAToken()");
        mAccountInfoSupplier.requestAccessTokenWithExpiredTokenToSamsungAccount();
    }

    public static boolean initialize() {
        synchronized (mInitialLock) {
            try {
            } catch (Throwable th) {
                Debugger.m8609e(TAG, "[PAM] initialize() : fail to initialize, " + th);
            }
            if (BaseUtils.getApplicationContext() == null) {
                Debugger.m8609e(TAG, "[PAM] initialize() : appContext is null!");
                return false;
            }
            Scsp.setUp(BaseUtils.getApplicationContext(), CommonUtils.getAppServiceId(), null);
            mIsInitialized = Boolean.TRUE;
            Debugger.m8615i(TAG, "[PAM] initialize() : initialized!");
            return true;
        }
    }

    public static boolean initializeForAccount(String str, String str2) {
        synchronized (mInitialLock) {
            try {
                if (mIsInitializedForAccount.booleanValue()) {
                    Debugger.m8607d(TAG, "[PAM] initializeForAccount() : already initialized!");
                    return mIsInitializedForAccount.booleanValue();
                }
                Context applicationContext = BaseUtils.getApplicationContext();
                if (applicationContext == null) {
                    Debugger.m8609e(TAG, "[PAM] initializeForAccount() : appContext is null!");
                    return false;
                }
                Debugger.m8615i(TAG, "[PAM] initializeForAccount()");
                AccountInfoSupplierImpl accountInfoSupplierImpl = mAccountInfoSupplier;
                accountInfoSupplierImpl.setAccountInfo(str, str2);
                ContextFactory.attachApplicationContext(applicationContext);
                C0158a.m407a().getClass();
                try {
                    Scsp.setUp(applicationContext, CommonUtils.getAppServiceId(), new ScspSuppliers.Builder().with(accountInfoSupplierImpl).with(mPushInfoSupplier).with(mE2eeInfoSupplier).build());
                    mIsInitializedForAccount = Boolean.TRUE;
                    Debugger.m8615i(TAG, "[PAM] initializeForAccount() : initialized!");
                } catch (Throwable th) {
                    Debugger.m8609e(TAG, "[PAM] initializeForAccount() : fail to initialize, " + th);
                }
                return mIsInitializedForAccount.booleanValue();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean isInitializedForAccount() {
        return mIsInitializedForAccount.booleanValue();
    }

    public static void signIn() {
        if (mIsInitialized.booleanValue()) {
            mIsInitialized = Boolean.FALSE;
        }
        if (mIsInitializedForAccount.booleanValue()) {
            mIsInitializedForAccount = Boolean.FALSE;
        }
    }

    public static void signOut(Context context) {
        if (mIsInitialized.booleanValue() || mIsInitializedForAccount.booleanValue()) {
            try {
                Scsp.signOut(context);
            } catch (Throwable th) {
                Debugger.m8609e(TAG, "[PAM] signOut() : Throwable = " + th);
            }
            Boolean bool = Boolean.FALSE;
            mIsInitialized = bool;
            mIsInitializedForAccount = bool;
        }
    }

    public static void updateAccountInfo(String str, String str2) {
        Debugger.m8615i(TAG, "[PAM] updateAccountInfoAsync() : call update()");
        mAccountInfoSupplier.setAccountInfo(str, str2);
        try {
            Scsp.refreshToken();
        } catch (Exception e) {
            AbstractC0000a.m22s("[PAM] updateAccountInfo() : Exception = ", e, TAG);
        }
    }

    public static boolean updatePushInfoSync() {
        Debugger.m8615i(TAG, "[PAM] updatePushInfoSync()");
        try {
            mPushInfoSupplier.update();
            Debugger.m8615i(TAG, "[PAM] updatePushInfoSync() : succeed");
            return true;
        } catch (Exception e) {
            Debugger.m8609e(TAG, "[PAM] updatePushInfoSync() : Exception = " + e);
            Debugger.m8609e(TAG, "[PAM] updatePushInfoSync() : fail!");
            return false;
        }
    }
}
