package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import androidx.dynamicanimation.animation.SpringAnimation;
import com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenItemVisibilityController;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.AnimationManager;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC7856h implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5294a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5295b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ float f5296c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f5297d;

    public /* synthetic */ RunnableC7856h(float f, SpringAnimation springAnimation, SpenQTPenItemVisibilityController.OnAnimationFinishedListener onAnimationFinishedListener) {
        this.f5294a = 2;
        this.f5296c = f;
        this.f5295b = springAnimation;
        this.f5297d = onAnimationFinishedListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5294a) {
            case 0:
                AnimationManager.createLuminanceAnimation$lambda$11((AnimationManager) this.f5295b, this.f5296c, (AnimationManager.AnimationCallback) this.f5297d);
                break;
            case 1:
                AnimationManager.hideByLuminance$lambda$23((AnimationManager) this.f5295b, this.f5296c, (AnimationManager.AnimationCallback) this.f5297d);
                break;
            default:
                SpenQTPenItemVisibilityController.startTranslationSpringAnimation$lambda$25$lambda$24(this.f5296c, (SpringAnimation) this.f5295b, (SpenQTPenItemVisibilityController.OnAnimationFinishedListener) this.f5297d);
                break;
        }
    }

    public /* synthetic */ RunnableC7856h(AnimationManager animationManager, float f, AnimationManager.AnimationCallback animationCallback, int i) {
        this.f5294a = i;
        this.f5295b = animationManager;
        this.f5296c = f;
        this.f5297d = animationCallback;
    }
}
