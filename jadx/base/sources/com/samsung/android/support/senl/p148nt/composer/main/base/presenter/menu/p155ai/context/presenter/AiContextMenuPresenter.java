package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.view.View;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.setting.quicktool.RunnableC7661m;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingStraightenData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiBixbyParam;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiMenuEventListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiAssistMenuExecutor;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiContextHwManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiContextTextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiMenuResultManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.ContentSwitcher;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf.TranslationOverlayManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.RecognizedHw;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SrcContentInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.DrawingAssistTypePopupWindow;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.solvemath.SolveMathPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import java.util.ArrayList;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiContextMenuPresenter {
    private static final String SAVE_KEY_AI_BIXBY = "ai_bixby_param";
    private static final String SAVE_KEY_CONTEXT_SRC = "context_src";
    private static final String TAG = Logger.createTag("AiContextMenuPresenter", AiConstants.PREFIX_TAG);
    private final AiAssistMenuExecutor mAiAssistMenuExecutor;
    private AiContextMenu mAiContextMenu;
    private AiDrawingManager mAiDrawingManager;
    private final AiMenuResultManager mAiMenuResultManager;
    private AiMenuViewContract mAiMenuViewContract;
    private AiBixbyParam mBixbyParam;
    private View mCallerView;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final ContentSwitcher mContentSwitcher;
    private final AiContextHwManager mContextHwManager;
    private final AiContextTextManager mContextTextManager;
    private final ControllerManager mControllerManager;
    private final DialogPresenterManager mDialogManager;
    private final Handler mHandler;
    private final MenuPresenterContract.IMenuManager mMenuManager;
    private final SolveMathPresenter mSolveMathPresenter;
    private final AiContextMenuState mState;
    private final TranslationOverlayManager mTranslationOverlayManager;
    private final VoiceRecordMenuPresenter mVoiceRecordMenuPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AiAssistMenuExecutorContract implements AiAssistMenuExecutor.Contract {
        public AiAssistMenuExecutorContract() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.Contract
        public void cleanUpText() {
            AiContextMenuPresenter.this.cleanUpText();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.Contract
        public AiBixbyParam getParam() {
            return AiContextMenuPresenter.this.mBixbyParam;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.Contract
        public SrcContentInfo getSrcContentInfo() {
            return AiContextMenuPresenter.this.getSrcContentInfo();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.Contract
        public void matchSelectionRange(SrcContentInfo srcContentInfo) {
            if (AiContextMenuPresenter.this.mContextTextManager.getSelectionText() != null) {
                AiContextMenuPresenter.this.mContextTextManager.getSelectionText().matchSelectionRange(srcContentInfo);
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.Contract
        public void setParam(AiBixbyParam aiBixbyParam) {
            AiContextMenuPresenter.this.mBixbyParam = aiBixbyParam;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AiContextHwManagerContract extends AiContextTextManagerContract implements AiContextHwManager.Contract {
        public AiContextHwManagerContract() {
            super();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextHwManager.Contract
        public void handleFailOfStartHwContext() {
            AiContextMenuPresenter.this.handleFailOfStartHwContext();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextHwManager.Contract
        public void onHide() {
            AiContextMenuPresenter.this.onHide();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextHwManager.Contract
        public void show(boolean z, int i, View view, boolean z2) {
            AiContextMenuPresenter aiContextMenuPresenter = AiContextMenuPresenter.this;
            aiContextMenuPresenter.show(z, aiContextMenuPresenter.mBixbyParam, i, view, z2);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextHwManager.Contract
        public boolean startTextSelection(int i) {
            return AiContextMenuPresenter.this.mContextTextManager.startTextSelection(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AiContextTextManagerContract implements AiContextTextManager.Contract {
        public AiContextTextManagerContract() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextTextManager.Contract
        public AiContextMenu getAiContextMenu() {
            return AiContextMenuPresenter.this.mAiContextMenu;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextTextManager.Contract
        public void initMenuExecutor(boolean z) {
            if (z) {
                AiContextMenuPresenter.this.mAiAssistMenuExecutor.setHwBase();
            } else {
                AiContextMenuPresenter.this.mAiAssistMenuExecutor.setTextBase();
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextTextManager.Contract
        public boolean isBixbyAction() {
            return AiContextMenuPresenter.this.mBixbyParam != null && AiContextMenuPresenter.this.mBixbyParam.hasResultActionForBixby();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextTextManager.Contract
        public boolean isResultActionDirect() {
            if (AiContextMenuPresenter.this.mBixbyParam != null) {
                return AiContextMenuPresenter.this.mBixbyParam.getResultAction() == 6 || AiContextMenuPresenter.this.mBixbyParam.hasResultActionForBixby();
            }
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextTextManager.Contract
        public void postDirectAction() {
            AiContextMenuPresenter.this.postDirectAction();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextTextManager.Contract
        public void postSmoothScrollAndScaleToFitPage(boolean z, int i, Runnable runnable) {
            AiContextMenuPresenter.this.postSmoothScrollAndScaleToFitPage(z, i, runnable);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextTextManager.Contract
        public void setCanSwitchContents(boolean z) {
            AiContextMenuPresenter.this.mContentSwitcher.setCanSwitchContents(z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AiMenuViewContract {
        void hide();

        void show();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ResultContract implements AiMenuResultManager.Contract {
        public ResultContract() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiMenuResultManager.Contract
        public void clearAiResultPendingFlag() {
            AiContextMenuPresenter.this.mAiAssistMenuExecutor.clearPendingFlag();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiMenuResultManager.Contract
        @RequiresApi(api = 33)
        public void restoreSelection(SrcContentInfo srcContentInfo) {
            if (srcContentInfo.getSrcType() == 2) {
                AiContextMenuPresenter.this.mContextHwManager.restoreResultSelection();
                return;
            }
            AiContextMenuPresenter.this.mContextTextManager.restoreTextSelection(srcContentInfo);
            AiContextMenuPresenter.this.mComposerViewPresenter.getTextManager().setAiTextFormat(true);
            AiContextMenuPresenter.this.mComposerViewPresenter.getPdfManager().setAiTextFormat(true);
        }
    }

    public AiContextMenuPresenter(MenuPresenterContract.IMenuManager iMenuManager, VoiceRecordMenuPresenter voiceRecordMenuPresenter, ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, DialogPresenterManager dialogPresenterManager, AiMenuEventListener aiMenuEventListener) {
        AiContextMenuState aiContextMenuState = new AiContextMenuState();
        this.mState = aiContextMenuState;
        this.mCallerView = null;
        Handler handler = new Handler(Looper.getMainLooper());
        this.mHandler = handler;
        this.mVoiceRecordMenuPresenter = voiceRecordMenuPresenter;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mControllerManager = controllerManager;
        this.mDialogManager = dialogPresenterManager;
        this.mMenuManager = iMenuManager;
        AiMenuResultManager aiMenuResultManager = new AiMenuResultManager(composerViewPresenter, controllerManager, dialogPresenterManager, aiMenuEventListener, new ResultContract());
        this.mAiMenuResultManager = aiMenuResultManager;
        TranslationOverlayManager translationOverlayManager = new TranslationOverlayManager(composerViewPresenter, composerViewPresenter.getComposerModel(), iMenuManager);
        this.mTranslationOverlayManager = translationOverlayManager;
        this.mSolveMathPresenter = new SolveMathPresenter(composerViewPresenter);
        this.mContentSwitcher = new ContentSwitcher(composerViewPresenter, new ContentSwitcher.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenuPresenter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.ContentSwitcher.Contract
            public AiBixbyParam getAiBixbyParam() {
                return AiContextMenuPresenter.this.mBixbyParam;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.ContentSwitcher.Contract
            public boolean hasBodyText(int i) {
                return AiContextMenuPresenter.this.mContextTextManager.hasBodyTextWithSelectionText(i);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.ContentSwitcher.Contract
            public boolean hasLineRectList() {
                return AiContextMenuPresenter.this.mContextHwManager.hasLineRectList();
            }
        });
        this.mContextTextManager = new AiContextTextManager(composerViewPresenter, controllerManager, translationOverlayManager, aiContextMenuState, new AiContextTextManagerContract());
        this.mContextHwManager = new AiContextHwManager(composerViewPresenter, controllerManager, aiContextMenuState, aiMenuResultManager, new AiContextHwManagerContract());
        this.mAiAssistMenuExecutor = new AiAssistMenuExecutor(handler, composerViewPresenter, voiceRecordMenuPresenter, aiMenuResultManager, new AiAssistMenuExecutorContract());
    }

    private boolean canNotRestore(Bundle bundle) {
        String str = TAG;
        return (bundle.containsKey(str) && bundle.getInt(str) == Process.myPid()) ? false : true;
    }

    private AiDrawingManager getAiDrawingManager() {
        if (this.mAiDrawingManager == null) {
            this.mAiDrawingManager = new AiDrawingManager(this.mHandler, this.mComposerViewPresenter, this.mAiAssistMenuExecutor, this.mMenuManager);
        }
        return this.mAiDrawingManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFailOfStartHwContext() {
        getSelectionHW().doRecognitionFailed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doDirectAction$5(int i) {
        this.mVoiceRecordMenuPresenter.showRecordingPlayView(true);
        this.mVoiceRecordMenuPresenter.expandRecordingListVerticalMenu();
        this.mAiMenuResultManager.getAiSTTContract().getSTTPresenter().setIndexItemToShow(i);
        executeSTT();
        if (this.mAiMenuResultManager.getAiSTTContract().getSTTPresenter().getVoiceDataController().isHaveSTTData(i) || this.mAiMenuResultManager.getAiSTTContract().getSTTPresenter().isItemSTTConverting(i)) {
            this.mAiMenuResultManager.getAiSTTContract().getSTTPresenter().dismissSelectLanguageDialog();
        } else {
            this.mAiMenuResultManager.getAiSTTContract().executeSTT(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeMeeting$7() {
        this.mAiAssistMenuExecutor.getExecutor().executeAutoFormat(AutoFormat.FormatType.Meeting);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeNormal$6() {
        this.mAiAssistMenuExecutor.getExecutor().executeAutoFormat(AutoFormat.FormatType.Normal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeSpellingCorrection$9() {
        this.mAiAssistMenuExecutor.getExecutor().executeSpellingCorrection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeSummarize$8() {
        this.mAiAssistMenuExecutor.getExecutor().executeSummarize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeTranslate$10() {
        this.mAiAssistMenuExecutor.getExecutor().executeTranslate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeTranslateWithOverlay$12(String str, Runnable runnable) {
        if (!this.mComposerViewPresenter.getComposerModel().getComposerState().isTranslated()) {
            this.mComposerViewPresenter.getComposerModel().getComposerState().setTranslated(true);
        }
        this.mTranslationOverlayManager.start(str);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postDirectAction$3() {
        this.mAiAssistMenuExecutor.setTextBase();
        doDirectAction(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postDirectAction$4() {
        doDirectAction(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$1() {
        Logger.m11000e(TAG, "show# canceled");
        onHide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startAiAssist$2(int i) {
        this.mContextTextManager.getSelectionText().selectPdfText(this.mComposerViewPresenter.getDoc(), i, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$switchContents$11() {
        this.mAiContextMenu.showSwitchContentForOverlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postDirectAction() {
        if (this.mBixbyParam.isMaxSelection() && canShowContainerSelectNext()) {
            this.mBixbyParam.setMaxSelectionFlag(false);
            this.mState.setWaitingMaxSelection(true);
            getHandler().post(new RunnableC9341a(this, 7));
        } else {
            this.mState.setWaitingMaxSelection(false);
            if (this.mBixbyParam.getResultAction() == 6) {
                getHandler().postDelayed(new RunnableC9341a(this, 8), 200L);
            } else {
                getHandler().postDelayed(new RunnableC9341a(this, 9), 300L);
            }
        }
    }

    private void restoreAiBixbyParam(Bundle bundle) {
        AiBixbyParam aiBixbyParam = (AiBixbyParam) bundle.getParcelable(SAVE_KEY_AI_BIXBY);
        if (aiBixbyParam != null) {
            Logger.m10999d(TAG, "restoreAiBixbyParam");
            this.mBixbyParam = aiBixbyParam;
        }
    }

    private void restoreDrawing(Bundle bundle) {
        if (FeatureInfo.isAiDrawingS2IEnabled() && isAiDrawingActivated()) {
            Logger.m10999d(TAG, "restoreDrawing");
            getAiDrawingManager().restoreDrawing(bundle);
        }
    }

    private void restoreRegardlessOs(Bundle bundle) {
        Logger.m10999d(TAG, "restoreRegardlessOs");
        restoreSolveMath(bundle);
    }

    private void restoreSolveMath(Bundle bundle) {
        SolveMathPresenter solveMathPresenter = this.mSolveMathPresenter;
        if (solveMathPresenter != null) {
            solveMathPresenter.restore(bundle);
        }
    }

    private void restoreTranslate(Bundle bundle) {
        Logger.m10999d(TAG, "restoreTranslate");
        if (this.mTranslationOverlayManager == null || !this.mComposerViewPresenter.getComposerModel().getComposerState().isTranslated()) {
            return;
        }
        this.mTranslationOverlayManager.stop();
        this.mTranslationOverlayManager.restoreTranslate(bundle);
        this.mTranslationOverlayManager.start(null);
    }

    private void saveState(@NonNull Bundle bundle) {
        AiBixbyParam aiBixbyParam = this.mBixbyParam;
        if (aiBixbyParam != null) {
            bundle.putParcelable(SAVE_KEY_AI_BIXBY, aiBixbyParam);
        }
        if (!this.mContextHwManager.saveState(bundle)) {
            SrcContentInfo srcContentInfo = getSrcContentInfo();
            if (srcContentInfo == null) {
                return;
            } else {
                bundle.putParcelable(SAVE_KEY_CONTEXT_SRC, srcContentInfo);
            }
        }
        bundle.putInt(TAG, Process.myPid());
    }

    private boolean showGoToSettingsDialogIfNeeded() {
        int i;
        if (!RecognitionUtil.isHWREnabled()) {
            Logger.m10999d(TAG, "showGoToSettingsDialogIfNeeded# isHWREnabled : false");
            i = C9086R.string.ai_error_handwriting_disabled;
        } else {
            if (TextRecognitionLanguageDownloadHelper.getDefaultLanguageSupported(this.mComposerViewPresenter.getActivity())) {
                return false;
            }
            Logger.m10999d(TAG, "showGoToSettingsDialogIfNeeded# isDefaultLanguageSupported : false");
            i = C9086R.string.ai_error_no_existed_language_by_default_language;
        }
        this.mDialogManager.showGoToSettingsDialog(i);
        return true;
    }

    private void showToastCouldNotRun(String str) {
        ToastHandler.show(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getActivity().getString(C9086R.string.could_not_run_something, str), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startAiAssist, reason: merged with bridge method [inline-methods] */
    public void lambda$show$0(int i, boolean z) {
        if (this.mContextTextManager.getSelectionText() == null) {
            Logger.m11000e(TAG, "mSelectionText is null");
            return;
        }
        if (this.mContentSwitcher.isRecognitionSupported()) {
            if (z) {
                if (this.mContextHwManager.isAiAssistHw()) {
                    this.mContextHwManager.startHwSelection(i, z);
                    return;
                }
            } else if (isWritingMode()) {
                if (this.mComposerViewPresenter.getComposerModel().getComposerSpenDocModel().hasStrokeInSelected()) {
                    this.mContextHwManager.startHwSelection(i, z);
                    return;
                } else if (this.mContextTextManager.getSelectionText().canStartPdf(this.mComposerViewPresenter.getDoc())) {
                    this.mContextTextManager.startTextSelection(i, z, new RunnableC9342b(this, i, 1));
                    return;
                } else {
                    if (!this.mContextTextManager.getSelectionText().canStartBodyText(this.mComposerViewPresenter.getDoc())) {
                        this.mContextHwManager.startHwSelection(i, z);
                        return;
                    }
                    Logger.m11003i(TAG, "startAiAssist# : canStartBodyText = true ");
                }
            }
        }
        if (this.mContextTextManager.getSelectionText().startTextSelection(false)) {
            if (this.mBixbyParam.getResultAction() == 5 && this.mContextTextManager.getSelectionText().canStartAutomatically()) {
                this.mBixbyParam.setResultAction(6);
            }
            this.mContextTextManager.startTextSelection(i, z, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenuPresenter.2
                @Override // java.lang.Runnable
                public void run() {
                    AiContextMenuPresenter.this.mContextTextManager.getSelectionText().startTextSelection(true);
                }
            });
            return;
        }
        if (this.mComposerViewPresenter.getComposerModel().isPDFReader()) {
            Logger.m11000e(TAG, "startAiAssist# pdf reader dose not support recognition");
            AiCommonUtil.showCustomToast(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getActivity().getResources().getString(C9086R.string.ai_error_can_not_find_any_text));
            onHide();
        } else {
            if (RecognitionUtil.isSupported(this.mComposerViewPresenter.getActivity())) {
                this.mContextHwManager.startHwSelection(i, z);
                return;
            }
            Logger.m11000e(TAG, "startAiAssist# recognition is not supported");
            if (!this.mContentSwitcher.hasHandWriting(i, false)) {
                AiCommonUtil.showCustomToast(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getActivity().getResources().getString(C9086R.string.ai_error_can_not_find_any_text));
            } else if (showGoToSettingsDialogIfNeeded()) {
                onHide();
                return;
            } else if (DeviceUtils.isTabletModel()) {
                AiCommonUtil.showCustomToast(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getActivity().getResources().getString(C9086R.string.ai_error_not_support_handwriting_recognition_tablet));
            } else {
                AiCommonUtil.showCustomToast(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getActivity().getResources().getString(C9086R.string.ai_error_not_support_handwriting_recognition_phone));
            }
            onHide();
        }
    }

    public boolean canShowContainerSelectNext() {
        return (this.mComposerViewPresenter.getComposerModel().isSingleMode() || this.mComposerViewPresenter.getDoc().getPageCount() <= 2 || this.mComposerViewPresenter.getComposerModel().getComposerSpenDocModel().hasStrokeInSelected() || isTranslationOverlayActivated()) ? false : true;
    }

    public boolean canShowDoneButton() {
        return this.mBixbyParam.getResultAction() != 6;
    }

    public boolean canShowSTTTranscribeMenu() {
        SpenWNote doc = this.mComposerViewPresenter.getComposerModel().getDoc();
        if (doc == null) {
            Logger.m11000e(TAG, "canShowSTTTranscribeMenu# composerDoc is null");
            return false;
        }
        ArrayList<SpenVoiceData> voiceDataList = doc.getVoiceDataList();
        return (isPdfReader() || voiceDataList == null || voiceDataList.isEmpty()) ? false : true;
    }

    public boolean canUseOverlayPdfWithCurrentPage() {
        if ((this.mComposerViewPresenter.getTextManager().isSelected() && this.mComposerViewPresenter.getObjectManager().isSelectedBodyText()) || this.mComposerViewPresenter.getComposerModel().getComposerSpenDocModel().hasStrokeInSelected()) {
            return false;
        }
        int currentPageIndex = this.mComposerViewPresenter.getCurrentPageIndex();
        if (this.mComposerViewPresenter.getComposerModel().getComposerSpenDocModel().hasPdf(currentPageIndex)) {
            return this.mComposerViewPresenter.getComposerModel().isSingleMode() ? this.mComposerViewPresenter.getPdfManager().hasPdfOnScreen() : this.mComposerViewPresenter.getComposerModel().getDoc().getPage(currentPageIndex).getTemplateType() != 16;
        }
        return false;
    }

    public boolean canUseSpellingCollection(int i) {
        if (isWritingMode()) {
            return false;
        }
        return this.mContextTextManager.hasBodyTextWithSelectionText(i) || !this.mContentSwitcher.hasHandWriting(i);
    }

    public void cleanUpHw() {
        if (this.mContextHwManager.getSelectionHW() == null) {
            Logger.m11000e(TAG, "cleanUpHw# is null");
            return;
        }
        Logger.m10999d(TAG, "cleanUpHw#");
        this.mComposerViewPresenter.getWritingToolManager().cancelConvertToText(false);
        SettingStraightenData settingStraightenData = new SettingStraightenData();
        this.mComposerViewPresenter.getWritingToolManager().setAlignmentOptions(settingStraightenData.getStraightenEnabled(), settingStraightenData.getAlignLettersEnabled(), settingStraightenData.getEvenlySpaceWordsEnabled(), settingStraightenData.getFixShapeLettersEnabled());
        this.mComposerViewPresenter.getWritingToolManager().executeCleanUp(this.mContextHwManager.getSelectionHW().getLineRectFList());
        this.mAiContextMenu.hide();
    }

    public void cleanUpText() {
        if (this.mContextHwManager.getSelectionHW() == null) {
            Logger.m11000e(TAG, "cleanUpText# is null");
            return;
        }
        Logger.m10999d(TAG, "cleanUpText#");
        ArrayList<RectF> lineRectFList = this.mContextHwManager.getSelectionHW().getLineRectFList();
        RecognizedHw recognizedHw = new RecognizedHw(this.mComposerViewPresenter, lineRectFList, this.mBixbyParam);
        recognizedHw.getSrcContentInfo().setSAForAIScenarioScreenID(this.mState.getSAScreenID());
        recognizedHw.getSrcContentInfo().setSAForAIScenario(this.mState.getSAScenario());
        if (this.mAiAssistMenuExecutor.getExecutor() == null) {
            this.mAiAssistMenuExecutor.setHwBase();
        }
        this.mAiMenuResultManager.showResultView(recognizedHw);
        if (this.mComposerViewPresenter.getComposerModel().getComposerSpenDocModel().hasStrokeInSelected()) {
            recognizedHw.startRecognitionWithSelectedStroke();
        } else {
            recognizedHw.startRecognition(lineRectFList);
        }
        this.mAiContextMenu.hide();
    }

    public void clearAiResultPendingFlag() {
        this.mAiAssistMenuExecutor.clearPendingFlag();
    }

    public void clearSearchComposer() {
        AiMenuResultManager aiMenuResultManager = this.mAiMenuResultManager;
        if (aiMenuResultManager != null) {
            aiMenuResultManager.clearSearchComposer();
        }
    }

    public void clearSelectionText() {
        this.mContextTextManager.clearSelectionText();
    }

    public void doDirectAction(boolean z) {
        String str = TAG;
        Logger.m10999d(str, "doDirectAction#");
        AiBixbyParam aiBixbyParam = this.mBixbyParam;
        if (aiBixbyParam == null || aiBixbyParam.getResultAction() == 5) {
            Logger.m11000e(str, "mBixbyParam is null");
            return;
        }
        if (z && this.mBixbyParam.getAction() != 0 && this.mAiAssistMenuExecutor.getExecutor() == null) {
            this.mAiAssistMenuExecutor.setHwBase();
        }
        int action = this.mBixbyParam.getAction();
        if (action == 1) {
            executeTranslate();
            return;
        }
        if (action == 2) {
            executeSummarize();
            return;
        }
        if (action == 3) {
            if (!isSelectedPdf()) {
                executeNormal();
                return;
            } else {
                Logger.m10999d(str, "doDirectAction# pdf is not supported autoformat");
                showToastCouldNotRun(this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_auto_format_name));
                return;
            }
        }
        if (action == 4) {
            if (!isSelectedPdf()) {
                executeMeeting();
                return;
            } else {
                Logger.m10999d(str, "doDirectAction# pdf is not supported autoformat");
                showToastCouldNotRun(this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_auto_format_name));
                return;
            }
        }
        if (action == 5) {
            boolean zIsSelectedPdf = isSelectedPdf();
            if (!zIsSelectedPdf && !isAiAssistHw()) {
                executeSpellingCorrection();
                return;
            }
            Logger.m10999d(str, "doDirectAction# pdf is not supported spelling correction");
            showToastCouldNotRun(this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_spelling_correction));
            if (zIsSelectedPdf) {
                return;
            }
            this.mAiContextMenu.hide();
            return;
        }
        if (action != 7) {
            Logger.m11000e(str, "doDirectAction# fail = " + this.mBixbyParam.getAction());
            return;
        }
        int index = this.mBixbyParam.getIndex();
        int size = this.mAiMenuResultManager.getAiSTTContract().getSTTPresenter().getVoiceDataList() != null ? this.mAiMenuResultManager.getAiSTTContract().getSTTPresenter().getVoiceDataList().size() : 0;
        if (index == -1) {
            index = size - 1;
            AbstractC0000a.m3D(index, "doDirectAction# last index voice file ", str);
        }
        if (index >= 0 && index < size) {
            AiCommonUtil.executeActionByOndevice(this.mComposerViewPresenter.getActivity(), new RunnableC9342b(this, index, 0), new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiContextMenuPresenter.3
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m10999d(AiContextMenuPresenter.TAG, "doDirectAction# cancel");
                }
            });
            return;
        }
        Logger.m11000e(str, "doDirectAction# index of voice file not in range " + index);
        ToastHandler.show(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getActivity().getString(C9086R.string.there_is_no_recording), 0);
    }

    public void executeAiMenuDone() {
        int stateForOnlyOneMenu = getStateForOnlyOneMenu();
        if (stateForOnlyOneMenu != 3 && stateForOnlyOneMenu != 4) {
            if (stateForOnlyOneMenu == 2) {
                executeSummarize();
                return;
            } else if (stateForOnlyOneMenu == 5) {
                executeSpellingCorrection();
                return;
            } else {
                if (stateForOnlyOneMenu == 1) {
                    executeTranslate();
                    return;
                }
                return;
            }
        }
        if (this.mAiAssistMenuExecutor.getExecutor() == null || !this.mAiAssistMenuExecutor.getExecutor().checkAutoFormatLimitation()) {
            Logger.m11000e(TAG, "executeAiMenuDone# fail checkAutoFormatLimitation " + this.mAiAssistMenuExecutor.getExecutor());
            return;
        }
        if (stateForOnlyOneMenu == 3) {
            executeNormal();
        } else {
            executeMeeting();
        }
    }

    public void executeMeeting() {
        if (this.mAiAssistMenuExecutor.getExecutor() == null) {
            Logger.m11000e(TAG, "executeMeeting# in null");
        } else {
            Logger.m10999d(TAG, "executeMeeting#");
            this.mComposerViewPresenter.restoreBeforeSmoothScrollAndScaleToFitPage(new RunnableC9341a(this, 1));
        }
    }

    public void executeNormal() {
        if (this.mAiAssistMenuExecutor.getExecutor() == null) {
            Logger.m11000e(TAG, "executeNormal# in null");
            return;
        }
        Logger.m10999d(TAG, "executeNormal#");
        if (this.mBixbyParam.getResultAction() == 6) {
            this.mAiAssistMenuExecutor.getExecutor().executeAutoFormat(AutoFormat.FormatType.Normal);
        } else {
            this.mComposerViewPresenter.restoreBeforeSmoothScrollAndScaleToFitPage(new RunnableC9341a(this, 3));
        }
    }

    public void executeSTT(String str, boolean z, int i) {
        if (this.mAiAssistMenuExecutor.getExecutor() == null) {
            this.mAiAssistMenuExecutor.setTextBase();
        }
        this.mAiAssistMenuExecutor.getExecutor().executeSTT(str, z, i);
        View currentFocus = this.mComposerViewPresenter.getActivity().getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) this.mComposerViewPresenter.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            currentFocus.clearFocus();
        }
    }

    public void executeSpellingCorrection() {
        if (this.mAiAssistMenuExecutor.getExecutor() == null) {
            Logger.m11000e(TAG, "executeSpellingCorrection# in null");
        } else {
            Logger.m10999d(TAG, "executeSpellingCorrection#");
            this.mComposerViewPresenter.restoreBeforeSmoothScrollAndScaleToFitPage(new RunnableC9341a(this, 4));
        }
    }

    public void executeSummarize() {
        if (this.mAiAssistMenuExecutor.getExecutor() == null) {
            Logger.m11000e(TAG, "executeSummarize# in null");
        } else {
            Logger.m10999d(TAG, "executeSummarize#");
            this.mComposerViewPresenter.restoreBeforeSmoothScrollAndScaleToFitPage(new RunnableC9341a(this, 0));
        }
    }

    public void executeTranscribe() {
        if (VoiceManager.isRecording()) {
            Logger.m10999d(TAG, "executeTranscribe# isRecording");
            ToastHandler.show(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getActivity().getString(C9086R.string.ai_can_not_transcribe_while_recording), 0);
            return;
        }
        if (this.mAiAssistMenuExecutor.getExecutor() == null) {
            this.mAiAssistMenuExecutor.setTextBase();
        }
        Logger.m10999d(TAG, "executeTranscribe#");
        this.mAiAssistMenuExecutor.getExecutor().executeTranscribe();
        this.mAiContextMenu.hide();
    }

    public void executeTranslate() {
        if (this.mAiAssistMenuExecutor.getExecutor() == null) {
            Logger.m11000e(TAG, "executeTranslate# in null");
            return;
        }
        if (!isPdfReader() || !this.mComposerViewPresenter.getPdfManager().hasSelectedText() || this.mComposerViewPresenter.getComposerModel().getModeManager().isEditMode()) {
            Logger.m10999d(TAG, "executeTranslate#");
            this.mComposerViewPresenter.restoreBeforeSmoothScrollAndScaleToFitPage(new RunnableC9341a(this, 2));
            return;
        }
        Logger.m10999d(TAG, "executeTranslate# For PdfReader");
        if (!this.mComposerViewPresenter.getComposerModel().getComposerState().isTranslated()) {
            this.mComposerViewPresenter.getComposerModel().getComposerState().setTranslated(true);
        }
        this.mAiContextMenu.hide();
        this.mTranslationOverlayManager.start(null);
    }

    public void executeTranslateDirectly() {
        if (!isPdfReader()) {
            Logger.m10999d(TAG, "executeTranslateDirectly# Ignored by invalid status");
            return;
        }
        Logger.m10999d(TAG, "executeTranslateDirectly# For PdfReader");
        if (this.mAiAssistMenuExecutor.getExecutor() == null) {
            this.mAiAssistMenuExecutor.setTextBase();
        }
        if (!this.mComposerViewPresenter.getComposerModel().getComposerState().isTranslated()) {
            this.mComposerViewPresenter.getComposerModel().getComposerState().setTranslated(true);
        }
        this.mAiContextMenu.hide();
        this.mTranslationOverlayManager.start(null);
    }

    public void executeTranslateWithOverlay(boolean z, @Nullable String str, Runnable runnable) {
        if (!z || isPdfReader()) {
            AbstractC8014b.m7220v("executeTranslateWithOverlay# For PdfReader : ", TAG, z);
            ViewStub viewStub = (ViewStub) this.mComposerViewPresenter.getActivity().findViewById(C9086R.id.scanning_effect_view_stub);
            if (viewStub != null) {
                viewStub.inflate();
            }
            AiLanguageHelper.initTranslateConfig(new RunnableC8928b(this, 8, str, runnable));
        }
    }

    public AiMenuResultManager getAiMenuResultManager() {
        return this.mAiMenuResultManager;
    }

    public ContentSwitcher getContentSwitcher() {
        return this.mContentSwitcher;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    @Nullable
    public View getScanningAnimationTargetView() {
        View view = this.mCallerView;
        if (view == null) {
            return null;
        }
        return view;
    }

    public SelectionHw getSelectionHW() {
        return this.mContextHwManager.getSelectionHW();
    }

    public SelectionText getSelectionText() {
        return this.mContextTextManager.getSelectionText();
    }

    public SolveMathPresenter getSolveMathPresenter() {
        return this.mSolveMathPresenter;
    }

    public SrcContentInfo getSrcContentInfo() {
        if (this.mContextTextManager.getSelectionText() == null) {
            Logger.m11000e(TAG, "getSrcContentInfo# mSelectionText is null");
            return null;
        }
        SrcContentInfo srcContentInfo = this.mContextTextManager.getSelectionText().getSrcContentInfo();
        if (srcContentInfo == null) {
            Logger.m11000e(TAG, "getSrcContentInfo# srcContentInfo is null");
            return null;
        }
        srcContentInfo.setAiBixbyParam(this.mBixbyParam);
        srcContentInfo.setSAForAIScenario(this.mState.getSAScenario());
        srcContentInfo.setSAForAIScenarioScreenID(this.mState.getSAScreenID());
        return srcContentInfo;
    }

    public int getStateForOnlyOneMenu() {
        AiBixbyParam aiBixbyParam = this.mBixbyParam;
        if (aiBixbyParam == null) {
            return 0;
        }
        return aiBixbyParam.getAction();
    }

    public TranslationOverlayManager getTranslationOverlayManager() {
        return this.mTranslationOverlayManager;
    }

    public boolean hasSelectionHW() {
        return this.mContextHwManager.getSelectionHW() != null;
    }

    public void hideContainerSelectNext() {
        AiMenuViewContract aiMenuViewContract = this.mAiMenuViewContract;
        if (aiMenuViewContract != null) {
            aiMenuViewContract.hide();
        }
    }

    public void hideSIP() {
        this.mControllerManager.getSoftInputManager().hide(true);
    }

    public boolean isAiAssistHw() {
        return this.mContextHwManager.isAiAssistHw();
    }

    public boolean isAiDrawingActivated() {
        if (this.mAiDrawingManager == null) {
            return false;
        }
        return getAiDrawingManager().isAiDrawingActivated();
    }

    public boolean isAiMenuForTranslation() {
        AiBixbyParam aiBixbyParam = this.mBixbyParam;
        return aiBixbyParam != null && aiBixbyParam.getResultAction() == 5 && this.mBixbyParam.getAction() == 1;
    }

    public boolean isFirstShowForNextSelectionView() {
        return this.mState.isFirstShowForNextSelectionView();
    }

    public boolean isPdfReader() {
        return this.mComposerViewPresenter.getComposerModel().isPDFReader();
    }

    public boolean isScanningAnimating() {
        return this.mAiAssistMenuExecutor.isPendingAiResult();
    }

    public boolean isSelectedPdf() {
        return this.mComposerViewPresenter.getPdfManager().hasSelectedText();
    }

    public boolean isTextMode() {
        return this.mComposerViewPresenter.getComposerModel().getModeManager().isMode(Mode.Text);
    }

    public boolean isTranslated() {
        return this.mComposerViewPresenter.getComposerModel().getComposerState().isTranslated();
    }

    public boolean isTranslatedPdfOverlapping() {
        return !this.mComposerViewPresenter.getComposerModel().isPDFReader() && this.mComposerViewPresenter.getComposerModel().getComposerState().isTranslated() && isAiMenuForTranslation();
    }

    public boolean isTranslating() {
        return this.mTranslationOverlayManager.isActivated() && this.mTranslationOverlayManager.isTranslating();
    }

    public boolean isTranslationOverlayActivated() {
        return this.mTranslationOverlayManager.isActivated();
    }

    public boolean isWritingMode() {
        return this.mComposerViewPresenter.getComposerModel().getModeManager().isMode(Mode.Writing);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        return ComposerRequestCode.DrawingToolkit.getId() == i ? getAiDrawingManager().onActivityResult(i2, intent) : this.mAiMenuResultManager.onActivityResult(i, i2, intent);
    }

    public boolean onBackPressed() {
        if (this.mTranslationOverlayManager == null || !this.mComposerViewPresenter.getComposerModel().getComposerState().isTranslated()) {
            return false;
        }
        this.mTranslationOverlayManager.close();
        int translatedPageCount = this.mComposerViewPresenter.getPdfManager().getTranslatedPageCount();
        if (translatedPageCount <= 0) {
            return true;
        }
        ComposerSA.insertLog(this.mState.getSAScreenID(), ComposerSAConstants.EVENT_PDF_VIEWER_NUMBER_OF_TRANSLATED_PAGES, String.valueOf(translatedPageCount));
        return true;
    }

    public boolean onBackPressedBeforeComposerView() {
        if (this.mAiMenuResultManager.isShowingResultView()) {
            return this.mAiMenuResultManager.onBackPressedBeforeComposerView();
        }
        if (!isAiDrawingActivated()) {
            return false;
        }
        releaseAiDrawing("onBackPressedBeforeComposerView");
        return true;
    }

    public void onConfigurationChanged(Configuration configuration, boolean z) {
        this.mAiMenuResultManager.onConfigurationChanged(configuration, z);
        this.mSolveMathPresenter.onConfigurationChanged();
    }

    public void onDetachView(boolean... zArr) {
        AiContextMenu aiContextMenu = this.mAiContextMenu;
        if (aiContextMenu != null) {
            aiContextMenu.hide();
        }
        this.mAiMenuResultManager.hideResultView(false, zArr);
        TranslationOverlayManager translationOverlayManager = this.mTranslationOverlayManager;
        if (translationOverlayManager != null) {
            translationOverlayManager.stop();
        }
        SolveMathPresenter solveMathPresenter = this.mSolveMathPresenter;
        if (solveMathPresenter != null) {
            solveMathPresenter.onDetachView();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        clearAiResultPendingFlag();
    }

    public void onHide() {
        Logger.m10999d(TAG, "onHide#");
        boolean z = (this.mAiMenuResultManager.isShowingResultView() || this.mAiAssistMenuExecutor.isPendingAiResult()) ? false : true;
        this.mContextTextManager.clearSelectionText(z);
        this.mContextHwManager.clearSelectionHw(z);
        this.mComposerViewPresenter.getTextManager().getSpenNoteTextManager().setCursorSelectionMaxLength(0);
        this.mComposerViewPresenter.getPdfManager().setCursorSelectionMaxLength(0);
        this.mComposerViewPresenter.getPdfManager().setSelectedPdfStateListener(null);
        if (z) {
            this.mComposerViewPresenter.getComposerControllerManager().getComposerAiController().clearAiTextFormat();
            if (this.mState.isClearTextSelectionFlag()) {
                this.mComposerViewPresenter.getPdfManager().clearSelection();
            }
            this.mComposerViewPresenter.getListenerManager().setCursorChangedListener(null);
            this.mDialogManager.getQuickNoteDialogPresenter().blockToShow(false);
        }
        this.mContextHwManager.showErrorToast();
        this.mComposerViewPresenter.getListenerManager().removeSpenObjectSelectListener(this.mContextHwManager.getSpenObjectSelectListener());
        this.mState.setInitializing(false);
        this.mState.setShowing(false);
        this.mCallerView = null;
        this.mState.setWaitingMaxSelection(false);
    }

    public void onReadyReload() {
        if (this.mTranslationOverlayManager == null || !this.mComposerViewPresenter.getComposerModel().getComposerState().isTranslated()) {
            return;
        }
        this.mTranslationOverlayManager.close();
        this.mTranslationOverlayManager.stop();
    }

    public void onResume() {
        if (this.mTranslationOverlayManager != null && this.mComposerViewPresenter.getComposerModel().getComposerState().isTranslated()) {
            this.mTranslationOverlayManager.onResume();
        }
        AiMenuResultManager aiMenuResultManager = this.mAiMenuResultManager;
        if (aiMenuResultManager != null) {
            aiMenuResultManager.onResume();
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        if (this.mState.isShowing()) {
            saveState(bundle);
        }
        this.mAiMenuResultManager.onSaveInstanceState(bundle);
        if (isAiDrawingActivated()) {
            getAiDrawingManager().onSaveInstanceState(bundle);
        }
        this.mTranslationOverlayManager.onSaveInstanceState(bundle);
        SolveMathPresenter solveMathPresenter = this.mSolveMathPresenter;
        if (solveMathPresenter != null) {
            solveMathPresenter.onSaveInstanceState(bundle);
        }
    }

    public void onWindowModeChanged() {
        TranslationOverlayManager translationOverlayManager = this.mTranslationOverlayManager;
        if (translationOverlayManager != null) {
            translationOverlayManager.onWindowModeChanged();
        }
    }

    public void postSmoothScrollAndScaleToFitPage(boolean z, int i, Runnable runnable) {
        RectF textContentRectByCursorRangeInBodytext;
        if (z) {
            runnable.run();
            return;
        }
        if (!this.mComposerViewPresenter.getComposerModel().isSingleMode()) {
            if (this.mComposerViewPresenter.getPdfManager().hasSelectedText()) {
                i = this.mComposerViewPresenter.getPdfManager().getEndSelectionCursorPosition().getPageIndex();
                AbstractC0000a.m3D(i, "postSmoothScrollAndScaleToFitPage# pdf ", TAG);
            } else if (this.mComposerViewPresenter.getTextManager().isSelected()) {
                int[] cursorFromFocusedTextBox = this.mComposerViewPresenter.getTextManager().getCursorFromFocusedTextBox();
                i = this.mComposerViewPresenter.getTextManager().getSpenNoteTextManager().getPageIndexByCursorOfBodyText(Math.max(cursorFromFocusedTextBox[0], cursorFromFocusedTextBox[1] - 1));
                AbstractC0000a.m3D(i, "postSmoothScrollAndScaleToFitPage# ", TAG);
            }
            this.mComposerViewPresenter.smoothScrollAndScaleToFitPage(i, runnable, this.mState.isStartTextMode() ? 0 : 300);
            return;
        }
        if (this.mComposerViewPresenter.getPdfManager().hasSelectedText()) {
            textContentRectByCursorRangeInBodytext = this.mComposerViewPresenter.getPdfManager().getRectByCursor(this.mComposerViewPresenter.getPdfManager().getCurrentCursor());
        } else if (this.mComposerViewPresenter.getTextManager().isSelected()) {
            int[] cursorFromFocusedTextBox2 = this.mComposerViewPresenter.getTextManager().getCursorFromFocusedTextBox();
            textContentRectByCursorRangeInBodytext = this.mComposerViewPresenter.getTextManager().getTextContentRectByCursorRangeInBodytext(cursorFromFocusedTextBox2[0], cursorFromFocusedTextBox2[1]);
        } else {
            textContentRectByCursorRangeInBodytext = null;
        }
        if (textContentRectByCursorRangeInBodytext == null) {
            runnable.run();
            return;
        }
        Logger.m10999d(TAG, "postSmoothScrollAndScaleToFitPage# " + textContentRectByCursorRangeInBodytext);
        this.mComposerViewPresenter.smoothScrollAndScaleToFitRect(textContentRectByCursorRangeInBodytext, runnable);
    }

    public void releaseAiDrawing(String str) {
        if (isAiDrawingActivated()) {
            getAiDrawingManager().release(str);
        }
    }

    public void releaseSolveMath() {
        SolveMathPresenter solveMathPresenter = this.mSolveMathPresenter;
        if (solveMathPresenter != null) {
            solveMathPresenter.release();
        }
    }

    public void releaseTranslateWithOverlay(boolean z) {
        AbstractC8014b.m7220v("releaseTranslateWithOverlay# For PdfReader : ", TAG, z);
        TranslationOverlayManager translationOverlayManager = this.mTranslationOverlayManager;
        if (translationOverlayManager != null) {
            translationOverlayManager.close();
        }
    }

    public void requestAiAssistAction(AiBixbyParam aiBixbyParam) {
        if (this.mState.isHwContext()) {
            Logger.m10999d(TAG, "requestAiAssistAction# hw mode");
            return;
        }
        if (aiBixbyParam.getAction() == 5 && isAiAssistHw()) {
            Logger.m11000e(TAG, "requestAiAssistAction# unsupported action");
            return;
        }
        if (this.mComposerViewPresenter.getComposerModel().isPDFReader()) {
            int action = aiBixbyParam.getAction();
            Integer numValueOf = action == 5 ? Integer.valueOf(C9086R.string.ai_spelling_correction) : (action == 3 || action == 4) ? Integer.valueOf(C9086R.string.ai_auto_format_name) : null;
            if (numValueOf != null) {
                showToastCouldNotRun(this.mComposerViewPresenter.getActivity().getString(numValueOf.intValue()));
                Logger.m11000e(TAG, "requestAiAssistAction# unsupported action in pdf reader");
                return;
            }
        }
        this.mBixbyParam = aiBixbyParam;
        doDirectAction(true);
    }

    public void restore(Bundle bundle) {
        restoreRegardlessOs(bundle);
        if (Build.VERSION.SDK_INT < 33) {
            return;
        }
        String str = TAG;
        Logger.m10999d(str, "restore# ");
        restoreAiBixbyParam(bundle);
        restoreDrawing(bundle);
        restoreTranslate(bundle);
        this.mAiMenuResultManager.restoreResultView(bundle);
        if (canNotRestore(bundle) || this.mContextHwManager.restoreHw(bundle)) {
            return;
        }
        SrcContentInfo srcContentInfo = (SrcContentInfo) bundle.getParcelable("context_src", SrcContentInfo.class);
        if (srcContentInfo == null) {
            Logger.m10999d(str, "restore# no SrcContentInfo");
        } else if (this.mContextTextManager.restoreTextSelection(srcContentInfo)) {
            show(false, srcContentInfo.getAiBixbyParam(), srcContentInfo.mSrcPageIndex, null, true);
        }
    }

    public void search(String str, boolean z) {
        if (this.mAiAssistMenuExecutor.getExecutor() != null) {
            this.mAiAssistMenuExecutor.getExecutor().search(str, z);
        }
    }

    public void selectMaximumContent() {
        ComposerSA.insertLog(this.mState.getSAScreenID(), ComposerSAConstants.EVENT_AI_SELECT_MAXIMUM, this.mState.getSAAITypeDetail(this.mBixbyParam));
        this.mContentSwitcher.setDisableSwitchContentButton();
        if (hasSelectionHW()) {
            this.mContextHwManager.getSelectionHW().selectMaximumForText();
        } else {
            if (this.mContextTextManager.selectMaximum()) {
                return;
            }
            this.mState.setWaitingMaxSelection(false);
        }
    }

    public void selectNextPageForText() {
        ComposerSA.insertLog(this.mState.getSAScreenID(), ComposerSAConstants.EVENT_AI_SELECT_NEXT_PAGE, this.mState.getSAAITypeDetail(this.mBixbyParam));
        this.mContentSwitcher.setDisableSwitchContentButton();
        if (hasSelectionHW()) {
            this.mContextHwManager.getSelectionHW().selectNextPageForText();
        } else if (this.mContextTextManager.getSelectionText() != null) {
            this.mContextTextManager.getSelectionText().selectNextPageForText();
        }
    }

    public void setAiMenuViewContract(AiMenuViewContract aiMenuViewContract) {
        this.mAiMenuViewContract = aiMenuViewContract;
    }

    public void setAiSALogForPdfReader() {
        this.mState.setSAScreenID(this.mComposerViewPresenter.getComposerModel().getModeManager().isEditMode() ? ComposerSAConstants.SCREEN_PDF_VIEWER_EDIT : ComposerSAConstants.SCREEN_PDF_VIEWER);
        this.mState.setSAScenario("f");
        ComposerSA.insertLog(this.mState.getSAScreenID(), ComposerSAConstants.EVENT_PDF_VIEWER_AI_NOTE_ASSIST, this.mState.getSAScenario());
    }

    public void setAiSALogToGenerate() {
        if (this.mBixbyParam != null) {
            ComposerSA.insertLog(this.mState.getSAScreenID(), ComposerSAConstants.EVENT_AI_GENERATE, this.mState.getSAAITypeDetail(this.mBixbyParam));
        }
    }

    public void setBlockToShowQuickNoteDialog(boolean z) {
        this.mDialogManager.getQuickNoteDialogPresenter().blockToShow(z);
    }

    public void setClearTextSelectionFlag(boolean z) {
        this.mState.setClearTextSelectionFlag(z);
    }

    public void setFirstShowForNextSelectionView(boolean z) {
        this.mState.setFirstShowForNextSelectionView(z);
    }

    public void setIsStartTextMode(boolean z) {
        this.mState.setStartTextMode(z);
        this.mState.setSAScreenID(this.mComposerViewPresenter.getComposerModel().isTabletLayout() ? "403" : z ? "401" : "411");
        this.mState.setSAScenario(z ? "b" : "e");
        ComposerSA.insertLog(this.mState.getSAScreenID(), ComposerSAConstants.EVENT_AI_NOTE_ASSIST, this.mState.getSAScenario());
    }

    public void setSTTWindow(ISTTWindow.IAIContract iAIContract) {
        this.mAiMenuResultManager.setIAiSTTContract(iAIContract);
    }

    public void setTranslationOverlay() {
        this.mContentSwitcher.setLastSourceType(0);
        this.mState.initShowState();
        this.mCallerView = null;
        clearAiResultPendingFlag();
        this.mBixbyParam = new AiBixbyParam(1, 5);
        this.mComposerViewPresenter.setContextMenu(false);
        this.mComposerViewPresenter.getComposerControllerManager().getComposerAiController().setNeedToReleaseAiSelectionOnFirstMove(false);
        this.mContentSwitcher.setStartPageIndex(this.mComposerViewPresenter.getCurrentPageIndex());
        this.mAiContextMenu.show(this.mComposerViewPresenter.getActivity(), false);
        this.mAiContextMenu.showSwitchContentForOverlay();
    }

    public void setView(AiContextMenu aiContextMenu) {
        this.mAiContextMenu = aiContextMenu;
        this.mAiAssistMenuExecutor.setAiContextMenu(aiContextMenu);
    }

    public void show(boolean z, AiBixbyParam aiBixbyParam, int i, View view, boolean z2) {
        String str = TAG;
        releaseAiDrawing(str);
        this.mMenuManager.hideStickyMemo("3");
        if (CommonUtil.isNotAvailableActivity(this.mComposerViewPresenter.getActivity())) {
            Logger.m10999d(str, "show# not available activity");
            return;
        }
        if (this.mAiAssistMenuExecutor.isPendingAiResult()) {
            Logger.m10999d(str, "show# mIsPendingAiResult");
            return;
        }
        if (this.mAiContextMenu.isShowing()) {
            this.mAiContextMenu.setVisible(true);
            return;
        }
        this.mState.setHwContext(z);
        if (!this.mState.isHwContext()) {
            this.mControllerManager.getSoftInputManager().clearLastState();
        }
        Logger.m10999d(str, "show# " + this.mState.isHwContext() + " da: " + aiBixbyParam);
        boolean zIsRecognitionSupported = this.mContentSwitcher.isRecognitionSupported();
        if (this.mState.isHwContext() && !zIsRecognitionSupported) {
            Logger.m11000e(str, "show# recognition is not supported");
            if (showGoToSettingsDialogIfNeeded()) {
                return;
            }
            ToastHandler.show(this.mComposerViewPresenter.getActivity(), C9086R.string.ai_error_no_subject_recognized, 0);
            return;
        }
        this.mState.initShowState();
        this.mCallerView = view;
        clearAiResultPendingFlag();
        this.mBixbyParam = aiBixbyParam;
        this.mComposerViewPresenter.setContextMenu(false);
        this.mComposerViewPresenter.getComposerControllerManager().getComposerAiController().setNeedToReleaseAiSelectionOnFirstMove(false);
        this.mDialogManager.getQuickNoteDialogPresenter().blockToShow(true);
        AiLanguageHelper.initTranslateConfig();
        this.mContentSwitcher.setStartPageIndex(i);
        this.mContentSwitcher.setEnableSwitchContentButton();
        if (!this.mState.isHwContext()) {
            this.mContextTextManager.createSelectionText(i);
            AiCommonUtil.executeActionByOndevice(this.mComposerViewPresenter.getActivity(), new RunnableC7661m(i, 3, this, z2), new RunnableC9341a(this, 6));
        } else {
            if (this.mContextHwManager.startHwContext(false)) {
                return;
            }
            handleFailOfStartHwContext();
        }
    }

    public void showContainerSelectNext() {
        AiMenuViewContract aiMenuViewContract = this.mAiMenuViewContract;
        if (aiMenuViewContract != null) {
            aiMenuViewContract.show();
        }
    }

    public void showHwContextMenu(int i) {
        show(true, new AiBixbyParam(), i, null, false);
    }

    public void startCreateImage() {
        this.mMenuManager.hideStickyMemo("3");
        if (this.mAiContextMenu.isShowing()) {
            this.mAiContextMenu.hide();
        }
        if (this.mAiMenuResultManager.isShowingResultView()) {
            this.mAiMenuResultManager.hideResultView(false, new boolean[0]);
        }
        getAiDrawingManager().startCreateImage();
    }

    public void startCreativeStudio(DrawingAssistTypePopupWindow.StudioType studioType) {
        this.mMenuManager.hideStickyMemo("3");
        if (this.mAiContextMenu.isShowing()) {
            this.mAiContextMenu.hide();
        }
        if (this.mAiMenuResultManager.isShowingResultView()) {
            this.mAiMenuResultManager.hideResultView(false, new boolean[0]);
        }
        getAiDrawingManager().showCreativeStudio("startCreativeStudio", studioType);
    }

    public void switchContents(int i) {
        if (this.mContentSwitcher.getLastSourceType() == i) {
            AbstractC8014b.m7217s(i, "switchContents# type is the same : ", TAG);
            return;
        }
        int startPageIndex = this.mContentSwitcher.getStartPageIndex();
        String str = TAG;
        AbstractC8014b.m7217s(startPageIndex, "switchContents# pageIndex : ", str);
        this.mState.setBlockToReleaseSelection(true);
        boolean zIsCanSwitchContents = this.mContentSwitcher.isCanSwitchContents();
        if (this.mComposerViewPresenter.getPdfManager().hasSelectedText()) {
            this.mComposerViewPresenter.getPdfManager().clearSelection();
        } else if (this.mComposerViewPresenter.getObjectManager().isSelectedBodyText() && this.mComposerViewPresenter.getTextManager().isSelected()) {
            this.mComposerViewPresenter.getTextManager().clearSelection();
        } else {
            this.mContextHwManager.clearSelectionHw(true);
        }
        if (this.mComposerViewPresenter.getComposerModel().getComposerState().isTranslated() && isAiMenuForTranslation()) {
            releaseTranslateWithOverlay(false);
        }
        if (i == 0) {
            if (isAiMenuForTranslation()) {
                if (this.mComposerViewPresenter.getComposerModel().isPDFReader()) {
                    ComposerSA.insertLog(this.mComposerViewPresenter.getComposerModel().getModeManager().isEditMode() ? ComposerSAConstants.SCREEN_PDF_VIEWER_EDIT : ComposerSAConstants.SCREEN_PDF_VIEWER, ComposerSAConstants.EVENT_PDF_VIEWER_AI_TRANSLATE);
                }
                ComposerSA.insertLog("401", ComposerSAConstants.EVENT_OVER_VIEW_AI_ASSIST, "k");
                executeTranslateWithOverlay(false, null, new RunnableC9341a(this, 5));
            } else {
                this.mContextTextManager.readyToSwitchPdf(startPageIndex);
            }
        } else if (i == 1) {
            this.mContextTextManager.readyToSwitchBodyText(startPageIndex);
        } else if (i == 2) {
            this.mContextHwManager.readyToSwitchHw(startPageIndex);
        } else {
            Logger.m10999d(str, "switchContents# can't switch contents");
        }
        this.mState.setBlockToReleaseSelection(false);
        this.mContentSwitcher.setCanSwitchContents(zIsCanSwitchContents);
        this.mContentSwitcher.setLastSourceType(i);
    }

    public void executeSTT() {
        if (this.mAiAssistMenuExecutor.getExecutor() == null) {
            this.mAiAssistMenuExecutor.setTextBase();
        }
        this.mControllerManager.getSoftInputManager().hide(true);
        this.mAiAssistMenuExecutor.getExecutor().executeSTT();
        View currentFocus = this.mComposerViewPresenter.getActivity().getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) this.mComposerViewPresenter.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            currentFocus.clearFocus();
        }
    }
}
