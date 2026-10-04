package com.samsung.android.support.senl.p148nt.data.database.core.migration.version;

import androidx.annotation.NonNull;
import androidx.glance.AbstractC2821a;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MigrationToVersion61 extends Migration {
    private static final String TAG = DataLogger.createTag("MigrationToVersion61");

    public MigrationToVersion61() {
        super(60, 61);
    }

    private void addColumns(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("ALTER TABLE content ADD `size` INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE content ADD `createdAt` INTEGER NOT NULL DEFAULT 0");
        DataLogger.m12307i(TAG, "addColumns");
    }

    private void createIndices(SupportSQLiteDatabase supportSQLiteDatabase) {
        AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE INDEX IF NOT EXISTS `index_sdoc_isFavorite` ON `sdoc` (`isFavorite`)", "CREATE INDEX IF NOT EXISTS `index_sdoc_filePath` ON `sdoc` (`filePath`)", "CREATE INDEX IF NOT EXISTS `index_content_sdocUUID` ON `content` (`sdocUUID`)", "CREATE INDEX IF NOT EXISTS `index_retry_state` ON `retry` (`state`)");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_tag_list_normalizeName` ON `tag_list` (`normalizeName`)");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_stroke_sdocUUID_type` ON `stroke` (`sdocUUID`, `type`)");
        supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_page_search_info_sdocUUID` ON `page_search_info` (`sdocUUID`)");
        DataLogger.m12307i(TAG, "createIndices");
    }

    private void dropIndices(SupportSQLiteDatabase supportSQLiteDatabase) {
        AbstractC2821a.m2233x(supportSQLiteDatabase, "DROP INDEX IF EXISTS `index_category_tree_UUID`", "DROP INDEX IF EXISTS `index_text_search_sdocUUID`", "DROP INDEX IF EXISTS `index_cover_category_UUID`", "DROP INDEX IF EXISTS `index_cover_template_UUID`");
        supportSQLiteDatabase.execSQL("DROP INDEX IF EXISTS `index_suggested_cover_documentUUID`");
        supportSQLiteDatabase.execSQL("DROP INDEX IF EXISTS `index_organized_document_documentUUID`");
        DataLogger.m12307i(TAG, "dropIndices");
    }

    private void dropTables(SupportSQLiteDatabase supportSQLiteDatabase) {
        AbstractC2821a.m2233x(supportSQLiteDatabase, "DROP TABLE IF EXISTS category", "DROP TABLE IF EXISTS account", "DROP TABLE IF EXISTS server_only_folder_node", "DROP TABLE IF EXISTS share_space_info");
        DataLogger.m12307i(TAG, "dropTables");
    }

    private void migratesColumns(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("UPDATE OR ABORT sdoc SET isLock = 0 WHERE isLock = -1");
        supportSQLiteDatabase.execSQL("UPDATE OR ABORT sdoc SET title = SUBSTR(title, 1, 300) WHERE LENGTH(title) > 300");
        supportSQLiteDatabase.execSQL("UPDATE OR ABORT sdoc SET content = CAST(SUBSTR(content, 1, 300) AS BLOB) WHERE LENGTH(content) > 300");
        DataLogger.m12307i(TAG, "migratesColumns");
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        String str = TAG;
        DataLogger.m12307i(str, "migrate, start");
        dropTables(supportSQLiteDatabase);
        migratesColumns(supportSQLiteDatabase);
        createIndices(supportSQLiteDatabase);
        dropIndices(supportSQLiteDatabase);
        addColumns(supportSQLiteDatabase);
        DataLogger.m12307i(str, "migrate, end");
    }
}
