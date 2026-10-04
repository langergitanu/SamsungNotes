package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.VoiceTimeDataUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AlterDBtoVersion21 extends Migration {
    private static final String TAG = DataLogger.createTag("AlterDBtoVersion21");

    public AlterDBtoVersion21() {
        super(20, 21);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    @Override // androidx.room.migration.Migration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        SupportSQLiteDatabase supportSQLiteDatabase2;
        DataLogger.m12302d(TAG, "alterDBtoVersion21()");
        supportSQLiteDatabase.beginTransaction();
        try {
            Cursor cursorQuery = supportSQLiteDatabase.query("select UUID, filePath from content where mime_type = 'content/voice' and _data = ''");
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        while (true) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("UUID"));
                            String strCreateTimeString = VoiceTimeDataUtils.createTimeString(cursorQuery.getString(cursorQuery.getColumnIndex("filePath")));
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("_data", strCreateTimeString);
                            supportSQLiteDatabase2 = supportSQLiteDatabase;
                            supportSQLiteDatabase2.update("content", 1, contentValues, "UUID=?", new String[]{string});
                            if (!cursorQuery.moveToNext()) {
                                break;
                            } else {
                                supportSQLiteDatabase = supportSQLiteDatabase2;
                            }
                        }
                    } else {
                        supportSQLiteDatabase2 = supportSQLiteDatabase;
                    }
                } finally {
                }
            }
            supportSQLiteDatabase2.setTransactionSuccessful();
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            supportSQLiteDatabase2.endTransaction();
        } catch (SQLException e) {
            DataLogger.m12304e(TAG, "alterDBtoVersion20()", e);
            throw e;
        }
    }
}
