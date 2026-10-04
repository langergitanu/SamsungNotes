package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareCreatedWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskMakeNotCorruptShareNote extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskMakeNotCorruptShareNote");
    private boolean mIsCanceled;
    private TaskShareBuilder mShareBuilder;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final Context mContext;
        private String mDestPath;
        private ShareData mShareData;
        private TaskMakeContract mTaskMakeContract;
        private SpenWNote mWNote;

        public InputValues(Context context, SpenWNote spenWNote, ShareData shareData, String str, TaskMakeContract taskMakeContract) {
            this.mContext = context;
            this.mWNote = spenWNote;
            this.mShareData = shareData;
            this.mDestPath = str;
            this.mTaskMakeContract = taskMakeContract;
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

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
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
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskMakeNotCorruptShareNote.1
            private void executeTaskShare(ShareWNote shareWNote) {
                TaskMakeNotCorruptShareNote.this.mShareBuilder = inputValues.mTaskMakeContract.getTaskShareBuilder(inputValues.mShareData, shareWNote, inputValues.mDestPath);
                final Task.Callback callback = TaskMakeNotCorruptShareNote.this.mShareBuilder.getCallback();
                TaskMakeNotCorruptShareNote.this.mShareBuilder.executeTask(new Task.Callback<Task.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskMakeNotCorruptShareNote.1.1
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                    public void onError(Task.ResultValues resultValues) {
                        TaskMakeNotCorruptShareNote.this.notifyCallback(false, new ResultValues(callback, resultValues));
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                    public void onSuccess(Task.ResultValues resultValues) {
                        TaskMakeNotCorruptShareNote.this.notifyCallback(true, new ResultValues(callback, resultValues));
                    }
                });
            }

            @Override // java.lang.Runnable
            public void run() {
                ShareWNote shareWNote;
                Logger.m11003i(TaskMakeNotCorruptShareNote.TAG, "executeTask# start");
                if (inputValues.mWNote.hasAllContentFiles()) {
                    shareWNote = new ShareWNote(inputValues.mWNote);
                } else {
                    try {
                        SpenWNote spenWNoteOpen = DocumentFileManager.getInstance().open(inputValues.mContext, inputValues.mShareData.getPath(), inputValues.mWNote.getPageDefaultWidth(), 8500, true, true, UUIDUtils.isCoeditUuid(inputValues.mShareData.getUuid()));
                        DocumentFileManager.getInstance().saveAsDirectory(spenWNoteOpen, inputValues.mShareData.getNewPath());
                        ShareCreatedWNote shareCreatedWNote = new ShareCreatedWNote(spenWNoteOpen, inputValues.mShareData.getPath());
                        inputValues.mShareData.syncPath();
                        shareWNote = shareCreatedWNote;
                    } catch (Exception e) {
                        Logger.m11001e(TaskMakeNotCorruptShareNote.TAG, "new SpenWNote fail e#", e);
                        TaskMakeNotCorruptShareNote.this.notifyCallback(false, new ResultValues());
                        return;
                    }
                }
                if (TaskMakeNotCorruptShareNote.this.mIsCanceled) {
                    TaskMakeNotCorruptShareNote.this.notifyCallback(true, new ResultValues());
                } else {
                    executeTaskShare(shareWNote);
                    Logger.m11003i(TaskMakeNotCorruptShareNote.TAG, "executeTask# end");
                }
            }
        });
    }
}
