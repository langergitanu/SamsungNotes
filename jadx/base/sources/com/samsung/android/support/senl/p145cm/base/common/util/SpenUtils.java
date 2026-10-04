package com.samsung.android.support.senl.p145cm.base.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.provider.Settings;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\t\u0010\u000b¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/SpenUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SETTINGS_SPEN_ACTIVATED", "isSpenActivated", "", "isBundledSpenSupported", "isBundledSpenSupported$annotations", "()Z", "isSupportedSpenDisplay", "newConfig", "Landroid/content/res/Configuration;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenUtils {

    @NotNull
    public static final SpenUtils INSTANCE = new SpenUtils();

    @NotNull
    public static final String SETTINGS_SPEN_ACTIVATED = "pen_digitizer_enabled";

    @NotNull
    private static final String TAG = "SpenUtils";

    private SpenUtils() {
    }

    public static final boolean isBundledSpenSupported() {
        if (StringsKt.m14162r(FloatingFeature.INSTANCE.getInstance().getString("SEC_FLOATING_FEATURE_FRAMEWORK_CONFIG_SPEN_GARAGE_SPEC"), "bundled=false")) {
            return false;
        }
        LoggerBase.INSTANCE.m7137i(TAG, "isBundledSpenSupported true ");
        return true;
    }

    @JvmStatic
    public static final boolean isSpenActivated() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (Settings.System.getInt(applicationContext != null ? applicationContext.getContentResolver() : null, SETTINGS_SPEN_ACTIVATED, 1) == 0) {
            return false;
        }
        int penUsageDetected = SettingsCompat.INSTANCE.getInstance().getPenUsageDetected(applicationContext);
        LoggerBase.INSTANCE.m7137i(TAG, "isSpenActivated : " + penUsageDetected);
        return penUsageDetected == 1 || isBundledSpenSupported();
    }

    @JvmStatic
    public static final boolean isSupportedSpenDisplay(@Nullable Configuration newConfig) {
        if (!DisplayDeviceTypeCompat.INSTANCE.getInstance().isSubDisplay(newConfig)) {
            return true;
        }
        LoggerBase.INSTANCE.m7137i(TAG, "isSupportedSpenDisplay false ");
        return false;
    }

    @JvmStatic
    public static final boolean isSupportedSpenDisplay(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return isSupportedSpenDisplay(activity.getResources().getConfiguration());
    }

    @JvmStatic
    public static /* synthetic */ void isBundledSpenSupported$annotations() {
    }
}
