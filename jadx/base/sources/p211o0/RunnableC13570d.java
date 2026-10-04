package p211o0;

import com.samsung.android.app.notes.sync.C6662a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.concurrent.TimeUnit;
import p001A.AbstractC0000a;
import p186h1.C12020a;
import p202m1.C13526a;
import p207n1.C13541h;

/* JADX INFO: renamed from: o0.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC13570d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9622a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C13571e f9623b;

    public /* synthetic */ RunnableC13570d(C13571e c13571e, int i) {
        this.f9622a = i;
        this.f9623b = c13571e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9622a) {
            case 0:
                C13571e c13571e = this.f9623b;
                Debugger.m8615i("RequestEdpStateTask", "[EDP] run() : start RequestEdpStateTaskThread");
                try {
                    c13571e.f9625b.await(60, TimeUnit.SECONDS);
                } catch (Exception e) {
                    AbstractC0000a.m22s("[EDP] run() : fail to wait for edp state, ", e, "RequestEdpStateTask");
                }
                C6662a c6662a = c13571e.f9624a;
                if (c6662a != null) {
                    c13571e.f9626c = false;
                    C13572f c13572f = c13571e.f9627d;
                    if (c13572f == null) {
                        Debugger.m8609e("RequestEdpStateTask", "[EDP] run() : FAIL_EDP_STATE_TIMED_OUT");
                        c13571e.f9624a.mo4726a(601, "Timed out!");
                    } else if (!c13572f.f9630c) {
                        c6662a.mo4727b(c13572f);
                    } else {
                        Debugger.m8609e("RequestEdpStateTask", "[EDP] run() : fail to get edp state, errorCode = " + c13571e.f9627d.f9631d);
                        C6662a c6662a2 = c13571e.f9624a;
                        C13572f c13572f2 = c13571e.f9627d;
                        c6662a2.mo4726a(c13572f2.f9631d, c13572f2.f9632e);
                    }
                }
                break;
            default:
                C13571e c13571e2 = this.f9623b;
                Debugger.m8615i("RequestEdpStateTask", "[EDP] run() : start EdpStateApi");
                try {
                    c13571e2.getClass();
                    C13541h.m14287e().m14295i(new C13526a(c13571e2, new C12020a(c13571e2, 13), 1));
                } catch (Exception e2) {
                    c13571e2.getClass();
                    if (!(e2 instanceof SyncException)) {
                        c13571e2.f9627d = new C13572f(605, "Unknown");
                        c13571e2.f9625b.countDown();
                    }
                    SyncException syncException = (SyncException) e2;
                    int exceptionCode = syncException.getExceptionCode();
                    Debugger.m8609e("RequestEdpStateTask", "[EDP] handleException() : exceptionCode = " + exceptionCode);
                    c13571e2.f9627d = new C13572f(exceptionCode, syncException.getMessage());
                    c13571e2.f9625b.countDown();
                    return;
                }
                break;
        }
    }
}
