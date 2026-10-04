package com.samsung.context.sdk.samsunganalytics.internal.policy;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.samsung.context.sdk.samsunganalytics.Configuration;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import com.samsung.context.sdk.samsunganalytics.internal.util.Preferences;
import com.samsung.context.sdk.samsunganalytics.internal.util.Utils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Validation {
    private static final int MIN_SDK = 23;

    public static String checkSizeLimit(String str, int i) {
        if (str == null || str.length() <= i) {
            return str;
        }
        Debug.LogENG("length over, target: " + str + ", limit: " + i);
        return str.substring(0, i);
    }

    public static boolean isLoggingEnableDevice(Context context) {
        boolean zBooleanValue;
        SharedPreferences preferences = Preferences.getPreferences(context);
        int i = preferences.getInt(Preferences.PREFS_KEY_ENABLE_DEVICE, 0);
        if (i != 0) {
            return i == 1;
        }
        try {
            Class<?> cls = Class.forName("com.samsung.android.feature.SemFloatingFeature");
            zBooleanValue = ((Boolean) cls.getMethod("getBoolean", String.class).invoke(cls.getMethod("getInstance", null).invoke(null, null), "SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE")).booleanValue();
        } catch (Exception e) {
            try {
            } catch (Exception unused) {
                Debug.LogD("DMA is not supported");
                Debug.LogException(Validation.class, e);
            }
            if (Build.VERSION.SDK_INT < 29) {
                Debug.LogD("Floating feature is not supported (non-samsung device)");
                Debug.LogException(Validation.class, e);
                return false;
            }
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.sec.android.log.diagmonagent.sa/check/diagnostic"), null, null, null);
            if (cursorQuery != null) {
                cursorQuery.moveToNext();
                z = 1 == cursorQuery.getInt(0);
                cursorQuery.close();
            }
            zBooleanValue = z;
        }
        if (zBooleanValue) {
            Debug.LogD("cf feature is supported");
            preferences.edit().putInt(Preferences.PREFS_KEY_ENABLE_DEVICE, 1).apply();
        } else {
            Debug.LogD("feature is not supported");
            preferences.edit().putInt(Preferences.PREFS_KEY_ENABLE_DEVICE, 2).apply();
        }
        return zBooleanValue;
    }

    public static boolean isValid(Application application, Configuration configuration) {
        if (application == null) {
            Utils.throwException("context cannot be null");
            return false;
        }
        if (configuration == null) {
            Utils.throwException("Configuration cannot be null");
            return false;
        }
        if (TextUtils.isEmpty(configuration.getTrackingId())) {
            Utils.throwException("TrackingId is empty, set TrackingId");
            return false;
        }
        if (TextUtils.isEmpty(configuration.getDeviceId()) && !configuration.isEnableAutoDeviceId()) {
            Utils.throwException("Device Id is empty, set Device Id or enable auto device id");
            return false;
        }
        if (configuration.isEnableUseInAppLogging()) {
            if (configuration.getUserAgreement() == null) {
                Utils.throwException("If you want to use In App Logging, you should implement UserAgreement interface");
                return false;
            }
        } else if (!TextUtils.isEmpty(configuration.getDeviceId())) {
            Utils.throwException("This mode is not allowed to set device Id");
            return false;
        }
        if (!TextUtils.isEmpty(configuration.getVersion())) {
            return true;
        }
        Utils.throwException("you should set the UI version");
        return false;
    }

    public static Map<String, String> checkSizeLimit(Map<String, String> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (TextUtils.isEmpty(key)) {
                Debug.LogENG("key is empty");
            } else {
                map2.put(checkSizeLimit(key, 100), checkSizeLimit(value, 1024));
            }
        }
        return map2;
    }
}
