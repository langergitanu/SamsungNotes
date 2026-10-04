package com.samsung.android.app.notes.sync.contentsharing.sharehelpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import com.samsung.android.sdk.mobileservice.auth.AuthInfo;
import com.samsung.android.sdk.mobileservice.auth.result.AuthInfoResult;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.concurrent.Executor;
import p068Q.C0204a;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sharehelpers.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC6718a {

    /* JADX INFO: renamed from: b */
    public final Context f4054b;

    /* JADX INFO: renamed from: e */
    public final Class f4057e;

    /* JADX INFO: renamed from: f */
    public String f4058f;

    /* JADX INFO: renamed from: a */
    public int f4053a = 1;

    /* JADX INFO: renamed from: c */
    public Executor f4055c = null;

    /* JADX INFO: renamed from: d */
    public boolean f4056d = false;

    /* JADX INFO: renamed from: g */
    public final ServiceConnection f4059g = new ServiceConnection() { // from class: com.samsung.android.app.notes.sync.contentsharing.sharehelpers.AbsShareHelper$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this.this$0) {
                Debugger.m8607d("AbsShareHelper", "OldService is connected");
                AbstractC6718a abstractC6718a = this.this$0;
                abstractC6718a.f4056d = true;
                abstractC6718a.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.this$0.f4056d = false;
        }
    };

    public AbstractC6718a(Context context, Class cls) {
        this.f4054b = context;
        this.f4057e = cls;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m4810g(AbstractC6718a abstractC6718a) {
        boolean zIsAgreementProcedureNeeded = true;
        if (!DeviceInfo.isVSTModel()) {
            AuthInfoResult authInfo = AbstractC0299q.m648s().getAuthInfo();
            if (authInfo == null) {
                Debugger.m8609e("AbsShareHelper", "Not logged in the samsung account!");
                abstractC6718a.mo4811h(new C0204a("", 3));
                return true;
            }
            AuthInfo result = authInfo.getResult();
            if (result == null) {
                Debugger.m8609e("AbsShareHelper", "authInfo is null!");
                abstractC6718a.mo4811h(new C0204a("", 3));
                return false;
            }
            String accountId = result.getAccountId();
            if (accountId != null && !accountId.isEmpty()) {
                abstractC6718a.mo4812i(accountId);
                return false;
            }
            Debugger.m8609e("AbsShareHelper", "accountId is not valid!");
            abstractC6718a.mo4811h(new C0204a("", 3));
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            zIsAgreementProcedureNeeded = true ^ AbstractC0299q.m598H().isAgreementProcedureNeeded();
        } else {
            AuthInfoResult authInfo2 = AbstractC0299q.m648s().getAuthInfo();
            if (authInfo2 == null) {
                Debugger.m8609e("SesAuthApi", "Not logged in the samsung account!");
            } else {
                AuthInfo result2 = authInfo2.getResult();
                if (result2 == null) {
                    Debugger.m8609e("SesAuthApi", "authInfo is null!");
                } else {
                    String accountId2 = result2.getAccountId();
                    if (accountId2 == null || accountId2.isEmpty()) {
                        Debugger.m8609e("SesAuthApi", "accountId is not valid!");
                    }
                }
            }
            zIsAgreementProcedureNeeded = false;
        }
        if (!zIsAgreementProcedureNeeded) {
            Debugger.m8609e("AbsShareHelper", "device is not authorized");
            abstractC6718a.mo4811h(new C0204a("", 3));
            return false;
        }
        String strM594D = AbstractC0299q.m594D();
        if (strM594D != null && !strM594D.isEmpty()) {
            abstractC6718a.mo4812i(strM594D);
            return false;
        }
        Debugger.m8609e("AbsShareHelper", "accountId is not valid!");
        abstractC6718a.mo4811h(new C0204a("", 3));
        return false;
    }

    /* JADX INFO: renamed from: h */
    public abstract void mo4811h(C0204a c0204a);

    /* JADX INFO: renamed from: i */
    public abstract void mo4812i(String str);
}
