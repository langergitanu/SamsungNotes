package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.database.Cursor;
import android.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.common.legacy.OldDBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesHashtagEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesHashtagDao_Impl extends NotesHashtagDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<NotesHashtagEntity> __deletionAdapterOfNotesHashtagEntity;
    private final EntityInsertionAdapter<NotesHashtagEntity> __insertionAdapterOfNotesHashtagEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByUuid;
    private final SharedSQLiteStatement __preparedStmtOfUpdateDirtyByHashtagUuid;
    private final SharedSQLiteStatement __preparedStmtOfUpdateServerTimestampByHashtagUuid;
    private final EntityDeletionOrUpdateAdapter<NotesHashtagEntity> __updateAdapterOfNotesHashtagEntity;

    public NotesHashtagDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNotesHashtagEntity = new EntityInsertionAdapter<NotesHashtagEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `hashtag` (`_id`,`name`,`extraInfo`,`lastModifiedAt`,`isDeleted`,`isDirty`,`serverTimestamp`,`UUID`) VALUES (?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesHashtagEntity notesHashtagEntity) {
                if (notesHashtagEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesHashtagEntity.getId().longValue());
                }
                if (notesHashtagEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesHashtagEntity.getName());
                }
                if (notesHashtagEntity.getExtraInfo() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesHashtagEntity.getExtraInfo());
                }
                supportSQLiteStatement.bindLong(4, notesHashtagEntity.getLastModifiedAt());
                supportSQLiteStatement.bindLong(5, notesHashtagEntity.getIsDeleted());
                supportSQLiteStatement.bindLong(6, notesHashtagEntity.getIsDirty());
                if (notesHashtagEntity.getServerTimestamp() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, notesHashtagEntity.getServerTimestamp().longValue());
                }
                if (notesHashtagEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, notesHashtagEntity.getUuid());
                }
            }
        };
        this.__deletionAdapterOfNotesHashtagEntity = new EntityDeletionOrUpdateAdapter<NotesHashtagEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `hashtag` WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesHashtagEntity notesHashtagEntity) {
                if (notesHashtagEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesHashtagEntity.getId().longValue());
                }
            }
        };
        this.__updateAdapterOfNotesHashtagEntity = new EntityDeletionOrUpdateAdapter<NotesHashtagEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `hashtag` SET `_id` = ?,`name` = ?,`extraInfo` = ?,`lastModifiedAt` = ?,`isDeleted` = ?,`isDirty` = ?,`serverTimestamp` = ?,`UUID` = ? WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesHashtagEntity notesHashtagEntity) {
                if (notesHashtagEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesHashtagEntity.getId().longValue());
                }
                if (notesHashtagEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesHashtagEntity.getName());
                }
                if (notesHashtagEntity.getExtraInfo() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesHashtagEntity.getExtraInfo());
                }
                supportSQLiteStatement.bindLong(4, notesHashtagEntity.getLastModifiedAt());
                supportSQLiteStatement.bindLong(5, notesHashtagEntity.getIsDeleted());
                supportSQLiteStatement.bindLong(6, notesHashtagEntity.getIsDirty());
                if (notesHashtagEntity.getServerTimestamp() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, notesHashtagEntity.getServerTimestamp().longValue());
                }
                if (notesHashtagEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, notesHashtagEntity.getUuid());
                }
                if (notesHashtagEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindLong(9, notesHashtagEntity.getId().longValue());
                }
            }
        };
        this.__preparedStmtOfDeleteByUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM hashtag WHERE UUID=?";
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM hashtag";
            }
        };
        this.__preparedStmtOfUpdateDirtyByHashtagUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE hashtag SET isDirty =?  WHERE UUID=?";
            }
        };
        this.__preparedStmtOfUpdateServerTimestampByHashtagUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE hashtag SET serverTimestamp =?  WHERE UUID=?";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: __entityCursorConverter_comSamsungAndroidSupportSenlNtDataDatabaseCoreDocumentEntityNotesHashtagEntity */
    public NotesHashtagEntity m12378xe9dd5d37(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("name");
        int columnIndex3 = cursor.getColumnIndex("extraInfo");
        int columnIndex4 = cursor.getColumnIndex("lastModifiedAt");
        int columnIndex5 = cursor.getColumnIndex("isDeleted");
        int columnIndex6 = cursor.getColumnIndex("isDirty");
        int columnIndex7 = cursor.getColumnIndex("serverTimestamp");
        int columnIndex8 = cursor.getColumnIndex("UUID");
        NotesHashtagEntity notesHashtagEntity = new NotesHashtagEntity();
        if (columnIndex != -1) {
            notesHashtagEntity.setId(cursor.isNull(columnIndex) ? null : Long.valueOf(cursor.getLong(columnIndex)));
        }
        if (columnIndex2 != -1) {
            notesHashtagEntity.setName(cursor.isNull(columnIndex2) ? null : cursor.getString(columnIndex2));
        }
        if (columnIndex3 != -1) {
            notesHashtagEntity.setExtraInfo(cursor.isNull(columnIndex3) ? null : cursor.getString(columnIndex3));
        }
        if (columnIndex4 != -1) {
            notesHashtagEntity.setLastModifiedAt(cursor.getLong(columnIndex4));
        }
        if (columnIndex5 != -1) {
            notesHashtagEntity.setIsDeleted(cursor.getInt(columnIndex5));
        }
        if (columnIndex6 != -1) {
            notesHashtagEntity.setIsDirty(cursor.getInt(columnIndex6));
        }
        if (columnIndex7 != -1) {
            notesHashtagEntity.setServerTimestamp(cursor.isNull(columnIndex7) ? null : Long.valueOf(cursor.getLong(columnIndex7)));
        }
        if (columnIndex8 != -1) {
            notesHashtagEntity.setUuid(cursor.isNull(columnIndex8) ? null : cursor.getString(columnIndex8));
        }
        return notesHashtagEntity;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagDao
    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagDao
    public void deleteByUuid(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            super.deleteByUuid(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagDao
    public List<NotesHashtagEntity> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `hashtag`.`_id` AS `_id`, `hashtag`.`name` AS `name`, `hashtag`.`extraInfo` AS `extraInfo`, `hashtag`.`lastModifiedAt` AS `lastModifiedAt`, `hashtag`.`isDeleted` AS `isDeleted`, `hashtag`.`isDirty` AS `isDirty`, `hashtag`.`serverTimestamp` AS `serverTimestamp`, `hashtag`.`UUID` AS `UUID`  FROM hashtag", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesHashtagEntity notesHashtagEntity = new NotesHashtagEntity();
                notesHashtagEntity.setId(cursorQuery.isNull(0) ? null : Long.valueOf(cursorQuery.getLong(0)));
                notesHashtagEntity.setName(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                notesHashtagEntity.setExtraInfo(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                notesHashtagEntity.setLastModifiedAt(cursorQuery.getLong(3));
                notesHashtagEntity.setIsDeleted(cursorQuery.getInt(4));
                notesHashtagEntity.setIsDirty(cursorQuery.getInt(5));
                notesHashtagEntity.setServerTimestamp(cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6)));
                notesHashtagEntity.setUuid(cursorQuery.isNull(7) ? null : cursorQuery.getString(7));
                arrayList.add(notesHashtagEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagDao
    public NotesHashtagEntity getEntity(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM hashtag WHERE UUID=? LIMIT 1", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        NotesHashtagEntity notesHashtagEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extraInfo");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDeleted");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            if (cursorQuery.moveToFirst()) {
                NotesHashtagEntity notesHashtagEntity2 = new NotesHashtagEntity();
                notesHashtagEntity2.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow)));
                notesHashtagEntity2.setName(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                notesHashtagEntity2.setExtraInfo(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                notesHashtagEntity2.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow4));
                notesHashtagEntity2.setIsDeleted(cursorQuery.getInt(columnIndexOrThrow5));
                notesHashtagEntity2.setIsDirty(cursorQuery.getInt(columnIndexOrThrow6));
                notesHashtagEntity2.setServerTimestamp(cursorQuery.isNull(columnIndexOrThrow7) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow7)));
                if (!cursorQuery.isNull(columnIndexOrThrow8)) {
                    string = cursorQuery.getString(columnIndexOrThrow8);
                }
                notesHashtagEntity2.setUuid(string);
                notesHashtagEntity = notesHashtagEntity2;
            }
            return notesHashtagEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagDao
    public String getHashTagUuidWithDeleted(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM hashtag WHERE name=? LIMIT 1", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                string = cursorQuery.getString(0);
            }
            return string;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagDao
    public String getHashTagUuidWithDeletedIgnoreCase(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM hashtag WHERE name=? COLLATE NOCASE LIMIT 1", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                string = cursorQuery.getString(0);
            }
            return string;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagDao
    public String getHashTagUuidWithoutDeleted(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM hashtag WHERE name=? AND isDeleted=0 LIMIT 1", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                string = cursorQuery.getString(0);
            }
            return string;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagDao
    public String getHashTagUuidWithoutDeletedIgnoreCase(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM hashtag WHERE name=? COLLATE NOCASE AND isDeleted=0 LIMIT 1", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                string = cursorQuery.getString(0);
            }
            return string;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagDao
    public List<NotesHashtagEntity> rawQuery(SupportSQLiteQuery supportSQLiteQuery) {
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, supportSQLiteQuery, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(m12378xe9dd5d37(cursorQuery));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagDao
    public LiveData<List<NotesHashtagEntity>> rawQuery_LiveData(final SupportSQLiteQuery supportSQLiteQuery) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{OldDBSchema.HashTag.TABLE_NAME}, false, new Callable<List<NotesHashtagEntity>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagDao_Impl.8
            @Override // java.util.concurrent.Callable
            public List<NotesHashtagEntity> call() {
                Cursor cursorQuery = DBUtil.query(NotesHashtagDao_Impl.this.__db, supportSQLiteQuery, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(NotesHashtagDao_Impl.this.m12378xe9dd5d37(cursorQuery));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagDao
    public void updateDirtyByHashtagUuid(String str, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateDirtyByHashtagUuid.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateDirtyByHashtagUuid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagDao
    public void updateServerTimestampByHashtagUuid(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateServerTimestampByHashtagUuid.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateServerTimestampByHashtagUuid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(NotesHashtagEntity notesHashtagEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfNotesHashtagEntity.handle(notesHashtagEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(NotesHashtagEntity notesHashtagEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfNotesHashtagEntity.insert(notesHashtagEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(NotesHashtagEntity notesHashtagEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfNotesHashtagEntity.handle(notesHashtagEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(NotesHashtagEntity notesHashtagEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(notesHashtagEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagDao
    public int deleteByUuid(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteByUuid.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteByUuid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends NotesHashtagEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
