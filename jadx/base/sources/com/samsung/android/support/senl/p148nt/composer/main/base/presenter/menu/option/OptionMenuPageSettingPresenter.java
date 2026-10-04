package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.common.BackgroundColorInvertPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskRunnable;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuPageSettingPresenter {
    private static final String TAG = Logger.createTag("OptionMenuPageSetting");
    private BackgroundColorInvertPresenter mBackgroundColorInvertPresenter;
    private final ComposerModel mComposerModel;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final ControllerManager mControllerManager;
    private boolean mIsHideSelf = false;
    private final NoteManager mNoteManager;

    public OptionMenuPageSettingPresenter(ComposerViewPresenter composerViewPresenter, ComposerModel composerModel, ControllerManager controllerManager) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mNoteManager = composerViewPresenter.getNoteManager();
        this.mComposerModel = composerModel;
        this.mControllerManager = controllerManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setBackgroundColor$0(int i) {
        if (this.mNoteManager.getBackgroundColor() == i) {
            return;
        }
        this.mNoteManager.setBackgroundColor(i);
        this.mNoteManager.commitHistory();
        Logger.addFileLog(TAG, "SetBG", 0);
    }

    public int getBackgroundColor() {
        return this.mNoteManager.getBackgroundColor();
    }

    public BackgroundColorInvertPresenter getBackgroundColorInvertPresenter() {
        if (this.mBackgroundColorInvertPresenter == null) {
            this.mBackgroundColorInvertPresenter = new BackgroundColorInvertPresenter(this.mNoteManager, this.mComposerModel);
        }
        return this.mBackgroundColorInvertPresenter;
    }

    public DocumentPageRatio.PageRatioType getPageRatio() {
        return this.mComposerViewPresenter.getComposerControllerManager().getCvPageSettingController().getPageRatioType();
    }

    public void hideKeyboard() {
        boolean zIsInputMethodShown = this.mControllerManager.getSoftInputManager().isInputMethodShown();
        this.mIsHideSelf = zIsInputMethodShown;
        if (zIsInputMethodShown) {
            this.mControllerManager.getSoftInputManager().hide(true);
        }
    }

    public boolean isCoeditNote() {
        return this.mComposerModel.getCoeditAdapter().isCoeditNote();
    }

    public boolean isEnabledBgColor() {
        return !this.mComposerModel.getModeManager().isDeleteOnlyMode();
    }

    public boolean isNotSinglePageNote() {
        return !this.mComposerModel.isSingleMode();
    }

    public boolean isPageRatioAvailable() {
        return false;
    }

    public boolean isScrollVertical() {
        return this.mComposerViewPresenter.getComposerControllerManager().getCvPageSettingController().getPageLayoutState().isVertical();
    }

    public boolean isTwoPage() {
        return this.mComposerViewPresenter.getComposerControllerManager().getCvPageSettingController().getPageLayoutState().isTwoPage();
    }

    public boolean isTwoPageEnabled(Activity activity) {
        if (this.mComposerModel.getComposerSpenDocModel().getDoc().getOrientation() == SpenWNote.Orientation.LANDSCAPE_NEW) {
            return false;
        }
        return this.mComposerViewPresenter.getComposerControllerManager().getCvPageSettingController().getPageLayoutState().isTwoPageEnabled(WindowManagerCompat.getInstance().getMultiWindowMode(activity) == 0);
    }

    public boolean isViewMode() {
        return this.mComposerModel.getModeManager().isMode(Mode.View);
    }

    public void notifyChanged() {
        this.mNoteManager.notifyBackgroundColorChange();
    }

    public void setBackgroundColor(int i) {
        RunnableC9846e runnableC9846e = new RunnableC9846e(this, i, 1);
        if (this.mNoteManager.getNote().getPageCount() <= 1000) {
            runnableC9846e.run();
        } else {
            this.mControllerManager.getTaskController().execute(new TaskRunnable(), new TaskRunnable.InputValues(runnableC9846e), null, false);
        }
    }

    public void setPageRatio(DocumentPageRatio.PageRatioType pageRatioType) {
        this.mComposerViewPresenter.getComposerControllerManager().getCvPageSettingController().setPageRatioType(pageRatioType);
    }

    public void setTwoPage() {
        this.mComposerViewPresenter.getComposerControllerManager().getCvPageSettingController().setPageLayout(2, 1, false);
    }

    public void setVerticalOnePage(boolean z) {
        this.mComposerViewPresenter.getComposerControllerManager().getCvPageSettingController().setPageLayout(1, 1, z);
    }

    public void showKeyboard() {
        if (this.mIsHideSelf) {
            this.mIsHideSelf = false;
            if (this.mComposerModel.getModeManager().isSipMode()) {
                this.mControllerManager.getSoftInputManager().show(true);
            }
        }
    }
}
