package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.solvemath.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionManager;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.utils.ImageUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.solvemath.utils.SolveMathUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.common.HwInOutVI;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SolveMathResult implements View.OnLayoutChangeListener {
    private static final String TAG = Logger.createTag("SolveMathResult", AiConstants.PREFIX_TAG);
    private View mContainer;
    private Rect mLastPanelRect;
    private MenuView mMenuView;
    private Runnable mUpdateMenuRunnable;
    private int mVisibility;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback {
        void onCopyResult(Bitmap bitmap, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MenuView {
        Activity mActivity;
        View mContainer;
        List<View> mMenuViews;
        boolean mNeedToUpdatePositionAfterInit;
        View mResultContent;
        View mResultCopy;
        View mResultLayout;
        ViewGroup mView;

        public /* synthetic */ MenuView(int i) {
            this();
        }

        private void inOutVI() {
            TransitionManager.endTransitions(this.mView);
            if (!this.mView.isLaidOut()) {
                this.mView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.solvemath.view.SolveMathResult.MenuView.3
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        MenuView.this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
                        Animator animator = new HwInOutVI(1).getAnimator(MenuView.this.mView);
                        animator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.solvemath.view.SolveMathResult.MenuView.3.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                super.onAnimationEnd(animator2);
                            }
                        });
                        animator.start();
                        return true;
                    }
                });
                return;
            }
            HwInOutVI hwInOutVI = new HwInOutVI();
            hwInOutVI.addListener(new TransitionListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.solvemath.view.SolveMathResult.MenuView.2
                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionEnd(@NonNull Transition transition) {
                    super.onTransitionEnd(transition);
                }
            });
            TransitionManager.beginDelayedTransition(this.mView, hwInOutVI);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$init$0(Callback callback) {
            int color = this.mView.getContext().getResources().getColor(C9086R.color.ai_menu_bg_color);
            callback.onCopyResult(ImageUtils.createBitmap(((BitmapDrawable) this.mResultContent.getBackground()).getBitmap(), color), color);
            ComposerSA.insertLog(ComposerSAConstants.PAGE_SOLVE_MATH, ComposerSAConstants.EVENT_SOLVE_MATH_COPY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$init$1(KeyguardPresenter keyguardPresenter, final Callback callback, View view) {
            keyguardPresenter.dismissKeyguard(this.mActivity, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.solvemath.view.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6990a.lambda$init$0(callback);
                }
            });
        }

        private boolean outOfWindow() {
            return this.mView.getRootView().getWidth() <= getMenuWidth();
        }

        private int outOfWindowXRange(View view, View view2, int i) {
            view.measure(0, 0);
            view2.measure(0, 0);
            int width = ((View) view.getParent()).getWidth();
            int measuredWidth = view2.getMeasuredWidth() + i;
            if (i < 0) {
                return -i;
            }
            int i2 = measuredWidth - width;
            if (i2 > 0) {
                return -i2;
            }
            return 0;
        }

        private int outOfWindowYRange(View view, View view2, int i) {
            view.measure(0, 0);
            view2.measure(0, 0);
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            Logger.m10999d(SolveMathResult.TAG, "outOfWindowYRange# localVisibleRect " + rect);
            if (rect.height() < view2.getMeasuredHeight()) {
                return -(view2.getMeasuredHeight() - rect.height());
            }
            return 0;
        }

        public int getMenuWidth() {
            Rect screenSize = DisplayUtils.getScreenSize(this.mView.getContext());
            this.mView.measure(screenSize.width(), screenSize.height());
            return this.mView.getMeasuredWidth();
        }

        public int getVisibility() {
            return this.mView.getVisibility();
        }

        public void hide() {
            Logger.m10999d(SolveMathResult.TAG, "MenuView-hide#");
            inOutVI();
            this.mView.setVisibility(8);
        }

        public void init(Activity activity, @NonNull final KeyguardPresenter keyguardPresenter, View view, final Callback callback) {
            Logger.m10999d(SolveMathResult.TAG, "MenuView-init#");
            this.mNeedToUpdatePositionAfterInit = true;
            this.mActivity = activity;
            this.mContainer = view;
            this.mView = (ViewGroup) activity.findViewById(C9086R.id.solve_math_result);
            this.mMenuViews = new ArrayList();
            this.mResultLayout = this.mView.findViewById(C9086R.id.solve_math_result_layout);
            this.mResultContent = this.mView.findViewById(C9086R.id.solve_math_result_content);
            this.mResultCopy = this.mView.findViewById(C9086R.id.solve_math_result_copy);
            this.mMenuViews.add(this.mResultLayout);
            this.mResultCopy.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.solvemath.view.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f6992a.lambda$init$1(keyguardPresenter, callback, view2);
                }
            });
            if (this.mResultLayout.isLaidOut()) {
                updateContainerWidth();
            } else {
                this.mResultLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.solvemath.view.SolveMathResult.MenuView.4
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (MenuView.this.mResultLayout.getMeasuredWidth() > 0) {
                            MenuView.this.mResultLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            MenuView.this.updateContainerWidth();
                        }
                    }
                });
            }
        }

        public void invisible() {
            Logger.m10999d(SolveMathResult.TAG, "MenuView-invisible#");
            inOutVI();
            this.mView.setVisibility(4);
        }

        public boolean isShowing() {
            return this.mView.isShown();
        }

        public void show() {
            Logger.m10999d(SolveMathResult.TAG, "MenuView-show#");
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

        public void updateEachPosition(Rect rect) {
            int externalComponentLeftRightMargin = SolveMathUtil.getExternalComponentLeftRightMargin(this.mView.getContext());
            int externalComponentUpDownMargin = SolveMathUtil.getExternalComponentUpDownMargin(this.mView.getContext());
            int externalComponentUpDownMargin2 = SolveMathUtil.getExternalComponentUpDownMargin(this.mView.getContext());
            float fWidth = (rect.right - (rect.width() / 2)) - (getMenuWidth() / 2);
            float f = rect.bottom + externalComponentUpDownMargin2;
            this.mView.setX(fWidth);
            this.mView.setY(f);
            int iOutOfWindowXRange = outOfWindowXRange(this.mContainer, this.mView, (int) fWidth);
            if (iOutOfWindowXRange != 0) {
                if (iOutOfWindowXRange <= 0) {
                    externalComponentLeftRightMargin = -externalComponentLeftRightMargin;
                }
                fWidth += iOutOfWindowXRange + externalComponentLeftRightMargin;
                if (outOfWindow() || fWidth < 0.0f) {
                    fWidth = SolveMathUtil.getExceptionalCaseLeftRightMargin();
                }
            }
            int iOutOfWindowYRange = outOfWindowYRange(this.mContainer, this.mView, (int) f);
            if (iOutOfWindowYRange != 0) {
                if (iOutOfWindowYRange <= 0) {
                    externalComponentUpDownMargin = -externalComponentUpDownMargin;
                }
                f += iOutOfWindowYRange + externalComponentUpDownMargin;
            }
            Logger.m10999d(SolveMathResult.TAG, "updateEachPosition# x/y " + fWidth + "/" + f);
            this.mView.setX(fWidth);
            this.mView.setY(f);
            this.mView.requestLayout();
        }

        public void updatePosition(final Rect rect) {
            Logger.m10999d(SolveMathResult.TAG, "MenuView-updatePosition panelRect " + rect);
            ViewGroup viewGroup = this.mView;
            if (viewGroup == null || this.mContainer == null) {
                Logger.m11000e(SolveMathResult.TAG, "MenuView-updatePosition# mView is null");
                return;
            }
            if (!viewGroup.isLaidOut() || this.mNeedToUpdatePositionAfterInit) {
                this.mView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.solvemath.view.SolveMathResult.MenuView.1
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

        private MenuView() {
        }
    }

    private void initMenuView(Activity activity, @NonNull KeyguardPresenter keyguardPresenter, Callback callback) {
        Logger.m10999d(TAG, "initMenuView#");
        MenuView menuView = new MenuView(0);
        this.mMenuView = menuView;
        menuView.init(activity, keyguardPresenter, this.mContainer, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0() {
        Logger.m10999d(TAG, "init-run# lastContentRect " + this.mLastPanelRect);
        Rect rect = this.mLastPanelRect;
        if (rect == null || rect.isEmpty() || !isShowing()) {
            return;
        }
        this.mMenuView.updatePosition(this.mLastPanelRect);
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public void hide() {
        MenuView menuView = this.mMenuView;
        if (menuView != null) {
            this.mVisibility = 8;
            menuView.hide();
        }
    }

    public void init(Activity activity, @NonNull KeyguardPresenter keyguardPresenter, Callback callback) {
        Logger.m10999d(TAG, "init#");
        this.mContainer = activity.findViewById(C9086R.id.ai_menu_context_container);
        this.mVisibility = 8;
        this.mUpdateMenuRunnable = new RunnableC8669a(this, 29);
        initMenuView(activity, keyguardPresenter, callback);
    }

    public void invisible() {
        MenuView menuView = this.mMenuView;
        if (menuView != null) {
            this.mVisibility = 4;
            menuView.invisible();
        }
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
        this.mContainer.removeCallbacks(this.mUpdateMenuRunnable);
        this.mContainer.post(this.mUpdateMenuRunnable);
    }

    public void release() {
        hide();
        this.mMenuView = null;
        this.mLastPanelRect = null;
        this.mContainer.removeOnLayoutChangeListener(this);
        this.mContainer.removeCallbacks(this.mUpdateMenuRunnable);
    }

    public void setResultContent(Bitmap bitmap) {
        Logger.m10999d(TAG, "setResultContent");
        this.mMenuView.mResultContent.setBackground(new BitmapDrawable(bitmap));
    }

    public void show(boolean z) {
        Logger.m10999d(TAG, Constants.IntentExtraValue.SHOW);
        this.mContainer.addOnLayoutChangeListener(this);
        MenuView menuView = this.mMenuView;
        if (menuView != null) {
            this.mVisibility = 0;
            menuView.show();
            if (z) {
                ComposerSA.insertLog(ComposerSAConstants.PAGE_SOLVE_MATH, ComposerSAConstants.EVENT_SOLVE_MATH_CHECK_CALCULATION_RESULT);
            }
        }
    }

    public void updatePosition(RectF rectF) {
        String str = TAG;
        Logger.m10999d(str, "updatePosition#");
        if (this.mMenuView == null) {
            Logger.m11000e(str, "updatePosition# mMenuView is null");
            return;
        }
        Rect rect = new Rect();
        rectF.round(rect);
        this.mMenuView.updatePosition(rect);
        this.mLastPanelRect = rect;
    }
}
