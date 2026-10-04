package com.samsung.android.support.senl.p148nt.base.common.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.RestrictionsManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.samsung.android.feature.SemFloatingFeature;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.support.senl.p145cm.base.common.util.ConvertUtil;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.emergencymode.EmergencyManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSamsungAccountManager;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.view.SemWindowManager;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0007J\b\u0010\u000e\u001a\u00020\fH\u0007J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\b\u0010\u0013\u001a\u00020\fH\u0007J\b\u0010\u0014\u001a\u00020\fH\u0007J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010\u0018\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010\u0019\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\b\u0010\u001a\u001a\u00020\fH\u0007J\b\u0010\u001b\u001a\u00020\fH\u0007J\b\u0010\u001c\u001a\u00020\fH\u0007J\u0010\u0010!\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\"\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\b\u0010#\u001a\u00020\fH\u0007J\u0010\u0010$\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0012\u0010%\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010&\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010'\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010(\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010)\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010*\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010+\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u000e\u0010,\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u00100\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\u0007H\u0007J\b\u0010H\u001a\u00020IH\u0007J\"\u0010L\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010M\u001a\u0004\u0018\u00010\u00052\u0006\u0010N\u001a\u00020\u0005H\u0007J\u0018\u0010O\u001a\u00020I2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\tH\u0007J\u0018\u0010S\u001a\u00020I2\u0006\u0010T\u001a\u00020U2\u0006\u0010R\u001a\u00020\tH\u0002J \u0010V\u001a\u0012\u0012\u0004\u0012\u00020X0Wj\b\u0012\u0004\u0012\u00020X`Y2\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010Z\u001a\u00020\f2\u0006\u0010[\u001a\u00020\u0011H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010 R\u0012\u0010-\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010.R\u000e\u0010/\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\u0002028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u000e\u00108\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020<X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010?\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010@R\u001a\u0010A\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u0010\u0003\u001a\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020<8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0014\u0010J\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010K¨\u0006\\"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/DeviceUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mIsSpenModel", "", "DISPLAY_FREQUENCY_60HZ", "", "DISPLAY_FREQUENCY_DEFAULT", "isSpenModel", "", "isTabletModel", "isPhoneModel", "isSepModel", "context", "Landroid/content/Context;", "isSepLiteModel", "isOldSepLiteModel", "isUnpackDevice", "mIsShopDemoDevice", "mIsAiShopDemoDevice", "isShopDemoDevice", "isAiShopDemoDevice", "isDemoDevice", "isFoldableModel", "isDeviceFolded", "isLargeCoverScreen", "subModelName", "getSubModelName$annotations", "getSubModelName", "()Ljava/lang/String;", "getDeviceName", "getEncodedDeviceName", "isSupportedFileProvider", "isSupportedAccount", "isSupportedLock", "isSupportedSetLockPassword", "getDeviceSyncError", "isSyncEnabledInDoMode", "isSupportedSync", "isSupportedHandWritingRecognition", "isPowerManageMode", "isPopupNoteSupported", "mIsSepMainSignature", "Ljava/lang/Boolean;", "PKG_SEP_SHA_HASH", "isSepMainSignature", "sRamSizeKb", "", "totalRamSizeKb", "getTotalRamSizeKb", "()J", "isRamSizeBelowOf", "ramGB", "DEVICE_RAM_LEVEL_HIGH", "DEVICE_RAM_LEVEL_MID", "DEVICE_RAM_LEVEL_LOW", "DEVICE_RAM_LEVEL_HIGH_THRESHOLD", "", "DEVICE_RAM_LEVEL_LOW_THRESHOLD", "SCREEN_SIZE_FULL_HD", "sMemoryLevel", "Ljava/lang/Integer;", "deviceMemoryLevel", "getDeviceMemoryLevel$annotations", "getDeviceMemoryLevel", "()I", "screenResolution", "getScreenResolution", "()D", "resetDeviceMemoryLevel", "", "isForcedMIDLevelDevice", "()Z", "verifySignatureNoHash", "packageName", "signatureString", "updatePreferredDisplayMode", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "frameRate", "setPreferredDisplayRefreshRate", "window", "Landroid/view/Window;", "getAllowedDisplayMode", "Ljava/util/ArrayList;", "Landroid/view/Display$Mode;", "Lkotlin/collections/ArrayList;", "isPowerSavingMode", StateHandler.KEY_APP_STATE, "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDeviceUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceUtils.kt\ncom/samsung/android/support/senl/nt/base/common/util/DeviceUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,596:1\n1#2:597\n*E\n"})
public final class DeviceUtils {
    public static final int DEVICE_RAM_LEVEL_HIGH = 2;
    private static final double DEVICE_RAM_LEVEL_HIGH_THRESHOLD = 3.7d;
    private static final int DEVICE_RAM_LEVEL_LOW = 0;
    private static final double DEVICE_RAM_LEVEL_LOW_THRESHOLD = 2.5d;
    public static final int DEVICE_RAM_LEVEL_MID = 1;
    public static final float DISPLAY_FREQUENCY_60HZ = 60.0f;
    public static final float DISPLAY_FREQUENCY_DEFAULT = 0.0f;

