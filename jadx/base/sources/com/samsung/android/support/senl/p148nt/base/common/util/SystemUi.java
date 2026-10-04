package com.samsung.android.support.senl.p148nt.base.common.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.ColorInt;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\"\u0010\u000e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\rJ\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0007J\u001c\u0010\u0013\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0002J\u001a\u0010\u000e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0007J\u001a\u0010\u0014\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\n\u001a\u00020\u000bJ\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\rJ\u001a\u0010\u0017\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\rH\u0007J\u001a\u0010\u0019\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\rH\u0007J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/SystemUi;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "setStatusBarTheme", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "color", "", "isLightTheme", "", "setNavigationBarTheme", "setWindowBackgroundColor", "window", "Landroid/view/Window;", "lightTheme", "setStatusBarColor", "setNavigationBarColor", "setNavigationBarContrastEnforced", "value", "setImmersiveModeEnable", "enabled", "setHideStatusBarModeEnable", "addSystemUiVisibility", "visibility", "clearSystemUiVisibility", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SystemUi {

    @NotNull
    public static final SystemUi INSTANCE = new SystemUi();

    @NotNull
    private static final String TAG = "SystemUi";

    private SystemUi() {
    }

    private final void addSystemUiVisibility(Window window, int visibility) {
        try {
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | visibility);
        } catch (Exception e) {
            Logger.m8698e(TAG, "addSystemUiVisibility [" + visibility + "] failed e=" + e.getMessage());
        }
    }

    private final void clearSystemUiVisibility(Window window, int visibility) {
        try {
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (~visibility));
        } catch (Exception e) {
            Logger.m8698e(TAG, "clearSystemUiVisibility [" + visibility + "] failed e=" + e.getMessage());
        }
    }

    @JvmStatic
    public static final void setHideStatusBarModeEnable(@Nullable Activity activity, boolean enabled) {
        if (activity == null) {
            return;
        }
        if (enabled) {
            activity.getWindow().addFlags(1024);
        } else {
            activity.getWindow().clearFlags(1024);
        }
    }

    @JvmStatic
    public static final void setImmersiveModeEnable(@Nullable Activity activity, boolean enabled) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        if (enabled) {
            SystemUi systemUi = INSTANCE;
            Intrinsics.checkNotNull(window);
            systemUi.addSystemUiVisibility(window, 2054);
        } else {
            SystemUi systemUi2 = INSTANCE;
            Intrinsics.checkNotNull(window);
            systemUi2.clearSystemUiVisibility(window, 2054);
        }
    }

    @JvmStatic
    public static final void setNavigationBarTheme(@Nullable Activity activity, int color, boolean isLightTheme) {
        if (activity != null) {
            SystemUi systemUi = INSTANCE;
            systemUi.setNavigationBarColor(activity, color);
            systemUi.setNavigationBarTheme(activity, isLightTheme);
        }
    }

    @JvmStatic
    public static final void setStatusBarColor(@Nullable Activity activity, @ColorInt int color) {
        if (activity != null) {
            SystemUi systemUi = INSTANCE;
            Window window = activity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            systemUi.setStatusBarColor(window, color);
        }
    }

    @JvmStatic
    public static final void setStatusBarTheme(@Nullable Activity activity, int color, boolean isLightTheme) {
        if (activity != null) {
            setStatusBarColor(activity, color);
            INSTANCE.setStatusBarTheme(activity, isLightTheme);
        }
    }

    @JvmStatic
    public static final void setWindowBackgroundColor(@NotNull Window window, int color) {
        Intrinsics.checkNotNullParameter(window, "window");
        try {
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
            decorView.setBackgroundColor(color);
        } catch (Exception e) {
            AbstractC4539a.m3214x("setWindowBackgroundColor failed e=", e.getMessage(), TAG);
        }
    }

    public final void setNavigationBarColor(@Nullable Activity activity, @ColorInt int color) {
        if (activity != null) {
            Window window = activity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            setNavigationBarColor(window, color);
        }
    }

    public final void setNavigationBarContrastEnforced(@NotNull Window window, boolean value) {
        Intrinsics.checkNotNullParameter(window, "window");
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                window.setNavigationBarContrastEnforced(value);
            }
        } catch (Exception e) {
            AbstractC4539a.m3214x("setNavigationBarContrastEnforced failed e=", e.getMessage(), TAG);
        }
    }

    private final void setStatusBarColor(Window window, @ColorInt int color) {
        try {
            window.setStatusBarColor(color);
        } catch (Exception e) {
            AbstractC4539a.m3214x("setStatusBarColor failed e=", e.getMessage(), TAG);
        }
    }

    public final void setNavigationBarColor(@NotNull Window window, @ColorInt int color) {
        Intrinsics.checkNotNullParameter(window, "window");
        try {
            window.setNavigationBarColor(color);
        } catch (Exception e) {
            AbstractC4539a.m3214x("setNavigationBarColor failed e=", e.getMessage(), TAG);
        }
    }

    private final void setNavigationBarTheme(Activity activity, boolean lightTheme) {
        if (activity != null) {
            Window window = activity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            setNavigationBarTheme(window, lightTheme);
        }
    }

    public final void setStatusBarTheme(@Nullable Activity activity, boolean lightTheme) {
        if (activity != null) {
            Window window = activity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            setStatusBarTheme(window, lightTheme);
        }
    }

    @JvmStatic
    public static final void setNavigationBarTheme(@NotNull Window window, boolean lightTheme) {
        Intrinsics.checkNotNullParameter(window, "window");
        if (lightTheme) {
            INSTANCE.addSystemUiVisibility(window, 16);
        } else {
            INSTANCE.clearSystemUiVisibility(window, 16);
        }
    }

    @JvmStatic
    public static final void setStatusBarTheme(@NotNull Window window, boolean lightTheme) {
        Intrinsics.checkNotNullParameter(window, "window");
        if (lightTheme) {
            INSTANCE.addSystemUiVisibility(window, 8192);
        } else {
            INSTANCE.clearSystemUiVisibility(window, 8192);
        }
    }
}
