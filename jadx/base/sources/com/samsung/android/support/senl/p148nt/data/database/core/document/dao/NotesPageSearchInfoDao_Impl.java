package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.database.Cursor;
import android.util.Pair;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesPageSearchInfoEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesPageSearchInfoDao_Impl extends NotesPageSearchInfoDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<NotesPageSearchInfoEntity> __deletionAdapterOfNotesPageSearchInfoEntity;
    private final EntityInsertionAdapter<NotesPageSearchInfoEntity> __insertionAdapterOfNotesPageSearchInfoEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDummy;
    private final EntityDeletionOrUpdateAdapter<NotesPageSearchInfoEntity> __updateAdapterOfNotesPageSearchInfoEntity;

    public NotesPageSearchInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNotesPageSearchInfoEntity = new EntityInsertionAdapter<NotesPageSearchInfoEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesPageSearchInfoDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `page_search_info` (`_id`,`sdocUUID`,`pageUuid`,`contentSource`,`searchSource`,`lastContentModifiedAt`,`lastSearchModifiedAt`,`isDirty`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesPageSearchInfoEntity notesPageSearchInfoEntity) {
                supportSQLiteStatement.bindLong(1, notesPageSearchInfoEntity.getId());
                if (notesPageSearchInfoEntity.getDocumentUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesPageSearchInfoEntity.getDocumentUuid());
                }
                if (notesPageSearchInfoEntity.getPageUuid() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesPageSearchInfoEntity.getPageUuid());
                }
                supportSQLiteStatement.bindLong(4, notesPageSearchInfoEntity.getContentSource());
                supportSQLiteStatement.bindLong(5, notesPageSearchInfoEntity.getSearchSource());
                supportSQLiteStatement.bindLong(6, notesPageSearchInfoEntity.getLastContentModifiedAt());
                supportSQLiteStatement.bindLong(7, notesPageSearchInfoEntity.getLastSearchModifiedAt());
                supportSQLiteStatement.bindLong(8, notesPageSearchInfoEntity.getIsDirty());
            }
        };
        this.__deletionAdapterOfNotesPageSearchInfoEntity = new EntityDeletionOrUpdateAdapter<NotesPageSearchInfoEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesPageSearchInfoDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `page_search_info` WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesPageSearchInfoEntity notesPageSearchInfoEntity) {
                supportSQLiteStatement.bindLong(1, notesPageSearchInfoEntity.getId());
            }
        };
        this.__updateAdapterOfNotesPageSearchInfoEntity = new EntityDeletionOrUpdateAdapter<NotesPageSearchInfoEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesPageSearchInfoDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `page_search_info` SET `_id` = ?,`sdocUUID` = ?,`pageUuid` = ?,`contentSource` = ?,`searchSource` = ?,`lastContentModifiedAt` = ?,`lastSearchModifiedAt` = ?,`isDirty` = ? WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesPageSearchInfoEntity notesPageSearchInfoEntity) {
                supportSQLiteStatement.bindLong(1, notesPageSearchInfoEntity.getId());
                if (notesPageSearchInfoEntity.getDocumentUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesPageSearchInfoEntity.getDocumentUuid());
                }
                if (notesPageSearchInfoEntity.getPageUuid() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesPageSearchInfoEntity.getPageUuid());
                }
                supportSQLiteStatement.bindLong(4, notesPageSearchInfoEntity.getContentSource());
                supportSQLiteStatement.bindLong(5, notesPageSearchInfoEntity.getSearchSource());
                supportSQLiteStatement.bindLong(6, notesPageSearchInfoEntity.getLastContentModifiedAt());
                supportSQLiteStatement.bindLong(7, notesPageSearchInfoEntity.getLastSearchModifiedAt());
                supportSQLiteStatement.bindLong(8, notesPageSearchInfoEntity.getIsDirty());
                supportSQLiteStatement.bindLong(9, notesPageSearchInfoEntity.getId());
            }
        };
        this.__preparedStmtOfDeleteDummy = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesPageSearchInfoDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM page_search_info WHERE sdocUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesPageSearchInfoDao
    public void deleteByUuid(List<String> list) {
        StringBuilder sbM12324i = AbstractC11014a.m12324i(this.__db, "DELETE FROM page_search_info WHERE sdocUUID IN (");
        StringUtil.appendPlaceholders(sbM12324i, list.size());
        sbM12324i.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbM12324i.toString());
        int i = 1;
        for (String str : list) {
            if (str == null) {
                supportSQLiteStatementCompileStatement.bindNull(i);
            } else {
                supportSQLiteStatementCompileStatement.bindString(i, str);
            }
            i++;
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesPageSearchInfoDao
    public void deleteDummy() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteDummy.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteDummy.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesPageSearchInfoDao
    public List<NotesPageSearchInfoEntity> getEntities(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM page_search_info WHERE sdocUUID=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sdocUUID");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pageUuid");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.PageSearchInfo.PAGE_CONTENT_SOURCE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.PageSearchInfo.SEARCH_SOURCE);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.PageSearchInfo.LAST_CONTENT_MODIFIED_AT);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.PageSearchInfo.LAST_SEARCH_MODIFIED_AT);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesPageSearchInfoEntity notesPageSearchInfoEntity = new NotesPageSearchInfoEntity();
                notesPageSearchInfoEntity.setId(cursorQuery.getLong(columnIndexOrThrow));
                notesPageSearchInfoEntity.setDocumentUuid(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                notesPageSearchInfoEntity.setPageUuid(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                notesPageSearchInfoEntity.setContentSource(cursorQuery.getInt(columnIndexOrThrow4));
                notesPageSearchInfoEntity.setSearchSource(cursorQuery.getInt(columnIndexOrThrow5));
                notesPageSearchInfoEntity.setLastContentModifiedAt(cursorQuery.getLong(columnIndexOrThrow6));
                notesPageSearchInfoEntity.setLastSearchModifiedAt(cursorQuery.getLong(columnIndexOrThrow7));
                notesPageSearchInfoEntity.setIsDirty(cursorQuery.getInt(columnIndexOrThrow8));
                arrayList.add(notesPageSearchInfoEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesPageSearchInfoDao
    public NotesPageSearchInfoEntity getEntity(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM page_search_info WHERE sdocUUID=? AND pageUuid=?", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.__db.assertNotSuspendingTransaction();
        NotesPageSearchInfoEntity notesPageSearchInfoEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sdocUUID");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pageUuid");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.PageSearchInfo.PAGE_CONTENT_SOURCE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.PageSearchInfo.SEARCH_SOURCE);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.PageSearchInfo.LAST_CONTENT_MODIFIED_AT);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.PageSearchInfo.LAST_SEARCH_MODIFIED_AT);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
            if (cursorQuery.moveToFirst()) {
                NotesPageSearchInfoEntity notesPageSearchInfoEntity2 = new NotesPageSearchInfoEntity();
                notesPageSearchInfoEntity2.setId(cursorQuery.getLong(columnIndexOrThrow));
                notesPageSearchInfoEntity2.setDocumentUuid(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                if (!cursorQuery.isNull(columnIndexOrThrow3)) {
                    string = cursorQuery.getString(columnIndexOrThrow3);
                }
                notesPageSearchInfoEntity2.setPageUuid(string);
                notesPageSearchInfoEntity2.setContentSource(cursorQuery.getInt(columnIndexOrThrow4));
                notesPageSearchInfoEntity2.setSearchSource(cursorQuery.getInt(columnIndexOrThrow5));
                notesPageSearchInfoEntity2.setLastContentModifiedAt(cursorQuery.getLong(columnIndexOrThrow6));
                notesPageSearchInfoEntity2.setLastSearchModifiedAt(cursorQuery.getLong(columnIndexOrThrow7));
                notesPageSearchInfoEntity2.setIsDirty(cursorQuery.getInt(columnIndexOrThrow8));
                notesPageSearchInfoEntity = notesPageSearchInfoEntity2;
            }
            return notesPageSearchInfoEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(NotesPageSearchInfoEntity notesPageSearchInfoEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfNotesPageSearchInfoEntity.handle(notesPageSearchInfoEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(NotesPageSearchInfoEntity notesPageSearchInfoEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfNotesPageSearchInfoEntity.insert(notesPageSearchInfoEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(NotesPageSearchInfoEntity notesPageSearchInfoEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfNotesPageSearchInfoEntity.handle(notesPageSearchInfoEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(NotesPageSearchInfoEntity notesPageSearchInfoEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(notesPageSearchInfoEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends NotesPageSearchInfoEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesPageSearchInfoDao
    public int delete(Collection<? extends NotesPageSearchInfoEntity> collection) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__deletionAdapterOfNotesPageSearchInfoEntity.handleMultiple(collection);
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }
}
