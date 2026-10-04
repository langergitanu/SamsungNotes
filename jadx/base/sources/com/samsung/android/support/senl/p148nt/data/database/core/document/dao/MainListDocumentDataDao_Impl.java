package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.NotesDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class MainListDocumentDataDao_Impl extends MainListDocumentDataDao {
    private final RoomDatabase __db;

    public MainListDocumentDataDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: __entityCursorConverter_comSamsungAndroidSupportSenlNtDataDatabaseCoreDocumentDataMainListDocumentData */
    public MainListDocumentData m12353x1be9442c(Cursor cursor) {
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public List<MainListDocumentData> getAllByTagNormalizedNames(SortParam sortParam, Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            List<MainListDocumentData> allByTagNormalizedNames = super.getAllByTagNormalizedNames(sortParam, collection);
            this.__db.setTransactionSuccessful();
            return allByTagNormalizedNames;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public LiveData<List<NotesDocumentCountEntry>> getAllDocumentCountEntry_LiveData(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT category_tree.UUID, category_tree.parentUUID, category_tree.displayName, category_tree.displayNameColor, category_tree.isDeleted,  category_tree.createdAt, category_tree.lastModifiedAt, category_tree.recycle_bin_time_moved, category_tree.orderBy, (SELECT COUNT(*) FROM sdoc AS doc LEFT OUTER JOIN mapped_document AS map ON doc.UUID = map.UUID WHERE doc.categoryUUID=category_tree.UUID AND doc.isDeleted IS NOT 1 AND map.UUID IS NULL) AS documentCount FROM category_tree WHERE category_tree.parentUUID=? ORDER BY category_tree.orderBy ASC", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"sdoc", DBSchema.MappedDocument.TABLE_NAME, DBSchema.CategoryTree.TABLE_NAME}, false, new Callable<List<NotesDocumentCountEntry>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.MainListDocumentDataDao_Impl.2
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<NotesDocumentCountEntry> call() {
                Cursor cursorQuery = DBUtil.query(MainListDocumentDataDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public int getAllNoteCount(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM sdoc LEFT OUTER JOIN mapped_document AS map ON sdoc.UUID = map.UUID WHERE sdoc.isDeleted=? AND sdoc.mdeSpaceId='' AND map.UUID IS NULL ", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public int getAllNoteCountIncludingOldNote(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM sdoc WHERE isDeleted=? AND mdeSpaceId=''", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public List<MainListDocumentData> getAllWithTag(String str) {
        this.__db.beginTransaction();
        try {
            List<MainListDocumentData> allWithTag = super.getAllWithTag(str);
            this.__db.setTransactionSuccessful();
            return allWithTag;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public List<String> getDocumentsWithTag(Collection<String> collection, int i) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        int iM12317b = AbstractC11014a.m12317b(sbNewStringBuilder, "SELECT tag_list.docUUID FROM tag_list WHERE tag_list.normalizeName IN (", collection, sbNewStringBuilder, ") GROUP BY tag_list.docUUID HAVING COUNT(*)=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        int i2 = 1;
        int i4 = iM12317b + 1;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), i4);
        for (String str : collection) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i2);
            } else {
                roomSQLiteQueryAcquire.bindString(i2, str);
            }
            i2++;
        }
        roomSQLiteQueryAcquire.bindLong(i4, i);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public List<MainListDocumentData> getEntities(Collection<String> collection, String str) {
        this.__db.beginTransaction();
        try {
            List<MainListDocumentData> entities = super.getEntities(collection, str);
            this.__db.setTransactionSuccessful();
            return entities;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public List<MainListDocumentData> getEntitiesInChunk(Collection<String> collection) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), AbstractC11014a.m12317b(sbNewStringBuilder, "SELECT `sdoc`.`_id` AS `_id`, `sdoc`.`UUID` AS `UUID`, `sdoc`.`isDeleted` AS `isDeleted`, `sdoc`.`isDirty` AS `isDirty`, substr(`sdoc`.`title`, 1, 300) AS `title`, `sdoc`.`recommendedTitle` AS `recommendedTitle`, substr(`sdoc`.`content`, 1, 300) AS `content`, `sdoc`.`displayContent` AS `displayContent`, `sdoc`.`createdAt` AS `createdAt`, `sdoc`.`lastModifiedAt` AS `lastModifiedAt`, `sdoc`.`vrUUID` AS `vrUUID`, `sdoc`.`contentUUID` AS `contentUUID`, `sdoc`.`firstContentType` AS `firstContentType`, `sdoc`.`secondContentType` AS `secondContentType`, `sdoc`.`strokeUUID` AS `strokeUUID`, `sdoc`.`categoryUUID` AS `categoryUUID`, `sdoc`.`filePath` AS `filePath`, `sdoc`.`isFavorite` AS `isFavorite`, `sdoc`.`isLock` AS `isLock`, `sdoc`.`isSaving` AS `isSaving`, `sdoc`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `sdoc`.`firstOpendAt` AS `firstOpendAt`, `sdoc`.`mdeSpaceId` AS `mdeSpaceId`, `sdoc`.`mdeItemId` AS `mdeItemId`, `sdoc`.`mdeGroupId` AS `mdeGroupId`, `sdoc`.`mdeOwnerId` AS `mdeOwnerId`, `sdoc`.`absolutePath` AS `absolutePath`, `sdoc`.`backgroundColor` AS `backgroundColor`, `sdoc`.`backgroundColorInverted` AS `backgroundColorInverted`, `sdoc`.`corrupted` AS `corrupted`, `sdoc`.`pageMode` AS `pageMode`, `sdoc`.`size` AS `size`,`document_cover`.`templateUUID` AS `coverTemplateUuid`, `document_cover`.`summary` AS `coverSummary`, `document_cover`.`summary_alignment` AS `coverSummaryAlignment`, `document_cover`.`categoryUUID` AS `coverStickerUuid`, `document_cover`.`backgroundColor` AS `coverBackgroundColor`, `document_cover`.`isEnabled` AS `isCoverEnabled`, `suggested_cover`.`state` AS `coverSuggestedState`, `sync_info`.`syncState` AS `syncState`, `document_extra`.`hasSticky` AS `hasSticky`, `document_extra`.`unknownMinVersion` AS `unknownMinVersion`, `document_extra`.`formatVersion` AS `formatVersion`,`document_thumbnail`.`backgroundType` AS `backgroundType`, `document_thumbnail`.`layout` AS `layout`,`document_thumbnail`.`imagePath` AS `imagePath`, `document_thumbnail`.`playTime` AS `playTime` FROM sdoc LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID WHERE sdoc.UUID IN (", collection, sbNewStringBuilder, ") AND sdoc.isDeleted = 0 AND sdoc.isLock = 0"));
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
                MainListDocumentData mainListDocumentData = new MainListDocumentData();
                mainListDocumentData.setId(cursorQuery.isNull(0) ? null : Long.valueOf(cursorQuery.getLong(0)));
                mainListDocumentData.setUuid(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                mainListDocumentData.setIsDeleted(cursorQuery.getInt(2));
                mainListDocumentData.setIsDirty(cursorQuery.getInt(3));
                mainListDocumentData.setTitle(cursorQuery.isNull(4) ? null : cursorQuery.getString(4));
                mainListDocumentData.setRecommendedTitle(cursorQuery.isNull(5) ? null : cursorQuery.getString(5));
                mainListDocumentData.setContent(NotesDataConverter.byteToString(cursorQuery.isNull(6) ? null : cursorQuery.getBlob(6)));
                mainListDocumentData.setDisplayContent(cursorQuery.isNull(7) ? null : cursorQuery.getBlob(7));
                mainListDocumentData.setCreatedAt(cursorQuery.getLong(8));
                mainListDocumentData.setLastModifiedAt(cursorQuery.getLong(9));
                mainListDocumentData.setVrUuid(cursorQuery.isNull(10) ? null : cursorQuery.getString(10));
                mainListDocumentData.setContentUuid(cursorQuery.isNull(11) ? null : cursorQuery.getString(11));
                mainListDocumentData.setFirstContentType(cursorQuery.isNull(12) ? null : Integer.valueOf(cursorQuery.getInt(12)));
                mainListDocumentData.setSecondContentType(cursorQuery.isNull(13) ? null : Integer.valueOf(cursorQuery.getInt(13)));
                mainListDocumentData.setStrokeUuid(cursorQuery.isNull(14) ? null : cursorQuery.getString(14));
                mainListDocumentData.setCategoryUuid(cursorQuery.isNull(15) ? null : cursorQuery.getString(15));
                mainListDocumentData.setFilePath(cursorQuery.isNull(16) ? null : cursorQuery.getString(16));
                mainListDocumentData.setIsFavorite(cursorQuery.getInt(17));
                mainListDocumentData.setIsLock(cursorQuery.getInt(18));
                mainListDocumentData.setIsSavingByWhichPid(cursorQuery.getInt(19));
                mainListDocumentData.setRecycleBinTimeMoved(cursorQuery.getLong(20));
                mainListDocumentData.setFirstOpenedAt(cursorQuery.getLong(21));
                mainListDocumentData.setMdeSpaceId(cursorQuery.isNull(22) ? null : cursorQuery.getString(22));
                mainListDocumentData.setMdeItemId(cursorQuery.isNull(23) ? null : cursorQuery.getString(23));
                mainListDocumentData.setMdeGroupId(cursorQuery.isNull(24) ? null : cursorQuery.getString(24));
                mainListDocumentData.setMdeOwnerId(cursorQuery.isNull(25) ? null : cursorQuery.getString(25));
                mainListDocumentData.setAbsolutePath(cursorQuery.isNull(26) ? null : cursorQuery.getString(26));
                mainListDocumentData.setBackgroundColor(cursorQuery.getInt(27));
                mainListDocumentData.setBackgroundColorInverted(cursorQuery.getInt(28));
                mainListDocumentData.setCorrupted(cursorQuery.getInt(29));
                mainListDocumentData.setPageMode(cursorQuery.getInt(30));
                mainListDocumentData.setSize(cursorQuery.getLong(31));
                mainListDocumentData.setCoverTemplateUuid(cursorQuery.isNull(32) ? null : cursorQuery.getString(32));
                mainListDocumentData.setCoverSummary(cursorQuery.isNull(33) ? null : cursorQuery.getString(33));
                mainListDocumentData.setCoverSummaryAlignment(cursorQuery.getInt(34));
                mainListDocumentData.setCoverStickerUuid(cursorQuery.isNull(35) ? null : cursorQuery.getString(35));
                mainListDocumentData.setCoverBackgroundColor(cursorQuery.isNull(36) ? null : cursorQuery.getString(36));
                mainListDocumentData.setIsCoverEnabled(cursorQuery.getInt(37));
                mainListDocumentData.coverSuggestedState = cursorQuery.getInt(38);
                mainListDocumentData.setSyncState(cursorQuery.getLong(39));
                mainListDocumentData.setHasSticky(cursorQuery.getInt(40));
                mainListDocumentData.setUnknownMinVersion(cursorQuery.getInt(41));
                mainListDocumentData.setFormatVersion(cursorQuery.getInt(42));
                mainListDocumentData.setBackgroundType(cursorQuery.getInt(43));
                mainListDocumentData.setLayout(cursorQuery.getInt(44));
                mainListDocumentData.setImagePath(cursorQuery.isNull(45) ? null : cursorQuery.getString(45));
                mainListDocumentData.setPlayTime(cursorQuery.isNull(46) ? null : cursorQuery.getString(46));
                arrayList.add(mainListDocumentData);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public MainListDocumentData getEntity(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `sdoc`.`_id` AS `_id`, `sdoc`.`UUID` AS `UUID`, `sdoc`.`isDeleted` AS `isDeleted`, `sdoc`.`isDirty` AS `isDirty`, substr(`sdoc`.`title`, 1, 300) AS `title`, `sdoc`.`recommendedTitle` AS `recommendedTitle`, substr(`sdoc`.`content`, 1, 300) AS `content`, `sdoc`.`displayContent` AS `displayContent`, `sdoc`.`createdAt` AS `createdAt`, `sdoc`.`lastModifiedAt` AS `lastModifiedAt`, `sdoc`.`vrUUID` AS `vrUUID`, `sdoc`.`contentUUID` AS `contentUUID`, `sdoc`.`firstContentType` AS `firstContentType`, `sdoc`.`secondContentType` AS `secondContentType`, `sdoc`.`strokeUUID` AS `strokeUUID`, `sdoc`.`categoryUUID` AS `categoryUUID`, `sdoc`.`filePath` AS `filePath`, `sdoc`.`isFavorite` AS `isFavorite`, `sdoc`.`isLock` AS `isLock`, `sdoc`.`isSaving` AS `isSaving`, `sdoc`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `sdoc`.`firstOpendAt` AS `firstOpendAt`, `sdoc`.`mdeSpaceId` AS `mdeSpaceId`, `sdoc`.`mdeItemId` AS `mdeItemId`, `sdoc`.`mdeGroupId` AS `mdeGroupId`, `sdoc`.`mdeOwnerId` AS `mdeOwnerId`, `sdoc`.`absolutePath` AS `absolutePath`, `sdoc`.`backgroundColor` AS `backgroundColor`, `sdoc`.`backgroundColorInverted` AS `backgroundColorInverted`, `sdoc`.`corrupted` AS `corrupted`, `sdoc`.`pageMode` AS `pageMode`, `sdoc`.`size` AS `size`,`document_cover`.`templateUUID` AS `coverTemplateUuid`, `document_cover`.`summary` AS `coverSummary`, `document_cover`.`summary_alignment` AS `coverSummaryAlignment`, `document_cover`.`categoryUUID` AS `coverStickerUuid`, `document_cover`.`backgroundColor` AS `coverBackgroundColor`, `document_cover`.`isEnabled` AS `isCoverEnabled`, `suggested_cover`.`state` AS `coverSuggestedState`, `sync_info`.`syncState` AS `syncState`, `document_extra`.`hasSticky` AS `hasSticky`, `document_extra`.`unknownMinVersion` AS `unknownMinVersion`, `document_extra`.`formatVersion` AS `formatVersion`,`document_thumbnail`.`backgroundType` AS `backgroundType`, `document_thumbnail`.`layout` AS `layout`,`document_thumbnail`.`imagePath` AS `imagePath`, `document_thumbnail`.`playTime` AS `playTime` FROM sdoc LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID WHERE sdoc.UUID=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        MainListDocumentData mainListDocumentData = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                MainListDocumentData mainListDocumentData2 = new MainListDocumentData();
                mainListDocumentData2.setId(cursorQuery.isNull(0) ? null : Long.valueOf(cursorQuery.getLong(0)));
                mainListDocumentData2.setUuid(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                mainListDocumentData2.setIsDeleted(cursorQuery.getInt(2));
                mainListDocumentData2.setIsDirty(cursorQuery.getInt(3));
                mainListDocumentData2.setTitle(cursorQuery.isNull(4) ? null : cursorQuery.getString(4));
                mainListDocumentData2.setRecommendedTitle(cursorQuery.isNull(5) ? null : cursorQuery.getString(5));
                mainListDocumentData2.setContent(NotesDataConverter.byteToString(cursorQuery.isNull(6) ? null : cursorQuery.getBlob(6)));
                mainListDocumentData2.setDisplayContent(cursorQuery.isNull(7) ? null : cursorQuery.getBlob(7));
                mainListDocumentData2.setCreatedAt(cursorQuery.getLong(8));
                mainListDocumentData2.setLastModifiedAt(cursorQuery.getLong(9));
                mainListDocumentData2.setVrUuid(cursorQuery.isNull(10) ? null : cursorQuery.getString(10));
                mainListDocumentData2.setContentUuid(cursorQuery.isNull(11) ? null : cursorQuery.getString(11));
                mainListDocumentData2.setFirstContentType(cursorQuery.isNull(12) ? null : Integer.valueOf(cursorQuery.getInt(12)));
                mainListDocumentData2.setSecondContentType(cursorQuery.isNull(13) ? null : Integer.valueOf(cursorQuery.getInt(13)));
                mainListDocumentData2.setStrokeUuid(cursorQuery.isNull(14) ? null : cursorQuery.getString(14));
                mainListDocumentData2.setCategoryUuid(cursorQuery.isNull(15) ? null : cursorQuery.getString(15));
                mainListDocumentData2.setFilePath(cursorQuery.isNull(16) ? null : cursorQuery.getString(16));
                mainListDocumentData2.setIsFavorite(cursorQuery.getInt(17));
                mainListDocumentData2.setIsLock(cursorQuery.getInt(18));
                mainListDocumentData2.setIsSavingByWhichPid(cursorQuery.getInt(19));
                mainListDocumentData2.setRecycleBinTimeMoved(cursorQuery.getLong(20));
                mainListDocumentData2.setFirstOpenedAt(cursorQuery.getLong(21));
                mainListDocumentData2.setMdeSpaceId(cursorQuery.isNull(22) ? null : cursorQuery.getString(22));
                mainListDocumentData2.setMdeItemId(cursorQuery.isNull(23) ? null : cursorQuery.getString(23));
                mainListDocumentData2.setMdeGroupId(cursorQuery.isNull(24) ? null : cursorQuery.getString(24));
                mainListDocumentData2.setMdeOwnerId(cursorQuery.isNull(25) ? null : cursorQuery.getString(25));
                mainListDocumentData2.setAbsolutePath(cursorQuery.isNull(26) ? null : cursorQuery.getString(26));
                mainListDocumentData2.setBackgroundColor(cursorQuery.getInt(27));
                mainListDocumentData2.setBackgroundColorInverted(cursorQuery.getInt(28));
                mainListDocumentData2.setCorrupted(cursorQuery.getInt(29));
                mainListDocumentData2.setPageMode(cursorQuery.getInt(30));
                mainListDocumentData2.setSize(cursorQuery.getLong(31));
                mainListDocumentData2.setCoverTemplateUuid(cursorQuery.isNull(32) ? null : cursorQuery.getString(32));
                mainListDocumentData2.setCoverSummary(cursorQuery.isNull(33) ? null : cursorQuery.getString(33));
                mainListDocumentData2.setCoverSummaryAlignment(cursorQuery.getInt(34));
                mainListDocumentData2.setCoverStickerUuid(cursorQuery.isNull(35) ? null : cursorQuery.getString(35));
                mainListDocumentData2.setCoverBackgroundColor(cursorQuery.isNull(36) ? null : cursorQuery.getString(36));
                mainListDocumentData2.setIsCoverEnabled(cursorQuery.getInt(37));
                mainListDocumentData2.coverSuggestedState = cursorQuery.getInt(38);
                mainListDocumentData2.setSyncState(cursorQuery.getLong(39));
                mainListDocumentData2.setHasSticky(cursorQuery.getInt(40));
                mainListDocumentData2.setUnknownMinVersion(cursorQuery.getInt(41));
                mainListDocumentData2.setFormatVersion(cursorQuery.getInt(42));
                mainListDocumentData2.setBackgroundType(cursorQuery.getInt(43));
                mainListDocumentData2.setLayout(cursorQuery.getInt(44));
                mainListDocumentData2.setImagePath(cursorQuery.isNull(45) ? null : cursorQuery.getString(45));
                if (!cursorQuery.isNull(46)) {
                    string = cursorQuery.getString(46);
                }
                mainListDocumentData2.setPlayTime(string);
                mainListDocumentData = mainListDocumentData2;
            }
            return mainListDocumentData;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public List<String> getExpiredRecycleBinDataNotInFolder(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT UUID FROM sdoc WHERE recycle_bin_time_moved<? AND recycle_bin_time_moved IS NOT 0 AND isDeleted=2 AND categoryUUID='trash:///'", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public int getFavoriteItemCount(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM sdoc LEFT OUTER JOIN mapped_document AS map ON sdoc.UUID = map.UUID WHERE sdoc.isFavorite=1 AND sdoc.mdeSpaceId='' AND sdoc.isDeleted=? AND map.UUID IS NULL", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public int getNoteCountWithTitle() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM sdoc WHERE title != '' AND sdoc.isDeleted = 0", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public int getNoteCountWithVoiceData() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM sdoc WHERE vrUUID != '' AND sdoc.isDeleted = 0", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public List<String> getOldDocumentsWithTag(Collection<String> collection, int i) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        int iM12317b = AbstractC11014a.m12317b(sbNewStringBuilder, "SELECT hashtagContent.sdocUUID FROM hashtagContent JOIN hashtag ON hashtagContent.hashtagUUID = hashtag.UUID WHERE LOWER(hashtag.name) IN (", collection, sbNewStringBuilder, ") GROUP BY hashtagContent.sdocUUID HAVING COUNT(*)=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        int i2 = 1;
        int i4 = iM12317b + 1;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), i4);
        for (String str : collection) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i2);
            } else {
                roomSQLiteQueryAcquire.bindString(i2, str);
            }
            i2++;
        }
        roomSQLiteQueryAcquire.bindLong(i4, i);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public int getRecentlyImportedNoteCount(long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM sdoc LEFT OUTER JOIN mapped_document AS map ON sdoc.UUID = map.UUID WHERE sdoc.importedAt >= ? AND sdoc.isDeleted = 0 AND sdoc.mdeSpaceId='' AND map.UUID IS NULL ", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public LiveData<MainListDocumentData> get_LiveData(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `sdoc`.`_id` AS `_id`, `sdoc`.`UUID` AS `UUID`, `sdoc`.`isDeleted` AS `isDeleted`, `sdoc`.`isDirty` AS `isDirty`, substr(`sdoc`.`title`, 1, 300) AS `title`, `sdoc`.`recommendedTitle` AS `recommendedTitle`, substr(`sdoc`.`content`, 1, 300) AS `content`, `sdoc`.`displayContent` AS `displayContent`, `sdoc`.`createdAt` AS `createdAt`, `sdoc`.`lastModifiedAt` AS `lastModifiedAt`, `sdoc`.`vrUUID` AS `vrUUID`, `sdoc`.`contentUUID` AS `contentUUID`, `sdoc`.`firstContentType` AS `firstContentType`, `sdoc`.`secondContentType` AS `secondContentType`, `sdoc`.`strokeUUID` AS `strokeUUID`, `sdoc`.`categoryUUID` AS `categoryUUID`, `sdoc`.`filePath` AS `filePath`, `sdoc`.`isFavorite` AS `isFavorite`, `sdoc`.`isLock` AS `isLock`, `sdoc`.`isSaving` AS `isSaving`, `sdoc`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `sdoc`.`firstOpendAt` AS `firstOpendAt`, `sdoc`.`mdeSpaceId` AS `mdeSpaceId`, `sdoc`.`mdeItemId` AS `mdeItemId`, `sdoc`.`mdeGroupId` AS `mdeGroupId`, `sdoc`.`mdeOwnerId` AS `mdeOwnerId`, `sdoc`.`absolutePath` AS `absolutePath`, `sdoc`.`backgroundColor` AS `backgroundColor`, `sdoc`.`backgroundColorInverted` AS `backgroundColorInverted`, `sdoc`.`corrupted` AS `corrupted`, `sdoc`.`pageMode` AS `pageMode`, `sdoc`.`size` AS `size`,`document_cover`.`templateUUID` AS `coverTemplateUuid`, `document_cover`.`summary` AS `coverSummary`, `document_cover`.`summary_alignment` AS `coverSummaryAlignment`, `document_cover`.`categoryUUID` AS `coverStickerUuid`, `document_cover`.`backgroundColor` AS `coverBackgroundColor`, `document_cover`.`isEnabled` AS `isCoverEnabled`, `suggested_cover`.`state` AS `coverSuggestedState`, `sync_info`.`syncState` AS `syncState`, `document_extra`.`hasSticky` AS `hasSticky`, `document_extra`.`unknownMinVersion` AS `unknownMinVersion`, `document_extra`.`formatVersion` AS `formatVersion`,`document_thumbnail`.`backgroundType` AS `backgroundType`, `document_thumbnail`.`layout` AS `layout`,`document_thumbnail`.`imagePath` AS `imagePath`, `document_thumbnail`.`playTime` AS `playTime` FROM sdoc LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID WHERE sdoc.UUID=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"sdoc", DBSchema.DocumentExtra.TABLE_NAME, DBSchema.DocumentThumbnail.TABLE_NAME, SyncDBSchema.SyncInfo.TABLE_NAME, "document_cover", "suggested_cover"}, false, new Callable<MainListDocumentData>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.MainListDocumentDataDao_Impl.1
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public MainListDocumentData call() {
                MainListDocumentData mainListDocumentData = null;
                String string = null;
                Cursor cursorQuery = DBUtil.query(MainListDocumentDataDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        MainListDocumentData mainListDocumentData2 = new MainListDocumentData();
                        mainListDocumentData2.setId(cursorQuery.isNull(0) ? null : Long.valueOf(cursorQuery.getLong(0)));
                        mainListDocumentData2.setUuid(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                        mainListDocumentData2.setIsDeleted(cursorQuery.getInt(2));
                        mainListDocumentData2.setIsDirty(cursorQuery.getInt(3));
                        mainListDocumentData2.setTitle(cursorQuery.isNull(4) ? null : cursorQuery.getString(4));
                        mainListDocumentData2.setRecommendedTitle(cursorQuery.isNull(5) ? null : cursorQuery.getString(5));
                        mainListDocumentData2.setContent(NotesDataConverter.byteToString(cursorQuery.isNull(6) ? null : cursorQuery.getBlob(6)));
                        mainListDocumentData2.setDisplayContent(cursorQuery.isNull(7) ? null : cursorQuery.getBlob(7));
                        mainListDocumentData2.setCreatedAt(cursorQuery.getLong(8));
                        mainListDocumentData2.setLastModifiedAt(cursorQuery.getLong(9));
                        mainListDocumentData2.setVrUuid(cursorQuery.isNull(10) ? null : cursorQuery.getString(10));
                        mainListDocumentData2.setContentUuid(cursorQuery.isNull(11) ? null : cursorQuery.getString(11));
                        mainListDocumentData2.setFirstContentType(cursorQuery.isNull(12) ? null : Integer.valueOf(cursorQuery.getInt(12)));
                        mainListDocumentData2.setSecondContentType(cursorQuery.isNull(13) ? null : Integer.valueOf(cursorQuery.getInt(13)));
                        mainListDocumentData2.setStrokeUuid(cursorQuery.isNull(14) ? null : cursorQuery.getString(14));
                        mainListDocumentData2.setCategoryUuid(cursorQuery.isNull(15) ? null : cursorQuery.getString(15));
                        mainListDocumentData2.setFilePath(cursorQuery.isNull(16) ? null : cursorQuery.getString(16));
                        mainListDocumentData2.setIsFavorite(cursorQuery.getInt(17));
                        mainListDocumentData2.setIsLock(cursorQuery.getInt(18));
                        mainListDocumentData2.setIsSavingByWhichPid(cursorQuery.getInt(19));
                        mainListDocumentData2.setRecycleBinTimeMoved(cursorQuery.getLong(20));
                        mainListDocumentData2.setFirstOpenedAt(cursorQuery.getLong(21));
                        mainListDocumentData2.setMdeSpaceId(cursorQuery.isNull(22) ? null : cursorQuery.getString(22));
                        mainListDocumentData2.setMdeItemId(cursorQuery.isNull(23) ? null : cursorQuery.getString(23));
                        mainListDocumentData2.setMdeGroupId(cursorQuery.isNull(24) ? null : cursorQuery.getString(24));
                        mainListDocumentData2.setMdeOwnerId(cursorQuery.isNull(25) ? null : cursorQuery.getString(25));
                        mainListDocumentData2.setAbsolutePath(cursorQuery.isNull(26) ? null : cursorQuery.getString(26));
                        mainListDocumentData2.setBackgroundColor(cursorQuery.getInt(27));
                        mainListDocumentData2.setBackgroundColorInverted(cursorQuery.getInt(28));
                        mainListDocumentData2.setCorrupted(cursorQuery.getInt(29));
                        mainListDocumentData2.setPageMode(cursorQuery.getInt(30));
                        mainListDocumentData2.setSize(cursorQuery.getLong(31));
                        mainListDocumentData2.setCoverTemplateUuid(cursorQuery.isNull(32) ? null : cursorQuery.getString(32));
                        mainListDocumentData2.setCoverSummary(cursorQuery.isNull(33) ? null : cursorQuery.getString(33));
                        mainListDocumentData2.setCoverSummaryAlignment(cursorQuery.getInt(34));
                        mainListDocumentData2.setCoverStickerUuid(cursorQuery.isNull(35) ? null : cursorQuery.getString(35));
                        mainListDocumentData2.setCoverBackgroundColor(cursorQuery.isNull(36) ? null : cursorQuery.getString(36));
                        mainListDocumentData2.setIsCoverEnabled(cursorQuery.getInt(37));
                        mainListDocumentData2.coverSuggestedState = cursorQuery.getInt(38);
                        mainListDocumentData2.setSyncState(cursorQuery.getLong(39));
                        mainListDocumentData2.setHasSticky(cursorQuery.getInt(40));
                        mainListDocumentData2.setUnknownMinVersion(cursorQuery.getInt(41));
                        mainListDocumentData2.setFormatVersion(cursorQuery.getInt(42));
                        mainListDocumentData2.setBackgroundType(cursorQuery.getInt(43));
                        mainListDocumentData2.setLayout(cursorQuery.getInt(44));
                        mainListDocumentData2.setImagePath(cursorQuery.isNull(45) ? null : cursorQuery.getString(45));
                        if (!cursorQuery.isNull(46)) {
                            string = cursorQuery.getString(46);
                        }
                        mainListDocumentData2.setPlayTime(string);
                        mainListDocumentData = mainListDocumentData2;
                    }
                    return mainListDocumentData;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public List<MainListDocumentData> internalRawQuery(SupportSQLiteQuery supportSQLiteQuery) {
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, supportSQLiteQuery, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(m12353x1be9442c(cursorQuery));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public LiveData<List<MainListDocumentData>> internalRawQuery_LiveData(final SupportSQLiteQuery supportSQLiteQuery) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"sdoc", "document_cover", "suggested_cover", SyncDBSchema.SyncInfo.TABLE_NAME, DBSchema.DocumentExtra.TABLE_NAME, DBSchema.DocumentThumbnail.TABLE_NAME}, false, new Callable<List<MainListDocumentData>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.MainListDocumentDataDao_Impl.4
            @Override // java.util.concurrent.Callable
            public List<MainListDocumentData> call() {
                Cursor cursorQuery = DBUtil.query(MainListDocumentDataDao_Impl.this.__db, supportSQLiteQuery, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(MainListDocumentDataDao_Impl.this.m12353x1be9442c(cursorQuery));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    public LiveData<List<NotesDocumentCountEntry>> getAllDocumentCountEntry_LiveData() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT category_tree.UUID, category_tree.parentUUID, category_tree.displayName, category_tree.displayNameColor, category_tree.isDeleted, category_tree.createdAt, category_tree.lastModifiedAt, category_tree.recycle_bin_time_moved, category_tree.orderBy, (SELECT COUNT(*) FROM sdoc AS doc WHERE doc.categoryUUID=category_tree.UUID AND doc.isDeleted IS NOT 1) AS documentCount FROM category_tree ORDER BY category_tree.orderBy ASC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"sdoc", DBSchema.CategoryTree.TABLE_NAME}, false, new Callable<List<NotesDocumentCountEntry>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.MainListDocumentDataDao_Impl.3
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<NotesDocumentCountEntry> call() {
                Cursor cursorQuery = DBUtil.query(MainListDocumentDataDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao
    /* JADX INFO: renamed from: getEntitiesInChunk */
    public List<MainListDocumentData> lambda$getEntities$0(Collection<String> collection, String str) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT `sdoc`.`_id` AS `_id`, `sdoc`.`UUID` AS `UUID`, `sdoc`.`isDeleted` AS `isDeleted`, `sdoc`.`isDirty` AS `isDirty`, substr(`sdoc`.`title`, 1, 300) AS `title`, `sdoc`.`recommendedTitle` AS `recommendedTitle`, substr(`sdoc`.`content`, 1, 300) AS `content`, `sdoc`.`displayContent` AS `displayContent`, `sdoc`.`createdAt` AS `createdAt`, `sdoc`.`lastModifiedAt` AS `lastModifiedAt`, `sdoc`.`vrUUID` AS `vrUUID`, `sdoc`.`contentUUID` AS `contentUUID`, `sdoc`.`firstContentType` AS `firstContentType`, `sdoc`.`secondContentType` AS `secondContentType`, `sdoc`.`strokeUUID` AS `strokeUUID`, `sdoc`.`categoryUUID` AS `categoryUUID`, `sdoc`.`filePath` AS `filePath`, `sdoc`.`isFavorite` AS `isFavorite`, `sdoc`.`isLock` AS `isLock`, `sdoc`.`isSaving` AS `isSaving`, `sdoc`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `sdoc`.`firstOpendAt` AS `firstOpendAt`, `sdoc`.`mdeSpaceId` AS `mdeSpaceId`, `sdoc`.`mdeItemId` AS `mdeItemId`, `sdoc`.`mdeGroupId` AS `mdeGroupId`, `sdoc`.`mdeOwnerId` AS `mdeOwnerId`, `sdoc`.`absolutePath` AS `absolutePath`, `sdoc`.`backgroundColor` AS `backgroundColor`, `sdoc`.`backgroundColorInverted` AS `backgroundColorInverted`, `sdoc`.`corrupted` AS `corrupted`, `sdoc`.`pageMode` AS `pageMode`, `sdoc`.`size` AS `size`,`document_cover`.`templateUUID` AS `coverTemplateUuid`, `document_cover`.`summary` AS `coverSummary`, `document_cover`.`summary_alignment` AS `coverSummaryAlignment`, `document_cover`.`categoryUUID` AS `coverStickerUuid`, `document_cover`.`backgroundColor` AS `coverBackgroundColor`, `document_cover`.`isEnabled` AS `isCoverEnabled`, `suggested_cover`.`state` AS `coverSuggestedState`, `sync_info`.`syncState` AS `syncState`, `document_extra`.`hasSticky` AS `hasSticky`, `document_extra`.`unknownMinVersion` AS `unknownMinVersion`, `document_extra`.`formatVersion` AS `formatVersion`,`document_thumbnail`.`backgroundType` AS `backgroundType`, `document_thumbnail`.`layout` AS `layout`,`document_thumbnail`.`imagePath` AS `imagePath`, `document_thumbnail`.`playTime` AS `playTime` FROM sdoc LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID WHERE sdoc.categoryUUID = ");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" AND sdoc.UUID IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(") AND sdoc.isDeleted = 0 AND sdoc.isLock = 0");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        int i = 2;
        for (String str2 : collection) {
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
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                MainListDocumentData mainListDocumentData = new MainListDocumentData();
                mainListDocumentData.setId(cursorQuery.isNull(0) ? null : Long.valueOf(cursorQuery.getLong(0)));
                mainListDocumentData.setUuid(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                mainListDocumentData.setIsDeleted(cursorQuery.getInt(2));
                mainListDocumentData.setIsDirty(cursorQuery.getInt(3));
                mainListDocumentData.setTitle(cursorQuery.isNull(4) ? null : cursorQuery.getString(4));
                mainListDocumentData.setRecommendedTitle(cursorQuery.isNull(5) ? null : cursorQuery.getString(5));
                mainListDocumentData.setContent(NotesDataConverter.byteToString(cursorQuery.isNull(6) ? null : cursorQuery.getBlob(6)));
                mainListDocumentData.setDisplayContent(cursorQuery.isNull(7) ? null : cursorQuery.getBlob(7));
                mainListDocumentData.setCreatedAt(cursorQuery.getLong(8));
                mainListDocumentData.setLastModifiedAt(cursorQuery.getLong(9));
                mainListDocumentData.setVrUuid(cursorQuery.isNull(10) ? null : cursorQuery.getString(10));
                mainListDocumentData.setContentUuid(cursorQuery.isNull(11) ? null : cursorQuery.getString(11));
                mainListDocumentData.setFirstContentType(cursorQuery.isNull(12) ? null : Integer.valueOf(cursorQuery.getInt(12)));
                mainListDocumentData.setSecondContentType(cursorQuery.isNull(13) ? null : Integer.valueOf(cursorQuery.getInt(13)));
                mainListDocumentData.setStrokeUuid(cursorQuery.isNull(14) ? null : cursorQuery.getString(14));
                mainListDocumentData.setCategoryUuid(cursorQuery.isNull(15) ? null : cursorQuery.getString(15));
                mainListDocumentData.setFilePath(cursorQuery.isNull(16) ? null : cursorQuery.getString(16));
                mainListDocumentData.setIsFavorite(cursorQuery.getInt(17));
                mainListDocumentData.setIsLock(cursorQuery.getInt(18));
                mainListDocumentData.setIsSavingByWhichPid(cursorQuery.getInt(19));
                mainListDocumentData.setRecycleBinTimeMoved(cursorQuery.getLong(20));
                mainListDocumentData.setFirstOpenedAt(cursorQuery.getLong(21));
                mainListDocumentData.setMdeSpaceId(cursorQuery.isNull(22) ? null : cursorQuery.getString(22));
                mainListDocumentData.setMdeItemId(cursorQuery.isNull(23) ? null : cursorQuery.getString(23));
                mainListDocumentData.setMdeGroupId(cursorQuery.isNull(24) ? null : cursorQuery.getString(24));
                mainListDocumentData.setMdeOwnerId(cursorQuery.isNull(25) ? null : cursorQuery.getString(25));
                mainListDocumentData.setAbsolutePath(cursorQuery.isNull(26) ? null : cursorQuery.getString(26));
                mainListDocumentData.setBackgroundColor(cursorQuery.getInt(27));
                mainListDocumentData.setBackgroundColorInverted(cursorQuery.getInt(28));
                mainListDocumentData.setCorrupted(cursorQuery.getInt(29));
                mainListDocumentData.setPageMode(cursorQuery.getInt(30));
                mainListDocumentData.setSize(cursorQuery.getLong(31));
                mainListDocumentData.setCoverTemplateUuid(cursorQuery.isNull(32) ? null : cursorQuery.getString(32));
                mainListDocumentData.setCoverSummary(cursorQuery.isNull(33) ? null : cursorQuery.getString(33));
                mainListDocumentData.setCoverSummaryAlignment(cursorQuery.getInt(34));
                mainListDocumentData.setCoverStickerUuid(cursorQuery.isNull(35) ? null : cursorQuery.getString(35));
                mainListDocumentData.setCoverBackgroundColor(cursorQuery.isNull(36) ? null : cursorQuery.getString(36));
                mainListDocumentData.setIsCoverEnabled(cursorQuery.getInt(37));
                mainListDocumentData.coverSuggestedState = cursorQuery.getInt(38);
                mainListDocumentData.setSyncState(cursorQuery.getLong(39));
                mainListDocumentData.setHasSticky(cursorQuery.getInt(40));
                mainListDocumentData.setUnknownMinVersion(cursorQuery.getInt(41));
                mainListDocumentData.setFormatVersion(cursorQuery.getInt(42));
                mainListDocumentData.setBackgroundType(cursorQuery.getInt(43));
                mainListDocumentData.setLayout(cursorQuery.getInt(44));
                mainListDocumentData.setImagePath(cursorQuery.isNull(45) ? null : cursorQuery.getString(45));
                mainListDocumentData.setPlayTime(cursorQuery.isNull(46) ? null : cursorQuery.getString(46));
                arrayList.add(mainListDocumentData);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }
}
