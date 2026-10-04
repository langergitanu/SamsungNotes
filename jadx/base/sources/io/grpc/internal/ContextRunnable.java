package io.grpc.internal;

import io.grpc.Context;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class ContextRunnable implements Runnable {
    private final Context context;

    public ContextRunnable(Context context) {
        this.context = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context contextAttach = this.context.attach();
        try {
            runInContext();
        } finally {
            this.context.detach(contextAttach);
        }
    }

    public abstract void runInContext();
}
