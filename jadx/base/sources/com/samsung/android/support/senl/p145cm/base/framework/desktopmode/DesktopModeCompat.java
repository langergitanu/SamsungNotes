package com.samsung.android.support.senl.p145cm.base.framework.desktopmode;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import com.samsung.android.settings.search.provider.SecSearchIndexablesContract;
import com.samsung.android.support.senl.p145cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.desktopmode.DesktopModeCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0014\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0015\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0016\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0017\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0018\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0019\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\u001b\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/desktopmode/DesktopModeCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/AbsDesktopModeCompatImplFactory$IDesktopModeCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/AbsDesktopModeCompatImplFactory$IDesktopModeCompatImpl;)V", SecSearchIndexablesContract.ExtraInfo.EXTRA_KEY_DEX_MODE, "", "context", "Landroid/content/Context;", "getScreenLocation", "", "isDexModeType", "type", "isDexTouchpadEnabled", "defaultValue", "", "getDexFontScale", "", "defaultFontScale", "isDexDualModeOnDevice", "isDexDualModeOnScreen", "isDexDualModeConnected", "isDexStandAloneMode", "isDexNewDexMode", "isNotDexModeOrStandAloneMode", "isConnectedDoP", "isSupportedWindowingMode", "DOPConnectionState", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DesktopModeCompat {

    @NotNull
    private static final String CALL_METHOD_GET = "getSettings";
    public static final int DEX_DUAL_MODE = 36864;
    public static final int DEX_NEW_DEX_MODE = 40960;
    public static final int DEX_OFF_MODE = 0;
    public static final int DEX_ON_DEVICE = 512;
    public static final int DEX_ON_MODE = 32768;
    public static final int DEX_ON_SCREEN = 256;
    public static final int DEX_STAND_ALONE_MODE = 32768;

    @NotNull
    private static final String TAG = "DesktopModeCompat";

    @Nullable
    private static DesktopModeCompat mInstance;

    @NotNull
    private final AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl mImpl;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static final Uri CONTENT_URI = Uri.parse("content://0@com.sec.android.desktopmode.uiservice.SettingsProvider/settings");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/desktopmode/DesktopModeCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DEX_OFF_MODE", "", "DEX_ON_MODE", "DEX_STAND_ALONE_MODE", "DEX_NEW_DEX_MODE", "DEX_DUAL_MODE", "DEX_ON_SCREEN", "DEX_ON_DEVICE", "CONTENT_URI", "Landroid/net/Uri;", "CALL_METHOD_GET", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/desktopmode/DesktopModeCompat;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/desktopmode/DesktopModeCompat;", DesktopModeCompat.CALL_METHOD_GET, "resolver", "Landroid/content/ContentResolver;", "key", "defaultValue", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nDesktopModeCompat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DesktopModeCompat.kt\ncom/samsung/android/support/senl/cm/base/framework/desktopmode/DesktopModeCompat$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,150:1\n1#2:151\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getSettings(ContentResolver resolver, String key, String defaultValue) {
            Bundle bundle = new Bundle(2);
            bundle.putString("key", key);
            bundle.putString(HWToolbarSAConstants.DETAIL_COLOR_DEFINED, defaultValue);
            try {
                Uri uri = DesktopModeCompat.CONTENT_URI;
                Bundle bundleCall = uri != null ? resolver.call(uri, DesktopModeCompat.CALL_METHOD_GET, (String) null, bundle) : null;
                if (bundleCall != null) {
                    return bundleCall.getString(key);
                }
            } catch (IllegalArgumentException e) {
                LoggerBase.INSTANCE.m7134e(DesktopModeCompat.TAG, "Failed to get settings", e);
            }
            LoggerBase.INSTANCE.m7132d(DesktopModeCompat.TAG, "getSettings. " + defaultValue);
            return defaultValue;
        }

        @NotNull
        public final synchronized DesktopModeCompat getInstance() {
            DesktopModeCompat desktopModeCompat;
            try {
                if (DesktopModeCompat.mInstance == null) {
                    DesktopModeCompat.mInstance = new DesktopModeCompat(new DesktopModeCompatImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                desktopModeCompat = DesktopModeCompat.mInstance;
                Intrinsics.checkNotNull(desktopModeCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.desktopmode.DesktopModeCompat");
            } catch (Throwable th) {
                throw th;
            }
            return desktopModeCompat;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/desktopmode/DesktopModeCompat$DOPConnectionState;", "", "<init>", "()V", "SETTING_SOURCE_CONNECT_DEXONPC", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DOPConnectionState {

        @NotNull
        public static final DOPConnectionState INSTANCE = new DOPConnectionState();
        public static final int SETTING_SOURCE_CONNECT_DEXONPC = 3;

        private DOPConnectionState() {
        }
    }

    public /* synthetic */ DesktopModeCompat(AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl iDesktopModeCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iDesktopModeCompatImpl);
    }

    private final int getScreenLocation(Context context) {
        return this.mImpl.getScreenLocation(context);
    }

    private final boolean isDexModeType(Context context, int type) {
        return this.mImpl.isDexModeType(context, type);
    }

    public final float getDexFontScale(@NotNull Context context, float defaultFontScale) {
        Intrinsics.checkNotNullParameter(context, "context");
        Companion companion = INSTANCE;
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        String settings = companion.getSettings(contentResolver, "font_scale", String.valueOf(defaultFontScale));
        Float fValueOf = settings != null ? Float.valueOf(Float.parseFloat(settings)) : null;
        Intrinsics.checkNotNull(fValueOf);
        return fValueOf.floatValue();
    }

    public final boolean isConnectedDoP(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return Settings.System.getInt(context.getContentResolver(), "dexonpc_connection_state", 0) == 3;
        } catch (NoSuchMethodError e) {
            AbstractC0000a.m23t("isConnectedDop: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            return false;
        }
    }

    public final boolean isDexDualModeConnected(@Nullable Context context) {
        return isDexModeType(context, 36864);
    }

    public final boolean isDexDualModeOnDevice(@Nullable Context context) {
        return getScreenLocation(context) == 512;
    }

    public final boolean isDexDualModeOnScreen(@Nullable Context context) {
        return getScreenLocation(context) == 256;
    }

    public final boolean isDexMode(@Nullable Context context) {
        return this.mImpl.isDexMode(context);
    }

    public final boolean isDexNewDexMode(@Nullable Context context) {
        return isDexModeType(context, 40960);
    }

    public final boolean isDexStandAloneMode(@Nullable Context context) {
        return isDexModeType(context, 32768) || isDexModeType(context, 40960);
    }

    public final boolean isDexTouchpadEnabled(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return isDexTouchpadEnabled(context, "false");
    }

    public final boolean isNotDexModeOrStandAloneMode(@Nullable Context context) {
        return !isDexMode(context) || isDexStandAloneMode(context);
    }

    public final boolean isSupportedWindowingMode() {
        return this.mImpl.isSupportedWindowingMode();
    }

    private DesktopModeCompat(AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl iDesktopModeCompatImpl) {
        this.mImpl = iDesktopModeCompatImpl;
    }

    public final boolean isDexTouchpadEnabled(@NotNull Context context, @NotNull String defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (isDexModeType(context, 0)) {
            return false;
        }
        Companion companion = INSTANCE;
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        return Intrinsics.areEqual("true", companion.getSettings(contentResolver, "touchpad_enabled", defaultValue));
    }
}
