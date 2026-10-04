package io.grpc.inprocess;

import io.grpc.inprocess.InProcessTransport;
import io.grpc.internal.StreamListener;

/* JADX INFO: renamed from: io.grpc.inprocess.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC12074b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8821a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ InProcessTransport.InProcessStream.InProcessClientStream f8822b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ StreamListener.MessageProducer f8823c;

    public /* synthetic */ RunnableC12074b(InProcessTransport.InProcessStream.InProcessClientStream inProcessClientStream, StreamListener.MessageProducer messageProducer, int i) {
        this.f8821a = i;
        this.f8822b = inProcessClientStream;
        this.f8823c = messageProducer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8821a) {
            case 0:
                this.f8822b.lambda$writeMessage$3(this.f8823c);
                break;
            default:
                this.f8822b.lambda$serverRequested$1(this.f8823c);
                break;
        }
    }
}
