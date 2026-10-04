package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentData;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.NotesDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentTextSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesRetryEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesStrokeSearchEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesDebugDao_Impl extends NotesDebugDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<NotesDocumentEntity> __insertionAdapterOfNotesDocumentEntity;
    private final EntityInsertionAdapter<NotesRetryEntity> __insertionAdapterOfNotesRetryEntity;
    private final EntityInsertionAdapter<NotesStrokeSearchEntity> __insertionAdapterOfNotesStrokeSearchEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllDocuments;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllRetry;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllStrokes;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllTextSearch;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDocuments;
    private final SharedSQLiteStatement __preparedStmtOfDeleteStrokes;
    private final SharedSQLiteStatement __preparedStmtOfUpdateTextSearchEntity;
    private final EntityDeletionOrUpdateAdapter<NotesDocumentEntity> __updateAdapterOfNotesDocumentEntity;

    public NotesDebugDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNotesDocumentEntity = new EntityInsertionAdapter<NotesDocumentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDebugDao_Impl.1
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
        this.__insertionAdapterOfNotesRetryEntity = new EntityInsertionAdapter<NotesRetryEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDebugDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `retry` (`_id`,`sdocUUID`,`strokeFilePath`,`state`,`recognitionCount`,`lastModifiedAt`,`version`) VALUES (?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesRetryEntity notesRetryEntity) {
                if (notesRetryEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesRetryEntity.getId().longValue());
                }
                if (notesRetryEntity.getDocUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesRetryEntity.getDocUuid());
                }
                if (notesRetryEntity.getStrokeFilePath() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesRetryEntity.getStrokeFilePath());
                }
                supportSQLiteStatement.bindLong(4, notesRetryEntity.getState());
                supportSQLiteStatement.bindLong(5, notesRetryEntity.getRecognitionCount());
                supportSQLiteStatement.bindLong(6, notesRetryEntity.getLastModifiedAt());
                supportSQLiteStatement.bindLong(7, notesRetryEntity.getVersion());
            }
        };
        this.__insertionAdapterOfNotesStrokeSearchEntity = new EntityInsertionAdapter<NotesStrokeSearchEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDebugDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `stroke` (`_id`,`hasVisualCue`,`text`,`left`,`top`,`right`,`bottom`,`filePath`,`sdocUUID`,`pageWidth`,`type`,`pageUuid`,`actionLinkData`,`recognizerDBVersion`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesStrokeSearchEntity notesStrokeSearchEntity) {
                if (notesStrokeSearchEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesStrokeSearchEntity.getId().longValue());
                }
                if (notesStrokeSearchEntity.getHasVisualCue() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindLong(2, notesStrokeSearchEntity.getHasVisualCue().intValue());
                }
                if (notesStrokeSearchEntity.getText() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesStrokeSearchEntity.getText());
                }
                if (notesStrokeSearchEntity.getLeft() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindLong(4, notesStrokeSearchEntity.getLeft().intValue());
                }
                if (notesStrokeSearchEntity.getTop() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, notesStrokeSearchEntity.getTop().intValue());
                }
                if (notesStrokeSearchEntity.getRight() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindLong(6, notesStrokeSearchEntity.getRight().intValue());
                }
                if (notesStrokeSearchEntity.getBottom() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, notesStrokeSearchEntity.getBottom().intValue());
                }
                if (notesStrokeSearchEntity.getFilePath() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, notesStrokeSearchEntity.getFilePath());
                }
                if (notesStrokeSearchEntity.getDocUuid() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, notesStrokeSearchEntity.getDocUuid());
                }
                if (notesStrokeSearchEntity.getPageWidth() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindLong(10, notesStrokeSearchEntity.getPageWidth().intValue());
                }
                supportSQLiteStatement.bindLong(11, notesStrokeSearchEntity.getType());
                if (notesStrokeSearchEntity.getPageUuid() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, notesStrokeSearchEntity.getPageUuid());
                }
                if (notesStrokeSearchEntity.getActionLinkData() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, notesStrokeSearchEntity.getActionLinkData());
                }
                if (notesStrokeSearchEntity.getRecognizerDBVersion() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, notesStrokeSearchEntity.getRecognizerDBVersion());
                }
            }
        };
        this.__updateAdapterOfNotesDocumentEntity = new EntityDeletionOrUpdateAdapter<NotesDocumentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDebugDao_Impl.4
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR IGNORE `sdoc` SET `accountType` = ?,`accountName` = ?,`strippedContent` = ?,`serverTimestamp` = ?,`categoryserverTimestamp` = ?,`categoryisDirty` = ?,`noteName` = ?,`msSyncAccountId` = ?,`msSyncDocumentUuid` = ?,`msLastSyncTime` = ?,`mathMode` = ?,`_id` = ?,`UUID` = ?,`isDeleted` = ?,`isDirty` = ?,`title` = ?,`recommendedTitle` = ?,`content` = ?,`displayContent` = ?,`createdAt` = ?,`lastModifiedAt` = ?,`vrUUID` = ?,`contentUUID` = ?,`firstContentType` = ?,`secondContentType` = ?,`strokeUUID` = ?,`strokeRatio` = ?,`categoryUUID` = ?,`filePath` = ?,`isFavorite` = ?,`isLock` = ?,`isSaving` = ?,`reminderTriggerTime` = ?,`reminderRequestCode` = ?,`recycle_bin_time_moved` = ?,`contentSecureVersion` = ?,`size` = ?,`displayTitle` = ?,`saveType` = ?,`firstOpendAt` = ?,`secondOpenedAt` = ?,`lastOpenedAt` = ?,`importedAt` = ?,`recommendedAt` = ?,`lastMappedAt` = ?,`mdeSpaceId` = ?,`mdeItemId` = ?,`mdeExtra` = ?,`mdeGroupId` = ?,`mdeOwnerId` = ?,`firstHandwritingHeight` = ?,`deleteRecommended` = ?,`absolutePath` = ?,`backgroundColor` = ?,`backgroundColorInverted` = ?,`lockAccountGuid` = ?,`corrupted` = ?,`pageMode` = ? WHERE `_id` = ?";
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
        this.__preparedStmtOfDeleteDocuments = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDebugDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM sdoc WHERE UUID!=? AND filePath=?";
            }
        };
        this.__preparedStmtOfUpdateTextSearchEntity = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDebugDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO text_search (sdocUUID, strippedContent, filePath) VALUES (?, ?, ?)";
            }
        };
        this.__preparedStmtOfDeleteStrokes = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDebugDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM stroke WHERE sdocUUID=?";
            }
        };
        this.__preparedStmtOfDeleteAllDocuments = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDebugDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM sdoc";
            }
        };
        this.__preparedStmtOfDeleteAllTextSearch = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDebugDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM text_search";
            }
        };
        this.__preparedStmtOfDeleteAllStrokes = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDebugDao_Impl.10
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM stroke";
            }
        };
        this.__preparedStmtOfDeleteAllRetry = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesDebugDao_Impl.11
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM retry";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public void deleteAll() {
        this.__db.beginTransaction();
        try {
            super.deleteAll();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public void deleteAllDocuments() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteAllDocuments.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllDocuments.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public void deleteAllRetry() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteAllRetry.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllRetry.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public void deleteAllStrokes() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteAllStrokes.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllStrokes.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public void deleteAllTextSearch() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteAllTextSearch.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllTextSearch.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public void deleteDocuments(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteDocuments.acquire();
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
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteDocuments.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public void deleteNotes(List<String> list) {
        this.__db.beginTransaction();
        try {
            super.deleteNotes(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public void deleteNotesInChunk(Collection<String> collection) {
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, AbstractC11014a.m12324i(this.__db, "DELETE FROM sdoc WHERE UUID IN ("), ")"));
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public void deleteRetryInChunk(Collection<String> collection) {
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, AbstractC11014a.m12324i(this.__db, "DELETE FROM retry WHERE sdocUUID IN ("), ")"));
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public void deleteStrokes(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteStrokes.acquire();
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
            this.__preparedStmtOfDeleteStrokes.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public void deleteStrokesInChunk(Collection<String> collection) {
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, AbstractC11014a.m12324i(this.__db, "DELETE FROM stroke WHERE sdocUUID IN ("), ")"));
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public void deleteTextSearchInChunk(Collection<String> collection) {
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, AbstractC11014a.m12324i(this.__db, "DELETE FROM text_search WHERE sdocUUID IN ("), ")"));
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public List<NotesDocumentEntity> dumpDocumentTable() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `sdoc`.`accountType` AS `accountType`, `sdoc`.`accountName` AS `accountName`, `sdoc`.`strippedContent` AS `strippedContent`, `sdoc`.`serverTimestamp` AS `serverTimestamp`, `sdoc`.`categoryserverTimestamp` AS `categoryserverTimestamp`, `sdoc`.`categoryisDirty` AS `categoryisDirty`, `sdoc`.`noteName` AS `noteName`, `sdoc`.`msSyncAccountId` AS `msSyncAccountId`, `sdoc`.`msSyncDocumentUuid` AS `msSyncDocumentUuid`, `sdoc`.`msLastSyncTime` AS `msLastSyncTime`, `sdoc`.`mathMode` AS `mathMode`, `sdoc`.`_id` AS `_id`, `sdoc`.`UUID` AS `UUID`, `sdoc`.`isDeleted` AS `isDeleted`, `sdoc`.`isDirty` AS `isDirty`, `sdoc`.`title` AS `title`, `sdoc`.`recommendedTitle` AS `recommendedTitle`, `sdoc`.`content` AS `content`, `sdoc`.`displayContent` AS `displayContent`, `sdoc`.`createdAt` AS `createdAt`, `sdoc`.`lastModifiedAt` AS `lastModifiedAt`, `sdoc`.`vrUUID` AS `vrUUID`, `sdoc`.`contentUUID` AS `contentUUID`, `sdoc`.`firstContentType` AS `firstContentType`, `sdoc`.`secondContentType` AS `secondContentType`, `sdoc`.`strokeUUID` AS `strokeUUID`, `sdoc`.`strokeRatio` AS `strokeRatio`, `sdoc`.`categoryUUID` AS `categoryUUID`, `sdoc`.`filePath` AS `filePath`, `sdoc`.`isFavorite` AS `isFavorite`, `sdoc`.`isLock` AS `isLock`, `sdoc`.`isSaving` AS `isSaving`, `sdoc`.`reminderTriggerTime` AS `reminderTriggerTime`, `sdoc`.`reminderRequestCode` AS `reminderRequestCode`, `sdoc`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `sdoc`.`contentSecureVersion` AS `contentSecureVersion`, `sdoc`.`size` AS `size`, `sdoc`.`displayTitle` AS `displayTitle`, `sdoc`.`saveType` AS `saveType`, `sdoc`.`firstOpendAt` AS `firstOpendAt`, `sdoc`.`secondOpenedAt` AS `secondOpenedAt`, `sdoc`.`lastOpenedAt` AS `lastOpenedAt`, `sdoc`.`importedAt` AS `importedAt`, `sdoc`.`recommendedAt` AS `recommendedAt`, `sdoc`.`lastMappedAt` AS `lastMappedAt`, `sdoc`.`mdeSpaceId` AS `mdeSpaceId`, `sdoc`.`mdeItemId` AS `mdeItemId`, `sdoc`.`mdeExtra` AS `mdeExtra`, `sdoc`.`mdeGroupId` AS `mdeGroupId`, `sdoc`.`mdeOwnerId` AS `mdeOwnerId`, `sdoc`.`firstHandwritingHeight` AS `firstHandwritingHeight`, `sdoc`.`deleteRecommended` AS `deleteRecommended`, `sdoc`.`absolutePath` AS `absolutePath`, `sdoc`.`backgroundColor` AS `backgroundColor`, `sdoc`.`backgroundColorInverted` AS `backgroundColorInverted`, `sdoc`.`lockAccountGuid` AS `lockAccountGuid`, `sdoc`.`corrupted` AS `corrupted`, `sdoc`.`pageMode` AS `pageMode` FROM sdoc", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public List<DocumentData> dumpDocumentsForUsed() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT _id, UUID, categoryUUID, filePath, contentUUID, strokeUUID FROM sdoc WHERE isDeleted != 1", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public boolean existDirtyRows() {
        boolean z = false;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) > 1 AS count FROM sdoc GROUP BY filePath ORDER BY count DESC LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                if (cursorQuery.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public List<DocumentData> findRecentlyUsed(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT _id, UUID, categoryUUID, filePath, contentUUID, strokeUUID FROM sdoc WHERE filePath=? ORDER BY lastModifiedAt DESC, isDeleted ASC", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public List<NotesCategoryTreeEntity> getAllCategoryEntities() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `tree`.`UUID`, `tree`.`parentUUID`, `tree`.`isDeleted`, `tree`.`isDirty`, `tree`.`createdAt`, `tree`.`lastModifiedAt`, `tree`.`serverTimestamp`, `tree`.`recycle_bin_time_moved`, `tree`.`displayName`, `tree`.`path`, `tree`.`orderBy`, `tree`.`displayNameColor`, `tree`.`isSyncWithMS` FROM category_tree AS tree GROUP BY tree.UUID", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public void insert(NotesDocumentEntity notesDocumentEntity, NotesDocumentTextSearchEntity notesDocumentTextSearchEntity, List<NotesStrokeSearchEntity> list, NotesRetryEntity notesRetryEntity) {
        this.__db.beginTransaction();
        try {
            super.insert(notesDocumentEntity, notesDocumentTextSearchEntity, list, notesRetryEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public void insertDocumentEntity(NotesDocumentEntity notesDocumentEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfNotesDocumentEntity.insert(notesDocumentEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public void insertRetryEntity(NotesRetryEntity notesRetryEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfNotesRetryEntity.insert(notesRetryEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public void insertStrokeEntity(NotesStrokeSearchEntity notesStrokeSearchEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfNotesStrokeSearchEntity.insert(notesStrokeSearchEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public int update(NotesDocumentEntity notesDocumentEntity, NotesDocumentTextSearchEntity notesDocumentTextSearchEntity, List<NotesStrokeSearchEntity> list) {
        this.__db.beginTransaction();
        try {
            int iUpdate = super.update(notesDocumentEntity, notesDocumentTextSearchEntity, list);
            this.__db.setTransactionSuccessful();
            return iUpdate;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public int updateDocumentEntity(NotesDocumentEntity notesDocumentEntity) {
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao
    public void updateTextSearchEntity(String str, String str2, String str3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateTextSearchEntity.acquire();
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
        if (str3 == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, str3);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeInsert();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateTextSearchEntity.release(supportSQLiteStatementAcquire);
        }
    }
}
