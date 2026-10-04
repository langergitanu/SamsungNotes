package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: androidx.core.location.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2383l implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1308a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f1309b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Executor f1310c;

    public /* synthetic */ RunnableC2383l(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i) {
        this.f1308a = i;
        this.f1309b = preRGnssStatusTransport;
        this.f1310c = executor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1308a) {
            case 0:
                this.f1309b.lambda$onStopped$1(this.f1310c);
                break;
            default:
                this.f1309b.lambda$onStarted$0(this.f1310c);
                break;
        }
    }
}
