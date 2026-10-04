package io.grpc.inprocess;

import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.inprocess.InProcessTransport;
import io.grpc.internal.Stream;

/* JADX INFO: renamed from: io.grpc.inprocess.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC12075c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8824a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8825b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Stream f8826c;

    public /* synthetic */ RunnableC12075c(Stream stream, Object obj, int i) {
        this.f8824a = i;
        this.f8826c = stream;
        this.f8825b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8824a) {
            case 0:
                ((InProcessTransport.InProcessStream.InProcessClientStream) this.f8826c).lambda$internalCancel$4((Status) this.f8825b);
                break;
            case 1:
                ((InProcessTransport.InProcessStream.InProcessServerStream) this.f8826c).lambda$internalCancel$6((Status) this.f8825b);
                break;
            default:
                ((InProcessTransport.InProcessStream.InProcessServerStream) this.f8826c).lambda$writeHeaders$4((Metadata) this.f8825b);
                break;
        }
    }
}
