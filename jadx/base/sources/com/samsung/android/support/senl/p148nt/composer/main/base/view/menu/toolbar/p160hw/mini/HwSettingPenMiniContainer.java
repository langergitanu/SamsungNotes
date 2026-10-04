package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.mini;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingPenMiniContainer extends AbsToolbarContainerLayout {
    private static final Interpolator CUSTOM_INTERPOLATOR = PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f);
    private static final int INITIAL_POSITION = -1;
    private static final String PREF_KEY_SETTING_PEN_MINI_TOOLBAR_CLOSE = "setting_pen_mini_toolbar_close_state";
    private static final String PREF_KEY_SETTING_PEN_MINI_TOOLBAR_X = "setting_pen_mini_toolbar_pos_x";
    private static final String PREF_KEY_SETTING_PEN_MINI_TOOLBAR_Y = "setting_pen_mini_toolbar_pos_y";
    private int mDockingSize;
    private IView mIView;
    private Transition.TransitionListener mReplaceTransitionListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        View getBottomDocker();

        View getEndDocker();

        View getStartDocker();

        View getTopDocker();

        void hideView();

        void onActionEnd();

        void onReadyToRotate();

        void onTouchDown();

        void onVisibleAnimationEnd();
    }

    public HwSettingPenMiniContainer(Context context) {
        super(context);
        init(context);
    }

    private Animation getAlphaAnimation(float f, float f4, int i) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f4);
        alphaAnimation.setDuration(i);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        return alphaAnimation;
    }

    private Runnable getIntroVI() {
        return new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.2
            @Override // java.lang.Runnable
            public void run() {
                int width = HwSettingPenMiniContainer.this.getWidth();
                if (width == 0) {
                    HwSettingPenMiniContainer.this.measure(0, 0);
                    width = HwSettingPenMiniContainer.this.getMeasuredWidth();
                }
                HwSettingPenMiniContainer.this.setX(-width);
                HwSettingPenMiniContainer.this.setY(r0.getCenterVertical());
                SpringAnimation springAnimation = new SpringAnimation(HwSettingPenMiniContainer.this, DynamicAnimation.f1485X, r1.mIView.getStartDocker().getRight());
                springAnimation.getSpring().setStiffness(200.0f).setDampingRatio(0.7f);
                springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.2.1
                    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                    public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
                        HwSettingPenMiniContainer.this.saveCurrentPosition();
                    }
                });
                springAnimation.start();
            }
        };
    }

    private Runnable getRestrictOutOfBoundsVI() {
        return new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.5
            @Override // java.lang.Runnable
            public void run() {
                HwSettingPenMiniContainer.this.restrictOutOfBoundsVI();
            }
        };
    }

    private Runnable getRotationVI() {
        final PointF endBottomPointF = getEndBottomPointF();
        return new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.4
            @Override // java.lang.Runnable
            public void run() {
                PointF endBottomPointF2 = HwSettingPenMiniContainer.this.getEndBottomPointF();
                PointF pointF = endBottomPointF;
                endBottomPointF2.offset(-pointF.x, -pointF.y);
                HwSettingPenMiniContainer hwSettingPenMiniContainer = HwSettingPenMiniContainer.this;
                hwSettingPenMiniContainer.setX(hwSettingPenMiniContainer.getX() - endBottomPointF2.x);
                HwSettingPenMiniContainer hwSettingPenMiniContainer2 = HwSettingPenMiniContainer.this;
                hwSettingPenMiniContainer2.setY(hwSettingPenMiniContainer2.getY() - endBottomPointF2.y);
                PointF targetPositionInside = HwSettingPenMiniContainer.this.getTargetPositionInside();
                HwSettingPenMiniContainer.this.setX(targetPositionInside.x);
                HwSettingPenMiniContainer.this.setY(targetPositionInside.y);
                HwSettingPenMiniContainer.this.runAnimationSetVI(null, HwSettingPenMiniContainer.m11738k(HwSettingPenMiniContainer.this), HwSettingPenMiniContainer.m11737j(HwSettingPenMiniContainer.this));
                HwSettingPenMiniContainer.this.saveCurrentPosition();
            }
        };
    }

    private Animation getScaleAnimation(float f, float f4, int i) {
        PointF centerPointF = getCenterPointF();
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f4, f, f4, centerPointF.x, centerPointF.y);
        scaleAnimation.setDuration(i);
        scaleAnimation.setInterpolator(CUSTOM_INTERPOLATOR);
        return scaleAnimation;
    }

    private void initReplaceTransitionListener() {
        this.mReplaceTransitionListener = new Transition.TransitionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.9
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                HwSettingPenMiniContainer.this.setBackground(null);
                HwSettingPenMiniContainer.this.mIView.onVisibleAnimationEnd();
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
            }
        };
    }

    /* JADX INFO: renamed from: j */
    public static /* bridge */ /* synthetic */ Animation m11737j(HwSettingPenMiniContainer hwSettingPenMiniContainer) {
        return hwSettingPenMiniContainer.getAlphaAnimation(0.0f, 1.0f, 200);
    }

    /* JADX INFO: renamed from: k */
    public static /* bridge */ /* synthetic */ Animation m11738k(HwSettingPenMiniContainer hwSettingPenMiniContainer) {
        return hwSettingPenMiniContainer.getScaleAnimation(0.8f, 1.0f, 400);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetViewState() {
        setScaleX(1.0f);
        setScaleY(1.0f);
        setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restrictOutOfBoundsVI() {
        PointF targetPositionInside = getTargetPositionInside();
        reboundOnDropZone(targetPositionInside.x, targetPositionInside.y, true, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runDelayedRunnableAfterLaidOut(final Runnable runnable) {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                HwSettingPenMiniContainer.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                runnable.run();
            }
        });
    }

    private void updateMaxHeight() {
        int iMin = Math.min(getMParentHeight(), getMParentWidth()) - this.mDockingSize;
        if (getHeight() < iMin) {
            ((ConstraintLayout.LayoutParams) getLayoutParams()).matchConstraintMaxHeight = iMin;
        }
    }

    public void beginDelayedRestrictOutOfBounds() {
        runDelayedRunnableAfterLaidOut(getRestrictOutOfBoundsVI());
    }

    public void clearPosition() {
        savePosition(-1.0f, -1.0f);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void dispatchLongPress(MotionEvent motionEvent) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public String getChildName() {
        return getClass().getSimpleName();
    }

    public PointF getTargetPositionInside() {
        Rect rect = new Rect((int) this.mStartMargin, 0, this.mParentWidth, this.mParentHeight);
        float x = getX();
        float y2 = getY();
        PointF pointF = new PointF(x, y2);
        if (LocaleUtils.isRTLMode()) {
            rect.right = (rect.right - getWidth()) - rect.left;
            rect.left = getWidth();
        }
        int i = rect.left;
        if (x < i) {
            pointF.x = i;
        } else {
            if (x + getWidth() > rect.right) {
                pointF.x = r4 - getWidth();
            }
        }
        int i2 = rect.top;
        if (y2 < i2) {
            pointF.y = i2;
            return pointF;
        }
        if (y2 + getHeight() > rect.bottom) {
            pointF.y = r0 - getHeight();
        }
        return pointF;
    }

    public void hide() {
        if (isShowing()) {
            setVisibility(8);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public void init(Context context) {
        super.init(context);
        this.mDockingSize = getResources().getDimensionPixelSize(C9086R.dimen.comp_hw_floating_menu_container_height);
        this.pref_key_toolbar_x = PREF_KEY_SETTING_PEN_MINI_TOOLBAR_X;
        this.pref_key_toolbar_y = PREF_KEY_SETTING_PEN_MINI_TOOLBAR_Y;
        this.mInitialPositionX = -1.0f;
        this.mInitialPositionY = -1.0f;
        this.mHasScrollable = true;
        this.mHasViewFlipper = true;
        this.mHasSeekBar = true;
        setImportantForAccessibility(2);
        enableDocking(false);
        initReplaceTransitionListener();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public boolean isAcceptableOverlap() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public boolean isShowing() {
        return getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void onActionEnd() {
        super.onActionEnd();
        this.mIView.onActionEnd();
        ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_MINI_MOVE_MINI_PEN);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        super.onLayout(z, i, i2, i4, i5);
        if (z) {
            setEndEdgeSize(i4 - i);
            updateMaxHeight();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void onLongPress() {
        interceptTouchOnce();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void onTouchDown(PointF pointF) {
        super.onTouchDown(pointF);
        this.mIView.onTouchDown();
    }

    public void replaceView(View view, View view2, boolean z) {
        if (z) {
            TransitionSet transitionSet = new TransitionSet();
            if (view.getBackground() != null && view.getBackground().getConstantState() != null) {
                setBackground(view.getBackground().getConstantState().newDrawable());
            }
            transitionSet.addListener(this.mReplaceTransitionListener);
            transitionSet.addTransition(new Fade().setDuration(400L).setInterpolator(new LinearInterpolator()));
            transitionSet.addTransition(new ChangeBounds().setDuration(400L).setInterpolator(CUSTOM_INTERPOLATOR).addTarget(this));
            TransitionManager.beginDelayedTransition((ViewGroup) getParent(), transitionSet);
        }
        view.setVisibility(8);
        view2.setVisibility(0);
        if (z) {
            return;
        }
        this.mReplaceTransitionListener.onTransitionEnd(null);
    }

    public void rotateVI() {
        final Runnable rotationVI = getRotationVI();
        Animation scaleAnimation = getScaleAnimation(1.0f, 0.8f, 100);
        scaleAnimation.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        runAnimationSetVI(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.3
            @Override // java.lang.Runnable
            public void run() {
                HwSettingPenMiniContainer.this.mIView.onReadyToRotate();
                HwSettingPenMiniContainer.this.runDelayedRunnableAfterLaidOut(rotationVI);
            }
        }, scaleAnimation, getAlphaAnimation(1.0f, 0.0f, 100));
    }

    public void runAnimationSetVI(@Nullable final Runnable runnable, Animation... animationArr) {
        AnimationSet animationSet = new AnimationSet(true);
        for (Animation animation : animationArr) {
            animationSet.addAnimation(animation);
        }
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                HwSettingPenMiniContainer.this.resetViewState();
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }
        });
        startAnimation(animationSet);
    }

    public void runHidingVI() {
        runAnimationSetVI(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.7
            @Override // java.lang.Runnable
            public void run() {
                HwSettingPenMiniContainer.this.mIView.hideView();
            }
        }, getScaleAnimation(1.0f, 0.9f, 400), getAlphaAnimation(1.0f, 0.0f, 100));
    }

    public void runReboundVI() {
        animate().scaleX(1.02f).scaleY(1.02f).setDuration(150L).setInterpolator(new LinearInterpolator()).withEndAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniContainer.6
            @Override // java.lang.Runnable
            public void run() {
                HwSettingPenMiniContainer.this.runScaleAnimation(1.0f, 200.0f, 0.5f);
            }
        }).start();
    }

    public void setView(IView iView) {
        this.mIView = iView;
    }

    public void show() {
        Pair<Float, Float> storedRatio = getStoredRatio();
        if (isInitialPosition(((Float) storedRatio.first).floatValue(), ((Float) storedRatio.second).floatValue())) {
            runDelayedRunnableAfterLaidOut(getIntroVI());
        } else {
            super.updateRelayoutPosition();
        }
        setVisibility(0);
    }

    public HwSettingPenMiniContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public HwSettingPenMiniContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public HwSettingPenMiniContainer(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
    }
}
