package com.samsung.context.sdk.samsunganalytics.internal.util;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Trace;
import android.provider.Settings;
import android.text.TextUtils;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.context.sdk.samsunganalytics.AnalyticsException;
import com.samsung.context.sdk.samsunganalytics.Configuration;
import com.samsung.context.sdk.samsunganalytics.internal.property.PropertyLogRegister;
import com.samsung.context.sdk.samsunganalytics.internal.property.PropertyLogSender;
import com.samsung.context.sdk.samsunganalytics.internal.sender.LogType;
import com.samsung.context.sdk.samsunganalytics.internal.setting.SettingLogRegister;
import com.samsung.context.sdk.samsunganalytics.internal.setting.SettingLogSender;
import com.samsung.context.sdk.samsunganalytics.internal.terms.RegisterLogSender;
import com.samsung.context.sdk.samsunganalytics.internal.terms.RegisterType;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import com.sec.android.diagmonagent.common.util.CommonUtils;
import com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient;
import com.sec.android.diagmonagent.common.util.executor.SingleThreadExecutor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Utils {
    private static final int DMA_VERSION_NOT_SUPPORTED_APP_COMMON = 712601000;
    private static final int DMA_VERSION_PROVIDING_DATA = 710000000;
    private static final int DMA_VERSION_SUPPORTED_DELETE_SENSITIVE_DATA = 910701000;
    public static final String LOG_DELIMITER = "\u000e";

    /* JADX INFO: renamed from: br */
    private static BroadcastReceiver f8122br;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Depth {
        ONE_DEPTH("\u0002", "\u0003"),
        TWO_DEPTH("\u0004", "\u0005"),
        THREE_DEPTH("\u0006", "\u0007");

        private final String collDlm;
        private final String keyValueDlm;

        Depth(String str, String str2) {
            this.collDlm = str;
            this.keyValueDlm = str2;
        }

        public String getCollectionDLM() {
            return this.collDlm;
        }

        public String getKeyValueDLM() {
            return this.keyValueDlm;
        }
    }

    public static void addAppCommonData(Context context, ContentValues contentValues, Configuration configuration) {
        HashMap map = new HashMap();
        map.put("av", CommonUtils.getPackageVersion(context));
        map.put("uv", configuration.getVersion());
        map.put(VPathDataCmd.RCurveTo, "6.05.079");
        Depth depth = Depth.ONE_DEPTH;
        contentValues.put("appCommon_data", makeDelimiterString(map, depth));
        if (TextUtils.isEmpty(configuration.getDeviceId())) {
            return;
        }
        HashMap map2 = new HashMap();
        map2.put("auid", configuration.getDeviceId());
        map2.put(VPathDataCmd.ArcTo, String.valueOf(configuration.getAuidType()));
        contentValues.put("appCommon_did", makeDelimiterString(map2, depth));
    }

    public static boolean compareDays(int i, Long l) {
        return System.currentTimeMillis() > (((long) i) * 86400000) + l.longValue();
    }

    public static boolean compareHours(int i, Long l) {
        return System.currentTimeMillis() > (((long) i) * 3600000) + l.longValue();
    }

    public static long getDaysAgo(int i) {
        return System.currentTimeMillis() - (((long) i) * 86400000);
    }

    public static long getTimeZoneOffset() {
        return TimeUnit.MILLISECONDS.toMinutes(((long) TimeZone.getDefault().getRawOffset()) + ((long) android.icu.util.TimeZone.getDefault().getDSTSavings()));
    }

    public static LogType getTypeForServer(String str) {
        return "dl".equals(str) ? LogType.DEVICE : LogType.UIX;
    }

    public static boolean isAddingContentValueKeyAllowed(Context context) {
        return !isSendingAppCommonSupported(context);
    }

    public static boolean isAppVersionChanged(Context context, String str) {
        String packageVersion = CommonUtils.getPackageVersion(context);
        String string = Preferences.getPreferences(context).getString(str, "");
        if (TextUtils.isEmpty(string)) {
            Preferences.getPreferences(context).edit().putString(str, packageVersion).apply();
            return false;
        }
        if (string.equals(packageVersion) || TextUtils.isEmpty(packageVersion)) {
            return false;
        }
        Preferences.getPreferences(context).edit().putString(str, packageVersion).apply();
        return true;
    }

    public static boolean isDeletionOfSensitiveDataSupported(Context context) {
        return DMA_VERSION_SUPPORTED_DELETE_SENSITIVE_DATA <= CommonUtils.getDMAVersion(context);
    }

    public static boolean isDev() {
        return !Build.TYPE.equals(IdentityApiContract.Token.USER);
    }

    public static boolean isDiagnosticAgree(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "samsung_errorlog_agree", 0) == 1;
    }

    public static boolean isMultipleTcTypeSupported(Context context) {
        return !isSendingAppCommonSupported(context);
    }

    public static boolean isProvidingDataSupported(Context context) {
        return DMA_VERSION_PROVIDING_DATA <= CommonUtils.getDMAVersion(context);
    }

    public static boolean isSendingAppCommonSupported(Context context) {
        return DMA_VERSION_NOT_SUPPORTED_APP_COMMON > CommonUtils.getDMAVersion(context);
    }

    public static boolean isTcTypeChanged(Context context, Configuration configuration, Configuration configuration2) {
        if (!isMultipleTcTypeSupported(context)) {
            return false;
        }
        if (configuration == null) {
            return true;
        }
        return (configuration2 == null || configuration.isEnableUseInAppLogging() == configuration2.isEnableUseInAppLogging()) ? false : true;
    }

    public static String makeDelimiterString(Map<String, String> map, Depth depth) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(depth.getCollectionDLM());
            }
            sb.append(entry.getKey());
            sb.append(depth.getKeyValueDLM());
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public static Map<String, String> parseDelimiterString(String str, Depth depth) {
        HashMap map = new HashMap();
        for (String str2 : str.split(depth.getCollectionDLM())) {
            String[] strArrSplit = str2.split(depth.getKeyValueDLM());
            if (strArrSplit.length > 1) {
                map.put(strArrSplit[0], strArrSplit[1]);
            }
        }
        return map;
    }

    public static void registerProperties(Context context, Map<String, String> map) {
        new PropertyLogRegister(context).registerLog(map);
    }

    public static void registerReceiver(Context context, final Configuration configuration) {
        Debug.LogENG("register BR");
        if (f8122br != null) {
            Debug.LogENG("BR is already registered");
            return;
        }
        f8122br = new BroadcastReceiver() { // from class: com.samsung.context.sdk.samsunganalytics.internal.util.Utils.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(final Context context2, Intent intent) {
                StringBuilder sb = new StringBuilder("receive BR ");
                sb.append(intent != null ? intent.getAction() : "null");
                Debug.LogENG(sb.toString());
                if (intent == null || !"android.intent.action.ACTION_POWER_CONNECTED".equals(intent.getAction())) {
                    return;
                }
                SingleThreadExecutor.getInstance().execute(new AsyncTaskClient() { // from class: com.samsung.context.sdk.samsunganalytics.internal.util.Utils.1.1
                    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
                    public int onFinish() {
                        return 0;
                    }

                    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
                    public void run() {
                        Utils.sendSettings(context2, configuration);
                        Utils.sendProperties(context2, configuration);
                    }
                });
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        context.registerReceiver(f8122br, intentFilter);
    }

    public static void registerSettings(Context context, Map<String, Set<String>> map) {
        new SettingLogRegister(context).registerLog(map);
    }

    public static void sendProperties(Context context, Configuration configuration) {
        Trace.beginSection("PropertyLogSender sendLog");
        new PropertyLogSender(context, configuration).sendLog();
        Trace.endSection();
    }

    public static void sendRegistration(Application application, Configuration configuration, RegisterType registerType) {
        Trace.beginSection("RegisterLogSender sendLog");
        new RegisterLogSender(application, configuration, registerType).sendLog();
        Trace.endSection();
    }

    public static void sendSettings(Context context, Configuration configuration) {
        Trace.beginSection("SettingLogSender sendLog");
        new SettingLogSender(context, configuration).sendLog();
        Trace.endSection();
    }

    public static void throwException(String str) {
        if (isDev()) {
            throw new AnalyticsException(str);
        }
        Debug.LogE(str);
    }

    public static void unregisterReceiver(Context context) {
        BroadcastReceiver broadcastReceiver;
        if (context == null || (broadcastReceiver = f8122br) == null) {
            return;
        }
        context.unregisterReceiver(broadcastReceiver);
        f8122br = null;
    }
}
