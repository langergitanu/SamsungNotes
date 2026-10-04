package com.samsung.android.sdk.scs.base.tasks;

import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
final class TaskStreamingListenersManager<TResult> extends TaskListenersManager<TResult> {
    private static final String TAG = "TaskStreamingListenersManager";

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskListenersManager
    public void processCompletion(@NonNull Task<TResult> task) {
        synchronized (this.mLock) {
            if (this.mQueue != null && !this.mIsProcessingCompletion) {
                this.mIsProcessingCompletion = true;
                Log.m6485d(TAG, "processCompletionStreaming: " + this.mQueue.size());
                Iterator<TaskListenerCompletion<TResult>> it = this.mQueue.iterator();
                while (it.hasNext()) {
                    it.next().onComplete(task);
                }
                this.mIsProcessingCompletion = false;
            }
        }
    }
}
