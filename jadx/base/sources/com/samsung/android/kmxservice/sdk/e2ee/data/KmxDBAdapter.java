package com.samsung.android.kmxservice.sdk.e2ee.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxSdk;
import com.samsung.android.kmxservice.sdk.util.HashUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class KmxDBAdapter {
    private static final String TAG = LogTag.getTag("KmxDBAdapter");
    private final KmxDBHelper kmxDBHelper;

    public KmxDBAdapter(Context context) {
        this.kmxDBHelper = new KmxDBHelper(context);
    }

    public boolean compareGuid(String str) {
        SQLiteDatabase readableDatabase = this.kmxDBHelper.getReadableDatabase();
        String sHA256Hash = HashUtil.getSHA256Hash(str);
        try {
            try {
                Cursor cursorQuery = readableDatabase.query("kmx_sdk_table", new String[]{"user_guid"}, null, null, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToLast();
                            boolean zEquals = cursorQuery.getString(0).equals(sHA256Hash);
                            cursorQuery.close();
                            this.kmxDBHelper.close(readableDatabase);
                            return zEquals;
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e) {
                Log.e(TAG, "[getFabricId] " + e);
            }
            this.kmxDBHelper.close(readableDatabase);
            return false;
        } catch (Throwable th) {
            this.kmxDBHelper.close(readableDatabase);
            throw th;
        }
    }

    public String getGuid() {
        SQLiteDatabase readableDatabase = this.kmxDBHelper.getReadableDatabase();
        try {
            try {
                Cursor cursorQuery = readableDatabase.query("kmx_sdk_table", new String[]{"user_guid"}, null, null, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToLast();
                            String string = cursorQuery.getString(0);
                            cursorQuery.close();
                            return string;
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } finally {
                this.kmxDBHelper.close(readableDatabase);
            }
        } catch (Exception e) {
            Log.e(TAG, "[getFabricId] " + e);
        }
        return null;
    }

    public String getServiceKeyId(String str) {
        SQLiteDatabase readableDatabase = this.kmxDBHelper.getReadableDatabase();
        String sHA256Hash = readableDatabase.getVersion() >= 2 ? HashUtil.getSHA256Hash(KmxSdk.getGuid()) : KmxSdk.getGuid();
        int iDelete = readableDatabase.delete("kmx_sdk_table", "user_guid!= ? ", new String[]{sHA256Hash});
        if (iDelete > 0) {
            AbstractC2322a.m1631u(iDelete, "getServiceKeyId: deleted = ", TAG);
        }
        try {
            try {
                Cursor cursorQuery = readableDatabase.query("kmx_sdk_table", new String[]{"service_key_id"}, "service_id= ? AND user_guid=?", new String[]{str, sHA256Hash}, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToFirst();
                            String string = cursorQuery.getString(0);
                            cursorQuery.close();
                            this.kmxDBHelper.close(readableDatabase);
                            return string;
                        }
                    } finally {
                    }
                }
                Log.i(TAG, "[SERVICE_KEY_ID] result null or empty");
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                this.kmxDBHelper.close(readableDatabase);
                throw th;
            }
        } catch (Exception e) {
            Log.e(TAG, "[SERVICE_KEY_ID] " + e);
        }
        this.kmxDBHelper.close(readableDatabase);
        return null;
    }

    public void insertServiceKeyId(String str, String str2, String str3) {
        SQLiteDatabase writableDatabase = this.kmxDBHelper.getWritableDatabase();
        if (str == null) {
            return;
        }
        String sHA256Hash = writableDatabase.getVersion() >= 2 ? HashUtil.getSHA256Hash(KmxSdk.getGuid()) : KmxSdk.getGuid();
        try {
            try {
                writableDatabase.beginTransaction();
                int iDelete = writableDatabase.delete("kmx_sdk_table", "user_guid!= ? ", new String[]{sHA256Hash});
                String str4 = TAG;
                Log.i(str4, "insertServiceKeyId: deleted old guid = " + iDelete);
                ContentValues contentValues = new ContentValues();
                contentValues.put("service_key_id", str3);
                if (writableDatabase.update("kmx_sdk_table", contentValues, "service_id= ?", new String[]{str2}) == 0) {
                    contentValues.put("user_guid", sHA256Hash);
                    contentValues.put("service_id", str2);
                    Log.i(str4, "insertServiceKeyId: inserted guid = " + writableDatabase.insert("kmx_sdk_table", null, contentValues));
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                Log.e(TAG, "[insertServiceKeyId]" + e);
            }
            writableDatabase.endTransaction();
            this.kmxDBHelper.close(writableDatabase);
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            this.kmxDBHelper.close(writableDatabase);
            throw th;
        }
    }
}
