package com.samsung.android.sdk.pen.view;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.AbstractC0622a;
import com.samsung.android.spen.libwrapper.DesktopModeManagerWrapper;
import com.samsung.android.spen.libwrapper.DesktopModeStateWrapper;
import com.samsung.android.spen.libwrapper.FloatingFeatureWrapper;
import com.samsung.android.spen.libwrapper.SettingsSystemWrapper;
import com.samsung.android.spen.libwrapper.SystemPropertiesWrapper;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0017\u001a\u00020\u0018R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/SpenConfiguration;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "", "nativeHandle", "getNativeHandle", "()J", HandoffConstant.KEY_DEVICE_TYPE, "", "getDeviceType", "()I", "setDeviceType", "(I)V", "deviceUXType", "getDeviceUXType", "setDeviceUXType", "dexMode", "getDexMode", "setDexMode", "close", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenConfiguration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenConfiguration.kt\ncom/samsung/android/sdk/pen/view/SpenConfiguration\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,428:1\n1#2:429\n*E\n"})
public final class SpenConfiguration {
    public static final int AI_CONFIG_VERSION_20251 = 20251;
    public static final int AI_CONFIG_VERSION_20253 = 20253;

    @NotNull
    private static final String CONFIG_AI_VERSION = "SEC_FLOATING_FEATURE_COMMON_CONFIG_AI_VERSION";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEVICE_TYPE_FOLD = 2;
    public static final int DEVICE_TYPE_PHONE = 0;
    public static final int DEVICE_TYPE_TABLET = 1;
    public static final int DEVICE_UX_TYPE_PHONE = 0;
    public static final int DEVICE_UX_TYPE_TABLET = 1;
    public static final int DEX_MODE_DUAL = 1;
    public static final int DEX_MODE_NEW_DEX = 3;
    public static final int DEX_MODE_NONE = 0;
    public static final int DEX_MODE_STANDALONE = 2;

    @NotNull
    private static final String FOLD_DEVICE_FEATURE_Q = "SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_WM_CONTROLS_DISPLAY_SWITCH";

    @NotNull
    private static final String FOLD_DEVICE_FEATURE_R_UP = "SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FOLD";
    public static final int ONE_UI_8_0 = 80000;
    public static final int ONE_UI_NONE = 0;
    private static final int R_OS_VERSION_CODES = 30;

