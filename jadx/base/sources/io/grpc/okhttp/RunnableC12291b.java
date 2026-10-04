package io.grpc.okhttp;

import io.grpc.internal.SerializingExecutor;
import io.grpc.okhttp.OkHttpServerStream;
import io.grpc.okhttp.OkHttpServerTransport;
import java.util.List;

/* JADX INFO: renamed from: io.grpc.okhttp.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class RunnableC12291b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8847a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8848b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f8849c;

    public /* synthetic */ RunnableC12291b(Object obj, Object obj2, int i) {
        this.f8847a = i;
        this.f8848b = obj;
        this.f8849c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8847a) {
            case 0:
                ((OkHttpServerStream.TransportState) this.f8848b).lambda$sendTrailers$0((List) this.f8849c);
                break;
            case 1:
                ((OkHttpServerTransport) this.f8848b).lambda$start$0((SerializingExecutor) this.f8849c);
                break;
            default:
                ((OkHttpServerTransport.FrameHandler) this.f8848b).lambda$respondWithHttpError$0((OkHttpServerTransport.Http2ErrorStreamState) this.f8849c);
                break;
        }
    }
}
