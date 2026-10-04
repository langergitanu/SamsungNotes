package com.samsung.android.sdk.handwriting;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.core.p139ai.sdkcommon.ExtensionConst;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class GSIMLogger {
    private static final int FEATURE_TYPE_FLOATING_FEATURE = 1;
    private static final int FEATURE_TYPE_SEM_FLOATING_FEATURE = 2;
    private static final int FW_TYPE_CONTEXT_FRAMEWORK = 1;
    private static final int FW_TYPE_DEVICE_MANAGEMENT_AGENT = 2;
    private static final String TAG = "GSIMLogger";
    private static final String TRACKING_ID = "4E8-399-5210055";
    private static GSIMLogger mGSiMLogger;
    private String mAppTag;
    private Context mContext;
    private boolean mIsLoggingAvailable;
    private String mAppId = getClass().getPackage().getName();
    private int mFloatingFeature = 0;
    private int mLoggingFW = 0;

    private GSIMLogger(Context context) {
        this.mIsLoggingAvailable = false;
        this.mContext = context;
        if (checkFloatingFeature()) {
            String str = TAG;
            AbstractC0000a.m26w(new StringBuilder("Floating Feature : "), str, this.mFloatingFeature);
            if (checkLoggingFramework(context)) {
                AbstractC0000a.m26w(new StringBuilder(" Logging FW : "), str, this.mLoggingFW);
                this.mIsLoggingAvailable = (this.mFloatingFeature == 0 || this.mLoggingFW == 0) ? false : true;
                Log.i(str, " Logging Available : " + this.mIsLoggingAvailable);
                String str2 = context.getApplicationInfo().packageName;
                str2.getClass();
                switch (str2) {
                    case "com.sec.android.inputmethod":
                        this.mAppTag = "IM";
                        break;
                    case "com.sec.android.app.SmartClipService":
                        this.mAppTag = "SS";
                        break;
                    case "com.samsung.android.notes":
                        this.mAppTag = "NO";
                        break;
                    case "com.samsung.android.snote":
                        this.mAppTag = "SN";
                        break;
                    default:
                        this.mAppTag = "UN";
                        break;
                }
            }
        }
    }

    private boolean checkFloatingFeature() {
        if (isFloatingFeatureExist("com.samsung.android.feature.SemFloatingFeature", "getBoolean")) {
            this.mFloatingFeature = 2;
            return true;
        }
        if (!isFloatingFeatureExist("com.samsung.android.feature.FloatingFeature", "getEnableStatus")) {
            return false;
        }
        this.mFloatingFeature = 1;
        return true;
    }

    private boolean checkLoggingFramework(Context context) {
        if (isLoggingFWAvailable("com.sec.android.diagmonagent", "com.sec.android.diagmonagent.permission.DIAGMON_SURVEY")) {
            this.mLoggingFW = 2;
            return true;
        }
        if (!isLoggingFWAvailable("com.samsung.android.providers.context", "com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY")) {
            return false;
        }
        this.mLoggingFW = 1;
        return true;
    }

    public static void init(Context context) {
        Log.i(TAG, "init");
        synchronized (GSIMLogger.class) {
            try {
                if (mGSiMLogger == null) {
                    mGSiMLogger = new GSIMLogger(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        mGSiMLogger.insertAppLog();
    }

    private void insertAppLog() {
        if (this.mIsLoggingAvailable && "UN".equals(this.mAppTag)) {
            insertLog("00", this.mContext.getPackageName());
        }
    }

    public static void insertLog(String str, String str2) {
        Log.i(TAG, "[feature]:" + str + "[extra]:" + str2);
        mGSiMLogger.insertLogData(str, str2);
    }

    private void insertLogData(String str, String str2) {
        if (this.mIsLoggingAvailable) {
            int i = this.mLoggingFW;
            if (i == 2) {
                Bundle bundle = new Bundle();
                bundle.putString("tracking_id", TRACKING_ID);
                bundle.putString(ExtensionConst.KEY_PARAM_FEATURE, str);
                bundle.putString("extra", str2);
                Intent intent = new Intent();
                intent.setAction("com.sec.android.diagmonagent.intent.USE_APP_FEATURE_SURVEY");
                intent.putExtras(bundle);
                intent.setPackage("com.sec.android.diagmonagent");
                this.mContext.sendBroadcast(intent);
                return;
            }
            if (i == 1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", this.mAppId);
                contentValues.put(ExtensionConst.KEY_PARAM_FEATURE, this.mAppTag + str);
                contentValues.put("extra", str2);
                Intent intent2 = new Intent();
                intent2.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
                intent2.putExtra("data", contentValues);
                intent2.setPackage("com.samsung.android.providers.context");
                this.mContext.sendBroadcast(intent2);
            }
        }
    }

    private static boolean isFloatingFeatureExist(String str, String str2) {
        try {
            Class<?> cls = Class.forName(str);
            boolean zBooleanValue = ((Boolean) cls.getMethod(str2, String.class).invoke(cls.getMethod("getInstance", null).invoke(null, null), "SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE")).booleanValue();
            Log.i(TAG, "Floating Feature is enable.");
            return zBooleanValue;
        } catch (Exception unused) {
            Log.i(TAG, "Floating Feature is disable.");
            return false;
        }
    }

    private boolean isLoggingFWAvailable(String str, String str2) {
        try {
            int i = this.mContext.getPackageManager().getPackageInfo(str, 128).versionCode;
            String str3 = TAG;
            AbstractC2322a.m1631u(i, "versionCode : ", str3);
            if (i <= 1) {
                Log.i(str3, "Invalid logging FW version.");
                return false;
            }
            if (this.mContext.checkCallingOrSelfPermission(str2) != 0) {
                Log.i(str3, "Permission is not allowed.");
                return false;
            }
            Log.i(str3, "Permission is granted.");
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.i(TAG, "Could not find Logging Framework.");
            return false;
        }
    }
}
