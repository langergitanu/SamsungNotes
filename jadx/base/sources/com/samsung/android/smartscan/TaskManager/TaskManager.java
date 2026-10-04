package com.samsung.android.smartscan.TaskManager;

import android.util.Log;
import com.samsung.android.smartscan.TaskManager.Tasks.AbstractTask;
import com.samsung.android.smartscan.TaskManager.Tasks.DeinitTask;
import com.samsung.android.smartscan.TaskManager.Tasks.InitTask;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TaskManager {
    private static final String TAG = "SmartScan-TaskManager";
    private AbstractTask.TaskListener taskListener;
    private Deque<AbstractTask> taskDeque = new ArrayDeque();
    private AbstractTask curTask = null;
    private ReentrantLock taskLock = new ReentrantLock();

    public TaskManager(AbstractTask.TaskListener taskListener) {
        this.taskListener = taskListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void executeTaskRecursive() {
        boolean z;
        this.taskLock.lock();
        if (this.curTask != null) {
            Log.d(TAG, "Cur task = " + this.curTask.getType());
        }
        if (this.curTask == null) {
            AbstractTask abstractTaskPollFirst = this.taskDeque.pollFirst();
            this.curTask = abstractTaskPollFirst;
            z = abstractTaskPollFirst != null;
        }
        if ((this.taskDeque.size() == 2) & (this.curTask != null)) {
            AbstractTask first = this.taskDeque.getFirst();
            AbstractTask last = this.taskDeque.getLast();
            Log.d(TAG, "Remove duplicated tasks, CurTaskType = " + this.curTask.getType() + ", FirstQueuedTask = " + first.getType() + ", SecondQueuedTask = " + last.getType());
            int taskNumToRemoveDuplicatedTask = getTaskNumToRemoveDuplicatedTask(this.curTask.getType(), first.getType(), last.getType());
            for (int i = 0; i < taskNumToRemoveDuplicatedTask; i++) {
                Log.d(TAG, "Task removed : " + this.taskDeque.pollFirst().getType());
            }
        }
        this.taskLock.unlock();
        if (z) {
            new Thread(new Runnable() { // from class: com.samsung.android.smartscan.TaskManager.TaskManager.2
                @Override // java.lang.Runnable
                public void run() {
                    TaskManager.this.curTask.executeTask();
                    TaskManager.this.taskLock.lock();
                    TaskManager.this.curTask = null;
                    TaskManager.this.taskLock.unlock();
                    TaskManager.this.executeTaskRecursive();
                }
            }).start();
        }
    }

    private int getTaskNumToRemoveDuplicatedTask(AbstractTask.TaskType taskType, AbstractTask.TaskType taskType2, AbstractTask.TaskType taskType3) {
        return ((taskType != taskType2) & (taskType2 == taskType3)) | ((taskType == taskType2) & (taskType2 != taskType3)) ? 1 : 2;
    }

    public AbstractTask makeTaskByType(AbstractTask.TaskType taskType) {
        if (taskType == AbstractTask.TaskType.Init) {
            return new InitTask();
        }
        if (taskType == AbstractTask.TaskType.Deinit) {
            return new DeinitTask();
        }
        return null;
    }

    public void requestNewTask(AbstractTask.TaskType taskType) {
        AbstractTask abstractTaskMakeTaskByType = makeTaskByType(taskType);
        if (abstractTaskMakeTaskByType != null) {
            abstractTaskMakeTaskByType.setTaskListener(this.taskListener);
            if (abstractTaskMakeTaskByType.getType() != AbstractTask.TaskType.None) {
                Log.d(TAG, "Add task in deque : " + abstractTaskMakeTaskByType.getType());
                this.taskLock.lock();
                this.taskDeque.add(abstractTaskMakeTaskByType);
                this.taskLock.unlock();
            }
            new Thread(new Runnable() { // from class: com.samsung.android.smartscan.TaskManager.TaskManager.1
                @Override // java.lang.Runnable
                public void run() {
                    TaskManager.this.executeTaskRecursive();
                }
            }).start();
        }
    }
}
