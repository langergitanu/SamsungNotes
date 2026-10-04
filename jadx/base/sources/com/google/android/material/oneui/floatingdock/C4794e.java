package com.google.android.material.oneui.floatingdock;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: renamed from: com.google.android.material.oneui.floatingdock.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4794e implements DynamicAnimation.OnAnimationEndListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2336a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FloatingPaneView f2337b;

    public /* synthetic */ C4794e(FloatingPaneView floatingPaneView, int i) {
        this.f2336a = i;
        this.f2337b = floatingPaneView;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        switch (this.f2336a) {
            case 0:
                FloatingPaneView.hide$lambda$24$lambda$23(this.f2337b, dynamicAnimation, z, f, f4);
                break;
            default:
                FloatingPaneView.show$lambda$18$lambda$17(this.f2337b, dynamicAnimation, z, f, f4);
                break;
        }
    }
}
