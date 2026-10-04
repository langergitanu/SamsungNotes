package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.content.Context;
import android.database.Cursor;
import android.util.Pair;
import androidx.glance.AbstractC2821a;
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
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentData;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.NotesDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
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
public final class NotesDocumentDao_Impl extends NotesDocumentDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<NotesDocumentEntity> __insertionAdapterOfNotesDocumentEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByCategoryUuid;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByUuidDb;
    private final SharedSQLiteStatement __preparedStmtOfMoveToRecycleBinByCategory;
    private final SharedSQLiteStatement __preparedStmtOfRestoreByCategory;
    private final SharedSQLiteStatement __preparedStmtOfSetDisplayContent;
    private final SharedSQLiteStatement __preparedStmtOfUpdateAccountGuidByUuid;
    private final SharedSQLiteStatement __preparedStmtOfUpdateCategoryByCategoryUuid;
    private final SharedSQLiteStatement __preparedStmtOfUpdateCorrupted;
    private final SharedSQLiteStatement __preparedStmtOfUpdateFavorite;
    private final SharedSQLiteStatement __preparedStmtOfUpdateLastMappedAt;
    private final SharedSQLiteStatement __preparedStmtOfUpdateOpenedTime;
    private final SharedSQLiteStatement __preparedStmtOfUpdateRecommendedTitle;
    private final SharedSQLiteStatement __preparedStmtOfUpdateRecycleBinTimeMoved;
    private final SharedSQLiteStatement __preparedStmtOfUpdateSaving;
    private final SharedSQLiteStatement __preparedStmtOfUpdateStrippedContents;
    private final SharedSQLiteStatement __preparedStmtOfUpdateTitle;
    private final EntityDeletionOrUpdateAdapter<NotesDocumentEntity> __updateAdapterOfNotesDocumentEntity;

    public NotesDocumentDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNotesDocumentEntity = new EntityInsertionAdapter<NotesDocumentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `sdoc` (`accountType`,`accountName`,`strippedContent`,`serverTimestamp`,`categoryserverTimestamp`,`categoryisDirty`,`noteName`,`msSyncAccountId`,`msSyncDocumentUuid`,`msLastSyncTime`,`mathMode`,`_id`,`UUID`,`isDeleted`,`isDirty`,`title`,`recommendedTitle`,`content`,`displayContent`,`createdAt`,`lastModifiedAt`,`vrUUID`,`contentUUID`,`firstContentType`,`secondContentType`,`strokeUUID`,`strokeRatio`,`categoryUUID`,`filePath`,`isFavorite`,`isLock`,`isSaving`,`reminderTriggerTime`,`reminderRequestCode`,`recycle_bin_time_moved`,`contentSecureVersion`,`size`,`displayTitle`,`saveType`,`firstOpendAt`,`secondOpenedAt`,`lastOpenedAt`,`importedAt`,`recommendedAt`,`lastMappedAt`,`mdeSpaceId`,`mdeItemId`,`mdeExtra`,`mdeGroupId`,`mdeOwnerId`,`firstHandwritingHeight`,`deleteRecommended`,`absolutePath`,`backgroundColor`,`backgroundColorInverted`,`lockAccountGuid`,`corrupted`,`pageMode`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
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
            }
        };
        this.__updateAdapterOfNotesDocumentEntity = new EntityDeletionOrUpdateAdapter<NotesDocumentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.2
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
        this.__preparedStmtOfDeleteByUuidDb = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM sdoc WHERE UUID = ?";
            }
        };
        this.__preparedStmtOfDeleteByCategoryUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sdoc SET isDeleted=1 , isDirty=1 , categoryisDirty=1 , categoryServerTimestamp=? WHERE categoryUUID=?";
            }
        };
        this.__preparedStmtOfMoveToRecycleBinByCategory = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sdoc SET isDeleted=2 , recycle_bin_time_moved= ? , absolutePath=? , categoryisDirty=1 , categoryServerTimestamp=? WHERE categoryUUID=?";
            }
        };
        this.__preparedStmtOfRestoreByCategory = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sdoc SET isDeleted=0 , isDirty=1 , categoryserverTimestamp=?   , categoryisDirty=1 WHERE categoryUUID=? AND isDeleted=2";
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM sdoc";
            }
        };
        this.__preparedStmtOfUpdateTitle = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sdoc SET title=? , displayTitle=? WHERE UUID=?";
            }
        };
        this.__preparedStmtOfUpdateRecommendedTitle = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sdoc SET recommendedTitle=? WHERE UUID=?";
            }
        };
        this.__preparedStmtOfUpdateFavorite = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.10
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sdoc SET isFavorite=? , isDirty=1 , serverTimestamp=? WHERE UUID=?";
            }
        };
        this.__preparedStmtOfUpdateCategoryByCategoryUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.11
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sdoc SET categoryUUID=? WHERE categoryUUID=?";
            }
        };
        this.__preparedStmtOfUpdateRecycleBinTimeMoved = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.12
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sdoc SET recycle_bin_time_moved=? WHERE UUID=?";
            }
        };
        this.__preparedStmtOfUpdateOpenedTime = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.13
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sdoc SET firstOpendAt=? , secondOpenedAt=? , lastOpenedAt=? WHERE UUID=?";
            }
        };
        this.__preparedStmtOfUpdateLastMappedAt = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.14
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sdoc SET lastMappedAt=? WHERE UUID=?";
            }
        };
        this.__preparedStmtOfUpdateSaving = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.15
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sdoc SET isSaving=?, size=? WHERE UUID=?";
            }
        };
        this.__preparedStmtOfUpdateAccountGuidByUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.16
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sdoc SET lockAccountGuid=? WHERE UUID=?";
            }
        };
        this.__preparedStmtOfUpdateCorrupted = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.17
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sdoc SET corrupted=? WHERE UUID=?";
            }
        };
        this.__preparedStmtOfUpdateStrippedContents = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.18
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO text_search (sdocUUID, strippedContent, filePath) VALUES  (?, ?, ?)";
            }
        };
        this.__preparedStmtOfSetDisplayContent = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.19
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sdoc SET displayContent =?  WHERE UUID=?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public int deleteByCategoryUuid(NotesMappedDocumentDao notesMappedDocumentDao, Collection<String> collection, long j) {
        this.__db.beginTransaction();
        try {
            int iDeleteByCategoryUuid = super.deleteByCategoryUuid(notesMappedDocumentDao, collection, j);
            this.__db.setTransactionSuccessful();
            return iDeleteByCategoryUuid;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public int deleteByUuid(String str) {
        this.__db.beginTransaction();
        try {
            int iDeleteByUuid = super.deleteByUuid(str);
            this.__db.setTransactionSuccessful();
            return iDeleteByUuid;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public int deleteByUuidDb(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteByUuidDb.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteByUuidDb.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void deleteByUuidListWithTimestampIncrease(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            super.deleteByUuidListWithTimestampIncrease(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public int deleteInChunk(Collection<String> collection, long j) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("UPDATE OR ABORT sdoc SET isDeleted=1 , mdeSpaceId='' , mdeItemId='' , isDirty=1 , categoryisDirty=1 , categoryserverTimestamp= ");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" WHERE UUID IN (");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, sbNewStringBuilder, ")"));
        supportSQLiteStatementCompileStatement.bindLong(1, j);
        int i = 2;
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
            int iExecuteUpdateDelete = supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public int deleteInternalWithServerTimestampIncrease(Collection<String> collection) {
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, AbstractC11014a.m12324i(this.__db, "UPDATE OR ABORT sdoc SET isDeleted=1 , mdeSpaceId='' , mdeItemId='' , isDirty=1 , categoryisDirty=1 , categoryserverTimestamp= categoryserverTimestamp+1 WHERE UUID IN ("), ")"));
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
            int iExecuteUpdateDelete = supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<String> fetchActiveFilePaths(List<String> list) {
        this.__db.beginTransaction();
        try {
            List<String> listFetchActiveFilePaths = super.fetchActiveFilePaths(list);
            this.__db.setTransactionSuccessful();
            return listFetchActiveFilePaths;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<String> fetchActiveFilePathsInChunk(List<String> list) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT sdoc.filePath FROM sdoc WHERE sdoc.filePath IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(") AND sdoc.isDeleted != 1");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size);
        int i = 1;
        for (String str : list) {
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public String getAbsoluteFolderPath(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT GROUP_CONCAT(category_tree.displayName, '/') FROM category_tree WHERE category_tree.UUID IN (SELECT ancestor FROM category_tree_closure WHERE descendant = (SELECT categoryUUID FROM sdoc WHERE UUID = ?) ORDER BY depth DESC) AND category_tree.parentUUID IS NOT NULL", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public String getAbsolutePath(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT absolutePath FROM sdoc WHERE UUID=?", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<NotesDocumentEntity> getAll(int i, boolean z) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i2;
        String string;
        int i4;
        String string2;
        String string3;
        byte[] blob;
        int i5;
        String string4;
        Integer numValueOf;
        Integer numValueOf2;
        String string5;
        Float fValueOf;
        String string6;
        String string7;
        int i6;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `sdoc`.* FROM sdoc LEFT OUTER JOIN mapped_document AS map ON sdoc.UUID = map.UUID WHERE sdoc.isDeleted=? AND sdoc.mdeSpaceId='' AND map.UUID IS NULL ORDER BY CASE WHEN ?=1 THEN lastModifiedAt END DESC, CASE WHEN ?=0 THEN lastModifiedAt END ASC", 3);
        roomSQLiteQueryAcquire.bindLong(1, i);
        roomSQLiteQueryAcquire.bindLong(2, z ? 1L : 0L);
        roomSQLiteQueryAcquire.bindLong(3, z ? 1L : 0L);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accountType");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accountName");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strippedContent");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CATEGORY_SERVER_TIMESTAMP);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CATEGORY_IS_DIRTY);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.NOTENAME);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_SYNC_ACCOUNT_ID);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_SYNC_DOCUMENT_UUID);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_LAST_SYNC_TIME);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MATH_MODE);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDeleted");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.RECOMMENDED_TITLE);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayContent");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.VR_UUID);
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CONTENT_UUID);
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstContentType");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "secondContentType");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strokeUUID");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strokeRatio");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryUUID");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filePath");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFavorite");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLock");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSaving");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reminderTriggerTime");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reminderRequestCode");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recycle_bin_time_moved");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "contentSecureVersion");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayTitle");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "saveType");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstOpendAt");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "secondOpenedAt");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastOpenedAt");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "importedAt");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recommendedAt");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.LAST_MAPPED_AT);
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeSpaceId");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeItemId");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeExtra");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeGroupId");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeOwnerId");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstHandwritingHeight");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deleteRecommended");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.ABSOLUTE_PATH);
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backgroundColor");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.BACKGROUND_COLOR_INVERTED);
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.LOCK_ACCOUNT_GUID);
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CORRUPTED);
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.PAGE_MODE);
                int i7 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    NotesDocumentEntity notesDocumentEntity = new NotesDocumentEntity();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        i2 = columnIndexOrThrow;
                        string = null;
                    } else {
                        i2 = columnIndexOrThrow;
                        string = cursorQuery.getString(columnIndexOrThrow);
                    }
                    notesDocumentEntity.setAccountType(string);
                    notesDocumentEntity.setAccountName(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    notesDocumentEntity.setStrippedContent(NotesDataConverter.byteToString(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getBlob(columnIndexOrThrow3)));
                    notesDocumentEntity.setServerTimestamp(cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4)));
                    notesDocumentEntity.setCategoryServerTimeStamp(cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)));
                    notesDocumentEntity.setCategoryIsDirty(cursorQuery.getInt(columnIndexOrThrow6));
                    notesDocumentEntity.setNoteName(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    notesDocumentEntity.setMsSyncAccountId(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    notesDocumentEntity.setMsSyncDocumentUuid(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    int i8 = columnIndexOrThrow2;
                    int i9 = columnIndexOrThrow3;
                    notesDocumentEntity.setMsLastSyncTime(cursorQuery.getLong(columnIndexOrThrow10));
                    notesDocumentEntity.setMathMode(cursorQuery.getInt(columnIndexOrThrow11));
                    notesDocumentEntity.setId(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                    notesDocumentEntity.setUuid(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i10 = i7;
                    notesDocumentEntity.setIsDeleted(cursorQuery.getInt(i10));
                    int i11 = columnIndexOrThrow15;
                    notesDocumentEntity.setIsDirty(cursorQuery.getInt(i11));
                    int i12 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i12)) {
                        i4 = i12;
                        string2 = null;
                    } else {
                        i4 = i12;
                        string2 = cursorQuery.getString(i12);
                    }
                    notesDocumentEntity.setTitle(string2);
                    int i13 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i13)) {
                        columnIndexOrThrow17 = i13;
                        string3 = null;
                    } else {
                        columnIndexOrThrow17 = i13;
                        string3 = cursorQuery.getString(i13);
                    }
                    notesDocumentEntity.setRecommendedTitle(string3);
                    int i14 = columnIndexOrThrow18;
                    columnIndexOrThrow18 = i14;
                    notesDocumentEntity.setContent(NotesDataConverter.byteToString(cursorQuery.isNull(i14) ? null : cursorQuery.getBlob(i14)));
                    int i15 = columnIndexOrThrow19;
                    if (cursorQuery.isNull(i15)) {
                        columnIndexOrThrow19 = i15;
                        blob = null;
                    } else {
                        columnIndexOrThrow19 = i15;
                        blob = cursorQuery.getBlob(i15);
                    }
                    notesDocumentEntity.setDisplayContent(blob);
                    int i16 = columnIndexOrThrow13;
                    int i17 = columnIndexOrThrow20;
                    notesDocumentEntity.setCreatedAt(cursorQuery.getLong(i17));
                    int i18 = columnIndexOrThrow21;
                    notesDocumentEntity.setLastModifiedAt(cursorQuery.getLong(i18));
                    int i19 = columnIndexOrThrow22;
                    notesDocumentEntity.setVrUuid(cursorQuery.isNull(i19) ? null : cursorQuery.getString(i19));
                    int i20 = columnIndexOrThrow23;
                    if (cursorQuery.isNull(i20)) {
                        i5 = i17;
                        string4 = null;
                    } else {
                        i5 = i17;
                        string4 = cursorQuery.getString(i20);
                    }
                    notesDocumentEntity.setContentUuid(string4);
                    int i21 = columnIndexOrThrow24;
                    if (cursorQuery.isNull(i21)) {
                        columnIndexOrThrow24 = i21;
                        numValueOf = null;
                    } else {
                        columnIndexOrThrow24 = i21;
                        numValueOf = Integer.valueOf(cursorQuery.getInt(i21));
                    }
                    notesDocumentEntity.setFirstContentType(numValueOf);
                    int i22 = columnIndexOrThrow25;
                    if (cursorQuery.isNull(i22)) {
                        columnIndexOrThrow25 = i22;
                        numValueOf2 = null;
                    } else {
                        columnIndexOrThrow25 = i22;
                        numValueOf2 = Integer.valueOf(cursorQuery.getInt(i22));
                    }
                    notesDocumentEntity.setSecondContentType(numValueOf2);
                    int i23 = columnIndexOrThrow26;
                    if (cursorQuery.isNull(i23)) {
                        columnIndexOrThrow26 = i23;
                        string5 = null;
                    } else {
                        columnIndexOrThrow26 = i23;
                        string5 = cursorQuery.getString(i23);
                    }
                    notesDocumentEntity.setStrokeUuid(string5);
                    int i24 = columnIndexOrThrow27;
                    if (cursorQuery.isNull(i24)) {
                        columnIndexOrThrow27 = i24;
                        fValueOf = null;
                    } else {
                        columnIndexOrThrow27 = i24;
                        fValueOf = Float.valueOf(cursorQuery.getFloat(i24));
                    }
                    notesDocumentEntity.setStrokeRatio(fValueOf);
                    int i25 = columnIndexOrThrow28;
                    if (cursorQuery.isNull(i25)) {
                        columnIndexOrThrow28 = i25;
                        string6 = null;
                    } else {
                        columnIndexOrThrow28 = i25;
                        string6 = cursorQuery.getString(i25);
                    }
                    notesDocumentEntity.setCategoryUuid(string6);
                    int i26 = columnIndexOrThrow29;
                    if (cursorQuery.isNull(i26)) {
                        columnIndexOrThrow29 = i26;
                        string7 = null;
                    } else {
                        columnIndexOrThrow29 = i26;
                        string7 = cursorQuery.getString(i26);
                    }
                    notesDocumentEntity.setFilePath(string7);
                    int i27 = columnIndexOrThrow30;
                    notesDocumentEntity.setIsFavorite(cursorQuery.getInt(i27));
                    columnIndexOrThrow30 = i27;
                    int i28 = columnIndexOrThrow31;
                    notesDocumentEntity.setIsLock(cursorQuery.getInt(i28));
                    columnIndexOrThrow31 = i28;
                    int i29 = columnIndexOrThrow32;
                    notesDocumentEntity.setIsSavingByWhichPid(cursorQuery.getInt(i29));
                    int i30 = columnIndexOrThrow33;
                    notesDocumentEntity.setReminderTriggerTime(cursorQuery.getLong(i30));
                    int i31 = columnIndexOrThrow34;
                    notesDocumentEntity.setReminderRequestCode(cursorQuery.getInt(i31));
                    int i32 = columnIndexOrThrow35;
                    notesDocumentEntity.setRecycleBinTimeMoved(cursorQuery.getLong(i32));
                    int i33 = columnIndexOrThrow36;
                    notesDocumentEntity.setContentSecureVersion(cursorQuery.getInt(i33));
                    int i34 = columnIndexOrThrow4;
                    int i35 = columnIndexOrThrow37;
                    notesDocumentEntity.setSize(cursorQuery.getLong(i35));
                    int i36 = columnIndexOrThrow38;
                    notesDocumentEntity.setDisplayTitle(cursorQuery.isNull(i36) ? null : cursorQuery.getBlob(i36));
                    int i37 = columnIndexOrThrow39;
                    notesDocumentEntity.setSaveType(cursorQuery.getInt(i37));
                    int i38 = columnIndexOrThrow40;
                    notesDocumentEntity.setFirstOpendAt(cursorQuery.getLong(i38));
                    int i39 = columnIndexOrThrow41;
                    notesDocumentEntity.setSecondOpenedAt(cursorQuery.getLong(i39));
                    int i40 = columnIndexOrThrow42;
                    notesDocumentEntity.setLastOpenedAt(cursorQuery.getLong(i40));
                    int i41 = columnIndexOrThrow43;
                    notesDocumentEntity.setImportedAt(cursorQuery.getLong(i41));
                    int i42 = columnIndexOrThrow44;
                    notesDocumentEntity.setRecommendedAt(cursorQuery.getLong(i42));
                    int i43 = columnIndexOrThrow45;
                    notesDocumentEntity.setLastMappedAt(cursorQuery.getLong(i43));
                    int i44 = columnIndexOrThrow46;
                    notesDocumentEntity.setMdeSpaceId(cursorQuery.isNull(i44) ? null : cursorQuery.getString(i44));
                    int i45 = columnIndexOrThrow47;
                    if (cursorQuery.isNull(i45)) {
                        i6 = i38;
                        string8 = null;
                    } else {
                        i6 = i38;
                        string8 = cursorQuery.getString(i45);
                    }
                    notesDocumentEntity.setMdeItemId(string8);
                    int i46 = columnIndexOrThrow48;
                    if (cursorQuery.isNull(i46)) {
                        columnIndexOrThrow48 = i46;
                        string9 = null;
                    } else {
                        columnIndexOrThrow48 = i46;
                        string9 = cursorQuery.getString(i46);
                    }
                    notesDocumentEntity.setMdeExtra(string9);
                    int i47 = columnIndexOrThrow49;
                    if (cursorQuery.isNull(i47)) {
                        columnIndexOrThrow49 = i47;
                        string10 = null;
                    } else {
                        columnIndexOrThrow49 = i47;
                        string10 = cursorQuery.getString(i47);
                    }
                    notesDocumentEntity.setMdeGroupId(string10);
                    int i48 = columnIndexOrThrow50;
                    if (cursorQuery.isNull(i48)) {
                        columnIndexOrThrow50 = i48;
                        string11 = null;
                    } else {
                        columnIndexOrThrow50 = i48;
                        string11 = cursorQuery.getString(i48);
                    }
                    notesDocumentEntity.setMdeOwnerId(string11);
                    int i49 = columnIndexOrThrow51;
                    notesDocumentEntity.setFirstHandwritingHeight(cursorQuery.getInt(i49));
                    columnIndexOrThrow51 = i49;
                    int i50 = columnIndexOrThrow52;
                    notesDocumentEntity.setDeleteRecommended(cursorQuery.getInt(i50));
                    int i51 = columnIndexOrThrow53;
                    if (cursorQuery.isNull(i51)) {
                        columnIndexOrThrow53 = i51;
                        string12 = null;
                    } else {
                        columnIndexOrThrow53 = i51;
                        string12 = cursorQuery.getString(i51);
                    }
                    notesDocumentEntity.setAbsolutePath(string12);
                    columnIndexOrThrow52 = i50;
                    int i52 = columnIndexOrThrow54;
                    notesDocumentEntity.setBackgroundColor(cursorQuery.getInt(i52));
                    columnIndexOrThrow54 = i52;
                    int i53 = columnIndexOrThrow55;
                    notesDocumentEntity.setBackgroundColorInverted(cursorQuery.getInt(i53));
                    int i54 = columnIndexOrThrow56;
                    if (cursorQuery.isNull(i54)) {
                        columnIndexOrThrow56 = i54;
                        string13 = null;
                    } else {
                        columnIndexOrThrow56 = i54;
                        string13 = cursorQuery.getString(i54);
                    }
                    notesDocumentEntity.setLockAccountGuid(string13);
                    columnIndexOrThrow55 = i53;
                    int i55 = columnIndexOrThrow57;
                    notesDocumentEntity.setCorrupted(cursorQuery.getInt(i55));
                    columnIndexOrThrow57 = i55;
                    int i56 = columnIndexOrThrow58;
                    notesDocumentEntity.setPageMode(cursorQuery.getInt(i56));
                    arrayList.add(notesDocumentEntity);
                    columnIndexOrThrow2 = i8;
                    columnIndexOrThrow15 = i11;
                    columnIndexOrThrow21 = i18;
                    columnIndexOrThrow22 = i19;
                    columnIndexOrThrow32 = i29;
                    columnIndexOrThrow38 = i36;
                    columnIndexOrThrow41 = i39;
                    columnIndexOrThrow45 = i43;
                    columnIndexOrThrow58 = i56;
                    columnIndexOrThrow13 = i16;
                    columnIndexOrThrow16 = i4;
                    columnIndexOrThrow = i2;
                    i7 = i10;
                    columnIndexOrThrow20 = i5;
                    columnIndexOrThrow23 = i20;
                    columnIndexOrThrow33 = i30;
                    columnIndexOrThrow34 = i31;
                    columnIndexOrThrow35 = i32;
                    columnIndexOrThrow37 = i35;
                    columnIndexOrThrow40 = i6;
                    columnIndexOrThrow47 = i45;
                    columnIndexOrThrow4 = i34;
                    columnIndexOrThrow36 = i33;
                    columnIndexOrThrow39 = i37;
                    columnIndexOrThrow42 = i40;
                    columnIndexOrThrow43 = i41;
                    columnIndexOrThrow44 = i42;
                    columnIndexOrThrow46 = i44;
                    columnIndexOrThrow3 = i9;
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public LiveData<List<NotesDocumentCountEntry>> getAllDocumentCountEntry_LiveData() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT category_tree.UUID, category_tree.parentUUID, category_tree.displayName, category_tree.displayNameColor, category_tree.isDeleted, category_tree.createdAt, category_tree.lastModifiedAt, category_tree.recycle_bin_time_moved, category_tree.orderBy, (SELECT COUNT(*) FROM sdoc AS doc WHERE doc.categoryUUID=category_tree.UUID AND doc.isDeleted IS NOT 1) AS documentCount FROM category_tree ORDER BY category_tree.orderBy ASC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"sdoc", DBSchema.CategoryTree.TABLE_NAME}, false, new Callable<List<NotesDocumentCountEntry>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.21
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<NotesDocumentCountEntry> call() {
                Cursor cursorQuery = DBUtil.query(NotesDocumentDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        NotesDocumentCountEntry notesDocumentCountEntry = new NotesDocumentCountEntry();
                        notesDocumentCountEntry.setCategoryUuid(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                        notesDocumentCountEntry.setParentUuid(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                        notesDocumentCountEntry.setDisplayName(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                        notesDocumentCountEntry.setDisplayNameColor(cursorQuery.getInt(3));
                        notesDocumentCountEntry.setIsDeleted(cursorQuery.getInt(4));
                        notesDocumentCountEntry.setCreatedAt(cursorQuery.getLong(5));
                        notesDocumentCountEntry.setLastModifiedAt(cursorQuery.getLong(6));
                        notesDocumentCountEntry.setRecycleBinTimeMoved(cursorQuery.getLong(7));
                        notesDocumentCountEntry.setReorder(cursorQuery.isNull(8) ? null : Integer.valueOf(cursorQuery.getInt(8)));
                        notesDocumentCountEntry.setDocumentCount(cursorQuery.getInt(9));
                        arrayList.add(notesDocumentCountEntry);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<String> getAllDocumentsInFolderTree(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            List<String> allDocumentsInFolderTree = super.getAllDocumentsInFolderTree(collection);
            this.__db.setTransactionSuccessful();
            return allDocumentsInFolderTree;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<String> getAllDocumentsInFolderTreeInChunk(Collection<String> collection) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), AbstractC11014a.m12317b(sbNewStringBuilder, "SELECT UUID FROM sdoc WHERE categoryUUID IN (SELECT DISTINCT(descendant) FROM category_tree_closure WHERE ancestor IN (", collection, sbNewStringBuilder, "))"));
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<String> getAllPathList() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT filePath FROM sdoc WHERE isDeleted!=1", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<NotesDocumentEntity> getAll_NotConsideringMappingTable(int i, boolean z) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i2;
        String string;
        int i4;
        String string2;
        String string3;
        byte[] blob;
        int i5;
        String string4;
        Integer numValueOf;
        Integer numValueOf2;
        String string5;
        Float fValueOf;
        String string6;
        String string7;
        int i6;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `sdoc`.* FROM sdoc WHERE sdoc.isDeleted=? AND sdoc.mdeSpaceId='' ORDER BY CASE WHEN ?=1 THEN lastModifiedAt END DESC, CASE WHEN ?=0 THEN lastModifiedAt END ASC", 3);
        roomSQLiteQueryAcquire.bindLong(1, i);
        roomSQLiteQueryAcquire.bindLong(2, z ? 1L : 0L);
        roomSQLiteQueryAcquire.bindLong(3, z ? 1L : 0L);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accountType");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accountName");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strippedContent");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CATEGORY_SERVER_TIMESTAMP);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CATEGORY_IS_DIRTY);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.NOTENAME);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_SYNC_ACCOUNT_ID);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_SYNC_DOCUMENT_UUID);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_LAST_SYNC_TIME);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MATH_MODE);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDeleted");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.RECOMMENDED_TITLE);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayContent");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.VR_UUID);
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CONTENT_UUID);
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstContentType");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "secondContentType");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strokeUUID");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strokeRatio");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryUUID");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filePath");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFavorite");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLock");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSaving");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reminderTriggerTime");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reminderRequestCode");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recycle_bin_time_moved");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "contentSecureVersion");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayTitle");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "saveType");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstOpendAt");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "secondOpenedAt");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastOpenedAt");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "importedAt");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recommendedAt");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.LAST_MAPPED_AT);
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeSpaceId");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeItemId");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeExtra");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeGroupId");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeOwnerId");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstHandwritingHeight");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deleteRecommended");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.ABSOLUTE_PATH);
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backgroundColor");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.BACKGROUND_COLOR_INVERTED);
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.LOCK_ACCOUNT_GUID);
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CORRUPTED);
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.PAGE_MODE);
                int i7 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    NotesDocumentEntity notesDocumentEntity = new NotesDocumentEntity();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        i2 = columnIndexOrThrow;
                        string = null;
                    } else {
                        i2 = columnIndexOrThrow;
                        string = cursorQuery.getString(columnIndexOrThrow);
                    }
                    notesDocumentEntity.setAccountType(string);
                    notesDocumentEntity.setAccountName(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    notesDocumentEntity.setStrippedContent(NotesDataConverter.byteToString(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getBlob(columnIndexOrThrow3)));
                    notesDocumentEntity.setServerTimestamp(cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4)));
                    notesDocumentEntity.setCategoryServerTimeStamp(cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)));
                    notesDocumentEntity.setCategoryIsDirty(cursorQuery.getInt(columnIndexOrThrow6));
                    notesDocumentEntity.setNoteName(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    notesDocumentEntity.setMsSyncAccountId(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    notesDocumentEntity.setMsSyncDocumentUuid(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    int i8 = columnIndexOrThrow2;
                    int i9 = columnIndexOrThrow3;
                    notesDocumentEntity.setMsLastSyncTime(cursorQuery.getLong(columnIndexOrThrow10));
                    notesDocumentEntity.setMathMode(cursorQuery.getInt(columnIndexOrThrow11));
                    notesDocumentEntity.setId(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                    notesDocumentEntity.setUuid(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i10 = i7;
                    notesDocumentEntity.setIsDeleted(cursorQuery.getInt(i10));
                    int i11 = columnIndexOrThrow15;
                    notesDocumentEntity.setIsDirty(cursorQuery.getInt(i11));
                    int i12 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i12)) {
                        i4 = i12;
                        string2 = null;
                    } else {
                        i4 = i12;
                        string2 = cursorQuery.getString(i12);
                    }
                    notesDocumentEntity.setTitle(string2);
                    int i13 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i13)) {
                        columnIndexOrThrow17 = i13;
                        string3 = null;
                    } else {
                        columnIndexOrThrow17 = i13;
                        string3 = cursorQuery.getString(i13);
                    }
                    notesDocumentEntity.setRecommendedTitle(string3);
                    int i14 = columnIndexOrThrow18;
                    columnIndexOrThrow18 = i14;
                    notesDocumentEntity.setContent(NotesDataConverter.byteToString(cursorQuery.isNull(i14) ? null : cursorQuery.getBlob(i14)));
                    int i15 = columnIndexOrThrow19;
                    if (cursorQuery.isNull(i15)) {
                        columnIndexOrThrow19 = i15;
                        blob = null;
                    } else {
                        columnIndexOrThrow19 = i15;
                        blob = cursorQuery.getBlob(i15);
                    }
                    notesDocumentEntity.setDisplayContent(blob);
                    int i16 = columnIndexOrThrow13;
                    int i17 = columnIndexOrThrow20;
                    notesDocumentEntity.setCreatedAt(cursorQuery.getLong(i17));
                    int i18 = columnIndexOrThrow21;
                    notesDocumentEntity.setLastModifiedAt(cursorQuery.getLong(i18));
                    int i19 = columnIndexOrThrow22;
                    notesDocumentEntity.setVrUuid(cursorQuery.isNull(i19) ? null : cursorQuery.getString(i19));
                    int i20 = columnIndexOrThrow23;
                    if (cursorQuery.isNull(i20)) {
                        i5 = i17;
                        string4 = null;
                    } else {
                        i5 = i17;
                        string4 = cursorQuery.getString(i20);
                    }
                    notesDocumentEntity.setContentUuid(string4);
                    int i21 = columnIndexOrThrow24;
                    if (cursorQuery.isNull(i21)) {
                        columnIndexOrThrow24 = i21;
                        numValueOf = null;
                    } else {
                        columnIndexOrThrow24 = i21;
                        numValueOf = Integer.valueOf(cursorQuery.getInt(i21));
                    }
                    notesDocumentEntity.setFirstContentType(numValueOf);
                    int i22 = columnIndexOrThrow25;
                    if (cursorQuery.isNull(i22)) {
                        columnIndexOrThrow25 = i22;
                        numValueOf2 = null;
                    } else {
                        columnIndexOrThrow25 = i22;
                        numValueOf2 = Integer.valueOf(cursorQuery.getInt(i22));
                    }
                    notesDocumentEntity.setSecondContentType(numValueOf2);
                    int i23 = columnIndexOrThrow26;
                    if (cursorQuery.isNull(i23)) {
                        columnIndexOrThrow26 = i23;
                        string5 = null;
                    } else {
                        columnIndexOrThrow26 = i23;
                        string5 = cursorQuery.getString(i23);
                    }
                    notesDocumentEntity.setStrokeUuid(string5);
                    int i24 = columnIndexOrThrow27;
                    if (cursorQuery.isNull(i24)) {
                        columnIndexOrThrow27 = i24;
                        fValueOf = null;
                    } else {
                        columnIndexOrThrow27 = i24;
                        fValueOf = Float.valueOf(cursorQuery.getFloat(i24));
                    }
                    notesDocumentEntity.setStrokeRatio(fValueOf);
                    int i25 = columnIndexOrThrow28;
                    if (cursorQuery.isNull(i25)) {
                        columnIndexOrThrow28 = i25;
                        string6 = null;
                    } else {
                        columnIndexOrThrow28 = i25;
                        string6 = cursorQuery.getString(i25);
                    }
                    notesDocumentEntity.setCategoryUuid(string6);
                    int i26 = columnIndexOrThrow29;
                    if (cursorQuery.isNull(i26)) {
                        columnIndexOrThrow29 = i26;
                        string7 = null;
                    } else {
                        columnIndexOrThrow29 = i26;
                        string7 = cursorQuery.getString(i26);
                    }
                    notesDocumentEntity.setFilePath(string7);
                    int i27 = columnIndexOrThrow30;
                    notesDocumentEntity.setIsFavorite(cursorQuery.getInt(i27));
                    columnIndexOrThrow30 = i27;
                    int i28 = columnIndexOrThrow31;
                    notesDocumentEntity.setIsLock(cursorQuery.getInt(i28));
                    columnIndexOrThrow31 = i28;
                    int i29 = columnIndexOrThrow32;
                    notesDocumentEntity.setIsSavingByWhichPid(cursorQuery.getInt(i29));
                    int i30 = columnIndexOrThrow33;
                    notesDocumentEntity.setReminderTriggerTime(cursorQuery.getLong(i30));
                    int i31 = columnIndexOrThrow34;
                    notesDocumentEntity.setReminderRequestCode(cursorQuery.getInt(i31));
                    int i32 = columnIndexOrThrow35;
                    notesDocumentEntity.setRecycleBinTimeMoved(cursorQuery.getLong(i32));
                    int i33 = columnIndexOrThrow36;
                    notesDocumentEntity.setContentSecureVersion(cursorQuery.getInt(i33));
                    int i34 = columnIndexOrThrow4;
                    int i35 = columnIndexOrThrow37;
                    notesDocumentEntity.setSize(cursorQuery.getLong(i35));
                    int i36 = columnIndexOrThrow38;
                    notesDocumentEntity.setDisplayTitle(cursorQuery.isNull(i36) ? null : cursorQuery.getBlob(i36));
                    int i37 = columnIndexOrThrow39;
                    notesDocumentEntity.setSaveType(cursorQuery.getInt(i37));
                    int i38 = columnIndexOrThrow40;
                    notesDocumentEntity.setFirstOpendAt(cursorQuery.getLong(i38));
                    int i39 = columnIndexOrThrow41;
                    notesDocumentEntity.setSecondOpenedAt(cursorQuery.getLong(i39));
                    int i40 = columnIndexOrThrow42;
                    notesDocumentEntity.setLastOpenedAt(cursorQuery.getLong(i40));
                    int i41 = columnIndexOrThrow43;
                    notesDocumentEntity.setImportedAt(cursorQuery.getLong(i41));
                    int i42 = columnIndexOrThrow44;
                    notesDocumentEntity.setRecommendedAt(cursorQuery.getLong(i42));
                    int i43 = columnIndexOrThrow45;
                    notesDocumentEntity.setLastMappedAt(cursorQuery.getLong(i43));
                    int i44 = columnIndexOrThrow46;
                    notesDocumentEntity.setMdeSpaceId(cursorQuery.isNull(i44) ? null : cursorQuery.getString(i44));
                    int i45 = columnIndexOrThrow47;
                    if (cursorQuery.isNull(i45)) {
                        i6 = i38;
                        string8 = null;
                    } else {
                        i6 = i38;
                        string8 = cursorQuery.getString(i45);
                    }
                    notesDocumentEntity.setMdeItemId(string8);
                    int i46 = columnIndexOrThrow48;
                    if (cursorQuery.isNull(i46)) {
                        columnIndexOrThrow48 = i46;
                        string9 = null;
                    } else {
                        columnIndexOrThrow48 = i46;
                        string9 = cursorQuery.getString(i46);
                    }
                    notesDocumentEntity.setMdeExtra(string9);
                    int i47 = columnIndexOrThrow49;
                    if (cursorQuery.isNull(i47)) {
                        columnIndexOrThrow49 = i47;
                        string10 = null;
                    } else {
                        columnIndexOrThrow49 = i47;
                        string10 = cursorQuery.getString(i47);
                    }
                    notesDocumentEntity.setMdeGroupId(string10);
                    int i48 = columnIndexOrThrow50;
                    if (cursorQuery.isNull(i48)) {
                        columnIndexOrThrow50 = i48;
                        string11 = null;
                    } else {
                        columnIndexOrThrow50 = i48;
                        string11 = cursorQuery.getString(i48);
                    }
                    notesDocumentEntity.setMdeOwnerId(string11);
                    int i49 = columnIndexOrThrow51;
                    notesDocumentEntity.setFirstHandwritingHeight(cursorQuery.getInt(i49));
                    columnIndexOrThrow51 = i49;
                    int i50 = columnIndexOrThrow52;
                    notesDocumentEntity.setDeleteRecommended(cursorQuery.getInt(i50));
                    int i51 = columnIndexOrThrow53;
                    if (cursorQuery.isNull(i51)) {
                        columnIndexOrThrow53 = i51;
                        string12 = null;
                    } else {
                        columnIndexOrThrow53 = i51;
                        string12 = cursorQuery.getString(i51);
                    }
                    notesDocumentEntity.setAbsolutePath(string12);
                    columnIndexOrThrow52 = i50;
                    int i52 = columnIndexOrThrow54;
                    notesDocumentEntity.setBackgroundColor(cursorQuery.getInt(i52));
                    columnIndexOrThrow54 = i52;
                    int i53 = columnIndexOrThrow55;
                    notesDocumentEntity.setBackgroundColorInverted(cursorQuery.getInt(i53));
                    int i54 = columnIndexOrThrow56;
                    if (cursorQuery.isNull(i54)) {
                        columnIndexOrThrow56 = i54;
                        string13 = null;
                    } else {
                        columnIndexOrThrow56 = i54;
                        string13 = cursorQuery.getString(i54);
                    }
                    notesDocumentEntity.setLockAccountGuid(string13);
                    columnIndexOrThrow55 = i53;
                    int i55 = columnIndexOrThrow57;
                    notesDocumentEntity.setCorrupted(cursorQuery.getInt(i55));
                    columnIndexOrThrow57 = i55;
                    int i56 = columnIndexOrThrow58;
                    notesDocumentEntity.setPageMode(cursorQuery.getInt(i56));
                    arrayList.add(notesDocumentEntity);
                    columnIndexOrThrow2 = i8;
                    columnIndexOrThrow15 = i11;
                    columnIndexOrThrow21 = i18;
                    columnIndexOrThrow22 = i19;
                    columnIndexOrThrow32 = i29;
                    columnIndexOrThrow38 = i36;
                    columnIndexOrThrow41 = i39;
                    columnIndexOrThrow45 = i43;
                    columnIndexOrThrow58 = i56;
                    columnIndexOrThrow13 = i16;
                    columnIndexOrThrow16 = i4;
                    columnIndexOrThrow = i2;
                    i7 = i10;
                    columnIndexOrThrow20 = i5;
                    columnIndexOrThrow23 = i20;
                    columnIndexOrThrow33 = i30;
                    columnIndexOrThrow34 = i31;
                    columnIndexOrThrow35 = i32;
                    columnIndexOrThrow37 = i35;
                    columnIndexOrThrow40 = i6;
                    columnIndexOrThrow47 = i45;
                    columnIndexOrThrow4 = i34;
                    columnIndexOrThrow36 = i33;
                    columnIndexOrThrow39 = i37;
                    columnIndexOrThrow42 = i40;
                    columnIndexOrThrow43 = i41;
                    columnIndexOrThrow44 = i42;
                    columnIndexOrThrow46 = i44;
                    columnIndexOrThrow3 = i9;
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public String getCategoryUuid(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT categoryUUID FROM sdoc WHERE UUID=?", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<String> getCategoryUuidList(Collection<String> collection) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), AbstractC11014a.m12317b(sbNewStringBuilder, "SELECT categoryUUID FROM sdoc WHERE UUID IN (", collection, sbNewStringBuilder, ")"));
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public Set<String> getCategoryUuids(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            Set<String> categoryUuids = super.getCategoryUuids(collection);
            this.__db.setTransactionSuccessful();
            return categoryUuids;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public int getCorrupted(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM sdoc WHERE UUID=? AND corrupted IS 1", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<String> getCorruptedUuid() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM sdoc WHERE corrupted IS NOT 0", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public NotesDocumentCountEntry getDocumentCountEntry_NotConsideringMappingTable(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT category_tree.UUID, category_tree.parentUUID, category_tree.displayName, category_tree.displayNameColor, category_tree.isDeleted,  category_tree.createdAt, category_tree.lastModifiedAt, category_tree.recycle_bin_time_moved, category_tree.orderBy, (SELECT COUNT(*) FROM sdoc WHERE sdoc.categoryUUID=category_tree.UUID AND sdoc.isDeleted IS NOT 1) AS documentCount FROM category_tree WHERE category_tree.UUID=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        NotesDocumentCountEntry notesDocumentCountEntry = null;
        Integer numValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                NotesDocumentCountEntry notesDocumentCountEntry2 = new NotesDocumentCountEntry();
                notesDocumentCountEntry2.setCategoryUuid(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                notesDocumentCountEntry2.setParentUuid(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                notesDocumentCountEntry2.setDisplayName(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                notesDocumentCountEntry2.setDisplayNameColor(cursorQuery.getInt(3));
                notesDocumentCountEntry2.setIsDeleted(cursorQuery.getInt(4));
                notesDocumentCountEntry2.setCreatedAt(cursorQuery.getLong(5));
                notesDocumentCountEntry2.setLastModifiedAt(cursorQuery.getLong(6));
                notesDocumentCountEntry2.setRecycleBinTimeMoved(cursorQuery.getLong(7));
                if (!cursorQuery.isNull(8)) {
                    numValueOf = Integer.valueOf(cursorQuery.getInt(8));
                }
                notesDocumentCountEntry2.setReorder(numValueOf);
                notesDocumentCountEntry2.setDocumentCount(cursorQuery.getInt(9));
                notesDocumentCountEntry = notesDocumentCountEntry2;
            }
            return notesDocumentCountEntry;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public DocumentData getDocumentData(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT _id, UUID, categoryUUID, filePath, contentUUID, strokeUUID FROM sdoc WHERE UUID=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        DocumentData documentData = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                DocumentData documentData2 = new DocumentData();
                documentData2.setId(cursorQuery.isNull(0) ? null : Long.valueOf(cursorQuery.getLong(0)));
                documentData2.setUuid(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                documentData2.setCategoryUuid(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                documentData2.setFilePath(cursorQuery.isNull(3) ? null : cursorQuery.getString(3));
                documentData2.setContentUuid(cursorQuery.isNull(4) ? null : cursorQuery.getString(4));
                if (!cursorQuery.isNull(5)) {
                    string = cursorQuery.getString(5);
                }
                documentData2.setStrokeUuid(string);
                documentData = documentData2;
            }
            return documentData;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<DocumentData> getDocumentDataByCategoryUuid(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT _id, UUID, categoryUUID, filePath FROM sdoc WHERE categoryUUID=?", 1);
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
                DocumentData documentData = new DocumentData();
                documentData.setId(cursorQuery.isNull(0) ? null : Long.valueOf(cursorQuery.getLong(0)));
                documentData.setUuid(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                documentData.setCategoryUuid(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                documentData.setFilePath(cursorQuery.isNull(3) ? null : cursorQuery.getString(3));
                arrayList.add(documentData);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<DocumentData> getDocumentDataList(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            List<DocumentData> documentDataList = super.getDocumentDataList(collection);
            this.__db.setTransactionSuccessful();
            return documentDataList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<NotesDocumentEntity> getEntities(Collection<String> collection) throws Throwable {
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
        String string3;
        byte[] blob;
        int i4;
        String string4;
        Integer numValueOf;
        Integer numValueOf2;
        String string5;
        Float fValueOf;
        String string6;
        String string7;
        int i5;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), AbstractC11014a.m12317b(sbNewStringBuilder, "SELECT `sdoc`.* FROM sdoc WHERE UUID IN (", collection, sbNewStringBuilder, ")"));
        int i6 = 1;
        for (String str : collection) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i6);
            } else {
                roomSQLiteQueryAcquire.bindString(i6, str);
            }
            i6++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accountType");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accountName");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strippedContent");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CATEGORY_SERVER_TIMESTAMP);
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CATEGORY_IS_DIRTY);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.NOTENAME);
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_SYNC_ACCOUNT_ID);
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_SYNC_DOCUMENT_UUID);
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_LAST_SYNC_TIME);
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MATH_MODE);
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDeleted");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.RECOMMENDED_TITLE);
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayContent");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.VR_UUID);
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CONTENT_UUID);
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstContentType");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "secondContentType");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strokeUUID");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strokeRatio");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryUUID");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filePath");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFavorite");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLock");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSaving");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reminderTriggerTime");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reminderRequestCode");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recycle_bin_time_moved");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "contentSecureVersion");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayTitle");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "saveType");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstOpendAt");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "secondOpenedAt");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastOpenedAt");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "importedAt");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recommendedAt");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.LAST_MAPPED_AT);
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeSpaceId");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeItemId");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeExtra");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeGroupId");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeOwnerId");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstHandwritingHeight");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deleteRecommended");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.ABSOLUTE_PATH);
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backgroundColor");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.BACKGROUND_COLOR_INVERTED);
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.LOCK_ACCOUNT_GUID);
            int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CORRUPTED);
            int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.PAGE_MODE);
            int i7 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesDocumentEntity notesDocumentEntity = new NotesDocumentEntity();
                if (cursorQuery.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow;
                    string = null;
                } else {
                    i = columnIndexOrThrow;
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                notesDocumentEntity.setAccountType(string);
                notesDocumentEntity.setAccountName(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                notesDocumentEntity.setStrippedContent(NotesDataConverter.byteToString(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getBlob(columnIndexOrThrow3)));
                notesDocumentEntity.setServerTimestamp(cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4)));
                notesDocumentEntity.setCategoryServerTimeStamp(cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)));
                notesDocumentEntity.setCategoryIsDirty(cursorQuery.getInt(columnIndexOrThrow6));
                notesDocumentEntity.setNoteName(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                notesDocumentEntity.setMsSyncAccountId(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                notesDocumentEntity.setMsSyncDocumentUuid(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                int i8 = columnIndexOrThrow2;
                int i9 = columnIndexOrThrow3;
                notesDocumentEntity.setMsLastSyncTime(cursorQuery.getLong(columnIndexOrThrow10));
                notesDocumentEntity.setMathMode(cursorQuery.getInt(columnIndexOrThrow11));
                notesDocumentEntity.setId(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                notesDocumentEntity.setUuid(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i10 = i7;
                notesDocumentEntity.setIsDeleted(cursorQuery.getInt(i10));
                int i11 = columnIndexOrThrow15;
                notesDocumentEntity.setIsDirty(cursorQuery.getInt(i11));
                int i12 = columnIndexOrThrow16;
                if (cursorQuery.isNull(i12)) {
                    i2 = i12;
                    string2 = null;
                } else {
                    i2 = i12;
                    string2 = cursorQuery.getString(i12);
                }
                notesDocumentEntity.setTitle(string2);
                int i13 = columnIndexOrThrow17;
                if (cursorQuery.isNull(i13)) {
                    columnIndexOrThrow17 = i13;
                    string3 = null;
                } else {
                    columnIndexOrThrow17 = i13;
                    string3 = cursorQuery.getString(i13);
                }
                notesDocumentEntity.setRecommendedTitle(string3);
                int i14 = columnIndexOrThrow18;
                columnIndexOrThrow18 = i14;
                notesDocumentEntity.setContent(NotesDataConverter.byteToString(cursorQuery.isNull(i14) ? null : cursorQuery.getBlob(i14)));
                int i15 = columnIndexOrThrow19;
                if (cursorQuery.isNull(i15)) {
                    columnIndexOrThrow19 = i15;
                    blob = null;
                } else {
                    columnIndexOrThrow19 = i15;
                    blob = cursorQuery.getBlob(i15);
                }
                notesDocumentEntity.setDisplayContent(blob);
                int i16 = columnIndexOrThrow13;
                int i17 = columnIndexOrThrow20;
                notesDocumentEntity.setCreatedAt(cursorQuery.getLong(i17));
                int i18 = columnIndexOrThrow21;
                notesDocumentEntity.setLastModifiedAt(cursorQuery.getLong(i18));
                int i19 = columnIndexOrThrow22;
                notesDocumentEntity.setVrUuid(cursorQuery.isNull(i19) ? null : cursorQuery.getString(i19));
                int i20 = columnIndexOrThrow23;
                if (cursorQuery.isNull(i20)) {
                    i4 = i17;
                    string4 = null;
                } else {
                    i4 = i17;
                    string4 = cursorQuery.getString(i20);
                }
                notesDocumentEntity.setContentUuid(string4);
                int i21 = columnIndexOrThrow24;
                if (cursorQuery.isNull(i21)) {
                    columnIndexOrThrow24 = i21;
                    numValueOf = null;
                } else {
                    columnIndexOrThrow24 = i21;
                    numValueOf = Integer.valueOf(cursorQuery.getInt(i21));
                }
                notesDocumentEntity.setFirstContentType(numValueOf);
                int i22 = columnIndexOrThrow25;
                if (cursorQuery.isNull(i22)) {
                    columnIndexOrThrow25 = i22;
                    numValueOf2 = null;
                } else {
                    columnIndexOrThrow25 = i22;
                    numValueOf2 = Integer.valueOf(cursorQuery.getInt(i22));
                }
                notesDocumentEntity.setSecondContentType(numValueOf2);
                int i23 = columnIndexOrThrow26;
                if (cursorQuery.isNull(i23)) {
                    columnIndexOrThrow26 = i23;
                    string5 = null;
                } else {
                    columnIndexOrThrow26 = i23;
                    string5 = cursorQuery.getString(i23);
                }
                notesDocumentEntity.setStrokeUuid(string5);
                int i24 = columnIndexOrThrow27;
                if (cursorQuery.isNull(i24)) {
                    columnIndexOrThrow27 = i24;
                    fValueOf = null;
                } else {
                    columnIndexOrThrow27 = i24;
                    fValueOf = Float.valueOf(cursorQuery.getFloat(i24));
                }
                notesDocumentEntity.setStrokeRatio(fValueOf);
                int i25 = columnIndexOrThrow28;
                if (cursorQuery.isNull(i25)) {
                    columnIndexOrThrow28 = i25;
                    string6 = null;
                } else {
                    columnIndexOrThrow28 = i25;
                    string6 = cursorQuery.getString(i25);
                }
                notesDocumentEntity.setCategoryUuid(string6);
                int i26 = columnIndexOrThrow29;
                if (cursorQuery.isNull(i26)) {
                    columnIndexOrThrow29 = i26;
                    string7 = null;
                } else {
                    columnIndexOrThrow29 = i26;
                    string7 = cursorQuery.getString(i26);
                }
                notesDocumentEntity.setFilePath(string7);
                int i27 = columnIndexOrThrow30;
                notesDocumentEntity.setIsFavorite(cursorQuery.getInt(i27));
                columnIndexOrThrow30 = i27;
                int i28 = columnIndexOrThrow31;
                notesDocumentEntity.setIsLock(cursorQuery.getInt(i28));
                columnIndexOrThrow31 = i28;
                int i29 = columnIndexOrThrow32;
                notesDocumentEntity.setIsSavingByWhichPid(cursorQuery.getInt(i29));
                int i30 = columnIndexOrThrow33;
                notesDocumentEntity.setReminderTriggerTime(cursorQuery.getLong(i30));
                int i31 = columnIndexOrThrow34;
                notesDocumentEntity.setReminderRequestCode(cursorQuery.getInt(i31));
                int i32 = columnIndexOrThrow35;
                notesDocumentEntity.setRecycleBinTimeMoved(cursorQuery.getLong(i32));
                int i33 = columnIndexOrThrow36;
                notesDocumentEntity.setContentSecureVersion(cursorQuery.getInt(i33));
                int i34 = columnIndexOrThrow4;
                int i35 = columnIndexOrThrow37;
                notesDocumentEntity.setSize(cursorQuery.getLong(i35));
                int i36 = columnIndexOrThrow38;
                notesDocumentEntity.setDisplayTitle(cursorQuery.isNull(i36) ? null : cursorQuery.getBlob(i36));
                int i37 = columnIndexOrThrow39;
                notesDocumentEntity.setSaveType(cursorQuery.getInt(i37));
                int i38 = columnIndexOrThrow40;
                notesDocumentEntity.setFirstOpendAt(cursorQuery.getLong(i38));
                int i39 = columnIndexOrThrow41;
                notesDocumentEntity.setSecondOpenedAt(cursorQuery.getLong(i39));
                int i40 = columnIndexOrThrow42;
                notesDocumentEntity.setLastOpenedAt(cursorQuery.getLong(i40));
                int i41 = columnIndexOrThrow43;
                notesDocumentEntity.setImportedAt(cursorQuery.getLong(i41));
                int i42 = columnIndexOrThrow44;
                notesDocumentEntity.setRecommendedAt(cursorQuery.getLong(i42));
                int i43 = columnIndexOrThrow45;
                notesDocumentEntity.setLastMappedAt(cursorQuery.getLong(i43));
                int i44 = columnIndexOrThrow46;
                notesDocumentEntity.setMdeSpaceId(cursorQuery.isNull(i44) ? null : cursorQuery.getString(i44));
                int i45 = columnIndexOrThrow47;
                if (cursorQuery.isNull(i45)) {
                    i5 = i38;
                    string8 = null;
                } else {
                    i5 = i38;
                    string8 = cursorQuery.getString(i45);
                }
                notesDocumentEntity.setMdeItemId(string8);
                int i46 = columnIndexOrThrow48;
                if (cursorQuery.isNull(i46)) {
                    columnIndexOrThrow48 = i46;
                    string9 = null;
                } else {
                    columnIndexOrThrow48 = i46;
                    string9 = cursorQuery.getString(i46);
                }
                notesDocumentEntity.setMdeExtra(string9);
                int i47 = columnIndexOrThrow49;
                if (cursorQuery.isNull(i47)) {
                    columnIndexOrThrow49 = i47;
                    string10 = null;
                } else {
                    columnIndexOrThrow49 = i47;
                    string10 = cursorQuery.getString(i47);
                }
                notesDocumentEntity.setMdeGroupId(string10);
                int i48 = columnIndexOrThrow50;
                if (cursorQuery.isNull(i48)) {
                    columnIndexOrThrow50 = i48;
                    string11 = null;
                } else {
                    columnIndexOrThrow50 = i48;
                    string11 = cursorQuery.getString(i48);
                }
                notesDocumentEntity.setMdeOwnerId(string11);
                int i49 = columnIndexOrThrow51;
                notesDocumentEntity.setFirstHandwritingHeight(cursorQuery.getInt(i49));
                columnIndexOrThrow51 = i49;
                int i50 = columnIndexOrThrow52;
                notesDocumentEntity.setDeleteRecommended(cursorQuery.getInt(i50));
                int i51 = columnIndexOrThrow53;
                if (cursorQuery.isNull(i51)) {
                    columnIndexOrThrow53 = i51;
                    string12 = null;
                } else {
                    columnIndexOrThrow53 = i51;
                    string12 = cursorQuery.getString(i51);
                }
                notesDocumentEntity.setAbsolutePath(string12);
                columnIndexOrThrow52 = i50;
                int i52 = columnIndexOrThrow54;
                notesDocumentEntity.setBackgroundColor(cursorQuery.getInt(i52));
                columnIndexOrThrow54 = i52;
                int i53 = columnIndexOrThrow55;
                notesDocumentEntity.setBackgroundColorInverted(cursorQuery.getInt(i53));
                int i54 = columnIndexOrThrow56;
                if (cursorQuery.isNull(i54)) {
                    columnIndexOrThrow56 = i54;
                    string13 = null;
                } else {
                    columnIndexOrThrow56 = i54;
                    string13 = cursorQuery.getString(i54);
                }
                notesDocumentEntity.setLockAccountGuid(string13);
                columnIndexOrThrow55 = i53;
                int i55 = columnIndexOrThrow57;
                notesDocumentEntity.setCorrupted(cursorQuery.getInt(i55));
                columnIndexOrThrow57 = i55;
                int i56 = columnIndexOrThrow58;
                notesDocumentEntity.setPageMode(cursorQuery.getInt(i56));
                arrayList.add(notesDocumentEntity);
                columnIndexOrThrow45 = i43;
                columnIndexOrThrow2 = i8;
                columnIndexOrThrow15 = i11;
                columnIndexOrThrow21 = i18;
                columnIndexOrThrow22 = i19;
                columnIndexOrThrow32 = i29;
                columnIndexOrThrow38 = i36;
                columnIndexOrThrow41 = i39;
                columnIndexOrThrow58 = i56;
                columnIndexOrThrow13 = i16;
                columnIndexOrThrow16 = i2;
                columnIndexOrThrow = i;
                i7 = i10;
                columnIndexOrThrow20 = i4;
                columnIndexOrThrow23 = i20;
                columnIndexOrThrow33 = i30;
                columnIndexOrThrow34 = i31;
                columnIndexOrThrow35 = i32;
                columnIndexOrThrow37 = i35;
                columnIndexOrThrow40 = i5;
                columnIndexOrThrow47 = i45;
                columnIndexOrThrow4 = i34;
                columnIndexOrThrow36 = i33;
                columnIndexOrThrow39 = i37;
                columnIndexOrThrow42 = i40;
                columnIndexOrThrow43 = i41;
                columnIndexOrThrow44 = i42;
                columnIndexOrThrow46 = i44;
                columnIndexOrThrow3 = i9;
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<NotesDocumentEntity> getEntitiesByUuids(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            List<NotesDocumentEntity> entitiesByUuids = super.getEntitiesByUuids(collection);
            this.__db.setTransactionSuccessful();
            return entitiesByUuids;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public NotesDocumentEntity getEntity(String str) throws Throwable {
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
        NotesDocumentEntity notesDocumentEntity;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `sdoc`.* FROM sdoc WHERE UUID=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accountType");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accountName");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strippedContent");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CATEGORY_SERVER_TIMESTAMP);
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CATEGORY_IS_DIRTY);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.NOTENAME);
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_SYNC_ACCOUNT_ID);
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_SYNC_DOCUMENT_UUID);
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_LAST_SYNC_TIME);
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MATH_MODE);
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDeleted");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.RECOMMENDED_TITLE);
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayContent");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.VR_UUID);
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CONTENT_UUID);
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstContentType");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "secondContentType");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strokeUUID");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strokeRatio");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryUUID");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filePath");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFavorite");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLock");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSaving");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reminderTriggerTime");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reminderRequestCode");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recycle_bin_time_moved");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "contentSecureVersion");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayTitle");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "saveType");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstOpendAt");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "secondOpenedAt");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastOpenedAt");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "importedAt");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recommendedAt");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.LAST_MAPPED_AT);
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeSpaceId");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeItemId");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeExtra");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeGroupId");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeOwnerId");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstHandwritingHeight");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deleteRecommended");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.ABSOLUTE_PATH);
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backgroundColor");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.BACKGROUND_COLOR_INVERTED);
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.LOCK_ACCOUNT_GUID);
            int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CORRUPTED);
            int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.PAGE_MODE);
            if (cursorQuery.moveToFirst()) {
                NotesDocumentEntity notesDocumentEntity2 = new NotesDocumentEntity();
                notesDocumentEntity2.setAccountType(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                notesDocumentEntity2.setAccountName(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                notesDocumentEntity2.setStrippedContent(NotesDataConverter.byteToString(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getBlob(columnIndexOrThrow3)));
                notesDocumentEntity2.setServerTimestamp(cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4)));
                notesDocumentEntity2.setCategoryServerTimeStamp(cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)));
                notesDocumentEntity2.setCategoryIsDirty(cursorQuery.getInt(columnIndexOrThrow6));
                notesDocumentEntity2.setNoteName(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                notesDocumentEntity2.setMsSyncAccountId(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                notesDocumentEntity2.setMsSyncDocumentUuid(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                notesDocumentEntity2.setMsLastSyncTime(cursorQuery.getLong(columnIndexOrThrow10));
                notesDocumentEntity2.setMathMode(cursorQuery.getInt(columnIndexOrThrow11));
                notesDocumentEntity2.setId(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                notesDocumentEntity2.setUuid(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                notesDocumentEntity2.setIsDeleted(cursorQuery.getInt(columnIndexOrThrow14));
                notesDocumentEntity2.setIsDirty(cursorQuery.getInt(columnIndexOrThrow15));
                notesDocumentEntity2.setTitle(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                notesDocumentEntity2.setRecommendedTitle(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                notesDocumentEntity2.setContent(NotesDataConverter.byteToString(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getBlob(columnIndexOrThrow18)));
                notesDocumentEntity2.setDisplayContent(cursorQuery.isNull(columnIndexOrThrow19) ? null : cursorQuery.getBlob(columnIndexOrThrow19));
                notesDocumentEntity2.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow20));
                notesDocumentEntity2.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow21));
                notesDocumentEntity2.setVrUuid(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                notesDocumentEntity2.setContentUuid(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                notesDocumentEntity2.setFirstContentType(cursorQuery.isNull(columnIndexOrThrow24) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow24)));
                notesDocumentEntity2.setSecondContentType(cursorQuery.isNull(columnIndexOrThrow25) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow25)));
                notesDocumentEntity2.setStrokeUuid(cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26));
                notesDocumentEntity2.setStrokeRatio(cursorQuery.isNull(columnIndexOrThrow27) ? null : Float.valueOf(cursorQuery.getFloat(columnIndexOrThrow27)));
                notesDocumentEntity2.setCategoryUuid(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                notesDocumentEntity2.setFilePath(cursorQuery.isNull(columnIndexOrThrow29) ? null : cursorQuery.getString(columnIndexOrThrow29));
                notesDocumentEntity2.setIsFavorite(cursorQuery.getInt(columnIndexOrThrow30));
                notesDocumentEntity2.setIsLock(cursorQuery.getInt(columnIndexOrThrow31));
                notesDocumentEntity2.setIsSavingByWhichPid(cursorQuery.getInt(columnIndexOrThrow32));
                notesDocumentEntity2.setReminderTriggerTime(cursorQuery.getLong(columnIndexOrThrow33));
                notesDocumentEntity2.setReminderRequestCode(cursorQuery.getInt(columnIndexOrThrow34));
                notesDocumentEntity2.setRecycleBinTimeMoved(cursorQuery.getLong(columnIndexOrThrow35));
                notesDocumentEntity2.setContentSecureVersion(cursorQuery.getInt(columnIndexOrThrow36));
                notesDocumentEntity2.setSize(cursorQuery.getLong(columnIndexOrThrow37));
                notesDocumentEntity2.setDisplayTitle(cursorQuery.isNull(columnIndexOrThrow38) ? null : cursorQuery.getBlob(columnIndexOrThrow38));
                notesDocumentEntity2.setSaveType(cursorQuery.getInt(columnIndexOrThrow39));
                notesDocumentEntity2.setFirstOpendAt(cursorQuery.getLong(columnIndexOrThrow40));
                notesDocumentEntity2.setSecondOpenedAt(cursorQuery.getLong(columnIndexOrThrow41));
                notesDocumentEntity2.setLastOpenedAt(cursorQuery.getLong(columnIndexOrThrow42));
                notesDocumentEntity2.setImportedAt(cursorQuery.getLong(columnIndexOrThrow43));
                notesDocumentEntity2.setRecommendedAt(cursorQuery.getLong(columnIndexOrThrow44));
                notesDocumentEntity2.setLastMappedAt(cursorQuery.getLong(columnIndexOrThrow45));
                notesDocumentEntity2.setMdeSpaceId(cursorQuery.isNull(columnIndexOrThrow46) ? null : cursorQuery.getString(columnIndexOrThrow46));
                notesDocumentEntity2.setMdeItemId(cursorQuery.isNull(columnIndexOrThrow47) ? null : cursorQuery.getString(columnIndexOrThrow47));
                notesDocumentEntity2.setMdeExtra(cursorQuery.isNull(columnIndexOrThrow48) ? null : cursorQuery.getString(columnIndexOrThrow48));
                notesDocumentEntity2.setMdeGroupId(cursorQuery.isNull(columnIndexOrThrow49) ? null : cursorQuery.getString(columnIndexOrThrow49));
                notesDocumentEntity2.setMdeOwnerId(cursorQuery.isNull(columnIndexOrThrow50) ? null : cursorQuery.getString(columnIndexOrThrow50));
                notesDocumentEntity2.setFirstHandwritingHeight(cursorQuery.getInt(columnIndexOrThrow51));
                notesDocumentEntity2.setDeleteRecommended(cursorQuery.getInt(columnIndexOrThrow52));
                notesDocumentEntity2.setAbsolutePath(cursorQuery.isNull(columnIndexOrThrow53) ? null : cursorQuery.getString(columnIndexOrThrow53));
                notesDocumentEntity2.setBackgroundColor(cursorQuery.getInt(columnIndexOrThrow54));
                notesDocumentEntity2.setBackgroundColorInverted(cursorQuery.getInt(columnIndexOrThrow55));
                notesDocumentEntity2.setLockAccountGuid(cursorQuery.isNull(columnIndexOrThrow56) ? null : cursorQuery.getString(columnIndexOrThrow56));
                notesDocumentEntity2.setCorrupted(cursorQuery.getInt(columnIndexOrThrow57));
                notesDocumentEntity2.setPageMode(cursorQuery.getInt(columnIndexOrThrow58));
                notesDocumentEntity = notesDocumentEntity2;
            } else {
                notesDocumentEntity = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return notesDocumentEntity;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public NotesDocumentEntity getEntityFromPath(String str) throws Throwable {
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
        NotesDocumentEntity notesDocumentEntity;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `sdoc`.* FROM sdoc WHERE filePath=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accountType");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accountName");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strippedContent");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CATEGORY_SERVER_TIMESTAMP);
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CATEGORY_IS_DIRTY);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.NOTENAME);
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_SYNC_ACCOUNT_ID);
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_SYNC_DOCUMENT_UUID);
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_LAST_SYNC_TIME);
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MATH_MODE);
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDeleted");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.RECOMMENDED_TITLE);
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayContent");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.VR_UUID);
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CONTENT_UUID);
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstContentType");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "secondContentType");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strokeUUID");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strokeRatio");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryUUID");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filePath");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFavorite");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLock");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSaving");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reminderTriggerTime");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reminderRequestCode");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recycle_bin_time_moved");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "contentSecureVersion");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayTitle");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "saveType");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstOpendAt");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "secondOpenedAt");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastOpenedAt");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "importedAt");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recommendedAt");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.LAST_MAPPED_AT);
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeSpaceId");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeItemId");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeExtra");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeGroupId");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeOwnerId");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstHandwritingHeight");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deleteRecommended");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.ABSOLUTE_PATH);
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backgroundColor");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.BACKGROUND_COLOR_INVERTED);
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.LOCK_ACCOUNT_GUID);
            int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CORRUPTED);
            int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.PAGE_MODE);
            if (cursorQuery.moveToFirst()) {
                NotesDocumentEntity notesDocumentEntity2 = new NotesDocumentEntity();
                notesDocumentEntity2.setAccountType(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                notesDocumentEntity2.setAccountName(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                notesDocumentEntity2.setStrippedContent(NotesDataConverter.byteToString(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getBlob(columnIndexOrThrow3)));
                notesDocumentEntity2.setServerTimestamp(cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4)));
                notesDocumentEntity2.setCategoryServerTimeStamp(cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)));
                notesDocumentEntity2.setCategoryIsDirty(cursorQuery.getInt(columnIndexOrThrow6));
                notesDocumentEntity2.setNoteName(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                notesDocumentEntity2.setMsSyncAccountId(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                notesDocumentEntity2.setMsSyncDocumentUuid(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                notesDocumentEntity2.setMsLastSyncTime(cursorQuery.getLong(columnIndexOrThrow10));
                notesDocumentEntity2.setMathMode(cursorQuery.getInt(columnIndexOrThrow11));
                notesDocumentEntity2.setId(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                notesDocumentEntity2.setUuid(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                notesDocumentEntity2.setIsDeleted(cursorQuery.getInt(columnIndexOrThrow14));
                notesDocumentEntity2.setIsDirty(cursorQuery.getInt(columnIndexOrThrow15));
                notesDocumentEntity2.setTitle(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                notesDocumentEntity2.setRecommendedTitle(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                notesDocumentEntity2.setContent(NotesDataConverter.byteToString(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getBlob(columnIndexOrThrow18)));
                notesDocumentEntity2.setDisplayContent(cursorQuery.isNull(columnIndexOrThrow19) ? null : cursorQuery.getBlob(columnIndexOrThrow19));
                notesDocumentEntity2.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow20));
                notesDocumentEntity2.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow21));
                notesDocumentEntity2.setVrUuid(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                notesDocumentEntity2.setContentUuid(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                notesDocumentEntity2.setFirstContentType(cursorQuery.isNull(columnIndexOrThrow24) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow24)));
                notesDocumentEntity2.setSecondContentType(cursorQuery.isNull(columnIndexOrThrow25) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow25)));
                notesDocumentEntity2.setStrokeUuid(cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26));
                notesDocumentEntity2.setStrokeRatio(cursorQuery.isNull(columnIndexOrThrow27) ? null : Float.valueOf(cursorQuery.getFloat(columnIndexOrThrow27)));
                notesDocumentEntity2.setCategoryUuid(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                notesDocumentEntity2.setFilePath(cursorQuery.isNull(columnIndexOrThrow29) ? null : cursorQuery.getString(columnIndexOrThrow29));
                notesDocumentEntity2.setIsFavorite(cursorQuery.getInt(columnIndexOrThrow30));
                notesDocumentEntity2.setIsLock(cursorQuery.getInt(columnIndexOrThrow31));
                notesDocumentEntity2.setIsSavingByWhichPid(cursorQuery.getInt(columnIndexOrThrow32));
                notesDocumentEntity2.setReminderTriggerTime(cursorQuery.getLong(columnIndexOrThrow33));
                notesDocumentEntity2.setReminderRequestCode(cursorQuery.getInt(columnIndexOrThrow34));
                notesDocumentEntity2.setRecycleBinTimeMoved(cursorQuery.getLong(columnIndexOrThrow35));
                notesDocumentEntity2.setContentSecureVersion(cursorQuery.getInt(columnIndexOrThrow36));
                notesDocumentEntity2.setSize(cursorQuery.getLong(columnIndexOrThrow37));
                notesDocumentEntity2.setDisplayTitle(cursorQuery.isNull(columnIndexOrThrow38) ? null : cursorQuery.getBlob(columnIndexOrThrow38));
                notesDocumentEntity2.setSaveType(cursorQuery.getInt(columnIndexOrThrow39));
                notesDocumentEntity2.setFirstOpendAt(cursorQuery.getLong(columnIndexOrThrow40));
                notesDocumentEntity2.setSecondOpenedAt(cursorQuery.getLong(columnIndexOrThrow41));
                notesDocumentEntity2.setLastOpenedAt(cursorQuery.getLong(columnIndexOrThrow42));
                notesDocumentEntity2.setImportedAt(cursorQuery.getLong(columnIndexOrThrow43));
                notesDocumentEntity2.setRecommendedAt(cursorQuery.getLong(columnIndexOrThrow44));
                notesDocumentEntity2.setLastMappedAt(cursorQuery.getLong(columnIndexOrThrow45));
                notesDocumentEntity2.setMdeSpaceId(cursorQuery.isNull(columnIndexOrThrow46) ? null : cursorQuery.getString(columnIndexOrThrow46));
                notesDocumentEntity2.setMdeItemId(cursorQuery.isNull(columnIndexOrThrow47) ? null : cursorQuery.getString(columnIndexOrThrow47));
                notesDocumentEntity2.setMdeExtra(cursorQuery.isNull(columnIndexOrThrow48) ? null : cursorQuery.getString(columnIndexOrThrow48));
                notesDocumentEntity2.setMdeGroupId(cursorQuery.isNull(columnIndexOrThrow49) ? null : cursorQuery.getString(columnIndexOrThrow49));
                notesDocumentEntity2.setMdeOwnerId(cursorQuery.isNull(columnIndexOrThrow50) ? null : cursorQuery.getString(columnIndexOrThrow50));
                notesDocumentEntity2.setFirstHandwritingHeight(cursorQuery.getInt(columnIndexOrThrow51));
                notesDocumentEntity2.setDeleteRecommended(cursorQuery.getInt(columnIndexOrThrow52));
                notesDocumentEntity2.setAbsolutePath(cursorQuery.isNull(columnIndexOrThrow53) ? null : cursorQuery.getString(columnIndexOrThrow53));
                notesDocumentEntity2.setBackgroundColor(cursorQuery.getInt(columnIndexOrThrow54));
                notesDocumentEntity2.setBackgroundColorInverted(cursorQuery.getInt(columnIndexOrThrow55));
                notesDocumentEntity2.setLockAccountGuid(cursorQuery.isNull(columnIndexOrThrow56) ? null : cursorQuery.getString(columnIndexOrThrow56));
                notesDocumentEntity2.setCorrupted(cursorQuery.getInt(columnIndexOrThrow57));
                notesDocumentEntity2.setPageMode(cursorQuery.getInt(columnIndexOrThrow58));
                notesDocumentEntity = notesDocumentEntity2;
            } else {
                notesDocumentEntity = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return notesDocumentEntity;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<String> getExpiredRecycleBinDataList(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM sdoc WHERE recycle_bin_time_moved<? AND recycle_bin_time_moved IS NOT 0 AND isDeleted=2", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public int getIsSavingByWhichPid(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT isSaving FROM sdoc WHERE UUID=?", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<NotesDocumentEntity> getNotesForBackup() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `sdoc`.`accountType`, `sdoc`.`accountName`, `sdoc`.`strippedContent`, `sdoc`.`serverTimestamp`, `sdoc`.`categoryserverTimestamp`, `sdoc`.`categoryisDirty`, `sdoc`.`noteName`, `sdoc`.`msSyncAccountId`, `sdoc`.`msSyncDocumentUuid`, `sdoc`.`msLastSyncTime`, `sdoc`.`mathMode`, `sdoc`.`_id`, `sdoc`.`UUID`, `sdoc`.`isDeleted`, `sdoc`.`isDirty`, `sdoc`.`title`, `sdoc`.`recommendedTitle`, `sdoc`.`content`, `sdoc`.`displayContent`, `sdoc`.`createdAt`, `sdoc`.`lastModifiedAt`, `sdoc`.`vrUUID`, `sdoc`.`contentUUID`, `sdoc`.`firstContentType`, `sdoc`.`secondContentType`, `sdoc`.`strokeUUID`, `sdoc`.`strokeRatio`, `sdoc`.`categoryUUID`, `sdoc`.`filePath`, `sdoc`.`isFavorite`, `sdoc`.`isLock`, `sdoc`.`isSaving`, `sdoc`.`reminderTriggerTime`, `sdoc`.`reminderRequestCode`, `sdoc`.`recycle_bin_time_moved`, `sdoc`.`contentSecureVersion`, `sdoc`.`size`, `sdoc`.`displayTitle`, `sdoc`.`saveType`, `sdoc`.`firstOpendAt`, `sdoc`.`secondOpenedAt`, `sdoc`.`lastOpenedAt`, `sdoc`.`importedAt`, `sdoc`.`recommendedAt`, `sdoc`.`lastMappedAt`, `sdoc`.`mdeSpaceId`, `sdoc`.`mdeItemId`, `sdoc`.`mdeExtra`, `sdoc`.`mdeGroupId`, `sdoc`.`mdeOwnerId`, `sdoc`.`firstHandwritingHeight`, `sdoc`.`deleteRecommended`, `sdoc`.`absolutePath`, `sdoc`.`backgroundColor`, `sdoc`.`backgroundColorInverted`, `sdoc`.`lockAccountGuid`, `sdoc`.`corrupted`, `sdoc`.`pageMode` FROM sdoc LEFT OUTER JOIN mapped_document AS map ON sdoc.UUID = map.UUID WHERE sdoc.isDeleted != 1 AND sdoc.mdeSpaceId='' AND isLock != 1 AND map.UUID IS NULL", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<NotesDocumentEntity> getNotesForBackupExceptGenAi() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `sdoc`.`accountType`, `sdoc`.`accountName`, `sdoc`.`strippedContent`, `sdoc`.`serverTimestamp`, `sdoc`.`categoryserverTimestamp`, `sdoc`.`categoryisDirty`, `sdoc`.`noteName`, `sdoc`.`msSyncAccountId`, `sdoc`.`msSyncDocumentUuid`, `sdoc`.`msLastSyncTime`, `sdoc`.`mathMode`, `sdoc`.`_id`, `sdoc`.`UUID`, `sdoc`.`isDeleted`, `sdoc`.`isDirty`, `sdoc`.`title`, `sdoc`.`recommendedTitle`, `sdoc`.`content`, `sdoc`.`displayContent`, `sdoc`.`createdAt`, `sdoc`.`lastModifiedAt`, `sdoc`.`vrUUID`, `sdoc`.`contentUUID`, `sdoc`.`firstContentType`, `sdoc`.`secondContentType`, `sdoc`.`strokeUUID`, `sdoc`.`strokeRatio`, `sdoc`.`categoryUUID`, `sdoc`.`filePath`, `sdoc`.`isFavorite`, `sdoc`.`isLock`, `sdoc`.`isSaving`, `sdoc`.`reminderTriggerTime`, `sdoc`.`reminderRequestCode`, `sdoc`.`recycle_bin_time_moved`, `sdoc`.`contentSecureVersion`, `sdoc`.`size`, `sdoc`.`displayTitle`, `sdoc`.`saveType`, `sdoc`.`firstOpendAt`, `sdoc`.`secondOpenedAt`, `sdoc`.`lastOpenedAt`, `sdoc`.`importedAt`, `sdoc`.`recommendedAt`, `sdoc`.`lastMappedAt`, `sdoc`.`mdeSpaceId`, `sdoc`.`mdeItemId`, `sdoc`.`mdeExtra`, `sdoc`.`mdeGroupId`, `sdoc`.`mdeOwnerId`, `sdoc`.`firstHandwritingHeight`, `sdoc`.`deleteRecommended`, `sdoc`.`absolutePath`, `sdoc`.`backgroundColor`, `sdoc`.`backgroundColorInverted`, `sdoc`.`lockAccountGuid`, `sdoc`.`corrupted`, `sdoc`.`pageMode` FROM sdoc LEFT OUTER JOIN mapped_document AS map ON sdoc.UUID = map.UUID WHERE sdoc.isDeleted != 1 AND sdoc.mdeSpaceId='' AND isLock != 1 AND map.UUID IS NULL AND sdoc.UUID NOT LIKE '%_GEN%'", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public String getPath(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT filePath FROM sdoc WHERE UUID=?", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<String> getPathList(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT filePath FROM sdoc WHERE isDeleted=?", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<String> getRestoredUuidsByCategory(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM sdoc WHERE categoryUUID=? AND isDeleted=2", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<NotesDocumentEntity> getSaveFailedEntities(int i) throws Throwable {
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
        int i2;
        String string;
        int i4;
        String string2;
        String string3;
        byte[] blob;
        int i5;
        String string4;
        Integer numValueOf;
        Integer numValueOf2;
        String string5;
        Float fValueOf;
        String string6;
        String string7;
        int i6;
        String string8;
        String string9;
        String string10;
        String string11;
        String string12;
        String string13;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `sdoc`.* FROM sdoc WHERE sdoc.isDeleted != 1 AND sdoc.isSaving != 0 AND sdoc.isSaving != ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accountType");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accountName");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strippedContent");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CATEGORY_SERVER_TIMESTAMP);
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CATEGORY_IS_DIRTY);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.NOTENAME);
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_SYNC_ACCOUNT_ID);
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_SYNC_DOCUMENT_UUID);
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_LAST_SYNC_TIME);
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MATH_MODE);
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDeleted");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.RECOMMENDED_TITLE);
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayContent");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.VR_UUID);
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CONTENT_UUID);
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstContentType");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "secondContentType");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strokeUUID");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strokeRatio");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryUUID");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filePath");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFavorite");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLock");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSaving");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reminderTriggerTime");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reminderRequestCode");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recycle_bin_time_moved");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "contentSecureVersion");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayTitle");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "saveType");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstOpendAt");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "secondOpenedAt");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastOpenedAt");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "importedAt");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recommendedAt");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.LAST_MAPPED_AT);
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeSpaceId");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeItemId");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeExtra");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeGroupId");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeOwnerId");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstHandwritingHeight");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deleteRecommended");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.ABSOLUTE_PATH);
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backgroundColor");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.BACKGROUND_COLOR_INVERTED);
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.LOCK_ACCOUNT_GUID);
            int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CORRUPTED);
            int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.PAGE_MODE);
            int i7 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesDocumentEntity notesDocumentEntity = new NotesDocumentEntity();
                if (cursorQuery.isNull(columnIndexOrThrow)) {
                    i2 = columnIndexOrThrow;
                    string = null;
                } else {
                    i2 = columnIndexOrThrow;
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                notesDocumentEntity.setAccountType(string);
                notesDocumentEntity.setAccountName(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                notesDocumentEntity.setStrippedContent(NotesDataConverter.byteToString(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getBlob(columnIndexOrThrow3)));
                notesDocumentEntity.setServerTimestamp(cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4)));
                notesDocumentEntity.setCategoryServerTimeStamp(cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)));
                notesDocumentEntity.setCategoryIsDirty(cursorQuery.getInt(columnIndexOrThrow6));
                notesDocumentEntity.setNoteName(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                notesDocumentEntity.setMsSyncAccountId(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                notesDocumentEntity.setMsSyncDocumentUuid(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                int i8 = columnIndexOrThrow2;
                int i9 = columnIndexOrThrow3;
                notesDocumentEntity.setMsLastSyncTime(cursorQuery.getLong(columnIndexOrThrow10));
                notesDocumentEntity.setMathMode(cursorQuery.getInt(columnIndexOrThrow11));
                notesDocumentEntity.setId(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                notesDocumentEntity.setUuid(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i10 = i7;
                notesDocumentEntity.setIsDeleted(cursorQuery.getInt(i10));
                int i11 = columnIndexOrThrow15;
                notesDocumentEntity.setIsDirty(cursorQuery.getInt(i11));
                int i12 = columnIndexOrThrow16;
                if (cursorQuery.isNull(i12)) {
                    i4 = i12;
                    string2 = null;
                } else {
                    i4 = i12;
                    string2 = cursorQuery.getString(i12);
                }
                notesDocumentEntity.setTitle(string2);
                int i13 = columnIndexOrThrow17;
                if (cursorQuery.isNull(i13)) {
                    columnIndexOrThrow17 = i13;
                    string3 = null;
                } else {
                    columnIndexOrThrow17 = i13;
                    string3 = cursorQuery.getString(i13);
                }
                notesDocumentEntity.setRecommendedTitle(string3);
                int i14 = columnIndexOrThrow18;
                columnIndexOrThrow18 = i14;
                notesDocumentEntity.setContent(NotesDataConverter.byteToString(cursorQuery.isNull(i14) ? null : cursorQuery.getBlob(i14)));
                int i15 = columnIndexOrThrow19;
                if (cursorQuery.isNull(i15)) {
                    columnIndexOrThrow19 = i15;
                    blob = null;
                } else {
                    columnIndexOrThrow19 = i15;
                    blob = cursorQuery.getBlob(i15);
                }
                notesDocumentEntity.setDisplayContent(blob);
                int i16 = columnIndexOrThrow13;
                int i17 = columnIndexOrThrow20;
                notesDocumentEntity.setCreatedAt(cursorQuery.getLong(i17));
                int i18 = columnIndexOrThrow21;
                notesDocumentEntity.setLastModifiedAt(cursorQuery.getLong(i18));
                int i19 = columnIndexOrThrow22;
                notesDocumentEntity.setVrUuid(cursorQuery.isNull(i19) ? null : cursorQuery.getString(i19));
                int i20 = columnIndexOrThrow23;
                if (cursorQuery.isNull(i20)) {
                    i5 = i17;
                    string4 = null;
                } else {
                    i5 = i17;
                    string4 = cursorQuery.getString(i20);
                }
                notesDocumentEntity.setContentUuid(string4);
                int i21 = columnIndexOrThrow24;
                if (cursorQuery.isNull(i21)) {
                    columnIndexOrThrow24 = i21;
                    numValueOf = null;
                } else {
                    columnIndexOrThrow24 = i21;
                    numValueOf = Integer.valueOf(cursorQuery.getInt(i21));
                }
                notesDocumentEntity.setFirstContentType(numValueOf);
                int i22 = columnIndexOrThrow25;
                if (cursorQuery.isNull(i22)) {
                    columnIndexOrThrow25 = i22;
                    numValueOf2 = null;
                } else {
                    columnIndexOrThrow25 = i22;
                    numValueOf2 = Integer.valueOf(cursorQuery.getInt(i22));
                }
                notesDocumentEntity.setSecondContentType(numValueOf2);
                int i23 = columnIndexOrThrow26;
                if (cursorQuery.isNull(i23)) {
                    columnIndexOrThrow26 = i23;
                    string5 = null;
                } else {
                    columnIndexOrThrow26 = i23;
                    string5 = cursorQuery.getString(i23);
                }
                notesDocumentEntity.setStrokeUuid(string5);
                int i24 = columnIndexOrThrow27;
                if (cursorQuery.isNull(i24)) {
                    columnIndexOrThrow27 = i24;
                    fValueOf = null;
                } else {
                    columnIndexOrThrow27 = i24;
                    fValueOf = Float.valueOf(cursorQuery.getFloat(i24));
                }
                notesDocumentEntity.setStrokeRatio(fValueOf);
                int i25 = columnIndexOrThrow28;
                if (cursorQuery.isNull(i25)) {
                    columnIndexOrThrow28 = i25;
                    string6 = null;
                } else {
                    columnIndexOrThrow28 = i25;
                    string6 = cursorQuery.getString(i25);
                }
                notesDocumentEntity.setCategoryUuid(string6);
                int i26 = columnIndexOrThrow29;
                if (cursorQuery.isNull(i26)) {
                    columnIndexOrThrow29 = i26;
                    string7 = null;
                } else {
                    columnIndexOrThrow29 = i26;
                    string7 = cursorQuery.getString(i26);
                }
                notesDocumentEntity.setFilePath(string7);
                int i27 = columnIndexOrThrow30;
                notesDocumentEntity.setIsFavorite(cursorQuery.getInt(i27));
                columnIndexOrThrow30 = i27;
                int i28 = columnIndexOrThrow31;
                notesDocumentEntity.setIsLock(cursorQuery.getInt(i28));
                columnIndexOrThrow31 = i28;
                int i29 = columnIndexOrThrow32;
                notesDocumentEntity.setIsSavingByWhichPid(cursorQuery.getInt(i29));
                int i30 = columnIndexOrThrow33;
                notesDocumentEntity.setReminderTriggerTime(cursorQuery.getLong(i30));
                int i31 = columnIndexOrThrow34;
                notesDocumentEntity.setReminderRequestCode(cursorQuery.getInt(i31));
                int i32 = columnIndexOrThrow35;
                notesDocumentEntity.setRecycleBinTimeMoved(cursorQuery.getLong(i32));
                int i33 = columnIndexOrThrow36;
                notesDocumentEntity.setContentSecureVersion(cursorQuery.getInt(i33));
                int i34 = columnIndexOrThrow4;
                int i35 = columnIndexOrThrow37;
                notesDocumentEntity.setSize(cursorQuery.getLong(i35));
                int i36 = columnIndexOrThrow38;
                notesDocumentEntity.setDisplayTitle(cursorQuery.isNull(i36) ? null : cursorQuery.getBlob(i36));
                int i37 = columnIndexOrThrow39;
                notesDocumentEntity.setSaveType(cursorQuery.getInt(i37));
                int i38 = columnIndexOrThrow40;
                notesDocumentEntity.setFirstOpendAt(cursorQuery.getLong(i38));
                int i39 = columnIndexOrThrow41;
                notesDocumentEntity.setSecondOpenedAt(cursorQuery.getLong(i39));
                int i40 = columnIndexOrThrow42;
                notesDocumentEntity.setLastOpenedAt(cursorQuery.getLong(i40));
                int i41 = columnIndexOrThrow43;
                notesDocumentEntity.setImportedAt(cursorQuery.getLong(i41));
                int i42 = columnIndexOrThrow44;
                notesDocumentEntity.setRecommendedAt(cursorQuery.getLong(i42));
                int i43 = columnIndexOrThrow45;
                notesDocumentEntity.setLastMappedAt(cursorQuery.getLong(i43));
                int i44 = columnIndexOrThrow46;
                notesDocumentEntity.setMdeSpaceId(cursorQuery.isNull(i44) ? null : cursorQuery.getString(i44));
                int i45 = columnIndexOrThrow47;
                if (cursorQuery.isNull(i45)) {
                    i6 = i38;
                    string8 = null;
                } else {
                    i6 = i38;
                    string8 = cursorQuery.getString(i45);
                }
                notesDocumentEntity.setMdeItemId(string8);
                int i46 = columnIndexOrThrow48;
                if (cursorQuery.isNull(i46)) {
                    columnIndexOrThrow48 = i46;
                    string9 = null;
                } else {
                    columnIndexOrThrow48 = i46;
                    string9 = cursorQuery.getString(i46);
                }
                notesDocumentEntity.setMdeExtra(string9);
                int i47 = columnIndexOrThrow49;
                if (cursorQuery.isNull(i47)) {
                    columnIndexOrThrow49 = i47;
                    string10 = null;
                } else {
                    columnIndexOrThrow49 = i47;
                    string10 = cursorQuery.getString(i47);
                }
                notesDocumentEntity.setMdeGroupId(string10);
                int i48 = columnIndexOrThrow50;
                if (cursorQuery.isNull(i48)) {
                    columnIndexOrThrow50 = i48;
                    string11 = null;
                } else {
                    columnIndexOrThrow50 = i48;
                    string11 = cursorQuery.getString(i48);
                }
                notesDocumentEntity.setMdeOwnerId(string11);
                int i49 = columnIndexOrThrow51;
                notesDocumentEntity.setFirstHandwritingHeight(cursorQuery.getInt(i49));
                columnIndexOrThrow51 = i49;
                int i50 = columnIndexOrThrow52;
                notesDocumentEntity.setDeleteRecommended(cursorQuery.getInt(i50));
                int i51 = columnIndexOrThrow53;
                if (cursorQuery.isNull(i51)) {
                    columnIndexOrThrow53 = i51;
                    string12 = null;
                } else {
                    columnIndexOrThrow53 = i51;
                    string12 = cursorQuery.getString(i51);
                }
                notesDocumentEntity.setAbsolutePath(string12);
                columnIndexOrThrow52 = i50;
                int i52 = columnIndexOrThrow54;
                notesDocumentEntity.setBackgroundColor(cursorQuery.getInt(i52));
                columnIndexOrThrow54 = i52;
                int i53 = columnIndexOrThrow55;
                notesDocumentEntity.setBackgroundColorInverted(cursorQuery.getInt(i53));
                int i54 = columnIndexOrThrow56;
                if (cursorQuery.isNull(i54)) {
                    columnIndexOrThrow56 = i54;
                    string13 = null;
                } else {
                    columnIndexOrThrow56 = i54;
                    string13 = cursorQuery.getString(i54);
                }
                notesDocumentEntity.setLockAccountGuid(string13);
                columnIndexOrThrow55 = i53;
                int i55 = columnIndexOrThrow57;
                notesDocumentEntity.setCorrupted(cursorQuery.getInt(i55));
                columnIndexOrThrow57 = i55;
                int i56 = columnIndexOrThrow58;
                notesDocumentEntity.setPageMode(cursorQuery.getInt(i56));
                arrayList.add(notesDocumentEntity);
                columnIndexOrThrow45 = i43;
                columnIndexOrThrow2 = i8;
                columnIndexOrThrow15 = i11;
                columnIndexOrThrow21 = i18;
                columnIndexOrThrow22 = i19;
                columnIndexOrThrow32 = i29;
                columnIndexOrThrow38 = i36;
                columnIndexOrThrow41 = i39;
                columnIndexOrThrow58 = i56;
                columnIndexOrThrow13 = i16;
                columnIndexOrThrow16 = i4;
                columnIndexOrThrow = i2;
                i7 = i10;
                columnIndexOrThrow20 = i5;
                columnIndexOrThrow23 = i20;
                columnIndexOrThrow33 = i30;
                columnIndexOrThrow34 = i31;
                columnIndexOrThrow35 = i32;
                columnIndexOrThrow37 = i35;
                columnIndexOrThrow40 = i6;
                columnIndexOrThrow47 = i45;
                columnIndexOrThrow4 = i34;
                columnIndexOrThrow36 = i33;
                columnIndexOrThrow39 = i37;
                columnIndexOrThrow42 = i40;
                columnIndexOrThrow43 = i41;
                columnIndexOrThrow44 = i42;
                columnIndexOrThrow46 = i44;
                columnIndexOrThrow3 = i9;
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public Long getServerTimeStamp(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT serverTimestamp FROM sdoc WHERE UUID=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Long lValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                lValueOf = Long.valueOf(cursorQuery.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public byte[] getStrippedContent(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT strippedContent FROM text_search WHERE sdocUUID=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        byte[] blob = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                blob = cursorQuery.getBlob(0);
            }
            return blob;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<String> getUnlockedNormalNotes(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            List<String> unlockedNormalNotes = super.getUnlockedNormalNotes(collection);
            this.__db.setTransactionSuccessful();
            return unlockedNormalNotes;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<String> getUnlockedNormalUuids(Collection<String> collection) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), AbstractC11014a.m12317b(sbNewStringBuilder, "SELECT UUID FROM sdoc WHERE UUID IN (", collection, sbNewStringBuilder, ") AND sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND sdoc.mdeSpaceId=''"));
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<String> getUpdatableNotes(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            List<String> updatableNotes = super.getUpdatableNotes(collection);
            this.__db.setTransactionSuccessful();
            return updatableNotes;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<String> getUpdatableUuids(Collection<String> collection) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), AbstractC11014a.m12317b(sbNewStringBuilder, "SELECT UUID FROM sdoc WHERE UUID IN (", collection, sbNewStringBuilder, ") AND sdoc.filePath LIKE '%.sdocx' AND sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND sdoc.mdeSpaceId=''"));
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public String getUuid(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM sdoc WHERE filePath=?", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public LiveData<NotesDocumentEntity> get_LiveData(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `sdoc`.* FROM sdoc WHERE UUID=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"sdoc"}, false, new Callable<NotesDocumentEntity>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.20
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public NotesDocumentEntity call() {
                NotesDocumentEntity notesDocumentEntity;
                Cursor cursorQuery = DBUtil.query(NotesDocumentDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accountType");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accountName");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strippedContent");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "serverTimestamp");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CATEGORY_SERVER_TIMESTAMP);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CATEGORY_IS_DIRTY);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.NOTENAME);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_SYNC_ACCOUNT_ID);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_SYNC_DOCUMENT_UUID);
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MS_LAST_SYNC_TIME);
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.MATH_MODE);
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDeleted");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isDirty");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.RECOMMENDED_TITLE);
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayContent");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.VR_UUID);
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CONTENT_UUID);
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstContentType");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "secondContentType");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strokeUUID");
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strokeRatio");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "categoryUUID");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filePath");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFavorite");
                    int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLock");
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSaving");
                    int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reminderTriggerTime");
                    int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reminderRequestCode");
                    int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recycle_bin_time_moved");
                    int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "contentSecureVersion");
                    int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size");
                    int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayTitle");
                    int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "saveType");
                    int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstOpendAt");
                    int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "secondOpenedAt");
                    int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastOpenedAt");
                    int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "importedAt");
                    int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recommendedAt");
                    int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.LAST_MAPPED_AT);
                    int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeSpaceId");
                    int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeItemId");
                    int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeExtra");
                    int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeGroupId");
                    int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mdeOwnerId");
                    int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "firstHandwritingHeight");
                    int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deleteRecommended");
                    int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.ABSOLUTE_PATH);
                    int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backgroundColor");
                    int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.BACKGROUND_COLOR_INVERTED);
                    int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.LOCK_ACCOUNT_GUID);
                    int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.CORRUPTED);
                    int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.Document.PAGE_MODE);
                    if (cursorQuery.moveToFirst()) {
                        NotesDocumentEntity notesDocumentEntity2 = new NotesDocumentEntity();
                        notesDocumentEntity2.setAccountType(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                        notesDocumentEntity2.setAccountName(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        notesDocumentEntity2.setStrippedContent(NotesDataConverter.byteToString(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getBlob(columnIndexOrThrow3)));
                        notesDocumentEntity2.setServerTimestamp(cursorQuery.isNull(columnIndexOrThrow4) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow4)));
                        notesDocumentEntity2.setCategoryServerTimeStamp(cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)));
                        notesDocumentEntity2.setCategoryIsDirty(cursorQuery.getInt(columnIndexOrThrow6));
                        notesDocumentEntity2.setNoteName(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        notesDocumentEntity2.setMsSyncAccountId(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                        notesDocumentEntity2.setMsSyncDocumentUuid(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                        notesDocumentEntity2.setMsLastSyncTime(cursorQuery.getLong(columnIndexOrThrow10));
                        notesDocumentEntity2.setMathMode(cursorQuery.getInt(columnIndexOrThrow11));
                        notesDocumentEntity2.setId(cursorQuery.isNull(columnIndexOrThrow12) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow12)));
                        notesDocumentEntity2.setUuid(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                        notesDocumentEntity2.setIsDeleted(cursorQuery.getInt(columnIndexOrThrow14));
                        notesDocumentEntity2.setIsDirty(cursorQuery.getInt(columnIndexOrThrow15));
                        notesDocumentEntity2.setTitle(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                        notesDocumentEntity2.setRecommendedTitle(cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17));
                        notesDocumentEntity2.setContent(NotesDataConverter.byteToString(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getBlob(columnIndexOrThrow18)));
                        notesDocumentEntity2.setDisplayContent(cursorQuery.isNull(columnIndexOrThrow19) ? null : cursorQuery.getBlob(columnIndexOrThrow19));
                        notesDocumentEntity2.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow20));
                        notesDocumentEntity2.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow21));
                        notesDocumentEntity2.setVrUuid(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                        notesDocumentEntity2.setContentUuid(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                        notesDocumentEntity2.setFirstContentType(cursorQuery.isNull(columnIndexOrThrow24) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow24)));
                        notesDocumentEntity2.setSecondContentType(cursorQuery.isNull(columnIndexOrThrow25) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow25)));
                        notesDocumentEntity2.setStrokeUuid(cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26));
                        notesDocumentEntity2.setStrokeRatio(cursorQuery.isNull(columnIndexOrThrow27) ? null : Float.valueOf(cursorQuery.getFloat(columnIndexOrThrow27)));
                        notesDocumentEntity2.setCategoryUuid(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                        notesDocumentEntity2.setFilePath(cursorQuery.isNull(columnIndexOrThrow29) ? null : cursorQuery.getString(columnIndexOrThrow29));
                        notesDocumentEntity2.setIsFavorite(cursorQuery.getInt(columnIndexOrThrow30));
                        notesDocumentEntity2.setIsLock(cursorQuery.getInt(columnIndexOrThrow31));
                        notesDocumentEntity2.setIsSavingByWhichPid(cursorQuery.getInt(columnIndexOrThrow32));
                        notesDocumentEntity2.setReminderTriggerTime(cursorQuery.getLong(columnIndexOrThrow33));
                        notesDocumentEntity2.setReminderRequestCode(cursorQuery.getInt(columnIndexOrThrow34));
                        notesDocumentEntity2.setRecycleBinTimeMoved(cursorQuery.getLong(columnIndexOrThrow35));
                        notesDocumentEntity2.setContentSecureVersion(cursorQuery.getInt(columnIndexOrThrow36));
                        notesDocumentEntity2.setSize(cursorQuery.getLong(columnIndexOrThrow37));
                        notesDocumentEntity2.setDisplayTitle(cursorQuery.isNull(columnIndexOrThrow38) ? null : cursorQuery.getBlob(columnIndexOrThrow38));
                        notesDocumentEntity2.setSaveType(cursorQuery.getInt(columnIndexOrThrow39));
                        notesDocumentEntity2.setFirstOpendAt(cursorQuery.getLong(columnIndexOrThrow40));
                        notesDocumentEntity2.setSecondOpenedAt(cursorQuery.getLong(columnIndexOrThrow41));
                        notesDocumentEntity2.setLastOpenedAt(cursorQuery.getLong(columnIndexOrThrow42));
                        notesDocumentEntity2.setImportedAt(cursorQuery.getLong(columnIndexOrThrow43));
                        notesDocumentEntity2.setRecommendedAt(cursorQuery.getLong(columnIndexOrThrow44));
                        notesDocumentEntity2.setLastMappedAt(cursorQuery.getLong(columnIndexOrThrow45));
                        notesDocumentEntity2.setMdeSpaceId(cursorQuery.isNull(columnIndexOrThrow46) ? null : cursorQuery.getString(columnIndexOrThrow46));
                        notesDocumentEntity2.setMdeItemId(cursorQuery.isNull(columnIndexOrThrow47) ? null : cursorQuery.getString(columnIndexOrThrow47));
                        notesDocumentEntity2.setMdeExtra(cursorQuery.isNull(columnIndexOrThrow48) ? null : cursorQuery.getString(columnIndexOrThrow48));
                        notesDocumentEntity2.setMdeGroupId(cursorQuery.isNull(columnIndexOrThrow49) ? null : cursorQuery.getString(columnIndexOrThrow49));
                        notesDocumentEntity2.setMdeOwnerId(cursorQuery.isNull(columnIndexOrThrow50) ? null : cursorQuery.getString(columnIndexOrThrow50));
                        notesDocumentEntity2.setFirstHandwritingHeight(cursorQuery.getInt(columnIndexOrThrow51));
                        notesDocumentEntity2.setDeleteRecommended(cursorQuery.getInt(columnIndexOrThrow52));
                        notesDocumentEntity2.setAbsolutePath(cursorQuery.isNull(columnIndexOrThrow53) ? null : cursorQuery.getString(columnIndexOrThrow53));
                        notesDocumentEntity2.setBackgroundColor(cursorQuery.getInt(columnIndexOrThrow54));
                        notesDocumentEntity2.setBackgroundColorInverted(cursorQuery.getInt(columnIndexOrThrow55));
                        notesDocumentEntity2.setLockAccountGuid(cursorQuery.isNull(columnIndexOrThrow56) ? null : cursorQuery.getString(columnIndexOrThrow56));
                        notesDocumentEntity2.setCorrupted(cursorQuery.getInt(columnIndexOrThrow57));
                        notesDocumentEntity2.setPageMode(cursorQuery.getInt(columnIndexOrThrow58));
                        notesDocumentEntity = notesDocumentEntity2;
                    } else {
                        notesDocumentEntity = null;
                    }
                    return notesDocumentEntity;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void moveToRecycleBin(Collection<String> collection, long j, long j2, DocumentCategoryTree documentCategoryTree) throws Throwable {
        NotesDocumentDao_Impl notesDocumentDao_Impl;
        this.__db.beginTransaction();
        try {
            super.moveToRecycleBin(collection, j, j2, documentCategoryTree);
            notesDocumentDao_Impl = this;
            try {
                notesDocumentDao_Impl.__db.setTransactionSuccessful();
                notesDocumentDao_Impl.__db.endTransaction();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                notesDocumentDao_Impl.__db.endTransaction();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            notesDocumentDao_Impl = this;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void moveToRecycleBinByCategory(String str, long j, long j2, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfMoveToRecycleBinByCategory.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j);
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str2);
        }
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
            this.__preparedStmtOfMoveToRecycleBinByCategory.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void moveToRecycleBinByCategoryUuid(String str, long j, long j2, String str2) throws Throwable {
        NotesDocumentDao_Impl notesDocumentDao_Impl;
        this.__db.beginTransaction();
        try {
            super.moveToRecycleBinByCategoryUuid(str, j, j2, str2);
            notesDocumentDao_Impl = this;
            try {
                notesDocumentDao_Impl.__db.setTransactionSuccessful();
                notesDocumentDao_Impl.__db.endTransaction();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                notesDocumentDao_Impl.__db.endTransaction();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            notesDocumentDao_Impl = this;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public Cursor rawQueryForDocument(SupportSQLiteQuery supportSQLiteQuery) {
        return this.__db.query(supportSQLiteQuery);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void restoreByCategory(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfRestoreByCategory.acquire();
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
            this.__preparedStmtOfRestoreByCategory.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void restoreByCategoryUuid(String str, long j) {
        this.__db.beginTransaction();
        try {
            super.restoreByCategoryUuid(str, j);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void restoreByUuids(Context context, NotesCategoryTreeDao notesCategoryTreeDao, Collection<String> collection, long j) throws Throwable {
        NotesDocumentDao_Impl notesDocumentDao_Impl;
        this.__db.beginTransaction();
        try {
            super.restoreByUuids(context, notesCategoryTreeDao, collection, j);
            notesDocumentDao_Impl = this;
            try {
                notesDocumentDao_Impl.__db.setTransactionSuccessful();
                notesDocumentDao_Impl.__db.endTransaction();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                notesDocumentDao_Impl.__db.endTransaction();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            notesDocumentDao_Impl = this;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void setDisplayContent(String str, byte[] bArr) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSetDisplayContent.acquire();
        if (bArr == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindBlob(1, bArr);
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
            this.__preparedStmtOfSetDisplayContent.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void updateAccountGuidByUuid(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateAccountGuidByUuid.acquire();
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
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateAccountGuidByUuid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void updateCategory(Collection<String> collection, String str, long j) {
        this.__db.beginTransaction();
        try {
            super.updateCategory(collection, str, j);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void updateCategoryByCategoryUuid(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateCategoryByCategoryUuid.acquire();
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
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateCategoryByCategoryUuid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void updateCorrupted(String str, int i) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateCorrupted.acquire();
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
            this.__preparedStmtOfUpdateCorrupted.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void updateDocuments(Collection<String> collection, int i, String str, String str2, long j, long j2) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("UPDATE OR ABORT sdoc SET isDeleted=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" , categoryUUID=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        AbstractC2821a.m2207B(sbNewStringBuilder, " , recycle_bin_time_moved=", MsalUtils.QUERY_STRING_SYMBOL, " , absolutePath=", MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" , isDirty=1 , categoryisDirty=1 , categoryServerTimestamp=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" WHERE UUID IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, collection.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        supportSQLiteStatementCompileStatement.bindLong(1, i);
        if (str == null) {
            supportSQLiteStatementCompileStatement.bindNull(2);
        } else {
            supportSQLiteStatementCompileStatement.bindString(2, str);
        }
        supportSQLiteStatementCompileStatement.bindLong(3, j);
        if (str2 == null) {
            supportSQLiteStatementCompileStatement.bindNull(4);
        } else {
            supportSQLiteStatementCompileStatement.bindString(4, str2);
        }
        supportSQLiteStatementCompileStatement.bindLong(5, j2);
        int i2 = 6;
        for (String str3 : collection) {
            if (str3 == null) {
                supportSQLiteStatementCompileStatement.bindNull(i2);
            } else {
                supportSQLiteStatementCompileStatement.bindString(i2, str3);
            }
            i2++;
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public int updateFavorite(String str, boolean z, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateFavorite.acquire();
        supportSQLiteStatementAcquire.bindLong(1, z ? 1L : 0L);
        supportSQLiteStatementAcquire.bindLong(2, j);
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
            this.__preparedStmtOfUpdateFavorite.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void updateFavorites(Collection<String> collection, boolean z, long j) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("UPDATE OR ABORT sdoc SET isFavorite=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" , isDirty=1 , serverTimestamp=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" WHERE UUID IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, collection.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        supportSQLiteStatementCompileStatement.bindLong(1, z ? 1L : 0L);
        supportSQLiteStatementCompileStatement.bindLong(2, j);
        int i = 3;
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void updateLastMappedAt(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateLastMappedAt.acquire();
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
            this.__preparedStmtOfUpdateLastMappedAt.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void updateOpenedTime(String str, long j, long j2, long j3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateOpenedTime.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j);
        supportSQLiteStatementAcquire.bindLong(2, j2);
        supportSQLiteStatementAcquire.bindLong(3, j3);
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
            this.__preparedStmtOfUpdateOpenedTime.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public int updateRecommendedTitle(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateRecommendedTitle.acquire();
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
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateRecommendedTitle.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void updateRecycleBinTimeMoved(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateRecycleBinTimeMoved.acquire();
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
            this.__preparedStmtOfUpdateRecycleBinTimeMoved.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void updateSaving(String str, int i, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateSaving.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i);
        supportSQLiteStatementAcquire.bindLong(2, j);
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
            this.__preparedStmtOfUpdateSaving.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void updateStrippedContents(String str, String str2, String str3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateStrippedContents.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        if (str3 == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str3);
        }
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, str2);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeInsert();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateStrippedContents.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public int updateTitle(String str, String str2, byte[] bArr) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateTitle.acquire();
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str2);
        }
        if (bArr == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindBlob(2, bArr);
        }
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
            this.__preparedStmtOfUpdateTitle.release(supportSQLiteStatementAcquire);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao, com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(NotesDocumentEntity notesDocumentEntity) {
        this.__db.beginTransaction();
        try {
            int iDelete = super.delete(notesDocumentEntity);
            this.__db.setTransactionSuccessful();
            return iDelete;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(NotesDocumentEntity notesDocumentEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfNotesDocumentEntity.insert(notesDocumentEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(NotesDocumentEntity notesDocumentEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(notesDocumentEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public LiveData<List<NotesDocumentCountEntry>> getAllDocumentCountEntry_LiveData(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT category_tree.UUID, category_tree.parentUUID, category_tree.displayName, category_tree.displayNameColor, category_tree.isDeleted,  category_tree.createdAt, category_tree.lastModifiedAt, category_tree.recycle_bin_time_moved, category_tree.orderBy, (SELECT COUNT(*) FROM sdoc AS doc LEFT OUTER JOIN mapped_document AS map ON doc.UUID = map.UUID WHERE doc.categoryUUID=category_tree.UUID AND doc.isDeleted IS NOT 1 AND map.UUID IS NULL) AS documentCount FROM category_tree WHERE category_tree.parentUUID=? ORDER BY category_tree.orderBy ASC", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"sdoc", DBSchema.MappedDocument.TABLE_NAME, DBSchema.CategoryTree.TABLE_NAME}, false, new Callable<List<NotesDocumentCountEntry>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDocumentDao_Impl.22
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<NotesDocumentCountEntry> call() {
                Cursor cursorQuery = DBUtil.query(NotesDocumentDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        NotesDocumentCountEntry notesDocumentCountEntry = new NotesDocumentCountEntry();
                        notesDocumentCountEntry.setCategoryUuid(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                        notesDocumentCountEntry.setParentUuid(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                        notesDocumentCountEntry.setDisplayName(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                        notesDocumentCountEntry.setDisplayNameColor(cursorQuery.getInt(3));
                        notesDocumentCountEntry.setIsDeleted(cursorQuery.getInt(4));
                        notesDocumentCountEntry.setCreatedAt(cursorQuery.getLong(5));
                        notesDocumentCountEntry.setLastModifiedAt(cursorQuery.getLong(6));
                        notesDocumentCountEntry.setRecycleBinTimeMoved(cursorQuery.getLong(7));
                        notesDocumentCountEntry.setReorder(cursorQuery.isNull(8) ? null : Integer.valueOf(cursorQuery.getInt(8)));
                        notesDocumentCountEntry.setDocumentCount(cursorQuery.getInt(9));
                        arrayList.add(notesDocumentCountEntry);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public int deleteByCategoryUuid(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteByCategoryUuid.acquire();
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
            this.__preparedStmtOfDeleteByCategoryUuid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void deleteByUuid(Collection<String> collection, long j) {
        this.__db.beginTransaction();
        try {
            super.deleteByUuid(collection, j);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public void updateCategory(String str, Collection<String> collection, long j) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("UPDATE OR ABORT sdoc SET categoryUUID=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" , categoryserverTimestamp=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" , categoryisDirty=1 , isDirty=1 WHERE UUID IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, collection.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        if (str == null) {
            supportSQLiteStatementCompileStatement.bindNull(1);
        } else {
            supportSQLiteStatementCompileStatement.bindString(1, str);
        }
        supportSQLiteStatementCompileStatement.bindLong(2, j);
        int i = 3;
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
    public void upsert(Collection<? extends NotesDocumentEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public int update(Collection<NotesDocumentEntity> collection) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__updateAdapterOfNotesDocumentEntity.handleMultiple(collection);
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<String> getCorruptedUuid(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM sdoc WHERE corrupted=?", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao
    public List<DocumentData> getDocumentData(Collection<String> collection) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), AbstractC11014a.m12317b(sbNewStringBuilder, "SELECT _id, UUID, categoryUUID, filePath, contentUUID, strokeUUID FROM sdoc WHERE UUID IN (", collection, sbNewStringBuilder, ")"));
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
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                DocumentData documentData = new DocumentData();
                documentData.setId(cursorQuery.isNull(0) ? null : Long.valueOf(cursorQuery.getLong(0)));
                documentData.setUuid(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                documentData.setCategoryUuid(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                documentData.setFilePath(cursorQuery.isNull(3) ? null : cursorQuery.getString(3));
                documentData.setContentUuid(cursorQuery.isNull(4) ? null : cursorQuery.getString(4));
                documentData.setStrokeUuid(cursorQuery.isNull(5) ? null : cursorQuery.getString(5));
                arrayList.add(documentData);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }
}
