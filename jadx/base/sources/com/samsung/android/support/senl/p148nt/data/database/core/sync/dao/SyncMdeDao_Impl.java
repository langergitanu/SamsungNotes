package com.samsung.android.support.senl.p148nt.data.database.core.sync.dao;

import android.database.Cursor;
import android.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.NotesDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class SyncMdeDao_Impl extends SyncMdeDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<NotesDocumentEntity> __insertionAdapterOfNotesDocumentEntity;

    public SyncMdeDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNotesDocumentEntity = new EntityInsertionAdapter<NotesDocumentEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncMdeDao_Impl.1
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: __entityCursorConverter_comSamsungAndroidSupportSenlNtDataDatabaseCoreDocumentDataMainListDocumentData */
    public MainListDocumentData m12443x1be9442c(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("UUID");
        int columnIndex3 = cursor.getColumnIndex("isDeleted");
        int columnIndex4 = cursor.getColumnIndex("isDirty");
        int columnIndex5 = cursor.getColumnIndex("title");
        int columnIndex6 = cursor.getColumnIndex(DBSchema.Document.RECOMMENDED_TITLE);
        int columnIndex7 = cursor.getColumnIndex("content");
        int columnIndex8 = cursor.getColumnIndex("displayContent");
        int columnIndex9 = cursor.getColumnIndex("createdAt");
        int columnIndex10 = cursor.getColumnIndex("lastModifiedAt");
        int columnIndex11 = cursor.getColumnIndex(DBSchema.Document.VR_UUID);
        int columnIndex12 = cursor.getColumnIndex(DBSchema.Document.CONTENT_UUID);
        int columnIndex13 = cursor.getColumnIndex("firstContentType");
        int columnIndex14 = cursor.getColumnIndex("secondContentType");
        int columnIndex15 = cursor.getColumnIndex("strokeUUID");
        int columnIndex16 = cursor.getColumnIndex("categoryUUID");
        int columnIndex17 = cursor.getColumnIndex("filePath");
        int columnIndex18 = cursor.getColumnIndex("isFavorite");
        int columnIndex19 = cursor.getColumnIndex("isLock");
        int columnIndex20 = cursor.getColumnIndex("isSaving");
        int columnIndex21 = cursor.getColumnIndex("recycle_bin_time_moved");
        int columnIndex22 = cursor.getColumnIndex("firstOpendAt");
        int columnIndex23 = cursor.getColumnIndex("mdeSpaceId");
        int columnIndex24 = cursor.getColumnIndex("mdeItemId");
        int columnIndex25 = cursor.getColumnIndex("mdeGroupId");
        int columnIndex26 = cursor.getColumnIndex("mdeOwnerId");
        int columnIndex27 = cursor.getColumnIndex(DBSchema.Document.ABSOLUTE_PATH);
        int columnIndex28 = cursor.getColumnIndex("backgroundColor");
        int columnIndex29 = cursor.getColumnIndex(DBSchema.Document.BACKGROUND_COLOR_INVERTED);
        int columnIndex30 = cursor.getColumnIndex(DBSchema.Document.CORRUPTED);
        int columnIndex31 = cursor.getColumnIndex(DBSchema.Document.PAGE_MODE);
        int columnIndex32 = cursor.getColumnIndex("size");
        int columnIndex33 = cursor.getColumnIndex("coverTemplateUuid");
        int columnIndex34 = cursor.getColumnIndex(ExternalDataConstants.Column.COVER_SUMMARY);
        int columnIndex35 = cursor.getColumnIndex("coverSummaryAlignment");
        int columnIndex36 = cursor.getColumnIndex("coverStickerUuid");
        int columnIndex37 = cursor.getColumnIndex("coverBackgroundColor");
        int columnIndex38 = cursor.getColumnIndex("isCoverEnabled");
        int columnIndex39 = cursor.getColumnIndex("coverSuggestedState");
        int columnIndex40 = cursor.getColumnIndex(SyncDBSchema.SyncInfo.SYNC_STATE);
        int columnIndex41 = cursor.getColumnIndex(DBSchema.DocumentExtra.HAS_STICKY);
        int columnIndex42 = cursor.getColumnIndex(DBSchema.DocumentExtra.UNKNOWN_MIN_VERSION);
        int columnIndex43 = cursor.getColumnIndex(DBSchema.DocumentExtra.FORMAT_VERSION);
        int columnIndex44 = cursor.getColumnIndex(DBSchema.DocumentThumbnail.BACKGROUND_TYPE);
        int columnIndex45 = cursor.getColumnIndex(DBSchema.DocumentThumbnail.LAYOUT);
        int columnIndex46 = cursor.getColumnIndex(DBSchema.DocumentThumbnail.IMAGE_PATH);
        int columnIndex47 = cursor.getColumnIndex(DBSchema.DocumentThumbnail.PLAY_TIME);
        MainListDocumentData mainListDocumentData = new MainListDocumentData();
        if (columnIndex != -1) {
            mainListDocumentData.setId(cursor.isNull(columnIndex) ? null : Long.valueOf(cursor.getLong(columnIndex)));
        }
        if (columnIndex2 != -1) {
            mainListDocumentData.setUuid(cursor.isNull(columnIndex2) ? null : cursor.getString(columnIndex2));
        }
        if (columnIndex3 != -1) {
            mainListDocumentData.setIsDeleted(cursor.getInt(columnIndex3));
        }
        if (columnIndex4 != -1) {
            mainListDocumentData.setIsDirty(cursor.getInt(columnIndex4));
        }
        if (columnIndex5 != -1) {
            mainListDocumentData.setTitle(cursor.isNull(columnIndex5) ? null : cursor.getString(columnIndex5));
        }
        if (columnIndex6 != -1) {
            mainListDocumentData.setRecommendedTitle(cursor.isNull(columnIndex6) ? null : cursor.getString(columnIndex6));
        }
        if (columnIndex7 != -1) {
            mainListDocumentData.setContent(NotesDataConverter.byteToString(cursor.isNull(columnIndex7) ? null : cursor.getBlob(columnIndex7)));
        }
        if (columnIndex8 != -1) {
            mainListDocumentData.setDisplayContent(cursor.isNull(columnIndex8) ? null : cursor.getBlob(columnIndex8));
        }
        if (columnIndex9 != -1) {
            mainListDocumentData.setCreatedAt(cursor.getLong(columnIndex9));
        }
        if (columnIndex10 != -1) {
            mainListDocumentData.setLastModifiedAt(cursor.getLong(columnIndex10));
        }
        if (columnIndex11 != -1) {
            mainListDocumentData.setVrUuid(cursor.isNull(columnIndex11) ? null : cursor.getString(columnIndex11));
        }
        if (columnIndex12 != -1) {
            mainListDocumentData.setContentUuid(cursor.isNull(columnIndex12) ? null : cursor.getString(columnIndex12));
        }
        if (columnIndex13 != -1) {
            mainListDocumentData.setFirstContentType(cursor.isNull(columnIndex13) ? null : Integer.valueOf(cursor.getInt(columnIndex13)));
        }
        if (columnIndex14 != -1) {
            mainListDocumentData.setSecondContentType(cursor.isNull(columnIndex14) ? null : Integer.valueOf(cursor.getInt(columnIndex14)));
        }
        if (columnIndex15 != -1) {
            mainListDocumentData.setStrokeUuid(cursor.isNull(columnIndex15) ? null : cursor.getString(columnIndex15));
        }
        if (columnIndex16 != -1) {
            mainListDocumentData.setCategoryUuid(cursor.isNull(columnIndex16) ? null : cursor.getString(columnIndex16));
        }
        if (columnIndex17 != -1) {
            mainListDocumentData.setFilePath(cursor.isNull(columnIndex17) ? null : cursor.getString(columnIndex17));
        }
        if (columnIndex18 != -1) {
            mainListDocumentData.setIsFavorite(cursor.getInt(columnIndex18));
        }
        if (columnIndex19 != -1) {
            mainListDocumentData.setIsLock(cursor.getInt(columnIndex19));
        }
        if (columnIndex20 != -1) {
            mainListDocumentData.setIsSavingByWhichPid(cursor.getInt(columnIndex20));
        }
        if (columnIndex21 != -1) {
            mainListDocumentData.setRecycleBinTimeMoved(cursor.getLong(columnIndex21));
        }
        if (columnIndex22 != -1) {
            mainListDocumentData.setFirstOpenedAt(cursor.getLong(columnIndex22));
        }
        if (columnIndex23 != -1) {
            mainListDocumentData.setMdeSpaceId(cursor.isNull(columnIndex23) ? null : cursor.getString(columnIndex23));
        }
        if (columnIndex24 != -1) {
            mainListDocumentData.setMdeItemId(cursor.isNull(columnIndex24) ? null : cursor.getString(columnIndex24));
        }
        if (columnIndex25 != -1) {
            mainListDocumentData.setMdeGroupId(cursor.isNull(columnIndex25) ? null : cursor.getString(columnIndex25));
        }
        if (columnIndex26 != -1) {
            mainListDocumentData.setMdeOwnerId(cursor.isNull(columnIndex26) ? null : cursor.getString(columnIndex26));
        }
        if (columnIndex27 != -1) {
            mainListDocumentData.setAbsolutePath(cursor.isNull(columnIndex27) ? null : cursor.getString(columnIndex27));
        }
        if (columnIndex28 != -1) {
            mainListDocumentData.setBackgroundColor(cursor.getInt(columnIndex28));
        }
        if (columnIndex29 != -1) {
            mainListDocumentData.setBackgroundColorInverted(cursor.getInt(columnIndex29));
        }
        if (columnIndex30 != -1) {
            mainListDocumentData.setCorrupted(cursor.getInt(columnIndex30));
        }
        if (columnIndex31 != -1) {
            mainListDocumentData.setPageMode(cursor.getInt(columnIndex31));
        }
        if (columnIndex32 != -1) {
            mainListDocumentData.setSize(cursor.getLong(columnIndex32));
        }
        if (columnIndex33 != -1) {
            mainListDocumentData.setCoverTemplateUuid(cursor.isNull(columnIndex33) ? null : cursor.getString(columnIndex33));
        }
        if (columnIndex34 != -1) {
            mainListDocumentData.setCoverSummary(cursor.isNull(columnIndex34) ? null : cursor.getString(columnIndex34));
        }
        if (columnIndex35 != -1) {
            mainListDocumentData.setCoverSummaryAlignment(cursor.getInt(columnIndex35));
        }
        if (columnIndex36 != -1) {
            mainListDocumentData.setCoverStickerUuid(cursor.isNull(columnIndex36) ? null : cursor.getString(columnIndex36));
        }
        if (columnIndex37 != -1) {
            mainListDocumentData.setCoverBackgroundColor(cursor.isNull(columnIndex37) ? null : cursor.getString(columnIndex37));
        }
        if (columnIndex38 != -1) {
            mainListDocumentData.setIsCoverEnabled(cursor.getInt(columnIndex38));
        }
        if (columnIndex39 != -1) {
            mainListDocumentData.coverSuggestedState = cursor.getInt(columnIndex39);
        }
        if (columnIndex40 != -1) {
            mainListDocumentData.setSyncState(cursor.getLong(columnIndex40));
        }
        if (columnIndex41 != -1) {
            mainListDocumentData.setHasSticky(cursor.getInt(columnIndex41));
        }
        if (columnIndex42 != -1) {
            mainListDocumentData.setUnknownMinVersion(cursor.getInt(columnIndex42));
        }
        if (columnIndex43 != -1) {
            mainListDocumentData.setFormatVersion(cursor.getInt(columnIndex43));
        }
        if (columnIndex44 != -1) {
            mainListDocumentData.setBackgroundType(cursor.getInt(columnIndex44));
        }
        if (columnIndex45 != -1) {
            mainListDocumentData.setLayout(cursor.getInt(columnIndex45));
        }
        if (columnIndex46 != -1) {
            mainListDocumentData.setImagePath(cursor.isNull(columnIndex46) ? null : cursor.getString(columnIndex46));
        }
        if (columnIndex47 != -1) {
            mainListDocumentData.setPlayTime(cursor.isNull(columnIndex47) ? null : cursor.getString(columnIndex47));
        }
        return mainListDocumentData;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public List<String> getLocalGroupIdListCoedit() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT Distinct mdeGroupId FROM sdoc WHERE mdeSpaceId!=''  AND categoryUUID='coedit:///'", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public List<String> getLocalGroupIdListOldSharedNote() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT Distinct mdeGroupId FROM sdoc WHERE mdeSpaceId!=''  AND categoryUUID!='coedit:///'", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public List<String> getLocalSpaceIdListCoedit() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT Distinct mdeSpaceId FROM sdoc WHERE mdeSpaceId!='' AND categoryUUID='coedit:///'", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public List<String> getLocalSpaceIdListOldSharedNote() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT Distinct mdeSpaceId FROM sdoc WHERE mdeSpaceId!='' AND categoryUUID!='coedit:///'", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public int getMdeOwnerNoteCount(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM sdoc WHERE mdeSpaceId!='' AND mdeSpaceId=? AND mdeOwnerId=?", 2);
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
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public int getUnreadCoeditNoteCount() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM sdoc WHERE sdoc.isDeleted = 0 AND mdeSpaceId!='' AND firstOpendAt=0 AND categoryUUID='coedit:///'", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public int getUnreadMdeNoteCount() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM sdoc WHERE sdoc.isDeleted = 0 AND mdeSpaceId!='' AND firstOpendAt=0 AND categoryUUID!='coedit:///'", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public List<String> getUuidListByGroupIdAndOwnerIdOld(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM sdoc WHERE mdeGroupId=? AND mdeOwnerId=? AND categoryUUID!='coedit:///'", 2);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public List<String> getUuidListByGroupIdCoedit(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM sdoc WHERE mdeGroupId=? AND categoryUUID='coedit:///'", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public List<String> getUuidListByGroupIdOld(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM sdoc WHERE mdeGroupId=? AND categoryUUID!='coedit:///'", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public List<String> getUuidListBySpaceIdCoedit(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM sdoc WHERE mdeSpaceId=? AND categoryUUID='coedit:///'", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public List<String> getUuidListBySpaceIdOld(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM sdoc WHERE mdeSpaceId=? AND categoryUUID!='coedit:///'", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public List<String> getUuidListCoedit() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM sdoc WHERE mdeSpaceId!='' AND categoryUUID='coedit:///'", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public List<String> getUuidListInvalidSharedNote() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM sdoc WHERE mdeSpaceId!='' AND categoryUUID!='shared:///' AND categoryUUID!='coedit:///'", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public List<String> getUuidListMde() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM sdoc WHERE mdeSpaceId!='' AND categoryUUID!='coedit:///'", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public List<MainListDocumentData> internalRawQuery(SupportSQLiteQuery supportSQLiteQuery) {
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, supportSQLiteQuery, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(m12443x1be9442c(cursorQuery));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public LiveData<List<MainListDocumentData>> internalRawQuery_LiveData(final SupportSQLiteQuery supportSQLiteQuery) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"sdoc"}, false, new Callable<List<MainListDocumentData>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.sync.dao.SyncMdeDao_Impl.2
            @Override // java.util.concurrent.Callable
            public List<MainListDocumentData> call() {
                Cursor cursorQuery = DBUtil.query(SyncMdeDao_Impl.this.__db, supportSQLiteQuery, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(SyncMdeDao_Impl.this.m12443x1be9442c(cursorQuery));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public int getUnreadCoeditNoteCount(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM sdoc WHERE sdoc.isDeleted = 0 AND mdeSpaceId=? AND firstOpendAt=0  AND categoryUUID='coedit:///'", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao
    public int getUnreadMdeNoteCount(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM sdoc WHERE sdoc.isDeleted = 0 AND mdeSpaceId=? AND firstOpendAt=0 AND categoryUUID!='coedit:///'", 1);
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
}
