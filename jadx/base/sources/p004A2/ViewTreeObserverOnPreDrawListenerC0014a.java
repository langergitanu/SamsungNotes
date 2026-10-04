package p004A2;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout;
import com.samsung.android.support.senl.addons.brush.view.canvas.BrushCanvas;

/* JADX INFO: renamed from: A2.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class ViewTreeObserverOnPreDrawListenerC0014a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f86a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ View f87b;

    public /* synthetic */ ViewTreeObserverOnPreDrawListenerC0014a(View view, int i) {
        this.f86a = i;
        this.f87b = view;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        switch (this.f86a) {
            case 0:
                return BrushCanvas.setPaintingDoc$lambda$2((BrushCanvas) this.f87b);
            default:
                return FloatingGroupLayout.onPreDrawListener$lambda$6((FloatingGroupLayout) this.f87b);
        }
    }
}
