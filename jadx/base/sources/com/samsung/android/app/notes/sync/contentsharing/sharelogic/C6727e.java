package com.samsung.android.app.notes.sync.contentsharing.sharelogic;

import android.content.Intent;
import android.os.Message;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.contentsharing.deletecore.DeleteLocalSharedSdocTask;
import com.samsung.android.app.notes.sync.contentsharing.sharehelpers.C6719b;
import com.samsung.android.app.notes.sync.synchronization.managers.C6907j;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import p001A.AbstractC0000a;
import p063P.InterfaceC0192a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sharelogic.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6727e extends AbstractC6725c {

    /* JADX INFO: renamed from: e */
    public static final ExecutorService f4078e = AbstractC4539a.m3201k("MdeDeleteLogic");

    /* JADX INFO: renamed from: f */
    public static C6719b f4079f = null;

    /* JADX INFO: renamed from: g */
    public static final CopyOnWriteArrayList f4080g = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: h */
    public static long f4081h = 0;

    /* JADX INFO: renamed from: d */
    public C6907j f4082d;

    /* JADX INFO: renamed from: b */
    public static void m4818b(InterfaceC0192a interfaceC0192a) {
        CopyOnWriteArrayList copyOnWriteArrayList = f4080g;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (((InterfaceC0192a) it.next()).equals(interfaceC0192a)) {
                return;
            }
        }
        copyOnWriteArrayList.add(interfaceC0192a);
        Debugger.m8607d("MdeDeleteLogic", "Added progress listener - size : " + copyOnWriteArrayList.size());
    }

    /* JADX INFO: renamed from: c */
    public static boolean m4819c() {
        C6719b c6719b = f4079f;
        boolean z = false;
        if (c6719b != null && c6719b.f4053a != 1) {
            z = true;
        }
        Debugger.m8615i("MdeDeleteLogic", "isMdeDeleting : " + z);
        return z;
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sharelogic.AbstractC6725c
    /* JADX INFO: renamed from: a */
    public final void mo4817a(Message message) {
        int i = message.what;
        if (i != 200) {
            if (i != 300) {
                return;
            }
            AbstractC0000a.m0A(message.arg1, "startDeleteLocalAll : msgCode = ", "MdeDeleteLogic");
            C6719b c6719b = f4079f;
            ExecutorService executorService = f4078e;
            c6719b.f4054b.bindService(new Intent(c6719b.f4054b, (Class<?>) c6719b.f4057e), c6719b.f4059g, 1);
            synchronized (c6719b) {
                new DeleteLocalSharedSdocTask(DeleteLocalSharedSdocTask.DeleteType.ALL, null, c6719b).executeOnExecutor(executorService, new Void[0]);
            }
            return;
        }
        int i2 = message.arg1;
        Object obj = message.obj;
        Debugger.m8615i("MdeDeleteLogic", "startDelete : msgCode = " + i2);
        f4081h = System.currentTimeMillis();
        if (!(obj instanceof C6729g)) {
            Debugger.m8609e("MdeDeleteLogic", "startDelete : messageObj is invalid!");
            Debugger.m8616s("MdeDeleteLogic", "can't start deleting now!");
            return;
        }
        C6729g c6729g = (C6729g) obj;
        String str = c6729g.f4088a;
        List list = c6729g.f4089b;
        Iterator it = f4080g.iterator();
        while (it.hasNext()) {
            ((InterfaceC0192a) it.next()).onStarted(str);
        }
        f4079f.m4813j(f4078e, str, list);
    }
}
