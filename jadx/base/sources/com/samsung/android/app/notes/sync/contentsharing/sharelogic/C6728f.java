package com.samsung.android.app.notes.sync.contentsharing.sharelogic;

import android.os.Message;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.contentsharing.sharehelpers.C6721d;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import p063P.InterfaceC0192a;
import p234q1.C14433b;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sharelogic.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6728f extends AbstractC6725c {

    /* JADX INFO: renamed from: e */
    public static final ExecutorService f4083e = AbstractC4539a.m3201k("MdeImportLogic");

    /* JADX INFO: renamed from: f */
    public static long f4084f = 0;

    /* JADX INFO: renamed from: g */
    public static C6721d f4085g = null;

    /* JADX INFO: renamed from: h */
    public static final ArrayList f4086h = new ArrayList();

    /* JADX INFO: renamed from: d */
    public C14433b f4087d;

    /* JADX INFO: renamed from: b */
    public static void m4820b(InterfaceC0192a interfaceC0192a) {
        ArrayList arrayList = f4086h;
        synchronized (arrayList) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((InterfaceC0192a) it.next()).equals(interfaceC0192a)) {
                        return;
                    }
                }
                ArrayList arrayList2 = f4086h;
                arrayList2.add(interfaceC0192a);
                Debugger.m8607d("MdeImportLogic", "Added progress listener - size : " + arrayList2.size());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m4821c(InterfaceC0192a interfaceC0192a) {
        ArrayList arrayList = f4086h;
        synchronized (arrayList) {
            arrayList.remove(interfaceC0192a);
            Debugger.m8607d("MdeImportLogic", "Removed progress listener - size : " + arrayList.size());
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sharelogic.AbstractC6725c
    /* JADX INFO: renamed from: a */
    public final void mo4817a(Message message) {
        if (message.what != 100) {
            return;
        }
        int i = message.arg1;
        Object obj = message.obj;
        Debugger.m8615i("MdeImportLogic", "startShare : msgCode = " + i);
        f4084f = System.currentTimeMillis();
        if (!(obj instanceof C6729g)) {
            Debugger.m8609e("MdeImportLogic", "startShare : messageObj is invalid!");
            Debugger.m8616s("MdeImportLogic", "can't start sharing now!");
            return;
        }
        C6729g c6729g = (C6729g) obj;
        String str = c6729g.f4088a;
        List list = c6729g.f4089b;
        ArrayList arrayList = f4086h;
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
        f4085g.m4813j(f4083e, str, list);
    }
}
