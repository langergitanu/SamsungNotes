package com.samsung.android.support.senl.p145cm.base.framework.sem.provider;

import android.content.Context;
import android.net.Uri;
import com.samsung.android.support.senl.p145cm.base.framework.observer.SettingsContentObserver;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/provider/AbsSettingsCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/provider/AbsSettingsCompatImplFactory$ISettingsCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "ISettingsCompatImpl", "SettingsDelegatePureImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsSettingsCompatImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/provider/AbsSettingsCompatImplFactory$ISettingsCompatImpl;", "", "getPenDetachOption", "", "context", "Landroid/content/Context;", "getPenUsageDetected", "getMinimalBatteryUse", "easyModeUri", "Landroid/net/Uri;", "getEasyModeUri", "()Landroid/net/Uri;", "getEasyMode", "getGlobalFontSize", "registerUPSMChangeCallback", "", "settingsContentChangedCallback", "Lcom/samsung/android/support/senl/cm/base/framework/observer/SettingsContentObserver$SettingsContentChangedCallback;", "unregisterUPSMChangeCallback", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ISettingsCompatImpl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @NotNull
        public static final String PEN_DETACHMENT_OPTION = "pen_detachment_option";
        public static final int PEN_DETECTED_DEF = 0;

        @NotNull
        public static final String PEN_USAGE_DETECTED = "pen_usage_detected";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/provider/AbsSettingsCompatImplFactory$ISettingsCompatImpl$Companion;", "", "<init>", "()V", "PEN_DETACHMENT_OPTION", "", "PEN_USAGE_DETECTED", "PEN_DETECTED_DEF", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @NotNull
            public static final String PEN_DETACHMENT_OPTION = "pen_detachment_option";
            public static final int PEN_DETECTED_DEF = 0;

            @NotNull
            public static final String PEN_USAGE_DETECTED = "pen_usage_detected";

            private Companion() {
            }
        }

        int getEasyMode(@Nullable Context context);

        @Nullable
        Uri getEasyModeUri();

        int getGlobalFontSize(@Nullable Context context);

        int getMinimalBatteryUse(@Nullable Context context);

        int getPenDetachOption(@Nullable Context context);

        int getPenUsageDetected(@Nullable Context context);

        boolean registerUPSMChangeCallback(@Nullable SettingsContentObserver.SettingsContentChangedCallback settingsContentChangedCallback);

        boolean unregisterUPSMChangeCallback(@Nullable SettingsContentObserver.SettingsContentChangedCallback settingsContentChangedCallback);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/provider/AbsSettingsCompatImplFactory$SettingsDelegatePureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/provider/AbsSettingsCompatImplFactory$ISettingsCompatImpl;", "<init>", "()V", "getPenDetachOption", "", "context", "Landroid/content/Context;", "getPenUsageDetected", "getMinimalBatteryUse", "easyModeUri", "Landroid/net/Uri;", "getEasyModeUri", "()Landroid/net/Uri;", "getEasyMode", "getGlobalFontSize", "registerUPSMChangeCallback", "", "settingsContentChangedCallback", "Lcom/samsung/android/support/senl/cm/base/framework/observer/SettingsContentObserver$SettingsContentChangedCallback;", "unregisterUPSMChangeCallback", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class SettingsDelegatePureImpl implements ISettingsCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        public int getEasyMode(@Nullable Context context) {
            return 1;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        @Nullable
        public Uri getEasyModeUri() {
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        public int getGlobalFontSize(@Nullable Context context) {
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        public int getMinimalBatteryUse(@Nullable Context context) {
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        public int getPenDetachOption(@Nullable Context context) {
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        public int getPenUsageDetected(@Nullable Context context) {
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        public boolean registerUPSMChangeCallback(@Nullable SettingsContentObserver.SettingsContentChangedCallback settingsContentChangedCallback) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.provider.AbsSettingsCompatImplFactory.ISettingsCompatImpl
        public boolean unregisterUPSMChangeCallback(@Nullable SettingsContentObserver.SettingsContentChangedCallback settingsContentChangedCallback) {
            return false;
        }
    }

    @NotNull
    public ISettingsCompatImpl create(int deviceType) {
        return new SettingsDelegatePureImpl();
    }
}
