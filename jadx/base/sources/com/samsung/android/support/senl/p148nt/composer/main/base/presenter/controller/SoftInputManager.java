package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.glance.AbstractC2821a;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import p001A.AbstractC0000a;
import p022E1.RunnableC0080f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SoftInputManager {
    private static final String DEFAULT_BLOCK_TO_SHOW_KEY = "BlockToShow";
    public static final int DEFAULT_DELAY = 200;
    private static final long FORCE_TO_SHOW_INPUT_RETRY_INTERVAL = 100;
    private static final int LOCK_CONTENT_TOUCH_INVALID_VALUE = -1;
    private static final int SOFT_INPUT_INVALID_VALUE = -1;
    private static final String TAG = Logger.createTag("SoftInputManager");
    private Activity mActivity;
    private boolean mBlockHideFlag;
    private boolean mClearSkip;
    private View mCompView;
    private View mContainerLockView;
    private int mContentViewPaddingBottom;
    private int mContentViewPaddingLeft;
    private int mContentViewPaddingRight;
    private int mContentViewPaddingTop;
    private Runnable mDelayHideRunnable;
    private Runnable mForceToShowRunnable;
    private Handler mHandler;
    private boolean mIsAppResumedWithSip;
    private boolean mIsLockViewEnabled;
    private boolean mLastState;
    private View mLockContentView;
    private View mLockView;
    private OnCalledShowMethodListener mOnCalledShowMethodListener;
    private SipDetector mSipDetector;
    private SipVisibilityListener mSipVisibilityListener;
    private int mWindowMode;
    private int mForceToShowInputTryCount = 0;
    private final List<OnSipListener> mOnSipListenerList = new ArrayList(3);
    private final Set<String> mBlockShowKeySet = new HashSet();
    private final Set<String> mBlockHideKeySet = new HashSet();
    private final AtomicBoolean mIsWindowInsetsAnimating = new AtomicBoolean(false);
    private int mTemporarySoftInputMode = -1;
    private float mTouchRawY = -1.0f;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnCalledShowMethodListener {
        void onCalledShow();

        void onShowSip();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSipListener {
        void onHide();

        void onShow();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SipDetector implements ViewTreeObserver.OnGlobalLayoutListener {
        private static final int HIDE_HEIGHT_BASE = 10;
        private int beforeHeight;
        private final int idStatusBarHeight;
        private boolean isSipVisible;
        private final String TAG = Logger.createTag("SipDetector");
        private boolean isSipUpdated = false;

        public SipDetector() {
            this.idStatusBarHeight = SoftInputManager.this.mActivity.getResources().getIdentifier("status_bar_height", AbsExecuteBinding.TYPE_DIMEN, TelemetryEventStrings.C6439Os.OS_NAME);
            this.isSipVisible = SoftInputManager.this.isInputMethodShown();
        }

        private int getScreenHeight() {
            Point point = new Point();
            SoftInputManager.this.mActivity.getWindowManager().getDefaultDisplay().getSize(point);
            return point.y;
        }

        private int getVisibleHeight() {
            Rect rect = new Rect();
            SoftInputManager.this.mActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            return rect.height();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void notifyListeners() {
            if (this.isSipUpdated) {
                AbstractC8014b.m7215q(new StringBuilder("notifyDirectly# isSipVisible="), this.isSipVisible, this.TAG);
                this.isSipUpdated = false;
                for (OnSipListener onSipListener : SoftInputManager.this.mOnSipListenerList) {
                    if (this.isSipVisible) {
                        onSipListener.onShow();
                    } else {
                        onSipListener.onHide();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateSipVisibility(boolean z) {
            this.isSipVisible = z;
            this.isSipUpdated = true;
            if (SoftInputManager.this.mSipVisibilityListener != null) {
                SoftInputManager.this.mSipVisibilityListener.onSipVisibilityChanged(z);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (SoftInputManager.this.mOnSipListenerList.isEmpty() || SoftInputManager.this.mActivity == null || SoftInputManager.this.mActivity.getWindow() == null || FeatureInfo.isWindowInsetsAnimationWithSipEnabled()) {
                return;
            }
            int screenHeight = getScreenHeight();
            int visibleHeight = getVisibleHeight();
            int i = screenHeight - visibleHeight;
            if (!SoftInputManager.this.mActivity.isInMultiWindowMode() && this.idStatusBarHeight > 0) {
                try {
                    int dimensionPixelSize = SoftInputManager.this.mActivity.getResources().getDimensionPixelSize(this.idStatusBarHeight);
                    if (dimensionPixelSize > 0) {
                        i -= dimensionPixelSize;
                    }
                } catch (Resources.NotFoundException unused) {
                }
            }
            if (SoftInputManager.this.mWindowMode == 0) {
                if (i <= 10 && this.beforeHeight != i) {
                    AbstractC8014b.m7221w(AbstractC0622a.m1173s(screenHeight, visibleHeight, "window: ", " view: ", " before: "), this.TAG, this.beforeHeight);
                    updateSipVisibility(false);
                } else if (i > 10 && this.beforeHeight <= 10) {
                    AbstractC8014b.m7221w(AbstractC0622a.m1173s(screenHeight, visibleHeight, "window: ", " view: ", " before: "), this.TAG, this.beforeHeight);
                    updateSipVisibility(true);
                }
                this.beforeHeight = i;
            } else {
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(SoftInputManager.this.mActivity.getWindow().getDecorView());
                if (rootWindowInsets == null) {
                    Logger.m10999d(this.TAG, "onGlobalLayout# WindowInsets is null.");
                    return;
                }
                updateSipVisibility(rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime()));
            }
            notifyListeners();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SipVisibilityListener {
        void onSipVisibilityChanged(boolean z);
    }

    @RequiresApi(api = 30)
    private WindowInsetsAnimation$Callback contentViewWindowInsetsAnimationCallback(final View view) {
        return new WindowInsetsAnimation$Callback(0) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.3
            public void onEnd(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
                View view2 = view;
                if (view2 != null) {
                    SoftInputManager softInputManager = SoftInputManager.this;
                    softInputManager.setBottomPadding(view2, softInputManager.getImeHeight(view2.getRootWindowInsets()), true);
                    SoftInputManager.this.mIsWindowInsetsAnimating.set(false);
                    SoftInputManager.this.mTemporarySoftInputMode = -1;
                    SoftInputManager.this.updateLockView(view.getPaddingBottom() > SoftInputManager.this.mContentViewPaddingBottom);
                    SoftInputManager.this.mSipDetector.notifyListeners();
                }
            }

            public void onPrepare(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
                SoftInputManager.this.mIsWindowInsetsAnimating.set(true);
            }

            @NonNull
            public WindowInsets onProgress(@NonNull WindowInsets windowInsets, @NonNull List<WindowInsetsAnimation> list) {
                return windowInsets;
            }

            @NonNull
            public WindowInsetsAnimation.Bounds onStart(@NonNull WindowInsetsAnimation windowInsetsAnimation, @NonNull WindowInsetsAnimation.Bounds bounds) {
                View view2 = view;
                if (view2 != null && view2.getPaddingBottom() != SoftInputManager.this.mContentViewPaddingBottom && bounds.getUpperBound().bottom > 0) {
                    SoftInputManager.this.setBottomPadding(view, 0, false);
                }
                return bounds;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detectSipVisibilityChangeOnApplyWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        if (!FeatureInfo.isWindowInsetsAnimationWithSipEnabled()) {
            Logger.m11000e(TAG, "detectSipVisibilityChangeOnApplyWindowInsets# Ignored by Support Feature.");
            return;
        }
        boolean zIsVisible = windowInsetsCompat.isVisible(WindowInsetsCompat.Type.ime());
        if (zIsVisible != this.mSipDetector.isSipVisible) {
            AbstractC8014b.m7220v("detectSipVisibilityChangeOnApplyWindowInsets# ", TAG, zIsVisible);
            this.mSipDetector.updateSipVisibility(zIsVisible);
            this.mSipDetector.notifyListeners();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 30)
    public int getImeHeight(WindowInsets windowInsets) {
        if (windowInsets == null) {
            return 0;
        }
        return Math.max(windowInsets.getInsets(WindowInsets.Type.ime()).bottom - windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom, 0);
    }

    private void initBottomPadding(Activity activity, int i) {
        if (!FeatureInfo.isWindowInsetsAnimationWithSipEnabled() || activity == null || activity.getWindow() == null) {
            Logger.m10999d(TAG, "initBottomPadding# Ignored by Support Feature : " + FeatureInfo.isWindowInsetsAnimationWithSipEnabled());
            return;
        }
        View viewFindViewById = activity.getWindow().getDecorView().findViewById(C9086R.id.main_container);
        if (viewFindViewById == null) {
            Logger.m10999d(TAG, "initBottomPadding# Ignored by invalid contentView.");
        } else {
            AbstractC0000a.m3D(i, "initBottomPadding# padding : ", TAG);
            setBottomPadding(viewFindViewById, i, false);
        }
    }

    private void initSipDetector(View view) {
        if (this.mSipDetector == null) {
            this.mSipDetector = new SipDetector();
        }
        if (FeatureInfo.isWindowInsetsAnimationWithSipEnabled()) {
            setWindowInsetCallback(this.mActivity);
        }
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.mSipDetector);
        }
    }

    private boolean isBlockingToHide() {
        return this.mBlockHideFlag || !this.mBlockHideKeySet.isEmpty();
    }

    private boolean isBlockingToShow() {
        return !this.mBlockShowKeySet.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$delayForceToShow$0(View view, long j) {
        this.mForceToShowRunnable = null;
        if (this.mDelayHideRunnable == null) {
            forceToShow(view, j);
        } else {
            Logger.m11003i(TAG, "delayForceToShow# mDelayHideRunnable is not null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$delayHide$1(View view) {
        this.mDelayHideRunnable = null;
        if (this.mForceToShowRunnable == null) {
            hide(view);
        } else {
            Logger.m11003i(TAG, "delayHide# mForceToShowRunnable is not null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setLockView$2(View view, MotionEvent motionEvent) {
        View view2 = this.mLockView;
        if (view2 == null || view2.getVisibility() == 8) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            View view3 = this.mContainerLockView;
            if (view3 != null && view3.getVisibility() == 0) {
                Logger.m10999d(TAG, "LockView#onTouch ContainerLockView.dispatchTouchEvent ACTION_DOWN");
                this.mContainerLockView.dispatchTouchEvent(motionEvent);
            }
            View view4 = this.mLockContentView;
            if (view4 != null && view4.getVisibility() == 0) {
                Logger.m10999d(TAG, "LockView#onTouch PageListView.dispatchTouchEvent ACTION_DOWN");
                this.mLockContentView.dispatchTouchEvent(motionEvent);
                this.mTouchRawY = motionEvent.getRawY();
            }
        } else if (action == 1) {
            String str = TAG;
            Logger.m10999d(str, "LockView#onTouch LockView gone");
            this.mLockView.setVisibility(8);
            View view5 = this.mLockContentView;
            if (view5 == null || view5.getVisibility() != 0 || this.mTouchRawY <= -1.0f) {
                hide(view);
            } else {
                Logger.m10999d(str, "LockView#onTouch RecentSearchListView.dispatchTouchEvent ACTION_UP");
                this.mLockContentView.dispatchTouchEvent(motionEvent);
            }
        } else if (action == 2 && this.mLockContentView != null && this.mTouchRawY > -1.0f && Math.abs(motionEvent.getRawY() - this.mTouchRawY) > 20.0f) {
            Logger.m10999d(TAG, "LockView#onTouch Scroll");
            this.mTouchRawY = -1.0f;
        }
        return true;
    }

    private void printBlockToShowList() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.mBlockShowKeySet.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append('\n');
        }
        Logger.m11003i(TAG, "show# block list: " + ((Object) sb));
    }

    private void releaseSipDetector(View view) {
        this.mOnSipListenerList.clear();
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mSipDetector);
        }
    }

    private void removeCallbackDelayHide() {
        if (this.mCompView == null || this.mDelayHideRunnable == null) {
            return;
        }
        Logger.m11003i(TAG, "removeCallbackDelayHide#");
        this.mCompView.removeCallbacks(this.mDelayHideRunnable);
        this.mDelayHideRunnable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBottomPadding(@NonNull View view, int i, boolean z) {
        View view2;
        Activity activity = this.mActivity;
        if (activity == null || activity.getWindow() == null || view.getPaddingBottom() == this.mContentViewPaddingBottom + i) {
            AbstractC0000a.m3D(i, "setBottomPadding# ignored by invalid status. padding : ", TAG);
            return;
        }
        int i2 = this.mActivity.getWindow().getAttributes().softInputMode;
        if (AiViewUtils.isSupportFloatingLayout()) {
            boolean z2 = i > 0;
            OnCalledShowMethodListener onCalledShowMethodListener = this.mOnCalledShowMethodListener;
            if (onCalledShowMethodListener != null && z2) {
                onCalledShowMethodListener.onShowSip();
            }
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder("setBottomPadding# padding : ");
        AbstractC2821a.m2235z(sb, this.mContentViewPaddingBottom, i, " + ", ", softInputMode : ");
        sb.append(Integer.toHexString(i2));
        Logger.m10999d(str, sb.toString());
        if ((z && this.mTemporarySoftInputMode == 16) || InputMethodCompat.getInstance().isKeyboardConnected(view.getContext()) || (FeatureInfo.isSoftInputModeAdjustResizeEnabled() && this.mWindowMode != 0)) {
            if ((i2 & 32) != 0) {
                this.mActivity.getWindow().setSoftInputMode((i2 & (-33)) | 16);
                Logger.m10999d(str, "setBottomPadding# softInputMode : " + Integer.toHexString(this.mActivity.getWindow().getAttributes().softInputMode));
            }
            if (FeatureInfo.isSoftInputModeAdjustResizeEnabled()) {
                AbstractC8014b.m7221w(new StringBuilder("setBottomPadding# Initialize padding : "), str, this.mContentViewPaddingBottom);
                i = 0;
            }
        } else if ((i2 & 16) != 0) {
            this.mActivity.getWindow().setSoftInputMode((i2 & (-17)) | 32);
            Logger.m10999d(str, "setBottomPadding# softInputMode : " + Integer.toHexString(this.mActivity.getWindow().getAttributes().softInputMode));
        }
        view.setPadding(this.mContentViewPaddingLeft, this.mContentViewPaddingTop, this.mContentViewPaddingRight, this.mContentViewPaddingBottom + i);
        if (FeatureInfo.isNotEnabledDeltaDA() && i == 0 && (view2 = this.mLockView) != null && view2.getVisibility() == 0) {
            Logger.m10999d(str, "setBottomPadding# LockView gone");
            this.mLockView.setVisibility(8);
        }
    }

    private void setLockView() {
        if (FeatureInfo.isNotEnabledDeltaDA() && this.mIsLockViewEnabled) {
            this.mContainerLockView = this.mActivity.findViewById(C9086R.id.composer_fragment_container_lock);
            View viewFindViewById = this.mActivity.findViewById(C9086R.id.composer_fragment_container_sip_lock);
            this.mLockView = viewFindViewById;
            if (viewFindViewById != null) {
                Logger.m10999d(TAG, "setLockView#setOnTouchListener");
                this.mLockView.setOnTouchListener(new ViewOnTouchListenerC4799j(this, 17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLockView(boolean z) {
        View view;
        if (FeatureInfo.isNotEnabledDeltaDA() && (view = this.mLockView) != null) {
            int visibility = view.getVisibility();
            if (this.mIsLockViewEnabled && visibility == 8 && z) {
                Logger.m10999d(TAG, "updateLockView# visible");
                this.mLockView.setVisibility(0);
            } else if (visibility == 0) {
                Logger.m10999d(TAG, "updateLockView# gone");
                this.mLockView.setVisibility(8);
            }
        }
    }

    public void addOnSipListener(OnSipListener onSipListener) {
        Logger.m10999d(TAG, "addOnSipListener# " + onSipListener.hashCode());
        if (this.mOnSipListenerList.contains(onSipListener)) {
            return;
        }
        this.mOnSipListenerList.add(onSipListener);
    }

    public void blockToHide(boolean z) {
        AbstractC8014b.m7220v("blockToHide# ", TAG, z);
        this.mBlockHideFlag = z;
    }

    public void blockToShow(boolean z, String str) {
        Logger.m10999d(TAG, "blockToShow# " + z + " cause: " + str);
        if (z) {
            this.mBlockShowKeySet.add(DEFAULT_BLOCK_TO_SHOW_KEY);
        } else {
            this.mBlockShowKeySet.remove(DEFAULT_BLOCK_TO_SHOW_KEY);
        }
    }

    public void clearLastState() {
        Logger.m10999d(TAG, "clearLastState#");
        this.mLastState = false;
    }

    public void delayForceToShow(View view, long j) {
        if (this.mCompView == null) {
            Logger.m11003i(TAG, "delayForceToShow# mCompView is null.");
            return;
        }
        Logger.m11003i(TAG, "delayForceToShow# " + j);
        removeCallbackForceToShow();
        RunnableC0080f runnableC0080f = new RunnableC0080f(this, view, j, 2);
        this.mForceToShowRunnable = runnableC0080f;
        this.mCompView.postDelayed(runnableC0080f, j);
    }

    public void delayHide(View view, long j) {
        if (this.mCompView == null) {
            Logger.m11003i(TAG, "delayHide# mCompView is null.");
            return;
        }
        if (isBlockingToHide()) {
            Logger.m11003i(TAG, "delayHide# mBlockHideFlag is true.");
            return;
        }
        Logger.m11003i(TAG, "delayHide# " + j);
        removeCallbackDelayHide();
        RunnableC8515c runnableC8515c = new RunnableC8515c(this, view, 23);
        this.mDelayHideRunnable = runnableC8515c;
        this.mCompView.postDelayed(runnableC8515c, j);
    }

    public void forceToShow(final View view, final long j) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        if (isBlockingToShow()) {
            Logger.m10999d(TAG, "show# sip is blocked");
            printBlockToShowList();
            return;
        }
        if (view == null && (view = this.mActivity.getWindow().getCurrentFocus()) == null) {
            Logger.m11004w(TAG, "forceToShow# view is null");
            return;
        }
        Logger.m10999d(TAG, "forceToShow#");
        if (InputMethodCompat.getInstance().isEnabledMobileKeyboard(this.mActivity)) {
            InputMethodCompat.getInstance().showSoftInput(this.mActivity, view);
        } else {
            if (InputMethodCompat.getInstance().showSoftInput(this.mActivity, view)) {
                return;
            }
            this.mForceToShowInputTryCount = 1;
            view.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SoftInputManager.this.mActivity == null || SoftInputManager.this.mActivity.isDestroyed()) {
                        Logger.m11003i(SoftInputManager.TAG, "forceToShow# mActivity is null or destoried");
                        return;
                    }
                    Logger.m11003i(SoftInputManager.TAG, "forceToShow# delay " + SoftInputManager.this.mForceToShowInputTryCount);
                    if (!InputMethodCompat.getInstance().showSoftInput(SoftInputManager.this.mActivity, view) && ((long) SoftInputManager.this.mForceToShowInputTryCount) * 100 < j) {
                        SoftInputManager.this.mForceToShowInputTryCount++;
                        view.postDelayed(this, 100L);
                    }
                }
            }, 100L);
        }
    }

    public boolean getLastSipState() {
        return this.mLastState;
    }

    public void hide(View view) {
        hide(this.mActivity, view);
    }

    public void hideAndExecute(Runnable runnable) {
        if (!isInputMethodShown()) {
            runnable.run();
        } else {
            hide(this.mCompView);
            this.mHandler.postDelayed(runnable, 200L);
        }
    }

    public boolean isClearSkip() {
        return this.mClearSkip;
    }

    public boolean isInputMethodShown() {
        if (!CommonUtil.isAvailableActivity(this.mActivity)) {
            return false;
        }
        InputMethodCompat inputMethodCompat = InputMethodCompat.getInstance();
        Activity activity = this.mActivity;
        return inputMethodCompat.isInputMethodShown(activity, activity.getWindow().getDecorView(), inputMethodCompat.isEnabledMobileKeyboard(this.mActivity));
    }

    public boolean isShowImeEnabled() {
        if (!CommonUtil.isAvailableActivity(this.mActivity)) {
            return false;
        }
        InputMethodCompat inputMethodCompat = InputMethodCompat.getInstance();
        return !inputMethodCompat.isKeyboardConnected(this.mActivity) || inputMethodCompat.isShowImeWithHardKeyboardEnabled(this.mActivity);
    }

    public boolean isSipShowing() {
        SipDetector sipDetector = this.mSipDetector;
        if (sipDetector != null) {
            return sipDetector.isSipVisible;
        }
        Logger.m10999d(TAG, "isSipShowing# mSipDetector is null");
        return false;
    }

    public void minimizeSoftInput(View view) {
        AbstractC8014b.m7215q(new StringBuilder("minimizeSoftInput# "), isBlockingToHide(), TAG);
        if (isBlockingToHide() || this.mActivity == null) {
            return;
        }
        if (FeatureInfo.isNotEnabledDeltaDA() || !SystemPropertiesCompat.INSTANCE.getInstance().isUSAModel()) {
            hide(view);
            return;
        }
        InputMethodCompat.getInstance().minimizeSoftInput(this.mActivity, view, true);
        this.mTemporarySoftInputMode = -1;
        initBottomPadding(this.mActivity, InputMethodCompat.getInstance().getInputMethodWindowVisibleHeight(view.getContext()));
    }

    public void onAttachView(Activity activity, View view) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mActivity = activity;
        this.mCompView = view;
        this.mBlockShowKeySet.clear();
        this.mBlockHideFlag = false;
        this.mBlockHideKeySet.clear();
        this.mIsAppResumedWithSip = false;
        this.mIsLockViewEnabled = false;
        this.mTemporarySoftInputMode = -1;
        this.mIsWindowInsetsAnimating.set(false);
        initSipDetector(view);
    }

    public void onDetachView() {
        removeCallbackForceToShow();
        removeCallbackDelayHide();
        releaseSipDetector(this.mCompView);
        this.mActivity = null;
        this.mCompView = null;
        this.mLastState = false;
        this.mContentViewPaddingBottom = 0;
        this.mIsWindowInsetsAnimating.set(false);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void onPause() {
        if (!this.mLastState) {
            this.mLastState = isInputMethodShown() || isSipShowing();
        }
        AbstractC8014b.m7215q(new StringBuilder("onPause. "), this.mLastState, TAG);
    }

    public void onResume() {
        AbstractC8014b.m7215q(new StringBuilder("onResume. "), this.mLastState, TAG);
        if (this.mLastState) {
            this.mIsAppResumedWithSip = true;
        }
    }

    public void removeCallbackForceToShow() {
        if (this.mCompView == null || this.mForceToShowRunnable == null) {
            return;
        }
        Logger.m11003i(TAG, "removeCallbackForceToShow#");
        this.mCompView.removeCallbacks(this.mForceToShowRunnable);
        this.mForceToShowRunnable = null;
    }

    public void removeOnSipListener(OnSipListener onSipListener) {
        Logger.m10999d(TAG, "removeOnSipListener# " + onSipListener.hashCode());
        this.mOnSipListenerList.remove(onSipListener);
        if (isInputMethodShown()) {
            return;
        }
        initBottomPadding(this.mActivity);
    }

    public void setClearSkip(boolean z) {
        this.mClearSkip = z;
    }

    public void setLockViewEnabled(boolean z, @Nullable View view) {
        if (FeatureInfo.isNotEnabledDeltaDA()) {
            this.mIsLockViewEnabled = z;
            if (z && view != null) {
                Logger.m10999d(TAG, "setLockViewEnabled# setLockView");
                this.mLockContentView = view;
                setLockView();
                return;
            }
            View view2 = this.mLockView;
            if (view2 != null && view2.getVisibility() != 8) {
                Logger.m10999d(TAG, "setLockViewEnabled# LockView gone");
                this.mLockView.setVisibility(8);
            }
            this.mLockView = null;
            this.mLockContentView = null;
        }
    }

    public void setOnCalledShowMethodListener(OnCalledShowMethodListener onCalledShowMethodListener) {
        this.mOnCalledShowMethodListener = onCalledShowMethodListener;
    }

    public void setSipVisibilityListener(SipVisibilityListener sipVisibilityListener) {
        this.mSipVisibilityListener = sipVisibilityListener;
    }

    public void setTemporarySoftInputMode(int i) {
        if (i != 16) {
            return;
        }
        String str = TAG;
        Logger.m10999d(str, "setTemporarySoftInputMode# softInputMode prev : " + Integer.toHexString(i));
        this.mTemporarySoftInputMode = i;
        int i2 = this.mActivity.getWindow().getAttributes().softInputMode;
        if (this.mTemporarySoftInputMode == 16) {
            if ((i2 & 32) != 0) {
                this.mActivity.getWindow().setSoftInputMode((i2 & (-33)) | 16);
                initBottomPadding(this.mActivity, 0);
            }
            Logger.m10999d(str, "setTemporarySoftInputMode# softInputMode result : " + Integer.toHexString(this.mActivity.getWindow().getAttributes().softInputMode));
        }
    }

    @RequiresApi(api = 30)
    public void setWindowInsetCallback(Activity activity) {
        if (activity == null || activity.getWindow() == null) {
            Logger.m10999d(TAG, "setWindowInsetCallback# Ignored by invalid status.");
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        final View viewFindViewById = decorView.findViewById(C9086R.id.main_container);
        if (viewFindViewById == null) {
            Logger.m10999d(TAG, "setWindowInsetCallback# Ignored by invalid contentView.");
            return;
        }
        this.mContentViewPaddingLeft = viewFindViewById.getPaddingLeft();
        this.mContentViewPaddingTop = viewFindViewById.getPaddingTop();
        this.mContentViewPaddingRight = viewFindViewById.getPaddingRight();
        this.mContentViewPaddingBottom = viewFindViewById.getPaddingBottom();
        String str = TAG;
        StringBuilder sb = new StringBuilder("setWindowInsetCallback# setWindowInsetsAnimationCallback. padding : ");
        sb.append(this.mContentViewPaddingLeft);
        sb.append(SQLKeyword.COMMA);
        sb.append(this.mContentViewPaddingTop);
        sb.append(SQLKeyword.COMMA);
        sb.append(this.mContentViewPaddingRight);
        sb.append(SQLKeyword.COMMA);
        AbstractC8014b.m7221w(sb, str, this.mContentViewPaddingBottom);
        decorView.setWindowInsetsAnimationCallback(contentViewWindowInsetsAnimationCallback(viewFindViewById));
        ViewCompat.setOnApplyWindowInsetsListener(decorView, new OnApplyWindowInsetsListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            @NonNull
            public WindowInsetsCompat onApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime());
                if (!SoftInputManager.this.mIsWindowInsetsAnimating.get()) {
                    Logger.m10999d(SoftInputManager.TAG, "onApplyWindowInsets# Insets ime : " + insets2 + ", systemBars : " + insets + ", ime visibility: " + view.getRootWindowInsets().isVisible(WindowInsets.Type.ime()) + ", windowMode : " + SoftInputManager.this.mWindowMode);
                    if (SoftInputManager.this.mIsAppResumedWithSip && SoftInputManager.this.isShowImeEnabled() && !view.getRootWindowInsets().isVisible(WindowInsets.Type.ime()) && SoftInputManager.this.mWindowMode == 0) {
                        Logger.m10999d(SoftInputManager.TAG, "onApplyWindowInsets# ime is not visible. isAppResumedWithSip : " + SoftInputManager.this.mIsAppResumedWithSip);
                    } else {
                        int i = insets2.bottom;
                        int i2 = insets.bottom;
                        if (i >= i2 && i - i2 != viewFindViewById.getPaddingBottom()) {
                            SoftInputManager.this.setBottomPadding(viewFindViewById, insets2.bottom - insets.bottom, false);
                        } else if (insets2.bottom == 0) {
                            SoftInputManager.this.setBottomPadding(viewFindViewById, 0, false);
                        }
                        if (SoftInputManager.this.mIsAppResumedWithSip) {
                            Logger.m10999d(SoftInputManager.TAG, "onApplyWindowInsets# reset isAppResumedWithSip to false");
                            SoftInputManager.this.mIsAppResumedWithSip = false;
                        }
                    }
                }
                SoftInputManager.this.detectSipVisibilityChangeOnApplyWindowInsets(windowInsetsCompat);
                return WindowInsetsCompat.toWindowInsetsCompat(view.onApplyWindowInsets(windowInsetsCompat.toWindowInsets()));
            }
        });
        setLockView();
    }

    public void setWindowMode(int i) {
        this.mWindowMode = i;
    }

    public void show(View view) {
        show(this.mActivity, view);
    }

    public void hide(Activity activity, View view) {
        String str = TAG;
        Logger.m10999d(str, "hide# " + isBlockingToHide() + " " + activity + " / " + view);
        if (activity == null || isBlockingToHide()) {
            return;
        }
        if (view == null && (view = activity.getWindow().getCurrentFocus()) == null) {
            Logger.m11004w(str, "hide# view is null");
            return;
        }
        removeCallbackForceToShow();
        InputMethodCompat.getInstance().hideSoftInput(activity, view);
        initBottomPadding(activity);
    }

    public void show(Activity activity, View view) {
        boolean zShowSoftInput;
        OnCalledShowMethodListener onCalledShowMethodListener;
        String str = TAG;
        Logger.m10999d(str, "show# " + activity + " / " + view);
        if (isBlockingToShow()) {
            Logger.m10999d(str, "show# sip is blocked");
            printBlockToShowList();
            return;
        }
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        if (view == null && (view = activity.getWindow().getCurrentFocus()) == null) {
            Logger.m11004w(str, "show# view is null");
            return;
        }
        removeCallbackDelayHide();
        if (InputMethodCompat.getInstance().isEnabledMobileKeyboard(activity)) {
            zShowSoftInput = InputMethodCompat.getInstance().showSoftInput(activity, view);
        } else {
            if (SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel() && InputMethodCompat.getInstance().isInputMethodShown(activity, activity.getWindow().getDecorView(), false)) {
                Intent intent = new Intent();
                intent.setAction("imeAction:ShowVirtualKeyboard");
                activity.sendBroadcast(intent);
                Logger.m10999d(str, "sendBroadcast - " + intent.getAction());
            }
            InputMethodCompat inputMethodCompat = InputMethodCompat.getInstance();
            DesktopModeCompat.Companion companion = DesktopModeCompat.INSTANCE;
            zShowSoftInput = inputMethodCompat.showSoftInput(activity, view, companion.getInstance().isDexDualModeOnScreen(activity) || companion.getInstance().isDexStandAloneMode(activity));
        }
        if (!zShowSoftInput || (onCalledShowMethodListener = this.mOnCalledShowMethodListener) == null) {
            return;
        }
        onCalledShowMethodListener.onCalledShow();
    }

    public void blockToShow(String str, boolean z, String str2) {
        AbstractC8014b.m7213o(AbstractC2821a.m2229t("blockToShow# ", str, ": ", z, " cause: "), str2, TAG);
        if (z) {
            this.mBlockShowKeySet.add(str);
        } else {
            this.mBlockShowKeySet.remove(str);
        }
    }

    public void blockToHide(String str, boolean z, String str2) {
        AbstractC8014b.m7213o(AbstractC2821a.m2229t("blockToHide# ", str, ": ", z, " cause: "), str2, TAG);
        if (z) {
            this.mBlockHideKeySet.add(str);
        } else {
            this.mBlockHideKeySet.remove(str);
        }
    }

    public void hide(boolean z) {
        if (z) {
            if (InputMethodCompat.getInstance().isEnabledMobileKeyboard(this.mActivity)) {
                return;
            }
            hide(this.mCompView);
            return;
        }
        hide(this.mCompView);
    }

    public void initBottomPadding(Activity activity) {
        this.mTemporarySoftInputMode = -1;
        initBottomPadding(activity, 0);
    }

    public void show(boolean z) {
        if (z) {
            if (InputMethodCompat.getInstance().isEnabledMobileKeyboard(this.mActivity)) {
                return;
            }
            show(this.mCompView);
            return;
        }
        show(this.mCompView);
    }
}
