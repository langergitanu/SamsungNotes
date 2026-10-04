package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.database.Cursor;
import android.util.Pair;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
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
import com.samsung.android.support.senl.p148nt.data.common.legacy.OldDBSchema;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTagEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesTagDocCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesTagDao_Impl extends NotesTagDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<NotesTagEntity> __deletionAdapterOfNotesTagEntity;
    private final EntityInsertionAdapter<NotesTagEntity> __insertionAdapterOfNotesTagEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByUuid;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDummy;
    private final EntityDeletionOrUpdateAdapter<NotesTagEntity> __updateAdapterOfNotesTagEntity;

    public NotesTagDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNotesTagEntity = new EntityInsertionAdapter<NotesTagEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesTagDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `tag_list` (`_id`,`normalizeName`,`docUUID`,`displayName`) VALUES (?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesTagEntity notesTagEntity) {
                if (notesTagEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesTagEntity.getId().longValue());
                }
                if (notesTagEntity.getNormalizeName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesTagEntity.getNormalizeName());
                }
                if (notesTagEntity.getDocUuid() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesTagEntity.getDocUuid());
                }
                if (notesTagEntity.getDisplayName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, notesTagEntity.getDisplayName());
                }
            }
        };
        this.__deletionAdapterOfNotesTagEntity = new EntityDeletionOrUpdateAdapter<NotesTagEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesTagDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `tag_list` WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesTagEntity notesTagEntity) {
                if (notesTagEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesTagEntity.getId().longValue());
                }
            }
        };
        this.__updateAdapterOfNotesTagEntity = new EntityDeletionOrUpdateAdapter<NotesTagEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesTagDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `tag_list` SET `_id` = ?,`normalizeName` = ?,`docUUID` = ?,`displayName` = ? WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesTagEntity notesTagEntity) {
                if (notesTagEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesTagEntity.getId().longValue());
                }
                if (notesTagEntity.getNormalizeName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesTagEntity.getNormalizeName());
                }
                if (notesTagEntity.getDocUuid() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesTagEntity.getDocUuid());
                }
                if (notesTagEntity.getDisplayName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, notesTagEntity.getDisplayName());
                }
                if (notesTagEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, notesTagEntity.getId().longValue());
                }
            }
        };
        this.__preparedStmtOfDeleteByUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesTagDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM tag_list WHERE docUUID=?";
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesTagDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM tag_list";
            }
        };
        this.__preparedStmtOfDeleteDummy = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesTagDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM tag_list WHERE docUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)";
            }
        };
    }

    /* JADX INFO: renamed from: __entityCursorConverter_comSamsungAndroidSupportSenlNtDataDatabaseCoreDocumentEntityNotesTagEntity */
    private NotesTagEntity m12399xe35e4285(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex(DBSchema.TagList.NORMALIZE_NAME);
        int columnIndex3 = cursor.getColumnIndex("docUUID");
        int columnIndex4 = cursor.getColumnIndex("displayName");
        NotesTagEntity notesTagEntity = new NotesTagEntity();
        if (columnIndex != -1) {
            notesTagEntity.setId(cursor.isNull(columnIndex) ? null : Long.valueOf(cursor.getLong(columnIndex)));
        }
        if (columnIndex2 != -1) {
            notesTagEntity.setNormalizeName(cursor.isNull(columnIndex2) ? null : cursor.getString(columnIndex2));
        }
        if (columnIndex3 != -1) {
            notesTagEntity.setDocUuid(cursor.isNull(columnIndex3) ? null : cursor.getString(columnIndex3));
        }
        if (columnIndex4 != -1) {
            notesTagEntity.setDisplayName(cursor.isNull(columnIndex4) ? null : cursor.getString(columnIndex4));
        }
        return notesTagEntity;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public boolean addTagsByDocUuid(List<String> list, String str) {
        this.__db.beginTransaction();
        try {
            boolean zAddTagsByDocUuid = super.addTagsByDocUuid(list, str);
            this.__db.setTransactionSuccessful();
            return zAddTagsByDocUuid;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public boolean addTagsByDocUuidList(List<List<String>> list, List<String> list2) {
        this.__db.beginTransaction();
        try {
            boolean zAddTagsByDocUuidList = super.addTagsByDocUuidList(list, list2);
            this.__db.setTransactionSuccessful();
            return zAddTagsByDocUuidList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public void deleteByUuid(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            super.deleteByUuid(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public void deleteByUuids(Collection<String> collection) {
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, AbstractC11014a.m12324i(this.__db, "DELETE FROM tag_list WHERE docUUID IN ("), ")"));
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public List<NotesTagEntity> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `tag_list`.`_id` AS `_id`, `tag_list`.`normalizeName` AS `normalizeName`, `tag_list`.`docUUID` AS `docUUID`, `tag_list`.`displayName` AS `displayName`  FROM tag_list", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesTagEntity notesTagEntity = new NotesTagEntity();
                notesTagEntity.setId(cursorQuery.isNull(0) ? null : Long.valueOf(cursorQuery.getLong(0)));
                notesTagEntity.setNormalizeName(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                notesTagEntity.setDocUuid(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                notesTagEntity.setDisplayName(cursorQuery.isNull(3) ? null : cursorQuery.getString(3));
                arrayList.add(notesTagEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public List<NotesTagDocCountEntry> getAllTagListWithDocCount(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT SUM(docCountOri) AS docCount, _id, normalizeName, docUUID, displayName FROM (SELECT sdoc.serverTimestamp AS sortTime, tag_list._id AS _id, tag_list.normalizeName AS normalizeName, tag_list.docUUID AS docUUID, tag_list.displayName as displayName, count(tag_list.docUUID) AS docCountOri FROM tag_list JOIN sdoc ON tag_list.docUUID = sdoc.UUID WHERE sdoc.isDeleted = 0 GROUP BY tag_list.normalizeName  UNION ALL SELECT hashtagContent.serverTimestamp AS sortTime, hashtagContent._id AS _id, LOWER(hashtag.name) AS normalizeName, hashtagContent.sdocUUID AS docUUID, hashtag.name as displayName, COUNT(*) AS docCountOri FROM hashtag JOIN sdoc ON hashtagContent.sdocUUID = sdoc.UUID JOIN hashtagContent ON hashtagContent.hashtagUUID = hashtag.UUID LEFT OUTER JOIN mapped_document ON sdoc.UUID = mapped_document.UUID  WHERE sdoc.isDeleted = 0 AND mapped_document.UUID IS NULL  GROUP BY hashtag.UUID ) GROUP BY displayName  ORDER BY CASE WHEN ?=0 THEN normalizeName END ASC, CASE WHEN ?=1 THEN docCount END DESC,  CASE WHEN ?=2 THEN _id END DESC", 3);
        long j = i;
        roomSQLiteQueryAcquire.bindLong(1, j);
        roomSQLiteQueryAcquire.bindLong(2, j);
        roomSQLiteQueryAcquire.bindLong(3, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesTagDocCountEntry notesTagDocCountEntry = new NotesTagDocCountEntry();
                notesTagDocCountEntry.setDocCount(cursorQuery.getInt(0));
                notesTagDocCountEntry.setId(cursorQuery.isNull(1) ? null : Long.valueOf(cursorQuery.getLong(1)));
                notesTagDocCountEntry.setNormalizeName(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                notesTagDocCountEntry.setDocUuid(cursorQuery.isNull(3) ? null : cursorQuery.getString(3));
                notesTagDocCountEntry.setDisplayName(cursorQuery.isNull(4) ? null : cursorQuery.getString(4));
                arrayList.add(notesTagDocCountEntry);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public LiveData<List<NotesTagDocCountEntry>> getAllTagListWithDocCount_LiveData(int i) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT SUM(docCountOri) AS docCount, _id, normalizeName, docUUID, displayName FROM (SELECT sdoc.serverTimestamp AS sortTime, tag_list._id AS _id, tag_list.normalizeName AS normalizeName, tag_list.docUUID AS docUUID, tag_list.displayName as displayName, count(tag_list.docUUID) AS docCountOri FROM tag_list JOIN sdoc ON tag_list.docUUID = sdoc.UUID WHERE sdoc.isDeleted = 0 GROUP BY tag_list.normalizeName  UNION ALL SELECT hashtagContent.serverTimestamp AS sortTime, hashtagContent._id AS _id, LOWER(hashtag.name) AS normalizeName, hashtagContent.sdocUUID AS docUUID, hashtag.name as displayName, COUNT(*) AS docCountOri FROM hashtag JOIN sdoc ON hashtagContent.sdocUUID = sdoc.UUID JOIN hashtagContent ON hashtagContent.hashtagUUID = hashtag.UUID LEFT OUTER JOIN mapped_document ON sdoc.UUID = mapped_document.UUID  WHERE sdoc.isDeleted = 0 AND mapped_document.UUID IS NULL  GROUP BY hashtag.UUID ) GROUP BY displayName  ORDER BY CASE WHEN ?=0 THEN normalizeName END ASC, CASE WHEN ?=1 THEN docCount END DESC,  CASE WHEN ?=2 THEN _id END DESC", 3);
        long j = i;
        roomSQLiteQueryAcquire.bindLong(1, j);
        roomSQLiteQueryAcquire.bindLong(2, j);
        roomSQLiteQueryAcquire.bindLong(3, j);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"tag_list", "sdoc", OldDBSchema.HashTag.TABLE_NAME, OldDBSchema.HashTagContent.TABLE_NAME, DBSchema.MappedDocument.TABLE_NAME}, false, new Callable<List<NotesTagDocCountEntry>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesTagDao_Impl.7
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<NotesTagDocCountEntry> call() {
                Cursor cursorQuery = DBUtil.query(NotesTagDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        NotesTagDocCountEntry notesTagDocCountEntry = new NotesTagDocCountEntry();
                        notesTagDocCountEntry.setDocCount(cursorQuery.getInt(0));
                        notesTagDocCountEntry.setId(cursorQuery.isNull(1) ? null : Long.valueOf(cursorQuery.getLong(1)));
                        notesTagDocCountEntry.setNormalizeName(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                        notesTagDocCountEntry.setDocUuid(cursorQuery.isNull(3) ? null : cursorQuery.getString(3));
                        notesTagDocCountEntry.setDisplayName(cursorQuery.isNull(4) ? null : cursorQuery.getString(4));
                        arrayList.add(notesTagDocCountEntry);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public List<String> getAllTagsInUse() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT name FROM (SELECT tag_list.displayName AS name FROM tag_list JOIN sdoc ON tag_list.docUUID = sdoc.UUID WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 GROUP BY tag_list.normalizeName  UNION SELECT hashtag.name AS name FROM hashtag LEFT JOIN hashtagContent ON hashtag.UUID = hashtagContent.hashtagUUID LEFT JOIN sdoc ON hashtagContent.sdocUUID = sdoc.UUID LEFT OUTER JOIN mapped_document ON hashtagContent.sdocUUID = mapped_document.UUID  WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND mapped_document.UUID IS NULL GROUP BY LOWER(hashtag.name)) GROUP BY LOWER(name) ORDER BY LOWER(name) ASC", 0);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public int getNotesCountUsingTag() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM(SELECT docUUID FROM tag_list UNION SELECT sdocUUID FROM hashtagContent)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public List<NotesTagEntity> getRecentTagList(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT MAX(tag_list._id), tag_list.normalizeName, tag_list.docUUID, tag_list.displayName FROM tag_list INNER JOIN sdoc ON (tag_list.docUUID=sdoc.UUID) WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 GROUP BY tag_list.normalizeName  ORDER BY tag_list._id DESC  LIMIT ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesTagEntity notesTagEntity = new NotesTagEntity();
                notesTagEntity.setNormalizeName(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                notesTagEntity.setDocUuid(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                notesTagEntity.setDisplayName(cursorQuery.isNull(3) ? null : cursorQuery.getString(3));
                arrayList.add(notesTagEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public List<NotesTagEntity> getRelatedTagList(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT tag_list.* FROM tag_list JOIN sdoc ON tag_list.docUUID = sdoc.UUID WHERE sdoc.isDeleted = 0 AND tag_list.docUUID IN (SELECT tag_list.docUUID FROM tag_list WHERE tag_list.normalizeName=? GROUP BY tag_list.docUUID) GROUP BY tag_list.normalizeName  ORDER BY tag_list.normalizeName ASC", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.TagList.NORMALIZE_NAME);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "docUUID");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayName");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesTagEntity notesTagEntity = new NotesTagEntity();
                notesTagEntity.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow)));
                notesTagEntity.setNormalizeName(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                notesTagEntity.setDocUuid(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                notesTagEntity.setDisplayName(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                arrayList.add(notesTagEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public List<String> getRelatedTags(Collection<String> collection, int i) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        int iM12317b = AbstractC11014a.m12317b(sbNewStringBuilder, "SELECT name FROM(SELECT tag_list.displayName AS name FROM tag_list JOIN sdoc ON tag_list.docUUID = sdoc.UUID WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND tag_list.docUUID IN (SELECT tag_list.docUUID FROM tag_list WHERE tag_list.normalizeName IN (", collection, sbNewStringBuilder, ") GROUP BY tag_list.docUUID HAVING COUNT(*)=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(") GROUP BY tag_list.normalizeName  UNION SELECT hashtag.name AS name FROM hashtag JOIN hashtagContent ON hashtag.UUID = hashtagContent.hashtagUUID JOIN sdoc ON hashtagContent.sdocUUID = sdoc.UUID WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND hashtagContent.sdocUUID IN (SELECT hashtagContent.sdocUUID FROM hashtagContent JOIN hashtag ON hashtagContent.hashtagUUID = hashtag.UUID LEFT OUTER JOIN mapped_document ON hashtagContent.sdocUUID = mapped_document.UUID  WHERE mapped_document.UUID IS NULL AND LOWER(hashtag.name) IN (");
        int size = collection.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        int i2 = iM12317b + 2;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(AbstractC2322a.m1626p(sbNewStringBuilder, ") GROUP BY hashtagContent.sdocUUID HAVING COUNT(*)=", MsalUtils.QUERY_STRING_SYMBOL, ") GROUP BY LOWER(hashtag.name)) GROUP BY LOWER(name) ORDER BY LOWER(name) ASC"), size + i2);
        int i4 = 1;
        for (String str : collection) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i4);
            } else {
                roomSQLiteQueryAcquire.bindString(i4, str);
            }
            i4++;
        }
        long j = i;
        roomSQLiteQueryAcquire.bindLong(iM12317b + 1, j);
        int i5 = i2;
        for (String str2 : collection) {
            if (str2 == null) {
                roomSQLiteQueryAcquire.bindNull(i5);
            } else {
                roomSQLiteQueryAcquire.bindString(i5, str2);
            }
            i5++;
        }
        roomSQLiteQueryAcquire.bindLong(i2 + iM12317b, j);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public List<NotesTagEntity> getTagListByDocUuid(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM tag_list WHERE docUUID=?  ORDER BY displayName ASC", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.TagList.NORMALIZE_NAME);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "docUUID");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "displayName");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesTagEntity notesTagEntity = new NotesTagEntity();
                notesTagEntity.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow)));
                notesTagEntity.setNormalizeName(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                notesTagEntity.setDocUuid(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                notesTagEntity.setDisplayName(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                arrayList.add(notesTagEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public List<String> getTagNormalizeNameListByDocUuid(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT normalizeName FROM tag_list WHERE docUUID=?  ORDER BY displayName ASC", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public boolean isTagExistByNormalizedName(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT _id, normalizeName FROM tag_list WHERE normalizeName=? LIMIT 1", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public boolean isTagsExistByDocUuid(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT 1 FROM tag_list WHERE docUUID=?", 1);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public List<NotesTagEntity> rawQuery(SupportSQLiteQuery supportSQLiteQuery) {
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, supportSQLiteQuery, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(m12399xe35e4285(cursorQuery));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public Cursor rawQueryForTagBoard(SupportSQLiteQuery supportSQLiteQuery) {
        return this.__db.query(supportSQLiteQuery);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public boolean updateTagsByDocUuid(Collection<String> collection, String str) {
        this.__db.beginTransaction();
        try {
            boolean zUpdateTagsByDocUuid = super.updateTagsByDocUuid(collection, str);
            this.__db.setTransactionSuccessful();
            return zUpdateTagsByDocUuid;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(NotesTagEntity notesTagEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfNotesTagEntity.handle(notesTagEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(NotesTagEntity notesTagEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfNotesTagEntity.insert(notesTagEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(NotesTagEntity notesTagEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfNotesTagEntity.handle(notesTagEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(NotesTagEntity notesTagEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(notesTagEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public void deleteByUuid(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteByUuid.acquire();
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
            this.__preparedStmtOfDeleteByUuid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends NotesTagEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public int update(Collection<NotesTagEntity> collection) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandleMultiple = this.__updateAdapterOfNotesTagEntity.handleMultiple(collection);
            this.__db.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao
    public boolean isTagsExistByDocUuid(List<String> list) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT 1 FROM tag_list WHERE docUUID IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
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
}
