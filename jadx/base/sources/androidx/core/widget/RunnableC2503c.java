package androidx.core.widget;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer;

/* JADX INFO: renamed from: androidx.core.widget.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2503c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1369a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f1370b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ boolean f1371c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ ViewGroup f1372d;

    public /* synthetic */ RunnableC2503c(ViewGroup viewGroup, boolean z, boolean z2, int i) {
        this.f1369a = i;
        this.f1372d = viewGroup;
        this.f1370b = z;
        this.f1371c = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1369a) {
            case 0:
                ((NestedScrollView) this.f1372d).lambda$seslSetFadingEdgeEnabled$2(this.f1370b, this.f1371c);
                break;
            case 1:
                ((RecyclerView) this.f1372d).lambda$seslSetFadingEdgeEnabled$2(this.f1370b, this.f1371c);
                break;
            default:
                SpenSettingQTPenContainer.callAnimationListener$lambda$3(this.f1370b, (SpenSettingQTPenContainer) this.f1372d, this.f1371c);
                break;
        }
    }

    public /* synthetic */ RunnableC2503c(boolean z, SpenSettingQTPenContainer spenSettingQTPenContainer, boolean z2) {
        this.f1369a = 2;
        this.f1370b = z;
        this.f1372d = spenSettingQTPenContainer;
        this.f1371c = z2;
    }
}
