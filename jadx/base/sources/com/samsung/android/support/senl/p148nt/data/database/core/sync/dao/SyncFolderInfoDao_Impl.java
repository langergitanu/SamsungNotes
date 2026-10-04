package com.samsung.android.support.senl.p148nt.data.database.core.sync.dao;

import android.database.Cursor;
import android.util.Pair;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncFolderInfoEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class SyncFolderInfoDao_Impl extends SyncFolderInfoDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<SyncFolderInfoEntity> __deletionAdapterOfSyncFolderInfoEntity;
    private final EntityInsertionAdapter<SyncFolderInfoEntity> __insertionAdapterOfSyncFolderInfoEntity;
    private final EntityDeletionOrUpdateAdapter<SyncFolderInfoEntity> __updateAdapterOfSyncFolderInfoEntity;

    public SyncFolderInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSyncFolderInfoEntity = new EntityInsertionAdapter<SyncFolderInfoEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncFolderInfoDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `sync_folder_info` (`UUID`,`deletedBy`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SyncFolderInfoEntity syncFolderInfoEntity) {
                if (syncFolderInfoEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, syncFolderInfoEntity.getUuid());
                }
                supportSQLiteStatement.bindLong(2, syncFolderInfoEntity.getDeletedBy());
            }
        };
        this.__deletionAdapterOfSyncFolderInfoEntity = new EntityDeletionOrUpdateAdapter<SyncFolderInfoEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncFolderInfoDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `sync_folder_info` WHERE `UUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SyncFolderInfoEntity syncFolderInfoEntity) {
                if (syncFolderInfoEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, syncFolderInfoEntity.getUuid());
                }
            }
        };
        this.__updateAdapterOfSyncFolderInfoEntity = new EntityDeletionOrUpdateAdapter<SyncFolderInfoEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncFolderInfoDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `sync_folder_info` SET `UUID` = ?,`deletedBy` = ? WHERE `UUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SyncFolderInfoEntity syncFolderInfoEntity) {
                if (syncFolderInfoEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, syncFolderInfoEntity.getUuid());
                }
                supportSQLiteStatement.bindLong(2, syncFolderInfoEntity.getDeletedBy());
                if (syncFolderInfoEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, syncFolderInfoEntity.getUuid());
                }
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncFolderInfoDao
    public List<String> getUuidsInChunk(List<String> list) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT UUID FROM sync_folder_info WHERE UUID IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size);
        int i = 1;
        for (String str : list) {
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncFolderInfoDao
    public void updateDeletedBy(List<String> list, int i) {
        this.__db.beginTransaction();
        try {
            super.updateDeletedBy(list, i);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncFolderInfoDao
    public void updateDeletedByInChunk(List<String> list, int i) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("UPDATE OR ABORT sync_folder_info SET deletedBy=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" WHERE UUID IN (");
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(SyncFolderInfoEntity syncFolderInfoEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfSyncFolderInfoEntity.handle(syncFolderInfoEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(SyncFolderInfoEntity syncFolderInfoEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSyncFolderInfoEntity.insert(syncFolderInfoEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(SyncFolderInfoEntity syncFolderInfoEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfSyncFolderInfoEntity.handle(syncFolderInfoEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(SyncFolderInfoEntity syncFolderInfoEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(syncFolderInfoEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends SyncFolderInfoEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
