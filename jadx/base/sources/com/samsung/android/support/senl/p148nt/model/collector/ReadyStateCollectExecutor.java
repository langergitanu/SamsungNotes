package com.samsung.android.support.senl.p148nt.model.collector;

import android.database.Cursor;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.jobscheduler.INoteJob;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.RunnableC10960a;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesRetryEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.NotesSQLBuilder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.data.repository.recognition.NotesRetryRepository;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectResolver;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.updater.ReadyStateUpdater;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import p035H2.RunnableC0116a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class ReadyStateCollectExecutor {
    private static final String TAG = CollectLogger.createTag("ReadyStateUpdateExecutor");

    private void addMissingDocuments() {
        NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentRetryRepository().insert(getMissingDocuments());
    }

    private List<NotesRetryEntity> getMissingDocuments() {
        SupportSQLiteDatabase writableDatabase = NotesDatabaseManager.getWritableDatabase();
        String strBuild = new NotesSQLBuilder().select("sdoc.UUID, sdoc.lastModifiedAt").from("sdoc").leftJoin("retry").mo12421on("sdoc.UUID = retry.sdocUUID").where("retry.sdocUUID IS NULL").and("sdoc.isDeleted != 1").build();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = writableDatabase.query(strBuild);
        try {
            int columnIndex = cursorQuery.getColumnIndex("UUID");
            int columnIndex2 = cursorQuery.getColumnIndex("lastModifiedAt");
            String str = TAG;
            DataLogger.m12307i(str, "getMissingDocuments, cursor count : " + cursorQuery.getCount());
            if (columnIndex >= 0 && columnIndex2 >= 0) {
                if (!cursorQuery.moveToFirst()) {
                    DataLogger.m12309w(str, "getMissingDocuments, fail to move to first!");
                    cursorQuery.close();
                    return arrayList;
                }
                do {
                    arrayList.add(CollectResolver.createRetryEntity(cursorQuery.getString(columnIndex), cursorQuery.getLong(columnIndex2), 1));
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                DataLogger.m12302d(TAG, "getMissingDocuments, count : " + arrayList.size());
                return arrayList;
            }
            DataLogger.m12309w(str, "getMissingDocuments, invalid index!");
            cursorQuery.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private boolean hasRetryNoteStateReady() {
        return !NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentRetryRepository().getStateInReadyList(1).isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$0(boolean z) {
        if (z) {
            addMissingDocuments();
            removeRedundantNoteRetryEntity();
        }
        if (hasRetryNoteStateReady()) {
            DataLogger.m12302d(TAG, "execute, UPDATE_READY_STATE_NOTES");
            CollectController.getInstance().postCollectorTask(new CollectParam.CollectParamBuilder().setActionType(ICollectParam.ActionType.UPDATE_READY_STATE_NOTES.getValue()).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$1(INoteJob.INoteJobFinishCallback iNoteJobFinishCallback) {
        addMissingDocuments();
        removeRedundantNoteRetryEntity();
        ReadyStateUpdater.execute(iNoteJobFinishCallback);
    }

    private void removeRedundantNoteRetryEntity() {
        NotesRetryRepository notesRetryRepositoryCreateDocumentRetryRepository = NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentRetryRepository();
        List<NotesRetryEntity> stateInReadyList = notesRetryRepositoryCreateDocumentRetryRepository.getStateInReadyList(1);
        StringBuilder sb = new StringBuilder();
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        for (NotesRetryEntity notesRetryEntity : stateInReadyList) {
            String docUuid = notesRetryEntity.getDocUuid();
            Iterator it = concurrentLinkedQueue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    notesRetryEntity.setVersion(1);
                    concurrentLinkedQueue.add(notesRetryEntity);
                    sb.append(notesRetryEntity.getDocUuid());
                    sb.append(SQLKeyword.COMMA);
                    break;
                }
                if (((NotesRetryEntity) it.next()).getDocUuid().equals(docUuid)) {
                    break;
                }
            }
        }
        DataLogger.m12302d(TAG, "removeRedundantNoteRetryEntity " + ((Object) sb));
        notesRetryRepositoryCreateDocumentRetryRepository.delete(stateInReadyList);
        notesRetryRepositoryCreateDocumentRetryRepository.insert(concurrentLinkedQueue);
    }

    public void execute(boolean z) {
        String str = TAG;
        DataLogger.m12302d(str, "execute, isTriggeredByProcess : " + z);
        if (StorageUtils.isAvailableMinimumMemory()) {
            DataRepositoryScheduler.runnable(new RunnableC0116a(18, this, z)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
        } else {
            DataLogger.m12302d(str, "execute, fail : storage is full");
        }
    }

    public void execute(INoteJob.INoteJobFinishCallback iNoteJobFinishCallback) {
        String str = TAG;
        DataLogger.m12302d(str, "execute");
        if (!StorageUtils.isAvailableMinimumMemory()) {
            DataLogger.m12302d(str, "execute, fail : storage is full");
        } else {
            DataRepositoryScheduler.runnable(new RunnableC10960a(this, iNoteJobFinishCallback, 2)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
        }
    }
}
