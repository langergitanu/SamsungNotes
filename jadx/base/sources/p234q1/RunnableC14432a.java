package p234q1;

import com.microsoft.identity.client.AuthenticationCallback;
import com.microsoft.identity.client.IAccount;
import com.microsoft.identity.client.IMultipleAccountPublicClientApplication;
import com.microsoft.identity.common.java.authorities.Authority;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.app.notes.sync.microsoft.graph.C6785g;
import com.samsung.android.app.notes.sync.scloud.pam.SCloudPamHelper;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthorizationListener;
import p016D0.C0059d;
import p033H0.C0112b;
import p042J1.C0145c;

/* JADX INFO: renamed from: q1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC14432a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f10221a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f10222b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f10223c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f10224d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f10225e;

    public /* synthetic */ RunnableC14432a(C14433b c14433b, String str, String str2, IAuthorizationListener iAuthorizationListener, int i) {
        this.f10221a = i;
        this.f10225e = c14433b;
        this.f10222b = str;
        this.f10223c = str2;
        this.f10224d = iAuthorizationListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10221a) {
            case 0:
                Debugger.m8615i("SCloudAuthorizationManager", "getAuthorizationAsync(), run()");
                C14433b c14433b = (C14433b) this.f10225e;
                String str = (String) c14433b.f10228b;
                String str2 = this.f10222b;
                if (!str2.equals(str)) {
                    SCloudPamHelper.updateAccountInfo(str2, (String) this.f10223c);
                    c14433b.f10228b = str2;
                }
                try {
                    ((IAuthorizationListener) this.f10224d).onReceived(SCloudPamHelper.getToken());
                } catch (Exception unused) {
                    Debugger.m8609e("SCloudAuthorizationManager", "getAuthorization() : fail to call listener.onReceived()!");
                    return;
                }
                break;
            case 1:
                IAuthorizationListener iAuthorizationListener = (IAuthorizationListener) this.f10224d;
                C14433b c14433b2 = (C14433b) this.f10225e;
                Debugger.m8615i("SCloudAuthorizationManager", "getAuthorizationAsync(), run() : initializeForAccount first!");
                String str3 = (String) this.f10223c;
                String str4 = this.f10222b;
                if (SCloudPamHelper.initializeForAccount(str4, str3)) {
                    c14433b2.f10228b = str4;
                    try {
                        iAuthorizationListener.onReceived(SCloudPamHelper.getToken());
                    } catch (Exception unused2) {
                        Debugger.m8609e("SCloudAuthorizationManager", "getAuthorization() : fail to call listener.onReceived()!");
                        return;
                    }
                } else {
                    Debugger.m8609e("SCloudAuthorizationManager", "getAuthorizationAsync() : fail to initialize PAM!");
                    try {
                        iAuthorizationListener.onError("0", "fail to initialize PAM");
                    } catch (Exception unused3) {
                        Debugger.m8609e("SCloudAuthorizationManager", "getAuthorization() : fail to call listener.onError()!");
                        return;
                    }
                }
                break;
            default:
                AuthenticationCallback authenticationCallback = (AuthenticationCallback) this.f10224d;
                C0059d c0059d = (C0059d) this.f10225e;
                String[] strArr = c0059d.f233b;
                String string = ((Authority) this.f10223c).getAuthorityURL().toString();
                if (((IAccount) C0112b.m261h().f362a) != null) {
                    ((IMultipleAccountPublicClientApplication) c0059d.f232a).acquireTokenSilentAsync(strArr, (IAccount) C0112b.m261h().f362a, string, authenticationCallback);
                } else if (C0059d.m135a(c0059d) > 0) {
                    MSLogger.m8632d("AuthenticationHelper", "account id : 1");
                    for (IAccount iAccount : c0059d.f235d) {
                        MSLogger.m8632d("AuthenticationHelper", "getAccounts. id : OK");
                        if (iAccount.getId().equals(this.f10222b)) {
                            MSLogger.m8632d("AuthenticationHelper", "acquireTokenSilentAsync. id : equals OK");
                            ((IMultipleAccountPublicClientApplication) c0059d.f232a).acquireTokenSilentAsync(strArr, iAccount, string, authenticationCallback);
                        }
                    }
                } else if (C0059d.m135a(c0059d) == 0) {
                    MSLogger.m8633e("AuthenticationHelper", "getAccounts is empty (login info lost)");
                    C6785g c6785g = AbstractC6784f.f4180a;
                    c6785g.getClass();
                    MSLogger.m8632d("GraphManager", "setSignIn : false");
                    c6785g.f4185e = false;
                    C0145c.m304L("GRAPH_PREFERENCE", "sign_in", false);
                    c6785g.m4949m(false);
                }
                break;
        }
    }

    public RunnableC14432a(C0059d c0059d, Authority authority, AuthenticationCallback authenticationCallback, String str) {
        this.f10221a = 2;
        this.f10225e = c0059d;
        this.f10223c = authority;
        this.f10224d = authenticationCallback;
        this.f10222b = str;
    }
}
