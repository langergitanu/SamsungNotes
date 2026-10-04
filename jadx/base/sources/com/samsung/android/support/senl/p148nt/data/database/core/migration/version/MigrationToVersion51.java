package com.samsung.android.support.senl.p148nt.data.database.core.migration.version;

import android.database.sqlite.SQLiteException;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MigrationToVersion51 extends Migration {
    private static final String TAG = DataLogger.createTag("MigrationToVersion51");

    public MigrationToVersion51() {
        super(50, 51);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        DataLogger.m12307i(TAG, "migrate, start");
        try {
            supportSQLiteDatabase.execSQL("DROP INDEX IF EXISTS `index_document_page_UUID`");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_document_page_UUIDs` ON `document_page` (`documentUUID`, `UUID`)");
        } catch (SQLiteException e) {
            AbstractC0000a.m19p(e, new StringBuilder("migrate, e : "), TAG);
        }
        DataLogger.m12307i(TAG, "migrate, end");
    }
}
