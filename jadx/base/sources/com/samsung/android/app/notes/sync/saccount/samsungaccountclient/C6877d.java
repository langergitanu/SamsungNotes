package com.samsung.android.app.notes.sync.saccount.samsungaccountclient;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.msc.p133sa.aidl.ISACallback;
import com.msc.p133sa.aidl.ISAService;
import com.samsung.android.app.notes.sync.saccount.SAccountException;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.service.C6888c;
import com.samsung.android.sdk.mobileservice.social.buddy.provider.BuddyContract;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.ResultConsentData;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.StickyMemoSAConstants;
import java.util.concurrent.CompletableFuture;
import p001A.AbstractC0000a;
import p207n1.C13537d;
import p212o1.C13573a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6877d {

    /* JADX INFO: renamed from: h */
    public static C6877d f4396h;

    /* JADX INFO: renamed from: a */
    public final Context f4397a;

    /* JADX INFO: renamed from: b */
    public ISAService f4398b;

    /* JADX INFO: renamed from: c */
    public C13573a f4399c;

    /* JADX INFO: renamed from: d */
    public String f4400d;

    /* JADX INFO: renamed from: e */
    public final String f4401e;

    /* JADX INFO: renamed from: f */
    public final String f4402f;

    /* JADX INFO: renamed from: g */
    public final ISACallback.Stub f4403g = new ISACallback.Stub() { // from class: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.RequestRequiredConsentApi$1
        @Override // com.msc.p133sa.aidl.ISACallback
        public void onReceiveAccessToken(int i, boolean z, Bundle bundle) {
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
            String string;
            String string2;
            ResultConsentData resultConsentData;
            String string3;
            this.this$0.getClass();
            if (z) {
                if (bundle.containsKey("consent_list")) {
                    Debugger.m8615i("RequestRequiredConsentApi", "[SA] getResultConsentData() : Consent received and has the key");
                    string3 = bundle.getString("consent_list");
                } else {
                    string3 = null;
                }
                Debugger.m8615i("RequestRequiredConsentApi", "[SA] getResultConsentData() : Consent received, isEmpty = " + TextUtils.isEmpty(string3));
                resultConsentData = new ResultConsentData(string3);
                if (!resultConsentData.parse()) {
                    resultConsentData = new ResultConsentData(StickyMemoSAConstants.EVENT_MEMO_OPEN, "Unknown");
                }
            } else {
                Debugger.m8615i("RequestRequiredConsentApi", "[SA] getResultConsentData() : Fail to get Consent");
                if (bundle != null) {
                    string2 = bundle.getString("error_code");
                    string = bundle.getString("error_message");
                } else {
                    Debugger.m8609e("RequestRequiredConsentApi", "[SA] getResultConsentData() : No resultData!");
                    string = "Unknown";
                    string2 = "403";
                }
                resultConsentData = new ResultConsentData(string2, string);
            }
            this.this$0.m5072b(resultConsentData);
        }

        @Override // com.msc.p133sa.aidl.ISACallback
        public void onReceiveRubinRequest(int i, boolean z, Bundle bundle) {
        }

        @Override // com.msc.p133sa.aidl.ISACallback
        public void onReceiveSCloudAccessToken(int i, boolean z, Bundle bundle) {
        }
    };

    public C6877d() {
        Context applicationContext = BaseUtils.getApplicationContext();
        this.f4397a = applicationContext;
        this.f4401e = CommonUtils.getAppServiceId();
        this.f4402f = applicationContext.getPackageName();
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C6877d m5071a() {
        try {
            if (f4396h == null) {
                f4396h = new C6877d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4396h;
    }

    /* JADX INFO: renamed from: b */
    public final void m5072b(ResultConsentData resultConsentData) {
        m5074d();
        C13573a c13573a = this.f4399c;
        if (c13573a != null) {
            ((CompletableFuture) ((C6883j) c13573a.f9635b).f4420d).complete(resultConsentData);
        }
        this.f4399c = null;
    }

    /* JADX INFO: renamed from: c */
    public final void m5073c(C13537d c13537d, C13573a c13573a) throws SAccountException {
        AccountManager accountManager;
        Debugger.m8615i("RequestRequiredConsentApi", "[SA] requestRequiredConsent()");
        this.f4399c = c13573a;
        this.f4398b = C6888c.m5085a().f4433f;
        m5074d();
        ISACallback.Stub stub = this.f4403g;
        String str = this.f4402f;
        String str2 = this.f4401e;
        Debugger.m8615i("RequestRequiredConsentApi", "[SA] registerCallback()");
        ISAService iSAService = this.f4398b;
        Account account = null;
        if (iSAService != null) {
            try {
                String strRegisterCallback = iSAService.registerCallback(str2, null, str, stub);
                this.f4400d = strRegisterCallback;
                if (strRegisterCallback == null) {
                    Debugger.m8615i("RequestRequiredConsentApi", "[SA] registerCallback() : mRegistrationCode is null and try again!");
                    this.f4400d = this.f4398b.registerCallback(str2, null, str, stub);
                }
            } catch (Exception e) {
                AbstractC0000a.m22s("[SA] registerCallback() : ", e, "RequestRequiredConsentApi");
            }
        } else {
            Debugger.m8609e("RequestRequiredConsentApi", "[SA] registerCallback() : mISaService is null");
        }
        if (this.f4400d == null) {
            throw new SAccountException(StickyMemoSAConstants.EVENT_MOVE_STICKY_NOTE, "fail to registerCallback!");
        }
        Debugger.m8615i("RequestRequiredConsentApi", "[SA] request() start with v" + c13537d.f9569c);
        try {
            accountManager = AccountManager.get(this.f4397a);
        } catch (Exception e2) {
            AbstractC0000a.m22s("[SA] getSamsungAccount() : ", e2, "SamsungAccountClientUtil");
            accountManager = null;
        }
        boolean zRequestRequiredConsent = false;
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
        if (this.f4398b == null) {
            Debugger.m8609e("RequestRequiredConsentApi", "[SA] request() : consentService is null!");
            m5072b(new ResultConsentData("401", "fail to requestRequiredConsent <- mISaService is null"));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("client_id", c13537d.f9568b);
        bundle.putString("app_version", c13537d.f9569c);
        bundle.putString("language", c13537d.f9570d);
        bundle.putString(BuddyContract.Address.REGION, c13537d.f9571e);
        bundle.putString("application_region", c13537d.f9572f);
        bundle.putString("access_token", c13537d.f9573g);
        bundle.putString("scope", c13537d.f9574h);
        try {
            Debugger.m8615i("RequestRequiredConsentApi", "[SA] request() : requestRequiredConsent");
            zRequestRequiredConsent = this.f4398b.requestRequiredConsent(1002, this.f4400d, bundle);
        } catch (Exception e3) {
            AbstractC0000a.m22s("[SA] request() : fail to requestRequiredConsent, ", e3, "RequestRequiredConsentApi");
        }
        if (zRequestRequiredConsent) {
            return;
        }
        m5072b(new ResultConsentData("401", "fail to requestRequiredConsent!"));
    }

    /* JADX INFO: renamed from: d */
    public final void m5074d() {
        Debugger.m8615i("RequestRequiredConsentApi", "[SA] unregisterCallback()");
        String str = this.f4400d;
        if (str != null) {
            try {
                ISAService iSAService = this.f4398b;
                if (iSAService != null) {
                    iSAService.unregisterCallback(str);
                }
            } catch (Exception e) {
                AbstractC0000a.m22s("[SA] unregisterCallback() : fail to unregister = ", e, "RequestRequiredConsentApi");
            }
            this.f4400d = null;
        }
    }
}
