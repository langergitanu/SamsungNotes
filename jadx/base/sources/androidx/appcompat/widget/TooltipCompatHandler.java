package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.reflect.hardware.input.SeslInputManagerReflector;
import androidx.reflect.provider.SeslSettingsReflector;
import androidx.reflect.view.SeslPointerIconReflector;
import androidx.reflect.view.SeslViewReflector;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    private static final long CHECK_IS_HOVER_HIDE_TIMEOUT_MS = 300;
    private static final long HOVER_HIDE_TIMEOUT_MS = 15000;
    private static final long HOVER_HIDE_TIMEOUT_SHORT_MS = 3000;
    private static final long LONG_CLICK_HIDE_TIMEOUT_MS = 2500;
    private static final String TAG = "TooltipCompatHandler";
    private static TooltipCompatHandler sActiveHandler = null;
    private static boolean sIsCustomTooltipPosition = false;
    private static boolean sIsForceActionBarX = false;
    private static boolean sIsForceBelow = false;
    private static boolean sIsTooltipNull = false;
    private static int sLayoutDirection;
    private static TooltipCompatHandler sPendingHandler;
    private static int sPosX;
    private static int sPosY;
    private final View mAnchor;
    private int mAnchorX;
    private int mAnchorY;
    private boolean mForceNextChangeSignificant;
    private boolean mFromTouch;
    private final int mHoverSlop;
    private int mLastOrientation;
    View.OnLayoutChangeListener mLayoutChangeListener;
    private TooltipPopup mPopup;
    private final CharSequence mTooltipText;
    private final Runnable mShowRunnable = new RunnableC0553n(this, 0);
    private final Runnable mHideRunnable = new RunnableC0553n(this, 1);
    private final Runnable mCheckHoverRunnable = new Runnable() { // from class: androidx.appcompat.widget.TooltipCompatHandler.1
        @Override // java.lang.Runnable
        public void run() {
            if (TooltipCompatHandler.this.mAnchor == null || TooltipCompatHandler.this.mAnchor.isHovered()) {
                return;
            }
            Log.i(TooltipCompatHandler.TAG, "isHovered is false. Hide!!");
            TooltipCompatHandler.this.hide();
        }
    };
    private boolean mIsSPenPointChanged = false;
    private boolean mIsShowRunnablePostDelayed = false;
    private int mLastHoverEvent = -1;
    private boolean mInitialWindowFocus = false;
    private boolean mIsForceExitDelay = false;

    private TooltipCompatHandler(View view, CharSequence charSequence) {
        this.mAnchor = view;
        this.mTooltipText = charSequence;
        this.mHoverSlop = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(view.getContext()));
        forceNextChangeSignificant();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void cancelPendingShow() {
        this.mAnchor.removeCallbacks(this.mShowRunnable);
    }

    private void forceNextChangeSignificant() {
        this.mForceNextChangeSignificant = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        show(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$1(Resources resources, View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        TooltipPopup tooltipPopup;
        if (resources.getConfiguration().orientation != this.mLastOrientation && (tooltipPopup = this.mPopup) != null && tooltipPopup.isShowing()) {
            hide();
        }
        this.mLastOrientation = resources.getConfiguration().orientation;
    }

    private void scheduleShow() {
        this.mAnchor.postDelayed(this.mShowRunnable, ViewConfiguration.getLongPressTimeout());
    }

    public static void seslSetTooltipForceActionBarPosX(boolean z) {
        sIsForceActionBarX = z;
    }

    public static void seslSetTooltipForceBelow(boolean z) {
        sIsForceBelow = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void seslSetTooltipNull(boolean z) {
        sIsTooltipNull = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void seslSetTooltipPosition(int i, int i2, int i4) {
        sLayoutDirection = i4;
        sPosX = i;
        sPosY = i2;
        sIsCustomTooltipPosition = true;
    }

    private static void setPendingHandler(TooltipCompatHandler tooltipCompatHandler) {
        TooltipCompatHandler tooltipCompatHandler2 = sPendingHandler;
        if (tooltipCompatHandler2 != null) {
            tooltipCompatHandler2.cancelPendingShow();
        }
        sPendingHandler = tooltipCompatHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.scheduleShow();
        }
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        if (view == null) {
            Log.i(TAG, "view is null");
            return;
        }
        sIsForceActionBarX = false;
        TooltipCompatHandler tooltipCompatHandler = sPendingHandler;
        if (tooltipCompatHandler != null && tooltipCompatHandler.mAnchor == view) {
            setPendingHandler(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new TooltipCompatHandler(view, charSequence);
            return;
        }
        TooltipCompatHandler tooltipCompatHandler2 = sActiveHandler;
        if (tooltipCompatHandler2 != null && tooltipCompatHandler2.mAnchor == view) {
            tooltipCompatHandler2.hide();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
        Context context = view.getContext();
        if (view.isEnabled() || context == null) {
            return;
        }
        SeslViewReflector.semSetPointerIcon(view, 2, PointerIcon.getSystemIcon(context, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_DEFAULT()));
    }

    private void showPenPointEffect(MotionEvent motionEvent, boolean z) {
        if (motionEvent.getToolType(0) == 2) {
            if (z) {
                SeslInputManagerReflector.setPointerIconType(SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_MORE());
                this.mIsSPenPointChanged = true;
            } else if (this.mIsSPenPointChanged) {
                SeslInputManagerReflector.setPointerIconType(SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_DEFAULT());
                this.mIsSPenPointChanged = false;
            }
        }
    }

    private boolean updateAnchorPos(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        if (!this.mForceNextChangeSignificant && Math.abs(x - this.mAnchorX) <= this.mHoverSlop && Math.abs(y2 - this.mAnchorY) <= this.mHoverSlop) {
            return false;
        }
        this.mAnchorX = x;
        this.mAnchorY = y2;
        this.mForceNextChangeSignificant = false;
        return true;
    }

    public void hide() {
        if (sActiveHandler == this) {
            sActiveHandler = null;
            TooltipPopup tooltipPopup = this.mPopup;
            if (tooltipPopup != null) {
                tooltipPopup.hide();
                this.mPopup = null;
                forceNextChangeSignificant();
                this.mAnchor.removeOnAttachStateChangeListener(this);
            } else {
                Log.e(TAG, "sActiveHandler.mPopup == null");
            }
        }
        this.mIsShowRunnablePostDelayed = false;
        if (sPendingHandler == this) {
            setPendingHandler(null);
        }
        this.mAnchor.removeCallbacks(this.mHideRunnable);
        if (!this.mFromTouch) {
            this.mAnchor.removeCallbacks(this.mCheckHoverRunnable);
            this.mAnchor.removeOnLayoutChangeListener(this.mLayoutChangeListener);
        }
        sPosX = 0;
        sPosY = 0;
        sIsTooltipNull = false;
        sIsCustomTooltipPosition = false;
    }

    public boolean isSPenHoveringSettingsEnabled() {
        return Settings.System.getInt(this.mAnchor.getContext().getContentResolver(), SeslSettingsReflector.SeslSystemReflector.getField_SEM_PEN_HOVERING(), 0) == 1;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.mPopup != null && this.mFromTouch) {
            return false;
        }
        if (this.mAnchor == null) {
            Log.i(TAG, "TooltipCompat Anchor view is null");
            return false;
        }
        Context context = view.getContext();
        if (motionEvent.isFromSource(InputDeviceCompat.SOURCE_STYLUS) && !isSPenHoveringSettingsEnabled()) {
            if (this.mAnchor.isEnabled() && this.mPopup != null && context != null) {
                SeslViewReflector.semSetPointerIcon(view, 2, PointerIcon.getSystemIcon(context, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_DEFAULT()));
            }
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.mAnchor.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        this.mLastHoverEvent = action;
        if (action != 7) {
            if (action == 9) {
                this.mInitialWindowFocus = this.mAnchor.hasWindowFocus();
                if (this.mAnchor.isEnabled() && this.mPopup == null && context != null) {
                    SeslViewReflector.semSetPointerIcon(view, 2, PointerIcon.getSystemIcon(context, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_MORE()));
                }
            } else if (action == 10) {
                Log.i(TAG, "MotionEvent.ACTION_HOVER_EXIT : hide SeslTooltipPopup");
                if (this.mAnchor.isEnabled() && this.mPopup != null && context != null) {
                    SeslViewReflector.semSetPointerIcon(view, 2, PointerIcon.getSystemIcon(context, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_DEFAULT()));
                }
                TooltipPopup tooltipPopup = this.mPopup;
                if (tooltipPopup == null || !tooltipPopup.isShowing() || Math.abs(motionEvent.getX() - this.mAnchorX) >= 4.0f || Math.abs(motionEvent.getY() - this.mAnchorY) >= 4.0f) {
                    hide();
                } else {
                    this.mIsForceExitDelay = true;
                    this.mAnchor.removeCallbacks(this.mHideRunnable);
                    this.mAnchor.postDelayed(this.mHideRunnable, LONG_CLICK_HIDE_TIMEOUT_MS);
                }
            }
        } else if (this.mAnchor.isEnabled() && this.mPopup == null && updateAnchorPos(motionEvent)) {
            this.mAnchorX = (int) motionEvent.getX();
            this.mAnchorY = (int) motionEvent.getY();
            if (!this.mIsShowRunnablePostDelayed || this.mIsForceExitDelay) {
                setPendingHandler(this);
                this.mIsForceExitDelay = false;
                this.mIsShowRunnablePostDelayed = true;
            }
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.mAnchorX = view.getWidth() / 2;
        this.mAnchorY = view.getHeight() / 2;
        show(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        hide();
    }

    public void show(boolean z) {
        long longPressTimeout;
        long j;
        long j2;
        if (this.mAnchor.isAttachedToWindow()) {
            setPendingHandler(null);
            TooltipCompatHandler tooltipCompatHandler = sActiveHandler;
            if (tooltipCompatHandler != null) {
                tooltipCompatHandler.hide();
            }
            sActiveHandler = this;
            this.mFromTouch = z;
            TooltipPopup tooltipPopup = new TooltipPopup(this.mAnchor.getContext());
            this.mPopup = tooltipPopup;
            if (sIsCustomTooltipPosition) {
                sIsForceBelow = false;
                sIsForceActionBarX = false;
                if (sIsTooltipNull && !z) {
                    return;
                }
                tooltipPopup.showActionItemTooltip(sPosX, sPosY, sLayoutDirection, this.mTooltipText);
                sIsCustomTooltipPosition = false;
            } else {
                if (sIsTooltipNull) {
                    return;
                }
                boolean z2 = sIsForceBelow;
                if (z2 || sIsForceActionBarX) {
                    tooltipPopup.show(this.mAnchor, this.mAnchorX, this.mAnchorY, this.mFromTouch, this.mTooltipText, z2, sIsForceActionBarX);
                    sIsForceBelow = false;
                    sIsForceActionBarX = false;
                } else {
                    tooltipPopup.show(this.mAnchor, this.mAnchorX, this.mAnchorY, this.mFromTouch, this.mTooltipText);
                }
            }
            final Resources resources = this.mAnchor.getContext().getResources();
            this.mLastOrientation = resources.getConfiguration().orientation;
            View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: androidx.appcompat.widget.m
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                    this.f958a.lambda$show$1(resources, view, i, i2, i4, i5, i6, i7, i8, i9);
                }
            };
            this.mLayoutChangeListener = onLayoutChangeListener;
            this.mAnchor.addOnLayoutChangeListener(onLayoutChangeListener);
            this.mAnchor.addOnAttachStateChangeListener(this);
            if (this.mFromTouch) {
                j2 = LONG_CLICK_HIDE_TIMEOUT_MS;
            } else {
                if ((ViewCompat.getWindowSystemUiVisibility(this.mAnchor) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 15000;
                }
                j2 = j - longPressTimeout;
            }
            this.mAnchor.removeCallbacks(this.mHideRunnable);
            this.mAnchor.postDelayed(this.mHideRunnable, j2);
            if (!this.mFromTouch) {
                this.mAnchor.removeCallbacks(this.mCheckHoverRunnable);
                this.mAnchor.postDelayed(this.mCheckHoverRunnable, 300L);
            }
            if (this.mLastHoverEvent != 7 || this.mAnchor.hasWindowFocus() || this.mInitialWindowFocus == this.mAnchor.hasWindowFocus()) {
                return;
            }
            hide();
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
