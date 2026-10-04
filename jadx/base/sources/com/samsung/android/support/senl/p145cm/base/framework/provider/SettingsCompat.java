package com.samsung.android.support.senl.p145cm.base.framework.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import com.samsung.android.sesl.visualeffect.utils.DeviceSettingsUtil;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.observer.SettingsContentObserver;
import com.samsung.android.support.senl.p145cm.base.framework.sem.provider.AbsSettingsCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.provider.SettingsCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BOOLEAN;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0011\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0012\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0014\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0018\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0019\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u001b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u001c\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u001d\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010 \u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010!\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\"\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010#\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010$\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010'J\u0010\u0010(\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/provider/SettingsCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/provider/AbsSettingsCompatImplFactory$ISettingsCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/provider/AbsSettingsCompatImplFactory$ISettingsCompatImpl;)V", "getPenDetachOption", "", "context", "Landroid/content/Context;", "getPenUsageDetected", "isUPSM", "", "easyModeUri", "Landroid/net/Uri;", "getEasyModeUri", "()Landroid/net/Uri;", "getEasyMode", "getGlobalFontSize", "mIsRDUModel", "isRDUModel", "isShowImeWithHardKeyboardEnabled", "Lcom/samsung/android/support/senl/cm/base/framework/support/BOOLEAN;", "isShowImeWithHardKeyboardEnabledForDex", "isScreenOffMemoEnabled", "isAirViewSettingEnabled", "checkSetupWizardDone", "isShowButtonBackground", "isHideNavigationMode", "hasGestureNavigationBar", "getAndroidDeviceId", "", "isHighTextContrastEnabled", "isAccessibilityAnimationDisabled", "isRemoveAnimation", "isAutoBlocking", "isAutoBlockingAdvanced", "registerUPSMChangeCallback", "settingsContentChangedCallback", "Lcom/samsung/android/support/senl/cm/base/framework/observer/SettingsContentObserver$SettingsContentChangedCallback;", "unregisterUPSMChangeCallback", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String NAVIGATION_MODE = "navigation_mode";

    @NotNull
    private static final String RETAIL_PACKAGE_NAME = "com.samsung.rms.retailagent.global";

    @NotNull
    private static final String SETTINGS_GESTURE_NAVIGATION_BAR = "navigation_bar_gesture_while_hidden";

    @NotNull
    private static final String TAG = "SettingsCompat";

    @NotNull
    private static final String UPSM_MODE_KEY = "ultra_powersaving_mode";

    @Nullable
    private static SettingsCompat mInstance;

    @NotNull
    private final AbsSettingsCompatImplFactory.ISettingsCompatImpl mImpl;
    private int mIsRDUModel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/provider/SettingsCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SETTINGS_GESTURE_NAVIGATION_BAR", "NAVIGATION_MODE", "UPSM_MODE_KEY", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/provider/SettingsCompat;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/provider/SettingsCompat;", "getTestInstance", "type", "", "RETAIL_PACKAGE_NAME", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized SettingsCompat getInstance() {
            SettingsCompat settingsCompat;
            try {
                if (SettingsCompat.mInstance == null) {
                    SettingsCompat.mInstance = new SettingsCompat(new SettingsCompatImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                settingsCompat = SettingsCompat.mInstance;
                Intrinsics.checkNotNull(settingsCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.provider.SettingsCompat");
            } catch (Throwable th) {
                throw th;
            }
            return settingsCompat;
        }

        @NotNull
        public final SettingsCompat getTestInstance(int type) {
            return new SettingsCompat(new SettingsCompatImplFactory().create(type), null);
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    public /* synthetic */ SettingsCompat(AbsSettingsCompatImplFactory.ISettingsCompatImpl iSettingsCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iSettingsCompatImpl);
    }

    @NotNull
    public static final synchronized SettingsCompat getInstance() {
        return INSTANCE.getInstance();
    }

    public final boolean checkSetupWizardDone(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            int i = Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0);
            LoggerBase.INSTANCE.m7132d(TAG, "checkSetupWizardDone, SetupWizard state = " + i);
            return 1 == i;
        } catch (Exception e) {
            AbstractC0000a.m23t("checkSetupWizardDone: Exception] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            return false;
        }
    }

    @NotNull
    public final String getAndroidDeviceId(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = Settings.Secure.getString(context.getContentResolver(), SharedPreferencesConstants.COMPOSER_SP_KEY_ANDROID_ID);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final int getEasyMode(@Nullable Context context) {
        return this.mImpl.getEasyMode(context);
    }

    @Nullable
    public final Uri getEasyModeUri() {
        return this.mImpl.getEasyModeUri();
    }

    public final int getGlobalFontSize(@Nullable Context context) {
        return this.mImpl.getGlobalFontSize(context);
    }

    public final int getPenDetachOption(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        return this.mImpl.getPenDetachOption(context);
    }

    public final int getPenUsageDetected(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        return this.mImpl.getPenUsageDetected(context);
    }

    public final boolean hasGestureNavigationBar(@Nullable Context context) {
        if (context != null) {
            return Settings.Global.getInt(context.getContentResolver(), SETTINGS_GESTURE_NAVIGATION_BAR, 0) > 0;
        }
        LoggerBase.INSTANCE.m7133e(TAG, "hasGestureNavigationBar, context is null");
        return false;
    }

    public final boolean isAccessibilityAnimationDisabled(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale") == 0.0f;
    }

    public final boolean isAirViewSettingEnabled(@Nullable Context context) {
        return (context == null || DeviceInfo.isOtherCorpDevice() || Settings.System.getInt(context.getContentResolver(), "pen_hovering", 0) == 0) ? false : true;
    }

    public final boolean isAutoBlocking(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Settings.Secure.getInt(context.getContentResolver(), "rampart_main_switch_enabled", 0) == 1;
    }

    public final boolean isAutoBlockingAdvanced(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Settings.Secure.getInt(context.getContentResolver(), "rampart_blocked_location_gallery", 0) == 1;
    }

    public final boolean isHideNavigationMode(@Nullable Context context) {
        int i;
        if (context == null) {
            return false;
        }
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), NAVIGATION_MODE, 0);
        } catch (IllegalArgumentException unused) {
            LoggerBase.INSTANCE.m7133e(TAG, "IllegalArgumentException Hide Navigation Mode");
            i = 0;
        }
        return i != 0;
    }

    public final boolean isHighTextContrastEnabled(@Nullable Context context) {
        return context != null && Settings.Secure.getInt(context.getContentResolver(), "high_text_contrast_enabled", 0) == 1;
    }

    public final boolean isRDUModel(@Nullable Context context) {
        if (this.mIsRDUModel == -1) {
            if (context == null || DeviceInfo.isOtherCorpDevice()) {
                return false;
            }
            this.mIsRDUModel = (PackageManagerCompat.INSTANCE.getInstance().isPackageInstalled(context, RETAIL_PACKAGE_NAME) && Settings.Secure.getInt(context.getContentResolver(), "shopdemo", 0) == 1) ? 1 : 0;
        }
        return this.mIsRDUModel == 1;
    }

    public final boolean isRemoveAnimation(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Settings.System.getInt(context.getContentResolver(), DeviceSettingsUtil.REDUCE_ANIMATION, 0) == 1;
    }

    public final boolean isScreenOffMemoEnabled(@Nullable Context context) {
        return (context == null || DeviceInfo.isOtherCorpDevice() || Settings.System.getInt(context.getContentResolver(), "screen_off_memo", 0) != 1) ? false : true;
    }

    public final boolean isShowButtonBackground(@Nullable Context context) {
        int i;
        if (context == null) {
            return false;
        }
        try {
            i = Settings.System.getInt(context.getContentResolver(), "show_button_background", 0);
        } catch (IllegalArgumentException unused) {
            LoggerBase.INSTANCE.m7133e(TAG, "IllegalArgumentException Show button background");
            i = 0;
        }
        return i != 0;
    }

    @Nullable
    public final BOOLEAN isShowImeWithHardKeyboardEnabled(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        try {
            boolean z = true;
            if (Settings.Secure.getInt(context.getContentResolver(), "show_ime_with_hard_keyboard") != 1) {
                z = false;
            }
            return new BOOLEAN(z);
        } catch (Settings.SettingNotFoundException e) {
            LoggerBase.INSTANCE.m7134e(TAG, e.getMessage(), e);
            return null;
        }
    }

    @Nullable
    public final BOOLEAN isShowImeWithHardKeyboardEnabledForDex(@Nullable Context context) {
        Bundle bundleCall;
        String string;
        if (context == null) {
            return null;
        }
        Bundle bundle = new Bundle(2);
        bundle.putString("key", "keyboard_dex");
        bundle.putString(HWToolbarSAConstants.DETAIL_COLOR_DEFINED, "0");
        try {
            bundleCall = context.getContentResolver().call(Uri.parse("content://0@com.sec.android.desktopmode.uiservice.SettingsProvider/settings"), "getSettings", (String) null, bundle);
        } catch (IllegalArgumentException e) {
            LoggerBase.INSTANCE.m7134e(TAG, "Failed to get settings", e);
        }
        if (bundleCall != null && (string = bundleCall.getString("keyboard_dex")) != null) {
            return new BOOLEAN(Intrinsics.areEqual("1", string));
        }
        LoggerBase.INSTANCE.m7132d(TAG, "isShowImeWithHardKeyboardEnabledForDex# fail");
        return null;
    }

    public final boolean isUPSM(@Nullable Context context) {
        int i;
        int minimalBatteryUse;
        if (context == null || DeviceInfo.isOtherCorpDevice()) {
            return false;
        }
        try {
            i = Settings.System.getInt(context.getContentResolver(), "ultra_powersaving_mode", 0);
        } catch (IllegalArgumentException unused) {
            i = 0;
        }
        try {
            minimalBatteryUse = this.mImpl.getMinimalBatteryUse(context);
        } catch (IllegalArgumentException unused2) {
            LoggerBase.INSTANCE.m7133e(TAG, "IllegalArgumentException UPSM");
            minimalBatteryUse = 0;
        }
        return i == 1 || minimalBatteryUse == 1;
    }

    public final boolean registerUPSMChangeCallback(@Nullable SettingsContentObserver.SettingsContentChangedCallback settingsContentChangedCallback) {
        return this.mImpl.registerUPSMChangeCallback(settingsContentChangedCallback);
    }

    public final boolean unregisterUPSMChangeCallback(@Nullable SettingsContentObserver.SettingsContentChangedCallback settingsContentChangedCallback) {
        return this.mImpl.unregisterUPSMChangeCallback(settingsContentChangedCallback);
    }

    private SettingsCompat(AbsSettingsCompatImplFactory.ISettingsCompatImpl iSettingsCompatImpl) {
        this.mImpl = iSettingsCompatImpl;
        this.mIsRDUModel = -1;
    }
}
