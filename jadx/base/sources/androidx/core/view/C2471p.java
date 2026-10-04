package androidx.core.view;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

/* JADX INFO: renamed from: androidx.core.view.p */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2471p implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1353a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ViewConfiguration f1354b;

    public /* synthetic */ C2471p(ViewConfiguration viewConfiguration, int i) {
        this.f1353a = i;
        this.f1354b = viewConfiguration;
    }

    @Override // androidx.core.util.Supplier
    public final Object get() {
        int scaledMaximumFlingVelocity;
        switch (this.f1353a) {
            case 0:
                scaledMaximumFlingVelocity = this.f1354b.getScaledMaximumFlingVelocity();
                break;
            default:
                scaledMaximumFlingVelocity = this.f1354b.getScaledMinimumFlingVelocity();
                break;
        }
        return Integer.valueOf(scaledMaximumFlingVelocity);
    }
}
