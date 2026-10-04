package com.samsung.android.support.senl.p148nt.data.database.core.sync.dao;

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
import androidx.room.util.StringUtil;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncInfoEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class SyncInfoDao_Impl extends SyncInfoDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<SyncInfoEntity> __deletionAdapterOfSyncInfoEntity;
    private final EntityInsertionAdapter<SyncInfoEntity> __insertionAdapterOfSyncInfoEntity;
    private final SharedSQLiteStatement __preparedStmtOfAddSyncStateFlag;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByUuid;
    private final SharedSQLiteStatement __preparedStmtOfRemoveSyncStateFlag;
    private final SharedSQLiteStatement __preparedStmtOfResetAllIsSyncFailed;
    private final SharedSQLiteStatement __preparedStmtOfResetDeletedNoteInServer;
    private final SharedSQLiteStatement __preparedStmtOfSetExtraInfoDirty;
    private final SharedSQLiteStatement __preparedStmtOfSetStrokeGrouped;
    private final SharedSQLiteStatement __preparedStmtOfUpdateCheckPoint;
    private final SharedSQLiteStatement __preparedStmtOfUpdateCommitId;
    private final SharedSQLiteStatement __preparedStmtOfUpdateConflict;
    private final SharedSQLiteStatement __preparedStmtOfUpdateConflictStrategy;
    private final SharedSQLiteStatement __preparedStmtOfUpdateIsDirtyByIsSyncFailed;
    private final SharedSQLiteStatement __preparedStmtOfUpdateIsSyncFailed;
    private final SharedSQLiteStatement __preparedStmtOfUpdateResourceId;
    private final SharedSQLiteStatement __preparedStmtOfUpdateServerId;
    private final SharedSQLiteStatement __preparedStmtOfUpdateSyncState;
    private final EntityDeletionOrUpdateAdapter<SyncInfoEntity> __updateAdapterOfSyncInfoEntity;

    public SyncInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSyncInfoEntity = new EntityInsertionAdapter<SyncInfoEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `sync_info` (`_id`,`serverId`,`clientId`,`clientModifiedTime`,`isDirtyFolder`,`clientModifiedTimeFolder`,`lastModifiedTimeFolder`,`isSyncFailed`,`isExtraInfoDirty`,`commitId`,`deviceName`,`conflict`,`conflictStrategy`,`coeditResourceId`,`coeditCheckPoint`,`syncState`,`strokeGrouped`,`deletedBy`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SyncInfoEntity syncInfoEntity) {
                if (syncInfoEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, syncInfoEntity.getId().longValue());
                }
                if (syncInfoEntity.getNoteServerId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, syncInfoEntity.getNoteServerId());
                }
                if (syncInfoEntity.getNoteClientId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, syncInfoEntity.getNoteClientId());
                }
                supportSQLiteStatement.bindLong(4, syncInfoEntity.getClientModifiedTime());
                supportSQLiteStatement.bindLong(5, syncInfoEntity.getIsDirtyFolder());
                supportSQLiteStatement.bindLong(6, syncInfoEntity.getClientModifiedTimeFolder());
                supportSQLiteStatement.bindLong(7, syncInfoEntity.getLastModifiedTimeFolder());
                supportSQLiteStatement.bindLong(8, syncInfoEntity.getIsSyncFailed());
                supportSQLiteStatement.bindLong(9, syncInfoEntity.getIsExtraInfoDirty());
                if (syncInfoEntity.getCommitId() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, syncInfoEntity.getCommitId());
                }
                if (syncInfoEntity.getDeviceName() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, syncInfoEntity.getDeviceName());
                }
                supportSQLiteStatement.bindLong(12, syncInfoEntity.getConflict());
                supportSQLiteStatement.bindLong(13, syncInfoEntity.getConflictStrategy());
                if (syncInfoEntity.getCoeditResourceId() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, syncInfoEntity.getCoeditResourceId());
                }
                supportSQLiteStatement.bindLong(15, syncInfoEntity.getCoeditCheckPoint());
                supportSQLiteStatement.bindLong(16, syncInfoEntity.getSyncState());
                supportSQLiteStatement.bindLong(17, syncInfoEntity.getStrokeGrouped());
                supportSQLiteStatement.bindLong(18, syncInfoEntity.getDeletedBy());
            }
        };
        this.__deletionAdapterOfSyncInfoEntity = new EntityDeletionOrUpdateAdapter<SyncInfoEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `sync_info` WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SyncInfoEntity syncInfoEntity) {
                if (syncInfoEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, syncInfoEntity.getId().longValue());
                }
            }
        };
        this.__updateAdapterOfSyncInfoEntity = new EntityDeletionOrUpdateAdapter<SyncInfoEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `sync_info` SET `_id` = ?,`serverId` = ?,`clientId` = ?,`clientModifiedTime` = ?,`isDirtyFolder` = ?,`clientModifiedTimeFolder` = ?,`lastModifiedTimeFolder` = ?,`isSyncFailed` = ?,`isExtraInfoDirty` = ?,`commitId` = ?,`deviceName` = ?,`conflict` = ?,`conflictStrategy` = ?,`coeditResourceId` = ?,`coeditCheckPoint` = ?,`syncState` = ?,`strokeGrouped` = ?,`deletedBy` = ? WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SyncInfoEntity syncInfoEntity) {
                if (syncInfoEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, syncInfoEntity.getId().longValue());
                }
                if (syncInfoEntity.getNoteServerId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, syncInfoEntity.getNoteServerId());
                }
                if (syncInfoEntity.getNoteClientId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, syncInfoEntity.getNoteClientId());
                }
                supportSQLiteStatement.bindLong(4, syncInfoEntity.getClientModifiedTime());
                supportSQLiteStatement.bindLong(5, syncInfoEntity.getIsDirtyFolder());
                supportSQLiteStatement.bindLong(6, syncInfoEntity.getClientModifiedTimeFolder());
                supportSQLiteStatement.bindLong(7, syncInfoEntity.getLastModifiedTimeFolder());
                supportSQLiteStatement.bindLong(8, syncInfoEntity.getIsSyncFailed());
                supportSQLiteStatement.bindLong(9, syncInfoEntity.getIsExtraInfoDirty());
                if (syncInfoEntity.getCommitId() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, syncInfoEntity.getCommitId());
                }
                if (syncInfoEntity.getDeviceName() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, syncInfoEntity.getDeviceName());
                }
                supportSQLiteStatement.bindLong(12, syncInfoEntity.getConflict());
                supportSQLiteStatement.bindLong(13, syncInfoEntity.getConflictStrategy());
                if (syncInfoEntity.getCoeditResourceId() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, syncInfoEntity.getCoeditResourceId());
                }
                supportSQLiteStatement.bindLong(15, syncInfoEntity.getCoeditCheckPoint());
                supportSQLiteStatement.bindLong(16, syncInfoEntity.getSyncState());
                supportSQLiteStatement.bindLong(17, syncInfoEntity.getStrokeGrouped());
                supportSQLiteStatement.bindLong(18, syncInfoEntity.getDeletedBy());
                if (syncInfoEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindLong(19, syncInfoEntity.getId().longValue());
                }
            }
        };
        this.__preparedStmtOfDeleteByUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM sync_info WHERE clientId=?";
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM sync_info";
            }
        };
        this.__preparedStmtOfUpdateServerId = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sync_info SET serverId=? WHERE clientId=?";
            }
        };
        this.__preparedStmtOfResetAllIsSyncFailed = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE sync_info SET isSyncFailed=? ";
            }
        };
        this.__preparedStmtOfUpdateIsDirtyByIsSyncFailed = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE sdoc SET isDirty=?  WHERE UUID IN (SELECT clientId FROM sync_info WHERE isSyncFailed=?)";
            }
        };
        this.__preparedStmtOfUpdateIsSyncFailed = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE sync_info SET isSyncFailed=?  WHERE clientId=?";
            }
        };
        this.__preparedStmtOfSetExtraInfoDirty = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.10
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE sync_info SET isExtraInfoDirty=?  WHERE clientId=?";
            }
        };
        this.__preparedStmtOfUpdateCommitId = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.11
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sync_info SET commitId=? WHERE clientId=?";
            }
        };
        this.__preparedStmtOfUpdateCheckPoint = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.12
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sync_info SET coeditCheckPoint=? WHERE clientId=?";
            }
        };
        this.__preparedStmtOfUpdateConflict = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.13
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sync_info SET `conflict`=? , deviceName=? , conflictStrategy=? WHERE clientId=?";
            }
        };
        this.__preparedStmtOfUpdateConflictStrategy = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.14
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sync_info SET conflictStrategy=? WHERE clientId=?";
            }
        };
        this.__preparedStmtOfResetDeletedNoteInServer = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.15
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sync_info SET serverId='' , commitId='' , `conflict`=0 , conflictStrategy=0 WHERE clientId=?";
            }
        };
        this.__preparedStmtOfUpdateResourceId = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.16
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sync_info SET coeditResourceId=? WHERE clientId=?";
            }
        };
        this.__preparedStmtOfUpdateSyncState = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.17
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sync_info SET syncState=? WHERE clientId=?";
            }
        };
        this.__preparedStmtOfAddSyncStateFlag = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.18
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sync_info SET syncState= (syncState | ?) WHERE clientId=?";
            }
        };
        this.__preparedStmtOfRemoveSyncStateFlag = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.19
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sync_info SET syncState=(syncState & ~?) WHERE clientId=?";
            }
        };
        this.__preparedStmtOfSetStrokeGrouped = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.20
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sync_info SET strokeGrouped=? WHERE clientId=?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public void addSyncStateFlag(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfAddSyncStateFlag.acquire();
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
            this.__preparedStmtOfAddSyncStateFlag.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public List<SyncInfoEntity> dumpSyncInfo() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `sync_info`.`_id` AS `_id`, `sync_info`.`serverId` AS `serverId`, `sync_info`.`clientId` AS `clientId`, `sync_info`.`clientModifiedTime` AS `clientModifiedTime`, `sync_info`.`isDirtyFolder` AS `isDirtyFolder`, `sync_info`.`clientModifiedTimeFolder` AS `clientModifiedTimeFolder`, `sync_info`.`lastModifiedTimeFolder` AS `lastModifiedTimeFolder`, `sync_info`.`isSyncFailed` AS `isSyncFailed`, `sync_info`.`isExtraInfoDirty` AS `isExtraInfoDirty`, `sync_info`.`commitId` AS `commitId`, `sync_info`.`deviceName` AS `deviceName`, `sync_info`.`conflict` AS `conflict`, `sync_info`.`conflictStrategy` AS `conflictStrategy`, `sync_info`.`coeditResourceId` AS `coeditResourceId`, `sync_info`.`coeditCheckPoint` AS `coeditCheckPoint`, `sync_info`.`syncState` AS `syncState`, `sync_info`.`strokeGrouped` AS `strokeGrouped`, `sync_info`.`deletedBy` AS `deletedBy` FROM sync_info ORDER BY clientId ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                SyncInfoEntity syncInfoEntity = new SyncInfoEntity();
                syncInfoEntity.setId(cursorQuery.isNull(0) ? null : Long.valueOf(cursorQuery.getLong(0)));
                syncInfoEntity.setNoteServerId(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                syncInfoEntity.setNoteClientId(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                syncInfoEntity.setClientModifiedTime(cursorQuery.getLong(3));
                syncInfoEntity.setIsDirtyFolder(cursorQuery.getInt(4));
                syncInfoEntity.setClientModifiedTimeFolder(cursorQuery.getLong(5));
                syncInfoEntity.setLastModifiedTimeFolder(cursorQuery.getLong(6));
                syncInfoEntity.setIsSyncFailed(cursorQuery.getInt(7));
                syncInfoEntity.setIsExtraInfoDirty(cursorQuery.getInt(8));
                syncInfoEntity.setCommitId(cursorQuery.isNull(9) ? null : cursorQuery.getString(9));
                syncInfoEntity.setDeviceName(cursorQuery.isNull(10) ? null : cursorQuery.getString(10));
                syncInfoEntity.setConflict(cursorQuery.getInt(11));
                syncInfoEntity.setConflictStrategy(cursorQuery.getInt(12));
                syncInfoEntity.setCoeditResourceId(cursorQuery.isNull(13) ? null : cursorQuery.getString(13));
                syncInfoEntity.setCoeditCheckPoint(cursorQuery.getLong(14));
                syncInfoEntity.setSyncState(cursorQuery.getLong(15));
                syncInfoEntity.setStrokeGrouped(cursorQuery.getInt(16));
                syncInfoEntity.setDeletedBy(cursorQuery.getInt(17));
                arrayList.add(syncInfoEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public long getCheckPoint(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT coeditCheckPoint FROM sync_info WHERE clientId=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getLong(0) : 0L;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public String getCommitId(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT commitId FROM sync_info WHERE clientId=?", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public int getConflictStrategy(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT conflictStrategy FROM sync_info WHERE clientId=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public String getDeviceName(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT deviceName FROM sync_info WHERE clientId=?", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public int getDirtyCountOfNoteExtraInfo() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*)  FROM sdoc LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId WHERE isExtraInfoDirty=1 AND (sdoc.filePath LIKE '%.sdoc')", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public SyncInfoEntity getEntity(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        SyncInfoEntity syncInfoEntity;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM sync_info WHERE clientId=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SyncDBSchema.SyncInfo.CLIENT_ID);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SyncDBSchema.SyncInfo.CLIENT_MODIFIED_TIME);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SyncDBSchema.SyncInfo.IS_DIRTY_FOLDER);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SyncDBSchema.SyncInfo.CLIENT_MODIFIED_TIME_FOLDER);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SyncDBSchema.SyncInfo.LAST_MODIFIED_TIME_FOLDER);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSyncFailed");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SyncDBSchema.SyncInfo.IS_EXTRA_INFO_DIRTY);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SyncDBSchema.SyncInfo.COMMIT_ID);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceName");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "conflict");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SyncDBSchema.SyncInfo.CONFLICT_STRATEGY);
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SyncDBSchema.SyncInfo.COEDIT_RESOURCE_ID);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SyncDBSchema.SyncInfo.COEDIT_CHECKPOINT);
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SyncDBSchema.SyncInfo.SYNC_STATE);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SyncDBSchema.SyncInfo.STROKE_GROUPED);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deletedBy");
                if (cursorQuery.moveToFirst()) {
                    SyncInfoEntity syncInfoEntity2 = new SyncInfoEntity();
                    syncInfoEntity2.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow)));
                    syncInfoEntity2.setNoteServerId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    syncInfoEntity2.setNoteClientId(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    syncInfoEntity2.setClientModifiedTime(cursorQuery.getLong(columnIndexOrThrow4));
                    syncInfoEntity2.setIsDirtyFolder(cursorQuery.getInt(columnIndexOrThrow5));
                    syncInfoEntity2.setClientModifiedTimeFolder(cursorQuery.getLong(columnIndexOrThrow6));
                    syncInfoEntity2.setLastModifiedTimeFolder(cursorQuery.getLong(columnIndexOrThrow7));
                    syncInfoEntity2.setIsSyncFailed(cursorQuery.getInt(columnIndexOrThrow8));
                    syncInfoEntity2.setIsExtraInfoDirty(cursorQuery.getInt(columnIndexOrThrow9));
                    syncInfoEntity2.setCommitId(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    syncInfoEntity2.setDeviceName(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    syncInfoEntity2.setConflict(cursorQuery.getInt(columnIndexOrThrow12));
                    syncInfoEntity2.setConflictStrategy(cursorQuery.getInt(columnIndexOrThrow13));
                    syncInfoEntity2.setCoeditResourceId(cursorQuery.isNull(columnIndexOrThrow14) ? null : cursorQuery.getString(columnIndexOrThrow14));
                    syncInfoEntity2.setCoeditCheckPoint(cursorQuery.getLong(columnIndexOrThrow15));
                    syncInfoEntity2.setSyncState(cursorQuery.getLong(columnIndexOrThrow16));
                    syncInfoEntity2.setStrokeGrouped(cursorQuery.getInt(columnIndexOrThrow17));
                    syncInfoEntity2.setDeletedBy(cursorQuery.getInt(columnIndexOrThrow18));
                    syncInfoEntity = syncInfoEntity2;
                } else {
                    syncInfoEntity = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return syncInfoEntity;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public String getResourceId(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT coeditResourceId FROM sync_info WHERE clientId=?", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public String getServerId(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT serverId FROM sync_info WHERE clientId=?", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public int getStrokeGrouped(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT strokeGrouped FROM sync_info WHERE clientId=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public long getSyncStateFlag(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT syncState FROM sync_info WHERE clientId=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getLong(0) : 0L;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public List<String> getUuidListByConflictStrategy(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT clientId FROM sync_info WHERE `conflict`=1 AND conflictStrategy=?", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public List<String> getUuidListByDirtyForExtraInfo(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT sdoc.UUID  FROM sdoc LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId WHERE isExtraInfoDirty=?  AND (sdoc.filePath LIKE '%.sdoc')", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public List<String> getUuidListBySyncState(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT clientId FROM sync_info WHERE (syncState & ?)", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public int isConflicted(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `conflict` FROM sync_info WHERE clientId=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public LiveData<Integer> isConflicted_LiveData(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `conflict` FROM sync_info WHERE clientId=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{SyncDBSchema.SyncInfo.TABLE_NAME}, false, new Callable<Integer>() { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncInfoDao_Impl.21
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() {
                Integer numValueOf = null;
                Cursor cursorQuery = DBUtil.query(SyncInfoDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                        numValueOf = Integer.valueOf(cursorQuery.getInt(0));
                    }
                    return numValueOf;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public boolean isExistByClientId(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT 1 FROM sync_info WHERE clientId=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        boolean z = false;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                z = cursorQuery.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public Cursor rawQuery(SupportSQLiteQuery supportSQLiteQuery) {
        return this.__db.query(supportSQLiteQuery);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public void removeSyncStateFlag(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfRemoveSyncStateFlag.acquire();
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
            this.__preparedStmtOfRemoveSyncStateFlag.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public void resetAllIsSyncFailed(int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfResetAllIsSyncFailed.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i);
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetAllIsSyncFailed.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public void resetDeletedNoteInServer(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfResetDeletedNoteInServer.acquire();
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
            this.__preparedStmtOfResetDeletedNoteInServer.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public void setExtraInfoDirty(String str, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSetExtraInfoDirty.acquire();
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
            this.__preparedStmtOfSetExtraInfoDirty.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public void setStrokeGrouped(String str, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSetStrokeGrouped.acquire();
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
            this.__preparedStmtOfSetStrokeGrouped.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public void updateCheckPoint(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateCheckPoint.acquire();
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
            this.__preparedStmtOfUpdateCheckPoint.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public void updateCommitId(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateCommitId.acquire();
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str2);
        }
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
            this.__preparedStmtOfUpdateCommitId.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public void updateConflict(String str, int i, String str2, int i2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateConflict.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i);
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str2);
        }
        supportSQLiteStatementAcquire.bindLong(3, i2);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, str);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateConflict.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public void updateConflictStrategy(String str, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateConflictStrategy.acquire();
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
            this.__preparedStmtOfUpdateConflictStrategy.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public void updateDeletedBy(List<String> list, int i) {
        this.__db.beginTransaction();
        try {
            super.updateDeletedBy(list, i);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public void updateDeletedByInChunk(List<String> list, int i) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("UPDATE OR ABORT sync_info SET deletedBy=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" WHERE clientId IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, list.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        supportSQLiteStatementCompileStatement.bindLong(1, i);
        int i2 = 2;
        for (String str : list) {
            if (str == null) {
                supportSQLiteStatementCompileStatement.bindNull(i2);
            } else {
                supportSQLiteStatementCompileStatement.bindString(i2, str);
            }
            i2++;
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public void updateIsDirtyByIsSyncFailed(int i, int i2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateIsDirtyByIsSyncFailed.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i);
        supportSQLiteStatementAcquire.bindLong(2, i2);
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateIsDirtyByIsSyncFailed.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public void updateIsSyncFailed(String str, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateIsSyncFailed.acquire();
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
            this.__preparedStmtOfUpdateIsSyncFailed.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public void updateResourceId(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateResourceId.acquire();
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str2);
        }
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
            this.__preparedStmtOfUpdateResourceId.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public void updateServerId(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateServerId.acquire();
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str2);
        }
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
            this.__preparedStmtOfUpdateServerId.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao
    public void updateSyncState(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateSyncState.acquire();
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
            this.__preparedStmtOfUpdateSyncState.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(SyncInfoEntity syncInfoEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfSyncInfoEntity.handle(syncInfoEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(SyncInfoEntity syncInfoEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSyncInfoEntity.insert(syncInfoEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(SyncInfoEntity syncInfoEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfSyncInfoEntity.handle(syncInfoEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(SyncInfoEntity syncInfoEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(syncInfoEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends SyncInfoEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
