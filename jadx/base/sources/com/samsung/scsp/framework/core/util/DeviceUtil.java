package com.samsung.scsp.framework.core.util;

import android.app.admin.DevicePolicyManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.SemUserInfo;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.work.impl.C4041b;
import androidx.work.multiprocess.C4148a;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.scsp.common.ContextFactory;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.identity.DeviceIdSupplier;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.function.Function;
import org.apache.commons.lang3.exception.C13833a;
import org.apache.commons.lang3.function.C13849N;
import p006B.C0017a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DeviceUtil {
    private static final String DEFAULT_CC = "KOR";
    private static final String DEFAULT_CC_ISO = "KO";
    private static final String DEFAULT_CSC = "";
    private static final String DEFAULT_MCC = "";
    private static final String DEFAULT_MNC = "";
    private static final boolean MU_ENABLED = true;
    private static final int PER_USER_RANGE = 100000;
    private static final int USER_SYSTEM = 0;
    private static final Logger logger = Logger.get("DeviceUtil");
    private static String deviceUniqueId = "";
    private static String b2bMode = "";
    private static final String[] CSC_FIELDS = {"ro.csc.sales_code", "persist.omc.sales_code", "ril.sales_code", "persist.audio.sales_code"};
    public static Function<Context, String> androidId = new C13833a(14);

    /* JADX WARN: Multi-variable type inference failed */
    public static String getAndroidDeviceName(Context context) {
        String str = (String) FaultBarrier.get(new C4041b(context, 4), "", true).obj;
        return StringUtil.isEmpty(str) ? (String) FaultBarrier.get(new C4041b(context, 5), "", true).obj : str;
    }

    public static String getAndroidId(Context context) {
        return androidId.apply(context);
    }

    public static String getB2BMode(Context context) {
        if (StringUtil.isEmpty(b2bMode)) {
            if (isDoMode(context)) {
                b2bMode = "do";
            } else if (isPoMode(context)) {
                b2bMode = "po";
            } else {
                b2bMode = "none";
            }
        }
        return b2bMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getCsc() {
        return (String) FaultBarrier.get(new C13849N(18), "").obj;
    }

    public static String getDeviceName(Context context) {
        String watchDeviceName = isWatch(context) ? getWatchDeviceName() : getAndroidDeviceName(context);
        return TextUtils.isEmpty(watchDeviceName) ? Build.MODEL : watchDeviceName;
    }

    public static String getDeviceType() {
        return isWatch(ContextFactory.getApplicationContext()) ? "watch" : isVst() ? "vst" : isTablet() ? "tablet" : "phone";
    }

    public static String getDeviceUniqueId(Context context, DeviceIdSupplier deviceIdSupplier) throws ScspException {
        if (!StringUtil.isEmpty(deviceUniqueId)) {
            return deviceUniqueId;
        }
        if (deviceIdSupplier == null) {
            throw new ScspException(ScspException.Code.RUNTIME_POLICY, "Runtime policy error. DeviceIdSupplier is null.");
        }
        try {
            int phoneType = ((TelephonyManager) context.getSystemService("phone")).getPhoneType();
            if (isWatch(context) || phoneType == 0) {
                deviceUniqueId = deviceIdSupplier.getSerial();
            } else {
                deviceUniqueId = deviceIdSupplier.getImei();
            }
            if (!StringUtil.isEmpty(deviceUniqueId) && !deviceUniqueId.equals("0")) {
                return deviceUniqueId;
            }
            throw new ScspException(ScspException.Code.RUNTIME_POLICY, "Runtime policy error. There is an exception while getting device id. {" + deviceUniqueId + "}");
        } catch (SecurityException unused) {
            throw new ScspException(70000002, "Runtime policy error. Permission is not granted.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getIso3CountryCode(Context context) {
        return (String) FaultBarrier.get(new C13849N(19), DEFAULT_CC).obj;
    }

    private static String getMcc(String str) {
        return (str == null || str.isEmpty() || str.length() < 3) ? "" : str.substring(0, 3);
    }

    private static String getMnc(String str) {
        return (str == null || str.isEmpty() || str.length() < 3) ? "" : str.substring(3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getModelCode() {
        return (String) FaultBarrier.get(new C13849N(15), "").obj;
    }

    public static String getModelName() {
        return Build.MODEL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getNetworkMcc(Context context) {
        logger.m12934i("getNetworkMcc");
        return (String) FaultBarrier.get(new C4041b(context, 7), "").obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getNetworkMnc(Context context) {
        logger.m12934i(" : getNetworkMnc()");
        return (String) FaultBarrier.get(new C4041b(context, 10), "").obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getOneUiVersion() {
        return (String) FaultBarrier.get(new C13849N(14), "0.0.0").obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getOneUiVersionValue() {
        return ((Integer) FaultBarrier.get(new C13849N(17), 0).obj).intValue();
    }

    public static int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getSimMcc(Context context) {
        logger.m12934i("getSimMcc");
        return (String) FaultBarrier.get(new C4041b(context, 2), "").obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getSimMnc(Context context) {
        logger.m12934i("getSimMnc");
        return (String) FaultBarrier.get(new C4041b(context, 8), "").obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getSsdid(Context context) {
        return (String) FaultBarrier.get(new C4041b(context, 3), "", true).obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getSystemProperties(String str, String str2) {
        return (String) FaultBarrier.get(new C0017a(str, 3), str2).obj;
    }

    public static int getUserId() {
        return Process.myUid() / 100000;
    }

    public static int getUserInfoFlags() throws ScspException {
        if (Build.VERSION.SDK_INT < 35) {
            throw new ScspException(ScspException.Code.NOT_SUPPORT_OS_VERSION, "Not supported OS version. Support from V OS or higher");
        }
        return ((Integer) SemUserInfo.class.getDeclaredMethod("getFlags", null).invoke(((UserManager) ContextFactory.getApplicationContext().getSystemService(UserManager.class)).semGetSemUserInfo(UserHandle.getUserHandleForUid(Process.myUid()).semGetIdentifier()), null)).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String getWatchDeviceName() {
        return (String) FaultBarrier.get(new C13849N(16), "", true).obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isDoMode(Context context) {
        return ((Boolean) FaultBarrier.get(new C4041b(context, 6), Boolean.FALSE).obj).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isPoMode(Context context) {
        return ((Boolean) FaultBarrier.get(new C4041b(context, 9), Boolean.FALSE).obj).booleanValue();
    }

    public static boolean isTablet() {
        String systemProperties = getSystemProperties("ro.build.characteristics", (String) null);
        return systemProperties != null && systemProperties.contains("tablet");
    }

    public static boolean isVst() {
        String systemProperties = getSystemProperties("ro.product.system.name", (String) null);
        return systemProperties != null && systemProperties.contains("xrvst");
    }

    public static boolean isWatch(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getAndroidDeviceName$12(Context context) {
        return Settings.System.getString(context.getContentResolver(), "device_name");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getAndroidDeviceName$13(Context context) {
        return Settings.Global.getString(context.getContentResolver(), "device_name");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getCsc$10() {
        for (String str : CSC_FIELDS) {
            String systemProperties = getSystemProperties(str, "");
            if (!StringUtil.isEmpty(systemProperties)) {
                return systemProperties;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getIso3CountryCode$9() {
        String iSO3Country = new Locale("", getSystemProperties(isVst() ? "mdc.countryiso_code" : "ro.csc.countryiso_code", DEFAULT_CC_ISO)).getISO3Country();
        return iSO3Country.trim().length() == 3 ? iSO3Country : DEFAULT_CC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getModelCode$4() {
        return getSystemProperties("ril.product_code", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getNetworkMcc$5(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null ? "" : getMcc(telephonyManager.getNetworkOperator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getNetworkMnc$7(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null ? "" : getMnc(telephonyManager.getNetworkOperator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getOneUiVersion$3() {
        int oneUiVersionValue = getOneUiVersionValue();
        String str = (oneUiVersionValue / 10000) + Extension.DOT + ((oneUiVersionValue / 100) % 100) + Extension.DOT + (oneUiVersionValue % 100);
        logger.m12934i("One UI version : " + str);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$getOneUiVersionValue$2() {
        int systemProperties = getSystemProperties("ro.build.version.oneui", 0);
        if (systemProperties <= 0) {
            systemProperties = getSystemProperties("ro.build.version.sep", 0) - 90000;
        }
        return Integer.valueOf(systemProperties >= 0 ? systemProperties : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getSimMcc$6(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null ? "" : getMcc(telephonyManager.getSimOperator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getSimMnc$8(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return getMnc(telephonyManager.getSimOperator());
        }
        logger.m12932e(" : getSimMnc() : The telephonyManager is null.");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getSsdid$1(Context context) {
        Object systemService = context.getSystemService("sem_ssdid");
        for (Method method : systemService.getClass().getDeclaredMethods()) {
            if (method.getName().equals("getSsdid")) {
                method.setAccessible(true);
                return (String) method.invoke(systemService, null);
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getSystemProperties$14(String str) throws ClassNotFoundException {
        Class<?> cls = Class.forName("android.os.SystemProperties");
        return (String) cls.getMethod("get", String.class).invoke(cls, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$getSystemProperties$15(String str, int i) {
        return Integer.valueOf(Integer.parseInt(getSystemProperties(str, Integer.toString(i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getWatchDeviceName$11() {
        return BluetoothAdapter.getDefaultAdapter().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$isDoMode$17(Context context) {
        return Boolean.valueOf(((DevicePolicyManager) context.getSystemService("device_policy")).semGetDeviceOwner() != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$isPoMode$16(Context context) {
        return Boolean.valueOf(((UserManager) context.getSystemService(IdentityApiContract.Token.USER)).semIsManagedProfile());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$0(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), SharedPreferencesConstants.COMPOSER_SP_KEY_ANDROID_ID);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getSystemProperties(String str, int i) {
        return ((Integer) FaultBarrier.get(new C4148a(str, i, 7), Integer.valueOf(i), true).obj).intValue();
    }
}
