package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.EntryAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAddPdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuPdfPresenter {
    private static final int COUNT_TO_SAVE_AFTER_ADD_PDF = 1000;
    private static final String TAG = Logger.createTag("OptionMenuPdfPresenter");
    protected Activity mActivity;
    protected final ComposerModel mComposerModel;
    protected final ComposerViewPresenter mComposerViewPresenter;
    protected final MenuPresenterContract.IMenuManager mMenuManager;
    private final NoteManager mNoteManager;
    private final PageManager mPageManager;
    private final PdfManager mPdfManager;
    protected final QuickSaveTimerController mQuickSaveTimerController;
    private final TaskController mTaskController;
    private final TextManager mTextManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Param {
        private final List<String> mFilePathList;
        private final List<Uri> mUriList;
        private boolean mIsStartedByExternalImportMenu = false;
        private boolean mIsPdfViewer = false;
        private boolean mIsTemplate = false;
        private boolean mIsSkipTwoPage = false;
        private boolean mIsNew = false;

        public Param(List<Uri> list, List<String> list2) {
            this.mUriList = list;
            this.mFilePathList = list2;
        }

        public boolean isInvalid() {
            List<Uri> list = this.mUriList;
            if (list != null && !list.isEmpty()) {
                return false;
            }
            List<String> list2 = this.mFilePathList;
            return list2 == null || list2.isEmpty();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ParamFactory {
        private final Param mPdfMenuParam;

        public ParamFactory(@Nullable List<Uri> list, @Nullable List<String> list2) {
            this.mPdfMenuParam = new Param(list, list2);
        }

        public Param create() {
            return this.mPdfMenuParam;
        }

        public ParamFactory setByExternal(boolean z) {
            this.mPdfMenuParam.mIsStartedByExternalImportMenu = true;
            this.mPdfMenuParam.mIsPdfViewer = z;
            this.mPdfMenuParam.mIsNew = true;
            this.mPdfMenuParam.mIsSkipTwoPage = true;
            return this;
        }

        public ParamFactory setByNewTemplate() {
            this.mPdfMenuParam.mIsNew = true;
            this.mPdfMenuParam.mIsTemplate = true;
            return this;
        }

        public ParamFactory setByTemplate(boolean z) {
            this.mPdfMenuParam.mIsTemplate = true;
            this.mPdfMenuParam.mIsSkipTwoPage = z;
            return this;
        }
    }

    public OptionMenuPdfPresenter(MenuPresenterContract.IMenuManager iMenuManager, ComposerViewPresenter composerViewPresenter, ComposerModel composerModel, TaskController taskController, QuickSaveTimerController quickSaveTimerController) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mComposerModel = composerModel;
        this.mMenuManager = iMenuManager;
        this.mNoteManager = composerViewPresenter.getNoteManager();
        this.mPageManager = composerViewPresenter.getPageManager();
        this.mTextManager = composerViewPresenter.getTextManager();
        this.mPdfManager = composerViewPresenter.getPdfManager();
        this.mTaskController = taskController;
        this.mQuickSaveTimerController = quickSaveTimerController;
    }

    private void executeTaskAddPdf(TaskAddPdf.InputValues inputValues, Param param) {
        if (param.mIsStartedByExternalImportMenu) {
            this.mQuickSaveTimerController.pause("executeTaskAddPdf#");
        }
        this.mComposerViewPresenter.getThumbnailUpdateHandler().setBlockToUpdate(true, false);
        this.mTaskController.execute(new TaskAddPdf(), inputValues, getTaskAddPdfCallback(param), false);
    }

    private int getTwoPageRightIndex() {
        int currentPageIndex = this.mPageManager.getDocPageInfo().getCurrentPageIndex();
        if (currentPageIndex <= 0) {
            return 1;
        }
        return AbstractC2322a.m1610D(currentPageIndex, 2, 2, 1);
    }

    private boolean isTwoPage() {
        return this.mComposerViewPresenter.getComposerControllerManager().getCvPageSettingController().getPageLayoutState().isTwoPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPdfViewOnlyState(TaskAddPdf.ResultValues resultValues) {
        this.mComposerModel.getModeManager().setMode(Mode.Init, "set not editable", true);
        this.mComposerModel.getComposerState().setSecured(true);
        this.mComposerModel.setNotSave();
        this.mComposerModel.getModeManager().setMode(Mode.View, "set not editable", true);
        if (CommonUtil.isAvailableActivity(this.mActivity)) {
            resultValues.showErrorToast(true);
            this.mMenuManager.invalidateOptionsMenu();
            if (resultValues.isSecured()) {
                handleSecurePdf();
            }
        }
        this.mComposerViewPresenter.getThumbnailUpdateHandler().setBlockToUpdate(false, false);
    }

    public void addSALogPdfExecute() {
        ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_PDF_EXECUTE);
    }

    @NonNull
    public Task.Callback<TaskAddPdf.ResultValues> getTaskAddPdfCallback(final Param param) {
        return new Task.Callback<TaskAddPdf.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuPdfPresenter.2
            private boolean finish(TaskAddPdf.ResultValues resultValues) {
                if (!param.mIsStartedByExternalImportMenu || CommonUtil.isNotAvailableActivity(OptionMenuPdfPresenter.this.mActivity)) {
                    return false;
                }
                resultValues.showErrorToast(true);
                OptionMenuPdfPresenter.this.mMenuManager.finish("TaskAddPdf#onError");
                return true;
            }

            private void resetState(String str) {
                OptionMenuPdfPresenter.this.mQuickSaveTimerController.reset(str);
                OptionMenuPdfPresenter.this.mComposerViewPresenter.getThumbnailUpdateHandler().setBlockToUpdate(false, false);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskAddPdf.ResultValues resultValues) {
                if (finish(resultValues)) {
                    return;
                }
                resultValues.notifyPageUpdate();
                resultValues.showErrorToast(false);
                resetState("executeTaskAddPdf#onError");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskAddPdf.ResultValues resultValues) {
                Logger.m10999d(OptionMenuPdfPresenter.TAG, "executeTaskAddPdf#onSuccess");
                resultValues.notifyPageUpdate();
                resultValues.updateTitle();
                OptionMenuPdfPresenter.this.mNoteManager.updateInvertBackgroundColor();
                OptionMenuPdfPresenter.this.mNoteManager.updateDummyPage();
                if (param.mIsNew) {
                    OptionMenuPdfPresenter.this.mComposerModel.getDoc().clearHistory();
                    OptionMenuPdfPresenter.this.mComposerViewPresenter.getListenerManager().notifyClearedHistory();
                }
                if (param.mIsPdfViewer) {
                    OptionMenuPdfPresenter.this.addSALogPdfExecute();
                }
                if (param.mIsStartedByExternalImportMenu) {
                    if (resultValues.isSecured()) {
                        OptionMenuPdfPresenter.this.setPdfViewOnlyState(resultValues);
                        return;
                    }
                    OptionMenuPdfPresenter.this.setPdfWriteState(param.mIsNew);
                }
                if (!OptionMenuPdfPresenter.this.mComposerModel.isSingleMode() && resultValues.getFirstPageIndex() != null) {
                    OptionMenuPdfPresenter.this.mComposerViewPresenter.getComposerControllerManager().getScrollController().goToPage(resultValues.getFirstPageIndex().intValue());
                }
                resultValues.showErrorToast(false);
                resetState("executeTaskAddPdf#onSuccess");
                if (OptionMenuPdfPresenter.this.mNoteManager.getNote().getPageCount() >= 1000) {
                    OptionMenuPdfPresenter.this.mComposerModel.saveCache(false);
                }
                if (param.mIsTemplate) {
                    return;
                }
                OptionMenuPdfPresenter.this.mMenuManager.doAiSuggestionForTranslation();
            }
        };
    }

    public TaskAddPdf.InputValues getTaskAddPdfInputValues(Param param) {
        int currentPageIndex = this.mPageManager.getDocPageInfo().getCurrentPageIndex();
        if (!param.mIsSkipTwoPage && isTwoPage() && getTwoPageRightIndex() < this.mPageManager.getPageCount() - 1) {
            currentPageIndex = getTwoPageRightIndex();
        }
        return getTaskAddPdfInputValues(param, currentPageIndex);
    }

    public void handlePdfResult(Intent intent, int i) {
        if (i != -1) {
            return;
        }
        handlePdfUri(new ParamFactory(ContentPickerUtils.getUriListFromResult(intent), null).create());
    }

    public void handlePdfUri(Param param) {
        String str = TAG;
        Logger.m11003i(str, "handlePdfUri# isStartedByExternalImportMenu = " + param.mIsStartedByExternalImportMenu + " / isPdfViewer = " + param.mIsPdfViewer);
        if (param.isInvalid()) {
            Logger.m11000e(str, "handlePdfUri# uriList and filePathList are empty.");
        } else {
            executeTaskAddPdf(getTaskAddPdfInputValues(param), param);
        }
    }

    public void handleSecurePdf() {
        ToastHandler.show(this.mActivity, C9086R.string.composer_can_not_open_protected_pdf, 0);
        this.mMenuManager.finish("handleSecurePdf");
    }

    public void onAttachView(Activity activity) {
        this.mActivity = activity;
    }

    public void onDetachView() {
        this.mActivity = null;
    }

    public void setPdfWriteState(boolean z) {
        boolean z2;
        if (this.mComposerModel.getModeManager().isMode(Mode.Init)) {
            boolean zIsLaunchedPen = CommonUtil.isLaunchedPen(this.mActivity.getIntent());
            boolean zIsSimpleModeAction = EntryAction.isSimpleModeAction(this.mActivity.getIntent());
            boolean zIsEditModeAction = EntryAction.isEditModeAction(this.mActivity.getIntent());
            String str = TAG;
            StringBuilder sbM2230u = AbstractC2821a.m2230u("setPdfWriteState# isNew:", ", isLaunchedPen:", ", isSimpleModeAction:", z, zIsLaunchedPen);
            sbM2230u.append(zIsSimpleModeAction);
            sbM2230u.append(", isEditModeAction:");
            sbM2230u.append(zIsEditModeAction);
            Logger.m11003i(str, sbM2230u.toString());
            if (!z || zIsLaunchedPen) {
                z2 = false;
            } else {
                this.mComposerViewPresenter.getSoftInputManager().blockToShow(true, "setPdfWriteState");
                z2 = true;
            }
            this.mComposerModel.getModeManager().init(z, zIsLaunchedPen, false, zIsSimpleModeAction, zIsEditModeAction);
            if (z2) {
                this.mComposerViewPresenter.getSoftInputManager().blockToShow(false, "setPdfWriteState");
            }
            if (z) {
                this.mComposerModel.setIsSupportedViewMode(false);
            }
            this.mMenuManager.invalidateOptionsMenu();
        }
    }

    public TaskAddPdf.InputValues getTaskAddPdfInputValues(Param param, int i) {
        return new TaskAddPdf.InputValues(this.mActivity, this.mNoteManager, this.mPdfManager, this.mPageManager, this.mTextManager, this.mComposerViewPresenter.getComposerControllerManager(), param.mUriList, param.mFilePathList, i, this.mComposerModel.getCoeditAdapter().isCoeditNote(), param.mIsStartedByExternalImportMenu, new TaskAddPdf.ComposerContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuPdfPresenter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAddPdf.ComposerContract
            public void changeNoteType(SpenWNote spenWNote, SpenWNote.PageMode pageMode, SpenWNote.Orientation orientation) {
                boolean z = (spenWNote.getPageMode() == pageMode && spenWNote.getOrientation() == orientation) ? false : true;
                OptionMenuPdfPresenter.this.mComposerViewPresenter.changeNoteType(spenWNote, pageMode, orientation);
                if (z) {
                    OptionMenuPdfPresenter.this.mMenuManager.changeNoteType();
                }
                OptionMenuPdfPresenter.this.mMenuManager.invalidateOptionsMenu();
            }
        }, param.mIsTemplate, this.mComposerModel.isPDFReader());
    }
}
