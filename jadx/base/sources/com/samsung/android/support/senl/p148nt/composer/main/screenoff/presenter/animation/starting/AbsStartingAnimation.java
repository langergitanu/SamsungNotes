package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting;

import android.animation.Animator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.SimpleColorFilter;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.C7975a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b&\u0018\u0000 42\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H$J\b\u0010$\u001a\u00020#H$J,\u0010)\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010\u00112\b\u0010+\u001a\u0004\u0018\u00010\u00172\u0006\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020#H\u0016J\b\u0010/\u001a\u00020#H\u0016J\b\u00100\u001a\u00020#H\u0016J\u0010\u00103\u001a\u00020#2\u0006\u0010,\u001a\u00020&H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0012\u0010%\u001a\u00020&X¤\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u00101\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u001fR\u0014\u00102\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u001f¨\u00065"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/starting/AbsStartingAnimation;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/starting/IStartingAnimation;", "<init>", "()V", "mStartingAnimationListener", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/starting/IStartingAnimationListener;", "getMStartingAnimationListener", "()Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/starting/IStartingAnimationListener;", "setMStartingAnimationListener", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/starting/IStartingAnimationListener;)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mContainer", "Landroid/view/View;", "getMContainer", "()Landroid/view/View;", "setMContainer", "(Landroid/view/View;)V", "mAnimationView", "Lcom/airbnb/lottie/LottieAnimationView;", "getMAnimationView", "()Lcom/airbnb/lottie/LottieAnimationView;", "setMAnimationView", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "mIsAnimating", "", "getMIsAnimating", "()Z", "setMIsAnimating", "(Z)V", "initPosition", "", "initSystemValues", "startOffset", "", "getStartOffset", "()I", "init", "container", "animationView", "color", "startingAnimationListener", "start", "stop", "release", "isAnimating", "isValid", "initAnimation", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsStartingAnimation implements IStartingAnimation {

    @NotNull
    private static final String TAG = SOLogger.createTag("AbsStartingAnimation");

    @Nullable
    private LottieAnimationView mAnimationView;

    @Nullable
    private View mContainer;

    @Nullable
    private Context mContext;
    private boolean mIsAnimating;

    @Nullable
    private IStartingAnimationListener mStartingAnimationListener;

    private final void initAnimation(int color) {
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & color)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        sOLogger.SOLoggerD(str, "initAnimation# color ".concat(str2));
        LottieAnimationView lottieAnimationView = this.mAnimationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.addValueCallback(new KeyPath("**"), LottieProperty.COLOR_FILTER, new C7975a(color, 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ColorFilter initAnimation$lambda$1(int i, LottieFrameInfo lottieFrameInfo) {
        return new SimpleColorFilter(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void start$lambda$0(AbsStartingAnimation absStartingAnimation) {
        LottieAnimationView lottieAnimationView = absStartingAnimation.mAnimationView;
        if (lottieAnimationView == null || lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.playAnimation();
    }

    @Nullable
    public final LottieAnimationView getMAnimationView() {
        return this.mAnimationView;
    }

    @Nullable
    public final View getMContainer() {
        return this.mContainer;
    }

    @Nullable
    public final Context getMContext() {
        return this.mContext;
    }

    public final boolean getMIsAnimating() {
        return this.mIsAnimating;
    }

    @Nullable
    public final IStartingAnimationListener getMStartingAnimationListener() {
        return this.mStartingAnimationListener;
    }

    public abstract int getStartOffset();

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.IStartingAnimation
    public void init(@Nullable View container, @Nullable LottieAnimationView animationView, int color, @NotNull IStartingAnimationListener startingAnimationListener) {
        Intrinsics.checkNotNullParameter(startingAnimationListener, "startingAnimationListener");
        SOLogger.INSTANCE.SOLoggerD(TAG, "init#");
        this.mContainer = container;
        this.mContext = container != null ? container.getContext() : null;
        this.mAnimationView = animationView;
        this.mStartingAnimationListener = startingAnimationListener;
        initSystemValues();
        initAnimation(color);
    }

    public abstract void initPosition();

    public abstract void initSystemValues();

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.IStartingAnimation
    public boolean isAnimating() {
        return this.mIsAnimating;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.IStartingAnimation
    public boolean isValid() {
        return this.mAnimationView != null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.IStartingAnimation
    public void release() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "release#");
        LottieAnimationView lottieAnimationView = this.mAnimationView;
        if (lottieAnimationView != null) {
            if (lottieAnimationView != null) {
                lottieAnimationView.cancelAnimation();
            }
            LottieAnimationView lottieAnimationView2 = this.mAnimationView;
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.removeAllAnimatorListeners();
            }
        }
        this.mAnimationView = null;
        this.mStartingAnimationListener = null;
    }

    public final void setMAnimationView(@Nullable LottieAnimationView lottieAnimationView) {
        this.mAnimationView = lottieAnimationView;
    }

    public final void setMContainer(@Nullable View view) {
        this.mContainer = view;
    }

    public final void setMContext(@Nullable Context context) {
        this.mContext = context;
    }

    public final void setMIsAnimating(boolean z) {
        this.mIsAnimating = z;
    }

    public final void setMStartingAnimationListener(@Nullable IStartingAnimationListener iStartingAnimationListener) {
        this.mStartingAnimationListener = iStartingAnimationListener;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.IStartingAnimation
    public void start() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "start# isAnimating " + isAnimating());
        if (!isValid() || isAnimating()) {
            return;
        }
        this.mIsAnimating = true;
        initPosition();
        LottieAnimationView lottieAnimationView = this.mAnimationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.animation.starting.AbsStartingAnimation.start.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    SOLogger.INSTANCE.SOLoggerD(AbsStartingAnimation.TAG, "onAnimationCancel#");
                    LottieAnimationView mAnimationView = AbsStartingAnimation.this.getMAnimationView();
                    if (mAnimationView != null) {
                        mAnimationView.removeAllAnimatorListeners();
                    }
                    LottieAnimationView mAnimationView2 = AbsStartingAnimation.this.getMAnimationView();
                    if ((mAnimationView2 != null ? mAnimationView2.getParent() : null) != null) {
                        LottieAnimationView mAnimationView3 = AbsStartingAnimation.this.getMAnimationView();
                        ViewParent parent = mAnimationView3 != null ? mAnimationView3.getParent() : null;
                        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                        ((ViewGroup) parent).removeView(AbsStartingAnimation.this.getMAnimationView());
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    SOLogger.INSTANCE.SOLoggerD(AbsStartingAnimation.TAG, "onAnimationEnd#");
                    AbsStartingAnimation.this.setMIsAnimating(false);
                    LottieAnimationView mAnimationView = AbsStartingAnimation.this.getMAnimationView();
                    if (mAnimationView != null) {
                        mAnimationView.removeAllAnimatorListeners();
                    }
                    LottieAnimationView mAnimationView2 = AbsStartingAnimation.this.getMAnimationView();
                    if ((mAnimationView2 != null ? mAnimationView2.getParent() : null) != null) {
                        LottieAnimationView mAnimationView3 = AbsStartingAnimation.this.getMAnimationView();
                        ViewParent parent = mAnimationView3 != null ? mAnimationView3.getParent() : null;
                        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                        ((ViewGroup) parent).removeView(AbsStartingAnimation.this.getMAnimationView());
                    }
                    IStartingAnimationListener mStartingAnimationListener = AbsStartingAnimation.this.getMStartingAnimationListener();
                    if (mStartingAnimationListener != null) {
                        mStartingAnimationListener.onStartingAnimationEnd();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    SOLogger.INSTANCE.SOLoggerD(AbsStartingAnimation.TAG, "onAnimationRepeat#");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    SOLogger.INSTANCE.SOLoggerD(AbsStartingAnimation.TAG, "onAnimationStart#");
                    IStartingAnimationListener mStartingAnimationListener = AbsStartingAnimation.this.getMStartingAnimationListener();
                    if (mStartingAnimationListener != null) {
                        mStartingAnimationListener.onStartingAnimationStart();
                    }
                }
            });
        }
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC9767a(this, 23), getStartOffset());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.IStartingAnimation
    public void stop() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "stop#");
        this.mIsAnimating = false;
        LottieAnimationView lottieAnimationView = this.mAnimationView;
        if (lottieAnimationView != null) {
            if (lottieAnimationView != null) {
                lottieAnimationView.cancelAnimation();
            }
            LottieAnimationView lottieAnimationView2 = this.mAnimationView;
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.removeAllAnimatorListeners();
            }
        }
        this.mAnimationView = null;
        IStartingAnimationListener iStartingAnimationListener = this.mStartingAnimationListener;
        if (iStartingAnimationListener == null || iStartingAnimationListener == null) {
            return;
        }
        iStartingAnimationListener.onStartingAnimationEnd();
    }
}
