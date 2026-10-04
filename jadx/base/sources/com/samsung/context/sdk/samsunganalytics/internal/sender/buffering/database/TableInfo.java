package com.samsung.context.sdk.samsunganalytics.internal.sender.buffering.database;

import android.provider.BaseColumns;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TableInfo implements BaseColumns {
    public static final String COLUMN_NAME_DATA = "data";
    public static final String COLUMN_NAME_LOG_TYPE = "logtype";
    public static final String COLUMN_NAME_TIMESTAMP = "timestamp";
    public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS logs_v2 (_id INTEGER PRIMARY KEY AUTOINCREMENT, timestamp INTEGER, logtype TEXT, data TEXT)";
    public static final String TABLE_NAME = "logs_v2";
}
