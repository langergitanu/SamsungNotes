package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenBoundFileNotFoundException;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareCreatedWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageCopyData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskMakeShareNote extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskMakeShareNote");
    private boolean mIsCanceled;
    private TaskShareBuilder mShareBuilder;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final Context mContext;
        private String mDestPath;
        private NoteManager mNoteManager;
        protected ObjectManager mObjectManager;
        private List<PageCopyData> mPageDataList;
        private ShareData mShareData;
        private TaskMakeContract mTaskMakeContract;
        private TextManager mTextManager;

        public InputValues(Context context, ObjectManager objectManager, TextManager textManager, NoteManager noteManager, ShareData shareData, List<PageCopyData> list, String str, TaskMakeContract taskMakeContract) {
            this.mContext = context;
            this.mObjectManager = objectManager;
            this.mTextManager = textManager;
            this.mNoteManager = noteManager;
            this.mShareData = shareData;
            this.mDestPath = str;
            this.mTaskMakeContract = taskMakeContract;
            this.mPageDataList = new ArrayList(list);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private Task.Callback mCallback;
        private Task.ResultValues mResultValues;

        public ResultValues() {
        }

        public Task.Callback getCallback() {
            return this.mCallback;
        }

        public Task.ResultValues getResultValues() {
            return this.mResultValues;
        }

        public ResultValues(Task.Callback callback, Task.ResultValues resultValues) {
            this.mCallback = callback;
            this.mResultValues = resultValues;
        }
    }

    private void appendLastPage(SpenWNote spenWNote, NoteManager noteManager) {
        SpenWPage page = spenWNote.getPage(Math.max(spenWNote.getPageCount() - 1, 0));
        noteManager.copyBackground(page, spenWNote.appendPage(page.getWidth(), page.getHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean copyPage(Context context, SpenWNote spenWNote, SpenWNote spenWNote2, List<PageCopyData> list, ISpenNoteTextManager iSpenNoteTextManager, NoteManager noteManager) {
        spenWNote2.getBodyText().setMargin(spenWNote.getBodyText().getLeftMargin(), spenWNote.getBodyText().getTopMargin(), spenWNote.getBodyText().getRightMargin(), spenWNote.getBodyText().getBottomMargin());
        try {
            int textSizeDelta = iSpenNoteTextManager.getTextSizeDelta();
            spenWNote2.setBodyTextFontSizeDelta(textSizeDelta);
            SpenBodyTextContext spenBodyTextContext = new SpenBodyTextContext(context);
            spenBodyTextContext.setDocument(spenWNote2);
            spenBodyTextContext.lockBodyTextPage();
            for (PageCopyData pageCopyData : list) {
                if (this.mIsCanceled) {
                    Logger.m10999d(TAG, "copyPage# cancel");
                    spenBodyTextContext.unlockBodyTextPage();
                    spenBodyTextContext.close();
                    spenWNote2.close(true);
                    return false;
                }
                spenWNote2.copyPage(spenWNote.getPage(pageCopyData.getIndex()), spenWNote2.getPageCount());
                SpenObjectTextBox spenObjectTextBoxCopyBodyTextFrom = iSpenNoteTextManager.copyBodyTextFrom(pageCopyData.getIndex());
                if (spenObjectTextBoxCopyBodyTextFrom == null || TextUtils.isEmpty(spenObjectTextBoxCopyBodyTextFrom.getText())) {
                    spenBodyTextContext.insertEmptyBodyTextTo(spenWNote2.getPageCount() - 1);
                } else {
                    spenBodyTextContext.insertBodyTextTo(spenWNote2.getPageCount() - 1, spenObjectTextBoxCopyBodyTextFrom, textSizeDelta);
                }
            }
            spenBodyTextContext.unlockBodyTextPage();
            spenBodyTextContext.close();
            appendLastPage(spenWNote2, noteManager);
            Logger.m11003i(TAG, "copyPage# page count:" + spenWNote2.getPageCount());
            return true;
        } catch (SpenBoundFileNotFoundException e) {
            e = e;
            AbstractC8014b.m7207i("copyPage# e :", e, TAG);
            return false;
        } catch (IllegalArgumentException e2) {
            e = e2;
            AbstractC8014b.m7207i("copyPage# e :", e, TAG);
            return false;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        super.cancel(iCancelCallback);
        Logger.m10999d(TAG, "cancel#");
        TaskShareBuilder taskShareBuilder = this.mShareBuilder;
        if (taskShareBuilder != null) {
            taskShareBuilder.cancel(iCancelCallback);
            this.mShareBuilder.clear();
            this.mShareBuilder = null;
        }
        this.mIsCanceled = true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        cancel(null);
        super.clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isKeepTaskDuringActivityRecreation() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        inputValues.mObjectManager.getSelectedObjectManager().clearSelectedTextTypeObject();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskMakeShareNote.1
            private void closeDoc(SpenWNote spenWNote, String str) {
                try {
                    DocumentFileManager.getInstance().close(str, spenWNote, true);
                } catch (IOException e) {
                    Logger.m11001e(TaskMakeShareNote.TAG, "executeTask# close SpenWNote fail e : ", e);
                }
            }

            private void executeTaskShare(SpenWNote spenWNote) {
                inputValues.mShareData.syncPath();
                TaskMakeShareNote.this.mShareBuilder = inputValues.mTaskMakeContract.getTaskShareBuilder(inputValues.mShareData, new ShareCreatedWNote(spenWNote, null), inputValues.mDestPath);
                final Task.Callback callback = TaskMakeShareNote.this.mShareBuilder.getCallback();
                TaskMakeShareNote.this.mShareBuilder.executeTask(new Task.Callback<Task.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskMakeShareNote.1.1
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                    public void onError(Task.ResultValues resultValues) {
                        TaskMakeShareNote.this.notifyCallback(false, new ResultValues(callback, resultValues));
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                    public void onSuccess(Task.ResultValues resultValues) {
                        TaskMakeShareNote.this.notifyCallback(true, new ResultValues(callback, resultValues));
                    }
                });
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                SpenWNote spenWNote;
                Logger.m11003i(TaskMakeShareNote.TAG, "executeTask# start");
                String path = inputValues.mShareData.getPath();
                SpenWNote note = inputValues.mObjectManager.getNote();
                SpenWNote spenWNote2 = null;
                try {
                    if (note.hasAllContentFiles()) {
                        z = false;
                    } else {
                        note = DocumentFileManager.getInstance().open(inputValues.mContext, path, note.getPageDefaultWidth(), 8500, true, true, UUIDUtils.isCoeditUuid(inputValues.mShareData.getUuid()));
                        DocumentFileManager.getInstance().saveAsDirectory(note, inputValues.mShareData.getNewPath());
                        z = true;
                    }
                    SpenWNote spenWNote3 = note;
                    try {
                        Context context = inputValues.mContext;
                        spenWNote = new SpenWNote(context, null, SpenWNote.PageMode.LIST, spenWNote3.getOrientation(), spenWNote3.getPageDefaultWidth(), false);
                        try {
                            spenWNote.setPageDefaultHeight(spenWNote3.getPageDefaultHeight());
                            spenWNote.invertBackgroundColor(spenWNote3.isBackgroundColorInverted());
                            try {
                                boolean zCopyPage = TaskMakeShareNote.this.copyPage(context, spenWNote3, spenWNote, inputValues.mPageDataList, inputValues.mTextManager.getSpenNoteTextManager(), inputValues.mNoteManager);
                                note = spenWNote3;
                                spenWNote = spenWNote;
                                if (z) {
                                    try {
                                        closeDoc(note, path);
                                    } catch (Exception e) {
                                        e = e;
                                        spenWNote2 = spenWNote;
                                        Logger.m11001e(TaskMakeShareNote.TAG, "executeTask# copyPage:", e);
                                        if (z) {
                                            closeDoc(note, path);
                                        }
                                        spenWNote = spenWNote2;
                                    }
                                }
                                if (!TaskMakeShareNote.this.mIsCanceled && zCopyPage) {
                                    DocumentFileManager.getInstance().saveAsDirectory(spenWNote, inputValues.mShareData.getNewPath());
                                    executeTaskShare(spenWNote);
                                    return;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                note = spenWNote3;
                                spenWNote = spenWNote;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            note = spenWNote3;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        note = spenWNote3;
                    }
                } catch (Exception e6) {
                    e = e6;
                    z = false;
                }
                if (spenWNote != null) {
                    try {
                        if (!spenWNote.isClosed()) {
                            spenWNote.close(true);
                        }
                    } catch (IOException e7) {
                        Logger.m11001e(TaskMakeShareNote.TAG, "executeTask# close dstNote fail e : ", e7);
                    }
                }
                TaskMakeShareNote.this.notifyCallback(false, new ResultValues());
                Logger.m11003i(TaskMakeShareNote.TAG, "executeTask# end");
            }
        });
    }
}
