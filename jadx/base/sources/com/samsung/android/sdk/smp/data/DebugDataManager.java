package com.samsung.android.sdk.smp.data;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.constants.FeedbackEvent;
import com.samsung.android.sdk.smp.common.database.DBHandler;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.marketing.FeedbackManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DebugDataManager {
    public static final String DEBUG_ALARM_ACTION_DISPLAY = "005";
    public static final String DEBUG_ALARM_ACTION_GET_MARKETING_STATUS = "003";
    public static final String DEBUG_ALARM_ACTION_RESOURCE_DOWNLOAD = "001";
    private static final String DEBUG_DETAIL_DELIMITER = "|";
    public static final String DEBUG_JOB_ACTION_DISPLAY = "006";
    public static final String DEBUG_JOB_ACTION_GET_MARKETING_STATUS = "004";
    public static final String DEBUG_JOB_ACTION_RESOURCE_DOWNLOAD = "002";
    private static final long MAX_DELAY_MIN = 9999;
    private static final String STRING_BOOLEAN_DATA_FALSE = "0";
    private static final String STRING_BOOLEAN_DATA_TRUE = "1";
    private static final String STRING_STANDBY_BUCKET_EXEMPTED = "05";
    private static final String STRING_STANDBY_BUCKET_UNKNOWN = "-1";

    public static void addFeedback(Context context, Bundle bundle, String str, boolean z) {
        DBHandler dBHandlerOpen;
        if (!isDebugPolicyOn(context, z) || bundle == null || TextUtils.isEmpty(str)) {
            return;
        }
        String string = bundle.getString(Constants.EXTRA_KEY_MARKETING_SUB_ACTION);
        String strConvertToDebugJobAction = z ? convertToDebugJobAction(string) : convertToDebugAlarmAction(string);
        if (TextUtils.isEmpty(strConvertToDebugJobAction) || (dBHandlerOpen = DBHandler.open(context)) == null) {
            return;
        }
        if (canAddDebugFeedback(strConvertToDebugJobAction, dBHandlerOpen.getDebugAction(str))) {
            long delayMin = getDelayMin(bundle, z);
            if (delayMin >= 0) {
                FeedbackManager.addFeedback(context, str, FeedbackEvent.CLIENT_DEBUG, generateClientDebugFeedbackDetail(context, strConvertToDebugJobAction, delayMin));
                dBHandlerOpen.updateDebugAction(str, strConvertToDebugJobAction);
            }
        }
        dBHandlerOpen.close();
    }

    private static boolean canAddDebugFeedback(String str, String str2) {
        return TextUtils.isEmpty(str2) || str.compareTo(str2) > 0;
    }

    private static String convertBooleanDataToString(boolean z) {
        return z ? "1" : "0";
    }

    private static String convertToDebugAlarmAction(String str) {
        str.getClass();
        switch (str) {
            case "get_marketing_status":
                return DEBUG_ALARM_ACTION_GET_MARKETING_STATUS;
            case "deliver":
                return DEBUG_ALARM_ACTION_RESOURCE_DOWNLOAD;
            case "display":
                return DEBUG_ALARM_ACTION_DISPLAY;
            default:
                return "";
        }
    }

    private static String convertToDebugJobAction(String str) {
        str.getClass();
        switch (str) {
            case "get_marketing_status":
                return DEBUG_JOB_ACTION_GET_MARKETING_STATUS;
            case "deliver":
                return DEBUG_JOB_ACTION_RESOURCE_DOWNLOAD;
            case "display":
                return DEBUG_JOB_ACTION_DISPLAY;
            default:
                return "";
        }
    }

    public static String generateClientDebugFeedbackDetail(Context context, String str, long j) {
        StringBuilder sb = new StringBuilder();
        String str2 = String.format("%04d", Long.valueOf(j));
        sb.append(str);
        sb.append("|");
        return AbstractC2322a.m1626p(sb, getCommonDebugDataForFeedbackDetail(context), "|", str2);
    }

    public static String generateDeliverFeedbackDetail(Context context, int i) {
        StringBuilder sbM1322o = AbstractC1974b.m1322o(i, "|");
        sbM1322o.append(getCommonDebugDataForFeedbackDetail(context));
        return sbM1322o.toString();
    }

    private static String getCommonDebugDataForFeedbackDetail(Context context) {
        StringBuilder sb = new StringBuilder();
        String strConvertBooleanDataToString = convertBooleanDataToString(DeviceInfoUtil.isBatteryCharging(context));
        String strConvertBooleanDataToString2 = convertBooleanDataToString(DeviceInfoUtil.isPowerSaveMode(context));
        String strConvertBooleanDataToString3 = convertBooleanDataToString(DeviceInfoUtil.isBackgroundRestricted(context));
        String strConvertBooleanDataToString4 = convertBooleanDataToString(DeviceInfoUtil.isAppForeground(context));
        AbstractC2821a.m2207B(sb, getStandByBucketData(context), "|", strConvertBooleanDataToString, "|");
        AbstractC2821a.m2207B(sb, strConvertBooleanDataToString2, "|", strConvertBooleanDataToString3, "|");
        sb.append(strConvertBooleanDataToString4);
        return sb.toString();
    }

    private static long getDelayMin(Bundle bundle, boolean z) {
        long j = bundle.getLong(z ? Constants.EXTRA_KEY_JOB_EXECUTE_TIME : Constants.EXTRA_KEY_ALARM_SETTING_TIME, 0L);
        if (j <= 0) {
            return -1L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        if (jCurrentTimeMillis < 0) {
            return 0L;
        }
        return Math.min(jCurrentTimeMillis / Constants.MINMILLIS, MAX_DELAY_MIN);
    }

    private static String getStandByBucketData(Context context) {
        if (Build.VERSION.SDK_INT < 28) {
            return STRING_STANDBY_BUCKET_UNKNOWN;
        }
        int standByBucket = DeviceInfoUtil.getStandByBucket(context);
        return standByBucket == 5 ? STRING_STANDBY_BUCKET_EXEMPTED : (standByBucket == 10 || standByBucket == 20 || standByBucket == 30 || standByBucket == 40 || standByBucket == 45 || standByBucket == 50) ? Integer.toString(standByBucket) : STRING_STANDBY_BUCKET_UNKNOWN;
    }

    private static boolean isDebugPolicyOn(Context context, boolean z) {
        PrefManager prefManager = PrefManager.getInstance(context);
        return z ? prefManager.isDebugJobOn() : prefManager.isDebugAlarmOn();
    }

    public static void putTimeDataForDelay(Bundle bundle, long j, boolean z) {
        if (bundle == null) {
            return;
        }
        bundle.putLong(z ? Constants.EXTRA_KEY_JOB_EXECUTE_TIME : Constants.EXTRA_KEY_ALARM_SETTING_TIME, j);
    }
}
