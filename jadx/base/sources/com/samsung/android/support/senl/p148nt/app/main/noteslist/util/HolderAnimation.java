package com.samsung.android.support.senl.p148nt.app.main.noteslist.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextPaint;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.chip.C4635c;
import com.google.android.material.internal.RunnableC4738b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewShapeManager;
import com.samsung.android.support.senl.p148nt.app.common.widget.HoverPopupTextView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.view.LockView;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p066P2.RunnableC0202d;
import p079T.RunnableC0284b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u001c\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J \u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0007J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0002JX\u0010#\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000eH\u0007J\"\u0010/\u001a\u00020\u00122\b\u00100\u001a\u0004\u0018\u00010%2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0002J,\u00104\u001a\u00020\u00122\b\u00105\u001a\u0004\u0018\u00010%2\b\u00106\u001a\u0004\u0018\u00010)2\u0006\u00107\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eH\u0007Jf\u00108\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u00072\u0006\u00106\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010)2\b\u0010\u001d\u001a\u0004\u0018\u00010;2\u0006\u00107\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000eH\u0007J\u0012\u0010>\u001a\u00020\u00122\b\u0010?\u001a\u0004\u0018\u00010@H\u0007J \u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020C2\u0006\u00107\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u000eH\u0003J\u0018\u0010E\u001a\u00020\u00122\u0006\u00106\u001a\u00020C2\u0006\u00107\u001a\u00020\u000eH\u0003J\u0012\u0010F\u001a\u0004\u0018\u00010G2\u0006\u00107\u001a\u00020\u000eH\u0003J4\u0010H\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010I\u001a\u0004\u0018\u00010)2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0007H\u0007J\"\u0010J\u001a\u00020\u00122\b\u0010I\u001a\u0004\u0018\u00010)2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eH\u0007J\u0010\u0010K\u001a\u00020\u00122\u0006\u0010L\u001a\u00020%H\u0007J\u001c\u0010M\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u001c\u0010M\u001a\u00020\u00122\b\u0010L\u001a\u0004\u0018\u00010%2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/util/HolderAnimation;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "HOLDER_FADE_OUT_ANIMATE_DURATION", "", "ALPHA", "SCALE_X", "SCALE_Y", "EXTENSION_VIBRATION_ATTRIBUTES", "Landroid/media/AudioAttributes;", "mIsVibrating", "", "mVibrator", "Landroid/os/Vibrator;", "initVibrator", "", "animateHolderFadeOut", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "endAction", "Ljava/lang/Runnable;", "getSubFolderCollapseAnimator", "Lkotlin/Pair;", "Landroid/animation/ObjectAnimator;", "Landroid/animation/ValueAnimator;", "updateTextViewWidthAnimation", "textView", "Landroid/widget/TextView;", "newText", "calculateTextWidth", "text", "", "decorateVoiceAnimation", "roundedView", "Landroid/view/View;", "viewMode", "voiceView", "voiceIconView", "Landroid/widget/ImageView;", "voiceText", "isVoice", "withAnimation", "isFavorite", "isListView", "startSpringTranslateY", "view", "dampingRatio", "", "stiffness", "decorateLockThumbnailAnimation", "lockBackground", "lockView", "isLock", "decorateLockAnimation", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/adapter/view/LockView;", "imageView", "Lcom/samsung/android/support/senl/nt/app/common/widget/HoverPopupTextView;", "hideRunnable", "showRunnable", "beginDelayedTransition", DBSchema.DocumentThumbnail.LAYOUT, "Landroid/view/ViewGroup;", "playLockLottieAnimation", "lottieAnimationView", "Lcom/airbnb/lottie/LottieAnimationView;", "isNightMode", "playLockCompositionEffect", "getLockCompositionEffect", "Landroid/os/VibrationEffect;", "decorateRoundFavoriteShape", "favoriteView", "decorateFavoriteAnimation", "showSearchFilterView", "itemView", "hideSearchFilterView", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nHolderAnimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HolderAnimation.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/util/HolderAnimation\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,773:1\n348#2:774\n366#2:775\n*S KotlinDebug\n*F\n+ 1 HolderAnimation.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/util/HolderAnimation\n*L\n245#1:774\n245#1:775\n*E\n"})
public final class HolderAnimation {

    @NotNull
    private static final String ALPHA = "alpha";

