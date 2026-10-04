package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.menu.option;

import android.app.Activity;
import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPdfPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.EntryAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAddPdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwDocInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwOptionMenuPdfPresenter extends OptionMenuPdfPresenter {
    public PwOptionMenuPdfPresenter(MenuPresenterContract.IMenuManager iMenuManager, ComposerViewPresenter composerViewPresenter, ComposerModel composerModel, TaskController taskController, QuickSaveTimerController quickSaveTimerController) {
        super(iMenuManager, composerViewPresenter, composerModel, taskController, quickSaveTimerController);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPdfPresenter
    public void addSALogPdfExecute() {
        Activity activity = this.mActivity;
        boolean zIsEditModeAction = activity != null ? EntryAction.isEditModeAction(activity.getIntent()) : false;
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_PDF_VIEWER, ComposerSAConstants.EVENT_PDF_VIEWER_START);
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_PDF_VIEWER, zIsEditModeAction ? ComposerSAConstants.EVENT_PDF_VIEWER_EDIT_PAGE_COUNT : ComposerSAConstants.EVENT_PDF_VIEWER_VIEW_PAGE_COUNT, this.mComposerModel.isSingleMode() ? 1 : this.mComposerModel.getDoc().getPageCount() - 1);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPdfPresenter
    public TaskAddPdf.InputValues getTaskAddPdfInputValues(OptionMenuPdfPresenter.Param param, int i) {
        TaskAddPdf.InputValues taskAddPdfInputValues = super.getTaskAddPdfInputValues(param, i);
        DocInfo docInfo = this.mComposerModel.getDocInfo();
        if (docInfo instanceof PwDocInfo) {
            PwDocInfo pwDocInfo = (PwDocInfo) docInfo;
            if (!TextUtils.isEmpty(pwDocInfo.getPdfFileInfo().getName())) {
                taskAddPdfInputValues.setInputTitle(pwDocInfo.getPdfFileInfo().getName());
            }
        }
        return taskAddPdfInputValues;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPdfPresenter
    public void handleSecurePdf() {
        ToastHandler.show(this.mActivity, C9086R.string.composer_this_protected_pdf_is_view_only, 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPdfPresenter
    public void setPdfWriteState(boolean z) {
        this.mComposerModel.setNotSave();
        ModeManager modeManager = this.mComposerModel.getModeManager();
        Activity activity = this.mActivity;
        modeManager.init(false, true, false, false, activity != null ? EntryAction.isEditModeAction(activity.getIntent()) : false);
        this.mMenuManager.invalidateOptionsMenu();
        this.mMenuManager.attachBottomView();
    }
}
