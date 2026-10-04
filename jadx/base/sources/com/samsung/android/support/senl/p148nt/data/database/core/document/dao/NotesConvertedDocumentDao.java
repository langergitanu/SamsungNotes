package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Transaction;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DeleteType;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentCoverEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SuggestedCoverEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.database.core.query.document.DocumentSortQuery;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.NotesSQLBuilder;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p079T.C0287e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesConvertedDocumentDao {
    private static final String TAG = DataLogger.createTag("NotesConvertedDocumentDao");

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$hasConvertedOldNote$0(AtomicBoolean atomicBoolean, List list) {
        if (!atomicBoolean.get()) {
            atomicBoolean.set(hasConvertedOldNoteInChunk(list));
        }
        return new ArrayList();
    }

    public List<MainListDocumentData> getAll_Converted(@DeleteType int i, SortParam sortParam) {
        return rawQuery(new SimpleSQLiteQuery(new NotesSQLBuilder().selectDistinct(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_MAPPED_JOINED_TABLE).where("sdoc.mdeSpaceId=''").and("sdoc.isDeleted=" + i).and("map.mappedUUID IS NOT NULL").orderBy(new DocumentSortQuery().createQuery(sortParam)).build()));
    }

    @Query("SELECT COUNT(DISTINCT sdoc.UUID) FROM (SELECT * FROM sdoc WHERE mdeSpaceId = '' AND isDeleted = :deleteType) AS sdoc INNER JOIN mapped_document AS map ON sdoc.UUID = map.UUID")
    public abstract int getAll_ConvertedCount(@DeleteType int i);

    @Nullable
    public LiveData<List<MainListDocumentData>> getAll_Converted_LiveData(@DeleteType int i, @NonNull SortParam sortParam) {
        return rawQuery_LiveData(new SimpleSQLiteQuery(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_MAPPED_JOINED_TABLE).where("sdoc.mdeSpaceId=''").and("sdoc.isDeleted=" + i).and("map.mappedUUID IS NOT NULL").orderBy(new DocumentSortQuery().createQuery(sortParam)).build()));
    }

    @Transaction
    public List<String> getOldNotesWithConvertedNotesInUse(Collection<String> collection) {
        return new SplitTaskExecutor(new C8886c(this, 23)).execute(collection);
    }

    @Query("SELECT DISTINCT sdoc.UUID  FROM sdoc JOIN mapped_document ON sdoc.UUID = mapped_document.UUID WHERE sdoc.UUID IN (:oldNoteUuids) AND sdoc.mdeSpaceId='' AND sdoc.isDeleted = 0 AND EXISTS (SELECT 1 FROM sdoc AS doc WHERE doc.UUID = mapped_document.mappedUUID AND (doc.isDeleted = 0 OR doc.isDeleted = 2))")
    public abstract List<String> getOldNotesWithConvertedNotesInUseInChunk(Collection<String> collection);

    @Transaction
    public boolean hasConvertedOldNote(Collection<String> collection) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        new SplitTaskExecutor(new C0287e(this, atomicBoolean, 20)).execute(collection);
        return atomicBoolean.get();
    }

    @Query("SELECT 1  FROM sdoc WHERE sdoc.UUID IN (:oldNoteUuids) AND sdoc.mdeSpaceId='' AND sdoc.isDeleted = 0 AND sdoc.UUID IN (SELECT UUID FROM mapped_document)")
    public abstract boolean hasConvertedOldNoteInChunk(Collection<String> collection);

    @RawQuery(observedEntities = {NotesDocumentEntity.class, NotesDocumentCoverEntity.class, SuggestedCoverEntity.class})
    public abstract List<MainListDocumentData> internalRawQuery(SupportSQLiteQuery supportSQLiteQuery);

    @RawQuery(observedEntities = {NotesDocumentEntity.class, NotesDocumentCoverEntity.class, SuggestedCoverEntity.class})
    public abstract LiveData<List<MainListDocumentData>> internalRawQuery_LiveData(SupportSQLiteQuery supportSQLiteQuery);

    @NonNull
    public List<MainListDocumentData> rawQuery(@NonNull SupportSQLiteQuery supportSQLiteQuery) {
        try {
            return internalRawQuery(supportSQLiteQuery);
        } catch (Exception e) {
            DataLogger.m12305f(TAG, "rawQuery, e : " + e.getMessage() + ", backtrace : " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
            return new ArrayList();
        }
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> rawQuery_LiveData(@NonNull SupportSQLiteQuery supportSQLiteQuery) {
        try {
            return internalRawQuery_LiveData(supportSQLiteQuery);
        } catch (Exception e) {
            DataLogger.m12305f(TAG, "rawQuery_LiveData, e : " + e.getMessage() + ", backtrace : " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
            return null;
        }
    }
}
