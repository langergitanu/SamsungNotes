package com.samsung.android.support.senl.p148nt.data.database.core.migration.version;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MigrationToVersion63 extends Migration {
    private static final String TAG = DataLogger.createTag("MigrationToVersion63");

    public MigrationToVersion63() {
        super(62, 63);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        String str = TAG;
        DataLogger.m12307i(str, "migrate, start");
        supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD `mathMode` INTEGER NOT NULL DEFAULT 0");
        DataLogger.m12307i(str, "migrate, end");
    }
}
