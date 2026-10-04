package com.samsung.android.support.senl.p148nt.model.collector;

import android.os.Process;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.manager.CollectTaskManager;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class SavingByWhichPidCollectExecutor {
    private static final String TAG = CollectLogger.createTag("SavingByWhichPidCollectExecutor");

    /* JADX INFO: Access modifiers changed from: private */
    public void resetIsSavingByWhichPid() {
        int iMyPid = Process.myPid();
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentDataRepository();
        List<NotesDocumentEntity> saveFailedEntities = notesDocumentRepositoryCreateDocumentDataRepository.getSaveFailedEntities(iMyPid);
        ArrayList arrayList = new ArrayList();
        for (NotesDocumentEntity notesDocumentEntity : saveFailedEntities) {
            notesDocumentEntity.setIsSavingByWhichPid(0);
            CollectParam.CollectParamBuilder collectParamBuilder = new CollectParam.CollectParamBuilder();
            collectParamBuilder.setUuid(notesDocumentEntity.getUuid()).setLastModifiedAt(notesDocumentEntity.getLastModifiedAt()).setTriggerType(ICollectParam.TriggerType.UPDATE.getValue()).setActionType(ICollectParam.ActionType.START.getValue()).setSourceType(ICollectParam.SourceType.OTHERS.getValue()).setPriority(ICollectParam.Priority.BACKGROUND.getValue()).setLinkWith(ICollectParam.LinkWith.DEFAULT.getValue());
            arrayList.add(collectParamBuilder.build());
        }
        if (!saveFailedEntities.isEmpty()) {
            notesDocumentRepositoryCreateDocumentDataRepository.update(saveFailedEntities, false);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                CollectTaskManager.getInstance().runCollect((CollectParam) it.next());
            }
        }
        DataLogger.m12302d(TAG, "resetIsSavingByWhichPid, count: " + saveFailedEntities.size());
    }

    public void execute() {
        if (StorageUtils.isAvailableMinimumMemory()) {
            DataRepositoryScheduler.runnable(new RunnableC9767a(this, 24)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
        } else {
            DataLogger.m12302d(TAG, "execute, fail : storage is full");
        }
    }
}
