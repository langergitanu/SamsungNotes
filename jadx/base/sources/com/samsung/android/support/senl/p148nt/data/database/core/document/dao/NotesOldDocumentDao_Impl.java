package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.NotesDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesOldDocumentDao_Impl extends NotesOldDocumentDao {
    private final RoomDatabase __db;

    public NotesOldDocumentDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: __entityCursorConverter_comSamsungAndroidSupportSenlNtDataDatabaseCoreDocumentDataMainListDocumentData */
    public MainListDocumentData m12383x1be9442c(Cursor cursor) {
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOldDocumentDao
    public int getAll_OldNotes_Count(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM sdoc AS doc WHERE doc.mdeSpaceId='' AND doc.isDeleted=? AND doc.filePath LIKE '%.sdoc'", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOldDocumentDao
    public boolean hasOldNoteInUse() {
        boolean z = false;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT 1 FROM sdoc WHERE sdoc.mdeSpaceId='' AND sdoc.isDeleted= 0 AND sdoc.filePath LIKE '%.sdoc'", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOldDocumentDao
    public boolean includeOldNotes(List<String> list) {
        this.__db.beginTransaction();
        try {
            boolean zIncludeOldNotes = super.includeOldNotes(list);
            this.__db.setTransactionSuccessful();
            return zIncludeOldNotes;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOldDocumentDao
    public boolean includeOldNotesInChunk(List<String> list) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT 1 FROM sdoc WHERE sdoc.UUID IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(") AND sdoc.filePath LIKE '%.sdoc'");
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
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) != 0 : false;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOldDocumentDao
    public List<MainListDocumentData> internalRawQuery(SupportSQLiteQuery supportSQLiteQuery) {
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, supportSQLiteQuery, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(m12383x1be9442c(cursorQuery));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOldDocumentDao
    public LiveData<List<MainListDocumentData>> internalRawQuery_LiveData(final SupportSQLiteQuery supportSQLiteQuery) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"sdoc", "document_cover", "suggested_cover"}, false, new Callable<List<MainListDocumentData>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesOldDocumentDao_Impl.1
            @Override // java.util.concurrent.Callable
            public List<MainListDocumentData> call() {
                Cursor cursorQuery = DBUtil.query(NotesOldDocumentDao_Impl.this.__db, supportSQLiteQuery, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(NotesOldDocumentDao_Impl.this.m12383x1be9442c(cursorQuery));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }
}
