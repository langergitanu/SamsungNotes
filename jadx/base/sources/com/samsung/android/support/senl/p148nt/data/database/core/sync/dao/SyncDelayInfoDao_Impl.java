package com.samsung.android.support.senl.p148nt.data.database.core.sync.dao;

import android.database.Cursor;
import android.util.Pair;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncDelayInfoEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class SyncDelayInfoDao_Impl extends SyncDelayInfoDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<SyncDelayInfoEntity> __deletionAdapterOfSyncDelayInfoEntity;
    private final EntityInsertionAdapter<SyncDelayInfoEntity> __insertionAdapterOfSyncDelayInfoEntity;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final EntityDeletionOrUpdateAdapter<SyncDelayInfoEntity> __updateAdapterOfSyncDelayInfoEntity;

    public SyncDelayInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSyncDelayInfoEntity = new EntityInsertionAdapter<SyncDelayInfoEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncDelayInfoDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `sync_delay_info` (`UUID`,`serverId`,`appVersion`,`reason`,`retryCount`,`serverTimestamp`,`upSync`,`extra`) VALUES (?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SyncDelayInfoEntity syncDelayInfoEntity) {
                if (syncDelayInfoEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, syncDelayInfoEntity.getUuid());
                }
                if (syncDelayInfoEntity.getServerId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, syncDelayInfoEntity.getServerId());
                }
                if (syncDelayInfoEntity.getAppVersion() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, syncDelayInfoEntity.getAppVersion());
                }
                supportSQLiteStatement.bindLong(4, syncDelayInfoEntity.getReason());
                supportSQLiteStatement.bindLong(5, syncDelayInfoEntity.getRetryCount());
                supportSQLiteStatement.bindLong(6, syncDelayInfoEntity.getServerTimestamp());
                supportSQLiteStatement.bindLong(7, syncDelayInfoEntity.getUpSync());
                if (syncDelayInfoEntity.getExtra() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, syncDelayInfoEntity.getExtra());
                }
            }
        };
        this.__deletionAdapterOfSyncDelayInfoEntity = new EntityDeletionOrUpdateAdapter<SyncDelayInfoEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncDelayInfoDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `sync_delay_info` WHERE `UUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SyncDelayInfoEntity syncDelayInfoEntity) {
                if (syncDelayInfoEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, syncDelayInfoEntity.getUuid());
                }
            }
        };
        this.__updateAdapterOfSyncDelayInfoEntity = new EntityDeletionOrUpdateAdapter<SyncDelayInfoEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncDelayInfoDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `sync_delay_info` SET `UUID` = ?,`serverId` = ?,`appVersion` = ?,`reason` = ?,`retryCount` = ?,`serverTimestamp` = ?,`upSync` = ?,`extra` = ? WHERE `UUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SyncDelayInfoEntity syncDelayInfoEntity) {
                if (syncDelayInfoEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, syncDelayInfoEntity.getUuid());
                }
                if (syncDelayInfoEntity.getServerId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, syncDelayInfoEntity.getServerId());
                }
                if (syncDelayInfoEntity.getAppVersion() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, syncDelayInfoEntity.getAppVersion());
                }
                supportSQLiteStatement.bindLong(4, syncDelayInfoEntity.getReason());
                supportSQLiteStatement.bindLong(5, syncDelayInfoEntity.getRetryCount());
                supportSQLiteStatement.bindLong(6, syncDelayInfoEntity.getServerTimestamp());
                supportSQLiteStatement.bindLong(7, syncDelayInfoEntity.getUpSync());
                if (syncDelayInfoEntity.getExtra() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, syncDelayInfoEntity.getExtra());
                }
                if (syncDelayInfoEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, syncDelayInfoEntity.getUuid());
                }
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncDelayInfoDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM sync_delay_info WHERE UUID = ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDelayInfoDao
    public SyncDelayInfoEntity getEntity(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM sync_delay_info WHERE UUID = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        SyncDelayInfoEntity syncDelayInfoEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appVersion");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reason");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SyncDBSchema.SyncDelayInfo.RETRY_COUNT);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SyncDBSchema.SyncDelayInfo.UP_SYNC);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            if (cursorQuery.moveToFirst()) {
                SyncDelayInfoEntity syncDelayInfoEntity2 = new SyncDelayInfoEntity();
                syncDelayInfoEntity2.setUuid(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                syncDelayInfoEntity2.setServerId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                syncDelayInfoEntity2.setAppVersion(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                syncDelayInfoEntity2.setReason(cursorQuery.getInt(columnIndexOrThrow4));
                syncDelayInfoEntity2.setRetryCount(cursorQuery.getInt(columnIndexOrThrow5));
                syncDelayInfoEntity2.setServerTimestamp(cursorQuery.getLong(columnIndexOrThrow6));
                syncDelayInfoEntity2.setUpSync(cursorQuery.getInt(columnIndexOrThrow7));
                if (!cursorQuery.isNull(columnIndexOrThrow8)) {
                    string = cursorQuery.getString(columnIndexOrThrow8);
                }
                syncDelayInfoEntity2.setExtra(string);
                syncDelayInfoEntity = syncDelayInfoEntity2;
            }
            return syncDelayInfoEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDelayInfoDao
    public List<SyncDelayInfoEntity> getEntityList() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `sync_delay_info`.`UUID` AS `UUID`, `sync_delay_info`.`serverId` AS `serverId`, `sync_delay_info`.`appVersion` AS `appVersion`, `sync_delay_info`.`reason` AS `reason`, `sync_delay_info`.`retryCount` AS `retryCount`, `sync_delay_info`.`serverTimestamp` AS `serverTimestamp`, `sync_delay_info`.`upSync` AS `upSync`, `sync_delay_info`.`extra` AS `extra` FROM sync_delay_info", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                SyncDelayInfoEntity syncDelayInfoEntity = new SyncDelayInfoEntity();
                syncDelayInfoEntity.setUuid(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                syncDelayInfoEntity.setServerId(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                syncDelayInfoEntity.setAppVersion(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                syncDelayInfoEntity.setReason(cursorQuery.getInt(3));
                syncDelayInfoEntity.setRetryCount(cursorQuery.getInt(4));
                syncDelayInfoEntity.setServerTimestamp(cursorQuery.getLong(5));
                syncDelayInfoEntity.setUpSync(cursorQuery.getInt(6));
                syncDelayInfoEntity.setExtra(cursorQuery.isNull(7) ? null : cursorQuery.getString(7));
                arrayList.add(syncDelayInfoEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(SyncDelayInfoEntity syncDelayInfoEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfSyncDelayInfoEntity.handle(syncDelayInfoEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(SyncDelayInfoEntity syncDelayInfoEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSyncDelayInfoEntity.insert(syncDelayInfoEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(SyncDelayInfoEntity syncDelayInfoEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfSyncDelayInfoEntity.handle(syncDelayInfoEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(SyncDelayInfoEntity syncDelayInfoEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(syncDelayInfoEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends SyncDelayInfoEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDelayInfoDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDelayInfoDao
    public List<SyncDelayInfoEntity> getEntityList(String str, int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM sync_delay_info WHERE appVersion != ? OR (appVersion = ? AND retryCount < ?)", 3);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str);
        }
        roomSQLiteQueryAcquire.bindLong(3, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appVersion");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reason");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SyncDBSchema.SyncDelayInfo.RETRY_COUNT);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SyncDBSchema.SyncDelayInfo.UP_SYNC);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extra");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                SyncDelayInfoEntity syncDelayInfoEntity = new SyncDelayInfoEntity();
                syncDelayInfoEntity.setUuid(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                syncDelayInfoEntity.setServerId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                syncDelayInfoEntity.setAppVersion(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                syncDelayInfoEntity.setReason(cursorQuery.getInt(columnIndexOrThrow4));
                syncDelayInfoEntity.setRetryCount(cursorQuery.getInt(columnIndexOrThrow5));
                syncDelayInfoEntity.setServerTimestamp(cursorQuery.getLong(columnIndexOrThrow6));
                syncDelayInfoEntity.setUpSync(cursorQuery.getInt(columnIndexOrThrow7));
                syncDelayInfoEntity.setExtra(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                arrayList.add(syncDelayInfoEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }
}
