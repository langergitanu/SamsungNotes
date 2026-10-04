package p057N0;

import com.samsung.android.app.notes.sync.migration.C6835r;
import com.samsung.android.app.notes.sync.synchronization.managers.C6904g;
import java.util.TimerTask;
import p042J1.AbstractC0147e;
import p042J1.C0148f;
import p244u1.C14477a;

/* JADX INFO: renamed from: N0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0180a extends TimerTask {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f565a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f566b;

    public /* synthetic */ C0180a(Object obj, int i) {
        this.f565a = i;
        this.f566b = obj;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        int i = this.f565a;
        Object obj = this.f566b;
        switch (i) {
            case 0:
                int[] iArr = (int[]) obj;
                int i2 = iArr[0];
                if (i2 != 99) {
                    int i4 = i2 + 1;
                    iArr[0] = i4;
                    String str = C0148f.f420k;
                    AbstractC0147e.f419a.getClass();
                    C0148f.m354i(i4);
                } else {
                    String str2 = C0148f.f420k;
                    AbstractC0147e.f419a.getClass();
                    C0148f.m354i(99);
                }
                break;
            case 1:
                long jCurrentTimeMillis = System.currentTimeMillis() + 2000;
                ((C6835r) obj).getClass();
                C6835r.m4997d(jCurrentTimeMillis);
                break;
            default:
                C14477a.m15065b().m15071g("by SyncReSyncManager");
                ((C6904g) obj).f4478a = false;
                break;
        }
    }
}
