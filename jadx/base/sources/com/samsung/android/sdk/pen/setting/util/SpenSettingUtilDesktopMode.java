package com.samsung.android.sdk.pen.setting.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilDesktopMode;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "FLAG_EXTERNAL_DESKTOP_WINDOWING", "", "isDesktopMode", "", "context", "Landroid/content/Context;", "getFontScale", "", "hasDesktopWindowingOnExternalDisplay", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingUtilDesktopMode {
    private static final int FLAG_EXTERNAL_DESKTOP_WINDOWING = 131072;

    @NotNull
    public static final SpenSettingUtilDesktopMode INSTANCE = new SpenSettingUtilDesktopMode();

    @NotNull
    private static final String TAG = "SpenSettingUtilDesktopMode";

    private SpenSettingUtilDesktopMode() {
    }

    @JvmStatic
    public static final float getFontScale(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getConfiguration().fontScale;
    }

    @JvmStatic
    private static final boolean hasDesktopWindowingOnExternalDisplay(Context context) {
        if (context != null && Build.VERSION.SDK_INT >= 30) {
            if (!(context instanceof Activity)) {
                Log.d(TAG, "hasDesktopWindowingOnExternalDisplay. not activity context");
                return false;
            }
            Display display = ((Activity) context).getDisplay();
            Intrinsics.checkNotNullExpressionValue(display, "getDisplay(...)");
            if (display.getDisplayId() != 0 && display.getDisplayId() != -1 && (display.getFlags() & 131072) != 0) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean isDesktopMode(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT < 30 ? SpenConfiguration.INSTANCE.isDesktopMode(context) : hasDesktopWindowingOnExternalDisplay(context);
    }
}