    @NotNull
    private static final String TAG = "SpenConfiguration";
    private int deviceType;
    private int deviceUXType;
    private int dexMode;
    private long nativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0005H\u0003J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0012\u0010 \u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0012\u0010!\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0007J\u0012\u0010&\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0012\u0010'\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0012\u0010(\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0012\u0010)\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0012\u0010*\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0012\u0010+\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0019\u0010,\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\u0019H\u0007J!\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0083 J\u0011\u00104\u001a\u0002052\u0006\u00106\u001a\u000200H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u00067"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/SpenConfiguration$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "R_OS_VERSION_CODES", "", "FOLD_DEVICE_FEATURE_Q", "FOLD_DEVICE_FEATURE_R_UP", "CONFIG_AI_VERSION", "DEVICE_TYPE_PHONE", "DEVICE_TYPE_TABLET", "DEVICE_TYPE_FOLD", "DEVICE_UX_TYPE_PHONE", "DEVICE_UX_TYPE_TABLET", "DEX_MODE_NONE", "DEX_MODE_DUAL", "DEX_MODE_STANDALONE", "DEX_MODE_NEW_DEX", "ONE_UI_NONE", "ONE_UI_8_0", "AI_CONFIG_VERSION_20251", "AI_CONFIG_VERSION_20253", "isTabletDevice", "", "context", "Landroid/content/Context;", "isVSTDevice", "isSystemBuildCharacteristicsContaining", "value", "isTabletUX", "isFoldDevice", "isChromeBook", "isMainDisplay", "configuration", "Landroid/content/res/Configuration;", "isSubDisplay", "isDesktopMode", "isDexStandAloneMode", "isDexDualMode", "isNewDexMode", "isSystemDarkMode", "getOneUiVersion", "getConfigAiVersion", "(Landroid/content/Context;)Ljava/lang/Integer;", "isLandscapeQuirk", "Native_init", "", HandoffConstant.KEY_DEVICE_TYPE, "deviceUXType", "dexMode", "Native_finalize", "", "handle", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long handle) {
            SpenConfiguration.Native_finalize(handle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(int deviceType, int deviceUXType, int dexMode) {
            return SpenConfiguration.Native_init(deviceType, deviceUXType, dexMode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean isSystemBuildCharacteristicsContaining(Context context, String value) {
            try {
                String str = SystemPropertiesWrapper.create(context).get("ro.build.characteristics");
                if (str == null) {
                    return false;
                }
                Log.d(SpenConfiguration.TAG, "buildCharacteristics : " + str + " value : " + value);
                return StringsKt.m14162r(str, value);
            } catch (PlatformException unused) {
                return false;
            }
        }

        @JvmStatic
        @Nullable
        public final Integer getConfigAiVersion(@Nullable Context context) {
            try {
                return Integer.valueOf(FloatingFeatureWrapper.create(context).getInt(SpenConfiguration.CONFIG_AI_VERSION));
            } catch (PlatformException e) {
                Log.e(SpenConfiguration.TAG, "getConfigAiVersion exception: " + e);
                return null;
            }
        }

        @JvmStatic
        public final int getOneUiVersion(@Nullable Context context) {
            try {
                String str = SystemPropertiesWrapper.create(context).get("ro.build.version.oneui");
                Intrinsics.checkNotNullExpressionValue(str, "get(...)");
                return Integer.parseInt(str);
            } catch (PlatformException e) {
                Log.e(SpenConfiguration.TAG, "getOneUiVersion PlatformException: " + e);
                return 0;
            } catch (NumberFormatException e2) {
                Log.e(SpenConfiguration.TAG, "getOneUiVersion NumberFormatException: " + e2);
                return 0;
            }
        }

        @JvmStatic
        public final boolean isChromeBook(@Nullable Context context) {
            PackageManager packageManager;
            if (context == null || (packageManager = context.getPackageManager()) == null) {
                return false;
            }
            return packageManager.hasSystemFeature("org.chromium.arc.device_management");
        }

        @JvmStatic
        public final boolean isDesktopMode(@Nullable Context context) {
            try {
                return DesktopModeManagerWrapper.create(context).isDesktopMode();
            } catch (PlatformException unused) {
                return false;
            }
        }

        @JvmStatic
        public final boolean isDexDualMode(@Nullable Context context) {
            try {
                DesktopModeStateWrapper desktopModeStateWrapperCreate = DesktopModeStateWrapper.create(context);
                boolean z = true;
                boolean z2 = desktopModeStateWrapperCreate.getEnabled() == desktopModeStateWrapperCreate.getEnabledConstant();
                int displayType = desktopModeStateWrapperCreate.getDisplayType();
                if (!z2 || displayType != desktopModeStateWrapperCreate.getDisplayTypeDualConstant()) {
                    z = false;
                }
                Log.d(SpenConfiguration.TAG, "isDexDualMode: isEnabled=" + z2 + ", isDualMode=" + z);
                return z;
            } catch (PlatformException e) {
                Log.e(SpenConfiguration.TAG, "isDexDualMode exception: " + e);
                return false;
            }
        }

        @JvmStatic
        public final boolean isDexStandAloneMode(@Nullable Context context) {
            try {
                DesktopModeStateWrapper desktopModeStateWrapperCreate = DesktopModeStateWrapper.create(context);
                boolean z = true;
                boolean z2 = desktopModeStateWrapperCreate.getEnabled() == desktopModeStateWrapperCreate.getEnabledConstant();
                int displayType = desktopModeStateWrapperCreate.getDisplayType();
                if (!z2 || displayType != desktopModeStateWrapperCreate.getDisplayTypeStandaloneConstant()) {
                    z = false;
                }
                Log.d(SpenConfiguration.TAG, "isDexStandAloneMode: isEnabled=" + z2 + ", isStandaloneMode=" + z);
                return z;
            } catch (PlatformException e) {
                Log.e(SpenConfiguration.TAG, "isDexStandAloneMode exception: " + e);
                return false;
            }
        }

        @JvmStatic
        public final boolean isFoldDevice(@Nullable Context context) {
            try {
                return FloatingFeatureWrapper.create(context).getBoolean(Build.VERSION.SDK_INT >= 30 ? SpenConfiguration.FOLD_DEVICE_FEATURE_R_UP : SpenConfiguration.FOLD_DEVICE_FEATURE_Q);
            } catch (PlatformException unused) {
                String str = Build.MODEL;
                if (TextUtils.isEmpty(str) || str.length() < 7) {
                    return false;
                }
                Intrinsics.checkNotNull(str);
                String strSubstring = str.substring(3);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                char cCharAt = strSubstring.charAt(0);
                if (cCharAt != 'F') {
                    if (cCharAt != 'W' || !StringsKt.m14145S(strSubstring, "W20")) {
                        return false;
                    }
                } else if (!StringsKt.m14145S(strSubstring, "F90") && !StringsKt.m14145S(strSubstring, "F91") && !StringsKt.m14145S(strSubstring, "F92") && !StringsKt.m14145S(strSubstring, "F93")) {
                    return false;
                }
                return true;
            }
        }

        @JvmStatic
        public final boolean isLandscapeQuirk() {
            String str = Build.MODEL;
            if (TextUtils.isEmpty(str) || str.length() < 7) {
                return false;
            }
            Intrinsics.checkNotNull(str);
            String strSubstring = str.substring(3);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            return StringsKt.m14145S(strSubstring, "F968");
        }

        @JvmStatic
        public final boolean isMainDisplay(@NotNull Configuration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            return configuration.semDisplayDeviceType == 0;
        }

        @JvmStatic
        public final boolean isNewDexMode(@Nullable Context context) {
            if (context == null) {
                return false;
            }
            return SettingsSystemWrapper.create(context).getIntForUser(context.getContentResolver(), "new_dex", 0, SettingsSystemWrapper.USER_OWNER) == 1;
        }

        @JvmStatic
        public final boolean isSubDisplay(@NotNull Configuration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            return configuration.semDisplayDeviceType == 5;
        }

        @JvmStatic
        public final boolean isSystemDarkMode(@Nullable Context context) {
            Resources resources;
            Configuration configuration;
            return (((context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) ? -1 : configuration.uiMode) & 48) == 32;
        }

        @JvmStatic
        public final boolean isTabletDevice(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return isSystemBuildCharacteristicsContaining(context, "tablet");
        }

        @JvmStatic
        public final boolean isTabletUX(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return isTabletDevice(context) || isFoldDevice(context) || isChromeBook(context) || isVSTDevice(context);
        }

        @JvmStatic
        public final boolean isVSTDevice(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return isSystemBuildCharacteristicsContaining(context, "HMD");
        }

        private Companion() {
        }
    }

    public SpenConfiguration(@Nullable Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context must be not null");
        }
        Companion companion = INSTANCE;
        int i = companion.isTabletDevice(context) ? 1 : companion.isFoldDevice(context) ? 2 : 0;
        this.deviceType = i;
        this.deviceUXType = (i == 1 || i == 2) ? 1 : 0;
        int i2 = companion.isDesktopMode(context) ? companion.isDexStandAloneMode(context) ? 2 : companion.isNewDexMode(context) ? 3 : 1 : 0;
        this.dexMode = i2;
        AbstractC0000a.m26w(AbstractC0622a.m1173s(this.deviceType, this.deviceUXType, "SpenConfiguration deviceType=", ", deviceUXType=", ", dexMode="), TAG, i2);
        this.nativeHandle = companion.Native_init(this.deviceType, this.deviceUXType, this.dexMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(int i, int i2, int i4);

    @JvmStatic
    @Nullable
    public static final Integer getConfigAiVersion(@Nullable Context context) {
        return INSTANCE.getConfigAiVersion(context);
    }

    @JvmStatic
    public static final int getOneUiVersion(@Nullable Context context) {
        return INSTANCE.getOneUiVersion(context);
    }

    @JvmStatic
    public static final boolean isChromeBook(@Nullable Context context) {
        return INSTANCE.isChromeBook(context);
    }

    @JvmStatic
    public static final boolean isDesktopMode(@Nullable Context context) {
        return INSTANCE.isDesktopMode(context);
    }

    @JvmStatic
    public static final boolean isDexDualMode(@Nullable Context context) {
        return INSTANCE.isDexDualMode(context);
    }

    @JvmStatic
    public static final boolean isDexStandAloneMode(@Nullable Context context) {
        return INSTANCE.isDexStandAloneMode(context);
    }

    @JvmStatic
    public static final boolean isFoldDevice(@Nullable Context context) {
        return INSTANCE.isFoldDevice(context);
    }

    @JvmStatic
    public static final boolean isLandscapeQuirk() {
        return INSTANCE.isLandscapeQuirk();
    }

    @JvmStatic
    public static final boolean isMainDisplay(@NotNull Configuration configuration) {
        return INSTANCE.isMainDisplay(configuration);
    }

    @JvmStatic
    public static final boolean isNewDexMode(@Nullable Context context) {
        return INSTANCE.isNewDexMode(context);
    }

    @JvmStatic
    public static final boolean isSubDisplay(@NotNull Configuration configuration) {
        return INSTANCE.isSubDisplay(configuration);
    }

    @JvmStatic
    private static final boolean isSystemBuildCharacteristicsContaining(Context context, String str) {
        return INSTANCE.isSystemBuildCharacteristicsContaining(context, str);
    }

    @JvmStatic
    public static final boolean isSystemDarkMode(@Nullable Context context) {
        return INSTANCE.isSystemDarkMode(context);
    }

    @JvmStatic
    public static final boolean isTabletDevice(@NotNull Context context) {
        return INSTANCE.isTabletDevice(context);
    }

    @JvmStatic
    public static final boolean isTabletUX(@NotNull Context context) {
        return INSTANCE.isTabletUX(context);
    }

    @JvmStatic
    public static final boolean isVSTDevice(@NotNull Context context) {
        return INSTANCE.isVSTDevice(context);
    }

    public final void close() {
        long j = this.nativeHandle;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
            this.nativeHandle = 0L;
        }
    }

    public final int getDeviceType() {
        return this.deviceType;
    }

    public final int getDeviceUXType() {
        return this.deviceUXType;
    }

    public final int getDexMode() {
        return this.dexMode;
    }

    public final long getNativeHandle() {
        return this.nativeHandle;
    }

    public final void setDeviceType(int i) {
        this.deviceType = i;
    }

    public final void setDeviceUXType(int i) {
        this.deviceUXType = i;
    }

    public final void setDexMode(int i) {
        this.dexMode = i;
    }
}
