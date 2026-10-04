package com.google.android.material.oneui.floatingactioncontainer;

import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.google.android.material.oneui.floatingdock.FloatingPaneLayout;
import com.google.android.material.oneui.floatingdock.FloatingPaneView;

/* JADX INFO: renamed from: com.google.android.material.oneui.floatingactioncontainer.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4778c implements DynamicAnimation.OnAnimationUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2318a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ View f2319b;

    public /* synthetic */ C4778c(View view, int i) {
        this.f2318a = i;
        this.f2319b = view;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
        switch (this.f2318a) {
            case 0:
                FloatingGroupLayout.startSpringScaleAnimationInternal$lambda$13$lambda$12(this.f2319b, dynamicAnimation, f, f4);
                break;
            case 1:
                FloatingPaneLayout.minimizedIconScaleShowAnimation$lambda$23$lambda$22((FloatingPaneLayout) this.f2319b, dynamicAnimation, f, f4);
                break;
            default:
                FloatingPaneView.hide$lambda$24$lambda$22((FloatingPaneView) this.f2319b, dynamicAnimation, f, f4);
                break;
        }
    }
}
