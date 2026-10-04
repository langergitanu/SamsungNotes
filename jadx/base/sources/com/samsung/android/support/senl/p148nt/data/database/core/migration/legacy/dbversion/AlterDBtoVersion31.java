package com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.constructor.AndroidClassConstructor;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.data.Reminder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AlterDBtoVersion31 extends Migration {
    private static final String TAG = DataLogger.createTag("AlterDBtoVersion31");

    public AlterDBtoVersion31() {
        super(30, 31);
    }

    private List<Reminder> getReminderList(SupportSQLiteDatabase supportSQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = supportSQLiteDatabase.query(ReminderDbHelper.DATABASE_TABLE, new String[]{ReminderDbHelper.KEY_STRING_REMINDER_UUID, ReminderDbHelper.KEY_STRING_DOCUMENT_UUID, "request_code", ReminderDbHelper.KEY_LONG_TRIGGER_TIME, "state"});
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        while (!cursorQuery.isAfterLast()) {
                            Reminder reminder = new Reminder();
                            reminder.setDocumentUuid(cursorQuery.getString(1));
                            reminder.setRequestCode(cursorQuery.getInt(2));
                            reminder.setTriggerTime(cursorQuery.getLong(3));
                            arrayList.add(reminder);
                            cursorQuery.moveToNext();
                        }
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th) {
            DataLogger.m12303e(TAG, "getReminderList, e : " + th.getMessage());
        }
        DataLogger.m12302d(TAG, "getReminderList, reminderList size: " + arrayList.size());
        return arrayList;
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        DataLogger.m12302d(TAG, "alterDBtoVersion31");
        try {
            try {
                supportSQLiteDatabase.beginTransaction();
                supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN isSaving INTEGER DEFAULT 0 ");
                supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN reminderRequestCode INTEGER DEFAULT 0 ");
                supportSQLiteDatabase.execSQL("ALTER TABLE sdoc ADD COLUMN reminderTriggerTime INTEGER DEFAULT 0 ");
                supportSQLiteDatabase.setTransactionSuccessful();
                migrateDb(BaseUtils.getApplicationContext(), supportSQLiteDatabase);
            } catch (SQLException e) {
                DataLogger.m12304e(TAG, "alterDBtoVersion31", e);
                throw e;
            }
        } finally {
            supportSQLiteDatabase.endTransaction();
        }
    }

    public void migrateDb(Context context, SupportSQLiteDatabase supportSQLiteDatabase) {
        SupportSQLiteDatabase supportSQLiteDatabase2;
        if (ReminderDbHelper.isDatabaseExist(context)) {
            String str = TAG;
            DataLogger.m12302d(str, "migrateDb, start");
            List<Reminder> reminderList = getReminderList(supportSQLiteDatabase);
            DataLogger.m12302d(str, "migrateDb, reminder size: " + reminderList.size());
            for (Reminder reminder : reminderList) {
                if (System.currentTimeMillis() >= reminder.getTriggerTime() || reminder.getRequestCode() <= 0) {
                    supportSQLiteDatabase2 = supportSQLiteDatabase;
                } else {
                    ContentValues contentValuesCreateContentValues = AndroidClassConstructor.createContentValues();
                    contentValuesCreateContentValues.put("reminderRequestCode", Integer.valueOf(reminder.getRequestCode()));
                    contentValuesCreateContentValues.put("reminderTriggerTime", Long.valueOf(reminder.getTriggerTime()));
                    supportSQLiteDatabase2 = supportSQLiteDatabase;
                    supportSQLiteDatabase2.update("sdoc", 1, contentValuesCreateContentValues, "UUID=?", new String[]{reminder.getDocumentUuid()});
                }
                supportSQLiteDatabase = supportSQLiteDatabase2;
            }
            ReminderDbHelper.deleteDatabase(context);
            DataLogger.m12302d(TAG, "migrateDb, done");
        }
    }
}
