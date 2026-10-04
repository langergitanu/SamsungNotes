package com.google.android.material.oneui.floatingdock;

import android.graphics.Rect;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: renamed from: com.google.android.material.oneui.floatingdock.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4788b implements DynamicAnimation.OnAnimationUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2328a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Rect f2329b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ FloatingPaneView f2330c;

    public /* synthetic */ C4788b(int i, Rect rect, FloatingPaneView floatingPaneView) {
        this.f2328a = i;
        this.f2329b = rect;
        this.f2330c = floatingPaneView;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
        switch (this.f2328a) {
            case 0:
                FloatingPaneView.startUnMinimizeAnimation$lambda$46$lambda$44(this.f2329b, this.f2330c, dynamicAnimation, f, f4);
                break;
            default:
                FloatingPaneView.startMinimizeAnimation$lambda$38$lambda$36(this.f2329b, this.f2330c, dynamicAnimation, f, f4);
                break;
        }
    }
}
