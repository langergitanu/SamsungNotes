package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.constructor.AndroidClassConstructor;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.DisplayDataConverter;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AlterDBtoVersion36 extends Migration {
    private static final String TAG = DataLogger.createTag("AlterDBtoVersion36");

    public AlterDBtoVersion36() {
        super(35, 36);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[Catch: all -> 0x00f0, SQLException -> 0x00f3, SYNTHETIC, TRY_LEAVE, TryCatch #1 {SQLException -> 0x00f3, blocks: (B:43:0x00ec, B:56:0x0104, B:55:0x0101), top: B:78:0x0028 }] */
    @Override // androidx.room.migration.Migration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) throws Throwable {
        SupportSQLiteDatabase supportSQLiteDatabase2;
        SupportSQLiteDatabase supportSQLiteDatabase3;
        String str = TAG;
        DataLogger.m12302d(str, "alterDBtoVersion36, add doc size, display title");
        try {
            supportSQLiteDatabase.beginTransaction();
            supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN size INTEGER NOT NULL DEFAULT 0 ");
            supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN displayTitle BLOB ");
            supportSQLiteDatabase.setTransactionSuccessful();
            supportSQLiteDatabase.endTransaction();
            supportSQLiteDatabase.beginTransaction();
            try {
                try {
                    Cursor cursorQuery = supportSQLiteDatabase.query("SELECT filePath, UUID, title FROM sdoc WHERE isDeleted != 1 ");
                    int i = 0;
                    try {
                        if (cursorQuery != null) {
                            try {
                                if (cursorQuery.getCount() > 0) {
                                    DataLogger.m12302d(str, "alterDBtoVersion36, count: " + cursorQuery.getCount());
                                    if (cursorQuery.moveToFirst()) {
                                        while (true) {
                                            ContentValues contentValuesCreateContentValues = AndroidClassConstructor.createContentValues();
                                            try {
                                                String string = cursorQuery.getString(cursorQuery.getColumnIndex("filePath"));
                                                if (!TextUtils.isEmpty(string) && new File(string).exists()) {
                                                    contentValuesCreateContentValues.put("size", Long.valueOf(new File(string).length()));
                                                }
                                            } catch (Exception e) {
                                                DataLogger.m12304e(TAG, "alterDBtoVersion36", e);
                                            }
                                            try {
                                                contentValuesCreateContentValues.put("displayTitle", DisplayDataConverter.convertDisplayData(cursorQuery.getString(cursorQuery.getColumnIndex("title"))));
                                            } catch (Exception e2) {
                                                DataLogger.m12304e(TAG, "alterDBtoVersion36", e2);
                                            }
                                            if (contentValuesCreateContentValues.size() > 0) {
                                                supportSQLiteDatabase3 = supportSQLiteDatabase;
                                                try {
                                                    supportSQLiteDatabase3.update("sdoc", 1, contentValuesCreateContentValues, "UUID=?", new String[]{cursorQuery.getString(cursorQuery.getColumnIndex("UUID"))});
                                                    i++;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    Throwable th2 = th;
                                                    if (cursorQuery != null) {
                                                        throw th2;
                                                    }
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
                                    } else {
                                        supportSQLiteDatabase3 = supportSQLiteDatabase;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                Throwable th22 = th;
                                if (cursorQuery != null) {
                                }
                            }
                        }
                        supportSQLiteDatabase3.setTransactionSuccessful();
                        DataLogger.m12302d(TAG, "alterDBtoVersion36, updateCount: " + i);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        supportSQLiteDatabase3.endTransaction();
                    } catch (SQLException e3) {
                        e = e3;
                        SQLException sQLException = e;
                        DataLogger.m12304e(TAG, "alterDBtoVersion36", sQLException);
                        throw sQLException;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    Throwable th6 = th;
                    supportSQLiteDatabase.endTransaction();
                    throw th6;
                }
            } catch (SQLException e5) {
                e = e5;
            } catch (Throwable th7) {
                th = th7;
                Throwable th62 = th;
                supportSQLiteDatabase.endTransaction();
                throw th62;
            }
        } catch (SQLException e6) {
            supportSQLiteDatabase2 = supportSQLiteDatabase;
            try {
                DataLogger.m12304e(TAG, "alterDBtoVersion36", e6);
                throw e6;
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
