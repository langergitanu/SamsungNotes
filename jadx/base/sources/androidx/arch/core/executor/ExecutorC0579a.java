package androidx.arch.core.executor;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: androidx.arch.core.executor.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExecutorC0579a implements Executor {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f977a;

    public /* synthetic */ ExecutorC0579a(int i) {
        this.f977a = i;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f977a) {
            case 0:
                ArchTaskExecutor.lambda$static$0(runnable);
                break;
            case 1:
                ArchTaskExecutor.lambda$static$1(runnable);
                break;
            default:
                runnable.run();
                break;
        }
    }
}
