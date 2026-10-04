package com.samsung.android.support.senl.p148nt.base.composer.common;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import com.samsung.android.support.senl.p145cm.base.common.util.SpenUtils;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ComposerSpenUtils {
    public static boolean canUseSpen(Activity activity) {
        return canUseSpen(SpenUtils.isSupportedSpenDisplay(activity), DesktopModeCompat.INSTANCE.getInstance().isNotDexModeOrStandAloneMode(activity));
    }

    public static boolean isSpenActivated() {
        return DeviceUtils.isSpenModel() && SpenUtils.isSpenActivated();
    }

    public static boolean isSpenHoverListener(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "pen_hovering", 0) == 1;
    }

    public static boolean isSpenSupportChangeable() {
        return !SpenUtils.isBundledSpenSupported();
    }

    public static boolean canUseSpen(boolean z, boolean z2) {
        return z && z2 && isSpenActivated();
    }
}
