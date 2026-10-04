package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.constructor.AndroidClassConstructor;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.NotesDataConverter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AlterDBtoVersion34 extends Migration {
    private static final String TAG = DataLogger.createTag("AlterDBtoVersion34");

    public AlterDBtoVersion34() {
        super(33, 34);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ec  */
    @Override // androidx.room.migration.Migration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) throws Throwable {
        SupportSQLiteDatabase supportSQLiteDatabase2;
        DataLogger.m12302d(TAG, "alterDBtoVersion34, replace byte to string.");
        Cursor cursorQuery = null;
        try {
            try {
                supportSQLiteDatabase.beginTransaction();
                cursorQuery = supportSQLiteDatabase.query("SELECT content, strippedContent, UUID FROM sdoc WHERE isDeleted != 1");
                int i = 0;
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    supportSQLiteDatabase2 = supportSQLiteDatabase;
                } else {
                    int i2 = 0;
                    while (true) {
                        ContentValues contentValuesCreateContentValues = AndroidClassConstructor.createContentValues();
                        try {
                            cursorQuery.getString(cursorQuery.getColumnIndex("content"));
                        } catch (Exception e) {
                            DataLogger.m12303e(TAG, "alterDBtoVersion34, message: " + e.getMessage());
                            contentValuesCreateContentValues.put("content", NotesDataConverter.byteToString(cursorQuery.getBlob(cursorQuery.getColumnIndex("content"))));
                        }
                        try {
                            cursorQuery.getString(cursorQuery.getColumnIndex("strippedContent"));
                        } catch (Exception e2) {
                            DataLogger.m12303e(TAG, "alterDBtoVersion34, message: " + e2.getMessage());
                            contentValuesCreateContentValues.put("strippedContent", NotesDataConverter.byteToString(cursorQuery.getBlob(cursorQuery.getColumnIndex("strippedContent"))));
                        }
                        if (contentValuesCreateContentValues.size() > 0) {
                            supportSQLiteDatabase2 = supportSQLiteDatabase;
                            try {
                                try {
                                    supportSQLiteDatabase2.update("sdoc", 1, contentValuesCreateContentValues, "UUID=?", new String[]{cursorQuery.getString(cursorQuery.getColumnIndex("UUID"))});
                                    i2++;
                                } catch (SQLException e3) {
                                    e = e3;
                                    SQLException sQLException = e;
                                    DataLogger.m12304e(TAG, "alterDBtoVersion34", sQLException);
                                    throw sQLException;
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                supportSQLiteDatabase2.endTransaction();
                                throw th;
                            }
                        } else {
                            supportSQLiteDatabase2 = supportSQLiteDatabase;
                        }
                        if (!cursorQuery.moveToNext()) {
                            break;
                        } else {
                            supportSQLiteDatabase = supportSQLiteDatabase2;
                        }
                    }
                    i = i2;
                }
                supportSQLiteDatabase2.setTransactionSuccessful();
                DataLogger.m12302d(TAG, "alterDBtoVersion34, byteToStringCount: " + i);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                supportSQLiteDatabase2.endTransaction();
            } catch (SQLException e5) {
                e = e5;
                supportSQLiteDatabase2 = supportSQLiteDatabase;
            }
        } catch (Throwable th2) {
            th = th2;
            supportSQLiteDatabase2 = supportSQLiteDatabase;
            if (cursorQuery != null) {
            }
            supportSQLiteDatabase2.endTransaction();
            throw th;
        }
    }
}
