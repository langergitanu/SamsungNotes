package com.samsung.android.support.senl.p148nt.data.database.core.migration.version;

import android.database.sqlite.SQLiteException;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MigrationToVersion48 extends Migration {
    private static final String TAG = DataLogger.createTag("MigrationToVersion48");

    public MigrationToVersion48() {
        super(47, 48);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        DataLogger.m12307i(TAG, "migrate, start");
        try {
            supportSQLiteDatabase.execSQL("ALTER TABLE retry ADD `version` INTEGER NOT NULL DEFAULT 0");
        } catch (SQLiteException e) {
            AbstractC0000a.m19p(e, new StringBuilder("migrate, e : "), TAG);
        }
        DataLogger.m12307i(TAG, "migrate, end");
    }
}
