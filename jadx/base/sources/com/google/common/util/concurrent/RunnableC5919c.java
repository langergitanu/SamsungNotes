package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.JdkFutureAdapters;
import java.io.Closeable;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: renamed from: com.google.common.util.concurrent.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC5919c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3424a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3425b;

    public /* synthetic */ RunnableC5919c(Object obj, int i) {
        this.f3424a = i;
        this.f3425b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3424a) {
            case 0:
                ((AbstractExecutionThreadService.C58531) this.f3425b).lambda$doStart$1();
                break;
            case 1:
                ((JdkFutureAdapters.ListenableFutureAdapter) this.f3425b).lambda$addListener$0();
                break;
            case 2:
                WrappingExecutorService.lambda$wrapTask$0((Callable) this.f3425b);
                break;
            case 3:
                ClosingFuture.lambda$closeQuietly$0((Closeable) this.f3425b);
                break;
            default:
                ((Future) this.f3425b).cancel(false);
                break;
        }
    }
}
