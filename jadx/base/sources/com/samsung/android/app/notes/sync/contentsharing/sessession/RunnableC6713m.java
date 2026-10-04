package com.samsung.android.app.notes.sync.contentsharing.sessession;

import android.os.SystemClock;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sessession.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC6713m implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ long f4036a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AbstractC6714n f4037b;

    public RunnableC6713m(AbstractC6714n abstractC6714n, long j) {
        this.f4037b = abstractC6714n;
        this.f4036a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC6714n abstractC6714n = this.f4037b;
        try {
            abstractC6714n.getClass();
            if (!AbstractC6714n.m4793i()) {
                Debugger.m8615i(abstractC6714n.mo4794a(), "[CS0-1] disconnectInternal() cancelled!");
                abstractC6714n.m4805n();
                return;
            }
            abstractC6714n.m4807p(abstractC6714n.f4044f);
            abstractC6714n.f4049k.disconnect();
            Debugger.m8615i(abstractC6714n.mo4794a(), "[CS0-1] disconnectInternal() Finish to disConnect, et = " + (SystemClock.elapsedRealtime() - this.f4036a));
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("[CS0-2] disconnectInternal() : Fail, Exception = "), abstractC6714n.mo4794a());
        }
    }
}
