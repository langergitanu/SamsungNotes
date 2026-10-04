package com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.p137ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.TextView;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/ui/CapsuleAnimator;", "", "()V", "FADE_IN", "", "FADE_IN_ANIMATION_DELAY", "", "FADE_IN_ANIMATION_DURATION", "PIXEL_CORRECTION", "", "VIEW_WIDTH_ANIMATION_DURATION", "VIEW_WIDTH_ANIMATION_INTERPOLATOR", "Landroid/view/animation/PathInterpolator;", "startShowingAnimation", "", "context", "Landroid/content/Context;", "capsuleView", "Landroid/view/View;", "titleView", "Landroid/widget/TextView;", "delay", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class CapsuleAnimator {
    private static final float FADE_IN = 1.0f;
    private static final long FADE_IN_ANIMATION_DELAY = 350;
    private static final long FADE_IN_ANIMATION_DURATION = 200;
    private static final int PIXEL_CORRECTION = 1;
    private static final long VIEW_WIDTH_ANIMATION_DURATION = 400;

    @NotNull
    public static final CapsuleAnimator INSTANCE = new CapsuleAnimator();

    @NotNull
    private static final PathInterpolator VIEW_WIDTH_ANIMATION_INTERPOLATOR = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);

    /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.ui.CapsuleAnimator$startShowingAnimation$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m13886d2 = {"com/samsung/android/app/sdk/deepsky/textextraction/capsule/data/ui/CapsuleAnimator$startShowingAnimation$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class C70501 extends AnimatorListenerAdapter {
        final /* synthetic */ View $capsuleView;
        final /* synthetic */ float $endWidth;
        final /* synthetic */ int $startWidth;
        final /* synthetic */ TextView $titleView;

        public C70501(int i, float f, TextView textView, View view) {
            this.$startWidth = i;
            this.$endWidth = f;
            this.$titleView = textView;
            this.$capsuleView = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onAnimationStart$lambda$0(View capsuleView, ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(capsuleView, "$capsuleView");
            Intrinsics.checkNotNullParameter(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            capsuleView.getLayoutParams().width = ((Integer) animatedValue).intValue();
            capsuleView.requestLayout();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationStart(animation);
            ValueAnimator duration = ValueAnimator.ofInt(this.$startWidth, (int) this.$endWidth).setDuration(400L);
            duration.addUpdateListener(new C7051a(this.$capsuleView, 0));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(CapsuleAnimator.VIEW_WIDTH_ANIMATION_INTERPOLATOR);
            animatorSet.play(duration);
            animatorSet.start();
            this.$titleView.animate().alpha(1.0f).setInterpolator(new LinearInterpolator()).setDuration(200L).setStartDelay(350L).start();
        }
    }

    private CapsuleAnimator() {
    }

    public static /* synthetic */ void startShowingAnimation$default(CapsuleAnimator capsuleAnimator, Context context, View view, TextView textView, long j, int i, Object obj) {
        if ((i & 8) != 0) {
            j = 0;
        }
        capsuleAnimator.startShowingAnimation(context, view, textView, j);
    }

    public final void startShowingAnimation(@NotNull Context context, @NotNull View capsuleView, @NotNull TextView titleView, long delay) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(capsuleView, "capsuleView");
        Intrinsics.checkNotNullParameter(titleView, "titleView");
        capsuleView.setAlpha(0.0f);
        titleView.setAlpha(0.0f);
        titleView.setWidth((int) titleView.getPaint().measureText(titleView.getText().toString()));
        ViewGroup.LayoutParams layoutParams = capsuleView.getLayoutParams();
        if (layoutParams != null) {
            int i = layoutParams.width;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(C7039R.dimen.capsule_extract_text_action_margin_between_image_text);
            capsuleView.animate().alpha(1.0f).setInterpolator(new LinearInterpolator()).setDuration(200L).setStartDelay(delay).setListener(new C70501(i, titleView.getPaint().measureText(titleView.getText().toString()) + i + dimensionPixelSize + context.getResources().getDimensionPixelSize(C7039R.dimen.capsule_extract_text_action_margin_end) + 1, titleView, capsuleView)).start();
        }
    }
}
