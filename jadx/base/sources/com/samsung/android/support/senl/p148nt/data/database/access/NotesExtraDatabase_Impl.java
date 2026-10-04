package com.samsung.android.support.senl.p148nt.data.database.access;

import androidx.annotation.NonNull;
import androidx.glance.AbstractC2821a;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import androidx.sqlite.p113db.SupportSQLiteOpenHelper;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.ExtraDbSchema;
import com.samsung.android.support.senl.p148nt.data.database.temp.infra.dao.DeletedNoteDao;
import com.samsung.android.support.senl.p148nt.data.database.temp.infra.dao.DeletedNoteDao_Impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesExtraDatabase_Impl extends NotesExtraDatabase {
    private volatile DeletedNoteDao _deletedNoteDao;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `deleted_notes`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), ExtraDbSchema.DeletedNote.TABLE_NAME);
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) { // from class: com.samsung.android.support.senl.nt.data.database.access.NotesExtraDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `deleted_notes` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `UUID` TEXT NOT NULL DEFAULT '', `filePath` TEXT NOT NULL DEFAULT '', `deletedBy` INTEGER NOT NULL DEFAULT 0)", "CREATE INDEX IF NOT EXISTS `index_deleted_notes_filePath` ON `deleted_notes` (`filePath`)", RoomMasterTable.CREATE_QUERY, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f3b43b2b87f1338baa2fc14c15339e48')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `deleted_notes`");
                if (((RoomDatabase) NotesExtraDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) NotesExtraDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) NotesExtraDatabase_Impl.this).mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (((RoomDatabase) NotesExtraDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) NotesExtraDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) NotesExtraDatabase_Impl.this).mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                ((RoomDatabase) NotesExtraDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
                NotesExtraDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (((RoomDatabase) NotesExtraDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) NotesExtraDatabase_Impl.this).mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) NotesExtraDatabase_Impl.this).mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap map = new HashMap(4);
                map.put("_id", new TableInfo.Column("_id", "INTEGER", true, 1, null, 1));
                map.put("UUID", new TableInfo.Column("UUID", "TEXT", true, 0, "''", 1));
                map.put("filePath", new TableInfo.Column("filePath", "TEXT", true, 0, "''", 1));
                HashSet hashSetM2231v = AbstractC2821a.m2231v(map, "deletedBy", new TableInfo.Column("deletedBy", "INTEGER", true, 0, "0", 1), 0);
                HashSet hashSet = new HashSet(1);
                hashSet.add(new TableInfo.Index("index_deleted_notes_filePath", false, Arrays.asList("filePath"), Arrays.asList("ASC")));
                TableInfo tableInfo = new TableInfo(ExtraDbSchema.DeletedNote.TABLE_NAME, map, hashSetM2231v, hashSet);
                TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, ExtraDbSchema.DeletedNote.TABLE_NAME);
                return !tableInfo.equals(tableInfo2) ? new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("deleted_notes(com.samsung.android.support.senl.nt.data.database.temp.infra.entity.DeletedNoteEntity).\n Expected:\n", tableInfo, "\n Found:\n", tableInfo2)) : new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "f3b43b2b87f1338baa2fc14c15339e48", "7e1a315490828fa2524171efe1665adb")).build());
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.access.NotesExtraDatabase
    public DeletedNoteDao deletedNoteDao() {
        DeletedNoteDao deletedNoteDao;
        if (this._deletedNoteDao != null) {
            return this._deletedNoteDao;
        }
        synchronized (this) {
            try {
                if (this._deletedNoteDao == null) {
                    this._deletedNoteDao = new DeletedNoteDao_Impl(this);
                }
                deletedNoteDao = this._deletedNoteDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return deletedNoteDao;
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(DeletedNoteDao.class, DeletedNoteDao_Impl.getRequiredConverters());
        return map;
    }
}
