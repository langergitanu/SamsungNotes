package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RecycleBinDB32Provider {
    private static final String DATABASE_TABLE = "recyclebin_db_table";
    private static final String KEY_INT_ROW_ID = "_id";
    private static final String KEY_LONG_DELETED_TIME = "trigger_time";
    private static final String KEY_STRING_SDOC_UUID = "id_uuid_sdoc";
    private static final String TAG = DataLogger.createTag("RecycleBinDBHelper");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RecycleBinDBHelper extends SQLiteOpenHelper {
        private static final String DATABASE_CREATE = "create table recyclebin_db_table (_id integer primary key autoincrement,id_uuid_sdoc text not null, trigger_time integer not null);";
        private static final String DATABASE_NAME = "recylcebin.db";
        private static final int DATABASE_VERSION = 1;

        public RecycleBinDBHelper(Context context) {
            super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        }

        public static RecycleBinDBHelper createRecycleBinDBHelper(Context context) {
            return new RecycleBinDBHelper(context);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(DATABASE_CREATE);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    public static boolean deleteDatabase(Context context) {
        if (isDatabaseExist(context)) {
            return context.getDatabasePath("recylcebin.db").delete();
        }
        return false;
    }

    private static boolean isDatabaseExist(Context context) {
        boolean zExists = context.getDatabasePath("recylcebin.db").exists();
        DataLogger.m12302d(TAG, "isDatabaseExist, exist: " + zExists);
        return zExists;
    }

    public static void migrateDb(Context context, SupportSQLiteDatabase supportSQLiteDatabase) {
        if (!isDatabaseExist(context)) {
            return;
        }
        DataLogger.m12302d(TAG, "migrateDb, start");
        SQLiteDatabase readableDatabase = RecycleBinDBHelper.createRecycleBinDBHelper(context).getReadableDatabase();
        try {
            Cursor cursorQuery = readableDatabase.query(DATABASE_TABLE, new String[]{KEY_STRING_SDOC_UUID, "trigger_time"}, null, null, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        while (true) {
                            String string = cursorQuery.getString(0);
                            long j = cursorQuery.getLong(1);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("recycle_bin_time_moved", Long.valueOf(j));
                            SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                            supportSQLiteDatabase2.update("sdoc", 1, contentValues, "UUID IS '" + string + "'", null);
                            if (!cursorQuery.moveToNext()) {
                                break;
                            } else {
                                supportSQLiteDatabase = supportSQLiteDatabase2;
                            }
                        }
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            readableDatabase.close();
            boolean zDeleteDatabase = deleteDatabase(context);
            DataLogger.m12302d(TAG, "migrateDb, done. db delete : " + zDeleteDatabase);
        } finally {
        }
    }
}
