package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.TextView;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.p137ui.C7051a;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.EraserState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.AIGuidingLightEffect;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ \u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0002J$\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0002J \u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014H\u0002J(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010$\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceSubAnimation;", "", "<init>", "()V", "mCustomVoiceAnimationInterpolator", "Landroid/view/animation/PathInterpolator;", "mAlphaVoiceAnimationInterpolator", "updateAnimationForEraser", "", "parent", "Landroid/view/View;", "state", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/EraserState;", "isLineVoiceLayout", "", "isLeftPosition", "collapseToNormalAnimation", "collapseToErasedAnimation", "expandHorizontalAnimation", "getMeasureTargetWidth", "", "view", "getTranslateXAnimator", "Landroid/animation/ObjectAnimator;", DBSchema.DocumentThumbnail.LAYOUT, "start", "end", "getAlphaAnimator", "startAlpha", "endAlpha", "getValueAnimator", "Landroid/animation/ValueAnimator;", "startWidth", "endWidth", "interpolator", "startProcessingLightEffect", "removeProcessingLightEffect", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVoiceSubAnimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceSubAnimation.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceSubAnimation\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,274:1\n85#2,18:275\n29#2:293\n85#2,18:294\n29#2:312\n85#2,18:313\n*S KotlinDebug\n*F\n+ 1 VoiceSubAnimation.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceSubAnimation\n*L\n198#1:275,18\n229#1:293\n229#1:294,18\n250#1:312\n250#1:313,18\n*E\n"})
public final class VoiceSubAnimation {
    private static final long ALPHA_ANIMATION_DURATION = 300;
    private static final long VALUE_ANIMATION_DURATION = 500;

    @NotNull
    private final PathInterpolator mCustomVoiceAnimationInterpolator = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);

    @NotNull
    private final PathInterpolator mAlphaVoiceAnimationInterpolator = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EraserState.values().length];
            try {
                iArr[EraserState.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EraserState.ERASED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EraserState.ERASING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EraserState.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void collapseToErasedAnimation(View parent, boolean isLineVoiceLayout, boolean isLeftPosition) {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        ObjectAnimator translateXAnimator;
        View viewFindViewById4 = parent.findViewById(C9086R.id.voice_record_eraser_layout);
        if (viewFindViewById4 == null || (viewFindViewById = parent.findViewById(C9086R.id.voice_record_eraser_text)) == null || (viewFindViewById2 = parent.findViewById(C9086R.id.voice_record_eraser_done_animation)) == null || (viewFindViewById3 = parent.findViewById(C9086R.id.voice_record_speed)) == null) {
            return;
        }
        float width = viewFindViewById4.getWidth();
        removeProcessingLightEffect(viewFindViewById);
        removeProcessingLightEffect(viewFindViewById2);
        Resources resources = parent.getContext().getResources();
        List listMutableListOf = CollectionsKt.mutableListOf(getValueAnimator(viewFindViewById4, width, (resources.getDimensionPixelSize(C9086R.dimen.voice_record_audio_eraser_done_margin) * 2) + resources.getDimensionPixelSize(C9086R.dimen.voice_record_audio_eraser_done_width), this.mCustomVoiceAnimationInterpolator), getAlphaAnimator(viewFindViewById, 1.0f, 0.0f), getAlphaAnimator(viewFindViewById2, 0.0f, 1.0f));
        float dimensionPixelSize = resources.getDimensionPixelSize(C9086R.dimen.voice_record_audio_speed_translate);
        if (isLeftPosition) {
            ObjectAnimator translateXAnimator2 = !isLineVoiceLayout ? getTranslateXAnimator(viewFindViewById3, -dimensionPixelSize, 0.0f) : getTranslateXAnimator(viewFindViewById3, 0.0f, 0.0f);
            ObjectAnimator translateXAnimator3 = !isLineVoiceLayout ? null : getTranslateXAnimator(parent.findViewById(C9086R.id.voice_record_close_layout), -dimensionPixelSize, 0.0f);
            translateXAnimator = isLineVoiceLayout ? getTranslateXAnimator(parent.findViewById(C9086R.id.voice_record_seek_bar), -dimensionPixelSize, 0.0f) : null;
            if (translateXAnimator != null) {
                listMutableListOf.add(translateXAnimator);
            }
            if (translateXAnimator2 != null) {
                listMutableListOf.add(translateXAnimator2);
            }
            if (translateXAnimator3 != null) {
                listMutableListOf.add(translateXAnimator3);
            }
        } else {
            translateXAnimator = isLineVoiceLayout ? getTranslateXAnimator(parent.findViewById(C9086R.id.voice_record_total_time), dimensionPixelSize, 0.0f) : null;
            if (translateXAnimator != null) {
                listMutableListOf.add(translateXAnimator);
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(this.mCustomVoiceAnimationInterpolator);
        animatorSet.playTogether(listMutableListOf);
        animatorSet.start();
    }

    private final void collapseToNormalAnimation(View parent, boolean isLineVoiceLayout, boolean isLeftPosition) {
        View viewFindViewById;
        View viewFindViewById2;
        ObjectAnimator translateXAnimator;
        View viewFindViewById3 = parent.findViewById(C9086R.id.voice_record_eraser_layout);
        if (viewFindViewById3 == null || (viewFindViewById = parent.findViewById(C9086R.id.voice_record_eraser)) == null || (viewFindViewById2 = parent.findViewById(C9086R.id.voice_record_speed)) == null) {
            return;
        }
        List listMutableListOf = CollectionsKt.mutableListOf(getValueAnimator(viewFindViewById3, viewFindViewById3.getWidth(), getMeasureTargetWidth(viewFindViewById3), this.mCustomVoiceAnimationInterpolator), getAlphaAnimator(viewFindViewById, 0.0f, 1.0f));
        float dimensionPixelSize = parent.getContext().getResources().getDimensionPixelSize(C9086R.dimen.voice_record_audio_speed_translate);
        if (isLeftPosition) {
            ObjectAnimator translateXAnimator2 = !isLineVoiceLayout ? getTranslateXAnimator(viewFindViewById2, dimensionPixelSize, 0.0f) : getTranslateXAnimator(viewFindViewById2, 0.0f, 0.0f);
            ObjectAnimator translateXAnimator3 = !isLineVoiceLayout ? null : getTranslateXAnimator(parent.findViewById(C9086R.id.voice_record_close_layout), dimensionPixelSize, 0.0f);
            translateXAnimator = isLineVoiceLayout ? getTranslateXAnimator(parent.findViewById(C9086R.id.voice_record_seek_bar), dimensionPixelSize, 0.0f) : null;
            if (translateXAnimator2 != null) {
                listMutableListOf.add(translateXAnimator2);
            }
            if (translateXAnimator3 != null) {
                listMutableListOf.add(translateXAnimator3);
            }
            if (translateXAnimator != null) {
                listMutableListOf.add(translateXAnimator);
            }
        } else {
            translateXAnimator = isLineVoiceLayout ? getTranslateXAnimator(parent.findViewById(C9086R.id.voice_record_total_time), -dimensionPixelSize, 0.0f) : null;
            if (translateXAnimator != null) {
                listMutableListOf.add(translateXAnimator);
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(this.mCustomVoiceAnimationInterpolator);
        animatorSet.playTogether(listMutableListOf);
        animatorSet.start();
    }

    private final void expandHorizontalAnimation(View parent) {
        final TextView textView;
        final View viewFindViewById;
        final View viewFindViewById2;
        View viewFindViewById3 = parent.findViewById(C9086R.id.voice_record_eraser_layout);
        if (viewFindViewById3 == null || (textView = (TextView) parent.findViewById(C9086R.id.voice_record_eraser_text)) == null || (viewFindViewById = parent.findViewById(C9086R.id.voice_record_eraser_done_animation)) == null || (viewFindViewById2 = parent.findViewById(C9086R.id.voice_record_eraser)) == null) {
            return;
        }
        viewFindViewById2.setBackgroundResource(0);
        float width = viewFindViewById3.getWidth();
        float measureTargetWidth = getMeasureTargetWidth(viewFindViewById3);
        if ((parent.getWidth() - measureTargetWidth) - parent.getContext().getResources().getDimensionPixelSize(C9086R.dimen.voice_record_audio_speed_translate) <= 0.0f) {
            textView.setEllipsize(TextUtils.TruncateAt.END);
        } else {
            textView.setEllipsize(null);
        }
        ValueAnimator valueAnimator = getValueAnimator(viewFindViewById3, width, measureTargetWidth, this.mCustomVoiceAnimationInterpolator);
        ObjectAnimator alphaAnimator = getAlphaAnimator(textView, 0.0f, 1.0f);
        ObjectAnimator alphaAnimator2 = getAlphaAnimator(viewFindViewById2, 1.0f, 0.0f);
        ObjectAnimator alphaAnimator3 = getAlphaAnimator(viewFindViewById, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(alphaAnimator, alphaAnimator2, valueAnimator, alphaAnimator3);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.animation.VoiceSubAnimation$expandHorizontalAnimation$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                this.this$0.startProcessingLightEffect(textView);
                this.this$0.startProcessingLightEffect(viewFindViewById);
                viewFindViewById2.setBackgroundResource(C9086R.drawable.voice_button_ripple_effect);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        animatorSet.start();
    }

    private final ObjectAnimator getAlphaAnimator(final View layout, float startAlpha, final float endAlpha) {
        if (startAlpha == 1.0f) {
            layout.setVisibility(0);
        }
        layout.setAlpha(startAlpha);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(layout, "alpha", layout.getAlpha(), endAlpha);
        Intrinsics.checkNotNull(objectAnimatorOfFloat);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.animation.VoiceSubAnimation$getAlphaAnimator$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (endAlpha == 0.0f) {
                    layout.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.setInterpolator(this.mAlphaVoiceAnimationInterpolator);
        return objectAnimatorOfFloat;
    }

    private final float getMeasureTargetWidth(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredWidth();
    }

    private final ObjectAnimator getTranslateXAnimator(View layout, float start, float end) {
        if (layout == null) {
            return null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(layout, "translationX", start, end);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.setInterpolator(this.mCustomVoiceAnimationInterpolator);
        return objectAnimatorOfFloat;
    }

    private final ValueAnimator getValueAnimator(final View layout, float startWidth, float endWidth, PathInterpolator interpolator) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(startWidth, endWidth);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.setInterpolator(interpolator);
        valueAnimatorOfFloat.addUpdateListener(new C7051a(layout, 8));
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.animation.VoiceSubAnimation$getValueAnimator$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = layout.getLayoutParams();
                layoutParams.width = -2;
                layout.setLayoutParams(layoutParams);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getValueAnimator$lambda$2(View view, ValueAnimator valueAnimator) {
        view.getLayoutParams().width = (int) ((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        view.requestLayout();
    }

    private final void removeProcessingLightEffect(View view) {
        if (Build.VERSION.SDK_INT >= 33) {
            AIGuidingLightEffect.INSTANCE.removeProcessingLightEffect(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startProcessingLightEffect(View view) {
        if (Build.VERSION.SDK_INT >= 33) {
            AIGuidingLightEffect.INSTANCE.makeProcessingLightEffect(view).start();
        }
    }

    public final void updateAnimationForEraser(@Nullable View parent, @Nullable EraserState state, boolean isLineVoiceLayout, boolean isLeftPosition) {
        if (parent == null) {
            return;
        }
        int i = state == null ? -1 : WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i != -1) {
            if (i == 1) {
                collapseToNormalAnimation(parent, isLineVoiceLayout, isLeftPosition);
                return;
            }
            if (i == 2) {
                collapseToErasedAnimation(parent, isLineVoiceLayout, isLeftPosition);
            } else if (i == 3) {
                expandHorizontalAnimation(parent);
            } else if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
    }
}
