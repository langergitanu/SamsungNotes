package com.samsung.android.smartscan.TaskManager.Tasks;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractTask {
    protected TaskType taskType = TaskType.None;
    protected TaskListener taskListener = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TaskListener {
        void onExecuteTask(TaskType taskType);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TaskType {
        None,
        Init,
        Deinit
    }

    public boolean executeTask() {
        TaskListener taskListener = this.taskListener;
        if (taskListener == null) {
            return true;
        }
        taskListener.onExecuteTask(this.taskType);
        return true;
    }

    public TaskType getType() {
        return this.taskType;
    }

    public void setTaskListener(TaskListener taskListener) {
        this.taskListener = taskListener;
    }
}
