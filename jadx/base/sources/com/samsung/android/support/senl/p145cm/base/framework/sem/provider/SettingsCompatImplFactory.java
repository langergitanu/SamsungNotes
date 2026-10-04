package com.samsung.android.support.senl.p145cm.base.framework.sem.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.UserHandle;
import android.provider.Settings;
import com.samsung.android.knox.SemPersonaManager;
import com.samsung.android.support.senl.p145cm.base.framework.observer.SettingsContentObserver;
import com.samsung.android.support.senl.p145cm.base.framework.sem.provider.AbsSettingsCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/provider/SettingsCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/provider/AbsSettingsCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/provider/AbsSettingsCompatImplFactory$ISettingsCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "SettingsDelegateSemImpl", "SettingsCompatSdlImpl", "AbsSettingsCompatImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsCompatImplFactory extends AbsSettingsCompatImplFactory {

    @NotNull
    private static final String TAG = "SettingsCompatImpl";

    @NotNull
    public static final String UPSM_MODE_KEY = "ultra_powersaving_mode";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\"\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/provider/SettingsCompatImplFactory$AbsSettingsCompatImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/provider/AbsSettingsCompatImplFactory$ISettingsCompatImpl;", "<init>", "()V", "getMinimalBatteryUse", "", "context", "Landroid/content/Context;", "easyModeUri", "Landroid/net/Uri;", "getEasyModeUri", "()Landroid/net/Uri;", "getEasyMode", "getGlobalFontSize", "registerUPSMChangeCallback", "", "settingsContentChangedCallback", "Lcom/samsung/android/support/senl/cm/base/framework/observer/SettingsContentObserver$SettingsContentChangedCallback;", "unregisterUPSMChangeCallback", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static abstract class AbsSettingsCompatImpl implements AbsSettingsCompatImplFactory.ISettingsCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        public int getEasyMode(@Nullable Context context) {
            return Settings.System.getInt(context != null ? context.getContentResolver() : null, "easy_mode_switch", 0);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        @NotNull
        public Uri getEasyModeUri() {
            Uri uriFor = Settings.System.getUriFor("easy_mode_switch");
            Intrinsics.checkNotNullExpressionValue(uriFor, "getUriFor(...)");
            return uriFor;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        public int getGlobalFontSize(@Nullable Context context) {
            return Settings.Global.getInt(context != null ? context.getContentResolver() : null, "font_size", 0);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        public int getMinimalBatteryUse(@Nullable Context context) {
            return Settings.System.getInt(context != null ? context.getContentResolver() : null, "minimal_battery_use", 0);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        public boolean registerUPSMChangeCallback(@Nullable SettingsContentObserver.SettingsContentChangedCallback settingsContentChangedCallback) {
            if (Build.VERSION.SDK_INT <= 29) {
                return false;
            }
            LoggerBase.INSTANCE.m7137i(SettingsCompatImplFactory.TAG, "registerUPSMChangeCallback# ");
            return SettingsContentObserver.INSTANCE.getInstance().addSettingsContentChangedCallback(settingsContentChangedCallback, "minimal_battery_use", 0);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        public boolean unregisterUPSMChangeCallback(@Nullable SettingsContentObserver.SettingsContentChangedCallback settingsContentChangedCallback) {
            if (Build.VERSION.SDK_INT <= 29) {
                return false;
            }
            LoggerBase.INSTANCE.m7137i(SettingsCompatImplFactory.TAG, "unregisterUPSMChangeCallback# ");
            return SettingsContentObserver.INSTANCE.getInstance().removeSettingsContentChangedCallback(settingsContentChangedCallback);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/provider/SettingsCompatImplFactory$SettingsCompatSdlImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/provider/SettingsCompatImplFactory$AbsSettingsCompatImpl;", "<init>", "()V", "getPenDetachOption", "", "context", "Landroid/content/Context;", "getPenUsageDetected", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SettingsCompatSdlImpl extends AbsSettingsCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        public int getPenDetachOption(@Nullable Context context) {
            return Settings.System.getInt(context != null ? context.getContentResolver() : null, "pen_detachment_option", 0);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        public int getPenUsageDetected(@Nullable Context context) {
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/provider/SettingsCompatImplFactory$SettingsDelegateSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/provider/SettingsCompatImplFactory$AbsSettingsCompatImpl;", "<init>", "()V", "getPenDetachOption", "", "context", "Landroid/content/Context;", "getPenUsageDetected", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SettingsDelegateSemImpl extends AbsSettingsCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        public int getPenDetachOption(@Nullable Context context) {
            if (context != null) {
                try {
                    return Settings.System.semGetIntForUser(context.getContentResolver(), "pen_detachment_option", 0, -2);
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("getPenDetachOption: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, SettingsCompatImplFactory.TAG);
                }
            }
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        public int getPenUsageDetected(@Nullable Context context) {
            try {
                int iSemGetMyUserId = UserHandle.semGetMyUserId();
                if (SemPersonaManager.isSecureFolderId(iSemGetMyUserId) || SemPersonaManager.isKnoxId(iSemGetMyUserId)) {
                    iSemGetMyUserId = 0;
                }
                if (context != null) {
                    return Settings.System.semGetIntForUser(context.getContentResolver(), "pen_usage_detected", 0, iSemGetMyUserId);
                }
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("getPenUsageDetected: e ", e.getMessage(), LoggerBase.INSTANCE, SettingsCompatImplFactory.TAG);
            } catch (SecurityException e2) {
                AbstractC0000a.m23t("getPenUsageDetected: e ", e2.getMessage(), LoggerBase.INSTANCE, SettingsCompatImplFactory.TAG);
            }
            return 0;
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.provider.AbsSettingsCompatImplFactory
    @NotNull
    public AbsSettingsCompatImplFactory.ISettingsCompatImpl create(int deviceType) {
        return deviceType != 2 ? deviceType != 3 ? super.create(deviceType) : new SettingsCompatSdlImpl() : new SettingsDelegateSemImpl();
    }
}
