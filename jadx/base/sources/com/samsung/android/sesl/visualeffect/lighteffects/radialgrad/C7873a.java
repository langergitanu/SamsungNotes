package com.samsung.android.sesl.visualeffect.lighteffects.radialgrad;

import android.animation.ValueAnimator;
import android.view.View;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbar;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7873a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5343a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f5344b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f5345c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f5346d;

    public /* synthetic */ C7873a(Object obj, int i, Object obj2, int i2) {
        this.f5343a = i2;
        this.f5345c = obj;
        this.f5344b = i;
        this.f5346d = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f5343a) {
            case 0:
                AnimationHelper.buildColorAnimation$lambda$1$lambda$0((RadialGradRenderEffect) this.f5345c, this.f5344b, (ValueAnimator) this.f5346d, valueAnimator);
                break;
            default:
                CustomToolbar.setupHeightAnimator$lambda$9((CustomToolbar) this.f5345c, this.f5344b, (View) this.f5346d, valueAnimator);
                break;
        }
    }
}
