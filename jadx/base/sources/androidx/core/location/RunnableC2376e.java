package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: androidx.core.location.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2376e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1285a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Executor f1286b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1287c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f1288d;

    public /* synthetic */ RunnableC2376e(Object obj, Executor executor, Object obj2, int i) {
        this.f1285a = i;
        this.f1287c = obj;
        this.f1286b = executor;
        this.f1288d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1285a) {
            case 0:
                ((LocationManagerCompat.GnssMeasurementsTransport) this.f1287c).lambda$onGnssMeasurementsReceived$0(this.f1286b, (GnssMeasurementsEvent) this.f1288d);
                break;
            case 1:
                ((LocationManagerCompat.GpsStatusTransport) this.f1287c).lambda$onGpsStatusChanged$3(this.f1286b, (GnssStatusCompat) this.f1288d);
                break;
            default:
                ((LocationManagerCompat.PreRGnssStatusTransport) this.f1287c).lambda$onSatelliteStatusChanged$3(this.f1286b, (GnssStatus) this.f1288d);
                break;
        }
    }
}
