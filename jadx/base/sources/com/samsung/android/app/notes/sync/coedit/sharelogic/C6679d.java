package com.samsung.android.app.notes.sync.coedit.sharelogic;

import android.content.Intent;
import android.os.Message;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.deletecore.CoeditDeleteLocalSharedSdocTask;
import com.samsung.android.app.notes.sync.coedit.sharehelpers.C6672b;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import p001A.AbstractC0000a;
import p028G.InterfaceC0102a;
import p192j1.C12936a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.coedit.sharelogic.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6679d extends AbstractC6678c {

    /* JADX INFO: renamed from: e */
    public static final ExecutorService f3970e = AbstractC4539a.m3201k("MdeDeleteLogic");

    /* JADX INFO: renamed from: f */
    public static C6672b f3971f = null;

    /* JADX INFO: renamed from: g */
    public static final CopyOnWriteArrayList f3972g = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: h */
    public static long f3973h = 0;

    /* JADX INFO: renamed from: d */
    public C12936a f3974d;

    /* JADX INFO: renamed from: b */
    public static void m4774b(InterfaceC0102a interfaceC0102a) {
        CopyOnWriteArrayList copyOnWriteArrayList = f3972g;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (((InterfaceC0102a) it.next()).equals(interfaceC0102a)) {
                return;
            }
        }
        copyOnWriteArrayList.add(interfaceC0102a);
        Debugger.m8607d("MdeDeleteLogic", "Added progress listener - size : " + copyOnWriteArrayList.size());
    }

    @Override // com.samsung.android.app.notes.sync.coedit.sharelogic.AbstractC6678c
    /* JADX INFO: renamed from: a */
    public final void mo4773a(Message message) {
        int i = message.what;
        if (i != 200) {
            if (i != 300) {
                return;
            }
            AbstractC0000a.m0A(message.arg1, "startDeleteLocalAll : msgCode = ", "MdeDeleteLogic");
            C6672b c6672b = f3971f;
            ExecutorService executorService = f3970e;
            c6672b.f3949b.bindService(new Intent(c6672b.f3949b, (Class<?>) c6672b.f3952e), c6672b.f3954g, 1);
            synchronized (c6672b) {
                new CoeditDeleteLocalSharedSdocTask(CoeditDeleteLocalSharedSdocTask.DeleteType.ALL, null, c6672b).executeOnExecutor(executorService, new Void[0]);
            }
            return;
        }
        int i2 = message.arg1;
        Object obj = message.obj;
        Debugger.m8615i("MdeDeleteLogic", "startDelete : msgCode = " + i2);
        f3973h = System.currentTimeMillis();
        if (!(obj instanceof C6682g)) {
            Debugger.m8609e("MdeDeleteLogic", "startDelete : messageObj is invalid!");
            Debugger.m8616s("MdeDeleteLogic", "can't start deleting now!");
            return;
        }
        C6682g c6682g = (C6682g) obj;
        String str = c6682g.f3984a;
        List list = c6682g.f3985b;
        Iterator it = f3972g.iterator();
        while (it.hasNext()) {
            ((InterfaceC0102a) it.next()).onStarted(str);
        }
        f3971f.m4769j(f3970e, str, list);
    }
}
