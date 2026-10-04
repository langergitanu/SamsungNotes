package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.constructor.AndroidClassConstructor;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AlterDBtoVersion37 extends Migration {
    private static final String TAG = DataLogger.createTag("AlterDBtoVersion37");

    public AlterDBtoVersion37() {
        super(36, 37);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0080  */
    @Override // androidx.room.migration.Migration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) throws Throwable {
        SupportSQLiteDatabase supportSQLiteDatabase2;
        SupportSQLiteDatabase supportSQLiteDatabase3;
        try {
            supportSQLiteDatabase.beginTransaction();
            supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN saveType INTEGER NOT NULL DEFAULT 0 ");
            supportSQLiteDatabase.setTransactionSuccessful();
            supportSQLiteDatabase.endTransaction();
            try {
                try {
                    supportSQLiteDatabase.beginTransaction();
                    Cursor cursorQuery = supportSQLiteDatabase.query("SELECT filePath, UUID, title FROM sdoc WHERE isDeleted != 1 ");
                    int i = 0;
                    try {
                        if (cursorQuery != null) {
                            try {
                                if (cursorQuery.getCount() <= 0 || !cursorQuery.moveToFirst()) {
                                    supportSQLiteDatabase3 = supportSQLiteDatabase;
                                } else {
                                    DataLogger.m12302d(TAG, "alterDBtoVersion37, count: " + cursorQuery.getCount());
                                    int i2 = 0;
                                    while (true) {
                                        ContentValues contentValuesCreateContentValues = AndroidClassConstructor.createContentValues();
                                        contentValuesCreateContentValues.put("saveType", (Integer) 0);
                                        if (contentValuesCreateContentValues.size() > 0) {
                                            supportSQLiteDatabase3 = supportSQLiteDatabase;
                                            try {
                                                supportSQLiteDatabase3.update("sdoc", 1, contentValuesCreateContentValues, "UUID=?", new String[]{cursorQuery.getString(cursorQuery.getColumnIndex("UUID"))});
                                                i2++;
                                            } catch (Throwable th) {
                                                th = th;
                                                Throwable th2 = th;
                                                try {
                                                    cursorQuery.close();
                                                    throw th2;
                                                } catch (Throwable th3) {
                                                    th2.addSuppressed(th3);
                                                    throw th2;
                                                }
                                            }
                                        } else {
                                            supportSQLiteDatabase3 = supportSQLiteDatabase;
                                        }
                                        if (!cursorQuery.moveToNext()) {
                                            break;
                                        } else {
                                            supportSQLiteDatabase = supportSQLiteDatabase3;
                                        }
                                    }
                                    i = i2;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        supportSQLiteDatabase3.setTransactionSuccessful();
                        DataLogger.m12302d(TAG, "alterDBtoVersion37, updateCount: " + i);
                        supportSQLiteDatabase3.endTransaction();
                    } catch (SQLException e) {
                        e = e;
                        SQLException sQLException = e;
                        DataLogger.m12304e(TAG, "alterDBtoVersion37", sQLException);
                        throw sQLException;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    Throwable th6 = th;
                    supportSQLiteDatabase.endTransaction();
                    throw th6;
                }
            } catch (SQLException e2) {
                e = e2;
            } catch (Throwable th7) {
                th = th7;
                Throwable th62 = th;
                supportSQLiteDatabase.endTransaction();
                throw th62;
            }
        } catch (SQLException e3) {
            supportSQLiteDatabase2 = supportSQLiteDatabase;
            try {
                DataLogger.m12304e(TAG, "alterDBtoVersion37", e3);
                throw e3;
            } catch (Throwable th8) {
                th = th8;
                Throwable th9 = th;
                supportSQLiteDatabase2.endTransaction();
                throw th9;
            }
        } catch (Throwable th10) {
            th = th10;
            supportSQLiteDatabase2 = supportSQLiteDatabase;
            Throwable th92 = th;
            supportSQLiteDatabase2.endTransaction();
            throw th92;
        }
    }
}
