package com.samsung.android.sdk.scs.base.tasks;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class TaskListenersManager<TResult> {
    protected boolean mIsProcessingCompletion;
    protected final Object mLock = new Object();
    protected Queue<TaskListenerCompletion<TResult>> mQueue;

    public final void add(@NonNull TaskListenerCompletion<TResult> taskListenerCompletion) {
        synchronized (this.mLock) {
            try {
                if (this.mQueue == null) {
                    this.mQueue = new ArrayDeque();
                }
                this.mQueue.add(taskListenerCompletion);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void processCompletion(@NonNull Task<TResult> task) {
        TaskListenerCompletion<TResult> taskListenerCompletionPoll;
        synchronized (this.mLock) {
            if (this.mQueue != null && !this.mIsProcessingCompletion) {
                this.mIsProcessingCompletion = true;
                while (true) {
                    synchronized (this.mLock) {
                        try {
                            taskListenerCompletionPoll = this.mQueue.poll();
                            if (taskListenerCompletionPoll == null) {
                                this.mIsProcessingCompletion = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    taskListenerCompletionPoll.onComplete(task);
                }
            }
        }
    }
}
