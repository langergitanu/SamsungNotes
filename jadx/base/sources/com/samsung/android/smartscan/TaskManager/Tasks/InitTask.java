package com.samsung.android.smartscan.TaskManager.Tasks;

import com.samsung.android.smartscan.TaskManager.Tasks.AbstractTask;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class InitTask extends AbstractTask {
    public InitTask() {
        this.taskType = AbstractTask.TaskType.Init;
    }

    @Override // com.samsung.android.smartscan.TaskManager.Tasks.AbstractTask
    public boolean executeTask() {
        AbstractTask.TaskListener taskListener = this.taskListener;
        if (taskListener == null) {
            return true;
        }
        taskListener.onExecuteTask(this.taskType);
        return true;
    }
}
