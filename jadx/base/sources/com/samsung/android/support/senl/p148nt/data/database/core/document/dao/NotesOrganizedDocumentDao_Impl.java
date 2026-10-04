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
import androidx.room.util.StringUtil;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesOrganizedDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesOrganizedDocumentDao_Impl extends NotesOrganizedDocumentDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<NotesOrganizedDocumentEntity> __deletionAdapterOfNotesOrganizedDocumentEntity;
    private final EntityInsertionAdapter<NotesOrganizedDocumentEntity> __insertionAdapterOfNotesOrganizedDocumentEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDummy;
    private final EntityDeletionOrUpdateAdapter<NotesOrganizedDocumentEntity> __updateAdapterOfNotesOrganizedDocumentEntity;

    public NotesOrganizedDocumentDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNotesOrganizedDocumentEntity = new EntityInsertionAdapter<NotesOrganizedDocumentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesOrganizedDocumentDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `organized_document` (`documentUUID`,`contents`,`recognized_language`,`recognizerDBVersion`,`modified_time`) VALUES (?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesOrganizedDocumentEntity notesOrganizedDocumentEntity) {
                if (notesOrganizedDocumentEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, notesOrganizedDocumentEntity.getUuid());
                }
                if (notesOrganizedDocumentEntity.getContents() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesOrganizedDocumentEntity.getContents());
                }
                if (notesOrganizedDocumentEntity.getRecognizedLanguage() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesOrganizedDocumentEntity.getRecognizedLanguage());
                }
                if (notesOrganizedDocumentEntity.getRecognizerDBVersion() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, notesOrganizedDocumentEntity.getRecognizerDBVersion());
                }
                if (notesOrganizedDocumentEntity.getModifiedTime() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, notesOrganizedDocumentEntity.getModifiedTime().longValue());
                }
            }
        };
        this.__deletionAdapterOfNotesOrganizedDocumentEntity = new EntityDeletionOrUpdateAdapter<NotesOrganizedDocumentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesOrganizedDocumentDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `organized_document` WHERE `documentUUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesOrganizedDocumentEntity notesOrganizedDocumentEntity) {
                if (notesOrganizedDocumentEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, notesOrganizedDocumentEntity.getUuid());
                }
            }
        };
        this.__updateAdapterOfNotesOrganizedDocumentEntity = new EntityDeletionOrUpdateAdapter<NotesOrganizedDocumentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesOrganizedDocumentDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `organized_document` SET `documentUUID` = ?,`contents` = ?,`recognized_language` = ?,`recognizerDBVersion` = ?,`modified_time` = ? WHERE `documentUUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesOrganizedDocumentEntity notesOrganizedDocumentEntity) {
                if (notesOrganizedDocumentEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, notesOrganizedDocumentEntity.getUuid());
                }
                if (notesOrganizedDocumentEntity.getContents() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesOrganizedDocumentEntity.getContents());
                }
                if (notesOrganizedDocumentEntity.getRecognizedLanguage() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesOrganizedDocumentEntity.getRecognizedLanguage());
                }
                if (notesOrganizedDocumentEntity.getRecognizerDBVersion() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, notesOrganizedDocumentEntity.getRecognizerDBVersion());
                }
                if (notesOrganizedDocumentEntity.getModifiedTime() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, notesOrganizedDocumentEntity.getModifiedTime().longValue());
                }
                if (notesOrganizedDocumentEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, notesOrganizedDocumentEntity.getUuid());
                }
            }
        };
        this.__preparedStmtOfDeleteDummy = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesOrganizedDocumentDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM organized_document WHERE documentUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOrganizedDocumentDao
    public void deleteByUuids(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            super.deleteByUuids(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOrganizedDocumentDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOrganizedDocumentDao
    public void deleteInChunk(Collection<String> collection) {
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, AbstractC11014a.m12324i(this.__db, "DELETE FROM organized_document WHERE documentUUID IN ("), ")"));
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOrganizedDocumentDao
    public List<NotesOrganizedDocumentEntity> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `organized_document`.`documentUUID` AS `documentUUID`, `organized_document`.`contents` AS `contents`, `organized_document`.`recognized_language` AS `recognized_language`, `organized_document`.`recognizerDBVersion` AS `recognizerDBVersion`, `organized_document`.`modified_time` AS `modified_time` FROM organized_document WHERE EXISTS (SELECT 1 FROM sdoc WHERE sdoc.isDeleted = 0 AND organized_document.documentUUID = sdoc.UUID)  ORDER BY modified_time DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesOrganizedDocumentEntity notesOrganizedDocumentEntity = new NotesOrganizedDocumentEntity();
                notesOrganizedDocumentEntity.setUuid(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                notesOrganizedDocumentEntity.setContents(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                notesOrganizedDocumentEntity.setRecognizedLanguage(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                notesOrganizedDocumentEntity.setRecognizerDBVersion(cursorQuery.isNull(3) ? null : cursorQuery.getString(3));
                notesOrganizedDocumentEntity.setModifiedTime(cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4)));
                arrayList.add(notesOrganizedDocumentEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOrganizedDocumentDao
    public LiveData<List<NotesOrganizedDocumentEntity>> getAll_LiveData() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `organized_document`.`documentUUID` AS `documentUUID`, `organized_document`.`contents` AS `contents`, `organized_document`.`recognized_language` AS `recognized_language`, `organized_document`.`recognizerDBVersion` AS `recognizerDBVersion`, `organized_document`.`modified_time` AS `modified_time` FROM organized_document WHERE EXISTS (SELECT 1 FROM sdoc WHERE sdoc.isDeleted = 0 AND organized_document.documentUUID = sdoc.UUID)  ORDER BY modified_time DESC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{DBSchema.OrganizedDocument.TABLE_NAME, "sdoc"}, false, new Callable<List<NotesOrganizedDocumentEntity>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesOrganizedDocumentDao_Impl.5
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<NotesOrganizedDocumentEntity> call() {
                Cursor cursorQuery = DBUtil.query(NotesOrganizedDocumentDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        NotesOrganizedDocumentEntity notesOrganizedDocumentEntity = new NotesOrganizedDocumentEntity();
                        notesOrganizedDocumentEntity.setUuid(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                        notesOrganizedDocumentEntity.setContents(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                        notesOrganizedDocumentEntity.setRecognizedLanguage(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                        notesOrganizedDocumentEntity.setRecognizerDBVersion(cursorQuery.isNull(3) ? null : cursorQuery.getString(3));
                        notesOrganizedDocumentEntity.setModifiedTime(cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4)));
                        arrayList.add(notesOrganizedDocumentEntity);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOrganizedDocumentDao
    public List<NotesOrganizedDocumentEntity> getEntities(Collection<String> collection) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), AbstractC11014a.m12317b(sbNewStringBuilder, "SELECT * FROM organized_document WHERE documentUUID in (", collection, sbNewStringBuilder, ")"));
        int i = 1;
        for (String str : collection) {
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
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "documentUUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "contents");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.OrganizedDocument.RECOGNIZED_LANGUAGE);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recognizerDBVersion");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "modified_time");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesOrganizedDocumentEntity notesOrganizedDocumentEntity = new NotesOrganizedDocumentEntity();
                notesOrganizedDocumentEntity.setUuid(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                notesOrganizedDocumentEntity.setContents(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                notesOrganizedDocumentEntity.setRecognizedLanguage(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                notesOrganizedDocumentEntity.setRecognizerDBVersion(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                notesOrganizedDocumentEntity.setModifiedTime(cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)));
                arrayList.add(notesOrganizedDocumentEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOrganizedDocumentDao
    public NotesOrganizedDocumentEntity getEntity(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM organized_document WHERE documentUUID=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        NotesOrganizedDocumentEntity notesOrganizedDocumentEntity = null;
        Long lValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "documentUUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "contents");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.OrganizedDocument.RECOGNIZED_LANGUAGE);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recognizerDBVersion");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "modified_time");
            if (cursorQuery.moveToFirst()) {
                NotesOrganizedDocumentEntity notesOrganizedDocumentEntity2 = new NotesOrganizedDocumentEntity();
                notesOrganizedDocumentEntity2.setUuid(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                notesOrganizedDocumentEntity2.setContents(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                notesOrganizedDocumentEntity2.setRecognizedLanguage(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                notesOrganizedDocumentEntity2.setRecognizerDBVersion(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                if (!cursorQuery.isNull(columnIndexOrThrow5)) {
                    lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5));
                }
                notesOrganizedDocumentEntity2.setModifiedTime(lValueOf);
                notesOrganizedDocumentEntity = notesOrganizedDocumentEntity2;
            }
            return notesOrganizedDocumentEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(NotesOrganizedDocumentEntity notesOrganizedDocumentEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfNotesOrganizedDocumentEntity.handle(notesOrganizedDocumentEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(NotesOrganizedDocumentEntity notesOrganizedDocumentEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfNotesOrganizedDocumentEntity.insert(notesOrganizedDocumentEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(NotesOrganizedDocumentEntity notesOrganizedDocumentEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfNotesOrganizedDocumentEntity.handle(notesOrganizedDocumentEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(NotesOrganizedDocumentEntity notesOrganizedDocumentEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(notesOrganizedDocumentEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends NotesOrganizedDocumentEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
