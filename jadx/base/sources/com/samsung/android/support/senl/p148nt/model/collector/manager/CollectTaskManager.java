package com.samsung.android.support.senl.p148nt.model.collector.manager;

import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.jobscheduler.INoteJob;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.collector.CollectController;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectInfo;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectResolver;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectThreadPoolExecutor;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.manager.task.AbsCollectTask;
import com.samsung.android.support.senl.p148nt.model.collector.manager.task.NoteCollectTask;
import com.samsung.android.support.senl.p148nt.model.collector.manager.task.PdfCollectTask;
import com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectStateListener;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import com.samsung.android.support.senl.p148nt.model.executor.task.utils.DocumentExtraDataUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CollectTaskManager implements ICollectStateListener {
    private static final int BLOCKING_QUEUE_CAPACITY = 100;
    private static final int CORE_POOL_SIZE = 1;
    private static final int MAX_POOL_SIZE = 1;
    private static final int MAX_SB_LOG_SIZE = 10000;
    private static final String TAG = CollectLogger.createTag("CollectTaskManager");
    private static CollectTaskManager sInstance;
    private final HashMap<String, Class<?>> mPausedPdfMap = new HashMap<>();
    private final HashMap<String, CollectParam> mCollectParamMap = new HashMap<>();
    private final CollectThreadPoolExecutor mPriorityNoteThreadPoolExecutor = new CollectThreadPoolExecutor(1, 1, new PriorityBlockingQueue(100));
    private final CollectThreadPoolExecutor mNoteThreadPoolExecutor = new CollectThreadPoolExecutor(1, 1, new PriorityBlockingQueue(100));
    private final CollectThreadPoolExecutor mPdfThreadPoolExecutor = new CollectThreadPoolExecutor(1, 1, new PriorityBlockingQueue(100));

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CancelContext {
        private final CancelStrategy mStrategy;

        public CancelContext(CancelStrategy cancelStrategy) {
            this.mStrategy = cancelStrategy;
        }

        public boolean cancelActiveTask() {
            return this.mStrategy.cancelActiveTask();
        }

        public boolean isCancelable(CollectParam collectParam, AbsCollectTask absCollectTask) {
            return this.mStrategy.isCancelable(collectParam, absCollectTask);
        }

        public boolean isDeleted() {
            return this.mStrategy.isDeleted();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CancelDeletedNoteStrategy implements CancelStrategy {
        public /* synthetic */ CancelDeletedNoteStrategy(int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.nt.model.collector.manager.CollectTaskManager.CancelStrategy
        public boolean cancelActiveTask() {
            return true;
        }

        @Override // com.samsung.android.support.senl.nt.model.collector.manager.CollectTaskManager.CancelStrategy
        public boolean isCancelable(CollectParam collectParam, AbsCollectTask absCollectTask) {
            return absCollectTask != null && collectParam.getUuid().equals(absCollectTask.getUuid());
        }

        @Override // com.samsung.android.support.senl.nt.model.collector.manager.CollectTaskManager.CancelStrategy
        public boolean isDeleted() {
            return true;
        }

        private CancelDeletedNoteStrategy() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CancelSpecificNoteStrategy implements CancelStrategy {
        public /* synthetic */ CancelSpecificNoteStrategy(int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.nt.model.collector.manager.CollectTaskManager.CancelStrategy
        public boolean cancelActiveTask() {
            return true;
        }

        @Override // com.samsung.android.support.senl.nt.model.collector.manager.CollectTaskManager.CancelStrategy
        public boolean isCancelable(CollectParam collectParam, AbsCollectTask absCollectTask) {
            return absCollectTask != null && collectParam.getUuid().equals(absCollectTask.getUuid()) && collectParam.getCancelType() == absCollectTask.getTriggerType();
        }

        @Override // com.samsung.android.support.senl.nt.model.collector.manager.CollectTaskManager.CancelStrategy
        public boolean isDeleted() {
            return false;
        }

        private CancelSpecificNoteStrategy() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CancelSpecificTriggerStrategy implements CancelStrategy {
        public /* synthetic */ CancelSpecificTriggerStrategy(int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.nt.model.collector.manager.CollectTaskManager.CancelStrategy
        public boolean cancelActiveTask() {
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.model.collector.manager.CollectTaskManager.CancelStrategy
        public boolean isCancelable(CollectParam collectParam, AbsCollectTask absCollectTask) {
            return absCollectTask != null && collectParam.getCancelType() == absCollectTask.getTriggerType();
        }

        @Override // com.samsung.android.support.senl.nt.model.collector.manager.CollectTaskManager.CancelStrategy
        public boolean isDeleted() {
            return false;
        }

        private CancelSpecificTriggerStrategy() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CancelStrategy {
        boolean cancelActiveTask();

        boolean isCancelable(CollectParam collectParam, AbsCollectTask absCollectTask);

        boolean isDeleted();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum PdfState {
        PAUSE,
        RESUME
    }

    private CollectTaskManager() {
    }

    private void addPausedPdf(CollectParam collectParam) {
        dumpPausedPdfMap();
        this.mPausedPdfMap.put(collectParam.getPdfActionKey(), collectParam.getPdfActionCaller());
    }

    private void cancelPriorityNoteCollect(CollectParam collectParam) {
        String uuid = collectParam.getUuid();
        if (TextUtils.isEmpty(uuid)) {
            DataLogger.m12307i(TAG, "cancelPriorityNoteCollect uuid is empty !!!");
            return;
        }
        StringBuilder sb = new StringBuilder();
        synchronized (this) {
            this.mPriorityNoteThreadPoolExecutor.cancelAndRemoveTask(uuid, sb);
            this.mNoteThreadPoolExecutor.cancelAndRemoveTask(uuid, sb);
        }
        DataLogger.m12307i(TAG, "cancelPriorityNoteCollect : " + ((Object) sb));
    }

    private void dumpPausedPdfMap() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Class<?>> entry : this.mPausedPdfMap.entrySet()) {
            if (entry != null && entry.getValue() != null && sb.length() < 10000) {
                sb.append(entry.getKey());
                sb.append(SQLKeyword.COMMA);
                sb.append(entry.getValue().getSimpleName());
                sb.append('\n');
            }
        }
        DataLogger.m12307i(TAG, "dumpPdfStateMap : " + ((Object) sb));
    }

    public static synchronized CollectTaskManager getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new CollectTaskManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    private PdfState getPdfState() {
        return this.mPausedPdfMap.isEmpty() ? PdfState.RESUME : PdfState.PAUSE;
    }

    private boolean needToSkipRunNoteCollect(CollectParam collectParam) {
        String uuid = collectParam.getUuid();
        boolean z = false;
        if (collectParam.getTriggerType() == ICollectParam.TriggerType.UPDATE.getValue() && !TextUtils.isEmpty(uuid)) {
            synchronized (this) {
                try {
                    Iterator<Runnable> it = this.mNoteThreadPoolExecutor.getActiveTasks().iterator();
                    while (it.hasNext()) {
                        NoteCollectTask noteCollectTask = (NoteCollectTask) it.next();
                        if (noteCollectTask != null && uuid.equals(noteCollectTask.getUuid())) {
                            z = true;
                        }
                    }
                    Iterator<Runnable> it2 = this.mNoteThreadPoolExecutor.getQueue().iterator();
                    while (it2.hasNext()) {
                        NoteCollectTask noteCollectTask2 = (NoteCollectTask) it2.next();
                        if (noteCollectTask2 != null && uuid.equals(noteCollectTask2.getUuid())) {
                            z = true;
                        }
                    }
                    Iterator<Runnable> it3 = this.mNoteThreadPoolExecutor.getPausedTasks().iterator();
                    while (it3.hasNext()) {
                        NoteCollectTask noteCollectTask3 = (NoteCollectTask) it3.next();
                        if (noteCollectTask3 != null && uuid.equals(noteCollectTask3.getUuid())) {
                            z = true;
                        }
                    }
                } finally {
                }
            }
        }
        DataLogger.m12307i(TAG, "needToSkipRunNoteCollect uuid/result " + uuid + "/" + z);
        return z;
    }

    private boolean needToSkipRunPdfCollect(CollectParam collectParam) {
        String uuid = collectParam.getUuid();
        boolean z = false;
        if (collectParam.getTriggerType() == ICollectParam.TriggerType.UPDATE.getValue() && !TextUtils.isEmpty(uuid)) {
            synchronized (this) {
                try {
                    Iterator<Runnable> it = this.mPdfThreadPoolExecutor.getActiveTasks().iterator();
                    while (it.hasNext()) {
                        PdfCollectTask pdfCollectTask = (PdfCollectTask) it.next();
                        if (pdfCollectTask != null && uuid.equals(pdfCollectTask.getUuid())) {
                            z = true;
                        }
                    }
                    Iterator<Runnable> it2 = this.mPdfThreadPoolExecutor.getQueue().iterator();
                    while (it2.hasNext()) {
                        PdfCollectTask pdfCollectTask2 = (PdfCollectTask) it2.next();
                        if (pdfCollectTask2 != null && uuid.equals(pdfCollectTask2.getUuid())) {
                            z = true;
                        }
                    }
                    Iterator<Runnable> it3 = this.mPdfThreadPoolExecutor.getPausedTasks().iterator();
                    while (it3.hasNext()) {
                        PdfCollectTask pdfCollectTask3 = (PdfCollectTask) it3.next();
                        if (pdfCollectTask3 != null && uuid.equals(pdfCollectTask3.getUuid())) {
                            z = true;
                        }
                    }
                } finally {
                }
            }
        }
        DataLogger.m12307i(TAG, "needToSkipRunPdfCollect uuid/result " + uuid + "/" + z);
        return z;
    }

    private void notifyCollectFinished() {
        if (ServiceManager.INSTANCE.getInstance().canWorkOnBackground()) {
            return;
        }
        DataLogger.m12307i(TAG, "notifyCollectFinished#");
        CollectParam.CollectParamBuilder collectParamBuilder = new CollectParam.CollectParamBuilder();
        collectParamBuilder.setActionType(ICollectParam.ActionType.FINISH.getValue());
        CollectController.getInstance().postCollectorTask(collectParamBuilder.build());
    }

    private void removePausedPdf(CollectParam collectParam) {
        dumpPausedPdfMap();
        this.mPausedPdfMap.remove(collectParam.getPdfActionKey());
    }

    private void removePausedPdfCollect(CollectParam collectParam) {
        synchronized (this) {
            try {
                String uuid = collectParam.getUuid();
                PdfCollectTask pdfCollectTask = (PdfCollectTask) this.mPdfThreadPoolExecutor.getContainsPausedTasks(uuid);
                if (pdfCollectTask != null) {
                    boolean zRemove = this.mPdfThreadPoolExecutor.getPausedTasks().remove(pdfCollectTask);
                    this.mCollectParamMap.remove(uuid);
                    DataLogger.m12307i(TAG, "removePausedPdfCollect uuid/removed : " + uuid + " / " + zRemove);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void runNoteCollect(CollectParam collectParam) {
        synchronized (this) {
            try {
                if (needToSkipRunNoteCollect(collectParam)) {
                    return;
                }
                this.mNoteThreadPoolExecutor.execute(new NoteCollectTask(collectParam, this));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void runPdfCollect(CollectParam collectParam) {
        synchronized (this) {
            try {
                String str = TAG;
                DataLogger.m12307i(str, "runPdfCollect uuid/pdfState " + collectParam.getUuid() + "/" + getPdfState());
                if (needToSkipRunPdfCollect(collectParam)) {
                    DataLogger.m12307i(str, "runPdfCollect skipped");
                    return;
                }
                if (getPdfState() == PdfState.PAUSE) {
                    this.mPdfThreadPoolExecutor.addPausedTask(new PdfCollectTask(collectParam, this));
                } else {
                    this.mPdfThreadPoolExecutor.execute(new PdfCollectTask(collectParam, this));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void runPriorityNoteCollect(CollectParam collectParam) {
        synchronized (this) {
            DataLogger.m12307i(TAG, "runPriorityNoteCollect, uuid " + collectParam.getUuid());
            cancelPriorityNoteCollect(collectParam);
            this.mPriorityNoteThreadPoolExecutor.execute(new NoteCollectTask(collectParam, this));
        }
    }

    private void setNoteJobFinished(CollectParam collectParam) {
        INoteJob.INoteJobFinishCallback noteJobFinishCallback = collectParam.getNoteJobFinishCallback();
        if (!this.mCollectParamMap.isEmpty() || noteJobFinishCallback == null) {
            return;
        }
        noteJobFinishCallback.onFinishJob();
    }

    public void cancelCollect(CollectParam collectParam) {
        CancelStrategy cancelSpecificTriggerStrategy;
        String uuid = collectParam.getUuid();
        int cancelType = collectParam.getCancelType();
        int i = 0;
        if (cancelType == ICollectParam.CancelType.SAVE.getValue()) {
            if (TextUtils.isEmpty(uuid)) {
                DataLogger.m12309w(TAG, "cancelCollect uuid is empty !!!");
                return;
            }
            cancelSpecificTriggerStrategy = new CancelSpecificNoteStrategy(i);
        } else if (cancelType != ICollectParam.CancelType.DELETE.getValue()) {
            cancelSpecificTriggerStrategy = new CancelSpecificTriggerStrategy(i);
        } else {
            if (TextUtils.isEmpty(uuid)) {
                DataLogger.m12309w(TAG, "cancelCollect uuid is empty !!!");
                return;
            }
            DataLogger.m12309w(TAG, "cancelCollect, deleted, uuid: " + uuid);
            cancelSpecificTriggerStrategy = new CancelDeletedNoteStrategy(i);
        }
        CancelContext cancelContext = new CancelContext(cancelSpecificTriggerStrategy);
        StringBuilder sb = new StringBuilder();
        synchronized (this) {
            try {
                if (cancelContext.cancelActiveTask()) {
                    Iterator<Runnable> it = this.mNoteThreadPoolExecutor.getActiveTasks().iterator();
                    while (it.hasNext()) {
                        NoteCollectTask noteCollectTask = (NoteCollectTask) it.next();
                        if (cancelContext.isCancelable(collectParam, noteCollectTask)) {
                            noteCollectTask.getCollectParam().setCancelType(cancelType);
                            noteCollectTask.cancel();
                            if (!cancelContext.isDeleted()) {
                                setNoteReadyState(noteCollectTask.getUuid(), noteCollectTask.getLastModifiedAt());
                            }
                            if (!TextUtils.isEmpty(uuid) && sb.length() < 10000) {
                                sb.append(uuid);
                                sb.append(" from activeTasks, ");
                            }
                        }
                    }
                }
                Iterator<Runnable> it2 = this.mNoteThreadPoolExecutor.getQueue().iterator();
                while (it2.hasNext()) {
                    NoteCollectTask noteCollectTask2 = (NoteCollectTask) it2.next();
                    if (cancelContext.isCancelable(collectParam, noteCollectTask2) && this.mNoteThreadPoolExecutor.getQueue().remove(noteCollectTask2) && !TextUtils.isEmpty(uuid) && sb.length() < 10000) {
                        sb.append(uuid);
                        sb.append(" from queue, ");
                    }
                }
                Iterator<Runnable> it3 = this.mNoteThreadPoolExecutor.getPausedTasks().iterator();
                while (it3.hasNext()) {
                    NoteCollectTask noteCollectTask3 = (NoteCollectTask) it3.next();
                    if (cancelContext.isCancelable(collectParam, noteCollectTask3) && this.mNoteThreadPoolExecutor.getQueue().remove(noteCollectTask3) && !TextUtils.isEmpty(uuid) && sb.length() < 10000) {
                        sb.append(uuid);
                        sb.append(" from pausedTasks, ");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        DataLogger.m12307i(TAG, "cancelCollect : " + ((Object) sb));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isRunning() {
        boolean z;
        if (this.mPriorityNoteThreadPoolExecutor.getActiveCount() > 0 || this.mNoteThreadPoolExecutor.getActiveCount() > 0) {
            z = true;
        } else if (this.mPdfThreadPoolExecutor.getActiveCount() <= 0) {
            z = false;
        }
        return z;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectStateListener
    public void onCollectFailed(CollectInfo collectInfo) {
        String uuid = collectInfo.getUuid();
        CollectInfo.TaskType taskType = collectInfo.getTaskType();
        DataLogger.m12307i(TAG, "onCollectFailed# taskType " + taskType);
        CollectResolver.deleteReadyState(uuid);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectStateListener
    public void onCollectFinished(CollectInfo collectInfo) {
        String uuid = collectInfo.getUuid();
        CollectInfo.TaskType taskType = collectInfo.getTaskType();
        boolean zHasCustomerPdf = collectInfo.hasCustomerPdf();
        boolean z = collectInfo.getCancelType() == ICollectParam.CancelType.DELETE.getValue();
        String str = TAG;
        DataLogger.m12307i(str, "onCollectFinished# uuid/taskType/hasCustomerPdf/deleted: " + uuid + "/" + taskType + "/" + zHasCustomerPdf + "/" + z);
        if (CollectInfo.TaskType.NOTE != taskType || !zHasCustomerPdf) {
            CollectParam collectParamRemove = this.mCollectParamMap.remove(uuid);
            if (collectParamRemove != null) {
                setNoteJobFinished(collectParamRemove);
            }
            setDoneState(collectInfo);
            notifyCollectFinished();
            return;
        }
        CollectParam collectParam = this.mCollectParamMap.get(uuid);
        if (collectParam != null) {
            runPdfCollect(collectParam);
        } else {
            DataLogger.m12309w(str, "onCollectFinished# invalid collectParam");
            setDoneState(collectInfo);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.subcollectors.ICollectStateListener
    public void onCollectStarted(CollectInfo collectInfo, boolean z) {
        String uuid = collectInfo.getUuid();
        long lastModifiedAt = collectInfo.getLastModifiedAt();
        CollectInfo.TaskType taskType = collectInfo.getTaskType();
        DataLogger.m12307i(TAG, "onCollectStarted# uuid/taskType " + uuid + "/" + taskType);
        if (CollectInfo.TaskType.NOTE != taskType) {
            setPdfReadyState(uuid, lastModifiedAt);
        } else {
            if (z) {
                return;
            }
            setNoteReadyState(uuid, lastModifiedAt);
        }
    }

    public void pausePdfCollect(CollectParam collectParam) {
        DataLogger.m12307i(TAG, "pausePdfCollect key/caller " + collectParam.getPdfActionKey() + "/" + collectParam.getPdfActionCaller());
        StringBuilder sb = new StringBuilder();
        synchronized (this) {
            try {
                addPausedPdf(collectParam);
                Iterator<Runnable> it = this.mPdfThreadPoolExecutor.getActiveTasks().iterator();
                while (it.hasNext()) {
                    PdfCollectTask pdfCollectTask = (PdfCollectTask) it.next();
                    if (pdfCollectTask != null) {
                        pdfCollectTask.cancel();
                        this.mPdfThreadPoolExecutor.addPausedTask(pdfCollectTask);
                        if (sb.length() < 10000) {
                            sb.append(pdfCollectTask.hashCode());
                            sb.append(SQLKeyword.COMMA);
                        }
                    }
                }
                Iterator<Runnable> it2 = this.mPdfThreadPoolExecutor.getQueue().iterator();
                while (it2.hasNext()) {
                    PdfCollectTask pdfCollectTask2 = (PdfCollectTask) it2.next();
                    if (pdfCollectTask2 != null) {
                        pdfCollectTask2.cancel();
                        this.mPdfThreadPoolExecutor.addPausedTask(pdfCollectTask2);
                        if (sb.length() < 10000) {
                            sb.append(pdfCollectTask2.hashCode());
                            sb.append(SQLKeyword.COMMA);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        DataLogger.m12307i(TAG, "pausePdfCollect : " + ((Object) sb));
    }

    public void resumePdfCollect(CollectParam collectParam) {
        DataLogger.m12307i(TAG, "resumePdfCollect key/caller " + collectParam.getPdfActionKey() + "/" + collectParam.getPdfActionCaller());
        StringBuilder sb = new StringBuilder();
        synchronized (this) {
            try {
                removePausedPdf(collectParam);
                if (getPdfState() == PdfState.PAUSE) {
                    return;
                }
                Iterator<Runnable> it = this.mPdfThreadPoolExecutor.getPausedTasks().iterator();
                while (it.hasNext()) {
                    PdfCollectTask pdfCollectTask = (PdfCollectTask) it.next();
                    if (pdfCollectTask != null) {
                        this.mPdfThreadPoolExecutor.execute(new PdfCollectTask(pdfCollectTask.getCollectParam(), this));
                        if (sb.length() < 10000) {
                            sb.append(pdfCollectTask.hashCode());
                            sb.append(SQLKeyword.COMMA);
                        }
                    }
                }
                this.mPdfThreadPoolExecutor.clearPausedTasks();
                DataLogger.m12307i(TAG, "resumePdfCollect : " + ((Object) sb));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void runCollect(CollectParam collectParam) {
        removePausedPdfCollect(collectParam);
        if (StorageUtils.isAvailableMemoryForNewMemo()) {
            this.mCollectParamMap.put(collectParam.getUuid(), collectParam);
            if (collectParam.getPriority() == ICollectParam.Priority.IMMEDIATELY.getValue()) {
                runPriorityNoteCollect(collectParam);
                return;
            } else {
                runNoteCollect(collectParam);
                return;
            }
        }
        DataLogger.m12307i(TAG, "runCollect, skip storage : " + StorageUtils.getAvailableInternalMemorySize());
        setNoteReadyState(collectParam.getUuid(), collectParam.getLastModifiedAt());
    }

    public void setDoneState(CollectInfo collectInfo) {
        String uuid = collectInfo.getUuid();
        boolean zIsSharedNote = collectInfo.isSharedNote();
        boolean zIsLockedType = LockUtils.isLockedType(collectInfo.getLockType());
        if (collectInfo.getCancelType() != ICollectParam.CancelType.DELETE.getValue()) {
            CollectResolver.setDoneState(uuid);
        }
        if (zIsLockedType || zIsSharedNote) {
            return;
        }
        DocumentExtraDataUtils.updateExternalSharedDocuments(BaseUtils.getContext(), collectInfo.getUuid(), collectInfo.getLastModifiedAt(), true);
    }

    public void setNoteReadyState(String str, long j) {
        CollectResolver.setReadyState(str, j, 1);
    }

    public void setPdfReadyState(String str, long j) {
        CollectResolver.setReadyState(str, j, 3);
    }
}
