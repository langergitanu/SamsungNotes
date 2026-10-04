package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.menu.option;

import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.DocContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.EntryAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakePdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareCommon;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.ShareMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.lifecycle.IPwInfo;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.lifecycle.PdfWriterManager;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PdfFileInfo;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwDocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.task.PwTaskSavePdf;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwOptionMenuSharePresenter extends OptionMenuSharePresenter {
    private static final String KEY_MYFILES_WIDGET = "is_launch_from_myfiles_shortcut";
    private static final String TAG = Logger.createTag("PwOptionMenuSharePresenter");
    private boolean mIsSave;
    private Runnable mSaveCallback;

    public PwOptionMenuSharePresenter(ControllerManager controllerManager, ComposerViewPresenter composerViewPresenter, ComposerModel composerModel, DialogPresenterManager dialogPresenterManager) {
        super(controllerManager, composerViewPresenter, composerModel, dialogPresenterManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callSaveCallback() {
        Runnable runnable = this.mSaveCallback;
        if (runnable != null) {
            runnable.run();
            this.mSaveCallback = null;
        }
        ((PwComposerModel) this.mComposerModel).deleteCacheInfo();
        if (!EntryAction.isEditModeAction(this.mActivity.getIntent())) {
            this.mComposerModel.getModeManager().setMode(Mode.View, "onClickSave", true);
        } else {
            Logger.m10999d(TAG, "callSaveCallback# finish by EditModeAction");
            this.mActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeSavePdf(String str, ShareData shareData, ShareWNote shareWNote) {
        final PwTaskSavePdf pwTaskSavePdf = new PwTaskSavePdf();
        Task.Callback<TaskShareCommon.ResultValues> callback = new Task.Callback<TaskShareCommon.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.menu.option.PwOptionMenuSharePresenter.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskShareCommon.ResultValues resultValues) {
                pwTaskSavePdf.getDefaultCallback().onError(resultValues);
                if (!(resultValues instanceof PwTaskSavePdf.ResultValues) || !((PwTaskSavePdf.ResultValues) resultValues).isIOError()) {
                    PwOptionMenuSharePresenter.this.setSaveFlag(false);
                    return;
                }
                Logger.m10999d(PwOptionMenuSharePresenter.TAG, "makeNotCorruptShareNote#onError# execute picker");
                ((PwDocInfo) ((OptionMenuSharePresenter) PwOptionMenuSharePresenter.this).mComposerModel.getDocInfo()).getPdfFileInfo().setSaveAs(true);
                PwOptionMenuSharePresenter.this.executeSaveDirectoryPicker();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskShareCommon.ResultValues resultValues) {
                pwTaskSavePdf.getDefaultCallback().onSuccess(resultValues);
                if (resultValues == null || TextUtils.isEmpty(resultValues.getPath())) {
                    return;
                }
                PdfFileInfo pdfFileInfo = ((PwDocInfo) ((OptionMenuSharePresenter) PwOptionMenuSharePresenter.this).mComposerModel.getDocInfo()).getPdfFileInfo();
                if (pdfFileInfo.isSaveAs()) {
                    pdfFileInfo.setName(FileUtils.getFileNameFromFilePath(resultValues.getPath()));
                    pdfFileInfo.setSaveAs(false);
                    pdfFileInfo.setPath(resultValues.getPath());
                    if (((OptionMenuSharePresenter) PwOptionMenuSharePresenter.this).mActivity instanceof IPwInfo) {
                        PdfWriterManager.getInstance().register((IPwInfo) ((OptionMenuSharePresenter) PwOptionMenuSharePresenter.this).mActivity, pdfFileInfo.getPath());
                    }
                }
                PwOptionMenuSharePresenter.this.setSaveFlag(false);
                PwOptionMenuSharePresenter.this.callSaveCallback();
            }
        };
        TaskMakePdf.InputValues inputValues = new TaskMakePdf.InputValues(this.mActivity, this.mComposerModel, str, shareData, shareWNote, this.mPdfShareType);
        if (this.mActivity.getIntent() != null && this.mActivity.getIntent().getBooleanExtra(KEY_MYFILES_WIDGET, false)) {
            Logger.m11004w(TAG, "setWidgetMyfiles");
            inputValues.setWidgetMyfiles();
        }
        this.mTaskController.execute(pwTaskSavePdf, inputValues, callback, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter, com.samsung.android.support.senl.nt.composer.main.base.widget.share.ShareMenuContract.Presenter
    public void executeSaveDirectoryPicker() {
        startSaveDirectoryPicker();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter, com.samsung.android.support.senl.nt.composer.main.base.widget.share.ShareMenuContract.Presenter
    public void executeShareNote() {
        shareNote();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter
    public void initShareMenuList() {
        ArrayList arrayList = new ArrayList();
        this.mShareMenuList = arrayList;
        arrayList.add(ShareMenuContract.ShareType.PDF);
        this.mShareMenuList.add(ShareMenuContract.ShareType.IMAGE);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter
    public void makeNotCorruptShareNote(final String str, final ShareData shareData) {
        boolean z;
        final ShareWNote shareWNote = new ShareWNote(this.mComposerModel.getDoc());
        if (this.mIsSave) {
            saveNoteAsync(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.menu.option.PwOptionMenuSharePresenter.1
                @Override // java.lang.Runnable
                public void run() {
                    PwOptionMenuSharePresenter.this.executeSavePdf(str, shareData, shareWNote);
                }
            });
            return;
        }
        if (this.mComposerModel.isExistSdocxFile()) {
            z = false;
        } else {
            z = true;
            this.mComposerModel.saveCacheForced(true);
        }
        getTaskShareBuilder(shareData, shareWNote, str).executeTask(this.mTaskController, checkPermission());
        if (z) {
            this.mComposerModel.getDocState().setDirty(false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter
    public void saveNoteAsync(final Runnable runnable) {
        if (!this.mComposerModel.isEmpty() && this.mComposerModel.getModeManager().isEditModeWithReadOnly()) {
            this.mClipboardController.closeClipboard();
            this.mObjectManager.clearSelectObject(false);
            if (this.mComposerModel.isChangedDocStateWithSnapSavedData()) {
                this.mComposerViewPresenter.requestReadyForSave();
                this.mComposerModel.getDocState().setDirty(true);
                if (this.mComposerModel.saveCache(false, 0)) {
                    this.mComposerModel.getComposerSaveModel().addSaveListener(new DocContract.SavedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.menu.option.PwOptionMenuSharePresenter.2
                        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.data.DocContract.SavedListener
                        public void onSuccess() {
                            runnable.run();
                        }
                    });
                    return;
                }
            } else {
                Logger.m11000e(TAG, "saveNote# The saveNote was skipped.");
            }
        }
        runnable.run();
    }

    public void setSaveCallback(Runnable runnable) {
        this.mSaveCallback = runnable;
    }

    public void setSaveFlag(boolean z) {
        AbstractC8014b.m7220v("setSaveFlag# ", TAG, z);
        this.mIsSave = z;
    }
}
