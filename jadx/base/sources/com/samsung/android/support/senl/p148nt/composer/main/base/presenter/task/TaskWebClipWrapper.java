package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ScrollController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskWebClip;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.common.TaskContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskWebClipWrapper extends SingleThreadTask<InputValues, TaskWebClip.ResultValues> {
    private static final String TAG = Logger.createTag("TaskWebClipWrapper");
    private TaskWebClip mTaskWebClip;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues extends TaskWebClip.InputValues {
        public InputValues(Context context, NoteManager noteManager, PdfManager pdfManager, PageManager pageManager, TextManager textManager, final ScrollController scrollController, String str, boolean z, ObjectManager objectManager, ComposerModel composerModel) {
            super(context, noteManager, pdfManager, pageManager, textManager, new TaskContract.IPageScroller() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskWebClipWrapper.InputValues.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.common.TaskContract.IPageScroller
                public void goToPage(int i) {
                    scrollController.goToPage(i);
                }
            }, str, z, objectManager, composerModel);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        this.mTaskWebClip.cancel(iCancelCallback);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        this.mTaskWebClip.clear();
        this.mTaskWebClip = null;
        super.clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToSave() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isKeepTaskDuringActivityRecreation() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskWebClipWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.m11003i(TaskWebClipWrapper.TAG, "executeTask# start");
                TaskWebClipWrapper.this.mTaskWebClip = new TaskWebClip();
                TaskWebClipWrapper.this.mTaskWebClip.setTaskCallback(new Task.Callback<TaskWebClip.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskWebClipWrapper.1.1
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                    public void onError(TaskWebClip.ResultValues resultValues) {
                        TaskWebClipWrapper.this.getTaskCallback().onError(resultValues);
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                    public void onSuccess(TaskWebClip.ResultValues resultValues) {
                        TaskWebClipWrapper.this.getTaskCallback().onSuccess(resultValues);
                    }
                });
                TaskWebClipWrapper.this.mTaskWebClip.setInputValue(inputValues);
                TaskWebClipWrapper.this.mTaskWebClip.setStorageChecker(TaskWebClipWrapper.this.mStorageChecker);
                TaskWebClipWrapper.this.mTaskWebClip.setTimeStart(System.currentTimeMillis());
                TaskWebClipWrapper.this.mTaskWebClip.executeTask((TaskWebClip.InputValues) inputValues);
                Logger.m11003i(TaskWebClipWrapper.TAG, "executeTask# end");
            }
        });
    }
}
