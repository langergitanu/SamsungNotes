package com.google.android.material.oneui.floatingdock;

import android.graphics.Rect;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: renamed from: com.google.android.material.oneui.floatingdock.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4795f implements DynamicAnimation.OnAnimationEndListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2338a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FloatingPaneView f2339b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Rect f2340c;

    public /* synthetic */ C4795f(int i, Rect rect, FloatingPaneView floatingPaneView) {
        this.f2338a = i;
        this.f2339b = floatingPaneView;
        this.f2340c = rect;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        switch (this.f2338a) {
            case 0:
                FloatingPaneView.startMinimizeAnimation$lambda$38$lambda$37(this.f2339b, this.f2340c, dynamicAnimation, z, f, f4);
                break;
            default:
                FloatingPaneView.startUnMinimizeAnimation$lambda$46$lambda$45(this.f2339b, this.f2340c, dynamicAnimation, z, f, f4);
                break;
        }
    }
}
