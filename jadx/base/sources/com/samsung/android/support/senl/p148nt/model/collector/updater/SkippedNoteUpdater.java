package com.samsung.android.support.senl.p148nt.model.collector.updater;

import androidx.annotation.VisibleForTesting;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesRetryEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.manager.CollectTaskManager;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SkippedNoteUpdater extends AbstractUpdater {
    private static final String TAG = CollectLogger.createTag("SkippedNoteUpdater");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static class Executor implements Runnable {
        private static final String TAG = CollectLogger.createTag("SkippedNoteUpdater$Executor");

        @Override // java.lang.Runnable
        public void run() {
            List<NotesRetryEntity> stateInReadyList = NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentRetryRepository().getStateInReadyList(1);
            DataLogger.m12307i(TAG, "execute, readyStateList size : " + stateInReadyList.size());
            for (NotesRetryEntity notesRetryEntity : stateInReadyList) {
                CollectTaskManager.getInstance().runCollect(new CollectParam.CollectParamBuilder().setUuid(notesRetryEntity.getDocUuid()).setLastModifiedAt(notesRetryEntity.getLastModifiedAt()).setTriggerType(ICollectParam.TriggerType.UPDATE.getValue()).setActionType(ICollectParam.ActionType.START.getValue()).setSourceType(ICollectParam.SourceType.OTHERS.getValue()).setLinkWith(ICollectParam.LinkWith.DEFAULT.getValue()).build());
            }
        }
    }

    private SkippedNoteUpdater() {
        super(TAG);
    }

    public static void execute() {
        new SkippedNoteUpdater().runExecutor();
    }

    private void runExecutor() {
        DataLogger.m12302d(TAG, "execute");
        this.mThreadPoolExecutor.execute(new Executor());
    }
}
