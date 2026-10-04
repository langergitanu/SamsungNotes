package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiMenuEventListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuResultViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SrcContentInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultView;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultManager {
    private static final String TAG = Logger.createTag("AiMenuResultManager", AiConstants.PREFIX_TAG);
    AiMenuResultView mAiMenuResultView;
    AiMenuResultViewPresenter mAiMenuResultViewPresenter;
    ComposerViewPresenter mComposerViewPresenter;
    Contract mContract;
    ControllerManager mControllerManager;
    DialogPresenterManager mDialogManager;
    private ISTTWindow.IAIContract mIAiSTTContract;
    private final AiMenuEventListener mResultViewEventListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void clearAiResultPendingFlag();

        void restoreSelection(SrcContentInfo srcContentInfo);
    }

    public AiMenuResultManager(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, DialogPresenterManager dialogPresenterManager, AiMenuEventListener aiMenuEventListener, Contract contract) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mControllerManager = controllerManager;
        this.mDialogManager = dialogPresenterManager;
        this.mResultViewEventListener = aiMenuEventListener;
        this.mContract = contract;
    }

    public void cancelRecognizing() {
        AiMenuResultViewPresenter aiMenuResultViewPresenter = this.mAiMenuResultViewPresenter;
        if (aiMenuResultViewPresenter == null || aiMenuResultViewPresenter.getRecognizedHw() == null) {
            return;
        }
        this.mAiMenuResultViewPresenter.getRecognizedHw().setCancelRecognizingState();
    }

    public void clearSearchComposer() {
        AiMenuResultView aiMenuResultView = this.mAiMenuResultView;
        if (aiMenuResultView != null) {
            aiMenuResultView.clearSearchComposer();
        }
    }

    public AiMenuResultViewPresenter getAiMenuResultViewPresenter() {
        return this.mAiMenuResultViewPresenter;
    }

    public ISTTWindow.IAIContract getAiSTTContract() {
        return this.mIAiSTTContract;
    }

    public int getCurrentScreen() {
        if (isShowingResultView()) {
            return this.mAiMenuResultView.getCurrentScreen();
        }
        return 9000;
    }

    public void hideResultView(boolean z, boolean... zArr) {
        if (this.mAiMenuResultView == null) {
            return;
        }
        if (z) {
            this.mAiMenuResultViewPresenter.setBlockingReleaseSelection(true);
        }
        this.mAiMenuResultView.hide(zArr);
        this.mAiMenuResultView.releaseSelection();
    }

    public boolean isShowingResultView() {
        AiMenuResultView aiMenuResultView = this.mAiMenuResultView;
        return aiMenuResultView != null && aiMenuResultView.isShowing();
    }

    public boolean isShowingResultWorking() {
        AiMenuResultView aiMenuResultView = this.mAiMenuResultView;
        if (aiMenuResultView == null) {
            return false;
        }
        return aiMenuResultView.isShowingResultWorking();
    }

    public boolean isShowingSTT() {
        AiMenuResultViewPresenter aiMenuResultViewPresenter = this.mAiMenuResultViewPresenter;
        return (aiMenuResultViewPresenter == null || aiMenuResultViewPresenter.getSTTTabletLayoutAction() == null) ? false : true;
    }

    public boolean isUsingAiFunction() {
        AiMenuResultViewPresenter aiMenuResultViewPresenter = this.mAiMenuResultViewPresenter;
        return aiMenuResultViewPresenter != null && aiMenuResultViewPresenter.isUsingAiFunction();
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (ComposerRequestCode.get(i) == ComposerRequestCode.DownloadLanguage) {
            if (isShowingResultView()) {
                this.mAiMenuResultView.notifyLanguageDownload();
            }
            return true;
        }
        if (ComposerRequestCode.get(i) != ComposerRequestCode.SearchVoiceSTT && ComposerRequestCode.get(i) != ComposerRequestCode.SearchVoiceSTTSvi) {
            return false;
        }
        if (isShowingResultView()) {
            this.mAiMenuResultView.onSTTSearchVoiceResult(i, i2, intent);
        }
        return true;
    }

    public boolean onBackPressedBeforeComposerView() {
        if (this.mAiMenuResultView.closeEditMode()) {
            return true;
        }
        if (!isShowingResultWorking()) {
            return false;
        }
        hideResultView(false, new boolean[0]);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration, boolean z) {
        AiMenuResultView aiMenuResultView = this.mAiMenuResultView;
        if (aiMenuResultView != null) {
            aiMenuResultView.onConfigurationChanged(configuration, z);
            this.mDialogManager.hideSummaryOptionDialog();
        }
    }

    public void onResume() {
        if (isShowingResultView()) {
            this.mAiMenuResultViewPresenter.onResume();
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        if (isShowingResultView()) {
            this.mAiMenuResultViewPresenter.onSaveInstanceState(bundle);
        }
    }

    public void requestResultAction(int i) {
        if (isShowingResultView()) {
            this.mAiMenuResultView.requestResultAction(i);
        }
    }

    @RequiresApi(api = 33)
    public void restoreResultView(Bundle bundle) {
        AiMenuResultViewPresenter aiMenuResultViewPresenter = this.mAiMenuResultViewPresenter;
        if (aiMenuResultViewPresenter == null || !aiMenuResultViewPresenter.canRestore(bundle)) {
            return;
        }
        String str = TAG;
        Logger.m10999d(str, "restoreResultView#");
        SrcContentInfo srcContentInfo = (SrcContentInfo) bundle.getParcelable(AiMenuResultViewPresenter.SAVE_KEY_RESULT_SRC, SrcContentInfo.class);
        if (srcContentInfo == null) {
            Logger.m10999d(str, "restoreResultView# no SrcContentInfo");
        } else {
            this.mContract.restoreSelection(srcContentInfo);
            this.mAiMenuResultViewPresenter.restore(bundle, srcContentInfo);
        }
    }

    public void search(String str, boolean z) {
        AiMenuResultView aiMenuResultView = this.mAiMenuResultView;
        if (aiMenuResultView != null) {
            aiMenuResultView.search(str, z, -1);
        }
    }

    public void setIAiSTTContract(ISTTWindow.IAIContract iAIContract) {
        this.mIAiSTTContract = iAIContract;
    }

    public void showResultView(AiMenuContract.IAiAction iAiAction) {
        if (isShowingResultView()) {
            this.mAiMenuResultViewPresenter.updateNewAiAction(iAiAction);
            this.mContract.clearAiResultPendingFlag();
            this.mAiMenuResultView.updatePageContainer();
            return;
        }
        this.mControllerManager.getSoftInputManager().hide((View) null);
        AiMenuResultViewPresenter aiMenuResultViewPresenter = new AiMenuResultViewPresenter(this.mComposerViewPresenter, this.mControllerManager, this.mIAiSTTContract, this.mDialogManager, this.mResultViewEventListener);
        aiMenuResultViewPresenter.setAiAction(iAiAction);
        AiMenuResultView aiMenuResultView = new AiMenuResultView();
        this.mAiMenuResultView = aiMenuResultView;
        this.mAiMenuResultViewPresenter = aiMenuResultViewPresenter;
        aiMenuResultView.setPresenter(aiMenuResultViewPresenter);
        this.mAiMenuResultView.show(this.mComposerViewPresenter.getActivity());
        this.mContract.clearAiResultPendingFlag();
    }

    public void showResultView(AiMenuContract.IAiAction iAiAction, String str, boolean z, int i) {
        if (isShowingResultView()) {
            this.mAiMenuResultViewPresenter.updateNewAiAction(iAiAction);
            this.mContract.clearAiResultPendingFlag();
            this.mAiMenuResultViewPresenter.setModeSearch();
            return;
        }
        this.mControllerManager.getSoftInputManager().hide((View) null);
        AiMenuResultViewPresenter aiMenuResultViewPresenter = new AiMenuResultViewPresenter(this.mComposerViewPresenter, this.mControllerManager, this.mIAiSTTContract, this.mDialogManager, this.mResultViewEventListener);
        aiMenuResultViewPresenter.setAiAction(iAiAction);
        AiMenuResultView aiMenuResultView = new AiMenuResultView();
        this.mAiMenuResultView = aiMenuResultView;
        this.mAiMenuResultViewPresenter = aiMenuResultViewPresenter;
        aiMenuResultView.setPresenter(aiMenuResultViewPresenter);
        this.mAiMenuResultViewPresenter.setModeSearch();
        this.mAiMenuResultView.show(this.mComposerViewPresenter.getActivity(), str, z, i);
        this.mContract.clearAiResultPendingFlag();
    }
}
