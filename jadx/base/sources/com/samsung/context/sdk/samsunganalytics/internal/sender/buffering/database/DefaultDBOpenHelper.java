package com.samsung.context.sdk.samsunganalytics.internal.sender.buffering.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.samsung.context.sdk.samsunganalytics.DBOpenHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DefaultDBOpenHelper extends SQLiteOpenHelper implements DBOpenHelper {
    public static final String DATABASE_NAME = "SamsungAnalytics.db";
    public static final int DATABASE_VERSION = 1;

    public DefaultDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, com.samsung.context.sdk.samsunganalytics.DBOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, com.samsung.context.sdk.samsunganalytics.DBOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(TableInfo.SQL_CREATE_TABLE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
