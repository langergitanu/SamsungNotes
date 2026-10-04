package com.samsung.android.support.senl.p148nt.data.repository.cover;

import android.database.sqlite.SQLiteConstraintException;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.DeleteType;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.NotesSQLiteConstraintException;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentCoverDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.SuggestedCoverDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentCoverEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SuggestedCoverEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.tuple.DocumentCoverStateTuple;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import p001A.AbstractC0000a;
import p107a4.RunnableC0355a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesDocumentCoverRepository {
    private static final String TAG = DataLogger.createTag("NotesDocumentCoverRepository");
    private final NotesDatabase mDatabase;
    private final NotesDocumentCoverDao mNotesDocumentCoverDao;
    private final SuggestedCoverDao mSuggestedCoverDao;

    public NotesDocumentCoverRepository() {
        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
        this.mDatabase = notesDatabaseManager;
        this.mNotesDocumentCoverDao = notesDatabaseManager.getDocumentCoverDao();
        this.mSuggestedCoverDao = notesDatabaseManager.getSuggestedCoverDao();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$insert$0(NotesDocumentCoverEntity notesDocumentCoverEntity, int i, String str) {
        Pair<AtomicInteger, AtomicInteger> pairUpsert = this.mNotesDocumentCoverDao.upsert(notesDocumentCoverEntity);
        DataLogger.m12307i(TAG, "insert, result: " + pairUpsert);
        if (((AtomicInteger) pairUpsert.first).get() > 0 || ((AtomicInteger) pairUpsert.second).get() > 0) {
            SuggestedCoverEntity suggestedCoverEntity = new SuggestedCoverEntity();
            suggestedCoverEntity.setDocUuid(notesDocumentCoverEntity.getDocUuid());
            suggestedCoverEntity.setState(i, str);
            this.mSuggestedCoverDao.upsert(suggestedCoverEntity);
        }
    }

    public void deleteByUuids(Collection<String> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("deleteByUuids, docUuids : "), TAG);
        this.mNotesDocumentCoverDao.deleteByUuids(collection);
    }

    public void deleteDummy() {
        this.mNotesDocumentCoverDao.deleteDummy();
    }

    public LiveData<List<DocumentCoverStateTuple>> getAllTuples_LiveData() {
        DataLogger.m12307i(TAG, "getAllTuples_LiveData");
        return this.mNotesDocumentCoverDao.getAllTuples_LiveData();
    }

    @Nullable
    public DocumentCoverStateTuple getCoverStateTuple(String str) {
        AbstractC0000a.m2C("getCoverStateTuple, uuid: ", str, TAG);
        return this.mNotesDocumentCoverDao.getCoverStateTuple(str);
    }

    @Nullable
    public NotesDocumentCoverEntity getEntity(String str) {
        return this.mNotesDocumentCoverDao.getEntity(str);
    }

    public List<String> getUuidList(String str, @DeleteType int i) {
        AbstractC0000a.m2C("getUuidList, categoryUuid : ", str, TAG);
        return this.mNotesDocumentCoverDao.getUuidList(str, i);
    }

    public void insert(NotesDocumentCoverEntity notesDocumentCoverEntity, @CoverConstants.SuggestedState int i, String str) throws NotesSQLiteConstraintException {
        DataLogger.m12307i(TAG, "insert, entity: " + notesDocumentCoverEntity.getDocUuid() + ", state: " + i + ", caller: " + str);
        try {
            this.mDatabase.runInTransaction(new RunnableC0355a(this, notesDocumentCoverEntity, i, str, 0));
        } catch (SQLiteConstraintException e) {
            throw new NotesSQLiteConstraintException(e);
        }
    }

    public void updateEnabled(@NonNull String str, boolean z) {
        DataLogger.m12307i(TAG, "updateEnabled, docUuid: " + str + ", enabled: " + z);
        this.mNotesDocumentCoverDao.updateEnabled(str, z ? 1 : 0);
    }
}
