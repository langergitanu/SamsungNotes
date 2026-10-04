package com.samsung.android.sdk.smp.data;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.database.DBHandler;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.push.PushHelper;
import com.samsung.android.sdk.smp.task.STask;
import com.samsung.android.sdk.smp.task.STaskDispatcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class UsageManager {
    private static final String TAG = "UsageManager";
    private static UsageManager sUsageManager;
    private long mAppStartElapsedTime;
    private long mAppStartTime;
    private boolean mIsAppUsageEnabled;
    private boolean mIsTrackingEnabled;
    private int mSavedSessionHashCode;
    private boolean mScreenOrientationChanged;
    private JSONArray mSessions = new JSONArray();
    private final SparseArray<Long> mSessionStartTimes = new SparseArray<>();
    private final SparseArray<Long> mSessionStartElapsedTime = new SparseArray<>();
    private int mActivityCount = 0;

    private UsageManager(Context context) {
        this.mIsAppUsageEnabled = !DeviceInfoUtil.isOnlySupportGeneralPush(context);
    }

    public static void clearAppUsage(Context context) {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen != null) {
            dBHandlerOpen.deleteAllAppStartData();
            dBHandlerOpen.deleteAllSessionData();
            dBHandlerOpen.close();
        }
    }

    private synchronized void decreaseActivityCount() {
        this.mActivityCount--;
    }

    public static synchronized UsageManager getInstance(Context context) {
        try {
            if (sUsageManager == null) {
                sUsageManager = new UsageManager(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return sUsageManager;
    }

    public static void handleUploadFail(Context context) {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen != null) {
            dBHandlerOpen.incrementAppStartFailCount();
            dBHandlerOpen.deleteOverRetryAppStart(3);
            dBHandlerOpen.incrementSessionFailCount();
            dBHandlerOpen.deleteOverRetrySession(3);
            dBHandlerOpen.close();
        }
    }

    private synchronized void increaseActivityCount() {
        this.mActivityCount++;
    }

    public static void saveAppUsage(Context context, Bundle bundle) {
        long j = bundle.getLong(Constants.EXTRA_KEY_APP_START_TIME);
        long j2 = bundle.getLong(Constants.EXTRA_KEY_APP_DURATION);
        String string = bundle.getString(Constants.EXTRA_KEY_SESSIONS);
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            return;
        }
        if (j > 0 && j2 > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dts", j);
                jSONObject.put("dur", j2);
                dBHandlerOpen.addAppStartData(jSONObject);
            } catch (JSONException e) {
                SmpLog.m6494e(TAG, e.toString());
            }
            dBHandlerOpen.deleteOldestAppStartData();
        }
        if (!TextUtils.isEmpty(string)) {
            dBHandlerOpen.addSessionData(string, bundle.getInt(Constants.EXTRA_KEY_SESSION_COUNT, 25));
            dBHandlerOpen.deleteOldestSessionData();
        }
        dBHandlerOpen.close();
    }

    private void triggerUploadClientsWhenAppStarts(Context context) {
        if (System.currentTimeMillis() < DataManager.getAvailableUploadPeriod(context) || !PushHelper.isPushRegComplete(context)) {
            return;
        }
        SmpLog.m6498i(TAG, "upload clients when app starts");
        DataManager.triggerUploadClientsNow(context, true);
    }

    public void activityCreated(Activity activity) {
    }

    public void activityStarted(Activity activity) {
        if (this.mIsAppUsageEnabled) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.mScreenOrientationChanged) {
                return;
            }
            increaseActivityCount();
            if (getActivityCount() == 1) {
                Context applicationContext = activity.getApplicationContext();
                PrefManager prefManager = PrefManager.getInstance(applicationContext);
                this.mAppStartTime = jCurrentTimeMillis;
                this.mAppStartElapsedTime = jElapsedRealtime;
                this.mSessions = new JSONArray();
                this.mIsTrackingEnabled = prefManager.getActivityTrackingEnabled();
                prefManager.setUploadFailCount(0);
                triggerUploadClientsWhenAppStarts(applicationContext);
            }
            if (this.mIsTrackingEnabled) {
                this.mSessionStartTimes.put(activity.hashCode(), Long.valueOf(jCurrentTimeMillis));
                this.mSessionStartElapsedTime.put(activity.hashCode(), Long.valueOf(jElapsedRealtime));
            }
        }
    }

    public void activityStopped(Activity activity) {
        if (this.mIsAppUsageEnabled) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Context applicationContext = activity.getApplicationContext();
            boolean zIsChangingConfigurations = activity.isChangingConfigurations();
            this.mScreenOrientationChanged = zIsChangingConfigurations;
            if (zIsChangingConfigurations) {
                if (this.mSavedSessionHashCode == 0) {
                    this.mSavedSessionHashCode = activity.hashCode();
                    return;
                }
                return;
            }
            if (this.mIsTrackingEnabled) {
                try {
                    int iHashCode = activity.hashCode();
                    Long l = this.mSessionStartTimes.get(iHashCode) != null ? this.mSessionStartTimes.get(iHashCode) : this.mSessionStartTimes.get(this.mSavedSessionHashCode);
                    Long l2 = this.mSessionStartElapsedTime.get(iHashCode) != null ? this.mSessionStartElapsedTime.get(iHashCode) : this.mSessionStartElapsedTime.get(this.mSavedSessionHashCode);
                    if (l2 != null && l != null && l.longValue() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("dts", l);
                        jSONObject.put("dur", jElapsedRealtime - l2.longValue());
                        jSONObject.put("id", activity.getClass().getSimpleName());
                        this.mSessions.put(jSONObject);
                        if (this.mSessions.length() >= 25) {
                            Bundle bundle = new Bundle();
                            bundle.putString(Constants.EXTRA_KEY_SESSIONS, this.mSessions.toString());
                            bundle.putInt(Constants.EXTRA_KEY_SESSION_COUNT, this.mSessions.length());
                            STaskDispatcher.dispatchOnService(applicationContext, new STask(STask.CommonAction.SAVE_APP_USAGE, bundle));
                            this.mSessions = new JSONArray();
                        }
                    }
                    this.mSessionStartTimes.remove(iHashCode);
                    this.mSessionStartElapsedTime.remove(iHashCode);
                } catch (Exception e) {
                    AbstractC6670b.m4737B(e, new StringBuilder("error while handling session. "), TAG);
                }
                this.mSavedSessionHashCode = 0;
            }
            decreaseActivityCount();
            if (getActivityCount() > 0) {
                return;
            }
            if (PushHelper.isPushRegComplete(applicationContext)) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong(Constants.EXTRA_KEY_APP_START_TIME, this.mAppStartTime);
                bundle2.putLong(Constants.EXTRA_KEY_APP_DURATION, jElapsedRealtime - this.mAppStartElapsedTime);
                if (this.mIsTrackingEnabled && this.mSessions.length() > 0) {
                    bundle2.putString(Constants.EXTRA_KEY_SESSIONS, this.mSessions.toString());
                    bundle2.putInt(Constants.EXTRA_KEY_SESSION_COUNT, this.mSessions.length());
                }
                STaskDispatcher.dispatchOnService(applicationContext, new STask(STask.CommonAction.SAVE_APP_USAGE, bundle2));
            }
            this.mSessions = new JSONArray();
            this.mSessionStartTimes.clear();
            this.mSessionStartElapsedTime.clear();
            this.mAppStartTime = 0L;
            this.mAppStartElapsedTime = 0L;
        }
    }

    public synchronized int getActivityCount() {
        return this.mActivityCount;
    }
}
