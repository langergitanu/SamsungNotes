package com.samsung.android.app.notes.sync.contentsharing.sharelogic;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import p063P.InterfaceC0192a;
import p063P.InterfaceC0193b;
import p068Q.C0204a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sharelogic.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC6726d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4075a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f4076b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ ArrayList f4077c;

    public /* synthetic */ RunnableC6726d(InterfaceC0193b interfaceC0193b, String str, ArrayList arrayList, int i) {
        this.f4075a = i;
        this.f4076b = str;
        this.f4077c = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4075a) {
            case 0:
                String str = this.f4076b;
                ArrayList arrayList = this.f4077c;
                ExecutorService executorService = C6727e.f4078e;
                Debugger.m8607d("MdeDeleteLogic", "onFailed [" + str + "]");
                if (arrayList.isEmpty()) {
                    return;
                }
                Iterator it = C6727e.f4080g.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0192a) it.next()).onEnded(str, ((C0204a) arrayList.get(0)).f634c.f10350b);
                }
                return;
            default:
                String str2 = this.f4076b;
                ArrayList arrayList2 = this.f4077c;
                ExecutorService executorService2 = C6728f.f4083e;
                Debugger.m8609e("MdeImportLogic", "onFailed[" + str2 + "]");
                if (arrayList2.isEmpty()) {
                    return;
                }
                ArrayList arrayList3 = C6728f.f4086h;
                synchronized (arrayList3) {
                    try {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            ((InterfaceC0192a) it2.next()).onEnded(str2, ((C0204a) arrayList2.get(0)).f634c.f10350b);
                        }
                    } finally {
                    }
                    break;
                }
                return;
        }
    }
}
