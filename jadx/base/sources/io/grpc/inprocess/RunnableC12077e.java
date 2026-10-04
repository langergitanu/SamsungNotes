package io.grpc.inprocess;

import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.inprocess.InProcessTransport;

/* JADX INFO: renamed from: io.grpc.inprocess.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC12077e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8830a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ InProcessTransport.InProcessStream.InProcessServerStream f8831b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Status f8832c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Metadata f8833d;

    public /* synthetic */ RunnableC12077e(InProcessTransport.InProcessStream.InProcessServerStream inProcessServerStream, Status status, Metadata metadata, int i) {
        this.f8830a = i;
        this.f8831b = inProcessServerStream;
        this.f8832c = status;
        this.f8833d = metadata;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8830a) {
            case 0:
                this.f8831b.lambda$clientRequested$2(this.f8832c, this.f8833d);
                break;
            default:
                this.f8831b.lambda$notifyClientClose$5(this.f8832c, this.f8833d);
                break;
        }
    }
}
