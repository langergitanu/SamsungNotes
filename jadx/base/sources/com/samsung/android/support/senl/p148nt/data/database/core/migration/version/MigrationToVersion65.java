package com.samsung.android.support.senl.p148nt.data.database.core.migration.version;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MigrationToVersion65 extends Migration {
    private static final String TAG = DataLogger.createTag("MigrationToVersion65");

    public MigrationToVersion65() {
        super(64, 65);
    }

    private void createStickyNoteStrokeTable(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `sticky_stroke` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `objectId` TEXT NOT NULL DEFAULT '', `text` TEXT NOT NULL DEFAULT '', `type` INTEGER NOT NULL DEFAULT 0, `left` INTEGER NOT NULL DEFAULT 0, `top` INTEGER NOT NULL DEFAULT 0, `right` INTEGER NOT NULL DEFAULT 0, `bottom` INTEGER NOT NULL DEFAULT 0, `pageWidth` INTEGER NOT NULL DEFAULT 0, `actionLinkData` TEXT NOT NULL DEFAULT '', FOREIGN KEY(`objectId`) REFERENCES `sticky`(`objectId`) ON DELETE CASCADE)");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_sticky_stroke_objectId` ON `sticky_stroke` (`objectId`)");
    }

    private void createStickyNoteTable(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `sticky` (`objectId` TEXT NOT NULL PRIMARY KEY, `documentUUID` TEXT NOT NULL DEFAULT '', `pageUuid` TEXT NOT NULL DEFAULT '', `width` INTEGER NOT NULL DEFAULT 0, `height` INTEGER NOT NULL DEFAULT 0, `filePath` TEXT NOT NULL DEFAULT '', `lastModifiedAt` INTEGER NOT NULL DEFAULT 0, FOREIGN KEY(`documentUUID`) REFERENCES `sdoc`(`UUID`) ON DELETE CASCADE)");
    }

    private void createStickyTextTable(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `sticky_text` (`objectId` TEXT NOT NULL PRIMARY KEY, `text` TEXT NOT NULL DEFAULT '', FOREIGN KEY(`objectId`) REFERENCES `sticky`(`objectId`) ON DELETE CASCADE)");
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        String str = TAG;
        DataLogger.m12307i(str, "migrate, start");
        createStickyNoteTable(supportSQLiteDatabase);
        createStickyTextTable(supportSQLiteDatabase);
        createStickyNoteStrokeTable(supportSQLiteDatabase);
        DataLogger.m12307i(str, "migrate, end");
    }
}
