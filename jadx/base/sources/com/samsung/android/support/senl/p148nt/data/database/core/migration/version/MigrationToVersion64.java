package com.samsung.android.support.senl.p148nt.data.database.core.migration.version;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MigrationToVersion64 extends Migration {
    private static final String TAG = DataLogger.createTag("MigrationToVersion64");

    public MigrationToVersion64() {
        super(63, 64);
    }

    private void addColumn(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("ALTER TABLE sync_info ADD `strokeGrouped` INTEGER NOT NULL DEFAULT 0");
    }

    private void createDocumentExtraTable(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `document_extra` (`UUID` TEXT NOT NULL PRIMARY KEY, `hasSticky` INTEGER NOT NULL DEFAULT 0,  `unknownMinVersion` INTEGER NOT NULL DEFAULT 0,  FOREIGN KEY(`UUID`) REFERENCES `sdoc`(`UUID`) ON DELETE CASCADE)");
    }

    private void createSyncDelayInfoTable(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `sync_delay_info` (`UUID` TEXT NOT NULL PRIMARY KEY, `serverId` TEXT NOT NULL DEFAULT '', `appVersion` TEXT NOT NULL DEFAULT '', `reason` INTEGER NOT NULL DEFAULT 0,  `retryCount` INTEGER NOT NULL DEFAULT 0,  `serverTimestamp` INTEGER NOT NULL DEFAULT 1464416139847,  `upSync` INTEGER NOT NULL DEFAULT 0, `extra` TEXT NOT NULL DEFAULT '')");
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        String str = TAG;
        DataLogger.m12307i(str, "migrate, start");
        addColumn(supportSQLiteDatabase);
        createSyncDelayInfoTable(supportSQLiteDatabase);
        createDocumentExtraTable(supportSQLiteDatabase);
        DataLogger.m12307i(str, "migrate, end");
    }
}
