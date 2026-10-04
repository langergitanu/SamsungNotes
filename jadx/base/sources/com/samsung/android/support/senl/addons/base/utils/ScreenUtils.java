package com.samsung.android.support.senl.addons.base.utils;

import android.app.Activity;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/utils/ScreenUtils;", "", "<init>", "()V", "getWindowType", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "getRotationType", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScreenUtils {

    @NotNull
    public static final ScreenUtils INSTANCE = new ScreenUtils();

    private ScreenUtils() {
    }

    @JvmStatic
    public static final int getRotationType(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return activity.getWindowManager().getDefaultDisplay().getRotation();
    }

    @JvmStatic
    public static final int getWindowType(@Nullable Activity activity) {
        int multiWindowMode = WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(activity);
        if (DesktopModeCompat.INSTANCE.getInstance().isDexMode(activity)) {
            return 1024;
        }
        return multiWindowMode;
    }
}
