package androidx.lifecycle;

/* JADX INFO: renamed from: androidx.lifecycle.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC3570a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1622a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1623b;

    public /* synthetic */ RunnableC3570a(Object obj, int i) {
        this.f1622a = i;
        this.f1623b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1622a) {
            case 0:
                ComputableLiveData.refreshRunnable$lambda$0((ComputableLiveData) this.f1623b);
                break;
            case 1:
                ComputableLiveData.invalidationRunnable$lambda$1((ComputableLiveData) this.f1623b);
                break;
            default:
                ProcessLifecycleOwner.delayedPauseRunnable$lambda$0((ProcessLifecycleOwner) this.f1623b);
                break;
        }
    }
}
