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
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentThumbnailEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class DocumentThumbnailDao_Impl extends DocumentThumbnailDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<DocumentThumbnailEntity> __deletionAdapterOfDocumentThumbnailEntity;
    private final EntityInsertionAdapter<DocumentThumbnailEntity> __insertionAdapterOfDocumentThumbnailEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDummy;
    private final EntityDeletionOrUpdateAdapter<DocumentThumbnailEntity> __updateAdapterOfDocumentThumbnailEntity;

    public DocumentThumbnailDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfDocumentThumbnailEntity = new EntityInsertionAdapter<DocumentThumbnailEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.DocumentThumbnailDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `document_thumbnail` (`UUID`,`backgroundType`,`layout`,`imagePath`,`playTime`) VALUES (?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, DocumentThumbnailEntity documentThumbnailEntity) {
                if (documentThumbnailEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, documentThumbnailEntity.getUuid());
                }
                supportSQLiteStatement.bindLong(2, documentThumbnailEntity.getBackgroundType());
                supportSQLiteStatement.bindLong(3, documentThumbnailEntity.getLayout());
                if (documentThumbnailEntity.getImagePath() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, documentThumbnailEntity.getImagePath());
                }
                if (documentThumbnailEntity.getPlayTime() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, documentThumbnailEntity.getPlayTime());
                }
            }
        };
        this.__deletionAdapterOfDocumentThumbnailEntity = new EntityDeletionOrUpdateAdapter<DocumentThumbnailEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.DocumentThumbnailDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `document_thumbnail` WHERE `UUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, DocumentThumbnailEntity documentThumbnailEntity) {
                if (documentThumbnailEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, documentThumbnailEntity.getUuid());
                }
            }
        };
        this.__updateAdapterOfDocumentThumbnailEntity = new EntityDeletionOrUpdateAdapter<DocumentThumbnailEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.DocumentThumbnailDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `document_thumbnail` SET `UUID` = ?,`backgroundType` = ?,`layout` = ?,`imagePath` = ?,`playTime` = ? WHERE `UUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, DocumentThumbnailEntity documentThumbnailEntity) {
                if (documentThumbnailEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, documentThumbnailEntity.getUuid());
                }
                supportSQLiteStatement.bindLong(2, documentThumbnailEntity.getBackgroundType());
                supportSQLiteStatement.bindLong(3, documentThumbnailEntity.getLayout());
                if (documentThumbnailEntity.getImagePath() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, documentThumbnailEntity.getImagePath());
                }
                if (documentThumbnailEntity.getPlayTime() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, documentThumbnailEntity.getPlayTime());
                }
                if (documentThumbnailEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, documentThumbnailEntity.getUuid());
                }
            }
        };
        this.__preparedStmtOfDeleteDummy = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.DocumentThumbnailDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM document_thumbnail WHERE UUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentThumbnailDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentThumbnailDao
    public void deleteInChunk(Collection<String> collection) {
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, AbstractC11014a.m12324i(this.__db, "DELETE FROM document_thumbnail WHERE UUID IN ("), ")"));
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentThumbnailDao
    public DocumentThumbnailEntity getEntity(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM document_thumbnail WHERE UUID = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        DocumentThumbnailEntity documentThumbnailEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.DocumentThumbnail.BACKGROUND_TYPE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.DocumentThumbnail.LAYOUT);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.DocumentThumbnail.IMAGE_PATH);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.DocumentThumbnail.PLAY_TIME);
            if (cursorQuery.moveToFirst()) {
                documentThumbnailEntity = new DocumentThumbnailEntity(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4), cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
            }
            return documentThumbnailEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentThumbnailDao
    public void upsert2(Collection<DocumentThumbnailEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert2(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(DocumentThumbnailEntity documentThumbnailEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfDocumentThumbnailEntity.handle(documentThumbnailEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(DocumentThumbnailEntity documentThumbnailEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfDocumentThumbnailEntity.insert(documentThumbnailEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(DocumentThumbnailEntity documentThumbnailEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfDocumentThumbnailEntity.handle(documentThumbnailEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(DocumentThumbnailEntity documentThumbnailEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(documentThumbnailEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends DocumentThumbnailEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentThumbnailDao
    public void delete(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            super.delete(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
