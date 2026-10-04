package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionManager;
import com.samsung.android.sesl.visualeffect.ScanningEffectView;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.common.HwInOutVI;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.animation.ScanningAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.view.FrameLayoutEventWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiContextMenu implements View.OnLayoutChangeListener {
    private static final String TAG = Logger.createTag("AiContextMenu", AiConstants.PREFIX_TAG);
    private Activity mActivity;
    private View mContainer;
    private Rect mLastContentRect;
    private MenuView mMenuView;
    private AiContextMenuPresenter mPresenter;
    private final ScanningAnimation mScanningAnimation = new ScanningAnimation(TAG);
    private Runnable mUpdateMenuRunnable;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class HwMenuView extends MenuView {
        View mBottomBase;
        View mVIewRequiresFocus;

        public HwMenuView() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.MenuView
        public View getViewRequiresFocus() {
            return this.mVIewRequiresFocus;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.MenuView
        public void init(Activity activity, View view) {
            super.init(activity, view);
            initTopDocker(activity, view);
            this.mContainer = view;
            this.mView = (ViewGroup) activity.findViewById(C9086R.id.ai_menu_context_hw_container);
            if (Build.VERSION.SDK_INT >= 33 && AiViewUtils.isAtLeastOneUI7()) {
                if (activity.findViewById(C9086R.id.ai_context_container) == null) {
                    ViewGroup viewGroup = (ViewGroup) activity.findViewById(C9086R.id.ai_menu_context_container);
                    viewGroup.removeView(this.mView);
                    this.mView.setVisibility(0);
                    final ViewGroup viewGroup2 = this.mView;
                    ViewGroup newStyleLayout = OptionMenuPopupWindowHelper.getNewStyleLayout(activity, viewGroup2);
                    this.mView = newStyleLayout;
                    final FrameLayout frameLayout = (FrameLayout) newStyleLayout.findViewById(C9086R.id.ai_context_background_layout);
                    final FrameLayoutEventWrapper frameLayoutEventWrapper = (FrameLayoutEventWrapper) this.mView.findViewById(C9086R.id.ai_context_action_list_container85);
                    OptionMenuPopupWindowHelper.initGuidingLightEffect(this.mView.getContext(), frameLayout, frameLayoutEventWrapper);
                    viewGroup.addView(this.mView);
                    if (AiViewUtils.isAtLeastOneUI85()) {
                        viewGroup2.setBackgroundResource(C9086R.drawable.ai_menu_toolbar_bg_oneui_85);
                        viewGroup2.setClipToOutline(true);
                        frameLayout.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.HwMenuView.1
                            @Override // java.lang.Runnable
                            public void run() {
                                int width = frameLayout.getWidth();
                                int height = frameLayout.getHeight();
                                if (width <= 0 || height <= 0) {
                                    return;
                                }
                                ((ViewGroup) viewGroup2.getParent()).removeView(viewGroup2);
                                frameLayout.getLayoutParams().width = width;
                                frameLayout.getLayoutParams().height = height;
                                frameLayoutEventWrapper.addView(viewGroup2);
                                viewGroup2.setClipToOutline(true);
                                frameLayoutEventWrapper.requestLayout();
                            }
                        });
                    }
                } else {
                    this.mView = (ViewGroup) activity.findViewById(C9086R.id.ai_context_container);
                }
            }
            this.mMenuViews = new ArrayList();
            this.mBottomBase = activity.findViewById(C9086R.id.main_layout_container);
            final View viewFindViewById = this.mView.findViewById(C9086R.id.ai_menu_btn_clean_up_hw);
            this.mMenuViews.add(viewFindViewById);
            this.mVIewRequiresFocus = viewFindViewById;
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.HwMenuView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AiContextMenu.this.mPresenter.cleanUpHw();
                    ComposerSA.insertLog("411", ComposerSAConstants.EVENT_AI_CLEANUP_HANDWRITING);
                }
            });
            View viewFindViewById2 = this.mView.findViewById(C9086R.id.ai_menu_btn_clean_up_text);
            this.mMenuViews.add(viewFindViewById2);
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.HwMenuView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AiContextMenu.this.mPresenter.cleanUpText();
                    ComposerSA.insertLog("411", ComposerSAConstants.EVENT_AI_CONVERT_TO_TEXT);
                }
            });
            if (viewFindViewById.isLaidOut()) {
                updateContainerWidth();
            } else {
                viewFindViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.HwMenuView.4
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (viewFindViewById.getMeasuredWidth() > 0) {
                            viewFindViewById.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            HwMenuView.this.updateContainerWidth();
                        }
                    }
                });
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.MenuView
        public void updateEachPosition(Rect rect) {
            rect.bottom += getTopDockerHeight();
            float dimensionPixelSize = this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_context_vertical_margin);
            float width = (this.mContainer.getWidth() / 2.0f) - (this.mView.getWidth() / 2.0f);
            float fMin = rect.bottom + dimensionPixelSize;
            if (this.mView.getHeight() + fMin + dimensionPixelSize > this.mBottomBase.getHeight()) {
                fMin = (Math.min(rect.bottom, this.mBottomBase.getHeight()) - this.mView.getHeight()) - dimensionPixelSize;
                int i = rect.top;
                if (i >= fMin && i <= this.mView.getHeight() + fMin) {
                    fMin = (rect.top - this.mView.getHeight()) - dimensionPixelSize;
                }
            }
            if (fMin < 0.0f) {
                fMin = 0.0f;
            }
            this.mView.setX(width);
            this.mView.setY(fMin);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class MenuView {
        View mContainer;
        List<View> mMenuViews;
        boolean mNeedToUpdatePositionAfterInit;
        View mTopDocker;
        ViewGroup mView;

        /* JADX INFO: Access modifiers changed from: private */
        public void requestFocus() {
            View viewRequiresFocus = getViewRequiresFocus();
            if (viewRequiresFocus == null) {
                return;
            }
            viewRequiresFocus.sendAccessibilityEvent(8);
        }

        public int getTopDockerHeight() {
            View view = this.mTopDocker;
            if (view == null || view.getHeight() < 0) {
                return 0;
            }
            return this.mTopDocker.getHeight();
        }

        public abstract View getViewRequiresFocus();

        public void hide() {
            inOutVI();
            this.mView.setVisibility(8);
        }

        public void inOutVI() {
            TransitionManager.endTransitions(this.mView);
            if (!this.mView.isLaidOut()) {
                this.mView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.MenuView.3
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        MenuView.this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
                        Animator animator = new HwInOutVI(1).getAnimator(MenuView.this.mView);
                        animator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.MenuView.3.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                super.onAnimationEnd(animator2);
                                MenuView.this.requestFocus();
                            }
                        });
                        animator.start();
                        return true;
                    }
                });
                return;
            }
            HwInOutVI hwInOutVI = new HwInOutVI();
            hwInOutVI.addListener(new TransitionListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.MenuView.2
                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionEnd(@NonNull Transition transition) {
                    super.onTransitionEnd(transition);
                    MenuView.this.requestFocus();
                }
            });
            TransitionManager.beginDelayedTransition(this.mView, hwInOutVI);
        }

        public void init(Activity activity, View view) {
            this.mNeedToUpdatePositionAfterInit = true;
        }

        public void initTopDocker(Activity activity, View view) {
            this.mTopDocker = activity.findViewById(C9086R.id.top_docker);
            if (((View) view.getParent()).getId() == C9086R.id.main_layout_container) {
                this.mTopDocker = null;
            }
        }

        public void show() {
            inOutVI();
            this.mView.setVisibility(0);
        }

        public void updateContainerWidth() {
            List<View> list = this.mMenuViews;
            if (list == null) {
                return;
            }
            int size = list.size();
            int measuredWidth = 0;
            for (int i = 0; i < size; i++) {
                View view = this.mMenuViews.get(i);
                if (view.getVisibility() == 0 && measuredWidth < view.getMeasuredWidth()) {
                    measuredWidth = view.getMeasuredWidth();
                }
            }
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = this.mMenuViews.get(i2);
                if (view2.getVisibility() == 0 && view2.getMeasuredWidth() < measuredWidth) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    view2.setLayoutParams(layoutParams);
                }
            }
        }

        public abstract void updateEachPosition(Rect rect);

        public void updatePosition(final Rect rect) {
            ViewGroup viewGroup = this.mView;
            if (viewGroup == null || this.mContainer == null) {
                Logger.m11000e(AiContextMenu.TAG, "updatePosition# mView is null");
                return;
            }
            if (!viewGroup.isLaidOut() || this.mNeedToUpdatePositionAfterInit) {
                this.mView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.MenuView.1
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                        view.removeOnLayoutChangeListener(this);
                        MenuView.this.updateEachPosition(rect);
                    }
                });
            } else {
                updateEachPosition(rect);
            }
            this.mNeedToUpdatePositionAfterInit = false;
        }

        public void updateSubPopup() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class TextMenuView extends MenuView {
        public TextMenuView() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.MenuView
        public View getViewRequiresFocus() {
            return null;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.MenuView
        public void hide() {
            AiContextMenu.this.mPresenter.hideContainerSelectNext();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.MenuView
        public void init(Activity activity, View view) {
            super.init(activity, view);
            this.mContainer = view;
            if (ResourceUtils.isTabletLayout(AiContextMenu.this.mActivity)) {
                this.mView = (ViewGroup) AiContextMenu.this.mActivity.findViewById(C9086R.id.comp_next_scroll_button_container);
                return;
            }
            this.mView = (ViewGroup) this.mContainer.findViewById(C9086R.id.ai_menu_context_rt_container);
            this.mMenuViews = new ArrayList();
            this.mMenuViews.add(this.mView.findViewById(C9086R.id.ai_menu_btn_autoformat));
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.MenuView
        public void show() {
            AiContextMenu.this.mPresenter.showContainerSelectNext();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.MenuView
        public void updateEachPosition(Rect rect) {
            float height;
            if (ResourceUtils.isTabletLayout(AiContextMenu.this.mActivity)) {
                rect.bottom += getTopDockerHeight();
                float dimensionPixelSize = this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_context_right_boundary_margin);
                float dimensionPixelSize2 = this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_context_water_drop_width);
                int height2 = this.mContainer.getHeight() / 2;
                int i = rect.bottom;
                if (height2 < i) {
                    height = ((rect.bottom - this.mView.getHeight()) - 0.0f) - this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_context_water_drop_height);
                } else {
                    height = i + 0.0f;
                }
                float width = rect.right - (dimensionPixelSize2 * 2.0f);
                float width2 = this.mContainer.getWidth() - dimensionPixelSize;
                if (width2 < this.mView.getWidth() + width) {
                    width = width2 - this.mView.getWidth();
                }
                float height3 = this.mContainer.getHeight() - 0.0f;
                if (height3 < this.mView.getHeight() + height) {
                    height = height3 - this.mView.getHeight();
                }
                if (height < 0.0f) {
                    width = (this.mContainer.getWidth() / 2.0f) - (this.mView.getWidth() / 2.0f);
                }
                this.mView.setX(Math.max(0.0f, width));
                this.mView.setY(Math.max(0.0f, height));
                Logger.m10999d(AiContextMenu.TAG, "updateEachPosition# " + this.mView.getX() + "/" + this.mView.getY() + " " + this.mContainer.getWidth() + "/" + this.mContainer.getHeight());
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.MenuView
        public void updateSubPopup() {
        }
    }

    private void init(Activity activity, boolean z) {
        this.mActivity = activity;
        this.mContainer = activity.findViewById(C9086R.id.ai_menu_context_container);
        this.mUpdateMenuRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.1
            @Override // java.lang.Runnable
            public void run() {
                if (AiContextMenu.this.mLastContentRect == null || AiContextMenu.this.mLastContentRect.isEmpty() || !AiContextMenu.this.isShowing()) {
                    return;
                }
                AiContextMenu.this.mMenuView.updatePosition(AiContextMenu.this.mLastContentRect);
                AiContextMenu.this.mMenuView.updateSubPopup();
            }
        };
        if (z) {
            initHw(activity);
        } else {
            initText(activity);
        }
        this.mScanningAnimation.clearFlag();
    }

    private void initHw(Activity activity) {
        if (this.mMenuView instanceof HwMenuView) {
            return;
        }
        HwMenuView hwMenuView = new HwMenuView();
        this.mMenuView = hwMenuView;
        hwMenuView.init(activity, this.mContainer);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initScanningEffectView(Activity activity) {
        if (Build.VERSION.SDK_INT < 33) {
            return;
        }
        ViewStub viewStub = (ViewStub) activity.findViewById(C9086R.id.scanning_effect_view_stub);
        if (viewStub != null) {
            Logger.m10999d(TAG, "initScanningEffectView# inflate");
            viewStub.inflate();
        }
        if (this.mScanningAnimation.getScanningEffectView() == null) {
            this.mScanningAnimation.setScanningEffectView((ScanningEffectView) activity.findViewById(C9086R.id.scanning_effect_view));
        }
        if (this.mScanningAnimation.getScanningEffectView() != null) {
            this.mScanningAnimation.getScanningEffectView().setVisibility(0);
            this.mScanningAnimation.getScanningEffectView().setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenu.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return AiContextMenu.this.mScanningAnimation.isScanningAnimating();
                }
            });
        }
    }

    private void initText(Activity activity) {
        if (this.mMenuView instanceof TextMenuView) {
            return;
        }
        TextMenuView textMenuView = new TextMenuView();
        this.mMenuView = textMenuView;
        textMenuView.init(activity, this.mContainer);
        initScanningEffectView(activity);
    }

    public void hide() {
        MenuView menuView = this.mMenuView;
        if (menuView == null) {
            return;
        }
        menuView.hide();
        this.mPresenter.onHide();
        this.mMenuView = null;
        this.mLastContentRect = null;
        this.mContainer.removeOnLayoutChangeListener(this);
        this.mPresenter.getHandler().removeCallbacks(this.mUpdateMenuRunnable);
        if (this.mScanningAnimation.getScanningEffectView() == null || this.mScanningAnimation.getScanningAnimationToken() == null || !this.mScanningAnimation.getScanningAnimationToken().isExpired() || this.mScanningAnimation.isScanningAnimating()) {
            return;
        }
        this.mScanningAnimation.getScanningEffectView().setVisibility(8);
    }

    public boolean isShowing() {
        return this.mMenuView != null;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i8 - i6 == i4 - i && i9 - i7 == i5 - i2) {
            return;
        }
        Logger.m10999d(TAG, "onLayoutChange# ");
        this.mPresenter.getHandler().removeCallbacks(this.mUpdateMenuRunnable);
        this.mPresenter.getHandler().post(this.mUpdateMenuRunnable);
    }

    public void setPresenter(AiContextMenuPresenter aiContextMenuPresenter) {
        this.mPresenter = aiContextMenuPresenter;
        aiContextMenuPresenter.setView(this);
    }

    public void setVisible(boolean z) {
        MenuView menuView = this.mMenuView;
        if (menuView == null) {
            Logger.m11000e(TAG, "setVisible# mMenuView is null");
        } else if (z) {
            menuView.show();
        } else {
            menuView.hide();
        }
    }

    public void show(Activity activity, boolean z) {
        init(activity, z);
        this.mContainer.addOnLayoutChangeListener(this);
    }

    public boolean showScanningEffectView() {
        if (AiViewUtils.isAtLeastOneUI7() || this.mPresenter.getScanningAnimationTargetView() == null || Build.VERSION.SDK_INT < 33) {
            return false;
        }
        return this.mScanningAnimation.showScanningEffectView(this.mActivity, this.mPresenter.getScanningAnimationTargetView());
    }

    public void showSwitchContentForOverlay() {
        this.mPresenter.showContainerSelectNext();
        this.mPresenter.getContentSwitcher().setEnableSwitchContentButton();
    }

    public void updatePosition(RectF rectF) {
        if (this.mMenuView == null) {
            Logger.m11000e(TAG, "updatePosition# mMenuView is null");
            return;
        }
        Rect rect = new Rect();
        rectF.round(rect);
        this.mMenuView.updatePosition(rect);
        this.mLastContentRect = rect;
    }
}
