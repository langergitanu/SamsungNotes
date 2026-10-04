package p186h1;

import com.samsung.android.app.notes.sync.migration.utils.InterruptedCountDownLatch$AbortedException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: h1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12021b extends CountDownLatch {

    /* JADX INFO: renamed from: b */
    public static final String f8773b = "SS$".concat("InterruptedCountDownLatch");

    /* JADX INFO: renamed from: a */
    public boolean f8774a;

    @Override // java.util.concurrent.CountDownLatch
    public final boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
        boolean zAwait = super.await(j, timeUnit);
        if (this.f8774a) {
            throw new InterruptedCountDownLatch$AbortedException("Interrupted");
        }
        return zAwait;
    }

    @Override // java.util.concurrent.CountDownLatch
    public final void await() throws InterruptedException {
        super.await();
        if (this.f8774a) {
            throw new InterruptedCountDownLatch$AbortedException("Interrupted");
        }
    }
}
