package com.samsung.android.support.senl.p148nt.model.collector.updater;

import androidx.annotation.VisibleForTesting;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.collect.CollectTestLogger;
import com.samsung.android.support.senl.p148nt.base.common.jobscheduler.INoteJob;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesRetryEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.manager.CollectTaskManager;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ReadyStateUpdater extends AbstractUpdater {
    private static final String TAG = CollectLogger.createTag("ReadyStateUpdater");
    private static INoteJob.INoteJobFinishCallback sNoteJobFinishCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static class Executor implements Runnable {
        private static final String TAG = CollectLogger.createTag("ReadyStateUpdater$Executor");

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int lambda$run$0(NotesRetryEntity notesRetryEntity, NotesRetryEntity notesRetryEntity2) {
            long lastModifiedAt = notesRetryEntity.getLastModifiedAt() - notesRetryEntity2.getLastModifiedAt();
            if (lastModifiedAt < 0) {
                return 1;
            }
            return lastModifiedAt > 0 ? -1 : 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<NotesRetryEntity> stateInReadyList = NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentRetryRepository().getStateInReadyList(1);
            String str = TAG;
            Logger.m8700f(str, "execute, readyStateList size : " + stateInReadyList.size());
            CollectTestLogger.log(str + "execute, readyStateList size : " + stateInReadyList.size());
            if (stateInReadyList.isEmpty() && ReadyStateUpdater.sNoteJobFinishCallback != null) {
                ReadyStateUpdater.sNoteJobFinishCallback.onFinishJob();
                return;
            }
            stateInReadyList.sort(new C11429a());
            boolean zIsEngMode = DeviceInfo.isEngMode();
            StringBuilder sb = new StringBuilder();
            for (NotesRetryEntity notesRetryEntity : stateInReadyList) {
                String docUuid = notesRetryEntity.getDocUuid();
                if (zIsEngMode) {
                    sb.append(docUuid);
                    sb.append(SQLKeyword.COMMA);
                }
                CollectParam.CollectParamBuilder collectParamBuilder = new CollectParam.CollectParamBuilder();
                collectParamBuilder.setUuid(docUuid).setLastModifiedAt(notesRetryEntity.getLastModifiedAt()).setTriggerType(ICollectParam.TriggerType.UPDATE.getValue()).setActionType(ICollectParam.ActionType.START.getValue()).setSourceType(ICollectParam.SourceType.OTHERS.getValue()).setPriority(ICollectParam.Priority.BACKGROUND.getValue()).setLinkWith(ICollectParam.LinkWith.DEFAULT.getValue());
                if (ReadyStateUpdater.sNoteJobFinishCallback != null) {
                    collectParamBuilder.setNoteJobFinishCallback(ReadyStateUpdater.sNoteJobFinishCallback);
                }
                CollectTaskManager.getInstance().runCollect(collectParamBuilder.build());
            }
            if (zIsEngMode) {
                DataLogger.m12302d(TAG, "execute, lExecutedList : " + ((Object) sb));
            }
        }
    }

    private ReadyStateUpdater() {
        super(TAG);
    }

    public static void execute(INoteJob.INoteJobFinishCallback iNoteJobFinishCallback) {
        sNoteJobFinishCallback = iNoteJobFinishCallback;
        new ReadyStateUpdater().executeExecutor();
    }

    private void executeExecutor() {
        DataLogger.m12302d(TAG, "execute");
        this.mThreadPoolExecutor.execute(new Executor());
    }
}
