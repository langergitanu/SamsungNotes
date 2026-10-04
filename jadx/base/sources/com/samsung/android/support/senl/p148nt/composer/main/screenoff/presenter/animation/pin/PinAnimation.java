package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.pin;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0010J\b\u0010\"\u001a\u00020\u001cH\u0002J\u0006\u0010#\u001a\u00020\u001cJ\u0006\u0010$\u001a\u00020\u001cR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/pin/PinAnimation;", "", "<init>", "()V", "mPinAnimationListener", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/pin/IPinAnimationListener;", "mContainer", "Landroid/view/View;", "mComposerView", "mCapturedComposerView", "Landroid/graphics/Bitmap;", "mMenuBar", "mScrollLayout", "mMainLayoutContainer", "mDummyAnimationLayout", "mIsEdited", "", "mScrollPanY", "", "mPinAnimationSet", "Landroid/view/animation/AnimationSet;", "mScaleAnimation", "Landroid/view/animation/Animation;", "mAlphaAnimation", "value", "isAnimating", "()Z", "init", "", "container", "pinAnimationListener", "composerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", Constants.IntentExtraName.IS_EDITED, "initPinAnimation", "start", "release", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PinAnimation {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SOLogger.createTag("PinAnimation");
    private boolean isAnimating;

    @Nullable
    private Animation mAlphaAnimation;

    @Nullable
    private Bitmap mCapturedComposerView;

    @Nullable
    private View mComposerView;

    @Nullable
    private View mContainer;

    @Nullable
    private View mDummyAnimationLayout;
    private boolean mIsEdited;

    @Nullable
    private View mMainLayoutContainer;

    @Nullable
    private View mMenuBar;

    @Nullable
    private IPinAnimationListener mPinAnimationListener;

    @Nullable
    private AnimationSet mPinAnimationSet;

    @Nullable
    private Animation mScaleAnimation;

    @Nullable
    private View mScrollLayout;
    private float mScrollPanY;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/pin/PinAnimation$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getBitmapFromView", "Landroid/graphics/Bitmap;", "view", "Landroid/view/View;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bitmap getBitmapFromView(View view) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvasM4740a = AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap);
            Drawable background = view.getBackground();
            if (background != null) {
                background.draw(canvasM4740a);
            } else {
                canvasM4740a.drawColor(view.getResources().getColor(C9086R.color.screenoff_main_background, null));
            }
            view.draw(canvasM4740a);
            return bitmapCreateBitmap;
        }

        private Companion() {
        }
    }

    private final void initPinAnimation() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "initPinAnimation#");
        View view = this.mContainer;
        this.mScaleAnimation = AnimationUtils.loadAnimation(view != null ? view.getContext() : null, C9086R.anim.screenoff_pin_scale);
        View view2 = this.mContainer;
        this.mAlphaAnimation = AnimationUtils.loadAnimation(view2 != null ? view2.getContext() : null, C9086R.anim.screenoff_pin_alpha);
        AnimationSet animationSet = new AnimationSet(true);
        this.mPinAnimationSet = animationSet;
        animationSet.addAnimation(this.mScaleAnimation);
        AnimationSet animationSet2 = this.mPinAnimationSet;
        if (animationSet2 != null) {
            animationSet2.addAnimation(this.mAlphaAnimation);
        }
    }

    public final void init(@NotNull View container, @Nullable IPinAnimationListener pinAnimationListener, @NotNull ComposerViewPresenter composerViewPresenter, boolean isEdited) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        SOLogger.INSTANCE.SOLoggerD(TAG, "init#");
        this.mContainer = container;
        this.mPinAnimationListener = pinAnimationListener;
        this.mComposerView = composerViewPresenter.getView();
        this.mCapturedComposerView = composerViewPresenter.captureCurrentView();
        this.mIsEdited = isEdited;
        PointF pan = composerViewPresenter.getComposerControllerManager().getScrollController().getPan();
        this.mScrollPanY = pan != null ? pan.y : 0.0f;
        this.mMenuBar = container.findViewById(C9086R.id.menu_bar_layout);
        this.mScrollLayout = container.findViewById(C9086R.id.scroll_layout);
        this.mMainLayoutContainer = container.findViewById(C9086R.id.main_layout_container);
        View viewFindViewById = container.findViewById(C9086R.id.dummy_animation_layout);
        this.mDummyAnimationLayout = viewFindViewById;
        ViewGroup viewGroup = (ViewGroup) viewFindViewById;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        View view = this.mDummyAnimationLayout;
        if (view != null) {
            view.setBackground(new BitmapDrawable(container.getResources(), INSTANCE.getBitmapFromView(container)));
        }
        initPinAnimation();
    }

    /* JADX INFO: renamed from: isAnimating, reason: from getter */
    public final boolean getIsAnimating() {
        return this.isAnimating;
    }

    public final void release() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "release#");
        Animation animation = this.mScaleAnimation;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.mScaleAnimation;
        if (animation2 != null) {
            animation2.setAnimationListener(null);
        }
        Animation animation3 = this.mAlphaAnimation;
        if (animation3 != null) {
            animation3.cancel();
        }
        Animation animation4 = this.mAlphaAnimation;
        if (animation4 != null) {
            animation4.setAnimationListener(null);
        }
        View view = this.mDummyAnimationLayout;
        if (view != null) {
            view.clearAnimation();
        }
        this.mScaleAnimation = null;
        this.mAlphaAnimation = null;
        this.mPinAnimationListener = null;
    }

    public final void start() {
        AbstractC8014b.m7211m("start# isAnimating ", this.isAnimating, SOLogger.INSTANCE, TAG);
        if (this.isAnimating) {
            return;
        }
        this.isAnimating = true;
        View view = this.mMenuBar;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.mScrollLayout;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.mMainLayoutContainer;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.mComposerView;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.mDummyAnimationLayout;
        if (view5 != null) {
            view5.setVisibility(0);
        }
        Animation animation = this.mScaleAnimation;
        if (animation != null) {
            animation.setFillAfter(false);
        }
        Animation animation2 = this.mScaleAnimation;
        if (animation2 != null) {
            animation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.animation.pin.PinAnimation.start.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation3) {
                    IPinAnimationListener iPinAnimationListener;
                    Intrinsics.checkNotNullParameter(animation3, "animation");
                    SOLogger.INSTANCE.SOLoggerD(PinAnimation.TAG, "onAnimationEnd# ScaleAnimation");
                    if (PinAnimation.this.mCapturedComposerView == null || (iPinAnimationListener = PinAnimation.this.mPinAnimationListener) == null) {
                        return;
                    }
                    iPinAnimationListener.onPinToAOD(PinAnimation.this.mCapturedComposerView, PinAnimation.this.mIsEdited, PinAnimation.this.mScrollPanY);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation3) {
                    Intrinsics.checkNotNullParameter(animation3, "animation");
                    SOLogger.INSTANCE.SOLoggerD(PinAnimation.TAG, "onAnimationRepeat# ScaleAnimation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation3) {
                    Intrinsics.checkNotNullParameter(animation3, "animation");
                    SOLogger.INSTANCE.SOLoggerD(PinAnimation.TAG, "onAnimationStart# ScaleAnimation");
                }
            });
        }
        Animation animation3 = this.mAlphaAnimation;
        if (animation3 != null) {
            animation3.setFillAfter(false);
        }
        Animation animation4 = this.mAlphaAnimation;
        if (animation4 != null) {
            animation4.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.animation.pin.PinAnimation.start.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation5) {
                    Intrinsics.checkNotNullParameter(animation5, "animation");
                    SOLogger.INSTANCE.SOLoggerD(PinAnimation.TAG, "onAnimationEnd# AlphaAnimation");
                    PinAnimation.this.isAnimating = false;
                    View view6 = PinAnimation.this.mMenuBar;
                    if (view6 != null) {
                        view6.setVisibility(0);
                    }
                    View view7 = PinAnimation.this.mScrollLayout;
                    if (view7 != null) {
                        view7.setVisibility(0);
                    }
                    View view8 = PinAnimation.this.mMainLayoutContainer;
                    if (view8 != null) {
                        view8.setVisibility(0);
                    }
                    View view9 = PinAnimation.this.mComposerView;
                    if (view9 != null) {
                        view9.setVisibility(0);
                    }
                    View view10 = PinAnimation.this.mDummyAnimationLayout;
                    if (view10 != null) {
                        view10.setVisibility(8);
                    }
                    IPinAnimationListener iPinAnimationListener = PinAnimation.this.mPinAnimationListener;
                    if (iPinAnimationListener != null) {
                        iPinAnimationListener.onPinAnimationEnd();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation5) {
                    Intrinsics.checkNotNullParameter(animation5, "animation");
                    SOLogger.INSTANCE.SOLoggerD(PinAnimation.TAG, "onAnimationRepeat# AlphaAnimation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation5) {
                    Intrinsics.checkNotNullParameter(animation5, "animation");
                    SOLogger.INSTANCE.SOLoggerD(PinAnimation.TAG, "onAnimationStart# AlphaAnimation");
                }
            });
        }
        View view6 = this.mDummyAnimationLayout;
        if (view6 != null) {
            view6.startAnimation(this.mPinAnimationSet);
        }
    }
}
