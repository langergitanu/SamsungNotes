package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.database.Cursor;
import android.util.Pair;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesStrokeDao_Impl extends NotesStrokeDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<NotesStrokeSearchEntity> __deletionAdapterOfNotesStrokeSearchEntity;
    private final EntityInsertionAdapter<NotesStrokeSearchEntity> __insertionAdapterOfNotesStrokeSearchEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByUuid;
    private final SharedSQLiteStatement __preparedStmtOfDeleteDummy;
    private final EntityDeletionOrUpdateAdapter<NotesStrokeSearchEntity> __updateAdapterOfNotesStrokeSearchEntity;

    public NotesStrokeDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfNotesStrokeSearchEntity = new EntityInsertionAdapter<NotesStrokeSearchEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesStrokeDao_Impl.1
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
        this.__deletionAdapterOfNotesStrokeSearchEntity = new EntityDeletionOrUpdateAdapter<NotesStrokeSearchEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesStrokeDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `stroke` WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NotesStrokeSearchEntity notesStrokeSearchEntity) {
                if (notesStrokeSearchEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, notesStrokeSearchEntity.getId().longValue());
                }
            }
        };
        this.__updateAdapterOfNotesStrokeSearchEntity = new EntityDeletionOrUpdateAdapter<NotesStrokeSearchEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesStrokeDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `stroke` SET `_id` = ?,`hasVisualCue` = ?,`text` = ?,`left` = ?,`top` = ?,`right` = ?,`bottom` = ?,`filePath` = ?,`sdocUUID` = ?,`pageWidth` = ?,`type` = ?,`pageUuid` = ?,`actionLinkData` = ?,`recognizerDBVersion` = ? WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
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
                if (notesStrokeSearchEntity.getId() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindLong(15, notesStrokeSearchEntity.getId().longValue());
                }
            }
        };
        this.__preparedStmtOfDeleteByUuid = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesStrokeDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM stroke WHERE sdocUUID=?";
            }
        };
        this.__preparedStmtOfDeleteDummy = new SharedSQLiteStatement(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.NotesStrokeDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM stroke WHERE sdocUUID NOT IN (SELECT UUID FROM sdoc WHERE isDeleted != 1)";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesStrokeDao
    public void deleteByUuid(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            super.deleteByUuid(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesStrokeDao
    public void deleteByUuidAndPageIds(String str, List<String> list) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM stroke WHERE sdocUUID=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" AND pageUuid IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, list.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        if (str == null) {
            supportSQLiteStatementCompileStatement.bindNull(1);
        } else {
            supportSQLiteStatementCompileStatement.bindString(1, str);
        }
        int i = 2;
        for (String str2 : list) {
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesStrokeDao
    public void deleteByUuidAndPageIdsWithExcludedTypes(String str, List<String> list, int... iArr) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM stroke WHERE sdocUUID=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" AND pageUuid IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(") AND type NOT IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, iArr.length);
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        if (str == null) {
            supportSQLiteStatementCompileStatement.bindNull(1);
        } else {
            supportSQLiteStatementCompileStatement.bindString(1, str);
        }
        int i = 2;
        for (String str2 : list) {
            if (str2 == null) {
                supportSQLiteStatementCompileStatement.bindNull(i);
            } else {
                supportSQLiteStatementCompileStatement.bindString(i, str2);
            }
            i++;
        }
        int i2 = size + 2;
        for (int i4 : iArr) {
            supportSQLiteStatementCompileStatement.bindLong(i2, i4);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesStrokeDao
    public void deleteByUuidWithTypes(String str, int... iArr) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM stroke WHERE sdocUUID=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" AND type IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, iArr.length);
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        if (str == null) {
            supportSQLiteStatementCompileStatement.bindNull(1);
        } else {
            supportSQLiteStatementCompileStatement.bindString(1, str);
        }
        int i = 2;
        for (int i2 : iArr) {
            supportSQLiteStatementCompileStatement.bindLong(i, i2);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesStrokeDao
    public void deleteByUuids(Collection<String> collection) {
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesStrokeDao
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesStrokeDao
    public void deleteInChunk(Collection<String> collection) {
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesStrokeDao
    public List<NotesStrokeSearchEntity> getEntities(String str, int i) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int i2;
        Long lValueOf;
        String string;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM stroke WHERE sdocUUID=? AND type =?", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        roomSQLiteQueryAcquire.bindLong(2, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.StrokeSearch.HAS_VISUALCUE);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "text");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "left");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "top");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "right");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bottom");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filePath");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sdocUUID");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pageWidth");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pageUuid");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "actionLinkData");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recognizerDBVersion");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    NotesStrokeSearchEntity notesStrokeSearchEntity = new NotesStrokeSearchEntity();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        i2 = columnIndexOrThrow;
                        lValueOf = null;
                    } else {
                        i2 = columnIndexOrThrow;
                        lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow));
                    }
                    notesStrokeSearchEntity.setId(lValueOf);
                    notesStrokeSearchEntity.setHasVisualCue(cursorQuery.isNull(columnIndexOrThrow2) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow2)));
                    notesStrokeSearchEntity.setText(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    notesStrokeSearchEntity.setLeft(cursorQuery.isNull(columnIndexOrThrow4) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow4)));
                    notesStrokeSearchEntity.setTop(cursorQuery.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow5)));
                    notesStrokeSearchEntity.setRight(cursorQuery.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow6)));
                    notesStrokeSearchEntity.setBottom(cursorQuery.isNull(columnIndexOrThrow7) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow7)));
                    notesStrokeSearchEntity.setFilePath(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    notesStrokeSearchEntity.setDocUuid(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    notesStrokeSearchEntity.setPageWidth(cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10)));
                    notesStrokeSearchEntity.setType(cursorQuery.getInt(columnIndexOrThrow11));
                    notesStrokeSearchEntity.setPageUuid(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    notesStrokeSearchEntity.setActionLinkData(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i4 = columnIndexOrThrow14;
                    if (cursorQuery.isNull(i4)) {
                        columnIndexOrThrow14 = i4;
                        string = null;
                    } else {
                        columnIndexOrThrow14 = i4;
                        string = cursorQuery.getString(i4);
                    }
                    notesStrokeSearchEntity.setRecognizerDBVersion(string);
                    arrayList.add(notesStrokeSearchEntity);
                    columnIndexOrThrow = i2;
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesStrokeDao
    public List<NotesStrokeSearchEntity> getEntityListWithExcludedTypes(String str, int... iArr) throws Throwable {
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
        int i;
        Long lValueOf;
        String string;
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT * FROM stroke WHERE sdocUUID=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" AND type NOT IN (");
        int length = iArr.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length + 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        int i2 = 2;
        for (int i4 : iArr) {
            roomSQLiteQueryAcquire.bindLong(i2, i4);
            i2++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, DBSchema.StrokeSearch.HAS_VISUALCUE);
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "text");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "left");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "top");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "right");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bottom");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "filePath");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sdocUUID");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pageWidth");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pageUuid");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "actionLinkData");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recognizerDBVersion");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                NotesStrokeSearchEntity notesStrokeSearchEntity = new NotesStrokeSearchEntity();
                if (cursorQuery.isNull(columnIndexOrThrow)) {
                    i = columnIndexOrThrow;
                    lValueOf = null;
                } else {
                    i = columnIndexOrThrow;
                    lValueOf = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow));
                }
                notesStrokeSearchEntity.setId(lValueOf);
                notesStrokeSearchEntity.setHasVisualCue(cursorQuery.isNull(columnIndexOrThrow2) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow2)));
                notesStrokeSearchEntity.setText(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                notesStrokeSearchEntity.setLeft(cursorQuery.isNull(columnIndexOrThrow4) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow4)));
                notesStrokeSearchEntity.setTop(cursorQuery.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow5)));
                notesStrokeSearchEntity.setRight(cursorQuery.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow6)));
                notesStrokeSearchEntity.setBottom(cursorQuery.isNull(columnIndexOrThrow7) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow7)));
                notesStrokeSearchEntity.setFilePath(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                notesStrokeSearchEntity.setDocUuid(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                notesStrokeSearchEntity.setPageWidth(cursorQuery.isNull(columnIndexOrThrow10) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow10)));
                notesStrokeSearchEntity.setType(cursorQuery.getInt(columnIndexOrThrow11));
                notesStrokeSearchEntity.setPageUuid(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                notesStrokeSearchEntity.setActionLinkData(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i5 = columnIndexOrThrow14;
                if (cursorQuery.isNull(i5)) {
                    columnIndexOrThrow14 = i5;
                    string = null;
                } else {
                    columnIndexOrThrow14 = i5;
                    string = cursorQuery.getString(i5);
                }
                notesStrokeSearchEntity.setRecognizerDBVersion(string);
                arrayList.add(notesStrokeSearchEntity);
                columnIndexOrThrow = i;
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesStrokeDao
    public List<String> getPageIdListByUuid(String str, int... iArr) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT pageUuid FROM stroke WHERE sdocUUID=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" AND type IN (");
        int length = iArr.length;
        StringUtil.appendPlaceholders(sbNewStringBuilder, length);
        sbNewStringBuilder.append(") GROUP BY pageUuid");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), length + 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        int i = 2;
        for (int i2 : iArr) {
            roomSQLiteQueryAcquire.bindLong(i, i2);
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(NotesStrokeSearchEntity notesStrokeSearchEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfNotesStrokeSearchEntity.handle(notesStrokeSearchEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(NotesStrokeSearchEntity notesStrokeSearchEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfNotesStrokeSearchEntity.insert(notesStrokeSearchEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(NotesStrokeSearchEntity notesStrokeSearchEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfNotesStrokeSearchEntity.handle(notesStrokeSearchEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(NotesStrokeSearchEntity notesStrokeSearchEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(notesStrokeSearchEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesStrokeDao
    public int deleteByUuid(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteByUuid.acquire();
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
            this.__preparedStmtOfDeleteByUuid.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends NotesStrokeSearchEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesStrokeDao
    public void deleteByUuidAndPageIds(String str, List<String> list, int... iArr) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM stroke WHERE sdocUUID=");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" AND pageUuid IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(") AND type IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, iArr.length);
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        if (str == null) {
            supportSQLiteStatementCompileStatement.bindNull(1);
        } else {
            supportSQLiteStatementCompileStatement.bindString(1, str);
        }
        int i = 2;
        for (String str2 : list) {
            if (str2 == null) {
                supportSQLiteStatementCompileStatement.bindNull(i);
            } else {
                supportSQLiteStatementCompileStatement.bindString(i, str2);
            }
            i++;
        }
        int i2 = size + 2;
        for (int i4 : iArr) {
            supportSQLiteStatementCompileStatement.bindLong(i2, i4);
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
}
