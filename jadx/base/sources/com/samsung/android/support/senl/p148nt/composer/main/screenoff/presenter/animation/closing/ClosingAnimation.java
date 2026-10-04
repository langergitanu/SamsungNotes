package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.closing;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.motion.widget.Key;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nJ\b\u0010 \u001a\u00020\u0017H\u0002J\b\u0010!\u001a\u00020\u0017H\u0002J\u0006\u0010#\u001a\u00020\u0017J\b\u0010$\u001a\u00020\u0017H\u0002J\b\u0010%\u001a\u00020\u0017H\u0002J\u0006\u0010&\u001a\u00020\u0017R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\"\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0015¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/closing/ClosingAnimation;", "", "<init>", "()V", "mClosingAnimationListener", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/closing/IClosingAnimationListener;", "mContainer", "Landroid/view/View;", "mComposerView", "mIsEmpty", "", "mMenuBar", "mScrollLayout", "mGuideLayout", "mMainLayoutContainer", "mDummyAnimationLayout", "mClosingSaveAnimation", "Landroid/view/animation/Animation;", "mClosingNotSaveAnimation", "value", "isAnimating", "()Z", "init", "", "container", "closingAnimationListener", "composerView", "capturedComposerView", "Landroid/graphics/Bitmap;", Key.ROTATION, "", "isEmpty", "initClosingSaveAnimation", "initClosingNotSaveAnimation", "isValid", "start", "startClosingSaveAnimation", "startClosingNotSaveAnimation", "release", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ClosingAnimation {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SOLogger.createTag("ClosingAnimation");
    private boolean isAnimating;

    @Nullable
    private IClosingAnimationListener mClosingAnimationListener;

    @Nullable
    private Animation mClosingNotSaveAnimation;

    @Nullable
    private Animation mClosingSaveAnimation;

    @Nullable
    private View mComposerView;

    @Nullable
    private View mContainer;

    @Nullable
    private View mDummyAnimationLayout;

    @Nullable
    private View mGuideLayout;
    private boolean mIsEmpty;

    @Nullable
    private View mMainLayoutContainer;

    @Nullable
    private View mMenuBar;

    @Nullable
    private View mScrollLayout;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/closing/ClosingAnimation$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getBitmapFromView", "Landroid/graphics/Bitmap;", "view", "Landroid/view/View;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
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
                Resources resources = view.getResources();
                canvasM4740a.drawColor(resources != null ? resources.getColor(C9086R.color.screenoff_main_background, null) : 0);
            }
            view.draw(canvasM4740a);
            return bitmapCreateBitmap;
        }

        private Companion() {
        }
    }

    private final void initClosingNotSaveAnimation() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "initClosingSaveAnimation#");
        View view = this.mContainer;
        this.mClosingNotSaveAnimation = AnimationUtils.loadAnimation(view != null ? view.getContext() : null, C9086R.anim.screenoff_closing_not_save);
    }

    private final void initClosingSaveAnimation() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "initClosingSaveAnimation#");
        View view = this.mContainer;
        this.mClosingSaveAnimation = AnimationUtils.loadAnimation(view != null ? view.getContext() : null, C9086R.anim.screenoff_closing_save);
    }

    private final void startClosingNotSaveAnimation() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "startClosingNotSaveAnimation#");
        View view = this.mMenuBar;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.mScrollLayout;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.mGuideLayout;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.mMainLayoutContainer;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.mComposerView;
        if (view5 != null) {
            view5.setVisibility(8);
        }
        View view6 = this.mDummyAnimationLayout;
        if (view6 != null) {
            view6.setVisibility(0);
        }
        Animation animation = this.mClosingNotSaveAnimation;
        if (animation != null) {
            animation.setFillAfter(true);
        }
        Animation animation2 = this.mClosingNotSaveAnimation;
        if (animation2 != null) {
            animation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.animation.closing.ClosingAnimation.startClosingNotSaveAnimation.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation3) {
                    Intrinsics.checkNotNullParameter(animation3, "animation");
                    SOLogger.INSTANCE.SOLoggerD(ClosingAnimation.TAG, "onAnimationEnd# ClosingNotSaveAnimation");
                    ClosingAnimation.this.isAnimating = false;
                    IClosingAnimationListener iClosingAnimationListener = ClosingAnimation.this.mClosingAnimationListener;
                    if (iClosingAnimationListener != null) {
                        iClosingAnimationListener.onClosingAnimationEnd();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation3) {
                    Intrinsics.checkNotNullParameter(animation3, "animation");
                    SOLogger.INSTANCE.SOLoggerD(ClosingAnimation.TAG, "onAnimationRepeat# ClosingNotSaveAnimation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation3) {
                    Intrinsics.checkNotNullParameter(animation3, "animation");
                    SOLogger.INSTANCE.SOLoggerD(ClosingAnimation.TAG, "onAnimationStart# ClosingNotSaveAnimation");
                }
            });
        }
        View view7 = this.mDummyAnimationLayout;
        if (view7 != null) {
            view7.startAnimation(this.mClosingNotSaveAnimation);
        }
    }

    private final void startClosingSaveAnimation() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "startClosingSaveAnimation#");
        View view = this.mMenuBar;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.mScrollLayout;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.mGuideLayout;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.mMainLayoutContainer;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.mComposerView;
        if (view5 != null) {
            view5.setVisibility(8);
        }
        View view6 = this.mDummyAnimationLayout;
        if (view6 != null) {
            view6.setVisibility(0);
        }
        Animation animation = this.mClosingSaveAnimation;
        if (animation != null) {
            animation.setFillAfter(true);
        }
        Animation animation2 = this.mClosingSaveAnimation;
        if (animation2 != null) {
            animation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.animation.closing.ClosingAnimation.startClosingSaveAnimation.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation3) {
                    Intrinsics.checkNotNullParameter(animation3, "animation");
                    SOLogger.INSTANCE.SOLoggerD(ClosingAnimation.TAG, "onAnimationEnd# ClosingSaveAnimation");
                    ClosingAnimation.this.isAnimating = false;
                    IClosingAnimationListener iClosingAnimationListener = ClosingAnimation.this.mClosingAnimationListener;
                    if (iClosingAnimationListener != null) {
                        iClosingAnimationListener.onClosingAnimationEnd();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation3) {
                    Intrinsics.checkNotNullParameter(animation3, "animation");
                    SOLogger.INSTANCE.SOLoggerD(ClosingAnimation.TAG, "onAnimationRepeat# ClosingSaveAnimation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation3) {
                    Intrinsics.checkNotNullParameter(animation3, "animation");
                    SOLogger.INSTANCE.SOLoggerD(ClosingAnimation.TAG, "onAnimationStart# ClosingSaveAnimation");
                }
            });
        }
        View view7 = this.mDummyAnimationLayout;
        if (view7 != null) {
            view7.startAnimation(this.mClosingSaveAnimation);
        }
    }

    public final void init(@NotNull View container, @Nullable IClosingAnimationListener closingAnimationListener, @Nullable View composerView, @Nullable Bitmap capturedComposerView, int rotation, boolean isEmpty) {
        Intrinsics.checkNotNullParameter(container, "container");
        AbstractC8014b.m7206h("init# rotation ", rotation, SOLogger.INSTANCE, TAG);
        this.mContainer = container;
        this.mClosingAnimationListener = closingAnimationListener;
        this.mComposerView = composerView;
        this.mIsEmpty = isEmpty;
        this.mMenuBar = container.findViewById(C9086R.id.menu_bar_layout);
        this.mScrollLayout = container.findViewById(C9086R.id.scroll_layout);
        this.mGuideLayout = container.findViewById(C9086R.id.guide_layout);
        this.mMainLayoutContainer = container.findViewById(C9086R.id.main_layout_container);
        View viewFindViewById = container.findViewById(C9086R.id.dummy_animation_layout);
        this.mDummyAnimationLayout = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setBackground(new BitmapDrawable(container.getResources(), INSTANCE.getBitmapFromView(container)));
        }
        if (this.mIsEmpty) {
            initClosingNotSaveAnimation();
        } else {
            initClosingSaveAnimation();
        }
    }

    /* JADX INFO: renamed from: isAnimating, reason: from getter */
    public final boolean getIsAnimating() {
        return this.isAnimating;
    }

    public final boolean isValid() {
        return this.mComposerView != null;
    }

    public final void release() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "release#");
        Animation animation = this.mClosingSaveAnimation;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.mClosingSaveAnimation;
        if (animation2 != null) {
            animation2.setAnimationListener(null);
        }
        Animation animation3 = this.mClosingNotSaveAnimation;
        if (animation3 != null) {
            animation3.cancel();
        }
        Animation animation4 = this.mClosingNotSaveAnimation;
        if (animation4 != null) {
            animation4.setAnimationListener(null);
        }
        View view = this.mDummyAnimationLayout;
        if (view != null) {
            view.clearAnimation();
        }
        this.mClosingSaveAnimation = null;
        this.mClosingNotSaveAnimation = null;
        this.mClosingAnimationListener = null;
    }

    public final void start() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "start#");
        if (this.isAnimating) {
            return;
        }
        if (!isValid()) {
            IClosingAnimationListener iClosingAnimationListener = this.mClosingAnimationListener;
            if (iClosingAnimationListener != null) {
                iClosingAnimationListener.onClosingAnimationEnd();
                return;
            }
            return;
        }
        this.isAnimating = true;
        if (this.mIsEmpty) {
            startClosingNotSaveAnimation();
        } else {
            startClosingSaveAnimation();
        }
    }
}
