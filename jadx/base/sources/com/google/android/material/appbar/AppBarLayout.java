package com.google.android.material.appbar;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.C0419R;
import androidx.appcompat.animation.SeslAnimationUtils;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.util.SeslMisc;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.coordinatorlayout.widget.AppBarLayoutBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.SeslDisplayUtils;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.glance.AbstractC2821a;
import androidx.work.impl.utils.AbstractC4113a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.material.C4548R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior, AppBarLayoutBehavior {
    private static final float DEFAULT_HEIGHT_RATIO_TO_SCREEN = 0.39f;
    public static final int IMMERSIVE_DETACH_OPTION_SET_FIT_SYSTEM_WINDOW = 1;
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_COLLAPSED_IMM = 512;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_HIDE = 256;
    static final int PENDING_ACTION_NONE = 0;
    public static final int SESL_STATE_COLLAPSED = 2;
    public static final int SESL_STATE_EXPANDED = 1;
    public static final int SESL_STATE_HIDE = 4;
    public static final int SESL_STATE_IDLE = 0;
    private static final float SNAP_THRESHOLD_ON_EXPANDED = 0.43f;
    private static final float SNAP_THRESHOLD_ON_LIFTED = 0.52f;
    private static final String TAG = "AppBarLayout";
    private final float appBarElevation;
    private Behavior behavior;
    private int currentOffset;
    private int downPreScrollRange;
    private int downScrollRange;
    private final boolean hasLiftOnScrollColor;
    private boolean haveChildWithInterpolator;
    private boolean isMouse;

    @Nullable
    private WindowInsetsCompat lastInsets;
    private boolean liftOnScroll;

    @Nullable
    private ValueAnimator liftOnScrollColorAnimator;
    private final long liftOnScrollColorDuration;
    private final TimeInterpolator liftOnScrollColorInterpolator;

    @Nullable
    private ValueAnimator.AnimatorUpdateListener liftOnScrollColorUpdateListener;
    private final List<LiftOnScrollListener> liftOnScrollListeners;

    @Nullable
    private WeakReference<View> liftOnScrollTargetView;

    @IdRes
    private int liftOnScrollTargetViewId;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private List<BaseOnOffsetChangedListener> listeners;
    private int mAdditionalScrollRange;
    private boolean mAllowStartNestedScroll;
    private boolean mAllowStateToHideAppRequestValue;
    private boolean mAllowStateToHideInternal;
    private boolean mAllowStateToHideRequested;
    List<Animator.AnimatorListener> mAnimateOffsetListener;
    List<AppBarStateChangedListener> mAppBarStateChangedListener;
    private SeslAppbarState mAppbarState;
    private Drawable mBackground;
    private int mBottomPadding;
    private float mCollapsedHeight;
    private int mCurrentOrientation;
    private int mCurrentScreenHeight;
    private int mCustomHeight;
    private float mCustomHeightProportion;
    private boolean mHasSuggestion;
    private float mHeightProportion;
    private List<SeslBaseOnImmOffsetChangedListener> mImmOffsetListener;
    private int mImmersiveTopInset;
    private boolean mIsActivatedByUser;
    private boolean mIsActivatedImmersiveScroll;
    private boolean mIsCanImmScroll;
    private boolean mIsDetachedState;
    boolean mIsFirstLayoutAppBar;
    private boolean mIsLiftHided;
    private boolean mIsReservedImmersiveDetachOption;
    private Insets mLastSysInsets;
    private Insets mLastTappableInsets;
    private boolean mOrientationChanged;
    private int mProportionExtraHeight;
    private boolean mRequestedForceExpanded;
    private boolean mReservedFitSystemWindow;
    private Resources mResources;
    private boolean mRestoreAnim;
    private boolean mSetCustomHeight;
    private boolean mSetCustomProportion;
    private boolean mUseCollapsedHeight;
    private boolean mUseCustomHeight;
    private boolean mUseCustomPadding;
    private boolean mUseFloatingToolbar;
    private int pendingAction;

    @Nullable
    private Drawable statusBarForeground;

    @Nullable
    private Integer statusBarForegroundOriginalColor;
    private int[] tmpStatesArray;
    private int totalScrollRange;
    private static final int DEF_STYLE_RES = C4548R.style.Widget_Design_AppBarLayout;
    private static final int TAPPABLE_ELEMENT = WindowInsetsCompat.Type.tappableElement();
    private static final int SYSTEM_BARS = WindowInsetsCompat.Type.systemBars();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AppBarStateChangedListener {
        void onStateChanged(int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private static final int MAX_OFFSET_ANIMATION_DURATION = 450;
        private static int SKIP_ANIMATION_THRESHOLD = 10;

        @Nullable
        private WeakReference<View> lastNestedScrollingChildRef;
        private int lastStartedType;
        private boolean mAnimatorEnded;
        private float mDiffY_Touch;
        private boolean mDirectTouchAppbar;
        private boolean mIsFlingScrollDown;
        boolean mIsFlingScrollUp;
        private boolean mIsSetStaticDuration;
        private float mLastMotionY_Touch;
        private boolean mLifted;
        private boolean mReserveScrollHoldOnCollapse;
        private boolean mReserveScrollHoldOnHide;
        private boolean mRunSnapOnLiftHide;
        private boolean mToolisMouse;
        private int mTouchSlop;
        private boolean mUseScrollHoldOnCollapseFromExpand;
        private boolean mUseScrollHoldOnHide;
        private float mVelocity;
        private ValueAnimator offsetAnimator;
        private int offsetDelta;
        private BaseDragCallback onDragCallback;
        private SavedState savedState;
        private float touchX;
        private float touchY;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static abstract class BaseDragCallback<T extends AppBarLayout> {
            public abstract boolean canDrag(@NonNull T t);
        }

        public BaseBehavior() {
            this.mAnimatorEnded = true;
            this.mIsFlingScrollDown = false;
            this.mIsFlingScrollUp = false;
            this.mDirectTouchAppbar = false;
            this.mTouchSlop = -1;
            this.mVelocity = 0.0f;
            this.mIsSetStaticDuration = false;
            this.mRunSnapOnLiftHide = false;
            this.mUseScrollHoldOnCollapseFromExpand = false;
            this.mReserveScrollHoldOnCollapse = false;
            this.mUseScrollHoldOnHide = false;
            this.mReserveScrollHoldOnHide = false;
        }

        private void addAccessibilityDelegateIfNeeded(final CoordinatorLayout coordinatorLayout, @NonNull final T t) {
            if (ViewCompat.hasAccessibilityDelegate(coordinatorLayout)) {
                return;
            }
            ViewCompat.setAccessibilityDelegate(coordinatorLayout, new AccessibilityDelegateCompat() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.3
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    View childWithScrollingBehavior;
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
                    if (t.getTotalScrollRange() == 0 || (childWithScrollingBehavior = BaseBehavior.this.getChildWithScrollingBehavior(coordinatorLayout)) == null || !BaseBehavior.this.childrenHaveScrollFlags(t)) {
                        return;
                    }
                    if (BaseBehavior.this.getTopBottomOffsetForScrollingSibling() != (-t.getTotalScrollRange())) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                        accessibilityNodeInfoCompat.setScrollable(true);
                    }
                    if (BaseBehavior.this.getTopBottomOffsetForScrollingSibling() != 0) {
                        if (!childWithScrollingBehavior.canScrollVertically(-1)) {
                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                            accessibilityNodeInfoCompat.setScrollable(true);
                        } else if ((-t.getDownNestedPreScrollRange()) != 0) {
                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                            accessibilityNodeInfoCompat.setScrollable(true);
                        }
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    if (i == 4096) {
                        t.setExpanded(false);
                        return true;
                    }
                    if (i != 8192) {
                        return super.performAccessibilityAction(view, i, bundle);
                    }
                    if (BaseBehavior.this.getTopBottomOffsetForScrollingSibling() != 0) {
                        View childWithScrollingBehavior = BaseBehavior.this.getChildWithScrollingBehavior(coordinatorLayout);
                        if (!childWithScrollingBehavior.canScrollVertically(-1)) {
                            t.setExpanded(true);
                            return true;
                        }
                        int i2 = -t.getDownNestedPreScrollRange();
                        if (i2 != 0) {
                            BaseBehavior.this.onNestedPreScroll(coordinatorLayout, t, childWithScrollingBehavior, 0, i2, new int[]{0, 0}, 1);
                            return true;
                        }
                    }
                    return false;
                }
            });
        }

        private void animateOffsetTo(CoordinatorLayout coordinatorLayout, @NonNull T t, int i, float f) {
            int i2 = 250;
            int iAbs = (Math.abs(this.mVelocity) <= 0.0f || Math.abs(this.mVelocity) > 3000.0f) ? 250 : (int) (((double) (3000.0f - Math.abs(this.mVelocity))) * 0.4d);
            if (iAbs <= 250) {
                iAbs = 250;
            }
            if (this.mIsSetStaticDuration) {
                this.mIsSetStaticDuration = false;
            } else {
                i2 = iAbs;
            }
            if (Math.abs(this.mVelocity) < 2000.0f || t.isRequestedForceExpanded()) {
                animateOffsetWithDuration(coordinatorLayout, t, i, i2);
            }
            this.mVelocity = 0.0f;
        }

        private void animateOffsetWithDuration(final CoordinatorLayout coordinatorLayout, final T t, int i, int i2) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (topBottomOffsetForScrollingSibling == i) {
                ValueAnimator valueAnimator = this.offsetAnimator;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.offsetAnimator.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.offsetAnimator;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.offsetAnimator = valueAnimator3;
                valueAnimator3.setInterpolator(SeslAnimationUtils.SINE_OUT_80);
                this.offsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator4) {
                        BaseBehavior.this.setHeaderTopBottomOffset(coordinatorLayout, t, ((Integer) valueAnimator4.getAnimatedValue()).intValue());
                    }
                });
                this.offsetAnimator.addListener(new Animator.AnimatorListener() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(@NonNull Animator animator) {
                        List<Animator.AnimatorListener> list = t.mAnimateOffsetListener;
                        if (list != null) {
                            Iterator<Animator.AnimatorListener> it = list.iterator();
                            while (it.hasNext()) {
                                it.next().onAnimationCancel(animator);
                            }
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(@NonNull Animator animator) {
                        List<Animator.AnimatorListener> list = t.mAnimateOffsetListener;
                        if (list != null) {
                            Iterator<Animator.AnimatorListener> it = list.iterator();
                            while (it.hasNext()) {
                                it.next().onAnimationEnd(animator);
                            }
                        }
                        t.seslStopForceExpanded();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(@NonNull Animator animator) {
                        List<Animator.AnimatorListener> list = t.mAnimateOffsetListener;
                        if (list != null) {
                            Iterator<Animator.AnimatorListener> it = list.iterator();
                            while (it.hasNext()) {
                                it.next().onAnimationRepeat(animator);
                            }
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(@NonNull Animator animator) {
                        List<Animator.AnimatorListener> list = t.mAnimateOffsetListener;
                        if (list != null) {
                            Iterator<Animator.AnimatorListener> it = list.iterator();
                            while (it.hasNext()) {
                                it.next().onAnimationStart(animator);
                            }
                        }
                        BaseBehavior.this.mAnimatorEnded = true;
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.offsetAnimator.setDuration(Math.abs(i - topBottomOffsetForScrollingSibling) < SKIP_ANIMATION_THRESHOLD ? 0L : Math.min(i2, MAX_OFFSET_ANIMATION_DURATION));
            this.offsetAnimator.setIntValues(topBottomOffsetForScrollingSibling, i);
            this.mAnimatorEnded = false;
            this.offsetAnimator.start();
        }

        private int calculateSnapOffset(int i, int i2, int i4) {
            return i < (i2 + i4) / 2 ? i2 : i4;
        }

        private boolean canScrollChildren(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull View view) {
            return t.hasScrollableChildren() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        private static boolean checkFlag(int i, int i2) {
            return (i & i2) == i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean childrenHaveScrollFlags(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (((LayoutParams) appBarLayout.getChildAt(i).getLayoutParams()).scrollFlags != 0) {
                    return true;
                }
            }
            return false;
        }

        @Nullable
        private View findFirstScrollingChild(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        @Nullable
        private static View getAppBarChildOnOffset(@NonNull AppBarLayout appBarLayout, int i) {
            int iAbs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int getChildIndexOnOffset(@NonNull T t, int i) {
            int paddingBottom = i + (t.isLifted() ? t.getPaddingBottom() : 0);
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (checkFlag(layoutParams.getScrollFlags(), 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                if (t.seslGetAdditionalScrollRange() != 0) {
                    bottom += t.seslGetAdditionalScrollRange();
                }
                int i4 = -paddingBottom;
                if (top <= i4 && bottom >= i4) {
                    return i2;
                }
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public View getChildWithScrollingBehavior(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        private int getImmPendingActionOffset(AppBarLayout appBarLayout) {
            if (Build.VERSION.SDK_INT < 30) {
                return 0;
            }
            Behavior behavior = (Behavior) ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            if (!appBarLayout.getCanImmScroll() || !(behavior instanceof SeslImmersiveScrollBehavior)) {
                return 0;
            }
            return appBarLayout.seslGetAdditionalScrollRange() + ((int) appBarLayout.seslGetCollapsedHeight());
        }

        private boolean isScrollHoldMode(T t) {
            if (this.mToolisMouse) {
                return false;
            }
            int childIndexOnOffset = getChildIndexOnOffset(t, getTopBottomOffsetForScrollingSibling());
            return childIndexOnOffset < 0 || (((LayoutParams) t.getChildAt(childIndexOnOffset).getLayoutParams()).getScrollFlags() & 65536) != 65536;
        }

        private boolean shouldJumpElevationState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t) {
            List<View> dependents = coordinatorLayout.getDependents(t);
            int size = dependents.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) dependents.get(i).getLayoutParams()).getBehavior();
                if (behavior instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) behavior).getOverlayTop() != 0;
                }
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x00e9  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0142  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x014f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, @NonNull T t) {
            int i;
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling() - (t.getPaddingTop() + t.getTopInset());
            int childIndexOnOffset = getChildIndexOnOffset(t, topBottomOffsetForScrollingSibling);
            View childAt = null;
            for (int i2 = 0; i2 < coordinatorLayout.getChildCount(); i2++) {
                View childAt2 = coordinatorLayout.getChildAt(i2);
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) childAt2.getLayoutParams();
                if (!(childAt2 instanceof AppBarLayout) && (layoutParams.getBehavior() instanceof ScrollingViewBehavior)) {
                    childAt = childAt2;
                }
            }
            if (childAt == null) {
                childAt = coordinatorLayout.getChildAt(1);
            }
            if (childIndexOnOffset < 0) {
                return;
            }
            View childAt3 = t.getChildAt(childIndexOnOffset);
            LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
            int scrollFlags = layoutParams2.getScrollFlags();
            if ((scrollFlags & 4096) == 4096) {
                seslHasNoSnapFlag(true);
                return;
            }
            seslHasNoSnapFlag(false);
            int iSeslGetAdditionalScrollRange = t.getCanImmScroll() ? t.seslGetAdditionalScrollRange() : 0;
            if (getTopAndBottomOffset() <= t.seslGetCollapsedHeight() + (-t.getHeight())) {
                if (getTopAndBottomOffset() < (-t.seslGetCollapsedHeight())) {
                    if (this.mRunSnapOnLiftHide) {
                        int iSeslGetCollapsedHeight = ((float) t.getBottom()) < t.seslGetCollapsedHeight() / 2.0f ? -t.getHeight() : (int) t.seslGetCollapsedHeight();
                        if (this.mIsFlingScrollUp) {
                            iSeslGetCollapsedHeight = -t.getHeight();
                        } else if (this.mIsFlingScrollDown) {
                            iSeslGetCollapsedHeight = (int) t.seslGetCollapsedHeight();
                        }
                        animateOffsetTo(coordinatorLayout, t, MathUtils.clamp(iSeslGetCollapsedHeight, -t.getHeight(), (int) (t.seslGetCollapsedHeight() + (-t.getHeight()))), 0.0f);
                        return;
                    }
                    return;
                }
                if (t.getCanImmScroll()) {
                    int iSeslGetCollapsedHeight2 = (((int) t.seslGetCollapsedHeight()) - t.getTotalScrollRange()) + iSeslGetAdditionalScrollRange;
                    int i4 = -t.getTotalScrollRange();
                    int i5 = ((double) (t.getBottom() + iSeslGetAdditionalScrollRange)) >= ((double) t.seslGetCollapsedHeight()) * 0.48d ? iSeslGetCollapsedHeight2 : i4;
                    if (!this.mIsFlingScrollUp) {
                        i4 = i5;
                    }
                    if (!this.mIsFlingScrollDown) {
                        iSeslGetCollapsedHeight2 = i4;
                    }
                    animateOffsetTo(coordinatorLayout, t, MathUtils.clamp(iSeslGetCollapsedHeight2, -t.getTotalScrollRange(), 0), 0.0f);
                    return;
                }
                return;
            }
            int i6 = -t.getHeight();
            int iSeslGetCollapsedHeight3 = (int) (t.seslGetCollapsedHeight() + i6);
            int topInset = (childIndexOnOffset == 0 && ViewCompat.getFitsSystemWindows(t) && ViewCompat.getFitsSystemWindows(childAt3)) ? 0 - t.getTopInset() : 0;
            if (checkFlag(scrollFlags, 2)) {
                if (t.getCanImmScroll()) {
                    iSeslGetCollapsedHeight3 = (int) ((t.seslGetCollapsedHeight() - t.getPaddingBottom()) + iSeslGetCollapsedHeight3);
                }
            } else if (checkFlag(scrollFlags, 5)) {
                int minimumHeight = ViewCompat.getMinimumHeight(childAt3) + iSeslGetCollapsedHeight3;
                if (topBottomOffsetForScrollingSibling < minimumHeight) {
                    topInset = minimumHeight;
                } else {
                    iSeslGetCollapsedHeight3 = minimumHeight;
                }
            }
            if (checkFlag(scrollFlags, 32)) {
                topInset += ((LinearLayout.LayoutParams) layoutParams2).topMargin;
                iSeslGetCollapsedHeight3 -= ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
            }
            if (this.mLifted) {
                i = ((float) topBottomOffsetForScrollingSibling) >= ((float) (iSeslGetCollapsedHeight3 + topInset)) * AppBarLayout.SNAP_THRESHOLD_ON_LIFTED ? topInset : iSeslGetCollapsedHeight3;
            } else if (t.useFloatingToolbar()) {
                if (topBottomOffsetForScrollingSibling < (iSeslGetCollapsedHeight3 + topInset) * AppBarLayout.SNAP_THRESHOLD_ON_EXPANDED) {
                    i = i6;
                }
            } else if (topBottomOffsetForScrollingSibling < (iSeslGetCollapsedHeight3 + topInset) * AppBarLayout.SNAP_THRESHOLD_ON_EXPANDED) {
            }
            if (childAt != null) {
                if (this.mIsFlingScrollUp) {
                    if (this.mUseScrollHoldOnCollapseFromExpand || !t.seslCanChangeToHideState()) {
                        i6 = iSeslGetCollapsedHeight3;
                    }
                    this.mIsFlingScrollUp = false;
                    this.mIsFlingScrollDown = false;
                    i = i6;
                }
                if (this.mIsFlingScrollDown && childAt.getTop() > t.seslGetCollapsedHeight()) {
                    this.mIsFlingScrollDown = false;
                }
                if (this.mUseScrollHoldOnCollapseFromExpand) {
                    animateOffsetTo(coordinatorLayout, t, MathUtils.clamp(topInset, getMaxDragOffset((AppBarLayout) t), 0), 0.0f);
                    return;
                } else {
                    animateOffsetTo(coordinatorLayout, t, MathUtils.clamp(topInset, -t.getTotalScrollRange(), 0), 0.0f);
                    return;
                }
            }
            Log.w(AppBarLayout.TAG, "coordinatorLayout.getChildAt(1) is null");
            topInset = i;
            if (this.mUseScrollHoldOnCollapseFromExpand) {
            }
        }

        private void stopNestedScrollIfNeeded(int i, @NonNull T t, View view, int i2) {
            if (i2 == 1) {
                int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
                if ((i >= 0 || topBottomOffsetForScrollingSibling != 0) && (i <= 0 || topBottomOffsetForScrollingSibling != (-t.getDownNestedScrollRange()))) {
                    return;
                }
                ViewCompat.stopNestedScroll(view, 1);
            }
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        public int interpolateOffset(@NonNull T t, int i) {
            int iAbs = Math.abs(i);
            int childCount = t.getChildCount();
            int topInset = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator scrollInterpolator = layoutParams.getScrollInterpolator();
                if (iAbs < childAt.getTop() || iAbs > childAt.getBottom()) {
                    i2++;
                } else if (scrollInterpolator != null) {
                    int scrollFlags = layoutParams.getScrollFlags();
                    if ((scrollFlags & 1) != 0) {
                        topInset = childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        if ((scrollFlags & 2) != 0) {
                            topInset -= ViewCompat.getMinimumHeight(childAt);
                        }
                    }
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        topInset -= t.getTopInset();
                    }
                    if (topInset > 0) {
                        float f = topInset;
                        return (childAt.getTop() + Math.round(scrollInterpolator.getInterpolation((iAbs - childAt.getTop()) / f) * f)) * Integer.signum(i);
                    }
                }
            }
            return i;
        }

        @VisibleForTesting
        public boolean isOffsetAnimatorRunning() {
            ValueAnimator valueAnimator = this.offsetAnimator;
            return valueAnimator != null && valueAnimator.isRunning();
        }

        public void restoreScrollState(@Nullable SavedState savedState, boolean z) {
            if (this.savedState == null || z) {
                this.savedState = savedState;
            }
        }

        @Nullable
        public SavedState saveScrollState(@Nullable Parcelable parcelable, @NonNull T t) {
            int i;
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.EMPTY_STATE;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    boolean z = topAndBottomOffset == 0;
                    savedState.fullyExpanded = z;
                    boolean z2 = !z && (i = -topAndBottomOffset) >= t.getTotalScrollRange() && i < t.getHeight();
                    savedState.fullyScrolled = z2;
                    savedState.fullyHided = (z2 || t.getHeight() == 0 || (-topAndBottomOffset) != t.getHeight()) ? false : true;
                    savedState.firstVisibleChildIndex = i2;
                    savedState.firstVisibleChildAtMinimumHeight = bottom == t.getTopInset() + ViewCompat.getMinimumHeight(childAt);
                    savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                    savedState.lastOffset = topAndBottomOffset;
                    savedState.lastMeasuredHeight = childAt.getMeasuredHeight();
                    return savedState;
                }
            }
            return null;
        }

        public void setDragCallback(@Nullable BaseDragCallback baseDragCallback) {
            this.onDragCallback = baseDragCallback;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void updateAppBarLayoutDrawableState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i, int i2, boolean z) {
            View appBarChildOnOffset = getAppBarChildOnOffset(t, i);
            boolean zShouldLift = false;
            if (appBarChildOnOffset != null) {
                int scrollFlags = ((LayoutParams) appBarChildOnOffset.getLayoutParams()).getScrollFlags();
                if (t.useFloatingToolbar()) {
                    if (i <= t.seslGetCollapsedHeight() + (-t.getHeight())) {
                        zShouldLift = true;
                    }
                } else if ((scrollFlags & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(appBarChildOnOffset);
                    if (i2 <= 0 || (scrollFlags & 12) == 0 ? !((scrollFlags & 2) == 0 || (-i) < ((appBarChildOnOffset.getBottom() - minimumHeight) - t.getTopInset()) - t.getImmersiveTopInset()) : (-i) >= ((appBarChildOnOffset.getBottom() - minimumHeight) - t.getTopInset()) - t.getImmersiveTopInset()) {
                    }
                }
            }
            if (t.isLiftOnScroll()) {
                zShouldLift = t.shouldLift(findFirstScrollingChild(coordinatorLayout));
            }
            boolean liftedState = t.setLiftedState(zShouldLift);
            if (z || (liftedState && shouldJumpElevationState(coordinatorLayout, t))) {
                if (t.getBackground() != null) {
                    t.getBackground().jumpToCurrentState();
                }
                if (t.getForeground() != null) {
                    t.getForeground().jumpToCurrentState();
                }
                if (t.getStateListAnimator() != null) {
                    t.getStateListAnimator().jumpToCurrentState();
                }
            }
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public boolean canDragView(T t) {
            BaseDragCallback baseDragCallback = this.onDragCallback;
            if (baseDragCallback != null) {
                return baseDragCallback.canDrag(t);
            }
            WeakReference<View> weakReference = this.lastNestedScrollingChildRef;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public int getMaxDragOffset(@NonNull T t) {
            if (!t.useFloatingToolbar()) {
                return (int) (t.seslGetCollapsedHeight() + (-t.getHeight()));
            }
            if (t.seslCanChangeToHideState()) {
                return t.getTopInset() + (-t.getHeight());
            }
            return (int) (t.seslGetCollapsedHeight() + (-t.getHeight()));
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public int getScrollRangeForDragFling(@NonNull T t) {
            return t.getTotalScrollRange();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public void onFlingFinished(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t) {
            OverScroller overScroller = this.scroller;
            if (overScroller != null) {
                overScroller.forceFinished(true);
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i) {
            boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, t, i);
            this.mVelocity = 0.0f;
            int pendingAction = t.getPendingAction();
            SavedState savedState = this.savedState;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        float immPendingActionOffset = ((-t.getTotalScrollRange()) + getImmPendingActionOffset(t)) - t.getImmersiveTopInset();
                        if (z) {
                            animateOffsetTo(coordinatorLayout, t, (int) immPendingActionOffset, 0.0f);
                        } else {
                            setHeaderTopBottomOffset(coordinatorLayout, t, (int) immPendingActionOffset);
                        }
                    } else if ((pendingAction & 512) != 0) {
                        float immPendingActionOffset2 = (-t.getTotalScrollRange()) + getImmPendingActionOffset(t);
                        if (coordinatorLayout.getContext().getResources().getConfiguration().orientation == 1 && t.getImmersiveTopInset() == 0 && t.seslGetHeightProPortion() == 0.0f) {
                            immPendingActionOffset2 = 0.0f;
                        }
                        if (z) {
                            animateOffsetTo(coordinatorLayout, t, (int) immPendingActionOffset2, 0.0f);
                        } else {
                            setHeaderTopBottomOffset(coordinatorLayout, t, (int) immPendingActionOffset2);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z) {
                            animateOffsetTo(coordinatorLayout, t, 0, 0.0f);
                        } else {
                            setHeaderTopBottomOffset(coordinatorLayout, t, 0);
                        }
                    } else if ((pendingAction & 256) != 0) {
                        if (z) {
                            animateOffsetTo(coordinatorLayout, t, -t.seslGetTotalFullyScrollRange(), 0.0f);
                        } else {
                            setHeaderTopBottomOffset(coordinatorLayout, t, -t.seslGetTotalFullyScrollRange());
                        }
                    }
                }
            } else if (savedState.fullyHided) {
                setHeaderTopBottomOffset(coordinatorLayout, t, -t.getHeight());
            } else if (savedState.fullyScrolled) {
                if (savedState.lastMeasuredHeight == t.getMeasuredHeight()) {
                    setHeaderTopBottomOffset(coordinatorLayout, t, this.savedState.lastOffset);
                } else {
                    setHeaderTopBottomOffset(coordinatorLayout, t, -t.getTotalScrollRange());
                }
            } else if (savedState.fullyExpanded) {
                setHeaderTopBottomOffset(coordinatorLayout, t, 0);
            } else {
                View childAt = t.getChildAt(savedState.firstVisibleChildIndex);
                if (childAt != null) {
                    int i2 = -childAt.getBottom();
                    setHeaderTopBottomOffset(coordinatorLayout, t, this.savedState.firstVisibleChildAtMinimumHeight ? t.getTopInset() + ViewCompat.getMinimumHeight(childAt) + i2 : Math.round(childAt.getHeight() * this.savedState.firstVisibleChildPercentageShown) + i2);
                } else {
                    Log.e(AppBarLayout.TAG, "Failed get firstVisible child skip the offset control");
                }
            }
            t.resetPendingAction();
            this.savedState = null;
            if (t.useFloatingToolbar()) {
                setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -t.getHeight(), 0));
            } else if (t.useCollapsedHeight()) {
                setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), (int) (t.seslGetCollapsedHeight() + (-t.getHeight())), 0));
            } else {
                setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -t.getTotalScrollRange(), 0));
            }
            updateAppBarLayoutDrawableState(coordinatorLayout, t, getTopAndBottomOffset(), 0, false);
            t.onOffsetChanged(getTopAndBottomOffset());
            addAccessibilityDelegateIfNeeded(coordinatorLayout, t);
            return zOnLayoutChild;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i, int i2, int i4, int i5) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) t.getLayoutParams())).height != -2) {
                return super.onMeasureChild(coordinatorLayout, t, i, i2, i4, i5);
            }
            coordinatorLayout.onMeasureChild(t, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull View view, float f, float f4) {
            this.mVelocity = f4;
            if (f != 0.0f) {
                return false;
            }
            if (f4 < -300.0f) {
                this.mIsFlingScrollDown = true;
                this.mIsFlingScrollUp = false;
            } else {
                if (f4 <= 300.0f) {
                    this.mVelocity = 0.0f;
                    this.mIsFlingScrollDown = false;
                    this.mIsFlingScrollUp = false;
                    return true;
                }
                this.mIsFlingScrollDown = false;
                this.mIsFlingScrollUp = true;
            }
            return super.onNestedPreFling(coordinatorLayout, t, view, f, f4);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x009f  */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull T t, View view, int i, int i2, int[] iArr, int i4) {
            float f;
            float fSeslGetCollapsedHeight;
            int i5;
            int downNestedPreScrollRange;
            BaseBehavior<T> baseBehavior;
            CoordinatorLayout coordinatorLayout2;
            int i6;
            int i7;
            int i8;
            if (i2 != 0) {
                int i9 = 0;
                if (i2 < 0) {
                    i5 = -t.getTotalScrollRange();
                    downNestedPreScrollRange = t.getDownNestedPreScrollRange() + i5;
                    this.mIsFlingScrollDown = true;
                    this.mIsFlingScrollUp = false;
                    if (t.getBottom() >= ((double) t.getHeight()) * 0.52d) {
                        this.mIsSetStaticDuration = true;
                    }
                    if (i2 < -30) {
                        this.mIsFlingScrollDown = true;
                    } else {
                        this.mVelocity = 0.0f;
                        this.mIsFlingScrollDown = false;
                    }
                } else {
                    if (t.useFloatingToolbar()) {
                        i5 = -t.getHeight();
                        if (!t.seslCanChangeToHideState()) {
                            f = -t.getHeight();
                            fSeslGetCollapsedHeight = t.seslGetCollapsedHeight();
                        }
                        this.mIsFlingScrollDown = false;
                        this.mIsFlingScrollUp = true;
                        if (t.getBottom() <= ((double) t.getHeight()) * 0.43d) {
                            this.mIsSetStaticDuration = true;
                        }
                        if (i2 <= 30) {
                            this.mIsFlingScrollUp = true;
                        } else {
                            this.mVelocity = 0.0f;
                            this.mIsFlingScrollUp = false;
                        }
                        if (this.mUseScrollHoldOnHide && getTopAndBottomOffset() == i5) {
                            this.mUseScrollHoldOnHide = true;
                        }
                        if (getTopAndBottomOffset() == (-t.getHeight())) {
                            this.mReserveScrollHoldOnHide = true;
                        }
                        downNestedPreScrollRange = 0;
                    } else {
                        f = -t.getHeight();
                        fSeslGetCollapsedHeight = t.seslGetCollapsedHeight();
                    }
                    i5 = (int) (fSeslGetCollapsedHeight + f);
                    this.mIsFlingScrollDown = false;
                    this.mIsFlingScrollUp = true;
                    if (t.getBottom() <= ((double) t.getHeight()) * 0.43d) {
                    }
                    if (i2 <= 30) {
                    }
                    if (this.mUseScrollHoldOnHide) {
                        this.mUseScrollHoldOnHide = true;
                    }
                    if (getTopAndBottomOffset() == (-t.getHeight())) {
                    }
                    downNestedPreScrollRange = 0;
                }
                if (isFlingRunnable()) {
                    onFlingFinished(coordinatorLayout, (AppBarLayout) t);
                }
                if (i5 != downNestedPreScrollRange) {
                    if (t.useFloatingToolbar() && i2 > 0 && this.mLifted) {
                        if (this.mUseScrollHoldOnCollapseFromExpand) {
                            i8 = -t.getHeight();
                            int iSeslGetCollapsedHeight = (int) (t.seslGetCollapsedHeight() + i8);
                            if (t.getTop() <= iSeslGetCollapsedHeight) {
                                i9 = iSeslGetCollapsedHeight;
                            }
                        } else {
                            i8 = -t.getHeight();
                        }
                        int iSeslGetCollapsedHeight2 = i8;
                        if (!t.seslCanChangeToHideState()) {
                            iSeslGetCollapsedHeight2 = (int) (t.seslGetCollapsedHeight() + (-t.getHeight()));
                        }
                        baseBehavior = this;
                        i6 = i9;
                        i7 = iSeslGetCollapsedHeight2;
                        coordinatorLayout2 = coordinatorLayout;
                    } else {
                        baseBehavior = this;
                        coordinatorLayout2 = coordinatorLayout;
                        i6 = downNestedPreScrollRange;
                        i7 = i5;
                    }
                    iArr[1] = baseBehavior.scroll(coordinatorLayout2, t, i2, i7, i6);
                }
            }
            if (t.isLiftOnScroll()) {
                t.setLiftedState(t.shouldLift(view));
            }
            stopNestedScrollIfNeeded(i2, t, view, i4);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t, View view, int i, int i2, int i4, int i5, int i6, int[] iArr) {
            CoordinatorLayout coordinatorLayout2;
            T t2;
            int i7;
            if (!t.useFloatingToolbar()) {
                coordinatorLayout2 = coordinatorLayout;
                t2 = t;
                i7 = i5;
                if (isScrollHoldMode(t2)) {
                    if (i7 >= 0 || this.mReserveScrollHoldOnCollapse) {
                        ViewCompat.stopNestedScroll(view, 1);
                    } else {
                        iArr[1] = scroll(coordinatorLayout2, t2, i7, -t2.getDownNestedScrollRange(), 0);
                        stopNestedScrollIfNeeded(i7, t2, view, i6);
                    }
                } else if (i7 < 0) {
                    iArr[1] = scroll(coordinatorLayout2, t2, i7, -t2.getDownNestedScrollRange(), 0);
                    stopNestedScrollIfNeeded(i7, t2, view, i6);
                }
            } else if (!this.mUseScrollHoldOnHide || !isScrollHoldMode(t)) {
                coordinatorLayout2 = coordinatorLayout;
                t2 = t;
                i7 = i5;
                if (isScrollHoldMode(t2)) {
                    int iSeslGetCollapsedHeight = (-t2.getHeight()) + ((int) t2.seslGetCollapsedHeight());
                    if (i7 < 0 && t2.getTop() >= iSeslGetCollapsedHeight) {
                        iArr[1] = scroll(coordinatorLayout2, t2, i7, iSeslGetCollapsedHeight, 0);
                    } else if (i7 < 0 && t2.getTop() < iSeslGetCollapsedHeight) {
                        iArr[1] = scroll(coordinatorLayout2, t2, i7, -t2.getHeight(), iSeslGetCollapsedHeight);
                        if (t2.getTop() == iSeslGetCollapsedHeight) {
                            ViewCompat.stopNestedScroll(view, 1);
                        }
                    }
                } else if (i7 < 0) {
                    t2.getHeight();
                    t2.seslGetCollapsedHeight();
                    iArr[1] = scroll(coordinatorLayout2, t2, i7, -t2.getHeight(), 0);
                }
            } else if (i5 >= 0 || this.mReserveScrollHoldOnHide || getTopAndBottomOffset() >= (-t.getDownNestedScrollRange())) {
                coordinatorLayout2 = coordinatorLayout;
                t2 = t;
                i7 = i5;
                if (i7 >= 0 || this.mReserveScrollHoldOnCollapse) {
                    ViewCompat.stopNestedScroll(view, 1);
                } else {
                    iArr[1] = scroll(coordinatorLayout2, t2, i7, -t2.getDownNestedScrollRange(), 0);
                    stopNestedScrollIfNeeded(i7, t2, view, i6);
                }
            } else {
                coordinatorLayout2 = coordinatorLayout;
                t2 = t;
                i7 = i5;
                iArr[1] = scroll(coordinatorLayout2, t2, i7, -t.getHeight(), -t.getDownNestedScrollRange());
                stopNestedScrollIfNeeded(i7, t2, view, i6);
            }
            if (i7 == 0) {
                addAccessibilityDelegateIfNeeded(coordinatorLayout2, t2);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                restoreScrollState((SavedState) parcelable, true);
                super.onRestoreInstanceState(coordinatorLayout, t, this.savedState.getSuperState());
            } else {
                super.onRestoreInstanceState(coordinatorLayout, t, parcelable);
                this.savedState = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t) {
            Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, t);
            SavedState savedStateSaveScrollState = saveScrollState(parcelableOnSaveInstanceState, t);
            return savedStateSaveScrollState == null ? parcelableOnSaveInstanceState : savedStateSaveScrollState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull View view, View view2, int i, int i2) {
            boolean z = (i & 2) != 0 && (t.isLiftOnScroll() || canScrollChildren(coordinatorLayout, t, view));
            if (!z && t.useFloatingToolbar()) {
                z = true;
            }
            if (!t.seslIsAllowStartNestedScroll()) {
                z = false;
            }
            if (z && this.offsetAnimator != null && !t.isRequestedForceExpanded()) {
                this.offsetAnimator.cancel();
            }
            if (t.getBottom() <= t.seslGetCollapsedHeight()) {
                this.mLifted = true;
                t.setLifted(true);
                this.mDiffY_Touch = 0.0f;
                if (t.getBottom() <= 0) {
                    t.seslSetLiftHided(true);
                }
            } else {
                this.mLifted = false;
                t.setLifted(false);
                t.seslSetLiftHided(false);
            }
            t.updateInternalCollapsedHeight();
            this.lastNestedScrollingChildRef = null;
            this.lastStartedType = i2;
            this.mToolisMouse = t.getIsMouse();
            return z;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t, View view, int i) {
            int i2;
            int i4 = this.mLastTouchEvent;
            if (i4 == 3 || i4 == 1 || (i2 = this.mLastInterceptTouchEvent) == 3 || i2 == 1) {
                snapToChildIfNeeded(coordinatorLayout, t);
            }
            if (this.lastStartedType == 0 || i == 1) {
                if (t.isLiftOnScroll()) {
                    t.setLiftedState(t.shouldLift(view));
                }
                if (this.mReserveScrollHoldOnCollapse) {
                    this.mReserveScrollHoldOnCollapse = false;
                }
                if (this.mReserveScrollHoldOnHide) {
                    this.mReserveScrollHoldOnHide = false;
                }
            }
            this.lastNestedScrollingChildRef = new WeakReference<>(view);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull MotionEvent motionEvent) {
            if (this.mTouchSlop < 0) {
                this.mTouchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
            }
            int action = motionEvent.getAction();
            this.mToolisMouse = t.getIsMouse();
            if (action == 0) {
                this.mDirectTouchAppbar = true;
                this.touchX = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.touchY = y2;
                this.mLastMotionY_Touch = y2;
                this.mDiffY_Touch = 0.0f;
            } else if (action == 1) {
                if (Math.abs(this.mDiffY_Touch) > 21.0f) {
                    float f = this.mDiffY_Touch;
                    if (f < 0.0f) {
                        this.mIsFlingScrollUp = true;
                        this.mIsFlingScrollDown = false;
                    } else if (f > 0.0f) {
                        this.mIsFlingScrollUp = false;
                        this.mIsFlingScrollDown = true;
                    }
                } else {
                    this.touchX = 0.0f;
                    this.touchY = 0.0f;
                    this.mIsFlingScrollUp = false;
                    this.mIsFlingScrollDown = false;
                    this.mLastMotionY_Touch = 0.0f;
                }
                if (this.mDirectTouchAppbar) {
                    this.mDirectTouchAppbar = false;
                    snapToChildIfNeeded(coordinatorLayout, t);
                }
            } else if (action == 2) {
                this.mDirectTouchAppbar = true;
                float y3 = motionEvent.getY();
                float f4 = this.mLastMotionY_Touch;
                if (y3 - f4 != 0.0f) {
                    this.mDiffY_Touch = y3 - f4;
                }
                if (Math.abs(this.mDiffY_Touch) > this.mTouchSlop) {
                    this.mLastMotionY_Touch = y3;
                }
            } else if (action == 3) {
            }
            return super.onTouchEvent(coordinatorLayout, t, motionEvent);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public int setHeaderTopBottomOffset(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i, int i2, int i4) {
            CoordinatorLayout coordinatorLayout2;
            T t2;
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int i5 = 0;
            if (topBottomOffsetForScrollingSibling < i2 || topBottomOffsetForScrollingSibling > i4) {
                coordinatorLayout2 = coordinatorLayout;
                t2 = t;
                this.offsetDelta = 0;
            } else {
                int iClamp = MathUtils.clamp(i, i2, i4);
                if (topBottomOffsetForScrollingSibling != iClamp) {
                    int iInterpolateOffset = t.hasChildWithInterpolator() ? interpolateOffset(t, iClamp) : iClamp;
                    boolean topAndBottomOffset = setTopAndBottomOffset(iInterpolateOffset);
                    int i6 = topBottomOffsetForScrollingSibling - iClamp;
                    this.offsetDelta = iClamp - iInterpolateOffset;
                    if (topAndBottomOffset) {
                        while (i5 < t.getChildCount()) {
                            LayoutParams layoutParams = (LayoutParams) t.getChildAt(i5).getLayoutParams();
                            ChildScrollEffect scrollEffect = layoutParams.getScrollEffect();
                            if (scrollEffect != null && (layoutParams.getScrollFlags() & 1) != 0) {
                                scrollEffect.onOffsetChanged(t, t.getChildAt(i5), getTopAndBottomOffset());
                            }
                            i5++;
                        }
                    }
                    if (!topAndBottomOffset && t.hasChildWithInterpolator()) {
                        coordinatorLayout.dispatchDependentViewsChanged(t);
                    }
                    t.onOffsetChanged(getTopAndBottomOffset());
                    coordinatorLayout2 = coordinatorLayout;
                    t2 = t;
                    updateAppBarLayoutDrawableState(coordinatorLayout2, t2, iClamp, iClamp < topBottomOffsetForScrollingSibling ? -1 : 1, false);
                    i5 = i6;
                } else {
                    coordinatorLayout2 = coordinatorLayout;
                    t2 = t;
                }
            }
            addAccessibilityDelegateIfNeeded(coordinatorLayout2, t2);
            return i5;
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.SavedState.1
                @Override // android.os.Parcelable.Creator
                @NonNull
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                @NonNull
                public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                @Nullable
                public SavedState createFromParcel(@NonNull Parcel parcel) {
                    return new SavedState(parcel, null);
                }
            };
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;
            boolean fullyExpanded;
            boolean fullyHided;
            boolean fullyScrolled;
            int lastMeasuredHeight;
            int lastOffset;

            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.fullyHided = parcel.readByte() != 0;
                this.fullyScrolled = parcel.readByte() != 0;
                this.fullyExpanded = parcel.readByte() != 0;
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
                this.lastOffset = parcel.readInt();
                this.lastMeasuredHeight = parcel.readInt();
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeByte(this.fullyHided ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.fullyScrolled ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.fullyExpanded ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.lastOffset);
                parcel.writeInt(this.lastMeasuredHeight);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mAnimatorEnded = true;
            this.mIsFlingScrollDown = false;
            this.mIsFlingScrollUp = false;
            this.mDirectTouchAppbar = false;
            this.mTouchSlop = -1;
            this.mVelocity = 0.0f;
            this.mIsSetStaticDuration = false;
            this.mRunSnapOnLiftHide = false;
            this.mUseScrollHoldOnCollapseFromExpand = false;
            this.mReserveScrollHoldOnCollapse = false;
            this.mUseScrollHoldOnHide = false;
            this.mReserveScrollHoldOnHide = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void onOffsetChanged(T t, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Behavior extends BaseBehavior<AppBarLayout> {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {
        }

        public Behavior() {
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ int getLastInterceptTouchEventEvent() {
            return super.getLastInterceptTouchEventEvent();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        public /* bridge */ /* synthetic */ int getLastTouchEventEvent() {
            return super.getLastTouchEventEvent();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i) {
            return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i, int i2, int i4, int i5) {
            return super.onMeasureChild(coordinatorLayout, appBarLayout, i, i2, i4, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f4) {
            return super.onNestedPreFling(coordinatorLayout, appBarLayout, view, f, f4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i4) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i, int i2, int i4, int i5, int i6, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i4, i5, i6, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, View view2, int i, int i2) {
            return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i) {
            super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull MotionEvent motionEvent) {
            return super.onTouchEvent(coordinatorLayout, appBarLayout, motionEvent);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public /* bridge */ /* synthetic */ void seslHasNoSnapFlag(boolean z) {
            super.seslHasNoSnapFlag(z);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void setDragCallback(@Nullable BaseBehavior.BaseDragCallback baseDragCallback) {
            super.setDragCallback(baseDragCallback);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z) {
            super.setHorizontalOffsetEnabled(z);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
            return super.setLeftAndRightOffset(i);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
            return super.setTopAndBottomOffset(i);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z) {
            super.setVerticalOffsetEnabled(z);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ChildScrollEffect {
        public abstract void onOffsetChanged(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CompressChildScrollEffect extends ChildScrollEffect {
        private static final float COMPRESS_DISTANCE_FACTOR = 0.3f;
        private final Rect relativeRect = new Rect();
        private final Rect ghostRect = new Rect();

        private static void updateRelativeRect(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ChildScrollEffect
        public void onOffsetChanged(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f) {
            updateRelativeRect(this.relativeRect, appBarLayout, view);
            float fAbs = this.relativeRect.top - Math.abs(f);
            if (fAbs > 0.0f) {
                ViewCompat.setClipBounds(view, null);
                view.setTranslationY(0.0f);
                view.setVisibility(0);
                return;
            }
            float fClamp = 1.0f - MathUtils.clamp(Math.abs(fAbs / this.relativeRect.height()), 0.0f, 1.0f);
            float fHeight = (-fAbs) - ((this.relativeRect.height() * 0.3f) * (1.0f - (fClamp * fClamp)));
            view.setTranslationY(fHeight);
            view.getDrawingRect(this.ghostRect);
            this.ghostRect.offset(0, (int) (-fHeight));
            if (fHeight >= this.ghostRect.height()) {
                view.setVisibility(4);
            } else {
                view.setVisibility(0);
            }
            ViewCompat.setClipBounds(view, this.ghostRect);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        static final int COLLAPSIBLE_FLAGS = 10;
        private static final int FLAG_NO_SCROLL_HOLD = 65536;
        private static final int FLAG_NO_SNAP = 4096;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        public static final int SCROLL_EFFECT_COMPRESS = 1;
        public static final int SCROLL_EFFECT_NONE = 0;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_NO_SCROLL = 0;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
        public static final int SESL_SCROLL_FLAG_NO_SCROLL_HOLD = 65536;
        public static final int SESL_SCROLL_FLAG_NO_SNAP = 4096;
        private ChildScrollEffect scrollEffect;
        int scrollFlags;
        Interpolator scrollInterpolator;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface ScrollEffect {
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.scrollFlags = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4548R.styleable.AppBarLayout_Layout);
            this.scrollFlags = typedArrayObtainStyledAttributes.getInt(C4548R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            setScrollEffect(typedArrayObtainStyledAttributes.getInt(C4548R.styleable.AppBarLayout_Layout_layout_scrollEffect, 0));
            if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.scrollInterpolator = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(C4548R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        @Nullable
        private ChildScrollEffect createScrollEffectFromInt(int i) {
            if (i != 1) {
                return null;
            }
            return new CompressChildScrollEffect();
        }

        @Nullable
        public ChildScrollEffect getScrollEffect() {
            return this.scrollEffect;
        }

        public int getScrollFlags() {
            return this.scrollFlags;
        }

        public Interpolator getScrollInterpolator() {
            return this.scrollInterpolator;
        }

        public boolean isCollapsible() {
            int i = this.scrollFlags;
            return (i & 1) == 1 && (i & 10) != 0;
        }

        public void setScrollEffect(@Nullable ChildScrollEffect childScrollEffect) {
            this.scrollEffect = childScrollEffect;
        }

        public void setScrollFlags(int i) {
            this.scrollFlags = i;
        }

        public void setScrollInterpolator(Interpolator interpolator) {
            this.scrollInterpolator = interpolator;
        }

        public void setScrollEffect(int i) {
            this.scrollEffect = createScrollEffectFromInt(i);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.scrollFlags = 1;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.scrollFlags = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.scrollFlags = 1;
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((LinearLayout.LayoutParams) layoutParams);
            this.scrollFlags = 1;
            this.scrollFlags = layoutParams.scrollFlags;
            this.scrollEffect = layoutParams.scrollEffect;
            this.scrollInterpolator = layoutParams.scrollInterpolator;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface LiftOnScrollListener {
        void onUpdate(@Dimension float f, @ColorInt int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        void onOffsetChanged(AppBarLayout appBarLayout, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private static int getAppBarLayoutOffset(@NonNull AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                return ((BaseBehavior) behavior).getTopBottomOffsetForScrollingSibling();
            }
            return 0;
        }

        private void offsetChildAsNeeded(@NonNull View view, @NonNull View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, ((((BaseBehavior) behavior).offsetDelta + (view2.getBottom() - view.getTop())) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
            }
        }

        private void updateLiftedStateIfNeeded(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.isLiftOnScroll()) {
                    appBarLayout.setLiftedState(appBarLayout.shouldLift(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        public /* bridge */ /* synthetic */ View findFirstDependency(@NonNull List list) {
            return findFirstDependency((List<View>) list);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public float getOverlapRatioForOffset(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int appBarLayoutOffset = getAppBarLayoutOffset(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + appBarLayoutOffset > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (appBarLayoutOffset / i) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public int getScrollRange(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.getScrollRange(view);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            offsetChildAsNeeded(view, view2);
            updateLiftedStateIfNeeded(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.setAccessibilityDelegate(coordinatorLayout, null);
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
            return super.onLayoutChild(coordinatorLayout, view, i);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i, int i2, int i4, int i5) {
            return super.onMeasureChild(coordinatorLayout, view, i, i2, i4, i5);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z) {
            AppBarLayout appBarLayoutFindFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
            if (appBarLayoutFindFirstDependency != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                Rect rect3 = this.tempRect1;
                rect3.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect3.contains(rect2)) {
                    appBarLayoutFindFirstDependency.setExpanded(false, !z);
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z) {
            super.setHorizontalOffsetEnabled(z);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
            return super.setLeftAndRightOffset(i);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
            return super.setTopAndBottomOffset(i);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z) {
            super.setVerticalOffsetEnabled(z);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4548R.styleable.ScrollingViewBehavior_Layout);
            setOverlayTop(typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        public AppBarLayout findFirstDependency(@NonNull List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SeslAppbarState {
        private int mCurrentState = 0;

        public int getState() {
            return this.mCurrentState;
        }

        public void setState(int i) {
            this.mCurrentState = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SeslBaseOnImmOffsetChangedListener<T extends AppBarLayout> {
        void onOffsetChanged(T t, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SeslOnImmOffsetChangedListener extends SeslBaseOnImmOffsetChangedListener<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.SeslBaseOnImmOffsetChangedListener
        void onOffsetChanged(AppBarLayout appBarLayout, int i);
    }

    public AppBarLayout(@NonNull Context context) {
        this(context, null);
    }

    private int calculateInternalHeight() {
        int windowHeight = getWindowHeight();
        float heightPercent = windowHeight * getHeightPercent();
        if (heightPercent == 0.0f) {
            updateInternalCollapsedHeightOnce();
            heightPercent = seslGetCollapsedHeight();
        }
        StringBuilder sb = new StringBuilder("[calculateInternalHeight] orientation:");
        sb.append(this.mResources.getConfiguration().orientation);
        sb.append(", density:");
        AbstractC2821a.m2235z(sb, this.mResources.getConfiguration().densityDpi, windowHeight, ", windowHeight:", ", heightDp:");
        sb.append(heightPercent);
        StringBuilder sb2 = new StringBuilder(sb.toString());
        if (!this.mUseCustomHeight) {
            sb2.append(", [3]mHeightProportion : ");
            sb2.append(this.mHeightProportion);
            if (this.mHeightProportion != 0.0f && this.mProportionExtraHeight != 0) {
                sb2.append(", [4]mProportionExtraHeight : ");
                sb2.append(this.mProportionExtraHeight);
                heightPercent += this.mProportionExtraHeight;
            }
        } else if (this.mSetCustomProportion) {
            sb2.append(", [1]mCustomHeightProportion : ");
            sb2.append(this.mCustomHeightProportion);
        } else if (this.mSetCustomHeight) {
            heightPercent = getImmersiveTopInset() + this.mCustomHeight;
            sb2.append(", [2]CustomHeight : ");
            sb2.append(this.mCustomHeight);
        }
        Log.i(TAG, sb2.toString());
        return (int) heightPercent;
    }

    private void clearLiftOnScrollTargetView() {
        WeakReference<View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.liftOnScrollTargetView = null;
    }

    @Nullable
    private Integer extractStatusBarForegroundColor() {
        Drawable drawable = this.statusBarForeground;
        if (drawable instanceof MaterialShapeDrawable) {
            return Integer.valueOf(((MaterialShapeDrawable) drawable).getResolvedTintColor());
        }
        ColorStateList colorStateListOrNull = DrawableUtils.getColorStateListOrNull(drawable);
        if (colorStateListOrNull != null) {
            return Integer.valueOf(colorStateListOrNull.getDefaultColor());
        }
        return null;
    }

    @Nullable
    private View findLiftOnScrollTargetView(@Nullable View view) {
        int i;
        if (this.liftOnScrollTargetView == null && (i = this.liftOnScrollTargetViewId) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.liftOnScrollTargetViewId);
            }
            if (viewFindViewById != null) {
                this.liftOnScrollTargetView = new WeakReference<>(viewFindViewById);
            }
        }
        WeakReference<View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private float getDifferImmHeightRatio() {
        float windowHeight = getWindowHeight();
        float immersiveTopInset = getImmersiveTopInset();
        if (windowHeight == 0.0f) {
            windowHeight = 1.0f;
        }
        return immersiveTopInset / windowHeight;
    }

    private float getHeightPercent() {
        if (!this.mUseCustomHeight) {
            return this.mHeightProportion;
        }
        float f = this.mCustomHeightProportion;
        if (f != 0.0f) {
            return f + (getCanImmScroll() ? getDifferImmHeightRatio() : 0.0f);
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SeslImmersiveScrollBehavior getImmBehavior() {
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof SeslImmersiveScrollBehavior) {
                return (SeslImmersiveScrollBehavior) behavior;
            }
        }
        return null;
    }

    private int getWindowHeight() {
        return this.mIsActivatedImmersiveScroll ? getContext().getResources().getDisplayMetrics().heightPixels : SeslAppBarHelper.INSTANCE.getScreenHeight(this);
    }

    private boolean hasCollapsibleChild() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).isCollapsible()) {
                return true;
            }
        }
        return false;
    }

    private void initializeLiftOnScrollWithColor(final MaterialShapeDrawable materialShapeDrawable, @NonNull final ColorStateList colorStateList, @NonNull final ColorStateList colorStateList2) {
        final Integer colorOrNull = MaterialColors.getColorOrNull(getContext(), C4548R.attr.colorSurface);
        this.liftOnScrollColorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f2230a.lambda$initializeLiftOnScrollWithColor$0(colorStateList, colorStateList2, materialShapeDrawable, colorOrNull, valueAnimator);
            }
        };
        ViewCompat.setBackground(this, materialShapeDrawable);
    }

    private void initializeLiftOnScrollWithElevation(Context context, MaterialShapeDrawable materialShapeDrawable) {
        materialShapeDrawable.initializeElevationOverlay(context);
        this.liftOnScrollColorUpdateListener = new C4565b(this, materialShapeDrawable, 0);
        ViewCompat.setBackground(this, materialShapeDrawable);
    }

    private void invalidateScrollRanges() {
        Behavior behavior = this.behavior;
        BaseBehavior.SavedState savedStateSaveScrollState = (behavior == null || this.totalScrollRange == -1 || this.pendingAction != 0) ? null : behavior.saveScrollState(AbsSavedState.EMPTY_STATE, this);
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        if (savedStateSaveScrollState != null) {
            this.behavior.restoreScrollState(savedStateSaveScrollState, false);
        }
    }

    private boolean isDexEnabled() {
        if (getContext() == null) {
            return false;
        }
        return SeslDisplayUtils.isDexEnabled(getContext());
    }

    private boolean isLiftOnScrollCompatibleBackground() {
        return getBackground() instanceof MaterialShapeDrawable;
    }

    private static boolean isVerticalScrollDown(float f) {
        return f > 0.0f;
    }

    private static boolean isVerticalScrollUp(float f) {
        return f < 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeLiftOnScrollWithColor$0(ColorStateList colorStateList, ColorStateList colorStateList2, MaterialShapeDrawable materialShapeDrawable, Integer num, ValueAnimator valueAnimator) {
        Integer num2;
        int iLayer = MaterialColors.layer(colorStateList.getDefaultColor(), colorStateList2.getDefaultColor(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(iLayer));
        if (this.statusBarForeground != null && (num2 = this.statusBarForegroundOriginalColor) != null && num2.equals(num)) {
            DrawableCompat.setTint(this.statusBarForeground, iLayer);
        }
        if (this.liftOnScrollListeners.isEmpty()) {
            return;
        }
        for (LiftOnScrollListener liftOnScrollListener : this.liftOnScrollListeners) {
            if (materialShapeDrawable.getFillColor() != null) {
                liftOnScrollListener.onUpdate(0.0f, iLayer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeLiftOnScrollWithElevation$1(MaterialShapeDrawable materialShapeDrawable, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        materialShapeDrawable.setElevation(fFloatValue);
        Drawable drawable = this.statusBarForeground;
        if (drawable instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) drawable).setElevation(fFloatValue);
        }
        Iterator<LiftOnScrollListener> it = this.liftOnScrollListeners.iterator();
        while (it.hasNext()) {
            it.next().onUpdate(fFloatValue, materialShapeDrawable.getResolvedTintColor());
        }
    }

    private boolean setLiftableState(boolean z) {
        if (this.liftable == z) {
            return false;
        }
        this.liftable = z;
        refreshDrawableState();
        return true;
    }

    private boolean shouldDrawStatusBarForeground() {
        return this.statusBarForeground != null && getTopInset() > 0;
    }

    private boolean shouldOffsetFirstChild() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !ViewCompat.getFitsSystemWindows(childAt)) {
                return true;
            }
        }
        return false;
    }

    private void startLiftOnScrollColorAnimation(float f, float f4) {
        ValueAnimator valueAnimator = this.liftOnScrollColorAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f4);
        this.liftOnScrollColorAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.liftOnScrollColorDuration);
        this.liftOnScrollColorAnimator.setInterpolator(this.liftOnScrollColorInterpolator);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.liftOnScrollColorUpdateListener;
        if (animatorUpdateListener != null) {
            this.liftOnScrollColorAnimator.addUpdateListener(animatorUpdateListener);
        }
        this.liftOnScrollColorAnimator.start();
    }

    private void updateInternalHeight() {
        updateInternalHeight(calculateInternalHeight());
    }

    private void updateWillNotDraw() {
        setWillNotDraw(!shouldDrawStatusBarForeground());
    }

    public void addLiftOnScrollListener(@NonNull LiftOnScrollListener liftOnScrollListener) {
        this.liftOnScrollListeners.add(liftOnScrollListener);
    }

    public void addOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        if (this.listeners == null) {
            this.listeners = new ArrayList();
        }
        if (baseOnOffsetChangedListener == null || this.listeners.contains(baseOnOffsetChangedListener)) {
            return;
        }
        this.listeners.add(baseOnOffsetChangedListener);
    }

    public void appBarStateChanged(int i, int i2) {
        List<AppBarStateChangedListener> list = this.mAppBarStateChangedListener;
        if (list != null) {
            Iterator<AppBarStateChangedListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onStateChanged(i, i2);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void clearLiftOnScrollListener() {
        this.liftOnScrollListeners.clear();
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 8) {
            handleAxisScroll(motionEvent.getAxisValue(9), this.liftOnScrollTargetView != null && canScrollVertically(-1));
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (shouldDrawStatusBarForeground()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.currentOffset);
            this.statusBarForeground.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.statusBarForeground;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.behavior = behavior;
        return behavior;
    }

    public boolean getCanImmScroll() {
        return this.mIsCanImmScroll;
    }

    public int getCurrentOrientation() {
        return this.mCurrentOrientation;
    }

    public int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i = this.downPreScrollRange;
        if (i != -1) {
            return i;
        }
        if (useCollapsedHeight()) {
            return (int) (seslGetCollapsedHeight() + (-getHeight()));
        }
        int childCount = getChildCount() - 1;
        int iSeslGetCollapsedHeight = 0;
        while (true) {
            if (childCount < 0) {
                break;
            }
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i2 = layoutParams.scrollFlags;
                if ((i2 & 5) == 5) {
                    int i4 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    if ((i2 & 8) != 0) {
                        minimumHeight = ViewCompat.getMinimumHeight(childAt);
                    } else if ((i2 & 2) != 0) {
                        minimumHeight = measuredHeight - ViewCompat.getMinimumHeight(childAt);
                    } else {
                        iMin = i4 + measuredHeight;
                        if (childCount == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                        iSeslGetCollapsedHeight += iMin;
                    }
                    iMin = minimumHeight + i4;
                    if (childCount == 0) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    iSeslGetCollapsedHeight += iMin;
                } else if (getCanImmScroll()) {
                    iSeslGetCollapsedHeight = (int) (seslGetCollapsedHeight() + seslGetAdditionalScrollRange() + iSeslGetCollapsedHeight);
                }
            }
            childCount--;
        }
        int iMax = Math.max(0, iSeslGetCollapsedHeight);
        this.downPreScrollRange = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i = this.downScrollRange;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int iSeslGetMinimumHeightWithoutMargin = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + childAt.getMeasuredHeight();
                int i4 = layoutParams.scrollFlags;
                if ((i4 & 1) == 0) {
                    break;
                }
                iSeslGetMinimumHeightWithoutMargin += measuredHeight;
                if ((i4 & 2) != 0) {
                    iSeslGetMinimumHeightWithoutMargin -= (this.mIsCanImmScroll && (childAt instanceof CollapsingToolbarLayout)) ? ((CollapsingToolbarLayout) childAt).seslGetMinimumHeightWithoutMargin() : ViewCompat.getMinimumHeight(childAt);
                }
            }
            i2++;
        }
        int iMax = Math.max(0, iSeslGetMinimumHeightWithoutMargin);
        this.downScrollRange = iMax;
        return iMax;
    }

    public final int getImmersiveTopInset() {
        if (this.mIsCanImmScroll) {
            return this.mImmersiveTopInset;
        }
        return 0;
    }

    public boolean getIsMouse() {
        return this.isMouse;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.liftOnScrollTargetViewId;
    }

    @Nullable
    public MaterialShapeDrawable getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            return (MaterialShapeDrawable) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    public int getPendingAction() {
        return this.pendingAction;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.statusBarForeground;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    public final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.totalScrollRange;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int iCalculateInternalHeight = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i4 = layoutParams.scrollFlags;
                if ((i4 & 1) == 0) {
                    break;
                }
                int topInset = measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + iCalculateInternalHeight;
                if (i2 == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                    topInset -= getTopInset();
                }
                iCalculateInternalHeight = topInset;
                if ((i4 & 2) != 0) {
                    if (getCanImmScroll()) {
                        iCalculateInternalHeight += seslGetAdditionalScrollRange() + getTopInset() + this.mBottomPadding;
                    } else {
                        iCalculateInternalHeight = calculateInternalHeight() - ((int) seslGetCollapsedHeight());
                    }
                }
            }
            i2++;
        }
        int iMax = Math.max(0, iCalculateInternalHeight);
        this.totalScrollRange = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public void handleAxisScroll(float f, boolean z) {
        if (isVerticalScrollUp(f)) {
            if (useFloatingToolbar()) {
                seslSetHide();
                return;
            } else {
                setExpanded(false);
                return;
            }
        }
        if (!isVerticalScrollDown(f) || z) {
            return;
        }
        setExpanded(!seslIsHided());
    }

    public boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    public boolean hasScrollableChildren() {
        return getTotalScrollRange() != 0;
    }

    @RequiresApi(api = 30)
    public void internalActivateImmersiveScroll(boolean z, boolean z2) {
        this.mIsActivatedImmersiveScroll = z;
        this.mIsActivatedByUser = z2;
        SeslImmersiveScrollBehavior immBehavior = getImmBehavior();
        if (immBehavior != null) {
            if (!z || immBehavior.isAppBarHide()) {
                immBehavior.restoreTopAndBottom(this.mRestoreAnim);
            }
        }
    }

    public void internalProportion(float f) {
        if (this.mUseCustomHeight || this.mHeightProportion == f) {
            return;
        }
        this.mHeightProportion = f;
        updateInternalHeight();
    }

    public boolean isDetachedState() {
        return this.mIsDetachedState;
    }

    public boolean isImmersiveActivatedByUser() {
        return this.mIsActivatedByUser;
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    public boolean isLifted() {
        return this.lifted;
    }

    public boolean isRequestedForceExpanded() {
        return this.mRequestedForceExpanded;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsDetachedState = false;
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Drawable drawable = this.mBackground;
        if (drawable != null) {
            setBackgroundDrawable(drawable == getBackground() ? this.mBackground : getBackground());
        } else if (getBackground() != null) {
            Drawable background = getBackground();
            this.mBackground = background;
            setBackgroundDrawable(background);
        } else {
            this.mBackground = null;
            setBackgroundColor(this.mResources.getColor(SeslMisc.isLightTheme(getContext()) ? C0419R.color.sesl_action_bar_background_color_light : C0419R.color.sesl_action_bar_background_color_dark));
        }
        if (this.mCurrentScreenHeight != configuration.screenHeightDp || this.mCurrentOrientation != configuration.orientation) {
            boolean z = this.mUseCustomPadding;
            if (!z && !this.mUseCollapsedHeight) {
                Log.i(TAG, "Update bottom padding");
                int dimensionPixelSize = this.mResources.getDimensionPixelSize(C4548R.dimen.sesl_extended_appbar_bottom_padding);
                this.mBottomPadding = dimensionPixelSize;
                setPadding(0, 0, 0, dimensionPixelSize);
                float dimensionPixelSize2 = this.mResources.getDimensionPixelSize(C0419R.dimen.sesl_action_bar_height_with_padding) + this.mBottomPadding;
                this.mCollapsedHeight = dimensionPixelSize2;
                seslSetCollapsedHeight(dimensionPixelSize2, false);
            } else if (z && this.mBottomPadding == 0 && !this.mUseCollapsedHeight) {
                float dimensionPixelSize3 = this.mResources.getDimensionPixelSize(C0419R.dimen.sesl_action_bar_height_with_padding);
                this.mCollapsedHeight = dimensionPixelSize3;
                seslSetCollapsedHeight(dimensionPixelSize3, false);
            }
        }
        if (!this.mSetCustomProportion) {
            this.mHeightProportion = SeslAppBarHelper.INSTANCE.getAppBarProPortion(getContext());
        }
        updateInternalHeight();
        Log.i(TAG, "onConfigurationChanged : mCollapsedHeight = " + this.mCollapsedHeight + ", mHeightProportion = " + this.mHeightProportion + ", mHasSuggestion = " + this.mHasSuggestion + ", mUseCollapsedHeight = " + this.mUseCollapsedHeight);
        if (useFloatingToolbar()) {
            if (seslGetCurrentAppBarState() == 4) {
                seslSetHide(false);
            } else if (this.lifted) {
                setExpanded(false, false, true);
            } else {
                setExpanded(true, false, true);
            }
        } else if (this.lifted || (this.mCurrentOrientation == 1 && configuration.orientation == 2)) {
            setExpanded(false, false, true);
        } else {
            setExpanded(true, false, true);
        }
        int i = this.mCurrentOrientation;
        int i2 = configuration.orientation;
        if (i != i2) {
            this.mOrientationChanged = true;
        }
        this.mCurrentOrientation = i2;
        this.mCurrentScreenHeight = configuration.screenHeightDp;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        if (this.tmpStatesArray == null) {
            this.tmpStatesArray = new int[4];
        }
        int[] iArr = this.tmpStatesArray;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        boolean z = this.liftable;
        int i2 = C4548R.attr.state_liftable;
        if (!z) {
            i2 = -i2;
        }
        iArr[0] = i2;
        iArr[1] = (z && this.lifted) ? C4548R.attr.state_lifted : -C4548R.attr.state_lifted;
        int i4 = C4548R.attr.state_collapsible;
        if (!z) {
            i4 = -i4;
        }
        iArr[2] = i4;
        iArr[3] = (z && this.lifted) ? C4548R.attr.state_collapsed : -C4548R.attr.state_collapsed;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.mIsDetachedState = true;
        SeslImmersiveScrollBehavior immBehavior = getImmBehavior();
        if (immBehavior != null) {
            if (this.mIsReservedImmersiveDetachOption && this.mReservedFitSystemWindow) {
                immBehavior.setupDecorFitsSystemWindow();
            }
            immBehavior.notifyOnDetachedFromWindow();
        }
        super.onDetachedFromWindow();
        clearLiftOnScrollTargetView();
    }

    public void onImmOffsetChanged(int i) {
        if (!willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        List<SeslBaseOnImmOffsetChangedListener> list = this.mImmOffsetListener;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                SeslBaseOnImmOffsetChangedListener seslBaseOnImmOffsetChangedListener = this.mImmOffsetListener.get(i2);
                if (seslBaseOnImmOffsetChangedListener != null) {
                    seslBaseOnImmOffsetChangedListener.onOffsetChanged(this, i);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        super.onLayout(z, i, i2, i4, i5);
        boolean z2 = true;
        if (ViewCompat.getFitsSystemWindows(this) && shouldOffsetFirstChild()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.offsetTopAndBottom(getChildAt(childCount), topInset);
            }
        }
        if (this.mIsFirstLayoutAppBar) {
            invalidateScrollRanges();
            this.mIsFirstLayoutAppBar = false;
        }
        this.haveChildWithInterpolator = false;
        int childCount2 = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount2) {
                break;
            }
            if (((LayoutParams) getChildAt(i6).getLayoutParams()).getScrollInterpolator() != null) {
                this.haveChildWithInterpolator = true;
                break;
            }
            i6++;
        }
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.liftableOverride) {
            return;
        }
        if (!this.liftOnScroll && !hasCollapsibleChild()) {
            z2 = false;
        }
        setLiftableState(z2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        updateInternalHeight();
        if (getLayoutParams().height >= 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getLayoutParams().height, 1073741824));
            if (this.pendingAction == 256 && getHeight() > 0 && getHeight() != getLayoutParams().height) {
                if (getTop() == seslGetCollapsedHeight() + (-getHeight())) {
                    Log.i(TAG, "Height changed and refresh collapsed offset");
                    this.pendingAction = 2 | 8;
                }
            }
        } else {
            super.onMeasure(i, i2);
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && shouldOffsetFirstChild()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = MathUtils.clamp(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i2));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        invalidateScrollRanges();
    }

    public void onOffsetChanged(int i) {
        this.currentOffset = i;
        int totalScrollRange = getTotalScrollRange();
        getHeight();
        seslGetCollapsedHeight();
        int i2 = 4;
        if (getCanImmScroll() && Math.abs(i) >= totalScrollRange && this.mAppbarState.getState() != 4) {
            this.mAppbarState.setState(4);
        }
        int i4 = this.mAppbarState.mCurrentState;
        if (i != (-getHeight())) {
            float f = i;
            i2 = f < seslGetCollapsedHeight() + (-getHeight()) ? 6 : f == seslGetCollapsedHeight() + ((float) (-getHeight())) ? 2 : i < 0 ? 3 : i == 0 ? 1 : 0;
        }
        if (i4 != i2) {
            setLifted((i2 & 1) == 0);
            this.mAppbarState.setState(i2);
            appBarStateChanged(i4, i2);
        }
        if (!willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        List<BaseOnOffsetChangedListener> list = this.listeners;
        if (list != null) {
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                BaseOnOffsetChangedListener baseOnOffsetChangedListener = this.listeners.get(i5);
                if (baseOnOffsetChangedListener != null) {
                    baseOnOffsetChangedListener.onOffsetChanged(this, i);
                }
            }
        }
    }

    public WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.lastInsets, windowInsetsCompat2)) {
            this.lastInsets = windowInsetsCompat2;
            updateWillNotDraw();
            requestLayout();
        }
        return windowInsetsCompat;
    }

    public boolean removeLiftOnScrollListener(@NonNull LiftOnScrollListener liftOnScrollListener) {
        return this.liftOnScrollListeners.remove(liftOnScrollListener);
    }

    public void removeOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        List<BaseOnOffsetChangedListener> list = this.listeners;
        if (list == null || baseOnOffsetChangedListener == null) {
            return;
        }
        list.remove(baseOnOffsetChangedListener);
    }

    @RequiresApi(api = 30)
    @Deprecated
    public void resetAppBarAndInsets() {
        seslResetAppBarAndInsets(true);
    }

    public void resetPendingAction() {
        this.pendingAction = 0;
    }

    public void seslActivateImmersiveScroll(boolean z, boolean z2) {
        if (isDexEnabled()) {
            Log.i(TAG, "Dex Enabled Set false ImmersiveScroll");
            z = false;
        }
        this.mRestoreAnim = z2;
        if (Build.VERSION.SDK_INT >= 30) {
            internalActivateImmersiveScroll(z, true);
            SeslImmersiveScrollBehavior immBehavior = getImmBehavior();
            if ((immBehavior != null ? immBehavior.dispatchImmersiveScrollEnabled() : true) || !z) {
                setCanImmScroll(z);
            }
        }
    }

    public void seslAddAnimateOffsetListener(Animator.AnimatorListener animatorListener) {
        if (this.mAnimateOffsetListener == null) {
            this.mAnimateOffsetListener = new ArrayList();
        }
        this.mAnimateOffsetListener.add(animatorListener);
    }

    public void seslAddAppBarStateChangedListener(AppBarStateChangedListener appBarStateChangedListener) {
        if (this.mAppBarStateChangedListener == null) {
            this.mAppBarStateChangedListener = new ArrayList();
        }
        if (this.mAppBarStateChangedListener.contains(appBarStateChangedListener)) {
            return;
        }
        this.mAppBarStateChangedListener.add(appBarStateChangedListener);
    }

    public void seslAddOnImmOffsetChangedListener(@Nullable SeslBaseOnImmOffsetChangedListener seslBaseOnImmOffsetChangedListener) {
        if (this.mImmOffsetListener == null) {
            this.mImmOffsetListener = new ArrayList();
        }
        if (seslBaseOnImmOffsetChangedListener == null || this.mImmOffsetListener.contains(seslBaseOnImmOffsetChangedListener)) {
            return;
        }
        this.mImmOffsetListener.add(seslBaseOnImmOffsetChangedListener);
    }

    public void seslAllowStartNestedScroll(boolean z) {
        this.mAllowStartNestedScroll = z;
    }

    @Override // androidx.coordinatorlayout.widget.AppBarLayoutBehavior
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean seslCanChangeToHideState() {
        if (this.mAllowStateToHideRequested) {
            return this.mAllowStateToHideAppRequestValue;
        }
        if ((seslGetCurrentAppBarState() & 4) != 0) {
            return true;
        }
        return this.mAllowStateToHideInternal;
    }

    @RequiresApi(api = 30)
    public boolean seslCanImmersiveScroll() {
        SeslImmersiveScrollBehavior immBehavior = getImmBehavior();
        if (immBehavior != null) {
            return immBehavior.getCanImmersiveScrollState();
        }
        return false;
    }

    @RequiresApi(api = 30)
    public void seslCancelWindowInsetsAnimationController() {
        SeslImmersiveScrollBehavior immBehavior = getImmBehavior();
        if (immBehavior != null) {
            Log.i(TAG, "seslCancelWindowInsetsAnimationController");
            immBehavior.cancelWindowInsetsAnimationController();
        }
    }

    public int seslGetAdditionalScrollRange() {
        return this.mAdditionalScrollRange;
    }

    public SeslAppbarState seslGetAppBarState() {
        return this.mAppbarState;
    }

    public float seslGetCollapsedHeight() {
        return this.mCollapsedHeight + getImmersiveTopInset();
    }

    @Override // androidx.coordinatorlayout.widget.AppBarLayoutBehavior
    public int seslGetCurrentAppBarState() {
        return this.mAppbarState.mCurrentState;
    }

    public float seslGetDefaultCollapsedHeight() {
        return this.mResources.getDimensionPixelSize(C0419R.dimen.sesl_action_bar_height_with_padding) + this.mBottomPadding;
    }

    public float seslGetHeightProPortion() {
        return this.mHeightProportion;
    }

    public boolean seslGetImmersiveScroll() {
        return seslIsActivatedImmsersiveScroll();
    }

    public int seslGetProportionExtraHeight() {
        return this.mProportionExtraHeight;
    }

    public final int seslGetTotalFullyScrollRange() {
        return calculateInternalHeight();
    }

    public boolean seslHaveImmersiveBehavior() {
        return getImmBehavior() != null;
    }

    @RequiresApi(api = 30)
    public void seslImmersiveRelease() {
        SeslImmersiveScrollBehavior immBehavior = getImmBehavior();
        if (immBehavior != null) {
            immBehavior.release();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean seslInternalIsNestedFlingUp() {
        if (this.behavior == null) {
            getBehavior();
        }
        return this.behavior.mIsFlingScrollUp;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void seslInternalSetAllowStateToHide(boolean z) {
        this.mAllowStateToHideInternal = z;
        if (!this.mAllowStateToHideRequested && !z && seslIsHided() && this.mOrientationChanged) {
            setExpanded(false, false, true);
        }
        this.mOrientationChanged = false;
    }

    public boolean seslIsActivatedImmsersiveScroll() {
        return this.mIsActivatedImmersiveScroll;
    }

    public boolean seslIsAllowStartNestedScroll() {
        return this.mAllowStartNestedScroll;
    }

    @Deprecated
    public boolean seslIsAllowStateToHide() {
        return this.mAllowStateToHideAppRequestValue;
    }

    @Override // androidx.coordinatorlayout.widget.AppBarLayoutBehavior
    public boolean seslIsCollapsed() {
        return this.lifted || seslGetCollapsedHeight() == ((float) getHeight()) || this.mHeightProportion == 0.0f;
    }

    @Override // androidx.coordinatorlayout.widget.AppBarLayoutBehavior
    public boolean seslIsHided() {
        return useFloatingToolbar() && ((float) getBottom()) < seslGetCollapsedHeight();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Deprecated
    public boolean seslIsLiftHided() {
        return this.mIsLiftHided;
    }

    public void seslRemoveAppBarStateChangedListener(AppBarStateChangedListener appBarStateChangedListener) {
        List<AppBarStateChangedListener> list = this.mAppBarStateChangedListener;
        if (list != null) {
            list.remove(appBarStateChangedListener);
        }
    }

    public void seslRemoveOnImmOffsetChangedListener(@Nullable SeslBaseOnImmOffsetChangedListener seslBaseOnImmOffsetChangedListener) {
        List<SeslBaseOnImmOffsetChangedListener> list = this.mImmOffsetListener;
        if (list == null || seslBaseOnImmOffsetChangedListener == null) {
            return;
        }
        list.remove(seslBaseOnImmOffsetChangedListener);
    }

    @RequiresApi(api = 30)
    public void seslReserveImmersiveDetachOption(int i) {
        if (i == 0) {
            this.mIsReservedImmersiveDetachOption = false;
        } else {
            this.mIsReservedImmersiveDetachOption = true;
            this.mReservedFitSystemWindow = (i & 1) != 0;
        }
    }

    @RequiresApi(api = 30)
    public void seslResetAppBarAndInsets(boolean z) {
        SeslImmersiveScrollBehavior immBehavior = getImmBehavior();
        if (immBehavior != null) {
            Log.i(TAG, "seslResetAppBarAndInsets() force = " + z);
            immBehavior.restoreTopAndBottom(true);
            immBehavior.forceRestoreWindowInset(z);
        }
    }

    @RequiresApi(api = 30)
    @Deprecated
    public void seslRestoreTopAndBottom(View view) {
        seslRestoreTopAndBottom();
    }

    public void seslSetAllowStateToHide(boolean z) {
        this.mAllowStateToHideRequested = !z;
        this.mAllowStateToHideAppRequestValue = z;
    }

    @RequiresApi(api = 30)
    public void seslSetAutoRestoreTopAndBottom(boolean z) {
        SeslImmersiveScrollBehavior immBehavior = getImmBehavior();
        if (immBehavior != null) {
            immBehavior.setAutoRestoreTopAndBottom(z);
        }
    }

    @RequiresApi(api = 30)
    @Deprecated
    public void seslSetBottomView(View view, View view2) {
        seslSetBottomView(view2);
    }

    public void seslSetCollapsedHeight(float f) {
        seslSetCollapsedHeight(f, true);
    }

    public void seslSetCustomHeight(int i) {
        CoordinatorLayout.LayoutParams layoutParams;
        AbstractC2322a.m1631u(i, "seslSetCustomHeight: height = ", TAG);
        this.mCustomHeight = i;
        this.mUseCustomHeight = true;
        this.mSetCustomHeight = true;
        this.mSetCustomProportion = false;
        try {
            layoutParams = (CoordinatorLayout.LayoutParams) getLayoutParams();
        } catch (ClassCastException e) {
            Log.e(TAG, Log.getStackTraceString(e));
            layoutParams = null;
        }
        if (layoutParams != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).height = i;
            setLayoutParams(layoutParams);
        }
    }

    public void seslSetCustomHeightProportion(boolean z, @FloatRange(from = 0.0d, m705to = 1.0d) float f) {
        if (f > 1.0f) {
            Log.e(TAG, "Height proportion float range is 0..1");
            return;
        }
        Log.i(TAG, "seslSetCustomHeightProportion: useCustomHeight = " + z + ", heightProportion = " + f);
        this.mUseCustomHeight = z;
        this.mSetCustomProportion = z;
        this.mSetCustomHeight = false;
        this.mCustomHeightProportion = f;
        updateInternalHeight();
        requestLayout();
    }

    @Override // androidx.coordinatorlayout.widget.AppBarLayoutBehavior
    public void seslSetExpanded(boolean z) {
        setExpanded(z);
    }

    @Override // androidx.coordinatorlayout.widget.AppBarLayoutBehavior
    public void seslSetHide() {
        seslSetHide(ViewCompat.isLaidOut(this));
    }

    public void seslSetImmersiveScroll(boolean z, boolean z2) {
        seslActivateImmersiveScroll(z, z2);
    }

    @Override // androidx.coordinatorlayout.widget.AppBarLayoutBehavior
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void seslSetIsMouse(boolean z) {
        this.isMouse = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Deprecated
    public void seslSetLiftHided(boolean z) {
        this.mIsLiftHided = z;
    }

    @RequiresApi(api = 30)
    public void seslSetNeedToCheckBottomViewMargin(boolean z) {
        SeslImmersiveScrollBehavior immBehavior = getImmBehavior();
        if (immBehavior != null) {
            immBehavior.setNeedToCheckBottomViewMargin(z);
        }
    }

    public void seslSetProportionExtraHeight(int i) {
        if (this.mProportionExtraHeight != i) {
            this.mProportionExtraHeight = i;
            updateInternalHeight();
            if (seslGetCurrentAppBarState() == 2) {
                this.pendingAction = 2;
            }
            requestLayout();
        }
    }

    public void seslSetSuggestion(boolean z) {
        this.mHasSuggestion = z;
    }

    public void seslSetTCScrollRange(int i) {
        this.mAdditionalScrollRange = i;
    }

    public void seslSetWindowInsetsAnimationCallback(@Nullable Object obj) {
        SeslImmersiveScrollBehavior immBehavior;
        if (Build.VERSION.SDK_INT < 30 || (immBehavior = getImmBehavior()) == null) {
            return;
        }
        if (obj == null) {
            immBehavior.setWindowInsetsAnimationCallback(this, null);
        }
        if (AbstractC4113a.m2444B(obj)) {
            immBehavior.setWindowInsetsAnimationCallback(this, AbstractC4113a.m2455i(obj));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void seslStartForceSetExpanded(boolean z) {
        if (this.mRequestedForceExpanded) {
            return;
        }
        Log.i(TAG, "start seslStartForceExpanded");
        this.mRequestedForceExpanded = true;
        setExpanded(z);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void seslStopForceExpanded() {
        if (this.mRequestedForceExpanded) {
            Log.i(TAG, "stop seslStartForceExpanded");
            this.mRequestedForceExpanded = false;
        }
    }

    public void setCanImmScroll(boolean z) {
        if (this.mIsCanImmScroll != z) {
            this.mIsCanImmScroll = z;
            invalidateScrollRanges();
            requestLayout();
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f) {
        super.setElevation(f);
        MaterialShapeUtils.setElevation(this, f);
    }

    public void setExpanded(boolean z) {
        setExpanded(z, ViewCompat.isLaidOut(this));
    }

    public void setImmersiveTopInset(int i) {
        this.mImmersiveTopInset = i;
    }

    public void setLiftOnScroll(boolean z) {
        this.liftOnScroll = z;
    }

    public void setLiftOnScrollTargetView(@Nullable View view) {
        this.liftOnScrollTargetViewId = -1;
        if (view == null) {
            clearLiftOnScrollTargetView();
        } else {
            this.liftOnScrollTargetView = new WeakReference<>(view);
        }
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i) {
        this.liftOnScrollTargetViewId = i;
        clearLiftOnScrollTargetView();
    }

    public boolean setLiftable(boolean z) {
        this.liftableOverride = true;
        return setLiftableState(z);
    }

    public void setLiftableOverrideEnabled(boolean z) {
        this.liftableOverride = z;
    }

    public boolean setLifted(boolean z) {
        return setLiftedState(z, true);
    }

    public boolean setLiftedState(boolean z) {
        return setLiftedState(z, !this.liftableOverride);
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.statusBarForeground;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.statusBarForeground = drawable != null ? drawable.mutate() : null;
            this.statusBarForegroundOriginalColor = extractStatusBarForegroundColor();
            Drawable drawable3 = this.statusBarForeground;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.statusBarForeground.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.statusBarForeground, ViewCompat.getLayoutDirection(this));
                this.statusBarForeground.setVisible(getVisibility() == 0, false);
                this.statusBarForeground.setCallback(this);
            }
            updateWillNotDraw();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(@DrawableRes int i) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f) {
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, f);
    }

    public void setUseFloatingToolbar(boolean z) {
        AbstractC4539a.m3208r("setUseFloatingToolbar ", TAG, z);
        this.mUseFloatingToolbar = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    public boolean shouldLift(@Nullable View view) {
        View viewFindLiftOnScrollTargetView = findLiftOnScrollTargetView(view);
        if (viewFindLiftOnScrollTargetView != null) {
            view = viewFindLiftOnScrollTargetView;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    public void updateInternalCollapsedHeight() {
        if (useCollapsedHeight()) {
            return;
        }
        if (getImmBehavior() == null || !getCanImmScroll()) {
            float fSeslGetCollapsedHeight = seslGetCollapsedHeight();
            float height = getHeight() - getTotalScrollRange();
            if (height == fSeslGetCollapsedHeight || height <= 0.0f) {
                return;
            }
            Log.i(TAG, "Internal collapsedHeight/ oldCollapsedHeight :" + fSeslGetCollapsedHeight + " newCollapsedHeight :" + height);
            seslSetCollapsedHeight(height, false);
            updateInternalHeight();
        }
    }

    public void updateInternalCollapsedHeightOnce() {
        if (useCollapsedHeight()) {
            return;
        }
        if (getImmBehavior() == null || !getCanImmScroll()) {
            float fSeslGetCollapsedHeight = seslGetCollapsedHeight();
            AbstractC4539a.m3205o("update InternalCollapsedHeight from updateInternalHeight() : ", TAG, fSeslGetCollapsedHeight);
            seslSetCollapsedHeight(fSeslGetCollapsedHeight, false);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean useCollapsedHeight() {
        return this.mUseCollapsedHeight;
    }

    @Override // androidx.coordinatorlayout.widget.AppBarLayoutBehavior
    public boolean useFloatingToolbar() {
        return this.mUseFloatingToolbar;
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.statusBarForeground;
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C4548R.attr.appBarLayoutStyle);
    }

    private void seslSetCollapsedHeight(float f, boolean z) {
        this.totalScrollRange = -1;
        this.mUseCollapsedHeight = z;
        this.mCollapsedHeight = f;
    }

    private void updateInternalHeight(int i) {
        if (getHeight() != i && this.pendingAction == 256 && getTop() == getHeight() - seslGetCollapsedHeight()) {
            this.pendingAction = 2 | 8;
            requestLayout();
        }
        boolean z = this.mUseCustomHeight;
        if (!z || (z && (this.mSetCustomProportion || this.mSetCustomHeight))) {
            try {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams).height = i;
                setLayoutParams(layoutParams);
            } catch (ClassCastException e) {
                Log.e(TAG, Log.getStackTraceString(e));
            }
        }
        if (Build.VERSION.SDK_INT < 30 || !this.mIsActivatedImmersiveScroll) {
            return;
        }
        StringBuilder sb = new StringBuilder("[updateInternalHeight] mUseCustomHeight : " + this.mUseCustomHeight + ", mSetCustomProportion : " + this.mSetCustomProportion + ", mSetCustomHeight : " + this.mSetCustomHeight + ", mIsImmersiveScroll : " + this.mIsActivatedImmersiveScroll + ", mIsSetByUser : " + this.mIsActivatedByUser + ", mImmersiveTopInset : " + this.mImmersiveTopInset);
        WindowInsets rootWindowInsets = getRootView().getRootWindowInsets();
        if (rootWindowInsets != null) {
            sb.append("\n");
            sb.append(rootWindowInsets);
        }
        Log.i(TAG, sb.toString());
    }

    @RequiresApi(api = 30)
    public void seslRestoreTopAndBottom() {
        SeslImmersiveScrollBehavior immBehavior = getImmBehavior();
        if (immBehavior != null) {
            immBehavior.restoreTopAndBottom(true);
        }
    }

    @RequiresApi(api = 30)
    public void seslSetBottomView(View view) {
        if (view == null) {
            Log.w(TAG, "bottomView is null");
        }
        SeslImmersiveScrollBehavior immBehavior = getImmBehavior();
        if (immBehavior != null) {
            immBehavior.setBottomView(view);
        }
    }

    public void seslSetHide(boolean z) {
        if (seslCanChangeToHideState()) {
            seslSetHide(z, true);
        }
    }

    public void seslSetImmersiveScroll(boolean z) {
        seslActivateImmersiveScroll(z);
    }

    public void setExpanded(boolean z, boolean z2) {
        setExpanded(z, z2, true);
    }

    public boolean setLiftedState(boolean z, boolean z2) {
        if (!z2 || this.lifted == z) {
            return false;
        }
        this.lifted = z;
        refreshDrawableState();
        if (!isLiftOnScrollCompatibleBackground()) {
            return true;
        }
        if (this.hasLiftOnScrollColor) {
            startLiftOnScrollColorAnimation(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
            return true;
        }
        if (!this.liftOnScroll) {
            return true;
        }
        startLiftOnScrollColorAnimation(z ? 0.0f : this.appBarElevation, z ? this.appBarElevation : 0.0f);
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        int i2;
        int i4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i4), attributeSet, i);
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        this.pendingAction = 0;
        this.lifted = false;
        this.liftOnScrollListeners = new ArrayList();
        this.mIsFirstLayoutAppBar = true;
        this.mCustomHeight = -1;
        this.mAllowStartNestedScroll = true;
        this.mProportionExtraHeight = 0;
        this.mRequestedForceExpanded = false;
        this.mBottomPadding = 0;
        this.mUseCollapsedHeight = false;
        this.isMouse = false;
        this.mIsReservedImmersiveDetachOption = false;
        this.mReservedFitSystemWindow = false;
        this.mIsDetachedState = false;
        this.mHasSuggestion = false;
        this.mUseFloatingToolbar = true;
        this.mAllowStateToHideInternal = true;
        this.mAllowStateToHideAppRequestValue = true;
        this.mAllowStateToHideRequested = false;
        this.mIsActivatedImmersiveScroll = false;
        this.mIsActivatedByUser = false;
        this.mIsCanImmScroll = false;
        this.mRestoreAnim = false;
        this.mAdditionalScrollRange = 0;
        this.mImmersiveTopInset = 0;
        this.mLastTappableInsets = null;
        this.mLastSysInsets = null;
        Context context2 = getContext();
        setOrientation(1);
        ViewUtilsLollipop.setStateListAnimatorFromAttrs(this, attributeSet, i, i4);
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, C4548R.styleable.AppBarLayout, i, i4, new int[0]);
        this.mAppbarState = new SeslAppbarState();
        this.mResources = getResources();
        boolean zIsLightTheme = SeslMisc.isLightTheme(context2);
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.AppBarLayout_android_background)) {
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(C4548R.styleable.AppBarLayout_android_background);
            this.mBackground = drawable;
            ViewCompat.setBackground(this, drawable);
        } else {
            this.mBackground = null;
            Resources resources = this.mResources;
            if (zIsLightTheme) {
                i2 = C0419R.color.sesl_action_bar_background_color_light;
            } else {
                i2 = C0419R.color.sesl_action_bar_background_color_dark;
            }
            setBackgroundColor(resources.getColor(i2));
        }
        ColorStateList colorStateList = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, C4548R.styleable.AppBarLayout_liftOnScrollColor);
        this.hasLiftOnScrollColor = colorStateList != null;
        ColorStateList colorStateListOrNull = DrawableUtils.getColorStateListOrNull(getBackground());
        if (colorStateListOrNull != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.setFillColor(colorStateListOrNull);
            if (colorStateList != null) {
                initializeLiftOnScrollWithColor(materialShapeDrawable, colorStateListOrNull, colorStateList);
            } else {
                initializeLiftOnScrollWithElevation(context2, materialShapeDrawable);
            }
        }
        this.liftOnScrollColorDuration = MotionUtils.resolveThemeDuration(context2, C4548R.attr.motionDurationMedium2, getResources().getInteger(C4548R.integer.app_bar_elevation_anim_duration));
        this.liftOnScrollColorInterpolator = MotionUtils.resolveThemeInterpolator(context2, C4548R.attr.motionEasingStandardInterpolator, com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR);
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.AppBarLayout_expanded)) {
            setExpanded(typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.AppBarLayout_expanded, false), false, false);
        }
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.AppBarLayout_seslHide) && typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.AppBarLayout_seslHide, false)) {
            seslSetHide(false, true);
        }
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.AppBarLayout_elevation)) {
            ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.AppBarLayout_elevation, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.AppBarLayout_seslUseCustomHeight)) {
            this.mUseCustomHeight = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.AppBarLayout_seslUseCustomHeight, false);
        }
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.AppBarLayout_seslHeightProportion)) {
            this.mSetCustomProportion = true;
            this.mCustomHeightProportion = typedArrayObtainStyledAttributes.getFloat(C4548R.styleable.AppBarLayout_seslHeightProportion, DEFAULT_HEIGHT_RATIO_TO_SCREEN);
        } else {
            this.mSetCustomProportion = false;
            this.mCustomHeightProportion = DEFAULT_HEIGHT_RATIO_TO_SCREEN;
        }
        this.mHeightProportion = SeslAppBarHelper.INSTANCE.getAppBarProPortion(getContext());
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.AppBarLayout_seslUseCustomPadding)) {
            this.mUseCustomPadding = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.AppBarLayout_seslUseCustomPadding, false);
        }
        if (this.mUseCustomPadding) {
            this.mBottomPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.AppBarLayout_android_paddingBottom, 0);
        } else {
            this.mBottomPadding = this.mResources.getDimensionPixelOffset(C4548R.dimen.sesl_extended_appbar_bottom_padding);
        }
        setPadding(0, 0, 0, this.mBottomPadding);
        float dimensionPixelSize = this.mResources.getDimensionPixelSize(C0419R.dimen.sesl_action_bar_height_with_padding) + this.mBottomPadding;
        this.mCollapsedHeight = dimensionPixelSize;
        seslSetCollapsedHeight(dimensionPixelSize, false);
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.AppBarLayout_elevation)) {
            ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.AppBarLayout_elevation, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.AppBarLayout_android_keyboardNavigationCluster)) {
            setKeyboardNavigationCluster(typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
            setTouchscreenBlocksFocus(typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
        }
        this.appBarElevation = getResources().getDimension(C4548R.dimen.design_appbar_elevation);
        this.liftOnScroll = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.AppBarLayout_liftOnScroll, false);
        this.liftOnScrollTargetViewId = typedArrayObtainStyledAttributes.getResourceId(C4548R.styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        this.mUseFloatingToolbar = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.AppBarLayout_seslUseFloatingToolbar, true);
        setStatusBarForeground(typedArrayObtainStyledAttributes.getDrawable(C4548R.styleable.AppBarLayout_statusBarForeground));
        typedArrayObtainStyledAttributes.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.appbar.AppBarLayout.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Insets insets = windowInsetsCompat.getInsets(AppBarLayout.SYSTEM_BARS);
                Insets insets2 = windowInsetsCompat.getInsets(AppBarLayout.TAPPABLE_ELEMENT);
                if (!insets2.equals(AppBarLayout.this.mLastTappableInsets) || !insets.equals(AppBarLayout.this.mLastSysInsets)) {
                    Log.d(AppBarLayout.TAG, "[onApplyWindowInsets] sysInsets : " + insets + ", tappableInsets : " + insets2);
                    if (AppBarLayout.this.getImmBehavior() != null) {
                        AppBarLayout.this.getImmBehavior().notifyOnApplyWindowInsets();
                    }
                    AppBarLayout.this.mLastSysInsets = insets;
                    AppBarLayout.this.mLastTappableInsets = insets2;
                }
                return AppBarLayout.this.onWindowInsetChanged(windowInsetsCompat);
            }
        });
        this.mCurrentOrientation = this.mResources.getConfiguration().orientation;
        this.mCurrentScreenHeight = this.mResources.getConfiguration().screenHeightDp;
        String str = TAG;
        StringBuilder sb = new StringBuilder("Init : mUseCustomHeight = ");
        sb.append(this.mUseCustomHeight);
        sb.append(", mCustomHeightProportion = ");
        sb.append(this.mCustomHeightProportion);
        sb.append(", mHeightProportion = ");
        sb.append(this.mHeightProportion);
        sb.append(", mUseCustomPadding = ");
        sb.append(this.mUseCustomPadding);
        sb.append(", mCurrentScreenHeight = ");
        AbstractC0000a.m26w(sb, str, this.mCurrentScreenHeight);
    }

    private void setExpanded(boolean z, boolean z2, boolean z3) {
        setLifted(!z);
        seslSetLiftHided(false);
        if (z) {
            this.pendingAction = 1;
        } else if (seslGetImmersiveScroll()) {
            this.pendingAction = 512;
        } else {
            this.pendingAction = 2;
        }
        this.pendingAction |= (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        removeOnOffsetChangedListener((BaseOnOffsetChangedListener) onOffsetChangedListener);
    }

    public void seslRemoveOnImmOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        seslRemoveOnImmOffsetChangedListener((SeslBaseOnImmOffsetChangedListener) onOffsetChangedListener);
    }

    public void seslSetAllowStateToHide(boolean z, boolean z2) {
        this.mAllowStateToHideRequested = z2;
        this.mAllowStateToHideAppRequestValue = z;
    }

    @RequiresApi(api = 30)
    public void seslRestoreTopAndBottom(boolean z) {
        SeslImmersiveScrollBehavior immBehavior = getImmBehavior();
        if (immBehavior != null) {
            immBehavior.restoreTopAndBottom(z);
        }
    }

    public void seslSetHide(boolean z, boolean z2) {
        if (seslCanChangeToHideState() || z2) {
            setLifted(true);
            seslSetLiftHided(true);
            this.pendingAction = (z ? 4 : 0) | 256 | (z2 ? 8 : 0);
            requestLayout();
        }
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        addOnOffsetChangedListener((BaseOnOffsetChangedListener) onOffsetChangedListener);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void seslAddOnImmOffsetChangedListener(SeslOnImmOffsetChangedListener seslOnImmOffsetChangedListener) {
        seslAddOnImmOffsetChangedListener((SeslBaseOnImmOffsetChangedListener) seslOnImmOffsetChangedListener);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public void seslActivateImmersiveScroll(boolean z) {
        seslActivateImmersiveScroll(z, true);
    }
}
