package com.sec.android.diagmonagent.common.logger;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class AppLog {
    private static String SERVICE_ID_TAG = "";
    private static final String TAG = "DIAGMON_SDK";
    private static IAppLogData sInstance;

    /* JADX INFO: renamed from: d */
    public static int m13140d(String str) {
        IAppLogData iAppLogData = sInstance;
        return iAppLogData == null ? Log.d(TAG, str) : iAppLogData.mo13145d(SERVICE_ID_TAG, str);
    }

    /* JADX INFO: renamed from: e */
    public static int m13141e(String str) {
        IAppLogData iAppLogData = sInstance;
        return iAppLogData == null ? Log.e(TAG, str) : iAppLogData.mo13146e(SERVICE_ID_TAG, str);
    }

    /* JADX INFO: renamed from: i */
    public static int m13142i(String str) {
        IAppLogData iAppLogData = sInstance;
        return iAppLogData == null ? Log.i(TAG, str) : iAppLogData.mo13147i(SERVICE_ID_TAG, str);
    }

    public static void initLogger(Context context, String str) {
        try {
            if (sInstance != null || context == null || TextUtils.isEmpty(str)) {
                return;
            }
            SERVICE_ID_TAG = str;
            sInstance = new AppLogData();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    /* JADX INFO: renamed from: v */
    public static int m13143v(String str) {
        IAppLogData iAppLogData = sInstance;
        return iAppLogData == null ? Log.v(TAG, str) : iAppLogData.mo13148v(SERVICE_ID_TAG, str);
    }

    /* JADX INFO: renamed from: w */
    public static int m13144w(String str) {
        IAppLogData iAppLogData = sInstance;
        return iAppLogData == null ? Log.w(TAG, str) : iAppLogData.mo13149w(SERVICE_ID_TAG, str);
    }
}
