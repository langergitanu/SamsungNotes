package com.samsung.android.sdk.scs.p142ai.translation;

import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.translation.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC7780c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5234a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TaskRunnable f5235b;

    public /* synthetic */ RunnableC7780c(TaskRunnable taskRunnable, int i) {
        this.f5234a = i;
        this.f5235b = taskRunnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5234a) {
            case 0:
                ((NeuralTranslationByChunkRunnable) this.f5235b).lambda$execute$1();
                break;
            default:
                ((NeuralTranslationRunnable) this.f5235b).lambda$execute$0();
                break;
        }
    }
}
