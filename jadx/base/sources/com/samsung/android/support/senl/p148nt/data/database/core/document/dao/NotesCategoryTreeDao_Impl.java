package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.content.Context;
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
import androidx.sqlite.p113db.SupportSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.CategoryTimeTuple;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesCategoryTreeDao_Impl extends NotesCategoryTreeDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<NotesCategoryTreeEntity> __deletionAdapterOfNotesCategoryTreeEntity;
    private final EntityInsertionAdapter<NotesCategoryTreeEntity> __insertionAdapterOfNotesCategoryTreeEntity;
    private final SharedSQLiteStatement __preparedStmtOfChangeParentUuid;
    private final SharedSQLiteStatement __preparedStmtOfChangeParentUuid_1;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllCategorySubTree;
    private final SharedSQLiteStatement __preparedStmtOfDeleteCategoryTreeClosureSubTree;
    private final SharedSQLiteStatement __preparedStmtOfDeleteMovingCategory;
    private final SharedSQLiteStatement __preparedStmtOfInsertCategoryClosure;
    private final SharedSQLiteStatement __preparedStmtOfMoveToParent;
    private final SharedSQLiteStatement __preparedStmtOfMoveToTrash;
    private final SharedSQLiteStatement __preparedStmtOfRestoreFromTrash;
    private final SharedSQLiteStatement __preparedStmtOfUpdateDelete;
    private final SharedSQLiteStatement __preparedStmtOfUpdateDelete_1;
    private final SharedSQLiteStatement __preparedStmtOfUpdateModifiedTime;
    private final SharedSQLiteStatement __preparedStmtOfUpdateServerTimestamp;
    private final EntityDeletionOrUpdateAdapter<NotesCategoryTreeEntity> __updateAdapterOfNotesCategoryTreeEntity;

    public NotesCategoryTreeDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNotesCategoryTreeEntity = new EntityInsertionAdapter<NotesCategoryTreeEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `category_tree` (`UUID`,`parentUUID`,`isDeleted`,`isDirty`,`createdAt`,`lastModifiedAt`,`serverTimestamp`,`recycle_bin_time_moved`,`displayName`,`path`,`orderBy`,`displayNameColor`,`isSyncWithMS`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesCategoryTreeEntity notesCategoryTreeEntity) {
                if (notesCategoryTreeEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, notesCategoryTreeEntity.getUuid());
                }
                if (notesCategoryTreeEntity.getParentUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesCategoryTreeEntity.getParentUuid());
                }
                supportSQLiteStatement.bindLong(3, notesCategoryTreeEntity.getIsDeleted());
                supportSQLiteStatement.bindLong(4, notesCategoryTreeEntity.getIsDirty());
                supportSQLiteStatement.bindLong(5, notesCategoryTreeEntity.getCreatedAt());
                supportSQLiteStatement.bindLong(6, notesCategoryTreeEntity.getLastModifiedAt());
                if (notesCategoryTreeEntity.getServerTimeStamp() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, notesCategoryTreeEntity.getServerTimeStamp().longValue());
                }
                supportSQLiteStatement.bindLong(8, notesCategoryTreeEntity.getRecycleBinTimeMoved());
                if (notesCategoryTreeEntity.getDisplayName() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, notesCategoryTreeEntity.getDisplayName());
                }
                if (notesCategoryTreeEntity.getRestorePath() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, notesCategoryTreeEntity.getRestorePath());
                }
                if (notesCategoryTreeEntity.getReorder() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindLong(11, notesCategoryTreeEntity.getReorder().intValue());
                }
                supportSQLiteStatement.bindLong(12, notesCategoryTreeEntity.getDisplayNameColor());
                supportSQLiteStatement.bindLong(13, notesCategoryTreeEntity.isSyncWithMS());
            }
        };
        this.__deletionAdapterOfNotesCategoryTreeEntity = new EntityDeletionOrUpdateAdapter<NotesCategoryTreeEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `category_tree` WHERE `UUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesCategoryTreeEntity notesCategoryTreeEntity) {
                if (notesCategoryTreeEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, notesCategoryTreeEntity.getUuid());
                }
            }
        };
        this.__updateAdapterOfNotesCategoryTreeEntity = new EntityDeletionOrUpdateAdapter<NotesCategoryTreeEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `category_tree` SET `UUID` = ?,`parentUUID` = ?,`isDeleted` = ?,`isDirty` = ?,`createdAt` = ?,`lastModifiedAt` = ?,`serverTimestamp` = ?,`recycle_bin_time_moved` = ?,`displayName` = ?,`path` = ?,`orderBy` = ?,`displayNameColor` = ?,`isSyncWithMS` = ? WHERE `UUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesCategoryTreeEntity notesCategoryTreeEntity) {
                if (notesCategoryTreeEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, notesCategoryTreeEntity.getUuid());
                }
                if (notesCategoryTreeEntity.getParentUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesCategoryTreeEntity.getParentUuid());
                }
                supportSQLiteStatement.bindLong(3, notesCategoryTreeEntity.getIsDeleted());
                supportSQLiteStatement.bindLong(4, notesCategoryTreeEntity.getIsDirty());
                supportSQLiteStatement.bindLong(5, notesCategoryTreeEntity.getCreatedAt());
                supportSQLiteStatement.bindLong(6, notesCategoryTreeEntity.getLastModifiedAt());
                if (notesCategoryTreeEntity.getServerTimeStamp() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, notesCategoryTreeEntity.getServerTimeStamp().longValue());
                }
                supportSQLiteStatement.bindLong(8, notesCategoryTreeEntity.getRecycleBinTimeMoved());
                if (notesCategoryTreeEntity.getDisplayName() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, notesCategoryTreeEntity.getDisplayName());
                }
                if (notesCategoryTreeEntity.getRestorePath() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, notesCategoryTreeEntity.getRestorePath());
                }
                if (notesCategoryTreeEntity.getReorder() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindLong(11, notesCategoryTreeEntity.getReorder().intValue());
                }
                supportSQLiteStatement.bindLong(12, notesCategoryTreeEntity.getDisplayNameColor());
                supportSQLiteStatement.bindLong(13, notesCategoryTreeEntity.isSyncWithMS());
                if (notesCategoryTreeEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, notesCategoryTreeEntity.getUuid());
                }
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM category_tree WHERE UUID = ?";
            }
        };
        this.__preparedStmtOfChangeParentUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT category_tree SET parentUUID=? , isDirty=1 , serverTimeStamp=? , lastModifiedAt=? WHERE UUID=?";
            }
        };
        this.__preparedStmtOfChangeParentUuid_1 = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT category_tree SET parentUUID=? , isDirty=1 , serverTimeStamp=? , lastModifiedAt=? , path=? WHERE UUID=?";
            }
        };
        this.__preparedStmtOfUpdateDelete = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT category_tree SET isDeleted=1 , parentUUID='trash:///' , serverTimestamp=? , lastModifiedAt=? , isDirty=1 WHERE UUID=?";
            }
        };
        this.__preparedStmtOfUpdateDelete_1 = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT category_tree SET isDeleted=1 , serverTimestamp=? WHERE UUID=?";
            }
        };
        this.__preparedStmtOfDeleteMovingCategory = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM category_tree_closure WHERE descendant IN (SELECT descendant FROM category_tree_closure WHERE ancestor = ?) AND ancestor IN (SELECT ancestor FROM category_tree_closure WHERE descendant = ? AND ancestor != descendant)";
            }
        };
        this.__preparedStmtOfMoveToParent = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.10
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO category_tree_closure (ancestor, descendant, depth) SELECT supertree.ancestor, subtree.descendant, supertree.depth + subtree.depth + 1 FROM category_tree_closure AS supertree CROSS JOIN category_tree_closure AS subtree WHERE supertree.descendant = ? AND subtree.ancestor = ?";
            }
        };
        this.__preparedStmtOfDeleteAllCategorySubTree = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.11
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT category_tree SET isDeleted=1 , serverTimestamp=? , isDirty=1 WHERE UUID IN (SELECT descendant FROM category_tree_closure WHERE ancestor = ?)";
            }
        };
        this.__preparedStmtOfMoveToTrash = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.12
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT category_tree SET path=? , isDeleted=2 , recycle_bin_time_moved=? , serverTimestamp=? , isDirty=1 WHERE UUID=?";
            }
        };
        this.__preparedStmtOfRestoreFromTrash = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.13
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT category_tree SET path=? , isDeleted=0 , recycle_bin_time_moved=? , serverTimestamp=? , isDirty=1 WHERE UUID=?";
            }
        };
        this.__preparedStmtOfInsertCategoryClosure = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.14
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO category_tree_closure (ancestor, descendant, depth) SELECT ancestor, (?), depth + 1 FROM category_tree_closure WHERE descendant = (?) UNION ALL SELECT (?), (?), 0";
            }
        };
        this.__preparedStmtOfDeleteCategoryTreeClosureSubTree = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.15
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM category_tree_closure WHERE descendant IN (SELECT descendant FROM category_tree_closure WHERE ancestor = ?)";
            }
        };
        this.__preparedStmtOfUpdateModifiedTime = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.16
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT category_tree SET lastModifiedAt =? WHERE UUID=?";
            }
        };
        this.__preparedStmtOfUpdateServerTimestamp = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.17
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT category_tree SET serverTimestamp =? , isDirty=1  WHERE UUID=?";
            }
        };
    }

    /* JADX INFO: renamed from: __entityCursorConverter_comSamsungAndroidSupportSenlNtDataDatabaseCoreDocumentEntityNotesCategoryTreeEntity */
    private NotesCategoryTreeEntity m12356xe87aef57(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("UUID");
        int columnIndex2 = cursor.getColumnIndex(DBSchema.CategoryTree.PARENT_UUID);
        int columnIndex3 = cursor.getColumnIndex("isDeleted");
        int columnIndex4 = cursor.getColumnIndex("isDirty");
        int columnIndex5 = cursor.getColumnIndex("createdAt");
        int columnIndex6 = cursor.getColumnIndex("lastModifiedAt");
        int columnIndex7 = cursor.getColumnIndex("serverTimestamp");
        int columnIndex8 = cursor.getColumnIndex("recycle_bin_time_moved");
        int columnIndex9 = cursor.getColumnIndex("displayName");
        int columnIndex10 = cursor.getColumnIndex("path");
        int columnIndex11 = cursor.getColumnIndex("orderBy");
        int columnIndex12 = cursor.getColumnIndex("displayNameColor");
        int columnIndex13 = cursor.getColumnIndex(DBSchema.CategoryTree.IS_SYNC_WITH_MS);
        NotesCategoryTreeEntity notesCategoryTreeEntity = new NotesCategoryTreeEntity((columnIndex == -1 || cursor.isNull(columnIndex)) ? null : cursor.getString(columnIndex), (columnIndex2 == -1 || cursor.isNull(columnIndex2)) ? null : cursor.getString(columnIndex2), (columnIndex9 == -1 || cursor.isNull(columnIndex9)) ? null : cursor.getString(columnIndex9), (columnIndex10 == -1 || cursor.isNull(columnIndex10)) ? null : cursor.getString(columnIndex10));
        if (columnIndex3 != -1) {
            notesCategoryTreeEntity.setIsDeleted(cursor.getInt(columnIndex3));
        }
        if (columnIndex4 != -1) {
            notesCategoryTreeEntity.setIsDirty(cursor.getInt(columnIndex4));
        }
        if (columnIndex5 != -1) {
            notesCategoryTreeEntity.setCreatedAt(cursor.getLong(columnIndex5));
        }
        if (columnIndex6 != -1) {
            notesCategoryTreeEntity.setLastModifiedAt(cursor.getLong(columnIndex6));
        }
        if (columnIndex7 != -1) {
            notesCategoryTreeEntity.setServerTimeStamp(cursor.isNull(columnIndex7) ? null : Long.valueOf(cursor.getLong(columnIndex7)));
        }
        if (columnIndex8 != -1) {
            notesCategoryTreeEntity.setRecycleBinTimeMoved(cursor.getLong(columnIndex8));
        }
        if (columnIndex11 != -1) {
            notesCategoryTreeEntity.setReorder(cursor.isNull(columnIndex11) ? null : Integer.valueOf(cursor.getInt(columnIndex11)));
        }
        if (columnIndex12 != -1) {
            notesCategoryTreeEntity.setDisplayNameColor(cursor.getInt(columnIndex12));
        }
        if (columnIndex13 != -1) {
            notesCategoryTreeEntity.setIsSyncWithMS(cursor.getInt(columnIndex13));
        }
        return notesCategoryTreeEntity;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void changeParentUuid(String str, String str2, long j, long j2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfChangeParentUuid.acquire();
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str2);
        }
        supportSQLiteStatementAcquire.bindLong(2, j);
        supportSQLiteStatementAcquire.bindLong(3, j2);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, str);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfChangeParentUuid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void deleteAllCategorySubTree(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteAllCategorySubTree.acquire();
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
            this.__preparedStmtOfDeleteAllCategorySubTree.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void deleteByUuidWithDocumentDelete(NotesDocumentDao notesDocumentDao, NotesMappedDocumentDao notesMappedDocumentDao, long j, Collection<String> collection) throws Throwable {
        NotesCategoryTreeDao_Impl notesCategoryTreeDao_Impl;
        this.__db.beginTransaction();
        try {
            super.deleteByUuidWithDocumentDelete(notesDocumentDao, notesMappedDocumentDao, j, collection);
            notesCategoryTreeDao_Impl = this;
            try {
                notesCategoryTreeDao_Impl.__db.setTransactionSuccessful();
                notesCategoryTreeDao_Impl.__db.endTransaction();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                notesCategoryTreeDao_Impl.__db.endTransaction();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            notesCategoryTreeDao_Impl = this;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void deleteCategoryTreeClosureSubTree(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteCategoryTreeClosureSubTree.acquire();
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
            this.__preparedStmtOfDeleteCategoryTreeClosureSubTree.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void deleteFromTable(String str) {
        this.__db.beginTransaction();
        try {
            super.deleteFromTable(str);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void deleteMovingCategory(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteMovingCategory.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
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
            this.__preparedStmtOfDeleteMovingCategory.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public List<String> findUuidListByDisplayName(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM category_tree WHERE displayName = ? AND category_tree.isDeleted = 0", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public List<String> findUuidListByDisplayNameIncludeDeleted(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM category_tree WHERE displayName = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public List<String> getAllCategorySubTreeUuid(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM category_tree WHERE UUID IN (SELECT descendant FROM category_tree_closure WHERE ancestor = ?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public LiveData<List<NotesFolder>> getAllCategory_LiveData(boolean z) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT tree.*, clo.depth, CASE ?  WHEN 1 THEN (SELECT COUNT(*) FROM sdoc  WHERE sdoc.categoryUUID=tree.UUID AND sdoc.isDeleted != 1) ELSE 0  END AS documentCount FROM category_tree AS tree JOIN category_tree_closure AS clo ON tree.UUID = clo.descendant WHERE tree.isDeleted != 1 AND clo.ancestor IN (SELECT UUID FROM category_tree WHERE parentUUID IS NULL) ORDER BY clo.depth ASC", 1);
        roomSQLiteQueryAcquire.bindLong(1, z ? 1L : 0L);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"sdoc", DBSchema.CategoryTree.TABLE_NAME, DBSchema.CategoryTreeClosure.TABLE_NAME}, false, new Callable<List<NotesFolder>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.18
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<NotesFolder> call() {
                int i;
                String string;
                int i2;
                String string2;
                int i4;
                String string3;
                Cursor cursorQuery = DBUtil.query(NotesCategoryTreeDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTree.PARENT_UUID);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDeleted");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recycle_bin_time_moved");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayName");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "path");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "orderBy");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayNameColor");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTree.IS_SYNC_WITH_MS);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTreeClosure.DEPTH);
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTreeClosure.DOCUMENT_COUNT);
                    int i5 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string4 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        if (cursorQuery.isNull(columnIndexOrThrow2)) {
                            i = columnIndexOrThrow;
                            string = null;
                        } else {
                            i = columnIndexOrThrow;
                            string = cursorQuery.getString(columnIndexOrThrow2);
                        }
                        if (cursorQuery.isNull(columnIndexOrThrow9)) {
                            i2 = columnIndexOrThrow2;
                            string2 = null;
                        } else {
                            i2 = columnIndexOrThrow2;
                            string2 = cursorQuery.getString(columnIndexOrThrow9);
                        }
                        if (cursorQuery.isNull(columnIndexOrThrow10)) {
                            i4 = columnIndexOrThrow9;
                            string3 = null;
                        } else {
                            i4 = columnIndexOrThrow9;
                            string3 = cursorQuery.getString(columnIndexOrThrow10);
                        }
                        int i6 = columnIndexOrThrow10;
                        NotesFolder notesFolder = new NotesFolder(string4, string, string2, string3);
                        notesFolder.setIsDeleted(cursorQuery.getInt(columnIndexOrThrow3));
                        notesFolder.setIsDirty(cursorQuery.getInt(columnIndexOrThrow4));
                        notesFolder.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow5));
                        notesFolder.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow6));
                        notesFolder.setServerTimeStamp(cursorQuery.isNull(columnIndexOrThrow7) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow7)));
                        notesFolder.setRecycleBinTimeMoved(cursorQuery.getLong(columnIndexOrThrow8));
                        notesFolder.setReorder(cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)));
                        notesFolder.setDisplayNameColor(cursorQuery.getInt(columnIndexOrThrow12));
                        notesFolder.setIsSyncWithMS(cursorQuery.getInt(columnIndexOrThrow13));
                        int i7 = i5;
                        notesFolder.setDepth(cursorQuery.getInt(i7));
                        int i8 = columnIndexOrThrow15;
                        notesFolder.setDocumentCount(cursorQuery.getInt(i8));
                        arrayList.add(notesFolder);
                        i5 = i7;
                        columnIndexOrThrow15 = i8;
                        columnIndexOrThrow10 = i6;
                        columnIndexOrThrow = i;
                        columnIndexOrThrow2 = i2;
                        columnIndexOrThrow9 = i4;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public DocumentCategoryTree getAllDocumentCategoryTree(boolean z) {
        this.__db.beginTransaction();
        try {
            DocumentCategoryTree allDocumentCategoryTree = super.getAllDocumentCategoryTree(z);
            this.__db.setTransactionSuccessful();
            return allDocumentCategoryTree;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public List<NotesFolder> getAllNotesFolders(boolean z) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        int i2;
        String string2;
        int i4;
        String string3;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT tree.*, clo.depth, CASE ?  WHEN 1 THEN (SELECT COUNT(*) FROM sdoc  WHERE sdoc.categoryUUID=tree.UUID AND sdoc.isDeleted != 1) ELSE 0  END AS documentCount FROM category_tree AS tree JOIN category_tree_closure AS clo ON tree.UUID = clo.descendant WHERE tree.isDeleted != 1 AND clo.ancestor IN (SELECT UUID FROM category_tree WHERE parentUUID IS NULL) ORDER BY clo.depth ASC", 1);
        roomSQLiteQueryAcquire.bindLong(1, z ? 1L : 0L);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTree.PARENT_UUID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDeleted");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recycle_bin_time_moved");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayName");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "path");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "orderBy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayNameColor");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTree.IS_SYNC_WITH_MS);
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTreeClosure.DEPTH);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTreeClosure.DOCUMENT_COUNT);
                int i5 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string4 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                    if (cursorQuery.isNull(columnIndexOrThrow2)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(columnIndexOrThrow2);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow9)) {
                        i2 = columnIndexOrThrow2;
                        string2 = null;
                    } else {
                        i2 = columnIndexOrThrow2;
                        string2 = cursorQuery.getString(columnIndexOrThrow9);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow10)) {
                        i4 = columnIndexOrThrow9;
                        string3 = null;
                    } else {
                        i4 = columnIndexOrThrow9;
                        string3 = cursorQuery.getString(columnIndexOrThrow10);
                    }
                    int i6 = columnIndexOrThrow10;
                    NotesFolder notesFolder = new NotesFolder(string4, string, string2, string3);
                    notesFolder.setIsDeleted(cursorQuery.getInt(columnIndexOrThrow3));
                    notesFolder.setIsDirty(cursorQuery.getInt(columnIndexOrThrow4));
                    notesFolder.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow5));
                    notesFolder.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow6));
                    notesFolder.setServerTimeStamp(cursorQuery.isNull(columnIndexOrThrow7) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow7)));
                    notesFolder.setRecycleBinTimeMoved(cursorQuery.getLong(columnIndexOrThrow8));
                    notesFolder.setReorder(cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)));
                    notesFolder.setDisplayNameColor(cursorQuery.getInt(columnIndexOrThrow12));
                    notesFolder.setIsSyncWithMS(cursorQuery.getInt(columnIndexOrThrow13));
                    int i7 = i5;
                    notesFolder.setDepth(cursorQuery.getInt(i7));
                    int i8 = columnIndexOrThrow15;
                    notesFolder.setDocumentCount(cursorQuery.getInt(i8));
                    arrayList.add(notesFolder);
                    i5 = i7;
                    columnIndexOrThrow15 = i8;
                    columnIndexOrThrow10 = i6;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow2 = i2;
                    columnIndexOrThrow9 = i4;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public int getChildrenCount(String str, Set<String> set) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT COUNT(*) FROM category_tree WHERE parentUUID = ");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" AND category_tree.isDeleted = 0 AND UUID NOT IN (");
        int size = set.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        int i = 2;
        for (String str2 : set) {
            if (str2 == null) {
                roomSQLiteQueryAcquire.bindNull(i);
            } else {
                roomSQLiteQueryAcquire.bindString(i, str2);
            }
            i++;
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public List<String> getChildrenUuids(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM category_tree WHERE parentUUID = ? AND isDeleted != 1", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public List<NotesCategoryTreeEntity> getEntities(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            List<NotesCategoryTreeEntity> entities = super.getEntities(collection);
            this.__db.setTransactionSuccessful();
            return entities;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public List<NotesCategoryTreeEntity> getEntitiesInChunk(Collection<String> collection) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String string;
        int i2;
        String string2;
        int i4;
        String string3;
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), AbstractC11014a.m12317b(sbNewStringBuilder, "SELECT * FROM category_tree WHERE UUID IN (", collection, sbNewStringBuilder, ") ORDER BY UUID ASC"));
        int i5 = 1;
        for (String str : collection) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i5);
            } else {
                roomSQLiteQueryAcquire.bindString(i5, str);
            }
            i5++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTree.PARENT_UUID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDeleted");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recycle_bin_time_moved");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayName");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "path");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "orderBy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayNameColor");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTree.IS_SYNC_WITH_MS);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string4 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                    if (cursorQuery.isNull(columnIndexOrThrow2)) {
                        i = columnIndexOrThrow;
                        string = null;
                    } else {
                        i = columnIndexOrThrow;
                        string = cursorQuery.getString(columnIndexOrThrow2);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow9)) {
                        i2 = columnIndexOrThrow2;
                        string2 = null;
                    } else {
                        i2 = columnIndexOrThrow2;
                        string2 = cursorQuery.getString(columnIndexOrThrow9);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow10)) {
                        i4 = columnIndexOrThrow9;
                        string3 = null;
                    } else {
                        i4 = columnIndexOrThrow9;
                        string3 = cursorQuery.getString(columnIndexOrThrow10);
                    }
                    int i6 = columnIndexOrThrow10;
                    NotesCategoryTreeEntity notesCategoryTreeEntity = new NotesCategoryTreeEntity(string4, string, string2, string3);
                    notesCategoryTreeEntity.setIsDeleted(cursorQuery.getInt(columnIndexOrThrow3));
                    notesCategoryTreeEntity.setIsDirty(cursorQuery.getInt(columnIndexOrThrow4));
                    int i7 = columnIndexOrThrow3;
                    notesCategoryTreeEntity.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow5));
                    notesCategoryTreeEntity.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow6));
                    notesCategoryTreeEntity.setServerTimeStamp(cursorQuery.isNull(columnIndexOrThrow7) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow7)));
                    notesCategoryTreeEntity.setRecycleBinTimeMoved(cursorQuery.getLong(columnIndexOrThrow8));
                    notesCategoryTreeEntity.setReorder(cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)));
                    notesCategoryTreeEntity.setDisplayNameColor(cursorQuery.getInt(columnIndexOrThrow12));
                    notesCategoryTreeEntity.setIsSyncWithMS(cursorQuery.getInt(columnIndexOrThrow13));
                    arrayList.add(notesCategoryTreeEntity);
                    columnIndexOrThrow3 = i7;
                    columnIndexOrThrow10 = i6;
                    columnIndexOrThrow = i;
                    columnIndexOrThrow2 = i2;
                    columnIndexOrThrow9 = i4;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public NotesCategoryTreeEntity getEntity(String str) {
        NotesCategoryTreeEntity notesCategoryTreeEntity;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM category_tree WHERE UUID = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTree.PARENT_UUID);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDeleted");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recycle_bin_time_moved");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayName");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "path");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "orderBy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayNameColor");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTree.IS_SYNC_WITH_MS);
            if (cursorQuery.moveToFirst()) {
                NotesCategoryTreeEntity notesCategoryTreeEntity2 = new NotesCategoryTreeEntity(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                notesCategoryTreeEntity2.setIsDeleted(cursorQuery.getInt(columnIndexOrThrow3));
                notesCategoryTreeEntity2.setIsDirty(cursorQuery.getInt(columnIndexOrThrow4));
                notesCategoryTreeEntity2.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow5));
                notesCategoryTreeEntity2.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow6));
                notesCategoryTreeEntity2.setServerTimeStamp(cursorQuery.isNull(columnIndexOrThrow7) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow7)));
                notesCategoryTreeEntity2.setRecycleBinTimeMoved(cursorQuery.getLong(columnIndexOrThrow8));
                notesCategoryTreeEntity2.setReorder(cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)));
                notesCategoryTreeEntity2.setDisplayNameColor(cursorQuery.getInt(columnIndexOrThrow12));
                notesCategoryTreeEntity2.setIsSyncWithMS(cursorQuery.getInt(columnIndexOrThrow13));
                notesCategoryTreeEntity = notesCategoryTreeEntity2;
            } else {
                notesCategoryTreeEntity = null;
            }
            return notesCategoryTreeEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public List<String> getExpiredRecycleBinDataNotInFolder(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM category_tree WHERE recycle_bin_time_moved<? AND recycle_bin_time_moved IS NOT 0 AND isDeleted=2 AND parentUUID='trash:///'", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public NotesFolder getNotesFolder(String str, boolean z) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        NotesFolder notesFolder;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT tree.*, clo.depth, CASE ?  WHEN 1 THEN (SELECT COUNT(*) FROM sdoc                 WHERE sdoc.categoryUUID=tree.UUID AND sdoc.isDeleted != 1) ELSE 0  END AS documentCount FROM category_tree AS tree JOIN category_tree_closure AS clo ON (tree.UUID = clo.descendant) WHERE clo.ancestor = ? ORDER BY clo.depth ASC LIMIT 1", 2);
        roomSQLiteQueryAcquire.bindLong(1, z ? 1L : 0L);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTree.PARENT_UUID);
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDeleted");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recycle_bin_time_moved");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayName");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "path");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "orderBy");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayNameColor");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTree.IS_SYNC_WITH_MS);
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTreeClosure.DEPTH);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTreeClosure.DOCUMENT_COUNT);
            if (cursorQuery.moveToFirst()) {
                NotesFolder notesFolder2 = new NotesFolder(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9), cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                notesFolder2.setIsDeleted(cursorQuery.getInt(columnIndexOrThrow3));
                notesFolder2.setIsDirty(cursorQuery.getInt(columnIndexOrThrow4));
                notesFolder2.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow5));
                notesFolder2.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow6));
                notesFolder2.setServerTimeStamp(cursorQuery.isNull(columnIndexOrThrow7) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow7)));
                notesFolder2.setRecycleBinTimeMoved(cursorQuery.getLong(columnIndexOrThrow8));
                notesFolder2.setReorder(cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)));
                notesFolder2.setDisplayNameColor(cursorQuery.getInt(columnIndexOrThrow12));
                notesFolder2.setIsSyncWithMS(cursorQuery.getInt(columnIndexOrThrow13));
                notesFolder2.setDepth(cursorQuery.getInt(columnIndexOrThrow14));
                notesFolder2.setDocumentCount(cursorQuery.getInt(columnIndexOrThrow15));
                notesFolder = notesFolder2;
            } else {
                notesFolder = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return notesFolder;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public List<NotesFolder> getNotesFolders(String str, boolean z) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i;
        String string;
        int i2;
        String string2;
        int i4;
        String string3;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT tree.*, clo.depth, CASE ?  WHEN 1 THEN (SELECT COUNT(*) FROM sdoc                 WHERE sdoc.categoryUUID=tree.UUID AND sdoc.isDeleted != 1) ELSE 0  END AS documentCount FROM category_tree AS tree JOIN category_tree_closure AS clo ON (tree.UUID = clo.descendant) WHERE clo.ancestor = ? ORDER BY clo.depth ASC", 2);
        roomSQLiteQueryAcquire.bindLong(1, z ? 1L : 0L);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTree.PARENT_UUID);
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDeleted");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recycle_bin_time_moved");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayName");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "path");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "orderBy");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayNameColor");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTree.IS_SYNC_WITH_MS);
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTreeClosure.DEPTH);
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTreeClosure.DOCUMENT_COUNT);
            int i5 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string4 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                if (cursorQuery.isNull(columnIndexOrThrow2)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = cursorQuery.getString(columnIndexOrThrow2);
                }
                if (cursorQuery.isNull(columnIndexOrThrow9)) {
                    i2 = columnIndexOrThrow2;
                    string2 = null;
                } else {
                    i2 = columnIndexOrThrow2;
                    string2 = cursorQuery.getString(columnIndexOrThrow9);
                }
                if (cursorQuery.isNull(columnIndexOrThrow10)) {
                    i4 = columnIndexOrThrow9;
                    string3 = null;
                } else {
                    i4 = columnIndexOrThrow9;
                    string3 = cursorQuery.getString(columnIndexOrThrow10);
                }
                int i6 = columnIndexOrThrow10;
                NotesFolder notesFolder = new NotesFolder(string4, string, string2, string3);
                notesFolder.setIsDeleted(cursorQuery.getInt(columnIndexOrThrow3));
                notesFolder.setIsDirty(cursorQuery.getInt(columnIndexOrThrow4));
                notesFolder.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow5));
                notesFolder.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow6));
                notesFolder.setServerTimeStamp(cursorQuery.isNull(columnIndexOrThrow7) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow7)));
                notesFolder.setRecycleBinTimeMoved(cursorQuery.getLong(columnIndexOrThrow8));
                notesFolder.setReorder(cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)));
                notesFolder.setDisplayNameColor(cursorQuery.getInt(columnIndexOrThrow12));
                notesFolder.setIsSyncWithMS(cursorQuery.getInt(columnIndexOrThrow13));
                int i7 = i5;
                notesFolder.setDepth(cursorQuery.getInt(i7));
                int i8 = columnIndexOrThrow15;
                notesFolder.setDocumentCount(cursorQuery.getInt(i8));
                arrayList.add(notesFolder);
                i5 = i7;
                columnIndexOrThrow15 = i8;
                columnIndexOrThrow10 = i6;
                columnIndexOrThrow = i;
                columnIndexOrThrow2 = i2;
                columnIndexOrThrow9 = i4;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public List<CategoryTimeTuple> getParentsCategoryUuidList(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID, serverTimestamp FROM category_tree WHERE UUID IN (SELECT ancestor FROM category_tree_closure WHERE descendant = ?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new CategoryTimeTuple(cursorQuery.isNull(1) ? null : Long.valueOf(cursorQuery.getLong(1)), cursorQuery.isNull(0) ? null : cursorQuery.getString(0)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public List<String> getUuidsByDisplayName(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM category_tree WHERE REPLACE(LOWER(displayName), ' ', '') LIKE '%' || (?) || '%' AND category_tree.isDeleted = 0", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public long insertCategoryClosure(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfInsertCategoryClosure.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str2);
        }
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, str);
        }
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, str);
        }
        this.__db.beginTransaction();
        try {
            long jExecuteInsert = supportSQLiteStatementAcquire.executeInsert();
            this.__db.setTransactionSuccessful();
            return jExecuteInsert;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfInsertCategoryClosure.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void insertFolder(String str, String str2, String str3, int i, String str4, long j, long j2, boolean z) throws Throwable {
        NotesCategoryTreeDao_Impl notesCategoryTreeDao_Impl;
        this.__db.beginTransaction();
        try {
            super.insertFolder(str, str2, str3, i, str4, j, j2, z);
            notesCategoryTreeDao_Impl = this;
            try {
                notesCategoryTreeDao_Impl.__db.setTransactionSuccessful();
                notesCategoryTreeDao_Impl.__db.endTransaction();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                notesCategoryTreeDao_Impl.__db.endTransaction();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            notesCategoryTreeDao_Impl = this;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public boolean isUsed(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT 1 FROM category_tree WHERE UUID = ? AND category_tree.isDeleted = 0", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public boolean move(Context context, NotesDocumentDao notesDocumentDao, String str, String str2, long j, long j2) throws Throwable {
        NotesCategoryTreeDao_Impl notesCategoryTreeDao_Impl;
        this.__db.beginTransaction();
        try {
            boolean zMove = super.move(context, notesDocumentDao, str, str2, j, j2);
            notesCategoryTreeDao_Impl = this;
            try {
                notesCategoryTreeDao_Impl.__db.setTransactionSuccessful();
                notesCategoryTreeDao_Impl.__db.endTransaction();
                return zMove;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                notesCategoryTreeDao_Impl.__db.endTransaction();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            notesCategoryTreeDao_Impl = this;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public boolean moveInTrash(Context context, Collection<String> collection, NotesDocumentDao notesDocumentDao, String str, long j, long j2) throws Throwable {
        NotesCategoryTreeDao_Impl notesCategoryTreeDao_Impl;
        this.__db.beginTransaction();
        try {
            boolean zMoveInTrash = super.moveInTrash(context, collection, notesDocumentDao, str, j, j2);
            notesCategoryTreeDao_Impl = this;
            try {
                notesCategoryTreeDao_Impl.__db.setTransactionSuccessful();
                notesCategoryTreeDao_Impl.__db.endTransaction();
                return zMoveInTrash;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                notesCategoryTreeDao_Impl.__db.endTransaction();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            notesCategoryTreeDao_Impl = this;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void moveToParent(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfMoveToParent.acquire();
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str2);
        }
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeInsert();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfMoveToParent.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public boolean moveToRecycleBin(String str, long j, long j2, NotesDocumentDao notesDocumentDao, DocumentCategoryTree documentCategoryTree) throws Throwable {
        NotesCategoryTreeDao_Impl notesCategoryTreeDao_Impl;
        this.__db.beginTransaction();
        try {
            boolean zMoveToRecycleBin = super.moveToRecycleBin(str, j, j2, notesDocumentDao, documentCategoryTree);
            notesCategoryTreeDao_Impl = this;
            try {
                notesCategoryTreeDao_Impl.__db.setTransactionSuccessful();
                notesCategoryTreeDao_Impl.__db.endTransaction();
                return zMoveToRecycleBin;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                notesCategoryTreeDao_Impl.__db.endTransaction();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            notesCategoryTreeDao_Impl = this;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void moveToTrash(String str, String str2, long j, long j2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfMoveToTrash.acquire();
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str2);
        }
        supportSQLiteStatementAcquire.bindLong(2, j);
        supportSQLiteStatementAcquire.bindLong(3, j2);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, str);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfMoveToTrash.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public List<NotesCategoryTreeEntity> rawQuery(SupportSQLiteQuery supportSQLiteQuery) {
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, supportSQLiteQuery, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(m12356xe87aef57(cursorQuery));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void reorder(String str, Collection<? extends NotesCategoryTreeEntity> collection, long j, long j2) throws Throwable {
        NotesCategoryTreeDao_Impl notesCategoryTreeDao_Impl;
        this.__db.beginTransaction();
        try {
            super.reorder(str, collection, j, j2);
            notesCategoryTreeDao_Impl = this;
            try {
                notesCategoryTreeDao_Impl.__db.setTransactionSuccessful();
                notesCategoryTreeDao_Impl.__db.endTransaction();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                notesCategoryTreeDao_Impl.__db.endTransaction();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            notesCategoryTreeDao_Impl = this;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void restore(Collection<? extends NotesCategoryTreeEntity> collection, Collection<? extends NotesCategoryTreeEntity> collection2) {
        this.__db.beginTransaction();
        try {
            super.restore(collection, collection2);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void restoreFromTrash(String str, String str2, long j, long j2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfRestoreFromTrash.acquire();
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str2);
        }
        supportSQLiteStatementAcquire.bindLong(2, j);
        supportSQLiteStatementAcquire.bindLong(3, j2);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, str);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfRestoreFromTrash.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public int updateDelete(String str, long j, long j2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateDelete.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j);
        supportSQLiteStatementAcquire.bindLong(2, j2);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, str);
        }
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateDelete.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void updateModifiedTime(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateModifiedTime.acquire();
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
            this.__preparedStmtOfUpdateModifiedTime.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void updateModifiedTimeWithUuidList(Collection<CategoryTimeTuple> collection) {
        this.__db.beginTransaction();
        try {
            super.updateModifiedTimeWithUuidList(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void updateServerTimestamp(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateServerTimestamp.acquire();
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
            this.__preparedStmtOfUpdateServerTimestamp.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void updateServerTimestampWithUuidList(Collection<CategoryTimeTuple> collection) {
        this.__db.beginTransaction();
        try {
            super.updateServerTimestampWithUuidList(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(NotesCategoryTreeEntity notesCategoryTreeEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfNotesCategoryTreeEntity.handle(notesCategoryTreeEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(NotesCategoryTreeEntity notesCategoryTreeEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfNotesCategoryTreeEntity.insert(notesCategoryTreeEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(NotesCategoryTreeEntity notesCategoryTreeEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfNotesCategoryTreeEntity.handle(notesCategoryTreeEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(NotesCategoryTreeEntity notesCategoryTreeEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(notesCategoryTreeEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public LiveData<List<NotesFolder>> getAllCategory_LiveData(Collection<String> collection, boolean z) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT tree.*, clo.depth, CASE ");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append("  WHEN 1 THEN (SELECT COUNT(*) FROM sdoc  WHERE sdoc.categoryUUID=tree.UUID AND sdoc.isDeleted != 1) ELSE 0  END AS documentCount FROM category_tree AS tree JOIN category_tree_closure AS clo ON tree.UUID = clo.descendant WHERE tree.isDeleted != 1 AND clo.ancestor IN (SELECT UUID FROM category_tree WHERE parentUUID IS NULL AND UUID NOT IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")) AND tree.UUID NOT IN (");
        int size2 = collection.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size2);
        sbNewStringBuilder.append(") ORDER BY clo.depth ASC");
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 1 + size2);
        roomSQLiteQueryAcquire.bindLong(1, z ? 1L : 0L);
        int i = 2;
        for (String str : collection) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i);
            } else {
                roomSQLiteQueryAcquire.bindString(i, str);
            }
            i++;
        }
        int i2 = size + 2;
        for (String str2 : collection) {
            if (str2 == null) {
                roomSQLiteQueryAcquire.bindNull(i2);
            } else {
                roomSQLiteQueryAcquire.bindString(i2, str2);
            }
            i2++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"sdoc", DBSchema.CategoryTree.TABLE_NAME, DBSchema.CategoryTreeClosure.TABLE_NAME}, false, new Callable<List<NotesFolder>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesCategoryTreeDao_Impl.19
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<NotesFolder> call() {
                int i4;
                String string;
                int i5;
                String string2;
                int i6;
                String string3;
                Cursor cursorQuery = DBUtil.query(NotesCategoryTreeDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTree.PARENT_UUID);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDeleted");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recycle_bin_time_moved");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayName");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "path");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "orderBy");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayNameColor");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTree.IS_SYNC_WITH_MS);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTreeClosure.DEPTH);
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.CategoryTreeClosure.DOCUMENT_COUNT);
                    int i7 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        String string4 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                        if (cursorQuery.isNull(columnIndexOrThrow2)) {
                            i4 = columnIndexOrThrow;
                            string = null;
                        } else {
                            i4 = columnIndexOrThrow;
                            string = cursorQuery.getString(columnIndexOrThrow2);
                        }
                        if (cursorQuery.isNull(columnIndexOrThrow9)) {
                            i5 = columnIndexOrThrow2;
                            string2 = null;
                        } else {
                            i5 = columnIndexOrThrow2;
                            string2 = cursorQuery.getString(columnIndexOrThrow9);
                        }
                        if (cursorQuery.isNull(columnIndexOrThrow10)) {
                            i6 = columnIndexOrThrow9;
                            string3 = null;
                        } else {
                            i6 = columnIndexOrThrow9;
                            string3 = cursorQuery.getString(columnIndexOrThrow10);
                        }
                        int i8 = columnIndexOrThrow10;
                        NotesFolder notesFolder = new NotesFolder(string4, string, string2, string3);
                        notesFolder.setIsDeleted(cursorQuery.getInt(columnIndexOrThrow3));
                        notesFolder.setIsDirty(cursorQuery.getInt(columnIndexOrThrow4));
                        notesFolder.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow5));
                        notesFolder.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow6));
                        notesFolder.setServerTimeStamp(cursorQuery.isNull(columnIndexOrThrow7) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow7)));
                        notesFolder.setRecycleBinTimeMoved(cursorQuery.getLong(columnIndexOrThrow8));
                        notesFolder.setReorder(cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)));
                        notesFolder.setDisplayNameColor(cursorQuery.getInt(columnIndexOrThrow12));
                        notesFolder.setIsSyncWithMS(cursorQuery.getInt(columnIndexOrThrow13));
                        int i9 = i7;
                        notesFolder.setDepth(cursorQuery.getInt(i9));
                        int i10 = columnIndexOrThrow15;
                        notesFolder.setDocumentCount(cursorQuery.getInt(i10));
                        arrayList.add(notesFolder);
                        i7 = i9;
                        columnIndexOrThrow15 = i10;
                        columnIndexOrThrow10 = i8;
                        columnIndexOrThrow = i4;
                        columnIndexOrThrow2 = i5;
                        columnIndexOrThrow9 = i6;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public DocumentCategoryTree getAllDocumentCategoryTree(boolean z, boolean z2) {
        this.__db.beginTransaction();
        try {
            DocumentCategoryTree allDocumentCategoryTree = super.getAllDocumentCategoryTree(z, z2);
            this.__db.setTransactionSuccessful();
            return allDocumentCategoryTree;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public List<NotesCategoryTreeEntity> getEntities() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `category_tree`.`UUID` AS `UUID`, `category_tree`.`parentUUID` AS `parentUUID`, `category_tree`.`isDeleted` AS `isDeleted`, `category_tree`.`isDirty` AS `isDirty`, `category_tree`.`createdAt` AS `createdAt`, `category_tree`.`lastModifiedAt` AS `lastModifiedAt`, `category_tree`.`serverTimestamp` AS `serverTimestamp`, `category_tree`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `category_tree`.`displayName` AS `displayName`, `category_tree`.`path` AS `path`, `category_tree`.`orderBy` AS `orderBy`, `category_tree`.`displayNameColor` AS `displayNameColor`, `category_tree`.`isSyncWithMS` AS `isSyncWithMS` FROM category_tree ORDER BY UUID ASC", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void insertFolder(NotesCategoryTreeEntity notesCategoryTreeEntity) {
        this.__db.beginTransaction();
        try {
            super.insertFolder(notesCategoryTreeEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public String restore(Context context, NotesDocumentDao notesDocumentDao, String str, long j, long j2) throws Throwable {
        NotesCategoryTreeDao_Impl notesCategoryTreeDao_Impl;
        this.__db.beginTransaction();
        try {
            String strRestore = super.restore(context, notesDocumentDao, str, j, j2);
            notesCategoryTreeDao_Impl = this;
            try {
                notesCategoryTreeDao_Impl.__db.setTransactionSuccessful();
                notesCategoryTreeDao_Impl.__db.endTransaction();
                return strRestore;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                notesCategoryTreeDao_Impl.__db.endTransaction();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            notesCategoryTreeDao_Impl = this;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends NotesCategoryTreeEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public int delete(NotesFolder notesFolder, long j, long j2) throws Throwable {
        NotesCategoryTreeDao_Impl notesCategoryTreeDao_Impl;
        this.__db.beginTransaction();
        try {
            int iDelete = super.delete(notesFolder, j, j2);
            notesCategoryTreeDao_Impl = this;
            try {
                notesCategoryTreeDao_Impl.__db.setTransactionSuccessful();
                notesCategoryTreeDao_Impl.__db.endTransaction();
                return iDelete;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                notesCategoryTreeDao_Impl.__db.endTransaction();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            notesCategoryTreeDao_Impl = this;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public int update(Collection<? extends NotesCategoryTreeEntity> collection) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__updateAdapterOfNotesCategoryTreeEntity.handleMultiple(collection);
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public DocumentCategoryTree getAllDocumentCategoryTree(String str, boolean z) {
        this.__db.beginTransaction();
        try {
            DocumentCategoryTree allDocumentCategoryTree = super.getAllDocumentCategoryTree(str, z);
            this.__db.setTransactionSuccessful();
            return allDocumentCategoryTree;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void insertFolder(Collection<? extends NotesCategoryTreeEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.insertFolder(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public int delete(String str, long j) {
        this.__db.beginTransaction();
        try {
            int iDelete = super.delete(str, j);
            this.__db.setTransactionSuccessful();
            return iDelete;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public int updateDelete(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateDelete_1.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateDelete_1.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
    public void changeParentUuid(String str, String str2, long j, long j2, String str3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfChangeParentUuid_1.acquire();
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str2);
        }
        supportSQLiteStatementAcquire.bindLong(2, j);
        supportSQLiteStatementAcquire.bindLong(3, j2);
        if (str3 == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, str3);
        }
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(5);
        } else {
            supportSQLiteStatementAcquire.bindString(5, str);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfChangeParentUuid_1.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao
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
}
