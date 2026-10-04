package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4;
import androidx.fragment.app.SpecialEffectsController;

/* JADX INFO: renamed from: androidx.fragment.app.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2802d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1515a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1516b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1517c;

    public /* synthetic */ RunnableC2802d(Object obj, Object obj2, int i) {
        this.f1515a = i;
        this.f1516b = obj;
        this.f1517c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1515a) {
            case 0:
                DefaultSpecialEffectsController$TransitionEffect$onStart$4.C27542.invoke$lambda$2((DefaultSpecialEffectsController.TransitionEffect) this.f1516b, (ViewGroup) this.f1517c);
                break;
            default:
                DefaultSpecialEffectsController.collectEffects$lambda$2((DefaultSpecialEffectsController) this.f1516b, (SpecialEffectsController.Operation) this.f1517c);
                break;
        }
    }
}
