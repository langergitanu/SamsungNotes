package com.samsung.android.support.senl.p148nt.data.repository.document;

import android.database.sqlite.SQLiteConstraintException;
import androidx.lifecycle.LiveData;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.NotesSQLiteConstraintException;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOrganizedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesOrganizedDocumentEntity;
import java.util.Collection;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesOrganizedDocumentRepository {
    private static final String TAG = DataLogger.createTag("NotesOrganizedDocumentRepository");
    private final NotesOrganizedDocumentDao mOrganizedDocumentDao = NotesDatabaseManager.getInstance().getOrganizedDocumentDao();

    public void deleteByUuids(List<String> list) {
        DataLogger.m12307i(TAG, "deleteByUuids, docUuids : " + list.size());
        this.mOrganizedDocumentDao.deleteByUuids(list);
    }

    public void deleteDummy() {
        this.mOrganizedDocumentDao.deleteDummy();
    }

    public List<NotesOrganizedDocumentEntity> getAll() {
        DataLogger.m12307i(TAG, "getAll");
        return this.mOrganizedDocumentDao.getAll();
    }

    public LiveData<List<NotesOrganizedDocumentEntity>> getAll_LiveData() {
        DataLogger.m12307i(TAG, "getAll_LiveData");
        return this.mOrganizedDocumentDao.getAll_LiveData();
    }

    public List<NotesOrganizedDocumentEntity> getEntities(Collection<String> collection) {
        DataLogger.m12307i(TAG, "getEntities, uuids: " + collection);
        return this.mOrganizedDocumentDao.getEntities(collection);
    }

    public NotesOrganizedDocumentEntity getEntity(String str) {
        AbstractC0000a.m2C("getEntity, uuid: ", str, TAG);
        return this.mOrganizedDocumentDao.getEntity(str);
    }

    public void insert(NotesOrganizedDocumentEntity notesOrganizedDocumentEntity) {
        DataLogger.m12307i(TAG, "insert, entity: " + notesOrganizedDocumentEntity.getUuid());
        try {
            this.mOrganizedDocumentDao.upsert(notesOrganizedDocumentEntity);
        } catch (SQLiteConstraintException e) {
            throw new NotesSQLiteConstraintException(e);
        }
    }

    public void insert(List<NotesOrganizedDocumentEntity> list) throws NotesSQLiteConstraintException {
        DataLogger.m12307i(TAG, "insert, entities: " + list.size());
        try {
            this.mOrganizedDocumentDao.upsert((Collection) list);
        } catch (SQLiteConstraintException e) {
            throw new NotesSQLiteConstraintException(e);
        }
    }
}
