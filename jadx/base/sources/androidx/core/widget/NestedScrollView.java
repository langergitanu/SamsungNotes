package androidx.core.widget;

import android.R;
import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.C2337R;
import androidx.core.os.BuildCompat;
import androidx.core.util.SeslFadingEdgeHelper;
import androidx.core.util.SeslFadingEdgeHelperImpl;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DifferentialMotionFlingController;
import androidx.core.view.DifferentialMotionFlingTarget;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollFeedbackProviderCompat;
import androidx.core.view.ScrollingView;
import androidx.core.view.SeslPointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.SeslGoToTopConfig;
import androidx.core.widget.SeslGoToTopController;
import androidx.core.widget.SeslGoToTopControllerFactory;
import androidx.core.widget.SeslScrollable;
import androidx.glance.AbstractC2821a;
import androidx.reflect.provider.SeslSettingsReflector;
import androidx.reflect.view.SeslPointerIconReflector;
import androidx.reflect.view.SeslViewReflector;
import com.samsung.android.sesl.visualeffect.utils.DeviceSettingsUtil;
import com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import p004A2.RunnableC0015b;
import p017D1.C0061b;
import p035H2.RunnableC0116a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(api = 23)
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, ScrollingView, SeslScrollable {
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final int DEFAULT_SMOOTH_SCROLL_DURATION = 250;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final int GoToTopScrollingDuration = 700;
    private static final int HOVERSCROLL_DELAY = 7;
    private static final int HOVERSCROLL_DOWN = 2;
    private static final int HOVERSCROLL_HEIGHT_BOTTOM_DP = 25;
    private static final int HOVERSCROLL_HEIGHT_TOP_DP = 25;
    private static final float HOVERSCROLL_SPEED = 10.0f;
    private static final int HOVERSCROLL_UP = 1;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final int MIN_PIXEL_PER_SECOND = 1;
    private static final int MOTION_EVENT_ACTION_PEN_DOWN = 211;
    private static final int MOTION_EVENT_ACTION_PEN_MOVE = 213;
    private static final int MOTION_EVENT_ACTION_PEN_UP = 212;
    private static final int MSG_HOVERSCROLL_MOVE = 1;
    private static final String NAVIGATION_MODE = "navigation_mode";
    private static final int NAV_BAR_MODE_3BUTTON = 0;
    private static final int NAV_BAR_MODE_GESTURAL = 2;
    private static final int ON_ABSORB_VELOCITY = 10000;
    private static final float SCROLL_FRICTION = 0.015f;
    private static final String TAG = "NestedScrollView";
    public final Interpolator SINE_IN_OUT_70;
    private int mActivePointerId;

    @Nullable
    private Rect mAvailableBounds;
    private final Runnable mCheckGoToTopAndAutoScrollCondition;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;
    private Context mContext;
    private boolean mDebugDrawAvailRect;

    @VisibleForTesting
    DifferentialMotionFlingController mDifferentialMotionFlingController;

    @VisibleForTesting
    final DifferentialMotionFlingTargetImpl mDifferentialMotionFlingTarget;
    private boolean mDrawHorizontalPadding;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public EdgeEffect mEdgeGlowBottom;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public EdgeEffect mEdgeGlowTop;
    private final SeslFadingEdgeHelper mFadingEdgeHelper;
    private boolean mFillViewport;
    private SeslGoToTopConfig mGoToTopConfig;
    private SeslNestedGoToTopController mGoToTopController;
    private final SeslGoToTopController.Host mGoToTopHost;
    private boolean mHasNestedScrollRange;
    private boolean mHoverAreaEnter;
    private int mHoverBottomAreaHeight;
    private int mHoverDefaultBottomAreaHeight;
    private int mHoverDefaultTopAreaHeight;
    private HoverScrollHandler mHoverHandler;
    private long mHoverRecognitionCurrentTime;
    private long mHoverRecognitionDurationTime;
    private long mHoverRecognitionStartTime;
    private int mHoverScrollDirection;
    private boolean mHoverScrollEnabled;
    private int mHoverScrollSpeed;
    private long mHoverScrollStartTime;
    private boolean mHoverScrollStateChanged;
    private long mHoverScrollTimeInterval;
    private int mHoverTopAreaHeight;
    private int mInitialTopOffsetOfScreen;
    private boolean mIsBeingDragged;
    private boolean mIsBottomHoverScrollWithAppBarEnabled;
    private boolean mIsHoverOverscrolled;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private boolean mIsSupportHoverScroll;
    private int mLastMotionY;
    private long mLastScroll;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNaviBarTop;
    private boolean mNeedsHoverScroll;
    private int mNestedScrollRange;
    private int mNestedYOffset;
    private SeslOnGoToTopClickListener mOnGoToTopClickListener;
    private List<SeslScrollable.SeslOnGoToTopClickListener> mOnGoToTopClickListeners;
    View.OnLayoutChangeListener mOnLayoutChangeListener;
    private OnScrollChangeListener mOnScrollChangeListener;
    private List<OnScrollChangeListener> mOnScrollChangeListeners;
    private final NestedScrollingParentHelper mParentHelper;
    private final float mPhysicalCoeff;
    private final Paint mRectPaint;
    private int mRemainNestedScrollRange;
    private SavedState mSavedState;
    private int mScrollBarBottomOffset;
    private int mScrollBarTopOffset;
    private final int[] mScrollConsumed;

    @VisibleForTesting
    ScrollFeedbackProviderCompat mScrollFeedbackProvider;
    private final SeslFadingEdgeHelper.ScrollInfoProvider mScrollInfoProvider;
    private final int[] mScrollOffset;
    private int mScrollbarBottomPadding;
    private int mScrollbarTopPadding;
    private OverScroller mScroller;
    private int mSeslBottomBarHeight;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;
    private final int[] mWindowOffsets;
    private static final float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
    private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
    private static final int[] SCROLLVIEW_STYLEABLE = {R.attr.fillViewport};
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();

    /* JADX INFO: renamed from: androidx.core.widget.NestedScrollView$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C24791 implements SeslGoToTopController.Host {
        public C24791() {
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public boolean canScrollDown() {
            return NestedScrollView.this.canScrollDown();
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public boolean canScrollUp() {
            return NestedScrollView.this.canScrollUp();
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public Context getContext() {
            return NestedScrollView.this.mContext;
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public int getHeight() {
            return NestedScrollView.this.getHeight();
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public void getLocationInWindow(int[] iArr) {
            NestedScrollView.this.getLocationInWindow(iArr);
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public ViewGroupOverlay getOverlay() {
            return NestedScrollView.this.getOverlay();
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public int getPaddingBottom() {
            return NestedScrollView.this.getPaddingBottom();
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public int getPaddingLeft() {
            return NestedScrollView.this.getPaddingLeft();
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public int getPaddingRight() {
            return NestedScrollView.this.getPaddingRight();
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public int getScrollY() {
            return NestedScrollView.this.getScrollY();
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public int getWidth() {
            return NestedScrollView.this.getWidth();
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public void invalidateHost() {
            NestedScrollView.this.invalidate();
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public boolean isFastScrollerEnabled() {
            return false;
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public void playSoundEffect(int i) {
            NestedScrollView.this.playSoundEffect(i);
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public void post(Runnable runnable) {
            NestedScrollView.this.post(runnable);
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public void postDelayed(Runnable runnable, long j) {
            NestedScrollView.this.postDelayed(runnable, j);
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public void removeCallbacks(Runnable runnable) {
            NestedScrollView.this.removeCallbacks(runnable);
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public void showTopEdgeEffect() {
            NestedScrollView.this.mEdgeGlowTop.onAbsorb(10000);
            NestedScrollView.this.invalidate();
        }

        @Override // androidx.core.widget.SeslGoToTopController.Host
        public void smoothScrollToTop() {
            post(new Runnable() { // from class: androidx.core.widget.NestedScrollView.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (NestedScrollView.this.mGoToTopController != null) {
                        NestedScrollView.this.mGoToTopController.setScrollRunning(true);
                        if (Settings.System.getInt(C24791.this.getContext().getContentResolver(), DeviceSettingsUtil.REDUCE_ANIMATION, 0) == 1) {
                            NestedScrollView.this.scrollTo(0, 0);
                            return;
                        }
                        int scrollToTopDurationMs = NestedScrollView.this.mGoToTopController.getScrollToTopDurationMs();
                        if (NestedScrollView.this.mAvailableBounds != null) {
                            NestedScrollView.this.smoothScrollTo(0, 0, scrollToTopDurationMs, true);
                        } else {
                            NestedScrollView.this.smoothScrollTo(0, 0, scrollToTopDurationMs);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            accessibilityNodeInfoCompat.setScrollable(true);
            if (nestedScrollView.getScrollY() > 0) {
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i != 4096) {
                if (i == 8192 || i == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.scrollTo(0, iMax);
                    return true;
                }
                if (i != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.scrollTo(0, iMin);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(21)
    @SuppressLint({"ObsoleteSdkInt"})
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean getClipToPadding(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(35)
    public static final class Api35Impl {
        private Api35Impl() {
        }

        public static void setFrameContentVelocity(View view, float f) {
            try {
                view.setFrameContentVelocity(f);
            } catch (LinkageError unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DifferentialMotionFlingTargetImpl implements DifferentialMotionFlingTarget {
        public DifferentialMotionFlingTargetImpl() {
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public float getScaledScrollFactor() {
            return -NestedScrollView.this.getVerticalScrollFactorCompat();
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public boolean startDifferentialMotionFling(float f) {
            if (f == 0.0f) {
                return false;
            }
            stopDifferentialMotionFling();
            NestedScrollView.this.fling((int) f);
            return true;
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public void stopDifferentialMotionFling() {
            NestedScrollView.this.mScroller.abortAnimation();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HoverScrollHandler extends Handler {
        private final WeakReference<NestedScrollView> mScrollView;

        public HoverScrollHandler(NestedScrollView nestedScrollView) {
            this.mScrollView = new WeakReference<>(nestedScrollView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            NestedScrollView nestedScrollView = this.mScrollView.get();
            if (nestedScrollView != null) {
                nestedScrollView.handleMessage(message);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnScrollChangeListener {
        void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i4, int i5);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.core.widget.NestedScrollView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int scrollPosition;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("HorizontalScrollView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" scrollPosition=");
            return AbstractC2821a.m2223n(sb, "}", this.scrollPosition);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.scrollPosition);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.scrollPosition = parcel.readInt();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SeslOnGoToTopClickListener {
        boolean onGoToTopClick(NestedScrollView nestedScrollView);
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        stopNestedScroll(1);
    }

    private void adjustNestedScrollRange() {
        getLocationInWindow(this.mWindowOffsets);
        int i = this.mNestedScrollRange;
        int i2 = this.mInitialTopOffsetOfScreen;
        int i4 = this.mWindowOffsets[1];
        int i5 = i - (i2 - i4);
        this.mRemainNestedScrollRange = i5;
        if (i2 - i4 < 0) {
            this.mNestedScrollRange = i5;
            this.mInitialTopOffsetOfScreen = i4;
        }
    }

    private void adjustNestedScrollRangeBy(int i) {
        if (this.mHasNestedScrollRange) {
            if (canScrollUp() && this.mRemainNestedScrollRange == 0) {
                return;
            }
            int i2 = this.mRemainNestedScrollRange - i;
            this.mRemainNestedScrollRange = i2;
            if (i2 < 0) {
                this.mRemainNestedScrollRange = 0;
                return;
            }
            int i4 = this.mNestedScrollRange;
            if (i2 > i4) {
                this.mRemainNestedScrollRange = i4;
            }
        }
    }

    private void applyFadingEdge(boolean z, Runnable runnable) {
        if (z) {
            this.mFadingEdgeHelper.setTargetView(this);
        }
        if (runnable != null) {
            runnable.run();
        }
        invalidate();
    }

    private Rect calculateFadingEdgeBounds() {
        Rect rect = new Rect(getScrollX(), getScrollY(), (getRight() + getScrollX()) - getLeft(), (getBottom() + getScrollY()) - getTop());
        if (getClipToPadding()) {
            rect.left = getPaddingLeft() + rect.left;
            rect.right -= getPaddingRight();
            rect.top = getPaddingTop() + rect.top;
            rect.bottom -= getPaddingBottom();
        }
        if (isPaddingOffsetRequired()) {
            rect.top += getTopPaddingOffset();
            rect.bottom += getBottomPaddingOffset();
        }
        return rect;
    }

    private boolean canHoverScroll() {
        return this.mIsSupportHoverScroll && this.mHoverScrollEnabled;
    }

    private boolean canOverScroll() {
        int overScrollMode = getOverScrollMode();
        return overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0);
    }

    private boolean canScroll() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScrollDown() {
        return canScrollVertically(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScrollUp() {
        return canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkChildScrollableForGoToTopAndAutoScroll() {
        int i = Build.VERSION.SDK_INT;
        if (i < 33) {
            AbstractC2322a.m1631u(i, "GTT HSC not support : under Platform Version : ", TAG);
            return false;
        }
        if (!this.mIsBottomHoverScrollWithAppBarEnabled && getChildCount() > 0 && (getChildAt(0) instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) getChildAt(0);
            if (viewGroup.getHeight() < getHeight()) {
                Log.i(TAG, "GTT HSC not support : Small Height child");
                return false;
            }
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() != 8 && (childAt.canScrollVertically(1) || childAt.canScrollVertically(-1))) {
                    Log.i(TAG, "GTT HSC not support : Some child view can scroll index: " + i2 + " " + childAt);
                    return false;
                }
            }
        }
        return true;
    }

    private static int clamp(int i, int i2, int i4) {
        if (i2 >= i4 || i < 0) {
            return 0;
        }
        return i2 + i > i4 ? i4 - i2 : i;
    }

    private void doScrollY(int i) {
        if (i != 0) {
            if (this.mSmoothScrollingEnabled) {
                smoothScrollBy(0, i);
            } else {
                scrollBy(0, i);
            }
        }
    }

    private boolean edgeEffectFling(int i) {
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0.0f) {
            if (shouldAbsorb(this.mEdgeGlowTop, i)) {
                this.mEdgeGlowTop.onAbsorb(i);
                return true;
            }
            fling(-i);
            return true;
        }
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) {
            return false;
        }
        int i2 = -i;
        if (shouldAbsorb(this.mEdgeGlowBottom, i2)) {
            this.mEdgeGlowBottom.onAbsorb(i2);
            return true;
        }
        fling(i2);
        return true;
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        stopNestedScroll(0);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    }

    private void ensureGoToTopController() {
        if (this.mGoToTopController == null) {
            this.mGoToTopController = (SeslNestedGoToTopController) SeslGoToTopControllerFactory.createController(SeslGoToTopControllerFactory.ControllerType.NESTEDSCROLLVIEW, updateGoToTopConfig(), this.mGoToTopHost, TAG);
        }
    }

    private int findAndGetColor(String str, int i) {
        try {
            return this.mContext.getColor(this.mContext.getResources().getIdentifier(str, "color", this.mContext.getPackageName()));
        } catch (Resources.NotFoundException unused) {
            return i;
        }
    }

    private int findAndGetDimension(String str, int i) {
        try {
            return this.mContext.getResources().getDimensionPixelSize(this.mContext.getResources().getIdentifier(str, AbsExecuteBinding.TYPE_DIMEN, this.mContext.getPackageName()));
        } catch (Resources.NotFoundException unused) {
            return i;
        }
    }

    private Drawable findAndGetDrawable(String str) {
        try {
            return this.mContext.getResources().getDrawable(this.mContext.getResources().getIdentifier(str, "drawable", this.mContext.getPackageName()));
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private View findFocusableViewInBounds(boolean z, int i, int i2) {
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z2 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = focusables.get(i4);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                boolean z3 = i < top && bottom < i2;
                if (view == null) {
                    view = view2;
                    z2 = z3;
                } else {
                    boolean z4 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    if (z2) {
                        if (z3 && z4) {
                            view = view2;
                        }
                    } else if (z3) {
                        view = view2;
                        z2 = true;
                    } else if (z4) {
                    }
                }
            }
        }
        return view;
    }

    private boolean findSuperClass(ViewParent viewParent, String str) {
        for (Class<?> superclass = viewParent.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (superclass.getSimpleName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private ScrollFeedbackProviderCompat getScrollFeedbackProvider() {
        if (this.mScrollFeedbackProvider == null) {
            this.mScrollFeedbackProvider = ScrollFeedbackProviderCompat.createProvider(this);
        }
        return this.mScrollFeedbackProvider;
    }

    private float getSplineFlingDistance(int i) {
        double dLog = Math.log((Math.abs(i) * 0.35f) / (this.mPhysicalCoeff * SCROLL_FRICTION));
        float f = DECELERATION_RATE;
        return (float) (Math.exp((((double) f) / (((double) f) - 1.0d)) * dLog) * ((double) (this.mPhysicalCoeff * SCROLL_FRICTION)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMessage(Message message) {
        if (message.what == 1) {
            int scrollRange = getScrollRange();
            if (this.mIsBottomHoverScrollWithAppBarEnabled) {
                scrollRange += this.mRemainNestedScrollRange;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.mHoverRecognitionCurrentTime = jCurrentTimeMillis;
            this.mHoverRecognitionDurationTime = (jCurrentTimeMillis - this.mHoverRecognitionStartTime) / 1000;
            if (jCurrentTimeMillis - this.mHoverScrollStartTime >= this.mHoverScrollTimeInterval) {
                int iApplyDimension = (int) (TypedValue.applyDimension(1, 10.0f, this.mContext.getResources().getDisplayMetrics()) + 0.5f);
                this.mHoverScrollSpeed = iApplyDimension;
                long j = this.mHoverRecognitionDurationTime;
                if (j > 2 && j < 4) {
                    this.mHoverScrollSpeed = iApplyDimension + ((int) (((double) iApplyDimension) * 0.1d));
                } else if (j >= 4 && j < 5) {
                    this.mHoverScrollSpeed = iApplyDimension + ((int) (((double) iApplyDimension) * 0.2d));
                } else if (j >= 5) {
                    this.mHoverScrollSpeed = iApplyDimension + ((int) (((double) iApplyDimension) * 0.3d));
                }
                int i = this.mHoverScrollDirection == 2 ? this.mHoverScrollSpeed * (-1) : this.mHoverScrollSpeed;
                ViewCompat.getLayoutDirection(this);
                boolean z = false;
                if ((i < 0 && getScrollY() > 0) || (i > 0 && getScrollY() < scrollRange)) {
                    startNestedScroll(2, 1);
                    if (dispatchNestedPreScroll(0, i, null, null, 1)) {
                        adjustNestedScrollRangeBy(i);
                    } else {
                        smoothScrollBy(0, i);
                    }
                    this.mHoverHandler.sendEmptyMessageDelayed(1, 7L);
                    return;
                }
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    z = true;
                }
                if (z && !this.mIsHoverOverscrolled) {
                    int i2 = this.mHoverScrollDirection;
                    if (i2 == 2) {
                        this.mEdgeGlowTop.setSize((getWidth() - getPaddingLeft()) - getPaddingRight(), getHeight());
                        this.mEdgeGlowTop.onAbsorb(10000);
                        if (!this.mEdgeGlowBottom.isFinished()) {
                            this.mEdgeGlowBottom.onRelease();
                        }
                    } else if (i2 == 1) {
                        this.mEdgeGlowBottom.setSize((getWidth() - getPaddingLeft()) - getPaddingRight(), getHeight());
                        this.mEdgeGlowBottom.onAbsorb(10000);
                        SeslNestedGoToTopController seslNestedGoToTopController = this.mGoToTopController;
                        if (seslNestedGoToTopController != null) {
                            seslNestedGoToTopController.showIfNeeded();
                        }
                        if (!this.mEdgeGlowTop.isFinished()) {
                            this.mEdgeGlowTop.onRelease();
                        }
                    }
                    if (!this.mEdgeGlowTop.isFinished() || !this.mEdgeGlowBottom.isFinished()) {
                        invalidate();
                    }
                    this.mIsHoverOverscrolled = true;
                }
                if (z || this.mIsHoverOverscrolled) {
                    return;
                }
                this.mIsHoverOverscrolled = true;
            }
        }
    }

    private boolean inChild(int i, int i2) {
        if (getChildCount() > 0) {
            int scrollY = getScrollY();
            View childAt = getChildAt(0);
            if (i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight()) {
                return true;
            }
        }
        return false;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        post(this.mCheckGoToTopAndAutoScrollCondition);
        addOnLayoutChangeListener(this.mOnLayoutChangeListener);
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private boolean isFloatingGoToTopScrollRequest(int i) {
        return i == (-getScrollY()) && this.mAvailableBounds != null;
    }

    private boolean isLightTheme(Context context) {
        TypedValue typedValue = new TypedValue();
        return (context.getTheme().resolveAttribute(R.attr.isLightTheme, typedValue, true) && typedValue.data == 0) ? false : true;
    }

    private boolean isLockScreenMode() {
        return ((KeyguardManager) this.mContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    private boolean isOffScreen(View view) {
        return !isWithinDeltaOfScreen(view, 0, getHeight());
    }

    private static boolean isViewDescendantOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && isViewDescendantOf((View) parent, view2);
    }

    private boolean isWithinDeltaOfScreen(View view, int i, int i2) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        return this.mTempRect.bottom + i >= getScrollY() && this.mTempRect.top - i <= getScrollY() + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$seslSetFadingEdgeEnabled$0(boolean z, int i, int i2) {
        this.mFadingEdgeHelper.setFadingEdgeEnabled(z, i, i2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$seslSetFadingEdgeEnabled$1(boolean z) {
        this.mFadingEdgeHelper.setFadingEdgeEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$seslSetFadingEdgeEnabled$2(boolean z, boolean z2) {
        this.mFadingEdgeHelper.setFadingEdgeEnabled(z, false, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$seslSetFadingEdgeEnabled$3(boolean z, boolean z2, boolean z3) {
        this.mFadingEdgeHelper.setFadingEdgeEnabled(z, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$seslSetGoToTopEnabled$4() {
        List<SeslScrollable.SeslOnGoToTopClickListener> list = this.mOnGoToTopClickListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnGoToTopClickListeners.get(size).onGoToTopClick(this);
            }
        }
        SeslOnGoToTopClickListener seslOnGoToTopClickListener = this.mOnGoToTopClickListener;
        if (seslOnGoToTopClickListener != null) {
            return seslOnGoToTopClickListener.onGoToTopClick(this);
        }
        return false;
    }

    private void onNestedScrollInternal(int i, int i2, int[] iArr) {
        SeslNestedGoToTopController seslNestedGoToTopController = this.mGoToTopController;
        if (seslNestedGoToTopController == null || !seslNestedGoToTopController.isScrollRunning() || this.mScroller.isFinished()) {
            int scrollY = getScrollY();
            scrollBy(0, i);
            this.mLastScrollerY = getScrollY();
            if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            int scrollY2 = getScrollY() - scrollY;
            if (iArr != null) {
                iArr[1] = iArr[1] + scrollY2;
            }
            this.mChildHelper.dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, null, i2, iArr);
        }
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mLastMotionY = (int) motionEvent.getY(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int releaseVerticalGlow(int i, float f) {
        float fOnPullDistance;
        int iRound;
        float width = f / getWidth();
        float height = i / getHeight();
        float f4 = 0.0f;
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == 0.0f) {
            if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != 0.0f) {
                fOnPullDistance = EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, height, 1.0f - width);
                if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) {
                    this.mEdgeGlowBottom.onRelease();
                }
            }
            iRound = Math.round(f4 * getHeight());
            if (iRound != 0) {
                invalidate();
            }
            return iRound;
        }
        fOnPullDistance = -EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, -height, width);
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == 0.0f) {
            this.mEdgeGlowTop.onRelease();
        }
        f4 = fOnPullDistance;
        iRound = Math.round(f4 * getHeight());
        if (iRound != 0) {
        }
        return iRound;
    }

    private void runAnimatedScroll(boolean z) {
        if (z) {
            startNestedScroll(2, 1);
        } else {
            stopNestedScroll(1);
        }
        this.mLastScrollerY = getScrollY();
        postInvalidateOnAnimation();
    }

    private boolean scrollAndFocus(int i, int i2, int i4) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = height + scrollY;
        boolean z = false;
        boolean z2 = i == 33;
        View viewFindFocusableViewInBounds = findFocusableViewInBounds(z2, i2, i4);
        if (viewFindFocusableViewInBounds == null) {
            viewFindFocusableViewInBounds = this;
        }
        if (i2 < scrollY || i4 > i5) {
            doScrollY(z2 ? i2 - scrollY : i4 - i5);
            z = true;
        }
        if (viewFindFocusableViewInBounds != findFocus()) {
            viewFindFocusableViewInBounds.requestFocus(i);
        }
        return z;
    }

    private void scrollToChild(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (iComputeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private boolean scrollToChildRect(Rect rect, boolean z) {
        int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z2 = iComputeScrollDeltaToGetChildRectOnScreen != 0;
        if (z2) {
            if (z) {
                scrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
                return z2;
            }
            smoothScrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
        }
        return z2;
    }

    private boolean seslDispatchNestedScroll(int i, int i2, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        return this.mChildHelper.seslDispatchNestedScroll(i, i2, i4, i5, iArr, i6, iArr2);
    }

    private void seslRenderFadingEffect(Canvas canvas) {
        this.mFadingEdgeHelper.renderFadingEffect(canvas, this.mScrollInfoProvider);
    }

    private boolean shouldAbsorb(EdgeEffect edgeEffect, int i) {
        if (i > 0) {
            return true;
        }
        return getSplineFlingDistance(-i) < EdgeEffectCompat.getDistance(edgeEffect) * ((float) getHeight());
    }

    private void showPointerIcon(MotionEvent motionEvent, int i) {
        motionEvent.getDevice();
        SeslViewReflector.semSetPointerIcon(this, motionEvent.getToolType(0), SeslPointerIconCompat.isSemStylusDefault(i) ? null : PointerIcon.getSystemIcon(this.mContext, i));
    }

    private boolean stopGlowAnimations(MotionEvent motionEvent) {
        boolean z;
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0.0f) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, 0.0f, motionEvent.getX() / getWidth());
            z = true;
        } else {
            z = false;
        }
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) {
            return z;
        }
        EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    private SeslGoToTopConfig updateGoToTopConfig() {
        int iFindAndGetDimension = findAndGetDimension("sesl_go_to_top_scrollable_view_gap", 0);
        int iFindAndGetDimension2 = findAndGetDimension("sesl_go_to_top_scrollable_view_size", -1);
        int iFindAndGetDimension3 = findAndGetDimension("sesl_go_to_top_elevation", -1);
        Drawable drawableFindAndGetDrawable = findAndGetDrawable("sesl_list_go_to_top_light");
        Drawable drawableFindAndGetDrawable2 = findAndGetDrawable("sesl_list_go_to_top_dark");
        Drawable drawableFindAndGetDrawable3 = findAndGetDrawable("sesl_go_to_top_background_light");
        Drawable drawableFindAndGetDrawable4 = findAndGetDrawable("sesl_go_to_top_background_dark");
        return new SeslGoToTopConfig.Builder().setIconLight(drawableFindAndGetDrawable).setIconDark(drawableFindAndGetDrawable2).setBackgroundLight(drawableFindAndGetDrawable3).setBackgroundDark(drawableFindAndGetDrawable4).setBackgroundBlur(findAndGetDrawable("sesl_go_to_top_background_blur")).setBackgroundColorBlur(findAndGetColor("sesl_figma_floating_component_blur_background_dark", -1)).setPaddingBottom(iFindAndGetDimension).setPaddingLeft(0).setPaddingRight(0).setSize(iFindAndGetDimension2).setElevation(iFindAndGetDimension3).setOverlayFeatureHiddenHeightPx(0).setScrollToTopDurationMs(700).setFadeInInterpolator(this.SINE_IN_OUT_70).setFadeOutInterpolator(LINEAR_INTERPOLATOR).build();
    }

    private void updateScrollbarVerticalPadding() {
        SeslViewReflector.semSetScrollBarTopPadding(this, this.mScrollbarTopPadding + this.mScrollBarTopOffset);
        SeslViewReflector.semSetScrollBarBottomPadding(this, this.mScrollbarBottomPadding + this.mScrollBarBottomOffset);
    }

    public void addOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        if (this.mOnScrollChangeListeners == null) {
            this.mOnScrollChangeListeners = new ArrayList();
        }
        this.mOnScrollChangeListeners.add(onScrollChangeListener);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public boolean arrowScroll(int i) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !isWithinDeltaOfScreen(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            doScrollY(maxScrollAmount);
        } else {
            viewFindNextFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.mTempRect);
            int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
            this.mLastScrollerY = getScrollY();
            doScrollY(iComputeScrollDeltaToGetChildRectOnScreen);
            viewFindNextFocus.requestFocus(i);
        }
        if (viewFindFocus == null || !viewFindFocus.isFocused() || !isOffScreen(viewFindFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        int i;
        if (this.mScroller.isFinished()) {
            return;
        }
        this.mScroller.computeScrollOffset();
        int currY = this.mScroller.getCurrY();
        int iConsumeFlingInVerticalStretch = consumeFlingInVerticalStretch(currY - this.mLastScrollerY);
        this.mLastScrollerY = currY;
        int[] iArr = this.mScrollConsumed;
        iArr[1] = 0;
        dispatchNestedPreScroll(0, iConsumeFlingInVerticalStretch, iArr, null, 1);
        int i2 = iConsumeFlingInVerticalStretch - this.mScrollConsumed[1];
        int scrollRange = getScrollRange();
        if (Build.VERSION.SDK_INT >= 35) {
            Api35Impl.setFrameContentVelocity(this, Math.abs(this.mScroller.getCurrVelocity()));
        }
        if (i2 != 0) {
            int scrollY = getScrollY();
            overScrollByCompat(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            i = scrollRange;
            int scrollY2 = getScrollY() - scrollY;
            int i4 = i2 - scrollY2;
            int[] iArr2 = this.mScrollConsumed;
            iArr2[1] = 0;
            if (seslDispatchNestedScroll(0, scrollY2, 0, i4, this.mScrollOffset, 1, iArr2)) {
                int[] iArr3 = this.mScrollOffset;
                iArr3[0] = 0;
                iArr3[1] = 0;
            }
            int[] iArr4 = this.mScrollOffset;
            if (iArr4[0] < 0 || iArr4[1] < 0) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
            i2 = i4 - this.mScrollConsumed[1];
        } else {
            i = scrollRange;
        }
        if (i2 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && i > 0)) {
                if (i2 < 0) {
                    if (this.mEdgeGlowTop.isFinished()) {
                        this.mEdgeGlowTop.onAbsorb((int) this.mScroller.getCurrVelocity());
                    }
                } else if (this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onAbsorb((int) this.mScroller.getCurrVelocity());
                }
            }
            abortAnimatedScroll();
        }
        if (this.mScroller.isFinished()) {
            stopNestedScroll(1);
        } else {
            postInvalidateOnAnimation();
        }
        SeslViewReflector.setFrameContentVelocity(this, Math.abs(this.mScroller.getCurrVelocity()));
    }

    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = (scrollY + height) - this.mHoverBottomAreaHeight;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i2 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i - verticalFadingEdgeLength : i;
        int i4 = rect.bottom;
        if (i4 > i2 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i2, (childAt.getBottom() + layoutParams.bottomMargin) - i);
        }
        if (rect.top >= scrollY || i4 >= i2) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i2 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? (scrollY - iMax) + bottom : bottom;
    }

    public int consumeFlingInVerticalStretch(int i) {
        int height = getHeight();
        if (i > 0 && EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0.0f) {
            int iRound = Math.round(EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, ((-i) * 4.0f) / height, 0.5f) * ((-height) / 4.0f));
            if (iRound != i) {
                this.mEdgeGlowTop.finish();
            }
            return i - iRound;
        }
        if (i >= 0 || EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) {
            return i;
        }
        float f = height;
        int iRound2 = Math.round(EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, (i * 4.0f) / f, 0.5f) * (f / 4.0f));
        if (iRound2 != i) {
            this.mEdgeGlowBottom.finish();
        }
        return i - iRound2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0032  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchDraw(Canvas canvas) {
        Canvas canvas2;
        super.dispatchDraw(canvas);
        if (this.mDebugDrawAvailRect) {
            Paint paint = new Paint();
            paint.setColor(VUtilString.GREEN);
            paint.setAlpha(128);
            paint.setStyle(Paint.Style.FILL);
            if (this.mAvailableBounds != null) {
                canvas.drawRect(r0.left, r0.top, r0.right, r0.bottom, paint);
                canvas2 = canvas;
            } else {
                canvas2 = canvas;
            }
        }
        if (this.mDrawHorizontalPadding) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int height = getHeight();
            int width = getWidth();
            int scrollY = getScrollY();
            if (paddingLeft > 0) {
                canvas2.drawRect(0.0f, scrollY, paddingLeft, height + scrollY, this.mRectPaint);
            }
            if (paddingRight > 0) {
                canvas2.drawRect(width - paddingRight, scrollY, width, height + scrollY, this.mRectPaint);
            }
        }
        if (this.mFadingEdgeHelper.isFadingEdgeEnabled()) {
            seslRenderFadingEffect(canvas2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        SeslNestedGoToTopController seslNestedGoToTopController;
        int action = motionEvent.getAction();
        if (action == 9 || this.mHoverScrollStateChanged) {
            if (this.mHasNestedScrollRange) {
                adjustNestedScrollRange();
            }
            int toolType = motionEvent.getToolType(0);
            this.mNeedsHoverScroll = true;
            this.mHoverScrollStateChanged = false;
            if (!canHoverScroll()) {
                this.mNeedsHoverScroll = false;
            }
            if (this.mNeedsHoverScroll && toolType == 2) {
                if (Settings.System.getInt(this.mContext.getContentResolver(), SeslSettingsReflector.SeslSystemReflector.getField_SEM_PEN_HOVERING(), 0) != 1) {
                    this.mNeedsHoverScroll = false;
                }
            }
            if (this.mNeedsHoverScroll && toolType == 3) {
                this.mNeedsHoverScroll = false;
            }
        }
        if (!this.mNeedsHoverScroll) {
            return super.dispatchHoverEvent(motionEvent);
        }
        int x = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        int childCount = getChildCount();
        int scrollRange = getScrollRange();
        if (this.mIsBottomHoverScrollWithAppBarEnabled) {
            scrollRange += this.mRemainNestedScrollRange;
        }
        if (this.mHoverHandler == null) {
            this.mHoverHandler = new HoverScrollHandler(this);
        }
        if (this.mHoverDefaultTopAreaHeight <= 0 || this.mHoverDefaultBottomAreaHeight <= 0) {
            this.mHoverDefaultTopAreaHeight = (int) (TypedValue.applyDimension(1, 25.0f, this.mContext.getResources().getDisplayMetrics()) + 0.5f);
            this.mHoverDefaultBottomAreaHeight = (int) (TypedValue.applyDimension(1, 25.0f, this.mContext.getResources().getDisplayMetrics()) + 0.5f);
        }
        int height = childCount != 0 ? getHeight() : 0;
        boolean z = motionEvent.getToolType(0) == 2;
        if ((y2 > this.mHoverTopAreaHeight + this.mHoverDefaultTopAreaHeight && y2 < ((height - this.mHoverBottomAreaHeight) - this.mHoverDefaultBottomAreaHeight) - this.mRemainNestedScrollRange) || x <= 0 || x > getRight() || scrollRange == 0 || ((y2 >= 0 && y2 <= this.mHoverTopAreaHeight + this.mHoverDefaultTopAreaHeight && getScrollY() <= 0 && this.mIsHoverOverscrolled) || ((y2 >= height - this.mHoverBottomAreaHeight && y2 <= height && getScrollY() >= scrollRange && this.mIsHoverOverscrolled) || ((z && motionEvent.getButtonState() == 32) || !z || isLockScreenMode() || ((seslNestedGoToTopController = this.mGoToTopController) != null && seslNestedGoToTopController.isAvailable() && this.mGoToTopController.getState() != 0 && this.mGoToTopController.contains(x, y2)))))) {
            if (this.mHoverHandler.hasMessages(1)) {
                this.mHoverHandler.removeMessages(1);
                showPointerIcon(motionEvent, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_DEFAULT());
            }
            if ((y2 > this.mHoverTopAreaHeight + this.mHoverDefaultTopAreaHeight && y2 < (height - this.mHoverBottomAreaHeight) - this.mHoverDefaultBottomAreaHeight) || x <= 0 || x > getRight()) {
                this.mIsHoverOverscrolled = false;
            }
            if (this.mHoverAreaEnter || this.mHoverScrollStartTime != 0) {
                showPointerIcon(motionEvent, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_DEFAULT());
            }
            this.mHoverRecognitionStartTime = 0L;
            this.mHoverScrollStartTime = 0L;
            this.mHoverAreaEnter = false;
            return super.dispatchHoverEvent(motionEvent);
        }
        if (!this.mHoverAreaEnter) {
            this.mHoverScrollStartTime = System.currentTimeMillis();
        }
        if (action != 7) {
            if (action == 9) {
                this.mHoverAreaEnter = true;
                if (y2 < 0 || y2 > this.mHoverTopAreaHeight + this.mHoverDefaultTopAreaHeight) {
                    if (y2 >= ((height - this.mHoverBottomAreaHeight) - this.mHoverDefaultBottomAreaHeight) - this.mRemainNestedScrollRange && y2 <= height && !this.mHoverHandler.hasMessages(1)) {
                        this.mHoverRecognitionStartTime = System.currentTimeMillis();
                        showPointerIcon(motionEvent, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_SCROLL_DOWN());
                        this.mHoverScrollDirection = 1;
                        this.mHoverHandler.sendEmptyMessage(1);
                    }
                } else if (!this.mHoverHandler.hasMessages(1)) {
                    this.mHoverRecognitionStartTime = System.currentTimeMillis();
                    showPointerIcon(motionEvent, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_SCROLL_UP());
                    this.mHoverScrollDirection = 2;
                    this.mHoverHandler.sendEmptyMessage(1);
                }
            } else if (action == 10) {
                if (this.mHoverHandler.hasMessages(1)) {
                    this.mHoverHandler.removeMessages(1);
                }
                showPointerIcon(motionEvent, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_DEFAULT());
                this.mHoverRecognitionStartTime = 0L;
                this.mHoverScrollStartTime = 0L;
                this.mIsHoverOverscrolled = false;
                this.mHoverAreaEnter = false;
                this.mScroller.forceFinished(true);
                return super.dispatchHoverEvent(motionEvent);
            }
        } else {
            if (!this.mHoverAreaEnter) {
                this.mHoverAreaEnter = true;
                motionEvent.setAction(10);
                return super.dispatchHoverEvent(motionEvent);
            }
            if (y2 < 0 || y2 > this.mHoverTopAreaHeight + this.mHoverDefaultTopAreaHeight) {
                if (y2 >= ((height - this.mHoverBottomAreaHeight) - this.mHoverDefaultBottomAreaHeight) - this.mRemainNestedScrollRange && y2 <= height && !this.mHoverHandler.hasMessages(1)) {
                    this.mHoverRecognitionStartTime = System.currentTimeMillis();
                    if (!this.mIsHoverOverscrolled || this.mHoverScrollDirection == 2) {
                        showPointerIcon(motionEvent, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_SCROLL_DOWN());
                    }
                    this.mHoverScrollDirection = 1;
                    this.mHoverHandler.sendEmptyMessage(1);
                }
            } else if (!this.mHoverHandler.hasMessages(1)) {
                this.mHoverRecognitionStartTime = System.currentTimeMillis();
                if (!this.mIsHoverOverscrolled || this.mHoverScrollDirection == 1) {
                    showPointerIcon(motionEvent, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_SCROLL_UP());
                }
                this.mHoverScrollDirection = 2;
                this.mHoverHandler.sendEmptyMessage(1);
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f4, boolean z) {
        return this.mChildHelper.dispatchNestedFling(f, f4, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f4) {
        SeslViewReflector.setFrameContentVelocity(this, 1.0f);
        return this.mChildHelper.dispatchNestedPreFling(f, f4);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i4) {
        SeslNestedGoToTopController seslNestedGoToTopController = this.mGoToTopController;
        if (seslNestedGoToTopController != null) {
            seslNestedGoToTopController.invalidate();
        }
        return this.mChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2, i4);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int i, int i2, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        this.mChildHelper.dispatchNestedScroll(i, i2, i4, i5, iArr, i6, iArr2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        int childCount = getChildCount();
        int scrollRange = getScrollRange();
        if (this.mHoverHandler == null) {
            this.mHoverHandler = new HoverScrollHandler(this);
        }
        if (this.mHoverDefaultTopAreaHeight <= 0 || this.mHoverDefaultBottomAreaHeight <= 0) {
            this.mHoverDefaultTopAreaHeight = (int) (TypedValue.applyDimension(1, 25.0f, this.mContext.getResources().getDisplayMetrics()) + 0.5f);
            this.mHoverDefaultBottomAreaHeight = (int) (TypedValue.applyDimension(1, 25.0f, this.mContext.getResources().getDisplayMetrics()) + 0.5f);
        }
        int height = childCount != 0 ? getHeight() : 0;
        boolean z = motionEvent.getToolType(0) == 2;
        int action = motionEvent.getAction();
        SeslNestedGoToTopController seslNestedGoToTopController = this.mGoToTopController;
        if (seslNestedGoToTopController != null && seslNestedGoToTopController.onTouchEvent(motionEvent)) {
            return true;
        }
        if ((y2 > this.mHoverTopAreaHeight + this.mHoverDefaultTopAreaHeight && y2 < (height - this.mHoverBottomAreaHeight) - this.mHoverDefaultBottomAreaHeight) || scrollRange == 0 || !z || motionEvent.getButtonState() != 32) {
            if (this.mHoverHandler.hasMessages(1)) {
                this.mHoverHandler.removeMessages(1);
            }
            this.mHoverRecognitionStartTime = 0L;
            this.mHoverScrollStartTime = 0L;
            this.mHoverAreaEnter = false;
            this.mIsHoverOverscrolled = false;
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.mHoverAreaEnter) {
            this.mHoverScrollStartTime = System.currentTimeMillis();
        }
        SeslNestedGoToTopController seslNestedGoToTopController2 = this.mGoToTopController;
        if (seslNestedGoToTopController2 != null && seslNestedGoToTopController2.onTouchPenEvent(motionEvent)) {
            return true;
        }
        if (action != 212) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.mHoverHandler.hasMessages(1)) {
            this.mHoverHandler.removeMessages(1);
        }
        this.mHoverRecognitionStartTime = 0L;
        this.mHoverScrollStartTime = 0L;
        this.mIsHoverOverscrolled = false;
        this.mHoverAreaEnter = false;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    @SuppressLint({"ObsoleteSdkInt"})
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        int paddingLeft2 = 0;
        if (!this.mEdgeGlowTop.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (Api21Impl.getClipToPadding(this)) {
                width -= getPaddingRight() + getPaddingLeft();
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = 0;
            }
            if (Api21Impl.getClipToPadding(this)) {
                height -= getPaddingBottom() + getPaddingTop();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            this.mEdgeGlowTop.setSize(width, height);
            if (this.mEdgeGlowTop.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave);
        }
        if (!this.mEdgeGlowBottom.isFinished()) {
            int iSave2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int iMax = Math.max(getScrollRange(), scrollY) + height2;
            if (Api21Impl.getClipToPadding(this)) {
                width2 -= getPaddingRight() + getPaddingLeft();
                paddingLeft2 = getPaddingLeft();
            }
            if (Api21Impl.getClipToPadding(this)) {
                height2 -= getPaddingBottom() + getPaddingTop();
                iMax -= getPaddingBottom();
            }
            canvas.translate(paddingLeft2 - width2, iMax);
            canvas.rotate(180.0f, width2, 0.0f);
            this.mEdgeGlowBottom.setSize(width2, height2);
            if (this.mEdgeGlowBottom.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave2);
        }
        SeslNestedGoToTopController seslNestedGoToTopController = this.mGoToTopController;
        if (seslNestedGoToTopController != null) {
            seslNestedGoToTopController.draw();
        }
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        this.mTempRect.setEmpty();
        if (canScroll()) {
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 19) {
                    return !keyEvent.isAltPressed() ? arrowScroll(33) : fullScroll(33);
                }
                if (keyCode == 20) {
                    return !keyEvent.isAltPressed() ? arrowScroll(130) : fullScroll(130);
                }
                if (keyCode == 62) {
                    pageScroll(keyEvent.isShiftPressed() ? 33 : 130);
                    return false;
                }
            }
            return false;
        }
        if (isFocused() && keyEvent.getKeyCode() != 4) {
            View viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            if (viewFindNextFocus != null && viewFindNextFocus != this && viewFindNextFocus.requestFocus(130)) {
                return true;
            }
        }
        return false;
    }

    public void fling(int i) {
        if (getChildCount() > 0) {
            this.mScroller.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            SeslViewReflector.setFrameContentVelocity(this, Math.abs(this.mScroller.getCurrVelocity()));
            runAnimatedScroll(true);
            if (BuildCompat.isAtLeastV()) {
                Api35Impl.setFrameContentVelocity(this, Math.abs(this.mScroller.getCurrVelocity()));
            }
        }
    }

    public boolean fullScroll(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.mTempRect;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.mTempRect.bottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            Rect rect2 = this.mTempRect;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.mTempRect;
        return scrollAndFocus(i, rect3.top, rect3.bottom);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @VisibleForTesting
    public float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.mVerticalScrollFactor;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i) {
        return this.mChildHelper.hasNestedScrollingParent(i);
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    @Override // android.view.ViewGroup
    public void measureChild(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i, int i2, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SeslNestedGoToTopController seslNestedGoToTopController = this.mGoToTopController;
        if (seslNestedGoToTopController != null) {
            seslNestedGoToTopController.release();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mFadingEdgeHelper.isFadingEdgeEnabled()) {
            Rect rectCalculateFadingEdgeBounds = calculateFadingEdgeBounds();
            this.mFadingEdgeHelper.prepareFadingEffect(canvas, rectCalculateFadingEdgeBounds.left, rectCalculateFadingEdgeBounds.top, rectCalculateFadingEdgeBounds.right, rectCalculateFadingEdgeBounds.bottom);
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue;
        int i;
        int i2;
        boolean z;
        boolean z2 = false;
        if (motionEvent.getAction() == 8 && !this.mIsBeingDragged) {
            if (MotionEventCompat.isFromSource(motionEvent, 2)) {
                i = 9;
                axisValue = motionEvent.getAxisValue(9);
            } else if (MotionEventCompat.isFromSource(motionEvent, 4194304)) {
                i = 26;
                axisValue = motionEvent.getAxisValue(26);
            } else {
                axisValue = 0.0f;
                i = 0;
            }
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (getVerticalScrollFactorCompat() * axisValue);
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i4 = scrollY - verticalScrollFactorCompat;
                if (i4 < 0) {
                    if (!canOverScroll() || MotionEventCompat.isFromSource(motionEvent, 8194)) {
                        z = false;
                    } else {
                        EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, (-i4) / getHeight(), 0.5f);
                        this.mEdgeGlowTop.onRelease();
                        invalidate();
                        z = true;
                    }
                    i2 = 0;
                    z2 = z;
                } else if (i4 > scrollRange) {
                    if (canOverScroll() && !MotionEventCompat.isFromSource(motionEvent, 8194)) {
                        EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, (i4 - scrollRange) / getHeight(), 0.5f);
                        this.mEdgeGlowBottom.onRelease();
                        invalidate();
                        z2 = true;
                    }
                    i2 = scrollRange;
                } else {
                    i2 = i4;
                }
                if (i != 0) {
                    this.mDifferentialMotionFlingController.onMotionEvent(motionEvent, i);
                }
                if (i2 == scrollY) {
                    return z2;
                }
                super.scrollTo(getScrollX(), i2);
                startNestedScroll(i2, 1);
                SeslNestedGoToTopController seslNestedGoToTopController = this.mGoToTopController;
                if (seslNestedGoToTopController != null) {
                    seslNestedGoToTopController.showIfNeeded();
                }
                if (!dispatchNestedPreScroll(0, i2, null, null, 1)) {
                    super.scrollTo(getScrollX(), i2);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = true;
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        int i = action & 255;
        if (i == 0) {
            int y2 = (int) motionEvent.getY();
            if (inChild((int) motionEvent.getX(), y2)) {
                this.mLastMotionY = y2;
                this.mActivePointerId = motionEvent.getPointerId(0);
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                this.mScroller.computeScrollOffset();
                SeslViewReflector.setFrameContentVelocity(this, Math.abs(this.mScroller.getCurrVelocity()));
                if (!stopGlowAnimations(motionEvent) && this.mScroller.isFinished()) {
                    z = false;
                }
                this.mIsBeingDragged = z;
                startNestedScroll(2, 0);
            } else {
                if (!stopGlowAnimations(motionEvent) && this.mScroller.isFinished()) {
                    z = false;
                }
                this.mIsBeingDragged = z;
                recycleVelocityTracker();
            }
        } else if (i == 1) {
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            recycleVelocityTracker();
            if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            stopNestedScroll(0);
        } else if (i == 2) {
            int i2 = this.mActivePointerId;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                if (iFindPointerIndex == -1) {
                    AbstractC2322a.m1632v(i2, "Invalid pointerId=", " in onInterceptTouchEvent", TAG);
                } else {
                    int y3 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y3 - this.mLastMotionY) > this.mTouchSlop && (2 & getNestedScrollAxes()) == 0) {
                        this.mIsBeingDragged = true;
                        this.mLastMotionY = y3;
                        initVelocityTrackerIfNotExists();
                        this.mVelocityTracker.addMovement(motionEvent);
                        this.mNestedYOffset = 0;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
        } else if (i != 3) {
            if (i == 6) {
                onSecondaryPointerUp(motionEvent);
            }
        }
        return this.mIsBeingDragged;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        int measuredHeight;
        SeslNestedGoToTopController seslNestedGoToTopController;
        super.onLayout(z, i, i2, i4, i5);
        this.mIsLayoutDirty = false;
        View view = this.mChildToScrollTo;
        if (view != null && isViewDescendantOf(view, this)) {
            scrollToChild(this.mChildToScrollTo);
        }
        this.mChildToScrollTo = null;
        if (z && (seslNestedGoToTopController = this.mGoToTopController) != null) {
            seslNestedGoToTopController.setSizeChanged(true);
            this.mGoToTopController.setOverlayFeatureHiddenHeightPx(getResources().getDimensionPixelOffset(C2337R.dimen.sesl_nestedscrollview_overlay_feature_hidden_height));
            this.mGoToTopController.onSizeChanged();
        }
        if (!this.mIsLaidOut) {
            if (this.mSavedState != null) {
                scrollTo(getScrollX(), this.mSavedState.scrollPosition);
                this.mSavedState = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                measuredHeight = 0;
            }
            int paddingTop = ((i5 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iClamp = clamp(scrollY, paddingTop, measuredHeight);
            if (iClamp != scrollY) {
                scrollTo(getScrollX(), iClamp);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.mIsLaidOut = true;
        if (!z || computeHorizontalScrollRange() > computeHorizontalScrollExtent()) {
            return;
        }
        this.mHasNestedScrollRange = false;
        ViewParent parent = getParent();
        while (true) {
            if (parent == null || !(parent instanceof ViewGroup)) {
                break;
            }
            if ((parent instanceof NestedScrollingParent2) && findSuperClass(parent, "CoordinatorLayout")) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.getLocationInWindow(this.mWindowOffsets);
                int height = viewGroup.getHeight() + this.mWindowOffsets[1];
                getLocationInWindow(this.mWindowOffsets);
                this.mInitialTopOffsetOfScreen = this.mWindowOffsets[1];
                int height2 = getHeight() - (height - this.mInitialTopOffsetOfScreen);
                this.mRemainNestedScrollRange = height2;
                if (height2 < 0) {
                    this.mRemainNestedScrollRange = 0;
                }
                this.mNestedScrollRange = this.mRemainNestedScrollRange;
                this.mHasNestedScrollRange = true;
            } else {
                parent = parent.getParent();
            }
        }
        if (this.mHasNestedScrollRange) {
            return;
        }
        this.mInitialTopOffsetOfScreen = 0;
        this.mRemainNestedScrollRange = 0;
        this.mNestedScrollRange = 0;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mFillViewport && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f4, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f4, true);
        fling((int) f4);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f4) {
        return dispatchNestedPreFling(f, f4);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i4) {
        dispatchNestedPreScroll(i, i2, iArr, null, i4);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i, int i2, int i4, int i5, int i6, int[] iArr) {
        onNestedScrollInternal(i5, i6, iArr);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i, i2);
        startNestedScroll(2, i2);
    }

    @Override // android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        SeslNestedGoToTopController seslNestedGoToTopController = this.mGoToTopController;
        if (seslNestedGoToTopController != null) {
            seslNestedGoToTopController.showIfNeeded();
        }
        super.scrollTo(i, i2);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (viewFindNextFocus == null || isOffScreen(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSavedState = savedState;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i4, int i5) {
        SeslNestedGoToTopController seslNestedGoToTopController;
        super.onScrollChanged(i, i2, i4, i5);
        if (canOverScroll() && i2 != i5 && (seslNestedGoToTopController = this.mGoToTopController) != null) {
            seslNestedGoToTopController.showIfNeeded();
        }
        SeslNestedGoToTopController seslNestedGoToTopController2 = this.mGoToTopController;
        if (seslNestedGoToTopController2 != null) {
            seslNestedGoToTopController2.draw();
        }
        OnScrollChangeListener onScrollChangeListener = this.mOnScrollChangeListener;
        NestedScrollView nestedScrollView = this;
        int i6 = i;
        int i7 = i2;
        int i8 = i4;
        int i9 = i5;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChange(nestedScrollView, i6, i7, i8, i9);
        }
        List<OnScrollChangeListener> list = nestedScrollView.mOnScrollChangeListeners;
        if (list != null) {
            int size = list.size() - 1;
            while (size >= 0) {
                int i10 = i9;
                int i11 = i8;
                int i12 = i7;
                int i13 = i6;
                nestedScrollView.mOnScrollChangeListeners.get(size).onScrollChange(nestedScrollView, i13, i12, i11, i10);
                i6 = i13;
                i7 = i12;
                i8 = i11;
                i9 = i10;
                size--;
                nestedScrollView = this;
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i4, int i5) {
        super.onSizeChanged(i, i2, i4, i5);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !isWithinDeltaOfScreen(viewFindFocus, 0, i5)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(viewFindFocus, this.mTempRect);
        doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        this.mParentHelper.onStopNestedScroll(view, i);
        stopNestedScroll(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x01c5  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        VelocityTracker velocityTracker;
        initVelocityTrackerIfNotExists();
        int actionMasked = motionEvent.getActionMasked();
        boolean z = false;
        if (actionMasked == 0) {
            this.mNestedYOffset = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.mNestedYOffset);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker2 = this.mVelocityTracker;
                velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int yVelocity = (int) velocityTracker2.getYVelocity(this.mActivePointerId);
                if (Math.abs(yVelocity) >= this.mMinimumVelocity) {
                    if (!edgeEffectFling(yVelocity)) {
                        int i = -yVelocity;
                        float f = i;
                        if (!dispatchNestedPreFling(0.0f, f)) {
                            dispatchNestedFling(0.0f, f, true);
                            fling(i);
                        }
                    }
                } else if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                this.mActivePointerId = -1;
                endDrag();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (iFindPointerIndex == -1) {
                    Log.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
                } else {
                    int y2 = (int) motionEvent.getY(iFindPointerIndex);
                    int i2 = this.mLastMotionY - y2;
                    int iReleaseVerticalGlow = i2 - releaseVerticalGlow(i2, motionEvent.getX(iFindPointerIndex));
                    if (!this.mIsBeingDragged && Math.abs(iReleaseVerticalGlow) > this.mTouchSlop) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.mIsBeingDragged = true;
                        iReleaseVerticalGlow = iReleaseVerticalGlow > 0 ? iReleaseVerticalGlow - this.mTouchSlop : iReleaseVerticalGlow + this.mTouchSlop;
                    }
                    int i4 = iReleaseVerticalGlow;
                    if (this.mIsBeingDragged) {
                        if (dispatchNestedPreScroll(0, i4, this.mScrollConsumed, this.mScrollOffset, 0)) {
                            i4 -= this.mScrollConsumed[1];
                            this.mNestedYOffset += this.mScrollOffset[1];
                        }
                        this.mLastMotionY = y2 - this.mScrollOffset[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z2 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        int i5 = i4;
                        boolean z3 = overScrollByCompat(0, i4, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent(0);
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.mScrollConsumed;
                        iArr[1] = 0;
                        dispatchNestedScroll(0, scrollY2, 0, i5 - scrollY2, this.mScrollOffset, 0, iArr);
                        int i6 = this.mLastMotionY;
                        int i7 = this.mScrollOffset[1];
                        this.mLastMotionY = i6 - i7;
                        this.mNestedYOffset += i7;
                        if (z2) {
                            int i8 = i5 - this.mScrollConsumed[1];
                            int i9 = scrollY + i8;
                            if (i9 < 0) {
                                EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, (-i8) / getHeight(), motionEvent.getX(iFindPointerIndex) / getWidth());
                                if (!this.mEdgeGlowBottom.isFinished()) {
                                    this.mEdgeGlowBottom.onRelease();
                                }
                            } else if (i9 > scrollRange) {
                                EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, i8 / getHeight(), 1.0f - (motionEvent.getX(iFindPointerIndex) / getWidth()));
                                SeslNestedGoToTopController seslNestedGoToTopController = this.mGoToTopController;
                                if (seslNestedGoToTopController != null) {
                                    seslNestedGoToTopController.showIfNeeded();
                                }
                                if (!this.mEdgeGlowTop.isFinished()) {
                                    this.mEdgeGlowTop.onRelease();
                                }
                            }
                            if (!this.mEdgeGlowTop.isFinished() || !this.mEdgeGlowBottom.isFinished()) {
                                postInvalidateOnAnimation();
                            }
                            if (z) {
                                velocityTracker.clear();
                            }
                        } else {
                            z = z3;
                            if (z && (velocityTracker = this.mVelocityTracker) != null) {
                                velocityTracker.clear();
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.mIsBeingDragged && getChildCount() > 0 && this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                this.mActivePointerId = -1;
                endDrag();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.mLastMotionY = (int) motionEvent.getY(actionIndex);
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                onSecondaryPointerUp(motionEvent);
                this.mLastMotionY = (int) motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
            }
        } else {
            if (getChildCount() == 0) {
                motionEventObtain.recycle();
                return false;
            }
            if (this.mIsBeingDragged && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.mScroller.isFinished()) {
                abortAnimatedScroll();
            }
            this.mLastMotionY = (int) motionEvent.getY();
            this.mActivePointerId = motionEvent.getPointerId(0);
            startNestedScroll(2, 0);
        }
        VelocityTracker velocityTracker3 = this.mVelocityTracker;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public boolean overScrollByCompat(int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        boolean z2;
        boolean z3;
        int i10;
        int overScrollMode = getOverScrollMode();
        boolean z4 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z5 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z6 = overScrollMode == 0 || (overScrollMode == 1 && z4);
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        int i11 = i4 + i;
        int i12 = !z6 ? 0 : i8;
        int i13 = i5 + i2;
        int i14 = !z7 ? 0 : i9;
        int i15 = -i12;
        int i16 = i12 + i6;
        int i17 = -i14;
        int i18 = i14 + i7;
        if (i11 > i16) {
            i11 = i16;
            z2 = true;
        } else if (i11 < i15) {
            z2 = true;
            i11 = i15;
        } else {
            z2 = false;
        }
        if (i13 > i18) {
            i13 = i18;
            z3 = true;
        } else if (i13 < i17) {
            z3 = true;
            i13 = i17;
        } else {
            z3 = false;
        }
        if (!z3 || hasNestedScrollingParent(1)) {
            i10 = i11;
        } else {
            int i19 = i11;
            this.mScroller.springBack(i19, i13, 0, 0, 0, getScrollRange());
            i10 = i19;
        }
        onOverScrolled(i10, i13, z2, z3);
        return z2 || z3;
    }

    public boolean pageScroll(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.mTempRect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                Rect rect = this.mTempRect;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            this.mTempRect.top = getScrollY() - height;
            Rect rect2 = this.mTempRect;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.mTempRect;
        int i2 = rect3.top;
        int i4 = height + i2;
        rect3.bottom = i4;
        return scrollAndFocus(i, i2, i4);
    }

    public void removeOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        List<OnScrollChangeListener> list = this.mOnScrollChangeListeners;
        if (list != null) {
            list.remove(onScrollChangeListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.mIsLayoutDirty) {
            this.mChildToScrollTo = view2;
        } else {
            scrollToChild(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return scrollToChildRect(rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iClamp = clamp(i, width, width2);
            int iClamp2 = clamp(i2, height, height2);
            if (iClamp == getScrollX() && iClamp2 == getScrollY()) {
                return;
            }
            super.scrollTo(iClamp, iClamp2);
        }
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslAddOnGoToTopClickListener(@NonNull SeslScrollable.SeslOnGoToTopClickListener seslOnGoToTopClickListener) {
        if (this.mOnGoToTopClickListeners == null) {
            this.mOnGoToTopClickListeners = new ArrayList();
        }
        this.mOnGoToTopClickListeners.add(seslOnGoToTopClickListener);
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslClearOnGoToTopClickListener() {
        List<SeslScrollable.SeslOnGoToTopClickListener> list = this.mOnGoToTopClickListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslForceBottomFadingEdgeClamped(int i) {
        this.mFadingEdgeHelper.forceBottomFadingEdgeClamped(i);
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslForceTopFadingEdgeClamped(int i) {
        this.mFadingEdgeHelper.forceTopFadingEdgeClamped(i);
    }

    @Override // androidx.core.widget.SeslScrollable
    public Rect seslGetAvailableBounds() {
        return this.mAvailableBounds;
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int seslGetBottomScrollOffset() {
        return this.mFadingEdgeHelper.getFadingEdgeBottomOffset();
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int seslGetGoToTopBottomPadding() {
        SeslNestedGoToTopController seslNestedGoToTopController = this.mGoToTopController;
        if (seslNestedGoToTopController != null) {
            return seslNestedGoToTopController.getBottomPadding();
        }
        return 0;
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int seslGetGoToTopDefaultBottomPadding() {
        SeslNestedGoToTopController seslNestedGoToTopController = this.mGoToTopController;
        if (seslNestedGoToTopController != null) {
            return seslNestedGoToTopController.getDefaultBottomPadding();
        }
        return 0;
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int seslGetHoverBottomPadding() {
        return this.mHoverBottomAreaHeight;
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int seslGetHoverDefaultBottomPadding() {
        return this.mHoverDefaultBottomAreaHeight;
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int seslGetHoverDefaultTopPadding() {
        return this.mHoverDefaultTopAreaHeight;
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int seslGetHoverTopPadding() {
        return this.mHoverTopAreaHeight;
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int seslGetScrollBarBottomOffset() {
        return this.mScrollBarBottomOffset;
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int seslGetScrollBarTopOffset() {
        return this.mScrollBarTopOffset;
    }

    public void seslHideBottomFadingEdge(boolean z) {
        this.mFadingEdgeHelper.hideBottomFadingEdge(z);
    }

    public void seslHideTopFadingEdge(boolean z) {
        this.mFadingEdgeHelper.hideTopFadingEdge(z);
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslRemoveOnGoToTopClickListener(@NonNull SeslScrollable.SeslOnGoToTopClickListener seslOnGoToTopClickListener) {
        List<SeslScrollable.SeslOnGoToTopClickListener> list = this.mOnGoToTopClickListeners;
        if (list != null) {
            list.remove(seslOnGoToTopClickListener);
        }
    }

    public void seslSetAllowTopFadingEdgeWithoutEdgeToEdge(boolean z) {
        this.mFadingEdgeHelper.setAllowTopFadingEdgeWithoutEdgeToEdge(z);
    }

    @Override // androidx.core.widget.SeslScrollable
    public void seslSetAvailableBounds(@Nullable Rect rect) {
        this.mAvailableBounds = rect;
    }

    public void seslSetBottomHoverScrollWithAppBar(boolean z) {
        this.mIsBottomHoverScrollWithAppBarEnabled = z;
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslSetBottomScrollOffset(int i) {
        if (this.mFadingEdgeHelper.getFadingEdgeBottomOffset() != i) {
            this.mFadingEdgeHelper.setFadingEdgeBottomOffset(i);
            invalidate();
        }
    }

    @Override // androidx.core.widget.SeslScrollable
    public void seslSetFadingEdgeColor(@ColorInt int i) {
        this.mFadingEdgeHelper.setFadingEdgeColor(i, new RunnableC0015b(this, 22));
        invalidate();
    }

    @Override // androidx.core.widget.SeslScrollable
    public void seslSetFadingEdgeEnabled(boolean z, int i, int i2) {
        applyFadingEdge(z, new RunnableC2502b(this, z, i, i2, 0));
    }

    public void seslSetFadingEdgeWindowBottomAlignment(boolean z) {
        this.mFadingEdgeHelper.setWindowBottomAlignment(z);
    }

    public void seslSetFillHorizontalPaddingEnabled(boolean z, int i) {
        this.mDrawHorizontalPadding = z;
        int dimensionPixelOffset = z ? getResources().getDimensionPixelOffset(C2337R.dimen.sesl_nestedscrollview_system_scroller_vertical_padding) : 0;
        this.mScrollbarTopPadding = dimensionPixelOffset;
        this.mScrollbarBottomPadding = dimensionPixelOffset;
        updateScrollbarVerticalPadding();
        this.mRectPaint.setColor(i);
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslSetFloatingBottomLayoutHeight(int i) {
        this.mSeslBottomBarHeight = i;
    }

    public void seslSetGoToTopBlurEnabled(boolean z) {
        SeslNestedGoToTopController seslNestedGoToTopController = this.mGoToTopController;
        if (seslNestedGoToTopController != null) {
            seslNestedGoToTopController.setBlurEnabled(z, isLightTheme(this.mContext));
        }
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslSetGoToTopBottomPadding(int i) {
        SeslNestedGoToTopController seslNestedGoToTopController = this.mGoToTopController;
        if (seslNestedGoToTopController != null) {
            seslNestedGoToTopController.setBottomPadding(i);
        }
    }

    public void seslSetGoToTopEnabled(boolean z) {
        seslSetGoToTopEnabled(z, isLightTheme(this.mContext));
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslSetHoverBottomPadding(int i) {
        int iMax = Math.max(0, i);
        if (this.mHoverBottomAreaHeight != iMax) {
            this.mHoverBottomAreaHeight = iMax;
        }
    }

    public void seslSetHoverScrollEnabled(boolean z) {
        this.mHoverScrollEnabled = z;
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslSetHoverTopPadding(int i) {
        int iMax = Math.max(0, i);
        if (this.mHoverTopAreaHeight != iMax) {
            this.mHoverTopAreaHeight = iMax;
        }
    }

    public void seslSetOnGoToTopClickListener(SeslOnGoToTopClickListener seslOnGoToTopClickListener) {
        this.mOnGoToTopClickListener = seslOnGoToTopClickListener;
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslSetScrollBarBottomOffset(int i) {
        int i2 = i - this.mScrollBarTopOffset;
        if (this.mScrollBarBottomOffset != i2) {
            this.mScrollBarBottomOffset = Math.max(i2, 0);
            updateScrollbarVerticalPadding();
        }
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslSetScrollBarTopOffset(int i) {
        if (this.mScrollBarTopOffset != i) {
            this.mScrollBarTopOffset = Math.max(i, 0);
            updateScrollbarVerticalPadding();
        }
    }

    public void seslSetScrollbarVerticalPadding(int i, int i2) {
        this.mScrollbarTopPadding = i;
        this.mScrollbarBottomPadding = i2;
        updateScrollbarVerticalPadding();
    }

    public void seslSmoothScrollToWithNestedScrolling(int i, int i2) {
        smoothScrollTo(i, i2, true);
    }

    public void setFillViewport(boolean z) {
        if (z != this.mFillViewport) {
            this.mFillViewport = z;
            requestLayout();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.mChildHelper.setNestedScrollingEnabled(z);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListener = onScrollChangeListener;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.mSmoothScrollingEnabled = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int i, int i2) {
        smoothScrollBy(i, i2, 250, false);
    }

    public final void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, 250, false);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i, int i2) {
        return this.mChildHelper.startNestedScroll(i, i2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i) {
        this.mChildHelper.stopNestedScroll(i);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C2337R.attr.nestedScrollViewStyle);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i, int i2, int i4, int i5, int[] iArr, int i6) {
        return this.mChildHelper.dispatchNestedScroll(i, i2, i4, i5, iArr, i6);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i4, int i5, int i6) {
        onNestedScrollInternal(i5, i6, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // androidx.core.widget.SeslScrollable
    public void seslSetFadingEdgeEnabled(boolean z) {
        applyFadingEdge(z, new RunnableC0116a(3, this, z));
    }

    public void seslSetGoToTopEnabled(boolean z, boolean z2) {
        ensureGoToTopController();
        post(this.mCheckGoToTopAndAutoScrollCondition);
        SeslNestedGoToTopController seslNestedGoToTopController = this.mGoToTopController;
        if (seslNestedGoToTopController != null) {
            seslNestedGoToTopController.setEnabled(z, z2);
            if (z) {
                this.mGoToTopController.setOnGoToTopClickListener(new C0061b(this, 6));
            } else {
                this.mGoToTopController.setOnGoToTopClickListener(null);
            }
        }
    }

    public final void smoothScrollBy(int i, int i2, int i4) {
        smoothScrollBy(i, i2, i4, false);
    }

    public final void smoothScrollTo(int i, int i2, int i4) {
        smoothScrollTo(i, i2, i4, false);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mHoverScrollSpeed = 0;
        this.mGoToTopHost = new C24791();
        this.SINE_IN_OUT_70 = new PathInterpolator(0.33f, 0.0f, 0.3f, 1.0f);
        this.mDrawHorizontalPadding = false;
        Paint paint = new Paint();
        this.mRectPaint = paint;
        this.mScrollbarTopPadding = 0;
        this.mScrollbarBottomPadding = 0;
        this.mIsSupportHoverScroll = false;
        this.mHoverScrollEnabled = true;
        this.mHoverScrollStateChanged = false;
        this.mHoverAreaEnter = false;
        this.mNeedsHoverScroll = false;
        this.mHoverTopAreaHeight = 0;
        this.mHoverBottomAreaHeight = 0;
        this.mHoverDefaultTopAreaHeight = 0;
        this.mHoverDefaultBottomAreaHeight = 0;
        this.mHoverScrollDirection = -1;
        this.mHoverRecognitionDurationTime = 0L;
        this.mHoverRecognitionCurrentTime = 0L;
        this.mHoverRecognitionStartTime = 0L;
        this.mHoverScrollTimeInterval = 300L;
        this.mHoverScrollStartTime = 0L;
        this.mIsHoverOverscrolled = false;
        this.mInitialTopOffsetOfScreen = 0;
        this.mHasNestedScrollRange = false;
        this.mWindowOffsets = new int[2];
        this.mRemainNestedScrollRange = 0;
        this.mNestedScrollRange = 0;
        this.mIsBottomHoverScrollWithAppBarEnabled = false;
        this.mScrollBarTopOffset = 0;
        this.mScrollBarBottomOffset = 0;
        this.mOnGoToTopClickListener = null;
        this.mNaviBarTop = -1;
        this.mScrollInfoProvider = new SeslFadingEdgeHelper.ScrollInfoProvider() { // from class: androidx.core.widget.NestedScrollView.2
            @Override // androidx.core.util.SeslFadingEdgeHelper.ScrollInfoProvider
            public int computeVerticalScrollExtent() {
                return NestedScrollView.this.computeVerticalScrollExtent();
            }

            @Override // androidx.core.util.SeslFadingEdgeHelper.ScrollInfoProvider
            public int computeVerticalScrollOffset() {
                return NestedScrollView.this.computeVerticalScrollOffset();
            }

            @Override // androidx.core.util.SeslFadingEdgeHelper.ScrollInfoProvider
            public int computeVerticalScrollRange() {
                return NestedScrollView.this.computeVerticalScrollRange();
            }

            @Override // androidx.core.util.SeslFadingEdgeHelper.ScrollInfoProvider
            public int getLastItemHeightIfVisible() {
                return -1;
            }

            @Override // androidx.core.util.SeslFadingEdgeHelper.ScrollInfoProvider
            public boolean shouldNormalizeFadingEdge() {
                return false;
            }
        };
        DifferentialMotionFlingTargetImpl differentialMotionFlingTargetImpl = new DifferentialMotionFlingTargetImpl();
        this.mDifferentialMotionFlingTarget = differentialMotionFlingTargetImpl;
        this.mDifferentialMotionFlingController = new DifferentialMotionFlingController(getContext(), differentialMotionFlingTargetImpl);
        this.mAvailableBounds = null;
        this.mDebugDrawAvailRect = false;
        this.mSeslBottomBarHeight = 0;
        this.mOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: androidx.core.widget.NestedScrollView.3
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                NestedScrollView nestedScrollView = NestedScrollView.this;
                nestedScrollView.post(nestedScrollView.mCheckGoToTopAndAutoScrollCondition);
            }
        };
        this.mCheckGoToTopAndAutoScrollCondition = new Runnable() { // from class: androidx.core.widget.NestedScrollView.4
            @Override // java.lang.Runnable
            public void run() {
                if ((NestedScrollView.this.mGoToTopController == null || !NestedScrollView.this.mGoToTopController.isEnabled()) && !NestedScrollView.this.mHoverScrollEnabled) {
                    return;
                }
                boolean zCheckChildScrollableForGoToTopAndAutoScroll = NestedScrollView.this.checkChildScrollableForGoToTopAndAutoScroll();
                NestedScrollView.this.mIsSupportHoverScroll = zCheckChildScrollableForGoToTopAndAutoScroll;
                if (NestedScrollView.this.mGoToTopController != null) {
                    NestedScrollView.this.mGoToTopController.setSupportGoToTop(zCheckChildScrollableForGoToTopAndAutoScroll);
                }
            }
        };
        this.mContext = context;
        this.mEdgeGlowTop = EdgeEffectCompat.create(context, attributeSet);
        this.mEdgeGlowBottom = EdgeEffectCompat.create(context, attributeSet);
        this.mPhysicalCoeff = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        initScrollView();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SCROLLVIEW_STYLEABLE, i, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mFadingEdgeHelper = SeslFadingEdgeHelperImpl.createSeslFadingEdgeHelper(this.mContext);
    }

    private void smoothScrollBy(int i, int i2, int i4, boolean z) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
            boolean zIsFloatingGoToTopScrollRequest = isFloatingGoToTopScrollRequest(i2);
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iMax = Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY;
            if (zIsFloatingGoToTopScrollRequest) {
                iMax -= this.mAvailableBounds.top;
            }
            this.mScroller.startScroll(getScrollX(), scrollY, 0, iMax, i4);
            runAnimatedScroll(z);
        } else {
            if (!this.mScroller.isFinished()) {
                abortAnimatedScroll();
            }
            scrollBy(i, i2);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i4, int i5, int[] iArr) {
        return this.mChildHelper.dispatchNestedScroll(i, i2, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i4, int i5) {
        onNestedScrollInternal(i5, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // androidx.core.widget.SeslScrollable
    public void seslSetFadingEdgeEnabled(boolean z, boolean z2) {
        applyFadingEdge(z, new RunnableC2503c(this, z, z2, 0));
    }

    public void smoothScrollTo(int i, int i2, boolean z) {
        smoothScrollTo(i, i2, 250, z);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    @Override // androidx.core.widget.SeslScrollable
    public void seslSetFadingEdgeEnabled(boolean z, boolean z2, boolean z3) {
        applyFadingEdge(z, new RunnableC2504d(this, z, z2, z3, 0));
    }

    public void smoothScrollTo(int i, int i2, int i4, boolean z) {
        smoothScrollBy(i - getScrollX(), i2 - getScrollY(), i4, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
