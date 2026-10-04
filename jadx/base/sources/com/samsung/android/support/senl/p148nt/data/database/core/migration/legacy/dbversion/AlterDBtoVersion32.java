package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AlterDBtoVersion32 extends Migration {
    private static final String TAG = DataLogger.createTag("AlterDBtoVersion32");

    public AlterDBtoVersion32() {
        super(31, 32);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        DataLogger.m12302d(TAG, "alterDBtoVersion32");
        try {
            try {
                supportSQLiteDatabase.beginTransaction();
                supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN recycle_bin_time_moved INTEGER NOT NULL DEFAULT 0 ");
                supportSQLiteDatabase.setTransactionSuccessful();
                RecycleBinDB32Provider.migrateDb(BaseUtils.getApplicationContext(), supportSQLiteDatabase);
            } catch (SQLException e) {
                DataLogger.m12304e(TAG, "alterDBtoVersion32", e);
                throw e;
            }
        } finally {
            supportSQLiteDatabase.endTransaction();
        }
    }
}
