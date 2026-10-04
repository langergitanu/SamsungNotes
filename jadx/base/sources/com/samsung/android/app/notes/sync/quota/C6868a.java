package com.samsung.android.app.notes.sync.quota;

import androidx.compose.runtime.AbstractC1974b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.quota.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6868a implements InterfaceC6872e {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C6871d f4360a;

    public C6868a(C6871d c6871d) {
        this.f4360a = c6871d;
    }

    @Override // com.samsung.android.app.notes.sync.quota.InterfaceC6872e
    /* JADX INFO: renamed from: a */
    public final void mo5055a(int i, long j, long j2) {
        StringBuilder sbM1323p = AbstractC1974b.m1323p(j, "onUpdate() : usage = ", " , total = ");
        sbM1323p.append(j2);
        Debugger.m8607d("QT/QuotaHelper", sbM1323p.toString());
        Iterator it = ((ArrayList) this.f4360a.f4367b).iterator();
        while (it.hasNext()) {
            int i2 = i;
            long j3 = j;
            long j5 = j2;
            try {
                ((InterfaceC6872e) it.next()).mo5055a(i2, j3, j5);
            } catch (Exception e) {
                AbstractC4539a.m3213w(e, new StringBuilder("onUpdate() : "), "QT/QuotaHelper");
            }
            i = i2;
            j = j3;
            j2 = j5;
        }
    }
}
