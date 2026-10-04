package com.samsung.android.model.contractimpl;

import android.app.Activity;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6875b;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6879f;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6880g;
import com.samsung.android.app.notes.sync.synchronization.managers.C6904g;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.support.senl.p148nt.app.account.AccountHelper;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.ConsentDataListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.CountryPolicyListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract;
import java.util.ArrayList;
import java.util.Iterator;
import p033H0.C0112b;
import p207n1.C13535b;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RequestSamsungAccountContractImpl implements RequestSamsungAccountContract {
    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public void cancelAuthInfo(IAuthInfoReqListener iAuthInfoReqListener) {
        C13541h.m14287e().m14289b(iAuthInfoReqListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public void cancelConsentInfo(ConsentDataListener consentDataListener) {
        C13541h c13541hM14287e = C13541h.m14287e();
        c13541hM14287e.getClass();
        Debugger.m8615i("SAccountManager", "[SA] cancelConsentInfo()");
        C6906i c6906i = (C6906i) c13541hM14287e.f9590c;
        synchronized (((ArrayList) c6906i.f4483b)) {
            try {
                ((ArrayList) c6906i.f4483b).remove(consentDataListener);
                if (((ArrayList) c6906i.f4483b).size() == 0) {
                    ((C6880g) c6906i.f4484c).m5076b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public void cancelCountryPolicy(CountryPolicyListener countryPolicyListener) {
        C13541h.m14287e().getClass();
        Debugger.m8615i("SAccountManager", "[SA] cancelCountryPolicy()");
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public void clearInvalidLoggedIn() {
        C13541h.m14287e().m14290c();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public String getAccessToken() {
        return C13541h.m14287e().m14291d();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public String getApiServerUrl() {
        ((C6880g) ((C0112b) C13541h.m14287e().f9589b).f363b).getClass();
        return C6875b.m5062c().f4381g;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public boolean getInvalidLoggedIn() {
        ((C6880g) ((C0112b) C13541h.m14287e().f9589b).f363b).getClass();
        return C6875b.m5062c().f4377c.booleanValue();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public String getRegionMcc() {
        ((C6880g) ((C0112b) C13541h.m14287e().f9589b).f363b).getClass();
        return C6875b.m5062c().f4384j;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public String getUserId() {
        return C13541h.m14287e().m14293g();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public String getUserIdHash() {
        return C13541h.m14287e().m14294h();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public boolean isB2BAccount() {
        return C13541h.m14287e().m14292f();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public boolean isChildAccount() {
        ((C6880g) ((C0112b) C13541h.m14287e().f9589b).f363b).getClass();
        return C6875b.m5062c().f4385k;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public boolean isLogined() {
        return ((C13540g) C13541h.m14287e().f9588a).m14285a();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public void loginPopupSamsungAccount(Activity activity, int i) {
        AccountHelper.loginPopupSamsungAccount(activity, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public void loginRequestAccessToken(Activity activity, int i) {
        AccountHelper.loginRequestAccessToken(activity, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public void requestAuthInfo(IAuthInfoReqListener iAuthInfoReqListener) {
        C13541h.m14287e().m14295i(iAuthInfoReqListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public void requestConsentInfo(ConsentDataListener consentDataListener) {
        C13541h c13541hM14287e = C13541h.m14287e();
        c13541hM14287e.getClass();
        Debugger.m8615i("SAccountManager", "[SA] requestConsentInfo() : user = 104");
        C6906i c6906i = (C6906i) c13541hM14287e.f9590c;
        synchronized (((ArrayList) c6906i.f4483b)) {
            try {
                Iterator it = ((ArrayList) c6906i.f4483b).iterator();
                while (it.hasNext()) {
                    if (((ConsentDataListener) it.next()) == consentDataListener) {
                        Debugger.m8615i("RequestRequiredConsentController", "[SA] request() : Listener exists!");
                        return;
                    }
                }
                ((ArrayList) c6906i.f4483b).add(consentDataListener);
                int size = ((ArrayList) c6906i.f4483b).size();
                if (size == 1) {
                    Debugger.m8615i("RequestRequiredConsentController", "[SA] request() : RequestRequiredConsent!");
                    ((C6880g) c6906i.f4484c).m5079e(new C6879f(c6906i, 1));
                } else {
                    Debugger.m8615i("RequestRequiredConsentController", "[SA] request() : pass to requestRequiredConsent, # of listeners = " + size);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public void requestCountryPolicy(CountryPolicyListener countryPolicyListener) {
        C13541h c13541hM14287e = C13541h.m14287e();
        c13541hM14287e.getClass();
        Debugger.m8615i("SAccountManager", "[SA] getCountryPolicy()");
        C6742k c6742k = (C6742k) c13541hM14287e.f9591d;
        synchronized (((ArrayList) c6742k.f4110b)) {
            try {
                Iterator it = ((ArrayList) c6742k.f4110b).iterator();
                while (it.hasNext()) {
                    if (((CountryPolicyListener) it.next()) == countryPolicyListener) {
                        Debugger.m8615i("CountryPolicyController", "[SA] request() : Listener exists!");
                        return;
                    }
                }
                ((ArrayList) c6742k.f4110b).add(countryPolicyListener);
                int size = ((ArrayList) c6742k.f4110b).size();
                if (size == 1) {
                    Debugger.m8615i("CountryPolicyController", "[SA] request() : requestCountryPolicy!");
                    ((C6904g) c6742k.f4111c).m5134c(new C13535b(c6742k, 0));
                } else {
                    Debugger.m8615i("CountryPolicyController", "[SA] request() : pass to requestCountryPolicy, # of listeners = " + size);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public void requestPreventOnlineProcessingSettings(Activity activity, int i) {
        AccountHelper.requestPreventOnlineProcessingSettings(activity, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public void requestSystemAiPermission(Activity activity, int i) {
        AccountHelper.requestSystemAiPermission(activity, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSamsungAccountContract
    public void setAccessTokenExpired() {
        C13541h.m14287e().m14296j();
    }
}