    @NotNull
    private static final String PKG_SEP_SHA_HASH = "9CA5170F381919DFE0446FCDAB18B19A143B3163";
    private static final int SCREEN_SIZE_FULL_HD = 2073600;

    @NotNull
    private static final String TAG = "DeviceUtils";

    @Nullable
    private static Boolean mIsSepMainSignature;

    @Nullable
    private static Integer sMemoryLevel;
    private static long sRamSizeKb;

    @NotNull
    public static final DeviceUtils INSTANCE = new DeviceUtils();
    private static int mIsSpenModel = -1;
    private static int mIsShopDemoDevice = -1;
    private static int mIsAiShopDemoDevice = -1;

    private DeviceUtils() {
    }

    private final ArrayList<Display.Mode> getAllowedDisplayMode(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        LoggerBase.INSTANCE.m7137i(TAG, "current refresh rate : " + ((int) defaultDisplay.getRefreshRate()) + "Hz");
        Display.Mode mode = defaultDisplay.getMode();
        Display.Mode[] supportedModes = defaultDisplay.getSupportedModes();
        ArrayList<Display.Mode> arrayList = new ArrayList<>();
        if (supportedModes != null) {
            Iterator it = ArrayIteratorKt.iterator(supportedModes);
            while (it.hasNext()) {
                Display.Mode mode2 = (Display.Mode) it.next();
                if (mode.getPhysicalWidth() == mode2.getPhysicalWidth() && mode.getPhysicalHeight() == mode2.getPhysicalHeight()) {
                    arrayList.add(mode2);
                } else {
                    LoggerBase.INSTANCE.m7132d(TAG, "getRequestedMode skipping mode, mode=" + mode2);
                }
            }
        }
        return arrayList;
    }

    public static final int getDeviceMemoryLevel() {
        if (sMemoryLevel == null) {
            DeviceUtils deviceUtils = INSTANCE;
            long totalRamSizeKb = deviceUtils.getTotalRamSizeKb();
            if (totalRamSizeKb == 0) {
                Logger.m8702i(TAG, "fail to get RAM size");
                sMemoryLevel = numValueOf;
                Intrinsics.checkNotNull(numValueOf);
                return numValueOf.intValue();
            }
            int i = ((int) totalRamSizeKb) >> 20;
            double dCbrt = Math.cbrt(deviceUtils.getScreenResolution() / ((double) SCREEN_SIZE_FULL_HD));
            double d = ((double) i) / dCbrt;
            Logger.m8702i(TAG, "MEM = " + i + "GB  / " + dCbrt + " = " + d);
            numValueOf = d < DEVICE_RAM_LEVEL_HIGH_THRESHOLD ? d >= DEVICE_RAM_LEVEL_LOW_THRESHOLD ? 1 : Integer.valueOf(deviceUtils.isForcedMIDLevelDevice() ? 1 : 0) : 2;
            sMemoryLevel = numValueOf;
            Logger.m8702i(TAG, "Memory Level = " + numValueOf);
        }
        Integer num = sMemoryLevel;
        Intrinsics.checkNotNull(num);
        return num.intValue();
    }

