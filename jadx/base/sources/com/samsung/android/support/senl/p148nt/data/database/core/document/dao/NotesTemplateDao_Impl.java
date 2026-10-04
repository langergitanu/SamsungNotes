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
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTemplateEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesTemplateDao_Impl extends NotesTemplateDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<NotesTemplateEntity> __deletionAdapterOfNotesTemplateEntity;
    private final EntityInsertionAdapter<NotesTemplateEntity> __insertionAdapterOfNotesTemplateEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByPath;
    private final SharedSQLiteStatement __preparedStmtOfUpdateTitle;
    private final EntityDeletionOrUpdateAdapter<NotesTemplateEntity> __updateAdapterOfNotesTemplateEntity;

    public NotesTemplateDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNotesTemplateEntity = new EntityInsertionAdapter<NotesTemplateEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesTemplateDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `document_template` (`_id`,`UUID`,`_data`,`_size`,`_display_name`,`title`,`createdAt`,`lastModifiedAt`,`mime_type`,`width`,`height`,`type`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesTemplateEntity notesTemplateEntity) {
                if (notesTemplateEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesTemplateEntity.getId().longValue());
                }
                if (notesTemplateEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesTemplateEntity.getUuid());
                }
                if (notesTemplateEntity.getData() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesTemplateEntity.getData());
                }
                supportSQLiteStatement.bindLong(4, notesTemplateEntity.getSize());
                if (notesTemplateEntity.getDisplayName() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, notesTemplateEntity.getDisplayName());
                }
                if (notesTemplateEntity.getTitle() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, notesTemplateEntity.getTitle());
                }
                supportSQLiteStatement.bindLong(7, notesTemplateEntity.getCreatedAt());
                supportSQLiteStatement.bindLong(8, notesTemplateEntity.getLastModifiedAt());
                if (notesTemplateEntity.getMimeType() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, notesTemplateEntity.getMimeType());
                }
                supportSQLiteStatement.bindLong(10, notesTemplateEntity.getWidth());
                supportSQLiteStatement.bindLong(11, notesTemplateEntity.getHeight());
                supportSQLiteStatement.bindLong(12, notesTemplateEntity.getType());
            }
        };
        this.__deletionAdapterOfNotesTemplateEntity = new EntityDeletionOrUpdateAdapter<NotesTemplateEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesTemplateDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `document_template` WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesTemplateEntity notesTemplateEntity) {
                if (notesTemplateEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesTemplateEntity.getId().longValue());
                }
            }
        };
        this.__updateAdapterOfNotesTemplateEntity = new EntityDeletionOrUpdateAdapter<NotesTemplateEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesTemplateDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `document_template` SET `_id` = ?,`UUID` = ?,`_data` = ?,`_size` = ?,`_display_name` = ?,`title` = ?,`createdAt` = ?,`lastModifiedAt` = ?,`mime_type` = ?,`width` = ?,`height` = ?,`type` = ? WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesTemplateEntity notesTemplateEntity) {
                if (notesTemplateEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesTemplateEntity.getId().longValue());
                }
                if (notesTemplateEntity.getUuid() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, notesTemplateEntity.getUuid());
                }
                if (notesTemplateEntity.getData() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, notesTemplateEntity.getData());
                }
                supportSQLiteStatement.bindLong(4, notesTemplateEntity.getSize());
                if (notesTemplateEntity.getDisplayName() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, notesTemplateEntity.getDisplayName());
                }
                if (notesTemplateEntity.getTitle() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, notesTemplateEntity.getTitle());
                }
                supportSQLiteStatement.bindLong(7, notesTemplateEntity.getCreatedAt());
                supportSQLiteStatement.bindLong(8, notesTemplateEntity.getLastModifiedAt());
                if (notesTemplateEntity.getMimeType() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, notesTemplateEntity.getMimeType());
                }
                supportSQLiteStatement.bindLong(10, notesTemplateEntity.getWidth());
                supportSQLiteStatement.bindLong(11, notesTemplateEntity.getHeight());
                supportSQLiteStatement.bindLong(12, notesTemplateEntity.getType());
                if (notesTemplateEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindLong(13, notesTemplateEntity.getId().longValue());
                }
            }
        };
        this.__preparedStmtOfUpdateTitle = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesTemplateDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT document_template SET title=? WHERE UUID=?";
            }
        };
        this.__preparedStmtOfDeleteByPath = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesTemplateDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM document_template WHERE _data=?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTemplateDao
    public void deleteByPath(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            super.deleteByPath(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTemplateDao
    public List<NotesTemplateEntity> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `document_template`.`_id` AS `_id`, `document_template`.`UUID` AS `UUID`, `document_template`.`_data` AS `_data`, `document_template`.`_size` AS `_size`, `document_template`.`_display_name` AS `_display_name`, `document_template`.`title` AS `title`, `document_template`.`createdAt` AS `createdAt`, `document_template`.`lastModifiedAt` AS `lastModifiedAt`, `document_template`.`mime_type` AS `mime_type`, `document_template`.`width` AS `width`, `document_template`.`height` AS `height`, `document_template`.`type` AS `type`  FROM document_template", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesTemplateEntity notesTemplateEntity = new NotesTemplateEntity();
                notesTemplateEntity.setId(cursorQuery.isNull(0) ? null : Long.valueOf(cursorQuery.getLong(0)));
                notesTemplateEntity.setUuid(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                notesTemplateEntity.setData(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                notesTemplateEntity.setSize(cursorQuery.getInt(3));
                notesTemplateEntity.setDisplayName(cursorQuery.isNull(4) ? null : cursorQuery.getString(4));
                notesTemplateEntity.setTitle(cursorQuery.isNull(5) ? null : cursorQuery.getString(5));
                notesTemplateEntity.setCreatedAt(cursorQuery.getLong(6));
                notesTemplateEntity.setLastModifiedAt(cursorQuery.getLong(7));
                notesTemplateEntity.setMimeType(cursorQuery.isNull(8) ? null : cursorQuery.getString(8));
                notesTemplateEntity.setWidth(cursorQuery.getInt(9));
                notesTemplateEntity.setHeight(cursorQuery.getInt(10));
                notesTemplateEntity.setType(cursorQuery.getInt(11));
                arrayList.add(notesTemplateEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTemplateDao
    public LiveData<List<NotesTemplateEntity>> getAll_LiveData(boolean z) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM document_template ORDER BY CASE WHEN ?=1 THEN lastModifiedAt END DESC, CASE WHEN ?=0 THEN lastModifiedAt END ASC", 2);
        roomSQLiteQueryAcquire.bindLong(1, z ? 1L : 0L);
        roomSQLiteQueryAcquire.bindLong(2, z ? 1L : 0L);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{DBSchema.DocumentTemplate.TABLE_NAME}, false, new Callable<List<NotesTemplateEntity>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesTemplateDao_Impl.6
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<NotesTemplateEntity> call() {
                int i;
                Long lValueOf;
                Cursor cursorQuery = DBUtil.query(NotesTemplateDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_data");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_size");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_display_name");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mime_type");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "width");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "height");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        NotesTemplateEntity notesTemplateEntity = new NotesTemplateEntity();
                        if (cursorQuery.isNull(columnIndexOrThrow)) {
                            i = columnIndexOrThrow;
                            lValueOf = null;
                        } else {
                            i = columnIndexOrThrow;
                            lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow));
                        }
                        notesTemplateEntity.setId(lValueOf);
                        notesTemplateEntity.setUuid(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        notesTemplateEntity.setData(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        notesTemplateEntity.setSize(cursorQuery.getInt(columnIndexOrThrow4));
                        notesTemplateEntity.setDisplayName(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        notesTemplateEntity.setTitle(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        notesTemplateEntity.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow7));
                        notesTemplateEntity.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow8));
                        notesTemplateEntity.setMimeType(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                        notesTemplateEntity.setWidth(cursorQuery.getInt(columnIndexOrThrow10));
                        notesTemplateEntity.setHeight(cursorQuery.getInt(columnIndexOrThrow11));
                        notesTemplateEntity.setType(cursorQuery.getInt(columnIndexOrThrow12));
                        arrayList.add(notesTemplateEntity);
                        columnIndexOrThrow = i;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTemplateDao
    public NotesTemplateEntity getEntity(String str) {
        NotesTemplateEntity notesTemplateEntity;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT *  FROM document_template WHERE UUID=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_data");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_size");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_display_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mime_type");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "width");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "height");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            if (cursorQuery.moveToFirst()) {
                notesTemplateEntity = new NotesTemplateEntity();
                notesTemplateEntity.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow)));
                notesTemplateEntity.setUuid(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                notesTemplateEntity.setData(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                notesTemplateEntity.setSize(cursorQuery.getInt(columnIndexOrThrow4));
                notesTemplateEntity.setDisplayName(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                notesTemplateEntity.setTitle(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                notesTemplateEntity.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow7));
                notesTemplateEntity.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow8));
                notesTemplateEntity.setMimeType(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                notesTemplateEntity.setWidth(cursorQuery.getInt(columnIndexOrThrow10));
                notesTemplateEntity.setHeight(cursorQuery.getInt(columnIndexOrThrow11));
                notesTemplateEntity.setType(cursorQuery.getInt(columnIndexOrThrow12));
            } else {
                notesTemplateEntity = null;
            }
            return notesTemplateEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTemplateDao
    public void updateTitle(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdateTitle.acquire();
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
            this.__preparedStmtOfUpdateTitle.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(NotesTemplateEntity notesTemplateEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfNotesTemplateEntity.handle(notesTemplateEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(NotesTemplateEntity notesTemplateEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfNotesTemplateEntity.insert(notesTemplateEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(NotesTemplateEntity notesTemplateEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfNotesTemplateEntity.handle(notesTemplateEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(NotesTemplateEntity notesTemplateEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(notesTemplateEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTemplateDao
    public LiveData<List<NotesTemplateEntity>> getAll_LiveData(boolean z, int i) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM document_template WHERE type=? ORDER BY CASE WHEN ?=1 THEN lastModifiedAt END DESC, CASE WHEN ?=0 THEN lastModifiedAt END ASC", 3);
        roomSQLiteQueryAcquire.bindLong(1, i);
        roomSQLiteQueryAcquire.bindLong(2, z ? 1L : 0L);
        roomSQLiteQueryAcquire.bindLong(3, z ? 1L : 0L);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{DBSchema.DocumentTemplate.TABLE_NAME}, false, new Callable<List<NotesTemplateEntity>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesTemplateDao_Impl.7
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<NotesTemplateEntity> call() {
                int i2;
                Long lValueOf;
                Cursor cursorQuery = DBUtil.query(NotesTemplateDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "UUID");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_data");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_size");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_display_name");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdAt");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "lastModifiedAt");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mime_type");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "width");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "height");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        NotesTemplateEntity notesTemplateEntity = new NotesTemplateEntity();
                        if (cursorQuery.isNull(columnIndexOrThrow)) {
                            i2 = columnIndexOrThrow;
                            lValueOf = null;
                        } else {
                            i2 = columnIndexOrThrow;
                            lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow));
                        }
                        notesTemplateEntity.setId(lValueOf);
                        notesTemplateEntity.setUuid(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        notesTemplateEntity.setData(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        notesTemplateEntity.setSize(cursorQuery.getInt(columnIndexOrThrow4));
                        notesTemplateEntity.setDisplayName(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        notesTemplateEntity.setTitle(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        notesTemplateEntity.setCreatedAt(cursorQuery.getLong(columnIndexOrThrow7));
                        notesTemplateEntity.setLastModifiedAt(cursorQuery.getLong(columnIndexOrThrow8));
                        notesTemplateEntity.setMimeType(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                        notesTemplateEntity.setWidth(cursorQuery.getInt(columnIndexOrThrow10));
                        notesTemplateEntity.setHeight(cursorQuery.getInt(columnIndexOrThrow11));
                        notesTemplateEntity.setType(cursorQuery.getInt(columnIndexOrThrow12));
                        arrayList.add(notesTemplateEntity);
                        columnIndexOrThrow = i2;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTemplateDao
    public void deleteByPath(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteByPath.acquire();
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
            this.__preparedStmtOfDeleteByPath.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends NotesTemplateEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
