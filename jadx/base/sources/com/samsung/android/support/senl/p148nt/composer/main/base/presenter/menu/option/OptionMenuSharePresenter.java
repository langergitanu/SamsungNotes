package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.DocContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.NotesDocEntityManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageCopyData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ClipboardController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SaveAsRenameDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareCacheHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareCondition;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakeContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakeNotCorruptShareNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakePdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakeShareNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareBuilder;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareCommon;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskSharePowerPoint;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareSDoc;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareText;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareWord;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.ShareMenuContract;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuSharePresenter implements TaskMakeContract, ShareMenuContract.Presenter {
    private static final String TAG = Logger.createTag("OptionMenuSharePresenter");
    protected Activity mActivity;
    protected ClipboardController mClipboardController;
    protected ComposerModel mComposerModel;
    protected ComposerViewPresenter mComposerViewPresenter;
    private final DialogPresenterManager mDialogPresenterManager;
    private Fragment mFragment;
    private final ModeManager mModeManager;
    private final NoteManager mNoteManager;
    protected ObjectManager mObjectManager;
    private OptionMenuContract.IOptionMenuShare mOptionMenuShare;
    protected ShareMenuContract.ShareType mShareType;
    protected TaskController mTaskController;
    private final TextManager mTextManager;
    protected TaskMakePdf.PdfShareType mPdfShareType = TaskMakePdf.PdfShareType.NOTES_COMPAT;
    private List<PageCopyData> mPageDataList = null;
    protected List<ShareMenuContract.ShareType> mShareMenuList = null;
    private ShareData.ShareTo mShareTo = null;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter$9 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C98359 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$composer$main$base$widget$share$ShareMenuContract$ShareType */
        static final /* synthetic */ int[] f7004x86a0478b;

        static {
            int[] iArr = new int[ShareMenuContract.ShareType.values().length];
            f7004x86a0478b = iArr;
            try {
                iArr[ShareMenuContract.ShareType.SDOC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7004x86a0478b[ShareMenuContract.ShareType.PDF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7004x86a0478b[ShareMenuContract.ShareType.IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7004x86a0478b[ShareMenuContract.ShareType.TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7004x86a0478b[ShareMenuContract.ShareType.DOC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7004x86a0478b[ShareMenuContract.ShareType.PPTX.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public OptionMenuSharePresenter(ControllerManager controllerManager, ComposerViewPresenter composerViewPresenter, ComposerModel composerModel, DialogPresenterManager dialogPresenterManager) {
        this.mTaskController = controllerManager.getTaskController();
        this.mClipboardController = controllerManager.getClipboardController();
        this.mComposerViewPresenter = composerViewPresenter;
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mTextManager = composerViewPresenter.getTextManager();
        this.mNoteManager = composerViewPresenter.getNoteManager();
        this.mComposerModel = composerModel;
        this.mDialogPresenterManager = dialogPresenterManager;
        initShareMenuList();
    }

    private boolean isAutoSaveOptionEnabled() {
        return this.mComposerModel.getComposerSaveModel().isAutoSaveOptionEnabled();
    }

    private boolean isAvailableShare() {
        return (!isAutoSaveOptionEnabled() && this.mComposerModel.getModeManager().isEditModeWithReadOnly() && this.mComposerModel.isChangedDocStateWithSnapSavedData()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makePagesShareNote(String str, ShareData shareData) {
        TaskMakeShareNote.InputValues inputValues = new TaskMakeShareNote.InputValues(this.mActivity, this.mObjectManager, this.mTextManager, this.mNoteManager, shareData, this.mPageDataList, str, this);
        Task.Callback<TaskMakeShareNote.ResultValues> callback = new Task.Callback<TaskMakeShareNote.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter.8
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskMakeShareNote.ResultValues resultValues) {
                if (resultValues.getCallback() != null) {
                    resultValues.getCallback().onError(resultValues.getResultValues());
                }
                OptionMenuSharePresenter.this.mPageDataList = null;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskMakeShareNote.ResultValues resultValues) {
                if (resultValues.getCallback() != null) {
                    resultValues.getCallback().onSuccess(resultValues.getResultValues());
                }
                OptionMenuSharePresenter.this.mPageDataList = null;
            }
        };
        if (checkPermission()) {
            this.mTaskController.setPendingTask(new TaskMakeShareNote(), inputValues, callback, false);
        } else {
            this.mTaskController.execute(new TaskMakeShareNote(), inputValues, callback, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeShareNote(String str, ShareData shareData) {
        if (isPageShareNote()) {
            makePagesShareNote(str, shareData);
        } else {
            makeNotCorruptShareNote(str, shareData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAsWithFixedPath() {
        File saveAsFixedDir = ShareUtils.getSaveAsFixedDir(this.mActivity);
        if (saveAsFixedDir == null) {
            Logger.m11000e(TAG, "saveAsWithFixedPath# can not create");
            return;
        }
        ShareData shareData = getShareData();
        makeShareNote(FileUtils.generateUniqueFilePath(saveAsFixedDir.getAbsolutePath(), ShareUtils.generateNewFileName(shareData.getTitle(), shareData.getLastModifiedTime()), getExtension()), shareData);
    }

    private void showErrorMessage(boolean z) {
        if (z) {
            ToastHandler.show(this.mActivity, C9086R.string.save_as_file_empty_content, 0);
        } else {
            ToastHandler.show(this.mActivity, C9086R.string.share_empty_content, 0);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.share.ShareMenuContract.Presenter
    public boolean canShowWordExportOption() {
        return isPageShareNote() ? ShareCondition.canShowWordExportOption(this.mObjectManager.getNote(), this.mPageDataList, this.mActivity) : ShareCondition.canShowWordExportOption(this.mObjectManager.getNote(), this.mActivity);
    }

    public boolean checkPermission() {
        if (!ShareUtils.isNotSupportedFileProviderForChina()) {
            return false;
        }
        String[] storagePermissions = PermissionCompat.getStoragePermissions(4);
        if (PermissionHelper.isPermissionGrantedWithoutNotice(this.mActivity, storagePermissions)) {
            return false;
        }
        Logger.m11003i(TAG, "checkPermission# - get WRITE_EXTERNAL_STORAGE permission");
        Fragment fragmentFindFragmentByTag = ((AppCompatActivity) this.mActivity).getSupportFragmentManager().findFragmentByTag("Composer");
        if (fragmentFindFragmentByTag == null) {
            return false;
        }
        PermissionHelper.requestPermissions(fragmentFindFragmentByTag, 108, storagePermissions);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkShareCondition(SpenWNote spenWNote, boolean z) {
        ShareMenuContract.ShareType shareType = this.mShareType;
        boolean z2 = false;
        if (shareType == ShareMenuContract.ShareType.SDOC || shareType == ShareMenuContract.ShareType.DOC || shareType == ShareMenuContract.ShareType.PPTX) {
            if (this.mComposerModel.isEmpty()) {
                showErrorMessage(z);
            } else {
                z2 = true;
            }
        } else if (shareType == ShareMenuContract.ShareType.TEXT) {
            if (!ShareCondition.hasText(spenWNote)) {
                ToastHandler.show(this.mActivity, C9086R.string.share_no_text, 0);
            }
        } else if (!ShareCondition.hasContent(spenWNote)) {
            showErrorMessage(z);
        }
        Logger.m11003i(TAG, "checkShareCondition# type " + this.mShareType.name() + SQLKeyword.COMMA + z2);
        return z2;
    }

    public void clearPageDataList() {
        this.mPageDataList = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.share.ShareMenuContract.Presenter
    public void executeSaveDirectoryPicker() {
        if (isAvailableShare()) {
            startSaveDirectoryPicker();
        } else {
            this.mDialogPresenterManager.showShareSaveNoteConfirmDialog(false, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter.4
                @Override // java.lang.Runnable
                public void run() {
                    OptionMenuSharePresenter.this.startSaveDirectoryPicker();
                }
            });
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.share.ShareMenuContract.Presenter
    public void executeShareNote() {
        if (isAvailableShare()) {
            shareNote();
        } else {
            this.mDialogPresenterManager.showShareSaveNoteConfirmDialog(true, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter.3
                @Override // java.lang.Runnable
                public void run() {
                    OptionMenuSharePresenter.this.shareNote();
                }
            });
        }
    }

    public String getExtension() {
        switch (C98359.f7004x86a0478b[this.mShareType.ordinal()]) {
            case 1:
                return "sdocx";
            case 2:
                return Constants.PDF_EXTENSION;
            case 3:
                return "jpg";
            case 4:
                return Constants.TEXT_EXTENSION;
            case 5:
                return Constants.DOC_EXTENSION;
            case 6:
                return Constants.PPT_EXTENSION;
            default:
                throw new IncompatibleClassChangeError();
        }
    }

    public ShareData getShareData() {
        String path = this.mComposerModel.getDocState().getPath();
        String title = this.mTextManager.getTitle();
        NotesDocEntityManager notesDocEntityManager = this.mComposerModel.getNotesDocEntityManager();
        long createdTime = notesDocEntityManager.getCreatedTime();
        long lastModifiedTime = notesDocEntityManager.getLastModifiedTime();
        ShareCacheHelper.ReturnValueForShareDir contextShareDir = new ShareCacheHelper().getContextShareDir(this.mActivity, false);
        return new ShareData(path, notesDocEntityManager.getUuid(), title, createdTime, lastModifiedTime, ShareUtils.generateNewFilePath(contextShareDir == null ? "" : contextShareDir.mDir, title, lastModifiedTime, "sdocx"));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.share.ShareMenuContract.Presenter
    public List<ShareMenuContract.ShareType> getShareMenuList() {
        return this.mShareMenuList;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakeContract
    @NonNull
    public TaskShareBuilder getTaskShareBuilder(ShareData shareData, ShareWNote shareWNote, String str) {
        Task.InputValues inputValues;
        Task.InputValues inputValues2;
        Task task;
        Task task2;
        shareData.setShareToInfo(this.mShareTo);
        Task.Callback defaultCallback = null;
        this.mShareTo = null;
        switch (C98359.f7004x86a0478b[this.mShareType.ordinal()]) {
            case 1:
                TaskShareSDoc taskShareSDoc = new TaskShareSDoc();
                inputValues = new TaskShareCommon.InputValues(this.mActivity, str, shareData, shareWNote);
                task2 = taskShareSDoc;
                if (!TextUtils.isEmpty(str)) {
                    defaultCallback = taskShareSDoc.getDefaultCallback();
                    task2 = taskShareSDoc;
                }
                break;
            case 2:
                TaskMakePdf taskMakePdf = new TaskMakePdf();
                inputValues2 = new TaskMakePdf.InputValues(this.mActivity, this.mComposerModel, str, shareData, shareWNote, this.mPdfShareType);
                task = taskMakePdf;
                if (!TextUtils.isEmpty(str)) {
                    defaultCallback = taskMakePdf.getDefaultCallback();
                    task = taskMakePdf;
                }
                inputValues = inputValues2;
                task2 = task;
                break;
            case 3:
                TaskShareImage taskShareImage = new TaskShareImage();
                inputValues2 = new TaskShareImage.InputValues(this.mActivity, this.mComposerModel, str, shareData, shareWNote);
                task = taskShareImage;
                if (!TextUtils.isEmpty(str)) {
                    defaultCallback = taskShareImage.getDefaultCallback();
                    task = taskShareImage;
                }
                inputValues = inputValues2;
                task2 = task;
                break;
            case 4:
                TaskShareText taskShareText = new TaskShareText();
                inputValues = new TaskShareText.InputValues(this.mActivity, str, shareData, shareWNote);
                task2 = taskShareText;
                if (!TextUtils.isEmpty(str)) {
                    defaultCallback = taskShareText.getDefaultCallback();
                    task2 = taskShareText;
                }
                break;
            case 5:
                TaskShareWord taskShareWord = new TaskShareWord();
                inputValues = new TaskShareCommon.InputValues(this.mActivity, str, shareData, shareWNote);
                task2 = taskShareWord;
                if (!TextUtils.isEmpty(str)) {
                    defaultCallback = taskShareWord.getDefaultCallback();
                    task2 = taskShareWord;
                }
                break;
            case 6:
                TaskSharePowerPoint taskSharePowerPoint = new TaskSharePowerPoint();
                inputValues = new TaskShareCommon.InputValues(this.mActivity, str, shareData, shareWNote);
                task2 = taskSharePowerPoint;
                if (!TextUtils.isEmpty(str)) {
                    defaultCallback = taskSharePowerPoint.getDefaultCallback();
                    task2 = taskSharePowerPoint;
                }
                break;
            default:
                TaskShareImage taskShareImage2 = new TaskShareImage();
                inputValues = new TaskShareImage.InputValues(this.mActivity, this.mComposerModel, str, shareData, shareWNote);
                task2 = taskShareImage2;
                break;
        }
        return new TaskShareBuilder(task2).setCallback(defaultCallback).setInputValues(inputValues);
    }

    public void initShareMenuList() {
        ArrayList arrayList = new ArrayList();
        this.mShareMenuList = arrayList;
        arrayList.add(ShareMenuContract.ShareType.SDOC);
        if (!this.mComposerModel.getComposerSpenDocModel().hasUnknownObject()) {
            this.mShareMenuList.add(ShareMenuContract.ShareType.PDF);
        }
        this.mShareMenuList.add(ShareMenuContract.ShareType.DOC);
        this.mShareMenuList.add(ShareMenuContract.ShareType.PPTX);
        this.mShareMenuList.add(ShareMenuContract.ShareType.IMAGE);
        this.mShareMenuList.add(ShareMenuContract.ShareType.TEXT);
    }

    public boolean isEditMode() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            return false;
        }
        return composerModel.getModeManager().isEditMode();
    }

    public boolean isPageShareNote() {
        List<PageCopyData> list = this.mPageDataList;
        return (list == null || list.isEmpty() || this.mPageDataList.size() == this.mObjectManager.getNote().getPageCount() - 1) ? false : true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.share.ShareMenuContract.Presenter
    public boolean isSingleMode() {
        return this.mComposerModel.isSingleMode();
    }

    public void makeNotCorruptShareNote(String str, ShareData shareData) {
        TaskMakeNotCorruptShareNote.InputValues inputValues = new TaskMakeNotCorruptShareNote.InputValues(this.mActivity, this.mObjectManager.getNote(), shareData, str, this);
        Task.Callback<TaskMakeNotCorruptShareNote.ResultValues> callback = new Task.Callback<TaskMakeNotCorruptShareNote.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter.7
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskMakeNotCorruptShareNote.ResultValues resultValues) {
                if (resultValues.getCallback() != null) {
                    resultValues.getCallback().onError(resultValues.getResultValues());
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskMakeNotCorruptShareNote.ResultValues resultValues) {
                if (resultValues.getCallback() != null) {
                    resultValues.getCallback().onSuccess(resultValues.getResultValues());
                }
            }
        };
        if (checkPermission()) {
            this.mTaskController.setPendingTask(new TaskMakeNotCorruptShareNote(), inputValues, callback, false);
        } else {
            this.mTaskController.execute(new TaskMakeNotCorruptShareNote(), inputValues, callback, false);
        }
    }

    public void onActivityResultForExport(int i, final Intent intent) {
        if (intent == null || i != -1) {
            AbstractC0000a.m3D(i, "onActivityResultForExport# data or resultCode has problem", TAG);
        } else if (this.mShareType == null) {
            Logger.m10999d(TAG, "onActivityResultForExport# mShareType is null.");
        } else {
            saveNoteAsync(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter.6
                @Override // java.lang.Runnable
                public void run() {
                    String pathFromResult = ContentPickerUtils.getPathFromResult(OptionMenuSharePresenter.this.mActivity, intent);
                    Logger.m10999d(OptionMenuSharePresenter.TAG, "onActivityResultForExport# Dir : " + Logger.getEncode(pathFromResult));
                    final ShareData shareData = OptionMenuSharePresenter.this.getShareData();
                    OptionMenuSharePresenter.this.mDialogPresenterManager.showSaveAsRenameDialog(shareData, pathFromResult, OptionMenuSharePresenter.this.getExtension(), new SaveAsRenameDialogPresenter.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter.6.1
                        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.SaveAsRenameDialogPresenter.OnClickListener
                        public void dismiss(View view) {
                            InputMethodCompat.getInstance().forceHideSoftInput(OptionMenuSharePresenter.this.mActivity);
                            if (!OptionMenuSharePresenter.this.mModeManager.isMode(Mode.Text)) {
                                OptionMenuSharePresenter.this.mObjectManager.clearSelectObject(false);
                            } else {
                                OptionMenuSharePresenter optionMenuSharePresenter = OptionMenuSharePresenter.this;
                                optionMenuSharePresenter.mObjectManager.selectObject(optionMenuSharePresenter.mTextManager.getTextBox());
                            }
                        }

                        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.SaveAsRenameDialogPresenter.OnClickListener
                        public void onClick(String str) {
                            OptionMenuSharePresenter.this.makeShareNote(str, shareData);
                        }
                    });
                }
            });
        }
    }

    public void onAttachView(Activity activity, Fragment fragment) {
        this.mActivity = activity;
        this.mFragment = fragment;
    }

    public void onDetachView() {
        this.mActivity = null;
        this.mFragment = null;
    }

    public boolean onRequestPermissionsResult(int i) {
        if (i == 108) {
            this.mTaskController.executePendingTask();
            return true;
        }
        if (i != 109) {
            return false;
        }
        executeSaveDirectoryPicker();
        return true;
    }

    public void saveNoteAsync(final Runnable runnable) {
        if (!this.mComposerModel.isEmpty()) {
            if (this.mComposerModel.getModeManager().isEditModeWithReadOnly()) {
                this.mClipboardController.closeClipboard();
                this.mNoteManager.updateBodyTextPage();
                this.mObjectManager.clearSelectObject(false);
                this.mComposerViewPresenter.requestReadyForSave();
                if (this.mComposerModel.saveCache(false, 0)) {
                    this.mComposerModel.getComposerSaveModel().addSaveListener(new DocContract.SavedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter.1
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

    public void setPageDataList(List<PageCopyData> list) {
        this.mPageDataList = list;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.share.ShareMenuContract.Presenter
    public void setPdfShareType(TaskMakePdf.PdfShareType pdfShareType) {
        this.mPdfShareType = pdfShareType;
    }

    public void setShareTo(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        ShareData.ShareTo shareTo = new ShareData.ShareTo();
        this.mShareTo = shareTo;
        shareTo.setPackage(str);
        this.mShareTo.setActivity(str2);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.share.ShareMenuContract.Presenter
    public void setShareType(ShareMenuContract.ShareType shareType) {
        this.mShareType = shareType;
    }

    public void setShareView(OptionMenuContract.IOptionMenuShare iOptionMenuShare) {
        this.mOptionMenuShare = iOptionMenuShare;
    }

    public void shareNote() {
        saveNoteAsync(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter.2
            @Override // java.lang.Runnable
            public void run() {
                ShareData shareData = OptionMenuSharePresenter.this.getShareData();
                if (OptionMenuSharePresenter.this.isPageShareNote()) {
                    OptionMenuSharePresenter optionMenuSharePresenter = OptionMenuSharePresenter.this;
                    if (optionMenuSharePresenter.checkShareCondition(optionMenuSharePresenter.mObjectManager.getNote(), OptionMenuSharePresenter.this.mPageDataList, false)) {
                        OptionMenuSharePresenter.this.makePagesShareNote("", shareData);
                        return;
                    }
                    return;
                }
                OptionMenuSharePresenter optionMenuSharePresenter2 = OptionMenuSharePresenter.this;
                if (optionMenuSharePresenter2.checkShareCondition(optionMenuSharePresenter2.mObjectManager.getNote(), false)) {
                    OptionMenuSharePresenter.this.makeNotCorruptShareNote("", shareData);
                }
            }
        });
    }

    public void showShareMenu(Activity activity) {
        OptionMenuContract.IOptionMenuShare iOptionMenuShare = this.mOptionMenuShare;
        if (iOptionMenuShare != null) {
            iOptionMenuShare.showPopupMenu(activity, this);
        }
    }

    public void startSaveDirectoryPicker() {
        Logger.m11003i(TAG, "startSaveDirectoryPicker#");
        saveNoteAsync(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter.5
            @Override // java.lang.Runnable
            public void run() {
                if (OptionMenuSharePresenter.this.isPageShareNote()) {
                    OptionMenuSharePresenter optionMenuSharePresenter = OptionMenuSharePresenter.this;
                    if (!optionMenuSharePresenter.checkShareCondition(optionMenuSharePresenter.mObjectManager.getNote(), OptionMenuSharePresenter.this.mPageDataList, true)) {
                        return;
                    }
                } else {
                    OptionMenuSharePresenter optionMenuSharePresenter2 = OptionMenuSharePresenter.this;
                    if (!optionMenuSharePresenter2.checkShareCondition(optionMenuSharePresenter2.mObjectManager.getNote(), true)) {
                        return;
                    }
                }
                if (PermissionCompat.FEATURE_ENABLED_MANAGE_EXTERNAL_STORAGE) {
                    ContentPickerUtils.startSaveDirectoryPickerActivityForResult(OptionMenuSharePresenter.this.mFragment, 109, ComposerRequestCode.Export.getId());
                } else {
                    OptionMenuSharePresenter.this.saveAsWithFixedPath();
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.share.ShareMenuContract.Presenter
    public void stopRecordAndAudio() {
        this.mComposerModel.getVoiceModel().stopRecordingOrPlaying();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkShareCondition(SpenWNote spenWNote, List<PageCopyData> list, boolean z) {
        boolean z2 = false;
        if (this.mShareType == ShareMenuContract.ShareType.TEXT) {
            if (ShareCondition.hasText(spenWNote, list, this.mTextManager.getSpenNoteTextManager())) {
                z2 = true;
            } else {
                ToastHandler.show(this.mActivity, C9086R.string.share_no_text, 0);
            }
        } else if (!ShareCondition.hasContent(spenWNote, list, this.mTextManager.getSpenNoteTextManager())) {
            showErrorMessage(z);
        }
        Logger.m11003i(TAG, "checkShareCondition - PageShare# type " + this.mShareType.name() + SQLKeyword.COMMA + z2);
        return z2;
    }
}
