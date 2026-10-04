package p122b2;

import com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice;
import com.samsung.android.mcf.continuity.api.ContinuitySessionManager;

/* JADX INFO: renamed from: b2.w */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC4200w implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1824a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ContinuitySessionManager.PeerStatusListener f1825b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f1826c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ ContinuityNearbyMyDevice f1827d;

    public /* synthetic */ RunnableC4200w(ContinuitySessionManager.PeerStatusListener peerStatusListener, int i, ContinuityNearbyMyDevice continuityNearbyMyDevice, int i2) {
        this.f1824a = i2;
        this.f1825b = peerStatusListener;
        this.f1826c = i;
        this.f1827d = continuityNearbyMyDevice;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1824a) {
            case 0:
                this.f1825b.onPeerStatusChanged(this.f1826c, this.f1827d);
                break;
            default:
                this.f1825b.onPeerStatusChanged(this.f1826c, this.f1827d);
                break;
        }
    }
}
