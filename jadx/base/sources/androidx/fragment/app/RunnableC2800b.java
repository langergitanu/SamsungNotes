package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4;
import java.util.ArrayList;
import kotlin.jvm.internal.Ref;

/* JADX INFO: renamed from: androidx.fragment.app.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2800b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1510a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1511b;

    public /* synthetic */ RunnableC2800b(Object obj, int i) {
        this.f1510a = i;
        this.f1511b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1510a) {
            case 0:
                DefaultSpecialEffectsController.TransitionEffect.createMergedTransition$lambda$14((ArrayList) this.f1511b);
                break;
            case 1:
                DefaultSpecialEffectsController.TransitionEffect.onStart$lambda$6$lambda$4((Ref.ObjectRef) this.f1511b);
                break;
            case 2:
                DefaultSpecialEffectsController$TransitionEffect$onStart$4.C27542.invoke$lambda$4((DefaultSpecialEffectsController.TransitionEffect) this.f1511b);
                break;
            case 3:
                ((Fragment) this.f1511b).lambda$performCreateView$1();
                break;
            default:
                ((FragmentManager) this.f1511b).lambda$cancelBackStackTransition$4();
                break;
        }
    }
}
