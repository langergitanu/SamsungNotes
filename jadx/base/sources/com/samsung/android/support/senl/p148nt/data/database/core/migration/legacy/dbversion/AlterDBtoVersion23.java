package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.constants.DataConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AlterDBtoVersion23 extends Migration {
    private static final String TAG = DataLogger.createTag("AlterDBtoVersion23");

    public AlterDBtoVersion23() {
        super(22, 23);
    }

    public static String filePathParser(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String[] strArrSplit = str.split("/");
        return strArrSplit.length >= 1 ? strArrSplit[strArrSplit.length - 1] : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x009b  */
    @Override // androidx.room.migration.Migration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        boolean z;
        DataLogger.m12302d(TAG, "alterDBtoVersion23");
        supportSQLiteDatabase.beginTransaction();
        try {
            try {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                Cursor cursorQuery = supportSQLiteDatabase2.query("SELECT UUID, mime_type, _data, filePath FROM content");
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            while (true) {
                                String string = cursorQuery.getString(cursorQuery.getColumnIndex("UUID"));
                                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("mime_type"));
                                ContentValues contentValues = new ContentValues();
                                String strFilePathParser = filePathParser(cursorQuery.getString(cursorQuery.getColumnIndex("filePath")));
                                boolean z2 = true;
                                if (strFilePathParser.isEmpty()) {
                                    z = false;
                                } else {
                                    contentValues.put("filePath", strFilePathParser);
                                    z = true;
                                }
                                if (DataConstants.MIME_TYPE.VOICE.equals(string2)) {
                                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                                    if (string3.contains(":")) {
                                        String[] strArrSplit = string3.split(":");
                                        contentValues.put("_data", String.valueOf(Long.valueOf(((Long.parseLong(strArrSplit[1]) * 60) + (Long.parseLong(strArrSplit[0]) * 3600) + Long.parseLong(strArrSplit[2])) * 1000)));
                                    } else {
                                        z2 = z;
                                    }
                                    if (z2) {
                                        supportSQLiteDatabase2.update("content", 1, contentValues, "UUID=?", new String[]{string});
                                    }
                                    if (!cursorQuery.moveToNext()) {
                                        break;
                                    } else {
                                        supportSQLiteDatabase2 = supportSQLiteDatabase;
                                    }
                                }
                            }
                        }
                    } finally {
                    }
                }
                supportSQLiteDatabase.setTransactionSuccessful();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (SQLException e) {
                DataLogger.m12304e(TAG, "alterDBtoVersion23()", e);
                throw e;
            }
        } finally {
            supportSQLiteDatabase.endTransaction();
        }
    }
}
