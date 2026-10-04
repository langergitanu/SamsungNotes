package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

/* JADX INFO: renamed from: androidx.fragment.app.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2799a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1506a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1507b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1508c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f1509d;

    public /* synthetic */ RunnableC2799a(Object obj, int i, Object obj2, Object obj3) {
        this.f1506a = i;
        this.f1507b = obj;
        this.f1508c = obj2;
        this.f1509d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1506a) {
            case 0:
                DefaultSpecialEffectsController$AnimationEffect$onCommit$1.onAnimationEnd$lambda$0((ViewGroup) this.f1507b, (View) this.f1508c, (DefaultSpecialEffectsController.AnimationEffect) this.f1509d);
                break;
            case 1:
                DefaultSpecialEffectsController.TransitionEffect.createMergedTransition$lambda$12((SpecialEffectsController.Operation) this.f1507b, (SpecialEffectsController.Operation) this.f1508c, (DefaultSpecialEffectsController.TransitionEffect) this.f1509d);
                break;
            default:
                DefaultSpecialEffectsController.TransitionEffect.createMergedTransition$lambda$13((FragmentTransitionImpl) this.f1507b, (View) this.f1508c, (Rect) this.f1509d);
                break;
        }
    }
}
