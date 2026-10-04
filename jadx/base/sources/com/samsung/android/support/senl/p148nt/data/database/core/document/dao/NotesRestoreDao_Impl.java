package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.NotesDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesRestoreDao_Impl extends NotesRestoreDao {
    private final RoomDatabase __db;
    private final SharedSQLiteStatement __preparedStmtOfInsertToExternalSharedDocuments;
    private final SharedSQLiteStatement __preparedStmtOfResetUncategorizedFolderParentUuid;
    private final SharedSQLiteStatement __preparedStmtOfRestoreDisplayContent;
    private final EntityDeletionOrUpdateAdapter<NotesDocumentEntity> __updateAdapterOfNotesDocumentEntity;

    public NotesRestoreDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__updateAdapterOfNotesDocumentEntity = new EntityDeletionOrUpdateAdapter<NotesDocumentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesRestoreDao_Impl.1
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `sdoc` SET `accountType` = ?,`accountName` = ?,`strippedContent` = ?,`serverTimestamp` = ?,`categoryserverTimestamp` = ?,`categoryisDirty` = ?,`noteName` = ?,`msSyncAccountId` = ?,`msSyncDocumentUuid` = ?,`msLastSyncTime` = ?,`mathMode` = ?,`_id` = ?,`UUID` = ?,`isDeleted` = ?,`isDirty` = ?,`title` = ?,`recommendedTitle` = ?,`content` = ?,`displayContent` = ?,`createdAt` = ?,`lastModifiedAt` = ?,`vrUUID` = ?,`contentUUID` = ?,`firstContentType` = ?,`secondContentType` = ?,`strokeUUID` = ?,`strokeRatio` = ?,`categoryUUID` = ?,`filePath` = ?,`isFavorite` = ?,`isLock` = ?,`isSaving` = ?,`reminderTriggerTime` = ?,`reminderRequestCode` = ?,`recycle_bin_time_moved` = ?,`contentSecureVersion` = ?,`size` = ?,`displayTitle` = ?,`saveType` = ?,`firstOpendAt` = ?,`secondOpenedAt` = ?,`lastOpenedAt` = ?,`importedAt` = ?,`recommendedAt` = ?,`lastMappedAt` = ?,`mdeSpaceId` = ?,`mdeItemId` = ?,`mdeExtra` = ?,`mdeGroupId` = ?,`mdeOwnerId` = ?,`firstHandwritingHeight` = ?,`deleteRecommended` = ?,`absolutePath` = ?,`backgroundColor` = ?,`backgroundColorInverted` = ?,`lockAccountGuid` = ?,`corrupted` = ?,`pageMode` = ? WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesDocumentEntity notesDocumentEntity) {
                if (notesDocumentEntity.getAccountType() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, notesDocumentEntity.getAccountType());
                }
                if (notesDocumentEntity.getAccountName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesDocumentEntity.getAccountName());
                }
                byte[] bArrStringToByteArray = NotesDataConverter.stringToByteArray(notesDocumentEntity.getStrippedContent());
                if (bArrStringToByteArray == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindBlob(3, bArrStringToByteArray);
                }
                if (notesDocumentEntity.getServerTimestamp() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindLong(4, notesDocumentEntity.getServerTimestamp().longValue());
                }
                if (notesDocumentEntity.getCategoryServerTimeStamp() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, notesDocumentEntity.getCategoryServerTimeStamp().longValue());
                }
                supportSQLiteStatement.bindLong(6, notesDocumentEntity.getCategoryIsDirty());
                if (notesDocumentEntity.getNoteName() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, notesDocumentEntity.getNoteName());
                }
                if (notesDocumentEntity.getMsSyncAccountId() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, notesDocumentEntity.getMsSyncAccountId());
                }
                if (notesDocumentEntity.getMsSyncDocumentUuid() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, notesDocumentEntity.getMsSyncDocumentUuid());
                }
                supportSQLiteStatement.bindLong(10, notesDocumentEntity.getMsLastSyncTime());
                supportSQLiteStatement.bindLong(11, notesDocumentEntity.getMathMode());
                if (notesDocumentEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindLong(12, notesDocumentEntity.getId().longValue());
                }
                if (notesDocumentEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, notesDocumentEntity.getUuid());
                }
                supportSQLiteStatement.bindLong(14, notesDocumentEntity.getIsDeleted());
                supportSQLiteStatement.bindLong(15, notesDocumentEntity.getIsDirty());
                if (notesDocumentEntity.getTitle() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, notesDocumentEntity.getTitle());
                }
                if (notesDocumentEntity.getRecommendedTitle() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, notesDocumentEntity.getRecommendedTitle());
                }
                byte[] bArrStringToByteArray2 = NotesDataConverter.stringToByteArray(notesDocumentEntity.getContent());
                if (bArrStringToByteArray2 == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindBlob(18, bArrStringToByteArray2);
                }
                if (notesDocumentEntity.getDisplayContent() == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindBlob(19, notesDocumentEntity.getDisplayContent());
                }
                supportSQLiteStatement.bindLong(20, notesDocumentEntity.getCreatedAt());
                supportSQLiteStatement.bindLong(21, notesDocumentEntity.getLastModifiedAt());
                if (notesDocumentEntity.getVrUuid() == null) {
                    supportSQLiteStatement.bindNull(22);
                } else {
                    supportSQLiteStatement.bindString(22, notesDocumentEntity.getVrUuid());
                }
                if (notesDocumentEntity.getContentUuid() == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindString(23, notesDocumentEntity.getContentUuid());
                }
                if (notesDocumentEntity.getFirstContentType() == null) {
                    supportSQLiteStatement.bindNull(24);
                } else {
                    supportSQLiteStatement.bindLong(24, notesDocumentEntity.getFirstContentType().intValue());
                }
                if (notesDocumentEntity.getSecondContentType() == null) {
                    supportSQLiteStatement.bindNull(25);
                } else {
                    supportSQLiteStatement.bindLong(25, notesDocumentEntity.getSecondContentType().intValue());
                }
                if (notesDocumentEntity.getStrokeUuid() == null) {
                    supportSQLiteStatement.bindNull(26);
                } else {
                    supportSQLiteStatement.bindString(26, notesDocumentEntity.getStrokeUuid());
                }
                if (notesDocumentEntity.getStrokeRatio() == null) {
                    supportSQLiteStatement.bindNull(27);
                } else {
                    supportSQLiteStatement.bindDouble(27, notesDocumentEntity.getStrokeRatio().floatValue());
                }
                if (notesDocumentEntity.getCategoryUuid() == null) {
                    supportSQLiteStatement.bindNull(28);
                } else {
                    supportSQLiteStatement.bindString(28, notesDocumentEntity.getCategoryUuid());
                }
                if (notesDocumentEntity.getFilePath() == null) {
                    supportSQLiteStatement.bindNull(29);
                } else {
                    supportSQLiteStatement.bindString(29, notesDocumentEntity.getFilePath());
                }
                supportSQLiteStatement.bindLong(30, notesDocumentEntity.getIsFavorite());
                supportSQLiteStatement.bindLong(31, notesDocumentEntity.getIsLock());
                supportSQLiteStatement.bindLong(32, notesDocumentEntity.getIsSavingByWhichPid());
                supportSQLiteStatement.bindLong(33, notesDocumentEntity.getReminderTriggerTime());
                supportSQLiteStatement.bindLong(34, notesDocumentEntity.getReminderRequestCode());
                supportSQLiteStatement.bindLong(35, notesDocumentEntity.getRecycleBinTimeMoved());
                supportSQLiteStatement.bindLong(36, notesDocumentEntity.getContentSecureVersion());
                supportSQLiteStatement.bindLong(37, notesDocumentEntity.getSize());
                if (notesDocumentEntity.getDisplayTitle() == null) {
                    supportSQLiteStatement.bindNull(38);
                } else {
                    supportSQLiteStatement.bindBlob(38, notesDocumentEntity.getDisplayTitle());
                }
                supportSQLiteStatement.bindLong(39, notesDocumentEntity.getSaveType());
                supportSQLiteStatement.bindLong(40, notesDocumentEntity.getFirstOpendAt());
                supportSQLiteStatement.bindLong(41, notesDocumentEntity.getSecondOpenedAt());
                supportSQLiteStatement.bindLong(42, notesDocumentEntity.getLastOpenedAt());
                supportSQLiteStatement.bindLong(43, notesDocumentEntity.getImportedAt());
                supportSQLiteStatement.bindLong(44, notesDocumentEntity.getRecommendedAt());
                supportSQLiteStatement.bindLong(45, notesDocumentEntity.getLastMappedAt());
                if (notesDocumentEntity.getMdeSpaceId() == null) {
                    supportSQLiteStatement.bindNull(46);
                } else {
                    supportSQLiteStatement.bindString(46, notesDocumentEntity.getMdeSpaceId());
                }
                if (notesDocumentEntity.getMdeItemId() == null) {
                    supportSQLiteStatement.bindNull(47);
                } else {
                    supportSQLiteStatement.bindString(47, notesDocumentEntity.getMdeItemId());
                }
                if (notesDocumentEntity.getMdeExtra() == null) {
                    supportSQLiteStatement.bindNull(48);
                } else {
                    supportSQLiteStatement.bindString(48, notesDocumentEntity.getMdeExtra());
                }
                if (notesDocumentEntity.getMdeGroupId() == null) {
                    supportSQLiteStatement.bindNull(49);
                } else {
                    supportSQLiteStatement.bindString(49, notesDocumentEntity.getMdeGroupId());
                }
                if (notesDocumentEntity.getMdeOwnerId() == null) {
                    supportSQLiteStatement.bindNull(50);
                } else {
                    supportSQLiteStatement.bindString(50, notesDocumentEntity.getMdeOwnerId());
                }
                supportSQLiteStatement.bindLong(51, notesDocumentEntity.getFirstHandwritingHeight());
                supportSQLiteStatement.bindLong(52, notesDocumentEntity.getDeleteRecommended());
                if (notesDocumentEntity.getAbsolutePath() == null) {
                    supportSQLiteStatement.bindNull(53);
                } else {
                    supportSQLiteStatement.bindString(53, notesDocumentEntity.getAbsolutePath());
                }
                supportSQLiteStatement.bindLong(54, notesDocumentEntity.getBackgroundColor());
                supportSQLiteStatement.bindLong(55, notesDocumentEntity.getBackgroundColorInverted());
                if (notesDocumentEntity.getLockAccountGuid() == null) {
                    supportSQLiteStatement.bindNull(56);
                } else {
                    supportSQLiteStatement.bindString(56, notesDocumentEntity.getLockAccountGuid());
                }
                supportSQLiteStatement.bindLong(57, notesDocumentEntity.getCorrupted());
                supportSQLiteStatement.bindLong(58, notesDocumentEntity.getPageMode());
                if (notesDocumentEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(59);
                } else {
                    supportSQLiteStatement.bindLong(59, notesDocumentEntity.getId().longValue());
                }
            }
        };
        this.__preparedStmtOfResetUncategorizedFolderParentUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesRestoreDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT category_tree SET parentUUID = NULL WHERE UUID='uncategorized:///'";
            }
        };
        this.__preparedStmtOfRestoreDisplayContent = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesRestoreDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sdoc SET displayContent=? WHERE LENGTH(displayContent) > ?";
            }
        };
        this.__preparedStmtOfInsertToExternalSharedDocuments = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesRestoreDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO external_shared_documents (UUID, timestamp) SELECT UUID, lastModifiedAt FROM sdoc WHERE isDeleted != 1 AND mdeSpaceId = ''";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRestoreDao
    public void deleteDummyNewFoldersInCategoryTree(List<String> list) {
        StringBuilder sbM12324i = AbstractC11014a.m12324i(this.__db, "DELETE FROM category_tree WHERE UUID IN (");
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRestoreDao
    public void deleteDummyNewFoldersInCategoryTreeClosure(List<String> list) {
        StringBuilder sbM12324i = AbstractC11014a.m12324i(this.__db, "DELETE FROM category_tree_closure WHERE descendant IN (");
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRestoreDao
    public List<NotesDocumentEntity> getCorruptNotes() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `sdoc`.`accountType`, `sdoc`.`accountName`, `sdoc`.`strippedContent`, `sdoc`.`serverTimestamp`, `sdoc`.`categoryserverTimestamp`, `sdoc`.`categoryisDirty`, `sdoc`.`noteName`, `sdoc`.`msSyncAccountId`, `sdoc`.`msSyncDocumentUuid`, `sdoc`.`msLastSyncTime`, `sdoc`.`mathMode`, `sdoc`.`_id`, `sdoc`.`UUID`, `sdoc`.`isDeleted`, `sdoc`.`isDirty`, `sdoc`.`title`, `sdoc`.`recommendedTitle`, `sdoc`.`content`, `sdoc`.`displayContent`, `sdoc`.`createdAt`, `sdoc`.`lastModifiedAt`, `sdoc`.`vrUUID`, `sdoc`.`contentUUID`, `sdoc`.`firstContentType`, `sdoc`.`secondContentType`, `sdoc`.`strokeUUID`, `sdoc`.`strokeRatio`, `sdoc`.`categoryUUID`, `sdoc`.`filePath`, `sdoc`.`isFavorite`, `sdoc`.`isLock`, `sdoc`.`isSaving`, `sdoc`.`reminderTriggerTime`, `sdoc`.`reminderRequestCode`, `sdoc`.`recycle_bin_time_moved`, `sdoc`.`contentSecureVersion`, `sdoc`.`size`, `sdoc`.`displayTitle`, `sdoc`.`saveType`, `sdoc`.`firstOpendAt`, `sdoc`.`secondOpenedAt`, `sdoc`.`lastOpenedAt`, `sdoc`.`importedAt`, `sdoc`.`recommendedAt`, `sdoc`.`lastMappedAt`, `sdoc`.`mdeSpaceId`, `sdoc`.`mdeItemId`, `sdoc`.`mdeExtra`, `sdoc`.`mdeGroupId`, `sdoc`.`mdeOwnerId`, `sdoc`.`firstHandwritingHeight`, `sdoc`.`deleteRecommended`, `sdoc`.`absolutePath`, `sdoc`.`backgroundColor`, `sdoc`.`backgroundColorInverted`, `sdoc`.`lockAccountGuid`, `sdoc`.`corrupted`, `sdoc`.`pageMode` FROM sdoc WHERE sdoc.isDeleted = 0 AND ( isFavorite NOT IN (0, 1) OR  isLock > 5 OR isLock < -2 ) ", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesDocumentEntity notesDocumentEntity = new NotesDocumentEntity();
                notesDocumentEntity.setAccountType(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                notesDocumentEntity.setAccountName(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                notesDocumentEntity.setStrippedContent(NotesDataConverter.byteToString(cursorQuery.isNull(2) ? null : cursorQuery.getBlob(2)));
                notesDocumentEntity.setServerTimestamp(cursorQuery.isNull(3) ? null : Long.valueOf(cursorQuery.getLong(3)));
                notesDocumentEntity.setCategoryServerTimeStamp(cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4)));
                notesDocumentEntity.setCategoryIsDirty(cursorQuery.getInt(5));
                notesDocumentEntity.setNoteName(cursorQuery.isNull(6) ? null : cursorQuery.getString(6));
                notesDocumentEntity.setMsSyncAccountId(cursorQuery.isNull(7) ? null : cursorQuery.getString(7));
                notesDocumentEntity.setMsSyncDocumentUuid(cursorQuery.isNull(8) ? null : cursorQuery.getString(8));
                notesDocumentEntity.setMsLastSyncTime(cursorQuery.getLong(9));
                notesDocumentEntity.setMathMode(cursorQuery.getInt(10));
                notesDocumentEntity.setId(cursorQuery.isNull(11) ? null : Long.valueOf(cursorQuery.getLong(11)));
                notesDocumentEntity.setUuid(cursorQuery.isNull(12) ? null : cursorQuery.getString(12));
                notesDocumentEntity.setIsDeleted(cursorQuery.getInt(13));
                notesDocumentEntity.setIsDirty(cursorQuery.getInt(14));
                notesDocumentEntity.setTitle(cursorQuery.isNull(15) ? null : cursorQuery.getString(15));
                notesDocumentEntity.setRecommendedTitle(cursorQuery.isNull(16) ? null : cursorQuery.getString(16));
                notesDocumentEntity.setContent(NotesDataConverter.byteToString(cursorQuery.isNull(17) ? null : cursorQuery.getBlob(17)));
                notesDocumentEntity.setDisplayContent(cursorQuery.isNull(18) ? null : cursorQuery.getBlob(18));
                notesDocumentEntity.setCreatedAt(cursorQuery.getLong(19));
                notesDocumentEntity.setLastModifiedAt(cursorQuery.getLong(20));
                notesDocumentEntity.setVrUuid(cursorQuery.isNull(21) ? null : cursorQuery.getString(21));
                notesDocumentEntity.setContentUuid(cursorQuery.isNull(22) ? null : cursorQuery.getString(22));
                notesDocumentEntity.setFirstContentType(cursorQuery.isNull(23) ? null : Integer.valueOf(cursorQuery.getInt(23)));
                notesDocumentEntity.setSecondContentType(cursorQuery.isNull(24) ? null : Integer.valueOf(cursorQuery.getInt(24)));
                notesDocumentEntity.setStrokeUuid(cursorQuery.isNull(25) ? null : cursorQuery.getString(25));
                notesDocumentEntity.setStrokeRatio(cursorQuery.isNull(26) ? null : Float.valueOf(cursorQuery.getFloat(26)));
                notesDocumentEntity.setCategoryUuid(cursorQuery.isNull(27) ? null : cursorQuery.getString(27));
                notesDocumentEntity.setFilePath(cursorQuery.isNull(28) ? null : cursorQuery.getString(28));
                notesDocumentEntity.setIsFavorite(cursorQuery.getInt(29));
                notesDocumentEntity.setIsLock(cursorQuery.getInt(30));
                notesDocumentEntity.setIsSavingByWhichPid(cursorQuery.getInt(31));
                notesDocumentEntity.setReminderTriggerTime(cursorQuery.getLong(32));
                notesDocumentEntity.setReminderRequestCode(cursorQuery.getInt(33));
                notesDocumentEntity.setRecycleBinTimeMoved(cursorQuery.getLong(34));
                notesDocumentEntity.setContentSecureVersion(cursorQuery.getInt(35));
                notesDocumentEntity.setSize(cursorQuery.getLong(36));
                notesDocumentEntity.setDisplayTitle(cursorQuery.isNull(37) ? null : cursorQuery.getBlob(37));
                notesDocumentEntity.setSaveType(cursorQuery.getInt(38));
                notesDocumentEntity.setFirstOpendAt(cursorQuery.getLong(39));
                notesDocumentEntity.setSecondOpenedAt(cursorQuery.getLong(40));
                notesDocumentEntity.setLastOpenedAt(cursorQuery.getLong(41));
                notesDocumentEntity.setImportedAt(cursorQuery.getLong(42));
                notesDocumentEntity.setRecommendedAt(cursorQuery.getLong(43));
                notesDocumentEntity.setLastMappedAt(cursorQuery.getLong(44));
                notesDocumentEntity.setMdeSpaceId(cursorQuery.isNull(45) ? null : cursorQuery.getString(45));
                notesDocumentEntity.setMdeItemId(cursorQuery.isNull(46) ? null : cursorQuery.getString(46));
                notesDocumentEntity.setMdeExtra(cursorQuery.isNull(47) ? null : cursorQuery.getString(47));
                notesDocumentEntity.setMdeGroupId(cursorQuery.isNull(48) ? null : cursorQuery.getString(48));
                notesDocumentEntity.setMdeOwnerId(cursorQuery.isNull(49) ? null : cursorQuery.getString(49));
                notesDocumentEntity.setFirstHandwritingHeight(cursorQuery.getInt(50));
                notesDocumentEntity.setDeleteRecommended(cursorQuery.getInt(51));
                notesDocumentEntity.setAbsolutePath(cursorQuery.isNull(52) ? null : cursorQuery.getString(52));
                notesDocumentEntity.setBackgroundColor(cursorQuery.getInt(53));
                notesDocumentEntity.setBackgroundColorInverted(cursorQuery.getInt(54));
                notesDocumentEntity.setLockAccountGuid(cursorQuery.isNull(55) ? null : cursorQuery.getString(55));
                notesDocumentEntity.setCorrupted(cursorQuery.getInt(56));
                notesDocumentEntity.setPageMode(cursorQuery.getInt(57));
                arrayList.add(notesDocumentEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRestoreDao
    public List<String> getDummyFolders() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM category_tree WHERE parentUUID = 'uncategorized:///' AND UUID NOT IN (SELECT ancestor FROM category_tree_closure WHERE depth > 0) AND UUID NOT IN (SELECT categoryUUID FROM sdoc) AND category_tree.isDeleted = 0", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRestoreDao
    public List<NotesDocumentEntity> getSdocXInOldFolder() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `sdoc`.`accountType` AS `accountType`, `sdoc`.`accountName` AS `accountName`, `sdoc`.`strippedContent` AS `strippedContent`, `sdoc`.`serverTimestamp` AS `serverTimestamp`, `sdoc`.`categoryserverTimestamp` AS `categoryserverTimestamp`, `sdoc`.`categoryisDirty` AS `categoryisDirty`, `sdoc`.`noteName` AS `noteName`, `sdoc`.`msSyncAccountId` AS `msSyncAccountId`, `sdoc`.`msSyncDocumentUuid` AS `msSyncDocumentUuid`, `sdoc`.`msLastSyncTime` AS `msLastSyncTime`, `sdoc`.`mathMode` AS `mathMode`, `sdoc`.`_id` AS `_id`, `sdoc`.`UUID` AS `UUID`, `sdoc`.`isDeleted` AS `isDeleted`, `sdoc`.`isDirty` AS `isDirty`, `sdoc`.`title` AS `title`, `sdoc`.`recommendedTitle` AS `recommendedTitle`, `sdoc`.`content` AS `content`, `sdoc`.`displayContent` AS `displayContent`, `sdoc`.`createdAt` AS `createdAt`, `sdoc`.`lastModifiedAt` AS `lastModifiedAt`, `sdoc`.`vrUUID` AS `vrUUID`, `sdoc`.`contentUUID` AS `contentUUID`, `sdoc`.`firstContentType` AS `firstContentType`, `sdoc`.`secondContentType` AS `secondContentType`, `sdoc`.`strokeUUID` AS `strokeUUID`, `sdoc`.`strokeRatio` AS `strokeRatio`, `sdoc`.`categoryUUID` AS `categoryUUID`, `sdoc`.`filePath` AS `filePath`, `sdoc`.`isFavorite` AS `isFavorite`, `sdoc`.`isLock` AS `isLock`, `sdoc`.`isSaving` AS `isSaving`, `sdoc`.`reminderTriggerTime` AS `reminderTriggerTime`, `sdoc`.`reminderRequestCode` AS `reminderRequestCode`, `sdoc`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `sdoc`.`contentSecureVersion` AS `contentSecureVersion`, `sdoc`.`size` AS `size`, `sdoc`.`displayTitle` AS `displayTitle`, `sdoc`.`saveType` AS `saveType`, `sdoc`.`firstOpendAt` AS `firstOpendAt`, `sdoc`.`secondOpenedAt` AS `secondOpenedAt`, `sdoc`.`lastOpenedAt` AS `lastOpenedAt`, `sdoc`.`importedAt` AS `importedAt`, `sdoc`.`recommendedAt` AS `recommendedAt`, `sdoc`.`lastMappedAt` AS `lastMappedAt`, `sdoc`.`mdeSpaceId` AS `mdeSpaceId`, `sdoc`.`mdeItemId` AS `mdeItemId`, `sdoc`.`mdeExtra` AS `mdeExtra`, `sdoc`.`mdeGroupId` AS `mdeGroupId`, `sdoc`.`mdeOwnerId` AS `mdeOwnerId`, `sdoc`.`firstHandwritingHeight` AS `firstHandwritingHeight`, `sdoc`.`deleteRecommended` AS `deleteRecommended`, `sdoc`.`absolutePath` AS `absolutePath`, `sdoc`.`backgroundColor` AS `backgroundColor`, `sdoc`.`backgroundColorInverted` AS `backgroundColorInverted`, `sdoc`.`lockAccountGuid` AS `lockAccountGuid`, `sdoc`.`corrupted` AS `corrupted`, `sdoc`.`pageMode` AS `pageMode` FROM sdoc WHERE sdoc.categoryUUID IN (SELECT category_tree.UUID FROM category_tree WHERE category_tree.parentUUID = 'old:///') AND sdoc.filePath LIKE '%.sdocx'", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesDocumentEntity notesDocumentEntity = new NotesDocumentEntity();
                notesDocumentEntity.setAccountType(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                notesDocumentEntity.setAccountName(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                notesDocumentEntity.setStrippedContent(NotesDataConverter.byteToString(cursorQuery.isNull(2) ? null : cursorQuery.getBlob(2)));
                notesDocumentEntity.setServerTimestamp(cursorQuery.isNull(3) ? null : Long.valueOf(cursorQuery.getLong(3)));
                notesDocumentEntity.setCategoryServerTimeStamp(cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4)));
                notesDocumentEntity.setCategoryIsDirty(cursorQuery.getInt(5));
                notesDocumentEntity.setNoteName(cursorQuery.isNull(6) ? null : cursorQuery.getString(6));
                notesDocumentEntity.setMsSyncAccountId(cursorQuery.isNull(7) ? null : cursorQuery.getString(7));
                notesDocumentEntity.setMsSyncDocumentUuid(cursorQuery.isNull(8) ? null : cursorQuery.getString(8));
                notesDocumentEntity.setMsLastSyncTime(cursorQuery.getLong(9));
                notesDocumentEntity.setMathMode(cursorQuery.getInt(10));
                notesDocumentEntity.setId(cursorQuery.isNull(11) ? null : Long.valueOf(cursorQuery.getLong(11)));
                notesDocumentEntity.setUuid(cursorQuery.isNull(12) ? null : cursorQuery.getString(12));
                notesDocumentEntity.setIsDeleted(cursorQuery.getInt(13));
                notesDocumentEntity.setIsDirty(cursorQuery.getInt(14));
                notesDocumentEntity.setTitle(cursorQuery.isNull(15) ? null : cursorQuery.getString(15));
                notesDocumentEntity.setRecommendedTitle(cursorQuery.isNull(16) ? null : cursorQuery.getString(16));
                notesDocumentEntity.setContent(NotesDataConverter.byteToString(cursorQuery.isNull(17) ? null : cursorQuery.getBlob(17)));
                notesDocumentEntity.setDisplayContent(cursorQuery.isNull(18) ? null : cursorQuery.getBlob(18));
                notesDocumentEntity.setCreatedAt(cursorQuery.getLong(19));
                notesDocumentEntity.setLastModifiedAt(cursorQuery.getLong(20));
                notesDocumentEntity.setVrUuid(cursorQuery.isNull(21) ? null : cursorQuery.getString(21));
                notesDocumentEntity.setContentUuid(cursorQuery.isNull(22) ? null : cursorQuery.getString(22));
                notesDocumentEntity.setFirstContentType(cursorQuery.isNull(23) ? null : Integer.valueOf(cursorQuery.getInt(23)));
                notesDocumentEntity.setSecondContentType(cursorQuery.isNull(24) ? null : Integer.valueOf(cursorQuery.getInt(24)));
                notesDocumentEntity.setStrokeUuid(cursorQuery.isNull(25) ? null : cursorQuery.getString(25));
                notesDocumentEntity.setStrokeRatio(cursorQuery.isNull(26) ? null : Float.valueOf(cursorQuery.getFloat(26)));
                notesDocumentEntity.setCategoryUuid(cursorQuery.isNull(27) ? null : cursorQuery.getString(27));
                notesDocumentEntity.setFilePath(cursorQuery.isNull(28) ? null : cursorQuery.getString(28));
                notesDocumentEntity.setIsFavorite(cursorQuery.getInt(29));
                notesDocumentEntity.setIsLock(cursorQuery.getInt(30));
                notesDocumentEntity.setIsSavingByWhichPid(cursorQuery.getInt(31));
                notesDocumentEntity.setReminderTriggerTime(cursorQuery.getLong(32));
                notesDocumentEntity.setReminderRequestCode(cursorQuery.getInt(33));
                notesDocumentEntity.setRecycleBinTimeMoved(cursorQuery.getLong(34));
                notesDocumentEntity.setContentSecureVersion(cursorQuery.getInt(35));
                notesDocumentEntity.setSize(cursorQuery.getLong(36));
                notesDocumentEntity.setDisplayTitle(cursorQuery.isNull(37) ? null : cursorQuery.getBlob(37));
                notesDocumentEntity.setSaveType(cursorQuery.getInt(38));
                notesDocumentEntity.setFirstOpendAt(cursorQuery.getLong(39));
                notesDocumentEntity.setSecondOpenedAt(cursorQuery.getLong(40));
                notesDocumentEntity.setLastOpenedAt(cursorQuery.getLong(41));
                notesDocumentEntity.setImportedAt(cursorQuery.getLong(42));
                notesDocumentEntity.setRecommendedAt(cursorQuery.getLong(43));
                notesDocumentEntity.setLastMappedAt(cursorQuery.getLong(44));
                notesDocumentEntity.setMdeSpaceId(cursorQuery.isNull(45) ? null : cursorQuery.getString(45));
                notesDocumentEntity.setMdeItemId(cursorQuery.isNull(46) ? null : cursorQuery.getString(46));
                notesDocumentEntity.setMdeExtra(cursorQuery.isNull(47) ? null : cursorQuery.getString(47));
                notesDocumentEntity.setMdeGroupId(cursorQuery.isNull(48) ? null : cursorQuery.getString(48));
                notesDocumentEntity.setMdeOwnerId(cursorQuery.isNull(49) ? null : cursorQuery.getString(49));
                notesDocumentEntity.setFirstHandwritingHeight(cursorQuery.getInt(50));
                notesDocumentEntity.setDeleteRecommended(cursorQuery.getInt(51));
                notesDocumentEntity.setAbsolutePath(cursorQuery.isNull(52) ? null : cursorQuery.getString(52));
                notesDocumentEntity.setBackgroundColor(cursorQuery.getInt(53));
                notesDocumentEntity.setBackgroundColorInverted(cursorQuery.getInt(54));
                notesDocumentEntity.setLockAccountGuid(cursorQuery.isNull(55) ? null : cursorQuery.getString(55));
                notesDocumentEntity.setCorrupted(cursorQuery.getInt(56));
                notesDocumentEntity.setPageMode(cursorQuery.getInt(57));
                arrayList.add(notesDocumentEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRestoreDao
    public String getUncategorizedFolderParentUuid() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT parentUUID FROM category_tree WHERE UUID='uncategorized:///'", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRestoreDao
    public void insertToExternalSharedDocuments() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfInsertToExternalSharedDocuments.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeInsert();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfInsertToExternalSharedDocuments.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRestoreDao
    public void repairUncategorizedFolder() {
        this.__db.beginTransaction();
        try {
            super.repairUncategorizedFolder();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRestoreDao
    public void resetUncategorizedFolderParentUuid() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfResetUncategorizedFolderParentUuid.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetUncategorizedFolderParentUuid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRestoreDao
    public void restoreDisplayContent(byte[] bArr, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfRestoreDisplayContent.acquire();
        if (bArr == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindBlob(1, bArr);
        }
        supportSQLiteStatementAcquire.bindLong(2, i);
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfRestoreDisplayContent.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRestoreDao
    public int update(NotesDocumentEntity notesDocumentEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfNotesDocumentEntity.handle(notesDocumentEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRestoreDao
    public int update(List<NotesDocumentEntity> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__updateAdapterOfNotesDocumentEntity.handleMultiple(list);
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }
}
