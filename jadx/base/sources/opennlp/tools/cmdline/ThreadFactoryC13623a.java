package opennlp.tools.cmdline;

import java.util.concurrent.ThreadFactory;
import opennlp.tools.p217ml.maxent.GISTrainer;
import opennlp.tools.p217ml.maxent.quasinewton.ParallelNegLogLikelihood;

/* JADX INFO: renamed from: opennlp.tools.cmdline.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class ThreadFactoryC13623a implements ThreadFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9653a;

    public /* synthetic */ ThreadFactoryC13623a(int i) {
        this.f9653a = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f9653a) {
            case 0:
                return PerformanceMonitor.lambda$new$0(runnable);
            case 1:
                return GISTrainer.lambda$findParameters$0(runnable);
            default:
                return ParallelNegLogLikelihood.lambda$computeInParallel$0(runnable);
        }
    }
}
