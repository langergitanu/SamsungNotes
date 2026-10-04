package com.samsung.android.support.senl.p148nt.model.converter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.common.startmanager.ModelStartManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import com.samsung.android.support.senl.p148nt.model.collector.CollectController;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.converter.task.ConvertTask;
import com.samsung.android.support.senl.p148nt.model.converter.task.ConvertTaskGroup;
import com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.ConvertTaskResult;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.ConvertTaskStatus;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.ConvertServiceManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConvertTaskManager {
    private static final long CONVERTING_STATE_UPDATE_INTERVAL = 30000;
    private Handler mHandler;
    private ConvertServiceManager mServiceManager;
    private static final String TAG = ModelLogger.createConverterTag("ConvertTaskManager");
    private static int sReferenceCount = 0;
    private static ConvertTaskManager sInstance = null;
    private ConvertTaskExecutor mExecutor = new ConvertTaskExecutor();
    private Map<Integer, ConvertTaskGroup> mGroupTaskMap = new HashMap();
    private Map<String, ConvertTask> mTaskMap = new HashMap();
    private final Runnable mStatusUpdateRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.model.converter.ConvertTaskManager.1
        @Override // java.lang.Runnable
        public void run() {
            boolean zHasConvertingTask = ConvertTaskManager.this.hasConvertingTask();
            DataLogger.m12302d(ConvertTaskManager.TAG, "SyncStateUpdateCheck#, hasConverting : " + zHasConvertingTask);
            if (!zHasConvertingTask) {
                ConvertTaskManager.this.enableConvertingState(false);
            } else if (ConvertTaskManager.this.mHandler != null) {
                ConvertTaskManager.this.mHandler.postDelayed(this, 30000L);
            }
        }
    };
    private ConvertTaskGroup.IGroupStatusCallback mGroupStatusCallback = new C11253j(this, 9);

    private ConvertTaskManager() {
        DataLogger.m12302d(TAG, "construct : " + hashCode());
    }

    public static synchronized void connect(Context context) {
        sReferenceCount++;
        getInstance().initService(context);
        DataLogger.m12302d(TAG, "connect, reference count : " + sReferenceCount);
    }

    public static synchronized void disconnect() {
        try {
            int i = sReferenceCount - 1;
            sReferenceCount = i;
            ConvertTaskManager convertTaskManager = sInstance;
            if (convertTaskManager != null && i <= 0) {
                sReferenceCount = 0;
                convertTaskManager.release();
                sInstance = null;
            }
            DataLogger.m12302d(TAG, "disconnect, reference count : " + sReferenceCount);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableConvertingState(boolean z) {
        DataLogger.m12302d(TAG, "enableConvertingState, enable : " + z);
        if (z) {
            TaskState.Companion companion = TaskState.INSTANCE;
            if (!companion.getInstance().isRunning("CONVERT")) {
                companion.getInstance().setIsRunning("CONVERT", true);
                return;
            }
        }
        if (z) {
            return;
        }
        TaskState.Companion companion2 = TaskState.INSTANCE;
        if (companion2.getInstance().isRunning("CONVERT")) {
            companion2.getInstance().setIsRunning("CONVERT", false);
            RequestToSyncManager.INSTANCE.requestSyncWithoutCancel();
        }
    }

    public static synchronized ConvertTaskManager getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new ConvertTaskManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean hasConvertingTask() {
        for (ConvertTask convertTask : this.mTaskMap.values()) {
            if (convertTask != null && convertTask.isInProgress()) {
                return true;
            }
        }
        return false;
    }

    private synchronized void initService(Context context) {
        if (this.mServiceManager == null) {
            this.mServiceManager = new ConvertServiceManager(context);
            enableConvertingState(true);
            Handler handler = new Handler(Looper.getMainLooper());
            this.mHandler = handler;
            handler.postDelayed(this.mStatusUpdateRunnable, 30000L);
            DataLogger.m12302d(TAG, "init service");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(int i) {
        synchronized (this) {
            this.mGroupTaskMap.remove(Integer.valueOf(i));
        }
    }

    private void onFailed(ConvertTask convertTask, String str, int i) {
        IConvertTaskCallback externalCallback = convertTask.getCallback().getExternalCallback();
        if (externalCallback != null) {
            externalCallback.onFailed(convertTask.getInfo(), new ConvertTaskResult(convertTask.getInfo().getSrcType(), convertTask.getInfo().getDstType()).setState(i));
            DataLogger.m12307i(TAG, "onFailed#, uuid : " + convertTask.getInfo().getUuid() + ", msg: " + str);
        }
    }

    private synchronized void release() {
        try {
            ConvertServiceManager convertServiceManager = this.mServiceManager;
            if (convertServiceManager != null) {
                convertServiceManager.disconnect();
                this.mServiceManager = null;
            }
            ConvertTaskExecutor convertTaskExecutor = this.mExecutor;
            if (convertTaskExecutor != null) {
                convertTaskExecutor.shutdownAndAwaitTermination();
                this.mExecutor = null;
            }
            this.mGroupTaskMap.clear();
            this.mGroupTaskMap = null;
            this.mTaskMap.clear();
            this.mTaskMap = null;
            this.mGroupStatusCallback = null;
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacks(this.mStatusUpdateRunnable);
                this.mHandler = null;
            }
            enableConvertingState(false);
            startCollector();
            DataLogger.m12302d(TAG, "release");
        } catch (Throwable th) {
            throw th;
        }
    }

    private void removeAllTaskGroupOnMap() {
        this.mGroupTaskMap.clear();
    }

    private void removeTaskGroupOnMap(int i, int i2) {
        ConvertTaskGroup convertTaskGroup = this.mGroupTaskMap.get(Integer.valueOf(i2));
        if (convertTaskGroup == null || convertTaskGroup.getCallerId() != i) {
            return;
        }
        this.mGroupTaskMap.remove(Integer.valueOf(i2));
    }

    private void startCollector() {
        DataLogger.m12302d(TAG, "startCollector");
        CollectController.getInstance().postCollectorTask(new CollectParam.CollectParamBuilder().setActionType(ICollectParam.ActionType.UPDATE_SKIPPED_NOTES_OBJECT_RECOGNITION.getValue()).build());
    }

    private void updateAllTaskMapByCancel() {
        DataLogger.m12307i(TAG, "updateAllTaskMapByCancel");
        Iterator<ConvertTask> it = this.mTaskMap.values().iterator();
        while (it.hasNext()) {
            it.next().getStatus().updateStatus(ConvertTaskStatus.State.CANCELLD);
        }
    }

    private synchronized void updateStatusMap(String str, ConvertTask convertTask) {
        DataLogger.m12307i(TAG, "updateStatusMap, uuid : " + str + ", status : " + convertTask.getStatus().toString());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.mTaskMap.containsKey(str)) {
            this.mTaskMap.put(str, convertTask);
        }
    }

    private void updateTaskMapByCancel(int i, int i2) {
        DataLogger.m12307i(TAG, "updateTaskMapByCancel, groupId : " + i2);
        for (ConvertTask convertTask : this.mTaskMap.values()) {
            if (i == convertTask.getInfo().getCallerId() && i2 == convertTask.getInfo().getGroupId()) {
                convertTask.getStatus().updateStatus(ConvertTaskStatus.State.CANCELLD);
            }
        }
    }

    public synchronized void cancel(int i, int i2) {
        try {
            removeTaskGroupOnMap(i, i2);
            updateTaskMapByCancel(i, i2);
            ConvertTaskExecutor convertTaskExecutor = this.mExecutor;
            if (convertTaskExecutor != null) {
                convertTaskExecutor.cancel(i);
            }
            ConvertServiceManager convertServiceManager = this.mServiceManager;
            if (convertServiceManager != null) {
                convertServiceManager.cancel(i);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void cancelAll() {
        try {
            removeAllTaskGroupOnMap();
            updateAllTaskMapByCancel();
            ConvertTaskExecutor convertTaskExecutor = this.mExecutor;
            if (convertTaskExecutor != null) {
                convertTaskExecutor.cancelAll();
            }
            ConvertServiceManager convertServiceManager = this.mServiceManager;
            if (convertServiceManager != null) {
                convertServiceManager.cancelAll();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean changeTaskCallback(String str, IConvertTaskCallback iConvertTaskCallback) {
        ConvertTask convertTask = this.mTaskMap.get(str);
        if (convertTask == null || !convertTask.isInProgress()) {
            return false;
        }
        convertTask.getCallback().setExternalCallback(iConvertTaskCallback);
        return true;
    }

    public synchronized boolean findConvertTaskGroup(int i, int i2, @Nullable ConvertTaskGroup.IGroupTaskCallback iGroupTaskCallback) {
        ConvertTaskGroup convertTaskGroup = this.mGroupTaskMap.get(Integer.valueOf(i2));
        if (convertTaskGroup == null || convertTaskGroup.getCallerId() != i) {
            return false;
        }
        if (iGroupTaskCallback != null) {
            convertTaskGroup.setExternalCallback(iGroupTaskCallback);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isConverting(String str) {
        boolean z;
        ConvertTask convertTask = this.mTaskMap.get(str);
        if (convertTask != null) {
            z = convertTask.isInProgress();
        }
        return z;
    }

    public synchronized void put(ConvertTask convertTask) {
        if (convertTask != null) {
            if (!convertTask.isEmptyTask()) {
                if (ModelStartManager.INSTANCE.isBlocked()) {
                    onFailed(convertTask, "converting is blocked", 8);
                } else {
                    if (isConverting(convertTask.getInfo().getUuid())) {
                        onFailed(convertTask, "progress in converting", 5);
                        return;
                    }
                    updateStatusMap(convertTask.getInfo().getUuid(), convertTask);
                    convertTask.setRequestor(this.mServiceManager);
                    this.mExecutor.runConvert(convertTask);
                }
            }
        }
    }

    public synchronized void put(ConvertTaskGroup convertTaskGroup) {
        if (convertTaskGroup.getTaskList().isEmpty()) {
            DataLogger.m12307i(TAG, "put, ConvertTaskGroup is empty");
            return;
        }
        this.mGroupTaskMap.put(Integer.valueOf(convertTaskGroup.getId()), convertTaskGroup);
        convertTaskGroup.setStatusCallback(this.mGroupStatusCallback);
        Iterator<ConvertTask> it = convertTaskGroup.getTaskList().iterator();
        while (it.hasNext()) {
            put(it.next());
        }
    }
}
