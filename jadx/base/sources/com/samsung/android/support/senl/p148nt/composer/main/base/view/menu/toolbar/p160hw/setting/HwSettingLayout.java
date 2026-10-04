package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.TransitionManager;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterContainer;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.common.HwInOutVI;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class HwSettingLayout {
    protected static final float DISABLED_ALPHA = 0.4f;
    protected static final float ENABLED_ALPHA = 1.0f;
    private int mCallerType;
    protected FloaterContainer mFloatingContainer;
    protected ISettingViewManager mSettingViewManager;
    private int mViewId;
    WritingToolManager mWritingToolManager;

    public void addViewToFloatingContainer(View view) {
        this.mFloatingContainer.addView(view);
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.mFloatingContainer);
        constraintSet.connect(view.getId(), 6, 0, 6);
        constraintSet.connect(view.getId(), 7, 0, 7);
        constraintSet.connect(view.getId(), 3, 0, 3);
        constraintSet.connect(view.getId(), 4, 0, 4);
        constraintSet.applyTo(this.mFloatingContainer);
    }

    public ViewGroup addWrappingScrollView(int i) {
        ScrollWrapperView scrollWrapperView = new ScrollWrapperView(this.mFloatingContainer.getContext(), i);
        this.mFloatingContainer.addView(scrollWrapperView.getView());
        return scrollWrapperView.getView();
    }

    public ViewGroup addWrappingViewGroup(View view) {
        ViewGroupWrapperView viewGroupWrapperView = new ViewGroupWrapperView(this.mFloatingContainer.getContext(), view);
        this.mFloatingContainer.addView(viewGroupWrapperView.getView());
        return viewGroupWrapperView.getView();
    }

    public boolean cancel() {
        return false;
    }

    public abstract void close();

    public int getCallerType() {
        return this.mCallerType;
    }

    public HwSettingPresenter getSettingInstance() {
        ISettingViewManager iSettingViewManager = this.mSettingViewManager;
        if (iSettingViewManager == null) {
            return null;
        }
        return iSettingViewManager.getSettingInstance();
    }

    public int getViewId() {
        return this.mViewId;
    }

    public abstract void hide(boolean z);

    public void inOutVI(final ViewGroup viewGroup, boolean z) {
        if (z) {
            TransitionManager.endTransitions(viewGroup);
            if (viewGroup.isLaidOut()) {
                TransitionManager.beginDelayedTransition(viewGroup, new HwInOutVI());
            } else {
                viewGroup.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingLayout.1
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
                        new HwInOutVI(1).getAnimator(viewGroup).start();
                        return true;
                    }
                });
            }
        }
    }

    public abstract void init();

    public boolean isCalledFromToolbarInPenMiniMode(int i) {
        return isPenMiniMode() && i != 0;
    }

    public boolean isPenMiniMode() {
        return this.mSettingViewManager.isTabletLayout() && this.mSettingViewManager.getSettingInfoManager().getPenMiniMenuData().isEnable();
    }

    public abstract boolean isVisible();

    public boolean onTouchOutside() {
        hide(true);
        return true;
    }

    public void setCallerType(int i) {
        this.mCallerType = i;
    }

    public void setColorTheme(int i) {
    }

    public void setEnabled(View view, boolean z) {
        view.setEnabled(z);
        view.setAlpha(z ? 1.0f : 0.4f);
    }

    public void setEnabledSettingView(boolean z) {
    }

    public void setFloatingContainer(FloaterContainer floaterContainer) {
        this.mFloatingContainer = floaterContainer;
    }

    public void setRotation(int i, View view, View view2) {
    }

    public void setSettingViewManager(ISettingViewManager iSettingViewManager) {
        this.mSettingViewManager = iSettingViewManager;
    }

    public void setViewId(int i) {
        this.mViewId = i;
    }

    public void setWritingToolManager(WritingToolManager writingToolManager) {
        this.mWritingToolManager = writingToolManager;
    }

    public abstract void show(int i, View view, boolean z);

    public void update(int i, View view, boolean z) {
    }

    public abstract void updatePosition(int i, View view, boolean z);
}
