package p207n1;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6875b;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6880g;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAccountLoginListener;
import java.util.ArrayList;
import java.util.Iterator;
import p001A.AbstractC0000a;
import p033H0.C0112b;
import p048L.RunnableC0164b;

/* JADX INFO: renamed from: n1.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13540g {

    /* JADX INFO: renamed from: a */
    public final Context f9579a;

    /* JADX INFO: renamed from: c */
    public boolean f9581c;

    /* JADX INFO: renamed from: d */
    public String f9582d;

    /* JADX INFO: renamed from: e */
    public final SharedPreferences f9583e;

    /* JADX INFO: renamed from: f */
    public C0112b f9584f;

    /* JADX INFO: renamed from: b */
    public final ArrayList f9580b = new ArrayList();

    /* JADX INFO: renamed from: g */
    public final C13539f f9585g = new C13539f();

    public C13540g(Context context) {
        this.f9579a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginInfo", 0);
        this.f9583e = sharedPreferences;
        if (sharedPreferences != null) {
            this.f9581c = sharedPreferences.getBoolean("ISLOGIN", false);
            this.f9582d = sharedPreferences.getString("Email", null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009c  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m14285a() {
        AccountManager accountManager;
        Account account = null;
        try {
            accountManager = AccountManager.get(this.f9579a);
        } catch (Exception e) {
            AbstractC0000a.m22s("[SA] getSamsungAccount() : ", e, "SamsungAccountClientUtil");
            accountManager = null;
        }
        if (accountManager == null) {
            Debugger.m8615i("SamsungAccountClientUtil", "[SA] getSamsungAccount() : manager is null. please check the APK signing!");
        } else {
            Account[] accountsByType = accountManager.getAccountsByType("com.osp.app.signin");
            if (accountsByType.length > 0) {
                account = accountsByType[0];
            }
        }
        boolean z = account != null;
        if (this.f9581c != z) {
            Debugger.m8615i("SamsungAccountLogInController", "[SA] isLoggedIn() : " + z);
            if (z) {
                String str = account.name;
                Debugger.m8615i("SamsungAccountLogInController", "[SA] setLoggedIn()");
                this.f9582d = str;
                this.f9581c = true;
                C6875b c6875bM5062c = C6875b.m5062c();
                c6875bM5062c.f4379e = c6875bM5062c.f4378d;
                c6875bM5062c.f4376b = Boolean.TRUE;
                c6875bM5062c.m5064b();
                SharedPreferences sharedPreferences = this.f9583e;
                if (sharedPreferences != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putBoolean("ISLOGIN", this.f9581c);
                    editorEdit.putString("Email", this.f9582d);
                    editorEdit.apply();
                }
            } else {
                m14286b();
            }
            synchronized (this.f9580b) {
                try {
                    if (this.f9580b.size() > 0) {
                        Iterator it = this.f9580b.iterator();
                        while (it.hasNext()) {
                            new Handler(Looper.getMainLooper()).post(new RunnableC0164b(1, (IAccountLoginListener) it.next(), z));
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (z) {
            if (this.f9582d.equals(account.name)) {
                ((C6880g) this.f9584f.f363b).getClass();
                if (C6875b.m5062c().f4378d != null) {
                    ((C6880g) this.f9584f.f363b).getClass();
                    if (C6875b.m5062c().f4380f == null) {
                        Debugger.m8615i("SamsungAccountLogInController", "[SA] AccessToken or userId is empty!");
                        this.f9584f.m268l(this.f9585g);
                    }
                }
            } else {
                m14286b();
                String str2 = account.name;
                Debugger.m8615i("SamsungAccountLogInController", "[SA] setLoggedIn()");
                this.f9582d = str2;
                this.f9581c = true;
                C6875b c6875bM5062c2 = C6875b.m5062c();
                c6875bM5062c2.f4379e = c6875bM5062c2.f4378d;
                c6875bM5062c2.f4376b = Boolean.TRUE;
                c6875bM5062c2.m5064b();
                SharedPreferences sharedPreferences2 = this.f9583e;
                if (sharedPreferences2 != null) {
                    SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
                    editorEdit2.putBoolean("ISLOGIN", this.f9581c);
                    editorEdit2.putString("Email", this.f9582d);
                    editorEdit2.apply();
                }
                this.f9584f.m268l(this.f9585g);
            }
        }
        return this.f9581c;
    }

    /* JADX INFO: renamed from: b */
    public final void m14286b() {
        Debugger.m8615i("SamsungAccountLogInController", "[SA] setLoggedOut()");
        C6875b.m5062c().m5068g(null);
        this.f9582d = null;
        this.f9581c = false;
        C6875b.m5062c().m5064b();
        SharedPreferences sharedPreferences = this.f9583e;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("ISLOGIN", this.f9581c);
            editorEdit.putString("Email", this.f9582d);
            editorEdit.apply();
        }
    }
}
