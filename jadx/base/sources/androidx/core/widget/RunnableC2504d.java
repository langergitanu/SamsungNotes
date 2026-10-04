package androidx.core.widget;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: androidx.core.widget.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2504d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1373a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f1374b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ boolean f1375c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ boolean f1376d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ ViewGroup f1377e;

    public /* synthetic */ RunnableC2504d(ViewGroup viewGroup, boolean z, boolean z2, boolean z3, int i) {
        this.f1373a = i;
        this.f1377e = viewGroup;
        this.f1374b = z;
        this.f1375c = z2;
        this.f1376d = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1373a) {
            case 0:
                ((NestedScrollView) this.f1377e).lambda$seslSetFadingEdgeEnabled$3(this.f1374b, this.f1375c, this.f1376d);
                break;
            default:
                ((RecyclerView) this.f1377e).lambda$seslSetFadingEdgeEnabled$3(this.f1374b, this.f1375c, this.f1376d);
                break;
        }
    }
}
