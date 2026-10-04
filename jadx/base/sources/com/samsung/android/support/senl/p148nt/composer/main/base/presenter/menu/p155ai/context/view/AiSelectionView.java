package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Pair;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.sem.recoil.CustomRecoilDrawable;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiContextMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf.TranslationOverlayManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.GuidingLightEffectUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiSelectionView implements AiContextMenuPresenter.AiMenuViewContract {
    private static final String TAG = Logger.createTag("AiSelectionView");
    private final AiContextMenuPresenter mAiContextMenuPresenter;
    private final ComposerViewPresenter mComposerViewPresenter;
    private ContentSwitcherMenu mContentSwitcherMenu;
    private View mDoneButton;
    private GuidingLightEffect mDoneButtonEffect;
    private ValueAnimator mFadeInOutAnimator;
    private boolean mIsRemoveAnimation;
    private View.OnLayoutChangeListener mOnLayoutChangeListener;
    private Runnable mRunnableCheckMaximumTextSelected;
    private SelectionDone mSelectionDone;
    private Animation mSlideUpAnimation;

    public AiSelectionView(ComposerViewPresenter composerViewPresenter, AiContextMenuPresenter aiContextMenuPresenter) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mAiContextMenuPresenter = aiContextMenuPresenter;
        aiContextMenuPresenter.setAiMenuViewContract(this);
        this.mIsRemoveAnimation = SettingsCompat.getInstance().isRemoveAnimation(composerViewPresenter.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeToVSTLayout() {
        View viewFindViewById = this.mComposerViewPresenter.getActivity().findViewById(C9086R.id.comp_next_scroll_button_container);
        View viewFindViewById2 = viewFindViewById.findViewById(C9086R.id.comp_next_buttons_container);
        viewFindViewById2.setPadding(viewFindViewById2.getPaddingLeft(), viewFindViewById2.getPaddingTop(), viewFindViewById2.getResources().getDimensionPixelSize(C9086R.dimen.vst_ai_selection_view_buttons_end_padding), viewFindViewById2.getResources().getDimensionPixelSize(C9086R.dimen.vst_ai_selection_view_buttons_bottom_padding));
        View viewFindViewById3 = viewFindViewById.findViewById(C9086R.id.comp_select_next_page);
        int dimensionPixelSize = viewFindViewById3.getResources().getDimensionPixelSize(C9086R.dimen.vst_ai_selection_view_button_top_bottom_padding);
        viewFindViewById3.setPadding(viewFindViewById3.getPaddingLeft(), dimensionPixelSize, viewFindViewById3.getPaddingRight(), dimensionPixelSize);
        View viewFindViewById4 = viewFindViewById.findViewById(C9086R.id.comp_select_maximum);
        viewFindViewById4.setPadding(viewFindViewById4.getPaddingLeft(), dimensionPixelSize, viewFindViewById4.getPaddingRight(), dimensionPixelSize);
        int dimensionPixelSize2 = viewFindViewById3.getResources().getDimensionPixelSize(C9086R.dimen.vst_ai_selection_view_button_end_gap_margin);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewFindViewById3.getLayoutParams();
        marginLayoutParams.rightMargin = dimensionPixelSize2;
        viewFindViewById3.setLayoutParams(marginLayoutParams);
        int dimensionPixelSize3 = viewFindViewById4.getResources().getDimensionPixelSize(C9086R.dimen.vst_ai_selection_view_button_top_bottom_margin);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) viewFindViewById4.getLayoutParams();
        marginLayoutParams2.topMargin = dimensionPixelSize3;
        marginLayoutParams2.rightMargin = dimensionPixelSize2;
        viewFindViewById4.setLayoutParams(marginLayoutParams2);
        View viewFindViewById5 = viewFindViewById.findViewById(C9086R.id.comp_ai_done);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) viewFindViewById5.getLayoutParams();
        marginLayoutParams3.topMargin = dimensionPixelSize3;
        viewFindViewById5.setLayoutParams(marginLayoutParams3);
        View viewFindViewById6 = viewFindViewById.findViewById(C9086R.id.comp_ai_done_item);
        ViewGroup.LayoutParams layoutParams = viewFindViewById6.getLayoutParams();
        layoutParams.height = viewFindViewById6.getResources().getDimensionPixelSize(C9086R.dimen.vst_ai_selection_view_button_done_height);
        viewFindViewById6.setLayoutParams(layoutParams);
    }

    @RequiresApi(api = 28)
    private void clearOldBackground(View view) {
        view.setBackground(null);
        view.setElevation(0.0f);
        view.setOutlineAmbientShadowColor(0);
        view.setOutlineSpotShadowColor(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getHeightOverLapped(View view, View view2) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr);
        view2.getLocationOnScreen(iArr2);
        int width = view.getWidth() > 0 ? view.getWidth() : view.getMeasuredWidth();
        int height = view.getHeight() > 0 ? view.getHeight() : view.getMeasuredHeight();
        int width2 = view2.getWidth() > 0 ? view2.getWidth() : view2.getMeasuredWidth();
        int height2 = view2.getHeight() > 0 ? view2.getHeight() : view2.getMeasuredHeight();
        int iMax = Math.max(iArr[0], iArr2[0]);
        int iMax2 = Math.max(iArr[1], iArr2[1]);
        int iMin = Math.min(iArr[0] + width, iArr2[0] + width2);
        int iMin2 = Math.min(iArr[1] + height, iArr2[1] + height2);
        if (iMin - iMax <= 0) {
            return 0;
        }
        int i = iMin2 - iMax2;
        return i >= height ? (iArr[1] + height) - iArr2[1] : Math.max(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        this.mSlideUpAnimation = translateAnimation;
        translateAnimation.setDuration(this.mIsRemoveAnimation ? 0L : 350L);
        this.mSlideUpAnimation.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        this.mFadeInOutAnimator = new ValueAnimator();
    }

    @RequiresApi(api = 33)
    private void initGuidingLightEffect(View view, int i) {
        GuidingLightEffect guidingLightEffect = this.mDoneButtonEffect;
        if (guidingLightEffect != null) {
            guidingLightEffect.hide(GuidingLightEffect.HideAnimationType.NONE);
            this.mDoneButtonEffect.remove(this.mDoneButton);
            this.mDoneButtonEffect.release();
        }
        GuidingLightEffect guidingLightEffectCreateGuidingLightEffect = GuidingLightEffectUtil.createGuidingLightEffect(view, view.getResources().getDimension(C9086R.dimen.ai_select_next_blue_button_round), i);
        this.mDoneButtonEffect = guidingLightEffectCreateGuidingLightEffect;
        guidingLightEffectCreateGuidingLightEffect.show(GuidingLightEffect.ShowAnimationType.NONE);
    }

    private CustomRecoilDrawable makeRecoilBackground(Resources resources, @ColorRes int i, @DrawableRes int i2, @DrawableRes int i4) {
        return new CustomRecoilDrawable(resources.getColor(i, null), new Drawable[]{resources.getDrawable(i2, null)}, resources.getDrawable(i4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 33)
    public void setNewStyleDoneButton(View view) {
        clearOldBackground(view);
        setRecoilStateListAnimator(view);
        Resources resources = view.getResources();
        CustomRecoilDrawable customRecoilDrawableMakeRecoilBackground = makeRecoilBackground(resources, C9086R.color.ai_drawing_request_type_bg_color, C9086R.drawable.ai_menu_button_bg, C9086R.drawable.ai_selection_done_recoil);
        int dimensionPixelSize = resources.getDimensionPixelSize(C9086R.dimen.ai_context_menu_light_effect_inset);
        view.setBackground(new InsetDrawable((Drawable) customRecoilDrawableMakeRecoilBackground, dimensionPixelSize));
        initGuidingLightEffect(view, dimensionPixelSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 28)
    public void setRecoilEffectSelectionButton(View view) {
        clearOldBackground(view);
        setRecoilStateListAnimator(view);
        view.setBackground(makeRecoilBackground(view.getResources(), C9086R.color.ai_drawing_request_type_bg_color, C9086R.drawable.ai_selection_next_bg, C9086R.drawable.ai_selection_next_recoil));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRecoilStateListAnimator(View view) {
        StateListAnimator recoilStateListAnimator = ViewCompat.getInstance().getRecoilStateListAnimator(view.getContext(), 0);
        if (recoilStateListAnimator != null) {
            view.setStateListAnimator(recoilStateListAnimator);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenuPresenter.AiMenuViewContract
    public void hide() {
        final View containerSelectNext = this.mSelectionDone.getContainerSelectNext();
        final View containerSwitchContent = this.mContentSwitcherMenu.getContainerSwitchContent();
        if (this.mRunnableCheckMaximumTextSelected != null) {
            this.mComposerViewPresenter.getHandler().removeCallbacks(this.mRunnableCheckMaximumTextSelected);
        }
        ValueAnimator valueAnimator = this.mFadeInOutAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mFadeInOutAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = new ValueAnimator();
        this.mFadeInOutAnimator = valueAnimator2;
        valueAnimator2.setInterpolator(new LinearInterpolator());
        this.mFadeInOutAnimator.setFloatValues(1.0f, 0.0f);
        this.mFadeInOutAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.AiSelectionView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator3) {
                containerSwitchContent.setAlpha(((Float) valueAnimator3.getAnimatedValue()).floatValue());
                containerSelectNext.setAlpha(((Float) valueAnimator3.getAnimatedValue()).floatValue());
            }
        });
        this.mFadeInOutAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.AiSelectionView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Logger.m10999d(AiSelectionView.TAG, "hideContainerSelectNext#");
                containerSwitchContent.setVisibility(8);
                containerSelectNext.setVisibility(8);
            }
        });
        this.mFadeInOutAnimator.setDuration(this.mIsRemoveAnimation ? 0L : 100L);
        this.mFadeInOutAnimator.start();
        if (this.mOnLayoutChangeListener != null) {
            ((View) containerSelectNext.getParent()).removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
            this.mOnLayoutChangeListener = null;
        }
        GuidingLightEffect guidingLightEffect = this.mDoneButtonEffect;
        if (guidingLightEffect == null || Build.VERSION.SDK_INT < 33) {
            return;
        }
        guidingLightEffect.hide(GuidingLightEffect.HideAnimationType.NONE);
        this.mDoneButtonEffect.remove(this.mDoneButton);
        this.mDoneButtonEffect.release();
        this.mDoneButtonEffect = null;
    }

    public void onAttachView() {
        this.mSelectionDone = new SelectionDone(this.mComposerViewPresenter.getActivity(), this.mAiContextMenuPresenter);
        this.mContentSwitcherMenu = new ContentSwitcherMenu(this.mComposerViewPresenter.getActivity(), this.mAiContextMenuPresenter);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenuPresenter.AiMenuViewContract
    public void show() {
        if (!this.mAiContextMenuPresenter.canShowDoneButton()) {
            Logger.m11000e(TAG, "show# gone : canShowDoneButton false");
            return;
        }
        final View containerSelectNext = this.mSelectionDone.getContainerSelectNext();
        final View containerSwitchContent = this.mContentSwitcherMenu.getContainerSwitchContent();
        if (this.mFadeInOutAnimator == null) {
            initAnimation();
        }
        if (this.mRunnableCheckMaximumTextSelected != null) {
            this.mComposerViewPresenter.getHandler().removeCallbacks(this.mRunnableCheckMaximumTextSelected);
        }
        this.mRunnableCheckMaximumTextSelected = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.AiSelectionView.1
            @Override // java.lang.Runnable
            public void run() {
                boolean zBooleanValue;
                boolean z;
                AiSelectionView.this.mSelectionDone.init();
                AiSelectionView.this.mContentSwitcherMenu.init();
                boolean zCanShowContainerSelectNext = AiSelectionView.this.mAiContextMenuPresenter.canShowContainerSelectNext();
                boolean zIsTranslatedPdfOverlapping = AiSelectionView.this.mAiContextMenuPresenter.isTranslatedPdfOverlapping();
                int stateForOnlyOneMenu = AiSelectionView.this.mAiContextMenuPresenter.getStateForOnlyOneMenu();
                boolean z2 = zCanShowContainerSelectNext && !zIsTranslatedPdfOverlapping;
                boolean z3 = stateForOnlyOneMenu == 3 || stateForOnlyOneMenu == 4 || stateForOnlyOneMenu == 2;
                if (!z2) {
                    zBooleanValue = (AiSelectionView.this.mAiContextMenuPresenter.hasSelectionHW() || AiSelectionView.this.mAiContextMenuPresenter.getSelectionText() == null) ? true : AiSelectionView.this.mAiContextMenuPresenter.getSelectionText().canSelectMoreForText(z3).second.booleanValue();
                    z = false;
                } else if (AiSelectionView.this.mAiContextMenuPresenter.hasSelectionHW()) {
                    z = !AiSelectionView.this.mAiContextMenuPresenter.getSelectionHW().isMaxLineSelected();
                    zBooleanValue = true;
                } else if (AiSelectionView.this.mAiContextMenuPresenter.getSelectionText() == null) {
                    Logger.m11000e(AiSelectionView.TAG, "showContainerSelectNext# gone");
                    containerSelectNext.setVisibility(8);
                    return;
                } else {
                    Pair<Boolean, Boolean> pairCanSelectMoreForText = AiSelectionView.this.mAiContextMenuPresenter.getSelectionText().canSelectMoreForText(z3);
                    boolean zBooleanValue2 = pairCanSelectMoreForText.first.booleanValue();
                    zBooleanValue = pairCanSelectMoreForText.second.booleanValue();
                    z = zBooleanValue2;
                }
                if (AiSelectionView.this.mFadeInOutAnimator.isRunning()) {
                    AiSelectionView.this.mFadeInOutAnimator.cancel();
                }
                Logger.m10999d(AiSelectionView.TAG, "showContainerSelectNext# show");
                containerSelectNext.setVisibility(0);
                View viewFindViewById = AiSelectionView.this.mComposerViewPresenter.getActivity().findViewById(C9086R.id.comp_next_scroll_button_container);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
                if (layoutParams != null) {
                    if (AiSelectionView.this.mComposerViewPresenter.getComposerModel().isTabletLayout()) {
                        layoutParams.removeRule(21);
                        layoutParams.removeRule(12);
                        viewFindViewById.setLayoutParams(layoutParams);
                    } else {
                        layoutParams.addRule(21, -1);
                        layoutParams.addRule(12, -1);
                        viewFindViewById.setLayoutParams(layoutParams);
                    }
                }
                View viewFindViewById2 = viewFindViewById.findViewById(C9086R.id.comp_select_maximum);
                View viewFindViewById3 = viewFindViewById.findViewById(C9086R.id.comp_select_next_page);
                if (DeviceInfo.isVSTModel()) {
                    AiSelectionView.this.changeToVSTLayout();
                }
                int i = Build.VERSION.SDK_INT;
                if (i >= 28) {
                    AiSelectionView.this.setRecoilEffectSelectionButton(viewFindViewById3);
                    AiSelectionView.this.setRecoilEffectSelectionButton(viewFindViewById2);
                }
                if (z2) {
                    viewFindViewById2.setVisibility(0);
                    viewFindViewById2.setEnabled(z);
                    viewFindViewById2.setAlpha(z ? 1.0f : 0.3f);
                    viewFindViewById3.setVisibility(0);
                    viewFindViewById3.setEnabled(z);
                    viewFindViewById3.setAlpha(z ? 1.0f : 0.3f);
                    if (AiSelectionView.this.mAiContextMenuPresenter.isFirstShowForNextSelectionView()) {
                        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 2.0f, 1, 0.0f);
                        translateAnimation.setDuration(AiSelectionView.this.mIsRemoveAnimation ? 0L : 350L);
                        translateAnimation.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
                        viewFindViewById2.startAnimation(translateAnimation);
                        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 3.0f, 1, 0.0f);
                        translateAnimation2.setDuration(AiSelectionView.this.mIsRemoveAnimation ? 0L : 350L);
                        translateAnimation2.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
                        viewFindViewById3.startAnimation(translateAnimation2);
                    }
                } else {
                    viewFindViewById2.setVisibility(8);
                    viewFindViewById3.setVisibility(8);
                }
                final View viewFindViewById4 = viewFindViewById.findViewById(C9086R.id.comp_ai_done_container);
                final View viewFindViewById5 = viewFindViewById.findViewById(C9086R.id.comp_ai_done);
                AiSelectionView.this.mDoneButton = viewFindViewById5;
                if (i < 33 || !AiViewUtils.isAtLeastOneUI7()) {
                    AiSelectionView.this.setRecoilStateListAnimator(viewFindViewById5);
                } else {
                    AiSelectionView.this.setNewStyleDoneButton(viewFindViewById5);
                    ((TextView) viewFindViewById4.findViewById(C9086R.id.comp_ai_done_text)).setTextColor(ColorStateList.valueOf(viewFindViewById5.getContext().getResources().getColor(C9086R.color.ai_menu_text_color, null)));
                    if (AiViewUtils.isAtLeastOneUI85()) {
                        viewFindViewById4.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.AiSelectionView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                int width = viewFindViewById5.getWidth();
                                int height = viewFindViewById5.getHeight();
                                if (width <= 0 || height <= 0) {
                                    return;
                                }
                                View viewFindViewById6 = viewFindViewById4.findViewById(C9086R.id.comp_ai_done_item);
                                ((ViewGroup) viewFindViewById6.getParent()).removeView(viewFindViewById6);
                                viewFindViewById5.getLayoutParams().width = width;
                                viewFindViewById5.getLayoutParams().height = height;
                                ((ViewGroup) viewFindViewById4.findViewById(C9086R.id.comp_ai_done_item_container85)).addView(viewFindViewById6);
                                viewFindViewById4.requestLayout();
                            }
                        });
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewFindViewById4.getLayoutParams();
                    int dimensionPixelSize = viewFindViewById4.getResources().getDimensionPixelSize(C9086R.dimen.ai_context_menu_light_effect_inset) * (-1);
                    marginLayoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                    viewFindViewById4.requestLayout();
                }
                if (zIsTranslatedPdfOverlapping) {
                    viewFindViewById4.setVisibility(8);
                } else {
                    viewFindViewById4.setAlpha(zBooleanValue ? 1.0f : 0.3f);
                    viewFindViewById5.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.AiSelectionView.1.2
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            viewFindViewById5.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            viewFindViewById5.requestFocus();
                            if (VoiceAssistantTTS.isVoiceAssistantEnabled(viewFindViewById5.getContext())) {
                                ViewCompat.getInstance().requestAccessibilityFocus(viewFindViewById5);
                            }
                        }
                    });
                    viewFindViewById4.setVisibility(0);
                    if (AiSelectionView.this.mAiContextMenuPresenter.isFirstShowForNextSelectionView()) {
                        if (AiSelectionView.this.mSlideUpAnimation == null) {
                            AiSelectionView.this.initAnimation();
                        }
                        viewFindViewById4.startAnimation(AiSelectionView.this.mSlideUpAnimation);
                    }
                    AiSelectionView.this.mSelectionDone.setDoneButton(AiSelectionView.this.mAiContextMenuPresenter.getStateForOnlyOneMenu());
                }
                String stringCurrentSelectedType = AiSelectionView.this.mAiContextMenuPresenter.getContentSwitcher().getStringCurrentSelectedType();
                if (TextUtils.isEmpty(stringCurrentSelectedType)) {
                    containerSwitchContent.setVisibility(8);
                } else {
                    ((TextView) containerSwitchContent.findViewById(C9086R.id.comp_ai_switch_button_text)).setText(stringCurrentSelectedType);
                    containerSwitchContent.setVisibility(0);
                    AiSelectionView.this.mAiContextMenuPresenter.setBlockToShowQuickNoteDialog(true);
                    if (AiSelectionView.this.mAiContextMenuPresenter.isFirstShowForNextSelectionView()) {
                        if (AiSelectionView.this.mSlideUpAnimation == null) {
                            AiSelectionView.this.initAnimation();
                        }
                        containerSwitchContent.startAnimation(AiSelectionView.this.mSlideUpAnimation);
                    }
                    if (AiSelectionView.this.mAiContextMenuPresenter.getTranslationOverlayManager() != null) {
                        AiSelectionView.this.mAiContextMenuPresenter.getTranslationOverlayManager().setCloseListener(new TranslationOverlayManager.CloseListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.AiSelectionView.1.3
                            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.CloseListener
                            public void onClosed() {
                                containerSwitchContent.setVisibility(8);
                                AiSelectionView.this.mAiContextMenuPresenter.setBlockToShowQuickNoteDialog(false);
                            }
                        });
                    }
                }
                if (containerSwitchContent.getVisibility() == 0 && viewFindViewById4.getVisibility() == 0) {
                    final View view = containerSelectNext;
                    view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), 0);
                    containerSwitchContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.AiSelectionView.1.4
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            containerSwitchContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            RunnableC93561 runnableC93561 = RunnableC93561.this;
                            if (AiSelectionView.this.getHeightOverLapped(containerSwitchContent, containerSelectNext) > 0) {
                                View view2 = view;
                                view2.setPadding(view2.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), containerSwitchContent.getHeight() > 0 ? containerSwitchContent.getHeight() : containerSwitchContent.getMeasuredHeight());
                            }
                        }
                    });
                    View view2 = (View) view.getParent();
                    if (AiSelectionView.this.mOnLayoutChangeListener == null) {
                        AiSelectionView.this.mOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.AiSelectionView.1.5
                            @Override // android.view.View.OnLayoutChangeListener
                            public void onLayoutChange(View view3, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                                if (i5 - i2 != i9 - i7) {
                                    AiSelectionView.this.mComposerViewPresenter.getHandler().post(AiSelectionView.this.mRunnableCheckMaximumTextSelected);
                                }
                            }
                        };
                    }
                    view2.removeOnLayoutChangeListener(AiSelectionView.this.mOnLayoutChangeListener);
                    view2.addOnLayoutChangeListener(AiSelectionView.this.mOnLayoutChangeListener);
                }
                AiSelectionView.this.mFadeInOutAnimator = new ValueAnimator();
                AiSelectionView.this.mFadeInOutAnimator.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
                if (AiSelectionView.this.mFadeInOutAnimator.isRunning()) {
                    AiSelectionView.this.mFadeInOutAnimator.cancel();
                }
                AiSelectionView.this.mFadeInOutAnimator.setFloatValues(0.0f, 1.0f);
                AiSelectionView.this.mFadeInOutAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.AiSelectionView.1.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                        containerSwitchContent.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        containerSelectNext.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                AiSelectionView.this.mFadeInOutAnimator.setDuration(AiSelectionView.this.mIsRemoveAnimation ? 0L : 300L);
                AiSelectionView.this.mFadeInOutAnimator.start();
                AiSelectionView.this.mAiContextMenuPresenter.setFirstShowForNextSelectionView(false);
            }
        };
        this.mComposerViewPresenter.getHandler().post(this.mRunnableCheckMaximumTextSelected);
    }
}
