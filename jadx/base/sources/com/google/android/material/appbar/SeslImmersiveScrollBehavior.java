package com.google.android.material.appbar;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.WindowInsetsController$OnControllableInsetsChangedListener;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.util.SeslDisplayUtils;
import androidx.reflect.view.SeslDecorViewReflector;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.material.C4548R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.SeslContextUtils;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(api = 30)
public final class SeslImmersiveScrollBehavior extends AppBarLayout.Behavior {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MSG_APPEAR_ANIMATION = 100;
    private static final String TAG = "SeslImmersiveScrollBehavior";
    private boolean isRoundedCornerHide;
    private WindowInsetsAnimationController mAnimationController;
    private final Handler mAnimationHandler;
    private AppBarLayout mAppBarLayout;
    private View mBottomArea;
    boolean mCalledHideShowOnLayoutChild;
    private boolean mCanImmersiveScroll;
    private CancellationSignal mCancellationSignal;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private View mContentView;
    private Context mContext;
    private CoordinatorLayout mCoordinatorLayout;
    private float mCurOffset;
    private WindowInsetsAnimation$Callback mCustomWindowInsetsAnimation;
    private View mDecorView;
    private WindowInsets mDecorViewInset;
    private boolean mIsMultiWindow;
    private boolean mIsSetAutoRestore;
    private View mNavigationBarBg;
    private int mNavigationBarBgHeight;
    private int mNavigationBarFrameHeight;
    private boolean mNeedInit;
    private boolean mNeedRestoreAnim;
    private boolean mNeedToCheckBottomViewMargin;
    private ValueAnimator mOffsetAnimator;
    private final AppBarLayout.OnOffsetChangedListener mOffsetChangedListener;
    private WindowInsetsController$OnControllableInsetsChangedListener mOnInsetsChangedListener;
    private int mPrevOffset;
    private int mPrevOrientation;
    private boolean mShownAtDown;
    private View mStatusBarBg;
    private int mStatusBarHeight;
    private View mTargetView;
    private boolean mToolIsMouse;
    private final WindowInsetsAnimation$Callback mWindowAnimationCallback;
    private final WindowInsetsAnimationControlListener mWindowInsetsAnimationControlListener;
    private WindowInsetsController mWindowInsetsController;
    private boolean useCustomAnimationCallback;

