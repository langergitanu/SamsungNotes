package com.samsung.android.support.senl.addons.base.binding.adapters;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J(\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J \u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/adapters/BAVisibility;", "", "<init>", "()V", "DEBUG_LOG", "", SearchConstants.TargetContents.TAG, "", "setVisibleAndGone", "", "view", "Landroid/view/View;", "visible", "setVisibleAndGoneWithAnimation", "setVisibleAndInvisible", "setViewVisibility", "hideVisibility", "", "withAnimation", "startVisibilityAnimation", "finalVisibility", "debugLog", "content", "VisibilityAnimator", "SimpleAnimationListener", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BAVisibility {
    private static final boolean DEBUG_LOG = true;

    @NotNull
    public static final BAVisibility INSTANCE = new BAVisibility();

    @NotNull
    private static final String TAG = Logger.createTag("BAVisibility");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\"\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/adapters/BAVisibility$SimpleAnimationListener;", "Landroid/view/animation/Animation$AnimationListener;", "<init>", "()V", "onAnimationStart", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static abstract class SimpleAnimationListener implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/adapters/BAVisibility$VisibilityAnimator;", "", "mView", "Landroid/view/View;", "mFinalVisibility", "", "<init>", "(Landroid/view/View;I)V", "startAnimation", "", "onAnimationStart", "onAnimationEnd", "VisibilityAnimationListener", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class VisibilityAnimator {
        private final int mFinalVisibility;

        @Nullable
        private View mView;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/adapters/BAVisibility$VisibilityAnimator$VisibilityAnimationListener;", "Lcom/samsung/android/support/senl/addons/base/binding/adapters/BAVisibility$SimpleAnimationListener;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/binding/adapters/BAVisibility$VisibilityAnimator;)V", "onAnimationStart", "", "animation", "Landroid/view/animation/Animation;", "onAnimationEnd", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public final class VisibilityAnimationListener extends SimpleAnimationListener {
            public VisibilityAnimationListener() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(@NotNull Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                VisibilityAnimator.this.onAnimationEnd();
            }

            @Override // com.samsung.android.support.senl.addons.base.binding.adapters.BAVisibility.SimpleAnimationListener, android.view.animation.Animation.AnimationListener
            public void onAnimationStart(@NotNull Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                VisibilityAnimator.this.onAnimationStart();
            }
        }

        public VisibilityAnimator(@Nullable View view, int i) {
            this.mView = view;
            this.mFinalVisibility = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void onAnimationEnd() {
            View view = this.mView;
            if (view != null) {
                Intrinsics.checkNotNull(view);
                view.setVisibility(this.mFinalVisibility);
                BAVisibility bAVisibility = BAVisibility.INSTANCE;
                int i = this.mFinalVisibility;
                View view2 = this.mView;
                bAVisibility.debugLog("end animation : " + i + " / " + (view2 != null ? view2.hashCode() : 0));
                this.mView = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void onAnimationStart() {
            View view;
            if (this.mFinalVisibility != 0 || (view = this.mView) == null) {
                return;
            }
            Intrinsics.checkNotNull(view);
            view.setVisibility(this.mFinalVisibility);
            BAVisibility bAVisibility = BAVisibility.INSTANCE;
            int i = this.mFinalVisibility;
            View view2 = this.mView;
            bAVisibility.debugLog("start animation : " + i + " / " + (view2 != null ? view2.hashCode() : 0));
        }

        public final void startAnimation() {
            Animation animationLoadAnimation;
            View view = this.mView;
            if (view == null) {
                return;
            }
            Intrinsics.checkNotNull(view);
            Context context = view.getContext();
            if (context == null) {
                return;
            }
            if (this.mFinalVisibility == 0) {
                animationLoadAnimation = AnimationUtils.loadAnimation(context, C7944R.anim.base_view_show_with_alpha);
                Intrinsics.checkNotNull(animationLoadAnimation);
            } else {
                animationLoadAnimation = AnimationUtils.loadAnimation(context, C7944R.anim.base_view_hide_with_alpha);
                Intrinsics.checkNotNull(animationLoadAnimation);
            }
            animationLoadAnimation.setAnimationListener(new VisibilityAnimationListener());
            View view2 = this.mView;
            Intrinsics.checkNotNull(view2);
            view2.startAnimation(animationLoadAnimation);
        }
    }

    private BAVisibility() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void debugLog(String content) {
        Logger.m7100d(TAG, content);
    }

    private final void setViewVisibility(final View view, boolean visible, final int hideVisibility, final boolean withAnimation) {
        if (visible) {
            hideVisibility = 0;
        }
        if (view.getVisibility() != hideVisibility) {
            startVisibilityAnimation(view, hideVisibility, withAnimation);
            return;
        }
        Animation animation = view.getAnimation();
        if (animation != null) {
            animation.cancel();
            animation.setAnimationListener(new SimpleAnimationListener() { // from class: com.samsung.android.support.senl.addons.base.binding.adapters.BAVisibility.setViewVisibility.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation2) {
                    Intrinsics.checkNotNullParameter(animation2, "animation");
                    BAVisibility.INSTANCE.startVisibilityAnimation(view, hideVisibility, withAnimation);
                }
            });
        }
        debugLog(AbstractC1038a.m1214o(hideVisibility, view.hashCode(), "already set target visibility - ", " / "));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startVisibilityAnimation(View view, int finalVisibility, boolean withAnimation) {
        if (withAnimation) {
            new VisibilityAnimator(view, finalVisibility).startAnimation();
            debugLog(AbstractC1038a.m1214o(finalVisibility, view.hashCode(), "set visibility with animation : start to ", " / "));
        } else {
            view.setVisibility(finalVisibility);
            debugLog(AbstractC1038a.m1214o(finalVisibility, view.hashCode(), "set visibility without animation :", " / "));
        }
    }

    public final void setVisibleAndGone(@NotNull View view, boolean visible) {
        Intrinsics.checkNotNullParameter(view, "view");
        setViewVisibility(view, visible, 8, false);
    }

    public final void setVisibleAndGoneWithAnimation(@NotNull View view, boolean visible) {
        Intrinsics.checkNotNullParameter(view, "view");
        setViewVisibility(view, visible, 8, true);
    }

    public final void setVisibleAndInvisible(@NotNull View view, boolean visible) {
        Intrinsics.checkNotNullParameter(view, "view");
        setViewVisibility(view, visible, 4, false);
    }
}
