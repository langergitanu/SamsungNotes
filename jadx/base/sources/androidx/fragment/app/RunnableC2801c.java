package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

/* JADX INFO: renamed from: androidx.fragment.app.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2801c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1512a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpecialEffectsController.Operation f1513b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect f1514c;

    public /* synthetic */ RunnableC2801c(SpecialEffectsController.Operation operation, DefaultSpecialEffectsController.TransitionEffect transitionEffect, int i) {
        this.f1512a = i;
        this.f1513b = operation;
        this.f1514c = transitionEffect;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1512a) {
            case 0:
                DefaultSpecialEffectsController.TransitionEffect.onStart$lambda$6$lambda$5(this.f1513b, this.f1514c);
                break;
            default:
                DefaultSpecialEffectsController.TransitionEffect.onCommit$lambda$11$lambda$10(this.f1513b, this.f1514c);
                break;
        }
    }
}
