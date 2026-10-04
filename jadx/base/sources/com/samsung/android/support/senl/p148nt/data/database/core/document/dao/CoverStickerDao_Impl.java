package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.database.Cursor;
import android.util.Pair;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.CoverStickerEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class CoverStickerDao_Impl extends CoverStickerDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<CoverStickerEntity> __deletionAdapterOfCoverStickerEntity;
    private final EntityInsertionAdapter<CoverStickerEntity> __insertionAdapterOfCoverStickerEntity;
    private final EntityDeletionOrUpdateAdapter<CoverStickerEntity> __updateAdapterOfCoverStickerEntity;

    public CoverStickerDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfCoverStickerEntity = new EntityInsertionAdapter<CoverStickerEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.CoverStickerDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `cover_category` (`UUID`,`name`,`icon_path`,`createdAt`,`lastModifiedAt`) VALUES (?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, CoverStickerEntity coverStickerEntity) {
                if (coverStickerEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, coverStickerEntity.getUuid());
                }
                if (coverStickerEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, coverStickerEntity.getName());
                }
                if (coverStickerEntity.getPath() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, coverStickerEntity.getPath());
                }
                supportSQLiteStatement.bindLong(4, coverStickerEntity.getCreatedAt());
                supportSQLiteStatement.bindLong(5, coverStickerEntity.getLastModifiedAt());
            }
        };
        this.__deletionAdapterOfCoverStickerEntity = new EntityDeletionOrUpdateAdapter<CoverStickerEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.CoverStickerDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `cover_category` WHERE `UUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, CoverStickerEntity coverStickerEntity) {
                if (coverStickerEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, coverStickerEntity.getUuid());
                }
            }
        };
        this.__updateAdapterOfCoverStickerEntity = new EntityDeletionOrUpdateAdapter<CoverStickerEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.CoverStickerDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `cover_category` SET `UUID` = ?,`name` = ?,`icon_path` = ?,`createdAt` = ?,`lastModifiedAt` = ? WHERE `UUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, CoverStickerEntity coverStickerEntity) {
                if (coverStickerEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, coverStickerEntity.getUuid());
                }
                if (coverStickerEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, coverStickerEntity.getName());
                }
                if (coverStickerEntity.getPath() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, coverStickerEntity.getPath());
                }
                supportSQLiteStatement.bindLong(4, coverStickerEntity.getCreatedAt());
                supportSQLiteStatement.bindLong(5, coverStickerEntity.getLastModifiedAt());
                if (coverStickerEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, coverStickerEntity.getUuid());
                }
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.CoverStickerDao
    public CoverStickerEntity getEntity(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM cover_category WHERE UUID=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        CoverStickerEntity coverStickerEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CoverSticker.ICON_PATH);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            if (cursorQuery.moveToFirst()) {
                CoverStickerEntity coverStickerEntity2 = new CoverStickerEntity();
                coverStickerEntity2.setUuid(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                coverStickerEntity2.setName(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                if (!cursorQuery.isNull(columnIndexOrThrow3)) {
                    string = cursorQuery.getString(columnIndexOrThrow3);
                }
                coverStickerEntity2.setPath(string);
                coverStickerEntity2.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow4));
                coverStickerEntity2.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow5));
                coverStickerEntity = coverStickerEntity2;
            }
            return coverStickerEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.CoverStickerDao
    public List<String> getPredefinedUuids() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM cover_category WHERE UUID LIKE '%:///'", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.CoverStickerDao
    public List<CoverStickerEntity> getUsedEntities(List<String> list) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM cover_category WHERE UUID IN (SELECT document_cover.categoryUUID FROM document_cover JOIN sdoc ON document_cover.documentUUID = sdoc.UUID WHERE document_cover.templateUUID IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(") AND document_cover.categoryUUID != 'NONE:///' AND document_cover.isEnabled = 1 AND sdoc.isDeleted = 0 AND sdoc.isLock = 0)");
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
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CoverSticker.ICON_PATH);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                CoverStickerEntity coverStickerEntity = new CoverStickerEntity();
                coverStickerEntity.setUuid(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                coverStickerEntity.setName(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                coverStickerEntity.setPath(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                coverStickerEntity.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow4));
                coverStickerEntity.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow5));
                arrayList.add(coverStickerEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(CoverStickerEntity coverStickerEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfCoverStickerEntity.handle(coverStickerEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(CoverStickerEntity coverStickerEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfCoverStickerEntity.insert(coverStickerEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(CoverStickerEntity coverStickerEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfCoverStickerEntity.handle(coverStickerEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(CoverStickerEntity coverStickerEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(coverStickerEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends CoverStickerEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
