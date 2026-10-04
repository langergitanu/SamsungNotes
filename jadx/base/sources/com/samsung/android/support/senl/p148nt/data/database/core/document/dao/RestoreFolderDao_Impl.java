package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class RestoreFolderDao_Impl extends RestoreFolderDao {
    private final RoomDatabase __db;
    private final SharedSQLiteStatement __preparedStmtOfFixRestorePath;
    private final SharedSQLiteStatement __preparedStmtOfRestoreReservedFolderFromTrash;

    public RestoreFolderDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__preparedStmtOfFixRestorePath = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.RestoreFolderDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT category_tree SET path = REPLACE(path, ?, ?) WHERE UUID IN (SELECT descendant FROM category_tree_closure WHERE ancestor = ?) AND path NOT LIKE '%' || ? || '%'";
            }
        };
        this.__preparedStmtOfRestoreReservedFolderFromTrash = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.RestoreFolderDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT category_tree SET parentUUID='uncategorized:///' , isDeleted=0 , recycle_bin_time_moved=0 , path='' , serverTimestamp=? , isDirty=1 WHERE UUID=?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.RestoreFolderDao
    public void fixRestorePath(String str, String str2, String str3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfFixRestorePath.acquire();
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str2);
        }
        if (str3 == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str3);
        }
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, str);
        }
        if (str3 == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, str3);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfFixRestorePath.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.RestoreFolderDao
    public List<NotesCategoryTreeEntity> getInvalidReservedFolders() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `category_tree`.`UUID` AS `UUID`, `category_tree`.`parentUUID` AS `parentUUID`, `category_tree`.`isDeleted` AS `isDeleted`, `category_tree`.`isDirty` AS `isDirty`, `category_tree`.`createdAt` AS `createdAt`, `category_tree`.`lastModifiedAt` AS `lastModifiedAt`, `category_tree`.`serverTimestamp` AS `serverTimestamp`, `category_tree`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `category_tree`.`displayName` AS `displayName`, `category_tree`.`path` AS `path`, `category_tree`.`orderBy` AS `orderBy`, `category_tree`.`displayNameColor` AS `displayNameColor`, `category_tree`.`isSyncWithMS` AS `isSyncWithMS` FROM category_tree WHERE path LIKE '%\u200b' AND isDeleted != 1 AND parentUUID != 'uncategorized:///'", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesCategoryTreeEntity notesCategoryTreeEntity = new NotesCategoryTreeEntity(cursorQuery.isNull(0) ? null : cursorQuery.getString(0), cursorQuery.isNull(1) ? null : cursorQuery.getString(1), cursorQuery.isNull(8) ? null : cursorQuery.getString(8), cursorQuery.isNull(9) ? null : cursorQuery.getString(9));
                notesCategoryTreeEntity.setIsDeleted(cursorQuery.getInt(2));
                notesCategoryTreeEntity.setIsDirty(cursorQuery.getInt(3));
                notesCategoryTreeEntity.setCreatedAt(cursorQuery.getLong(4));
                notesCategoryTreeEntity.setLastModifiedAt(cursorQuery.getLong(5));
                notesCategoryTreeEntity.setServerTimeStamp(cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6)));
                notesCategoryTreeEntity.setRecycleBinTimeMoved(cursorQuery.getLong(7));
                notesCategoryTreeEntity.setReorder(cursorQuery.isNull(10) ? null : Integer.valueOf(cursorQuery.getInt(10)));
                notesCategoryTreeEntity.setDisplayNameColor(cursorQuery.getInt(11));
                notesCategoryTreeEntity.setIsSyncWithMS(cursorQuery.getInt(12));
                arrayList.add(notesCategoryTreeEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.RestoreFolderDao
    public void restoreReservedFolder(String str, NotesDocumentDao notesDocumentDao) {
        this.__db.beginTransaction();
        try {
            super.restoreReservedFolder(str, notesDocumentDao);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.RestoreFolderDao
    public void restoreReservedFolderFromTrash(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfRestoreReservedFolderFromTrash.acquire();
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
            this.__preparedStmtOfRestoreReservedFolderFromTrash.release(supportSQLiteStatementAcquire);
        }
    }
}
