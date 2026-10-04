package com.samsung.android.app.notes.sync.coedit.sharehelpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.sdk.mobileservice.auth.AuthApi;
import com.samsung.android.sdk.mobileservice.auth.AuthInfo;
import com.samsung.android.sdk.mobileservice.auth.result.AuthInfoResult;
import com.samsung.android.sdk.mobileservice.common.exception.NotAuthorizedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotConnectedException;
import com.samsung.android.sdk.mobileservice.common.exception.NotSupportedApiException;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.concurrent.Executor;
import p068Q.C0204a;
import p079T.AbstractC0299q;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.coedit.sharehelpers.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC6671a {

    /* JADX INFO: renamed from: b */
    public final Context f3949b;

    /* JADX INFO: renamed from: e */
    public final Class f3952e;

    /* JADX INFO: renamed from: f */
    public String f3953f;

    /* JADX INFO: renamed from: a */
    public int f3948a = 1;

    /* JADX INFO: renamed from: c */
    public Executor f3950c = null;

    /* JADX INFO: renamed from: d */
    public boolean f3951d = false;

    /* JADX INFO: renamed from: g */
    public final ServiceConnection f3954g = new ServiceConnection() { // from class: com.samsung.android.app.notes.sync.coedit.sharehelpers.CoeditAbsShareHelper$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this.this$0) {
                Debugger.m8607d("CoeditAbsShareHelper", "OldService is connected");
                AbstractC6671a abstractC6671a = this.this$0;
                abstractC6671a.f3951d = true;
                abstractC6671a.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.this$0.f3951d = false;
        }
    };

    public AbstractC6671a(Context context, Class cls) {
        this.f3949b = context;
        this.f3952e = cls;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m4766g(AbstractC6671a abstractC6671a) throws ShareException {
        boolean zIsAgreementProcedureNeeded = true;
        if (!DeviceInfo.isVSTModel()) {
            AuthInfoResult authInfo = AbstractC0299q.m648s().getAuthInfo();
            if (authInfo == null) {
                Debugger.m8609e("CoeditAbsShareHelper", "Not logged in the samsung account!");
                abstractC6671a.mo4767h(new C0204a("", 3));
                return true;
            }
            AuthInfo result = authInfo.getResult();
            if (result == null) {
                Debugger.m8609e("CoeditAbsShareHelper", "authInfo is null!");
                abstractC6671a.mo4767h(new C0204a("", 3));
                return false;
            }
            String accountId = result.getAccountId();
            if (accountId != null && !accountId.isEmpty()) {
                abstractC6671a.mo4768i(accountId);
                return false;
            }
            Debugger.m8609e("CoeditAbsShareHelper", "accountId is not valid!");
            abstractC6671a.mo4767h(new C0204a("", 3));
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            zIsAgreementProcedureNeeded = true ^ AbstractC14517a.m15159s().isAgreementProcedureNeeded();
        } else {
            try {
                AuthInfoResult authInfo2 = new AuthApi(C6715o.m4808q().m4798f()).getAuthInfo();
                if (authInfo2 == null) {
                    Debugger.m8609e("SesSocialApi", "Not logged in the samsung account!");
                } else {
                    AuthInfo result2 = authInfo2.getResult();
                    if (result2 == null) {
                        Debugger.m8609e("SesSocialApi", "authInfo is null!");
                    } else {
                        String accountId2 = result2.getAccountId();
                        if (accountId2 == null || accountId2.isEmpty()) {
                            Debugger.m8609e("SesSocialApi", "accountId is not valid!");
                        }
                    }
                }
                zIsAgreementProcedureNeeded = false;
            } catch (NotAuthorizedException e) {
                String str = "NotAuthorizedException : " + e.getMessage();
                Debugger.m8609e("SesSocialApi", str);
                throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_AUTHORIZED_EXCEPTION, str);
            } catch (NotConnectedException e2) {
                String str2 = "NotConnectedException : " + e2.getMessage();
                Debugger.m8609e("SesSocialApi", str2);
                throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SESSION_CONNECTED_EXCEPTION, str2);
            } catch (NotSupportedApiException e3) {
                String str3 = "NotSupportedApiException : " + e3.getMessage();
                Debugger.m8609e("SesSocialApi", str3);
                throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SUPPORTED_API_EXCEPTION, str3);
            } catch (Exception e5) {
                throw new ShareException(ShareConstants$ResultCode.FAIL_UNKNOWN_EXCEPTION, "Exception : " + e5.toString());
            }
        }
        if (!zIsAgreementProcedureNeeded) {
            Debugger.m8609e("CoeditAbsShareHelper", "device is not authorized");
            abstractC6671a.mo4767h(new C0204a("", 3));
            return false;
        }
        String strM594D = AbstractC0299q.m594D();
        if (strM594D != null && !strM594D.isEmpty()) {
            abstractC6671a.mo4768i(strM594D);
            return false;
        }
        Debugger.m8609e("CoeditAbsShareHelper", "accountId is not valid!");
        abstractC6671a.mo4767h(new C0204a("", 3));
        return false;
    }

    /* JADX INFO: renamed from: h */
    public abstract void mo4767h(C0204a c0204a);

    /* JADX INFO: renamed from: i */
    public abstract void mo4768i(String str);
}
