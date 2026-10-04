package com.samsung.android.support.senl.p148nt.data.database.core.sync.dao;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DeleteType;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.document.DocumentSortQuery;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.NotesSQLBuilder;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class SyncMdeDao implements BaseDao<NotesDocumentEntity> {
    private static final String TAG = DataLogger.createTag("SyncMdeDao");

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(@NonNull NotesDocumentEntity notesDocumentEntity) {
        return 0;
    }

    public LiveData<List<MainListDocumentData>> getAllCoeditStandAloneNoteList_LiveData(@DeleteType int i, @NonNull SortParam sortParam) {
        return rawQuery_LiveData(new SimpleSQLiteQuery(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_JOINED_TABLE).where("isDeleted = " + i).and("mdeSpaceId != ''").and("sdoc.categoryUUID='coedit:///'").orderBy(new DocumentSortQuery().createQuery(sortParam)).build()));
    }

    public List<MainListDocumentData> getCoeditEntryBySpaceId(List<String> list, SortParam sortParam) {
        return rawQuery(new SimpleSQLiteQuery(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_JOINED_TABLE).where(QueryConstants.USED_DOCUMENT_CONDITION).and("mdeSpaceId").mo12420in(QueryUtils.getCommaSeparatedString(list)).and("sdoc.categoryUUID='coedit:///'").orderBy(new DocumentSortQuery().createQuery(sortParam)).build()));
    }

    @Query("SELECT Distinct mdeGroupId FROM sdoc WHERE mdeSpaceId!=''  AND categoryUUID='coedit:///'")
    public abstract List<String> getLocalGroupIdListCoedit();

    @Query("SELECT Distinct mdeGroupId FROM sdoc WHERE mdeSpaceId!=''  AND categoryUUID!='coedit:///'")
    public abstract List<String> getLocalGroupIdListOldSharedNote();

    @Query("SELECT Distinct mdeSpaceId FROM sdoc WHERE mdeSpaceId!='' AND categoryUUID='coedit:///'")
    public abstract List<String> getLocalSpaceIdListCoedit();

    @Query("SELECT Distinct mdeSpaceId FROM sdoc WHERE mdeSpaceId!='' AND categoryUUID!='coedit:///'")
    public abstract List<String> getLocalSpaceIdListOldSharedNote();

    @Query("SELECT COUNT(*) FROM sdoc WHERE mdeSpaceId!='' AND mdeSpaceId=:mdeSpaceId AND mdeOwnerId=:mdeSpaceOwnerId")
    public abstract int getMdeOwnerNoteCount(String str, String str2);

    @Query("SELECT COUNT(*) FROM sdoc WHERE sdoc.isDeleted = 0 AND mdeSpaceId!='' AND firstOpendAt=0 AND categoryUUID='coedit:///'")
    public abstract int getUnreadCoeditNoteCount();

    @Query("SELECT COUNT(*) FROM sdoc WHERE sdoc.isDeleted = 0 AND mdeSpaceId=:spaceId AND firstOpendAt=0  AND categoryUUID='coedit:///'")
    public abstract int getUnreadCoeditNoteCount(String str);

    @Query("SELECT COUNT(*) FROM sdoc WHERE sdoc.isDeleted = 0 AND mdeSpaceId!='' AND firstOpendAt=0 AND categoryUUID!='coedit:///'")
    public abstract int getUnreadMdeNoteCount();

    @Query("SELECT COUNT(*) FROM sdoc WHERE sdoc.isDeleted = 0 AND mdeSpaceId=:spaceId AND firstOpendAt=0 AND categoryUUID!='coedit:///'")
    public abstract int getUnreadMdeNoteCount(String str);

    @Query("SELECT UUID FROM sdoc WHERE mdeGroupId=:mdeGroupId AND mdeOwnerId=:mdeOwnerId AND categoryUUID!='coedit:///'")
    public abstract List<String> getUuidListByGroupIdAndOwnerIdOld(String str, String str2);

    @Query("SELECT UUID FROM sdoc WHERE mdeGroupId=:mdeGroupId AND categoryUUID='coedit:///'")
    public abstract List<String> getUuidListByGroupIdCoedit(String str);

    @Query("SELECT UUID FROM sdoc WHERE mdeGroupId=:mdeGroupId AND categoryUUID!='coedit:///'")
    public abstract List<String> getUuidListByGroupIdOld(String str);

    @Query("SELECT UUID FROM sdoc WHERE mdeSpaceId=:mdeSpaceId AND categoryUUID='coedit:///'")
    public abstract List<String> getUuidListBySpaceIdCoedit(String str);

    @Query("SELECT UUID FROM sdoc WHERE mdeSpaceId=:mdeSpaceId AND categoryUUID!='coedit:///'")
    public abstract List<String> getUuidListBySpaceIdOld(String str);

    @Query("SELECT UUID FROM sdoc WHERE mdeSpaceId!='' AND categoryUUID='coedit:///'")
    public abstract List<String> getUuidListCoedit();

    @Query("SELECT UUID FROM sdoc WHERE mdeSpaceId!='' AND categoryUUID!='shared:///' AND categoryUUID!='coedit:///'")
    public abstract List<String> getUuidListInvalidSharedNote();

    @Query("SELECT UUID FROM sdoc WHERE mdeSpaceId!='' AND categoryUUID!='coedit:///'")
    public abstract List<String> getUuidListMde();

    @RawQuery(observedEntities = {NotesDocumentEntity.class})
    public abstract List<MainListDocumentData> internalRawQuery(SupportSQLiteQuery supportSQLiteQuery);

    @RawQuery(observedEntities = {NotesDocumentEntity.class})
    public abstract LiveData<List<MainListDocumentData>> internalRawQuery_LiveData(SupportSQLiteQuery supportSQLiteQuery);

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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(@NonNull NotesDocumentEntity notesDocumentEntity) {
        return 0;
    }
}
