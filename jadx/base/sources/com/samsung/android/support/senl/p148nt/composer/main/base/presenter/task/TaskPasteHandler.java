package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.ClipData;
import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipDataBackupPath;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipboardCacheManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAddPdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskPaste;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.AbsPasteLogic;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.PasteObject;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.PastePage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.PasteRawContent;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.WebCardUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class TaskPasteHandler extends Handler {
    static final int MESSAGE_GET_CONTENTS = 2;
    private static final String TAG = Logger.createTag("TaskPasteHandler");
    private Task.Callback<TaskPaste.ResultValues> mCallback;
    private ClipData mClipData;
    private ComposerModel mComposerModel;
    private Context mContext;
    private WebCardUtil.IDialogManager mDialogPresenterManager;
    private boolean mEnableWebCard;
    private ExecutorService mExecutorService;
    private NoteManager mNoteManager;
    private ObjectManager mObjectManager;
    private PageManager mPageManager;
    private AbsPasteLogic mPasteLogic;
    private PointF mPastePosition;
    private PdfManager mPdfManager;
    private boolean mPlainTextFlags;
    private SpenWNote mSpenWNote;
    private StorageChecker mStorageChecker;
    private int mTargetPageIndex;
    private TaskAddPdf mTaskAddPdf;
    private TextManager mTextManager;
    private int mErrorCode = 0;
    private int mErrorCodeSubType = 0;
    private boolean mUpdateInvertBG = false;
    private String mCachePath = "";
    private boolean mIsReleased = false;

    public TaskPasteHandler(Context context, ClipData clipData, Task.Callback<TaskPaste.ResultValues> callback, ComposerModel composerModel, ObjectManager objectManager, NoteManager noteManager, PageManager pageManager, TextManager textManager, PdfManager pdfManager, int i, PointF pointF, boolean z, WebCardUtil.IDialogManager iDialogManager, boolean z2) {
        init(context, clipData, callback, composerModel, objectManager, noteManager, pageManager, textManager, pdfManager, i, pointF, z, iDialogManager, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeTaskAddPdf(final PasteRawContent.PdfInputs pdfInputs) {
        TaskAddPdf.InputValues inputValues = new TaskAddPdf.InputValues(this.mContext, this.mNoteManager, this.mPdfManager, this.mPageManager, this.mTextManager, null, pdfInputs.getPdfUris(), null, this.mPageManager.getDocPageInfo().getCurrentPageIndex(), this.mComposerModel.getCoeditAdapter().isCoeditNote());
        TaskAddPdf taskAddPdf = new TaskAddPdf();
        this.mTaskAddPdf = taskAddPdf;
        taskAddPdf.setStorageChecker(this.mStorageChecker);
        this.mTaskAddPdf.setTaskCallback(new Task.Callback<TaskAddPdf.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskPasteHandler.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskAddPdf.ResultValues resultValues) {
                pdfInputs.onErrorToAddPdf(resultValues.mErrorCode);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskAddPdf.ResultValues resultValues) {
                pdfInputs.onSuccessToAddPdf(resultValues.mFinalPageIndex, resultValues.mErrorCode);
            }
        });
        this.mTaskAddPdf.setInputValue(inputValues);
        this.mTaskAddPdf.executeTask(inputValues);
    }

    private void handleGetContents() {
        this.mExecutorService.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskPasteHandler.1
            @Override // java.lang.Runnable
            public void run() {
                String backupPathFromHtml = ClipDataBackupPath.getBackupPathFromHtml(TaskPasteHandler.this.mClipData);
                if (TaskPasteHandler.this.mPlainTextFlags || !ClipDataBackupPath.isNoteClip(backupPathFromHtml)) {
                    TaskPasteHandler taskPasteHandler = TaskPasteHandler.this;
                    PasteRawContent.Contract contract = new PasteRawContent.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskPasteHandler.1.1
                        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.paste.PasteRawContent.Contract
                        public void addPdf(PasteRawContent.PdfInputs pdfInputs) {
                            TaskPasteHandler.this.executeTaskAddPdf(pdfInputs);
                        }

                        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.paste.AbsPasteLogic.Contract
                        public void release() {
                            TaskPasteHandler.this.release();
                        }
                    };
                    Context context = TaskPasteHandler.this.mContext;
                    TaskPasteHandler taskPasteHandler2 = TaskPasteHandler.this;
                    taskPasteHandler.mPasteLogic = new PasteRawContent(contract, context, taskPasteHandler2, taskPasteHandler2.mComposerModel, TaskPasteHandler.this.mClipData, TaskPasteHandler.this.mObjectManager, TaskPasteHandler.this.mSpenWNote, TaskPasteHandler.this.mStorageChecker, TaskPasteHandler.this.mTargetPageIndex, TaskPasteHandler.this.mPastePosition, TaskPasteHandler.this.mCachePath, TaskPasteHandler.this.mEnableWebCard, TaskPasteHandler.this.mExecutorService, TaskPasteHandler.this.mDialogPresenterManager, TaskPasteHandler.this.mPlainTextFlags);
                } else {
                    if (TaskPasteHandler.this.mComposerModel.getCoeditAdapter().isCoeditNote() && SpenWNoteFile.getFormatVersion(backupPathFromHtml) > 4000) {
                        Logger.m11004w(TaskPasteHandler.TAG, "paste# unsupported format version");
                        TaskPasteHandler.this.setErrorCode(256);
                        TaskPasteHandler taskPasteHandler3 = TaskPasteHandler.this;
                        taskPasteHandler3.sendMessage(taskPasteHandler3.obtainMessage(9));
                        return;
                    }
                    if (!TaskPasteHandler.this.mStorageChecker.checkAvailableStateToAdd(backupPathFromHtml)) {
                        TaskPasteHandler.this.setErrorCode(1024);
                        TaskPasteHandler taskPasteHandler4 = TaskPasteHandler.this;
                        taskPasteHandler4.sendMessage(taskPasteHandler4.obtainMessage(9));
                        return;
                    }
                    C10050c c10050c = new C10050c(TaskPasteHandler.this, 1);
                    if (!ClipboardCacheManager.isPageData(backupPathFromHtml)) {
                        TaskPasteHandler taskPasteHandler5 = TaskPasteHandler.this;
                        Context context2 = TaskPasteHandler.this.mContext;
                        TaskPasteHandler taskPasteHandler6 = TaskPasteHandler.this;
                        taskPasteHandler5.mPasteLogic = new PasteObject(c10050c, context2, taskPasteHandler6, taskPasteHandler6.mComposerModel, TaskPasteHandler.this.mObjectManager, TaskPasteHandler.this.mSpenWNote, backupPathFromHtml, TaskPasteHandler.this.mTargetPageIndex, TaskPasteHandler.this.mPastePosition);
                    } else if (TaskPasteHandler.this.mTextManager.hasFocusedTextBox() && !TaskPasteHandler.this.mTextManager.isSelectedBodyTextBox()) {
                        Logger.m11003i(TaskPasteHandler.TAG, "handleGetContents# Skipped");
                        TaskPasteHandler taskPasteHandler7 = TaskPasteHandler.this;
                        taskPasteHandler7.sendMessage(taskPasteHandler7.obtainMessage(9));
                        return;
                    } else {
                        TaskPasteHandler taskPasteHandler8 = TaskPasteHandler.this;
                        Context context3 = TaskPasteHandler.this.mContext;
                        TaskPasteHandler taskPasteHandler9 = TaskPasteHandler.this;
                        taskPasteHandler8.mPasteLogic = new PastePage(c10050c, context3, taskPasteHandler9, taskPasteHandler9.mComposerModel, TaskPasteHandler.this.mSpenWNote, TaskPasteHandler.this.mNoteManager, TaskPasteHandler.this.mTextManager, TaskPasteHandler.this.mPageManager, backupPathFromHtml, TaskPasteHandler.this.mTargetPageIndex);
                    }
                }
                TaskPasteHandler.this.mPasteLogic.readyContents();
                TaskPasteHandler.this.mPasteLogic.insertSourceSALog();
            }
        });
    }

    private void init(Context context, ClipData clipData, Task.Callback<TaskPaste.ResultValues> callback, ComposerModel composerModel, ObjectManager objectManager, NoteManager noteManager, PageManager pageManager, TextManager textManager, PdfManager pdfManager, int i, PointF pointF, boolean z, WebCardUtil.IDialogManager iDialogManager, boolean z2) {
        this.mContext = context;
        this.mSpenWNote = objectManager.getNote();
        this.mCachePath = objectManager.getCachePath();
        this.mCallback = callback;
        this.mClipData = clipData;
        this.mComposerModel = composerModel;
        this.mObjectManager = objectManager;
        this.mNoteManager = noteManager;
        this.mPageManager = pageManager;
        this.mTextManager = textManager;
        this.mPdfManager = pdfManager;
        this.mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), new SenlThreadFactory(TAG));
        this.mTargetPageIndex = i;
        this.mPastePosition = pointF;
        this.mEnableWebCard = z;
        this.mDialogPresenterManager = iDialogManager;
        this.mPlainTextFlags = z2;
        this.mUpdateInvertBG = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorCode(int i) {
        this.mErrorCode = i | this.mErrorCode;
    }

    public ExecutorService getExecutorService() {
        return this.mExecutorService;
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        String str = TAG;
        Logger.m11003i(str, "TaskPasteHandler#handleMessage, what: " + AbsPasteLogic.messageToString(message.what));
        if (this.mIsReleased) {
            Logger.m11003i(str, "TaskPasteHandler#handleMessage# released");
        }
        switch (message.what) {
            case 2:
                handleGetContents();
                break;
            case 3:
            case 4:
            case 7:
            case 8:
            case 10:
                this.mPasteLogic.handleMessage(message);
                break;
            case 9:
                release();
                break;
        }
    }

    public void release() {
        boolean zIsSkipAiSuggestion;
        String str = TAG;
        Logger.m11003i(str, "release#");
        setReleased(true);
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null) {
            executorService.shutdownNow();
            try {
                this.mExecutorService.awaitTermination(1000L, TimeUnit.MILLISECONDS);
                Logger.m10999d(str, "release# await end");
            } catch (InterruptedException e) {
                Logger.m10999d(TAG, e.getMessage());
            }
            this.mExecutorService = null;
        }
        removeCallbacksAndMessages(null);
        AbsPasteLogic absPasteLogic = this.mPasteLogic;
        if (absPasteLogic != null) {
            this.mUpdateInvertBG = absPasteLogic.isUpdateInvertBG();
            setErrorCode(this.mPasteLogic.getErrorCode(), this.mPasteLogic.getErrorCodeSubType());
            this.mPasteLogic.release();
            zIsSkipAiSuggestion = this.mPasteLogic.isSkipAiSuggestion();
        } else {
            zIsSkipAiSuggestion = false;
        }
        int i = this.mErrorCode;
        if (i != 0) {
            this.mCallback.onError(new TaskPaste.ResultValues(this.mContext, i, this.mErrorCodeSubType, this.mUpdateInvertBG));
        } else {
            this.mCallback.onSuccess(new TaskPaste.ResultValues(this.mContext, i, this.mUpdateInvertBG, zIsSkipAiSuggestion));
        }
        TaskAddPdf taskAddPdf = this.mTaskAddPdf;
        if (taskAddPdf != null) {
            taskAddPdf.clear();
            this.mTaskAddPdf = null;
        }
        this.mObjectManager = null;
        this.mNoteManager = null;
        this.mSpenWNote = null;
        this.mContext = null;
        AbsPasteLogic absPasteLogic2 = this.mPasteLogic;
        if (absPasteLogic2 != null) {
            absPasteLogic2.release();
        }
    }

    public void setReleased(boolean z) {
        this.mIsReleased = z;
        AbsPasteLogic absPasteLogic = this.mPasteLogic;
        if (absPasteLogic != null) {
            absPasteLogic.setReleased(z);
        }
    }

    public void setStorageChecker(StorageChecker storageChecker) {
        this.mStorageChecker = storageChecker;
    }

    private void setErrorCode(int i, int i2) {
        setErrorCode(i);
        this.mErrorCodeSubType = i2;
    }

    public TaskPasteHandler(Context context, ClipData clipData, Task.Callback<TaskPaste.ResultValues> callback, ComposerModel composerModel, ObjectManager objectManager, NoteManager noteManager, PageManager pageManager, TextManager textManager, int i) {
        init(context, clipData, callback, composerModel, objectManager, noteManager, pageManager, textManager, null, i, null, false, null, false);
    }
}
