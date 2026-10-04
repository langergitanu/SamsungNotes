package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiActionStatus;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiBixbyParam;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiMenuEventListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiContextMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiContextMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiSuggestionManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.view.AiMenuView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverDataSrcCollector;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverMenuViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.solvemath.SolveMathPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.STTPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.view.AnchorPosition;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import com.samsung.android.support.senl.p148nt.stt.base.model.mode.STTMode;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuManager {
    private static final String TAG = Logger.createTag("AiMenuManager");
    protected AiContextMenu mAiContextMenu;
    AiContextMenuPresenter mAiContextMenuPresenter;
    AiCoverDataSrcCollector mAiCoverDataSrcCollector;
    AiCoverMenuViewPresenter mAiCoverMenuViewPresenter;
    AiMenuView mAiMenuView;
    AiSuggestionManager mAiSuggestionManager;
    protected ComposerViewPresenter mComposerViewPresenter;
    protected ControllerManager mControllerManager;
    protected DialogPresenterManager mDialogPresenterManager;
    protected HwToolbarPresenter mHwToolbarPresenter;
    protected MenuPresenterContract.IMenuManager mMenuManager;
    private Runnable mPostDelayRunnable;
    protected VoiceRecordMenuPresenter mVoiceRecordMenuPresenter;
    private boolean mIsInitialized = false;
    Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.AiMenuManager$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C92661 implements AiCoverDataSrcCollector.ResultListener {
        public C92661() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFinished$0() {
            AiMenuManager.this.mAiCoverMenuViewPresenter.show();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverDataSrcCollector.ResultListener
        @WorkerThread
        public void onFinished(String str) {
            Logger.m10999d(AiMenuManager.TAG, "onFinished#");
            AiMenuManager.this.mComposerViewPresenter.getActivity().runOnUiThread(new RunnableC9378d(this, 0));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AiSuggestionManagerContract implements AiSuggestionManager.Contract {
        public AiSuggestionManagerContract() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiSuggestionManager.Contract
        public void executeAiSuggestion(int i, boolean z, @Nullable String str) {
            AiBixbyParam aiBixbyParam;
            if (z) {
                aiBixbyParam = new AiBixbyParam(i, 6);
                AiLanguageHelper.updateLanguageList();
            } else {
                aiBixbyParam = TextUtils.isEmpty(str) ? new AiBixbyParam(i, 5) : new AiBixbyParam(i, 5, str);
            }
            AiMenuManager.this.showByBixby(aiBixbyParam);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiSuggestionManager.Contract
        public void hideResultView() {
            if (AiMenuManager.this.mAiContextMenuPresenter.getAiMenuResultManager().isShowingResultView()) {
                AiMenuManager.this.mAiContextMenuPresenter.getAiMenuResultManager().hideResultView(false, new boolean[0]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentFactory {
        @NonNull
        AiCoverMenuViewPresenter createAiCoverMenuViewPresenter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ View lambda$init$0() {
        return this.mMenuManager.getToolbarView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$makeCoverForBixby$3(String str) {
        this.mControllerManager.getProgressController().hideProgress(1, true);
        this.mControllerManager.getProgressController().setProgressStar(false);
        this.mAiCoverMenuViewPresenter.makeCoverDirectlyWithActivity(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$makeCoverForBixby$4(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mHandler.postDelayed(new RunnableC9270a(this, str, 0), 500L);
            return;
        }
        ToastHandler.show(this.mComposerViewPresenter.getActivity(), C9086R.string.ai_cover_not_enough_contents_msg, 0);
        this.mControllerManager.getProgressController().hideProgress(1, true);
        this.mControllerManager.getProgressController().setProgressStar(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$makeCoverForBixby$5(String str) {
        this.mHandler.post(new RunnableC9270a(this, str, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runAiAssistByBixby$1(AiBixbyParam aiBixbyParam, int i, boolean z) {
        if (aiBixbyParam.getResultAction() != 6) {
            hideResultView(true);
        }
        this.mAiContextMenuPresenter.show(false, aiBixbyParam, i, null, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runAiAssistByBixby$2() {
        this.mAiContextMenuPresenter.setTranslationOverlay();
    }

    private void makeCoverForBixby() {
        this.mControllerManager.getProgressController().setProgressStar(true);
        this.mControllerManager.getProgressController().showProgress(0, 1);
        this.mAiCoverDataSrcCollector.collectData(new C9272c(this));
    }

    private void runAiAiAssistByBixbyInPdfReader(AiBixbyParam aiBixbyParam) {
        int action = aiBixbyParam.getAction();
        if (action == 1) {
            this.mMenuManager.hideBottomMenu();
            hideResultView();
            this.mAiContextMenuPresenter.executeTranslateWithOverlay(true, aiBixbyParam.getTargetLanguage(), null);
        } else {
            if (action != 2) {
                Logger.m11000e(TAG, "requestAiAssistAction# unsupported action in pdf reader");
                return;
            }
            hideResultView(true);
            this.mMenuManager.hideBottomMenu();
            runAiAssistByBixby(aiBixbyParam, false);
        }
    }

    private void runAiAssistByBixby(final AiBixbyParam aiBixbyParam, final boolean z) {
        ModeManager modeManager = this.mComposerViewPresenter.getComposerModel().getModeManager();
        final int currentPageIndex = this.mComposerViewPresenter.getCurrentPageIndex();
        if (modeManager.isMode(Mode.Text) && this.mControllerManager.getSoftInputManager().isInputMethodShown()) {
            this.mControllerManager.getSoftInputManager().hide((View) null);
            this.mHandler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6800a.lambda$runAiAssistByBixby$1(aiBixbyParam, currentPageIndex, z);
                }
            }, 500L);
            return;
        }
        if (aiBixbyParam.getResultAction() != 6) {
            hideResultView(true);
        }
        if (aiBixbyParam.getAction() == 1 && this.mAiContextMenuPresenter.canUseOverlayPdfWithCurrentPage()) {
            this.mAiContextMenuPresenter.executeTranslateWithOverlay(false, aiBixbyParam.getTargetLanguage(), new RunnableC9378d(this, 1));
        } else {
            this.mAiContextMenuPresenter.show(false, aiBixbyParam, currentPageIndex, null, z);
        }
    }

    public boolean canShowAiContextMenu() {
        return this.mAiMenuView.canShowAiContextMenu();
    }

    public void clearRecommendedCover() {
        this.mAiCoverMenuViewPresenter.clearRecommendedCover();
    }

    public AiContextMenuPresenter createAiContextMenuPresenter() {
        return new AiContextMenuPresenter(this.mMenuManager, this.mVoiceRecordMenuPresenter, this.mComposerViewPresenter, this.mControllerManager, this.mDialogPresenterManager, new AiMenuEventListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.AiMenuManager.3
            @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiMenuEventListener
            public void onHide() {
                AiMenuManager.this.mMenuManager.onHideMenu(MenuPresenterContract.CMenu.AI_MENU_RESULT);
                if (AiMenuManager.this.mAiContextMenu.isShowing()) {
                    AiMenuManager.this.mAiContextMenu.hide();
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiMenuEventListener
            public void onShow() {
                AiMenuManager.this.mMenuManager.onShowMenu(MenuPresenterContract.CMenu.AI_MENU_RESULT);
            }
        });
    }

    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter == null || !aiContextMenuPresenter.getAiMenuResultManager().isShowingResultView() || this.mControllerManager.getSoftInputManager().isInputMethodShown() || keyEvent.getKeyCode() != 4 || !isShowingAiResultWorking()) {
            return false;
        }
        this.mAiContextMenuPresenter.getAiMenuResultManager().hideResultView(false, new boolean[0]);
        return true;
    }

    public void doAiSuggestionForTranslation() {
        AiSuggestionManager aiSuggestionManager = this.mAiSuggestionManager;
        if (aiSuggestionManager != null) {
            aiSuggestionManager.doAiSuggestionForTranslation();
        }
    }

    public void doAiSuggestionForTranslationDelay() {
        Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.AiMenuManager.4
            @Override // java.lang.Runnable
            public void run() {
                AiMenuManager.this.mPostDelayRunnable = null;
                AiMenuManager.this.doAiSuggestionForTranslation();
            }
        };
        this.mPostDelayRunnable = runnable;
        this.mHandler.postDelayed(runnable, 1000L);
    }

    public void executeTranslateWithOverlay(boolean z, Runnable runnable) {
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter != null) {
            aiContextMenuPresenter.executeTranslateWithOverlay(z, null, runnable);
        }
    }

    public AiContextMenuPresenter getAiContextMenuPresenter() {
        return this.mAiContextMenuPresenter;
    }

    public AiCoverMenuViewPresenter getAiCoverMenuViewPresenter() {
        return this.mAiCoverMenuViewPresenter;
    }

    public AiMenuView getAiMenuView() {
        return this.mAiMenuView;
    }

    public ComposerViewPresenter getComposerViewPresenter() {
        return this.mComposerViewPresenter;
    }

    public int getCurrentScreen() {
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter == null) {
            return 9000;
        }
        return aiContextMenuPresenter.getAiMenuResultManager().getCurrentScreen();
    }

    public HwToolbarPresenter getHwToolbarPresenter() {
        return this.mHwToolbarPresenter;
    }

    public Runnable getRunnableAiSuggestionForAutoFormat() {
        AiSuggestionManager aiSuggestionManager = this.mAiSuggestionManager;
        if (aiSuggestionManager != null) {
            return aiSuggestionManager.getRunnableAiSuggestionForAutoFormat();
        }
        return null;
    }

    public SolveMathPresenter getSolveMathPresenter() {
        return getAiContextMenuPresenter().getSolveMathPresenter();
    }

    public void hideAiSuggestionView() {
        AiSuggestionManager aiSuggestionManager = this.mAiSuggestionManager;
        if (aiSuggestionManager != null) {
            aiSuggestionManager.hideAiSuggestionView();
        }
    }

    public void hideContextMenu(boolean z) {
        if (this.mAiContextMenu.isShowing()) {
            if (z) {
                this.mAiContextMenuPresenter.setClearTextSelectionFlag(true);
            }
            this.mAiContextMenuPresenter.clearAiResultPendingFlag();
            this.mAiContextMenu.hide();
            if (z) {
                this.mAiContextMenuPresenter.setClearTextSelectionFlag(false);
            }
        }
    }

    public void hideResultView() {
        hideResultView(false);
    }

    public void init(VoiceRecordMenuPresenter voiceRecordMenuPresenter, ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, TitleEditorPresenter titleEditorPresenter, DialogPresenterManager dialogPresenterManager, MenuPresenterContract.IMenuManager iMenuManager, HwToolbarPresenter hwToolbarPresenter, @NonNull KeyguardPresenter keyguardPresenter, @NonNull ComponentFactory componentFactory) {
        this.mHwToolbarPresenter = hwToolbarPresenter;
        this.mMenuManager = iMenuManager;
        this.mVoiceRecordMenuPresenter = voiceRecordMenuPresenter;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mControllerManager = controllerManager;
        this.mDialogPresenterManager = dialogPresenterManager;
        AiCoverMenuViewPresenter aiCoverMenuViewPresenterCreateAiCoverMenuViewPresenter = componentFactory.createAiCoverMenuViewPresenter();
        this.mAiCoverMenuViewPresenter = aiCoverMenuViewPresenterCreateAiCoverMenuViewPresenter;
        aiCoverMenuViewPresenterCreateAiCoverMenuViewPresenter.init(composerViewPresenter, titleEditorPresenter, keyguardPresenter);
        AiCoverDataSrcCollector aiCoverDataSrcCollector = new AiCoverDataSrcCollector(this.mComposerViewPresenter, this.mAiCoverMenuViewPresenter);
        this.mAiCoverDataSrcCollector = aiCoverDataSrcCollector;
        aiCoverDataSrcCollector.setResultListener(new C92661());
        this.mAiContextMenuPresenter = createAiContextMenuPresenter();
        AiContextMenu aiContextMenu = new AiContextMenu();
        this.mAiContextMenu = aiContextMenu;
        aiContextMenu.setPresenter(this.mAiContextMenuPresenter);
        this.mAiMenuView = new AiMenuView(this.mComposerViewPresenter, this.mAiContextMenuPresenter, new C9272c(this));
        if (FeatureInfo.isAiFeatureEnabled()) {
            this.mAiSuggestionManager = new AiSuggestionManager(this.mComposerViewPresenter, this.mControllerManager, new AiSuggestionManagerContract());
        }
        composerViewPresenter.setAiMenuManager(new ComposerViewContract.AiMenuManagerContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.AiMenuManager.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.AiMenuManagerContract
            public AiCoverMenuViewPresenter getAiCoverMenuViewPresenter() {
                return AiMenuManager.this.mAiCoverMenuViewPresenter;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.AiMenuManagerContract
            public void hideAiSuggestionView() {
                AiSuggestionManager aiSuggestionManager = AiMenuManager.this.mAiSuggestionManager;
                if (aiSuggestionManager != null) {
                    aiSuggestionManager.hideAiSuggestionView();
                    if (AiMenuManager.this.mPostDelayRunnable != null) {
                        AiMenuManager aiMenuManager = AiMenuManager.this;
                        aiMenuManager.mHandler.removeCallbacks(aiMenuManager.mPostDelayRunnable);
                        AiMenuManager.this.mPostDelayRunnable = null;
                    }
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.AiMenuManagerContract
            public boolean isTranslating() {
                return AiMenuManager.this.mAiContextMenuPresenter.isTranslating();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.AiMenuManagerContract
            public void setStopImageOverlay(boolean z) {
                AiMenuManager.this.mAiContextMenuPresenter.getTranslationOverlayManager().setStopImageOverlay(z);
            }
        });
        this.mIsInitialized = true;
    }

    public boolean isNotScanningAnimating() {
        if (this.mAiContextMenuPresenter != null) {
            return !r0.isScanningAnimating();
        }
        return true;
    }

    public boolean isShowingAiResultWorking() {
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter == null) {
            return false;
        }
        return aiContextMenuPresenter.getAiMenuResultManager().isShowingResultWorking();
    }

    public boolean isShowingContextMenu() {
        return this.mAiContextMenu.isShowing();
    }

    public boolean isShowingMenu() {
        return this.mAiContextMenu.isShowing() || isShowingResultView();
    }

    public boolean isShowingResultView() {
        return this.mAiContextMenuPresenter.getAiMenuResultManager().isShowingResultView();
    }

    public void makeCoverDirectly() {
        Logger.m10999d(TAG, "makeCoverDirectly#");
        if (this.mAiCoverMenuViewPresenter.hasCover()) {
            this.mAiCoverMenuViewPresenter.showCoverEditorActivity();
        } else {
            makeCoverForBixby();
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        return this.mAiContextMenuPresenter.onActivityResult(i, i2, intent);
    }

    public void onAttachView(Fragment fragment) {
        this.mAiCoverMenuViewPresenter.onAttachView(fragment);
        AiMenuView aiMenuView = this.mAiMenuView;
        if (aiMenuView != null) {
            aiMenuView.onAttachView();
        }
    }

    public boolean onBackPressed() {
        AiSuggestionManager aiSuggestionManager = this.mAiSuggestionManager;
        if (aiSuggestionManager != null && aiSuggestionManager.isShowing()) {
            this.mAiSuggestionManager.hideAiSuggestionView();
            return true;
        }
        if (!this.mAiContextMenuPresenter.getAiMenuResultManager().isShowingResultView()) {
            return this.mAiContextMenuPresenter.onBackPressed();
        }
        this.mAiContextMenuPresenter.getAiMenuResultManager().hideResultView(false, new boolean[0]);
        return true;
    }

    public boolean onBackPressedBeforeComposerView() {
        if (FeatureInfo.isSupportSTTFunction()) {
            STTPresenterImpl sTTPresenter = this.mVoiceRecordMenuPresenter.getSTTPresenter();
            if (sTTPresenter.isSTTEditMode() || sTTPresenter.isSelectionMode() || sTTPresenter.isSelectionSummaryMode() || sTTPresenter.getCurrentMode() == STTMode.SEARCH) {
                this.mVoiceRecordMenuPresenter.onBackPressed();
                return true;
            }
        }
        return this.mAiContextMenuPresenter.onBackPressedBeforeComposerView();
    }

    public void onChangeLayoutBefore() {
        onDetachView(true);
    }

    public void onConfigurationChanged(Configuration configuration, boolean z) {
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter == null) {
            return;
        }
        aiContextMenuPresenter.onConfigurationChanged(configuration, z);
    }

    public void onDestroy() {
        if (this.mIsInitialized) {
            releaseAiDrawing("onDestroy");
            releaseSolveMath();
            onDetachView(new boolean[0]);
            AiSuggestionManager aiSuggestionManager = this.mAiSuggestionManager;
            if (aiSuggestionManager != null) {
                aiSuggestionManager.release();
            }
        }
    }

    public void onDetachView(boolean... zArr) {
        AiCoverMenuViewPresenter aiCoverMenuViewPresenter = this.mAiCoverMenuViewPresenter;
        if (aiCoverMenuViewPresenter != null) {
            aiCoverMenuViewPresenter.onDetachView();
        }
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter != null) {
            aiContextMenuPresenter.onDetachView(zArr);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        AiMenuView aiMenuView = this.mAiMenuView;
        if (aiMenuView != null) {
            aiMenuView.release();
        }
    }

    public void onReadyReload() {
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter != null) {
            aiContextMenuPresenter.onReadyReload();
        }
    }

    public void onResume() {
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter != null) {
            if (aiContextMenuPresenter.getAiMenuResultManager().isShowingResultView() && this.mAiContextMenuPresenter.getAiMenuResultManager().isUsingAiFunction() && !AiActionStatus.isAiFeatureEnable()) {
                hideResultView();
            }
            this.mAiContextMenuPresenter.onResume();
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter != null) {
            aiContextMenuPresenter.onSaveInstanceState(bundle);
        }
    }

    public void onWindowModeChanged() {
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter == null) {
            return;
        }
        aiContextMenuPresenter.onWindowModeChanged();
    }

    public void releaseAiDrawing(String str) {
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter != null) {
            aiContextMenuPresenter.releaseAiDrawing(str);
        }
    }

    public void releaseAiDrawingPopup(String str) {
        if (AiDrawingUtil.isPopupShowingState(this.mComposerViewPresenter.getComposerModel().getAiDrawingState())) {
            releaseAiDrawing(str);
        }
    }

    public void releaseSelectionForResultView() {
        if (isShowingResultView() && this.mComposerViewPresenter.getComposerControllerManager().getComposerAiController().isNeedToReleaseAiSelectionOnFirstMove()) {
            this.mAiContextMenuPresenter.clearSelectionText();
        }
    }

    public void releaseSolveMath() {
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter != null) {
            aiContextMenuPresenter.releaseSolveMath();
        }
    }

    public void restoreState(Bundle bundle) {
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter != null) {
            aiContextMenuPresenter.restore(bundle);
        }
    }

    public void setAiSALogForPdfReader() {
        this.mAiContextMenuPresenter.setAiSALogForPdfReader();
    }

    public void setIsStartTextMode(boolean z) {
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter != null) {
            aiContextMenuPresenter.setIsStartTextMode(z);
        }
    }

    public void showAiContextMenu(View view, AnchorPosition anchorPosition) {
        AiMenuView aiMenuView = this.mAiMenuView;
        if (aiMenuView != null) {
            aiMenuView.showAiPopupMenu(view, anchorPosition);
        }
    }

    public void showByBixby(AiBixbyParam aiBixbyParam) {
        String str = TAG;
        Logger.m10999d(str, "showByBixby# " + aiBixbyParam);
        if (aiBixbyParam.getAction() == 7) {
            this.mAiContextMenuPresenter.requestAiAssistAction(aiBixbyParam);
            return;
        }
        if (aiBixbyParam.getAction() == 1 && this.mAiContextMenuPresenter.isTranslatedPdfOverlapping() && this.mAiContextMenuPresenter.canUseOverlayPdfWithCurrentPage()) {
            Logger.m11004w(str, "showByBixby# translation for pdf is working");
        } else if (this.mAiContextMenu.isShowing()) {
            Logger.m11004w(str, "showByBixby# is working");
            this.mAiContextMenuPresenter.requestAiAssistAction(aiBixbyParam);
            return;
        } else if (this.mAiContextMenuPresenter.getAiMenuResultManager().isShowingResultView() && aiBixbyParam.getResultAction() != 6) {
            Logger.m10999d(str, "showByBixby# result is showing");
            if (aiBixbyParam.getAction() != 0 || aiBixbyParam.getResultAction() == 0) {
                return;
            }
            this.mAiContextMenuPresenter.getAiMenuResultManager().requestResultAction(aiBixbyParam.getResultAction());
            return;
        }
        if (this.mComposerViewPresenter.getComposerModel().isPDFReader()) {
            runAiAiAssistByBixbyInPdfReader(aiBixbyParam);
        } else {
            runAiAssistByBixby(aiBixbyParam, aiBixbyParam.getResultAction() == 6);
        }
    }

    public void showHwContextMenu() {
        AiContextMenu aiContextMenu = this.mAiContextMenu;
        if (aiContextMenu != null && aiContextMenu.isShowing()) {
            this.mAiContextMenu.hide();
        }
        hideResultView();
        this.mAiContextMenuPresenter.showHwContextMenu(this.mComposerViewPresenter.getCurrentPageIndex());
    }

    public void showSelectionContextMenu(int i, View view) {
        this.mAiContextMenuPresenter.show(false, new AiBixbyParam(i, 5), this.mComposerViewPresenter.getCurrentPageIndex(), view, false);
    }

    public void hideResultView(boolean z) {
        if (this.mAiContextMenuPresenter.getAiMenuResultManager().isShowingResultView()) {
            this.mAiContextMenuPresenter.getAiMenuResultManager().hideResultView(z, new boolean[0]);
        }
    }
}
