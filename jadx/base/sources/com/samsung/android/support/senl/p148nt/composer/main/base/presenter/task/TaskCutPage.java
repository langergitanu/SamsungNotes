package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageCopyData;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskCopyPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskDeletePages;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskCutPage extends SingleThreadTask<InputValues, TaskDeletePages.ResultValues> {
    private static final String TAG = Logger.createTag("TaskCutPage");
    private TaskCopyPage mTaskCopyPage;
    private TaskDeletePages mTaskDeletePages;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues extends TaskDeletePages.ResultValues {
        public ResultValues(PageManager pageManager, NoteManager noteManager, List<Integer> list, List<String> list2, boolean z) {
            super(pageManager, noteManager, list, list2, z);
        }
    }

    private void cutPages(final InputValues inputValues) {
        TaskCopyPage taskCopyPage = new TaskCopyPage();
        this.mTaskCopyPage = taskCopyPage;
        taskCopyPage.setTaskCallback(new Task.Callback<TaskCopyPage.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskCutPage.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskCopyPage.ResultValues resultValues) {
                Logger.m10999d(TaskCutPage.TAG, "onError#copy ");
                TaskCutPage.this.getTaskCallback().onError(new ResultValues(inputValues.getPageManager(), inputValues.getNoteManager(), new ArrayList(), new ArrayList(), inputValues.isNeedToCallEndHistory()));
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskCopyPage.ResultValues resultValues) {
                Logger.m10999d(TaskCutPage.TAG, "onSuccess#copy ");
                TaskCutPage.this.executeTaskDeletePages(inputValues);
            }
        });
        this.mTaskCopyPage.executeTask(new TaskCopyPage.InputValues(inputValues.getContext(), inputValues.getNoteManager(), inputValues.getObjectManager(), inputValues.getDataList()));
    }

    private void cutSinglePage(final InputValues inputValues) {
        TaskCopyPage taskCopyPage = new TaskCopyPage();
        this.mTaskCopyPage = taskCopyPage;
        taskCopyPage.setTaskCallback(new Task.Callback<TaskCopyPage.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskCutPage.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskCopyPage.ResultValues resultValues) {
                TaskCutPage.this.getTaskCallback().onError(new ResultValues(inputValues.getPageManager(), inputValues.getNoteManager(), new ArrayList(), new ArrayList(), inputValues.isNeedToCallEndHistory()));
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskCopyPage.ResultValues resultValues) {
                InputValues inputValues2 = inputValues;
                TaskCutPage.this.getTaskCallback().onSuccess(new ResultValues(inputValues.getPageManager(), inputValues.getNoteManager(), inputValues.getIndexList(), inputValues2.mNoteManager.deletePageList(inputValues2.getIndexList(), true), inputValues.isNeedToCallEndHistory()));
            }
        });
        this.mTaskCopyPage.executeTask((TaskCopyPage.InputValues) inputValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeTaskDeletePages(InputValues inputValues) {
        TaskDeletePages taskDeletePages = new TaskDeletePages();
        this.mTaskDeletePages = taskDeletePages;
        taskDeletePages.setTaskCallback(new Task.Callback<TaskDeletePages.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskCutPage.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskDeletePages.ResultValues resultValues) {
                Logger.m10999d(TaskCutPage.TAG, "onError#delete ");
                TaskCutPage.this.getTaskCallback().onError(resultValues);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskDeletePages.ResultValues resultValues) {
                Logger.m10999d(TaskCutPage.TAG, "onSuccess#delete ");
                TaskCutPage.this.getTaskCallback().onSuccess(resultValues);
            }
        });
        this.mTaskDeletePages.executeTask(new TaskDeletePages.InputValues(inputValues.getPageManager(), inputValues.getNoteManager(), inputValues.getIndexList(), inputValues.isNeedToCallEndHistory()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        this.mTaskCopyPage.clear();
        this.mTaskCopyPage = null;
        TaskDeletePages taskDeletePages = this.mTaskDeletePages;
        if (taskDeletePages != null) {
            taskDeletePages.clear();
            this.mTaskDeletePages = null;
        }
        super.clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToReload() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToSave() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToUpdate() {
        TaskDeletePages taskDeletePages = this.mTaskDeletePages;
        if (taskDeletePages != null) {
            return taskDeletePages.isAvailableToUpdate();
        }
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues extends TaskCopyPage.InputValues {
        private boolean mNeedToCallEndHistory;
        private PageManager mPageManager;

        public InputValues(Context context, NoteManager noteManager, ObjectManager objectManager, PageCopyData pageCopyData, boolean z) {
            super(context, noteManager, objectManager, pageCopyData);
            this.mNeedToCallEndHistory = z;
        }

        public PageManager getPageManager() {
            return this.mPageManager;
        }

        public boolean isNeedToCallEndHistory() {
            return this.mNeedToCallEndHistory;
        }

        public InputValues(Context context, PageManager pageManager, NoteManager noteManager, ObjectManager objectManager, List<PageCopyData> list, boolean z) {
            super(context, noteManager, objectManager, list);
            this.mPageManager = pageManager;
            this.mNeedToCallEndHistory = z;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(InputValues inputValues) {
        if (inputValues.getIndexList().size() > 1) {
            cutPages(inputValues);
        } else {
            cutSinglePage(inputValues);
        }
    }
}
