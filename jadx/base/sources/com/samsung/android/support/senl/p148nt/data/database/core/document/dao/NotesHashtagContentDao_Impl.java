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
import com.samsung.android.support.senl.p148nt.data.common.legacy.OldDBSchema;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesHashtagContentEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesHashtagContentDao_Impl extends NotesHashtagContentDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<NotesHashtagContentEntity> __deletionAdapterOfNotesHashtagContentEntity;
    private final EntityInsertionAdapter<NotesHashtagContentEntity> __insertionAdapterOfNotesHashtagContentEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByHashtagUuid;
    private final SharedSQLiteStatement __preparedStmtOfDeleteBySdocUuidAndContentUuid;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByUuid;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDummy;
    private final SharedSQLiteStatement __preparedStmtOfUpdateBySdocUuidAndContentUuid;
    private final SharedSQLiteStatement __preparedStmtOfUpdateDirtyBySdocUuid;
    private final SharedSQLiteStatement __preparedStmtOfUpdateLastAddedTime;
    private final EntityDeletionOrUpdateAdapter<NotesHashtagContentEntity> __updateAdapterOfNotesHashtagContentEntity;

    public NotesHashtagContentDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNotesHashtagContentEntity = new EntityInsertionAdapter<NotesHashtagContentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagContentDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `hashtagContent` (`_id`,`sdocUUID`,`extraInfo`,`isDeleted`,`isDirty`,`serverTimestamp`,`isSyncFailed`,`hashtagUUID`,`lastModifiedAt`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesHashtagContentEntity notesHashtagContentEntity) {
                if (notesHashtagContentEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesHashtagContentEntity.getId().longValue());
                }
                if (notesHashtagContentEntity.getSdocUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesHashtagContentEntity.getSdocUuid());
                }
                if (notesHashtagContentEntity.getExtraInfo() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesHashtagContentEntity.getExtraInfo());
                }
                supportSQLiteStatement.bindLong(4, notesHashtagContentEntity.getIsDeleted());
                supportSQLiteStatement.bindLong(5, notesHashtagContentEntity.getIsDirty());
                if (notesHashtagContentEntity.getServerTimestamp() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindLong(6, notesHashtagContentEntity.getServerTimestamp().longValue());
                }
                if (notesHashtagContentEntity.getIsSyncFailed() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, notesHashtagContentEntity.getIsSyncFailed().intValue());
                }
                if (notesHashtagContentEntity.getHashtagUuid() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, notesHashtagContentEntity.getHashtagUuid());
                }
                supportSQLiteStatement.bindLong(9, notesHashtagContentEntity.getLastModifiedAt());
            }
        };
        this.__deletionAdapterOfNotesHashtagContentEntity = new EntityDeletionOrUpdateAdapter<NotesHashtagContentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagContentDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `hashtagContent` WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesHashtagContentEntity notesHashtagContentEntity) {
                if (notesHashtagContentEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesHashtagContentEntity.getId().longValue());
                }
            }
        };
        this.__updateAdapterOfNotesHashtagContentEntity = new EntityDeletionOrUpdateAdapter<NotesHashtagContentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagContentDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `hashtagContent` SET `_id` = ?,`sdocUUID` = ?,`extraInfo` = ?,`isDeleted` = ?,`isDirty` = ?,`serverTimestamp` = ?,`isSyncFailed` = ?,`hashtagUUID` = ?,`lastModifiedAt` = ? WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesHashtagContentEntity notesHashtagContentEntity) {
                if (notesHashtagContentEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesHashtagContentEntity.getId().longValue());
                }
                if (notesHashtagContentEntity.getSdocUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesHashtagContentEntity.getSdocUuid());
                }
                if (notesHashtagContentEntity.getExtraInfo() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesHashtagContentEntity.getExtraInfo());
                }
                supportSQLiteStatement.bindLong(4, notesHashtagContentEntity.getIsDeleted());
                supportSQLiteStatement.bindLong(5, notesHashtagContentEntity.getIsDirty());
                if (notesHashtagContentEntity.getServerTimestamp() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindLong(6, notesHashtagContentEntity.getServerTimestamp().longValue());
                }
                if (notesHashtagContentEntity.getIsSyncFailed() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, notesHashtagContentEntity.getIsSyncFailed().intValue());
                }
                if (notesHashtagContentEntity.getHashtagUuid() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, notesHashtagContentEntity.getHashtagUuid());
                }
                supportSQLiteStatement.bindLong(9, notesHashtagContentEntity.getLastModifiedAt());
                if (notesHashtagContentEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindLong(10, notesHashtagContentEntity.getId().longValue());
                }
            }
        };
        this.__preparedStmtOfDeleteByUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagContentDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM hashtagContent WHERE sdocUUID=?";
            }
        };
        this.__preparedStmtOfUpdateBySdocUuidAndContentUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagContentDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE hashtagContent SET serverTimestamp=?, lastModifiedAt=?, isDirty=?, extraInfo=? WHERE sdocUUID=? AND hashtagUUID=?";
            }
        };
        this.__preparedStmtOfDeleteBySdocUuidAndContentUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagContentDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM hashtagContent WHERE sdocUUID=? AND hashtagUUID=?";
            }
        };
        this.__preparedStmtOfUpdateDirtyBySdocUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagContentDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE hashtagContent SET isDirty=? WHERE sdocUUID=?";
            }
        };
        this.__preparedStmtOfDeleteByHashtagUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagContentDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM hashtagContent WHERE hashtagUUID=?";
            }
        };
        this.__preparedStmtOfDeleteDummy = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagContentDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM hashtagContent WHERE sdocUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)";
            }
        };
        this.__preparedStmtOfUpdateLastAddedTime = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesHashtagContentDao_Impl.10
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE hashtagContent SET serverTimestamp=?  WHERE sdocUUID=?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao
    public void deleteByHashtagUuid(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteByHashtagUuid.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteByHashtagUuid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao
    public void deleteBySdocUuidAndContentUuid(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteBySdocUuidAndContentUuid.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str2);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteBySdocUuidAndContentUuid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao
    public int deleteByUuids(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            int iDeleteByUuids = super.deleteByUuids(collection);
            this.__db.setTransactionSuccessful();
            return iDeleteByUuids;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao
    public NotesHashtagContentEntity getEntityBySdocUuidAndContentUuid(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM hashtagContent WHERE sdocUUID=? AND hashtagUUID=?", 2);
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
        NotesHashtagContentEntity notesHashtagContentEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sdocUUID");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extraInfo");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDeleted");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSyncFailed");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, OldDBSchema.HashTagContent.HASHTAG_UUID);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            if (cursorQuery.moveToFirst()) {
                NotesHashtagContentEntity notesHashtagContentEntity2 = new NotesHashtagContentEntity();
                notesHashtagContentEntity2.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow)));
                notesHashtagContentEntity2.setSdocUuid(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                notesHashtagContentEntity2.setExtraInfo(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                notesHashtagContentEntity2.setIsDeleted(cursorQuery.getInt(columnIndexOrThrow4));
                notesHashtagContentEntity2.setIsDirty(cursorQuery.getInt(columnIndexOrThrow5));
                notesHashtagContentEntity2.setServerTimestamp(cursorQuery.isNull(columnIndexOrThrow6) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow6)));
                notesHashtagContentEntity2.setIsSyncFailed(cursorQuery.isNull(columnIndexOrThrow7) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow7)));
                if (!cursorQuery.isNull(columnIndexOrThrow8)) {
                    string = cursorQuery.getString(columnIndexOrThrow8);
                }
                notesHashtagContentEntity2.setHashtagUuid(string);
                notesHashtagContentEntity2.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow9));
                notesHashtagContentEntity = notesHashtagContentEntity2;
            }
            return notesHashtagContentEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao
    public boolean hashTagContentExists(Collection<String> collection) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), AbstractC11014a.m12317b(sbNewStringBuilder, "SELECT 1 FROM hashtagContent WHERE sdocUUID in (", collection, sbNewStringBuilder, ")"));
        int i = 1;
        for (String str : collection) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i);
            } else {
                roomSQLiteQueryAcquire.bindString(i, str);
            }
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) != 0 : false;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao
    public boolean hashTagExists(List<String> list) {
        this.__db.beginTransaction();
        try {
            boolean zHashTagExists = super.hashTagExists(list);
            this.__db.setTransactionSuccessful();
            return zHashTagExists;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao
    public void updateBySdocUuidAndContentUuid(ArrayList<NotesHashtagContentEntity> arrayList) {
        this.__db.beginTransaction();
        try {
            super.updateBySdocUuidAndContentUuid(arrayList);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao
    public void updateDirtyBySdocUuid(String str, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateDirtyBySdocUuid.acquire();
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
            this.__preparedStmtOfUpdateDirtyBySdocUuid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao
    public void updateHashTagsBySdocUuid(NotesHashtagDao notesHashtagDao, ArrayList<NotesHashtagContentDao.HashTagExtra> arrayList) {
        this.__db.beginTransaction();
        try {
            super.updateHashTagsBySdocUuid(notesHashtagDao, arrayList);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao
    public void updateLastAddedTime(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateLastAddedTime.acquire();
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
            this.__preparedStmtOfUpdateLastAddedTime.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(NotesHashtagContentEntity notesHashtagContentEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfNotesHashtagContentEntity.handle(notesHashtagContentEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(NotesHashtagContentEntity notesHashtagContentEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfNotesHashtagContentEntity.insert(notesHashtagContentEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(NotesHashtagContentEntity notesHashtagContentEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfNotesHashtagContentEntity.handle(notesHashtagContentEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(NotesHashtagContentEntity notesHashtagContentEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(notesHashtagContentEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao
    public void updateBySdocUuidAndContentUuid(String str, String str2, long j, long j2, int i, String str3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateBySdocUuidAndContentUuid.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j);
        supportSQLiteStatementAcquire.bindLong(2, j2);
        supportSQLiteStatementAcquire.bindLong(3, i);
        if (str3 == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, str3);
        }
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(5);
        } else {
            supportSQLiteStatementAcquire.bindString(5, str);
        }
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(6);
        } else {
            supportSQLiteStatementAcquire.bindString(6, str2);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateBySdocUuidAndContentUuid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends NotesHashtagContentEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao
    public int deleteByUuid(Collection<String> collection) {
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, AbstractC11014a.m12324i(this.__db, "DELETE FROM hashtagContent WHERE sdocUUID IN ("), ")"));
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
            int iExecuteUpdateDelete = supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
        }
    }
}
