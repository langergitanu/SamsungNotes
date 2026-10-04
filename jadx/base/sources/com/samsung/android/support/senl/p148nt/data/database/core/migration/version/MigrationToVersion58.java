package com.samsung.android.support.senl.p148nt.data.database.core.migration.version;

import android.database.sqlite.SQLiteException;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MigrationToVersion58 extends Migration {
    private static final String TAG = DataLogger.createTag("MigrationToVersion58");

    public MigrationToVersion58() {
        super(57, 58);
    }

    private void createCoverCategoryTable(SupportSQLiteDatabase supportSQLiteDatabase) {
        try {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `cover_category` (`UUID` TEXT NOT NULL PRIMARY KEY, `name` TEXT NOT NULL DEFAULT '', `icon_path` TEXT NOT NULL DEFAULT '', `createdAt` INTEGER NOT NULL DEFAULT 0, `lastModifiedAt` INTEGER NOT NULL DEFAULT 0)");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_cover_category_UUID` ON `cover_category` (`UUID`)");
        } catch (SQLiteException e) {
            AbstractC0000a.m19p(e, new StringBuilder("createCoverCategoryTable, e : "), TAG);
        }
    }

    private void createCoverTemplateTable(SupportSQLiteDatabase supportSQLiteDatabase) {
        try {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `cover_template` (`UUID` TEXT NOT NULL PRIMARY KEY, `path` TEXT NOT NULL DEFAULT '', `createdAt` INTEGER NOT NULL DEFAULT 0, `lastModifiedAt` INTEGER NOT NULL DEFAULT 0, `type` INTEGER NOT NULL DEFAULT 0)");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_cover_template_UUID` ON `cover_template` (`UUID`)");
        } catch (SQLiteException e) {
            AbstractC0000a.m19p(e, new StringBuilder("createCoverTemplateTable, e : "), TAG);
        }
    }

    private void createDocumentCoverTable(SupportSQLiteDatabase supportSQLiteDatabase) {
        try {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `document_cover` (`documentUUID` TEXT NOT NULL PRIMARY KEY, `templateUUID` TEXT NOT NULL DEFAULT 'DEFAULT:///', `categoryUUID` TEXT NOT NULL DEFAULT 'NONE:///', `title` TEXT NOT NULL DEFAULT '', `title_alignment` INTEGER NOT NULL DEFAULT 0, `summary` TEXT NOT NULL DEFAULT '', `summary_alignment` INTEGER NOT NULL DEFAULT 0, `createdAt` INTEGER NOT NULL DEFAULT 0, `lastModifiedAt` INTEGER NOT NULL DEFAULT 0, `isEnabled` INTEGER NOT NULL DEFAULT 1, FOREIGN KEY(`documentUUID`) REFERENCES `sdoc`(`UUID`) ON DELETE CASCADE, FOREIGN KEY(`categoryUUID`) REFERENCES `cover_category`(`UUID`) ON DELETE SET DEFAULT, FOREIGN KEY(`templateUUID`) REFERENCES `cover_template`(`UUID`) ON DELETE SET DEFAULT)");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_document_cover_documentUUID_templateUUID_categoryUUID` ON `document_cover` (`documentUUID`, `templateUUID`, `categoryUUID`)");
        } catch (SQLiteException e) {
            AbstractC0000a.m19p(e, new StringBuilder("createDocumentCoverTable, e : "), TAG);
        }
    }

    private void createOrganizedDocumentTable(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        try {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `organized_document` (`documentUUID` TEXT NOT NULL PRIMARY KEY, `contents` TEXT NOT NULL DEFAULT '', `recognized_language` TEXT NOT NULL DEFAULT '', `modified_time` INTEGER NOT NULL DEFAULT 0, FOREIGN KEY(`documentUUID`) REFERENCES `sdoc`(`UUID`) ON DELETE CASCADE)");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_organized_document_documentUUID` ON `organized_document` (`documentUUID`)");
        } catch (SQLiteException e) {
            AbstractC0000a.m19p(e, new StringBuilder("migrate, e : "), TAG);
        }
    }

    private void createSuggestedCoverTable(SupportSQLiteDatabase supportSQLiteDatabase) {
        try {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `suggested_cover` (`documentUUID` TEXT NOT NULL PRIMARY KEY, `state` INTEGER NOT NULL DEFAULT 0, FOREIGN KEY(`documentUUID`) REFERENCES `sdoc`(`UUID`) ON DELETE CASCADE)");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_suggested_cover_documentUUID` ON `suggested_cover` (`documentUUID`)");
        } catch (SQLiteException e) {
            AbstractC0000a.m19p(e, new StringBuilder("createSuggestedCoverTable, e : "), TAG);
        }
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        String str = TAG;
        DataLogger.m12307i(str, "migrate, start");
        createCoverCategoryTable(supportSQLiteDatabase);
        createCoverTemplateTable(supportSQLiteDatabase);
        createSuggestedCoverTable(supportSQLiteDatabase);
        createDocumentCoverTable(supportSQLiteDatabase);
        createOrganizedDocumentTable(supportSQLiteDatabase);
        DataLogger.m12307i(str, "migrate, end");
    }
}
