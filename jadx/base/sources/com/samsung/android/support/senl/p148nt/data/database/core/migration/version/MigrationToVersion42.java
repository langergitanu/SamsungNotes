package com.samsung.android.support.senl.p148nt.data.database.core.migration.version;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.legacy.SDocDBSQL;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import java.io.File;
import p009B3.C0035a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MigrationToVersion42 extends Migration {
    private static final String TAG = DataLogger.createTag("MigrationToVersion42");

    public MigrationToVersion42() {
        super(41, 42);
    }

    private void createAllTable(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `sdoc` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `UUID` TEXT NOT NULL, `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1, `accountType` TEXT, `accountName` TEXT DEFAULT '', `title` TEXT NOT NULL DEFAULT '', `recommendedTitle` TEXT NOT NULL DEFAULT '', `content` BLOB NOT NULL, `displayContent` BLOB NOT NULL, `strippedContent` BLOB NOT NULL, `createdAt` INTEGER NOT NULL, `lastModifiedAt` INTEGER NOT NULL, `serverTimestamp` INTEGER DEFAULT 1464416139847, `vrUUID` TEXT DEFAULT '', `contentUUID` TEXT DEFAULT '', `firstContentType` INTEGER DEFAULT 0, `secondContentType` INTEGER DEFAULT 0, `strokeUUID` TEXT DEFAULT '', `strokeRatio` REAL DEFAULT 0.0, `categoryUUID` TEXT NOT NULL DEFAULT 'uncategorized:///', `categoryserverTimestamp` INTEGER DEFAULT 1464416139847, `categoryisDirty` INTEGER NOT NULL DEFAULT 1, `filePath` TEXT NOT NULL, `noteName` TEXT NOT NULL DEFAULT '', `isFavorite` INTEGER NOT NULL DEFAULT 0, `isLock` INTEGER NOT NULL DEFAULT 0, `isSaving` INTEGER NOT NULL DEFAULT 0, `reminderTriggerTime` INTEGER NOT NULL DEFAULT 0, `reminderRequestCode` INTEGER NOT NULL DEFAULT 0, `recycle_bin_time_moved` INTEGER NOT NULL DEFAULT 0, `contentSecureVersion` INTEGER NOT NULL DEFAULT 0, `size` INTEGER NOT NULL DEFAULT 0, `displayTitle` BLOB, `saveType` INTEGER NOT NULL DEFAULT 0, `firstOpendAt` INTEGER NOT NULL DEFAULT 0, `secondOpenedAt` INTEGER NOT NULL DEFAULT 0, `lastOpenedAt` INTEGER NOT NULL DEFAULT 0, `importedAt` INTEGER NOT NULL DEFAULT 0, `recommendedAt` INTEGER NOT NULL DEFAULT 0, `lastMappedAt` INTEGER NOT NULL DEFAULT 0, `mdeSpaceId` TEXT NOT NULL DEFAULT '', `mdeItemId` TEXT NOT NULL DEFAULT '', `mdeExtra` TEXT NOT NULL DEFAULT '', `mdeGroupId` TEXT NOT NULL DEFAULT '', `mdeOwnerId` TEXT NOT NULL DEFAULT '', `firstHandwritingHeight` INTEGER NOT NULL DEFAULT 0, `deleteRecommended` INTEGER NOT NULL DEFAULT 0, `absolutePath` TEXT, `backgroundColor` INTEGER NOT NULL DEFAULT 0, `backgroundColorInverted` INTEGER NOT NULL DEFAULT 0, `lockAccountGuid` TEXT, `msSyncAccountId` TEXT, `msSyncDocumentUuid` TEXT, `msLastSyncTime` INTEGER NOT NULL DEFAULT 0)", "CREATE UNIQUE INDEX IF NOT EXISTS `index_sdoc_UUID` ON `sdoc` (`UUID`)", "CREATE TABLE IF NOT EXISTS `category` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `UUID` TEXT NOT NULL, `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1, `accountType` TEXT, `accountName` TEXT DEFAULT '', `predefine` INTEGER NOT NULL DEFAULT 0, `lastModifiedAt` INTEGER NOT NULL, `serverTimestamp` INTEGER DEFAULT 1464416139847, `orderBy` INTEGER NOT NULL DEFAULT 999999, `displayName` TEXT NOT NULL, `displayNameColor` INTEGER NOT NULL DEFAULT -1)", "CREATE UNIQUE INDEX IF NOT EXISTS `index_category_UUID` ON `category` (`UUID`)");
        AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `content` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `UUID` TEXT NOT NULL, `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1, `accountType` TEXT, `accountName` TEXT DEFAULT '', `sdocUUID` TEXT NOT NULL, `mime_type` TEXT NOT NULL DEFAULT 'application/octet-stream', `displayName` TEXT NOT NULL DEFAULT '', `srcID` INTEGER NOT NULL, `data` BLOB, `_data` TEXT DEFAULT '', `filePath` TEXT NOT NULL DEFAULT '', `contentSecureVersion` INTEGER NOT NULL DEFAULT 0)", "CREATE UNIQUE INDEX IF NOT EXISTS `index_content_UUID` ON `content` (`UUID`)", "CREATE TABLE IF NOT EXISTS `category_tree` (`UUID` TEXT NOT NULL, `parentUUID` TEXT, `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1, `createdAt` INTEGER NOT NULL, `lastModifiedAt` INTEGER NOT NULL, `serverTimestamp` INTEGER DEFAULT 1464416139847, `recycle_bin_time_moved` INTEGER NOT NULL DEFAULT 0, `displayName` TEXT NOT NULL, `path` TEXT, `orderBy` INTEGER, `displayNameColor` INTEGER NOT NULL DEFAULT -1, `isSyncWithMS` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`UUID`))", "CREATE UNIQUE INDEX IF NOT EXISTS `index_category_tree_UUID` ON `category_tree` (`UUID`)");
        AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `category_tree_closure` (`ancestor` TEXT NOT NULL DEFAULT '', `descendant` TEXT NOT NULL DEFAULT '', `depth` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`ancestor`, `descendant`), FOREIGN KEY(`ancestor`) REFERENCES `category_tree`(`UUID`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`descendant`) REFERENCES `category_tree`(`UUID`) ON UPDATE CASCADE ON DELETE CASCADE )", "CREATE TABLE IF NOT EXISTS `sync_info` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `serverId` TEXT, `clientId` TEXT NOT NULL, `clientModifiedTime` INTEGER NOT NULL DEFAULT 0, `isDirtyFolder` INTEGER NOT NULL DEFAULT 1, `clientModifiedTimeFolder` INTEGER NOT NULL DEFAULT 0, `lastModifiedTimeFolder` INTEGER NOT NULL DEFAULT 0, `isSyncFailed` INTEGER NOT NULL DEFAULT 0)", "CREATE UNIQUE INDEX IF NOT EXISTS `index_sync_info_clientId` ON `sync_info` (`clientId`)", "CREATE TABLE IF NOT EXISTS `tag_list` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `normalizeName` TEXT NOT NULL, `docUUID` TEXT NOT NULL, `displayName` TEXT NOT NULL)");
        AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `retry` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `sdocUUID` TEXT NOT NULL, `strokeFilePath` TEXT NOT NULL, `state` INTEGER NOT NULL DEFAULT 0, `recognitionCount` INTEGER NOT NULL DEFAULT 0, `lastModifiedAt` INTEGER NOT NULL)", "CREATE TABLE IF NOT EXISTS `stroke` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `hasVisualCue` INTEGER DEFAULT 0, `text` TEXT DEFAULT '', `left` INTEGER DEFAULT 0, `top` INTEGER DEFAULT 0, `right` INTEGER DEFAULT 0, `bottom` INTEGER DEFAULT 0, `filePath` TEXT NOT NULL, `sdocUUID` TEXT NOT NULL, `pageWidth` INTEGER DEFAULT 0, `type` INTEGER NOT NULL DEFAULT 0, `pageUuid` TEXT DEFAULT '', `actionLinkData` TEXT DEFAULT '')", "CREATE TABLE IF NOT EXISTS `document_template` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `_data` TEXT, `_size` INTEGER NOT NULL DEFAULT 0, `_display_name` TEXT DEFAULT '', `title` TEXT DEFAULT '', `createdAt` INTEGER NOT NULL DEFAULT 0, `lastModifiedAt` INTEGER NOT NULL DEFAULT 0, `mime_type` TEXT, `width` INTEGER NOT NULL DEFAULT 0, `height` INTEGER NOT NULL DEFAULT 0, `type` INTEGER NOT NULL DEFAULT 3)", "CREATE TABLE IF NOT EXISTS `server_only_folder_node` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `UUID` TEXT NOT NULL, `type` TEXT NOT NULL, `parentFolderNodeID` TEXT NOT NULL, `syncModifiedTime` INTEGER NOT NULL, `createdTime` INTEGER NOT NULL, `lastModifiedTime` INTEGER NOT NULL, `recyclerBinMovedTime` INTEGER NOT NULL, `name` TEXT NOT NULL, `state` TEXT NOT NULL, `restorePath` TEXT NOT NULL DEFAULT '', `isDirty` INTEGER NOT NULL DEFAULT 0)");
        AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `mapped_document` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `UUID` TEXT NOT NULL DEFAULT '', `mappedUUID` TEXT NOT NULL DEFAULT '', `converted` INTEGER NOT NULL DEFAULT 1, `mappedAt` INTEGER NOT NULL DEFAULT 0)", "CREATE UNIQUE INDEX IF NOT EXISTS `index_mapped_document_mappedUUID` ON `mapped_document` (`mappedUUID`)", "CREATE TABLE IF NOT EXISTS `document_page` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `UUID` TEXT NOT NULL DEFAULT '', `documentUUID` TEXT NOT NULL DEFAULT '', `index` INTEGER NOT NULL, `favorite` INTEGER NOT NULL, `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1)", "CREATE UNIQUE INDEX IF NOT EXISTS `index_document_page_UUIDs` ON `document_page` (`documentUUID`, `UUID`)");
        AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `hashtag` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT NOT NULL, `extraInfo` TEXT NOT NULL DEFAULT '', `lastModifiedAt` INTEGER NOT NULL, `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1, `serverTimestamp` INTEGER DEFAULT 1464416139847, `UUID` TEXT NOT NULL)", "CREATE TABLE IF NOT EXISTS `hashtagContent` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `sdocUUID` TEXT NOT NULL, `extraInfo` TEXT NOT NULL DEFAULT '', `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1, `serverTimestamp` INTEGER DEFAULT 1464416139847, `isSyncFailed` INTEGER DEFAULT 0, `hashtagUUID` TEXT NOT NULL, `lastModifiedAt` INTEGER NOT NULL)", "CREATE TABLE IF NOT EXISTS `account` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `accountGuid` TEXT NOT NULL DEFAULT '', `accountType` TEXT NOT NULL DEFAULT '', `accountName` TEXT DEFAULT '', `primaryAccount` INTEGER NOT NULL DEFAULT 1)", "CREATE UNIQUE INDEX IF NOT EXISTS `index_account_accountGuid` ON `account` (`accountGuid`)");
    }

    private void createOrUpdateTables(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        DataLogger.m12307i(TAG, "migrate, createOrUpdateTables - start");
        try {
            try {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `new_category` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `UUID` TEXT NOT NULL, `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1, `accountType` TEXT, `accountName` TEXT DEFAULT '', `predefine` INTEGER NOT NULL DEFAULT 0, `lastModifiedAt` INTEGER NOT NULL, `serverTimestamp` INTEGER DEFAULT 1464416139847, `orderBy` INTEGER NOT NULL DEFAULT 999999, `displayName` TEXT NOT NULL, `displayNameColor` INTEGER NOT NULL DEFAULT -1)");
                supportSQLiteDatabase.execSQL("INSERT INTO new_category SELECT * FROM category");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS category");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `category` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `UUID` TEXT NOT NULL, `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1, `accountType` TEXT, `accountName` TEXT DEFAULT '', `predefine` INTEGER NOT NULL DEFAULT 0, `lastModifiedAt` INTEGER NOT NULL, `serverTimestamp` INTEGER DEFAULT 1464416139847, `orderBy` INTEGER NOT NULL DEFAULT 999999, `displayName` TEXT NOT NULL, `displayNameColor` INTEGER NOT NULL DEFAULT -1)");
                supportSQLiteDatabase.execSQL("INSERT INTO category SELECT * FROM new_category");
            } catch (RuntimeException e) {
                DataLogger.m12303e(TAG, "migrate, createOrUpdateTables, e : " + e.getMessage());
            }
            AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE UNIQUE INDEX IF NOT EXISTS `index_category_UUID` ON `category` (`UUID`)", "CREATE UNIQUE INDEX IF NOT EXISTS `index_content_UUID` ON `content` (`UUID`)", "CREATE VIEW IF NOT EXISTS `category_memo_count` AS SELECT category.*, COUNT(sdoc._id) AS memoCount FROM category LEFT JOIN sdoc ON (category.UUID=sdoc.categoryUUID AND sdoc.isDeleted=0) WHERE category.isDeleted=0 GROUP BY category.UUID ORDER BY category.orderBy ASC", "CREATE TABLE IF NOT EXISTS `category_tree` (`UUID` TEXT NOT NULL, `parentUUID` TEXT, `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1, `createdAt` INTEGER NOT NULL, `lastModifiedAt` INTEGER NOT NULL, `serverTimestamp` INTEGER DEFAULT 1464416139847, `recycle_bin_time_moved` INTEGER NOT NULL DEFAULT 0, `displayName` TEXT NOT NULL, `path` TEXT, `orderBy` INTEGER, `displayNameColor` INTEGER NOT NULL DEFAULT -1, `isSyncWithMS` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`UUID`))");
            AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE UNIQUE INDEX IF NOT EXISTS `index_category_tree_UUID` ON `category_tree` (`UUID`)", "CREATE TABLE IF NOT EXISTS `category_tree_closure` (`ancestor` TEXT NOT NULL DEFAULT '', `descendant` TEXT NOT NULL DEFAULT '', `depth` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`ancestor`, `descendant`), FOREIGN KEY(`ancestor`) REFERENCES `category_tree`(`UUID`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`descendant`) REFERENCES `category_tree`(`UUID`) ON UPDATE CASCADE ON DELETE CASCADE )", "CREATE TABLE IF NOT EXISTS `document_page` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `UUID` TEXT NOT NULL DEFAULT '', `documentUUID` TEXT NOT NULL DEFAULT '', `index` INTEGER NOT NULL, `favorite` INTEGER NOT NULL, `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1)", "CREATE UNIQUE INDEX IF NOT EXISTS `index_document_page_UUID` ON `document_page` (`UUID`)");
            AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `mapped_document` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `UUID` TEXT NOT NULL DEFAULT '', `mappedUUID` TEXT NOT NULL DEFAULT '', `converted` INTEGER NOT NULL DEFAULT 1, `mappedAt` INTEGER NOT NULL DEFAULT 0)", "CREATE UNIQUE INDEX IF NOT EXISTS `index_mapped_document_mappedUUID` ON `mapped_document` (`mappedUUID`)", "CREATE TABLE IF NOT EXISTS `account` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `accountGuid` TEXT NOT NULL DEFAULT '', `accountType` TEXT NOT NULL DEFAULT '', `accountName` TEXT DEFAULT '', `primaryAccount` INTEGER NOT NULL DEFAULT 1)", "CREATE UNIQUE INDEX IF NOT EXISTS `index_account_accountGuid` ON `account` (`accountGuid`)");
            AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `server_only_folder_node` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `UUID` TEXT NOT NULL, `type` TEXT NOT NULL, `parentFolderNodeID` TEXT NOT NULL, `syncModifiedTime` INTEGER NOT NULL, `createdTime` INTEGER NOT NULL, `lastModifiedTime` INTEGER NOT NULL, `recyclerBinMovedTime` INTEGER NOT NULL, `name` TEXT NOT NULL, `state` TEXT NOT NULL, `restorePath` TEXT NOT NULL DEFAULT '', `isDirty` INTEGER NOT NULL DEFAULT 0)", "CREATE TABLE IF NOT EXISTS `document_template` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `_data` TEXT, `_size` INTEGER NOT NULL DEFAULT 0, `_display_name` TEXT DEFAULT '', `title` TEXT DEFAULT '', `createdAt` INTEGER NOT NULL DEFAULT 0, `lastModifiedAt` INTEGER NOT NULL DEFAULT 0, `mime_type` TEXT, `width` INTEGER NOT NULL DEFAULT 0, `height` INTEGER NOT NULL DEFAULT 0, `type` INTEGER NOT NULL DEFAULT 3)", "CREATE TABLE IF NOT EXISTS stroke ('_id' INTEGER PRIMARY KEY AUTOINCREMENT, 'hasVisualCue' INTEGER DEFAULT 0 ,'text' TEXT    DEFAULT '', 'left' INTEGER DEFAULT 0 ,'top' INTEGER DEFAULT 0 ,'right' INTEGER DEFAULT 0 ,'bottom' INTEGER DEFAULT 0 ,'filePath' TEXT    NOT NULL ,'sdocUUID' TEXT    NOT NULL ,'pageWidth' INTEGER DEFAULT 0  )", "ALTER TABLE stroke ADD `type` INTEGER NOT NULL DEFAULT 0");
            AbstractC2821a.m2233x(supportSQLiteDatabase, "ALTER TABLE stroke ADD `pageUuid` TEXT DEFAULT ''", "ALTER TABLE stroke ADD `actionLinkData` TEXT DEFAULT ''", "CREATE TABLE IF NOT EXISTS retry (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `sdocUUID` TEXT NOT NULL, `strokeFilePath` TEXT NOT NULL, `state` INTEGER NOT NULL DEFAULT 0, `recognitionCount` INTEGER NOT NULL DEFAULT 0, `lastModifiedAt` INTEGER NOT NULL)", "CREATE TABLE IF NOT EXISTS `sync_info` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `serverId` TEXT, `clientId` TEXT NOT NULL, `clientModifiedTime` INTEGER NOT NULL DEFAULT 0 , `isDirtyFolder` INTEGER NOT NULL DEFAULT 1, `clientModifiedTimeFolder` INTEGER NOT NULL DEFAULT 0, `isSyncFailed` INTEGER NOT NULL DEFAULT 0, `lastModifiedTimeFolder` INTEGER NOT NULL DEFAULT 0)");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_sync_info_clientId` ON `sync_info` (`clientId`)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `tag_list` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `normalizeName` TEXT NOT NULL, `docUUID` TEXT NOT NULL, `displayName` TEXT NOT NULL)");
            supportSQLiteDatabase.execSQL(SDocDBSQL.getSqlCreateHashtag());
            supportSQLiteDatabase.execSQL(SDocDBSQL.getSqlCreateHashtagContent());
            DataLogger.m12307i(TAG, "migrate, createOrUpdateTables - end");
        } finally {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS new_category");
        }
    }

    private String getLegacyThumbnailFolderPath(String str, String str2) {
        int length = str2.length();
        String strValueOf = String.valueOf(str2.charAt(length - 2));
        String strValueOf2 = String.valueOf(str2.charAt(length - 1));
        StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
        String str3 = File.separator;
        return AbstractC0541b.m776r(sbM1324q, str3, strValueOf, str3, strValueOf2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$migrateBackgroundColor$0(File file, String str) {
        return str.startsWith("d_");
    }

    private void migrateBackgroundColor(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        DataLogger.m12307i(TAG, "migrate, migrateBackgroundColor - start");
        File dir = BaseUtils.getApplicationContext().getDir("attach", 0);
        Cursor cursorQuery = supportSQLiteDatabase.query("SELECT UUID, strokeUUID FROM sdoc WHERE LENGTH(strokeUUID) > 0");
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("UUID"));
                        File[] fileArrListFiles = new File(getLegacyThumbnailFolderPath(dir.getAbsolutePath(), cursorQuery.getString(cursorQuery.getColumnIndex("strokeUUID")))).listFiles(new C0035a(1));
                        supportSQLiteDatabase.execSQL("UPDATE OR ABORT sdoc SET backgroundColor = ? WHERE UUID = ?", new Object[]{Integer.valueOf((fileArrListFiles == null || fileArrListFiles.length <= 0) ? -1 : 0), string});
                    } while (cursorQuery.moveToNext());
                }
            } catch (Throwable th) {
                try {
                    cursorQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        DataLogger.m12307i(TAG, "migrate, migrateBackgroundColor - end");
    }

    private void migrateCategoryToFolder(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        DataLogger.m12307i(TAG, "migrate, migrateCategoryToFolder - start");
        supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO category_tree (UUID, displayName, createdAt, lastModifiedAt) VALUES ('old:///', 'Old notebooks', 1464416139847, 1464416139847)");
        supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO category_tree_closure (ancestor, descendant, depth) VALUES ('old:///', 'old:///', 0)");
        supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO category_tree (UUID, parentUUID, isDeleted, isDirty, displayName, createdAt, lastModifiedAt, serverTimestamp, recycle_bin_time_moved, displayNameColor, orderBy) SELECT UUID, 'old:///', isDeleted, isDirty, displayName, lastModifiedAt, lastModifiedAt, serverTimestamp, lastModifiedAt, displayNameColor, orderBy FROM category");
        Cursor cursorQuery = supportSQLiteDatabase.query("SELECT UUID FROM category");
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("UUID"));
                        supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO category_tree_closure (ancestor, descendant, depth) SELECT ancestor, ?, depth + 1 FROM category_tree_closure WHERE descendant = 'old:///' UNION ALL SELECT ?, ?, 0", new String[]{string, string, string});
                    } while (cursorQuery.moveToNext());
                }
            } catch (Throwable th) {
                try {
                    cursorQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        supportSQLiteDatabase.execSQL("UPDATE OR ABORT category_tree SET displayName = 'Uncategorized', displayNameColor = 4290624957 WHERE UUID = 1");
        supportSQLiteDatabase.execSQL("UPDATE OR ABORT category_tree SET displayName = 'Screen off memo', displayNameColor = 4284572001 WHERE UUID = 2");
        supportSQLiteDatabase.execSQL("UPDATE OR ABORT sdoc SET absolutePath = 'old:///' || (SELECT tree.displayName FROM category_tree AS tree WHERE tree.UUID=sdoc.categoryUUID) WHERE isDeleted = 2");
        supportSQLiteDatabase.execSQL("UPDATE OR ABORT sdoc SET categoryUUID = '" + PredefinedCategory.RECYCLE_BIN.getUuid() + "' WHERE isDeleted = 2");
        supportSQLiteDatabase.execSQL("UPDATE OR ABORT sdoc SET isLock = 5 WHERE isLock IS NOT 0 AND isLock IS NOT -1 AND filePath LIKE '%.sdocx'");
        StringBuilder sb = new StringBuilder("UPDATE OR ABORT sdoc SET categoryUUID = '");
        PredefinedCategory predefinedCategory = PredefinedCategory.SHARED_NOTE_BOOK;
        sb.append(predefinedCategory.getUuid());
        sb.append("' WHERE mdeSpaceId != '' AND categoryUUID != '");
        sb.append(predefinedCategory.getUuid());
        sb.append("'");
        supportSQLiteDatabase.execSQL(sb.toString());
        DataLogger.m12307i(TAG, "migrate, migrateCategoryToFolder - end");
    }

    private void migrateDocumentTable(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        DataLogger.m12307i(TAG, "migrate, migrateDocumentTable - start");
        try {
            try {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `new_sdoc` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `UUID` TEXT NOT NULL, `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1, `accountType` TEXT, `accountName` TEXT DEFAULT '', `title` TEXT NOT NULL DEFAULT '', `content` BLOB NOT NULL, `displayContent` BLOB NOT NULL, `strippedContent` BLOB NOT NULL, `createdAt` INTEGER NOT NULL, `lastModifiedAt` INTEGER NOT NULL, `serverTimestamp` INTEGER DEFAULT 1464416139847, `vrUUID` TEXT DEFAULT '', `contentUUID` TEXT DEFAULT '', `firstContentType` INTEGER DEFAULT 0, `secondContentType` INTEGER DEFAULT 0, `strokeUUID` TEXT DEFAULT '', `strokeRatio` REAL DEFAULT 0.0, `categoryUUID` TEXT NOT NULL DEFAULT 'uncategorized:///', `categoryserverTimestamp` INTEGER DEFAULT 1464416139847, `categoryisDirty` INTEGER NOT NULL DEFAULT 1, `filePath` TEXT NOT NULL, `noteName` TEXT NOT NULL DEFAULT '', `isFavorite` INTEGER NOT NULL DEFAULT 0, `isLock` INTEGER NOT NULL DEFAULT 0, `isSaving` INTEGER NOT NULL DEFAULT 0, `reminderTriggerTime` INTEGER NOT NULL DEFAULT 0, `reminderRequestCode` INTEGER NOT NULL DEFAULT 0, `recycle_bin_time_moved` INTEGER NOT NULL DEFAULT 0, `contentSecureVersion` INTEGER NOT NULL DEFAULT 0, `size` INTEGER NOT NULL DEFAULT 0, `displayTitle` BLOB, `saveType` INTEGER NOT NULL DEFAULT 0, `firstOpendAt` INTEGER NOT NULL DEFAULT 0, `secondOpenedAt` INTEGER NOT NULL DEFAULT 0, `lastOpenedAt` INTEGER NOT NULL DEFAULT 0, `importedAt` INTEGER NOT NULL DEFAULT 0, `recommendedAt` INTEGER NOT NULL DEFAULT 0, `mdeSpaceId` TEXT NOT NULL DEFAULT '', `mdeItemId` TEXT NOT NULL DEFAULT '', `mdeExtra` TEXT NOT NULL DEFAULT '', `mdeGroupId` TEXT NOT NULL DEFAULT '', `mdeOwnerId` TEXT NOT NULL DEFAULT '', `firstHandwritingHeight` INTEGER NOT NULL DEFAULT 0, `deleteRecommended` INTEGER NOT NULL DEFAULT 0)");
                supportSQLiteDatabase.execSQL("INSERT INTO new_sdoc SELECT * FROM sdoc");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS sdoc");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `sdoc` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT, `UUID` TEXT NOT NULL, `isDeleted` INTEGER NOT NULL DEFAULT 0, `isDirty` INTEGER NOT NULL DEFAULT 1, `accountType` TEXT, `accountName` TEXT DEFAULT '', `title` TEXT NOT NULL DEFAULT '', `content` BLOB NOT NULL, `displayContent` BLOB NOT NULL, `strippedContent` BLOB NOT NULL, `createdAt` INTEGER NOT NULL, `lastModifiedAt` INTEGER NOT NULL, `serverTimestamp` INTEGER DEFAULT 1464416139847, `vrUUID` TEXT DEFAULT '', `contentUUID` TEXT DEFAULT '', `firstContentType` INTEGER DEFAULT 0, `secondContentType` INTEGER DEFAULT 0, `strokeUUID` TEXT DEFAULT '', `strokeRatio` REAL DEFAULT 0.0, `categoryUUID` TEXT NOT NULL DEFAULT 'uncategorized:///', `categoryserverTimestamp` INTEGER DEFAULT 1464416139847, `categoryisDirty` INTEGER NOT NULL DEFAULT 1, `filePath` TEXT NOT NULL, `noteName` TEXT NOT NULL DEFAULT '', `isFavorite` INTEGER NOT NULL DEFAULT 0, `isLock` INTEGER NOT NULL DEFAULT 0, `isSaving` INTEGER NOT NULL DEFAULT 0, `reminderTriggerTime` INTEGER NOT NULL DEFAULT 0, `reminderRequestCode` INTEGER NOT NULL DEFAULT 0, `recycle_bin_time_moved` INTEGER NOT NULL DEFAULT 0, `contentSecureVersion` INTEGER NOT NULL DEFAULT 0, `size` INTEGER NOT NULL DEFAULT 0, `displayTitle` BLOB, `saveType` INTEGER NOT NULL DEFAULT 0, `firstOpendAt` INTEGER NOT NULL DEFAULT 0, `secondOpenedAt` INTEGER NOT NULL DEFAULT 0, `lastOpenedAt` INTEGER NOT NULL DEFAULT 0, `importedAt` INTEGER NOT NULL DEFAULT 0, `recommendedAt` INTEGER NOT NULL DEFAULT 0, `mdeSpaceId` TEXT NOT NULL DEFAULT '', `mdeItemId` TEXT NOT NULL DEFAULT '', `mdeExtra` TEXT NOT NULL DEFAULT '', `mdeGroupId` TEXT NOT NULL DEFAULT '', `mdeOwnerId` TEXT NOT NULL DEFAULT '', `firstHandwritingHeight` INTEGER NOT NULL DEFAULT 0, `deleteRecommended` INTEGER NOT NULL DEFAULT 0)");
                supportSQLiteDatabase.execSQL("INSERT INTO sdoc SELECT * FROM new_sdoc");
            } catch (RuntimeException e) {
                DataLogger.m12303e(TAG, "migrateDocumentTable, e : " + e.getMessage());
            }
            AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE UNIQUE INDEX IF NOT EXISTS `index_sdoc_UUID` ON `sdoc` (`UUID`)", "ALTER TABLE sdoc ADD `absolutePath` TEXT", "ALTER TABLE sdoc ADD `backgroundColor` INTEGER NOT NULL DEFAULT 0", "ALTER TABLE sdoc ADD `backgroundColorInverted` INTEGER NOT NULL DEFAULT 0");
            AbstractC2821a.m2233x(supportSQLiteDatabase, "ALTER TABLE sdoc ADD `lastMappedAt` INTEGER NOT NULL DEFAULT 0", "ALTER TABLE sdoc ADD `recommendedTitle` TEXT NOT NULL DEFAULT ''", "ALTER TABLE sdoc ADD `lockAccountGuid` TEXT", "ALTER TABLE sdoc ADD `msSyncAccountId` TEXT");
            supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD `msSyncDocumentUuid` TEXT");
            supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD `msLastSyncTime` INTEGER NOT NULL DEFAULT 0");
            DataLogger.m12307i(TAG, "migrate, migrateDocumentTable - end");
        } finally {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS new_sdoc");
        }
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        try {
            try {
                DataLogger.m12307i(TAG, "migrate, start");
                try {
                    migrateDocumentTable(supportSQLiteDatabase);
                    createOrUpdateTables(supportSQLiteDatabase);
                } catch (Exception e) {
                    DataLogger.m12305f(TAG, "migrate - force createAllTable, e : " + e.getMessage());
                    createAllTable(supportSQLiteDatabase);
                }
                migrateCategoryToFolder(supportSQLiteDatabase);
                migrateBackgroundColor(supportSQLiteDatabase);
            } catch (Exception e2) {
                String str = TAG;
                DataLogger.m12305f(str, "migrate, e : " + e2.getMessage());
                DataLogger.m12307i(str, "migrate, end");
            }
        } finally {
            DataLogger.m12307i(TAG, "migrate, end");
        }
    }
}
