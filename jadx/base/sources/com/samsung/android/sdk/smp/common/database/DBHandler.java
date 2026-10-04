package com.samsung.android.sdk.smp.common.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.adobe.internal.xmp.XMPConst;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.samsung.android.sdk.smp.common.constants.FeedbackEvent;
import com.samsung.android.sdk.smp.common.constants.MarketingState;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.sdk.smp.common.database.DBContract;
import com.samsung.android.sdk.smp.common.database.entity.AckDataEntity;
import com.samsung.android.sdk.smp.common.database.entity.ExternalFeedbackUrlDataEntity;
import com.samsung.android.sdk.smp.common.util.JSONUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DBHandler {
    private static final String DB_FEEDBACK_STATUS_DONE = "done";
    private static final String DB_FEEDBACK_STATUS_WAIT = "wait";
    private static final Object DB_LOCK = new Object();
    private static final int INVALID_INT = -1;
    private static final String TAG = "DBHandler";
    private static DBHandler mHandler;
    private static int mReferCount;
    private SQLiteDatabase mDb;
    private DBHelper mDbHelper;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TransactionWithinLoop {
        void execute();
    }

    private DBHandler(Context context) {
        DBHelper dBHelper = new DBHelper(context);
        this.mDbHelper = dBHelper;
        this.mDb = dBHelper.getWritableDatabase();
    }

    private void closeCursor(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    private synchronized int countAppStartData() {
        return countDataFromDb("start", "countAppStartData");
    }

    private synchronized int countDataFromDb(String str, String str2) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = this.mDb.rawQuery("SELECT COUNT (*) FROM " + str, null);
                if (cursorRawQuery.moveToFirst()) {
                    return cursorRawQuery.getInt(0);
                }
            } catch (Exception e) {
                SmpLog.m6494e(TAG, str2 + " db error. " + e.toString());
            }
            return 0;
        } finally {
            closeCursor(cursorRawQuery);
        }
    }

    private synchronized int countSessionData() {
        int i;
        int i2 = 0;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mDb.query("session", new String[]{"count"}, null, null, null, null, null);
                i = 0;
                while (cursorQuery.moveToNext()) {
                    try {
                        i += cursorQuery.getInt(0);
                    } catch (Exception e) {
                        e = e;
                        i2 = i;
                        SmpLog.m6494e(TAG, "error while handling session. " + e.toString());
                        closeCursor(cursorQuery);
                        i = i2;
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        } finally {
            closeCursor(null);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void deleteAckData(String str) {
        try {
            this.mDb.delete("ack", "rid=?", new String[]{str});
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "[" + str + "] fail to delete ack data. database delete exception. " + e.toString());
        }
    }

    private synchronized void deleteAllFeedbacks() {
        try {
            this.mDb.delete("feedback", null, null);
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling feedback data. " + e.toString());
        }
    }

    private synchronized void deleteAllMarketingData() {
        try {
            this.mDb.delete(DBContract.Tables.MARKETING, null, null);
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling marketing data. " + e.toString());
        }
    }

    private synchronized boolean getBooleanValueFromDbWithMid(String str, String str2, String str3, String str4, String str5) throws Throwable {
        try {
        } catch (Throwable th) {
            th = th;
            while (true) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return 1 == getIntValueFromDbWithMid(str, str2, str3, str4, str5);
    }

    private synchronized int getIntValueFromDbWithMid(String str, String str2, String str3, String str4, String str5) {
        if (!TextUtils.isEmpty(str4)) {
            Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = this.mDb.query(str, new String[]{str2}, str3 + "=?", new String[]{str4}, null, null, null, null);
                    if (cursorQuery.moveToFirst()) {
                        int i = cursorQuery.getInt(0);
                        closeCursor(cursorQuery);
                        return i;
                    }
                } catch (Exception e) {
                    SmpLog.m6495e(TAG, str4, str5 + " db error. " + e.toString());
                }
                closeCursor(cursorQuery);
            } catch (Throwable th) {
                closeCursor(cursorQuery);
                throw th;
            }
        }
        return -1;
    }

    private synchronized long getLongValueFromDbWithMid(String str, String str2, String str3, String str4, String str5) {
        if (!TextUtils.isEmpty(str4)) {
            Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = this.mDb.query(str, new String[]{str2}, str3 + "=?", new String[]{str4}, null, null, null, null);
                    if (cursorQuery.moveToFirst()) {
                        long j = cursorQuery.getLong(0);
                        closeCursor(cursorQuery);
                        return j;
                    }
                } catch (Exception e) {
                    SmpLog.m6495e(TAG, str4, str5 + " db error. " + e.toString());
                }
                closeCursor(cursorQuery);
            } catch (Throwable th) {
                closeCursor(cursorQuery);
                throw th;
            }
        }
        return -1L;
    }

    private static String getStringFromCursor(Cursor cursor, String str, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        return columnIndex == -1 ? str2 : cursor.getString(columnIndex);
    }

    private synchronized String getStringValueFromDb(String str, String str2, String str3, String str4, String str5, String str6) {
        Throwable th;
        Exception exc;
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            cursorQuery = this.mDb.query(str, new String[]{str2}, str3, new String[]{str4}, null, null, null);
            try {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(!TextUtils.isEmpty(str5) ? cursorQuery.getColumnIndex(str5) : 0);
                        closeCursor(cursorQuery);
                        return string;
                    }
                } catch (Exception e) {
                    exc = e;
                    SmpLog.m6494e(TAG, str6 + " db error. " + exc.toString());
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                closeCursor(cursor);
                throw th;
            }
        } catch (Exception e2) {
            exc = e2;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            closeCursor(cursor);
            throw th;
        }
        closeCursor(cursorQuery);
        return null;
    }

    private String getStringValueFromDbWithMid(String str, String str2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        return getStringValueFromDb(str, str2, AbstractC0541b.m756B(str3, "=?"), str4, null, AbstractC0541b.m757C(str4, " ", str5));
    }

    private synchronized boolean hasValueFromDbWithMid(String str, String str2, String str3, String str4, String str5) {
        if (!TextUtils.isEmpty(str4)) {
            Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = this.mDb.query(str, new String[]{str2}, str3 + "=?", new String[]{str4}, null, null, null, null);
                    boolean zMoveToFirst = cursorQuery.moveToFirst();
                    closeCursor(cursorQuery);
                    return zMoveToFirst;
                } catch (Exception e) {
                    SmpLog.m6495e(TAG, str4, str5 + " db error. " + e.toString());
                    closeCursor(cursorQuery);
                    return false;
                }
            } catch (Throwable th) {
                closeCursor(cursorQuery);
                throw th;
            }
        }
        return false;
    }

    private synchronized int modDisplayId(int i) {
        return (i % 999) + 9000000;
    }

    public static DBHandler open(Context context) {
        DBHandler dBHandler;
        if (context == null) {
            SmpLog.m6494e(TAG, "db open fail : context null");
            return null;
        }
        synchronized (DB_LOCK) {
            mReferCount++;
            SmpLog.m6500v(TAG, "db open : " + mReferCount);
            if (mHandler == null) {
                try {
                    mHandler = new DBHandler(context);
                } catch (Exception e) {
                    mReferCount--;
                    SmpLog.m6494e(TAG, "db open fail : " + e.toString());
                    return null;
                }
            }
            dBHandler = mHandler;
        }
        return dBHandler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void performTransactionWithinLoop(TransactionWithinLoop transactionWithinLoop, String str) {
        try {
        } catch (Exception e) {
            String str2 = TAG;
            StringBuilder sbM781w = AbstractC0541b.m781w(str, " error while end transaction. ");
            AbstractC6670b.m4737B(e, sbM781w, str2);
            str = sbM781w;
        }
        try {
            try {
                this.mDb.beginTransaction();
                transactionWithinLoop.execute();
                this.mDb.setTransactionSuccessful();
                this.mDb.endTransaction();
            } catch (Throwable th) {
                try {
                    this.mDb.endTransaction();
                } catch (Exception e2) {
                    AbstractC6670b.m4737B(e2, AbstractC0541b.m781w(str, " error while end transaction. "), TAG);
                }
                throw th;
            }
        } catch (Exception e3) {
            SmpLog.m6494e(TAG, str + " error while perform transaction within loop. " + e3.toString());
            this.mDb.endTransaction();
            str = str;
        }
    }

    private boolean updateMarketingDbValueWithMid(String str, Object obj, String str2, String str3) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                ContentValues contentValues = new ContentValues();
                if (obj.getClass() == Integer.class) {
                    contentValues.put(str, (Integer) obj);
                } else if (obj.getClass() == Float.class) {
                    contentValues.put(str, (Float) obj);
                } else if (obj.getClass() == Boolean.class) {
                    if (((Boolean) obj).booleanValue()) {
                        contentValues.put(str, (Integer) 1);
                    } else {
                        contentValues.put(str, (Integer) 0);
                    }
                } else if (obj.getClass() == Double.class) {
                    contentValues.put(str, (Double) obj);
                } else {
                    if (obj.getClass() != Long.class) {
                        if (obj.getClass() == String.class) {
                            contentValues.put(str, (String) obj);
                        }
                    }
                    contentValues.put(str, (Long) obj);
                }
                return this.mDb.update(DBContract.Tables.MARKETING, contentValues, "mid = ?", new String[]{str2}) != 0;
            } catch (Exception e) {
                String str4 = TAG;
                StringBuilder sbM781w = AbstractC0541b.m781w(str3, " db error. ");
                sbM781w.append(e.toString());
                SmpLog.m6495e(str4, str2, sbM781w.toString());
            }
        }
        return false;
    }

    public synchronized long addAckData(String str, long j, String str2, String str3, String str4) {
        ContentValues contentValues;
        try {
            contentValues = new ContentValues();
            contentValues.put(DBContract.AckColumns.RID, str);
            contentValues.put(DBContract.AckColumns.TIMESTAMP, Long.valueOf(j));
            contentValues.put("fail", (Integer) 0);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            contentValues.put("type", str2);
            if (!TextUtils.isEmpty(str3)) {
                contentValues.put(DBContract.AckColumns.ERROR_CODE, str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                contentValues.put(DBContract.AckColumns.ERROR_MSG, str4);
            }
            try {
            } catch (Exception e) {
                SmpLog.m6494e(TAG, "fail to add ack. database insert exception." + e.toString());
                return -1L;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mDb.insertWithOnConflict("ack", null, contentValues, 4);
    }

    public synchronized void addAppStartData(JSONObject jSONObject) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("start", jSONObject.toString());
            contentValues.put("fail", (Integer) 0);
            this.mDb.insert("start", null, contentValues);
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling app start. " + e.toString());
        }
    }

    public synchronized void addExternalFeedbackData(String str) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("path", str);
            contentValues.put("fail", (Integer) 0);
            contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            this.mDb.insert(DBContract.Tables.EXTERNAL_FEEDBACK, null, contentValues);
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling external feedback data. " + e.toString());
        }
    }

    public synchronized boolean addFeedbackData(String str, FeedbackEvent feedbackEvent, String str2) {
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && feedbackEvent != null) {
                if (!isMarketingExist(str)) {
                    SmpLog.m6502w(TAG, str, "error while adding feedback. " + str + " not exists.");
                    return false;
                }
                try {
                    boolean z = getFeedbackState(str) != null;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(NetworkConfig.CLIENTS_FEEDBACK_FBID, feedbackEvent.value());
                    jSONObject.put("dts", jCurrentTimeMillis);
                    if (str2 != null) {
                        jSONObject.put(NetworkConfig.CLIENTS_FEEDBACK_DETAIL, str2);
                    }
                    JSONArray feedbackData = z ? getFeedbackData(str) : new JSONArray();
                    feedbackData.put(jSONObject);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("mid", str);
                    if (!FeedbackEvent.CUSTOM_FEEDBACK.equals(feedbackEvent)) {
                        contentValues.put(DBContract.FeedbackColumns.LAST_FBID, Integer.valueOf(feedbackEvent.value()));
                    }
                    contentValues.put(DBContract.FeedbackColumns.LAST_TIMESTAMP, Long.valueOf(jCurrentTimeMillis));
                    contentValues.put(DBContract.FeedbackColumns.FEEDBACKS, feedbackData.toString());
                    contentValues.put("state", DB_FEEDBACK_STATUS_WAIT);
                    if (FeedbackDetailConstants.APP_UPDATE.equals(str2)) {
                        contentValues.put(DBContract.FeedbackColumns.IS_APP_UPDATE_FEEDBACK_ADDED, (Integer) 1);
                    } else if (FeedbackDetailConstants.REBOOT.equals(str2)) {
                        contentValues.put(DBContract.FeedbackColumns.IS_REBOOT_FEEDBACK_ADDED, (Integer) 1);
                    }
                    if (z) {
                        return this.mDb.update("feedback", contentValues, "mid = ?", new String[]{str}) != 0;
                    }
                    if (this.mDb.insert("feedback", null, contentValues) != -1) {
                        return true;
                    }
                    SmpLog.m6495e(TAG, str, "error while handling feedback. insert fail");
                    return false;
                } catch (Exception e) {
                    SmpLog.m6495e(TAG, str, "error while handling feedback. " + e.toString());
                    return false;
                }
            }
            SmpLog.m6495e(TAG, str, "error while handling feedback. invalid params");
            return false;
        }
    }

    public synchronized void addSessionData(String str, int i) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("session", str);
            contentValues.put("count", Integer.valueOf(i));
            contentValues.put("fail", (Integer) 0);
            this.mDb.insert("session", null, contentValues);
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling session. " + e.toString());
        }
    }

    public void close() {
        synchronized (DB_LOCK) {
            try {
                int i = mReferCount - 1;
                mReferCount = i;
                if (i <= 0) {
                    try {
                        SQLiteDatabase sQLiteDatabase = this.mDb;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        DBHelper dBHelper = this.mDbHelper;
                        if (dBHelper != null) {
                            dBHelper.close();
                        }
                    } catch (Exception e) {
                        SmpLog.m6494e(TAG, "close fail. " + e.toString());
                    }
                    this.mDb = null;
                    this.mDbHelper = null;
                    mHandler = null;
                    mReferCount = 0;
                }
                SmpLog.m6500v(TAG, "db close : " + mReferCount);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized int countExternalFeedbackData() {
        return countDataFromDb(DBContract.Tables.EXTERNAL_FEEDBACK, "countExternalFeedbackData");
    }

    public synchronized long countIncompletedMarketings() {
        Cursor cursorQuery;
        cursorQuery = null;
        try {
            try {
                cursorQuery = this.mDb.query(DBContract.Tables.MARKETING, new String[]{"mid"}, "state=? OR state=? OR state=? OR state=?", new String[]{MarketingState.INCOMP_DISPLAY.name(), MarketingState.INCOMP_RESOURCE.name(), MarketingState.INCOMP_GET_STATUS_API.name()}, null, null, null, null);
            } catch (Exception e) {
                SmpLog.m6494e(TAG, "db error. " + e.toString());
                return 0L;
            }
        } finally {
            closeCursor(cursorQuery);
        }
        return cursorQuery.getCount();
    }

    public synchronized int countMarketingsDisplayedIn(long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = this.mDb.rawQuery("SELECT COUNT (*) FROM card WHERE mdt> ? AND msgtype!=? AND mid NOT LIKE ?", new String[]{String.valueOf(System.currentTimeMillis() - j), "test", "%_test"});
            } catch (Exception e) {
                SmpLog.m6501w(TAG, "fail to count marketings displayed in " + (j / Constants.HOURMILLIS) + " hours:" + e.toString());
            }
            if (cursorRawQuery == null || !cursorRawQuery.moveToFirst()) {
                SmpLog.m6492d(TAG, "fail to find and move cursor.");
                return -1;
            }
            SmpLog.m6492d(TAG, cursorRawQuery.getInt(0) + " marketings displayed in " + (j / Constants.HOURMILLIS) + " hours");
            return cursorRawQuery.getInt(0);
        } finally {
            closeCursor(null);
        }
    }

    public synchronized void deleteAckList(final ArrayList<AckDataEntity> arrayList) {
        performTransactionWithinLoop(new TransactionWithinLoop() { // from class: com.samsung.android.sdk.smp.common.database.DBHandler.1
            @Override // com.samsung.android.sdk.smp.common.database.DBHandler.TransactionWithinLoop
            public void execute() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    DBHandler.this.deleteAckData(((AckDataEntity) it.next()).getRequestId());
                }
            }
        }, "deleteAckList. ");
    }

    public synchronized void deleteAll() {
        deleteAllMarketingData();
        deleteAllFeedbacks();
        deleteAllAckData();
        deleteAllAppFilter();
        deleteAllAppStartData();
        deleteAllSessionData();
        deleteAllExternalFeedbackData();
        deleteAllAppReferrer();
    }

    public synchronized void deleteAllAckData() {
        try {
            this.mDb.delete("ack", null, null);
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling ack data. " + e.toString());
        }
    }

    public synchronized boolean deleteAllAppFilter() {
        try {
            this.mDb.delete("appfilter", null, null);
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling delete app filter. " + e.toString());
            return false;
        }
        return true;
    }

    public synchronized boolean deleteAllAppReferrer() {
        try {
            this.mDb.delete(DBContract.Tables.APP_REFERRER, null, null);
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling delete app referrer. " + e.toString());
            return false;
        }
        return true;
    }

    public synchronized void deleteAllAppStartData() {
        try {
            this.mDb.delete("start", null, null);
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling app start. " + e.toString());
        }
    }

    public synchronized void deleteAllExternalFeedbackData() {
        try {
            this.mDb.delete(DBContract.Tables.EXTERNAL_FEEDBACK, null, null);
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling external feedback data. " + e.toString());
        }
    }

    public synchronized void deleteAllSessionData() {
        try {
            this.mDb.delete("session", null, null);
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling session. " + e.toString());
        }
    }

    public synchronized boolean deleteAppFilter(String str) {
        try {
            this.mDb.delete("appfilter", "key=?", new String[]{str});
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling delete app filter. " + e.toString());
            return false;
        }
        return true;
    }

    public synchronized boolean deleteAppReferrer(String str) {
        try {
            this.mDb.delete(DBContract.Tables.APP_REFERRER, "key=?", new String[]{str});
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling delete app referrer. " + e.toString());
            return false;
        }
        return true;
    }

    public synchronized boolean deleteExternalFeedbackData(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return this.mDb.delete(DBContract.Tables.EXTERNAL_FEEDBACK, "path=?", new String[]{str}) != 0;
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "db error. " + e.toString());
            return false;
        }
    }

    public synchronized void deleteFeedbacks(String str, JSONArray jSONArray) {
        if (TextUtils.isEmpty(str) && jSONArray == null) {
            SmpLog.m6494e(TAG, "deleteFeedbacks. error : mid or feedback null");
            return;
        }
        JSONArray feedbackData = getFeedbackData(str);
        if (feedbackData.length() == 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            int i2 = jSONArray.getJSONObject(i).getInt(NetworkConfig.CLIENTS_FEEDBACK_FBID);
            int i4 = 0;
            while (true) {
                if (i4 >= feedbackData.length()) {
                    break;
                }
                if (i2 == feedbackData.getJSONObject(i4).getInt(NetworkConfig.CLIENTS_FEEDBACK_FBID)) {
                    feedbackData = JSONUtil.removeItemFromJsonArray(feedbackData, i4);
                    break;
                }
                i4++;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBContract.FeedbackColumns.FEEDBACKS, feedbackData.toString());
        if (feedbackData.length() > 0) {
            SmpLog.m6493d(TAG, str, "feedbacks left : " + feedbackData.toString());
            contentValues.put("state", DB_FEEDBACK_STATUS_WAIT);
        } else {
            contentValues.put("state", "done");
        }
        try {
            this.mDb.update("feedback", contentValues, "mid = ?", new String[]{str});
        } catch (Exception e) {
            SmpLog.m6495e(TAG, str, "error while handling feedback. " + e.toString());
        }
    }

    public synchronized boolean deleteMarketingData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return this.mDb.delete(DBContract.Tables.MARKETING, "mid=?", new String[]{str}) != 0;
            } catch (Exception e) {
                SmpLog.m6495e(TAG, str, "db error. " + e.toString());
                return false;
            }
        }
        return false;
    }

    public synchronized void deleteOldestAppStartData() {
        try {
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling app start. " + e.toString());
        }
        if (countAppStartData() > 100) {
            this.mDb.execSQL("DELETE FROM start WHERE _id IN (SELECT _id FROM start ORDER BY _id DESC LIMIT -1 OFFSET 100)");
        }
    }

    public synchronized void deleteOldestSessionData() {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mDb.query("session", new String[]{"count"}, null, null, null, null, "_id asc");
                int i = 0;
                for (int iCountSessionData = countSessionData(); iCountSessionData > 500 && cursorQuery.moveToNext(); iCountSessionData -= cursorQuery.getInt(0)) {
                    i++;
                }
                if (i > 0) {
                    SmpLog.m6492d(TAG, "over max count of sessions. " + i + " row(s) will be deleted");
                    this.mDb.execSQL("DELETE FROM session WHERE _id IN (SELECT _id FROM session ORDER BY _id ASC LIMIT " + i + ")");
                }
            } catch (Exception e) {
                SmpLog.m6494e(TAG, "error while handling session. " + e.toString());
            }
            closeCursor(cursorQuery);
        } catch (Throwable th) {
            closeCursor(cursorQuery);
            throw th;
        }
    }

    public synchronized void deleteOverRetryAck(int i) {
        try {
            this.mDb.delete("ack", "fail>?", new String[]{String.valueOf(i)});
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "delete max ack retry. database delete exception. " + e.toString());
        }
    }

    public synchronized void deleteOverRetryAppStart(int i) {
        try {
            this.mDb.delete("start", "fail>=?", new String[]{String.valueOf(i)});
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "delete max ack retry. database delete exception. " + e.toString());
        }
    }

    public synchronized void deleteOverRetrySession(int i) {
        try {
            this.mDb.delete("session", "fail>=?", new String[]{String.valueOf(i)});
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "delete max ack retry. database delete exception. " + e.toString());
        }
    }

    public synchronized int getAckCount() {
        return countDataFromDb("ack", "getAckCount");
    }

    public synchronized ArrayList<AckDataEntity> getAckList() {
        ArrayList<AckDataEntity> arrayList;
        arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = this.mDb.query("ack", null, null, null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    try {
                        arrayList.add(new AckDataEntity(cursorQuery.getString(cursorQuery.getColumnIndex(DBContract.AckColumns.RID)), cursorQuery.getLong(cursorQuery.getColumnIndex(DBContract.AckColumns.TIMESTAMP)), cursorQuery.getLong(cursorQuery.getColumnIndex("fail")), cursorQuery.getString(cursorQuery.getColumnIndex("type")), getStringFromCursor(cursorQuery, DBContract.AckColumns.ERROR_CODE, null), getStringFromCursor(cursorQuery, DBContract.AckColumns.ERROR_MSG, null)));
                    } catch (Exception e) {
                        e = e;
                        cursor = cursorQuery;
                        SmpLog.m6494e(TAG, "get ack error. " + e.toString());
                        closeCursor(cursor);
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        closeCursor(cursor);
                        throw th;
                    }
                }
                closeCursor(cursorQuery);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return arrayList;
    }

    public synchronized ArrayList<String> getAllDisplayedMarketingList() {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mDb.query(DBContract.Tables.MARKETING, new String[]{"mid"}, "mdt>=?", new String[]{String.valueOf(0)}, null, null, null);
                while (cursorQuery.moveToNext()) {
                    arrayList.add(cursorQuery.getString(0));
                }
            } catch (Exception e) {
                SmpLog.m6494e(TAG, "db error. " + e.toString());
            }
        } finally {
            closeCursor(cursorQuery);
        }
        return arrayList;
    }

    public synchronized Map<String, JSONArray> getAllFeedbacksToSend() {
        HashMap map;
        map = new HashMap();
        try {
            try {
                Cursor cursorRawQuery = this.mDb.rawQuery("SELECT mid,feedbacks FROM feedback WHERE state= ? AND lts> ? AND feedbacks!= ?", new String[]{DB_FEEDBACK_STATUS_WAIT, String.valueOf(System.currentTimeMillis() - Constants.FEEDBACK_RETRY_DEADLINE_MILLIS), XMPConst.ARRAY_ITEM_NAME});
                if (cursorRawQuery != null) {
                    while (cursorRawQuery.moveToNext()) {
                        String string = cursorRawQuery.getString(0);
                        String string2 = cursorRawQuery.getString(1);
                        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                            map.put(string, new JSONArray(string2));
                        }
                    }
                } else {
                    SmpLog.m6492d(TAG, "error: cursor is null.");
                }
                closeCursor(cursorRawQuery);
            } catch (Exception e) {
                SmpLog.m6494e(TAG, "error while handling feedback. " + e.toString());
                closeCursor(null);
                return map;
            }
        } catch (Throwable th) {
            closeCursor(null);
            throw th;
        }
        return map;
    }

    public synchronized ArrayList<String> getAllIncompletedMarketingList(String str) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mDb.query(DBContract.Tables.MARKETING, new String[]{"mid"}, "(state=? OR state=? OR state=?) AND msgtype=?", new String[]{MarketingState.INCOMP_RESOURCE.name(), MarketingState.INCOMP_GET_STATUS_API.name(), MarketingState.INCOMP_DISPLAY.name(), str}, null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    arrayList.add(cursorQuery.getString(0));
                }
            } catch (Exception e) {
                SmpLog.m6494e(TAG, "db error. " + e);
            }
            closeCursor(cursorQuery);
        } catch (Throwable th) {
            closeCursor(cursorQuery);
            throw th;
        }
        return arrayList;
    }

    public synchronized ArrayList<String> getAllMarketingList() {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mDb.query(DBContract.Tables.MARKETING, new String[]{"mid"}, null, null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    arrayList.add(cursorQuery.getString(0));
                }
            } catch (Exception e) {
                SmpLog.m6494e(TAG, "db error. " + e.toString());
            }
        } finally {
            closeCursor(cursorQuery);
        }
        return arrayList;
    }

    public synchronized Map<String, MarketingState> getAllMarketingStates() {
        HashMap map;
        map = new HashMap();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mDb.query(DBContract.Tables.MARKETING, new String[]{"mid", "state"}, null, null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    if (string != null && string2 != null) {
                        map.put(string, MarketingState.fromString(string2));
                    }
                }
            } catch (Exception e) {
                SmpLog.m6494e(TAG, e.toString());
            }
        } finally {
            closeCursor(cursorQuery);
        }
        return map;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized String getAppFilter(String str) {
        try {
            return getStringValueFromDb("appfilter", "value", "key=?", str, "value", "get app filter error.");
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized Set<String> getAppFilterKeySet() {
        HashSet hashSet;
        hashSet = new HashSet();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mDb.query("appfilter", new String[]{"key"}, "value is not null and value != ?", new String[]{""}, null, null, null);
                while (cursorQuery.moveToNext()) {
                    hashSet.add(cursorQuery.getString(cursorQuery.getColumnIndex("key")));
                }
            } catch (Exception e) {
                SmpLog.m6494e(TAG, "get app filter keySet error. " + e.toString());
            }
        } finally {
            closeCursor(cursorQuery);
        }
        return hashSet;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized String getAppReferrer(String str) {
        try {
            return getStringValueFromDb(DBContract.Tables.APP_REFERRER, "value", "key=?", str, "value", "get app referrer error.");
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized JSONArray getAppReferrerKeyData() {
        JSONArray jSONArray;
        jSONArray = new JSONArray();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mDb.query(DBContract.Tables.APP_REFERRER, new String[]{"key", "value"}, "value is not null and value != ?", new String[]{""}, null, null, null);
                while (cursorQuery.moveToNext()) {
                    jSONArray.put(cursorQuery.getString(cursorQuery.getColumnIndex("key")));
                }
            } catch (Exception e) {
                SmpLog.m6494e(TAG, "get app referrer key error. " + e.toString());
            }
        } finally {
            closeCursor(cursorQuery);
        }
        return jSONArray;
    }

    public synchronized Set<String> getAppReferrerKeySet() {
        HashSet hashSet;
        hashSet = new HashSet();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mDb.query(DBContract.Tables.APP_REFERRER, new String[]{"key"}, "value is not null and value != ?", new String[]{""}, null, null, null);
                while (cursorQuery.moveToNext()) {
                    hashSet.add(cursorQuery.getString(cursorQuery.getColumnIndex("key")));
                }
            } catch (Exception e) {
                SmpLog.m6494e(TAG, "get app referrer keySet error. " + e.toString());
            }
        } finally {
            closeCursor(cursorQuery);
        }
        return hashSet;
    }

    public synchronized JSONArray getAppStartData() {
        JSONArray jSONArray;
        jSONArray = new JSONArray();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mDb.query("start", new String[]{"start"}, null, null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    jSONArray.put(new JSONObject(cursorQuery.getString(0)));
                }
            } catch (Exception e) {
                SmpLog.m6494e(TAG, "error while handling app start. " + e.toString());
            }
        } finally {
            closeCursor(cursorQuery);
        }
        return jSONArray;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized String getDebugAction(String str) {
        try {
            return getStringValueFromDbWithMid("feedback", DBContract.FeedbackColumns.DEBUG_ACTION, "mid", str, "get debug action error.");
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized long getExpectedDisplayTime(String str) {
        try {
            return getLongValueFromDbWithMid(DBContract.Tables.MARKETING, DBContract.MarketingColumns.EXPECTED_DISPLAY_TIME, "mid", str, "");
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int getExternalFeedbackFailCount(String str) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mDb.query(DBContract.Tables.EXTERNAL_FEEDBACK, new String[]{"fail"}, "path=?", new String[]{str}, null, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    int i = cursorQuery.getInt(0);
                    closeCursor(cursorQuery);
                    return i;
                }
            } catch (Exception e) {
                SmpLog.m6494e(TAG, "error while handling external feedback." + e.toString());
            }
            closeCursor(cursorQuery);
            return -1;
        } catch (Throwable th) {
            closeCursor(cursorQuery);
            throw th;
        }
    }

    public synchronized ArrayList<ExternalFeedbackUrlDataEntity> getExternalFeedbackList() {
        ArrayList<ExternalFeedbackUrlDataEntity> arrayList;
        arrayList = new ArrayList<>();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mDb.query(DBContract.Tables.EXTERNAL_FEEDBACK, null, null, null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    arrayList.add(new ExternalFeedbackUrlDataEntity(cursorQuery.getString(cursorQuery.getColumnIndex("path")), cursorQuery.getInt(cursorQuery.getColumnIndex("fail")), cursorQuery.getLong(cursorQuery.getColumnIndex("timestamp"))));
                }
            } catch (Exception e) {
                SmpLog.m6494e(TAG, "get external feedback error. " + e.toString());
            }
        } finally {
            closeCursor(cursorQuery);
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized JSONArray getFeedbackData(String str) {
        try {
            try {
                return new JSONArray(getStringValueFromDbWithMid("feedback", DBContract.FeedbackColumns.FEEDBACKS, "mid", str, "error while handling feedback."));
            } catch (Exception e) {
                SmpLog.m6495e(TAG, str, "error while handling feedback. " + e.toString());
                return new JSONArray();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized String getFeedbackState(String str) {
        try {
            return getStringValueFromDbWithMid("feedback", "state", "mid", str, "error while handling feedback.");
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized FeedbackEvent getLastFbid(String str) {
        try {
            int intValueFromDbWithMid = getIntValueFromDbWithMid("feedback", DBContract.FeedbackColumns.LAST_FBID, "mid", str, "error while handling feedback.");
            return intValueFromDbWithMid == -1 ? null : FeedbackEvent.fromInt(intValueFromDbWithMid);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized long getLastFeedbackTime(String str) {
        try {
            return getLongValueFromDbWithMid("feedback", DBContract.FeedbackColumns.LAST_TIMESTAMP, "mid", str, "error while handling feedback.");
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized int getMarketingDisplayId(String str) {
        try {
            int intValueFromDbWithMid = getIntValueFromDbWithMid(DBContract.Tables.MARKETING, "_id", "mid", str, "");
            if (intValueFromDbWithMid == -1) {
                return -1;
            }
            return modDisplayId(intValueFromDbWithMid);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized int getMarketingFailCount(String str) {
        try {
            return getIntValueFromDbWithMid(DBContract.Tables.MARKETING, "fail", "mid", str, "");
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.samsung.android.sdk.smp.common.database.DBHandler] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    public synchronized ArrayList<String> getMarketingList(MarketingState marketingState) {
        ArrayList<String> arrayList;
        Cursor cursorQuery;
        ?? r12 = 0;
        if (marketingState == null) {
            SmpLog.m6494e(TAG, "fail to get marketing list. state null");
            return null;
        }
        try {
            arrayList = new ArrayList<>();
        } catch (Throwable th) {
            th = th;
            r12 = marketingState;
        }
        try {
            cursorQuery = this.mDb.query(DBContract.Tables.MARKETING, new String[]{"mid"}, "state=?", new String[]{marketingState.name()}, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(cursorQuery.getString(0));
                } catch (Exception e) {
                    e = e;
                    SmpLog.m6494e(TAG, "fail to get marketing list. " + e.toString());
                    closeCursor(cursorQuery);
                    return null;
                }
            }
            closeCursor(cursorQuery);
            return arrayList;
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            closeCursor(r12);
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized String getMarketingMsgType(String str) {
        try {
            return getStringValueFromDbWithMid(DBContract.Tables.MARKETING, DBContract.MarketingColumns.MSG_TYPE, "mid", str, "");
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized long getMarketingReceivedTime(String str) {
        try {
            return getLongValueFromDbWithMid(DBContract.Tables.MARKETING, DBContract.MarketingColumns.RECEIVED_TIME, "mid", str, "");
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized MarketingState getMarketingState(String str) {
        try {
            String stringValueFromDbWithMid = getStringValueFromDbWithMid(DBContract.Tables.MARKETING, "state", "mid", str, "");
            return TextUtils.isEmpty(stringValueFromDbWithMid) ? null : MarketingState.fromString(stringValueFromDbWithMid);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized String getMarketingUserdata(String str) {
        try {
            return getStringValueFromDbWithMid(DBContract.Tables.MARKETING, "data", "mid", str, "");
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized JSONArray getSessionData() {
        JSONArray jSONArray;
        jSONArray = new JSONArray();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mDb.query("session", new String[]{"session"}, null, null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    try {
                        jSONArray = JSONUtil.combineJSONArrays(jSONArray, new JSONArray(cursorQuery.getString(0)));
                    } catch (Exception unused) {
                    }
                }
            } finally {
                closeCursor(cursorQuery);
            }
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling session. " + e.toString());
        }
        return jSONArray;
    }

    public synchronized void incrementAckFailCount() {
        final ArrayList<AckDataEntity> ackList = getAckList();
        performTransactionWithinLoop(new TransactionWithinLoop() { // from class: com.samsung.android.sdk.smp.common.database.DBHandler.2
            @Override // com.samsung.android.sdk.smp.common.database.DBHandler.TransactionWithinLoop
            public void execute() {
                for (AckDataEntity ackDataEntity : ackList) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("fail", Long.valueOf(ackDataEntity.getFailCount() + 1));
                    DBHandler.this.mDb.update("ack", contentValues, "rid=?", new String[]{ackDataEntity.getRequestId()});
                }
            }
        }, "incrementAckFailCount. ");
    }

    public synchronized void incrementAppStartFailCount() {
        try {
            this.mDb.execSQL("UPDATE start SET fail=fail+1");
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling app start. " + e.toString());
        }
    }

    public synchronized void incrementSessionFailCount() {
        try {
            this.mDb.execSQL("UPDATE session SET fail=fail+1");
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling session. " + e.toString());
        }
    }

    public synchronized int insertMarketingData(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mid", str);
            contentValues.put(DBContract.MarketingColumns.MSG_TYPE, str3);
            contentValues.put("data", str2);
            contentValues.put("state", MarketingState.INCOMP_RESOURCE.name());
            contentValues.put("fail", (Integer) 0);
            contentValues.put(DBContract.MarketingColumns.RECEIVED_TIME, Long.valueOf(System.currentTimeMillis()));
            try {
                if (this.mDb.insert(DBContract.Tables.MARKETING, null, contentValues) == -1) {
                    SmpLog.m6495e(TAG, str, "db error. fail to insert marketing");
                    return -1;
                }
                return getMarketingDisplayId(str);
            } catch (Exception e) {
                SmpLog.m6495e(TAG, str, "db error. " + e.toString());
            }
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized boolean isAppUpdateFeedbackAdded(String str) {
        try {
            return getBooleanValueFromDbWithMid("feedback", DBContract.FeedbackColumns.IS_APP_UPDATE_FEEDBACK_ADDED, "mid", str, "");
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized boolean isMarketingExist(String str) {
        try {
            return hasValueFromDbWithMid(DBContract.Tables.MARKETING, "_id", "mid", str, "");
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized boolean isMarketingLandingRedirected(String str) {
        try {
            return getBooleanValueFromDbWithMid(DBContract.Tables.MARKETING, DBContract.MarketingColumns.IS_LANDING_REDIRECTED, "mid", str, "");
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized boolean isRebootFeedbackAdded(String str) {
        try {
            return getBooleanValueFromDbWithMid("feedback", DBContract.FeedbackColumns.IS_REBOOT_FEEDBACK_ADDED, "mid", str, "");
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean setAppFilter(String str, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            contentValues.put("value", str2);
            this.mDb.insertWithOnConflict("appfilter", null, contentValues, 5);
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "set app filter error. " + e.toString());
            return false;
        }
        return true;
    }

    public synchronized boolean setAppReferrer(String str, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            contentValues.put("value", str2);
            this.mDb.insertWithOnConflict(DBContract.Tables.APP_REFERRER, null, contentValues, 5);
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "set app referrer error. " + e.toString());
            return false;
        }
        return true;
    }

    public synchronized void updateDebugAction(String str, String str2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DBContract.FeedbackColumns.DEBUG_ACTION, str2);
            this.mDb.update("feedback", contentValues, "mid = ?", new String[]{str});
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling debug action. " + e.toString());
        }
    }

    public synchronized boolean updateExternalFeedbackFailCount(String str, int i) {
        ContentValues contentValues;
        try {
            contentValues = new ContentValues();
            contentValues.put("fail", Integer.valueOf(i));
        } catch (Exception e) {
            SmpLog.m6494e(TAG, "error while handling external feedback. " + e.toString());
            return false;
        }
        return this.mDb.update(DBContract.Tables.EXTERNAL_FEEDBACK, contentValues, "path = ?", new String[]{str}) != 0;
    }

    public synchronized boolean updateMarketingClickedTime(String str, long j) {
        return updateMarketingDbValueWithMid(DBContract.MarketingColumns.CLICKED_TIME, Long.valueOf(j), str, "");
    }

    public synchronized boolean updateMarketingDisplayedTime(String str, long j) {
        return updateMarketingDbValueWithMid(DBContract.MarketingColumns.DISPLAYED_TIME, Long.valueOf(j), str, "");
    }

    public synchronized boolean updateMarketingExpectedDisplayTime(String str, long j) {
        return updateMarketingDbValueWithMid(DBContract.MarketingColumns.EXPECTED_DISPLAY_TIME, Long.valueOf(j), str, "");
    }

    public synchronized boolean updateMarketingFailCount(String str, int i) {
        return updateMarketingDbValueWithMid("fail", Integer.valueOf(i), str, "");
    }

    public synchronized boolean updateMarketingLandingRedirected(String str, Boolean bool) {
        return updateMarketingDbValueWithMid(DBContract.MarketingColumns.IS_LANDING_REDIRECTED, bool, str, "");
    }

    public synchronized boolean updateMarketingReceivedTime(String str, long j) {
        return updateMarketingDbValueWithMid(DBContract.MarketingColumns.RECEIVED_TIME, Long.valueOf(j), str, "");
    }

    public synchronized boolean updateMarketingState(String str, MarketingState marketingState) {
        SmpLog.m6499i(TAG, str, "state - " + marketingState);
        if (marketingState == null) {
            return false;
        }
        return updateMarketingDbValueWithMid("state", marketingState.name(), str, "");
    }

    public synchronized boolean updateMarketingUserData(String str, String str2) {
        return updateMarketingDbValueWithMid("data", str2, str, "");
    }

    public synchronized Map<String, String> getAppFilter() {
        TreeMap treeMap;
        treeMap = new TreeMap();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mDb.query("appfilter", new String[]{"key", "value"}, "value is not null and value != ?", new String[]{""}, null, null, null);
                while (cursorQuery.moveToNext()) {
                    treeMap.put(cursorQuery.getString(cursorQuery.getColumnIndex("key")), cursorQuery.getString(cursorQuery.getColumnIndex("value")));
                }
            } catch (Exception e) {
                SmpLog.m6494e(TAG, "get app filter error. " + e.toString());
            }
        } finally {
            closeCursor(cursorQuery);
        }
        return treeMap;
    }
}
