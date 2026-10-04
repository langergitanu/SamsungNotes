package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.appcompat.animation.C0421a;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut33;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut70;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.common.view.C8235a;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.AiMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import p001A.AbstractC0000a;
import p075S.C0255g;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TitleEditorShowHideAnimator {
    private static final String TAG = Logger.createTag("TitleEditorShowHideAnimator");
    private float mAlphaEnd;
    private float mAlphaStart;
    private AnimatorSet mAnimatorSetForDataAndTag;
    private AnimatorSet mAnimatorSetGeneral;
    private final Contract mContract;
    private boolean mIsCoverShowing;
    private boolean mIsExtending;
    private boolean mIsHiding;
    private final KeyguardPresenter.Observer mKeyguardObserver;
    private final KeyguardPresenter mKeyguardPresenter;
    private NaviUpAnimation mNaviUpAnimation = NaviUpAnimation.Rotation;
    private SineInOut33 mSineInOut33;
    private SineInOut70 mSineInOut70;
    private int mTitleContainerHEnd;
    private int mTitleContainerHStart;
    private int mToolbarTitleMaxWidth;
    private final TitleEditorViewSet mViewSet;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        AppCompatActivity getActivity();

        TitleEditorPresenter getPresenter();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum NaviUpAnimation {
        Rotation,
        Alpha
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TitleEditorAnimatorListener extends AnimatorListenerAdapter {
        public /* synthetic */ TitleEditorAnimatorListener(int i) {
            this();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Logger.m10999d(TitleEditorShowHideAnimator.TAG, "onAnimationCancel# ");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Logger.m10999d(TitleEditorShowHideAnimator.TAG, "onAnimationEnd# ");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Logger.m10999d(TitleEditorShowHideAnimator.TAG, "onAnimationStart# ");
        }

        private TitleEditorAnimatorListener() {
        }
    }

    public TitleEditorShowHideAnimator(TitleEditorViewSet titleEditorViewSet, Contract contract) {
        KeyguardPresenter.Observer observer = new KeyguardPresenter.Observer() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorShowHideAnimator.1
            @Override // com.samsung.android.support.senl.nt.composer.main.common.presenter.keyguard.KeyguardPresenter.Observer
            public void onDismissed() {
                Logger.m10999d(TitleEditorShowHideAnimator.TAG, "onDismissed");
                TitleEditorShowHideAnimator.this.mKeyguardPresenter.removeObserver(this);
                TitleEditorShowHideAnimator.this.mNaviUpAnimation = NaviUpAnimation.Rotation;
                TitleEditorShowHideAnimator.this.mViewSet.onNaviUpEnabled();
            }
        };
        this.mKeyguardObserver = observer;
        this.mViewSet = titleEditorViewSet;
        this.mContract = contract;
        KeyguardPresenter keyguardPresenter = contract.getPresenter().getKeyguardPresenter();
        this.mKeyguardPresenter = keyguardPresenter;
        keyguardPresenter.addObserver(observer);
    }

    private int getEndMargin() {
        Resources resources = this.mViewSet.getResources();
        return this.mIsCoverShowing ? resources.getDimensionPixelSize(C9086R.dimen.comp_title_margin_end_with_cover) : resources.getDimensionPixelSize(C9086R.dimen.comp_title_text_end_margin);
    }

    private Animator getInfoAlphaAnimator(float f, float f4, int i, Interpolator interpolator) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f4);
        valueAnimatorOfFloat.addUpdateListener(new C0421a(this, 22));
        valueAnimatorOfFloat.setDuration(i);
        if (interpolator != null) {
            valueAnimatorOfFloat.setInterpolator(interpolator);
        }
        return valueAnimatorOfFloat;
    }

    private SineInOut33 getSineInOut33() {
        if (this.mSineInOut33 == null) {
            this.mSineInOut33 = new SineInOut33();
        }
        return this.mSineInOut33;
    }

    private SineInOut70 getSineInOut70() {
        if (this.mSineInOut70 == null) {
            this.mSineInOut70 = new SineInOut70();
        }
        return this.mSineInOut70;
    }

    private int getTitleHeight() {
        Resources resources = this.mViewSet.getResources();
        return this.mIsCoverShowing ? resources.getDimensionPixelSize(C9086R.dimen.comp_title_text_container_height_with_cover) : resources.getDimensionPixelSize(C9086R.dimen.comp_title_text_container_height);
    }

    private int getTitleLeftEnd() {
        if (LocaleUtils.isRTLMode()) {
            return getEndMargin();
        }
        return 0;
    }

    private int getTitleLeftStart() {
        return LocaleUtils.isRTLMode() ? (TextUtils.isEmpty(this.mViewSet.getTitleView().getTitleText()) || this.mViewSet.getTitleView().getTitleText().chars().allMatch(new C0255g(2))) ? this.mViewSet.getToolbarTitle().getLeft() - getEndMargin() : this.mContract.getPresenter().isNaviUpEnabled() ? this.mViewSet.getToolbarTitle().getLeft() : (this.mViewSet.getToolbarNaviUp().getRight() - this.mViewSet.getToolbarTitle().getMeasuredWidth()) - this.mViewSet.getTitleStartMargin() : this.mContract.getPresenter().isNaviUpEnabled() ? this.mViewSet.getToolbarTitle().getLeft() : this.mViewSet.getTitleStartMargin();
    }

    private int getTitleWidth() {
        return this.mViewSet.getToolbarView().getWidth() - getEndMargin();
    }

    private int getToolbarLeftEnd() {
        if (LocaleUtils.isRTLMode()) {
            return (TextUtils.isEmpty(this.mViewSet.getTitleView().getTitleText()) || this.mViewSet.getTitleView().getTitleText().chars().allMatch(new C0255g(2))) ? (int) ((this.mViewSet.getToolbarNaviUp().getRight() - (this.mViewSet.getToolbarTitle().getMeasuredWidth() * 1.575f)) - this.mViewSet.getTitleStartMargin()) : getEndMargin();
        }
        if (this.mContract.getPresenter().isNaviUpEnabled()) {
            return 0;
        }
        return this.mViewSet.getTitleStartMargin();
    }

    private int getToolbarLeftStart() {
        return this.mContract.getPresenter().isNaviUpEnabled() ? this.mViewSet.getToolbarTitle().getLeft() : LocaleUtils.isRTLMode() ? (this.mViewSet.getToolbarNaviUp().getRight() - this.mViewSet.getToolbarTitle().getMeasuredWidth()) - this.mViewSet.getTitleStartMargin() : this.mViewSet.getTitleStartMargin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTopEnd() {
        return this.mViewSet.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_text_top_margin);
    }

    private void initAnimationValueAlpha(float f, float f4) {
        this.mAlphaStart = f;
        this.mAlphaEnd = f4;
    }

    private void initAnimationValueContainer(int i, int i2) {
        this.mTitleContainerHStart = i;
        this.mTitleContainerHEnd = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animate$0(boolean z, ValueAnimator valueAnimator) {
        if (this.mContract.getActivity() == null) {
            return;
        }
        updateAllViewByFraction(((Float) valueAnimator.getAnimatedValue()).floatValue(), !z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getInfoAlphaAnimator$1(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.mViewSet.getAiNoteContainer().setAlpha(fFloatValue);
        this.mViewSet.getOtherContainerFirstLine().setAlpha(fFloatValue);
        this.mViewSet.getOtherContainerFirstLineDivider().setAlpha(fFloatValue);
        this.mViewSet.getInfoContainer().setAlpha(fFloatValue);
        this.mViewSet.getTitleCoeditMemberListView().setAlpha(fFloatValue);
    }

    private void postAnimationAfterLaidOut() {
        if (this.mViewSet.getTitleContainer().isLaidOut()) {
            this.mAnimatorSetGeneral.start();
        } else {
            this.mViewSet.getTitleContainer().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorShowHideAnimator.4
                @Override // java.lang.Runnable
                public void run() {
                    TitleEditorShowHideAnimator.this.mAnimatorSetGeneral.start();
                }
            });
        }
    }

    private void updateAllViewByFraction(float f, boolean z) {
        updateTitleContainerHeight(this.mTitleContainerHStart, this.mTitleContainerHEnd, f);
        this.mViewSet.getTitleView().updateViewByFraction(f, z);
        this.mViewSet.updateScreenLockView(f, z);
        updateNaviButton(f, z);
        updateToolbarButtons(this.mAlphaStart, this.mAlphaEnd, f);
        updateToolbarCover(this.mAlphaEnd, this.mAlphaStart, f);
        updateFavoriteView(f, z);
        updateCoeditAddMemberView(f, z);
        this.mViewSet.updateFirstLineLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateExtendedState() {
        this.mContract.getPresenter().onShow();
        this.mViewSet.getOtherContainer().setVisibility(0);
        updateOtherContainer("updateExtendedState");
        AnimatorSet animatorSet = this.mAnimatorSetForDataAndTag;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        Animator infoAlphaAnimator = getInfoAlphaAnimator(0.0f, 1.0f, 200, getSineInOut33());
        Animator showAnimator = this.mViewSet.getTagListView().getShowAnimator();
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(infoAlphaAnimator, showAnimator);
        animatorSet2.start();
        this.mAnimatorSetForDataAndTag = animatorSet2;
        this.mIsExtending = false;
        this.mViewSet.getTitleView().getView().setEnabled(true);
        if (this.mContract.getPresenter().isEditMode()) {
            this.mViewSet.getTitleView().getView().requestFocus();
            this.mContract.getPresenter().showSoftInput(this.mViewSet.getTitleView().getView());
        }
    }

    private void updateNaviButton(float f, boolean z) {
        if (z) {
            f = 1.0f - f;
        }
        if (this.mNaviUpAnimation == NaviUpAnimation.Rotation) {
            this.mViewSet.getNaviUpView().setRotation((LocaleUtils.isRTLMode() ? -90 : 90) * f);
        } else {
            this.mViewSet.getNaviUpView().setAlpha(f);
        }
    }

    private void updateOtherContainer(final String str) {
        this.mViewSet.getTitleView().getTitleTextContainerBottom(new TitleViewManager.TitleContainerBottomCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorShowHideAnimator.5
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleViewManager.TitleContainerBottomCallback
            public void onBottomCalculated(int i) {
                if (TitleEditorShowHideAnimator.this.mIsCoverShowing) {
                    i = TitleEditorShowHideAnimator.this.getTopEnd() + TitleEditorShowHideAnimator.this.mViewSet.getResources().getDimensionPixelSize(C9086R.dimen.cover_preview_height);
                }
                TitleEditorShowHideAnimator.this.mViewSet.getOtherContainer().setY(i + 10);
                Logger.m10999d(TitleEditorShowHideAnimator.TAG, "updateOtherContainer# caller : " + str + ", getY : " + TitleEditorShowHideAnimator.this.mViewSet.getOtherContainer().getY() + ", IsCoverShowing : " + TitleEditorShowHideAnimator.this.mIsCoverShowing);
            }
        });
    }

    private void updateTitleContainerHeight(int i, int i2, float f) {
        ViewGroup.LayoutParams layoutParams = this.mViewSet.getTitleContainer().getLayoutParams();
        layoutParams.height = (int) (((i2 - i) * f) + i);
        this.mViewSet.getTitleContainer().setLayoutParams(layoutParams);
    }

    private void updateToolbarButtons(float f, float f4, float f5) {
        if (this.mViewSet.getToolbarActionBtns() != null) {
            this.mViewSet.getToolbarActionBtns().setAlpha(((f4 - f) * f5) + f);
            if (DeviceInfo.isVSTModel()) {
                this.mViewSet.getToolbarActionBtns().setVisibility(Math.round(f4) == 1 ? 0 : 8);
            }
        }
    }

    private void updateToolbarCover(float f, float f4, float f5) {
        this.mViewSet.getToolbarCoverView().setAlpha(((f4 - f) * f5) + f);
    }

    public void animate(float f, boolean z) {
        this.mAnimatorSetGeneral = new AnimatorSet();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new C8235a(1, this, z));
        valueAnimatorOfFloat.setDuration((long) ((1.0f - f) * 333.0f));
        if (z) {
            valueAnimatorOfFloat.addListener(new TitleEditorAnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorShowHideAnimator.2
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorShowHideAnimator.TitleEditorAnimatorListener, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (TitleEditorShowHideAnimator.this.mContract.getActivity() == null) {
                        return;
                    }
                    super.onAnimationEnd(animator);
                    TitleEditorShowHideAnimator.this.updateExtendedState();
                }
            });
            this.mAnimatorSetGeneral.playTogether(this.mViewSet.getTitleView().getShowAlphaAnimator());
        } else {
            valueAnimatorOfFloat.addListener(new TitleEditorAnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorShowHideAnimator.3
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorShowHideAnimator.TitleEditorAnimatorListener, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (TitleEditorShowHideAnimator.this.mContract.getActivity() == null) {
                        return;
                    }
                    super.onAnimationCancel(animator);
                    TitleEditorShowHideAnimator.this.updateHideState();
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorShowHideAnimator.TitleEditorAnimatorListener, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (TitleEditorShowHideAnimator.this.mContract.getActivity() == null) {
                        return;
                    }
                    super.onAnimationEnd(animator);
                    TitleEditorShowHideAnimator.this.updateHideState();
                }
            });
            this.mAnimatorSetGeneral.playTogether(this.mViewSet.getTitleView().getHideAlphaAnimator());
        }
        this.mAnimatorSetGeneral.playTogether(valueAnimatorOfFloat);
        this.mAnimatorSetGeneral.setInterpolator(getSineInOut70());
        postAnimationAfterLaidOut();
    }

    public void cancel() {
        AnimatorSet animatorSet = this.mAnimatorSetGeneral;
        if (animatorSet == null || !animatorSet.isRunning()) {
            return;
        }
        this.mAnimatorSetGeneral.cancel();
    }

    public void hideNoteCover() {
        boolean z = this.mContract.getPresenter().getAiCoverMenuViewPresenter().hasCover() && this.mContract.getPresenter().getAiCoverMenuViewPresenter().isCoverEnabled();
        this.mIsCoverShowing = z;
        if (z) {
            return;
        }
        Resources resources = this.mViewSet.getResources();
        this.mViewSet.getAiNoteCoverView().hide();
        updateTitleWidth();
        updateTitleContainerHeight(0, this.mViewSet.getExtendedTitleHeight(resources, true), 1.0f);
        updateOtherContainer("hideNoteCover");
        this.mViewSet.getTitleContainer().setVisibility(0);
        this.mViewSet.getTitleView().getView().setVisibility(0);
        this.mViewSet.getTitleView().initCoverShowStatOneTitle();
    }

    public void initHideState() {
        if (this.mIsHiding) {
            return;
        }
        if (this.mViewSet.getToolbarTitle() == null) {
            this.mViewSet.findViewOnToolbar();
        }
        if (this.mViewSet.getToolbarTitle() == null) {
            Logger.m10999d(TAG, "not found title");
            return;
        }
        Logger.m10999d(TAG, "initHideState#");
        this.mToolbarTitleMaxWidth = this.mViewSet.calculateTitleMaxWidth();
        this.mIsHiding = true;
        this.mViewSet.attachNaviUpButton();
        this.mContract.getPresenter().setTitle(this.mViewSet.getTitleView().getTitleText(), true);
        this.mContract.getPresenter().setFocusToComposer();
        this.mViewSet.getTitleContainer().setVisibility(0);
        initAnimationValueContainer(this.mViewSet.getTitleContainer().getHeight(), this.mViewSet.getToolbarView().getHeight());
        int topEnd = getTopEnd();
        TitleViewManager titleView = this.mViewSet.getTitleView();
        titleView.setToolbarTitle(this.mViewSet.getToolbarTitle());
        titleView.initAnimationValueTitleView(getTitleLeftStart(), getTitleLeftEnd(), 0, topEnd);
        titleView.initAnimationValueToolbar(getToolbarLeftStart(), getToolbarLeftEnd(), topEnd, this.mToolbarTitleMaxWidth);
        titleView.initHideState(getTitleWidth());
        initAnimationValueAlpha(0.0f, 1.0f);
        updateAllViewByFraction(0.0f, true);
        AnimatorSet animatorSet = this.mAnimatorSetForDataAndTag;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(getInfoAlphaAnimator(1.0f, 0.0f, 150, getSineInOut33()), this.mViewSet.getTagListView().getHideAnimator());
        animatorSet2.setInterpolator(getSineInOut33());
        animatorSet2.start();
        this.mAnimatorSetForDataAndTag = animatorSet2;
        this.mViewSet.getToolbarView().setImportantForAccessibility(1);
        this.mViewSet.getMainLayoutContainerParent().setImportantForAccessibility(1);
        this.mViewSet.updateTitleToolbarAccessibilityDelegate(true);
    }

    public void initShowState() {
        if (this.mViewSet.getTitleContainer().getVisibility() == 0) {
            return;
        }
        if (this.mViewSet.getToolbarTitle() == null) {
            this.mViewSet.findViewOnToolbar();
        }
        if (this.mViewSet.getToolbarTitle() == null) {
            Logger.m10999d(TAG, "not found title");
            return;
        }
        this.mIsCoverShowing = this.mContract.getPresenter().getAiCoverMenuViewPresenter().hasCover() && this.mContract.getPresenter().getAiCoverMenuViewPresenter().isCoverEnabled();
        AiMenuManager aiMenuManager = this.mContract.getPresenter().getAiMenuManager();
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        sb.append(str);
        sb.append("/initShowState");
        aiMenuManager.releaseAiDrawingPopup(sb.toString());
        this.mContract.getPresenter().getAiMenuManager().getSolveMathPresenter().onHideContextMenu();
        AbstractC8014b.m7215q(new StringBuilder("initShowState# mIsCoverShowing : "), this.mIsCoverShowing, str);
        this.mToolbarTitleMaxWidth = this.mViewSet.calculateTitleMaxWidth();
        this.mIsExtending = true;
        this.mViewSet.attachNaviUpButton();
        this.mViewSet.getNaviUpView().setVisibility(0);
        this.mViewSet.getTitleContainer().setVisibility(0);
        this.mViewSet.getParentLockView().setVisibility(0);
        this.mViewSet.getParentView().setVisibility(0);
        this.mViewSet.getFolderViewManager().updateFolderInfo();
        this.mViewSet.getNoteInfoViewManager().updateInfoContainer();
        this.mViewSet.getTitleCoeditMemberListView().setAlpha(0.0f);
        this.mViewSet.getTitleCoeditMemberListView().updateCoeditMemberListView();
        this.mViewSet.updateBottomDockerLockedState(true);
        this.mNaviUpAnimation = this.mViewSet.getToolbarNaviUp().getVisibility() == 0 ? NaviUpAnimation.Rotation : NaviUpAnimation.Alpha;
        int topEnd = getTopEnd();
        AppCompatTextView toolbarTitle = this.mViewSet.getToolbarTitle();
        toolbarTitle.setAlpha(0.0f);
        TitleViewManager titleView = this.mViewSet.getTitleView();
        titleView.setToolbarTitle(toolbarTitle);
        titleView.initAnimationValueTitleView(getTitleLeftStart(), getTitleLeftEnd(), 0, topEnd);
        titleView.initAnimationValueToolbar(getToolbarLeftStart(), getToolbarLeftEnd(), topEnd, this.mToolbarTitleMaxWidth);
        titleView.initShowState(getTitleWidth(), getTitleHeight());
        if (this.mIsCoverShowing) {
            this.mViewSet.getTitleView().setAiCoverBtnGoneState();
            this.mViewSet.getAiNoteCoverView().show();
        } else {
            this.mViewSet.getAiNoteCoverView().hide();
            this.mViewSet.getTitleView().getView().setVisibility(0);
        }
        this.mViewSet.getToolbarNaviUp().setAlpha(0.0f);
        this.mViewSet.getTagListView().setEditable(this.mContract.getPresenter().isEditMode());
        this.mViewSet.getTagListView().updateTagListView();
        this.mViewSet.getNaviUpView().requestFocus();
        View toolbarView = this.mViewSet.getToolbarView();
        toolbarView.setImportantForAccessibility(2);
        this.mViewSet.getMainLayoutContainerParent().setImportantForAccessibility(4);
        this.mViewSet.initShowState();
        initAnimationValueContainer(toolbarView.getHeight(), this.mViewSet.getExtendedTitleHeight(this.mViewSet.getResources(), this.mIsCoverShowing));
        initAnimationValueAlpha(1.0f, 0.0f);
        updateAllViewByFraction(0.0f, false);
        this.mViewSet.updateFocusNavigationTraversal();
        this.mViewSet.updateAccessibilityTraversal();
        this.mViewSet.updateTitleToolbarAccessibilityDelegate(false);
    }

    public boolean isAnimating() {
        return this.mIsExtending || this.mIsHiding;
    }

    public boolean isHiding() {
        return this.mIsHiding;
    }

    public void release() {
        this.mKeyguardPresenter.removeObserver(this.mKeyguardObserver);
        AnimatorSet animatorSet = this.mAnimatorSetGeneral;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void updateCoeditAddMemberView(float f, boolean z) {
        if (z) {
            f = 1.0f - f;
        }
        this.mViewSet.getCoeditAddMember().getView().setAlpha(f);
    }

    public void updateFavoriteView(float f, boolean z) {
        if (this.mViewSet.getFavorite().getView().getVisibility() == 8) {
            return;
        }
        this.mViewSet.getFavorite().updateState();
        if (z) {
            f = 1.0f - f;
        }
        this.mViewSet.getFavorite().getView().setAlpha(f);
    }

    public void updateHideState() {
        this.mViewSet.getToolbarNaviUp().setAlpha(1.0f);
        this.mViewSet.getToolbarTitle().setAlpha(1.0f);
        this.mViewSet.getTitleContainer().setVisibility(8);
        this.mViewSet.getParentLockView().setVisibility(8);
        this.mViewSet.getParentView().setVisibility(8);
        this.mViewSet.getOtherContainer().setVisibility(8);
        this.mViewSet.getNaviUpView().setVisibility(8);
        this.mViewSet.updateBottomDockerLockedState(false);
        this.mIsHiding = false;
        this.mContract.getPresenter().onHide(this.mViewSet.getTitleView().getView());
    }

    public void updateNoteCover() {
        if (!this.mIsCoverShowing && this.mContract.getPresenter().getComposerModel().getComposerState().isSupportedAiCover()) {
            boolean z = this.mContract.getPresenter().getAiCoverMenuViewPresenter().hasCover() && this.mContract.getPresenter().getAiCoverMenuViewPresenter().isCoverEnabled();
            this.mIsCoverShowing = z;
            if (z) {
                int extendedTitleHeight = this.mViewSet.getExtendedTitleHeight(this.mViewSet.getResources(), this.mIsCoverShowing);
                this.mViewSet.getTitleView().setAiCoverBtnGoneState();
                this.mViewSet.getAiNoteCoverView().show();
                this.mViewSet.getTitleView().getTitleViewShowHideAnimator().updateWidth(getTitleWidth(), getTitleHeight());
                updateTitleContainerHeight(0, extendedTitleHeight, 1.0f);
                updateOtherContainer("updateNoteCover");
            }
        }
    }

    public void updateTitleWidth() {
        this.mViewSet.getTitleView().getTitleViewShowHideAnimator().updateWidth(getTitleWidth(), getTitleHeight());
    }

    public void updateTitleWidth(int i) {
        AbstractC0000a.m3D(i, "updateTitleWidth# width : ", TAG);
        this.mViewSet.getTitleView().getTitleViewShowHideAnimator().updateWidth(i - getEndMargin(), getTitleHeight());
    }
}