    @JvmStatic
    public static /* synthetic */ void getDeviceMemoryLevel$annotations() {
    }

    @JvmStatic
    public static final int getDeviceSyncError(@Nullable Context context) {
        if (SystemPropertiesCompat.INSTANCE.getInstance().isNationalDisasterNet()) {
            Debugger.INSTANCE.m8627i(TAG, "getDeviceSyncError : false <- National disaster net!");
            return 109;
        }
        if (!INSTANCE.isSupportedAccount(context)) {
            Debugger.INSTANCE.m8627i(TAG, "getDeviceSyncError : false <- No account package!");
            return 105;
        }
        if (isUnpackDevice()) {
            Debugger.INSTANCE.m8627i(TAG, "getDeviceSyncError : false <- Unpack device!");
            return 110;
        }
        if (SettingsCompat.INSTANCE.getInstance().isRDUModel(context)) {
            Debugger.INSTANCE.m8627i(TAG, "getDeviceSyncError : false <- RDU device!");
            return 111;
        }
        if (UserHandleCompat.INSTANCE.getInstance().isKnoxMode() && !isSyncEnabledInDoMode(context)) {
            Debugger.INSTANCE.m8627i(TAG, "getDeviceSyncError : false <- Knox Mode!");
            return 112;
        }
        if (isPowerManageMode(context)) {
            Debugger.INSTANCE.m8627i(TAG, "getDeviceSyncError : false <- Power Manage Mode!");
            return 113;
        }
        if (!FloatingFeature.INSTANCE.getInstance().isDisableRecycleBinModel()) {
            return 0;
        }
        Debugger.INSTANCE.m8627i(TAG, "getDeviceSyncError : false <- Disable Recycle Bin Model!");
        return 123;
    }

    @JvmStatic
    @NotNull
    public static final String getEncodedDeviceName(@Nullable Context context) {
        String deviceName;
        if (context != null) {
            try {
                deviceName = INSTANCE.getDeviceName(context);
            } catch (Exception unused) {
                return "Unknown";
            }
        } else {
            deviceName = null;
        }
        return Base64Utils.encodeBase64(deviceName);
    }

    private final double getScreenResolution() {
        double mainScreenResolution = DisplayUtils.getMainScreenResolution();
        if (mainScreenResolution != 0.0d) {
            return mainScreenResolution;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext != null) {
            DisplayUtils.init(applicationContext);
        }
        return DisplayUtils.getMainScreenResolution();
    }

