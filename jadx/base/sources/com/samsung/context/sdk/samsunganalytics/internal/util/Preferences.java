package com.samsung.context.sdk.samsunganalytics.internal.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Preferences {
    public static final String APP_PREF_NAMES = "AppPrefs";
    public static final String PREFS_KEY_APP_VERSION = "appVersion";
    public static final String PREFS_KEY_APP_VERSION_FOR_INIT = "appVersionForInit";
    public static final String PREFS_KEY_APP_VERSION_FOR_SETTING = "appVersionForSetting";
    public static final String PREFS_KEY_DELETE_COUNT = "deleteCount";
    public static final String PREFS_KEY_DELETE_COUNT_RESET_TIME = "deleteCountResetTime";
    public static final String PREFS_KEY_DID = "deviceId";
    public static final String PREFS_KEY_DID_TYPE = "auidType";
    public static final String PREFS_KEY_ENABLE_DEVICE = "enable_device";
    public static final String PREFS_KEY_SEND_COMMON_SUCCESS = "sendCommonSuccess";
    public static final String PREFS_KEY_SEND_COMMON_TIME = "sendCommonTime";
    public static final String PROPERTY_DATA = "property_data";
    private static final String PROPERTY_PREFS_NAME = "SAProperties";
    public static final String PROPERTY_SENT_DATE = "property_sent_date";
    private static final String SHARED_PREFS_NAME = "SamsungAnalyticsPrefs";
    public static final String STATUS_SENT_DATE = "status_sent_date";
    private static final String TERMS_PREF_NAME = "SATerms";

    private static String getPreferenceName(String str) {
        if (Build.VERSION.SDK_INT < 28) {
            return str;
        }
        String[] strArrSplit = Application.getProcessName().split(":", 2);
        if (strArrSplit.length != 2) {
            return str;
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(str, "_");
        sbM781w.append(strArrSplit[1]);
        return sbM781w.toString();
    }

    public static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(getPreferenceName(SHARED_PREFS_NAME), 0);
    }

    public static SharedPreferences getPropertyPreferences(Context context) {
        return context.getSharedPreferences(getPreferenceName(PROPERTY_PREFS_NAME), 0);
    }

    public static SharedPreferences getTermsPreferences(Context context) {
        return context.getSharedPreferences(getPreferenceName(TERMS_PREF_NAME), 0);
    }
}
