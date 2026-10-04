package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.RectF;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenSpellCorrectionSpan;
import com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SpellingCorrection;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultViewCorrection extends AbsAiActionResultView implements SpellingCorrection.ResultListener {
    private static final String TAG = Logger.createTag("AiMenuResultViewCorrection", AiConstants.PREFIX_TAG);
    AiMenuContract.IAiActionResultContainer mAiActionResultContainer;
    private PopupWindow mCorrectionPopup;
    private ViewGroup mEditViewContainer;
    boolean mIsEnableLongClick;
    View.OnLayoutChangeListener mOnLayoutChangeListenerImpl;
    private SimpleEditView mSimpleEditView;
    private final SpellingCorrection mSpellingCorrection;
    boolean mStreamingStartFlag;
    private View mView;

    public AiMenuResultViewCorrection(SpellingCorrection spellingCorrection, AiMenuResultCommonViews aiMenuResultCommonViews, AiMenuContract.IAiActionResultContainer iAiActionResultContainer) {
        super(aiMenuResultCommonViews);
        this.mStreamingStartFlag = false;
        this.mSpellingCorrection = spellingCorrection;
        spellingCorrection.setResultListener(this);
        this.mAiActionResultContainer = iAiActionResultContainer;
    }

    private void hideCorrectionPopup(String str) {
        PopupWindow popupWindow = this.mCorrectionPopup;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        AbstractC8014b.m7196B("hideCorrectionPopup# ", str, TAG);
        this.mCorrectionPopup.dismiss();
    }

    private void hideProgress() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews != null) {
            aiMenuResultCommonViews.hideProgress();
        }
    }

    private void initAddDeleteSpan(View view, final SpenObjectShape spenObjectShape, final SpenSpellCorrectionSpan spenSpellCorrectionSpan, SpellingCorrection.SpanInfo spanInfo) {
        int i;
        TextView textView = (TextView) view.findViewById(C9086R.id.spelling_correction_content);
        final boolean zIsOriginal = SpellingCorrection.isOriginal(spenSpellCorrectionSpan);
        initPopupTitle(view, zIsOriginal);
        StrikethroughSpan strikethroughSpan = null;
        if (zIsOriginal) {
            if (spanInfo.isTypeAdd()) {
                i = -16776961;
            } else {
                i = SpellingCorrection.COLOR_REMOVED_TEXT;
                strikethroughSpan = new StrikethroughSpan();
            }
        } else if (spanInfo.isTypeAdd()) {
            i = SpellingCorrection.COLOR_REMOVED_TEXT;
            strikethroughSpan = new StrikethroughSpan();
        } else {
            i = SpellingCorrection.COLOR_ORIGINAL_TEXT;
        }
        final int i2 = i;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(spanInfo.getCorrectedWords(), foregroundColorSpan, 33);
        if (strikethroughSpan != null) {
            spannableStringBuilder.setSpan(strikethroughSpan, 0, spannableStringBuilder.length(), 33);
        }
        spannableStringBuilder.insert(0, (CharSequence) spanInfo.getFrontWord());
        spannableStringBuilder.append((CharSequence) spanInfo.getEndWord());
        textView.setText(spannableStringBuilder);
        final boolean z = strikethroughSpan != null;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f6955a.lambda$initAddDeleteSpan$6(spenObjectShape, spenSpellCorrectionSpan, zIsOriginal, z, i2, view2);
            }
        });
    }

    private void initChangesSpan(View view, final SpenObjectShape spenObjectShape, final SpenSpellCorrectionSpan spenSpellCorrectionSpan) {
        TextView textView = (TextView) view.findViewById(C9086R.id.spelling_correction_content);
        final boolean zIsOriginal = SpellingCorrection.isOriginal(spenSpellCorrectionSpan);
        initPopupTitle(view, zIsOriginal);
        textView.setTextColor(zIsOriginal ? SpellingCorrection.COLOR_CORRECTION_TEXT : SpellingCorrection.COLOR_ORIGINAL_TEXT);
        String originalText = spenSpellCorrectionSpan.getOriginalText();
        int length = originalText.length();
        int iCharCount = 0;
        while (true) {
            if (iCharCount >= length) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(originalText);
                spannableStringBuilder.setSpan(new UnderlineSpan(), 0, originalText.length(), 33);
                textView.setText(spannableStringBuilder);
                break;
            } else {
                int iCodePointAt = originalText.codePointAt(iCharCount);
                if (!Character.isWhitespace(iCodePointAt)) {
                    textView.setText(spenSpellCorrectionSpan.getOriginalText());
                    break;
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f6949a.lambda$initChangesSpan$5(spenObjectShape, spenSpellCorrectionSpan, zIsOriginal, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPopup(Context context, SpenObjectShape spenObjectShape, SpenSpellCorrectionSpan spenSpellCorrectionSpan) {
        PopupWindow popupWindow = this.mCorrectionPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.mCorrectionPopup = null;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(C9086R.layout.ai_menu_result_spelling_correction_popup_layout, (ViewGroup) null);
        SpellingCorrection.SpanInfo spanInfo = SpellingCorrection.SpanInfo.parseSpanInfo(spenSpellCorrectionSpan.getOriginalText());
        if (spanInfo == null) {
            initChangesSpan(viewGroup, spenObjectShape, spenSpellCorrectionSpan);
        } else {
            initAddDeleteSpan(viewGroup, spenObjectShape, spenSpellCorrectionSpan, spanInfo);
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) viewGroup.findViewById(C9086R.id.spelling_correction_state_icon);
        Objects.requireNonNull(lottieAnimationView);
        lottieAnimationView.postDelayed(new RunnableC9711g(lottieAnimationView, 9), 220L);
        initPopupWindow(viewGroup);
    }

    private void initPopupTitle(View view, boolean z) {
        TextView textView = (TextView) view.findViewById(C9086R.id.spelling_correction_state_name);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(C9086R.id.spelling_correction_state_icon);
        boolean zIsNightMode = ContextUtils.isNightMode(view.getContext());
        if (z) {
            textView.setText(C9086R.string.ai_spelling_correction_suggested);
            lottieAnimationView.setAnimation(zIsNightMode ? "ic_smile_face_w.json" : "ic_smile_face_b.json");
        } else {
            textView.setText(C9086R.string.ai_auto_format_original);
            lottieAnimationView.setAnimation(zIsNightMode ? "ic_error_face_w.json" : "ic_error_face_b.json");
        }
    }

    private void initPopupWindow(View view) {
        PopupWindow popupWindow = new PopupWindow(view, -2, -2);
        this.mCorrectionPopup = popupWindow;
        popupWindow.setTouchable(true);
        this.mCorrectionPopup.setOutsideTouchable(true);
        this.mCorrectionPopup.setOutsideTouchable(true);
        this.mCorrectionPopup.setClippingEnabled(true);
        this.mCorrectionPopup.setFocusable(true);
        this.mCorrectionPopup.setInputMethodMode(2);
        this.mCorrectionPopup.setOverlapAnchor(true);
        this.mCorrectionPopup.setBackgroundDrawable(view.getContext().getDrawable(C9086R.drawable.popup_menu_background));
        this.mCorrectionPopup.setElevation(12.0f);
        this.mCorrectionPopup.setAnimationStyle(C9086R.style.MorePopupEnterExitAnimation);
        BackgroundColorUtil.setBlurInfoPopup(view.getContext(), this.mCorrectionPopup.getContentView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initAddDeleteSpan$6(SpenObjectShape spenObjectShape, SpenSpellCorrectionSpan spenSpellCorrectionSpan, boolean z, boolean z2, int i, View view) {
        this.mSpellingCorrection.updateAddDelete(spenObjectShape, spenSpellCorrectionSpan, z, z2, i);
        this.mCorrectionPopup.dismiss();
        this.mCorrectionPopup = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initChangesSpan$5(SpenObjectShape spenObjectShape, SpenSpellCorrectionSpan spenSpellCorrectionSpan, boolean z, View view) {
        if (spenObjectShape.getText() == null) {
            Logger.m10999d(TAG, "initChangesSpan# onClick#, object text is null");
            return;
        }
        this.mSpellingCorrection.updateChange(spenObjectShape, spenSpellCorrectionSpan, z);
        this.mCorrectionPopup.dismiss();
        this.mCorrectionPopup = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initView$0(View view) {
        if (!this.mCommonViews.isShowingAnyProgress() && this.mSpellingCorrection.canDoAction() && this.mIsEnableLongClick) {
            this.mCommonViews.mContract.getPresenter().startDragAndDrop(this.mSimpleEditView.getView(), this.mSpellingCorrection.getResultToCopy());
            this.mCommonViews.mContract.getPresenter().getComposerViewPresenter().getView().requestFocus();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(boolean z) {
        this.mCommonViews.mViewPager.setUserInputEnabled(!z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2() {
        this.mIsEnableLongClick = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initView$3(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        this.mIsEnableLongClick = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$4(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i9 - i7;
        int i11 = i5 - i2;
        if (i8 - i6 == i4 - i && i10 == i11) {
            return;
        }
        hideCorrectionPopup("onLayoutChange");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runStreamingCompletedAnimation$7(ValueAnimator valueAnimator) {
        this.mView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runStreamingCompletedAnimation$8(ValueAnimator valueAnimator) {
        this.mView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private void runStreamingCompletedAnimation() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        final int i = 0;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.i

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AiMenuResultViewCorrection f6954b;

            {
                this.f6954b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i) {
                    case 0:
                        this.f6954b.lambda$runStreamingCompletedAnimation$7(valueAnimator);
                        break;
                    default:
                        this.f6954b.lambda$runStreamingCompletedAnimation$8(valueAnimator);
                        break;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setDuration(200L);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        final int i2 = 1;
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.i

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AiMenuResultViewCorrection f6954b;

            {
                this.f6954b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i2) {
                    case 0:
                        this.f6954b.lambda$runStreamingCompletedAnimation$7(valueAnimator);
                        break;
                    default:
                        this.f6954b.lambda$runStreamingCompletedAnimation$8(valueAnimator);
                        break;
                }
            }
        });
        valueAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewCorrection.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (AiMenuResultViewCorrection.this.mSpellingCorrection.getViewerNote() == null) {
                    return;
                }
                AiMenuResultViewCorrection aiMenuResultViewCorrection = AiMenuResultViewCorrection.this;
                aiMenuResultViewCorrection.setNote(aiMenuResultViewCorrection.mSpellingCorrection.getViewerNote());
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        animatorSet.start();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void clear() {
        hideCorrectionPopup("clear");
        SimpleEditView simpleEditView = this.mSimpleEditView;
        if (simpleEditView != null) {
            simpleEditView.getView().removeOnLayoutChangeListener(this.mOnLayoutChangeListenerImpl);
            this.mSimpleEditView.setScrollBarListener(null);
            this.mSimpleEditView.setSpenTextManagerActionListener(null);
            this.mSimpleEditView.release();
        }
        SpellingCorrection spellingCorrection = this.mSpellingCorrection;
        if (spellingCorrection != null) {
            spellingCorrection.clear();
        }
        hideProgress();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public AiMenuContract.IAiAction getAction() {
        return this.mSpellingCorrection;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public View inflateView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.ai_menu_result_spelling_correction_layout, viewGroup, false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    @SuppressLint({"ClickableViewAccessibility"})
    public void initView(final View view, View view2) {
        this.mView = view2;
        this.mEditViewContainer = (ViewGroup) view2.findViewById(C9086R.id.spelling_correction_result_edit_view);
        SimpleEditView simpleEditView = new SimpleEditView(view2.getContext(), this.mCommonViews.mContract.getPresenter());
        this.mSimpleEditView = simpleEditView;
        simpleEditView.attachView(this.mEditViewContainer);
        this.mSimpleEditView.setSpenTextManagerActionListener(new SpenTextManagerActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewCorrection.1
            @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
            public void onSelectionAreaLongPressed() {
                if (AiViewUtils.isSupportFloatingLayout() && !AiMenuResultViewCorrection.this.mCommonViews.isShowingAnyProgress() && AiMenuResultViewCorrection.this.mSpellingCorrection.canDoAction()) {
                    AiMenuResultViewCorrection aiMenuResultViewCorrection = AiMenuResultViewCorrection.this;
                    if (aiMenuResultViewCorrection.mIsEnableLongClick && !aiMenuResultViewCorrection.mSimpleEditView.isRightClickByMouse()) {
                        ViewCompat.getInstance().performHapticFeedback(AiMenuResultViewCorrection.this.mSimpleEditView.getView(), 110);
                        AiMenuResultViewCorrection.this.mCommonViews.mContract.getPresenter().startDragAndDrop(AiMenuResultViewCorrection.this.mSimpleEditView.getView(), AiMenuResultViewCorrection.this.mSimpleEditView.getResultToCopy());
                        AiMenuResultViewCorrection.this.mSimpleEditView.clearSelection();
                        AiMenuResultViewCorrection.this.mCommonViews.mContract.getPresenter().getComposerViewPresenter().getView().requestFocus();
                    }
                }
            }

            @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
            public void onSpellCorrectionTextClicked(@Nullable SpenObjectShape spenObjectShape, @Nullable SpenSpellCorrectionSpan spenSpellCorrectionSpan, @NonNull RectF rectF, List<RectF> list) {
                if (spenObjectShape == null || spenSpellCorrectionSpan == null) {
                    Logger.m11000e(AiMenuResultViewCorrection.TAG, "onSpellCorrectionTextClicked# object or span is null" + spenObjectShape + "/" + spenSpellCorrectionSpan);
                    return;
                }
                AiMenuResultViewCorrection.this.initPopup(view.getContext(), spenObjectShape, spenSpellCorrectionSpan);
                RectF rectF2 = new RectF();
                Iterator<RectF> it = list.iterator();
                while (it.hasNext()) {
                    rectF2.union(it.next());
                }
                float fConvertDpToPixel = ResourceUtils.convertDpToPixel(AiMenuResultViewCorrection.this.mSimpleEditView.getView().getContext(), 10.0f);
                float fConvertDpToPixel2 = ResourceUtils.convertDpToPixel(AiMenuResultViewCorrection.this.mSimpleEditView.getView().getContext(), 4.0f);
                float fConvertDpToPixel3 = ResourceUtils.convertDpToPixel(AiMenuResultViewCorrection.this.mSimpleEditView.getView().getContext(), 90.0f);
                int i = (int) (rectF2.left - fConvertDpToPixel);
                int i2 = (int) (rectF2.bottom - fConvertDpToPixel2);
                if (i2 + fConvertDpToPixel3 > AiMenuResultViewCorrection.this.mSimpleEditView.getView().getHeight()) {
                    i2 = (int) (rectF2.top - fConvertDpToPixel3);
                }
                AiMenuResultViewCorrection.this.mCorrectionPopup.showAsDropDown(AiMenuResultViewCorrection.this.mSimpleEditView.getView(), i, i2, 0);
                AiMenuResultViewCorrection.this.mCommonViews.getBottomView().removePostShow();
            }
        });
        if (AiViewUtils.isSupportFloatingLayout()) {
            this.mSimpleEditView.setContextMenuListener();
        } else {
            this.mSimpleEditView.setOnLongClickListener(new ViewOnLongClickListenerC9715k(this, 0));
        }
        this.mSimpleEditView.setScrollBarListener(new C9716l(this));
        this.mSimpleEditView.setOnScrollListener(new C9716l(this));
        this.mSimpleEditView.setOnTouchListener(new ViewOnTouchListenerC9717m(this, 0));
        this.mOnLayoutChangeListenerImpl = new ViewOnLayoutChangeListenerC9709e(this, 1);
        this.mSimpleEditView.getView().addOnLayoutChangeListener(this.mOnLayoutChangeListenerImpl);
        updateResult();
        this.mSimpleEditView.setEnabledBlurEffect(true);
        this.mRestoreSpenEditViewScroll = new AbsAiActionResultView.RestoreSpenEditViewScroll(this.mSimpleEditView, this.mSpellingCorrection.getHandler());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isInitialized() {
        return this.mSimpleEditView != null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isStreaming() {
        return this.mStreamingStartFlag;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.SpellingCorrection.ResultListener
    public void onCompleted(boolean z) {
        if (isInitialized()) {
            if (z) {
                if (CscFeature.INSTANCE.getInstance().isChinaAiFeature() && this.mStreamingStartFlag) {
                    runStreamingCompletedAnimation();
                } else {
                    setNote(this.mSpellingCorrection.getViewerNote());
                }
                this.mCommonViews.hideProgress(true);
                this.mStreamingStartFlag = false;
                this.mCommonViews.setBottomButtonsState(true);
                this.mCommonViews.setTopButtonState(true);
                if (!this.mSpellingCorrection.hasNext() && !this.mCommonViews.getContinuesProgress().isShowing()) {
                    this.mSpellingCorrection.showNoRevisedToast(this.mAiActionResultContainer.getActivity());
                }
                this.mCommonViews.getBottomView().show(true);
                this.mAiActionResultContainer.updateResultState(true, true);
                if (this.mSpellingCorrection.isRestore()) {
                    this.mSimpleEditView.getDocument().getBodyText().removeAllText();
                    this.mSimpleEditView.getDocument().getBodyText().copy(this.mSpellingCorrection.getResultNote().getBodyText());
                }
                if (!this.mCommonViews.getContinuesProgress().isShowing() && this.mSpellingCorrection.getCountDiff() != 0 && !this.mSpellingCorrection.isNotRevised()) {
                    this.mCommonViews.addWatermark(this.mView.getContext(), this.mSimpleEditView.getDocument());
                }
            }
            if (CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
                this.mSimpleEditView.scrollToPosition(z ? SimpleEditView.SCROLL_POSITION.TOP : SimpleEditView.SCROLL_POSITION.BOTTOM);
                if (this.mStreamingStartFlag || z) {
                    return;
                }
                this.mStreamingStartFlag = true;
                setNote(this.mSpellingCorrection.getViewerNote());
                this.mCommonViews.hideProgress(false);
                this.mAiActionResultContainer.updateResultState(true, false);
                this.mCommonViews.setBottomButtonsState(false);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.SpellingCorrection.ResultListener
    public void onFailed(String str) {
        if (this.mCommonViews.handleRestrictedPersonalDataError(str)) {
            return;
        }
        hideProgress();
        this.mCommonViews.mErrMsgView.setText(str);
        this.mCommonViews.showErrorMessage();
        this.mCommonViews.getContinuesProgress().setEnable(false);
        this.mAiActionResultContainer.updateResultState(false, true);
        if (this.mCommonViews.isShowingErrorMessage()) {
            return;
        }
        ToastHandler.show(this.mCommonViews.mErrMsgView.getContext(), str, 0);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.SpellingCorrection.ResultListener
    public void onNextCompleted(boolean z) {
        this.mAiActionResultContainer.updateContinuesResultState(z);
        if (z) {
            this.mSpellingCorrection.showNoRevisedToast(this.mAiActionResultContainer.getActivity());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void onPageSelected() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{4}[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        aiMenuResultCommonViews.setTopButtonsVisibility(Collections.unmodifiableList(arrayList));
        if (this.mCommonViews.getContinuesProgress().isShowing()) {
            this.mCommonViews.setBottomButtonsState(false);
        }
        if (this.mCommonViews.getBottomView().isShowing() || this.mStreamingStartFlag) {
            return;
        }
        this.mCommonViews.getBottomView().show(false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.SpellingCorrection.ResultListener
    public void onProgressing() {
        this.mCommonViews.setBottomButtonsState(false);
        this.mCommonViews.getContinuesProgress().show(5);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.SpellingCorrection.ResultListener
    public void setCountDiff(int i) {
        View view = this.mView;
        if (view == null) {
            Logger.m11000e(TAG, "updateOptionInfo# view is null");
            return;
        }
        TextView textView = (TextView) view.findViewById(C9086R.id.info_text);
        View viewFindViewById = this.mView.findViewById(C9086R.id.info_text_container);
        if (i == -1) {
            viewFindViewById.setVisibility(4);
            return;
        }
        textView.setText(textView.getContext().getResources().getQuantityString(C9086R.plurals.ai_spelling_correction_count, i, Integer.valueOf(i)));
        viewFindViewById.getLayoutParams().height = -2;
        viewFindViewById.setVisibility(0);
        viewFindViewById.requestLayout();
    }

    public void setNote(SpenWNote spenWNote) {
        SimpleEditView simpleEditView = this.mSimpleEditView;
        if (simpleEditView == null) {
            return;
        }
        simpleEditView.initView(spenWNote, this.mSpellingCorrection.getSrcContentInfo().mIsBGColorInverted, this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_result_page_horizontal_padding), new boolean[0]);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void setTitle() {
        this.mCommonViews.getTopView().setTitle(C9086R.string.ai_spelling_correction, C9086R.drawable.ic_ai_menu_title, (Integer) null);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView
    public void updateHorizontalPadding(int i) {
        if (isInitialized()) {
            this.mSimpleEditView.updateHorizontalPadding(this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_result_side_margin_size));
        }
    }

    public void updateResult() {
        if (this.mSpellingCorrection.isWorking()) {
            return;
        }
        if (this.mSpellingCorrection.getLastErrorMessage() != null) {
            Logger.m10999d(TAG, "updateResult# onFailed");
            onFailed(this.mSpellingCorrection.getLastErrorMessage());
        } else if (this.mSpellingCorrection.getViewerNote() != null) {
            Logger.m10999d(TAG, "updateResult# onCompleted");
            onCompleted(true);
            if (this.mSpellingCorrection.getCountDiff() != -1) {
                setCountDiff(this.mSpellingCorrection.getCountDiff());
            }
        }
    }
}
