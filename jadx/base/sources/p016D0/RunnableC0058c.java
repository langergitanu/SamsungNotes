package p016D0;

import com.microsoft.identity.client.IAccount;
import com.microsoft.identity.client.IMultipleAccountPublicClientApplication;
import com.samsung.android.support.senl.p148nt.app.settings.microsoft.SettingsMicrosoft$signOut$1$1;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import p033H0.C0112b;

/* JADX INFO: renamed from: D0.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC0058c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ SettingsMicrosoft$signOut$1$1 f228a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f229b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C0059d f230c;

    public RunnableC0058c(C0059d c0059d, SettingsMicrosoft$signOut$1$1 settingsMicrosoft$signOut$1$1, String str) {
        this.f230c = c0059d;
        this.f228a = settingsMicrosoft$signOut$1$1;
        this.f229b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAccount iAccount = (IAccount) C0112b.m261h().f362a;
        SettingsMicrosoft$signOut$1$1 settingsMicrosoft$signOut$1$1 = this.f228a;
        C0059d c0059d = this.f230c;
        if (iAccount != null) {
            ((IMultipleAccountPublicClientApplication) c0059d.f232a).removeAccount((IAccount) C0112b.m261h().f362a, settingsMicrosoft$signOut$1$1);
            return;
        }
        if (C0059d.m135a(c0059d) <= 0) {
            if (C0059d.m135a(c0059d) == 0) {
                MSLogger.m8633e("AuthenticationHelper", "getAccounts is empty (login info lost)");
                settingsMicrosoft$signOut$1$1.onRemoved();
                return;
            }
            return;
        }
        MSLogger.m8632d("AuthenticationHelper", "account id : 1");
        for (IAccount iAccount2 : c0059d.f235d) {
            MSLogger.m8632d("AuthenticationHelper", "getAccounts. id : Ok");
            if (iAccount2.getId().equals(this.f229b)) {
                MSLogger.m8632d("AuthenticationHelper", "removeAccount id : equals");
                ((IMultipleAccountPublicClientApplication) c0059d.f232a).removeAccount(iAccount2, settingsMicrosoft$signOut$1$1);
            }
        }
    }
}
