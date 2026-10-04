package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

import android.animation.ValueAnimator;
import android.view.View;
import com.samsung.android.sesl.visualeffect.lighteffects.common.config.AnimatableAttribute;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectControl;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.o */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10889o implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7323a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7324b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f7325c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f7326d;

    public /* synthetic */ C10889o(Object obj, int i, Object obj2, Object obj3) {
        this.f7323a = i;
        this.f7324b = obj;
        this.f7325c = obj2;
        this.f7326d = obj3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f7323a) {
            case 0:
                VoiceRecordSimpleMenu.hideAnimationRecording$lambda$8((VoiceRecordSimpleMenu) this.f7324b, (View) this.f7325c, (View) this.f7326d, valueAnimator);
                break;
            default:
                AnimatableAttribute.applyAttrs$lambda$3$lambda$0((ValueAnimator) this.f7324b, (AnimatableAttribute) this.f7325c, (VibeEffectControl) this.f7326d, valueAnimator);
                break;
        }
    }
}
