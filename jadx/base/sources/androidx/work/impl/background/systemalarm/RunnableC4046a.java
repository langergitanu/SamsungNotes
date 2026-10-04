package androidx.work.impl.background.systemalarm;

/* JADX INFO: renamed from: androidx.work.impl.background.systemalarm.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC4046a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1728a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DelayMetCommandHandler f1729b;

    public /* synthetic */ RunnableC4046a(DelayMetCommandHandler delayMetCommandHandler, int i) {
        this.f1728a = i;
        this.f1729b = delayMetCommandHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1728a) {
            case 0:
                this.f1729b.stopWork();
                break;
            default:
                this.f1729b.startWork();
                break;
        }
    }
}
