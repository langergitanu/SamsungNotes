package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ReminderDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_CREATE = "create table reminder_internal (_id integer primary key autoincrement,id_uuid_reminder text not null, id_uuid_document text not null, request_code integer not null, trigger_time integer not null,set_time integer not null,alarm_notify_done integer not null default 0,state integer not null default 0);";
    private static final String DATABASE_NAME = "reminder.db";
    public static final String DATABASE_TABLE = "reminder_internal";
    private static final int DATABASE_VERSION = 2;
    private static final String KEY_BOOL_ALARM_NOTIFY_DONE = "alarm_notify_done";
    public static final String KEY_INT_REQUEST_CODE = "request_code";
    private static final String KEY_INT_ROW_ID = "_id";
    public static final String KEY_INT_STATE = "state";
    private static final String KEY_LONG_SET_TIME = "set_time";
    public static final String KEY_LONG_TRIGGER_TIME = "trigger_time";
    public static final String KEY_STRING_DOCUMENT_UUID = "id_uuid_document";
    public static final String KEY_STRING_REMINDER_UUID = "id_uuid_reminder";
    private static final String TAG = DataLogger.createTag("ReminderDbHelper");

    public ReminderDbHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 2);
    }

    public static boolean deleteDatabase(Context context) {
        if (isDatabaseExist(context)) {
            return context.getDatabasePath(DATABASE_NAME).delete();
        }
        return false;
    }

    public static boolean isDatabaseExist(Context context) {
        boolean zExists = context.getDatabasePath(DATABASE_NAME).exists();
        DataLogger.m12302d(TAG, "isDatabaseExist, exist: " + zExists);
        return zExists;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        DataLogger.m12302d(TAG, "onCreate");
        sQLiteDatabase.execSQL(DATABASE_CREATE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        DataLogger.m12302d(TAG, "onUpgrade, oldVersion: " + i + ", newVersion: " + i2);
        if (i != 1) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE reminder_internal ADD COLUMN state integer not null default 0;");
        } catch (SQLiteException e) {
            DataLogger.m12304e(TAG, "onUpgrade", e);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS reminder_internal");
            onCreate(sQLiteDatabase);
        }
    }
}
