package p122b2;

import com.samsung.android.mcf.continuity.api.ContinuityMessageManager;

/* JADX INFO: renamed from: b2.u */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC4198u implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1817a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ContinuityMessageManager.MessageListener f1818b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f1819c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ byte[] f1820d;

    public /* synthetic */ RunnableC4198u(ContinuityMessageManager.MessageListener messageListener, String str, byte[] bArr, int i) {
        this.f1817a = i;
        this.f1818b = messageListener;
        this.f1819c = str;
        this.f1820d = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1817a) {
            case 0:
                this.f1818b.onReceived(this.f1819c, this.f1820d);
                break;
            default:
                this.f1818b.onReceived(this.f1819c, this.f1820d);
                break;
        }
    }
}
