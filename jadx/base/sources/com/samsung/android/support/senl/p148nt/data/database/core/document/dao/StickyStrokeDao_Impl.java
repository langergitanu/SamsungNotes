package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import android.util.Pair;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.StringUtil;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyStrokeSearchEntity;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class StickyStrokeDao_Impl extends StickyStrokeDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<StickyStrokeSearchEntity> __deletionAdapterOfStickyStrokeSearchEntity;
    private final EntityInsertionAdapter<StickyStrokeSearchEntity> __insertionAdapterOfStickyStrokeSearchEntity;
    private final EntityDeletionOrUpdateAdapter<StickyStrokeSearchEntity> __updateAdapterOfStickyStrokeSearchEntity;

    public StickyStrokeDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfStickyStrokeSearchEntity = new EntityInsertionAdapter<StickyStrokeSearchEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.StickyStrokeDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `sticky_stroke` (`_id`,`objectId`,`text`,`left`,`top`,`right`,`bottom`,`pageWidth`,`type`,`actionLinkData`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, StickyStrokeSearchEntity stickyStrokeSearchEntity) {
                supportSQLiteStatement.bindLong(1, stickyStrokeSearchEntity.getId());
                if (stickyStrokeSearchEntity.getObjectId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, stickyStrokeSearchEntity.getObjectId());
                }
                if (stickyStrokeSearchEntity.getText() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, stickyStrokeSearchEntity.getText());
                }
                supportSQLiteStatement.bindLong(4, stickyStrokeSearchEntity.getLeft());
                supportSQLiteStatement.bindLong(5, stickyStrokeSearchEntity.getTop());
                supportSQLiteStatement.bindLong(6, stickyStrokeSearchEntity.getRight());
                supportSQLiteStatement.bindLong(7, stickyStrokeSearchEntity.getBottom());
                supportSQLiteStatement.bindLong(8, stickyStrokeSearchEntity.getPageWidth());
                supportSQLiteStatement.bindLong(9, stickyStrokeSearchEntity.getType());
                if (stickyStrokeSearchEntity.getActionLinkData() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, stickyStrokeSearchEntity.getActionLinkData());
                }
            }
        };
        this.__deletionAdapterOfStickyStrokeSearchEntity = new EntityDeletionOrUpdateAdapter<StickyStrokeSearchEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.StickyStrokeDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `sticky_stroke` WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, StickyStrokeSearchEntity stickyStrokeSearchEntity) {
                supportSQLiteStatement.bindLong(1, stickyStrokeSearchEntity.getId());
            }
        };
        this.__updateAdapterOfStickyStrokeSearchEntity = new EntityDeletionOrUpdateAdapter<StickyStrokeSearchEntity>(roomDatabase) { // from class: com.samsung.android.support.senl.nt.data.database.core.document.dao.StickyStrokeDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `sticky_stroke` SET `_id` = ?,`objectId` = ?,`text` = ?,`left` = ?,`top` = ?,`right` = ?,`bottom` = ?,`pageWidth` = ?,`type` = ?,`actionLinkData` = ? WHERE `_id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, StickyStrokeSearchEntity stickyStrokeSearchEntity) {
                supportSQLiteStatement.bindLong(1, stickyStrokeSearchEntity.getId());
                if (stickyStrokeSearchEntity.getObjectId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, stickyStrokeSearchEntity.getObjectId());
                }
                if (stickyStrokeSearchEntity.getText() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, stickyStrokeSearchEntity.getText());
                }
                supportSQLiteStatement.bindLong(4, stickyStrokeSearchEntity.getLeft());
                supportSQLiteStatement.bindLong(5, stickyStrokeSearchEntity.getTop());
                supportSQLiteStatement.bindLong(6, stickyStrokeSearchEntity.getRight());
                supportSQLiteStatement.bindLong(7, stickyStrokeSearchEntity.getBottom());
                supportSQLiteStatement.bindLong(8, stickyStrokeSearchEntity.getPageWidth());
                supportSQLiteStatement.bindLong(9, stickyStrokeSearchEntity.getType());
                if (stickyStrokeSearchEntity.getActionLinkData() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, stickyStrokeSearchEntity.getActionLinkData());
                }
                supportSQLiteStatement.bindLong(11, stickyStrokeSearchEntity.getId());
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyStrokeDao
    public void deleteByUuid(Collection<String> collection) {
        this.__db.beginTransaction();
        try {
            super.deleteByUuid(collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyStrokeDao
    public void deleteByUuidAndPageIds(String str, List<String> list) {
        this.__db.beginTransaction();
        try {
            super.deleteByUuidAndPageIds(str, list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyStrokeDao
    public void deleteByUuidAndPageIdsInChunk(String str, List<String> list) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM sticky_stroke WHERE objectId IN (SELECT objectId FROM sticky WHERE documentUUID = ");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append(" AND pageUuid IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, list.size());
        sbNewStringBuilder.append("))");
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyStrokeDao
    public void deleteByUuids(Collection<String> collection) {
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(AbstractC11014a.m12322g(collection, AbstractC11014a.m12324i(this.__db, "DELETE FROM sticky_stroke WHERE objectId IN (SELECT objectId FROM sticky WHERE documentUUID IN ("), "))"));
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

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int delete(StickyStrokeSearchEntity stickyStrokeSearchEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__deletionAdapterOfStickyStrokeSearchEntity.handle(stickyStrokeSearchEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void insert(StickyStrokeSearchEntity stickyStrokeSearchEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfStickyStrokeSearchEntity.insert(stickyStrokeSearchEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public int update(StickyStrokeSearchEntity stickyStrokeSearchEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfStickyStrokeSearchEntity.handle(stickyStrokeSearchEntity);
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public Pair<AtomicInteger, AtomicInteger> upsert(StickyStrokeSearchEntity stickyStrokeSearchEntity) {
        this.__db.beginTransaction();
        try {
            Pair<AtomicInteger, AtomicInteger> pairUpsert = super.upsert(stickyStrokeSearchEntity);
            this.__db.setTransactionSuccessful();
            return pairUpsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.dao.BaseDao
    public void upsert(Collection<? extends StickyStrokeSearchEntity> collection) {
        this.__db.beginTransaction();
        try {
            super.upsert((Collection) collection);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
