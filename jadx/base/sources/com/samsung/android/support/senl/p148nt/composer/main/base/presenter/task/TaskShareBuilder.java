package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskShareBuilder {
    private Task.Callback mCallback;
    private Task.InputValues mInputValues;
    private Task mTask;

    public TaskShareBuilder(Task task) {
        this.mTask = task;
    }

    public void cancel(Task.ICancelCallback iCancelCallback) {
        Task task = this.mTask;
        if (task != null) {
            task.cancel(iCancelCallback);
        }
    }

    public void clear() {
        Task task = this.mTask;
        if (task != null) {
            task.clear();
            this.mTask = null;
        }
    }

    public void executeTask(TaskController taskController, boolean z) {
        if (z) {
            taskController.setPendingTask(this.mTask, this.mInputValues, this.mCallback, false);
        } else {
            taskController.execute(this.mTask, this.mInputValues, this.mCallback, false);
        }
    }

    public Task.Callback getCallback() {
        return this.mCallback;
    }

    public Task.InputValues getInputValues() {
        return this.mInputValues;
    }

    public Task getTask() {
        return this.mTask;
    }

    public TaskShareBuilder setCallback(Task.Callback callback) {
        this.mCallback = callback;
        return this;
    }

    public TaskShareBuilder setInputValues(Task.InputValues inputValues) {
        this.mInputValues = inputValues;
        return this;
    }

    public void executeTask(Task.Callback callback) {
        this.mTask.setTaskCallback(callback);
        this.mTask.executeTask(this.mInputValues);
    }
}
