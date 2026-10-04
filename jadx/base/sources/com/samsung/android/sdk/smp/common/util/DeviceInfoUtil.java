package com.samsung.android.sdk.smp.common.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.PowerManager;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.feature.SemFloatingFeature;
import com.samsung.android.sdk.smp.BuildConfig;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.data.UsageManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DeviceInfoUtil {
    public static final String CONTENTS_TYPE_1 = "type1";
    public static final String CONTENTS_TYPE_2 = "type2";
    public static final String CONTENTS_TYPE_3 = "type3";
    public static final String CONTENTS_TYPE_RESOLUTION = "resolution";
    public static final char FLAVOR_TYPE_C = 'c';
    public static final char FLAVOR_TYPE_G = 'g';
    private static final int MCC_LENGTH = 3;
    private static final String PLATFORM_ANDROID = "Android";
    private static final String SEC_FLOATING_FEATURE_DISPLAY_SWITCH = "SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_WM_CONTROLS_DISPLAY_SWITCH";
    private static final String SEC_FLOATING_FEATURE_TYPE_FOLD = "SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FOLD";
    private static final String TAG = "DeviceInfoUtil";
    private static final String VALUE_SEC_FLOATING_FEATURE_SPP_FORCE_ACTIVATION_MODE = "force_activation_mode";

    public static String getAppVersion(Context context) {
        try {
            return PackageManagerUtil.getPackageInfo(context, context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static String getContentsType(Context context) {
        if (!isFoldDevice()) {
            return getContentsTypeByResolution(context);
        }
        SmpLog.m6498i(TAG, "isFoldDevice : true, contents type : type2");
        return "type2";
    }

    public static String getContentsTypeByResolution(Context context) {
        return getSmallestScreenWidth(context) >= 600 ? "type2" : "type1";
    }

    public static String getCountryIsoCode() {
        try {
            String systemProperty = getSystemProperty("ro.csc.countryiso_code");
            return !TextUtils.isEmpty(systemProperty) ? systemProperty.trim() : systemProperty;
        } catch (Exception e) {
            SmpLog.m6501w(TAG, "get country iso code fail. " + e);
            return null;
        }
    }

    public static String getCscCode() {
        try {
            return getSystemProperty("ro.csc.sales_code");
        } catch (Exception e) {
            SmpLog.m6501w(TAG, "get csc code fail. " + e);
            return null;
        }
    }

    public static char getFlavorType() {
        return BuildConfig.FLAVOR.charAt(0);
    }

    public static int getJobIdSelectionKey(Context context, String str) {
        Bundle metaData = getMetaData(context, str);
        if (metaData == null) {
            SmpLog.m6501w(TAG, "fail to get job id selection key(int)");
            return 0;
        }
        int i = metaData.getInt(Constants.META_DATA_JOB_ID_SELECTION_KEY);
        SmpLog.m6498i(TAG, "job id selection key : " + i);
        return Math.min(Math.max(0, i), 99);
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage().trim();
    }

    public static String getLocale() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage().trim() + "_" + locale.getCountry().trim();
    }

    private static Bundle getMetaData(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6501w(TAG, "fail to get metadata. package is null");
            return null;
        }
        try {
            return PackageManagerUtil.getApplicationInfo(context, str, 128).metaData;
        } catch (Exception e) {
            SmpLog.m6501w(TAG, "fail to get metadata. " + e.toString());
            return null;
        }
    }

    public static String getModelName() {
        return Build.MODEL;
    }

    public static String getNetMcc(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        if (TextUtils.isEmpty(networkOperator) || networkOperator.length() <= 3) {
            return null;
        }
        return networkOperator.substring(0, 3);
    }

    public static String getNetMnc(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        if (TextUtils.isEmpty(networkOperator) || networkOperator.length() <= 3) {
            return null;
        }
        return networkOperator.substring(3);
    }

    public static String getOneUIVersion() {
        try {
            return getSystemProperty("ro.build.version.oneui");
        } catch (Exception e) {
            SmpLog.m6501w(TAG, "get one ui version fail. " + e);
            return null;
        }
    }

    public static String getPlatform() {
        return "Android";
    }

    public static int getPlatformVersionCode() {
        return Build.VERSION.SDK_INT;
    }

    public static Signature[] getSignature(Context context, String str) {
        return Build.VERSION.SDK_INT < 28 ? PackageManagerUtil.getPackageInfo(context, str, 64).signatures : PackageManagerUtil.getPackageInfo(context, str, 134217728).signingInfo.getApkContentsSigners();
    }

    public static String getSimMcc(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null || telephonyManager.getSimState() != 5) {
            return null;
        }
        String simOperator = telephonyManager.getSimOperator();
        if (TextUtils.isEmpty(simOperator) || simOperator.length() <= 3) {
            return null;
        }
        return simOperator.substring(0, 3);
    }

    public static String getSimMnc(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null || telephonyManager.getSimState() != 5) {
            return null;
        }
        String simOperator = telephonyManager.getSimOperator();
        if (TextUtils.isEmpty(simOperator) || simOperator.length() <= 3) {
            return null;
        }
        return simOperator.substring(3);
    }

    public static int getSmallestScreenWidth(Context context) {
        return context.getResources().getConfiguration().smallestScreenWidthDp;
    }

    public static String getSmpSdkVersion(Context context) {
        return getSmpSdkVersion(context, context.getPackageName());
    }

    public static int getSmpSdkVersionInt(Context context, String str) {
        Bundle metaData = getMetaData(context, str);
        if (metaData != null) {
            return metaData.getInt(Constants.META_DATA_SDK_VERSION_INT);
        }
        SmpLog.m6501w(TAG, "fail to get sdk version(int)");
        return -1;
    }

    public static boolean getSmpServerStg(Context context) {
        Bundle metaData = getMetaData(context, context.getPackageName());
        if (metaData != null) {
            return metaData.getBoolean(Constants.META_DATA_SDK_SERVER_STG, false);
        }
        SmpLog.m6501w(TAG, "fail to get sdk server stg(boolean)");
        return false;
    }

    @RequiresApi(api = 28)
    public static int getStandByBucket(Context context) {
        return ((UsageStatsManager) context.getApplicationContext().getSystemService("usagestats")).getAppStandbyBucket();
    }

    private static String getSystemProperty(String str) throws ClassNotFoundException {
        Class<?> cls = Class.forName("android.os.SystemProperties");
        return (String) cls.getMethod("get", String.class).invoke(cls, str);
    }

    public static int getTargetSdkVersion(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            int i = PackageManagerUtil.getPackageInfo(context, context.getPackageName(), 0).applicationInfo.targetSdkVersion;
            SmpLog.m6498i(TAG, "target version : " + i);
            return i;
        } catch (Exception e) {
            SmpLog.m6494e(TAG, e.getMessage());
            return -1;
        }
    }

    public static boolean hasSppForceActivationFeature() {
        try {
            String string = SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_SMP_CONFIG_SPP_ACTIVATION_MODE");
            if (!TextUtils.isEmpty(string)) {
                SmpLog.m6498i(TAG, "spp activation feature : " + string);
            }
            return VALUE_SEC_FLOATING_FEATURE_SPP_FORCE_ACTIVATION_MODE.equals(string);
        } catch (Error | Exception unused) {
            return false;
        }
    }

    public static boolean isAppDisabled(Context context) {
        try {
            return !PackageManagerUtil.getApplicationInfo(context, context.getPackageName(), 0).enabled;
        } catch (Exception e) {
            AbstractC6670b.m4737B(e, new StringBuilder("isAppDisabled error. "), TAG);
            return false;
        }
    }

    public static boolean isAppForeground(Context context) {
        return UsageManager.getInstance(context).getActivityCount() > 0;
    }

    public static boolean isArabicStyleLanguage() {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return false;
        }
        byte directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
        return directionality == 2 || directionality == 1;
    }

    public static boolean isBackgroundRestricted(Context context) {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return ((ActivityManager) context.getApplicationContext().getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY)).isBackgroundRestricted();
    }

    public static boolean isBatteryCharging(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            return false;
        }
        int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    public static boolean isCN() {
        String countryIsoCode = getCountryIsoCode();
        return com.samsung.android.sdk.smp.common.constants.Constants.ISO_CODE_CN.equals(countryIsoCode) || com.samsung.android.sdk.smp.common.constants.Constants.ISO_CODE_CHN.equals(countryIsoCode);
    }

    public static boolean isDataSaverMode(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || connectivityManager.getRestrictBackgroundStatus() != 3) {
            return false;
        }
        SmpLog.m6498i(TAG, "data saver mode on");
        return true;
    }

    public static boolean isFoldDevice() {
        try {
            SemFloatingFeature semFloatingFeature = SemFloatingFeature.getInstance();
            if (semFloatingFeature.getBoolean(SEC_FLOATING_FEATURE_TYPE_FOLD)) {
                return true;
            }
            return semFloatingFeature.getBoolean(SEC_FLOATING_FEATURE_DISPLAY_SWITCH);
        } catch (Error | Exception e) {
            SmpLog.m6501w(TAG, "Fail to fetch fold feature. " + e.toString());
            return false;
        }
    }

    public static boolean isNotiSettingOptionDisabled(Context context, String str) throws InternalException.IllegalPushChannelException {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager == null) {
            return false;
        }
        if (notificationManager.getImportance() == 0) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
        if (notificationChannel != null) {
            return notificationChannel.getImportance() == 0;
        }
        SmpLog.m6494e(TAG, "channel not created : " + str);
        throw new InternalException.IllegalPushChannelException();
    }

    @TargetApi(23)
    public static boolean isNotificationVisible(Context context, int i) {
        for (StatusBarNotification statusBarNotification : ((NotificationManager) context.getSystemService("notification")).getActiveNotifications()) {
            if (statusBarNotification.getId() == i) {
                SmpLog.m6498i(TAG, "notification(" + i + ") visible : true");
                return true;
            }
        }
        SmpLog.m6498i(TAG, "notification(" + i + ") visible : false");
        return false;
    }

    public static boolean isOnlySupportGeneralPush(Context context) {
        return isWatchDevice(context) || isVstDevice(context) || !isSamsungDevice();
    }

    public static boolean isPkgInstalled(Context context, String str) {
        try {
        } catch (Exception e) {
            AbstractC6670b.m4737B(e, new StringBuilder("isPkgInstalled error. "), TAG);
        }
        return PackageManagerUtil.getPackageInfo(context, str, 0) != null;
    }

    public static boolean isPowerSaveMode(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        boolean z = powerManager != null && powerManager.isPowerSaveMode();
        if (z) {
            SmpLog.m6498i(TAG, "power save mode on");
        }
        return z;
    }

    public static boolean isProductShip() {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                return "true".equals(getSystemProperty("ro.product_ship"));
            } catch (Throwable th) {
                Log.e(TAG, th.getMessage());
                return true;
            }
        }
        try {
            return ((Integer) Debug.class.getMethod(NetworkConfig.CLIENTS_IS_PRODUCT_SHIP, null).invoke(null, null)).intValue() == 1;
        } catch (Throwable th2) {
            Log.e(TAG, th2.getMessage());
            return true;
        }
    }

    private static boolean isSamsungDevice() {
        return "samsung".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isSamsungPushService(Context context) {
        if (context != null) {
            return "com.sec.spp.push".equals(context.getPackageName());
        }
        return false;
    }

    public static boolean isScreenOn(Context context) {
        PowerManager powerManager;
        if (context == null || (powerManager = (PowerManager) context.getSystemService("power")) == null) {
            return true;
        }
        return powerManager.isInteractive();
    }

    public static boolean isSupportCountryCode() {
        char flavorType = getFlavorType();
        return flavorType != 'c' ? (flavorType == 'g' && !hasSppForceActivationFeature() && isCN()) ? false : true : isCN();
    }

    private static boolean isVstDevice(Context context) {
        return PackageManagerUtil.hasSystemFeature(context, PackageManagerUtil.FEATURE_DEVICE_CATEGORY_VST);
    }

    private static boolean isWatchDevice(Context context) {
        return PackageManagerUtil.hasSystemFeature(context, "android.hardware.type.watch");
    }

    @TargetApi(29)
    public static boolean isWindowOverlayOpAllowed(Context context) {
        return Settings.canDrawOverlays(context);
    }

    public static String getSmpSdkVersion(Context context, String str) {
        Bundle metaData = getMetaData(context, str);
        if (metaData != null) {
            return metaData.getString(com.samsung.android.sdk.smp.common.constants.Constants.META_DATA_SDK_VERSION);
        }
        SmpLog.m6501w(TAG, "fail to get sdk version");
        return "";
    }
}
