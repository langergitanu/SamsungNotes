package com.samsung.android.app.notes.sync.saccount.samsungaccountclient;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.msc.p133sa.aidl.ISACallback;
import com.msc.p133sa.aidl.ISAService;
import com.samsung.android.app.notes.sync.saccount.SAccountException;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.service.C6888c;
import com.samsung.android.sdk.mobileservice.auth.AuthConstants;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.support.senl.p145cm.base.common.util.HashUtils;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.context.sdk.samsunganalytics.LogBuilders;
import java.util.ArrayList;
import java.util.Iterator;
import p001A.AbstractC0000a;
import p207n1.C13534a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6875b {

    /* JADX INFO: renamed from: u */
    public static C6875b f4372u;

    /* JADX INFO: renamed from: v */
    public static Context f4373v;

    /* JADX INFO: renamed from: w */
    public static String f4374w;

    /* JADX INFO: renamed from: a */
    public ISAService f4375a;

    /* JADX INFO: renamed from: b */
    public Boolean f4376b;

    /* JADX INFO: renamed from: c */
    public Boolean f4377c;

    /* JADX INFO: renamed from: d */
    public String f4378d;

    /* JADX INFO: renamed from: e */
    public String f4379e;

    /* JADX INFO: renamed from: f */
    public String f4380f;

    /* JADX INFO: renamed from: g */
    public String f4381g;

    /* JADX INFO: renamed from: h */
    public String f4382h;

    /* JADX INFO: renamed from: i */
    public String f4383i;

    /* JADX INFO: renamed from: j */
    public String f4384j;

    /* JADX INFO: renamed from: k */
    public boolean f4385k;

    /* JADX INFO: renamed from: l */
    public boolean f4386l;

    /* JADX INFO: renamed from: m */
    public long f4387m;

    /* JADX INFO: renamed from: n */
    public long f4388n;

    /* JADX INFO: renamed from: o */
    public final ArrayList f4389o;

    /* JADX INFO: renamed from: p */
    public final String f4390p;

    /* JADX INFO: renamed from: q */
    public final String f4391q;

    /* JADX INFO: renamed from: r */
    public final SharedPreferences f4392r;

    /* JADX INFO: renamed from: s */
    public final SharedPreferences f4393s;

    /* JADX INFO: renamed from: t */
    public final ISACallback.Stub f4394t;

    public C6875b() {
        Boolean bool = Boolean.FALSE;
        this.f4376b = bool;
        this.f4377c = bool;
        this.f4389o = new ArrayList();
        this.f4394t = new ISACallback.Stub() { // from class: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.AuthApi$1
            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveAccessToken(int i, boolean z, Bundle bundle) {
                String string;
                String string2;
                C13534a c13534a;
                C6875b c6875b = this.this$0;
                c6875b.getClass();
                if (z) {
                    c6875b.f4378d = bundle.getString("access_token");
                    Debugger.m8615i("AuthApi", "[SA] getAuthInfoItem : userId = " + UserHandleCompat.getInstance().getUserId(0) + ", AccessToken received, " + Debugger.pii(c6875b.f4378d));
                    c6875b.f4380f = bundle.getString(SearchIndexablesContract.RawData.COLUMN_USER_ID);
                    c6875b.f4383i = bundle.getString(LogBuilders.Property.COUNTRY_CODE);
                    Debugger.m8615i("AuthApi", "[SA] getAuthInfoItem : mCc = " + c6875b.f4383i);
                    if (bundle.containsKey(AuthConstants.EXTRA_API_SERVER_URL)) {
                        c6875b.f4381g = bundle.getString(AuthConstants.EXTRA_API_SERVER_URL);
                    }
                    if (bundle.containsKey(AuthConstants.EXTRA_AUTH_SERVER_URL)) {
                        c6875b.f4382h = bundle.getString(AuthConstants.EXTRA_AUTH_SERVER_URL);
                    }
                    if (bundle.containsKey("is_child_account")) {
                        c6875b.f4385k = bundle.getBoolean("is_child_account");
                        Debugger.m8615i("AuthApi", "[SA] getAuthInfoItem : mIsChildAccount = " + c6875b.f4385k);
                    }
                    if (bundle.containsKey("region_mcc")) {
                        c6875b.f4384j = bundle.getString("region_mcc");
                        Debugger.m8615i("AuthApi", "[SA] getAuthInfoItem : mRegionMcc = " + c6875b.f4384j);
                    }
                    if (bundle.containsKey(ComposerConstants.ARG_MDE_ACCOUNT_TYPE)) {
                        c6875b.f4386l = "b2b".equals(bundle.getString(ComposerConstants.ARG_MDE_ACCOUNT_TYPE));
                        Debugger.m8615i("AuthApi", "[SA] getAuthInfoItem : mIsB2BAccount = " + c6875b.f4386l);
                    } else {
                        c6875b.f4386l = false;
                        Debugger.m8615i("AuthApi", "[SA] getAuthInfoItem : No account_type");
                    }
                    if (bundle.containsKey("token_issue_time")) {
                        c6875b.f4387m = bundle.getLong("token_issue_time");
                        Debugger.m8615i("AuthApi", "[SA] getAuthInfoItem : IssueTime = " + c6875b.f4387m);
                    }
                    if (bundle.containsKey("token_expires_in")) {
                        c6875b.f4388n = bundle.getLong("token_expires_in");
                        Debugger.m8615i("AuthApi", "[SA] getAuthInfoItem : ExpiresIn = " + c6875b.f4388n);
                    }
                    String str = c6875b.f4378d;
                    String str2 = c6875b.f4380f;
                    c13534a = new C13534a();
                    c13534a.f9556a = str;
                    c13534a.f9557b = str2;
                    c6875b.f4377c = Boolean.FALSE;
                } else {
                    Debugger.m8609e("AuthApi", "[SA] getAuthInfoItem() : Fail to get AccessToken");
                    c6875b.m5064b();
                    if (bundle != null) {
                        string = bundle.getString("error_code");
                        if (TextUtils.isEmpty(string)) {
                            string = "unknown_code";
                        }
                        string2 = bundle.getString("error_message");
                        if (TextUtils.isEmpty(string2)) {
                            string2 = "unknown_message";
                        }
                        if (ErrorCodeConvertor.AUTH_TOKEN_EXPIRED.equals(string)) {
                            c6875b.f4377c = Boolean.TRUE;
                        }
                    } else {
                        Debugger.m8609e("AuthApi", "[SA] getAuthInfoItem() : No resultData!");
                        string = ComposerSAConstants.SCREEN_VIEW_303;
                        string2 = "Unknown";
                    }
                    C13534a c13534a2 = new C13534a(string);
                    c13534a2.f9560e = string2;
                    c13534a = c13534a2;
                }
                if (!c13534a.f9558c) {
                    if (this.this$0.f4376b.booleanValue()) {
                        C6875b c6875b2 = this.this$0;
                        c6875b2.getClass();
                        c6875b2.m5067f(System.currentTimeMillis());
                        c6875b2.f4376b = Boolean.FALSE;
                    }
                    C6875b c6875b3 = this.this$0;
                    c6875b3.m5068g(c6875b3.f4380f);
                }
                this.this$0.m5065d(c13534a);
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveAuthCode(int i, boolean z, Bundle bundle) {
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveChecklistValidation(int i, boolean z, Bundle bundle) {
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveClearConsentData(int i, boolean z, Bundle bundle) {
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveDisclaimerAgreement(int i, boolean z, Bundle bundle) {
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceivePasswordConfirmation(int i, boolean z, Bundle bundle) {
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveRLControlFMM(int i, boolean z, Bundle bundle) {
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveRequiredConsent(int i, boolean z, Bundle bundle) {
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveRubinRequest(int i, boolean z, Bundle bundle) {
            }

            @Override // com.msc.p133sa.aidl.ISACallback
            public void onReceiveSCloudAccessToken(int i, boolean z, Bundle bundle) {
            }
        };
        if (f4373v == null) {
            f4373v = BaseUtils.getApplicationContext();
        }
        if (SyncState.isCmsTest()) {
            this.f4390p = CommonUtils.getAppServiceIdForStageAccount();
        } else {
            this.f4390p = CommonUtils.getAppServiceId();
        }
        this.f4391q = f4373v.getPackageName();
        this.f4392r = f4373v.getSharedPreferences("AuthInfo", 0);
        this.f4393s = f4373v.getSharedPreferences("LoginInfo", 0);
        m5064b();
    }

    /* JADX INFO: renamed from: c */
    public static synchronized C6875b m5062c() {
        try {
            if (f4372u == null) {
                f4372u = new C6875b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4372u;
    }

    /* JADX INFO: renamed from: a */
    public final void m5063a(InterfaceC6874a interfaceC6874a) {
        Debugger.m8615i("AuthApi", "[SA] cancel()");
        synchronized (this.f4389o) {
            try {
                this.f4389o.remove(interfaceC6874a);
                if (this.f4389o.isEmpty()) {
                    m5069h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m5064b() {
        this.f4378d = null;
        this.f4380f = null;
        this.f4381g = null;
        this.f4382h = null;
        this.f4383i = null;
        this.f4385k = false;
        m5067f(0L);
        this.f4377c = Boolean.FALSE;
        this.f4387m = 0L;
        this.f4388n = 0L;
    }

    /* JADX INFO: renamed from: d */
    public final void m5065d(C13534a c13534a) {
        m5069h();
        synchronized (this.f4389o) {
            try {
                Iterator it = this.f4389o.iterator();
                while (it.hasNext()) {
                    ((InterfaceC6874a) it.next()).mo5061a(c13534a);
                }
                this.f4389o.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0154  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5066e(InterfaceC6874a interfaceC6874a) {
        AccountManager accountManager;
        Debugger.m8615i("AuthApi", "[SA] requestAuthInfo()");
        synchronized (this.f4389o) {
            try {
                Iterator it = this.f4389o.iterator();
                while (it.hasNext()) {
                    if (((InterfaceC6874a) it.next()).equals(interfaceC6874a)) {
                        return;
                    }
                }
                this.f4389o.add(interfaceC6874a);
                Debugger.m8615i("AuthApi", "[SA] requestAuthInfo listener - size : " + this.f4389o.size());
                this.f4375a = C6888c.m5085a().f4433f;
                m5069h();
                ISACallback.Stub stub = this.f4394t;
                String str = this.f4391q;
                String str2 = this.f4390p;
                Debugger.m8615i("AuthApi", "[SA] registerCallback()");
                ISAService iSAService = this.f4375a;
                Account account = null;
                if (iSAService != null) {
                    try {
                        String strRegisterCallback = iSAService.registerCallback(str2, null, str, stub);
                        f4374w = strRegisterCallback;
                        if (strRegisterCallback == null) {
                            Debugger.m8615i("AuthApi", "[SA] registerCallback() : mRegistrationCode is null and try again!");
                            f4374w = this.f4375a.registerCallback(str2, null, str, stub);
                        }
                    } catch (Exception e) {
                        AbstractC0000a.m22s("[SA] registerCallback() : ", e, "AuthApi");
                    }
                } else {
                    Debugger.m8609e("AuthApi", "[SA] registerCallback() : mISaService is null");
                }
                if (f4374w == null) {
                    throw new SAccountException(PerfConstants.ScenarioConstants.SCENARIO_GENERATE_AT_POP_ASYMMETRIC_KEYPAIR, "fail to registerCallback!");
                }
                try {
                    accountManager = AccountManager.get(f4373v);
                } catch (Exception e2) {
                    AbstractC0000a.m22s("[SA] getSamsungAccount() : ", e2, "SamsungAccountClientUtil");
                    accountManager = null;
                }
                boolean zRequestAccessToken = false;
                if (accountManager == null) {
                    Debugger.m8615i("SamsungAccountClientUtil", "[SA] getSamsungAccount() : manager is null. please check the APK signing!");
                } else {
                    Account[] accountsByType = accountManager.getAccountsByType("com.osp.app.signin");
                    if (accountsByType.length > 0) {
                        account = accountsByType[0];
                    }
                }
                if (account == null) {
                    throw new SAccountException("101", "Not logged In!");
                }
                if (this.f4375a == null) {
                    Debugger.m8609e("AuthApi", "request() : consentService is null!");
                    C13534a c13534a = new C13534a("401");
                    c13534a.f9560e = "fail to requestAccessToken <- mISaService is null";
                    m5065d(c13534a);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("additional", new String[]{SearchIndexablesContract.RawData.COLUMN_USER_ID, "server_url", AuthConstants.EXTRA_AUTH_SERVER_URL, AuthConstants.EXTRA_API_SERVER_URL, "login_id", "mcc", LogBuilders.Property.COUNTRY_CODE, "is_child_account", "region_mcc", "token_issue_time", "token_expires_in", ComposerConstants.ARG_MDE_ACCOUNT_TYPE});
                if (!SyncState.isCmsTest()) {
                    bundle.putString("scope", "galaxystore.openapi");
                }
                if (!this.f4376b.booleanValue()) {
                    long j = this.f4392r.getLong("ExpiredTokenRequestTime", 0L);
                    if (j == 0) {
                        Debugger.m8615i("AuthApi", "[SA] isAccessTokenRefreshTime() : expiredTokenRequestTime was reset!");
                        this.f4376b = Boolean.TRUE;
                    } else {
                        long jCurrentTimeMillis = System.currentTimeMillis() - j;
                        if (jCurrentTimeMillis > 82800000) {
                            Debugger.m8615i("AuthApi", "[SA] isAccessTokenRefreshTime() : expired, et = " + jCurrentTimeMillis);
                            this.f4376b = Boolean.TRUE;
                        } else {
                            Debugger.m8615i("AuthApi", "[SA] request : cached access token");
                        }
                    }
                    if (TextUtils.isEmpty(this.f4378d)) {
                        bundle.putString("expired_access_token", this.f4378d);
                        Debugger.m8615i("AuthApi", "[SA] request : expired access token = mAccessToken");
                    } else if (TextUtils.isEmpty(this.f4379e)) {
                        bundle.putString("expired_access_token", "");
                        Debugger.m8615i("AuthApi", "[SA] request : expired access token = empty");
                    } else {
                        bundle.putString("expired_access_token", this.f4379e);
                        Debugger.m8615i("AuthApi", "[SA] request : expired access token = mPrvAccessToken");
                    }
                } else if (TextUtils.isEmpty(this.f4378d)) {
                }
                try {
                    zRequestAccessToken = this.f4375a.requestAccessToken(1001, f4374w, bundle);
                } catch (Exception e3) {
                    AbstractC0000a.m22s("request() : fail to requestRequiredConsent, ", e3, "AuthApi");
                }
                if (zRequestAccessToken) {
                    return;
                }
                C13534a c13534a2 = new C13534a("401");
                c13534a2.f9560e = "fail to requestAccessToken!";
                m5065d(c13534a2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m5067f(long j) {
        SharedPreferences sharedPreferences = this.f4392r;
        if (sharedPreferences == null) {
            Debugger.m8609e("AuthApi", "[SA] setExpiredTokenRequestTime() : mPreferences is null!");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putLong("ExpiredTokenRequestTime", j);
        editorEdit.apply();
        Debugger.m8615i("AuthApi", "[SA] setExpiredTokenRequestTime() : update the request time = " + j);
    }

    /* JADX INFO: renamed from: g */
    public final void m5068g(String str) {
        SharedPreferences.Editor editorEdit = this.f4393s.edit();
        if (TextUtils.isEmpty(str)) {
            Debugger.m8615i("AuthApi", "[SA] setUidHash : Null");
            editorEdit.putString("UidHash", null);
        } else {
            Debugger.m8615i("AuthApi", "[SA] setUidHash : XXX");
            editorEdit.putString("UidHash", HashUtils.generateSha256(str));
        }
        editorEdit.apply();
    }

    /* JADX INFO: renamed from: h */
    public final void m5069h() {
        Debugger.m8615i("AuthApi", "[SA] unregisterCallback()");
        String str = f4374w;
        if (str != null) {
            try {
                ISAService iSAService = this.f4375a;
                if (iSAService != null) {
                    iSAService.unregisterCallback(str);
                }
            } catch (Exception e) {
                AbstractC0000a.m22s("[SA] unregisterCallback() : fail to unregister = ", e, "AuthApi");
            }
            f4374w = null;
        }
    }
}
