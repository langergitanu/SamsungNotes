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
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SuggestedCoverEntity;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class SuggestedCoverDao_Impl extends SuggestedCoverDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<SuggestedCoverEntity> __deletionAdapterOfSuggestedCoverEntity;
    private final EntityInsertionAdapter<SuggestedCoverEntity> __insertionAdapterOfSuggestedCoverEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDummy;
    private final SharedSQLiteStatement __preparedStmtOfUpdateState;
    private final SharedSQLiteStatement __preparedStmtOfUpdateState_1;
    private final EntityDeletionOrUpdateAdapter<SuggestedCoverEntity> __updateAdapterOfSuggestedCoverEntity;

    public SuggestedCoverDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSuggestedCoverEntity = new EntityInsertionAdapter<SuggestedCoverEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.SuggestedCoverDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `suggested_cover` (`documentUUID`,`state`) VALUES (?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SuggestedCoverEntity suggestedCoverEntity) {
                if (suggestedCoverEntity.getDocUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, suggestedCoverEntity.getDocUuid());
                }
                supportSQLiteStatement.bindLong(2, suggestedCoverEntity.getState());
            }
        };
        this.__deletionAdapterOfSuggestedCoverEntity = new EntityDeletionOrUpdateAdapter<SuggestedCoverEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.SuggestedCoverDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `suggested_cover` WHERE `documentUUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SuggestedCoverEntity suggestedCoverEntity) {
                if (suggestedCoverEntity.getDocUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, suggestedCoverEntity.getDocUuid());
                }
            }
        };
        this.__updateAdapterOfSuggestedCoverEntity = new EntityDeletionOrUpdateAdapter<SuggestedCoverEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.SuggestedCoverDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `suggested_cover` SET `documentUUID` = ?,`state` = ? WHERE `documentUUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SuggestedCoverEntity suggestedCoverEntity) {
                if (suggestedCoverEntity.getDocUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, suggestedCoverEntity.getDocUuid());
                }
                supportSQLiteStatement.bindLong(2, suggestedCoverEntity.getState());
                if (suggestedCoverEntity.getDocUuid() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, suggestedCoverEntity.getDocUuid());
                }
            }
        };
        this.__preparedStmtOfUpdateState = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.SuggestedCoverDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT suggested_cover SET state=? WHERE documentUUID=?";
            }
        };
        this.__preparedStmtOfUpdateState_1 = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.SuggestedCoverDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT suggested_cover SET state=? WHERE documentUUID=? AND state=?";
            }
        };
        this.__preparedStmtOfDeleteDummy = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.SuggestedCoverDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM suggested_cover WHERE documentUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.SuggestedCoverDao
    public void deleteByUuids(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            super.deleteByUuids(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.SuggestedCoverDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.SuggestedCoverDao
    public void deleteInChunk(Collection<String> collection) {
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, AbstractC11014a.m12324i(this.__db, "DELETE FROM suggested_cover WHERE documentUUID IN ("), ")"));
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.SuggestedCoverDao
    public SuggestedCoverEntity getEntity(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM suggested_cover WHERE documentUUID=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        SuggestedCoverEntity suggestedCoverEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "documentUUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            if (cursorQuery.moveToFirst()) {
                SuggestedCoverEntity suggestedCoverEntity2 = new SuggestedCoverEntity();
                if (!cursorQuery.isNull(columnIndexOrThrow)) {
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                suggestedCoverEntity2.setDocUuid(string);
                suggestedCoverEntity2.setState(cursorQuery.getInt(columnIndexOrThrow2));
                suggestedCoverEntity = suggestedCoverEntity2;
            }
            return suggestedCoverEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.SuggestedCoverDao
    public void updateState(String str, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateState.acquire();
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
            this.__preparedStmtOfUpdateState.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(SuggestedCoverEntity suggestedCoverEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfSuggestedCoverEntity.handle(suggestedCoverEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(SuggestedCoverEntity suggestedCoverEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSuggestedCoverEntity.insert(suggestedCoverEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(SuggestedCoverEntity suggestedCoverEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfSuggestedCoverEntity.handle(suggestedCoverEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(SuggestedCoverEntity suggestedCoverEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(suggestedCoverEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends SuggestedCoverEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.SuggestedCoverDao
    public void updateState(String str, int i, int i2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateState_1.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str);
        }
        supportSQLiteStatementAcquire.bindLong(3, i);
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateState_1.release(supportSQLiteStatementAcquire);
        }
    }
}
