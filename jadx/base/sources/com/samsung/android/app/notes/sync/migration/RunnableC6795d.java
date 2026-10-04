package com.samsung.android.app.notes.sync.migration;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import p042J1.AbstractC0147e;
import p042J1.C0148f;
import p079T.AbstractC0299q;
import p174d1.C11972a;
import p176e1.AbstractC11975a;
import p176e1.AbstractC11976b;
import p186h1.AbstractC12022c;
import p186h1.AbstractC12023d;
import p186h1.AbstractC12031l;
import p186h1.C12020a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC6795d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Class f4213a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Context f4214b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C6798g f4215c;

    public RunnableC6795d(C6798g c6798g, Class cls, Context context) {
        this.f4215c = c6798g;
        this.f4213a = cls;
        this.f4214b = context;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        String strM13717g;
        String str = C6798g.f4220k;
        AbstractC0299q.m643n(str, "startSelfRestoreMigration");
        Class cls = this.f4213a;
        C6798g c6798g = this.f4215c;
        c6798g.f4222a = cls;
        PackageManagerCompat companion = PackageManagerCompat.INSTANCE.getInstance();
        Context context = this.f4214b;
        if (companion.isKMemoPackage(context)) {
            AbstractC0299q.m643n(str, "startSelfRestoreMigration don't support KMEMO");
            return;
        }
        if (DeviceInfo.isOtherCorpDevice()) {
            AbstractC0299q.m643n(str, "startSelfRestoreMigration don't support other corp device");
            return;
        }
        if (AbstractC12023d.m13699v() > 5) {
            AbstractC0299q.m643n(str, "startSelfRestoreMigration reached MAX_EXCEPTION_COUNT");
            AbstractC12023d.m13676U(0);
            C6798g.m4956a(c6798g);
            C6798g.m4957b(c6798g);
            return;
        }
        if (AbstractC12031l.m13711a(context)) {
            c6798g.m4968m();
            strM13717g = AbstractC12031l.m13718h(context);
        } else {
            strM13717g = AbstractC12031l.m13717g();
        }
        AbstractC0299q.m643n(str, "startSelfRestoreMigration getPromisedRestorePath " + Logger.getEncode(strM13717g));
        C0148f.m361q(strM13717g);
        int iM13655b = AbstractC12022c.m13655b();
        if (iM13655b == 0) {
            c6798g.m4970o();
            C6798g.m4956a(c6798g);
            return;
        }
        c6798g.m4968m();
        C12020a c12020a = new C12020a(11, (byte) 0);
        C11972a c11972a = (C11972a) c12020a.f8772b;
        c11972a.f8536a = null;
        c11972a.f8538c = "SmartSwitch";
        c11972a.f8539d = "SmartSwitchMobile";
        c11972a.f8540e = "";
        c11972a.f8541f = 0;
        c11972a.f8542g = iM13655b;
        c11972a.f8543h = false;
        c11972a.f8544i = new Intent();
        ArrayList arrayListM13553a = AbstractC11976b.m13553a(c12020a.m13630I());
        Iterator it = arrayListM13553a.iterator();
        while (it.hasNext()) {
            ((AbstractC11975a) it.next()).f8564n = c6798g.f4231j;
        }
        c6798g.f4226e.getClass();
        C6789b.m4952b(arrayListM13553a);
        C6798g.m4956a(c6798g);
        if (AbstractC0147e.f419a.m365f()) {
            return;
        }
        c6798g.f4222a = null;
    }
}
