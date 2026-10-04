package com.samsung.android.support.senl.p148nt.data.database.core.migration.version;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MigrationToVersion57 extends Migration {
    private static final String TAG = DataLogger.createTag("MigrationToVersion57");

    public MigrationToVersion57() {
        super(56, 57);
    }

    /* JADX WARN: Finally extract failed */
    private void addUuidValues(SupportSQLiteDatabase supportSQLiteDatabase) {
        try {
            Cursor cursorQuery = supportSQLiteDatabase.query("SELECT * FROM document_template");
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        int columnIndex = cursorQuery.getColumnIndex("_id");
                        if (columnIndex >= 0) {
                            while (true) {
                                long j = cursorQuery.getLong(columnIndex);
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("UUID", UUIDUtils.newUUID(BaseUtils.getApplicationContext()));
                                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                                supportSQLiteDatabase2.update(DBSchema.DocumentTemplate.TABLE_NAME, 2, contentValues, "_id=?", new Long[]{Long.valueOf(j)});
                                if (!cursorQuery.moveToNext()) {
                                    break;
                                } else {
                                    supportSQLiteDatabase = supportSQLiteDatabase2;
                                }
                            }
                        } else {
                            DataLogger.m12305f(TAG, "fail to migrate UUIDs");
                        }
                    }
                } catch (Throwable th) {
                    try {
                        cursorQuery.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e) {
            DataLogger.m12305f(TAG, "addUuidValues, e : " + e.getMessage());
        }
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        DataLogger.m12307i(TAG, "migrate, start");
        try {
            supportSQLiteDatabase.execSQL("ALTER TABLE document_template ADD UUID TEXT");
            supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_document_template_UUID` ON `document_template` (`UUID`)");
            supportSQLiteDatabase.execSQL("DROP VIEW IF EXISTS category_memo_count");
        } catch (SQLiteException e) {
            AbstractC0000a.m19p(e, new StringBuilder("migrate, e : "), TAG);
        }
        addUuidValues(supportSQLiteDatabase);
        DataLogger.m12307i(TAG, "migrate, end");
    }
}
