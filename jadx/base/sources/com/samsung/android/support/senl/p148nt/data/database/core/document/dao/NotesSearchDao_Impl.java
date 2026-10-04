package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.database.Cursor;
import android.util.Pair;
import androidx.collection.AbstractC0622a;
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
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.NotesDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.DocumentTextData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentTextSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesSearchDao_Impl extends NotesSearchDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<NotesDocumentTextSearchEntity> __deletionAdapterOfNotesDocumentTextSearchEntity;
    private final EntityInsertionAdapter<NotesDocumentTextSearchEntity> __insertionAdapterOfNotesDocumentTextSearchEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDummy;
    private final EntityDeletionOrUpdateAdapter<NotesDocumentTextSearchEntity> __updateAdapterOfNotesDocumentTextSearchEntity;

    public NotesSearchDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNotesDocumentTextSearchEntity = new EntityInsertionAdapter<NotesDocumentTextSearchEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesSearchDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `text_search` (`sdocUUID`,`strippedContent`,`filePath`) VALUES (?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesDocumentTextSearchEntity notesDocumentTextSearchEntity) {
                if (notesDocumentTextSearchEntity.getDocUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, notesDocumentTextSearchEntity.getDocUuid());
                }
                byte[] bArrStringToByteArray = NotesDataConverter.stringToByteArray(notesDocumentTextSearchEntity.getStrippedContent());
                if (bArrStringToByteArray == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindBlob(2, bArrStringToByteArray);
                }
                if (notesDocumentTextSearchEntity.getFilePath() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesDocumentTextSearchEntity.getFilePath());
                }
            }
        };
        this.__deletionAdapterOfNotesDocumentTextSearchEntity = new EntityDeletionOrUpdateAdapter<NotesDocumentTextSearchEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesSearchDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `text_search` WHERE `sdocUUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesDocumentTextSearchEntity notesDocumentTextSearchEntity) {
                if (notesDocumentTextSearchEntity.getDocUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, notesDocumentTextSearchEntity.getDocUuid());
                }
            }
        };
        this.__updateAdapterOfNotesDocumentTextSearchEntity = new EntityDeletionOrUpdateAdapter<NotesDocumentTextSearchEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesSearchDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `text_search` SET `sdocUUID` = ?,`strippedContent` = ?,`filePath` = ? WHERE `sdocUUID` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesDocumentTextSearchEntity notesDocumentTextSearchEntity) {
                if (notesDocumentTextSearchEntity.getDocUuid() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, notesDocumentTextSearchEntity.getDocUuid());
                }
                byte[] bArrStringToByteArray = NotesDataConverter.stringToByteArray(notesDocumentTextSearchEntity.getStrippedContent());
                if (bArrStringToByteArray == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindBlob(2, bArrStringToByteArray);
                }
                if (notesDocumentTextSearchEntity.getFilePath() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesDocumentTextSearchEntity.getFilePath());
                }
                if (notesDocumentTextSearchEntity.getDocUuid() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, notesDocumentTextSearchEntity.getDocUuid());
                }
            }
        };
        this.__preparedStmtOfDeleteDummy = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesSearchDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM text_search WHERE sdocUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)";
            }
        };
    }

    /* JADX INFO: renamed from: __entityCursorConverter_comSamsungAndroidSupportSenlNtDataDatabaseCoreDocumentDataMainListDocumentData */
    private MainListDocumentData m12395x1be9442c(Cursor cursor) {
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

    /* JADX INFO: renamed from: __entityCursorConverter_comSamsungAndroidSupportSenlNtDataDatabaseCoreDocumentEntityNotesCategoryTreeEntity */
    private NotesCategoryTreeEntity m12396xe87aef57(Cursor cursor) {
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesSearchDao
    public void deleteByUuid(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            super.deleteByUuid(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesSearchDao
    public void deleteByUuids(Collection<String> collection) {
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesSearchDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesSearchDao
    public List<DocumentTextData> getDocumentTextData(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            List<DocumentTextData> documentTextData = super.getDocumentTextData(collection);
            this.__db.setTransactionSuccessful();
            return documentTextData;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesSearchDao
    public List<DocumentTextData> getDocumentTextDataWithDocUuids(List<String> list) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT UUID, title, strippedContent FROM (SELECT UUID, title FROM sdoc WHERE UUID IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(") AND sdoc.isDeleted = 0) JOIN text_search ON UUID = text_search.sdocUUID");
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
                DocumentTextData documentTextData = new DocumentTextData();
                documentTextData.setUuid(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                documentTextData.setTitle(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                documentTextData.setStrippedContent(NotesDataConverter.byteToString(cursorQuery.isNull(2) ? null : cursorQuery.getBlob(2)));
                arrayList.add(documentTextData);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesSearchDao
    public List<NotesDocumentTextSearchEntity> getEntities(Collection<String> collection) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), AbstractC11014a.m12317b(sbNewStringBuilder, "SELECT * FROM text_search WHERE sdocUUID IN (", collection, sbNewStringBuilder, ")"));
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
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sdocUUID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "strippedContent");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filePath");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesDocumentTextSearchEntity notesDocumentTextSearchEntity = new NotesDocumentTextSearchEntity();
                notesDocumentTextSearchEntity.setDocUuid(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                notesDocumentTextSearchEntity.setStrippedContent(NotesDataConverter.byteToString(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getBlob(columnIndexOrThrow2)));
                notesDocumentTextSearchEntity.setFilePath(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                arrayList.add(notesDocumentTextSearchEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesSearchDao
    public List<MainListDocumentData> internalRawQuery(SupportSQLiteQuery supportSQLiteQuery) {
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, supportSQLiteQuery, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(m12395x1be9442c(cursorQuery));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesSearchDao
    public boolean isEmptyForSearchLatestNotes() {
        boolean z = false;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT 1 FROM sdoc WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND mdeSpaceId = ''", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesSearchDao
    public List<NotesCategoryTreeEntity> rawQueryForFolder(SupportSQLiteQuery supportSQLiteQuery) {
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, supportSQLiteQuery, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(m12396xe87aef57(cursorQuery));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesSearchDao
    public List<NotesCategoryTreeEntity> searchLatestFolders(int i, Collection<String> collection) throws Throwable {
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
        int i2;
        String string;
        int i4;
        String string2;
        int i5;
        String string3;
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        int i6 = 1;
        int iM12317b = AbstractC11014a.m12317b(sbNewStringBuilder, "SELECT * FROM category_tree WHERE category_tree.isDeleted = 0 AND UUID NOT IN (", collection, sbNewStringBuilder, ") ORDER BY lastModifiedAt DESC LIMIT (") + 1;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(AbstractC0622a.m1170p(MsalUtils.QUERY_STRING_SYMBOL, ")", sbNewStringBuilder), iM12317b);
        for (String str : collection) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i6);
            } else {
                roomSQLiteQueryAcquire.bindString(i6, str);
            }
            i6++;
        }
        roomSQLiteQueryAcquire.bindLong(iM12317b, i);
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
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string4 = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                if (cursorQuery.isNull(columnIndexOrThrow2)) {
                    i2 = columnIndexOrThrow;
                    string = null;
                } else {
                    i2 = columnIndexOrThrow;
                    string = cursorQuery.getString(columnIndexOrThrow2);
                }
                if (cursorQuery.isNull(columnIndexOrThrow9)) {
                    i4 = columnIndexOrThrow2;
                    string2 = null;
                } else {
                    i4 = columnIndexOrThrow2;
                    string2 = cursorQuery.getString(columnIndexOrThrow9);
                }
                if (cursorQuery.isNull(columnIndexOrThrow10)) {
                    i5 = columnIndexOrThrow9;
                    string3 = null;
                } else {
                    i5 = columnIndexOrThrow9;
                    string3 = cursorQuery.getString(columnIndexOrThrow10);
                }
                int i7 = columnIndexOrThrow10;
                NotesCategoryTreeEntity notesCategoryTreeEntity = new NotesCategoryTreeEntity(string4, string, string2, string3);
                notesCategoryTreeEntity.setIsDeleted(cursorQuery.getInt(columnIndexOrThrow3));
                notesCategoryTreeEntity.setIsDirty(cursorQuery.getInt(columnIndexOrThrow4));
                notesCategoryTreeEntity.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow5));
                notesCategoryTreeEntity.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow6));
                notesCategoryTreeEntity.setServerTimeStamp(cursorQuery.isNull(columnIndexOrThrow7) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow7)));
                notesCategoryTreeEntity.setRecycleBinTimeMoved(cursorQuery.getLong(columnIndexOrThrow8));
                notesCategoryTreeEntity.setReorder(cursorQuery.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow11)));
                notesCategoryTreeEntity.setDisplayNameColor(cursorQuery.getInt(columnIndexOrThrow12));
                notesCategoryTreeEntity.setIsSyncWithMS(cursorQuery.getInt(columnIndexOrThrow13));
                arrayList.add(notesCategoryTreeEntity);
                columnIndexOrThrow = i2;
                columnIndexOrThrow10 = i7;
                columnIndexOrThrow2 = i4;
                columnIndexOrThrow9 = i5;
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesSearchDao
    public List<DocumentTextData> searchLatestNotes2(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT sdoc.UUID, sdoc.title, text_search.strippedContent FROM sdoc JOIN text_search ON sdoc.UUID = text_search.sdocUUID WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND mdeSpaceId = '' ORDER BY sdoc.lastModifiedAt DESC LIMIT (?)", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                DocumentTextData documentTextData = new DocumentTextData();
                documentTextData.setUuid(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                documentTextData.setTitle(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                documentTextData.setStrippedContent(NotesDataConverter.byteToString(cursorQuery.isNull(2) ? null : cursorQuery.getBlob(2)));
                arrayList.add(documentTextData);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(NotesDocumentTextSearchEntity notesDocumentTextSearchEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfNotesDocumentTextSearchEntity.handle(notesDocumentTextSearchEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(NotesDocumentTextSearchEntity notesDocumentTextSearchEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfNotesDocumentTextSearchEntity.insert(notesDocumentTextSearchEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(NotesDocumentTextSearchEntity notesDocumentTextSearchEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfNotesDocumentTextSearchEntity.handle(notesDocumentTextSearchEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(NotesDocumentTextSearchEntity notesDocumentTextSearchEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(notesDocumentTextSearchEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends NotesDocumentTextSearchEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