    @NotNull
    public static final String getSubModelName() {
        StringBuilder sb = new StringBuilder();
        SystemPropertiesCompat.Companion companion = SystemPropertiesCompat.INSTANCE;
        if (companion.getInstance().isJapanModel()) {
            sb.append(companion.getInstance().getFactoryName());
        }
        if (sb.length() == 0) {
            sb.append(DeviceInfo.getModelName());
        }
        for (int length = sb.length(); length < 6; length++) {
            sb.append('@');
        }
        String strSubstring = sb.substring(3);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    @JvmStatic
    public static /* synthetic */ void getSubModelName$annotations() {
    }

    private final long getTotalRamSizeKb() {
        long j = sRamSizeKb;
        if (j != 0) {
            return j;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        Object systemService = applicationContext != null ? applicationContext.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY) : null;
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null) {
            return sRamSizeKb;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j2 = memoryInfo.totalMem >> 10;
        sRamSizeKb = j2;
        return j2;
    }

    @JvmStatic
    public static final boolean isAiShopDemoDevice(@Nullable Context context) {
        if (mIsAiShopDemoDevice == -1 && context != null) {
            mIsAiShopDemoDevice = (SystemPropertiesCompat.INSTANCE.getInstance().isLDUModel() || (SettingsCompat.INSTANCE.getInstance().isRDUModel(context) && !(TextUtils.isEmpty(Settings.Global.getString(context.getContentResolver(), "SRM_storeId")) && TextUtils.isEmpty(Settings.Global.getString(context.getContentResolver(), "SRM_channelId"))))) ? 1 : 0;
        }
        return mIsAiShopDemoDevice == 1;
    }

    @JvmStatic
    public static final boolean isDemoDevice(@Nullable Context context) {
        return isUnpackDevice() || isShopDemoDevice(context);
    }

    @JvmStatic
    public static final boolean isDeviceFolded() {
        try {
            SemWindowManager semWindowManager = SemWindowManager.getInstance();
            if (semWindowManager != null) {
                return semWindowManager.isFolded();
            }
            return false;
        } catch (NoClassDefFoundError e) {
            LoggerBase.INSTANCE.m7133e(TAG, "FoldStateListener, NoSuchMethodError: " + e);
            return false;
        } catch (NoSuchMethodError e2) {
            LoggerBase.INSTANCE.m7133e(TAG, "FoldStateListener, NoSuchMethodError: " + e2);
            return false;
        }
    }

    @JvmStatic
    public static final boolean isFoldableModel() {
        return FloatingFeature.INSTANCE.getInstance().getBoolean("SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FOLD");
    }

    private final boolean isForcedMIDLevelDevice() {
        return StringsKt.m14145S(getSubModelName(), "T73");
    }

    @JvmStatic
    public static final boolean isLargeCoverScreen() {
        try {
            return SemFloatingFeature.getInstance().getBoolean("SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_LARGE_COVER_SCREEN");
        } catch (Exception e) {
            LoggerBase.INSTANCE.m7133e(TAG, "Exception: " + e);
            return false;
        }
    }

    @JvmStatic
    public static final boolean isOldSepLiteModel() {
        return PackageManagerCompat.INSTANCE.getInstance().isOldSepLiteModel();
    }

    @JvmStatic
    public static final boolean isPhoneModel() {
        return SystemPropertiesCompat.INSTANCE.getInstance().getDeviceType() == SystemPropertiesCompat.DeviceType.phone;
    }

    @JvmStatic
    public static final boolean isPowerManageMode(@Nullable Context context) {
        if ((context == null || !SettingsCompat.INSTANCE.getInstance().isUPSM(context)) && !EmergencyManagerCompat.INSTANCE.getInstance().isEmergencyMode(context)) {
            return false;
        }
        Debugger.INSTANCE.m8627i(TAG, "Power manage mode enabled!");
        return true;
    }

    @JvmStatic
    public static final boolean isPowerSavingMode(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        return Settings.Global.getInt(appContext.getContentResolver(), "low_power", 0) == 1;
    }

    @JvmStatic
    public static final boolean isRamSizeBelowOf(int ramGB) {
        long totalRamSizeKb = INSTANCE.getTotalRamSizeKb();
        if (totalRamSizeKb != 0) {
            return ((int) (totalRamSizeKb / ((long) 1000000))) < ramGB;
        }
        Logger.m8702i(TAG, "fail to get RAM size, return false");
        return false;
    }

    @JvmStatic
    public static final boolean isSepLiteModel(@Nullable Context context) {
        return PackageManagerCompat.INSTANCE.getInstance().isSepLiteModel(context);
    }

    @JvmStatic
    public static final boolean isSepMainSignature(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Boolean bool = mIsSepMainSignature;
        if (bool != null) {
            Intrinsics.checkNotNull(bool);
            return bool.booleanValue();
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            LoggerBase.INSTANCE.m7133e(TAG, "isSepMainSigning() : appContext is null!");
            return false;
        }
        try {
            PackageInfo packageInfo = applicationContext.getApplicationContext().getPackageManager().getPackageInfo(applicationContext.getApplicationContext().getPackageName(), 64);
            if ((packageInfo != null ? packageInfo.signatures : null) != null) {
                Signature[] signatureArr = packageInfo.signatures;
                Intrinsics.checkNotNull(signatureArr);
                for (Signature signature : signatureArr) {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                    messageDigest.update(signature.toByteArray());
                    byte[] bArrDigest = messageDigest.digest();
                    Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
                    if (Intrinsics.areEqual(PKG_SEP_SHA_HASH, ConvertUtil.bytesToHex(bArrDigest))) {
                        mIsSepMainSignature = Boolean.TRUE;
                        return true;
                    }
                }
            }
            mIsSepMainSignature = Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException e) {
            LoggerBase.INSTANCE.m7133e(TAG, e.getMessage());
        } catch (NoSuchAlgorithmException e2) {
            AbstractC0000a.m23t("SIGNATURE ERROR ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
        }
        return false;
    }

    @JvmStatic
    public static final boolean isSepModel(@Nullable Context context) {
        return !isSepLiteModel(context);
    }

    @JvmStatic
    public static final boolean isShopDemoDevice(@Nullable Context context) {
        if (mIsShopDemoDevice == -1) {
            mIsShopDemoDevice = (SystemPropertiesCompat.INSTANCE.getInstance().isLDUModel() || SettingsCompat.INSTANCE.getInstance().isRDUModel(context)) ? 1 : 0;
        }
        return mIsShopDemoDevice == 1;
    }

    @JvmStatic
    public static final boolean isSpenModel() {
        if (mIsSpenModel == -1) {
            mIsSpenModel = (new Spen().isFeatureEnabled(0) || FloatingFeature.INSTANCE.getInstance().getInt("SEC_FLOATING_FEATURE_FRAMEWORK_CONFIG_SPEN_VERSION", -1) > 0) ? 1 : 0;
        }
        return mIsSpenModel == 1;
    }

    @JvmStatic
    public static final boolean isSupportedFileProvider() {
        return DeviceInfo.isVSTModel() || DeviceInfo.getSemPlatformVersionInt(0) >= 80500;
    }

    @JvmStatic
    public static final boolean isSupportedHandWritingRecognition(@Nullable Context context) {
        if (isPowerManageMode(context)) {
            Debugger.INSTANCE.m8619d(TAG, "isSupportedHandWritingRecognition is not supported!");
            return false;
        }
        if (!isPowerManageMode(context) && (Build.VERSION.SDK_INT >= 36 || isSpenModel() || ModelFeature.getFeature().getIsQ7Device())) {
            return true;
        }
        Debugger.INSTANCE.m8619d(TAG, "HandWritingRecognition is not supported!");
        return false;
    }

    @JvmStatic
    public static final boolean isSupportedLock(@Nullable Context context) {
        return (isDemoDevice(context) || !INSTANCE.isSupportedAccount(context) || RequestToSamsungAccountManager.INSTANCE.isB2BAccount()) ? false : true;
    }

    @JvmStatic
    public static final boolean isSupportedSetLockPassword(@Nullable Context context) {
        return isSupportedLock(context);
    }

    @JvmStatic
    public static final boolean isSupportedSync(@Nullable Context context) {
        return getDeviceSyncError(context) == 0;
    }

    @JvmStatic
    public static final boolean isSyncEnabledInDoMode(@Nullable Context context) {
        Object systemService = context != null ? context.getSystemService("restrictions") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.RestrictionsManager");
        Bundle applicationRestrictions = ((RestrictionsManager) systemService).getApplicationRestrictions();
        return ((applicationRestrictions == null || !applicationRestrictions.containsKey("allowNoteSync")) ? 0 : applicationRestrictions.getInt("allowNoteSync")) != 0;
    }

    @JvmStatic
    public static final boolean isTabletModel() {
        return SystemPropertiesCompat.INSTANCE.getInstance().getDeviceType() == SystemPropertiesCompat.DeviceType.tablet;
    }

    @JvmStatic
    public static final boolean isUnpackDevice() {
        return FloatingFeature.INSTANCE.getInstance().getBoolean("SEC_FLOATING_FEATURE_COMMON_SUPPORT_UNPACK");
    }

    @JvmStatic
    public static final void resetDeviceMemoryLevel() {
        sMemoryLevel = null;
    }

    private final void setPreferredDisplayRefreshRate(Window window, float frameRate) {
        LoggerBase.INSTANCE.m7137i(TAG, "setPreferredDisplayRefreshRate# frameRate: " + frameRate);
        try {
            Field field = WindowManager.LayoutParams.class.getField("preferredMinDisplayRefreshRate");
            Field field2 = WindowManager.LayoutParams.class.getField("preferredMaxDisplayRefreshRate");
            WindowManager.LayoutParams attributes = window.getAttributes();
            field.setFloat(attributes, frameRate);
            field2.setFloat(attributes, frameRate);
            window.setAttributes(attributes);
        } catch (IllegalAccessException e) {
            LoggerBase.INSTANCE.m7133e(TAG, e.toString());
        } catch (NoSuchFieldException e2) {
            LoggerBase.INSTANCE.m7133e(TAG, e2.toString());
        }
    }

    @JvmStatic
    public static final void updatePreferredDisplayMode(@NotNull Activity activity, float frameRate) {
        Display.Mode mode;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        Iterator<Display.Mode> it = INSTANCE.getAllowedDisplayMode(activity).iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (true) {
            if (!it.hasNext()) {
                mode = null;
                break;
            }
            Display.Mode next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            mode = next;
            if (((int) mode.getRefreshRate()) == ((int) frameRate)) {
                LoggerBase.INSTANCE.m7137i(TAG, "set preferred display mode " + mode);
                break;
            }
        }
        if (mode == null) {
            window.getAttributes().preferredDisplayModeId = 0;
            DeviceUtils deviceUtils = INSTANCE;
            Intrinsics.checkNotNull(window);
            deviceUtils.setPreferredDisplayRefreshRate(window, 0.0f);
            return;
        }
        window.getAttributes().preferredDisplayModeId = mode.getModeId();
        DeviceUtils deviceUtils2 = INSTANCE;
        Intrinsics.checkNotNull(window);
        deviceUtils2.setPreferredDisplayRefreshRate(window, frameRate);
    }

    @JvmStatic
    public static final boolean verifySignatureNoHash(@NotNull Context context, @Nullable String packageName, @NotNull String signatureString) {
        PackageInfo packageInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(signatureString, "signatureString");
        if (TextUtils.isEmpty(signatureString)) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            LoggerBase.INSTANCE.m7133e(TAG, "isSepMainSigning() : appContext is null!");
            return false;
        }
        PackageManager packageManager = applicationContext.getPackageManager();
        if (packageName != null) {
            try {
                packageInfo = packageManager.getPackageInfo(packageName, 64);
            } catch (PackageManager.NameNotFoundException e) {
                LoggerBase.INSTANCE.m7133e(TAG, e.getMessage());
            }
        } else {
            packageInfo = null;
        }
        if ((packageInfo != null ? packageInfo.signatures : null) != null) {
            Signature[] signatureArr = packageInfo.signatures;
            Intrinsics.checkNotNull(signatureArr);
            for (Signature signature : signatureArr) {
                if (!Intrinsics.areEqual(signatureString, signature.toCharsString())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Nullable
    public final String getDeviceName(@NotNull Context context) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            string = Settings.Global.getString(context.getContentResolver(), "device_name");
        } catch (Exception unused) {
            string = null;
        }
        return TextUtils.isEmpty(string) ? Build.MODEL : string;
    }

    public final boolean isPopupNoteSupported(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DesktopModeCompat.Companion companion = DesktopModeCompat.INSTANCE;
        if (!companion.getInstance().isDexDualModeConnected(context) && !companion.getInstance().isDexTouchpadEnabled(context)) {
            return true;
        }
        Debugger.INSTANCE.m8619d(TAG, "PopupNote is not supported!");
        return false;
    }

    public final boolean isSupportedAccount(@Nullable Context context) {
        return !DeviceInfo.isOtherCorpDevice() && CommonUtils.hasSamsungAccountPackage(context);
    }
}