    @Nullable
    private static AudioAttributes EXTENSION_VIBRATION_ATTRIBUTES = null;
    private static final int HOLDER_FADE_OUT_ANIMATE_DURATION = 300;

    @NotNull
    public static final HolderAnimation INSTANCE = new HolderAnimation();

    @NotNull
    private static final String SCALE_X = "scaleX";

    @NotNull
    private static final String SCALE_Y = "scaleY";

    @NotNull
    private static final String TAG = "HolderAnimation";
    private static boolean mIsVibrating;

    @Nullable
    private static Vibrator mVibrator;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.util.HolderAnimation$updateTextViewWidthAnimation$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m13886d2 = {"com/samsung/android/support/senl/nt/app/main/noteslist/util/HolderAnimation$updateTextViewWidthAnimation$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class C85701 extends AnimatorListenerAdapter {
        final /* synthetic */ String $newText;
        final /* synthetic */ TextView $textView;

        public C85701(TextView textView, String str) {
            this.$textView = textView;
            this.$newText = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onAnimationEnd$lambda$1$lambda$0(TextView textView, ValueAnimator valueAnimator) {
            textView.setAlpha(((Float) AbstractC6670b.m4742c(valueAnimator, "anim", "null cannot be cast to non-null type kotlin.Float")).floatValue());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.$textView.setText(this.$newText);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            TextView textView = this.$textView;
            valueAnimatorOfFloat.setDuration(150L);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new C8573a(textView, 2));
            valueAnimatorOfFloat.start();
        }
    }

    private HolderAnimation() {
    }

