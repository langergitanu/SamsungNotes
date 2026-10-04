package p234q1;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.scloud.pam.SCloudPamHelper;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p086V.C0322h;

/* JADX INFO: renamed from: q1.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14434c {

    /* JADX INFO: renamed from: d */
    public static C14434c f10229d;

    /* JADX INFO: renamed from: a */
    public Context f10230a;

    /* JADX INFO: renamed from: b */
    public boolean f10231b;

    /* JADX INFO: renamed from: c */
    public boolean f10232c;

    /* JADX INFO: renamed from: a */
    public static synchronized C14434c m15043a() {
        try {
            if (f10229d == null) {
                C14434c c14434c = new C14434c();
                c14434c.f10231b = false;
                c14434c.f10232c = false;
                c14434c.f10230a = C0322h.m670a().f815a.getAppContext();
                f10229d = c14434c;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f10229d;
    }

    /* JADX INFO: renamed from: b */
    public final String m15044b(String str) {
        String baseUrlOfPath;
        if (m15045c()) {
            baseUrlOfPath = "https://stg-api.samsungcloud.com";
        } else {
            if (BaseUtils.getApplicationContext() == null) {
                Debugger.m8609e("SCloudPamDomain", "getDomain() : appContext is null!");
            } else {
                baseUrlOfPath = SCloudPamHelper.getBaseUrlOfPath();
                if (TextUtils.isEmpty(baseUrlOfPath)) {
                    Debugger.m8609e("SCloudPamDomain", "getDomain() : fail to get the domainUrl using PAM");
                }
            }
            baseUrlOfPath = null;
        }
        if (!TextUtils.isEmpty(baseUrlOfPath)) {
            return AbstractC0541b.m756B(baseUrlOfPath, str);
        }
        Debugger.m8609e("ServerDomainManager", "[PAM] getServerUrl() : domainUrl is empty!");
        return null;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m15045c() {
        if (!this.f10232c) {
            this.f10231b = this.f10230a.getSharedPreferences("SYNC_PREF", 0).getBoolean("isStaging", false);
            this.f10232c = true;
        }
        return this.f10231b;
    }
}
