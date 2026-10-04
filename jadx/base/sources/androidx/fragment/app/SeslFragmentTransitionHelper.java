package androidx.fragment.app;

import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.C2751R;
import androidx.fragment.app.SeslFragmentTransitionHelper;
import java.util.EnumMap;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class SeslFragmentTransitionHelper {
    private static final float AFTER_MOST_TRANSLATE_MIN_SWIPE = -0.33f;
    private static final int ALPHA_DURATION = 150;
    private static final int DEPTH_IN_DURATION = 450;
    private static final int DEPTH_OUT_DURATION = 400;
    private static final float PROGRESS_INPUT_MAX = 1.0f;
    private static final float PROGRESS_INPUT_MID = 0.5f;
    private static final float PROGRESS_MAPPED_MAX = 0.6f;
    private static final float PROGRESS_MAPPED_MIN = 0.5f;
    private static final EnumMap<AnimationType, AnimatorStrategy> STRATEGIES;
    private final Context mContext;
    private final int mScreenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private View mView;
    private static final PathInterpolator DEPTH_OUT_INTERPOLATION = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
    private static final PathInterpolator DEPTH_IN_INTERPOLATION = new PathInterpolator(0.22f, 0.5f, 0.0f, 1.0f);
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum AnimationType {
        CLOSE_EXIT(C2751R.animator.sesl_fragment_close_exit),
        CLOSE_ENTER(C2751R.animator.sesl_fragment_close_enter),
        OPEN_ENTER(C2751R.animator.sesl_fragment_open_enter),
        OPEN_EXIT(C2751R.animator.sesl_fragment_open_exit);

        private static final SparseArray<AnimationType> LOOKUP = new SparseArray<>();
        final int resId;

        static {
            for (AnimationType animationType : values()) {
                LOOKUP.put(animationType.resId, animationType);
            }
        }

        AnimationType(int i) {
            this.resId = i;
        }

        public static AnimationType fromResId(int i) {
            return LOOKUP.get(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @FunctionalInterface
    public interface AnimatorStrategy {
        AnimatorSet build(SeslFragmentTransitionHelper seslFragmentTransitionHelper, boolean z, boolean z2, TransitionGeometry transitionGeometry);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class TransitionGeometry {
        private final int leftMargin;
        private final int rightMargin;
        private final int width;

        public TransitionGeometry(int i, int[] iArr) {
            this.width = i;
            this.leftMargin = iArr[0];
            this.rightMargin = iArr[1];
        }

        public int getLeftMargin() {
            return this.leftMargin;
        }

        public int getRightMargin() {
            return this.rightMargin;
        }

        public int getWidth() {
            return this.width;
        }
    }

    static {
        EnumMap<AnimationType, AnimatorStrategy> enumMap = new EnumMap<>(AnimationType.class);
        STRATEGIES = enumMap;
        final int i = 0;
        enumMap.put(AnimationType.CLOSE_EXIT, new AnimatorStrategy() { // from class: androidx.fragment.app.j
            @Override // androidx.fragment.app.SeslFragmentTransitionHelper.AnimatorStrategy
            public final AnimatorSet build(SeslFragmentTransitionHelper seslFragmentTransitionHelper, boolean z, boolean z2, SeslFragmentTransitionHelper.TransitionGeometry transitionGeometry) {
                switch (i) {
                    case 0:
                        return SeslFragmentTransitionHelper.lambda$static$0(seslFragmentTransitionHelper, z, z2, transitionGeometry);
                    case 1:
                        return SeslFragmentTransitionHelper.lambda$static$1(seslFragmentTransitionHelper, z, z2, transitionGeometry);
                    case 2:
                        return SeslFragmentTransitionHelper.lambda$static$2(seslFragmentTransitionHelper, z, z2, transitionGeometry);
                    default:
                        return SeslFragmentTransitionHelper.lambda$static$3(seslFragmentTransitionHelper, z, z2, transitionGeometry);
                }
            }
        });
        final int i2 = 1;
        enumMap.put(AnimationType.CLOSE_ENTER, new AnimatorStrategy() { // from class: androidx.fragment.app.j
            @Override // androidx.fragment.app.SeslFragmentTransitionHelper.AnimatorStrategy
            public final AnimatorSet build(SeslFragmentTransitionHelper seslFragmentTransitionHelper, boolean z, boolean z2, SeslFragmentTransitionHelper.TransitionGeometry transitionGeometry) {
                switch (i2) {
                    case 0:
                        return SeslFragmentTransitionHelper.lambda$static$0(seslFragmentTransitionHelper, z, z2, transitionGeometry);
                    case 1:
                        return SeslFragmentTransitionHelper.lambda$static$1(seslFragmentTransitionHelper, z, z2, transitionGeometry);
                    case 2:
                        return SeslFragmentTransitionHelper.lambda$static$2(seslFragmentTransitionHelper, z, z2, transitionGeometry);
                    default:
                        return SeslFragmentTransitionHelper.lambda$static$3(seslFragmentTransitionHelper, z, z2, transitionGeometry);
                }
            }
        });
        final int i4 = 2;
        enumMap.put(AnimationType.OPEN_ENTER, new AnimatorStrategy() { // from class: androidx.fragment.app.j
            @Override // androidx.fragment.app.SeslFragmentTransitionHelper.AnimatorStrategy
            public final AnimatorSet build(SeslFragmentTransitionHelper seslFragmentTransitionHelper, boolean z, boolean z2, SeslFragmentTransitionHelper.TransitionGeometry transitionGeometry) {
                switch (i4) {
                    case 0:
                        return SeslFragmentTransitionHelper.lambda$static$0(seslFragmentTransitionHelper, z, z2, transitionGeometry);
                    case 1:
                        return SeslFragmentTransitionHelper.lambda$static$1(seslFragmentTransitionHelper, z, z2, transitionGeometry);
                    case 2:
                        return SeslFragmentTransitionHelper.lambda$static$2(seslFragmentTransitionHelper, z, z2, transitionGeometry);
                    default:
                        return SeslFragmentTransitionHelper.lambda$static$3(seslFragmentTransitionHelper, z, z2, transitionGeometry);
                }
            }
        });
        final int i5 = 3;
        enumMap.put(AnimationType.OPEN_EXIT, new AnimatorStrategy() { // from class: androidx.fragment.app.j
            @Override // androidx.fragment.app.SeslFragmentTransitionHelper.AnimatorStrategy
            public final AnimatorSet build(SeslFragmentTransitionHelper seslFragmentTransitionHelper, boolean z, boolean z2, SeslFragmentTransitionHelper.TransitionGeometry transitionGeometry) {
                switch (i5) {
                    case 0:
                        return SeslFragmentTransitionHelper.lambda$static$0(seslFragmentTransitionHelper, z, z2, transitionGeometry);
                    case 1:
                        return SeslFragmentTransitionHelper.lambda$static$1(seslFragmentTransitionHelper, z, z2, transitionGeometry);
                    case 2:
                        return SeslFragmentTransitionHelper.lambda$static$2(seslFragmentTransitionHelper, z, z2, transitionGeometry);
                    default:
                        return SeslFragmentTransitionHelper.lambda$static$3(seslFragmentTransitionHelper, z, z2, transitionGeometry);
                }
            }
        });
    }

    public SeslFragmentTransitionHelper(@NonNull View view) {
        this.mView = view;
        this.mContext = view.getContext();
    }

    private AnimatorSet animatorSetOf(ObjectAnimator... objectAnimatorArr) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (objectAnimatorArr != null && objectAnimatorArr.length != 0) {
            if (objectAnimatorArr.length == 1) {
                animatorSet.play(objectAnimatorArr[0]);
                return animatorSet;
            }
            animatorSet.playTogether(objectAnimatorArr);
        }
        return animatorSet;
    }

    private ObjectAnimator buildAlphaAnimator(int i, float f, float f4) {
        return createAnimator(LINEAR_INTERPOLATOR, i, "alpha", Keyframe.ofFloat(0.0f, f), Keyframe.ofFloat(1.0f, f4));
    }

    private ObjectAnimator buildTranslateXAnimator(Interpolator interpolator, int i, float f, float f4) {
        return createAnimator(interpolator, i, "x", Keyframe.ofFloat(0.0f, f), Keyframe.ofFloat(1.0f, f4));
    }

    private static float clamp(float f, float f4, float f5) {
        return Math.max(f, Math.min(f4, f5));
    }

    private ObjectAnimator createAnimator(Interpolator interpolator, int i, String str, Keyframe... keyframeArr) {
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setInterpolator(interpolator);
        objectAnimator.setValues(propertyValuesHolderOfKeyframe);
        objectAnimator.setDuration(i);
        return objectAnimator;
    }

    @VisibleForTesting
    public static int getAlphaDuration() {
        return 150;
    }

    @VisibleForTesting
    public static int getDepthInDuration() {
        return DEPTH_IN_DURATION;
    }

    @VisibleForTesting
    public static int getDepthOutDuration() {
        return 400;
    }

    private int getEffectiveWidth() {
        return this.mView.getWidth() > 0 ? this.mView.getWidth() : this.mScreenWidth;
    }

    private int[] getHorizontalMargins() {
        int i;
        int i2;
        ViewGroup.LayoutParams layoutParams = this.mView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i = marginLayoutParams.leftMargin;
            i2 = marginLayoutParams.rightMargin;
        } else {
            i = 0;
            i2 = 0;
        }
        return new int[]{i, i2};
    }

    private Interpolator getInterpolator(boolean z) {
        return z ? DEPTH_OUT_INTERPOLATION : DEPTH_IN_INTERPOLATION;
    }

    private TransitionGeometry getTransitionGeometry() {
        return new TransitionGeometry(getEffectiveWidth(), getHorizontalMargins());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnimatorSet lambda$static$0(SeslFragmentTransitionHelper seslFragmentTransitionHelper, boolean z, boolean z2, TransitionGeometry transitionGeometry) {
        return seslFragmentTransitionHelper.animatorSetOf(seslFragmentTransitionHelper.buildTranslateXAnimator(z ? seslFragmentTransitionHelper.getInterpolator(true) : LINEAR_INTERPOLATOR, 400, seslFragmentTransitionHelper.mView.getTranslationX() + transitionGeometry.getLeftMargin(), transitionGeometry.getWidth()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnimatorSet lambda$static$1(SeslFragmentTransitionHelper seslFragmentTransitionHelper, boolean z, boolean z2, TransitionGeometry transitionGeometry) {
        ObjectAnimator objectAnimatorBuildTranslateXAnimator = seslFragmentTransitionHelper.buildTranslateXAnimator(z ? seslFragmentTransitionHelper.getInterpolator(true) : LINEAR_INTERPOLATOR, 400, z2 ? seslFragmentTransitionHelper.mView.getTranslationX() + transitionGeometry.getLeftMargin() : (transitionGeometry.getWidth() + transitionGeometry.getLeftMargin() + transitionGeometry.getRightMargin()) * AFTER_MOST_TRANSLATE_MIN_SWIPE, transitionGeometry.getLeftMargin());
        return (!z || z2) ? seslFragmentTransitionHelper.animatorSetOf(objectAnimatorBuildTranslateXAnimator) : seslFragmentTransitionHelper.animatorSetOf(objectAnimatorBuildTranslateXAnimator, seslFragmentTransitionHelper.buildAlphaAnimator(150, 0.0f, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnimatorSet lambda$static$2(SeslFragmentTransitionHelper seslFragmentTransitionHelper, boolean z, boolean z2, TransitionGeometry transitionGeometry) {
        return seslFragmentTransitionHelper.animatorSetOf(seslFragmentTransitionHelper.buildTranslateXAnimator(seslFragmentTransitionHelper.getInterpolator(false), DEPTH_IN_DURATION, transitionGeometry.getWidth(), transitionGeometry.getLeftMargin()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnimatorSet lambda$static$3(SeslFragmentTransitionHelper seslFragmentTransitionHelper, boolean z, boolean z2, TransitionGeometry transitionGeometry) {
        return seslFragmentTransitionHelper.animatorSetOf(seslFragmentTransitionHelper.buildTranslateXAnimator(seslFragmentTransitionHelper.getInterpolator(false), DEPTH_IN_DURATION, transitionGeometry.getLeftMargin(), transitionGeometry.getWidth() * AFTER_MOST_TRANSLATE_MIN_SWIPE), seslFragmentTransitionHelper.buildAlphaAnimator(150, 1.0f, 0.0f));
    }

    private static float lerp(float f, float f4, float f5) {
        return AbstractC0000a.m29z(f4, f, f5, f);
    }

    @FloatRange(from = 0.0d, m705to = 1.0d)
    public float getProgress(float f) {
        float fClamp = clamp(0.0f, 1.0f, f);
        return (fClamp <= 0.5f || fClamp > 1.0f) ? fClamp : lerp(0.5f, 0.6f, (fClamp - 0.5f) / 0.5f);
    }

    public void initTransition() {
        View view = this.mView;
        if (view != null) {
            view.setTranslationX(0.0f);
        }
    }

    public void update(@NonNull View view) {
        if (this.mView != view) {
            this.mView = view;
        }
    }

    public AnimatorSet createAnimator(int i, boolean z, boolean z2) {
        AnimatorStrategy animatorStrategy;
        AnimationType animationTypeFromResId = AnimationType.fromResId(i);
        if (animationTypeFromResId == null || (animatorStrategy = STRATEGIES.get(animationTypeFromResId)) == null) {
            return null;
        }
        return animatorStrategy.build(this, z, z2, getTransitionGeometry());
    }
}
