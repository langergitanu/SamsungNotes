package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.database.Cursor;
import android.util.Pair;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesMappedDocumentEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesMappedDocumentDao_Impl extends NotesMappedDocumentDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<NotesMappedDocumentEntity> __deletionAdapterOfNotesMappedDocumentEntity;
    private final EntityInsertionAdapter<NotesMappedDocumentEntity> __insertionAdapterOfNotesMappedDocumentEntity;
    private final SharedSQLiteStatement __preparedStmtOfClear;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfDeleteMappedEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteMappedEntity_1;
    private final SharedSQLiteStatement __preparedStmtOfSetConvertedByMappedUuid;
    private final SharedSQLiteStatement __preparedStmtOfSetConvertedByOriginalUuid;
    private final SharedSQLiteStatement __preparedStmtOfUpdateConverted;
    private final EntityDeletionOrUpdateAdapter<NotesMappedDocumentEntity> __updateAdapterOfNotesMappedDocumentEntity;

    public NotesMappedDocumentDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNotesMappedDocumentEntity = new EntityInsertionAdapter<NotesMappedDocumentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesMappedDocumentDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `mapped_document` (`_id`,`UUID`,`mappedUUID`,`converted`,`mappedAt`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesMappedDocumentEntity notesMappedDocumentEntity) {
                supportSQLiteStatement.bindLong(1, notesMappedDocumentEntity.getId());
                if (notesMappedDocumentEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesMappedDocumentEntity.getUuid());
                }
                if (notesMappedDocumentEntity.getMappedUuid() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesMappedDocumentEntity.getMappedUuid());
                }
                supportSQLiteStatement.bindLong(4, notesMappedDocumentEntity.getIsConverted());
                supportSQLiteStatement.bindLong(5, notesMappedDocumentEntity.getMappedAt());
            }
        };
        this.__deletionAdapterOfNotesMappedDocumentEntity = new EntityDeletionOrUpdateAdapter<NotesMappedDocumentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesMappedDocumentDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `mapped_document` WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesMappedDocumentEntity notesMappedDocumentEntity) {
                supportSQLiteStatement.bindLong(1, notesMappedDocumentEntity.getId());
            }
        };
        this.__updateAdapterOfNotesMappedDocumentEntity = new EntityDeletionOrUpdateAdapter<NotesMappedDocumentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesMappedDocumentDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `mapped_document` SET `_id` = ?,`UUID` = ?,`mappedUUID` = ?,`converted` = ?,`mappedAt` = ? WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesMappedDocumentEntity notesMappedDocumentEntity) {
                supportSQLiteStatement.bindLong(1, notesMappedDocumentEntity.getId());
                if (notesMappedDocumentEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesMappedDocumentEntity.getUuid());
                }
                if (notesMappedDocumentEntity.getMappedUuid() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesMappedDocumentEntity.getMappedUuid());
                }
                supportSQLiteStatement.bindLong(4, notesMappedDocumentEntity.getIsConverted());
                supportSQLiteStatement.bindLong(5, notesMappedDocumentEntity.getMappedAt());
                supportSQLiteStatement.bindLong(6, notesMappedDocumentEntity.getId());
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesMappedDocumentDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM mapped_document WHERE UUID=?";
            }
        };
        this.__preparedStmtOfDeleteMappedEntity = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesMappedDocumentDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM mapped_document WHERE mappedUUID=?";
            }
        };
        this.__preparedStmtOfDeleteMappedEntity_1 = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesMappedDocumentDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM mapped_document WHERE UUID=? AND mappedAt<?";
            }
        };
        this.__preparedStmtOfSetConvertedByMappedUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesMappedDocumentDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT mapped_document SET converted=? WHERE mappedUUID=?";
            }
        };
        this.__preparedStmtOfSetConvertedByOriginalUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesMappedDocumentDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT mapped_document SET converted=? WHERE UUID=?";
            }
        };
        this.__preparedStmtOfUpdateConverted = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesMappedDocumentDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT mapped_document SET converted=? WHERE mappedUUID=?";
            }
        };
        this.__preparedStmtOfClear = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesMappedDocumentDao_Impl.10
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM mapped_document";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public void clear() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfClear.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfClear.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public void deleteMappedEntity(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteMappedEntity.acquire();
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
            this.__preparedStmtOfDeleteMappedEntity.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public List<NotesMappedDocumentEntity> dumpMappedDocumentList() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `mapped_document`.`_id` AS `_id`, `mapped_document`.`UUID` AS `UUID`, `mapped_document`.`mappedUUID` AS `mappedUUID`, `mapped_document`.`converted` AS `converted`, `mapped_document`.`mappedAt` AS `mappedAt` FROM mapped_document ORDER BY UUID ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesMappedDocumentEntity notesMappedDocumentEntity = new NotesMappedDocumentEntity();
                notesMappedDocumentEntity.setId(cursorQuery.getLong(0));
                notesMappedDocumentEntity.setUuid(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                notesMappedDocumentEntity.setMappedUuid(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                notesMappedDocumentEntity.setIsConverted(cursorQuery.getInt(3));
                notesMappedDocumentEntity.setMappedAt(cursorQuery.getLong(4));
                arrayList.add(notesMappedDocumentEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public String findLatestConvertedMappedUuid(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT mappedUUID FROM mapped_document WHERE converted IS 1 AND UUID=? ORDER BY _id DESC LIMIT 1", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public String findLatestMappedUuid(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT mappedUUID FROM mapped_document WHERE UUID=? ORDER BY _id DESC LIMIT 1", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public String findMappedDocumentUuid(String str, long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT mappedUUID FROM mapped_document WHERE UUID=? AND mappedAt=? ORDER BY _id DESC LIMIT 1", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        roomSQLiteQueryAcquire.bindLong(2, j);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public String findOriginalDocumentUuid(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM mapped_document WHERE mappedUUID=?", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public int getConverted(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT converted FROM mapped_document WHERE mappedUUID=?", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public long getDocumentServerTimestamp(NotesDocumentDao notesDocumentDao, String str) {
        this.__db.beginTransaction();
        try {
            long documentServerTimestamp = super.getDocumentServerTimestamp(notesDocumentDao, str);
            this.__db.setTransactionSuccessful();
            return documentServerTimestamp;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public long getMappedAt(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT mappedAt FROM mapped_document WHERE mappedUUID=?", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public void setConvertedByMappedUuid(String str, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSetConvertedByMappedUuid.acquire();
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
            this.__preparedStmtOfSetConvertedByMappedUuid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public void setConvertedByOriginalUuid(String str, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSetConvertedByOriginalUuid.acquire();
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
            this.__preparedStmtOfSetConvertedByOriginalUuid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public void updateConverted(String str, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateConverted.acquire();
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
            this.__preparedStmtOfUpdateConverted.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public boolean verifyMappedUuid(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT old.lastModifiedAt=new.lastModifiedAt FROM mapped_document AS map LEFT OUTER JOIN sdoc AS old ON old.UUID=? LEFT OUTER JOIN sdoc AS new ON new.UUID=? WHERE map.mappedUUID=? AND map.converted=1 ORDER BY map._id DESC LIMIT 1", 3);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(3);
        } else {
            roomSQLiteQueryAcquire.bindString(3, str2);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(NotesMappedDocumentEntity notesMappedDocumentEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfNotesMappedDocumentEntity.handle(notesMappedDocumentEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(NotesMappedDocumentEntity notesMappedDocumentEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfNotesMappedDocumentEntity.insert(notesMappedDocumentEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(NotesMappedDocumentEntity notesMappedDocumentEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfNotesMappedDocumentEntity.handle(notesMappedDocumentEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(NotesMappedDocumentEntity notesMappedDocumentEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(notesMappedDocumentEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends NotesMappedDocumentEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public void delete(NotesDocumentDao notesDocumentDao, boolean z, String str) {
        this.__db.beginTransaction();
        try {
            super.delete(notesDocumentDao, z, str);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public Pair<AtomicInteger, AtomicInteger> insert(NotesDocumentDao notesDocumentDao, NotesMappedDocumentEntity notesMappedDocumentEntity, String str, long j) throws Throwable {
        NotesMappedDocumentDao_Impl notesMappedDocumentDao_Impl;
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairInsert = super.insert(notesDocumentDao, notesMappedDocumentEntity, str, j);
            notesMappedDocumentDao_Impl = this;
            try {
                notesMappedDocumentDao_Impl.__db.setTransactionSuccessful();
                notesMappedDocumentDao_Impl.__db.endTransaction();
                return pairInsert;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                notesMappedDocumentDao_Impl.__db.endTransaction();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            notesMappedDocumentDao_Impl = this;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public void delete(NotesDocumentDao notesDocumentDao, Collection<DocumentData> collection) {
        this.__db.beginTransaction();
        try {
            super.delete(notesDocumentDao, collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public void deleteMappedEntity(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteMappedEntity_1.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        supportSQLiteStatementAcquire.bindLong(2, j);
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteMappedEntity_1.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public Pair<AtomicInteger, AtomicInteger> insert(NotesDocumentDao notesDocumentDao, String str, String str2, long j, boolean z) throws Throwable {
        NotesMappedDocumentDao_Impl notesMappedDocumentDao_Impl;
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairInsert = super.insert(notesDocumentDao, str, str2, j, z);
            notesMappedDocumentDao_Impl = this;
            try {
                notesMappedDocumentDao_Impl.__db.setTransactionSuccessful();
                notesMappedDocumentDao_Impl.__db.endTransaction();
                return pairInsert;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                notesMappedDocumentDao_Impl.__db.endTransaction();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            notesMappedDocumentDao_Impl = this;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public Pair<AtomicInteger, AtomicInteger> insert(NotesDocumentDao notesDocumentDao, String str, String str2, boolean z) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairInsert = super.insert(notesDocumentDao, str, str2, z);
            this.__db.setTransactionSuccessful();
            return pairInsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao
    public void insert(HashMap<String, Long> map) {
        this.__db.beginTransaction();
        try {
            super.insert(map);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
