package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common;

import android.graphics.PointF;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.common.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10399a implements DynamicAnimation.OnAnimationUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7178a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ PointF f7179b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ PointF f7180c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ GuidingLightEffect f7181d;

    public /* synthetic */ C10399a(PointF pointF, PointF pointF2, GuidingLightEffect guidingLightEffect, int i) {
        this.f7178a = i;
        this.f7179b = pointF;
        this.f7180c = pointF2;
        this.f7181d = guidingLightEffect;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
        switch (this.f7178a) {
            case 0:
                OptionMenuPopupWindowHelper.C103971.lambda$createPressOnAnimationUpdateListener$0(this.f7179b, this.f7180c, this.f7181d, dynamicAnimation, f, f4);
                break;
            default:
                OptionMenuPopupWindowHelper.C103971.lambda$createReleaseOnAnimationUpdateListener$1(this.f7179b, this.f7180c, this.f7181d, dynamicAnimation, f, f4);
                break;
        }
    }
}
