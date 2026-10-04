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
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentExtraEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class DocumentExtraDao_Impl extends DocumentExtraDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<DocumentExtraEntity> __deletionAdapterOfDocumentExtraEntity;
    private final EntityInsertionAdapter<DocumentExtraEntity> __insertionAdapterOfDocumentExtraEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDummy;
    private final SharedSQLiteStatement __preparedStmtOfUpdateFormatVersion;
    private final EntityDeletionOrUpdateAdapter<DocumentExtraEntity> __updateAdapterOfDocumentExtraEntity;

    public DocumentExtraDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfDocumentExtraEntity = new EntityInsertionAdapter<DocumentExtraEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.DocumentExtraDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `document_extra` (`UUID`,`hasSticky`,`hasImage`,`hasStroke`,`hasPdf`,`unknownMinVersion`,`formatVersion`) VALUES (?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, DocumentExtraEntity documentExtraEntity) {
                if (documentExtraEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, documentExtraEntity.getUuid());
                }
                supportSQLiteStatement.bindLong(2, documentExtraEntity.getHasSticky());
                supportSQLiteStatement.bindLong(3, documentExtraEntity.getHasImage());
                supportSQLiteStatement.bindLong(4, documentExtraEntity.getHasStroke());
                supportSQLiteStatement.bindLong(5, documentExtraEntity.getHasPdf());
                supportSQLiteStatement.bindLong(6, documentExtraEntity.getUnknownMinVersion());
                supportSQLiteStatement.bindLong(7, documentExtraEntity.getFormatVersion());
            }
        };
        this.__deletionAdapterOfDocumentExtraEntity = new EntityDeletionOrUpdateAdapter<DocumentExtraEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.DocumentExtraDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `document_extra` WHERE `UUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, DocumentExtraEntity documentExtraEntity) {
                if (documentExtraEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, documentExtraEntity.getUuid());
                }
            }
        };
        this.__updateAdapterOfDocumentExtraEntity = new EntityDeletionOrUpdateAdapter<DocumentExtraEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.DocumentExtraDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `document_extra` SET `UUID` = ?,`hasSticky` = ?,`hasImage` = ?,`hasStroke` = ?,`hasPdf` = ?,`unknownMinVersion` = ?,`formatVersion` = ? WHERE `UUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, DocumentExtraEntity documentExtraEntity) {
                if (documentExtraEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, documentExtraEntity.getUuid());
                }
                supportSQLiteStatement.bindLong(2, documentExtraEntity.getHasSticky());
                supportSQLiteStatement.bindLong(3, documentExtraEntity.getHasImage());
                supportSQLiteStatement.bindLong(4, documentExtraEntity.getHasStroke());
                supportSQLiteStatement.bindLong(5, documentExtraEntity.getHasPdf());
                supportSQLiteStatement.bindLong(6, documentExtraEntity.getUnknownMinVersion());
                supportSQLiteStatement.bindLong(7, documentExtraEntity.getFormatVersion());
                if (documentExtraEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, documentExtraEntity.getUuid());
                }
            }
        };
        this.__preparedStmtOfDeleteDummy = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.DocumentExtraDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM document_extra WHERE UUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)";
            }
        };
        this.__preparedStmtOfUpdateFormatVersion = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.DocumentExtraDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT document_extra SET formatVersion = (?) WHERE UUID = ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentExtraDao
    public void deleteByUuids(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            super.deleteByUuids(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentExtraDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentExtraDao
    public void deleteUuidsInChunk(Collection<String> collection) {
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, AbstractC11014a.m12324i(this.__db, "DELETE FROM document_extra WHERE UUID IN ("), ")"));
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentExtraDao
    public DocumentExtraEntity getEntity(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM document_extra WHERE UUID = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        DocumentExtraEntity documentExtraEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.DocumentExtra.HAS_STICKY);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hasImage");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hasStroke");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hasPdf");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.DocumentExtra.UNKNOWN_MIN_VERSION);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.DocumentExtra.FORMAT_VERSION);
            if (cursorQuery.moveToFirst()) {
                DocumentExtraEntity documentExtraEntity2 = new DocumentExtraEntity();
                if (!cursorQuery.isNull(columnIndexOrThrow)) {
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                documentExtraEntity2.setUuid(string);
                documentExtraEntity2.setHasSticky(cursorQuery.getInt(columnIndexOrThrow2));
                documentExtraEntity2.setHasImage(cursorQuery.getInt(columnIndexOrThrow3));
                documentExtraEntity2.setHasStroke(cursorQuery.getInt(columnIndexOrThrow4));
                documentExtraEntity2.setHasPdf(cursorQuery.getInt(columnIndexOrThrow5));
                documentExtraEntity2.setUnknownMinVersion(cursorQuery.getInt(columnIndexOrThrow6));
                documentExtraEntity2.setFormatVersion(cursorQuery.getInt(columnIndexOrThrow7));
                documentExtraEntity = documentExtraEntity2;
            }
            return documentExtraEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentExtraDao
    public void updateFormatVersion(String str, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateFormatVersion.acquire();
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
            this.__preparedStmtOfUpdateFormatVersion.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(DocumentExtraEntity documentExtraEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfDocumentExtraEntity.handle(documentExtraEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(DocumentExtraEntity documentExtraEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfDocumentExtraEntity.insert(documentExtraEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(DocumentExtraEntity documentExtraEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfDocumentExtraEntity.handle(documentExtraEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(DocumentExtraEntity documentExtraEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(documentExtraEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends DocumentExtraEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
