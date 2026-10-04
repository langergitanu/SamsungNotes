package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.samsung.android.app.notes.sync.network.InterfaceC6846k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.listeners.ProgressListener;
import com.samsung.scsp.framework.core.network.ByteBufferWriter;
import com.samsung.scsp.framework.core.network.base.PayloadWriterVisitorImpl;
import com.samsung.scsp.framework.core.network.visitor.PayloadWriterVisitor;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p001A.AbstractC0000a;
import p003A1.C0012a;
import p042J1.C0145c;
import p086V.C0322h;

/* JADX INFO: renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4512a implements SynchronizationGuard.CriticalSection, ByteBufferWriter.BufferWriterListener, FaultBarrier.ThrowableRunnable, InterfaceC6846k {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ long f2144a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f2145b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f2146c;

    public /* synthetic */ C4512a(Object obj, long j, Object obj2) {
        this.f2145b = obj;
        this.f2144a = j;
        this.f2146c = obj2;
    }

    @Override // com.samsung.android.app.notes.sync.network.InterfaceC6846k
    /* JADX INFO: renamed from: a */
    public void mo264a(int i) {
        C6903f c6903f = (C6903f) this.f2145b;
        long j = this.f2144a;
        String str = (String) this.f2146c;
        AbstractC0000a.m17n(i, "onResponse - SYNC_CATEGORY_ORDER_FILENAME = ", "SyncOldNote$SyncCategoryOrder");
        if (i == 0) {
            synchronized (C0322h.m670a().f829o.synchronizeCategory()) {
                if (C0145c.m328m(0L, "CategoryOrderTime", "CategoryOrderTimeKey") <= j) {
                    C0145c.m304L("CategoryOrderTime", "CategoryOrderDirtyKey", false);
                }
            }
            File file = new File(str);
            if (file.exists() && !file.delete()) {
                Debugger.m8609e("SyncOldNote$SyncCategoryOrder", "failed to delete zipfile");
            }
            C0012a c0012a = (C0012a) c6903f.f4474b;
            if (c0012a.f79t) {
                return;
            }
            c0012a.f79t = true;
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        return ((Uploader) this.f2145b).lambda$logAndUpdateState$8((TransportContext) this.f2146c, this.f2144a);
    }

    @Override // com.samsung.scsp.framework.core.network.ByteBufferWriter.BufferWriterListener
    public void onWritten(long j) {
        PayloadWriterVisitorImpl.lambda$visit$1((PayloadWriterVisitor.Payload) this.f2145b, (ProgressListener) this.f2146c, this.f2144a, j);
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public void run() throws InterruptedException {
        ((CountDownLatch) this.f2145b).await(this.f2144a, (TimeUnit) this.f2146c);
    }

    public /* synthetic */ C4512a(Object obj, Object obj2, long j) {
        this.f2145b = obj;
        this.f2146c = obj2;
        this.f2144a = j;
    }
}
