package com.samsung.context.sdk.samsunganalytics.internal.policy;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.smp.common.database.DBContract;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.context.sdk.samsunganalytics.Configuration;
import com.samsung.context.sdk.samsunganalytics.LogBuilders;
import com.samsung.context.sdk.samsunganalytics.internal.Callback;
import com.samsung.context.sdk.samsunganalytics.internal.connection.API;
import com.samsung.context.sdk.samsunganalytics.internal.device.DeviceInfo;
import com.samsung.context.sdk.samsunganalytics.internal.util.AuthUtil;
import com.samsung.context.sdk.samsunganalytics.internal.util.ClientUtil;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import com.samsung.context.sdk.samsunganalytics.internal.util.Preferences;
import com.samsung.context.sdk.samsunganalytics.internal.util.Utils;
import com.sec.android.diagmonagent.common.util.CommonUtils;
import com.sec.android.diagmonagent.common.util.executor.Executor;
import java.util.HashMap;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PolicyUtils {
    private static final int ALL_NEW_DMA_VERSION = 600000000;
    public static final int DLS = 0;
    public static final int DMA_B = 2;
    public static final int DMA_P = 3;
    private static final int DMA_SUPPORT_VERSION = 540000000;
    public static final int NONE = -1;
    private static int senderType = -1;

    private static PolicyClient buildPolicyClient(Context context, Configuration configuration, DeviceInfo deviceInfo, Callback<Void, Boolean> callback) {
        Debug.LogENG("Build policy client, trid: " + configuration.getTrackingId().substring(0, 7) + ", uv: " + configuration.getVersion());
        return new PolicyClient(API.GET_POLICY, makePolicyParam(context, deviceInfo, configuration), Preferences.getPreferences(context), callback);
    }

    private static String getCSC() {
        return getSystemProperties("ro.csc.sales_code");
    }

    private static String getCountryIso() {
        return getSystemProperties("ro.csc.countryiso_code");
    }

    public static int getRemainingQuota(Context context, int i) {
        int i2;
        int i4;
        int i5;
        SharedPreferences preferences = Preferences.getPreferences(context);
        int i6 = 0;
        if (i == 1) {
            i4 = preferences.getInt(Constants.KEY_WIFI_QUOTA, 0);
            i5 = preferences.getInt(Constants.KEY_WIFI_USED, 0);
        } else {
            if (i != 0) {
                i2 = 0;
                return i6 - i2;
            }
            i4 = preferences.getInt(Constants.KEY_DATA_QUOTA, 0);
            i5 = preferences.getInt(Constants.KEY_DATA_USED, 0);
        }
        i2 = i5;
        i6 = i4;
        return i6 - i2;
    }

    public static int getSenderType() {
        return senderType;
    }

    private static String getSystemProperties(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e) {
            StringBuilder sbM15l = AbstractC0000a.m15l("failed to get system properties : ", str, ", error : ");
            sbM15l.append(e.getMessage());
            Debug.logwingW(sbM15l.toString());
            return "";
        }
    }

    public static int hasQuota(Context context, int i, int i2) {
        int i4;
        int i5;
        int i6;
        SharedPreferences preferences = Preferences.getPreferences(context);
        if (i == 1) {
            i5 = preferences.getInt(Constants.KEY_WIFI_QUOTA, 0);
            i6 = preferences.getInt(Constants.KEY_WIFI_USED, 0);
            i4 = preferences.getInt(Constants.KEY_WIFI_ONCE_QUOTA, 0);
        } else if (i == 0) {
            i5 = preferences.getInt(Constants.KEY_DATA_QUOTA, 0);
            i6 = preferences.getInt(Constants.KEY_DATA_USED, 0);
            i4 = preferences.getInt(Constants.KEY_DATA_ONCE_QUOTA, 0);
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i5, i6, "Quota : ", "/ Uploaded : ", "/ limit : ");
        sbM1173s.append(i4);
        sbM1173s.append("/ size : ");
        sbM1173s.append(i2);
        Debug.LogENG(sbM1173s.toString());
        if (i5 >= i6 + i2) {
            if (i4 >= i2) {
                return 0;
            }
            Debug.LogD("DLS Sender", AbstractC0622a.m1164j(i4, i2, "send result fail : Over once quota (limit: ", "/ size: ", ")"));
            return -11;
        }
        StringBuilder sbM1173s2 = AbstractC0622a.m1173s(i5, i6, "send result fail : Over daily quota (quota: ", "/ uploaded: ", "/ size: ");
        sbM1173s2.append(i2);
        sbM1173s2.append(")");
        Debug.LogD("DLS Sender", sbM1173s2.toString());
        return -1;
    }

    public static void initSenderType() {
        senderType = -1;
    }

    public static boolean isPolicyExpired(Context context) {
        SharedPreferences preferences = Preferences.getPreferences(context);
        if (Utils.compareDays(1, Long.valueOf(preferences.getLong(Constants.LAST_QUOTA_RESET_DATE, 0L)))) {
            resetQuota(preferences);
        }
        return Utils.compareDays(preferences.getInt(Constants.POLICY_RINT, 1), Long.valueOf(preferences.getLong(Constants.POLICY_RECEIVED_DATE, 0L)));
    }

    private static Map<String, String> makePolicyParam(Context context, DeviceInfo deviceInfo, Configuration configuration) {
        HashMap map = new HashMap();
        map.put("pkn", context.getPackageName());
        map.put("dm", deviceInfo.getDeviceModel());
        if (!TextUtils.isEmpty(deviceInfo.getMcc())) {
            map.put("mcc", deviceInfo.getMcc());
        }
        if (!TextUtils.isEmpty(deviceInfo.getMnc())) {
            map.put("mnc", deviceInfo.getMnc());
        }
        map.put("uv", configuration.getVersion());
        map.put("sv", "6.05.079");
        map.put("tid", configuration.getTrackingId());
        String strValueOf = String.valueOf(System.currentTimeMillis());
        map.put(DBContract.AckColumns.TIMESTAMP, strValueOf);
        map.put(VPathDataCmd.CornerLine, AuthUtil.sha256(configuration.getTrackingId() + strValueOf + ClientUtil.SALT));
        String csc = getCSC();
        if (!TextUtils.isEmpty(csc)) {
            map.put("csc", csc);
        }
        String countryIso = getCountryIso();
        if (!TextUtils.isEmpty(countryIso)) {
            map.put(LogBuilders.Property.COUNTRY_CODE, countryIso);
        }
        return map;
    }

    private static void resetQuota(SharedPreferences sharedPreferences) {
        sharedPreferences.edit().putLong(Constants.LAST_QUOTA_RESET_DATE, System.currentTimeMillis()).putInt(Constants.KEY_DATA_USED, 0).putInt(Constants.KEY_WIFI_USED, 0).apply();
    }

    public static void setSenderType(Context context, Configuration configuration) {
        if (senderType != -1) {
            return;
        }
        int dMAVersion = CommonUtils.getDMAVersion(context);
        if (dMAVersion >= DMA_SUPPORT_VERSION) {
            senderType = dMAVersion >= ALL_NEW_DMA_VERSION ? 3 : 2;
        } else {
            senderType = configuration.isEnableUseInAppLogging() ? 0 : -1;
        }
    }

    public static void updatePolicy(Context context, Configuration configuration, Executor executor, DeviceInfo deviceInfo, Callback<Void, Boolean> callback) {
        executor.execute(buildPolicyClient(context, configuration, deviceInfo, callback));
    }

    public static void useQuota(Context context, int i, int i2) {
        SharedPreferences preferences = Preferences.getPreferences(context);
        if (i == 1) {
            preferences.edit().putInt(Constants.KEY_WIFI_USED, preferences.getInt(Constants.KEY_WIFI_USED, 0) + i2).apply();
        } else if (i == 0) {
            preferences.edit().putInt(Constants.KEY_DATA_USED, Preferences.getPreferences(context).getInt(Constants.KEY_DATA_USED, 0) + i2).apply();
        }
    }

    public static void updatePolicy(Context context, Configuration configuration, Executor executor, DeviceInfo deviceInfo) {
        updatePolicy(context, configuration, executor, deviceInfo, null);
    }
}