    public SeslImmersiveScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mNeedToCheckBottomViewMargin = false;
        this.mCurOffset = 0.0f;
        this.mCanImmersiveScroll = true;
        this.mWindowInsetsController = null;
        this.mOnInsetsChangedListener = null;
        this.useCustomAnimationCallback = false;
        this.mCustomWindowInsetsAnimation = null;
        this.mNeedRestoreAnim = true;
        this.mIsSetAutoRestore = true;
        this.isRoundedCornerHide = false;
        this.mCalledHideShowOnLayoutChild = false;
        this.mNeedInit = false;
        this.mAnimationHandler = new Handler(Looper.getMainLooper()) { // from class: com.google.android.material.appbar.SeslImmersiveScrollBehavior.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 100) {
                    SeslImmersiveScrollBehavior.this.startRestoreAnimation();
                }
            }
        };
        this.mOffsetChangedListener = new AppBarLayout.OnOffsetChangedListener() { // from class: com.google.android.material.appbar.SeslImmersiveScrollBehavior.2
            /* JADX WARN: Removed duplicated region for block: B:88:0x026f  */
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float height;
                float fMax;
                int totalScrollRange;
                if ((SeslImmersiveScrollBehavior.this.mAppBarLayout != null && SeslImmersiveScrollBehavior.this.mAppBarLayout.isDetachedState()) || SeslImmersiveScrollBehavior.this.useCustomAnimationCallback) {
                    Log.e(SeslImmersiveScrollBehavior.TAG, "AppBarLayout was DetachedState. Skip onOffsetChanged");
                    return;
                }
                int i2 = 0;
                float height2 = 0.0f;
                if (!SeslImmersiveScrollBehavior.this.mCanImmersiveScroll) {
                    if (SeslImmersiveScrollBehavior.this.mStatusBarBg != null) {
                        SeslImmersiveScrollBehavior.this.mStatusBarBg.setTranslationY(0.0f);
                    }
                    if (SeslImmersiveScrollBehavior.this.mNavigationBarBg != null) {
                        SeslImmersiveScrollBehavior.this.mNavigationBarBg.setTranslationY(0.0f);
                    }
                    if (SeslImmersiveScrollBehavior.this.mBottomArea != null) {
                        if (!SeslImmersiveScrollBehavior.this.mNeedToCheckBottomViewMargin || SeslImmersiveScrollBehavior.this.mDecorView == null) {
                            SeslImmersiveScrollBehavior.this.mBottomArea.setTranslationY(0.0f);
                        } else {
                            SeslImmersiveScrollBehavior seslImmersiveScrollBehavior = SeslImmersiveScrollBehavior.this;
                            seslImmersiveScrollBehavior.mDecorViewInset = seslImmersiveScrollBehavior.mDecorView.getRootWindowInsets();
                            if (SeslImmersiveScrollBehavior.this.mDecorViewInset != null) {
                                SeslImmersiveScrollBehavior.this.mBottomArea.setTranslationY(-SeslImmersiveScrollBehavior.this.mDecorViewInset.getInsets(WindowInsets.Type.navigationBars()).bottom);
                            } else {
                                SeslImmersiveScrollBehavior.this.mBottomArea.setTranslationY(0.0f);
                            }
                        }
                    }
                    if (SeslImmersiveScrollBehavior.this.mAppBarLayout != null) {
                        SeslImmersiveScrollBehavior.this.mAppBarLayout.onImmOffsetChanged(0);
                        return;
                    }
                    return;
                }
                int height3 = SeslImmersiveScrollBehavior.this.mBottomArea != null ? SeslImmersiveScrollBehavior.this.mBottomArea.getHeight() : 0;
                float fSeslGetCollapsedHeight = appBarLayout.seslGetCollapsedHeight();
                float totalScrollRange2 = ((appBarLayout.getTotalScrollRange() - appBarLayout.seslGetAdditionalScrollRange()) + i) - fSeslGetCollapsedHeight;
                float f = SeslImmersiveScrollBehavior.this.mStatusBarHeight + totalScrollRange2;
                float f4 = ((SeslImmersiveScrollBehavior.this.mNavigationBarBgHeight + height3) / (fSeslGetCollapsedHeight == 0.0f ? 1.0f : fSeslGetCollapsedHeight)) * totalScrollRange2 * 2.0f;
                float fMin = Math.min(SeslImmersiveScrollBehavior.this.mStatusBarHeight, SeslImmersiveScrollBehavior.this.mStatusBarHeight + totalScrollRange2);
                float fMax2 = Math.max(Math.min(SeslImmersiveScrollBehavior.this.mNavigationBarBgHeight, SeslImmersiveScrollBehavior.this.mNavigationBarBgHeight + f4), 0.0f);
                if (appBarLayout.getBottom() > fSeslGetCollapsedHeight) {
                    float totalScrollRange3 = SeslImmersiveScrollBehavior.this.mAppBarLayout != null ? SeslImmersiveScrollBehavior.this.mAppBarLayout.getTotalScrollRange() + i : 0.0f;
                    if (SeslImmersiveScrollBehavior.this.mIsMultiWindow && SeslImmersiveScrollBehavior.this.mBottomArea != null) {
                        SeslImmersiveScrollBehavior.this.mBottomArea.setTranslationY(0.0f);
                        totalScrollRange3 += SeslImmersiveScrollBehavior.this.mBottomArea.getHeight();
                    }
                    height = totalScrollRange3;
                    if (!SeslImmersiveScrollBehavior.this.mIsMultiWindow && SeslImmersiveScrollBehavior.this.mBottomArea != null && SeslImmersiveScrollBehavior.this.mDecorViewInset != null) {
                        if (SeslImmersiveScrollBehavior.this.isNavigationBarBottomPosition()) {
                            SeslImmersiveScrollBehavior.this.mBottomArea.setTranslationY(-SeslImmersiveScrollBehavior.this.mNavigationBarBgHeight);
                            if (SeslImmersiveScrollBehavior.this.mNavigationBarBg != null && SeslImmersiveScrollBehavior.this.mNavigationBarBg.getTranslationY() != 0.0f) {
                                SeslImmersiveScrollBehavior.this.mNavigationBarBg.setTranslationY(0.0f);
                            }
                        } else if (SeslImmersiveScrollBehavior.this.mNavigationBarBg != null && SeslImmersiveScrollBehavior.this.mNavigationBarBg.getTranslationY() != 0.0f) {
                            SeslImmersiveScrollBehavior.this.mBottomArea.setTranslationY(0.0f);
                        }
                        height = height + SeslImmersiveScrollBehavior.this.mBottomArea.getHeight() + SeslImmersiveScrollBehavior.this.mNavigationBarBgHeight;
                    }
                } else if (SeslImmersiveScrollBehavior.this.canImmersiveScroll()) {
                    if (SeslImmersiveScrollBehavior.this.mBottomArea == null || SeslImmersiveScrollBehavior.this.mBottomArea.getVisibility() == 8 || height3 == 0) {
                        fMax = Math.max(fMax2, 0.0f);
                        totalScrollRange = appBarLayout.getTotalScrollRange();
                    } else {
                        float fMin2 = Math.min(height3 + f4, fMax2);
                        SeslImmersiveScrollBehavior.this.mBottomArea.setTranslationY(-Math.round(fMin2));
                        if (SeslImmersiveScrollBehavior.this.mBottomArea.getVisibility() != 0) {
                            height3 = 0;
                        }
                        fMax = Math.max(height3 + fMin2, 0.0f);
                        totalScrollRange = appBarLayout.getTotalScrollRange();
                    }
                    height = fMax + totalScrollRange + i;
                    if (SeslImmersiveScrollBehavior.this.mNavigationBarBg != null) {
                        SeslImmersiveScrollBehavior seslImmersiveScrollBehavior2 = SeslImmersiveScrollBehavior.this;
                        if (seslImmersiveScrollBehavior2.isHideCameraCutout(seslImmersiveScrollBehavior2.mDecorViewInset)) {
                            SeslImmersiveScrollBehavior.this.mNavigationBarBg.setTranslationY(0.0f);
                        } else {
                            SeslImmersiveScrollBehavior.this.mNavigationBarBg.setTranslationY(-Math.min(0, Math.round(f4)));
                        }
                    } else if (SeslImmersiveScrollBehavior.this.mNavigationBarBgHeight != 0) {
                        SeslImmersiveScrollBehavior.this.findSystemBarsBackground();
                        if (SeslImmersiveScrollBehavior.this.mNavigationBarBg != null) {
                            SeslImmersiveScrollBehavior.this.mNavigationBarBg.setTranslationY(0.0f);
                        }
                    }
                    if (SeslImmersiveScrollBehavior.this.mStatusBarBg != null) {
                        SeslImmersiveScrollBehavior.this.mStatusBarBg.setTranslationY(Math.min(0.0f, totalScrollRange2));
                    }
                    if (SeslImmersiveScrollBehavior.this.mCurOffset != f) {
                        SeslImmersiveScrollBehavior.this.mCurOffset = f;
                        if (SeslImmersiveScrollBehavior.this.mAnimationController != null) {
                            if (SeslImmersiveScrollBehavior.this.mAnimationController.isFinished()) {
                                Log.e(SeslImmersiveScrollBehavior.TAG, "AnimationController is already finished by App side");
                            } else {
                                SeslImmersiveScrollBehavior.this.forceHideRoundedCorner((int) fMax2);
                                if (SeslDisplayUtils.isPinEdgeEnabled(SeslImmersiveScrollBehavior.this.mContext)) {
                                    Insets insets = SeslImmersiveScrollBehavior.this.mDecorViewInset.getInsets(WindowInsets.Type.navigationBars());
                                    int pinnedEdgeWidth = SeslDisplayUtils.getPinnedEdgeWidth(SeslImmersiveScrollBehavior.this.mContext);
                                    int edgeArea = SeslDisplayUtils.getEdgeArea(SeslImmersiveScrollBehavior.this.mContext);
                                    if (pinnedEdgeWidth == insets.left && edgeArea == 0) {
                                        pinnedEdgeWidth = 0;
                                        i2 = pinnedEdgeWidth;
                                    } else if (pinnedEdgeWidth != insets.right || edgeArea != 1) {
                                        pinnedEdgeWidth = 0;
                                    }
                                    SeslImmersiveScrollBehavior.this.mAnimationController.setInsetsAndAlpha(Insets.of(i2, (int) fMin, pinnedEdgeWidth, (int) Math.max(Math.min(SeslImmersiveScrollBehavior.this.mNavigationBarFrameHeight, f4 + SeslImmersiveScrollBehavior.this.mNavigationBarFrameHeight), 0.0f)), 1.0f, (SeslImmersiveScrollBehavior.this.mNavigationBarFrameHeight - fMax2) / (SeslImmersiveScrollBehavior.this.mNavigationBarFrameHeight != 0 ? SeslImmersiveScrollBehavior.this.mNavigationBarFrameHeight : 1));
                                }
                            }
                        }
                    }
                } else {
                    if (SeslImmersiveScrollBehavior.this.mStatusBarBg != null) {
                        SeslImmersiveScrollBehavior.this.mStatusBarBg.setTranslationY(0.0f);
                    }
                    if (SeslImmersiveScrollBehavior.this.mNavigationBarBg != null) {
                        SeslImmersiveScrollBehavior.this.mNavigationBarBg.setTranslationY(0.0f);
                    }
                    if (SeslImmersiveScrollBehavior.this.mAppBarLayout != null) {
                        float totalScrollRange4 = SeslImmersiveScrollBehavior.this.mAppBarLayout.getTotalScrollRange() + i;
                        if (SeslImmersiveScrollBehavior.this.mBottomArea != null) {
                            float f5 = height3;
                            if (fSeslGetCollapsedHeight == 0.0f) {
                                fSeslGetCollapsedHeight = 1.0f;
                            }
                            float bottom = f5 - (SeslImmersiveScrollBehavior.this.mAppBarLayout.getBottom() * (f5 / fSeslGetCollapsedHeight));
                            SeslImmersiveScrollBehavior.this.mBottomArea.setTranslationY(Math.max(bottom, 0.0f));
                            height2 = (int) ((totalScrollRange4 + SeslImmersiveScrollBehavior.this.mBottomArea.getHeight()) - Math.max(bottom, 0.0f));
                        } else {
                            height2 = totalScrollRange4;
                        }
                    }
                    SeslImmersiveScrollBehavior.this.finishWindowInsetsAnimationController();
                    height = height2;
                }
                if (SeslImmersiveScrollBehavior.this.mAppBarLayout != null) {
                    SeslImmersiveScrollBehavior.this.mAppBarLayout.onImmOffsetChanged((int) height);
                }
            }
        };
        this.mWindowInsetsAnimationControlListener = new WindowInsetsAnimationControlListener() { // from class: com.google.android.material.appbar.SeslImmersiveScrollBehavior.5
            public void onCancelled(@Nullable WindowInsetsAnimationController windowInsetsAnimationController) {
                SeslImmersiveScrollBehavior.this.cancelWindowInsetsAnimationController();
            }

            public void onFinished(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
                SeslImmersiveScrollBehavior.this.resetWindowInsetsAnimationController();
            }

            public void onReady(@NonNull WindowInsetsAnimationController windowInsetsAnimationController, int i) {
                if (SeslImmersiveScrollBehavior.this.mDecorView != null) {
                    SeslImmersiveScrollBehavior.this.mCancellationSignal = null;
                    SeslImmersiveScrollBehavior.this.mAnimationController = windowInsetsAnimationController;
                    SeslImmersiveScrollBehavior.this.setInsetsAndAlphaToDefault();
                }
            }
        };
        this.mWindowAnimationCallback = new WindowInsetsAnimation$Callback(1) { // from class: com.google.android.material.appbar.SeslImmersiveScrollBehavior.6
            public void onEnd(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
                super.onEnd(windowInsetsAnimation);
                if (SeslImmersiveScrollBehavior.this.mContentView == null || SeslImmersiveScrollBehavior.this.mAppBarLayout.isDetachedState()) {
                    return;
                }
                SeslImmersiveScrollBehavior seslImmersiveScrollBehavior = SeslImmersiveScrollBehavior.this;
                seslImmersiveScrollBehavior.mDecorViewInset = seslImmersiveScrollBehavior.mContentView.getRootWindowInsets();
                if (SeslImmersiveScrollBehavior.this.mDecorViewInset != null) {
                    SeslImmersiveScrollBehavior.this.mContentView.dispatchApplyWindowInsets(SeslImmersiveScrollBehavior.this.mDecorViewInset);
                }
            }

            @NonNull
            public WindowInsets onProgress(@NonNull WindowInsets windowInsets, @NonNull List<WindowInsetsAnimation> list) {
                return windowInsets;
            }
        };
        this.mContext = context;
        updateSystemBarsHeight();
        updateAppBarHeightProportion();
    }

    private void animateRestoreTopAndBottom(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i) {
        this.mPrevOffset = i;
        PathInterpolator pathInterpolator = new PathInterpolator(0.17f, 0.17f, 0.2f, 1.0f);
        float fSeslGetCollapsedHeight = (-this.mAppBarLayout.getHeight()) + this.mAppBarLayout.seslGetCollapsedHeight();
        final int[] iArr = {0};
        ValueAnimator valueAnimator = this.mOffsetAnimator;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.mOffsetAnimator = valueAnimator2;
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.SeslImmersiveScrollBehavior.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    if (SeslImmersiveScrollBehavior.this.mTargetView == null) {
                        Log.e(SeslImmersiveScrollBehavior.TAG, "mTargetView is null");
                        return;
                    }
                    int iIntValue = ((Integer) valueAnimator3.getAnimatedValue()).intValue();
                    iArr[0] = SeslImmersiveScrollBehavior.this.mPrevOffset - iIntValue;
                    SeslImmersiveScrollBehavior.this.mTargetView.scrollBy(0, -iArr[0]);
                    SeslImmersiveScrollBehavior.this.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, iIntValue);
                    SeslImmersiveScrollBehavior.this.mPrevOffset = iIntValue;
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.mOffsetAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.appbar.SeslImmersiveScrollBehavior.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (SeslImmersiveScrollBehavior.this.mNavigationBarBg != null) {
                    SeslImmersiveScrollBehavior.this.mNavigationBarBg.setTranslationY(0.0f);
                }
                if (SeslImmersiveScrollBehavior.this.mAnimationController != null) {
                    SeslImmersiveScrollBehavior.this.mAnimationController.finish(true);
                }
            }
        });
        this.mOffsetAnimator.setDuration(150L);
        this.mOffsetAnimator.setInterpolator(pathInterpolator);
        this.mOffsetAnimator.setStartDelay(0L);
        this.mOffsetAnimator.setIntValues(this.mNeedRestoreAnim ? -this.mAppBarLayout.getHeight() : (int) fSeslGetCollapsedHeight, (int) fSeslGetCollapsedHeight);
        this.mOffsetAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canImmersiveScroll() {
        AppBarLayout appBarLayout;
        WindowInsets windowInsets;
        if (this.mAppBarLayout != null && Build.VERSION.SDK_INT >= 30 && !isDexEnabled() && !this.useCustomAnimationCallback) {
            if (this.mAppBarLayout.getIsMouse()) {
                prepareImmersiveScroll(false, false);
                return false;
            }
            if (isAccessibilityEnabled()) {
                Log.i(TAG, "Disable ImmersiveScroll due to accessibility enabled");
                updateOrientationState();
                prepareImmersiveScroll(false, true);
                return false;
            }
            if (this.mAppBarLayout.seslIsActivatedImmsersiveScroll()) {
                prepareImmersiveScroll(true, false);
                boolean z = !getCurrentNavbarCanMoveState() || updateOrientationState() || ((windowInsets = this.mDecorViewInset) != null && windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom > 0);
                Context context = this.mContext;
                if (context != null) {
                    Activity activity = SeslContextUtils.getActivity(context);
                    if (activity == null && (appBarLayout = this.mAppBarLayout) != null) {
                        this.mContext = appBarLayout.getContext();
                        activity = SeslContextUtils.getActivity(this.mAppBarLayout.getContext());
                    }
                    if (activity != null) {
                        boolean zIsInMultiWindowMode = activity.isInMultiWindowMode();
                        if (this.mIsMultiWindow != zIsInMultiWindowMode) {
                            forceRestoreWindowInset(true);
                            cancelWindowInsetsAnimationController();
                        }
                        this.mIsMultiWindow = zIsInMultiWindowMode;
                        if (zIsInMultiWindowMode) {
                        }
                    }
                }
                return z;
            }
            AppBarLayout appBarLayout2 = this.mAppBarLayout;
            if (appBarLayout2 != null && appBarLayout2.isImmersiveActivatedByUser()) {
                cancelWindowInsetsAnimationController();
            }
            prepareImmersiveScroll(false, false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findSystemBarsBackground() {
        View view = this.mDecorView;
        if (view == null || this.mContext == null) {
            return;
        }
        this.mDecorViewInset = view.getRootWindowInsets();
        this.mDecorView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.appbar.SeslImmersiveScrollBehavior.4
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                SeslImmersiveScrollBehavior.this.mDecorView.getViewTreeObserver().removeOnPreDrawListener(this);
                SeslImmersiveScrollBehavior seslImmersiveScrollBehavior = SeslImmersiveScrollBehavior.this;
                seslImmersiveScrollBehavior.mStatusBarBg = seslImmersiveScrollBehavior.mDecorView.findViewById(R.id.statusBarBackground);
                SeslImmersiveScrollBehavior seslImmersiveScrollBehavior2 = SeslImmersiveScrollBehavior.this;
                seslImmersiveScrollBehavior2.mNavigationBarBg = seslImmersiveScrollBehavior2.mDecorView.findViewById(R.id.navigationBarBackground);
                return false;
            }
        });
        updateSystemBarsHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWindowInsetsAnimationController() {
        AppBarLayout appBarLayout = this.mAppBarLayout;
        if (appBarLayout == null) {
            return;
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.mAnimationController;
        if (this.mContentView == null) {
            View rootView = appBarLayout.getRootView();
            this.mDecorView = rootView;
            this.mContentView = rootView.findViewById(R.id.content);
        }
        if (windowInsetsAnimationController == null) {
            CancellationSignal cancellationSignal = this.mCancellationSignal;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
                return;
            }
            return;
        }
        int i = windowInsetsAnimationController.getCurrentInsets().bottom;
        int i2 = windowInsetsAnimationController.getShownStateInsets().bottom;
        int i4 = windowInsetsAnimationController.getHiddenStateInsets().bottom;
        if (i == i2) {
            windowInsetsAnimationController.finish(true);
        } else if (i == i4) {
            windowInsetsAnimationController.finish(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceHideRoundedCorner(int i) {
        WindowInsetsAnimationController windowInsetsAnimationController = this.mAnimationController;
        if (windowInsetsAnimationController == null || this.mDecorView == null) {
            return;
        }
        boolean z = i != windowInsetsAnimationController.getShownStateInsets().bottom;
        if (z != this.isRoundedCornerHide) {
            this.isRoundedCornerHide = z;
            SeslDecorViewReflector.semSetForceHideRoundedCorner(this.mDecorView, z);
        }
    }

    private boolean getCurrentNavbarCanMoveState() {
        try {
            return this.mContext.getApplicationContext().getResources().getBoolean(Resources.getSystem().getIdentifier("config_navBarCanMove", "bool", TelemetryEventStrings.C6439Os.OS_NAME));
        } catch (Exception e) {
            Log.e(TAG, "ERROR, e : " + e.getMessage());
            return true;
        }
    }

    private boolean isAccessibilityEnabled() {
        Context context = this.mContext;
        if (context == null) {
            return false;
        }
        return ((AccessibilityManager) context.getSystemService("accessibility")).isTouchExplorationEnabled();
    }

    private boolean isDexEnabled() {
        Context context = this.mContext;
        if (context == null) {
            return false;
        }
        return SeslDisplayUtils.isDexEnabled(context);
    }

    public static boolean isGestureNavigateEnabled(Context context) {
        int integer = context.getResources().getInteger(Resources.getSystem().getIdentifier("config_navBarInteractionMode", "integer", TelemetryEventStrings.C6439Os.OS_NAME));
        return integer == 2 || integer == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHideCameraCutout(WindowInsets windowInsets) {
        return windowInsets.getDisplayCutout() == null && windowInsets.getInsets(WindowInsets.Type.statusBars()).top == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLandscape() {
        AppBarLayout appBarLayout = this.mAppBarLayout;
        return appBarLayout != null && appBarLayout.getCurrentOrientation() == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNavigationBarBottomPosition() {
        if (this.mDecorViewInset == null) {
            if (this.mDecorView == null) {
                this.mDecorView = this.mAppBarLayout.getRootView();
            }
            this.mDecorViewInset = this.mDecorView.getRootWindowInsets();
        }
        WindowInsets windowInsets = this.mDecorViewInset;
        return windowInsets == null || windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom != 0;
    }

    private boolean isTouchInGestureNavigationArea(float f, WindowInsets windowInsets) {
        if (this.mDecorView == null) {
            return false;
        }
        int i = windowInsets.getInsets(WindowInsets.Type.mandatorySystemGestures()).bottom;
        Rect rect = new Rect();
        this.mDecorView.getWindowVisibleDisplayFrame(rect);
        return f > ((float) (rect.bottom - i));
    }

    private void prepareImmersiveScroll(boolean z, boolean z2) {
        if (this.mCanImmersiveScroll != z) {
            this.mCanImmersiveScroll = z;
            forceRestoreWindowInset(z2);
            setupDecorsFitSystemWindowState(z);
            if (z != this.mAppBarLayout.getCanImmScroll()) {
                this.mAppBarLayout.setCanImmScroll(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetWindowInsetsAnimationController() {
        this.mAnimationController = null;
        this.mCancellationSignal = null;
        this.mShownAtDown = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setInsetsAndAlphaToDefault() {
        int pinnedEdgeWidth;
        int i = 0;
        if (SeslDisplayUtils.isPinEdgeEnabled(this.mContext)) {
            Insets insets = this.mDecorViewInset.getInsets(WindowInsets.Type.navigationBars());
            pinnedEdgeWidth = SeslDisplayUtils.getPinnedEdgeWidth(this.mContext);
            int edgeArea = SeslDisplayUtils.getEdgeArea(this.mContext);
            if (pinnedEdgeWidth == insets.left && edgeArea == 0) {
                pinnedEdgeWidth = 0;
                i = pinnedEdgeWidth;
            } else if (pinnedEdgeWidth != insets.right || edgeArea != 1) {
                pinnedEdgeWidth = 0;
            }
        }
        this.mAnimationController.setInsetsAndAlpha(Insets.of(i, this.mStatusBarHeight, pinnedEdgeWidth, this.mNavigationBarFrameHeight), 1.0f, 1.0f);
    }

    private void setWindowInsetsController() {
        View view = this.mDecorView;
        if (view != null && this.mAnimationController == null && this.mWindowInsetsController == null) {
            this.mWindowInsetsController = view.getWindowInsetsController();
        }
    }

    private void setupDecorsFitSystemWindowState(boolean z) {
        AppBarLayout appBarLayout;
        int i;
        AppBarLayout appBarLayout2;
        if (this.mDecorView == null || (appBarLayout = this.mAppBarLayout) == null || this.useCustomAnimationCallback) {
            return;
        }
        if (this.mContext == null) {
            Context context = appBarLayout.getContext();
            this.mContext = context;
            if (context == null) {
                return;
            }
        }
        Activity activity = SeslContextUtils.getActivity(this.mContext);
        if (activity == null && (appBarLayout2 = this.mAppBarLayout) != null) {
            this.mContext = appBarLayout2.getContext();
            activity = SeslContextUtils.getActivity(this.mAppBarLayout.getContext());
        }
        if (activity != null) {
            Window window = activity.getWindow();
            if (z) {
                WindowInsets windowInsets = this.mDecorViewInset;
                if (windowInsets == null || !isHideCameraCutout(windowInsets)) {
                    this.mAppBarLayout.setImmersiveTopInset(this.mStatusBarHeight);
                } else {
                    this.mAppBarLayout.setImmersiveTopInset(0);
                }
                window.setDecorFitsSystemWindows(false);
                window.getDecorView().setFitsSystemWindows(false);
                WindowInsets windowInsets2 = this.mDecorViewInset;
                if (windowInsets2 == null || (i = windowInsets2.getInsets(WindowInsets.Type.statusBars()).top) == 0 || i == this.mStatusBarHeight) {
                    return;
                }
                this.mStatusBarHeight = i;
                this.mAppBarLayout.setImmersiveTopInset(i);
                return;
            }
            this.mAppBarLayout.setImmersiveTopInset(0);
            window.setDecorFitsSystemWindows(true);
            window.getDecorView().setFitsSystemWindows(true);
            if (isNavigationBarBottomPosition() || !isLandscape()) {
                return;
            }
            if (this.mWindowInsetsController == null) {
                setWindowInsetsController();
            }
            WindowInsets rootWindowInsets = this.mDecorView.getRootWindowInsets();
            this.mDecorViewInset = rootWindowInsets;
            if (this.mWindowInsetsController == null || rootWindowInsets == null || rootWindowInsets.getInsets(WindowInsets.Type.statusBars()).top == 0) {
                return;
            }
            try {
                this.mWindowInsetsController.hide(WindowInsets.Type.statusBars());
            } catch (IllegalStateException unused) {
                Log.w(TAG, "setupDecorsFitSystemWindowState: mWindowInsetsController.hide failed!");
            }
        }
    }

    private void startAnimationControlRequest() {
        setWindowInsetsController();
        if (this.mCancellationSignal == null) {
            this.mCancellationSignal = new CancellationSignal();
        }
        int iStatusBars = WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars();
        if (!isHideCameraCutout(this.mDecorViewInset)) {
            try {
                this.mWindowInsetsController.hide(iStatusBars);
            } catch (IllegalStateException unused) {
                Log.w(TAG, "startAnimationControlRequest: mWindowInsetsController.hide failed!");
            }
        }
        this.mWindowInsetsController.setSystemBarsBehavior(2);
        this.mWindowInsetsController.controlWindowInsetsAnimation(iStatusBars, -1L, null, this.mCancellationSignal, this.mWindowInsetsAnimationControlListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRestoreAnimation() {
        if (isAppBarHide()) {
            animateRestoreTopAndBottom(this.mCoordinatorLayout, this.mAppBarLayout, -this.mAppBarLayout.getUpNestedPreScrollRange());
        }
    }

    private void updateAppBarHeightProportion() {
        AppBarLayout appBarLayout = this.mAppBarLayout;
        if (appBarLayout == null) {
            return;
        }
        if (this.mContext == null) {
            Context context = appBarLayout.getContext();
            this.mContext = context;
            if (context == null) {
                return;
            }
        }
        Resources resources = this.mContext.getResources();
        float appBarProPortion = SeslAppBarHelper.INSTANCE.getAppBarProPortion(this.mContext);
        float f = 0.0f;
        if (appBarProPortion != 0.0f) {
            f = (this.mStatusBarHeight / resources.getDisplayMetrics().heightPixels) + appBarProPortion;
        }
        if (this.mCanImmersiveScroll) {
            this.mAppBarLayout.internalProportion(f);
        } else {
            this.mAppBarLayout.internalProportion(appBarProPortion);
        }
    }

    private boolean updateOrientationState() {
        AppBarLayout appBarLayout = this.mAppBarLayout;
        if (appBarLayout == null) {
            return false;
        }
        int currentOrientation = appBarLayout.getCurrentOrientation();
        if (this.mPrevOrientation != currentOrientation) {
            this.mPrevOrientation = currentOrientation;
            forceRestoreWindowInset(true);
            this.mCalledHideShowOnLayoutChild = false;
        }
        if (currentOrientation == 1) {
            return true;
        }
        if (currentOrientation != 2) {
            Log.e(TAG, "ERROR, e : AppbarLayout Configuration is wrong");
        }
        return false;
    }

    private void updateSystemBarsHeight() {
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", AbsExecuteBinding.TYPE_DIMEN, TelemetryEventStrings.C6439Os.OS_NAME);
        if (identifier > 0) {
            this.mStatusBarHeight = resources.getDimensionPixelSize(identifier);
        }
        int identifier2 = resources.getIdentifier("navigation_bar_height", AbsExecuteBinding.TYPE_DIMEN, TelemetryEventStrings.C6439Os.OS_NAME);
        if (identifier2 > 0) {
            this.mNavigationBarBgHeight = resources.getDimensionPixelSize(identifier2);
        }
        View view = this.mDecorView;
        if (view != null) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            this.mDecorViewInset = rootWindowInsets;
            if (rootWindowInsets != null) {
                this.mStatusBarHeight = rootWindowInsets.getInsets(WindowInsets.Type.statusBars()).top;
                int i = this.mDecorViewInset.getInsets(WindowInsets.Type.navigationBars()).bottom;
                this.mNavigationBarFrameHeight = i;
                this.mNavigationBarBgHeight = i;
                if (this.mNavigationBarBg == null) {
                    this.mNavigationBarBgHeight = 0;
                }
            }
        }
    }

    public void cancelWindowInsetsAnimationController() {
        View view = this.mDecorView;
        if (view != null) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            this.mDecorViewInset = rootWindowInsets;
            if (rootWindowInsets != null) {
                this.mShownAtDown = rootWindowInsets.isVisible(WindowInsets.Type.statusBars()) || this.mDecorViewInset.isVisible(WindowInsets.Type.navigationBars());
            }
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.mAnimationController;
        if (windowInsetsAnimationController != null) {
            windowInsetsAnimationController.finish(this.mShownAtDown);
        }
        CancellationSignal cancellationSignal = this.mCancellationSignal;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
        resetWindowInsetsAnimationController();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean z = motionEvent.getToolType(0) == 3;
        if (this.mToolIsMouse != z) {
            this.mToolIsMouse = z;
            AppBarLayout appBarLayout = this.mAppBarLayout;
            if (appBarLayout != null) {
                appBarLayout.seslSetIsMouse(z);
                dispatchImmersiveScrollEnabled();
            }
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchImmersiveScrollEnabled() {
        AppBarLayout appBarLayout = this.mAppBarLayout;
        if (appBarLayout == null || appBarLayout.isDetachedState()) {
            return false;
        }
        boolean zCanImmersiveScroll = canImmersiveScroll();
        setupDecorsFitSystemWindowState(zCanImmersiveScroll);
        updateAppBarHeightProportion();
        updateSystemBarsHeight();
        return zCanImmersiveScroll;
    }

    public void forceRestoreWindowInset(boolean z) {
        if (this.mWindowInsetsController != null) {
            WindowInsets rootWindowInsets = this.mDecorView.getRootWindowInsets();
            this.mDecorViewInset = rootWindowInsets;
            if (rootWindowInsets != null) {
                boolean zIsVisible = rootWindowInsets.isVisible(WindowInsets.Type.statusBars());
                boolean zIsVisible2 = this.mDecorViewInset.isVisible(WindowInsets.Type.navigationBars());
                if (!zIsVisible || !zIsVisible2 || isAppBarHide() || z) {
                    try {
                        this.mWindowInsetsController.show(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                    } catch (IllegalStateException unused) {
                        Log.w(TAG, "forceRestoreWindowInset: mWindowInsetsController.show failed!");
                    }
                }
            }
        }
    }

    public boolean getCanImmersiveScrollState() {
        return this.mCanImmersiveScroll;
    }

    public void initImmViews(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout) {
        Log.d(TAG, "initImmViews mNeedInit=" + this.mNeedInit);
        int i = 0;
        this.mNeedInit = false;
        this.mCanImmersiveScroll = false;
        this.mAppBarLayout = appBarLayout;
        this.mCoordinatorLayout = coordinatorLayout;
        appBarLayout.addOnOffsetChangedListener(this.mOffsetChangedListener);
        if (!this.mAppBarLayout.isImmersiveActivatedByUser() && !isDexEnabled()) {
            this.mAppBarLayout.internalActivateImmersiveScroll(true, false);
        }
        View rootView = this.mAppBarLayout.getRootView();
        this.mDecorView = rootView;
        View viewFindViewById = rootView.findViewById(R.id.content);
        this.mContentView = viewFindViewById;
        if (this.useCustomAnimationCallback) {
            viewFindViewById.setWindowInsetsAnimationCallback(this.mCustomWindowInsetsAnimation);
        } else {
            viewFindViewById.setWindowInsetsAnimationCallback(this.mWindowAnimationCallback);
        }
        findSystemBarsBackground();
        dispatchImmersiveScrollEnabled();
        while (true) {
            if (i >= appBarLayout.getChildCount()) {
                break;
            }
            View childAt = appBarLayout.getChildAt(i);
            if (this.mCollapsingToolbarLayout != null) {
                break;
            }
            if (childAt instanceof CollapsingToolbarLayout) {
                this.mCollapsingToolbarLayout = (CollapsingToolbarLayout) childAt;
                break;
            }
            i++;
        }
        View viewFindViewById2 = coordinatorLayout.findViewById(C4548R.id.bottom_bar_overlay);
        if (this.mBottomArea == null || viewFindViewById2 != null) {
            this.mBottomArea = viewFindViewById2;
        }
    }

    public boolean isAppBarHide() {
        AppBarLayout appBarLayout = this.mAppBarLayout;
        if (appBarLayout != null) {
            return ((float) (this.mAppBarLayout.getPaddingBottom() + appBarLayout.getBottom())) < this.mAppBarLayout.seslGetCollapsedHeight();
        }
        return false;
    }

    public void notifyOnApplyWindowInsets() {
        if (this.mAppBarLayout != null) {
            cancelWindowInsetsAnimationController();
            updateSystemBarsHeight();
            this.mAppBarLayout.onOffsetChanged(getTopAndBottomOffset());
        }
    }

    public void notifyOnDetachedFromWindow() {
        Log.i(TAG, "DetachedFromWindow");
        WindowInsetsController$OnControllableInsetsChangedListener windowInsetsController$OnControllableInsetsChangedListener = this.mOnInsetsChangedListener;
        if (windowInsetsController$OnControllableInsetsChangedListener != null) {
            this.mWindowInsetsController.removeOnControllableInsetsChangedListener(windowInsetsController$OnControllableInsetsChangedListener);
            this.mOnInsetsChangedListener = null;
        }
        resetWindowInsetsAnimationController();
    }

    public void release() {
        String str = TAG;
        Log.d(str, "release");
        if (this.mAnimationHandler.hasMessages(100)) {
            Log.d(str, "release removeMessages");
            this.mAnimationHandler.removeMessages(100);
        }
        View view = this.mContentView;
        if (view != null) {
            view.setWindowInsetsAnimationCallback(null);
        }
        this.mTargetView = null;
        this.mNeedInit = true;
    }

    public void restoreTopAndBottom(boolean z) {
        AppBarLayout appBarLayout;
        AbstractC4539a.m3208r(" Restore top and bottom areas [Animate] ", TAG, z);
        this.mNeedRestoreAnim = z;
        if (this.mAppBarLayout != null && isAppBarHide()) {
            if (this.mAnimationHandler.hasMessages(100)) {
                this.mAnimationHandler.removeMessages(100);
            }
            this.mAnimationHandler.sendEmptyMessageDelayed(100, 100L);
        }
        if (this.mBottomArea == null || this.mNavigationBarBg == null || this.mAnimationHandler.hasMessages(100) || (appBarLayout = this.mAppBarLayout) == null || appBarLayout.seslIsActivatedImmsersiveScroll()) {
            return;
        }
        this.mBottomArea.setTranslationY(0.0f);
    }

    public void setAutoRestoreTopAndBottom(boolean z) {
        this.mIsSetAutoRestore = z;
    }

    public void setBottomView(@Nullable View view) {
        this.mBottomArea = view;
    }

    public void setNeedToCheckBottomViewMargin(boolean z) {
        this.mNeedToCheckBottomViewMargin = z;
    }

    public void setWindowInsetsAnimationCallback(@NonNull AppBarLayout appBarLayout, @Nullable WindowInsetsAnimation$Callback windowInsetsAnimation$Callback) {
        if (this.mContentView == null) {
            View rootView = appBarLayout.getRootView();
            this.mDecorView = rootView;
            this.mContentView = rootView.findViewById(R.id.content);
        }
        if (windowInsetsAnimation$Callback == null) {
            this.useCustomAnimationCallback = false;
        } else {
            this.mCustomWindowInsetsAnimation = windowInsetsAnimation$Callback;
            this.useCustomAnimationCallback = true;
        }
        if (!this.useCustomAnimationCallback) {
            this.mContentView.setPadding(0, 0, 0, 0);
            this.mContentView.setWindowInsetsAnimationCallback(this.mWindowAnimationCallback);
            return;
        }
        this.mContentView.setWindowInsetsAnimationCallback(this.mCustomWindowInsetsAnimation);
        prepareImmersiveScroll(false, false);
        View view = this.mBottomArea;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
    }

    public void setupDecorFitsSystemWindow() {
        Log.i(TAG, "fits system window Immersive detached");
        Activity activity = SeslContextUtils.getActivity(this.mContext);
        if (activity != null && this.mAppBarLayout != null) {
            activity.getWindow().setDecorFitsSystemWindows(true);
            View view = this.mBottomArea;
            if (view != null) {
                view.setTranslationY(0.0f);
            }
        }
        View view2 = this.mStatusBarBg;
        if (view2 == null || view2.getTranslationY() == 0.0f) {
            return;
        }
        this.mStatusBarBg.setTranslationY(0.0f);
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    public void layoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i) {
        super.layoutChild(coordinatorLayout, appBarLayout, i);
        if (this.mWindowInsetsController != null && this.mOnInsetsChangedListener == null) {
            WindowInsetsController$OnControllableInsetsChangedListener windowInsetsController$OnControllableInsetsChangedListener = new WindowInsetsController$OnControllableInsetsChangedListener() { // from class: com.google.android.material.appbar.SeslImmersiveScrollBehavior.3
                public void onControllableInsetsChanged(@NonNull WindowInsetsController windowInsetsController, int i2) {
                    if (SeslImmersiveScrollBehavior.this.isLandscape() && !SeslImmersiveScrollBehavior.this.isNavigationBarBottomPosition() && !SeslImmersiveScrollBehavior.this.mCalledHideShowOnLayoutChild) {
                        windowInsetsController.hide(WindowInsets.Type.navigationBars());
                        windowInsetsController.show(WindowInsets.Type.navigationBars());
                        windowInsetsController.setSystemBarsBehavior(2);
                        SeslImmersiveScrollBehavior.this.mCalledHideShowOnLayoutChild = true;
                    }
                    if (SeslImmersiveScrollBehavior.this.mIsSetAutoRestore && i2 == 8) {
                        SeslImmersiveScrollBehavior seslImmersiveScrollBehavior = SeslImmersiveScrollBehavior.this;
                        seslImmersiveScrollBehavior.mDecorViewInset = seslImmersiveScrollBehavior.mDecorView.getRootWindowInsets();
                        if (SeslImmersiveScrollBehavior.this.mDecorViewInset != null && SeslImmersiveScrollBehavior.this.mDecorViewInset.isVisible(WindowInsets.Type.statusBars()) && SeslImmersiveScrollBehavior.this.isAppBarHide()) {
                            SeslImmersiveScrollBehavior.this.restoreTopAndBottom(true);
                        }
                    }
                }
            };
            this.mOnInsetsChangedListener = windowInsetsController$OnControllableInsetsChangedListener;
            this.mWindowInsetsController.addOnControllableInsetsChangedListener(windowInsetsController$OnControllableInsetsChangedListener);
        }
        AppBarLayout appBarLayout2 = this.mAppBarLayout;
        if (appBarLayout2 == null || appBarLayout != appBarLayout2 || this.mNeedInit) {
            initImmViews(coordinatorLayout, appBarLayout);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull MotionEvent motionEvent) {
        int toolType = motionEvent.getToolType(0);
        if (toolType == 0) {
            return super.onInterceptTouchEvent(coordinatorLayout, (View) appBarLayout, motionEvent);
        }
        boolean z = toolType == 3;
        if (this.mToolIsMouse != z) {
            this.mToolIsMouse = z;
            appBarLayout.seslSetIsMouse(z);
        }
        return super.onInterceptTouchEvent(coordinatorLayout, (View) appBarLayout, motionEvent);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i, int i2, int i4, int i5) {
        dispatchImmersiveScrollEnabled();
        return super.onMeasureChild(coordinatorLayout, appBarLayout, i, i2, i4, i5);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i4) {
        this.mTargetView = view;
        if (this.mCancellationSignal == null) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i4);
        } else {
            iArr[0] = i;
            iArr[1] = i2;
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, int i4, int i5, int i6, @NonNull int[] iArr) {
        this.mTargetView = view;
        super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i4, i5, i6, iArr);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i, int i2) {
        this.mTargetView = view2;
        if (dispatchImmersiveScrollEnabled() && this.mAnimationController == null) {
            startAnimationControlRequest();
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i) {
        this.mTargetView = view;
        super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i);
    }
}
