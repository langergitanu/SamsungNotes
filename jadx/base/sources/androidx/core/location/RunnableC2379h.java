package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

/* JADX INFO: renamed from: androidx.core.location.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2379h implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1296a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f1297b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f1298c;

    public /* synthetic */ RunnableC2379h(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str, int i) {
        this.f1296a = i;
        this.f1297b = locationListenerTransport;
        this.f1298c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1296a) {
            case 0:
                this.f1297b.lambda$onProviderEnabled$4(this.f1298c);
                break;
            default:
                this.f1297b.lambda$onProviderDisabled$5(this.f1298c);
                break;
        }
    }
}
