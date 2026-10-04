package com.samsung.android.support.senl.p148nt.data.repository.recognition;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.constants.RetryState;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRetryDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesRetryEntity;
import java.util.Collection;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesRetryRepository {
    private static final String TAG = DataLogger.createTag("NotesRetryRepository");
    private final NotesRetryDao mNotesRetryDao = NotesDatabaseManager.getInstance().getRetryDao();

    public void delete(@NonNull Collection<NotesRetryEntity> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("delete, entities: "), TAG);
        this.mNotesRetryDao.deleteEntities(collection);
    }

    public void deleteByUuid(@NonNull String str) {
        AbstractC0000a.m2C("deleteByUuid, uuid : ", str, TAG);
        this.mNotesRetryDao.deleteByUuid(str);
    }

    public void deleteDummy() {
        this.mNotesRetryDao.deleteDummy();
    }

    public int getCountInState(@RetryState int i) {
        return this.mNotesRetryDao.getCountInState(i);
    }

    public List<NotesRetryEntity> getStateInReadyList(@RetryState int i) {
        return this.mNotesRetryDao.getStateInReadyList(i);
    }

    public int getVersion(String str) {
        return this.mNotesRetryDao.getVersion(str);
    }

    public void insert(@NonNull NotesRetryEntity notesRetryEntity) {
        DataLogger.m12307i(TAG, "insert, entity : " + notesRetryEntity.getDocUuid());
        this.mNotesRetryDao.upsert(notesRetryEntity);
    }

    public int updateState(String str, @RetryState int i) {
        return this.mNotesRetryDao.updateState(str, i);
    }

    public void insert(@NonNull Collection<? extends NotesRetryEntity> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("insert, entities : "), TAG);
        this.mNotesRetryDao.upsert((Collection) collection);
    }

    public void deleteByUuid(@NonNull Collection<String> collection) {
        DataLogger.m12307i(TAG, "deleteByUuid, uuidList : " + collection);
        this.mNotesRetryDao.deleteByUuid(collection);
    }
}
