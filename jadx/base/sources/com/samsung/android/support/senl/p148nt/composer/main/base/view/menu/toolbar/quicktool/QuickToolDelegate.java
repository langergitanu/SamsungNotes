package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import androidx.collection.AbstractC0622a;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001-B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J \u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017J*\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ>\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0006\u0010\"\u001a\u00020\u0012J\u0012\u0010#\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u000e\u0010)\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010*\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006."}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickToolDelegate;", "", "mView", "Landroid/view/View;", "mDelta", "", "<init>", "(Landroid/view/View;F)V", "getMView", "()Landroid/view/View;", "getMDelta", "()F", "mFlyXAnimator", "Landroidx/dynamicanimation/animation/SpringAnimation;", "mFlyYAnimator", "mDockingType", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$RotationType;", "fly", "", "velocityX", "velocityY", "dockingType", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationEndListener;", "checkDockingAnimation", "targetX", "targetY", "onAnimationEnd", "startMoveOutDockingAnimation", "onXUpdateListener", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationUpdateListener;", "startAllSpringAnimation", "stiffness", "damping", "cancelAllSpringAnimation", "cancelSpringAnimation", "animation", "getDestination", "", "dstRect", "Landroid/graphics/RectF;", "relocateAnimation", OutlinedTextFieldKt.BorderId, "getBorder", "()Landroid/graphics/RectF;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class QuickToolDelegate {

    @NotNull
    private static final String TAG = "QuickToolDelegate";
    private final float mDelta;

    @NotNull
    private SpenSettingQTPenContainer.RotationType mDockingType;

    @Nullable
    private SpringAnimation mFlyXAnimator;

    @Nullable
    private SpringAnimation mFlyYAnimator;

    @NotNull
    private final View mView;

    public QuickToolDelegate(@NotNull View mView, float f) {
        Intrinsics.checkNotNullParameter(mView, "mView");
        this.mView = mView;
        this.mDelta = f;
        this.mDockingType = SpenSettingQTPenContainer.RotationType.NONE;
    }

    private final void cancelSpringAnimation(SpringAnimation animation) {
        if (animation == null || !animation.isRunning()) {
            return;
        }
        Logger.m10999d(TAG, "cancel Spring");
        animation.cancel();
    }

    public static /* synthetic */ void fly$default(QuickToolDelegate quickToolDelegate, float f, float f4, SpenSettingQTPenContainer.RotationType rotationType, DynamicAnimation.OnAnimationEndListener onAnimationEndListener, int i, Object obj) {
        if ((i & 8) != 0) {
            onAnimationEndListener = null;
        }
        quickToolDelegate.fly(f, f4, rotationType, onAnimationEndListener);
    }

    private final boolean getDestination(RectF dstRect) {
        RectF border = getBorder();
        if (border.contains(dstRect)) {
            return false;
        }
        float fHeight = dstRect.top;
        float f = border.top;
        if (fHeight < f) {
            fHeight = f;
        } else {
            float f4 = dstRect.bottom;
            float f5 = border.bottom;
            if (f4 > f5) {
                fHeight = f5 - dstRect.height();
            }
        }
        dstRect.offsetTo(dstRect.left, fHeight);
        float f6 = dstRect.left;
        float f7 = border.left;
        if (f6 < f7) {
            dstRect.offsetTo(f7, fHeight);
            return true;
        }
        float f8 = dstRect.right;
        float f9 = border.right;
        if (f8 <= f9) {
            return true;
        }
        dstRect.offsetTo(f9 - dstRect.width(), fHeight);
        return true;
    }

    private final void startAllSpringAnimation(float targetX, float targetY, float stiffness, float damping, DynamicAnimation.OnAnimationEndListener onAnimationEnd, DynamicAnimation.OnAnimationUpdateListener onXUpdateListener) {
        SpringForce stiffness2;
        SpringForce stiffness3;
        cancelAllSpringAnimation();
        SpringAnimation springAnimation = new SpringAnimation(this.mView, DynamicAnimation.f1486Y, targetY);
        this.mFlyYAnimator = springAnimation;
        SpringForce spring = springAnimation.getSpring();
        if (spring != null && (stiffness3 = spring.setStiffness(stiffness)) != null) {
            stiffness3.setDampingRatio(damping);
        }
        SpringAnimation springAnimation2 = new SpringAnimation(this.mView, DynamicAnimation.f1485X, targetX);
        this.mFlyXAnimator = springAnimation2;
        SpringForce spring2 = springAnimation2.getSpring();
        if (spring2 != null && (stiffness2 = spring2.setStiffness(stiffness)) != null) {
            stiffness2.setDampingRatio(damping);
        }
        SpringAnimation springAnimation3 = this.mFlyXAnimator;
        if (springAnimation3 != null) {
            springAnimation3.addUpdateListener(onXUpdateListener);
        }
        SpringAnimation springAnimation4 = this.mFlyXAnimator;
        if (springAnimation4 != null) {
            springAnimation4.addEndListener(onAnimationEnd);
        }
        SpringAnimation springAnimation5 = this.mFlyXAnimator;
        if (springAnimation5 != null) {
            springAnimation5.start();
        }
        SpringAnimation springAnimation6 = this.mFlyYAnimator;
        if (springAnimation6 != null) {
            springAnimation6.start();
        }
    }

    public static /* synthetic */ void startAllSpringAnimation$default(QuickToolDelegate quickToolDelegate, float f, float f4, float f5, float f6, DynamicAnimation.OnAnimationEndListener onAnimationEndListener, DynamicAnimation.OnAnimationUpdateListener onAnimationUpdateListener, int i, Object obj) {
        if ((i & 32) != 0) {
            onAnimationUpdateListener = null;
        }
        quickToolDelegate.startAllSpringAnimation(f, f4, f5, f6, onAnimationEndListener, onAnimationUpdateListener);
    }

    public final void cancelAllSpringAnimation() {
        cancelSpringAnimation(this.mFlyXAnimator);
        cancelSpringAnimation(this.mFlyYAnimator);
    }

    public final void checkDockingAnimation(float targetX, float targetY, @Nullable DynamicAnimation.OnAnimationEndListener onAnimationEnd) {
        startAllSpringAnimation$default(this, targetX, targetY, 200.0f, 0.64f, onAnimationEnd, null, 32, null);
    }

    public final void fly(float velocityX, float velocityY, @NotNull SpenSettingQTPenContainer.RotationType dockingType, @Nullable DynamicAnimation.OnAnimationEndListener listener) {
        float f;
        float f4;
        SpringForce spring;
        SpringForce stiffness;
        SpringForce spring2;
        SpringForce stiffness2;
        Intrinsics.checkNotNullParameter(dockingType, "dockingType");
        Logger.m10999d(TAG, "fly to x:" + velocityX + ", y:" + velocityY);
        this.mDockingType = dockingType;
        float x = this.mView.getX();
        float y2 = this.mView.getY();
        PointF pointF = new PointF((velocityX * 0.3f) + x, (0.3f * velocityY) + y2);
        float f5 = pointF.x;
        RectF rectF = new RectF(f5, pointF.y, this.mView.getWidth() + f5, pointF.y + this.mView.getHeight());
        boolean destination = getDestination(rectF);
        StringBuilder sbM1176v = AbstractC0622a.m1176v("fly to drop zone : ", pointF.x, SQLKeyword.COMMA, pointF.y, " : ");
        sbM1176v.append(x);
        sbM1176v.append(SQLKeyword.COMMA);
        sbM1176v.append(y2);
        Logger.m10999d(TAG, sbM1176v.toString());
        cancelAllSpringAnimation();
        if (destination) {
            f = 400.0f;
            f4 = 0.75f;
        } else {
            f = 600.0f;
            f4 = 1.4f;
        }
        float f6 = rectF.left;
        SpringAnimation springAnimation = new SpringAnimation(this.mView, DynamicAnimation.f1486Y, rectF.top);
        this.mFlyYAnimator = springAnimation;
        springAnimation.setStartVelocity(velocityY);
        SpringAnimation springAnimation2 = this.mFlyYAnimator;
        if (springAnimation2 != null && (spring2 = springAnimation2.getSpring()) != null && (stiffness2 = spring2.setStiffness(f)) != null) {
            stiffness2.setDampingRatio(f4);
        }
        SpringAnimation springAnimation3 = this.mFlyYAnimator;
        if (springAnimation3 != null) {
            springAnimation3.addEndListener(listener);
        }
        SpringAnimation springAnimation4 = new SpringAnimation(this.mView, DynamicAnimation.f1485X, f6);
        this.mFlyXAnimator = springAnimation4;
        springAnimation4.setStartVelocity(velocityX);
        SpringAnimation springAnimation5 = this.mFlyXAnimator;
        if (springAnimation5 != null && (spring = springAnimation5.getSpring()) != null && (stiffness = spring.setStiffness(f)) != null) {
            stiffness.setDampingRatio(f4);
        }
        SpringAnimation springAnimation6 = this.mFlyXAnimator;
        if (springAnimation6 != null) {
            springAnimation6.start();
        }
        SpringAnimation springAnimation7 = this.mFlyYAnimator;
        if (springAnimation7 != null) {
            springAnimation7.start();
        }
    }

    @NotNull
    public final RectF getBorder() {
        if (this.mDockingType == SpenSettingQTPenContainer.RotationType.NONE) {
            return new RectF(0.0f - this.mView.getContext().getResources().getDimensionPixelSize(C9086R.dimen.qt_margin_start_end), 0.0f - this.mDelta, this.mView.getRootView().getWidth() + this.mView.getContext().getResources().getDimensionPixelSize(C9086R.dimen.qt_margin_start_end), this.mView.getRootView().getHeight() + this.mDelta);
        }
        float f = this.mDelta;
        return new RectF(0.0f - f, 0.0f - f, this.mView.getRootView().getWidth() + this.mDelta, this.mView.getRootView().getHeight() + this.mDelta);
    }

    public final float getMDelta() {
        return this.mDelta;
    }

    @NotNull
    public final View getMView() {
        return this.mView;
    }

    public final void relocateAnimation(@NotNull SpenSettingQTPenContainer.RotationType dockingType) {
        SpringForce stiffness;
        SpringForce stiffness2;
        Intrinsics.checkNotNullParameter(dockingType, "dockingType");
        RectF rectF = new RectF(this.mView.getX(), this.mView.getY(), this.mView.getX() + this.mView.getWidth(), this.mView.getY() + this.mView.getHeight());
        this.mDockingType = dockingType;
        if (getDestination(rectF)) {
            cancelAllSpringAnimation();
            SpringAnimation springAnimation = new SpringAnimation(this.mView, DynamicAnimation.f1486Y, rectF.top);
            this.mFlyYAnimator = springAnimation;
            SpringForce spring = springAnimation.getSpring();
            if (spring != null && (stiffness2 = spring.setStiffness(125.0f)) != null) {
                stiffness2.setDampingRatio(0.65f);
            }
            if (dockingType != SpenSettingQTPenContainer.RotationType.NONE) {
                SpringAnimation springAnimation2 = new SpringAnimation(this.mView, DynamicAnimation.f1485X, rectF.left);
                this.mFlyXAnimator = springAnimation2;
                SpringForce spring2 = springAnimation2.getSpring();
                if (spring2 != null && (stiffness = spring2.setStiffness(125.0f)) != null) {
                    stiffness.setDampingRatio(0.65f);
                }
                SpringAnimation springAnimation3 = this.mFlyXAnimator;
                if (springAnimation3 != null) {
                    springAnimation3.start();
                }
            }
            SpringAnimation springAnimation4 = this.mFlyYAnimator;
            if (springAnimation4 != null) {
                springAnimation4.start();
            }
        }
    }

    public final void startMoveOutDockingAnimation(float targetX, float targetY, @Nullable DynamicAnimation.OnAnimationEndListener onAnimationEnd, @Nullable DynamicAnimation.OnAnimationUpdateListener onXUpdateListener) {
        startAllSpringAnimation(targetX, targetY, 200.0f, 0.64f, onAnimationEnd, onXUpdateListener);
    }
}
