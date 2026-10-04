package androidx.core.widget;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: androidx.core.widget.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2502b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1364a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f1365b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f1366c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f1367d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ ViewGroup f1368e;

    public /* synthetic */ RunnableC2502b(ViewGroup viewGroup, boolean z, int i, int i2, int i4) {
        this.f1364a = i4;
        this.f1368e = viewGroup;
        this.f1365b = z;
        this.f1366c = i;
        this.f1367d = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1364a) {
            case 0:
                ((NestedScrollView) this.f1368e).lambda$seslSetFadingEdgeEnabled$0(this.f1365b, this.f1366c, this.f1367d);
                break;
            default:
                ((RecyclerView) this.f1368e).lambda$seslSetFadingEdgeEnabled$0(this.f1365b, this.f1366c, this.f1367d);
                break;
        }
    }
}
