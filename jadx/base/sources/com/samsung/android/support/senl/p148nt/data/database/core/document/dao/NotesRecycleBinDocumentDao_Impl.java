package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
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

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesRecycleBinDocumentDao_Impl extends NotesRecycleBinDocumentDao {
    private final RoomDatabase __db;
    private final SharedSQLiteStatement __preparedStmtOfCorrectDocumentRecycleBinTime;
    private final SharedSQLiteStatement __preparedStmtOfCorrectFolderRecycleBinTime;

    public NotesRecycleBinDocumentDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__preparedStmtOfCorrectDocumentRecycleBinTime = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesRecycleBinDocumentDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT category_tree SET recycle_bin_time_moved=? , isDirty=1 , serverTimestamp=? WHERE isDeleted=2 AND recycle_bin_time_moved=0";
            }
        };
        this.__preparedStmtOfCorrectFolderRecycleBinTime = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesRecycleBinDocumentDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT sdoc SET recycle_bin_time_moved=? , isDirty=1 , serverTimestamp=? WHERE isDeleted=2 AND recycle_bin_time_moved=0";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: __entityCursorConverter_comSamsungAndroidSupportSenlNtDataDatabaseCoreDocumentDataMainListDocumentData */
    public MainListDocumentData m12388x1be9442c(Cursor cursor) {
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao
    public int correctDocumentRecycleBinTime(long j, long j2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfCorrectDocumentRecycleBinTime.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j);
        supportSQLiteStatementAcquire.bindLong(2, j2);
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfCorrectDocumentRecycleBinTime.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao
    public int correctFolderRecycleBinTime(long j, long j2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfCorrectFolderRecycleBinTime.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j);
        supportSQLiteStatementAcquire.bindLong(2, j2);
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfCorrectFolderRecycleBinTime.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao
    public int correctRecycleBinTime(long j, long j2) {
        this.__db.beginTransaction();
        try {
            int iCorrectRecycleBinTime = super.correctRecycleBinTime(j, j2);
            this.__db.setTransactionSuccessful();
            return iCorrectRecycleBinTime;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao
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
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `sdoc`.* FROM sdoc WHERE isDeleted=? AND mdeSpaceId='' ORDER BY CASE WHEN ?=1 THEN lastModifiedAt END DESC, CASE WHEN ?=0 THEN lastModifiedAt END ASC", 3);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao
    public List<String> getAllFilePathsInRecycleBin(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT sdoc.filePath FROM sdoc WHERE isDeleted=? AND mdeSpaceId=''", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao
    public List<String> getDocumentsInRecycleBin(Collection<String> collection) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), AbstractC11014a.m12317b(sbNewStringBuilder, "SELECT sdoc.UUID FROM sdoc WHERE sdoc.isDeleted = 2 AND sdoc.UUID IN (", collection, sbNewStringBuilder, ")"));
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao
    public int getFolderCount(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM category_tree WHERE isDeleted=? AND parentUUID= 'trash:///'", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao
    public List<String> getFoldersInRecycleBin(Collection<String> collection) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), AbstractC11014a.m12317b(sbNewStringBuilder, "SELECT category_tree.UUID FROM category_tree WHERE category_tree.isDeleted = 2 AND category_tree.UUID IN (", collection, sbNewStringBuilder, ")"));
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao
    public int getItemCount(int i) {
        this.__db.beginTransaction();
        try {
            int itemCount = super.getItemCount(i);
            this.__db.setTransactionSuccessful();
            return itemCount;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao
    public int getNoteCount(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM sdoc WHERE isDeleted=? AND categoryUUID= 'trash:///' AND mdeSpaceId=''", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao
    public List<MainListDocumentData> internalRawQuery(SupportSQLiteQuery supportSQLiteQuery) {
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, supportSQLiteQuery, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(m12388x1be9442c(cursorQuery));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao
    public LiveData<List<MainListDocumentData>> internalRawQuery_LiveData(final SupportSQLiteQuery supportSQLiteQuery) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"sdoc", "document_cover", "suggested_cover"}, false, new Callable<List<MainListDocumentData>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesRecycleBinDocumentDao_Impl.3
            @Override // java.util.concurrent.Callable
            public List<MainListDocumentData> call() {
                Cursor cursorQuery = DBUtil.query(NotesRecycleBinDocumentDao_Impl.this.__db, supportSQLiteQuery, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(NotesRecycleBinDocumentDao_Impl.this.m12388x1be9442c(cursorQuery));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao
    public boolean isEmpty() {
        boolean z = false;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT NOT EXISTS (SELECT 1 FROM sdoc WHERE sdoc.isDeleted = 2)", 0);
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
}
