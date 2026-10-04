package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.C2751R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
class FragmentAnim {
    private FragmentAnim() {
    }

    @AnimRes
    private static int getNextAnim(Fragment fragment, boolean z, boolean z2) {
        return z2 ? z ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z ? fragment.getEnterAnim() : fragment.getExitAnim();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0073 A[Catch: RuntimeException -> 0x0087, TryCatch #0 {RuntimeException -> 0x0087, blocks: (B:32:0x006b, B:34:0x0073, B:36:0x007c, B:39:0x0081, B:43:0x0089, B:45:0x0093, B:47:0x0099), top: B:57:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0093 A[Catch: RuntimeException -> 0x0087, TryCatch #0 {RuntimeException -> 0x0087, blocks: (B:32:0x006b, B:34:0x0073, B:36:0x007c, B:39:0x0081, B:43:0x0089, B:45:0x0093, B:47:0x0099), top: B:57:0x006b }] */
    @SuppressLint({"ResourceType"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AnimationOrAnimator loadAnimation(@NonNull Context context, @NonNull Fragment fragment, boolean z, boolean z2) {
        int nextTransition = fragment.getNextTransition();
        int nextAnim = getNextAnim(fragment, z, z2);
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && viewGroup.getTag(C2751R.id.visible_removing_fragment_view_tag) != null) {
            fragment.mContainer.setTag(C2751R.id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationOnCreateAnimation = fragment.onCreateAnimation(nextTransition, z, nextAnim);
        if (animationOnCreateAnimation != null) {
            return new AnimationOrAnimator(animationOnCreateAnimation);
        }
        Animator animatorOnCreateAnimator = fragment.onCreateAnimator(nextTransition, z, nextAnim);
        if (animatorOnCreateAnimator != null) {
            return new AnimationOrAnimator(animatorOnCreateAnimator);
        }
        if (nextAnim == 0 && nextTransition != 0) {
            nextAnim = transitToAnimResourceId(context, nextTransition, z);
        }
        if (nextAnim != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(nextAnim));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, nextAnim);
                    if (animationLoadAnimation != null) {
                        return new AnimationOrAnimator(animationLoadAnimation);
                    }
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                    try {
                        if (!SeslFragmentTransactionAnimationSet.INSTANCE.isFragmentAnimationRes(nextAnim)) {
                        }
                    } catch (RuntimeException e2) {
                        if (zEquals) {
                            throw e2;
                        }
                        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, nextAnim);
                        if (animationLoadAnimation2 != null) {
                            return new AnimationOrAnimator(animationLoadAnimation2);
                        }
                    }
                }
            } else {
                if (!SeslFragmentTransactionAnimationSet.INSTANCE.isFragmentAnimationRes(nextAnim)) {
                    Animator animatorOnCreateAnimator2 = fragment.onCreateAnimator(nextAnim, false, false);
                    if (nextAnim != C2751R.animator.sesl_fragment_close_enter && nextAnim != C2751R.animator.sesl_fragment_close_exit) {
                        return new AnimationOrAnimator(animatorOnCreateAnimator2, true);
                    }
                    return new AnimationOrAnimator(animatorOnCreateAnimator2, fragment.onCreateAnimator(nextAnim, true, false));
                }
                Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, nextAnim);
                if (animatorLoadAnimator != null) {
                    return new AnimationOrAnimator(animatorLoadAnimator);
                }
            }
        }
        return null;
    }

    @AnimRes
    private static int toActivityTransitResId(@NonNull Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    @AnimRes
    private static int transitToAnimResourceId(@NonNull Context context, int i, boolean z) {
        if (i == 4097) {
            return z ? C2751R.animator.fragment_open_enter : C2751R.animator.fragment_open_exit;
        }
        if (i == 8194) {
            return z ? C2751R.animator.fragment_close_enter : C2751R.animator.fragment_close_exit;
        }
        if (i == 8197) {
            return z ? toActivityTransitResId(context, R.attr.activityCloseEnterAnimation) : toActivityTransitResId(context, R.attr.activityCloseExitAnimation);
        }
        if (i == 4099) {
            return z ? C2751R.animator.fragment_fade_enter : C2751R.animator.fragment_fade_exit;
        }
        if (i != 4100) {
            return -1;
        }
        return z ? toActivityTransitResId(context, R.attr.activityOpenEnterAnimation) : toActivityTransitResId(context, R.attr.activityOpenExitAnimation);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AnimationOrAnimator {
        public final Animation animation;
        public final AnimatorSet animator;
        public final AnimatorSet animatorForCommit;
        public final boolean isFragmentAnimationRes;

        public AnimationOrAnimator(Animation animation) {
            this.animation = animation;
            this.animator = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
            this.animatorForCommit = null;
            this.isFragmentAnimationRes = false;
        }

        public AnimationOrAnimator(Animator animator) {
            this.animation = null;
            AnimatorSet animatorSet = new AnimatorSet();
            this.animator = animatorSet;
            animatorSet.play(animator);
            if (animator != null) {
                this.animatorForCommit = null;
                this.isFragmentAnimationRes = false;
                return;
            }
            throw new IllegalStateException("Animator cannot be null");
        }

        public AnimationOrAnimator(Animator animator, boolean z) {
            this.animation = null;
            AnimatorSet animatorSet = new AnimatorSet();
            this.animator = animatorSet;
            animatorSet.play(animator);
            if (animator != null) {
                this.animatorForCommit = null;
                this.isFragmentAnimationRes = z;
                return;
            }
            throw new IllegalStateException("Animator cannot be null");
        }

        public AnimationOrAnimator(Animator animator, Animator animator2) {
            this.animation = null;
            AnimatorSet animatorSet = new AnimatorSet();
            this.animator = animatorSet;
            animatorSet.play(animator);
            if (animator != null) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.animatorForCommit = animatorSet2;
                animatorSet2.play(animator2);
                if (animator2 != null) {
                    this.isFragmentAnimationRes = true;
                    return;
                }
                throw new IllegalStateException("animatorForCommit cannot be null");
            }
            throw new IllegalStateException("Animator cannot be null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean mAnimating;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        public EndViewTransitionAnimation(@NonNull Animation animation, @NonNull ViewGroup viewGroup, @NonNull View view) {
            super(false);
            this.mAnimating = true;
            this.mParent = viewGroup;
            this.mChild = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, @NonNull Transformation transformation) {
            this.mAnimating = true;
            if (this.mEnded) {
                return !this.mTransitionEnded;
            }
            if (!super.getTransformation(j, transformation)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mEnded || !this.mAnimating) {
                this.mParent.endViewTransition(this.mChild);
                this.mTransitionEnded = true;
            } else {
                this.mAnimating = false;
                this.mParent.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, @NonNull Transformation transformation, float f) {
            this.mAnimating = true;
            if (this.mEnded) {
                return !this.mTransitionEnded;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }
    }
}
