package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.animation.TimeInterpolator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AnchorInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsHwSettingAnchorExpansionLayout extends AbsHwSettingAnchorLayout {
    private static final int EXPAND_COLLAPSE_DURATION = 300;
    private AnchorInfo mAnchorInfo;
    private OnAnimationListener mCollapseListener;
    private OnAnimationListener mExpandListener;
    boolean mIsPreTouchHiding = false;
    private OnAnimationListener mMoveListener;
    SpenPreTouchListenerImpl.PreTouchListener mPreTouchListener;
    private String mSharedPrefID;
    private static final Interpolator EXPAND_COLLAPSE_INTERPOLATOR = PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f);
    private static final Boolean DEFAULT_EXPAND_STATE = Boolean.FALSE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class OnAnimationListener implements ISettingViewManager.OnUpdatePositionListener {
        public /* synthetic */ OnAnimationListener(int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.ISettingViewManager.OnUpdatePositionListener
        public void onPositionUpdated(View view, PointF pointF, PointF pointF2) {
            view.setTranslationX(pointF.x);
            view.setTranslationY(pointF.y);
            view.animate().translationX(pointF2.x).translationY(pointF2.y).setDuration(300L).setInterpolator(AbsHwSettingAnchorExpansionLayout.EXPAND_COLLAPSE_INTERPOLATOR).start();
        }

        private OnAnimationListener() {
        }
    }

    public AbsHwSettingAnchorExpansionLayout() {
        initAnimationListener();
    }

    private void beginDelayedTransition() {
        ChangeBounds changeBounds = new ChangeBounds();
        Fade fade = new Fade();
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(changeBounds);
        transitionSet.addTransition(fade);
        transitionSet.setInterpolator((TimeInterpolator) EXPAND_COLLAPSE_INTERPOLATOR);
        transitionSet.setDuration(300L);
        transitionSet.addListener((Transition.TransitionListener) new TransitionListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.AbsHwSettingAnchorExpansionLayout.1
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(@NonNull Transition transition) {
                super.onTransitionEnd(transition);
                AbsHwSettingAnchorExpansionLayout.this.resetViews();
            }
        });
        TransitionManager.beginDelayedTransition((ViewGroup) getView(), transitionSet);
    }

    private void initAnimationListener() {
        this.mIsPreTouchHiding = false;
        this.mPreTouchListener = new SpenPreTouchListenerImpl.PreTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.AbsHwSettingAnchorExpansionLayout.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl.PreTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 2 || actionMasked == 213) {
                    if (AbsHwSettingAnchorExpansionLayout.this.isVisible() && AbsHwSettingAnchorExpansionLayout.this.intersects(motionEvent)) {
                        AbsHwSettingAnchorExpansionLayout absHwSettingAnchorExpansionLayout = AbsHwSettingAnchorExpansionLayout.this;
                        if (!absHwSettingAnchorExpansionLayout.mIsPreTouchHiding) {
                            absHwSettingAnchorExpansionLayout.getView().animate().alpha(0.0f).start();
                            AbsHwSettingAnchorExpansionLayout.this.mIsPreTouchHiding = true;
                        }
                    }
                } else if (actionMasked == 1 || actionMasked == 212 || actionMasked == 3 || actionMasked == 214) {
                    AbsHwSettingAnchorExpansionLayout absHwSettingAnchorExpansionLayout2 = AbsHwSettingAnchorExpansionLayout.this;
                    if (absHwSettingAnchorExpansionLayout2.mIsPreTouchHiding) {
                        absHwSettingAnchorExpansionLayout2.mIsPreTouchHiding = false;
                        absHwSettingAnchorExpansionLayout2.getView().animate().alpha(1.0f).start();
                    }
                }
                return false;
            }
        };
        this.mExpandListener = new OnAnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.AbsHwSettingAnchorExpansionLayout.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.AbsHwSettingAnchorExpansionLayout.OnAnimationListener, com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.ISettingViewManager.OnUpdatePositionListener
            public void onPositionUpdated(View view, PointF pointF, PointF pointF2) {
                super.onPositionUpdated(view, pointF, pointF2);
                AbsHwSettingAnchorExpansionLayout.this.getExpandView().setTranslationX(pointF2.x - pointF.x);
                AbsHwSettingAnchorExpansionLayout.this.getExpandView().setTranslationY(pointF2.y - pointF.y);
                AbsHwSettingAnchorExpansionLayout.this.getExpandView().animate().translationX(0.0f).translationY(0.0f).setDuration(300L).setInterpolator(AbsHwSettingAnchorExpansionLayout.EXPAND_COLLAPSE_INTERPOLATOR).start();
                AbsHwSettingAnchorExpansionLayout.this.getCollapseView().animate().translationX(pointF.x - pointF2.x).translationY(pointF.y - pointF2.y).setDuration(300L).setInterpolator(AbsHwSettingAnchorExpansionLayout.EXPAND_COLLAPSE_INTERPOLATOR).start();
            }
        };
        this.mCollapseListener = new OnAnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.AbsHwSettingAnchorExpansionLayout.4
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.AbsHwSettingAnchorExpansionLayout.OnAnimationListener, com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.ISettingViewManager.OnUpdatePositionListener
            public void onPositionUpdated(View view, PointF pointF, PointF pointF2) {
                super.onPositionUpdated(view, pointF, pointF2);
                AbsHwSettingAnchorExpansionLayout.this.getExpandView().animate().translationX(pointF.x - pointF2.x).translationY(pointF.y - pointF2.y).setDuration(300L).setInterpolator(AbsHwSettingAnchorExpansionLayout.EXPAND_COLLAPSE_INTERPOLATOR).start();
                AbsHwSettingAnchorExpansionLayout.this.getCollapseView().setTranslationX(pointF2.x - pointF.x);
                AbsHwSettingAnchorExpansionLayout.this.getCollapseView().setTranslationY(pointF2.y - pointF.y);
                AbsHwSettingAnchorExpansionLayout.this.getCollapseView().animate().translationX(0.0f).translationY(0.0f).setDuration(300L).setInterpolator(AbsHwSettingAnchorExpansionLayout.EXPAND_COLLAPSE_INTERPOLATOR).start();
            }
        };
        this.mMoveListener = new OnAnimationListener(0);
    }

    private boolean isExpandState() {
        return this.mSharedPrefID == null ? DEFAULT_EXPAND_STATE.booleanValue() : SharedPreferencesCompat.getInstance("Composer").getBoolean(this.mSharedPrefID, DEFAULT_EXPAND_STATE.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetViews() {
        if (getView() == null) {
            return;
        }
        getCollapseView().setTranslationX(0.0f);
        getCollapseView().setTranslationY(0.0f);
        getExpandView().setTranslationX(0.0f);
        getExpandView().setTranslationY(0.0f);
        getView().setAlpha(1.0f);
    }

    private void setExpandState(boolean z) {
        if (this.mSharedPrefID == null) {
            return;
        }
        SharedPreferencesCompat.getInstance("Composer").putBoolean(this.mSharedPrefID, z);
    }

    public void collapseView() {
        beginDelayedTransition();
        setExpandView(false);
        AnchorInfo anchorInfo = this.mAnchorInfo;
        if (anchorInfo != null) {
            this.mSettingViewManager.updateLayoutParam(anchorInfo, getView(), this.mCollapseListener);
        } else {
            this.mSettingViewManager.updateLayoutParam(getCallerType(), getView(), this.mCollapseListener);
        }
    }

    public void expandView() {
        beginDelayedTransition();
        setExpandView(true);
        AnchorInfo anchorInfo = this.mAnchorInfo;
        if (anchorInfo != null) {
            this.mSettingViewManager.updateLayoutParam(anchorInfo, getView(), this.mExpandListener);
        } else {
            this.mSettingViewManager.updateLayoutParam(getCallerType(), getView(), this.mExpandListener);
        }
    }

    @NonNull
    public abstract View getCollapseView();

    @NonNull
    public abstract View getExpandView();

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean z) {
        super.hide(z);
        this.mAnchorInfo = null;
        resetViews();
        getSettingInstance().removePreTouchListener(this.mPreTouchListener);
    }

    public boolean intersects(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        getView().getLocationOnScreen(iArr);
        Rect rect = new Rect(0, 0, getView().getWidth(), getView().getHeight());
        rect.offset(iArr[0], iArr[1]);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    public boolean isExpand() {
        return getExpandView().getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout
    public void setAnchorInfo(AnchorInfo anchorInfo) {
        super.setAnchorInfo(anchorInfo);
        this.mAnchorInfo = new AnchorInfo(anchorInfo);
    }

    public void setEnableSwipeSwitchCompat(final SwitchCompat switchCompat) {
        switchCompat.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.AbsHwSettingAnchorExpansionLayout.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    switchCompat.getParent().requestDisallowInterceptTouchEvent(true);
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    switchCompat.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        });
    }

    public void setExpandView(boolean z) {
        getExpandView().setVisibility(z ? 0 : 8);
        getCollapseView().setVisibility(z ? 8 : 0);
        setExpandState(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        super.show(i, view, z);
        resetViews();
        setExpandView(isExpandState());
        getSettingInstance().addPreTouchListener(this.mPreTouchListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void updatePosition(int i, View view, boolean z) {
        AnchorInfo anchorInfo = this.mAnchorInfo;
        if (anchorInfo != null) {
            this.mSettingViewManager.updateLayoutParam(anchorInfo, getView(), z ? this.mMoveListener : null);
        } else {
            this.mSettingViewManager.updateLayoutParam(getCallerType(), getView(), z ? this.mMoveListener : null);
        }
    }

    public AbsHwSettingAnchorExpansionLayout(String str) {
        initAnimationListener();
        this.mSharedPrefID = str;
    }
}
