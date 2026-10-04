package com.samsung.android.app.notes.sync.migration;

import android.text.TextUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.migration.backup.task.osmosis.C6791b;
import com.samsung.android.app.notes.sync.migration.backup.task.osmosis.C6793d;
import com.samsung.android.app.notes.sync.migration.common.Type$Interface;
import com.samsung.android.app.notes.sync.migration.common.Type$Process;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import p049L0.C0168a;
import p053M0.AbstractC0173a;
import p057N0.C0182c;
import p057N0.C0183d;
import p079T.AbstractC0299q;
import p176e1.AbstractC11975a;
import p234q1.C14433b;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6789b {

    /* JADX INFO: renamed from: e */
    public static final String f4189e = "SS$".concat("MigrationController");

    /* JADX INFO: renamed from: a */
    public AbstractC0173a f4190a;

    /* JADX INFO: renamed from: b */
    public C0168a f4191b;

    /* JADX INFO: renamed from: c */
    public final C6835r f4192c = new C6835r(this);

    /* JADX INFO: renamed from: d */
    public C14433b f4193d;

    /* JADX INFO: renamed from: b */
    public static void m4952b(ArrayList arrayList) throws Throwable {
        TimeManager.getInstance().updateSettingsUsingServer(System.currentTimeMillis());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AbstractC11975a abstractC11975a = (AbstractC11975a) it.next();
            abstractC11975a.mo13548h();
            abstractC11975a.mo13546e();
            abstractC11975a.mo13547g();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m4953a(C14433b c14433b) {
        C6903f c6903f = this.f4191b.f529q;
        Type$Interface type$Interface = (Type$Interface) c6903f.f4474b;
        Type$Process type$Process = (Type$Process) c6903f.f4475c;
        int i = AbstractC6788a.f4188a[type$Interface.ordinal()];
        if (i == 1) {
            String strM15155o = AbstractC14517a.m15155o(this.f4191b.f513a);
            if (TextUtils.isEmpty(strM15155o) || !strM15155o.contains("PREPARE")) {
                this.f4190a = new C6791b(this.f4191b);
            } else {
                this.f4190a = new C6793d(this.f4191b);
            }
        } else if (i != 2) {
            AbstractC0299q.m646q(f4189e, "startBackUp wrong interface");
        } else if (type$Process == Type$Process.INSTANT) {
            C0168a c0168a = this.f4191b;
            C0183d c0183d = new C0183d(c0168a);
            String str = C0183d.f569h;
            try {
                File file = new File(c0168a.f515c);
                if (!file.exists()) {
                    AbstractC0299q.m603M(str, "prepareSnapShotFile mkdirs sourceFile " + file.mkdirs());
                }
                c0183d.f570g = new File(file.getParent(), "backuplist.json");
            } catch (Exception e) {
                AbstractC6670b.m4762w(e, new StringBuilder("prepareSnapShotFile exception "), str);
            }
            this.f4190a = c0183d;
        } else {
            this.f4190a = new C0182c(this.f4191b);
        }
        AbstractC0173a abstractC0173a = this.f4190a;
        abstractC0173a.f552d = c14433b;
        AbstractC0299q.m643n(AbstractC0173a.f548f, "run");
        abstractC0173a.mo438d();
        abstractC0173a.mo436a();
        abstractC0173a.mo437c();
    }
}
