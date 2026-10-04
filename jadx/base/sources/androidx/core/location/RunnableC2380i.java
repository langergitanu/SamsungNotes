package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;
import java.util.List;

/* JADX INFO: renamed from: androidx.core.location.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2380i implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1299a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f1300b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1301c;

    public /* synthetic */ RunnableC2380i(LocationManagerCompat.LocationListenerTransport locationListenerTransport, Object obj, int i) {
        this.f1299a = i;
        this.f1300b = locationListenerTransport;
        this.f1301c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1299a) {
            case 0:
                this.f1300b.lambda$onLocationChanged$1((List) this.f1301c);
                break;
            default:
                this.f1300b.lambda$onLocationChanged$0((Location) this.f1301c);
                break;
        }
    }
}
