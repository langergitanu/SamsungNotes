package io.grpc.okhttp;

/* JADX INFO: renamed from: io.grpc.okhttp.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class RunnableC12292c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8850a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8851b;

    public /* synthetic */ RunnableC12292c(Object obj, int i) {
        this.f8850a = i;
        this.f8851b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8850a) {
            case 0:
                ((OkHttpServerTransport) this.f8851b).triggerForcefulClose();
                break;
            case 1:
                ((OkHttpServerTransport) this.f8851b).shutdown();
                break;
            case 2:
                ((OkHttpServerTransport) this.f8851b).lambda$startIo$1();
                break;
            case 3:
                ((OkHttpServerTransport) this.f8851b).triggerGracefulSecondGoaway();
                break;
            default:
                ((OkHttpServer) this.f8851b).acceptConnections();
                break;
        }
    }
}
