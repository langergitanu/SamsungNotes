package com.samsung.context.sdk.samsunganalytics;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Trace;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.samsung.context.sdk.samsunganalytics.internal.Tracker;
import com.samsung.context.sdk.samsunganalytics.internal.policy.Validation;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import com.samsung.context.sdk.samsunganalytics.internal.util.Utils;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SamsungAnalytics {
    public static final String SDK_VERSION = "6.05.079";
    private static SamsungAnalytics instance;
    private Tracker tracker;

    private SamsungAnalytics(Application application, Configuration configuration) {
        this.tracker = null;
        if (Validation.isValid(application, configuration)) {
            this.tracker = new Tracker(application, configuration);
        }
    }

    private static void buildInstance(Application application, Configuration configuration) {
        synchronized (SamsungAnalytics.class) {
            try {
                if (isTcTypeChanged(application, configuration)) {
                    instance.tracker.disable();
                    instance = null;
                }
                if (isInstanceNull()) {
                    instance = new SamsungAnalytics(application, configuration);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Configuration getConfiguration() {
        if (isInstanceNull()) {
            return null;
        }
        return instance.tracker.getConfiguration();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v6 */
    private String getDeviceId(Context context) throws Throwable {
        ?? r5;
        Cursor cursorQuery;
        try {
            if (Build.VERSION.SDK_INT >= 29 && this.tracker.getConfiguration().isEnableAutoDeviceId() && !this.tracker.getConfiguration().isEnableUseInAppLogging()) {
                try {
                } catch (Throwable th) {
                    th = th;
                    r5 = context;
                }
                try {
                    cursorQuery = context.getContentResolver().query(Uri.parse("content://com.sec.android.log.diagmonagent.sa/deviceid"), null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToNext()) {
                                String string = cursorQuery.getString(0);
                                cursorQuery.close();
                                return string;
                            }
                        } catch (Exception e) {
                            e = e;
                            Debug.logwingW("failed to get deviceId from DMA : " + e.getMessage());
                            if (cursorQuery != null) {
                            }
                            return this.tracker.getConfiguration().getDeviceId();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursorQuery = null;
                } catch (Throwable th2) {
                    th = th2;
                    r5 = 0;
                    if (r5 != 0) {
                        r5.close();
                    }
                    throw th;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
            return this.tracker.getConfiguration().getDeviceId();
        } catch (NullPointerException e3) {
            Debug.LogException(getClass(), e3);
            return null;
        }
    }

    public static SamsungAnalytics getInstance() {
        if (instance == null) {
            Utils.throwException("call after setConfiguration() method");
            if (!Utils.isDev()) {
                synchronized (SamsungAnalytics.class) {
                    try {
                        if (instance == null) {
                            instance = new SamsungAnalytics(null, null);
                        }
                    } finally {
                    }
                }
            }
        }
        return instance;
    }

    private static boolean isInstanceNull() {
        SamsungAnalytics samsungAnalytics = instance;
        return samsungAnalytics == null || samsungAnalytics.tracker == null;
    }

    private static boolean isTcTypeChanged(Application application, Configuration configuration) {
        if (isInstanceNull()) {
            return false;
        }
        return Utils.isTcTypeChanged(application.getApplicationContext(), instance.tracker.getConfiguration(), configuration);
    }

    public static void setConfiguration(Application application, Configuration configuration) {
        Trace.beginSection("SamsungAnalytics setConfiguration");
        buildInstance(application, configuration);
        Trace.endSection();
    }

    public void deleteLogData() {
        try {
            this.tracker.deleteLogData();
        } catch (NullPointerException e) {
            Debug.LogException(getClass(), e);
        }
    }

    public void deleteSensitiveLogData() {
        try {
            this.tracker.deleteSensitiveLogData();
        } catch (NullPointerException e) {
            Debug.LogException(getClass(), e);
        }
    }

    public SamsungAnalytics enableAutoActivityTracking() {
        try {
            this.tracker.enableAutoActivityTracking();
            return this;
        } catch (NullPointerException e) {
            Debug.LogException(getClass(), e);
            return this;
        }
    }

    public void registerSettingPref(Map<String, Set<String>> map) {
        try {
            this.tracker.registerSettingPref(map);
        } catch (NullPointerException e) {
            Debug.LogException(getClass(), e);
        }
    }

    public int sendLog(Map<String, String> map) {
        Debug.LogD("sendLog");
        try {
            return this.tracker.sendLog(map);
        } catch (NullPointerException unused) {
            return -100;
        }
    }

    public void useWebAppLogging(Context context, WebView webView, String[] strArr) throws Throwable {
        if (context == null) {
            Utils.throwException("useWebAppLogging: context is null");
            return;
        }
        if (strArr == null) {
            Utils.throwException("useWebAppLogging: domain is null");
            return;
        }
        Tracker tracker = this.tracker;
        if (tracker == null || tracker.getConfiguration() == null) {
            Utils.throwException("useWebAppLogging: call after setConfiguration() method");
            return;
        }
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setAcceptThirdPartyCookies(webView, true);
        webView.getSettings().setJavaScriptEnabled(true);
        int auidType = TextUtils.isEmpty(this.tracker.getConfiguration().getDeviceId()) ? 4 : this.tracker.getConfiguration().getAuidType();
        String deviceId = getDeviceId(context);
        String packageName = context.getPackageName();
        String str = Build.MODEL;
        String strValueOf = String.valueOf(this.tracker.getConfiguration().getUserAgreement().isAgreement());
        if (TextUtils.isEmpty(deviceId)) {
            Debug.LogE("useWebAppLogging: device id is null");
            return;
        }
        for (String str2 : strArr) {
            cookieManager.setCookie(str2, "_sa_auid=" + deviceId);
            cookieManager.setCookie(str2, "_sa_apn=" + packageName);
            cookieManager.setCookie(str2, "_sa_at=" + auidType);
            cookieManager.setCookie(str2, "_sa_dm=" + str);
            cookieManager.setCookie(str2, "_sa_agree=" + strValueOf);
        }
    }
}
