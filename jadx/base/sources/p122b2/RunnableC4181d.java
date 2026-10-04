package p122b2;

import com.samsung.android.mcf.continuity.impl.ContinuityConnection;
import java.net.Socket;
import java.util.function.Consumer;

/* JADX INFO: renamed from: b2.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC4181d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1767a = 1;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ContinuityConnection f1768b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Socket f1769c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Consumer f1770d;

    public /* synthetic */ RunnableC4181d(ContinuityConnection continuityConnection, Socket socket, Consumer consumer) {
        this.f1768b = continuityConnection;
        this.f1769c = socket;
        this.f1770d = consumer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1767a) {
            case 0:
                this.f1768b.lambda$connectAndSetControlSocket$0(this.f1770d, this.f1769c);
                break;
            default:
                this.f1768b.lambda$setControlSocket$3(this.f1769c, this.f1770d);
                break;
        }
    }

    public /* synthetic */ RunnableC4181d(ContinuityConnection continuityConnection, Consumer consumer, Socket socket) {
        this.f1768b = continuityConnection;
        this.f1770d = consumer;
        this.f1769c = socket;
    }
}
