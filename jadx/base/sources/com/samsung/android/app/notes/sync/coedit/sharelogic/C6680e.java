package com.samsung.android.app.notes.sync.coedit.sharelogic;

import android.os.Message;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharehelpers.C6674d;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import p063P.InterfaceC0192a;
import p212o1.C13573a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.coedit.sharelogic.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6680e extends AbstractC6678c {

    /* JADX INFO: renamed from: e */
    public static final ExecutorService f3975e = AbstractC4539a.m3201k("CoeditImportLogic");

    /* JADX INFO: renamed from: f */
    public static long f3976f = 0;

    /* JADX INFO: renamed from: g */
    public static C6674d f3977g = null;

    /* JADX INFO: renamed from: h */
    public static final ArrayList f3978h = new ArrayList();

    /* JADX INFO: renamed from: d */
    public C13573a f3979d;

    @Override // com.samsung.android.app.notes.sync.coedit.sharelogic.AbstractC6678c
    /* JADX INFO: renamed from: a */
    public final void mo4773a(Message message) {
        if (message.what != 100) {
            return;
        }
        int i = message.arg1;
        Object obj = message.obj;
        Debugger.m8615i("CoeditImportLogic", "startShare : msgCode = " + i);
        f3976f = System.currentTimeMillis();
        if (!(obj instanceof C6682g)) {
            Debugger.m8609e("CoeditImportLogic", "startShare : messageObj is invalid!");
            Debugger.m8616s("CoeditImportLogic", "can't start sharing now!");
            return;
        }
        C6682g c6682g = (C6682g) obj;
        String str = c6682g.f3984a;
        List list = c6682g.f3985b;
        ArrayList arrayList = f3978h;
        synchronized (arrayList) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0192a) it.next()).onStarted(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f3977g.m4769j(f3975e, str, list);
    }
}
