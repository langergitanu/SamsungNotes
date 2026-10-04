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
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyNoteEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class StickyNoteDao_Impl extends StickyNoteDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<StickyNoteEntity> __deletionAdapterOfStickyNoteEntity;
    private final EntityInsertionAdapter<StickyNoteEntity> __insertionAdapterOfStickyNoteEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDummy;
    private final EntityDeletionOrUpdateAdapter<StickyNoteEntity> __updateAdapterOfStickyNoteEntity;

    public StickyNoteDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfStickyNoteEntity = new EntityInsertionAdapter<StickyNoteEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.StickyNoteDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `sticky` (`objectId`,`documentUUID`,`pageUuid`,`width`,`height`,`filePath`,`lastModifiedAt`) VALUES (?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, StickyNoteEntity stickyNoteEntity) {
                if (stickyNoteEntity.getObjectId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, stickyNoteEntity.getObjectId());
                }
                if (stickyNoteEntity.getDocumentUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, stickyNoteEntity.getDocumentUuid());
                }
                if (stickyNoteEntity.getPageUuid() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, stickyNoteEntity.getPageUuid());
                }
                supportSQLiteStatement.bindLong(4, stickyNoteEntity.getWidth());
                supportSQLiteStatement.bindLong(5, stickyNoteEntity.getHeight());
                if (stickyNoteEntity.getFilePath() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, stickyNoteEntity.getFilePath());
                }
                supportSQLiteStatement.bindLong(7, stickyNoteEntity.getLastModifiedAt());
            }
        };
        this.__deletionAdapterOfStickyNoteEntity = new EntityDeletionOrUpdateAdapter<StickyNoteEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.StickyNoteDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `sticky` WHERE `objectId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, StickyNoteEntity stickyNoteEntity) {
                if (stickyNoteEntity.getObjectId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, stickyNoteEntity.getObjectId());
                }
            }
        };
        this.__updateAdapterOfStickyNoteEntity = new EntityDeletionOrUpdateAdapter<StickyNoteEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.StickyNoteDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `sticky` SET `objectId` = ?,`documentUUID` = ?,`pageUuid` = ?,`width` = ?,`height` = ?,`filePath` = ?,`lastModifiedAt` = ? WHERE `objectId` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, StickyNoteEntity stickyNoteEntity) {
                if (stickyNoteEntity.getObjectId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, stickyNoteEntity.getObjectId());
                }
                if (stickyNoteEntity.getDocumentUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, stickyNoteEntity.getDocumentUuid());
                }
                if (stickyNoteEntity.getPageUuid() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, stickyNoteEntity.getPageUuid());
                }
                supportSQLiteStatement.bindLong(4, stickyNoteEntity.getWidth());
                supportSQLiteStatement.bindLong(5, stickyNoteEntity.getHeight());
                if (stickyNoteEntity.getFilePath() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, stickyNoteEntity.getFilePath());
                }
                supportSQLiteStatement.bindLong(7, stickyNoteEntity.getLastModifiedAt());
                if (stickyNoteEntity.getObjectId() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, stickyNoteEntity.getObjectId());
                }
            }
        };
        this.__preparedStmtOfDeleteDummy = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.StickyNoteDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM sticky WHERE documentUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyNoteDao
    public void deleteByDocUuids(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            super.deleteByDocUuids(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyNoteDao
    public void deleteByDocUuidsInChunk(Collection<String> collection) {
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, AbstractC11014a.m12324i(this.__db, "DELETE FROM sticky WHERE documentUUID IN ("), ")"));
        int i = 1;
        for (String str : collection) {
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyNoteDao
    public void deleteByUuidAndPageIds(String str, List<String> list) {
        this.__db.beginTransaction();
        try {
            super.deleteByUuidAndPageIds(str, list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyNoteDao
    public void deleteByUuidAndPageIdsInChunk(String str, Collection<String> collection) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM sticky WHERE documentUUID = ");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" AND pageUuid IN (");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, sbNewStringBuilder, ")"));
        if (str == null) {
            supportSQLiteStatementCompileStatement.bindNull(1);
        } else {
            supportSQLiteStatementCompileStatement.bindString(1, str);
        }
        int i = 2;
        for (String str2 : collection) {
            if (str2 == null) {
                supportSQLiteStatementCompileStatement.bindNull(i);
            } else {
                supportSQLiteStatementCompileStatement.bindString(i, str2);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyNoteDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyNoteDao
    public void deleteNotIncluded(Collection<String> collection) {
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, AbstractC11014a.m12324i(this.__db, "DELETE FROM sticky WHERE objectId NOT IN ("), ")"));
        int i = 1;
        for (String str : collection) {
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyNoteDao
    public List<StickyNoteEntity> getEntities(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM sticky WHERE documentUUID = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "objectId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "documentUUID");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pageUuid");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "width");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "height");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filePath");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                StickyNoteEntity stickyNoteEntity = new StickyNoteEntity();
                stickyNoteEntity.setObjectId(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                stickyNoteEntity.setDocumentUuid(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                stickyNoteEntity.setPageUuid(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                stickyNoteEntity.setWidth(cursorQuery.getInt(columnIndexOrThrow4));
                stickyNoteEntity.setHeight(cursorQuery.getInt(columnIndexOrThrow5));
                stickyNoteEntity.setFilePath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                stickyNoteEntity.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow7));
                arrayList.add(stickyNoteEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyNoteDao
    public StickyNoteEntity getEntity(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM sticky WHERE objectId = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        StickyNoteEntity stickyNoteEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "objectId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "documentUUID");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pageUuid");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "width");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "height");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filePath");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            if (cursorQuery.moveToFirst()) {
                StickyNoteEntity stickyNoteEntity2 = new StickyNoteEntity();
                stickyNoteEntity2.setObjectId(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                stickyNoteEntity2.setDocumentUuid(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                stickyNoteEntity2.setPageUuid(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                stickyNoteEntity2.setWidth(cursorQuery.getInt(columnIndexOrThrow4));
                stickyNoteEntity2.setHeight(cursorQuery.getInt(columnIndexOrThrow5));
                if (!cursorQuery.isNull(columnIndexOrThrow6)) {
                    string = cursorQuery.getString(columnIndexOrThrow6);
                }
                stickyNoteEntity2.setFilePath(string);
                stickyNoteEntity2.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow7));
                stickyNoteEntity = stickyNoteEntity2;
            }
            return stickyNoteEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyNoteDao
    public void retainOnly(Map<String, StickyNoteEntity> map) {
        this.__db.beginTransaction();
        try {
            super.retainOnly(map);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(StickyNoteEntity stickyNoteEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfStickyNoteEntity.handle(stickyNoteEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(StickyNoteEntity stickyNoteEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfStickyNoteEntity.insert(stickyNoteEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(StickyNoteEntity stickyNoteEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfStickyNoteEntity.handle(stickyNoteEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(StickyNoteEntity stickyNoteEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(stickyNoteEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends StickyNoteEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
