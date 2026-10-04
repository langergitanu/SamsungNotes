package com.samsung.android.support.senl.p148nt.model.converter.task;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.ConvertTaskStatus;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult;
import com.samsung.android.support.senl.p148nt.model.converter.task.service.listener.IServiceRequestor;
import com.samsung.android.support.senl.p148nt.model.converter.task.sub.ConvertSubTaskParams;
import com.samsung.android.support.senl.p148nt.model.converter.task.sub.IConvertSubTask;
import com.samsung.android.support.senl.p148nt.model.converter.task.sub.SDocXConvertTask;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConvertTask implements Runnable {
    private static final String TAG = ModelLogger.createConverterTag("ConvertTask");
    private TaskCallback mCallback;
    private final IConvertInfo mInfo;
    private IServiceRequestor mRequester;
    private final ConvertTaskStatus mStatus = new ConvertTaskStatus(0);
    private final Queue<IConvertSubTask> mSubTasks = new LinkedList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class TaskCallback implements SDocXConvertTask.ISDocXConvertTaskCallback {
        private IConvertTaskCallback mExternalCallback;

        public TaskCallback(IConvertTaskCallback iConvertTaskCallback) {
            setExternalCallback(iConvertTaskCallback);
        }

        @Override // com.samsung.android.support.senl.nt.model.converter.task.sub.SDocXConvertTask.ISDocXConvertTaskCallback
        public void convertDocument(List<String> list, long j, IServiceRequestor.IServiceListener iServiceListener) {
            if (ConvertTask.this.mRequester == null) {
                return;
            }
            ConvertTask.this.mInfo.setReqFileSize(j);
            ConvertTask.this.mRequester.convertDocument(ConvertTask.this.mInfo, list, iServiceListener);
        }

        public IConvertTaskCallback getExternalCallback() {
            return this.mExternalCallback;
        }

        @Override // com.samsung.android.support.senl.nt.model.converter.task.sub.IConvertSubTask.ISubTaskCallback
        public void onPostConvert(IConvertResult iConvertResult) {
            if (iConvertResult.getState() == 0) {
                DataLogger.m12307i(ConvertTask.TAG, "onPostConvert, " + iConvertResult);
                ConvertTask.this.mStatus.updateStatus(iConvertResult.getDstType(), iConvertResult.getDstType() == 9 ? ConvertTaskStatus.State.FINISHED : ConvertTaskStatus.State.SUB_TASK_SUCCESS);
                IConvertTaskCallback iConvertTaskCallback = this.mExternalCallback;
                if (iConvertTaskCallback != null) {
                    iConvertTaskCallback.onSuccess(ConvertTask.this.mInfo, iConvertResult);
                }
                ConvertTask.this.runConvert(new ConvertSubTaskParams(iConvertResult.getPathList(), false));
                return;
            }
            DataLogger.m12307i(ConvertTask.TAG, "onPostConvert, dstType : " + iConvertResult.getDstType() + ", state : " + iConvertResult.getState());
            ConvertTask.this.mStatus.updateStatus(iConvertResult.getDstType(), ConvertTaskStatus.State.FAILED);
            IConvertTaskCallback iConvertTaskCallback2 = this.mExternalCallback;
            if (iConvertTaskCallback2 != null) {
                iConvertTaskCallback2.onFailed(ConvertTask.this.mInfo, iConvertResult);
            }
        }

        @Override // com.samsung.android.support.senl.nt.model.converter.task.sub.IConvertSubTask.ISubTaskCallback
        public void onPreConvert(IConvertResult iConvertResult) {
            DataLogger.m12307i(ConvertTask.TAG, "onPreConvert, src : " + iConvertResult.getSrcType() + " -> dst : " + iConvertResult.getDstType());
            if (iConvertResult.getState() == 0) {
                ConvertTask.this.mStatus.updateStatus(iConvertResult.getDstType(), ConvertTaskStatus.State.PROGRESSING);
                return;
            }
            ConvertTask.this.mStatus.updateStatus(iConvertResult.getDstType(), ConvertTaskStatus.State.FAILED);
            IConvertTaskCallback iConvertTaskCallback = this.mExternalCallback;
            if (iConvertTaskCallback != null) {
                iConvertTaskCallback.onFailed(ConvertTask.this.mInfo, iConvertResult);
            }
        }

        public void release() {
            this.mExternalCallback = null;
        }

        public void setExternalCallback(IConvertTaskCallback iConvertTaskCallback) {
            this.mExternalCallback = iConvertTaskCallback;
        }
    }

    public ConvertTask(@NonNull IConvertInfo iConvertInfo, @Nullable IConvertTaskCallback iConvertTaskCallback) {
        this.mInfo = iConvertInfo;
        this.mCallback = new TaskCallback(iConvertTaskCallback);
        DataLogger.m12307i(TAG, "ConvertTask is created, callerId : " + iConvertInfo.getCallerId());
    }

    private boolean isState(ConvertTaskStatus.State state) {
        return this.mStatus.getState().equals(state);
    }

    private void onFinished() {
        this.mRequester = null;
        TaskCallback taskCallback = this.mCallback;
        if (taskCallback != null) {
            taskCallback.release();
            this.mCallback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runConvert(IConvertSubTask.IConvertParams iConvertParams) {
        IConvertSubTask iConvertSubTaskPoll = this.mSubTasks.poll();
        if (iConvertSubTaskPoll == null) {
            onFinished();
            return;
        }
        if (iConvertParams != null) {
            iConvertSubTaskPoll.setParams(iConvertParams);
        }
        iConvertSubTaskPoll.run();
    }

    public void addSubTask(IConvertSubTask iConvertSubTask) {
        this.mSubTasks.add(iConvertSubTask);
    }

    public TaskCallback getCallback() {
        return this.mCallback;
    }

    public IConvertInfo getInfo() {
        return this.mInfo;
    }

    public ConvertTaskStatus getStatus() {
        return this.mStatus;
    }

    public boolean isEmptyTask() {
        return this.mSubTasks.isEmpty();
    }

    public boolean isInProgress() {
        return isState(ConvertTaskStatus.State.PROGRESSING) || isState(ConvertTaskStatus.State.SUB_TASK_SUCCESS) || isState(ConvertTaskStatus.State.WAITING);
    }

    @Override // java.lang.Runnable
    public void run() {
        runConvert(null);
    }

    public void setRequestor(IServiceRequestor iServiceRequestor) {
        this.mRequester = iServiceRequestor;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(Log.TAG_SEPARATOR);
        sb.append(hashCode());
        for (IConvertSubTask iConvertSubTask : this.mSubTasks) {
            sb.append('/');
            sb.append(iConvertSubTask.toString());
        }
        return sb.toString();
    }
}
