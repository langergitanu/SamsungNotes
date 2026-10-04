package p122b2;

import com.samsung.android.mcf.continuity.impl.ContinuitySession;

/* JADX INFO: renamed from: b2.r */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC4195r implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1810a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ContinuitySession f1811b;

    public /* synthetic */ RunnableC4195r(ContinuitySession continuitySession, int i) {
        this.f1810a = i;
        this.f1811b = continuitySession;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1810a) {
            case 0:
                this.f1811b.lambda$unregisterMessageListener$11();
                break;
            case 1:
                this.f1811b.unregisterFileInfoListener();
                break;
            case 2:
                this.f1811b.unregisterPeerConnectionRequestListener();
                break;
            default:
                this.f1811b.close();
                break;
        }
    }
}
