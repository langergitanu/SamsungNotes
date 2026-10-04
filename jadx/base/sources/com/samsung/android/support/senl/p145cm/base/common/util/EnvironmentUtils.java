package com.samsung.android.support.senl.p145cm.base.common.util;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\fH\u0007J\b\u0010\u0014\u001a\u00020\u0011H\u0002R\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\r\u0010\u000f¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/EnvironmentUtils;", "", "<init>", "()V", "isRunningUnderKnox", "", "context", "Landroid/content/Context;", "isRunningUnderAndroidForWork", "mLaboratoryMode", "Ljava/lang/Boolean;", "LABS_ENABLED_PREF_KEY", "", "isRunningLaboratoryMode", "isRunningLaboratoryMode$annotations", "()Z", "setLaboratoryMode", "", "enable", "key", "updateLaboratoryMode", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class EnvironmentUtils {

    @NotNull
    public static final EnvironmentUtils INSTANCE = new EnvironmentUtils();

    @NotNull
    private static final String LABS_ENABLED_PREF_KEY = "ss_labs_enabled";

    @Nullable
    private static Boolean mLaboratoryMode;

    private EnvironmentUtils() {
    }

    public static final boolean isRunningLaboratoryMode() {
        INSTANCE.updateLaboratoryMode();
        Boolean bool = mLaboratoryMode;
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    @JvmStatic
    public static final boolean isRunningUnderAndroidForWork(@Nullable Context context) {
        DevicePolicyManager devicePolicyManager;
        List<ComponentName> activeAdmins;
        if (context != null && (devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy")) != null && (activeAdmins = devicePolicyManager.getActiveAdmins()) != null) {
            Iterator<ComponentName> it = activeAdmins.iterator();
            while (it.hasNext()) {
                if (devicePolicyManager.isProfileOwnerApp(it.next().getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean isRunningUnderKnox(@Nullable Context context) {
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        Intrinsics.checkNotNull(packageName);
        return StringsKt.m14145S(packageName, "sec_container_");
    }

    @JvmStatic
    public static final void setLaboratoryMode(boolean enable, @NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual("dDxo#DEo(Ea#lo^isExdGL@AX!@dov$u*gDW)-+FGx", key)) {
            SharedPreferencesCompat.INSTANCE.getInstance().putBoolean(LABS_ENABLED_PREF_KEY, enable);
            mLaboratoryMode = Boolean.valueOf(enable);
        }
    }

    private final void updateLaboratoryMode() {
        if (mLaboratoryMode == null) {
            mLaboratoryMode = Boolean.valueOf(SharedPreferencesCompat.INSTANCE.getInstance().getBoolean(LABS_ENABLED_PREF_KEY, false));
        }
    }

    @JvmStatic
    public static /* synthetic */ void isRunningLaboratoryMode$annotations() {
    }
}
