package com.samsung.android.sdk.scs.p142ai.translation;

import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslationRunnable;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.translation.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC7779b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5231a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5232b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f5233c;

    public /* synthetic */ RunnableC7779b(Object obj, Object obj2, int i) {
        this.f5231a = i;
        this.f5233c = obj;
        this.f5232b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5231a) {
            case 0:
                ((NeuralTranslationByChunkRunnable) this.f5233c).lambda$execute$0((NeuralTranslationResult) this.f5232b);
                break;
            case 1:
                ((NeuralTranslationRunnable.BinderC77761) this.f5233c).lambda$onSuccess$0((NeuralTranslationResult) this.f5232b);
                break;
            default:
                ((NeuralTranslationRunnable.BinderC77761) this.f5233c).lambda$onFailure$1((NeuralTranslationErrorCode) this.f5232b);
                break;
        }
    }
}
