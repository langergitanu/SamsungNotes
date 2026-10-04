package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10744d implements DynamicAnimation.OnAnimationEndListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7236a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ QuickToolContainer f7237b;

    public /* synthetic */ C10744d(QuickToolContainer quickToolContainer, int i) {
        this.f7236a = i;
        this.f7237b = quickToolContainer;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        switch (this.f7236a) {
            case 0:
                QuickToolContainer.restoreDocking$lambda$4$lambda$3(this.f7237b, dynamicAnimation, z, f, f4);
                break;
            default:
                this.f7237b.resetCoverQT();
                break;
        }
    }
}
