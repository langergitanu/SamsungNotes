package p122b2;

import com.samsung.android.mcf.continuity.api.ContinuityAdapter;

/* JADX INFO: renamed from: b2.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC4178a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1756a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ContinuityAdapter.ServiceStateListener f1757b;

    public /* synthetic */ RunnableC4178a(ContinuityAdapter.ServiceStateListener serviceStateListener, int i) {
        this.f1756a = i;
        this.f1757b = serviceStateListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1756a) {
            case 0:
                this.f1757b.onServiceDisconnected();
                break;
            default:
                this.f1757b.onServiceConnected();
                break;
        }
    }
}
