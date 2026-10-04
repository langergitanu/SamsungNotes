package io.grpc.inprocess;

import io.grpc.inprocess.InProcessTransport;
import io.grpc.internal.StreamListener;

/* JADX INFO: renamed from: io.grpc.inprocess.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC12076d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8827a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ InProcessTransport.InProcessStream.InProcessServerStream f8828b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ StreamListener.MessageProducer f8829c;

    public /* synthetic */ RunnableC12076d(InProcessTransport.InProcessStream.InProcessServerStream inProcessServerStream, StreamListener.MessageProducer messageProducer, int i) {
        this.f8827a = i;
        this.f8828b = inProcessServerStream;
        this.f8829c = messageProducer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8827a) {
            case 0:
                this.f8828b.lambda$clientRequested$1(this.f8829c);
                break;
            default:
                this.f8828b.lambda$writeMessage$3(this.f8829c);
                break;
        }
    }
}
