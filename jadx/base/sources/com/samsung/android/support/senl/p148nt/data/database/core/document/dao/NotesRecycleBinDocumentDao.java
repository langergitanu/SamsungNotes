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
import com.samsung.android.support.senl.p148nt.data.database.core.query.document.DocumentSortQuery;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.NotesSQLBuilder;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class NotesRecycleBinDocumentDao {
    private static final String ORDER_BY = " ORDER BY CASE WHEN :isDesc=1 THEN lastModifiedAt END DESC, CASE WHEN :isDesc=0 THEN lastModifiedAt END ASC";
    private static final String TAG = DataLogger.createTag("NotesRecycleBinDocumentDao");

    @Query("UPDATE OR ABORT category_tree SET recycle_bin_time_moved=:currentTimestamp , isDirty=1 , serverTimestamp=:serverTimestamp WHERE isDeleted=2 AND recycle_bin_time_moved=0")
    public abstract int correctDocumentRecycleBinTime(long j, long j2);

    @Query("UPDATE OR ABORT sdoc SET recycle_bin_time_moved=:currentTimestamp , isDirty=1 , serverTimestamp=:serverTimestamp WHERE isDeleted=2 AND recycle_bin_time_moved=0")
    public abstract int correctFolderRecycleBinTime(long j, long j2);

    @Transaction
    public int correctRecycleBinTime(long j, long j2) {
        return correctFolderRecycleBinTime(j, j2) + correctDocumentRecycleBinTime(j, j2);
    }

    public List<MainListDocumentData> getAll(@DeleteType int i, SortParam sortParam) {
        return rawQuery(new SimpleSQLiteQuery(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_JOINED_TABLE).where("sdoc.mdeSpaceId=''").and("sdoc.isDeleted=" + i).orderBy(new DocumentSortQuery().createQuery(sortParam)).build()));
    }

    @Query("SELECT `sdoc`.* FROM sdoc WHERE isDeleted=:deleteType AND mdeSpaceId='' ORDER BY CASE WHEN :isDesc=1 THEN lastModifiedAt END DESC, CASE WHEN :isDesc=0 THEN lastModifiedAt END ASC")
    public abstract List<NotesDocumentEntity> getAll(@DeleteType int i, boolean z);

    @Query("SELECT sdoc.filePath FROM sdoc WHERE isDeleted=:deleteType AND mdeSpaceId=''")
    public abstract List<String> getAllFilePathsInRecycleBin(@DeleteType int i);

    @Nullable
    public LiveData<List<MainListDocumentData>> getAll_LiveData(@DeleteType int i, @NonNull SortParam sortParam) {
        return rawQuery_LiveData(new SimpleSQLiteQuery(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_JOINED_TABLE).where("sdoc.mdeSpaceId=''").and("sdoc.isDeleted=" + i).orderBy(new DocumentSortQuery().createQuery(sortParam)).build()));
    }

    @Query("SELECT sdoc.UUID FROM sdoc WHERE sdoc.isDeleted = 2 AND sdoc.UUID IN (:uuids)")
    public abstract List<String> getDocumentsInRecycleBin(Collection<String> collection);

    @Query("SELECT COUNT(*) FROM category_tree WHERE isDeleted=:deleteType AND parentUUID= 'trash:///'")
    public abstract int getFolderCount(@DeleteType int i);

    @Query("SELECT category_tree.UUID FROM category_tree WHERE category_tree.isDeleted = 2 AND category_tree.UUID IN (:uuids)")
    public abstract List<String> getFoldersInRecycleBin(Collection<String> collection);

    @Transaction
    public int getItemCount(@DeleteType int i) {
        return getFolderCount(i) + getNoteCount(i);
    }

    @Query("SELECT COUNT(*) FROM sdoc WHERE isDeleted=:deleteType AND categoryUUID= 'trash:///' AND mdeSpaceId=''")
    public abstract int getNoteCount(@DeleteType int i);

    @RawQuery(observedEntities = {NotesDocumentEntity.class, NotesDocumentCoverEntity.class, SuggestedCoverEntity.class})
    public abstract List<MainListDocumentData> internalRawQuery(SupportSQLiteQuery supportSQLiteQuery);

    @RawQuery(observedEntities = {NotesDocumentEntity.class, NotesDocumentCoverEntity.class, SuggestedCoverEntity.class})
    public abstract LiveData<List<MainListDocumentData>> internalRawQuery_LiveData(SupportSQLiteQuery supportSQLiteQuery);

    @Query("SELECT NOT EXISTS (SELECT 1 FROM sdoc WHERE sdoc.isDeleted = 2)")
    public abstract boolean isEmpty();

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
