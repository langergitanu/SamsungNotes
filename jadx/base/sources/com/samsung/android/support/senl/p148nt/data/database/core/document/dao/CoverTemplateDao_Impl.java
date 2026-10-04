package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.database.Cursor;
import android.util.Pair;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.CoverTemplateEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class CoverTemplateDao_Impl extends CoverTemplateDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<CoverTemplateEntity> __deletionAdapterOfCoverTemplateEntity;
    private final EntityInsertionAdapter<CoverTemplateEntity> __insertionAdapterOfCoverTemplateEntity;
    private final EntityDeletionOrUpdateAdapter<CoverTemplateEntity> __updateAdapterOfCoverTemplateEntity;

    public CoverTemplateDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfCoverTemplateEntity = new EntityInsertionAdapter<CoverTemplateEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.CoverTemplateDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `cover_template` (`UUID`,`path`,`createdAt`,`lastModifiedAt`,`type`) VALUES (?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, CoverTemplateEntity coverTemplateEntity) {
                if (coverTemplateEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, coverTemplateEntity.getUuid());
                }
                if (coverTemplateEntity.getPath() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, coverTemplateEntity.getPath());
                }
                supportSQLiteStatement.bindLong(3, coverTemplateEntity.getCreatedAt());
                supportSQLiteStatement.bindLong(4, coverTemplateEntity.getLastModifiedAt());
                supportSQLiteStatement.bindLong(5, coverTemplateEntity.getType());
            }
        };
        this.__deletionAdapterOfCoverTemplateEntity = new EntityDeletionOrUpdateAdapter<CoverTemplateEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.CoverTemplateDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `cover_template` WHERE `UUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, CoverTemplateEntity coverTemplateEntity) {
                if (coverTemplateEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, coverTemplateEntity.getUuid());
                }
            }
        };
        this.__updateAdapterOfCoverTemplateEntity = new EntityDeletionOrUpdateAdapter<CoverTemplateEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.CoverTemplateDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `cover_template` SET `UUID` = ?,`path` = ?,`createdAt` = ?,`lastModifiedAt` = ?,`type` = ? WHERE `UUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, CoverTemplateEntity coverTemplateEntity) {
                if (coverTemplateEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, coverTemplateEntity.getUuid());
                }
                if (coverTemplateEntity.getPath() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, coverTemplateEntity.getPath());
                }
                supportSQLiteStatement.bindLong(3, coverTemplateEntity.getCreatedAt());
                supportSQLiteStatement.bindLong(4, coverTemplateEntity.getLastModifiedAt());
                supportSQLiteStatement.bindLong(5, coverTemplateEntity.getType());
                if (coverTemplateEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, coverTemplateEntity.getUuid());
                }
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.CoverTemplateDao
    public CoverTemplateEntity getEntity(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM cover_template WHERE UUID=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        CoverTemplateEntity coverTemplateEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "path");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            if (cursorQuery.moveToFirst()) {
                CoverTemplateEntity coverTemplateEntity2 = new CoverTemplateEntity();
                coverTemplateEntity2.setUuid(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                if (!cursorQuery.isNull(columnIndexOrThrow2)) {
                    string = cursorQuery.getString(columnIndexOrThrow2);
                }
                coverTemplateEntity2.setPath(string);
                coverTemplateEntity2.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow3));
                coverTemplateEntity2.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow4));
                coverTemplateEntity2.setType(cursorQuery.getInt(columnIndexOrThrow5));
                coverTemplateEntity = coverTemplateEntity2;
            }
            return coverTemplateEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.CoverTemplateDao
    public List<String> getPredefinedUuids() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM cover_template WHERE UUID LIKE '%:///'", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.CoverTemplateDao
    public void insertIfNotExists(String str) {
        this.__db.beginTransaction();
        try {
            super.insertIfNotExists(str);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(CoverTemplateEntity coverTemplateEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfCoverTemplateEntity.handle(coverTemplateEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(CoverTemplateEntity coverTemplateEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfCoverTemplateEntity.insert(coverTemplateEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(CoverTemplateEntity coverTemplateEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfCoverTemplateEntity.handle(coverTemplateEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(CoverTemplateEntity coverTemplateEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(coverTemplateEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends CoverTemplateEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
