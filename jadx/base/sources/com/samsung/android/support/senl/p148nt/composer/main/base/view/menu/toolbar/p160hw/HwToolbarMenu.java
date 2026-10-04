package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.HorizontalScrollView;
import androidx.annotation.NonNull;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut33;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistAsButton;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterContainer;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsAsyncInflater;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AllSideToolbarContainerLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.p159vi.ToggleDockingAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarOrderManager;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarMenu extends AbsAsyncInflater implements HwToolbarContract.IView, HwToolbarItemManager.IHwToolbarMenu {
    private static final String TAG = Logger.createTag("HwToolbarMenu");
    protected final Activity mActivity;
    protected final HwToolbarOrderManager.ComponentFactory mComponentFactory;
    private HwFavoritePreview mFavoritePreview;
    protected FloaterContainer mFloatingArea;
    protected AbsToolbarContainerLayout mFloatingContainer;
    private HorizontalScrollView mHorizontalScrollView;
    protected View mHwMenusView;
    protected HwToolbarItemManager mHwToolbarItemManager;
    private boolean mIsShowAnimation;
    protected ViewGroup mMenuItems;
    protected final HwToolbarPresenterImpl mPresenter;
    private HwToolbarContract.QtHwToolbarStateListener mQTListener;
    private AlphaAnimation mShowHideAnimation;
    protected View mToggleClickBtn;
    private ToggleDockingAnimation mToggleDockingAnimation;
    protected final IToolbarManager mToolbarManager;

    public HwToolbarMenu(Activity activity, ViewGroup viewGroup, IToolbarManager iToolbarManager, HwToolbarPresenterImpl hwToolbarPresenterImpl, @NonNull HwToolbarOrderManager.ComponentFactory componentFactory) {
        super(viewGroup.getContext());
        this.mActivity = activity;
        this.mToolbarManager = iToolbarManager;
        this.mPresenter = hwToolbarPresenterImpl;
        this.mComponentFactory = componentFactory;
        init(viewGroup);
    }

    private void initInternal() {
        if (this.mPresenter.isTabletLayout()) {
            initModeChangeForRotate();
            saLoggingPenSettingType();
        } else {
            initToggleBtn();
        }
        this.mFavoritePreview = new HwFavoritePreview();
    }

    private void initModeChangeForRotate() {
        AbsToolbarContainerLayout absToolbarContainerLayout = this.mFloatingContainer;
        if (absToolbarContainerLayout == null) {
            return;
        }
        absToolbarContainerLayout.addModeChangeListener(new IFloater.ModeChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.HwToolbarMenu.4
            @Override // com.samsung.android.support.senl.nt.base.winset.view.floater.IFloater.ModeChangeListener
            public void onModeChanged(int i) {
                AbsToolbarContainerLayout absToolbarContainerLayout2 = HwToolbarMenu.this.mFloatingContainer;
                if (absToolbarContainerLayout2 instanceof AllSideToolbarContainerLayout) {
                    ((AllSideToolbarContainerLayout) absToolbarContainerLayout2).changeDockTypeParam();
                }
                HwToolbarItemManager hwToolbarItemManager = HwToolbarMenu.this.mHwToolbarItemManager;
                if (hwToolbarItemManager != null) {
                    hwToolbarItemManager.updateItemLayout(i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEndAlphaAnimation() {
        View view = this.mHwMenusView;
        if (view != null) {
            if (this.mIsShowAnimation) {
                view.setVisibility(0);
                onShown();
            } else {
                view.setVisibility(8);
            }
        }
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null && this.mIsShowAnimation) {
            hwToolbarItemManager.onShown();
        }
        ViewGroup viewGroup = this.mMenuItems;
        if (viewGroup != null) {
            viewGroup.setAlpha(1.0f);
            this.mMenuItems.clearAnimation();
        }
        View view2 = this.mToggleClickBtn;
        if (view2 != null) {
            view2.setEnabled(true);
            if (this.mIsShowAnimation) {
                this.mToggleClickBtn.requestFocus();
            }
            ViewCompat.getInstance().setTooltipText(this.mToggleClickBtn);
        }
        AbstractC8014b.m7215q(new StringBuilder("run alpha : end, "), this.mIsShowAnimation, TAG);
    }

    private void onShown() {
        if (this.mPresenter.isDeleteOnlyState()) {
            updateDeleteOnlyState(true);
        }
        if (this.mPresenter.isMoveOnlyState()) {
            updateMoveOnlyState(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStartAlphaAnimation() {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            hwToolbarItemManager.show();
        }
    }

    private void runAlphaAnimation(float f, float f4) {
        if (this.mMenuItems == null || this.mHwMenusView == null) {
            return;
        }
        this.mIsShowAnimation = f4 == 1.0f;
        AlphaAnimation alphaAnimation = this.mShowHideAnimation;
        if (alphaAnimation != null && alphaAnimation.hasStarted() && !this.mShowHideAnimation.hasEnded()) {
            this.mShowHideAnimation.cancel();
        }
        this.mMenuItems.clearAnimation();
        if (!this.mIsShowAnimation && this.mHwMenusView.getVisibility() != 0) {
            Logger.m10999d(TAG, "run alpha : already hided");
            if (this.mHwMenusView.getVisibility() == 4) {
                this.mHwMenusView.setVisibility(8);
                return;
            }
            return;
        }
        Logger.m10999d(TAG, "run alpha : " + f + " -> " + f4);
        Activity activity = this.mActivity;
        if (activity != null && !activity.hasWindowFocus()) {
            onEndAlphaAnimation();
            return;
        }
        if (this.mIsShowAnimation) {
            this.mHwMenusView.setVisibility(0);
            this.mHwMenusView.bringToFront();
        }
        View view = this.mToggleClickBtn;
        if (view != null) {
            view.setEnabled(false);
        }
        if (!ValueAnimator.areAnimatorsEnabled()) {
            onStartAlphaAnimation();
            this.mMenuItems.setAlpha(f4);
            onEndAlphaAnimation();
        } else {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(f, f4);
            this.mShowHideAnimation = alphaAnimation2;
            alphaAnimation2.setDuration(150L);
            this.mShowHideAnimation.setInterpolator(new SineInOut33());
            this.mShowHideAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.HwToolbarMenu.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    HwToolbarMenu.this.onEndAlphaAnimation();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    HwToolbarMenu.this.onStartAlphaAnimation();
                }
            });
            this.mMenuItems.startAnimation(this.mShowHideAnimation);
        }
    }

    private void saLoggingPenSettingType() {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager == null) {
            return;
        }
        if (!hwToolbarItemManager.getSettingInstance().getSettingInfoManager().getPenMiniMenuData().isEnable()) {
            ComposerSA.insertStatusLog(HWToolbarSAConstants.EVENT_STATUS_TABLET_PEN_SETTINGS, "a");
        } else if (this.mHwToolbarItemManager.getSettingInstance().getSettingInfoManager().getPenMiniMenuData().isFavoriteMode()) {
            ComposerSA.insertStatusLog(HWToolbarSAConstants.EVENT_STATUS_TABLET_PEN_SETTINGS, "c");
        } else {
            ComposerSA.insertStatusLog(HWToolbarSAConstants.EVENT_STATUS_TABLET_PEN_SETTINGS, "b");
        }
    }

    private void showAction() {
        if (this.mHwMenusView != null) {
            runAlphaAnimation(0.0f, 1.0f);
        } else {
            Logger.m10999d(TAG, "mHwMenusView or mHwToolbarItemManager is null");
        }
        if (this.mToggleDockingAnimation != null && !this.mPresenter.isTabletLayout()) {
            this.mToggleDockingAnimation.resetView(this.mPresenter.isDockingMode());
        }
        Logger.m10999d(TAG, "show done");
    }

    private void updateToggleBtn(boolean z) {
        if (this.mToggleClickBtn == null || !isShowing() || this.mPresenter.isTabletLayout()) {
            return;
        }
        this.mToggleDockingAnimation.update(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void callOnSelected(int i) {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            hwToolbarItemManager.onSelected(i);
            this.mHorizontalScrollView.scrollTo(this.mHwToolbarItemManager.getView(i).getLeft() - this.mHwToolbarItemManager.getView(i).getWidth(), 0);
        }
    }

    public void clearSelectedButtonsToolbarItem() {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            hwToolbarItemManager.clearSelectedButtonsToolbarItem();
        }
    }

    public void close() {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager == null) {
            return;
        }
        hwToolbarItemManager.hide();
    }

    public HwToolbarItemManager createHwToolbarItemManager() {
        return new HwToolbarItemManager(this.mActivity, this.mFloatingContainer, this.mFloatingArea, this.mMenuItems, this.mPresenter, this, this.mComponentFactory);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void dismissSmartTip() {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager == null) {
            return;
        }
        hwToolbarItemManager.dismissSmartTip();
    }

    public void enableDockingMode(boolean z) {
        this.mPresenter.enableDockingMode(z);
        updateToggleBtn(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void executeAiAssist() {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            hwToolbarItemManager.executeAiAssist();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void executePenSetting() {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            hwToolbarItemManager.executePenSetting();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void executeRemoteEraser() {
        HwToolbarItemManager hwToolbarItemManager;
        if (!this.mFloatingContainer.isShowing() || (hwToolbarItemManager = this.mHwToolbarItemManager) == null) {
            return;
        }
        hwToolbarItemManager.executeRemoteEraser();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItemManager.IHwToolbarMenu
    public int getColorTheme(int i) {
        return this.mToolbarManager.getColorTheme(i);
    }

    public int getDeltaToAvoidOverlap(int i, int i2) {
        return this.mHwToolbarItemManager.getDeltaToAvoidOverlap(i, i2);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public View getToolbarView() {
        return this.mHwMenusView;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItemManager.IHwToolbarMenu
    public View getView() {
        return this.mHwMenusView;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void hide() {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager == null) {
            return;
        }
        hwToolbarItemManager.hideAll();
        this.mHwToolbarItemManager.closeHandwritingSpecialButtons();
        this.mHwToolbarItemManager.dismissSmartTip();
        runAlphaAnimation(1.0f, 0.0f);
        if (this.mToggleClickBtn != null) {
            ViewCompat.getInstance().setTooltipText(this.mToggleClickBtn, "");
        }
        Logger.m10999d(TAG, "hide done");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItemManager.IHwToolbarMenu
    public void hideDirectWrite() {
        this.mToolbarManager.hideDirectWrite();
    }

    public void hidePopups() {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager == null) {
            return;
        }
        hwToolbarItemManager.hide();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void hidePopupsWithSpoid() {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager == null) {
            return;
        }
        hwToolbarItemManager.hideAll();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void hideSettingPenMini() {
        this.mToolbarManager.hideSettingPenMini();
    }

    public void init(View view) {
        FloaterContainer floaterContainer = (FloaterContainer) view.findViewById(C9086R.id.floating_layout_container);
        this.mFloatingArea = floaterContainer;
        AbsToolbarContainerLayout absToolbarContainerLayout = (AbsToolbarContainerLayout) floaterContainer.findViewById(C9086R.id.floating_layout);
        this.mFloatingContainer = absToolbarContainerLayout;
        asyncInflate(C9086R.layout.comp_hw_floating_menu, absToolbarContainerLayout);
        this.mPresenter.setView(this);
        this.mToolbarManager.setSpenColorThemeUtil(this.mPresenter.getColorTheme());
    }

    public void initToggleBtn() {
        View viewFindViewById = this.mHwMenusView.findViewById(C9086R.id.hw_toolbar_toggleClickBtn);
        this.mToggleClickBtn = viewFindViewById;
        if (viewFindViewById == null) {
            return;
        }
        ((View) viewFindViewById.getParent()).setVisibility(this.mPresenter.isTextButtonEnabled() ? 0 : 8);
        ViewCompat.getInstance().setShadowAlpha(this.mToggleClickBtn, 0.5f);
        this.mToggleDockingAnimation = new ToggleDockingAnimation(this.mToggleClickBtn);
        ViewCompat.getInstance().setTooltipText(this.mToggleClickBtn);
        this.mToggleClickBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.HwToolbarMenu.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HwToolbarMenu.this.mToolbarManager.canNotChangeMode()) {
                    Logger.m11003i(HwToolbarMenu.TAG, "toggle button is clicked but blocked");
                    return;
                }
                HwToolbarMenu.this.clearSelectedButtonsToolbarItem();
                HwToolbarMenu.this.mPresenter.releaseAssistPopup();
                if (!HwToolbarMenu.this.mPresenter.isTextMode()) {
                    HwToolbarMenu.this.mPresenter.changeTextMode();
                } else if (!HwToolbarMenu.this.mPresenter.isShownSoftInput()) {
                    HwToolbarMenu.this.mPresenter.showSoftInput();
                }
                ComposerSA.insertLog(ComposerSA.getScreenID(true, true, HwToolbarMenu.this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_TEXT);
            }
        });
        this.mToggleClickBtn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.HwToolbarMenu.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.mToggleClickBtn.setAccessibilityDelegate(new VoiceAssistAsButton());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItemManager.IHwToolbarMenu
    public boolean isDirectWriteUsing() {
        return this.mToolbarManager.isDirectWriteUsing();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public boolean isSelected(int i) {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager == null) {
            return false;
        }
        return hwToolbarItemManager.isSelected(i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public boolean isShowing() {
        View view = this.mHwMenusView;
        return view != null && view.getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItemManager.IHwToolbarMenu
    public boolean isSupportDirectWrite() {
        return this.mToolbarManager.isSupportDirectWrite(this.mActivity);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItemManager.IHwToolbarMenu
    public boolean isTextMode() {
        return this.mPresenter.isTextMode();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void offEasyWritingPad() {
        this.mPresenter.offEasyWritingPad();
    }

    public boolean onBackPressed(boolean z) {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager == null) {
            return false;
        }
        return hwToolbarItemManager.onBackPressed(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            hwToolbarItemManager.onConfigurationChanged(configuration);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsAsyncInflater
    public void onInflated(View view) {
        IToolbarManager iToolbarManager;
        this.mHwMenusView = view.findViewById(C9086R.id.hw_toolbar_menu_container);
        this.mHorizontalScrollView = (HorizontalScrollView) view.findViewById(C9086R.id.hw_toolbar_scroll_view);
        this.mMenuItems = (ViewGroup) view.findViewById(C9086R.id.hw_toolbar_menu_item_container);
        this.mHwToolbarItemManager = createHwToolbarItemManager();
        initInternal();
        if (this.mActivity == null || (iToolbarManager = this.mToolbarManager) == null) {
            return;
        }
        setColorTheme(iToolbarManager.getBackgroundColor(), this.mToolbarManager.isBackgroundColorInverted(), this.mToolbarManager.hasBackgroundImage());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void onItemSelected(int i) {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            hwToolbarItemManager.onItemSelected(i);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItemManager.IHwToolbarMenu
    public void onMovePosition(View view) {
        this.mHorizontalScrollView.scrollTo(view.getLeft(), 0);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void onNoteAssistClick(Runnable runnable) {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            hwToolbarItemManager.doActionAfterDismissKeyguard(runnable);
        }
    }

    public void onOrientationChanged(int i, int i2) {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            hwToolbarItemManager.onOrientationChanged(i, i2);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            hwToolbarItemManager.onSaveInstanceState(bundle);
        }
    }

    public void onSetToolbarPosition(Rect rect, boolean z) {
        this.mPresenter.setToolbarPosition(rect, z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public boolean onTouchOutside() {
        HwFavoritePreview hwFavoritePreview = this.mFavoritePreview;
        if (hwFavoritePreview != null && hwFavoritePreview.isShowing()) {
            this.mFavoritePreview.hideFavoritePenPreview();
        }
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager == null) {
            return false;
        }
        return hwToolbarItemManager.getMInAppSettingViewManager().onTouchOutside();
    }

    public void onWindowFocusChanged() {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            hwToolbarItemManager.onWindowFocusChanged();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void reboundSettingPenMiniVI() {
        this.mToolbarManager.reboundSettingPenMiniVI();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsAsyncInflater
    public void release() {
        super.release();
        HwToolbarPresenterImpl hwToolbarPresenterImpl = this.mPresenter;
        if (hwToolbarPresenterImpl != null) {
            hwToolbarPresenterImpl.release();
            this.mPresenter.setView(null);
        }
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            hwToolbarItemManager.release();
            this.mHwToolbarItemManager = null;
        }
    }

    public void reloadToolbarMenu() {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            hwToolbarItemManager.reloadItemOrderLayout();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItemManager.IHwToolbarMenu
    public void requestItemOnToolbarMenu(View view) {
        if (view == null) {
            return;
        }
        Rect rect = new Rect();
        view.getHitRect(rect);
        this.mHorizontalScrollView.requestChildRectangleOnScreen(view, rect, false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void restore(final Bundle bundle) {
        if (!isInflated()) {
            addPendingActionAfterInflate(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.HwToolbarMenu.1
                @Override // java.lang.Runnable
                public void run() {
                    HwToolbarMenu.this.restore(bundle);
                }
            });
            return;
        }
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            hwToolbarItemManager.restore(bundle);
            this.mHwToolbarItemManager.setOnUpdateQuickToolListener(this.mQTListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void setColorTheme(int i) {
        this.mToolbarManager.setSpenColorThemeUtil(i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItemManager.IHwToolbarMenu
    public void setDirectWrite(boolean z) {
        this.mToolbarManager.setDirectWrite(z);
    }

    public void setEnableToolTip(boolean z) {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager == null) {
            return;
        }
        hwToolbarItemManager.setEnableToolTip(z);
        if (this.mToggleClickBtn == null) {
            return;
        }
        if (z) {
            ViewCompat.getInstance().setTooltipText(this.mToggleClickBtn);
        } else {
            ViewCompat.getInstance().setTooltipText(this.mToggleClickBtn, "");
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void setQtHwToolbarStateListener(HwToolbarContract.QtHwToolbarStateListener qtHwToolbarStateListener) {
        this.mQTListener = qtHwToolbarStateListener;
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            hwToolbarItemManager.setOnUpdateQuickToolListener(qtHwToolbarStateListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void show() {
        if (!isInflated()) {
            addPendingActionAfterInflate(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.HwToolbarMenu.5
                @Override // java.lang.Runnable
                public void run() {
                    HwToolbarMenu.this.show();
                }
            });
            return;
        }
        if (!isShowing()) {
            showAction();
            HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
            if (hwToolbarItemManager != null) {
                hwToolbarItemManager.updateSettingInfo();
                if (this.mPresenter.isTextMode()) {
                    this.mHwToolbarItemManager.updatePenColorWithLastPenInfoInNote();
                }
            }
            if (this.mToggleClickBtn != null) {
                ViewCompat.getInstance().setTooltipText(this.mToggleClickBtn, "");
            }
        }
        View view = this.mToggleClickBtn;
        if (view != null) {
            view.setSelected(this.mPresenter.isTextMode());
        }
        if (this.mHwToolbarItemManager != null) {
            if (!this.mPresenter.isMoveOnlyMode()) {
                this.mHwToolbarItemManager.getSettingInstance().updateTextMode(this.mPresenter.isTextMode());
            }
            this.mHwToolbarItemManager.updateZoomLock();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItemManager.IHwToolbarMenu
    public void showDirectWrite() {
        this.mToolbarManager.showDirectWrite();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void showSettingPenMini() {
        this.mToolbarManager.showSettingPenMini();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void showSettingPopupOfLaserPen(boolean z, View.OnClickListener onClickListener) {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager == null) {
            return;
        }
        hwToolbarItemManager.getMInAppSettingViewManager().showSettingPopupOfLaserPen(z, onClickListener);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void toggleZoomLock() {
        HwToolbarItemManager hwToolbarItemManager;
        if (isShowing() && (hwToolbarItemManager = this.mHwToolbarItemManager) != null) {
            hwToolbarItemManager.toggleZoomLock();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void unselect(int i) {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            try {
                if (hwToolbarItemManager.getView(i).isSelected()) {
                    this.mHwToolbarItemManager.getView(i).callOnClick();
                }
            } catch (NoSuchElementException unused) {
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void updateBackgroundColor(int i, boolean z, boolean z2) {
        setColorTheme(i, z, z2);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void updateDeleteOnlyState(boolean z) {
        if (isShowing()) {
            if (z) {
                hidePopups();
                hideSettingPenMini();
            } else {
                showSettingPenMini();
            }
            HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
            if (hwToolbarItemManager != null) {
                hwToolbarItemManager.updateDeleteOnlyState(z);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void updateMoveOnlyState(boolean z) {
        HwToolbarItemManager hwToolbarItemManager;
        if (!isShowing() || (hwToolbarItemManager = this.mHwToolbarItemManager) == null) {
            return;
        }
        if (z) {
            hwToolbarItemManager.onSelected(2097152);
        } else {
            hwToolbarItemManager.onSelected(2);
        }
        this.mHwToolbarItemManager.getSettingInstance().changeMoveOnlyMode(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void updatePolicy(int i, boolean z) {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager == null) {
            return;
        }
        hwToolbarItemManager.updatePolicy(i, z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void updateRemoteFavoritePen(boolean z, int i) {
        if (!z) {
            ToastHandler.show(this.mFloatingContainer.getContext(), C9086R.string.hw_toolbar_no_favorite_pen, 0);
            return;
        }
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            this.mFavoritePreview.showFavoritePenPreview(this.mFloatingContainer, i, hwToolbarItemManager.getSettingInstance().getSelectedPenInfo());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void updateSelectionState(int i, boolean z, boolean z2) {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager == null) {
            return;
        }
        if (z) {
            hwToolbarItemManager.updateSelectionState(i, z2);
        } else {
            hwToolbarItemManager.setSelectMenu(i, false);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract.IView
    public void updateToolbarItemList() {
        HwToolbarItemManager hwToolbarItemManager = this.mHwToolbarItemManager;
        if (hwToolbarItemManager != null) {
            hwToolbarItemManager.updateToolbarItemList();
        }
    }

    private void setColorTheme(int i, boolean z, boolean z2) {
        Logger.m11003i(TAG, "setColorTheme# not supported");
    }
}
