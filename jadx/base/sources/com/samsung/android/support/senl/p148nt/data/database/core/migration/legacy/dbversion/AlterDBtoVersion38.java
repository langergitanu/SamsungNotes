package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AlterDBtoVersion38 extends Migration {
    private static final String TAG = DataLogger.createTag("AlterDBtoVersion38");

    public AlterDBtoVersion38() {
        super(37, 38);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        try {
            try {
                supportSQLiteDatabase.beginTransaction();
                supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN firstOpendAt INTEGER NOT NULL DEFAULT 0 ");
                supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN secondOpenedAt INTEGER NOT NULL DEFAULT 0 ");
                supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN lastOpenedAt INTEGER NOT NULL DEFAULT 0 ");
                supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN importedAt INTEGER NOT NULL DEFAULT 0 ");
                supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN recommendedAt INTEGER NOT NULL DEFAULT 0 ");
                supportSQLiteDatabase.execSQL("ALTER TABLE category ADD COLUMN displayNameColor INTEGER NOT NULL DEFAULT -1");
                supportSQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                DataLogger.m12304e(TAG, "alterDBtoVersion38", e);
                throw e;
            }
        } finally {
            supportSQLiteDatabase.endTransaction();
        }
    }
}
