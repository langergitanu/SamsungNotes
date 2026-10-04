package com.samsung.android.support.senl.p148nt.model.executor.scheduler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DocumentThreadPoolManager implements SchedulerDataSource, SchedulerDataSource.OnWorkingStateListener {
    private static final String TAG = ModelLogger.createTag("DocumentThreadPoolManager");
    private static final int THREAD_POOL_COUNT = 1;
    private static DocumentThreadPoolManager sInstance;
    private SchedulerDataSource.OnWorkingStateListener mOnWorkingStateListener;
    private final Map<String, NotesDocumentThreadPool> mExecutorService = new ConcurrentHashMap();
    private final Map<String, BlockingQueue<Runnable>> mQueues = new ConcurrentHashMap();
    private final Object mStateMutex = new Object();
    private SchedulerDataSource.WorkingState mCurrentState = SchedulerDataSource.WorkingState.IDLE;

    private DocumentThreadPoolManager() {
    }

    private void clearAllQueues(@NonNull Map<String, BlockingQueue<Runnable>> map) {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            try {
                clearQueue(it.next());
            } catch (NullPointerException unused) {
            }
        }
    }

    private synchronized SchedulerDataSource.WorkingState getCurrentState(@NonNull String str) {
        NotesDocumentThreadPool notesDocumentThreadPool;
        try {
            notesDocumentThreadPool = this.mExecutorService.get(str);
        } catch (Throwable th) {
            throw th;
        }
        return notesDocumentThreadPool != null ? notesDocumentThreadPool.getCurrentState() : SchedulerDataSource.WorkingState.UNDEFINED;
    }

    public static synchronized DocumentThreadPoolManager getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new DocumentThreadPoolManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    private void notifyOnWorkingStateListener(@Nullable ThreadPoolExecutor threadPoolExecutor, @NonNull String str, @NonNull SchedulerDataSource.WorkingState workingState, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        DataLogger.m12309w(TAG, "notifyOnWorkingStateListener");
        SchedulerDataSource.OnWorkingStateListener onWorkingStateListener = this.mOnWorkingStateListener;
        if (onWorkingStateListener != null) {
            onWorkingStateListener.onState(threadPoolExecutor, str, workingState, documentSubscriptionId);
        }
    }

    private void shutdownNowAll(@NonNull Map<String, ThreadPoolExecutor> map) {
        DataLogger.m12309w(TAG, "shutdownNowAll");
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            try {
                shutdownExecutorService(it.next());
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource
    public boolean awaitTerminationAll(long j, TimeUnit timeUnit) {
        ArrayList<ExecutorService> arrayList;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jConvert = TimeUnit.MILLISECONDS.convert(j, timeUnit);
        DataLogger.m12309w(TAG, "awaitTermination, timeout : " + timeUnit + ", timeoutMillis : " + jConvert + ", currentTime : " + jCurrentTimeMillis);
        synchronized (this) {
            arrayList = new ArrayList(this.mExecutorService.values());
        }
        for (ExecutorService executorService : arrayList) {
            executorService.shutdown();
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            long j2 = jConvert - jCurrentTimeMillis2;
            if (!executorService.awaitTermination(j2, TimeUnit.MILLISECONDS)) {
                String str = TAG;
                StringBuilder sbM1323p = AbstractC1974b.m1323p(j2, "awaitTermination, there are tasks running :  remains : ", ", uptimeMillis : ");
                sbM1323p.append(jCurrentTimeMillis2);
                DataLogger.m12303e(str, sbM1323p.toString());
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource
    public void clearQueue(@NonNull String str) {
        BlockingQueue<Runnable> blockingQueueRemove;
        if (!this.mQueues.containsKey(str) || (blockingQueueRemove = this.mQueues.remove(str)) == null) {
            return;
        }
        blockingQueueRemove.clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource
    public void close() {
        HashMap map;
        synchronized (this) {
            map = new HashMap(this.mExecutorService);
            this.mExecutorService.clear();
        }
        shutdownNowAll(map);
        clearAllQueues(new HashMap(this.mQueues));
        this.mQueues.clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource
    public synchronized boolean existExecutorService(@NonNull String str) {
        DataLogger.m12307i(TAG, "existExecutorService, uuid : " + str);
        return this.mExecutorService.containsKey(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource
    @NonNull
    public synchronized NotesDocumentThreadPool getExecutorService(@NonNull String str) {
        NotesDocumentThreadPool notesDocumentThreadPoolOnCreateThreadPool;
        DataLogger.m12307i(TAG, "getExecutorService, uuid : " + str);
        notesDocumentThreadPoolOnCreateThreadPool = this.mExecutorService.get(str);
        if (notesDocumentThreadPoolOnCreateThreadPool == null) {
            notesDocumentThreadPoolOnCreateThreadPool = onCreateThreadPool(str);
            notesDocumentThreadPoolOnCreateThreadPool.setOnWorkingStateListener(this);
            this.mExecutorService.put(str, notesDocumentThreadPoolOnCreateThreadPool);
        }
        return notesDocumentThreadPoolOnCreateThreadPool;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource
    @NonNull
    public BlockingQueue<Runnable> getQueue(@NonNull String str) {
        AbstractC0000a.m2C("getQueue, uuid : ", str, TAG);
        BlockingQueue<Runnable> blockingQueue = this.mQueues.get(str);
        if (blockingQueue != null) {
            return blockingQueue;
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.mQueues.put(str, linkedBlockingQueue);
        return linkedBlockingQueue;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource
    public synchronized boolean isIdle() {
        Iterator<NotesDocumentThreadPool> it = this.mExecutorService.values().iterator();
        while (it.hasNext()) {
            int activeCount = it.next().getActiveCount();
            if (activeCount > 0) {
                DataLogger.m12309w(TAG, "isIdle, active count : " + activeCount);
                return false;
            }
        }
        return true;
    }

    public boolean isSaving(@NonNull String str) {
        SchedulerDataSource.WorkingState currentState = getCurrentState(str);
        return currentState == SchedulerDataSource.WorkingState.SAVING || currentState == SchedulerDataSource.WorkingState.SAVING_CACHE || currentState == SchedulerDataSource.WorkingState.SNAP_SAVE;
    }

    @NonNull
    public NotesDocumentThreadPool onCreateThreadPool(@NonNull String str) {
        DataLogger.m12307i(TAG, "onCreateThreadPool, uuid : " + str + ", poolSize : 1");
        return new NotesDocumentThreadPool(1, 1, 0L, TimeUnit.MILLISECONDS, getQueue(str));
    }

    @Override // com.samsung.android.support.senl.nt.model.executor.scheduler.SchedulerDataSource.OnWorkingStateListener
    public void onState(@Nullable ThreadPoolExecutor threadPoolExecutor, @NonNull String str, @NonNull SchedulerDataSource.WorkingState workingState, @NonNull DocumentSubscriptionId documentSubscriptionId) {
        synchronized (this.mStateMutex) {
            DataLogger.m12309w(TAG, "onState, uuid : " + str + ", state : " + workingState + ", threadPool : " + threadPoolExecutor + ", owner : " + documentSubscriptionId);
            this.mCurrentState = workingState;
            notifyOnWorkingStateListener(threadPoolExecutor, str, workingState, documentSubscriptionId);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource
    @NonNull
    public synchronized NotesDocumentThreadPool replaceExecutorService(String str) {
        try {
            DataLogger.m12307i(TAG, "replaceExecutorService, uuid : " + str);
            NotesDocumentThreadPool notesDocumentThreadPoolRemove = this.mExecutorService.remove(str);
            if (notesDocumentThreadPoolRemove != null) {
                notesDocumentThreadPoolRemove.setOnWorkingStateListener(null);
            }
        } catch (Throwable th) {
            throw th;
        }
        return getExecutorService(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource
    public void setOnWorkingStateListener(@Nullable SchedulerDataSource.OnWorkingStateListener onWorkingStateListener) {
        DataLogger.m12309w(TAG, "setOnWorkingStateListener, listener : " + onWorkingStateListener);
        this.mOnWorkingStateListener = onWorkingStateListener;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource
    public synchronized void shutdownExecutorService(@NonNull String str) {
        try {
            DataLogger.m12309w(TAG, "shutdownExecutorService, uuid : " + str);
            NotesDocumentThreadPool notesDocumentThreadPoolRemove = this.mExecutorService.remove(str);
            if (notesDocumentThreadPoolRemove != null) {
                notesDocumentThreadPoolRemove.setOnWorkingStateListener(null);
                notesDocumentThreadPoolRemove.shutdownNow();
            }
            BlockingQueue<Runnable> blockingQueueRemove = this.mQueues.remove(str);
            if (blockingQueueRemove != null) {
                blockingQueueRemove.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @NonNull
    public String toString() {
        return "DocumentThreadPoolManager{mExecutorService=" + this.mExecutorService + ", mQueue=" + this.mQueues + ", mCurrentState=" + this.mCurrentState + '}';
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource
    public SchedulerDataSource.WorkingState getCurrentState() {
        SchedulerDataSource.WorkingState workingState;
        synchronized (this.mStateMutex) {
            DataLogger.m12309w(TAG, "getCurrentState, state : " + this.mCurrentState);
            workingState = this.mCurrentState;
        }
        return workingState;
    }
}
