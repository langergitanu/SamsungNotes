package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

/* JADX INFO: renamed from: retrofit2.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class RunnableC14461a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f10245a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.C144501 f10246b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Callback f10247c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f10248d;

    public /* synthetic */ RunnableC14461a(DefaultCallAdapterFactory.ExecutorCallbackCall.C144501 c144501, Callback callback, Object obj, int i) {
        this.f10245a = i;
        this.f10246b = c144501;
        this.f10247c = callback;
        this.f10248d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10245a) {
            case 0:
                this.f10246b.lambda$onResponse$0(this.f10247c, (Response) this.f10248d);
                break;
            default:
                this.f10246b.lambda$onFailure$1(this.f10247c, (Throwable) this.f10248d);
                break;
        }
    }
}
