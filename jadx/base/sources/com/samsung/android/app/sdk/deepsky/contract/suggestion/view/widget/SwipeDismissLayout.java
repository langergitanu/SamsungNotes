package com.samsung.android.app.sdk.deepsky.contract.suggestion.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 G2\u00020\u0001:\u0004GHIJB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ0\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000bH\u0004J\u0010\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u0007H\u0016J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000204H\u0002J\u0018\u00106\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0002J\u0010\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020\u00112\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010<\u001a\u0002042\u0006\u0010=\u001a\u00020\u0011H\u0016J\b\u0010>\u001a\u000204H\u0002J\u0010\u0010?\u001a\u0002042\b\u0010@\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010A\u001a\u0002042\b\u0010@\u001a\u0004\u0018\u00010\"J\u0010\u0010B\u001a\u0002042\b\u0010@\u001a\u0004\u0018\u00010$J\u0010\u0010C\u001a\u0002042\u0006\u0010D\u001a\u00020\u000bH\u0002J\u0010\u0010E\u001a\u0002042\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010F\u001a\u0002042\u0006\u00109\u001a\u00020:H\u0002R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "dismissMinDragWidthRatio", "", "getDismissMinDragWidthRatio", "()F", "setDismissMinDragWidthRatio", "(F)V", "isSwipeable", "", "()Z", "setSwipeable", "(Z)V", "mActiveTouchId", "mCanStartSwipe", "mDisallowIntercept", "mDiscardIntercept", "mDismissed", "mDismissedListener", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout$OnDismissedListener;", "mDownX", "mDownY", "mGestureThresholdPx", "mLastX", "mMinFlingVelocity", "mOnPreSwipeListener", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout$OnPreSwipeListener;", "mProgressListener", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout$OnSwipeProgressChangedListener;", "mSlop", "mSwiping", "mTranslationX", "mVelocityTracker", "Landroid/view/VelocityTracker;", "canScroll", VPathDataCmd.RCurveTo, "Landroid/view/View;", "checkV", "dx", "x", "y", "canScrollHorizontally", "direction", "cancel", "", "dismiss", "isPotentialSwipe", "dy", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "requestDisallowInterceptTouchEvent", "disallowIntercept", "resetMembers", "setOnDismissedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnPreSwipeListener", "setOnSwipeProgressChangedListener", "setProgress", "deltaX", "updateDismiss", "updateSwiping", "Companion", "OnDismissedListener", "OnPreSwipeListener", "OnSwipeProgressChangedListener", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public class SwipeDismissLayout extends FrameLayout {
    public static final float DEFAULT_DISMISS_DRAG_WIDTH_RATIO = 0.33f;
    private static final float EDGE_SWIPE_THRESHOLD = 0.1f;

    @NotNull
    private static final String TAG = "SSS:SwipeDismissLayout";
    private float dismissMinDragWidthRatio;
    private boolean isSwipeable;
    private int mActiveTouchId;
    private boolean mCanStartSwipe;
    private boolean mDisallowIntercept;
    private boolean mDiscardIntercept;
    private boolean mDismissed;

    @Nullable
    private OnDismissedListener mDismissedListener;
    private float mDownX;
    private float mDownY;
    private final float mGestureThresholdPx;
    private float mLastX;
    private final int mMinFlingVelocity;

    @Nullable
    private OnPreSwipeListener mOnPreSwipeListener;

    @Nullable
    private OnSwipeProgressChangedListener mProgressListener;
    private final int mSlop;
    private boolean mSwiping;
    private float mTranslationX;

    @Nullable
    private VelocityTracker mVelocityTracker;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout$OnDismissedListener;", "", "onDismissed", "", DBSchema.DocumentThumbnail.LAYOUT, "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @UiThread
    public interface OnDismissedListener {
        void onDismissed(@Nullable SwipeDismissLayout layout);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout$OnPreSwipeListener;", "", "onPreSwipe", "", "swipeDismissLayout", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout;", "xDown", "", "yDown", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @UiThread
    public interface OnPreSwipeListener {
        boolean onPreSwipe(@Nullable SwipeDismissLayout swipeDismissLayout, float xDown, float yDown);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout$OnSwipeProgressChangedListener;", "", "onSwipeCanceled", "", DBSchema.DocumentThumbnail.LAYOUT, "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/widget/SwipeDismissLayout;", "onSwipeProgressChanged", "progress", "", "translate", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @UiThread
    public interface OnSwipeProgressChangedListener {
        void onSwipeCanceled(@Nullable SwipeDismissLayout layout);

        void onSwipeProgressChanged(@Nullable SwipeDismissLayout layout, float progress, float translate);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwipeDismissLayout(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void cancel() {
        OnSwipeProgressChangedListener onSwipeProgressChangedListener = this.mProgressListener;
        if (onSwipeProgressChangedListener != null) {
            Intrinsics.checkNotNull(onSwipeProgressChangedListener);
            onSwipeProgressChangedListener.onSwipeCanceled(this);
        }
    }

    private final void dismiss() {
        OnDismissedListener onDismissedListener = this.mDismissedListener;
        if (onDismissedListener != null) {
            Intrinsics.checkNotNull(onDismissedListener);
            onDismissedListener.onDismissed(this);
        }
    }

    private final boolean isPotentialSwipe(float dx, float dy) {
        float f = (dy * dy) + (dx * dx);
        int i = this.mSlop;
        return f > ((float) (i * i));
    }

    private final void resetMembers() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            Intrinsics.checkNotNull(velocityTracker);
            velocityTracker.recycle();
        }
        this.mVelocityTracker = null;
        this.mTranslationX = 0.0f;
        this.mDownX = 0.0f;
        this.mDownY = 0.0f;
        this.mSwiping = false;
        this.mDismissed = false;
        this.mDiscardIntercept = false;
        this.mCanStartSwipe = true;
        this.mDisallowIntercept = false;
    }

    private final void setProgress(float deltaX) {
        this.mTranslationX = deltaX;
        OnSwipeProgressChangedListener onSwipeProgressChangedListener = this.mProgressListener;
        if (onSwipeProgressChangedListener == null || deltaX < 0.0f) {
            return;
        }
        Intrinsics.checkNotNull(onSwipeProgressChangedListener);
        onSwipeProgressChangedListener.onSwipeProgressChanged(this, deltaX / getWidth(), deltaX);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateDismiss(MotionEvent ev) {
        float rawX = ev.getRawX() - this.mDownX;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        Intrinsics.checkNotNull(velocityTracker);
        velocityTracker.addMovement(ev);
        VelocityTracker velocityTracker2 = this.mVelocityTracker;
        Intrinsics.checkNotNull(velocityTracker2);
        velocityTracker2.computeCurrentVelocity(1000);
        if (!this.mDismissed) {
            if (rawX <= getWidth() * this.dismissMinDragWidthRatio || ev.getRawX() < this.mLastX) {
                VelocityTracker velocityTracker3 = this.mVelocityTracker;
                Intrinsics.checkNotNull(velocityTracker3);
                if (velocityTracker3.getXVelocity() >= this.mMinFlingVelocity) {
                    this.mDismissed = true;
                }
            }
        }
        if (this.mDismissed && this.mSwiping) {
            VelocityTracker velocityTracker4 = this.mVelocityTracker;
            Intrinsics.checkNotNull(velocityTracker4);
            if (velocityTracker4.getXVelocity() < (-this.mMinFlingVelocity)) {
                this.mDismissed = false;
            }
        }
    }

    private final void updateSwiping(MotionEvent ev) {
        if (this.mSwiping) {
            return;
        }
        float rawX = ev.getRawX() - this.mDownX;
        float rawY = ev.getRawY() - this.mDownY;
        if (isPotentialSwipe(rawX, rawY)) {
            boolean z = this.mCanStartSwipe && Math.abs(rawY) < Math.abs(rawX) && rawX > 0.0f;
            this.mSwiping = z;
            this.mCanStartSwipe = z;
        }
    }

    public final boolean canScroll(@NotNull View v, boolean checkV, float dx, float x, float y2) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (v instanceof ViewGroup) {
            int scrollX = v.getScrollX();
            int scrollY = v.getScrollY();
            ViewGroup viewGroup = (ViewGroup) v;
            for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
                View child = viewGroup.getChildAt(childCount);
                float f = x + scrollX;
                if (f >= child.getLeft() && f < child.getRight()) {
                    float f4 = y2 + scrollY;
                    if (f4 >= child.getTop() && f4 < child.getBottom()) {
                        Intrinsics.checkNotNullExpressionValue(child, "child");
                        if (canScroll(child, true, dx, f - child.getLeft(), f4 - child.getTop())) {
                            return true;
                        }
                    }
                }
            }
        }
        return checkV && v.canScrollHorizontally((int) (-dx));
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        return direction < 0 && this.isSwipeable && getVisibility() == 0;
    }

    public final float getDismissMinDragWidthRatio() {
        return this.dismissMinDragWidthRatio;
    }

    /* JADX INFO: renamed from: isSwipeable, reason: from getter */
    public final boolean getIsSwipeable() {
        return this.isSwipeable;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev) {
        SwipeDismissLayout swipeDismissLayout;
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!this.isSwipeable) {
            return super.onInterceptTouchEvent(ev);
        }
        ev.offsetLocation(this.mTranslationX, 0.0f);
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 0) {
            swipeDismissLayout = this;
            resetMembers();
            swipeDismissLayout.mDownX = ev.getRawX();
            swipeDismissLayout.mDownY = ev.getRawY();
            swipeDismissLayout.mActiveTouchId = ev.getPointerId(0);
            VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
            swipeDismissLayout.mVelocityTracker = velocityTrackerObtain;
            if (velocityTrackerObtain != null) {
                velocityTrackerObtain.addMovement(ev);
            }
        } else if (actionMasked == 1) {
            swipeDismissLayout = this;
            resetMembers();
        } else {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        this.mActiveTouchId = ev.getPointerId(ev.getActionIndex());
                    } else if (actionMasked == 6) {
                        int actionIndex = ev.getActionIndex();
                        if (ev.getPointerId(actionIndex) == this.mActiveTouchId) {
                            this.mActiveTouchId = ev.getPointerId(actionIndex == 0 ? 1 : 0);
                        }
                    }
                }
                swipeDismissLayout = this;
                resetMembers();
            } else if (this.mVelocityTracker != null && !this.mDiscardIntercept) {
                int iFindPointerIndex = ev.findPointerIndex(this.mActiveTouchId);
                if (iFindPointerIndex == -1) {
                    Log.e(TAG, "Invalid pointer index: ignoring.");
                    this.mDiscardIntercept = true;
                } else {
                    float rawX = ev.getRawX() - this.mDownX;
                    float x = ev.getX(iFindPointerIndex);
                    float y2 = ev.getY(iFindPointerIndex);
                    if (rawX != 0.0f && this.mDownX >= this.mGestureThresholdPx) {
                        swipeDismissLayout = this;
                        if (swipeDismissLayout.canScroll(this, false, rawX, x, y2)) {
                            swipeDismissLayout.mDiscardIntercept = true;
                        }
                    } else {
                        swipeDismissLayout = this;
                    }
                    updateSwiping(ev);
                }
            }
            swipeDismissLayout = this;
        }
        OnPreSwipeListener onPreSwipeListener = swipeDismissLayout.mOnPreSwipeListener;
        return ((onPreSwipeListener == null && !swipeDismissLayout.mDisallowIntercept) || (onPreSwipeListener != null && onPreSwipeListener.onPreSwipe(this, swipeDismissLayout.mDownX, swipeDismissLayout.mDownY))) && !swipeDismissLayout.mDiscardIntercept && swipeDismissLayout.mSwiping;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!this.isSwipeable) {
            return super.onTouchEvent(ev);
        }
        if (this.mVelocityTracker == null) {
            return super.onTouchEvent(ev);
        }
        OnPreSwipeListener onPreSwipeListener = this.mOnPreSwipeListener;
        if (onPreSwipeListener != null) {
            Intrinsics.checkNotNull(onPreSwipeListener);
            if (!onPreSwipeListener.onPreSwipe(this, this.mDownX, this.mDownY)) {
                return super.onTouchEvent(ev);
            }
        }
        ev.offsetLocation(this.mTranslationX, 0.0f);
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 1) {
            updateDismiss(ev);
            if (this.mDismissed) {
                dismiss();
            } else if (this.mSwiping) {
                cancel();
            }
            resetMembers();
        } else if (actionMasked == 2) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            Intrinsics.checkNotNull(velocityTracker);
            velocityTracker.addMovement(ev);
            this.mLastX = ev.getRawX();
            updateSwiping(ev);
            if (this.mSwiping) {
                setProgress(ev.getRawX() - this.mDownX);
            }
        } else if (actionMasked == 3) {
            cancel();
            resetMembers();
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        this.mDisallowIntercept = disallowIntercept;
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(disallowIntercept);
        }
    }

    public final void setDismissMinDragWidthRatio(float f) {
        this.dismissMinDragWidthRatio = f;
    }

    public final void setOnDismissedListener(@Nullable OnDismissedListener listener) {
        this.mDismissedListener = listener;
    }

    public final void setOnPreSwipeListener(@Nullable OnPreSwipeListener listener) {
        this.mOnPreSwipeListener = listener;
    }

    public final void setOnSwipeProgressChangedListener(@Nullable OnSwipeProgressChangedListener listener) {
        this.mProgressListener = listener;
    }

    public final void setSwipeable(boolean z) {
        this.isSwipeable = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwipeDismissLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwipeDismissLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SwipeDismissLayout(Context context, AttributeSet attributeSet, int i, int i2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwipeDismissLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCanStartSwipe = true;
        this.dismissMinDragWidthRatio = 0.33f;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mGestureThresholdPx = Resources.getSystem().getDisplayMetrics().widthPixels * 0.1f;
        this.isSwipeable = true;
    }
}
