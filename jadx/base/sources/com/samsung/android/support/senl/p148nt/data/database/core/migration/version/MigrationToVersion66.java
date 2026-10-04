package com.samsung.android.support.senl.p148nt.data.database.core.migration.version;

import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/database/core/migration/version/MigrationToVersion66;", "Landroidx/room/migration/Migration;", "<init>", "()V", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "addColumns", "createIndex", "createDocumentThumbnailTable", "createExternalSharedDocumentsTable", "createSyncFolderInfoTable", "dropIndex", "dropAutoTagTable", "Companion", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MigrationToVersion66 extends Migration {
    private static final String TAG = DataLogger.createTag("MigrationToVersion66");

    public MigrationToVersion66() {
        super(65, 66);
    }

    private final void addColumns(SupportSQLiteDatabase database) {
        database.execSQL("ALTER TABLE document_extra ADD `formatVersion` INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE sync_info ADD `deletedBy` INTEGER NOT NULL DEFAULT 0");
    }

    private final void createDocumentThumbnailTable(SupportSQLiteDatabase database) {
        database.execSQL("CREATE TABLE IF NOT EXISTS `document_thumbnail` (`UUID` TEXT NOT NULL PRIMARY KEY, `backgroundType` INTEGER NOT NULL DEFAULT 0,  `layout` INTEGER NOT NULL DEFAULT 0,  `imagePath` TEXT NOT NULL DEFAULT '',  `playTime` TEXT NOT NULL DEFAULT '',  FOREIGN KEY(`UUID`) REFERENCES `sdoc`(`UUID`) ON DELETE CASCADE)");
    }

    private final void createExternalSharedDocumentsTable(SupportSQLiteDatabase database) {
        database.execSQL("CREATE TABLE IF NOT EXISTS `external_shared_documents` (`UUID` TEXT NOT NULL PRIMARY KEY, `timestamp` INTEGER NOT NULL DEFAULT 0,  FOREIGN KEY(`UUID`) REFERENCES `sdoc`(`UUID`) ON DELETE CASCADE)");
    }

    private final void createIndex(SupportSQLiteDatabase database) {
        database.execSQL("CREATE INDEX IF NOT EXISTS `index_sdoc_importedAt` ON `sdoc` (`importedAt`)");
    }

    private final void createSyncFolderInfoTable(SupportSQLiteDatabase database) {
        database.execSQL("CREATE TABLE IF NOT EXISTS `sync_folder_info` (`UUID` TEXT NOT NULL PRIMARY KEY, `deletedBy` INTEGER NOT NULL DEFAULT 0)");
    }

    private final void dropAutoTagTable(SupportSQLiteDatabase database) {
        database.execSQL("DROP TABLE IF EXISTS auto_tag_list");
    }

    private final void dropIndex(SupportSQLiteDatabase database) {
        database.execSQL("DROP INDEX IF EXISTS `index_document_cover_documentUUID_templateUUID_categoryUUID`");
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NotNull SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        String str = TAG;
        DataLogger.m12307i(str, "migrate, start");
        addColumns(database);
        createIndex(database);
        createDocumentThumbnailTable(database);
        createExternalSharedDocumentsTable(database);
        createSyncFolderInfoTable(database);
        dropIndex(database);
        dropAutoTagTable(database);
        DataLogger.m12307i(str, "migrate, end");
    }
}
