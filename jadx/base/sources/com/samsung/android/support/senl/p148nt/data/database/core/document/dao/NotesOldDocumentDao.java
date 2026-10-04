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
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p079T.C0287e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesOldDocumentDao {
    private static final String TAG = DataLogger.createTag("NotesOldDocumentDao");

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$includeOldNotes$0(AtomicBoolean atomicBoolean, List list) {
        atomicBoolean.set(atomicBoolean.get() || includeOldNotesInChunk(list));
        return new ArrayList();
    }

    public List<MainListDocumentData> getAll_OldNotes(@DeleteType int i, SortParam sortParam) {
        return rawQuery(new SimpleSQLiteQuery(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_MAPPED_JOINED_TABLE).where("sdoc.mdeSpaceId=''").and("sdoc.isDeleted=" + i).and("sdoc.filePath LIKE '%.sdoc'").and("map.mappedUUID IS NULL").orderBy(new DocumentSortQuery().createQuery(sortParam)).build()));
    }

    @Query("SELECT COUNT(*) FROM sdoc AS doc WHERE doc.mdeSpaceId='' AND doc.isDeleted=:deleteType AND doc.filePath LIKE '%.sdoc'")
    public abstract int getAll_OldNotes_Count(@DeleteType int i);

    @Nullable
    public LiveData<List<MainListDocumentData>> getAll_OldNotes_LiveData(@DeleteType int i, @NonNull SortParam sortParam) {
        return rawQuery_LiveData(new SimpleSQLiteQuery(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_MAPPED_JOINED_TABLE).where("sdoc.mdeSpaceId=''").and("sdoc.isDeleted=" + i).and("sdoc.filePath LIKE '%.sdoc'").and("map.mappedUUID IS NULL").orderBy(new DocumentSortQuery().createQuery(sortParam)).build()));
    }

    @Query("SELECT 1 FROM sdoc WHERE sdoc.mdeSpaceId='' AND sdoc.isDeleted= 0 AND sdoc.filePath LIKE '%.sdoc'")
    public abstract boolean hasOldNoteInUse();

    @Transaction
    public boolean includeOldNotes(List<String> list) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        new SplitTaskExecutor(new C0287e(this, atomicBoolean, 21)).execute(list);
        return atomicBoolean.get();
    }

    @Query("SELECT 1 FROM sdoc WHERE sdoc.UUID IN (:uuids) AND sdoc.filePath LIKE '%.sdoc'")
    public abstract boolean includeOldNotesInChunk(List<String> list);

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
