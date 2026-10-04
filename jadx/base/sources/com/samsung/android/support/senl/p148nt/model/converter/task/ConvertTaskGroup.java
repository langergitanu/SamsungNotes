package com.samsung.android.support.senl.p148nt.model.converter.task;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.converter.task.ConvertTaskFactory;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.ConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.ConvertTaskGroupResult;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.ConvertTaskResult;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.CountInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConvertTaskGroup {
    private static final String TAG = ModelLogger.createConverterTag("ConvertTaskGroup");
    private final int mCallerId;
    private final GroupTaskCallback mGroupCallback;
    private final int mGroupId;
    private final List<ConvertTask> mTaskList = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IGroupStatusCallback {
        void onEnd(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IGroupTaskCallback extends ConvertTaskFactory.IConvertTaskFactoryCallback {
        void onEnd(boolean z, IConvertResult iConvertResult);
    }

    public ConvertTaskGroup(@NonNull Context context, @NonNull List<ConvertInfo> list, int i, int i2, @NonNull IGroupTaskCallback iGroupTaskCallback) {
        this.mCallerId = i;
        i2 = i2 == -1 ? hashCode() : i2;
        this.mGroupId = i2;
        this.mGroupCallback = new GroupTaskCallback(i2, list.size(), iGroupTaskCallback);
        initialize(context, list);
    }

    private void initialize(Context context, List<ConvertInfo> list) {
        WidgetAccessContract widgetAccessContract = WidgetAccessHandler.getWidgetAccessContract();
        List<String> widgetUuids = widgetAccessContract != null ? widgetAccessContract.getWidgetUuids(context) : new ArrayList<>();
        Iterator<ConvertInfo> it = list.iterator();
        while (it.hasNext()) {
            ConvertTask convertTaskCreateTaskWithValidCheck = ConvertTaskFactory.createTaskWithValidCheck(context, it.next(), widgetUuids, this.mGroupCallback);
            if (convertTaskCreateTaskWithValidCheck != null) {
                this.mTaskList.add(convertTaskCreateTaskWithValidCheck);
            }
        }
        this.mGroupCallback.onPrepared();
    }

    public int getCallerId() {
        return this.mCallerId;
    }

    public int getId() {
        return this.mGroupId;
    }

    public List<ConvertTask> getTaskList() {
        return this.mTaskList;
    }

    public void setExternalCallback(IGroupTaskCallback iGroupTaskCallback) {
        this.mGroupCallback.setExternalCallback(iGroupTaskCallback);
    }

    public void setOpenAfterConverted(IConvertTaskCallback iConvertTaskCallback) {
        this.mGroupCallback.setOpenAfterConverted(iConvertTaskCallback);
    }

    public void setStatusCallback(IGroupStatusCallback iGroupStatusCallback) {
        this.mGroupCallback.setStatusCallback(iGroupStatusCallback);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GroupTaskCallback implements ConvertTaskFactory.IConvertTaskFactoryCallback {
        private IGroupTaskCallback mExternalCallback;
        private final int mGroupId;
        private IConvertTaskCallback mOpenNoteCallback;
        private IGroupStatusCallback mStatusCallback;
        private final int mTotalCount;
        private int mValidInputCount = 0;
        private int mInvalidInputCount = 0;
        private int mSuccessCount = 0;
        private int mFailedCount = 0;
        private int mStorageFailedCount = 0;
        private final List<String> mUuidList = new ArrayList();

        public GroupTaskCallback(int i, int i2, IGroupTaskCallback iGroupTaskCallback) {
            this.mGroupId = i;
            this.mTotalCount = i2;
            this.mExternalCallback = iGroupTaskCallback;
        }

        private boolean isFinished() {
            return this.mValidInputCount == this.mFailedCount + this.mSuccessCount;
        }

        private void onEnd() {
            if (isFinished()) {
                DataLogger.m12307i(ConvertTaskGroup.TAG, "TaskGroupCallback, onEnd");
                IGroupStatusCallback iGroupStatusCallback = this.mStatusCallback;
                if (iGroupStatusCallback != null) {
                    iGroupStatusCallback.onEnd(this.mGroupId);
                }
                if (this.mExternalCallback != null) {
                    ConvertTaskResult convertTaskResult = new ConvertTaskResult(8, 9);
                    CountInfo countInfo = new CountInfo(this.mTotalCount, this.mInvalidInputCount, this.mSuccessCount, this.mFailedCount, this.mStorageFailedCount);
                    DataLogger.m12307i(ConvertTaskGroup.TAG, "TaskGroupCallback, onEnd, " + countInfo.toString());
                    if (this.mSuccessCount > 0) {
                        this.mExternalCallback.onEnd(true, new ConvertTaskGroupResult(convertTaskResult.setUuidList(this.mUuidList), countInfo));
                    } else {
                        this.mExternalCallback.onEnd(false, new ConvertTaskGroupResult(convertTaskResult.setUuidList(null), countInfo));
                    }
                }
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
        public void onFailed(IConvertInfo iConvertInfo, IConvertResult iConvertResult) {
            DataLogger.m12307i(ConvertTaskGroup.TAG, "TaskGroupCallback, onFailed#, state : " + iConvertResult.getState());
            this.mFailedCount = this.mFailedCount + 1;
            if (iConvertResult.getState() == 6) {
                this.mStorageFailedCount++;
            }
            IGroupTaskCallback iGroupTaskCallback = this.mExternalCallback;
            if (iGroupTaskCallback != null) {
                iGroupTaskCallback.onFailed(iConvertInfo, new ConvertTaskGroupResult(iConvertResult, new CountInfo(this.mTotalCount, this.mInvalidInputCount, this.mSuccessCount, this.mFailedCount, this.mStorageFailedCount)));
            }
            onEnd();
        }

        @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskFactory.IConvertTaskFactoryCallback
        public void onPreFailed(ConvertTaskFactory.IConvertTaskFactoryCallback.ErrorMsg errorMsg) {
            DataLogger.m12302d(ConvertTaskGroup.TAG, "onPreFailed, status : " + errorMsg.getStatus());
            this.mInvalidInputCount = this.mInvalidInputCount + 1;
        }

        public void onPrepared() {
            int i = this.mTotalCount - this.mInvalidInputCount;
            this.mValidInputCount = i;
            IGroupTaskCallback iGroupTaskCallback = this.mExternalCallback;
            if (iGroupTaskCallback != null) {
                if (i <= 0) {
                    iGroupTaskCallback.onPreFailed(new ConvertTaskFactory.IConvertTaskFactoryCallback.ErrorMsg(2));
                } else if (!isFinished()) {
                    this.mExternalCallback.onCreated();
                } else {
                    DataLogger.m12302d(ConvertTaskGroup.TAG, "onPrepared, all document already have mappedUuids");
                    onEnd();
                }
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
        public void onSuccess(IConvertInfo iConvertInfo, IConvertResult iConvertResult) {
            DataLogger.m12307i(ConvertTaskGroup.TAG, "TaskGroupCallback, onSuccess#");
            if (iConvertResult.getDstType() == 9) {
                this.mSuccessCount++;
                this.mUuidList.addAll(iConvertResult.getUuidList());
                IGroupTaskCallback iGroupTaskCallback = this.mExternalCallback;
                if (iGroupTaskCallback != null) {
                    iGroupTaskCallback.onSuccess(iConvertInfo, new ConvertTaskGroupResult(iConvertResult, new CountInfo(this.mTotalCount, this.mInvalidInputCount, this.mSuccessCount, this.mFailedCount, this.mStorageFailedCount)));
                }
                IConvertTaskCallback iConvertTaskCallback = this.mOpenNoteCallback;
                if (iConvertTaskCallback != null) {
                    iConvertTaskCallback.onSuccess(iConvertInfo, new ConvertTaskGroupResult(iConvertResult, new CountInfo(this.mTotalCount, this.mInvalidInputCount, this.mSuccessCount, this.mFailedCount, this.mStorageFailedCount)));
                }
                onEnd();
            }
        }

        public void setExternalCallback(IGroupTaskCallback iGroupTaskCallback) {
            this.mExternalCallback = iGroupTaskCallback;
        }

        public void setOpenAfterConverted(IConvertTaskCallback iConvertTaskCallback) {
            this.mOpenNoteCallback = iConvertTaskCallback;
        }

        public void setStatusCallback(IGroupStatusCallback iGroupStatusCallback) {
            this.mStatusCallback = iGroupStatusCallback;
        }

        @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskFactory.IConvertTaskFactoryCallback
        public void onCreated() {
        }
    }
}
