package androidx.fragment.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: renamed from: androidx.fragment.app.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2804f implements SavedStateRegistry.SavedStateProvider {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1520a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1521b;

    public /* synthetic */ C2804f(Object obj, int i) {
        this.f1520a = i;
        this.f1521b = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        switch (this.f1520a) {
            case 0:
                return ((FragmentActivity) this.f1521b).lambda$init$0();
            default:
                return ((FragmentManager) this.f1521b).lambda$attachController$5();
        }
    }
}
