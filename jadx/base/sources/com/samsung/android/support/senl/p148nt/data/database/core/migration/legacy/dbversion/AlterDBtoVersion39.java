package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.legacy.SDocDBSQL;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AlterDBtoVersion39 extends Migration {
    private static final String TAG = DataLogger.createTag("AlterDBtoVersion39");

    public AlterDBtoVersion39() {
        super(38, 39);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        try {
            try {
                supportSQLiteDatabase.beginTransaction();
                supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN mdeSpaceId TEXT    NOT NULL DEFAULT '' ");
                supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN mdeItemId TEXT    NOT NULL DEFAULT '' ");
                supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN mdeExtra TEXT    NOT NULL DEFAULT '' ");
                supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN mdeGroupId TEXT    NOT NULL DEFAULT '' ");
                supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN mdeOwnerId TEXT    NOT NULL DEFAULT '' ");
                supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN firstHandwritingHeight INTEGER NOT NULL DEFAULT 0 ");
                supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN deleteRecommended INTEGER NOT NULL DEFAULT 0 ");
                supportSQLiteDatabase.execSQL(SDocDBSQL.getSqlCreateMdeView());
                supportSQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                DataLogger.m12304e(TAG, "alterDBtoVersion39", e);
                throw e;
            }
        } finally {
            supportSQLiteDatabase.endTransaction();
        }
    }
}
