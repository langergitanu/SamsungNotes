package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfCursorPosition;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.text.SpenCursorChangedListener;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.page.PageLayoutState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.CursorChangedListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiBixbyParam;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiMenuEventListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.RecognizedHw;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.ResultOperation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTSummarization;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Summarization;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Translation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskStartDrag;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow;
import com.samsung.android.support.senl.p148nt.stt.base.model.mode.STTMode;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTSearchPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultViewPresenter implements CursorChangedListenerImpl.TextSelectionChangedListener {
    private static final String SAVE_KEY_RESULT_PAGE_INDEX = "result_page_index";
    public static final String SAVE_KEY_RESULT_SRC = "result_src";
    private static final String TAG = Logger.createTag("AiMenuResultViewPresenter", AiConstants.PREFIX_TAG);
    private final AiMenuEventListener mAiMenuEventListener;
    private final ISTTWindow.IAIContract mAiSTTContract;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final ControllerManager mControllerManager;
    private final DialogPresenterManager mDialogManager;
    private Integer mPageLayoutColumn;
    private Boolean mPageLayoutIsVertical;
    private AiMenuContract.IView mView;
    private boolean mIsBlockingReleaseSelection = false;
    private long mCurrentPageStartShowingTime = -1;
    private int mPreviousScreenId = 9000;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final List<AiMenuContract.IAiAction> mAiActions = new ArrayList(2);
    private final OnSipListenerImpl mOnSipListener = new OnSipListenerImpl();
    private final OnCalledShowMethodListenerImpl mOnCalledShowMethodListenerImpl = new OnCalledShowMethodListenerImpl();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OnCalledShowMethodListenerImpl implements SoftInputManager.OnCalledShowMethodListener {
        public OnCalledShowMethodListenerImpl() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnCalledShowMethodListener
        public void onCalledShow() {
            if (AiMenuResultViewPresenter.this.isCanMinimizeMode()) {
                AiMenuResultViewPresenter.this.mView.minimizeView();
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnCalledShowMethodListener
        public void onShowSip() {
            AiMenuResultViewPresenter.this.mView.onShowSip();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OnSipListenerImpl implements SoftInputManager.OnSipListener {
        public OnSipListenerImpl() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
        public void onHide() {
            AiMenuResultViewPresenter.this.mView.expandView();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
        public void onShow() {
            AiMenuResultViewPresenter.this.mView.minimizeView();
        }
    }

    public AiMenuResultViewPresenter(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, ISTTWindow.IAIContract iAIContract, DialogPresenterManager dialogPresenterManager, AiMenuEventListener aiMenuEventListener) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mControllerManager = controllerManager;
        this.mAiSTTContract = iAIContract;
        this.mDialogManager = dialogPresenterManager;
        this.mAiMenuEventListener = aiMenuEventListener;
    }

    private boolean equalPdfCursorPosition(SpenNotePdfCursorPosition spenNotePdfCursorPosition, SpenNotePdfCursorPosition spenNotePdfCursorPosition2) {
        return spenNotePdfCursorPosition.getPageIndex() == spenNotePdfCursorPosition2.getPageIndex() && spenNotePdfCursorPosition.getCursorIndex() == spenNotePdfCursorPosition2.getCursorIndex();
    }

    private void initOnShow() {
        if (!this.mAiActions.isEmpty()) {
            AiMenuContract.IAiAction iAiAction = this.mAiActions.get(0);
            if (iAiAction instanceof RecognizedHw) {
                ((RecognizedHw) iAiAction).initListener();
            }
        }
        this.mComposerViewPresenter.getComposerControllerManager().getComposerAiController().setNeedToReleaseAiSelectionOnFirstMove(true);
        this.mComposerViewPresenter.getListenerManager().setCursorChangedListener(new SpenCursorChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuResultViewPresenter.2
            @Override // com.samsung.android.sdk.pen.text.SpenCursorChangedListener
            public void onChanged(int i, int i2) {
                if (AiMenuResultViewPresenter.this.mComposerViewPresenter.getComposerControllerManager().getComposerAiController().isNeedToReleaseAiSelectionOnFirstMove()) {
                    AiMenuResultViewPresenter.this.mComposerViewPresenter.getComposerControllerManager().getComposerAiController().setNeedToReleaseAiSelectionOnFirstMove(false);
                    AiMenuResultViewPresenter.this.mComposerViewPresenter.getComposerControllerManager().getComposerAiController().clearAiTextFormat();
                }
                AiMenuResultViewPresenter.this.mView.setEnableReplace(i != i2);
            }
        });
        if (!isCreateImageRunning()) {
            this.mComposerViewPresenter.setContextMenuDelegate(true, null);
        }
        this.mDialogManager.getQuickNoteDialogPresenter().blockToShow(true);
    }

    private boolean isComposerSearchMode() {
        return this.mComposerViewPresenter.getComposerModel().getModeManager().isMode(Mode.Search);
    }

    private void setHiddenStateTablet() {
        ComposerControllerManager composerControllerManager = this.mComposerViewPresenter.getComposerControllerManager();
        if (this.mPageLayoutIsVertical != null) {
            composerControllerManager.getCvPageSettingController().setPageLayout(this.mPageLayoutColumn.intValue(), composerControllerManager.getCvPageSettingController().getPageLayoutState().getRow(), this.mPageLayoutIsVertical.booleanValue());
        }
    }

    private void setPageLayout() {
        ComposerControllerManager composerControllerManager = this.mComposerViewPresenter.getComposerControllerManager();
        PageLayoutState pageLayoutState = composerControllerManager.getCvPageSettingController().getPageLayoutState();
        if (pageLayoutState.isTwoPage() || !pageLayoutState.isVertical()) {
            this.mPageLayoutColumn = Integer.valueOf(pageLayoutState.getColumn());
            this.mPageLayoutIsVertical = Boolean.valueOf(pageLayoutState.isVertical());
            composerControllerManager.getCvPageSettingController().setPageLayout(1, pageLayoutState.getRow(), true);
        } else {
            this.mPageLayoutColumn = null;
            this.mPageLayoutIsVertical = null;
        }
        composerControllerManager.getScrollController().fitPageWidth();
    }

    private void updateSelection(SrcContentInfo srcContentInfo) {
        if (srcContentInfo == null) {
            return;
        }
        if (srcContentInfo.getSrcType() == 1) {
            if (!this.mComposerViewPresenter.getObjectManager().isSelectedBodyText() || !this.mComposerViewPresenter.getTextManager().isSelected()) {
                srcContentInfo.setSelected(false);
                return;
            } else {
                int[] cursorFromFocusedTextBox = this.mComposerViewPresenter.getTextManager().getCursorFromFocusedTextBox();
                srcContentInfo.setSelected(cursorFromFocusedTextBox[0] == srcContentInfo.mStartPos && cursorFromFocusedTextBox[1] == srcContentInfo.mEndPos);
                return;
            }
        }
        if (srcContentInfo.getSrcType() == 2) {
            srcContentInfo.setSelected(getRecognizedHw().isSelecting());
            return;
        }
        if (srcContentInfo.getSrcType() == 0) {
            if (!this.mComposerViewPresenter.getPdfManager().hasSelectedText()) {
                srcContentInfo.setSelected(false);
            } else if (equalPdfCursorPosition(this.mComposerViewPresenter.getPdfManager().getStartSelectionCursorPosition(), srcContentInfo.mPdfStartPos.getSpenPdfSelectionPos())) {
                srcContentInfo.setSelected(equalPdfCursorPosition(this.mComposerViewPresenter.getPdfManager().getEndSelectionCursorPosition(), srcContentInfo.mPdfEndPos.getSpenPdfSelectionPos()));
            } else {
                srcContentInfo.setSelected(false);
            }
        }
    }

    public void addAutoFormat(AutoFormat.FormatType formatType, AutoFormat.ErrorType errorType) {
        AutoFormat autoFormat = new AutoFormat(this.mAiActions.get(0).getSrcContentInfo(), this.mComposerViewPresenter);
        autoFormat.setCurrentFormatType(formatType);
        autoFormat.setErrorType(errorType);
        this.mAiActions.add(autoFormat);
    }

    public void addSummarize(Summarization.ErrorType errorType) {
        Summarization summarizationStreaming = CscFeature.INSTANCE.getInstance().isChinaAiFeature() ? new SummarizationStreaming(this.mAiActions.get(0).getSrcContentInfo(), this.mComposerViewPresenter) : new Summarization(this.mAiActions.get(0).getSrcContentInfo(), this.mComposerViewPresenter);
        summarizationStreaming.setErrorType(errorType);
        this.mAiActions.add(summarizationStreaming);
    }

    public void addTo(AiMenuContract.IAiAction iAiAction, ResultOperation.AddTo addTo) {
        if (iAiAction == null || !iAiAction.canDoAction()) {
            ToastHandler.show(this.mComposerViewPresenter.getActivity(), C9086R.string.composer_failed_to_copy, 0);
        } else {
            iAiAction.addTo(addTo);
            if (addTo != ResultOperation.AddTo.NewNote) {
                this.mIsBlockingReleaseSelection = true;
                return;
            }
        }
        releaseSelection();
    }

    public void addTranslation(Translation.ErrorType errorType) {
        Translation translation = new Translation(this.mAiActions.get(0).getSrcContentInfo(), this.mComposerViewPresenter);
        translation.setErrorType(errorType);
        this.mAiActions.add(translation);
    }

    public boolean canEditBodyText() {
        return !this.mComposerViewPresenter.getComposerModel().isPDFReader();
    }

    public boolean canReplace() {
        if (getSrcContentInfo() != null) {
            return getSrcContentInfo().getSrcType() == 1 || getSrcContentInfo().getSrcType() == 3;
        }
        return false;
    }

    public boolean canRestore(Bundle bundle) {
        String str = TAG;
        return bundle.containsKey(str) && bundle.getInt(str) == Process.myPid();
    }

    public void copy(AiMenuContract.IAiAction iAiAction) {
        if (iAiAction == null || !iAiAction.canDoAction()) {
            ToastHandler.show(this.mComposerViewPresenter.getActivity(), C9086R.string.composer_failed_to_copy, 0);
        } else {
            iAiAction.copy();
        }
    }

    public void executeAutoFormat(AutoFormat.FormatType formatType) {
        AutoFormat autoFormatStreaming = CscFeature.INSTANCE.getInstance().isChinaAiFeature() ? new AutoFormatStreaming(this.mAiActions.get(0).getSrcContentInfo(), this.mComposerViewPresenter) : new AutoFormat(this.mAiActions.get(0).getSrcContentInfo(), this.mComposerViewPresenter);
        this.mAiActions.add(autoFormatStreaming);
        autoFormatStreaming.setCurrentFormatType(formatType);
        autoFormatStreaming.execute();
    }

    public void executeSTTSummarize(ISTTWindow.IAIContract iAIContract, boolean z) {
        initSTTSummarize(iAIContract);
        STTSummarization sTTSummarization = getSTTSummarization();
        sTTSummarization.setIsSummarizeAgain(z);
        if (!iAIContract.canSummarizeBySubject()) {
            sTTSummarization.setSummaryStyle(STTSummarization.SummaryOption.SHOW_AS_TIMELINE);
        }
        sTTSummarization.execute();
    }

    public void executeSummarize() {
        Summarization summarizationStreaming = CscFeature.INSTANCE.getInstance().isChinaAiFeature() ? new SummarizationStreaming(this.mAiActions.get(0).getSrcContentInfo(), this.mComposerViewPresenter) : new Summarization(this.mAiActions.get(0).getSrcContentInfo(), this.mComposerViewPresenter);
        this.mAiActions.add(summarizationStreaming);
        summarizationStreaming.execute();
    }

    public void executeTranslate() {
        String str = TAG;
        Logger.m10999d(str, "executeTranslate#");
        Translation translation = new Translation(this.mAiActions.get(0).getSrcContentInfo(), this.mComposerViewPresenter);
        String targetLanguage = translation.getSrcContentInfo().getAiBixbyParam().getTargetLanguage();
        if (!TextUtils.isEmpty(targetLanguage)) {
            Logger.m10999d(str, "executeTranslate# set language by bixby " + targetLanguage);
            translation.setLastLanguage(targetLanguage);
            translation.getSrcContentInfo().getAiBixbyParam().setTargetLanguage("");
        }
        this.mAiActions.add(translation);
        translation.execute();
    }

    public Activity getActivity() {
        return this.mComposerViewPresenter.getActivity();
    }

    public List<AiMenuContract.IAiAction> getAiActions() {
        return this.mAiActions;
    }

    public AutoFormat getAutoFormat() {
        for (AiMenuContract.IAiAction iAiAction : this.mAiActions) {
            if (iAiAction instanceof AutoFormat) {
                return (AutoFormat) iAiAction;
            }
        }
        return null;
    }

    public int getBackgroundColor() {
        return this.mComposerViewPresenter.getBackgroundColor();
    }

    public int getBackgroundThemeColor() {
        return this.mComposerViewPresenter.getBackgroundThemeColor();
    }

    public ComposerViewPresenter getComposerViewPresenter() {
        return this.mComposerViewPresenter;
    }

    public CreateImage getCreateImage() {
        for (AiMenuContract.IAiAction iAiAction : this.mAiActions) {
            if (iAiAction instanceof CreateImage) {
                return (CreateImage) iAiAction;
            }
        }
        return null;
    }

    public long getCurrentPageStartShowingTime() {
        return this.mCurrentPageStartShowingTime;
    }

    public int getCurrentScreenIdByAiActions() {
        for (AiMenuContract.IAiAction iAiAction : this.mAiActions) {
            if (iAiAction instanceof RecognizedHw) {
                if (this.mAiActions.size() == 1) {
                    return 9007;
                }
            } else {
                if (iAiAction instanceof AutoFormat) {
                    return ((AutoFormat) iAiAction).getCurrentFormatType() == AutoFormat.FormatType.Meeting ? 90012 : 90011;
                }
                if (iAiAction instanceof Summarization) {
                    return 9002;
                }
                if (iAiAction instanceof SpellingCorrection) {
                    return 9003;
                }
                if (iAiAction instanceof Translation) {
                    return 9004;
                }
                if (iAiAction instanceof CreateImage) {
                    return 9006;
                }
                if ((iAiAction instanceof STTTabletLayoutAction) || (iAiAction instanceof STTSummarization)) {
                    return 9005;
                }
            }
        }
        return 9000;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public int getPreviousScreenId() {
        return this.mPreviousScreenId;
    }

    public RecognizedHw getRecognizedHw() {
        for (AiMenuContract.IAiAction iAiAction : this.mAiActions) {
            if (iAiAction instanceof RecognizedHw) {
                return (RecognizedHw) iAiAction;
            }
        }
        return null;
    }

    public STTSummarization getSTTSummarization() {
        for (AiMenuContract.IAiAction iAiAction : this.mAiActions) {
            if (iAiAction instanceof STTSummarization) {
                return (STTSummarization) iAiAction;
            }
        }
        return null;
    }

    public STTTabletLayoutAction getSTTTabletLayoutAction() {
        for (AiMenuContract.IAiAction iAiAction : this.mAiActions) {
            if (iAiAction instanceof STTTabletLayoutAction) {
                return (STTTabletLayoutAction) iAiAction;
            }
        }
        return null;
    }

    public boolean getSavedInstanceState() {
        return this.mView.getSavedInstanceState();
    }

    public SoftInputManager getSoftInputManager() {
        return this.mComposerViewPresenter.getSoftInputManager();
    }

    public SpellingCorrection getSpellingCorrection() {
        for (AiMenuContract.IAiAction iAiAction : this.mAiActions) {
            if (iAiAction instanceof SpellingCorrection) {
                return (SpellingCorrection) iAiAction;
            }
        }
        return null;
    }

    public SrcContentInfo getSrcContentInfo() {
        if (this.mAiActions.isEmpty()) {
            return null;
        }
        return this.mAiActions.get(0).getSrcContentInfo();
    }

    public Summarization getSummarization() {
        for (AiMenuContract.IAiAction iAiAction : this.mAiActions) {
            if (iAiAction instanceof Summarization) {
                return (Summarization) iAiAction;
            }
        }
        return null;
    }

    public Translation getTranslation() {
        for (AiMenuContract.IAiAction iAiAction : this.mAiActions) {
            if (iAiAction instanceof Translation) {
                return (Translation) iAiAction;
            }
        }
        return null;
    }

    public boolean hasBackgroundImage() {
        return this.mComposerViewPresenter.hasBackgroundImage();
    }

    public void initSTTSummarize(ISTTWindow.IAIContract iAIContract) {
        if (getSTTSummarization() == null) {
            this.mAiActions.add(CscFeature.INSTANCE.getInstance().isChinaAiFeature() ? new STTSummarizationStreaming(iAIContract, this.mComposerViewPresenter) : new STTSummarization(iAIContract, this.mComposerViewPresenter));
        }
    }

    public boolean isBackgroundColorInverted() {
        return this.mComposerViewPresenter.isBackgroundColorInverted();
    }

    public boolean isCanMinimizeMode() {
        return (isFocusingSTTEditMode() || isFocusingSTTSearchMode() || isComposerSearchMode()) ? false : true;
    }

    public boolean isCreateImageRunning() {
        return getCreateImage() != null;
    }

    public boolean isEditingRecognizedHw() {
        RecognizedHw recognizedHw = getRecognizedHw();
        if (this.mView == null || recognizedHw == null) {
            return false;
        }
        return recognizedHw.isEditing();
    }

    public boolean isFocusingSTTEditMode() {
        ISTTWindow.IAIContract iAIContract = this.mAiSTTContract;
        if (iAIContract == null) {
            return false;
        }
        return iAIContract.isFocusingEditMode();
    }

    public boolean isFocusingSTTSearchMode() {
        ISTTWindow.IAIContract iAIContract = this.mAiSTTContract;
        return iAIContract != null && this.mView != null && iAIContract.isSTTSearchMode() && this.mView.isSTTSearchViewFocusing();
    }

    public boolean isRecognizedHwAiResult() {
        return this.mAiActions.get(0) instanceof RecognizedHw;
    }

    public boolean isSTTEditMode() {
        ISTTWindow.IAIContract iAIContract = this.mAiSTTContract;
        if (iAIContract == null) {
            return false;
        }
        return iAIContract.isEditMode();
    }

    public boolean isSTTSearchMode() {
        ISTTWindow.IAIContract iAIContract = this.mAiSTTContract;
        if (iAIContract == null) {
            return false;
        }
        return iAIContract.getSTTPresenter().isSTTSearchMode();
    }

    public boolean isSTTSelectionMode() {
        ISTTWindow.IAIContract iAIContract = this.mAiSTTContract;
        if (iAIContract == null) {
            return false;
        }
        return iAIContract.getSTTPresenter().isSelectionMode();
    }

    public boolean isSTTSelectionSummaryMode() {
        ISTTWindow.IAIContract iAIContract = this.mAiSTTContract;
        if (iAIContract == null) {
            return false;
        }
        return iAIContract.getSTTPresenter().isSelectionSummaryMode();
    }

    public boolean isShowingSip() {
        return isCanMinimizeMode() && this.mComposerViewPresenter.getSoftInputManager().isInputMethodShown();
    }

    public boolean isSinglePageNote() {
        return this.mComposerViewPresenter.getComposerModel().isSingleMode();
    }

    public boolean isTabletLayout() {
        return AiViewUtils.isTabletLayout(this.mComposerViewPresenter.getComposerModel());
    }

    public boolean isUsingAiFunction() {
        AiBixbyParam aiBixbyParam;
        RecognizedHw recognizedHw = getRecognizedHw();
        return recognizedHw == null || this.mAiActions.size() > 1 || (aiBixbyParam = recognizedHw.getSrcContentInfo().getAiBixbyParam()) == null || aiBixbyParam.getAction() != 0;
    }

    public boolean needToBlockHideNavigationBar() {
        return this.mComposerViewPresenter.getComposerModel().isPDFReader() && this.mComposerViewPresenter.getComposerModel().getModeManager().isMode(Mode.Writing);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.CursorChangedListenerImpl.TextSelectionChangedListener
    public void onChanged(int i, int i2) {
    }

    public void onHide() {
        this.mComposerViewPresenter.getComposerControllerManager().getComposerAiController().clearAiTextFormat();
        if (!this.mIsBlockingReleaseSelection) {
            this.mComposerViewPresenter.getPdfManager().clearSelection();
        }
        this.mComposerViewPresenter.getListenerManager().setCursorChangedListener(null);
        this.mComposerViewPresenter.getWritingToolManager().setConvertToTextCancelListener(null);
        this.mComposerViewPresenter.getWritingToolManager().cancelConvertToText();
        this.mComposerViewPresenter.getWritingToolManager().setAutoFormatListener(null);
        this.mDialogManager.getQuickNoteDialogPresenter().blockToShow(false);
        if (this.mComposerViewPresenter.getView() != null) {
            this.mComposerViewPresenter.getView().requestFocus();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mAiMenuEventListener.onHide();
        this.mComposerViewPresenter.getSoftInputManager().removeOnSipListener(this.mOnSipListener);
        this.mComposerViewPresenter.getSoftInputManager().setOnCalledShowMethodListener(null);
    }

    public void onMinimize(boolean z) {
        STTSearchPresenter mSTTSearchPresenter;
        if (getSTTTabletLayoutAction() == null || (mSTTSearchPresenter = this.mAiSTTContract.getSTTPresenter().getMSTTSearchPresenter()) == null || !this.mAiSTTContract.getSTTPresenter().isSTTSearchMode()) {
            return;
        }
        mSTTSearchPresenter.onMinimize(z);
    }

    public void onResume() {
        AiMenuContract.IView iView = this.mView;
        if (iView == null || !iView.isShowing()) {
            return;
        }
        this.mView.onResume();
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        AiMenuContract.IView iView = this.mView;
        if (iView == null || !iView.isShowing()) {
            return;
        }
        this.mView.onSaveInstanceState(bundle);
        bundle.putInt(TAG, Process.myPid());
        Iterator<AiMenuContract.IAiAction> it = this.mAiActions.iterator();
        while (it.hasNext()) {
            it.next().onSaveInstanceState(bundle);
        }
        SrcContentInfo srcContentInfo = getSrcContentInfo();
        updateSelection(srcContentInfo);
        bundle.putParcelable(SAVE_KEY_RESULT_SRC, getSrcContentInfo());
        bundle.putInt(SAVE_KEY_RESULT_PAGE_INDEX, this.mView.getCurrentPageIndex());
        String str = TAG;
        StringBuilder sb = new StringBuilder("onSaveInstanceState# pageIndex = ");
        sb.append(this.mView.getCurrentPageIndex());
        sb.append(" ");
        sb.append(srcContentInfo == null ? null : Boolean.valueOf(srcContentInfo.isSelected()));
        Logger.m10999d(str, sb.toString());
    }

    public void onShow() {
        this.mIsBlockingReleaseSelection = false;
        initOnShow();
        this.mAiMenuEventListener.onShow();
        this.mComposerViewPresenter.getSoftInputManager().addOnSipListener(this.mOnSipListener);
        this.mComposerViewPresenter.getSoftInputManager().setOnCalledShowMethodListener(this.mOnCalledShowMethodListenerImpl);
    }

    public void overwrite(AiMenuContract.IAiAction iAiAction) {
        if (this.mComposerViewPresenter.isLockedScreen()) {
            Logger.m10999d(TAG, "overwrite# blocking");
            return;
        }
        if (iAiAction == null || !iAiAction.canDoAction()) {
            ToastHandler.show(this.mComposerViewPresenter.getActivity(), C9086R.string.composer_failed_to_copy, 0);
            releaseSelection();
        } else {
            iAiAction.overwrite();
            this.mIsBlockingReleaseSelection = true;
        }
    }

    public void releaseSelection() {
        if (!this.mComposerViewPresenter.getTextManager().isSelected()) {
            this.mComposerViewPresenter.getWritingToolManager().cancelConvertToText();
        } else if (this.mIsBlockingReleaseSelection) {
            this.mIsBlockingReleaseSelection = false;
        } else {
            this.mComposerViewPresenter.getDoc().getBodyText().setCursorPosition(this.mComposerViewPresenter.getTextManager().getCursorFromFocusedTextBox()[0]);
        }
    }

    public boolean requiredAddToNoteOnly() {
        return isCreateImageRunning();
    }

    public void restore(Bundle bundle, SrcContentInfo srcContentInfo) {
        if (srcContentInfo.getInputIndex() - srcContentInfo.getCompletedIndex() != 1) {
            srcContentInfo.setInputIndex(srcContentInfo.getCompletedIndex() + 1);
        }
        Integer num = null;
        RecognizedHw recognizedHw = null;
        for (AiMenuContract.IAiAction iAiAction : this.mAiActions) {
            if (recognizedHw != null && (iAiAction instanceof SpellingCorrection)) {
                srcContentInfo.setSrcNote(recognizedHw.getRecognizedHwNote());
            }
            iAiAction.restoreState(bundle, srcContentInfo);
            if (iAiAction instanceof RecognizedHw) {
                recognizedHw = (RecognizedHw) iAiAction;
            }
        }
        Boolean bool = this.mPageLayoutIsVertical;
        if (bool != null) {
            num = this.mPageLayoutColumn;
        } else {
            bool = null;
        }
        int i = bundle.getInt(SAVE_KEY_RESULT_PAGE_INDEX, 0);
        String str = TAG;
        AbstractC0000a.m3D(i, "restore# pageIndex = ", str);
        this.mView.show(this.mComposerViewPresenter.getActivity(), false, Integer.valueOf(i), true);
        if (srcContentInfo.getInputList() != null) {
            Logger.m10999d(str, "inputSize: " + srcContentInfo.getInputList().size() + " inputIndex: " + srcContentInfo.getInputIndex() + " completedIndex: " + srcContentInfo.getCompletedIndex());
            if (srcContentInfo.getCompletedIndex() != srcContentInfo.getInputList().size() - 1 && srcContentInfo.getCompletedIndex() >= 0) {
                ToastHandler.show(getActivity(), C9086R.string.ai_stopped, 0);
            }
        }
        if (recognizedHw != null) {
            if (recognizedHw.getSrcContentInfo().isSelected()) {
                recognizedHw.restoreRecognize();
            } else {
                this.mView.setDisableSettingBtn();
            }
        }
        if (getSrcContentInfo() != null && !getSrcContentInfo().isSelected()) {
            this.mView.setEnableReplace(false);
        }
        if (this.mPageLayoutIsVertical != null) {
            this.mPageLayoutColumn = num;
            this.mPageLayoutIsVertical = bool;
        }
    }

    public void setAiAction(AiMenuContract.IAiAction iAiAction) {
        if (!this.mAiActions.isEmpty()) {
            Logger.m11000e(TAG, "setAiAction# unexpected case");
            if (getSTTTabletLayoutAction() != null) {
                this.mAiSTTContract.getSTTPresenter().setMode(STTMode.REPLAY);
                this.mAiSTTContract.getSTTPresenter().getFloatingController().setShowingState(iAiAction instanceof STTTabletLayoutAction);
            }
            this.mAiActions.clear();
        }
        this.mAiActions.add(iAiAction);
        if (iAiAction instanceof RecognizedHw) {
            ((RecognizedHw) iAiAction).setConstruct(new RecognizedHw.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuResultViewPresenter.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.RecognizedHw.Contract
                public void onClosedCTT() {
                    AiMenuResultViewPresenter.this.mView.setDisableSettingBtn();
                    AiMenuResultViewPresenter.this.mComposerViewPresenter.setContextMenuDelegate(false, null);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.RecognizedHw.Contract
                public void requestClose() {
                    AiMenuResultViewPresenter.this.mView.hide(new boolean[0]);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.RecognizedHw.Contract
                public void setProgress(boolean z) {
                    if (z) {
                        AiMenuResultViewPresenter.this.mView.showNormalProgress();
                    } else {
                        AiMenuResultViewPresenter.this.mView.hideNormalProgress();
                    }
                }
            });
        }
    }

    public void setAlwaysFitPageToScreen() {
        this.mComposerViewPresenter.setAllwaysFitPageToScreen(true);
        this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuResultViewPresenter.3
            @Override // java.lang.Runnable
            public void run() {
                AiMenuResultViewPresenter.this.mComposerViewPresenter.setAllwaysFitPageToScreen(false);
            }
        });
    }

    public void setBlockingReleaseSelection(boolean z) {
        if (z) {
            this.mIsBlockingReleaseSelection = !this.mComposerViewPresenter.getComposerControllerManager().getComposerAiController().isNeedToReleaseAiSelectionOnFirstMove();
        }
    }

    public void setCurrentPageStartShowingTime(long j) {
        this.mCurrentPageStartShowingTime = j;
    }

    public void setFocusEditResult(boolean z) {
        this.mView.setFocusEditResult(z);
    }

    public void setModeSearch() {
        this.mAiSTTContract.getSTTPresenter().setMode(STTMode.SEARCH_COMPOSER);
    }

    public void setPreviousScreenId(int i) {
        this.mPreviousScreenId = i;
    }

    public void setView(AiMenuContract.IView iView) {
        this.mView = iView;
    }

    public void startDragAndDrop(View view, final SpenObjectTextBox spenObjectTextBox) {
        if (this.mControllerManager.getTaskController().isRunning()) {
            Logger.m11000e(TAG, "startDragAndDrop# getTaskController isRunning");
            return;
        }
        Logger.m10999d(TAG, "startDragAndDrop# ");
        final TaskStartDrag.InputValues inputValues = new TaskStartDrag.InputValues(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getObjectManager(), view, spenObjectTextBox);
        final TaskStartDrag taskStartDrag = new TaskStartDrag();
        this.mControllerManager.getTaskController().execute(taskStartDrag, inputValues, new Task.Callback<TaskStartDrag.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuResultViewPresenter.4
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskStartDrag.ResultValues resultValues) {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskStartDrag.ResultValues resultValues) {
                taskStartDrag.startDragAndDrop(inputValues, resultValues.getClipData(), spenObjectTextBox.getText(), null);
            }
        }, false);
    }

    public void stopContinues() {
        AiMenuContract.IAiAction iAiAction = (AiMenuContract.IAiAction) AbstractC0000a.m10g(this.mAiActions, 1);
        if (iAiAction instanceof Summarization) {
            Summarization summarization = (Summarization) iAiAction;
            ComposerSA.insertLog("802", ComposerSAConstants.EVENT_AI_CANCEL_GENERATE, summarization.getDetailSAAiType());
            summarization.cancel();
        } else if (iAiAction instanceof SpellingCorrection) {
            SpellingCorrection spellingCorrection = (SpellingCorrection) iAiAction;
            ComposerSA.insertLog("802", ComposerSAConstants.EVENT_AI_CANCEL_GENERATE, spellingCorrection.getDetailSAAiType());
            spellingCorrection.cancel();
        } else if (iAiAction instanceof AutoFormat) {
            AutoFormat autoFormat = (AutoFormat) iAiAction;
            ComposerSA.insertLog("802", ComposerSAConstants.EVENT_AI_CANCEL_GENERATE, autoFormat.getDetailSAAiType());
            autoFormat.cancel();
        }
    }

    public void updateNewAiAction(AiMenuContract.IAiAction iAiAction) {
        this.mPreviousScreenId = getCurrentScreenIdByAiActions();
        this.mHandler.removeCallbacksAndMessages(null);
        this.mView.clearCurrentAiAction();
        setAiAction(iAiAction);
        this.mView.updateNewAiAction();
        initOnShow();
    }
}
