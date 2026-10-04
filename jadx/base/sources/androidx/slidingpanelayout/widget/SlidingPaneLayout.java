package androidx.slidingpanelayout.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.appcompat.util.SeslMisc;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import androidx.slidingpanelayout.C3861R;
import com.samsung.android.sesl.visualeffect.utils.DeviceSettingsUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(api = 23)
public class SlidingPaneLayout extends ViewGroup implements Openable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.slidingpanelayout.widget.SlidingPaneLayout";
    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    public static final int LOCK_MODE_LOCKED = 3;
    public static final int LOCK_MODE_LOCKED_CLOSED = 2;
    public static final int LOCK_MODE_LOCKED_OPEN = 1;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_FLING_VELOCITY = 400;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_COLLAPSED_LOCK = 258;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_EXPANDED_LOCK = 257;
    static final int PENDING_ACTION_NONE = 0;
    private static final float SESL_EXTRA_AREA_SENSITIVITY = 0.1f;
    public static final int SESL_PENDING_COLLAPSED = 2;
    public static final int SESL_PENDING_COLLAPSED_LOCK = 258;
    public static final int SESL_PENDING_EXPANDED = 1;
    public static final int SESL_PENDING_EXPANDED_LOCK = 257;
    public static final int SESL_PENDING_NONE = 0;
    public static final int SESL_STATE_CLOSE = 0;
    public static final int SESL_STATE_IDLE = 2;
    public static final int SESL_STATE_OPEN = 1;
    private static final String TAG = "SeslSlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private boolean mDisplayListReflectionLoaded;
    private int mDoubleCheckState;
    final ViewDragHelper mDragHelper;
    private boolean mDrawRoundedCorner;
    private View mDrawerPanel;
    private boolean mFirstLayout;
    private int mFixedPaneStartX;
    private Method mGetDisplayList;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsAnimate;
    private boolean mIsDefaultOpen;
    private boolean mIsLock;
    private boolean mIsNeedBlockDim;
    private boolean mIsNeedClose;
    private boolean mIsNeedOpen;
    private boolean mIsSinglePanel;
    private boolean mIsSlideableViewTouched;
    boolean mIsUnableToDrag;
    private int mLastValidVelocity;
    private int mLockMode;
    private int mMarginBottom;
    private int mMarginTop;
    private boolean mNeedUpdateInitially;
    private final int mOverhangSize;

    @Nullable
    private PanelSlideListener mPanelSlideListener;
    private final List<PanelSlideListener> mPanelSlideListeners;
    private int mParallaxBy;
    private float mParallaxOffset;
    private int mPendingAction;
    final ArrayList<DisableLayerRunnable> mPostedRunnables;
    private TypedValue mPrefContentWidth;
    private TypedValue mPrefDrawerWidth;
    boolean mPreservedOpenState;
    private float mPrevMotionX;
    private int mPrevOrientation;
    private int mPrevWindowVisibility;
    private Field mRecreateDisplayList;
    private View mResizeChild;
    private ArrayList<View> mResizeChildList;
    private boolean mResizeOff;
    private int mRoundedColor;
    private boolean mSetCustomPendingAction;
    private boolean mSetResizeChild;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    float mSlideOffset;
    int mSlideRange;
    View mSlideableView;
    private int mSliderFadeColor;
    private int mSlidingPaneDragArea;
    private SlidingPaneRoundedCorner mSlidingPaneRoundedCorner;
    private SeslSlidingState mSlidingState;
    private int mSmoothWidth;
    private int mStartMargin;
    private float mStartOffset;
    private int mStartSlideX;
    private final Rect mTmpRect;
    private int mUserPreferredContentSize;
    private int mUserPreferredDrawerSize;
    private VelocityTracker mVelocityTracker;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect = new Rect();

        public AccessibilityDelegate() {
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.mTmpRect;
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
            accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
            accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
        }

        private boolean filterDrawerChild(View view) {
            if (view == SlidingPaneLayout.this.mDrawerPanel) {
                return true;
            }
            if (SlidingPaneLayout.this.mDrawerPanel instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) SlidingPaneLayout.this.mDrawerPanel;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    if (view == viewGroup.getChildAt(i)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean filter(View view) {
            return SlidingPaneLayout.this.isDimmed(view);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.ACCESSIBILITY_CLASS_NAME);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompatObtain);
            copyNodeInfoNoChildren(accessibilityNodeInfoCompat, accessibilityNodeInfoCompatObtain);
            accessibilityNodeInfoCompatObtain.recycle();
            accessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.ACCESSIBILITY_CLASS_NAME);
            accessibilityNodeInfoCompat.setSource(view);
            Object parentForAccessibility = ViewCompat.getParentForAccessibility(view);
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!filter(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            int dimensionPixelSize = SlidingPaneLayout.this.getResources().getDimensionPixelSize(C3861R.dimen.sesl_sliding_pane_contents_drag_width_default);
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.mSlideOffset != 0.0f || slidingPaneLayout.mStartMargin >= dimensionPixelSize) {
                ViewCompat.setImportantForAccessibility(view, 1);
            } else if (filterDrawerChild(view)) {
                ViewCompat.setImportantForAccessibility(view, 4);
            }
            if (filter(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DisableLayerRunnable implements Runnable {
        final View mChildView;

        public DisableLayerRunnable(View view) {
            this.mChildView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mChildView.getParent() == SlidingPaneLayout.this) {
                this.mChildView.setLayerType(0, null);
                SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
            }
            SlidingPaneLayout.this.mPostedRunnables.remove(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DragHelperCallback extends ViewDragHelper.Callback {
        public DragHelperCallback() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.mSlideableView.getLayoutParams();
            if (!SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.mSlideRange + paddingLeft);
            }
            int width = SlidingPaneLayout.this.getWidth() - (SlidingPaneLayout.this.mSlideableView.getWidth() + (SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
            return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.mSlideRange);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.mSlideRange;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int i, int i2) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.mDragHelper.captureChildView(slidingPaneLayout.mSlideableView, i2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i) {
            SlidingPaneLayout.this.setAllChildrenVisible();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0) {
                SlidingPaneLayout.this.mIsAnimate = false;
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.mSlideOffset != 0.0f) {
                    slidingPaneLayout.dispatchOnPanelOpened(slidingPaneLayout.mSlideableView);
                    SlidingPaneLayout.this.mPreservedOpenState = true;
                } else {
                    slidingPaneLayout.updateObscuredViewsVisibility(slidingPaneLayout.mSlideableView);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.dispatchOnPanelClosed(slidingPaneLayout2.mSlideableView);
                    SlidingPaneLayout.this.mPreservedOpenState = false;
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i4, int i5) {
            if (SlidingPaneLayout.this.mStartOffset != 0.0f || SlidingPaneLayout.this.mLastValidVelocity <= 0 || SlidingPaneLayout.this.mSlideOffset <= 0.2f) {
                if (SlidingPaneLayout.this.mStartOffset == 1.0f && SlidingPaneLayout.this.mLastValidVelocity < 0 && SlidingPaneLayout.this.mSlideOffset < 0.8f && i4 > 0) {
                    return;
                }
            } else if (i4 < 0) {
                return;
            }
            SlidingPaneLayout.this.onPanelDragged(i);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f4) {
            int paddingLeft;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.mSlideRange;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.mSlideableView.getWidth();
            } else {
                paddingLeft = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.mSlideRange;
                }
            }
            SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            if (SlidingPaneLayout.this.mIsUnableToDrag) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).slideable;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PanelSlideListener {
        void onPanelClosed(@NonNull View view);

        void onPanelOpened(@NonNull View view);

        void onPanelSlide(@NonNull View view, float f);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.slidingpanelayout.widget.SlidingPaneLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        boolean isOpen;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isOpen ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isOpen = parcel.readInt() != 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SeslSlidingState {
        private int mCurrentState = 2;

        public int getState() {
            return this.mCurrentState;
        }

        public void onStateChanged(int i) {
            this.mCurrentState = i;
        }
    }

    public SlidingPaneLayout(@NonNull Context context) {
        this(context, null);
    }

    private boolean closePane(int i, boolean z) {
        if (this.mIsAnimate) {
            return true;
        }
        if (this.mSlideableView == null || this.mIsLock) {
            return false;
        }
        if (z) {
            if (!this.mFirstLayout && !smoothSlideTo(0.0f, i)) {
                return false;
            }
            this.mPreservedOpenState = false;
            return true;
        }
        onPanelDragged(isLayoutRtlSupport() ? this.mSlideRange : this.mStartMargin);
        if (this.mResizeOff) {
            resizeSlideableView(0.0f);
            if (isLayoutRtlSupport()) {
                this.mSlideableView.setRight(getWindowWidth() - this.mStartMargin);
                View view = this.mSlideableView;
                view.setLeft((view.getRight() - getWindowWidth()) + this.mStartMargin);
            } else {
                this.mSlideableView.setLeft(isLayoutRtlSupport() ? this.mSlideRange : this.mStartMargin);
            }
        } else {
            resizeSlideableView(0.0f);
        }
        this.mPreservedOpenState = false;
        return true;
    }

    private void dimChildView(View view, float f, int i) {
        if (this.mIsNeedBlockDim) {
            return;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) ((((-16777216) & i) >>> 24) * f)) << 24) | (i & 16777215);
            if (layoutParams.dimPaint == null) {
                layoutParams.dimPaint = new Paint();
            }
            layoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.dimPaint);
            }
            invalidateChildRegion(view);
            return;
        }
        if (view.getLayerType() != 0) {
            Paint paint = layoutParams.dimPaint;
            if (paint != null) {
                paint.setColorFilter(null);
            }
            DisableLayerRunnable disableLayerRunnable = new DisableLayerRunnable(view);
            this.mPostedRunnables.add(disableLayerRunnable);
            ViewCompat.postOnAnimation(this, disableLayerRunnable);
        }
    }

    private void findResizeChild(View view) {
        if (!this.mSetResizeChild && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 2) {
                this.mResizeChild = viewGroup.getChildAt(1);
            }
        }
    }

    private int getWindowWidth() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    private boolean isToolbar(View view) {
        return (view instanceof Toolbar) || (view instanceof android.widget.Toolbar) || (view instanceof SPLToolbarContainer);
    }

    private boolean openPane(int i, boolean z) {
        if (this.mIsAnimate) {
            return true;
        }
        if (this.mSlideableView == null || this.mIsLock) {
            return false;
        }
        if (z) {
            if (!this.mFirstLayout && !smoothSlideTo(1.0f, i)) {
                return false;
            }
            this.mPreservedOpenState = true;
            return true;
        }
        int i2 = this.mFixedPaneStartX + (isLayoutRtlSupport() ? -this.mSlideRange : this.mSlideRange);
        onPanelDragged(i2);
        if (this.mResizeOff) {
            resizeSlideableView(0.0f);
            if (isLayoutRtlSupport()) {
                this.mSlideableView.setRight((getWindowWidth() - this.mStartMargin) - this.mSlideRange);
                this.mSlideableView.setLeft(this.mSlideableView.getRight() - (getWindowWidth() - this.mStartMargin));
            } else {
                this.mSlideableView.setLeft(i2);
                this.mSlideableView.setRight((i2 + getWindowWidth()) - this.mStartMargin);
            }
        } else {
            resizeSlideableView(1.0f);
        }
        this.mPreservedOpenState = true;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parallaxOtherViews(float f) {
        boolean z;
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        if (!layoutParams.dimWhenOffset) {
            z = false;
        } else if ((zIsLayoutRtlSupport ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) <= 0) {
            z = true;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != this.mSlideableView) {
                float f4 = 1.0f - this.mParallaxOffset;
                int i2 = this.mParallaxBy;
                this.mParallaxOffset = f;
                int i4 = ((int) (f4 * i2)) - ((int) ((1.0f - f) * i2));
                if (zIsLayoutRtlSupport) {
                    i4 = -i4;
                }
                childAt.offsetLeftAndRight(i4);
                if (z) {
                    dimChildView(childAt, zIsLayoutRtlSupport ? this.mParallaxOffset - 1.0f : 1.0f - this.mParallaxOffset, this.mCoveredFadeColor);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void seslSetDrawerPaneWidth() {
        int i;
        float dimension;
        View view;
        int dimensionPixelSize;
        if (this.mDrawerPanel == null) {
            Log.e(TAG, "mDrawerPanel is null");
            return;
        }
        TypedValue typedValue = new TypedValue();
        getResources().getValue(C3861R.dimen.sesl_sliding_pane_drawer_width, typedValue, true);
        int i2 = typedValue.type;
        if (i2 == 4) {
            dimension = typedValue.getFloat() * getWindowWidth();
        } else {
            if (i2 != 5) {
                i = -1;
                view = this.mDrawerPanel;
                if (view != null && (view.getBackground() instanceof InsetDrawable)) {
                    if (Build.VERSION.SDK_INT < 29) {
                        Insets opticalInsets = this.mDrawerPanel.getBackground().getOpticalInsets();
                        dimensionPixelSize = opticalInsets.right + opticalInsets.left;
                    } else {
                        dimensionPixelSize = getResources().getDimensionPixelSize(C3861R.dimen.sesl_sliding_pane_drawer_start_inset);
                    }
                    i += dimensionPixelSize;
                }
                if (i == -1) {
                    ViewGroup.LayoutParams layoutParams = this.mDrawerPanel.getLayoutParams();
                    layoutParams.width = i;
                    this.mDrawerPanel.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            dimension = typedValue.getDimension(getResources().getDisplayMetrics());
        }
        i = (int) dimension;
        view = this.mDrawerPanel;
        if (view != null) {
            if (Build.VERSION.SDK_INT < 29) {
            }
            i += dimensionPixelSize;
        }
        if (i == -1) {
        }
    }

    private void setVelocityTracker(MotionEvent motionEvent) {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        this.mVelocityTracker.addMovement(motionEvent);
    }

    private boolean shouldSkipScroll() {
        return Settings.System.getInt(getContext().getContentResolver(), DeviceSettingsUtil.REDUCE_ANIMATION, 0) == 1;
    }

    private void updateSlidingState() {
        SeslSlidingState seslSlidingState = this.mSlidingState;
        if (seslSlidingState == null || this.mSlideableView == null) {
            return;
        }
        float f = this.mSlideOffset;
        if (f == 0.0f) {
            if (seslSlidingState.getState() != 0) {
                this.mSlidingState.onStateChanged(0);
                dispatchOnPanelClosed(this.mSlideableView);
                return;
            }
            return;
        }
        if (f != 1.0f) {
            if (seslSlidingState.getState() != 2) {
                this.mSlidingState.onStateChanged(2);
            }
        } else if (seslSlidingState.getState() != 1) {
            this.mSlidingState.onStateChanged(1);
            dispatchOnPanelOpened(this.mSlideableView);
        }
    }

    private static boolean viewIsOpaque(View view) {
        return view.isOpaque();
    }

    public void addPanelSlideListener(@NonNull PanelSlideListener panelSlideListener) {
        Log.e(TAG, "addPanelSlideListener not work on SESL5");
    }

    public boolean canScroll(View view, boolean z, int i, int i2, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i2 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && canScroll(childAt, true, i, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (!z) {
            return false;
        }
        if (!isLayoutRtlSupport()) {
            i = -i;
        }
        return view.canScrollHorizontally(i);
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // androidx.customview.widget.Openable
    public void close() {
        this.mLastValidVelocity = 0;
        closePane();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mDragHelper.continueSettling(true)) {
            if (this.mCanSlide) {
                ViewCompat.postInvalidateOnAnimation(this);
            } else {
                this.mDragHelper.abort();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!this.mDrawRoundedCorner || this.mSlideableView == null) {
            return;
        }
        this.mSlidingPaneRoundedCorner.setRoundedCornerColor(0, this.mRoundedColor);
        this.mSlidingPaneRoundedCorner.drawRoundedCorner(this.mSlideableView, canvas);
    }

    public void dispatchOnPanelClosed(View view) {
        this.mStartOffset = this.mSlideOffset;
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null && view != null) {
            panelSlideListener.onPanelClosed(view);
        }
        sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelOpened(View view) {
        this.mStartOffset = this.mSlideOffset;
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null && view != null) {
            panelSlideListener.onPanelOpened(view);
        }
        sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelSlide(View view) {
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null && view != null) {
            panelSlideListener.onPanelSlide(view, this.mSlideOffset);
        }
        if (this.mResizeOff) {
            return;
        }
        resizeSlideableView(this.mSlideOffset);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i;
        int right;
        super.draw(canvas);
        Drawable drawable = isLayoutRtlSupport() ? this.mShadowDrawableRight : this.mShadowDrawableLeft;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (isLayoutRtlSupport()) {
            right = childAt.getRight();
            i = intrinsicWidth + right;
        } else {
            int left = childAt.getLeft();
            int i2 = left - intrinsicWidth;
            i = left;
            right = i2;
        }
        drawable.setBounds(right, top, i, bottom);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iSave = canvas.save();
        if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null) {
            canvas.getClipBounds(this.mTmpRect);
            if (isLayoutRtlSupport()) {
                Rect rect = this.mTmpRect;
                rect.left = Math.max(rect.left, this.mSlideableView.getRight());
            } else {
                Rect rect2 = this.mTmpRect;
                rect2.right = Math.min(rect2.right, this.mSlideableView.getLeft());
            }
            canvas.clipRect(this.mTmpRect);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @ColorInt
    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public final int getLockMode() {
        Log.e(TAG, "getLockMode not work on SESL5");
        return this.mLockMode;
    }

    @Px
    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    @ColorInt
    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    public void invalidateChildRegion(View view) {
        ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).dimPaint);
    }

    public boolean isDimmed(View view) {
        if (view == null) {
            return false;
        }
        return this.mCanSlide && ((LayoutParams) view.getLayoutParams()).dimWhenOffset && this.mSlideOffset > 0.0f;
    }

    public boolean isLayoutRtlSupport() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    @Override // androidx.customview.widget.Openable
    public boolean isOpen() {
        return !this.mCanSlide || this.mSlideOffset == 1.0f;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z = this.mIsDefaultOpen;
        boolean z2 = getResources().getBoolean(C3861R.dimen.sesl_sliding_layout_default_open);
        this.mIsDefaultOpen = z2;
        if (!this.mSetCustomPendingAction) {
            if (this.mNeedUpdateInitially || z != z2) {
                this.mPendingAction = z2 ? 1 : 2;
            } else {
                this.mPendingAction = isOpen() ? 1 : 2;
            }
        }
        if (this.mIsLock) {
            if (isOpen()) {
                this.mPendingAction = 1;
            } else {
                this.mPendingAction = 2;
            }
        }
        this.mPrevOrientation = configuration.orientation;
        this.mNeedUpdateInitially = false;
        seslSetDrawerPaneWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        for (int size = this.mPostedRunnables.size() - 1; size >= 0; size--) {
            this.mPostedRunnables.get(size).run();
        }
        this.mPostedRunnables.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0135 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0158 A[ADDED_TO_REGION] */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.mCanSlide || this.mIsLock || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.mDragHelper.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            this.mStartOffset = this.mSlideOffset;
            this.mIsNeedOpen = false;
            this.mIsNeedClose = false;
            this.mIsUnableToDrag = false;
            float x = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.mInitialMotionX = x;
            this.mInitialMotionY = y2;
            this.mSmoothWidth = 0;
            this.mPrevMotionX = x;
            int right = isLayoutRtlSupport() ? this.mSlideableView.getRight() : this.mSlideableView.getLeft();
            if (isLayoutRtlSupport()) {
                if (x < right - this.mSlidingPaneDragArea || this.mIsLock) {
                    this.mDragHelper.cancel();
                    this.mIsUnableToDrag = true;
                }
            } else if (x > right + this.mSlidingPaneDragArea || this.mIsLock) {
                this.mDragHelper.cancel();
                this.mIsUnableToDrag = true;
            }
            boolean zIsViewUnder = this.mDragHelper.isViewUnder(this.mSlideableView, (int) x, (int) y2);
            this.mIsSlideableViewTouched = zIsViewUnder;
            if (zIsViewUnder && isDimmed(this.mSlideableView)) {
                z = true;
            }
            if (!this.mCanSlide) {
                this.mPreservedOpenState = !this.mDragHelper.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
            }
            if (actionMasked == 3) {
            }
            this.mDragHelper.cancel();
            return false;
        }
        if (actionMasked == 1) {
            if (Math.abs(this.mStartOffset - this.mSlideOffset) < 0.1f) {
                return false;
            }
            this.mSmoothWidth = this.mSlideableView.getWidth();
            this.mDoubleCheckState = -1;
            if (!this.mIsAnimate) {
                float f = this.mSlideOffset;
                if (f != 0.0f && f != 1.0f) {
                    if (f >= 0.5f) {
                        this.mDoubleCheckState = 1;
                        seslOpenPane(true);
                    } else {
                        this.mDoubleCheckState = 0;
                        seslClosePane(true);
                    }
                    return true;
                }
            }
        } else if (actionMasked == 2) {
            float x2 = motionEvent.getX();
            float y3 = motionEvent.getY();
            float fAbs = Math.abs(x2 - this.mInitialMotionX);
            Math.abs(y3 - this.mInitialMotionY);
            int touchSlop = this.mDragHelper.getTouchSlop();
            float f4 = this.mPrevMotionX;
            float fMax = x2 - f4;
            if (f4 != x2) {
                this.mPrevMotionX = x2;
            }
            if (!this.mIsUnableToDrag && fAbs > touchSlop) {
                if (!isLayoutRtlSupport()) {
                    fMax = Math.max(this.mSlideableView.getLeft() + fMax, this.mStartMargin);
                } else if (this.mResizeOff) {
                    fMax = (this.mSlideableView.getRight() - getWindowWidth()) + this.mStartMargin;
                }
                onPanelDragged((int) fMax);
                return true;
            }
        } else if (actionMasked == 3) {
        }
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.mPreservedOpenState = !this.mDragHelper.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (actionMasked == 3 && actionMasked != 1) {
            return this.mDragHelper.shouldInterceptTouchEvent(motionEvent) || z;
        }
        this.mDragHelper.cancel();
        return false;
        z = false;
        if (!this.mCanSlide) {
        }
        if (actionMasked == 3) {
        }
        this.mDragHelper.cancel();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0115  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        boolean z2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int right;
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        if (zIsLayoutRtlSupport) {
            this.mDragHelper.setEdgeTrackingEnabled(2);
        } else {
            this.mDragHelper.setEdgeTrackingEnabled(1);
        }
        int i11 = i4 - i;
        int paddingRight = zIsLayoutRtlSupport ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = zIsLayoutRtlSupport ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            this.mSlideOffset = (this.mCanSlide && (this.mPreservedOpenState || this.mPendingAction == 1)) ? 1.0f : 0.0f;
        }
        int i12 = paddingRight;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.slideable) {
                    int i14 = i11 - paddingLeft;
                    int iMin = (Math.min(paddingRight, i14 - this.mOverhangSize) - i12) - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                    int i15 = zIsLayoutRtlSupport ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    this.mStartMargin = i15;
                    this.mSlideRange = iMin;
                    layoutParams.dimWhenOffset = (measuredWidth / 2) + ((i12 + i15) + iMin) > i14;
                    int i16 = (int) (iMin * this.mSlideOffset);
                    i7 = i15 + i16 + i12;
                    this.mSlideOffset = i16 / iMin;
                } else if (!this.mCanSlide || (i8 = this.mParallaxBy) == 0) {
                    i7 = paddingRight;
                } else {
                    i9 = (int) ((1.0f - this.mSlideOffset) * i8);
                    i7 = paddingRight;
                    if (zIsLayoutRtlSupport) {
                        i10 = i7 - i9;
                        if (this.mResizeOff) {
                            right = layoutParams.slideable ? (i11 - this.mStartMargin) + i10 : i10 + measuredWidth;
                            this.mFixedPaneStartX = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        } else {
                            if (layoutParams.slideable) {
                                right = getRight();
                            }
                            this.mFixedPaneStartX = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        }
                    } else {
                        right = (i11 - i7) + i9;
                        if (this.mResizeOff) {
                            i10 = layoutParams.slideable ? right - (i11 - this.mStartMargin) : right - measuredWidth;
                            this.mFixedPaneStartX = 0;
                        } else {
                            if (layoutParams.slideable) {
                                i10 = -getLeft();
                            }
                            this.mFixedPaneStartX = 0;
                        }
                    }
                    this.mStartSlideX = !zIsLayoutRtlSupport ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    int measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                    if (layoutParams.slideable) {
                        int i17 = this.mMarginTop;
                        childAt.layout(i10, paddingTop + i17, right, measuredHeight + i17);
                    } else {
                        childAt.layout(i10, paddingTop, right, measuredHeight);
                    }
                    paddingRight = childAt.getWidth() + paddingRight;
                    i12 = i7;
                }
                i9 = 0;
                if (zIsLayoutRtlSupport) {
                }
                this.mStartSlideX = !zIsLayoutRtlSupport ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                int measuredHeight2 = childAt.getMeasuredHeight() + paddingTop;
                if (layoutParams.slideable) {
                }
                paddingRight = childAt.getWidth() + paddingRight;
                i12 = i7;
            }
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide) {
                if (this.mParallaxBy != 0) {
                    parallaxOtherViews(this.mSlideOffset);
                }
                if (((LayoutParams) this.mSlideableView.getLayoutParams()).dimWhenOffset) {
                    dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
                }
            } else {
                for (int i18 = 0; i18 < childCount; i18++) {
                    dimChildView(getChildAt(i18), 0.0f, this.mSliderFadeColor);
                }
            }
            updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.mFirstLayout = false;
        int i19 = this.mPendingAction;
        if (i19 == 1) {
            if (this.mIsLock) {
                resizeSlideableView(1.0f);
            }
            openPane(0, false);
            this.mPendingAction = 0;
        } else {
            if (i19 != 2) {
                if (i19 == 257) {
                    this.mIsLock = false;
                    openPane(0, false);
                    z2 = true;
                    this.mIsLock = true;
                    this.mPendingAction = 0;
                } else {
                    z2 = true;
                    if (i19 == 258) {
                        this.mIsLock = false;
                        closePane(0, false);
                        this.mIsLock = true;
                        this.mPendingAction = 0;
                    }
                }
                updateSlidingState();
                i6 = this.mDoubleCheckState;
                if (i6 == -1) {
                    if (i6 == z2) {
                        openPane(0, z2);
                    } else if (i6 == 0) {
                        closePane(0, z2);
                    }
                    this.mDoubleCheckState = -1;
                    return;
                }
                return;
            }
            if (this.mIsLock) {
                resizeSlideableView(0.0f);
            }
            closePane(0, false);
            this.mPendingAction = 0;
        }
        z2 = true;
        updateSlidingState();
        i6 = this.mDoubleCheckState;
        if (i6 == -1) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0113  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        int paddingTop;
        int iMin;
        int i4;
        int i5;
        int iMakeMeasureSpec;
        int i6;
        int iMakeMeasureSpec2;
        int i7;
        int iMakeMeasureSpec3;
        int iMakeMeasureSpec4;
        float dimension;
        int dimensionPixelSize;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
            size2 = 300;
            mode2 = Integer.MIN_VALUE;
        }
        boolean z = false;
        if (mode2 != Integer.MIN_VALUE) {
            iMin = mode2 != 1073741824 ? 0 : (size2 - getPaddingTop()) - getPaddingBottom();
            paddingTop = iMin;
        } else {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            iMin = 0;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e(TAG, "onMeasure: More than two child views are not supported.");
        }
        this.mSlideableView = null;
        this.mDrawerPanel = null;
        int i8 = 0;
        boolean z2 = false;
        int i9 = paddingLeft;
        float f = 0.0f;
        while (true) {
            i4 = 8;
            if (i8 >= childCount) {
                break;
            }
            View childAt = getChildAt(i8);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.dimWhenOffset = z;
            } else {
                float f4 = layoutParams.weight;
                if (f4 > 0.0f) {
                    f += f4;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width == 0) {
                    }
                    i8++;
                    paddingLeft = i7;
                    z = false;
                }
                int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                if (i11 != -2) {
                    i7 = paddingLeft;
                    iMakeMeasureSpec3 = i11 == -1 ? View.MeasureSpec.makeMeasureSpec(i7 - i10, 1073741824) : View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
                } else if (layoutParams.slideable) {
                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i10, Integer.MIN_VALUE);
                    i7 = paddingLeft;
                } else {
                    int i12 = this.mUserPreferredDrawerSize;
                    if (i12 != -1) {
                        i7 = paddingLeft;
                    } else {
                        TypedValue typedValue = this.mPrefDrawerWidth;
                        if (typedValue != null) {
                            i7 = paddingLeft;
                        } else {
                            typedValue = new TypedValue();
                            i7 = paddingLeft;
                            getResources().getValue(C3861R.dimen.sesl_sliding_pane_drawer_width, typedValue, true);
                        }
                        int i13 = typedValue.type;
                        if (i13 == 4) {
                            dimension = typedValue.getFloat() * getWindowWidth();
                        } else if (i13 == 5) {
                            dimension = typedValue.getDimension(getResources().getDisplayMetrics());
                        } else {
                            i12 = size;
                            if (childAt.getBackground() instanceof InsetDrawable) {
                                if (Build.VERSION.SDK_INT >= 29) {
                                    Insets opticalInsets = childAt.getBackground().getOpticalInsets();
                                    dimensionPixelSize = opticalInsets.right + opticalInsets.left;
                                } else {
                                    dimensionPixelSize = getResources().getDimensionPixelSize(C3861R.dimen.sesl_sliding_pane_drawer_start_inset);
                                }
                                i12 += dimensionPixelSize;
                            }
                        }
                        i12 = (int) dimension;
                        if (childAt.getBackground() instanceof InsetDrawable) {
                        }
                    }
                    if (i12 > size) {
                        i12 = size;
                    }
                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                }
                int i14 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                if (i14 == -2) {
                    iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(layoutParams.slideable ? paddingTop : (paddingTop - this.mMarginTop) - this.mMarginBottom, Integer.MIN_VALUE);
                } else if (i14 == -1) {
                    iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(layoutParams.slideable ? paddingTop : (paddingTop - this.mMarginTop) - this.mMarginBottom, 1073741824);
                } else {
                    iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
                }
                childAt.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == Integer.MIN_VALUE && measuredHeight > iMin) {
                    iMin = Math.min(measuredHeight, paddingTop);
                }
                i9 -= measuredWidth;
                boolean z3 = i9 < 0;
                layoutParams.slideable = z3;
                z2 |= z3;
                if (z3) {
                    this.mSlideableView = childAt;
                } else {
                    this.mDrawerPanel = childAt;
                }
                i8++;
                paddingLeft = i7;
                z = false;
            }
            i7 = paddingLeft;
            i8++;
            paddingLeft = i7;
            z = false;
        }
        int i15 = paddingLeft;
        if (z2 || f > 0.0f) {
            int i16 = i15 - this.mOverhangSize;
            int i17 = 0;
            while (i17 < childCount) {
                View childAt2 = getChildAt(i17);
                if (childAt2.getVisibility() != i4) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i4) {
                        boolean z4 = ((ViewGroup.MarginLayoutParams) layoutParams2).width == 0 && layoutParams2.weight > 0.0f;
                        int measuredWidth2 = z4 ? 0 : childAt2.getMeasuredWidth();
                        if (!z2 || childAt2 == this.mSlideableView) {
                            if (layoutParams2.weight > 0.0f) {
                                if (((ViewGroup.MarginLayoutParams) layoutParams2).width == 0) {
                                    int i18 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                    if (i18 == -2) {
                                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                        i5 = 1073741824;
                                    } else if (i18 == -1) {
                                        i5 = 1073741824;
                                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                    } else {
                                        i5 = 1073741824;
                                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
                                    }
                                } else {
                                    i5 = 1073741824;
                                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                if (z2) {
                                    int i19 = i15 - (((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
                                    int iMakeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i19, i5);
                                    if (measuredWidth2 != i19) {
                                        childAt2.measure(iMakeMeasureSpec5, iMakeMeasureSpec);
                                    }
                                } else {
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2 + ((int) ((layoutParams2.weight * Math.max(0, i9)) / f)), 1073741824), iMakeMeasureSpec);
                                }
                            }
                        } else if (((ViewGroup.MarginLayoutParams) layoutParams2).width < 0 && (measuredWidth2 > i16 || layoutParams2.weight > 0.0f)) {
                            if (z4) {
                                int i20 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
                                if (i20 == -2) {
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                    i6 = 1073741824;
                                } else if (i20 == -1) {
                                    i6 = 1073741824;
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                } else {
                                    i6 = 1073741824;
                                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i20, 1073741824);
                                }
                            } else {
                                i6 = 1073741824;
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i16, i6), iMakeMeasureSpec2);
                        }
                    }
                }
                i17++;
                i4 = 8;
            }
        }
        int windowWidth = getWindowWidth();
        if (windowWidth > 0) {
            size = windowWidth;
        }
        setMeasuredDimension(size, getPaddingBottom() + getPaddingTop() + iMin);
        this.mCanSlide = z2;
        if (this.mDragHelper.getViewDragState() == 0 || z2) {
            return;
        }
        this.mDragHelper.abort();
    }

    public void onPanelDragged(int i) {
        if (this.mIsLock) {
            return;
        }
        if (this.mSlideableView == null) {
            this.mSlideOffset = 0.0f;
            return;
        }
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        int paddingRight = (zIsLayoutRtlSupport ? getPaddingRight() : getPaddingLeft()) + (zIsLayoutRtlSupport ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
        int width = this.mSlideableView.getWidth();
        if (zIsLayoutRtlSupport && this.mResizeOff) {
            width = getWidth() - paddingRight;
        } else if (this.mIsNeedClose) {
            width = Math.max((getWidth() - this.mSlideRange) - paddingRight, this.mSmoothWidth);
        } else if (this.mIsNeedOpen) {
            int width2 = getWidth() - paddingRight;
            int width3 = this.mSmoothWidth;
            if (width3 == 0) {
                width3 = getWidth() - paddingRight;
            }
            width = Math.min(width2, width3);
        }
        if (zIsLayoutRtlSupport) {
            i = (getWidth() - i) - width;
        }
        float f = i - paddingRight;
        int i2 = this.mSlideRange;
        if (i2 == 0) {
            i2 = 1;
        }
        float f4 = f / i2;
        this.mSlideOffset = f4;
        this.mSlideOffset = f4 <= 1.0f ? Math.max(f4, 0.0f) : 1.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null && velocityTracker.getXVelocity() != 0.0f) {
            this.mLastValidVelocity = (int) this.mVelocityTracker.getXVelocity();
        }
        updateSlidingState();
        if (this.mParallaxBy != 0) {
            parallaxOtherViews(this.mSlideOffset);
        }
        if (layoutParams.dimWhenOffset) {
            dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        }
        dispatchOnPanelSlide(this.mSlideableView);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            openPane();
        } else {
            closePane();
        }
        this.mPreservedOpenState = savedState.isOpen;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isOpen = isSlideable() ? isOpen() : this.mPreservedOpenState;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i4, int i5) {
        super.onSizeChanged(i, i2, i4, i5);
        if (i != i4) {
            this.mFirstLayout = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x017f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int right;
        int i;
        if (!this.mCanSlide || this.mIsLock) {
            return super.onTouchEvent(motionEvent);
        }
        this.mDragHelper.processTouchEvent(motionEvent);
        setVelocityTracker(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.mInitialMotionX = x;
            this.mInitialMotionY = y2;
            this.mStartOffset = this.mSlideOffset;
            this.mIsNeedOpen = false;
            this.mIsNeedClose = false;
            this.mPrevMotionX = x;
            this.mSmoothWidth = 0;
            return true;
        }
        if (actionMasked == 1) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
            if (isDimmed(this.mSlideableView)) {
                float x2 = motionEvent.getX();
                float y3 = motionEvent.getY();
                float f = x2 - this.mInitialMotionX;
                float f4 = y3 - this.mInitialMotionY;
                int touchSlop = this.mDragHelper.getTouchSlop();
                if ((f4 * f4) + (f * f) < touchSlop * touchSlop && this.mDragHelper.isViewUnder(this.mSlideableView, (int) x2, (int) y3)) {
                    closePane(0, true);
                    return true;
                }
            }
            this.mSmoothWidth = this.mSlideableView.getWidth();
            this.mDoubleCheckState = -1;
            float f5 = this.mSlideOffset;
            if (f5 != 0.0f && f5 != 1.0f) {
                if (f5 >= 0.5f) {
                    this.mDoubleCheckState = 1;
                    seslOpenPane(true);
                    return true;
                }
                this.mDoubleCheckState = 0;
                seslClosePane(true);
            }
        } else if (actionMasked == 2) {
            float x5 = motionEvent.getX();
            float fAbs = Math.abs(x5 - this.mInitialMotionX);
            float f6 = this.mPrevMotionX;
            float fMin = x5 - f6;
            if (f6 != x5) {
                this.mPrevMotionX = x5;
            }
            int touchSlop2 = this.mDragHelper.getTouchSlop();
            if (!this.mIsUnableToDrag && fAbs > touchSlop2) {
                if (this.mIsSlideableViewTouched) {
                    if (!isLayoutRtlSupport()) {
                        int right2 = isLayoutRtlSupport() ? this.mSlideableView.getRight() : this.mSlideableView.getLeft();
                        int width = this.mSlideableView.getWidth();
                        if (right2 == 0) {
                            right2 = 1;
                        }
                        int i2 = width / right2;
                        float left = this.mSlideableView.getLeft();
                        if (i2 == 0) {
                            i2 = 1;
                        }
                        fMin = Math.max((fMin / i2) + left, this.mStartMargin);
                        if (this.mResizeOff) {
                            this.mSlideableView.setLeft((int) Math.max(this.mStartMargin, fMin));
                            this.mSlideableView.setRight((this.mSlideableView.getLeft() + getWindowWidth()) - this.mStartMargin);
                        }
                    } else if (this.mResizeOff) {
                        right = this.mSlideableView.getRight() - getWindowWidth();
                        i = this.mStartMargin;
                        fMin = right + i;
                    }
                } else if (isLayoutRtlSupport()) {
                    float fMax = Math.max(Math.min(this.mSlideableView.getRight() + fMin, getWidth() - this.mStartMargin), (getWidth() - this.mStartMargin) - this.mSlideRange);
                    if (this.mResizeOff) {
                        this.mSlideableView.setRight((int) fMax);
                        this.mSlideableView.setLeft((this.mSlideableView.getRight() - getWindowWidth()) + this.mStartMargin);
                        right = this.mSlideableView.getRight() - getWindowWidth();
                        i = this.mStartMargin;
                        fMin = right + i;
                    }
                } else {
                    int i4 = this.mStartMargin;
                    int i5 = this.mSlideRange;
                    float xVelocity = (i4 + i5) / (i5 == 0 ? 1.0f : i5);
                    this.mVelocityTracker.computeCurrentVelocity(1000, 2.0f);
                    if (this.mVelocityTracker.getXVelocity() > 0.0f) {
                        xVelocity *= this.mVelocityTracker.getXVelocity();
                    }
                    fMin = Math.min((fMin / (xVelocity != 0.0f ? xVelocity : 1.0f)) + this.mSlideableView.getLeft(), this.mStartMargin + this.mSlideRange);
                    if (this.mResizeOff) {
                        this.mSlideableView.setRight((this.mSlideableView.getLeft() + getWindowWidth()) - this.mStartMargin);
                    }
                    this.mSlideableView.setLeft((int) Math.max(this.mStartMargin, fMin));
                }
                onPanelDragged((int) fMin);
                return true;
            }
        } else if (actionMasked == 3) {
        }
        return true;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        int i2 = this.mPrevWindowVisibility;
        if ((i2 == 8 || i2 == 4) && i == 0) {
            if (isOpen()) {
                this.mPendingAction = 1;
            } else {
                this.mPendingAction = 2;
            }
        }
        if (this.mPrevWindowVisibility != i) {
            this.mPrevWindowVisibility = i;
        }
    }

    @Override // androidx.customview.widget.Openable
    public void open() {
        this.mLastValidVelocity = 0;
        openPane();
    }

    public void removePanelSlideListener(@NonNull PanelSlideListener panelSlideListener) {
        this.mPanelSlideListeners.remove(panelSlideListener);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.mCanSlide) {
            return;
        }
        this.mPreservedOpenState = view == this.mSlideableView;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void resizeSlideableView(float f) {
        ViewGroup.LayoutParams layoutParams;
        int i;
        float dimension;
        int i2;
        ViewGroup.LayoutParams layoutParams2;
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        View view = this.mSlideableView;
        if (view instanceof ViewGroup) {
            int paddingEnd = this.mSlideableView.getPaddingEnd() + view.getPaddingStart();
            ViewGroup viewGroup = (ViewGroup) this.mSlideableView;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = viewGroup.getChildAt(i4);
                if (childAt != null && (layoutParams = childAt.getLayoutParams()) != null) {
                    int paddingEnd2 = (((width - this.mStartSlideX) - ((int) (this.mSlideRange * f))) - paddingEnd) - (childAt.getPaddingEnd() + childAt.getPaddingStart());
                    TypedValue typedValue = this.mPrefContentWidth;
                    if (typedValue == null) {
                        typedValue = new TypedValue();
                        getResources().getValue(C3861R.dimen.sesl_sliding_pane_contents_width, typedValue, true);
                    }
                    int i5 = typedValue.type;
                    if (i5 == 4) {
                        dimension = typedValue.getFloat() * width;
                    } else if (i5 == 5) {
                        dimension = typedValue.getDimension(getResources().getDisplayMetrics());
                    } else {
                        i = paddingEnd2;
                        i2 = this.mUserPreferredContentSize;
                        if (i2 != -1) {
                            i = i2;
                        }
                        int iMin = Math.min(paddingEnd2, i);
                        if (!this.mSetResizeChild) {
                            ArrayList<View> arrayList = this.mResizeChildList;
                            if (arrayList == null) {
                                View view2 = this.mResizeChild;
                                layoutParams2 = view2 != null ? view2.getLayoutParams() : null;
                                if (layoutParams2 != null) {
                                    layoutParams2.width = iMin;
                                }
                            } else {
                                for (View view3 : arrayList) {
                                    if (view3 == null) {
                                        return;
                                    } else {
                                        view3.getLayoutParams().width = iMin;
                                    }
                                }
                            }
                        } else if (this.mIsSinglePanel && !isToolbar(childAt)) {
                            if (childAt instanceof CoordinatorLayout) {
                                findResizeChild(childAt);
                                View view4 = this.mResizeChild;
                                layoutParams2 = view4 != null ? view4.getLayoutParams() : null;
                                if (layoutParams2 != null) {
                                    layoutParams2.width = iMin;
                                }
                            } else {
                                paddingEnd2 = iMin;
                            }
                        }
                        layoutParams.width = paddingEnd2;
                        childAt.requestLayout();
                    }
                    i = (int) dimension;
                    i2 = this.mUserPreferredContentSize;
                    if (i2 != -1) {
                    }
                    int iMin2 = Math.min(paddingEnd2, i);
                    if (!this.mSetResizeChild) {
                    }
                    layoutParams.width = paddingEnd2;
                    childAt.requestLayout();
                }
            }
        }
    }

    public void seslClosePane(boolean z) {
        this.mLastValidVelocity = 0;
        this.mIsNeedOpen = false;
        this.mIsNeedClose = true;
        closePane(0, z);
    }

    public boolean seslGetLock() {
        return this.mIsLock;
    }

    public int seslGetPreferredContentPixelSize() {
        return this.mUserPreferredContentSize;
    }

    public int seslGetPreferredDrawerPixelSize() {
        return this.mUserPreferredDrawerSize;
    }

    public boolean seslGetReiszeOff() {
        return this.mResizeOff;
    }

    public boolean seslGetSinglePanelStatus() {
        return this.mIsSinglePanel;
    }

    public int seslGetSlideRange() {
        return this.mSlideRange;
    }

    public int seslGetSlidingPaneDragArea() {
        return this.mSlidingPaneDragArea;
    }

    public SeslSlidingState seslGetSlidingState() {
        return this.mSlidingState;
    }

    public void seslOpenPane(boolean z) {
        this.mLastValidVelocity = 0;
        this.mIsNeedOpen = true;
        this.mIsNeedClose = false;
        openPane(0, z);
    }

    public void seslRequestPreferredContentPixelSize(int i) {
        this.mUserPreferredContentSize = i;
        resizeSlideableView(this.mSlideOffset);
    }

    public void seslRequestPreferredDrawerPixelSize(int i) {
        this.mUserPreferredDrawerSize = i;
        resizeSlideableView(this.mSlideOffset);
    }

    public void seslSetBlockDimWhenOffset(boolean z) {
        this.mIsNeedBlockDim = z;
    }

    public void seslSetDrawerMarginBottom(int i) {
        if (this.mMarginBottom == i) {
            return;
        }
        this.mMarginBottom = i;
        SlidingPaneRoundedCorner slidingPaneRoundedCorner = this.mSlidingPaneRoundedCorner;
        if (slidingPaneRoundedCorner != null) {
            slidingPaneRoundedCorner.setMarginBottom(i);
        }
        requestLayout();
    }

    public void seslSetDrawerMarginTop(int i) {
        if (this.mMarginTop == i) {
            return;
        }
        this.mMarginTop = i;
        SlidingPaneRoundedCorner slidingPaneRoundedCorner = this.mSlidingPaneRoundedCorner;
        if (slidingPaneRoundedCorner != null) {
            slidingPaneRoundedCorner.setMarginTop(i);
        }
        requestLayout();
    }

    public void seslSetLock(boolean z) {
        this.mIsLock = z;
    }

    public void seslSetPendingAction(int i) {
        if (i == 0 || i == 2 || i == 1 || i == 257 || i == 258) {
            this.mSetCustomPendingAction = true;
            this.mPendingAction = i;
        } else {
            this.mSetCustomPendingAction = false;
            AbstractC2322a.m1632v(i, "pendingAction value is wrong ==> Your pending action value is [", "] / Now set pendingAction value as default", TAG);
        }
    }

    public void seslSetResizeChild(View view) {
        this.mSetResizeChild = true;
        this.mResizeChild = view;
        this.mResizeChildList = null;
    }

    public void seslSetResizeOff(boolean z) {
        this.mResizeOff = z;
        ViewDragHelper viewDragHelper = this.mDragHelper;
        if (viewDragHelper != null) {
            viewDragHelper.seslSetUpdateOffsetLR(z);
        }
    }

    public void seslSetRoundedCornerColor(int i) {
        this.mRoundedColor = i;
    }

    public void seslSetSinglePanel(boolean z) {
        this.mIsSinglePanel = z;
    }

    public void seslSetSlidingPaneDragArea(int i) {
        this.mSlidingPaneDragArea = i;
    }

    public void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public void setCoveredFadeColor(@ColorInt int i) {
        this.mCoveredFadeColor = i;
    }

    public final void setLockMode(int i) {
        Log.e(TAG, "setLockMode not work on SESL5");
        this.mLockMode = i;
    }

    public void setPanelSlideListener(@Nullable PanelSlideListener panelSlideListener) {
        this.mPanelSlideListener = panelSlideListener;
    }

    public void setParallaxDistance(@Px int i) {
        this.mParallaxBy = i;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@Nullable Drawable drawable) {
        this.mShadowDrawableLeft = drawable;
    }

    public void setShadowDrawableRight(@Nullable Drawable drawable) {
        this.mShadowDrawableRight = drawable;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i) {
        setShadowDrawableLeft(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), i));
    }

    public void setSliderFadeColor(@ColorInt int i) {
        this.mSliderFadeColor = i;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    public boolean smoothSlideTo(float f, int i) {
        int paddingLeft;
        int width;
        this.mIsAnimate = false;
        if (!this.mCanSlide) {
            return false;
        }
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        if (zIsLayoutRtlSupport) {
            int paddingRight = getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            int width2 = this.mSlideableView.getWidth();
            if (this.mIsNeedClose) {
                width = this.mResizeOff ? getWidth() : getWidth() - this.mSlideRange;
            } else {
                if (this.mIsNeedOpen) {
                    width = getWidth();
                }
                paddingLeft = (int) (getWidth() - (((f * this.mSlideRange) + paddingRight) + width2));
            }
            width2 = width - paddingRight;
            paddingLeft = (int) (getWidth() - (((f * this.mSlideRange) + paddingRight) + width2));
        } else {
            paddingLeft = (int) ((f * this.mSlideRange) + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
        }
        ViewDragHelper viewDragHelper = this.mDragHelper;
        View view = this.mSlideableView;
        if (!viewDragHelper.smoothSlideViewTo(view, paddingLeft, view.getTop())) {
            return false;
        }
        setAllChildrenVisible();
        ViewCompat.postInvalidateOnAnimation(this);
        this.mIsAnimate = true;
        return true;
    }

    public void updateObscuredViewsVisibility(View view) {
        int left;
        int right;
        int top;
        int bottom;
        View childAt;
        boolean z;
        View view2 = view;
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        int width = zIsLayoutRtlSupport ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = zIsLayoutRtlSupport ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !viewIsOpaque(view2)) {
            left = 0;
            right = 0;
            top = 0;
            bottom = 0;
        } else {
            left = view2.getLeft();
            right = view2.getRight();
            top = view2.getTop();
            bottom = view2.getBottom();
        }
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount && (childAt = getChildAt(i)) != view2) {
            if (childAt.getVisibility() == 8) {
                z = zIsLayoutRtlSupport;
            } else {
                z = zIsLayoutRtlSupport;
                childAt.setVisibility((Math.max(zIsLayoutRtlSupport ? paddingLeft : width, childAt.getLeft()) < left || Math.max(paddingTop, childAt.getTop()) < top || Math.min(zIsLayoutRtlSupport ? width : paddingLeft, childAt.getRight()) > right || Math.min(height, childAt.getBottom()) > bottom) ? 0 : 4);
            }
            i++;
            view2 = view;
            zIsLayoutRtlSupport = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = {R.attr.layout_weight};
        Paint dimPaint;
        boolean dimWhenOffset;
        boolean slideable;
        public float weight;

        public LayoutParams() {
            super(-1, -1);
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.weight = 0.0f;
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.weight = 0.0f;
            this.weight = layoutParams.weight;
        }

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.weight = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            this.weight = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"ResourceAsColor", "ResourceType"})
    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        int color;
        super(context, attributeSet, i);
        this.mSliderFadeColor = DEFAULT_FADE_COLOR;
        this.mPanelSlideListeners = new CopyOnWriteArrayList();
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList<>();
        this.mDoubleCheckState = -1;
        this.mIsNeedBlockDim = false;
        this.mIsNeedClose = false;
        this.mIsNeedOpen = false;
        this.mSmoothWidth = 0;
        this.mStartOffset = 0.0f;
        this.mSlidingPaneDragArea = 0;
        this.mVelocityTracker = null;
        this.mStartMargin = 0;
        this.mRoundedColor = -1;
        this.mSetCustomPendingAction = false;
        this.mNeedUpdateInitially = true;
        this.mPrevWindowVisibility = 0;
        this.mFixedPaneStartX = 0;
        this.mPrevOrientation = 0;
        this.mStartSlideX = 0;
        this.mLastValidVelocity = 0;
        this.mResizeChild = null;
        this.mResizeChildList = null;
        this.mSetResizeChild = false;
        this.mIsLock = false;
        this.mMarginTop = 0;
        this.mMarginBottom = 0;
        this.mUserPreferredContentSize = -1;
        this.mUserPreferredDrawerSize = -1;
        float f = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = (int) ((32.0f * f) + 0.5f);
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        ViewCompat.setImportantForAccessibility(this, 1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3861R.styleable.SlidingPaneLayout, i, 0);
        this.mIsSinglePanel = typedArrayObtainStyledAttributes.getBoolean(C3861R.styleable.SlidingPaneLayout_seslIsSinglePanel, false);
        this.mDrawRoundedCorner = typedArrayObtainStyledAttributes.getBoolean(C3861R.styleable.SlidingPaneLayout_seslDrawRoundedCorner, true);
        int i2 = C3861R.styleable.SlidingPaneLayout_seslDrawRoundedCornerColor;
        if (SeslMisc.isLightTheme(context)) {
            color = getResources().getColor(C3861R.color.sesl_sliding_pane_background_light, null);
        } else {
            color = getResources().getColor(C3861R.color.sesl_sliding_pane_background_dark, null);
        }
        this.mRoundedColor = typedArrayObtainStyledAttributes.getColor(i2, color);
        this.mResizeOff = typedArrayObtainStyledAttributes.getBoolean(C3861R.styleable.SlidingPaneLayout_seslResizeOff, false);
        this.mMarginTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(C3861R.styleable.SlidingPaneLayout_seslDrawerMarginTop, 0);
        this.mMarginBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(C3861R.styleable.SlidingPaneLayout_seslDrawerMarginBottom, 0);
        if (typedArrayObtainStyledAttributes.hasValue(C3861R.styleable.SlidingPaneLayout_seslPrefDrawerWidthSize)) {
            TypedValue typedValue = new TypedValue();
            this.mPrefDrawerWidth = typedValue;
            typedArrayObtainStyledAttributes.getValue(C3861R.styleable.SlidingPaneLayout_seslPrefDrawerWidthSize, typedValue);
        }
        if (typedArrayObtainStyledAttributes.hasValue(C3861R.styleable.SlidingPaneLayout_seslPrefContentWidthSize)) {
            TypedValue typedValue2 = new TypedValue();
            this.mPrefContentWidth = typedValue2;
            typedArrayObtainStyledAttributes.getValue(C3861R.styleable.SlidingPaneLayout_seslPrefContentWidthSize, typedValue2);
        }
        typedArrayObtainStyledAttributes.recycle();
        ViewDragHelper viewDragHelperSeslCreate = ViewDragHelper.seslCreate(this, 0.5f, new DragHelperCallback());
        this.mDragHelper = viewDragHelperSeslCreate;
        viewDragHelperSeslCreate.setMinVelocity(f * 400.0f);
        viewDragHelperSeslCreate.seslSetUpdateOffsetLR(this.mResizeOff);
        if (this.mDrawRoundedCorner) {
            SlidingPaneRoundedCorner slidingPaneRoundedCorner = new SlidingPaneRoundedCorner(context);
            this.mSlidingPaneRoundedCorner = slidingPaneRoundedCorner;
            slidingPaneRoundedCorner.setRoundedCorners(0);
            this.mSlidingPaneRoundedCorner.setMarginTop(this.mMarginTop);
            this.mSlidingPaneRoundedCorner.setMarginBottom(this.mMarginBottom);
        }
        Resources resources = getResources();
        this.mIsDefaultOpen = resources.getBoolean(C3861R.dimen.sesl_sliding_layout_default_open);
        this.mSlidingPaneDragArea = resources.getDimensionPixelSize(C3861R.dimen.sesl_sliding_pane_contents_drag_width_default);
        this.mPendingAction = this.mIsDefaultOpen ? 1 : 2;
        this.mPrevOrientation = resources.getConfiguration().orientation;
        this.mSlidingState = new SeslSlidingState();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void seslSetResizeChild(ArrayList<View> arrayList) {
        this.mSetResizeChild = true;
        if (this.mResizeChildList == null) {
            this.mResizeChildList = new ArrayList<>();
        }
        this.mResizeChildList = arrayList;
    }

    public boolean closePane() {
        this.mIsNeedOpen = false;
        this.mIsNeedClose = true;
        return closePane(0, true ^ shouldSkipScroll());
    }

    public boolean openPane() {
        this.mIsNeedOpen = true;
        this.mIsNeedClose = false;
        return openPane(0, true ^ shouldSkipScroll());
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SimplePanelSlideListener implements PanelSlideListener {
        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f) {
        }
    }
}
