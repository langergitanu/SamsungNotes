package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedInfo;
import com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Summarization;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultViewSummarization extends AbsAiActionResultView implements AiMenuContract.ResultListener, AiMenuContract.SubTransition.IParentView {
    private static final String TAG = Logger.createTag("AiMenuResultViewSummarization", AiConstants.PREFIX_TAG);
    boolean isEmptyText;
    boolean isViewInit;
    View mAiRootView;
    Contract mContract;
    ViewGroup mEditViewContainer;
    TextView mErrorMsgView;
    TextView mInfoTextView;
    boolean mIsEnableLongClick;
    AbsAiActionResultView.RestoreSpenEditViewScroll mRestoreSpenEditViewScroll;
    int mSelectedTextLength;
    SimpleEditView mSimpleEditView;
    boolean mStreamingStartFlag;
    SubTranslationViewManager mSubTranslationViewManager;
    Summarization mSummarization;
    ViewGroup mView;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSummarization$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C96541 extends SpenTextManagerActionListener {
        public C96541() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBeforeTextChangedByKeyBoard$0() {
            Context context = AiMenuResultViewSummarization.this.mView.getContext();
            ToastHandler.show(context, context.getString(C9086R.string.ss_maximum_number_of_characters_exceeded, 350000), 0);
        }

        @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
        public void onBeforeTextChangedByKeyBoard() {
            if (AiMenuResultViewSummarization.this.mSimpleEditView.getTextBoxLength() >= 350000) {
                new Handler(Looper.getMainLooper()).post(new RunnableC9711g(this, 3));
            }
        }

        @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
        public void onSelectionAreaLongPressed() {
            if (!AiMenuResultViewSummarization.this.mCommonViews.isShowingAnyProgress() && AiMenuResultViewSummarization.this.mSummarization.canDoAction() && AiMenuResultViewSummarization.this.mIsEnableLongClick) {
                ViewCompat.getInstance().performHapticFeedback(AiMenuResultViewSummarization.this.mSimpleEditView.getView(), 110);
                AiMenuResultViewSummarization.this.mCommonViews.mContract.getPresenter().startDragAndDrop(AiMenuResultViewSummarization.this.mSimpleEditView.getView(), AiMenuResultViewSummarization.this.mSimpleEditView.getResultToCopy());
                AiMenuResultViewSummarization.this.mSimpleEditView.getView().setOnDragListener(AiMenuResultViewSummarization.this.mSimpleEditView.onDragListener);
            }
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSummarization$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C96574 implements SpenWNote.ObjectEventListener {
        public C96574() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onObjectChanged$0() {
            Context context = AiMenuResultViewSummarization.this.mView.getContext();
            ToastHandler.show(context, context.getString(C9086R.string.ss_maximum_number_of_characters_exceeded, 350000), 0);
        }

        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectAdded(@Nullable SpenWPage spenWPage, @NonNull ArrayList<SpenObjectBase> arrayList, int i) {
        }

        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectChanged(@Nullable SpenWPage spenWPage, @NonNull SpenObjectChangedInfo spenObjectChangedInfo, int i) {
            int textBoxLength = AiMenuResultViewSummarization.this.mSimpleEditView.getTextBoxLength();
            if (textBoxLength >= 350000) {
                new Handler(Looper.getMainLooper()).post(new RunnableC9711g(this, 4));
            }
            AiMenuResultViewSummarization aiMenuResultViewSummarization = AiMenuResultViewSummarization.this;
            aiMenuResultViewSummarization.isEmptyText = textBoxLength == 0;
            aiMenuResultViewSummarization.mCommonViews.getBottomView().setBottomButtonsState(!AiMenuResultViewSummarization.this.isEmptyText);
        }

        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectRemoved(@Nullable SpenWPage spenWPage, @NonNull ArrayList<SpenObjectBase> arrayList, int i) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract extends AiMenuContract.IAiActionResultContainer {
        boolean updateEditedRecognizedHw();
    }

    public AiMenuResultViewSummarization(Summarization summarization, int i, AiMenuResultCommonViews aiMenuResultCommonViews, Contract contract) {
        super(aiMenuResultCommonViews);
        this.isEmptyText = false;
        this.isViewInit = false;
        this.mStreamingStartFlag = false;
        this.mSummarization = summarization;
        if (summarization == null) {
            return;
        }
        summarization.setResultListener(this);
        this.mContract = contract;
        this.mSelectedTextLength = i;
    }

    private void hideProgress() {
        this.mCommonViews.hideProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(boolean z) {
        this.mCommonViews.mViewPager.setUserInputEnabled(!z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1() {
        this.mIsEnableLongClick = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initView$2(View view) {
        if (!this.mCommonViews.isShowingAnyProgress() && this.mSummarization.canDoAction() && this.mIsEnableLongClick) {
            this.mCommonViews.mContract.getPresenter().startDragAndDrop(this.mSimpleEditView.getView(), this.mSummarization.getResultToCopy());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3(View view) {
        if (this.mCommonViews.isNotAvailable()) {
            return;
        }
        showSettingDialog(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSettingDialog$4() {
        SubTranslationViewManager subTranslationViewManager = this.mSubTranslationViewManager;
        if (subTranslationViewManager != null) {
            subTranslationViewManager.clearTranslation();
        }
        if (this.mSummarization == null) {
            Logger.m10999d(TAG, "showSettingDialog# mSummarization is null");
            return;
        }
        updateOptionInfo();
        this.mCommonViews.showProgress(2);
        ComposerSA.insertLog("802", ComposerSAConstants.EVENT_AI_SUMMARY_STYLE, this.mSummarization.isStandardTypeWithCurrentOption() ? "a" : "b");
        this.mSimpleEditView.clearSelection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Activity lambda$toggleTranslate$5() {
        return this.mContract.getActivity();
    }

    private boolean setErrorState() {
        if (this.mSummarization.getErrorType() == null) {
            return false;
        }
        this.mCommonViews.getTopView().setButtonsVisibility(null);
        this.mCommonViews.getBottomView().setBottomButtonsState(false);
        return true;
    }

    private void setVisibleDisclaimerBtn() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{4}[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        aiMenuResultCommonViews.setTopButtonsVisibility(Collections.unmodifiableList(arrayList));
    }

    private void setVisibleFullButtons() {
        if (FeatureInfo.isSummaryOnDeviceMode()) {
            setVisibleDisclaimerBtn();
            return;
        }
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        Object[] objArr = {4, 3};
        ArrayList arrayList = new ArrayList(2);
        for (int i = 0; i < 2; i++) {
            Object obj = objArr[i];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
        }
        aiMenuResultCommonViews.setTopButtonsVisibility(Collections.unmodifiableList(arrayList));
    }

    private void showErrorMsg() {
        hideProgress();
        this.mErrorMsgView.setText(this.mSummarization.getErrorType().getMsg(this.mErrorMsgView.getContext()));
        this.mErrorMsgView.setVisibility(0);
        this.mCommonViews.getBottomView().hide(false);
    }

    private void showSettingDialog(View view) {
        this.mSummarization.showOptionDialog(new RunnableC9711g(this, 11), view);
    }

    private void updateOptionInfo() {
        ViewGroup viewGroup = this.mView;
        if (viewGroup == null) {
            Logger.m11000e(TAG, "updateOptionInfo# view is null");
            return;
        }
        if (this.mInfoTextView == null) {
            this.mInfoTextView = (TextView) viewGroup.findViewById(C9086R.id.info_text);
        }
        this.mInfoTextView.setText(this.mSummarization.getOption().getStrRes());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void clear() {
        Logger.m10999d(TAG, "clear");
        SimpleEditView simpleEditView = this.mSimpleEditView;
        if (simpleEditView != null) {
            simpleEditView.release();
            this.mSimpleEditView = null;
        }
        Summarization summarization = this.mSummarization;
        if (summarization != null) {
            summarization.clear();
            this.mSummarization = null;
        }
        ViewGroup viewGroup = this.mView;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            this.mView = null;
            hideProgress();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public AiMenuContract.IAiAction getAction() {
        return isShowingSubTranslation() ? this.mSubTranslationViewManager.getAction() : this.mSummarization;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public View inflateView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.ai_result_summary, viewGroup, false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void initView(View view, View view2) {
        if (this.mSummarization == null) {
            return;
        }
        this.mAiRootView = view;
        ViewGroup viewGroup = (ViewGroup) view2;
        this.mView = viewGroup;
        viewGroup.setVisibility(0);
        this.mEditViewContainer = (ViewGroup) this.mView.findViewById(C9086R.id.summarization_result_edit_view);
        this.mErrorMsgView = (TextView) this.mView.findViewById(C9086R.id.summarization_error_msg_view);
        if (AiViewUtils.isSupportFloatingLayout()) {
            this.mErrorMsgView.setBackgroundColor(0);
        }
        SimpleEditView simpleEditView = new SimpleEditView(view.getContext(), this.mCommonViews.mContract.getPresenter());
        this.mSimpleEditView = simpleEditView;
        simpleEditView.attachView(this.mEditViewContainer);
        this.mSimpleEditView.setScrollBarListener(new C9686G(this));
        this.mSimpleEditView.setOnScrollListener(new C9686G(this));
        if (AiViewUtils.isSupportFloatingLayout()) {
            if (this.mSimpleEditView.isEditMode()) {
                this.mSimpleEditView.setSpenTextManagerActionListener(new C96541());
            } else {
                this.mSimpleEditView.setSpenTextManagerActionListener(new SpenTextManagerActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSummarization.2
                    @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
                    public void onSelectionAreaLongPressed() {
                        if (AiMenuResultViewSummarization.this.mCommonViews.isShowingAnyProgress() || !AiMenuResultViewSummarization.this.mSummarization.canDoAction()) {
                            return;
                        }
                        AiMenuResultViewSummarization aiMenuResultViewSummarization = AiMenuResultViewSummarization.this;
                        if (aiMenuResultViewSummarization.mIsEnableLongClick && !aiMenuResultViewSummarization.mSimpleEditView.isRightClickByMouse()) {
                            ViewCompat.getInstance().performHapticFeedback(AiMenuResultViewSummarization.this.mSimpleEditView.getView(), 110);
                            AiMenuResultViewSummarization.this.mCommonViews.mContract.getPresenter().startDragAndDrop(AiMenuResultViewSummarization.this.mSimpleEditView.getView(), AiMenuResultViewSummarization.this.mSimpleEditView.getResultToCopy());
                            AiMenuResultViewSummarization.this.mSimpleEditView.clearSelection();
                            AiMenuResultViewSummarization.this.mCommonViews.mContract.getPresenter().getComposerViewPresenter().getView().requestFocus();
                        }
                    }
                });
            }
            this.mSimpleEditView.setContextMenuListener();
        } else {
            this.mSimpleEditView.setOnLongClickListener(new ViewOnLongClickListenerC9715k(this, 1));
        }
        this.mSimpleEditView.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSummarization.3
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view3, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                AiMenuResultViewSummarization.this.mIsEnableLongClick = true;
                return false;
            }
        });
        this.mSimpleEditView.setEnabledBlurEffect(true);
        this.mRestoreSpenEditViewScroll = new AbsAiActionResultView.RestoreSpenEditViewScroll(this.mSimpleEditView, this.mSummarization.getHandler());
        updateResult();
        if (FeatureInfo.isSummaryOnDeviceMode()) {
            this.mCommonViews.getTopView().initSummaryOnDevice(3);
        } else {
            this.mCommonViews.getTopView().getButton(3).setOnClickListener(new ViewOnClickListenerC9704a(this, 1));
        }
        updateOptionInfo();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isBottomMenuSupported() {
        return this.mSummarization.getErrorType() == null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isInitialized() {
        return this.mSimpleEditView != null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.SubTransition.IParentView
    public boolean isShowingSubTranslation() {
        SubTranslationViewManager subTranslationViewManager = this.mSubTranslationViewManager;
        return subTranslationViewManager != null && subTranslationViewManager.isShowing();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isStreaming() {
        return this.mStreamingStartFlag;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.ResultListener
    public void onCompleted(boolean z) {
        SimpleEditView simpleEditView = this.mSimpleEditView;
        if (simpleEditView == null) {
            Logger.m11000e(TAG, "mSimpleEditView is null");
            return;
        }
        if (!this.isViewInit) {
            this.isViewInit = true;
            simpleEditView.initView(this.mSummarization.getResultNote(), false, this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_result_page_horizontal_padding_for_standard_summary), new boolean[0]);
            this.mSimpleEditView.setSpenObjectEventListener(new C96574());
        }
        this.mSimpleEditView.updateHorizontalPadding(this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_result_page_horizontal_padding_for_standard_summary));
        this.mCommonViews.hideProgress(z);
        if (!z) {
            this.mCommonViews.setBottomButtonsState(false);
            this.mContract.updateResultState(true, false);
            this.mSimpleEditView.scrollToPosition(SimpleEditView.SCROLL_POSITION.BOTTOM);
            this.mSimpleEditView.setMode(3);
            this.mStreamingStartFlag = true;
            return;
        }
        this.mCommonViews.setBottomButtonsState(true);
        this.mCommonViews.setTopButtonState(true);
        setVisibleFullButtons();
        this.mContract.updateResultState(true, true);
        this.mStreamingStartFlag = false;
        this.mSimpleEditView.scrollToPosition(SimpleEditView.SCROLL_POSITION.TOP);
        if (!this.mCommonViews.getContinuesProgress().isShowing()) {
            this.mCommonViews.getBottomView().show(true);
            if (this.mSummarization.isShowingSubTranslation()) {
                toggleTranslate();
            }
        }
        if (this.mSummarization.getOriginalResultTextbox() == null) {
            Summarization summarization = this.mSummarization;
            summarization.setOriginalResultTextbox(summarization.getResultNote());
        }
        if (this.mSummarization.isRestore()) {
            this.mSummarization.getResultNote().getBodyText().removeAllText();
            this.mSummarization.getResultNote().getBodyText().copy(this.mSummarization.getOriginalResultTextbox());
        }
        if (!this.mCommonViews.getContinuesProgress().isShowing()) {
            this.mCommonViews.addWatermark(this.mView.getContext(), this.mSummarization.getResultNote());
        }
        this.mSimpleEditView.setMode(1);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.ResultListener
    public void onFailed(String str) {
        if (this.mCommonViews.handleRestrictedPersonalDataError(str)) {
            return;
        }
        hideProgress();
        this.mCommonViews.mErrMsgView.setText(str);
        this.mCommonViews.showErrorMessage();
        this.mCommonViews.getContinuesProgress().setEnable(false);
        this.mContract.updateResultState(false, true);
        if (this.mCommonViews.isShowingErrorMessage()) {
            return;
        }
        ToastHandler.show(this.mCommonViews.mErrMsgView.getContext(), str, 0);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.SubTransition.IParentView
    public void onLanguageDownload() {
        SubTranslationViewManager subTranslationViewManager = this.mSubTranslationViewManager;
        if (subTranslationViewManager != null) {
            subTranslationViewManager.onLanguageDownload();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.ResultListener
    public void onNextCompleted(boolean z) {
        this.mContract.updateContinuesResultState(z);
        if (z && this.mSummarization.isShowingSubTranslation()) {
            toggleTranslate();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void onPageSelected() {
        if (this.mCommonViews.getContinuesProgress().isShowing()) {
            this.mCommonViews.getBottomView().setBottomButtonsState(false);
            if (!setErrorState()) {
                setVisibleDisclaimerBtn();
            }
        } else {
            this.mCommonViews.getBottomView().setBottomButtonsState(!this.isEmptyText);
            if (!setErrorState()) {
                setVisibleFullButtons();
            }
        }
        this.mCommonViews.getBottomView().setTextMenuVisible(true);
        if (isInitialized()) {
            if (!this.mContract.updateEditedRecognizedHw()) {
                this.mCommonViews.getBottomView().updateTranslateButtonText(!isShowingSubTranslation());
                return;
            }
            Summarization.ErrorType errorTypeCanExecute = this.mSummarization.canExecute();
            if (errorTypeCanExecute != null) {
                Summarization.ErrorType errorType = Summarization.ErrorType.MINIMUM;
                if (errorType.equals(errorTypeCanExecute)) {
                    Logger.m10999d(TAG, "onPageSelected# minimum limitation");
                    if (!errorType.equals(this.mSummarization.getErrorType())) {
                        this.mSummarization.setErrorType(errorType);
                        this.mSummarization.clearResultText();
                        showErrorMsg();
                    }
                    setErrorState();
                }
                this.mCommonViews.getBottomView().hide(true, false);
            } else {
                this.mCommonViews.showProgress(2);
                this.mCommonViews.setTopButtonState(false);
                this.mSummarization.setErrorType(null);
                this.mSummarization.execute();
                this.mErrorMsgView.setVisibility(8);
            }
            this.mCommonViews.getBottomView().updateTranslateButtonText(true);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.ResultListener
    public void onProgressing() {
        setVisibleDisclaimerBtn();
        this.mCommonViews.setBottomButtonsState(false);
        this.mCommonViews.getContinuesProgress().show(2);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void setTitle() {
        this.mCommonViews.getTopView().setTitle(C9086R.string.ai_summary_title, C9086R.drawable.ic_ai_menu_title, (Integer) null);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.SubTransition.IParentView
    public void toggleTranslate() {
        if (this.mSubTranslationViewManager == null) {
            View view = this.mAiRootView;
            ViewGroup viewGroup = this.mView;
            this.mSubTranslationViewManager = new SubTranslationViewManager(view, viewGroup, viewGroup.findViewById(C9086R.id.summary_panel), this.mSummarization, this.mCommonViews, new C9686G(this));
        }
        this.mSubTranslationViewManager.toggleTranslate();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView
    public void updateHorizontalPadding(int i) {
        if (isInitialized()) {
            this.mSimpleEditView.updateHorizontalPadding(this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_result_side_margin_size));
        }
    }

    public void updateResult() {
        if (this.mSummarization.isWorking()) {
            return;
        }
        if (this.mSummarization.getErrorType() != null) {
            showErrorMsg();
            return;
        }
        if (this.mSummarization.getLastErrorMessage() != null) {
            Logger.m10999d(TAG, "updateResult# onFailed");
            onFailed(this.mSummarization.getLastErrorMessage());
        } else if (this.mSummarization.getResultNote() != null) {
            Logger.m10999d(TAG, "updateResult# onCompleted");
            onCompleted(true);
        }
    }
}
