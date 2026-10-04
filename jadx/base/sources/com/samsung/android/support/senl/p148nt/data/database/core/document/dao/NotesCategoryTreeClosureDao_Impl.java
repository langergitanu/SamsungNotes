package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeClosureEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesCategoryTreeClosureDao_Impl extends NotesCategoryTreeClosureDao {
    private final RoomDatabase __db;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDummy;

    public NotesCategoryTreeClosureDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__preparedStmtOfDeleteDummy = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeClosureDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM category_tree_closure WHERE descendant NOT IN (SELECT UUID FROM category_tree WHERE isDeleted != 1)";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao
    public InvalidParentFolderException.Info checkRelationShip(String str, String str2) {
        this.__db.beginTransaction();
        try {
            InvalidParentFolderException.Info infoCheckRelationShip = super.checkRelationShip(str, str2);
            this.__db.setTransactionSuccessful();
            return infoCheckRelationShip;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao
    public InvalidParentFolderException.Info checkRelationShipByUuids(Collection<String> collection, String str) {
        this.__db.beginTransaction();
        try {
            InvalidParentFolderException.Info infoCheckRelationShipByUuids = super.checkRelationShipByUuids(collection, str);
            this.__db.setTransactionSuccessful();
            return infoCheckRelationShipByUuids;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao
    public boolean exists(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT 1 FROM category_tree_closure WHERE descendant = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao
    public List<NotesCategoryTreeClosureEntity> getEntities(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM category_tree_closure WHERE descendant = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTreeClosure.ANCESTOR);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTreeClosure.DESCENDANT);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTreeClosure.DEPTH);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesCategoryTreeClosureEntity notesCategoryTreeClosureEntity = new NotesCategoryTreeClosureEntity();
                notesCategoryTreeClosureEntity.setAncestor(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                notesCategoryTreeClosureEntity.setDescendant(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                notesCategoryTreeClosureEntity.setDepth(cursorQuery.getInt(columnIndexOrThrow3));
                arrayList.add(notesCategoryTreeClosureEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao
    public Collection<String> getFoldersWithRelationShip(Collection<String> collection, String str) {
        this.__db.beginTransaction();
        try {
            Collection<String> foldersWithRelationShip = super.getFoldersWithRelationShip(collection, str);
            this.__db.setTransactionSuccessful();
            return foldersWithRelationShip;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao
    public int getMaxChildDepth(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT MAX(depth) FROM category_tree_closure WHERE ancestor = ?", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao
    public int getMaxDepth(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT MAX(depth) FROM category_tree_closure WHERE descendant = ?", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao
    public boolean hasDuplicateName(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT 1 FROM category_tree WHERE category_tree.isDeleted = 0 AND category_tree.UUID IN (SELECT descendant FROM category_tree_closure WHERE ancestor = ? AND depth = 1) AND category_tree.displayName = ?", 2);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao
    public boolean hasRelationShip(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT 1 FROM category_tree_closure WHERE ancestor = ? AND descendant = ?", 2);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao
    public boolean isDepthBiggerThanLimit(String str, String str2) {
        this.__db.beginTransaction();
        try {
            boolean zIsDepthBiggerThanLimit = super.isDepthBiggerThanLimit(str, str2);
            this.__db.setTransactionSuccessful();
            return zIsDepthBiggerThanLimit;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao
    public InvalidParentFolderException.Info checkRelationShip(Collection<? extends NotesCategoryTreeEntity> collection) {
        this.__db.beginTransaction();
        try {
            InvalidParentFolderException.Info infoCheckRelationShip = super.checkRelationShip(collection);
            this.__db.setTransactionSuccessful();
            return infoCheckRelationShip;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao
    public InvalidParentFolderException.Info checkRelationShip(Collection<? extends NotesCategoryTreeEntity> collection, String str) {
        this.__db.beginTransaction();
        try {
            InvalidParentFolderException.Info infoCheckRelationShip = super.checkRelationShip(collection, str);
            this.__db.setTransactionSuccessful();
            return infoCheckRelationShip;
        } finally {
            this.__db.endTransaction();
        }
    }
}
