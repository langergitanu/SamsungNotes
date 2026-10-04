package com.samsung.android.support.senl.p148nt.composer.main.base.ftu.common;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FTULayoutUtil {
    public static boolean isAnimationEnable(Context context) {
        return (SettingsCompat.getInstance().isHighTextContrastEnabled(context) || SettingsCompat.getInstance().isAccessibilityAnimationDisabled(context)) ? false : true;
    }

    public static boolean isMultiWindow(WeakReference<Activity> weakReference) {
        if (weakReference == null || CommonUtil.isNotAvailableActivity(weakReference.get())) {
            return false;
        }
        return WindowManagerCompat.getInstance().isFreeFormWindow(weakReference.get()) || WindowManagerCompat.getInstance().isMultiWindowMode(weakReference.get()) || WindowManagerCompat.getInstance().isPairWindowingMode(weakReference.get());
    }

    public static boolean isOrientationLandscape(Resources resources) {
        return resources.getConfiguration().orientation == 2;
    }
}
