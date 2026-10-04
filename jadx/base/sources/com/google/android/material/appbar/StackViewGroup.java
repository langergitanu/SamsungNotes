package com.google.android.material.appbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.appcompat.C0419R;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0007*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/google/android/material/appbar/StackViewGroup;", "", "rootView", "Landroid/widget/FrameLayout;", "(Landroid/widget/FrameLayout;)V", "hideAnimator", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "hideDuration", "", "getRootView", "()Landroid/widget/FrameLayout;", "sceneStack", "Lcom/google/android/material/appbar/StackViewGroup$SceneStack;", "Landroid/view/ViewGroup;", "showAnimator", "showDuration", "showHideAnimator", "Landroid/animation/AnimatorSet;", "showHideInterpolator", "Landroid/view/animation/Interpolator;", "pop", "push", "", "child", "remove", "view", "SceneStack", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class StackViewGroup {
    private final ObjectAnimator hideAnimator;
    private final long hideDuration;

    @NotNull
    private final FrameLayout rootView;

    @NotNull
    private final SceneStack<ViewGroup> sceneStack;
    private final ObjectAnimator showAnimator;
    private final long showDuration;

    @NotNull
    private final AnimatorSet showHideAnimator;
    private final Interpolator showHideInterpolator;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/google/android/material/appbar/StackViewGroup$SceneStack;", "T", "Landroid/view/View;", "Ljava/util/Stack;", "()V", "pop", "()Landroid/view/View;", "push", "item", "(Landroid/view/View;)Landroid/view/View;", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class SceneStack<T extends View> extends Stack<T> {
        public /* bridge */ boolean contains(View view) {
            return super.contains((Object) view);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ int indexOf(View view) {
            return super.indexOf((Object) view);
        }

        public /* bridge */ int lastIndexOf(View view) {
            return super.lastIndexOf((Object) view);
        }

        @Override // java.util.Vector, java.util.AbstractList, java.util.List
        public final /* bridge */ T remove(int i) {
            return (T) removeAt(i);
        }

        public /* bridge */ View removeAt(int i) {
            return remove(i);
        }

        @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof View) {
                return contains((View) obj);
            }
            return false;
        }

        @Override // java.util.Vector, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj == null ? true : obj instanceof View) {
                return indexOf((View) obj);
            }
            return -1;
        }

        @Override // java.util.Vector, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj == null ? true : obj instanceof View) {
                return lastIndexOf((View) obj);
            }
            return -1;
        }

        @Override // java.util.Stack
        @NotNull
        public synchronized T pop() {
            T result;
            try {
                result = (T) super.pop();
                if (!isEmpty()) {
                    peek().setVisibility(0);
                }
                Intrinsics.checkNotNullExpressionValue(result, "result");
            } catch (Throwable th) {
                throw th;
            }
            return result;
        }

        @Override // java.util.Stack
        @NotNull
        public T push(@NotNull T item) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (!isEmpty()) {
                T tPeek = peek();
                Intrinsics.checkNotNull(tPeek);
                tPeek.setVisibility(4);
            }
            Object objPush = super.push(item);
            Intrinsics.checkNotNullExpressionValue(objPush, "super.push(item)");
            return (T) objPush;
        }

        public /* bridge */ boolean remove(View view) {
            return super.remove((Object) view);
        }

        @Override // java.util.Vector, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj == null ? true : obj instanceof View) {
                return remove((View) obj);
            }
            return false;
        }
    }

    public StackViewGroup(@NotNull FrameLayout rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.rootView = rootView;
        this.sceneStack = new SceneStack<>();
        this.showDuration = 200L;
        this.hideDuration = 100L;
        Interpolator interpolatorLoadInterpolator = AnimationUtils.loadInterpolator(rootView.getContext(), C0419R.interpolator.sesl_interpolator_0_0_1_1);
        this.showHideInterpolator = interpolatorLoadInterpolator;
        Property property = View.ALPHA;
        final ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat((Object) null, (Property<Object, Float>) property, 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(interpolatorLoadInterpolator);
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat.setStartDelay(100L);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.google.android.material.appbar.StackViewGroup$showAnimator$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Object target = objectAnimatorOfFloat.getTarget();
                View view = target instanceof View ? (View) target : null;
                if (view == null) {
                    return;
                }
                view.setVisibility(0);
            }
        });
        this.showAnimator = objectAnimatorOfFloat;
        final ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat((Object) null, (Property<Object, Float>) property, 1.0f, 0.0f);
        objectAnimatorOfFloat2.setInterpolator(interpolatorLoadInterpolator);
        objectAnimatorOfFloat2.setDuration(100L);
        objectAnimatorOfFloat2.addListener(new Animator.AnimatorListener() { // from class: com.google.android.material.appbar.StackViewGroup$hideAnimator$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Object target = objectAnimatorOfFloat2.getTarget();
                View view = target instanceof View ? (View) target : null;
                if (view != null) {
                    this.getRootView().removeView(view);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        this.hideAnimator = objectAnimatorOfFloat2;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat);
        this.showHideAnimator = animatorSet;
    }

    @NotNull
    public final FrameLayout getRootView() {
        return this.rootView;
    }

    @Nullable
    public final ViewGroup pop() {
        ViewGroup viewGroup = !this.sceneStack.isEmpty() ? (ViewGroup) this.sceneStack.pop() : null;
        this.rootView.removeView(viewGroup);
        return viewGroup;
    }

    public final void push(@Nullable ViewGroup child) {
        if (child != null) {
            this.sceneStack.push(child);
            this.rootView.addView(child);
        }
    }

    public final void remove(@Nullable ViewGroup view) {
        this.sceneStack.remove((Object) view);
        if (view != null) {
            AnimatorSet animatorSet = this.showHideAnimator;
            if (animatorSet.isRunning()) {
                animatorSet.cancel();
            }
            this.hideAnimator.setTarget(view);
            ObjectAnimator objectAnimator = this.showAnimator;
            SceneStack<ViewGroup> sceneStack = this.sceneStack;
            objectAnimator.setTarget(!sceneStack.isEmpty() ? sceneStack.peek() : null);
            this.showHideAnimator.start();
        }
    }
}
