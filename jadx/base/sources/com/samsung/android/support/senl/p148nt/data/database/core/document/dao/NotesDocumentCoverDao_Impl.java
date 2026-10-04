package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

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
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentCoverEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.tuple.DocumentCoverStateTuple;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesDocumentCoverDao_Impl extends NotesDocumentCoverDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<NotesDocumentCoverEntity> __deletionAdapterOfNotesDocumentCoverEntity;
    private final EntityInsertionAdapter<NotesDocumentCoverEntity> __insertionAdapterOfNotesDocumentCoverEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDummy;
    private final SharedSQLiteStatement __preparedStmtOfUpdateEnabled;
    private final EntityDeletionOrUpdateAdapter<NotesDocumentCoverEntity> __updateAdapterOfNotesDocumentCoverEntity;

    public NotesDocumentCoverDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNotesDocumentCoverEntity = new EntityInsertionAdapter<NotesDocumentCoverEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentCoverDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `document_cover` (`documentUUID`,`templateUUID`,`title`,`title_alignment`,`summary`,`summary_alignment`,`categoryUUID`,`backgroundColor`,`createdAt`,`lastModifiedAt`,`isEnabled`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesDocumentCoverEntity notesDocumentCoverEntity) {
                if (notesDocumentCoverEntity.getDocUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, notesDocumentCoverEntity.getDocUuid());
                }
                if (notesDocumentCoverEntity.getTemplateUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesDocumentCoverEntity.getTemplateUuid());
                }
                if (notesDocumentCoverEntity.getTitle() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesDocumentCoverEntity.getTitle());
                }
                supportSQLiteStatement.bindLong(4, notesDocumentCoverEntity.getTitleAlignment());
                if (notesDocumentCoverEntity.getSummary() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, notesDocumentCoverEntity.getSummary());
                }
                supportSQLiteStatement.bindLong(6, notesDocumentCoverEntity.getSummaryAlignment());
                if (notesDocumentCoverEntity.getCategoryUuid() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, notesDocumentCoverEntity.getCategoryUuid());
                }
                if (notesDocumentCoverEntity.getBackgroundColor() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, notesDocumentCoverEntity.getBackgroundColor());
                }
                supportSQLiteStatement.bindLong(9, notesDocumentCoverEntity.getCreatedAt());
                supportSQLiteStatement.bindLong(10, notesDocumentCoverEntity.getLastModifiedAt());
                supportSQLiteStatement.bindLong(11, notesDocumentCoverEntity.getIsEnabled());
            }
        };
        this.__deletionAdapterOfNotesDocumentCoverEntity = new EntityDeletionOrUpdateAdapter<NotesDocumentCoverEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentCoverDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `document_cover` WHERE `documentUUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesDocumentCoverEntity notesDocumentCoverEntity) {
                if (notesDocumentCoverEntity.getDocUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, notesDocumentCoverEntity.getDocUuid());
                }
            }
        };
        this.__updateAdapterOfNotesDocumentCoverEntity = new EntityDeletionOrUpdateAdapter<NotesDocumentCoverEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentCoverDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `document_cover` SET `documentUUID` = ?,`templateUUID` = ?,`title` = ?,`title_alignment` = ?,`summary` = ?,`summary_alignment` = ?,`categoryUUID` = ?,`backgroundColor` = ?,`createdAt` = ?,`lastModifiedAt` = ?,`isEnabled` = ? WHERE `documentUUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesDocumentCoverEntity notesDocumentCoverEntity) {
                if (notesDocumentCoverEntity.getDocUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, notesDocumentCoverEntity.getDocUuid());
                }
                if (notesDocumentCoverEntity.getTemplateUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesDocumentCoverEntity.getTemplateUuid());
                }
                if (notesDocumentCoverEntity.getTitle() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesDocumentCoverEntity.getTitle());
                }
                supportSQLiteStatement.bindLong(4, notesDocumentCoverEntity.getTitleAlignment());
                if (notesDocumentCoverEntity.getSummary() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, notesDocumentCoverEntity.getSummary());
                }
                supportSQLiteStatement.bindLong(6, notesDocumentCoverEntity.getSummaryAlignment());
                if (notesDocumentCoverEntity.getCategoryUuid() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, notesDocumentCoverEntity.getCategoryUuid());
                }
                if (notesDocumentCoverEntity.getBackgroundColor() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, notesDocumentCoverEntity.getBackgroundColor());
                }
                supportSQLiteStatement.bindLong(9, notesDocumentCoverEntity.getCreatedAt());
                supportSQLiteStatement.bindLong(10, notesDocumentCoverEntity.getLastModifiedAt());
                supportSQLiteStatement.bindLong(11, notesDocumentCoverEntity.getIsEnabled());
                if (notesDocumentCoverEntity.getDocUuid() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, notesDocumentCoverEntity.getDocUuid());
                }
            }
        };
        this.__preparedStmtOfUpdateEnabled = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentCoverDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT document_cover SET isEnabled=? WHERE documentUUID=?";
            }
        };
        this.__preparedStmtOfDeleteDummy = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentCoverDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM document_cover WHERE documentUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentCoverDao
    public void deleteByUuids(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            super.deleteByUuids(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentCoverDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentCoverDao
    public void deleteInChunk(Collection<String> collection) {
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, AbstractC11014a.m12324i(this.__db, "DELETE FROM document_cover WHERE documentUUID IN ("), ")"));
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentCoverDao
    public LiveData<List<DocumentCoverStateTuple>> getAllTuples_LiveData() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `document_cover`.`documentUUID`, `document_cover`.`templateUUID`, `document_cover`.`title`, `document_cover`.`title_alignment`, `document_cover`.`summary`, `document_cover`.`summary_alignment`, `document_cover`.`categoryUUID`, `document_cover`.`backgroundColor`, `document_cover`.`createdAt`, `document_cover`.`lastModifiedAt`, `document_cover`.`isEnabled`, state FROM document_cover JOIN suggested_cover ON document_cover.documentUUID = suggested_cover.documentUUID WHERE EXISTS (SELECT 1 FROM sdoc WHERE sdoc.isDeleted = 0 AND document_cover.documentUUID = sdoc.UUID)", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"document_cover", "suggested_cover", "sdoc"}, false, new Callable<List<DocumentCoverStateTuple>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentCoverDao_Impl.6
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<DocumentCoverStateTuple> call() {
                Cursor cursorQuery = DBUtil.query(NotesDocumentCoverDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        DocumentCoverStateTuple documentCoverStateTuple = new DocumentCoverStateTuple();
                        documentCoverStateTuple.setDocUuid(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                        documentCoverStateTuple.setTemplateUuid(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                        documentCoverStateTuple.setTitle(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                        documentCoverStateTuple.setTitleAlignment(cursorQuery.getInt(3));
                        documentCoverStateTuple.setSummary(cursorQuery.isNull(4) ? null : cursorQuery.getString(4));
                        documentCoverStateTuple.setSummaryAlignment(cursorQuery.getInt(5));
                        documentCoverStateTuple.setCategoryUuid(cursorQuery.isNull(6) ? null : cursorQuery.getString(6));
                        documentCoverStateTuple.setBackgroundColor(cursorQuery.isNull(7) ? null : cursorQuery.getString(7));
                        documentCoverStateTuple.setCreatedAt(cursorQuery.getLong(8));
                        documentCoverStateTuple.setLastModifiedAt(cursorQuery.getLong(9));
                        documentCoverStateTuple.setIsEnabled(cursorQuery.getInt(10));
                        documentCoverStateTuple.state = cursorQuery.getInt(11);
                        arrayList.add(documentCoverStateTuple);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentCoverDao
    public DocumentCoverStateTuple getCoverStateTuple(String str) {
        DocumentCoverStateTuple documentCoverStateTuple;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT document_cover.*, state FROM document_cover JOIN suggested_cover ON document_cover.documentUUID = suggested_cover.documentUUID WHERE document_cover.documentUUID = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "documentUUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.DocumentCover.TEMPLATE_UUID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.DocumentCover.TITLE_ALIGNMENT);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.DocumentCover.SUMMARY);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.DocumentCover.SUMMARY_ALIGNMENT);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryUUID");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backgroundColor");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isEnabled");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            if (cursorQuery.moveToFirst()) {
                documentCoverStateTuple = new DocumentCoverStateTuple();
                documentCoverStateTuple.setDocUuid(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                documentCoverStateTuple.setTemplateUuid(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                documentCoverStateTuple.setTitle(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                documentCoverStateTuple.setTitleAlignment(cursorQuery.getInt(columnIndexOrThrow4));
                documentCoverStateTuple.setSummary(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                documentCoverStateTuple.setSummaryAlignment(cursorQuery.getInt(columnIndexOrThrow6));
                documentCoverStateTuple.setCategoryUuid(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                documentCoverStateTuple.setBackgroundColor(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                documentCoverStateTuple.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow9));
                documentCoverStateTuple.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow10));
                documentCoverStateTuple.setIsEnabled(cursorQuery.getInt(columnIndexOrThrow11));
                documentCoverStateTuple.state = cursorQuery.getInt(columnIndexOrThrow12);
            } else {
                documentCoverStateTuple = null;
            }
            return documentCoverStateTuple;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentCoverDao
    public NotesDocumentCoverEntity getEntity(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM document_cover WHERE documentUUID=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        NotesDocumentCoverEntity notesDocumentCoverEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "documentUUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.DocumentCover.TEMPLATE_UUID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.DocumentCover.TITLE_ALIGNMENT);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.DocumentCover.SUMMARY);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.DocumentCover.SUMMARY_ALIGNMENT);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryUUID");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backgroundColor");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isEnabled");
            if (cursorQuery.moveToFirst()) {
                NotesDocumentCoverEntity notesDocumentCoverEntity2 = new NotesDocumentCoverEntity();
                notesDocumentCoverEntity2.setDocUuid(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                notesDocumentCoverEntity2.setTemplateUuid(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                notesDocumentCoverEntity2.setTitle(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                notesDocumentCoverEntity2.setTitleAlignment(cursorQuery.getInt(columnIndexOrThrow4));
                notesDocumentCoverEntity2.setSummary(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                notesDocumentCoverEntity2.setSummaryAlignment(cursorQuery.getInt(columnIndexOrThrow6));
                notesDocumentCoverEntity2.setCategoryUuid(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                if (!cursorQuery.isNull(columnIndexOrThrow8)) {
                    string = cursorQuery.getString(columnIndexOrThrow8);
                }
                notesDocumentCoverEntity2.setBackgroundColor(string);
                notesDocumentCoverEntity2.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow9));
                notesDocumentCoverEntity2.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow10));
                notesDocumentCoverEntity2.setIsEnabled(cursorQuery.getInt(columnIndexOrThrow11));
                notesDocumentCoverEntity = notesDocumentCoverEntity2;
            }
            return notesDocumentCoverEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentCoverDao
    public List<String> getUuidList(String str, int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM sdoc WHERE UUID IN (SELECT documentUUID FROM document_cover WHERE categoryUUID=? AND isEnabled = 1) AND isDeleted=? AND sdoc.isLock = 0", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        roomSQLiteQueryAcquire.bindLong(2, i);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentCoverDao
    public void updateEnabled(String str, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateEnabled.acquire();
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
            this.__preparedStmtOfUpdateEnabled.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(NotesDocumentCoverEntity notesDocumentCoverEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfNotesDocumentCoverEntity.handle(notesDocumentCoverEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(NotesDocumentCoverEntity notesDocumentCoverEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfNotesDocumentCoverEntity.insert(notesDocumentCoverEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(NotesDocumentCoverEntity notesDocumentCoverEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfNotesDocumentCoverEntity.handle(notesDocumentCoverEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(NotesDocumentCoverEntity notesDocumentCoverEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(notesDocumentCoverEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends NotesDocumentCoverEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
