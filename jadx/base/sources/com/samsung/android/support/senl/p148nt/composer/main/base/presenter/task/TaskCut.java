package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller.DynamicTemplateController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskCopy;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskDelete;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskCut extends SingleThreadTask<InputValues, TaskCopy.ResultValues> {
    private static final String TAG = Logger.createTag("TaskCut");
    private TaskCopy mTaskCopy;
    private TaskDelete mTaskDelete;

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        this.mTaskCopy.clear();
        this.mTaskCopy = null;
        TaskDelete taskDelete = this.mTaskDelete;
        if (taskDelete != null) {
            taskDelete.clear();
            this.mTaskDelete = null;
        }
        super.clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToSave() {
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues extends TaskCopy.InputValues {
        DynamicTemplateController dynamicTemplateController;
        TextManager textManager;

        public InputValues(Context context, ObjectManager objectManager, DynamicTemplateController dynamicTemplateController, ArrayList<SpenObjectBase> arrayList) {
            super(context, objectManager, arrayList);
            this.dynamicTemplateController = dynamicTemplateController;
        }

        public InputValues(Context context, ObjectManager objectManager, TextManager textManager, DynamicTemplateController dynamicTemplateController, SpenObjectShape spenObjectShape, int i, int i2) {
            super(context, objectManager, spenObjectShape, i, i2);
            this.textManager = textManager;
            this.dynamicTemplateController = dynamicTemplateController;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        TaskCopy taskCopy = new TaskCopy();
        this.mTaskCopy = taskCopy;
        taskCopy.setTaskCallback(new Task.Callback<TaskCopy.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskCut.1
            private void executeTaskDelete(final TaskCopy.ResultValues resultValues, ObjectManager objectManager, DynamicTemplateController dynamicTemplateController) {
                TaskDelete.InputValues inputValues2 = new TaskDelete.InputValues(objectManager, dynamicTemplateController, objectManager.getSelectedObjectList(), objectManager.getSelectedObjectPageList());
                TaskCut.this.mTaskDelete = new TaskDelete();
                TaskCut.this.mTaskDelete.setTaskCallback(new Task.Callback<TaskDelete.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskCut.1.1
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                    public void onError(TaskDelete.ResultValues resultValues2) {
                        TaskCut.this.getTaskCallback().onError(resultValues);
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                    public void onSuccess(TaskDelete.ResultValues resultValues2) {
                        TaskCut.this.getTaskCallback().onSuccess(resultValues);
                    }
                });
                TaskCut.this.mTaskDelete.executeTask(inputValues2);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskCopy.ResultValues resultValues) {
                TaskCut.this.getTaskCallback().onError(resultValues);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskCopy.ResultValues resultValues) {
                ObjectManager objectManager = inputValues.getObjectManager();
                objectManager.commitHistory();
                if (inputValues.getTextBox() == null) {
                    executeTaskDelete(resultValues, objectManager, inputValues.dynamicTemplateController);
                    return;
                }
                if (objectManager.isSelectedObjectOfObjectSpan() && !objectManager.getSelectedObjectManager().isFocusedTable()) {
                    objectManager.clearSelectObject();
                }
                InputValues inputValues2 = inputValues;
                inputValues2.textManager.removeText(inputValues2.getCursor());
                objectManager.commitHistory();
                TaskCut.this.getTaskCallback().onSuccess(resultValues);
            }
        });
        this.mTaskCopy.executeTask((TaskCopy.InputValues) inputValues);
    }
}
