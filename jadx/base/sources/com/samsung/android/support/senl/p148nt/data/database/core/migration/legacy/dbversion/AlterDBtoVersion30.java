package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.content.SharedPreferences;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.data.common.legacy.SDocDBSQL;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AlterDBtoVersion30 extends Migration {
    private static final String TAG = DataLogger.createTag("AlterDBtoVersion30");

    public AlterDBtoVersion30() {
        super(29, 30);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        DataLogger.m12302d(TAG, "alterDBtoVersion30");
        supportSQLiteDatabase.beginTransaction();
        Cursor cursorQuery = supportSQLiteDatabase.query("SELECT UUID, isLock, filePath FROM sdoc WHERE isLock>0 AND isDeleted= 0");
        try {
            SharedPreferences.Editor editorEdit = SharedPreferencesCompat.getInstance(SDocDBSQL.LOCKED_SDOC_LIST).edit();
            if (cursorQuery != null && cursorQuery.getCount() > 0 && cursorQuery.moveToFirst()) {
                do {
                    if (cursorQuery.getInt(cursorQuery.getColumnIndex("isLock")) == 1) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("UUID"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("filePath"));
                        if (string != null && string2 != null && string.length() > 0 && string2.length() > 0) {
                            editorEdit.putString(string, string2);
                            editorEdit.apply();
                        }
                    }
                } while (cursorQuery.moveToNext());
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            supportSQLiteDatabase.setTransactionSuccessful();
            supportSQLiteDatabase.endTransaction();
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
