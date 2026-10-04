package io.grpc.inprocess;

import io.grpc.inprocess.InProcessTransport;
import io.grpc.internal.Stream;

/* JADX INFO: renamed from: io.grpc.inprocess.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC12073a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8819a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Stream f8820b;

    public /* synthetic */ RunnableC12073a(Stream stream, int i) {
        this.f8819a = i;
        this.f8820b = stream;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8819a) {
            case 0:
                ((InProcessTransport.InProcessStream.InProcessClientStream) this.f8820b).lambda$request$0();
                break;
            case 1:
                ((InProcessTransport.InProcessStream.InProcessClientStream) this.f8820b).lambda$halfClose$5();
                break;
            case 2:
                ((InProcessTransport.InProcessStream.InProcessClientStream) this.f8820b).lambda$serverRequested$2();
                break;
            default:
                ((InProcessTransport.InProcessStream.InProcessServerStream) this.f8820b).lambda$request$0();
                break;
        }
    }
}
