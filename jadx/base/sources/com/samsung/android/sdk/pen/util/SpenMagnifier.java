package com.samsung.android.sdk.pen.util;

import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Magnifier;
import com.samsung.android.imagetranslation.util.AbstractC7150s;
import com.samsung.android.sdk.pen.util.SpenMagnifier;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\tJ\u0016\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u001e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/SpenMagnifier;", "", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mMagnifier", "Landroid/widget/Magnifier;", "mVisible", "", "mHandler", "Lcom/samsung/android/sdk/pen/util/SpenMagnifier$MagnifierHandler;", "mMagnifierAnimator", "Lcom/samsung/android/sdk/pen/util/SpenMagnifier$MagnifierMotionAnimator;", "mEnableManifierAnimator", "visible", "isVisible", "()Z", "setVisible", "(Z)V", "dismiss", "", "setVisibleDelayed", Constants.IntentExtraValue.SHOW, "x", "", "y", "srcCenterX", "srcCenterY", "magnifierY", "MagnifierHandler", "MagnifierMotionAnimator", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMagnifier {
    private final boolean mEnableManifierAnimator;

    @Nullable
    private MagnifierHandler mHandler;

    @Nullable
    private Magnifier mMagnifier;

    @Nullable
    private MagnifierMotionAnimator mMagnifierAnimator;
    private boolean mVisible;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/SpenMagnifier$MagnifierHandler;", "Landroid/os/Handler;", "mMagnifier", "Lcom/samsung/android/sdk/pen/util/SpenMagnifier;", "<init>", "(Lcom/samsung/android/sdk/pen/util/SpenMagnifier;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class MagnifierHandler extends Handler {

        @NotNull
        private final SpenMagnifier mMagnifier;

        public MagnifierHandler(@NotNull SpenMagnifier mMagnifier) {
            Intrinsics.checkNotNullParameter(mMagnifier, "mMagnifier");
            this.mMagnifier = mMagnifier;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.mMagnifier.setVisible(msg.what == 1);
            super.handleMessage(msg);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/SpenMagnifier$MagnifierMotionAnimator;", "", "mMagnifier", "Landroid/widget/Magnifier;", "<init>", "(Landroid/widget/Magnifier;)V", "mAnimator", "Landroid/animation/ValueAnimator;", "mMagnifierIsShowing", "", "mAnimationStartX", "", "mAnimationStartY", "mAnimationCurrentX", "mAnimationCurrentY", "mLastX", "mLastY", Constants.IntentExtraValue.SHOW, "", "x", "y", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ARG_UPDATE, "dismiss", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class MagnifierMotionAnimator {
        private static final long DURATION = 100;
        private float mAnimationCurrentX;
        private float mAnimationCurrentY;
        private float mAnimationStartX;
        private float mAnimationStartY;

        @NotNull
        private final ValueAnimator mAnimator;
        private float mLastX;
        private float mLastY;

        @Nullable
        private final Magnifier mMagnifier;
        private boolean mMagnifierIsShowing;

        public MagnifierMotionAnimator(@Nullable Magnifier magnifier) {
            this.mMagnifier = magnifier;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            Intrinsics.checkNotNullExpressionValue(valueAnimatorOfFloat, "ofFloat(...)");
            this.mAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(100L);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.sdk.pen.util.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SpenMagnifier.MagnifierMotionAnimator._init_$lambda$0(this.f5114a, valueAnimator);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(MagnifierMotionAnimator magnifierMotionAnimator, ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Magnifier magnifier = magnifierMotionAnimator.mMagnifier;
            if (magnifier != null) {
                magnifier.update();
            }
            float f = magnifierMotionAnimator.mAnimationStartX;
            magnifierMotionAnimator.mAnimationCurrentX = (animation.getAnimatedFraction() * (magnifierMotionAnimator.mLastX - f)) + f;
            float f4 = magnifierMotionAnimator.mAnimationStartY;
            float animatedFraction = (animation.getAnimatedFraction() * (magnifierMotionAnimator.mLastY - f4)) + f4;
            magnifierMotionAnimator.mAnimationCurrentY = animatedFraction;
            Magnifier magnifier2 = magnifierMotionAnimator.mMagnifier;
            if (magnifier2 != null) {
                magnifier2.show(magnifierMotionAnimator.mAnimationCurrentX, animatedFraction);
            }
        }

        public final void dismiss() {
            Magnifier magnifier = this.mMagnifier;
            if (magnifier != null) {
                magnifier.dismiss();
            }
            this.mAnimator.cancel();
            this.mMagnifierIsShowing = false;
        }

        public final void show(float x, float y2) {
            Magnifier magnifier;
            if (this.mMagnifierIsShowing && y2 != this.mLastY) {
                if (this.mAnimator.isRunning()) {
                    this.mAnimator.cancel();
                    this.mAnimationStartX = this.mAnimationCurrentX;
                    this.mAnimationStartY = this.mAnimationCurrentY;
                } else {
                    this.mAnimationStartX = this.mLastX;
                    this.mAnimationStartY = this.mLastY;
                }
                this.mAnimator.start();
            } else if (!this.mAnimator.isRunning() && (magnifier = this.mMagnifier) != null) {
                magnifier.show(x, y2);
            }
            this.mLastX = x;
            this.mLastY = y2;
            this.mMagnifierIsShowing = true;
        }

        public final void update() {
            Magnifier magnifier = this.mMagnifier;
            if (magnifier != null) {
                magnifier.update();
            }
        }
    }

    public SpenMagnifier(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mVisible = true;
        this.mEnableManifierAnimator = true;
        if (Build.VERSION.SDK_INT >= 28) {
            this.mMagnifier = AbstractC7150s.m5512p(view);
            this.mHandler = new MagnifierHandler(this);
            this.mMagnifierAnimator = new MagnifierMotionAnimator(this.mMagnifier);
        }
    }

    public final void dismiss() {
        if (this.mEnableManifierAnimator) {
            MagnifierMotionAnimator magnifierMotionAnimator = this.mMagnifierAnimator;
            if (magnifierMotionAnimator != null) {
                magnifierMotionAnimator.dismiss();
                return;
            }
            return;
        }
        Magnifier magnifier = this.mMagnifier;
        if (magnifier != null) {
            magnifier.dismiss();
        }
    }

    /* JADX INFO: renamed from: isVisible, reason: from getter */
    public final boolean getMVisible() {
        return this.mVisible;
    }

    public final void setVisible(boolean z) {
        if (this.mVisible != z) {
            this.mVisible = z;
            if (z) {
                return;
            }
            dismiss();
        }
    }

    public final void setVisibleDelayed(boolean visible) {
        if (this.mMagnifier == null) {
            return;
        }
        MagnifierHandler magnifierHandler = this.mHandler;
        if (magnifierHandler != null) {
            magnifierHandler.removeMessages(visible ? 1 : 0);
        }
        MagnifierHandler magnifierHandler2 = this.mHandler;
        if (magnifierHandler2 != null) {
            magnifierHandler2.sendEmptyMessageDelayed(visible ? 1 : 0, 500L);
        }
    }

    public final void show(float x, float y2) {
        if (this.mVisible) {
            if (this.mEnableManifierAnimator) {
                MagnifierMotionAnimator magnifierMotionAnimator = this.mMagnifierAnimator;
                if (magnifierMotionAnimator != null) {
                    magnifierMotionAnimator.update();
                }
                MagnifierMotionAnimator magnifierMotionAnimator2 = this.mMagnifierAnimator;
                if (magnifierMotionAnimator2 != null) {
                    magnifierMotionAnimator2.show(x, y2);
                    return;
                }
                return;
            }
            Magnifier magnifier = this.mMagnifier;
            if (magnifier != null) {
                magnifier.update();
            }
            Magnifier magnifier2 = this.mMagnifier;
            if (magnifier2 != null) {
                magnifier2.show(x, y2);
            }
        }
    }

    public final void show(float srcCenterX, float srcCenterY, float magnifierY) {
        if (this.mVisible) {
            float height = magnifierY - ((this.mMagnifier != null ? r0.getHeight() : 0) / 2.0f);
            Magnifier magnifier = this.mMagnifier;
            if (magnifier != null) {
                magnifier.update();
            }
            Magnifier magnifier2 = this.mMagnifier;
            if (magnifier2 != null) {
                magnifier2.show(srcCenterX, srcCenterY, srcCenterX, height);
            }
        }
    }
}
