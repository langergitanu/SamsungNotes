package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: androidx.core.location.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2377f implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1289a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Executor f1290b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f1291c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f1292d;

    public /* synthetic */ RunnableC2377f(Object obj, Executor executor, int i, int i2) {
        this.f1289a = i2;
        this.f1292d = obj;
        this.f1290b = executor;
        this.f1291c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1289a) {
            case 0:
                ((LocationManagerCompat.GnssMeasurementsTransport) this.f1292d).lambda$onStatusChanged$1(this.f1290b, this.f1291c);
                break;
            case 1:
                ((LocationManagerCompat.GpsStatusTransport) this.f1292d).lambda$onGpsStatusChanged$2(this.f1290b, this.f1291c);
                break;
            default:
                ((LocationManagerCompat.PreRGnssStatusTransport) this.f1292d).lambda$onFirstFix$2(this.f1290b, this.f1291c);
                break;
        }
    }
}
