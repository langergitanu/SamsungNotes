package com.samsung.android.kmxservice.sdk.e2ee.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.kmxservice.sdk.util.HashUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class KmxDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_CREATE_E2EE_ITEM = "CREATE TABLE IF NOT EXISTS kmx_sdk_table (id INTEGER PRIMARY KEY AUTOINCREMENT, user_guid TEXT, service_id TEXT, service_key_id TEXT) ";
    static final String DB_KMX_E2EE = "kmx_sdk.db";
    static final int DB_VERSION = 2;
    private static final String TAG = LogTag.getTag("KmxDBHelper");
    private int counter;
    private final Object lock;

    public KmxDBHelper(Context context) {
        super(context, DB_KMX_E2EE, (SQLiteDatabase.CursorFactory) null, 2);
        this.counter = 0;
        this.lock = new Object();
    }

    private void migrationGuid(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery(" SELECT * FROM kmx_sdk_table", null);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (cursorRawQuery == null) {
                Log.e(TAG, "Cursor is NULL");
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                    return;
                }
                return;
            }
            int columnIndex = cursorRawQuery.getColumnIndex("user_guid");
            while (cursorRawQuery.moveToNext()) {
                String string = cursorRawQuery.getString(columnIndex);
                if (string != null) {
                    String str = TAG;
                    Log.e(str, "Upgrade DB ! " + string);
                    String sHA256Hash = HashUtil.getSHA256Hash(string);
                    Log.e(str, "Values [0]:" + string + "/ [1]:" + sHA256Hash);
                    if (!TextUtils.isEmpty(sHA256Hash)) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("user_guid", sHA256Hash);
                        sQLiteDatabase.update("kmx_sdk_table", contentValues, null, null);
                    }
                }
            }
            cursorRawQuery.close();
        } catch (Exception e2) {
            e = e2;
            cursor = cursorRawQuery;
            Log.e(TAG, "[Error DB migration] " + e);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorRawQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void close(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            synchronized (this.lock) {
                try {
                    int i = this.counter - 1;
                    this.counter = i;
                    if (i == 0) {
                        sQLiteDatabase.close();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase readableDatabase;
        synchronized (this.lock) {
            this.counter++;
            readableDatabase = super.getReadableDatabase();
        }
        return readableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase writableDatabase;
        synchronized (this.lock) {
            this.counter++;
            writableDatabase = super.getWritableDatabase();
        }
        return writableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(DATABASE_CREATE_E2EE_ITEM);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws Throwable {
        onCreate(sQLiteDatabase);
        AbstractC6670b.m4744e(i, i2, "Version [0]", " [1]", TAG);
        if (i < 2) {
            migrationGuid(sQLiteDatabase);
        }
    }
}
