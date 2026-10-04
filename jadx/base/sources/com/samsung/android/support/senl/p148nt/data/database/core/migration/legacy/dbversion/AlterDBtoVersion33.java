package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AlterDBtoVersion33 extends Migration {
    private static final String TAG = DataLogger.createTag("AlterDBtoVersion33");

    public AlterDBtoVersion33() {
        super(32, 33);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        DataLogger.m12302d(TAG, "alterDBtoVersion33");
        try {
            try {
                supportSQLiteDatabase.beginTransaction();
                supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN contentSecureVersion INTEGER NOT NULL DEFAULT 0 ");
                supportSQLiteDatabase.execSQL("ALTER TABLE content ADD COLUMN contentSecureVersion INTEGER NOT NULL DEFAULT 0 ");
                supportSQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                DataLogger.m12304e(TAG, "alterDBtoVersion33", e);
                throw e;
            }
        } finally {
            supportSQLiteDatabase.endTransaction();
        }
    }
}
