package com.samsung.android.support.senl.p148nt.base.winset.view.floater;

import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0002J(\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/SpringAnimator;", "", "contract", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/SpringAnimator$Contract;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/winset/view/floater/SpringAnimator$Contract;)V", "scaleXAnimator", "Landroidx/dynamicanimation/animation/SpringAnimation;", "scaleYAnimator", "cancelSpringAnimation", "", "animation", "runScaleAnimation", "view", "Landroid/view/View;", "targetScale", "", "stiffness", "dampingRatio", "Contract", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpringAnimator {

    @NotNull
    private static final String TAG = "SpringAnimator";

    @Nullable
    private final Contract contract;

    @Nullable
    private SpringAnimation scaleXAnimator;

    @Nullable
    private SpringAnimation scaleYAnimator;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/SpringAnimator$Contract;", "", "onAnimationEnd", "", "isScaleDown", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onAnimationEnd(boolean isScaleDown);
    }

    public SpringAnimator(@Nullable Contract contract) {
        this.contract = contract;
    }

    private final void cancelSpringAnimation(SpringAnimation animation) {
        if (animation == null || !animation.isRunning()) {
            return;
        }
        animation.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runScaleAnimation$lambda$0(SpringAnimator springAnimator, float f, DynamicAnimation dynamicAnimation, boolean z, float f4, float f5) {
        if (springAnimator.contract != null) {
            SpringAnimation springAnimation = springAnimator.scaleYAnimator;
            Boolean boolValueOf = springAnimation != null ? Boolean.valueOf(springAnimation.isRunning()) : null;
            Intrinsics.checkNotNull(boolValueOf);
            if (boolValueOf.booleanValue()) {
                return;
            }
            springAnimator.contract.onAnimationEnd(f < 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runScaleAnimation$lambda$1(SpringAnimator springAnimator, float f, DynamicAnimation dynamicAnimation, boolean z, float f4, float f5) {
        if (springAnimator.contract != null) {
            SpringAnimation springAnimation = springAnimator.scaleXAnimator;
            Boolean boolValueOf = springAnimation != null ? Boolean.valueOf(springAnimation.isRunning()) : null;
            Intrinsics.checkNotNull(boolValueOf);
            if (boolValueOf.booleanValue()) {
                return;
            }
            springAnimator.contract.onAnimationEnd(f < 1.0f);
        }
    }

    public final void runScaleAnimation(@Nullable View view, final float targetScale, float stiffness, float dampingRatio) {
        cancelSpringAnimation(this.scaleXAnimator);
        cancelSpringAnimation(this.scaleYAnimator);
        this.scaleXAnimator = new SpringAnimation(view, DynamicAnimation.SCALE_X);
        this.scaleYAnimator = new SpringAnimation(view, DynamicAnimation.SCALE_Y);
        SpringForce springForce = new SpringForce(targetScale);
        springForce.setStiffness(stiffness).setDampingRatio(dampingRatio);
        SpringAnimation springAnimation = this.scaleXAnimator;
        if (springAnimation != null) {
            springAnimation.setSpring(springForce);
        }
        SpringAnimation springAnimation2 = this.scaleYAnimator;
        if (springAnimation2 != null) {
            springAnimation2.setSpring(springForce);
        }
        SpringAnimation springAnimation3 = this.scaleXAnimator;
        if (springAnimation3 != null) {
            final int i = 0;
            springAnimation3.addEndListener(new DynamicAnimation.OnAnimationEndListener(this) { // from class: com.samsung.android.support.senl.nt.base.winset.view.floater.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SpringAnimator f6512b;

                {
                    this.f6512b = this;
                }

                @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
                    switch (i) {
                        case 0:
                            SpringAnimator.runScaleAnimation$lambda$0(this.f6512b, targetScale, dynamicAnimation, z, f, f4);
                            break;
                        default:
                            SpringAnimator.runScaleAnimation$lambda$1(this.f6512b, targetScale, dynamicAnimation, z, f, f4);
                            break;
                    }
                }
            });
        }
        SpringAnimation springAnimation4 = this.scaleYAnimator;
        if (springAnimation4 != null) {
            final int i2 = 1;
            springAnimation4.addEndListener(new DynamicAnimation.OnAnimationEndListener(this) { // from class: com.samsung.android.support.senl.nt.base.winset.view.floater.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SpringAnimator f6512b;

                {
                    this.f6512b = this;
                }

                @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
                    switch (i2) {
                        case 0:
                            SpringAnimator.runScaleAnimation$lambda$0(this.f6512b, targetScale, dynamicAnimation, z, f, f4);
                            break;
                        default:
                            SpringAnimator.runScaleAnimation$lambda$1(this.f6512b, targetScale, dynamicAnimation, z, f, f4);
                            break;
                    }
                }
            });
        }
        SpringAnimation springAnimation5 = this.scaleXAnimator;
        if (springAnimation5 != null) {
            springAnimation5.start();
        }
        SpringAnimation springAnimation6 = this.scaleYAnimator;
        if (springAnimation6 != null) {
            springAnimation6.start();
        }
    }
}
