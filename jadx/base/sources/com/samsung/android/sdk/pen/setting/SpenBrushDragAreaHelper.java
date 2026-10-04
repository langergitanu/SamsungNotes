package com.samsung.android.sdk.pen.setting;

import android.animation.TimeInterpolator;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import com.google.android.material.carousel.RunnableC4617a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b \u0018\u0000 %2\u00020\u0001:\u0001%B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u001b\u001a\u00020\u000fJ\u0006\u0010\u001c\u001a\u00020\u000fJ\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0005J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u0003H&R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushDragAreaHelper;", "", "guide", "Landroid/view/View;", "mHasTarget", "", "mWithYourPartner", "<init>", "(Landroid/view/View;ZZ)V", "getGuide", "()Landroid/view/View;", "setGuide", "(Landroid/view/View;)V", "mIsProcessingAnimation", "close", "", "hasTarget", "setGuideAlpha", "alpha", "", "setGuideVisibility", "visibility", "", "currentTag", "", "getCurrentTag", "()Ljava/lang/String;", "performDraggingInside", "performDraggingOutside", "transitionSet", "Landroid/transition/Transition;", "getTransitionSet", "()Landroid/transition/Transition;", "startAlphaAnimation", "visible", "startDrag", "partnerGuide", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class SpenBrushDragAreaHelper {
    public static final float ALPHA_OPAQUE = 1.0f;
    public static final float ALPHA_TRANSPARENT = 0.0f;
    private static final int ANIMATION_DURATION = 250;
    private static final int TRANSITION_DURATION = 200;

    @NotNull
    private View guide;
    private final boolean mHasTarget;
    private boolean mIsProcessingAnimation;
    private final boolean mWithYourPartner;

    @NotNull
    private static final TimeInterpolator mTransitionInterpolator = new PathInterpolator(0.4f, 0.0f, 0.4f, 1.0f);

    @NotNull
    private static final TimeInterpolator mAlphaAnimationInterpolator = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    public SpenBrushDragAreaHelper(@NotNull View guide, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(guide, "guide");
        this.guide = guide;
        this.mHasTarget = z;
        this.mWithYourPartner = z2;
    }

    private final Transition getTransitionSet() {
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setInterpolator(mTransitionInterpolator);
        changeBounds.setDuration(200L);
        return changeBounds;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAlphaAnimation$lambda$0(SpenBrushDragAreaHelper spenBrushDragAreaHelper) {
        if (spenBrushDragAreaHelper.guide.getAlpha() == 0.0f) {
            spenBrushDragAreaHelper.guide.setVisibility(8);
        }
        spenBrushDragAreaHelper.mIsProcessingAnimation = false;
    }

    @Nullable
    public final String getCurrentTag() {
        if (this.guide.getVisibility() != 0) {
            return null;
        }
        return this.guide.getTag().toString();
    }

    @NotNull
    public final View getGuide() {
        return this.guide;
    }

    /* JADX INFO: renamed from: hasTarget, reason: from getter */
    public final boolean getMHasTarget() {
        return this.mHasTarget;
    }

    public final void performDraggingInside() {
        if (this.guide.getVisibility() != 8) {
            if (this.guide.getAlpha() == 0.0f) {
                startAlphaAnimation(true);
            }
        } else if (!this.mWithYourPartner) {
            setGuideVisibility(0);
            setGuideAlpha(0.0f);
            startAlphaAnimation(true);
        } else {
            ViewParent parent = this.guide.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            TransitionManager.beginDelayedTransition((ViewGroup) parent, getTransitionSet());
            setGuideVisibility(0);
        }
    }

    public final void performDraggingOutside() {
        if (this.guide.getVisibility() != 0) {
            return;
        }
        if (!this.mWithYourPartner) {
            startAlphaAnimation(false);
            return;
        }
        ViewParent parent = this.guide.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        TransitionManager.beginDelayedTransition((ViewGroup) parent, getTransitionSet());
        this.guide.setVisibility(8);
    }

    public final void setGuide(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.guide = view;
    }

    public final void setGuideAlpha(float alpha) {
        this.guide.setAlpha(alpha);
    }

    public final void setGuideVisibility(int visibility) {
        this.guide.setVisibility(visibility);
    }

    public final void startAlphaAnimation(boolean visible) {
        if (this.mIsProcessingAnimation) {
            return;
        }
        this.mIsProcessingAnimation = true;
        this.guide.animate().setDuration(250L).setInterpolator(mAlphaAnimationInterpolator).alpha(visible ? 1.0f : 0.0f).withEndAction(new RunnableC4617a(this, 16)).start();
    }

    public abstract void startDrag(@NotNull View partnerGuide);

    public final void close() {
    }
}
