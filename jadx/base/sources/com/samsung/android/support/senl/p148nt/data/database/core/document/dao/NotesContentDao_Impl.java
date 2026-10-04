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
import androidx.sqlite.p113db.SupportSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.ContentFileData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesContentEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesContentDao_Impl extends NotesContentDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<NotesContentEntity> __deletionAdapterOfNotesContentEntity;
    private final EntityInsertionAdapter<NotesContentEntity> __insertionAdapterOfNotesContentEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDummy;
    private final SharedSQLiteStatement __preparedStmtOfUpdateIsDeleted;
    private final SharedSQLiteStatement __preparedStmtOfUpdateIsDirtyAndIsDeleted;
    private final EntityDeletionOrUpdateAdapter<NotesContentEntity> __updateAdapterOfNotesContentEntity;

    public NotesContentDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNotesContentEntity = new EntityInsertionAdapter<NotesContentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesContentDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `content` (`_id`,`UUID`,`isDeleted`,`isDirty`,`accountType`,`accountName`,`sdocUUID`,`mime_type`,`displayName`,`srcID`,`data`,`_data`,`filePath`,`contentSecureVersion`,`createdAt`,`size`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesContentEntity notesContentEntity) {
                if (notesContentEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesContentEntity.getId().longValue());
                }
                if (notesContentEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesContentEntity.getUuid());
                }
                supportSQLiteStatement.bindLong(3, notesContentEntity.getIsDeleted());
                supportSQLiteStatement.bindLong(4, notesContentEntity.getIsDirty());
                if (notesContentEntity.getAccountType() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, notesContentEntity.getAccountType());
                }
                if (notesContentEntity.getAccountName() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, notesContentEntity.getAccountName());
                }
                if (notesContentEntity.getSdocUuid() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, notesContentEntity.getSdocUuid());
                }
                if (notesContentEntity.getMimeType() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, notesContentEntity.getMimeType());
                }
                if (notesContentEntity.getDisplayName() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, notesContentEntity.getDisplayName());
                }
                supportSQLiteStatement.bindLong(10, notesContentEntity.getSrcId());
                if (notesContentEntity.getData() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindBlob(11, notesContentEntity.getData());
                }
                if (notesContentEntity.getMediaData() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, notesContentEntity.getMediaData());
                }
                if (notesContentEntity.getFilePath() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, notesContentEntity.getFilePath());
                }
                supportSQLiteStatement.bindLong(14, notesContentEntity.getContentSecureVersion());
                supportSQLiteStatement.bindLong(15, notesContentEntity.getCreatedAt());
                supportSQLiteStatement.bindLong(16, notesContentEntity.getSize());
            }
        };
        this.__deletionAdapterOfNotesContentEntity = new EntityDeletionOrUpdateAdapter<NotesContentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesContentDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `content` WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesContentEntity notesContentEntity) {
                if (notesContentEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesContentEntity.getId().longValue());
                }
            }
        };
        this.__updateAdapterOfNotesContentEntity = new EntityDeletionOrUpdateAdapter<NotesContentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesContentDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `content` SET `_id` = ?,`UUID` = ?,`isDeleted` = ?,`isDirty` = ?,`accountType` = ?,`accountName` = ?,`sdocUUID` = ?,`mime_type` = ?,`displayName` = ?,`srcID` = ?,`data` = ?,`_data` = ?,`filePath` = ?,`contentSecureVersion` = ?,`createdAt` = ?,`size` = ? WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesContentEntity notesContentEntity) {
                if (notesContentEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesContentEntity.getId().longValue());
                }
                if (notesContentEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesContentEntity.getUuid());
                }
                supportSQLiteStatement.bindLong(3, notesContentEntity.getIsDeleted());
                supportSQLiteStatement.bindLong(4, notesContentEntity.getIsDirty());
                if (notesContentEntity.getAccountType() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, notesContentEntity.getAccountType());
                }
                if (notesContentEntity.getAccountName() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, notesContentEntity.getAccountName());
                }
                if (notesContentEntity.getSdocUuid() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, notesContentEntity.getSdocUuid());
                }
                if (notesContentEntity.getMimeType() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, notesContentEntity.getMimeType());
                }
                if (notesContentEntity.getDisplayName() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, notesContentEntity.getDisplayName());
                }
                supportSQLiteStatement.bindLong(10, notesContentEntity.getSrcId());
                if (notesContentEntity.getData() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindBlob(11, notesContentEntity.getData());
                }
                if (notesContentEntity.getMediaData() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, notesContentEntity.getMediaData());
                }
                if (notesContentEntity.getFilePath() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, notesContentEntity.getFilePath());
                }
                supportSQLiteStatement.bindLong(14, notesContentEntity.getContentSecureVersion());
                supportSQLiteStatement.bindLong(15, notesContentEntity.getCreatedAt());
                supportSQLiteStatement.bindLong(16, notesContentEntity.getSize());
                if (notesContentEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindLong(17, notesContentEntity.getId().longValue());
                }
            }
        };
        this.__preparedStmtOfUpdateIsDirtyAndIsDeleted = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesContentDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT content SET isDirty=? , isDeleted=? WHERE UUID=?";
            }
        };
        this.__preparedStmtOfUpdateIsDeleted = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesContentDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT content SET isDeleted=? WHERE UUID=?";
            }
        };
        this.__preparedStmtOfDeleteDummy = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesContentDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM content WHERE sdocUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesContentDao
    public void deleteBySDocUuid(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            super.deleteBySDocUuid(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesContentDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesContentDao
    public void deleteInChunk(List<String> list) {
        StringBuilder sbM12324i = AbstractC11014a.m12324i(this.__db, "DELETE FROM content WHERE sdocUUID IN (");
        StringUtil.appendPlaceholders(sbM12324i, list.size());
        sbM12324i.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbM12324i.toString());
        int i = 1;
        for (String str : list) {
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesContentDao
    public List<NotesContentEntity> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `content`.`_id` AS `_id`, `content`.`UUID` AS `UUID`, `content`.`isDeleted` AS `isDeleted`, `content`.`isDirty` AS `isDirty`, `content`.`accountType` AS `accountType`, `content`.`accountName` AS `accountName`, `content`.`sdocUUID` AS `sdocUUID`, `content`.`mime_type` AS `mime_type`, `content`.`displayName` AS `displayName`, `content`.`srcID` AS `srcID`, `content`.`data` AS `data`, `content`.`_data` AS `_data`, `content`.`filePath` AS `filePath`, `content`.`contentSecureVersion` AS `contentSecureVersion`, `content`.`createdAt` AS `createdAt`, `content`.`size` AS `size` FROM content", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesContentEntity notesContentEntity = new NotesContentEntity();
                notesContentEntity.setId(cursorQuery.isNull(0) ? null : Long.valueOf(cursorQuery.getLong(0)));
                notesContentEntity.setUuid(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                notesContentEntity.setIsDeleted(cursorQuery.getInt(2));
                notesContentEntity.setIsDirty(cursorQuery.getInt(3));
                notesContentEntity.setAccountType(cursorQuery.isNull(4) ? null : cursorQuery.getString(4));
                notesContentEntity.setAccountName(cursorQuery.isNull(5) ? null : cursorQuery.getString(5));
                notesContentEntity.setSdocUuid(cursorQuery.isNull(6) ? null : cursorQuery.getString(6));
                notesContentEntity.setMimeType(cursorQuery.isNull(7) ? null : cursorQuery.getString(7));
                notesContentEntity.setDisplayName(cursorQuery.isNull(8) ? null : cursorQuery.getString(8));
                notesContentEntity.setSrcId(cursorQuery.getInt(9));
                notesContentEntity.setData(cursorQuery.isNull(10) ? null : cursorQuery.getBlob(10));
                notesContentEntity.setMediaData(cursorQuery.isNull(11) ? null : cursorQuery.getString(11));
                notesContentEntity.setFilePath(cursorQuery.isNull(12) ? null : cursorQuery.getString(12));
                notesContentEntity.setContentSecureVersion(cursorQuery.getInt(13));
                notesContentEntity.setCreatedAt(cursorQuery.getLong(14));
                notesContentEntity.setSize(cursorQuery.getLong(15));
                arrayList.add(notesContentEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesContentDao
    public List<NotesContentEntity> getEntitiesWithNonMatchingVersion(String str, int i) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i2;
        Long lValueOf;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM content WHERE sdocUUID=? AND contentSecureVersion != ?", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        roomSQLiteQueryAcquire.bindLong(2, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDeleted");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accountType");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accountName");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sdocUUID");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mime_type");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayName");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "srcID");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_data");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filePath");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "contentSecureVersion");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size");
                int i4 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    NotesContentEntity notesContentEntity = new NotesContentEntity();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        i2 = columnIndexOrThrow;
                        lValueOf = null;
                    } else {
                        i2 = columnIndexOrThrow;
                        lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow));
                    }
                    notesContentEntity.setId(lValueOf);
                    notesContentEntity.setUuid(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    notesContentEntity.setIsDeleted(cursorQuery.getInt(columnIndexOrThrow3));
                    notesContentEntity.setIsDirty(cursorQuery.getInt(columnIndexOrThrow4));
                    notesContentEntity.setAccountType(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    notesContentEntity.setAccountName(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    notesContentEntity.setSdocUuid(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    notesContentEntity.setMimeType(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    notesContentEntity.setDisplayName(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    notesContentEntity.setSrcId(cursorQuery.getInt(columnIndexOrThrow10));
                    notesContentEntity.setData(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getBlob(columnIndexOrThrow11));
                    notesContentEntity.setMediaData(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    notesContentEntity.setFilePath(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i5 = i4;
                    int i6 = columnIndexOrThrow13;
                    notesContentEntity.setContentSecureVersion(cursorQuery.getInt(i5));
                    int i7 = columnIndexOrThrow15;
                    int i8 = columnIndexOrThrow2;
                    int i9 = columnIndexOrThrow3;
                    notesContentEntity.setCreatedAt(cursorQuery.getLong(i7));
                    int i10 = columnIndexOrThrow16;
                    int i11 = columnIndexOrThrow4;
                    notesContentEntity.setSize(cursorQuery.getLong(i10));
                    arrayList.add(notesContentEntity);
                    columnIndexOrThrow4 = i11;
                    columnIndexOrThrow3 = i9;
                    columnIndexOrThrow16 = i10;
                    columnIndexOrThrow2 = i8;
                    columnIndexOrThrow15 = i7;
                    columnIndexOrThrow13 = i6;
                    i4 = i5;
                    columnIndexOrThrow = i2;
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesContentDao
    public LiveData<List<ContentFileData>> getLiveContentFileDataByMimeType(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT content.UUID, content.sdocUUID, sdoc.filePath, content.filePath AS `contentPath`, content.displayName, content.mime_type, content.size, content.createdAt FROM (SELECT * FROM content WHERE mime_type = ?) AS content JOIN sdoc ON content.sdocUUID = sdoc.UUID WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND mdeSpaceId = ''", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"content", "sdoc"}, false, new Callable<List<ContentFileData>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesContentDao_Impl.7
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<ContentFileData> call() {
                Cursor cursorQuery = DBUtil.query(NotesContentDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        ContentFileData contentFileData = new ContentFileData();
                        if (cursorQuery.isNull(0)) {
                            contentFileData.uuid = null;
                        } else {
                            contentFileData.uuid = cursorQuery.getString(0);
                        }
                        if (cursorQuery.isNull(1)) {
                            contentFileData.sdocUuid = null;
                        } else {
                            contentFileData.sdocUuid = cursorQuery.getString(1);
                        }
                        if (cursorQuery.isNull(2)) {
                            contentFileData.docPath = null;
                        } else {
                            contentFileData.docPath = cursorQuery.getString(2);
                        }
                        if (cursorQuery.isNull(3)) {
                            contentFileData.contentFilePath = null;
                        } else {
                            contentFileData.contentFilePath = cursorQuery.getString(3);
                        }
                        if (cursorQuery.isNull(4)) {
                            contentFileData.displayName = null;
                        } else {
                            contentFileData.displayName = cursorQuery.getString(4);
                        }
                        if (cursorQuery.isNull(5)) {
                            contentFileData.mimeType = null;
                        } else {
                            contentFileData.mimeType = cursorQuery.getString(5);
                        }
                        contentFileData.size = cursorQuery.getLong(6);
                        contentFileData.createdAt = cursorQuery.getLong(7);
                        arrayList.add(contentFileData);
                    }
                    cursorQuery.close();
                    return arrayList;
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesContentDao
    public List<ContentFileData> internalRawQuery(SupportSQLiteQuery supportSQLiteQuery) {
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, supportSQLiteQuery, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "UUID");
            int columnIndex2 = CursorUtil.getColumnIndex(cursorQuery, "sdocUUID");
            int columnIndex3 = CursorUtil.getColumnIndex(cursorQuery, "filePath");
            int columnIndex4 = CursorUtil.getColumnIndex(cursorQuery, "contentPath");
            int columnIndex5 = CursorUtil.getColumnIndex(cursorQuery, "displayName");
            int columnIndex6 = CursorUtil.getColumnIndex(cursorQuery, "mime_type");
            int columnIndex7 = CursorUtil.getColumnIndex(cursorQuery, "size");
            int columnIndex8 = CursorUtil.getColumnIndex(cursorQuery, "createdAt");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                ContentFileData contentFileData = new ContentFileData();
                if (columnIndex != -1) {
                    if (cursorQuery.isNull(columnIndex)) {
                        contentFileData.uuid = null;
                    } else {
                        contentFileData.uuid = cursorQuery.getString(columnIndex);
                    }
                }
                if (columnIndex2 != -1) {
                    if (cursorQuery.isNull(columnIndex2)) {
                        contentFileData.sdocUuid = null;
                    } else {
                        contentFileData.sdocUuid = cursorQuery.getString(columnIndex2);
                    }
                }
                if (columnIndex3 != -1) {
                    if (cursorQuery.isNull(columnIndex3)) {
                        contentFileData.docPath = null;
                    } else {
                        contentFileData.docPath = cursorQuery.getString(columnIndex3);
                    }
                }
                if (columnIndex4 != -1) {
                    if (cursorQuery.isNull(columnIndex4)) {
                        contentFileData.contentFilePath = null;
                    } else {
                        contentFileData.contentFilePath = cursorQuery.getString(columnIndex4);
                    }
                }
                if (columnIndex5 != -1) {
                    if (cursorQuery.isNull(columnIndex5)) {
                        contentFileData.displayName = null;
                    } else {
                        contentFileData.displayName = cursorQuery.getString(columnIndex5);
                    }
                }
                if (columnIndex6 != -1) {
                    if (cursorQuery.isNull(columnIndex6)) {
                        contentFileData.mimeType = null;
                    } else {
                        contentFileData.mimeType = cursorQuery.getString(columnIndex6);
                    }
                }
                if (columnIndex7 != -1) {
                    contentFileData.size = cursorQuery.getLong(columnIndex7);
                }
                if (columnIndex8 != -1) {
                    contentFileData.createdAt = cursorQuery.getLong(columnIndex8);
                }
                arrayList.add(contentFileData);
            }
            cursorQuery.close();
            return arrayList;
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesContentDao
    public void updateIsDeleted(String str, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateIsDeleted.acquire();
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
            this.__preparedStmtOfUpdateIsDeleted.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesContentDao
    public void updateIsDirtyAndIsDeleted(String str, int i, int i2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateIsDirtyAndIsDeleted.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i);
        supportSQLiteStatementAcquire.bindLong(2, i2);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, str);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateIsDirtyAndIsDeleted.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(NotesContentEntity notesContentEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfNotesContentEntity.handle(notesContentEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(NotesContentEntity notesContentEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfNotesContentEntity.insert(notesContentEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(NotesContentEntity notesContentEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfNotesContentEntity.handle(notesContentEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(NotesContentEntity notesContentEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(notesContentEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesContentDao
    public void deleteBySDocUuid(String str, Collection<String> collection) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM content WHERE sdocUUID=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" AND mime_type NOT IN (");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, sbNewStringBuilder, ")"));
        if (str == null) {
            supportSQLiteStatementCompileStatement.bindNull(1);
        } else {
            supportSQLiteStatementCompileStatement.bindString(1, str);
        }
        int i = 2;
        for (String str2 : collection) {
            if (str2 == null) {
                supportSQLiteStatementCompileStatement.bindNull(i);
            } else {
                supportSQLiteStatementCompileStatement.bindString(i, str2);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends NotesContentEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesContentDao
    public int update(Collection<NotesContentEntity> collection) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__updateAdapterOfNotesContentEntity.handleMultiple(collection);
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }
}
