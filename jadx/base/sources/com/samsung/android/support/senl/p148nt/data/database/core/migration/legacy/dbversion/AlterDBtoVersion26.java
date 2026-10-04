package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.content.ContentValues;
import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AlterDBtoVersion26 extends Migration {
    private static final String TAG = DataLogger.createTag("AlterDBtoVersion26");

    public AlterDBtoVersion26() {
        super(25, 26);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) throws Throwable {
        SupportSQLiteDatabase supportSQLiteDatabase2;
        DataLogger.m12302d(TAG, "alterDBtoVersion26");
        try {
            supportSQLiteDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put("orderBy", (Integer) 1000000);
            supportSQLiteDatabase2 = supportSQLiteDatabase;
            try {
                try {
                    supportSQLiteDatabase2.update("category", 1, contentValues, "predefine=1", null);
                    contentValues.put("orderBy", Integer.valueOf(CategoryConstants.DEFAULT_REORDER));
                    supportSQLiteDatabase2.update("category", 1, contentValues, "predefine=2", null);
                    supportSQLiteDatabase2.setTransactionSuccessful();
                    supportSQLiteDatabase2.endTransaction();
                } catch (SQLException e) {
                    e = e;
                    SQLException sQLException = e;
                    DataLogger.m12304e(TAG, "alterDBtoVersion26()", sQLException);
                    throw sQLException;
                }
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                supportSQLiteDatabase2.endTransaction();
                throw th2;
            }
        } catch (SQLException e2) {
            e = e2;
            supportSQLiteDatabase2 = supportSQLiteDatabase;
        } catch (Throwable th3) {
            th = th3;
            supportSQLiteDatabase2 = supportSQLiteDatabase;
            Throwable th22 = th;
            supportSQLiteDatabase2.endTransaction();
            throw th22;
        }
    }
}