    @JvmStatic
    public static final void animateHolderFadeOut(@Nullable RecyclerView.ViewHolder holder, @Nullable final Runnable endAction) {
        if (holder == null) {
            if (endAction != null) {
                endAction.run();
                return;
            }
            return;
        }
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 1.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.util.HolderAnimation.animateHolderFadeOut.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Runnable runnable = endAction;
                if (runnable != null) {
                    runnable.run();
                }
                MainLogger.m7258i(HolderAnimation.TAG, "animateHolderFadeOut onAnimationEnd");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                MainLogger.m7258i(HolderAnimation.TAG, "animateHolderFadeOut onAnimationStart");
            }
        });
        scaleAnimation.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f));
        alphaAnimation.setDuration(300L);
        animationSet.addAnimation(alphaAnimation);
        holder.itemView.startAnimation(animationSet);
    }

    @JvmStatic
    public static final void beginDelayedTransition(@Nullable ViewGroup layout) {
        if (layout == null) {
            return;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.setDuration(400L);
        transitionSet.setInterpolator((TimeInterpolator) PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f));
        TransitionManager.beginDelayedTransition(layout, transitionSet);
    }

    private final int calculateTextWidth(TextView textView, CharSequence text) {
        TextPaint paint = textView.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "getPaint(...)");
        return (int) (paint.measureText(text.toString()) + textView.getPaddingLeft() + textView.getPaddingRight());
    }

    @JvmStatic
    public static final void decorateFavoriteAnimation(@Nullable final ImageView favoriteView, final boolean isFavorite, boolean withAnimation) {
        if (favoriteView == null) {
            return;
        }
        if (!withAnimation) {
            favoriteView.setVisibility(isFavorite ? 0 : 8);
            return;
        }
        favoriteView.setRotation(0.0f);
        favoriteView.setScaleX(isFavorite ? 0.0f : 1.0f);
        favoriteView.setScaleY(isFavorite ? 0.0f : 1.0f);
        favoriteView.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(favoriteView, (Property<ImageView, Float>) View.ROTATION, 0.0f, isFavorite ? 360.0f : -360.0f);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f));
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(favoriteView, PropertyValuesHolder.ofFloat("scaleX", isFavorite ? 0.0f : 1.0f, isFavorite ? 1.0f : 0.0f), PropertyValuesHolder.ofFloat("scaleY", isFavorite ? 0.0f : 1.0f, isFavorite ? 1.0f : 0.0f));
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder, "ofPropertyValuesHolder(...)");
        objectAnimatorOfPropertyValuesHolder.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.util.HolderAnimation.decorateFavoriteAnimation.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                favoriteView.setRotation(0.0f);
                favoriteView.setVisibility(isFavorite ? 0 : 8);
            }
        });
        objectAnimatorOfFloat.setDuration(400L);
        objectAnimatorOfPropertyValuesHolder.setDuration(isFavorite ? 400 : 300);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfPropertyValuesHolder);
        favoriteView.postDelayed(new RunnableC7599e(animatorSet, 26), 500L);
    }

    @JvmStatic
    public static final void decorateLockAnimation(@Nullable final View roundedView, int viewMode, @NotNull final LockView lockView, @Nullable final ImageView imageView, @Nullable final HoverPopupTextView textView, final boolean isLock, boolean withAnimation, @NotNull final Runnable hideRunnable, @NotNull Runnable showRunnable, boolean isFavorite, boolean isListView) {
        Intrinsics.checkNotNullParameter(lockView, "lockView");
        Intrinsics.checkNotNullParameter(hideRunnable, "hideRunnable");
        Intrinsics.checkNotNullParameter(showRunnable, "showRunnable");
        if ((withAnimation || isLock) && withAnimation) {
            if (!isLock) {
                showRunnable.run();
            }
            if (roundedView != null) {
                roundedView.setOutlineProvider(isFavorite ? ViewShapeManager.INSTANCE.getInstance().getFavoriteNoteHolderOutlineProvider(viewMode) : ViewShapeManager.INSTANCE.getInstance().getDefaultNoteHolderOutlineProvider(viewMode));
            }
            lockView.getLockBackground().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.util.d
                @Override // java.lang.Runnable
                public final void run() {
                    HolderAnimation.decorateLockAnimation$lambda$8(lockView, isLock, imageView, textView, roundedView, hideRunnable);
                }
            }, isListView ? 500 : isLock ? 0 : 400);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void decorateLockAnimation$lambda$8(final LockView lockView, final boolean z, final ImageView imageView, final HoverPopupTextView hoverPopupTextView, final View view, final Runnable runnable) {
        lockView.getLockIcon().setScaleX(z ? 0.0f : 1.0f);
        lockView.getLockIcon().setScaleY(z ? 0.0f : 1.0f);
        lockView.getLockBackground().setAlpha(z ? 0.0f : 1.0f);
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("scaleX", z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
        PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat("scaleY", z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
        PropertyValuesHolder propertyValuesHolderOfFloat3 = PropertyValuesHolder.ofFloat("alpha", z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
        PropertyValuesHolder propertyValuesHolderOfFloat4 = PropertyValuesHolder.ofFloat("alpha", z ? 1.0f : 0.0f, z ? 0.0f : 1.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(lockView.getLockIcon(), propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder, "ofPropertyValuesHolder(...)");
        if (z) {
            lockView.getLockIcon().setAlpha(1.0f);
            objectAnimatorOfPropertyValuesHolder.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f));
        } else {
            objectAnimatorOfPropertyValuesHolder.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.67f, 1.0f));
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = imageView != null ? ObjectAnimator.ofPropertyValuesHolder(imageView, propertyValuesHolderOfFloat4) : null;
        ObjectAnimator objectAnimatorOfPropertyValuesHolder3 = hoverPopupTextView != null ? ObjectAnimator.ofPropertyValuesHolder(hoverPopupTextView, propertyValuesHolderOfFloat4) : null;
        ObjectAnimator objectAnimatorOfPropertyValuesHolder4 = ObjectAnimator.ofPropertyValuesHolder(lockView.getLockBackground(), propertyValuesHolderOfFloat3);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder4, "ofPropertyValuesHolder(...)");
        ObjectAnimator objectAnimatorOfPropertyValuesHolder5 = ObjectAnimator.ofPropertyValuesHolder(lockView.getLockIcon(), propertyValuesHolderOfFloat3);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder5, "ofPropertyValuesHolder(...)");
        objectAnimatorOfPropertyValuesHolder4.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.util.HolderAnimation$decorateLockAnimation$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                ViewParent parent;
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                View view2 = view;
                HolderAnimation.beginDelayedTransition((ViewGroup) ((view2 == null || (parent = view2.getParent()) == null) ? null : parent.getParent()));
                if (!z) {
                    runnable.run();
                    return;
                }
                ImageView imageView2 = imageView;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                HoverPopupTextView hoverPopupTextView2 = hoverPopupTextView;
                if (hoverPopupTextView2 != null) {
                    hoverPopupTextView2.setVisibility(8);
                }
                ImageView imageView3 = imageView;
                if (imageView3 != null) {
                    imageView3.setAlpha(1.0f);
                }
                HoverPopupTextView hoverPopupTextView3 = hoverPopupTextView;
                if (hoverPopupTextView3 != null) {
                    hoverPopupTextView3.setAlpha(1.0f);
                }
                ImageView imageView4 = imageView;
                if (imageView4 != null) {
                    imageView4.setScaleX(1.0f);
                }
                HoverPopupTextView hoverPopupTextView4 = hoverPopupTextView;
                if (hoverPopupTextView4 != null) {
                    hoverPopupTextView4.setScaleY(1.0f);
                }
                View lockIcon = lockView.getLockIcon();
                Intrinsics.checkNotNull(lockIcon, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                ((LottieAnimationView) lockIcon).playAnimation();
                HolderAnimation holderAnimation = HolderAnimation.INSTANCE;
                View lockIcon2 = lockView.getLockIcon();
                Intrinsics.checkNotNull(lockIcon2, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                holderAnimation.playLockCompositionEffect((LottieAnimationView) lockIcon2, true);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationStart(animation);
                View lockIcon = lockView.getLockIcon();
                Intrinsics.checkNotNull(lockIcon, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                HolderAnimation.playLockLottieAnimation((LottieAnimationView) lockIcon, z, ContextUtils.isNightMode(lockView.getLockIcon().getContext()));
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        if (z) {
            if (objectAnimatorOfPropertyValuesHolder2 == null && objectAnimatorOfPropertyValuesHolder3 == null) {
                animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder4);
            } else if (objectAnimatorOfPropertyValuesHolder2 == null) {
                animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder4, objectAnimatorOfPropertyValuesHolder3);
            } else if (objectAnimatorOfPropertyValuesHolder3 == null) {
                animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder4, objectAnimatorOfPropertyValuesHolder2);
            } else {
                animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder4, objectAnimatorOfPropertyValuesHolder2, objectAnimatorOfPropertyValuesHolder3);
            }
        } else if (objectAnimatorOfPropertyValuesHolder2 == null && objectAnimatorOfPropertyValuesHolder3 == null) {
            animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder4, objectAnimatorOfPropertyValuesHolder5);
        } else if (objectAnimatorOfPropertyValuesHolder2 == null) {
            animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder4, objectAnimatorOfPropertyValuesHolder5, objectAnimatorOfPropertyValuesHolder3);
        } else if (objectAnimatorOfPropertyValuesHolder3 == null) {
            animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder4, objectAnimatorOfPropertyValuesHolder5, objectAnimatorOfPropertyValuesHolder2);
        } else {
            animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder4, objectAnimatorOfPropertyValuesHolder5, objectAnimatorOfPropertyValuesHolder2, objectAnimatorOfPropertyValuesHolder3);
        }
        animatorSet.setDuration(z ? 200 : 350);
        animatorSet.start();
    }

    @JvmStatic
    public static final void decorateLockThumbnailAnimation(@Nullable View lockBackground, @Nullable ImageView lockView, boolean isLock, boolean withAnimation) {
        if (lockBackground == null || lockView == null) {
            return;
        }
        if (!withAnimation && !isLock) {
            lockBackground.setVisibility(8);
        } else if (withAnimation) {
            if (!isLock) {
                lockBackground.setVisibility(0);
            }
            lockBackground.postDelayed(new RunnableC0202d(isLock, lockBackground, lockView, 3), 400L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void decorateLockThumbnailAnimation$lambda$7(final boolean z, final View view, final ImageView imageView) {
        if (z) {
            view.setVisibility(0);
        }
        view.setScaleX(z ? 0.0f : 1.0f);
        view.setScaleY(z ? 0.0f : 1.0f);
        view.setAlpha(z ? 0.0f : 1.0f);
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("scaleX", z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
        PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat("scaleY", z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
        PropertyValuesHolder propertyValuesHolderOfFloat3 = PropertyValuesHolder.ofFloat("alpha", z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder, "ofPropertyValuesHolder(...)");
        if (z) {
            objectAnimatorOfPropertyValuesHolder.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f));
        } else {
            objectAnimatorOfPropertyValuesHolder.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.67f, 1.0f));
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderOfFloat3);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder2, "ofPropertyValuesHolder(...)");
        objectAnimatorOfPropertyValuesHolder2.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.util.HolderAnimation$decorateLockThumbnailAnimation$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                if (!z) {
                    view.setVisibility(8);
                    return;
                }
                ImageView imageView2 = imageView;
                Intrinsics.checkNotNull(imageView2, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                ((LottieAnimationView) imageView2).playAnimation();
                HolderAnimation.INSTANCE.playLockCompositionEffect((LottieAnimationView) imageView, true);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationStart(animation);
                ImageView imageView2 = imageView;
                Intrinsics.checkNotNull(imageView2, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                HolderAnimation.playLockLottieAnimation((LottieAnimationView) imageView2, z, ContextUtils.isNightMode(((LottieAnimationView) imageView).getContext()));
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        if (z) {
            animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2);
        } else {
            animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder2);
        }
        animatorSet.setDuration(z ? 200 : 350);
        animatorSet.start();
    }

    @JvmStatic
    @SuppressLint({"Recycle"})
    public static final void decorateRoundFavoriteShape(@Nullable final View roundedView, @Nullable final ImageView favoriteView, final boolean isFavorite, boolean withAnimation, final int viewMode) {
        if (favoriteView == null || roundedView == null) {
            return;
        }
        if (!withAnimation) {
            roundedView.setOutlineProvider(isFavorite ? ViewShapeManager.INSTANCE.getInstance().getFavoriteNoteHolderOutlineProvider(viewMode) : ViewShapeManager.INSTANCE.getInstance().getDefaultNoteHolderOutlineProvider(viewMode));
            return;
        }
        int i = 0;
        favoriteView.setVisibility(0);
        float favoriteCut = ViewShapeManager.INSTANCE.getInstance().getFavoriteCut(viewMode, DesktopModeCompat.INSTANCE.getInstance().isDexMode(roundedView.getContext()));
        float f = isFavorite ? 0.0f : favoriteCut;
        if (!isFavorite) {
            favoriteCut = 0.0f;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, favoriteCut);
        valueAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f));
        valueAnimatorOfFloat.addUpdateListener(new C8575c(roundedView, viewMode, i));
        valueAnimatorOfFloat.setDuration(450L);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(favoriteView, (Property<ImageView, Float>) View.ROTATION, 0.0f, isFavorite ? 360.0f : -360.0f);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f));
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(favoriteView, PropertyValuesHolder.ofFloat("scaleX", isFavorite ? 0.0f : 1.0f, isFavorite ? 1.0f : 0.0f), PropertyValuesHolder.ofFloat("scaleY", isFavorite ? 0.0f : 1.0f, isFavorite ? 1.0f : 0.0f));
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder, "ofPropertyValuesHolder(...)");
        objectAnimatorOfPropertyValuesHolder.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f));
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.util.HolderAnimation.decorateRoundFavoriteShape.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                roundedView.setOutlineProvider(isFavorite ? ViewShapeManager.INSTANCE.getInstance().getFavoriteNoteHolderOutlineProvider(viewMode) : ViewShapeManager.INSTANCE.getInstance().getDefaultNoteHolderOutlineProvider(viewMode));
                favoriteView.setRotation(0.0f);
                if (isFavorite) {
                    return;
                }
                favoriteView.setVisibility(8);
            }
        });
        objectAnimatorOfFloat.setDuration(400L);
        objectAnimatorOfPropertyValuesHolder.setDuration(400L);
        animatorSet.playTogether(valueAnimatorOfFloat, objectAnimatorOfFloat, objectAnimatorOfPropertyValuesHolder);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void decorateRoundFavoriteShape$lambda$10(View view, int i, ValueAnimator valueAnimator) {
        ViewShapeManager companion = ViewShapeManager.INSTANCE.getInstance();
        Intrinsics.checkNotNull(valueAnimator);
        Float f = (Float) valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(f);
        view.setOutlineProvider(companion.getNoteHolderOutlineProvider(i, f.floatValue()));
    }

    @JvmStatic
    public static final void decorateVoiceAnimation(@Nullable View roundedView, int viewMode, @Nullable View voiceView, @Nullable ImageView voiceIconView, @Nullable TextView voiceText, boolean isVoice, boolean withAnimation, boolean isFavorite, boolean isListView) {
        if (voiceView == null || voiceIconView == null || voiceText == null) {
            return;
        }
        if (roundedView != null) {
            roundedView.setOutlineProvider(isFavorite ? ViewShapeManager.INSTANCE.getInstance().getFavoriteNoteHolderOutlineProvider(viewMode) : ViewShapeManager.INSTANCE.getInstance().getDefaultNoteHolderOutlineProvider(viewMode));
        }
        if (!isVoice) {
            voiceView.setVisibility(8);
        } else if (withAnimation) {
            voiceView.post(new RunnableC4738b(2, voiceView, isListView));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void decorateVoiceAnimation$lambda$6(final View view, final boolean z) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i = 0;
        view.setVisibility(0);
        view.setPivotY(view.getHeight() / 2.0f);
        view.setPivotX(view.getWidth() / 2.0f);
        view.setScaleX(0.5f);
        view.setScaleY(0.5f);
        view.setAlpha(0.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder, "ofPropertyValuesHolder(...)");
        if (z) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                i = marginLayoutParams.topMargin;
            }
        } else {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            marginLayoutParams = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
            if (marginLayoutParams != null) {
                i = marginLayoutParams.bottomMargin;
            }
        }
        float f = i;
        if (z) {
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
            ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = (int) 0.0f;
            view.setLayoutParams(layoutParams4);
        } else {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) layoutParams5;
            layoutParams6.bottomMargin = (int) 0.0f;
            view.setLayoutParams(layoutParams6);
        }
        SpringAnimation springAnimationAddUpdateListener = new SpringAnimation(new FloatValueHolder(0.0f)).addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.util.b
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f4, float f5) {
                HolderAnimation.decorateVoiceAnimation$lambda$6$lambda$5(z, view, dynamicAnimation, f4, f5);
            }
        });
        SpringForce springForce = new SpringForce();
        springForce.setStiffness(350.0f);
        springForce.setDampingRatio(1.0f);
        springAnimationAddUpdateListener.setSpring(springForce);
        springAnimationAddUpdateListener.animateToFinalPosition(f);
        SpringAnimation springAnimation = new SpringAnimation(view, DynamicAnimation.SCALE_X);
        SpringAnimation springAnimation2 = new SpringAnimation(view, DynamicAnimation.SCALE_Y);
        SpringForce stiffness = new SpringForce().setDampingRatio(0.72f).setStiffness(300.0f);
        springAnimation.setSpring(stiffness);
        springAnimation2.setSpring(stiffness);
        springAnimation.animateToFinalPosition(1.0f);
        springAnimation2.animateToFinalPosition(1.0f);
        objectAnimatorOfPropertyValuesHolder.setDuration(150L);
        objectAnimatorOfPropertyValuesHolder.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void decorateVoiceAnimation$lambda$6$lambda$5(boolean z, View view, DynamicAnimation dynamicAnimation, float f, float f4) {
        if (z) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) f;
            view.setLayoutParams(layoutParams2);
        } else {
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
            layoutParams4.bottomMargin = (int) f;
            view.setLayoutParams(layoutParams4);
        }
        view.setPivotY(view.getHeight() / 2.0f);
        view.setPivotX(view.getWidth() / 2.0f);
    }

    @RequiresApi(30)
    private final VibrationEffect getLockCompositionEffect(boolean isLock) {
        initVibrator();
        Vibrator vibrator = mVibrator;
        if (vibrator == null || !vibrator.areAllPrimitivesSupported(1, 7)) {
            return null;
        }
        return isLock ? VibrationEffect.startComposition().addPrimitive(1, 0.75f, 67).addPrimitive(1, 1.0f, 250).compose() : VibrationEffect.startComposition().addPrimitive(1, 1.0f, 34).compose();
    }

    @JvmStatic
    @Nullable
    public static final Pair<ObjectAnimator, ValueAnimator> getSubFolderCollapseAnimator(@Nullable RecyclerView.ViewHolder holder) {
        View view;
        if (holder == null || (view = holder.itemView) == null) {
            return null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        objectAnimatorOfFloat.setDuration(100L);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        int dimensionPixelOffset = view.getResources().getDimensionPixelOffset(C8003R.dimen.sub_folder_layout_margin_vertical);
        int iCoerceAtLeast = RangesKt.coerceAtLeast(view.getMeasuredHeight(), 0);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f));
        valueAnimatorOfFloat.addUpdateListener(new C4635c(view, iCoerceAtLeast, dimensionPixelOffset, 1));
        return new Pair<>(objectAnimatorOfFloat, valueAnimatorOfFloat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSubFolderCollapseAnimator$lambda$0(View view, int i, int i2, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNull(valueAnimator);
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height = (int) (i * fFloatValue);
        int i4 = (int) (i2 * fFloatValue);
        marginLayoutParams.topMargin = i4;
        marginLayoutParams.bottomMargin = i4;
        view.setLayoutParams(marginLayoutParams);
    }

    @JvmStatic
    public static final void hideSearchFilterView(@Nullable RecyclerView.ViewHolder holder, @Nullable Runnable endAction) {
        hideSearchFilterView(holder != null ? holder.itemView : null, endAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresPermission("android.permission.VIBRATE")
    public final void playLockCompositionEffect(LottieAnimationView lockView, boolean isLock) {
        Vibrator vibrator;
        if (Build.VERSION.SDK_INT >= 30 && !mIsVibrating) {
            VibrationEffect lockCompositionEffect = getLockCompositionEffect(isLock);
            if (lockCompositionEffect == null || (vibrator = mVibrator) == null) {
                MainLogger.m7258i(TAG, "not supported primitives");
            } else {
                mIsVibrating = true;
                Intrinsics.checkNotNull(vibrator);
                vibrator.vibrate(lockCompositionEffect, EXTENSION_VIBRATION_ATTRIBUTES);
            }
            lockView.postDelayed(new RunnableC0284b(11), isLock ? 200L : 350L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final void playLockLottieAnimation(LottieAnimationView lottieAnimationView, boolean isLock, boolean isNightMode) {
        if (isNightMode) {
            lottieAnimationView.setAnimation(isLock ? "ic_lock_dark.json" : "ic_unlock_dark.json");
        } else {
            lottieAnimationView.setAnimation(isLock ? "ic_lock_light.json" : "ic_unlock_light.json");
        }
        if (isLock) {
            return;
        }
        lottieAnimationView.playAnimation();
        INSTANCE.playLockCompositionEffect(lottieAnimationView, false);
    }

    @JvmStatic
    public static final void showSearchFilterView(@NotNull View itemView) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        itemView.setAlpha(0.0f);
        itemView.animate().alpha(1.0f).setDuration(150L).setInterpolator(new LinearInterpolator()).start();
    }

    private final void startSpringTranslateY(View view, float dampingRatio, float stiffness) {
        new SpringAnimation(view, DynamicAnimation.TRANSLATION_Y).setSpring(new SpringForce(0.0f).setDampingRatio(dampingRatio).setStiffness(stiffness)).start();
    }

    @JvmStatic
    public static final void updateTextViewWidthAnimation(@NotNull TextView textView, @NotNull String newText) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(newText, "newText");
        if (Intrinsics.areEqual(textView.getText(), newText)) {
            return;
        }
        int width = textView.getWidth();
        int iCalculateTextWidth = INSTANCE.calculateTextWidth(textView, newText);
        textView.setAlpha(1.0f);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(width, iCalculateTextWidth);
        valueAnimatorOfInt.setDuration(400L);
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        valueAnimatorOfInt.addUpdateListener(new C8573a(textView, 1));
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(350L);
        valueAnimatorOfFloat.setInterpolator(new PathInterpolator(0.17f, 0.17f, 0.67f, 1.0f));
        valueAnimatorOfFloat.addUpdateListener(new C8573a(textView, 0));
        valueAnimatorOfInt.addListener(new C85701(textView, newText));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfInt, valueAnimatorOfFloat);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateTextViewWidthAnimation$lambda$2$lambda$1(TextView textView, ValueAnimator anim) {
        Intrinsics.checkNotNullParameter(anim, "anim");
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Object animatedValue = anim.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.width = ((Integer) animatedValue).intValue();
        textView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateTextViewWidthAnimation$lambda$4$lambda$3(TextView textView, ValueAnimator valueAnimator) {
        textView.setAlpha(((Float) AbstractC6670b.m4742c(valueAnimator, "anim", "null cannot be cast to non-null type kotlin.Float")).floatValue());
    }

    public final void initVibrator() {
        if (mVibrator != null) {
            return;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        mVibrator = (Vibrator) (applicationContext != null ? applicationContext.getSystemService("vibrator") : null);
        EXTENSION_VIBRATION_ATTRIBUTES = new AudioAttributes.Builder().setContentType(4).setUsage(13).build();
    }

    @JvmStatic
    public static final void hideSearchFilterView(@Nullable View itemView, @Nullable Runnable endAction) {
        if (itemView == null) {
            return;
        }
        itemView.animate().alpha(0.0f).setDuration(150L).setInterpolator(new LinearInterpolator()).withEndAction(endAction).start();
    }
}
