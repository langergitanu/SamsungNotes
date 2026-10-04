package com.samsung.android.support.senl.p148nt.data.database.temp.infra.dao;

import android.database.Cursor;
import android.util.Pair;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.database.temp.infra.entity.DeletedNoteEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class DeletedNoteDao_Impl extends DeletedNoteDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<DeletedNoteEntity> __deletionAdapterOfDeletedNoteEntity;
    private final EntityInsertionAdapter<DeletedNoteEntity> __insertionAdapterOfDeletedNoteEntity;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final EntityDeletionOrUpdateAdapter<DeletedNoteEntity> __updateAdapterOfDeletedNoteEntity;

    public DeletedNoteDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfDeletedNoteEntity = new EntityInsertionAdapter<DeletedNoteEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.temp.infra.dao.DeletedNoteDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `deleted_notes` (`_id`,`UUID`,`filePath`,`deletedBy`) VALUES (nullif(?, 0),?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, DeletedNoteEntity deletedNoteEntity) {
                supportSQLiteStatement.bindLong(1, deletedNoteEntity.getId());
                if (deletedNoteEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, deletedNoteEntity.getUuid());
                }
                if (deletedNoteEntity.getFilePath() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, deletedNoteEntity.getFilePath());
                }
                supportSQLiteStatement.bindLong(4, deletedNoteEntity.getDeletedBy());
            }
        };
        this.__deletionAdapterOfDeletedNoteEntity = new EntityDeletionOrUpdateAdapter<DeletedNoteEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.temp.infra.dao.DeletedNoteDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `deleted_notes` WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, DeletedNoteEntity deletedNoteEntity) {
                supportSQLiteStatement.bindLong(1, deletedNoteEntity.getId());
            }
        };
        this.__updateAdapterOfDeletedNoteEntity = new EntityDeletionOrUpdateAdapter<DeletedNoteEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.temp.infra.dao.DeletedNoteDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `deleted_notes` SET `_id` = ?,`UUID` = ?,`filePath` = ?,`deletedBy` = ? WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, DeletedNoteEntity deletedNoteEntity) {
                supportSQLiteStatement.bindLong(1, deletedNoteEntity.getId());
                if (deletedNoteEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, deletedNoteEntity.getUuid());
                }
                if (deletedNoteEntity.getFilePath() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, deletedNoteEntity.getFilePath());
                }
                supportSQLiteStatement.bindLong(4, deletedNoteEntity.getDeletedBy());
                supportSQLiteStatement.bindLong(5, deletedNoteEntity.getId());
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.temp.infra.dao.DeletedNoteDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM deleted_notes WHERE filePath = ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.temp.infra.dao.DeletedNoteDao
    public void deleteInChunk(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete.acquire();
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
            this.__preparedStmtOfDelete.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.temp.infra.dao.DeletedNoteDao
    public List<DeletedNoteEntity> getEntities() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `deleted_notes`.`_id` AS `_id`, `deleted_notes`.`UUID` AS `UUID`, `deleted_notes`.`filePath` AS `filePath`, `deleted_notes`.`deletedBy` AS `deletedBy` FROM deleted_notes", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                DeletedNoteEntity deletedNoteEntity = new DeletedNoteEntity();
                deletedNoteEntity.setId(cursorQuery.getLong(0));
                deletedNoteEntity.setUuid(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                deletedNoteEntity.setFilePath(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                deletedNoteEntity.setDeletedBy(cursorQuery.getInt(3));
                arrayList.add(deletedNoteEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(DeletedNoteEntity deletedNoteEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfDeletedNoteEntity.handle(deletedNoteEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(DeletedNoteEntity deletedNoteEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfDeletedNoteEntity.insert(deletedNoteEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(DeletedNoteEntity deletedNoteEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfDeletedNoteEntity.handle(deletedNoteEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(DeletedNoteEntity deletedNoteEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(deletedNoteEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends DeletedNoteEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.temp.infra.dao.DeletedNoteDao
    public void delete(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete.acquire();
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
            this.__preparedStmtOfDelete.release(supportSQLiteStatementAcquire);
        }
    }
}
