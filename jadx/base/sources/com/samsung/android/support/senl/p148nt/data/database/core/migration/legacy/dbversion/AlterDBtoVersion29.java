package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.constructor.AndroidClassConstructor;
import com.samsung.android.support.senl.p148nt.data.common.legacy.SDocDBSQL;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AlterDBtoVersion29 extends Migration {
    private static final String TAG = DataLogger.createTag("AlterDBtoVersion29");

    public AlterDBtoVersion29() {
        super(28, 29);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    @Override // androidx.room.migration.Migration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) throws Throwable {
        SupportSQLiteDatabase supportSQLiteDatabase2;
        DataLogger.m12302d(TAG, "alterDBtoVersion29");
        Cursor cursorQuery = null;
        try {
            supportSQLiteDatabase.beginTransaction();
            cursorQuery = supportSQLiteDatabase.query("SELECT UUID FROM sdoc WHERE categoryUUID = 3");
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                supportSQLiteDatabase2 = supportSQLiteDatabase;
            } else {
                while (true) {
                    ContentValues contentValuesCreateContentValues = AndroidClassConstructor.createContentValues();
                    contentValuesCreateContentValues.put("categoryUUID", "1");
                    supportSQLiteDatabase2 = supportSQLiteDatabase;
                    try {
                        try {
                            supportSQLiteDatabase2.update("sdoc", 1, contentValuesCreateContentValues, "UUID=?", new String[]{cursorQuery.getString(cursorQuery.getColumnIndex("UUID"))});
                            if (!cursorQuery.moveToNext()) {
                                break;
                            } else {
                                supportSQLiteDatabase = supportSQLiteDatabase2;
                            }
                        } catch (SQLException e) {
                            e = e;
                            SQLException sQLException = e;
                            DataLogger.m12304e(TAG, "alterDBtoVersion29()", sQLException);
                            throw sQLException;
                        }
                    } catch (Throwable th) {
                        th = th;
                        Throwable th2 = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        supportSQLiteDatabase2.endTransaction();
                        throw th2;
                    }
                }
            }
            supportSQLiteDatabase2.execSQL(SDocDBSQL.getSqlDeletePopupMemo());
            supportSQLiteDatabase2.setTransactionSuccessful();
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            supportSQLiteDatabase2.endTransaction();
        } catch (SQLException e2) {
            e = e2;
            supportSQLiteDatabase2 = supportSQLiteDatabase;
        } catch (Throwable th3) {
            th = th3;
            supportSQLiteDatabase2 = supportSQLiteDatabase;
            Throwable th22 = th;
            if (cursorQuery != null) {
            }
            supportSQLiteDatabase2.endTransaction();
            throw th22;
        }
    }
}
