package com.samsung.android.support.senl.p148nt.data.database.core.migration.version;

import android.database.sqlite.SQLiteException;
import androidx.annotation.NonNull;
import androidx.glance.AbstractC2821a;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MigrationToVersion62 extends Migration {
    private static final String TAG = DataLogger.createTag("MigrationToVersion62");

    public MigrationToVersion62() {
        super(61, 62);
    }

    private void addColumns(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("ALTER TABLE sync_info ADD `syncState` INTEGER NOT NULL DEFAULT 0");
    }

    private void createDocumentTempDataTable(SupportSQLiteDatabase supportSQLiteDatabase) {
        try {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `document_temp_data` (`UUID` TEXT NOT NULL PRIMARY KEY, `tempData` TEXT NOT NULL DEFAULT '', FOREIGN KEY(`UUID`) REFERENCES `sdoc`(`UUID`) ON DELETE CASCADE)");
        } catch (SQLiteException e) {
            AbstractC0000a.m19p(e, new StringBuilder("createDocumentTempDataTable, e : "), TAG);
        }
    }

    private void createSttContentTable(SupportSQLiteDatabase supportSQLiteDatabase) {
        try {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `stt_content` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,`documentUUID` TEXT NOT NULL DEFAULT '',`filePath` TEXT NOT NULL DEFAULT '',`type` INTEGER NOT NULL DEFAULT 0,`index` INTEGER NOT NULL DEFAULT 0,`content` TEXT NOT NULL DEFAULT '',`lastModifiedAt` INTEGER NOT NULL DEFAULT 0, FOREIGN KEY(`documentUUID`) REFERENCES `sdoc`(`UUID`) ON DELETE CASCADE)");
            supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_stt_content_documentUUID_objectId_type` ON `stt_content` (`documentUUID`, `filePath`, `type`)");
        } catch (SQLiteException e) {
            AbstractC0000a.m19p(e, new StringBuilder("createSttContentTable, e : "), TAG);
        }
    }

    private void migratesColumns(SupportSQLiteDatabase supportSQLiteDatabase) {
        try {
            supportSQLiteDatabase.execSQL("UPDATE OR ABORT suggested_cover SET state = 0 WHERE state = -1");
            migratesSyncState(supportSQLiteDatabase);
            DataLogger.m12307i(TAG, "migratesColumns");
        } catch (SQLiteException e) {
            AbstractC0000a.m19p(e, new StringBuilder("migratesColumns, e : "), TAG);
        }
    }

    private void migratesSyncState(SupportSQLiteDatabase supportSQLiteDatabase) {
        AbstractC2821a.m2233x(supportSQLiteDatabase, "INSERT INTO sync_info (clientId) SELECT UUID FROM sdoc WHERE corrupted > 0 AND UUID NOT IN (SELECT clientId FROM sync_info)", "UPDATE OR ABORT sync_info SET syncState = (syncState | 256) WHERE clientId IN (SELECT UUID FROM sdoc WHERE (corrupted & 1) != 0)", "UPDATE OR ABORT sync_info SET syncState = (syncState | 512) WHERE clientId IN (SELECT UUID FROM sdoc WHERE (corrupted & 2) != 0)", "UPDATE OR ABORT sync_info SET syncState = (syncState | 1024) WHERE clientId IN (SELECT UUID FROM sdoc WHERE (corrupted & 4) != 0)");
        AbstractC2821a.m2233x(supportSQLiteDatabase, "UPDATE OR ABORT sync_info SET syncState = (syncState | 2048) WHERE clientId IN (SELECT UUID FROM sdoc WHERE (corrupted & 8) != 0)", "UPDATE OR ABORT sync_info SET syncState = (syncState | 4096) WHERE clientId IN (SELECT UUID FROM sdoc WHERE (corrupted & 16) != 0)", "UPDATE OR ABORT sync_info SET syncState = (syncState | 8192) WHERE clientId IN (SELECT UUID FROM sdoc WHERE (corrupted & 32) != 0)", "UPDATE OR ABORT sync_info SET syncState = (syncState | 16384) WHERE clientId IN (SELECT UUID FROM sdoc WHERE (corrupted & 64) != 0)");
        AbstractC2821a.m2233x(supportSQLiteDatabase, "UPDATE OR ABORT sdoc SET corrupted = (corrupted & ~2) WHERE (corrupted & 2) != 0", "UPDATE OR ABORT sdoc SET corrupted = (corrupted & ~4) WHERE (corrupted & 4) != 0", "UPDATE OR ABORT sdoc SET corrupted = (corrupted & ~8) WHERE (corrupted & 8) != 0", "UPDATE OR ABORT sdoc SET corrupted = (corrupted & ~16) WHERE (corrupted & 16) != 0");
        supportSQLiteDatabase.execSQL("UPDATE OR ABORT sdoc SET corrupted = (corrupted & ~32) WHERE (corrupted & 32) != 0");
        supportSQLiteDatabase.execSQL("UPDATE OR ABORT sdoc SET corrupted = (corrupted & ~64) WHERE (corrupted & 64) != 0");
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        String str = TAG;
        DataLogger.m12307i(str, "migrate, start");
        addColumns(supportSQLiteDatabase);
        migratesColumns(supportSQLiteDatabase);
        createSttContentTable(supportSQLiteDatabase);
        createDocumentTempDataTable(supportSQLiteDatabase);
        DataLogger.m12307i(str, "migrate, end");
    }
}
