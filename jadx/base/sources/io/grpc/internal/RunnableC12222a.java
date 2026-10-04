package io.grpc.internal;

import io.grpc.internal.RetryingNameResolver;

/* JADX INFO: renamed from: io.grpc.internal.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC12222a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8837a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8838b;

    public /* synthetic */ RunnableC12222a(Object obj, int i) {
        this.f8837a = i;
        this.f8838b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8837a) {
            case 0:
                ((BackoffPolicyRetryScheduler) this.f8838b).lambda$reset$0();
                break;
            default:
                ((RetryingNameResolver.RetryingListener) this.f8838b).lambda$onError$0();
                break;
        }
    }
}
