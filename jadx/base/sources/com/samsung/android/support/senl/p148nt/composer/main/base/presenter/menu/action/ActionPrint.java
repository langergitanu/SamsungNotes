package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Build;
import android.print.PrintAttributes;
import android.print.PrintManager;
import android.text.TextUtils;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.util.EnvironmentUtils;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.DocContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.NotesDocEntityManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareCreatedWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.PdfPrintDocumentAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareCacheHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakePdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareCommon;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionPrint extends AbsAction {
    private static final String TAG = Logger.createTag("ActionPrint");
    private final ComposerModel mComposerModel;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final ControllerManager mControllerManager;
    private final ModeManager mModeManager;

    public ActionPrint(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager) {
        this.mComposerViewPresenter = composerViewPresenter;
        ComposerModel composerModel = composerViewPresenter.getComposerModel();
        this.mComposerModel = composerModel;
        this.mModeManager = composerModel.getModeManager();
        this.mControllerManager = controllerManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareData getShareData() {
        String path = this.mComposerModel.getDocState().getPath();
        String title = this.mComposerViewPresenter.getTextManager().getTitle();
        NotesDocEntityManager notesDocEntityManager = this.mComposerModel.getNotesDocEntityManager();
        long createdTime = notesDocEntityManager.getCreatedTime();
        long lastModifiedTime = notesDocEntityManager.getLastModifiedTime();
        ShareCacheHelper.ReturnValueForShareDir contextShareDir = new ShareCacheHelper().getContextShareDir(this.mComposerViewPresenter.getActivity(), false);
        return new ShareData(path, notesDocEntityManager.getUuid(), title, createdTime, lastModifiedTime, ShareUtils.generateNewFilePath(contextShareDir == null ? "" : contextShareDir.mDir, title, lastModifiedTime, "sdocx"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void print(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.m11000e(TAG, "print# path is null");
            return;
        }
        try {
            String strValueOf = String.valueOf(hashCode());
            String str2 = TAG;
            Logger.startTime(strValueOf, str2, "print# start");
            String string = context.getResources().getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C9086R.string.notes_jp : C9086R.string.notes);
            PrintManager printManager = (PrintManager) context.getSystemService("print");
            PdfPrintDocumentAdapter pdfPrintDocumentAdapter = new PdfPrintDocumentAdapter(str, new File(str).getName());
            PrintAttributes.Builder builder = new PrintAttributes.Builder();
            builder.setMediaSize(PrintAttributes.MediaSize.ISO_A4);
            printManager.print(string, pdfPrintDocumentAdapter, builder.build());
            Logger.endTime(String.valueOf(hashCode()), str2, "print# end");
            UserInputSkipper.setHoldingEventTime(700L, UserInputSkipper.Tag.ComposerActivity);
        } catch (Exception e) {
            AbstractC8014b.m7207i("print: ", e, TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printNote(Activity activity, TaskController taskController, ComposerModel composerModel, ShareData shareData) {
        Activity activity2;
        ShareWNote shareCreatedWNote;
        if (composerModel.getDoc().hasAllContentFiles()) {
            shareCreatedWNote = new ShareWNote(composerModel.getDoc());
            activity2 = activity;
        } else {
            try {
                boolean zIsCoeditUuid = UUIDUtils.isCoeditUuid(composerModel.getDocInfo().getUuid());
                String docPath = composerModel.getDocInfo().getDocPath();
                activity2 = activity;
                SpenWNote spenWNoteOpen = DocumentFileManager.getInstance().open(activity2, docPath, composerModel.getDoc().getPageDefaultWidth(), 8500, true, true, zIsCoeditUuid);
                DocumentFileManager.getInstance().saveAsDirectory(spenWNoteOpen, shareData.getNewPath());
                shareCreatedWNote = new ShareCreatedWNote(spenWNoteOpen, docPath);
                shareData.syncPath();
            } catch (Exception e) {
                Logger.m11001e(TAG, "printNote#  new SpenWNote fail e#", e);
                return;
            }
        }
        taskController.execute(new TaskMakePdf(), new TaskMakePdf.InputValues(activity2, composerModel, shareData, shareCreatedWNote, true), new Task.Callback<TaskShareCommon.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.action.ActionPrint.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskShareCommon.ResultValues resultValues) {
                Logger.m11000e(ActionPrint.TAG, "printNote : onError");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskShareCommon.ResultValues resultValues) {
                try {
                    ActionPrint.this.print(resultValues.getContext(), resultValues.getPath());
                } catch (ActivityNotFoundException e2) {
                    Logger.m11000e(ActionPrint.TAG, "printNote :" + e2);
                }
            }
        }, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean doAction(String str) {
        if (!this.mModeManager.isMode(Mode.View) && !this.mComposerModel.getComposerSaveModel().isAutoSaveOptionEnabled() && this.mComposerModel.isChangedDocStateWithSnapSavedData()) {
            Logger.m11004w(TAG, "doAction# mode = " + this.mModeManager.getMode());
            return false;
        }
        if (this.mControllerManager.getTaskController().isRunning()) {
            Logger.m11004w(TAG, "doAction# task is running / " + str);
            return false;
        }
        if (this.mComposerModel.getComposerState().isSecured()) {
            Logger.m11004w(TAG, "doAction# isSecured is true / " + str);
            return false;
        }
        AbstractC8014b.m7197C("doAction# ", str, TAG);
        if ((!this.mComposerModel.isPDFReader() || FileUtils.isFileExists(this.mComposerModel.getDocState().getPath())) ? this.mComposerModel.saveCache(false, 0) : this.mComposerModel.saveCacheForced(false)) {
            this.mComposerModel.getComposerSaveModel().addSaveListener(new DocContract.SavedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.action.ActionPrint.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.model.data.DocContract.SavedListener
                public void onSuccess() {
                    ActionPrint actionPrint = ActionPrint.this;
                    actionPrint.printNote(actionPrint.mComposerViewPresenter.getActivity(), ActionPrint.this.mControllerManager.getTaskController(), ActionPrint.this.mComposerModel, ActionPrint.this.getShareData());
                }
            });
            return true;
        }
        printNote(this.mComposerViewPresenter.getActivity(), this.mControllerManager.getTaskController(), this.mComposerModel, getShareData());
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean isSupported() {
        return isSupported(this.mComposerViewPresenter.getActivity());
    }

    public static boolean isSupported(Activity activity) {
        if (Build.VERSION.SDK_INT < 30) {
            return (UserHandleCompat.getInstance().isKnoxMode() || EnvironmentUtils.isRunningUnderKnox(activity) || EnvironmentUtils.isRunningUnderAndroidForWork(activity) || DeviceUtils.isPowerManageMode(activity)) ? false : true;
        }
        return true;
    }
}
