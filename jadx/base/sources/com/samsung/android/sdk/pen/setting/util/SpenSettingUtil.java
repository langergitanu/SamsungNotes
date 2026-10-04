package com.samsung.android.sdk.pen.setting.util;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.app.sdk.deepsky.common.AbstractC7019f;
import com.samsung.android.sdk.pen.util.color.SpenColorUtil;
import com.samsung.android.spen.libwrapper.ViewWrapper;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0007J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0007J\u001a\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0007J\u001a\u0010\u0015\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u0007H\u0007J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u001a\u0010\u0017\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u0007H\u0007J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u001a\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!H\u0007J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!H\u0007J\u0018\u0010\"\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0007H\u0007J\b\u0010$\u001a\u00020\u0005H\u0007J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002J \u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001eH\u0002J \u0010*\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001eH\u0002¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtil;", "", "<init>", "()V", "isAdaptiveColor", "", "color", "", "context", "Landroid/content/Context;", "isNightMode", "initDialogWindow", "", "dialog", "Landroid/app/Dialog;", "option", "height", "addSystemUiVisibility", "window", "Landroid/view/Window;", "visibility", "setWindowHeight", "getStatusBarHeight", "getColor", "id", "getPrimaryColor", "setShadowAlpha", "view", "Landroid/view/View;", "alpha", "", "HSVToColor", "hsvColor", "", "performHapticFeedback", "pattern", "needRecoilVI", "hasVibrator", "isAdaptiveColorInDayMode", "hue", "saturation", "value", "isAdaptiveColorInNightMode", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingUtil {

    @NotNull
    public static final SpenSettingUtil INSTANCE = new SpenSettingUtil();

    private SpenSettingUtil() {
    }

    @JvmStatic
    public static final int HSVToColor(@NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        return HSVToColor(255, hsvColor);
    }

    @JvmStatic
    public static final void addSystemUiVisibility(@Nullable Window window, int visibility) {
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView != null) {
            decorView.setSystemUiVisibility(visibility | decorView.getSystemUiVisibility());
        }
    }

    @JvmStatic
    public static final int getColor(@Nullable Context context, int id) {
        if (context != null) {
            return context.getColor(id);
        }
        return 0;
    }

    @JvmStatic
    public static final int getPrimaryColor(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        return typedValue.data;
    }

    @JvmStatic
    public static final int getStatusBarHeight(@Nullable Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", AbsExecuteBinding.TYPE_DIMEN, TelemetryEventStrings.C6439Os.OS_NAME)) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final boolean hasVibrator(Context context) {
        Vibrator defaultVibrator = null;
        if (Build.VERSION.SDK_INT >= 31) {
            Object systemService = context.getSystemService("vibrator_manager");
            VibratorManager vibratorManagerM5356j = AbstractC7019f.m5368v(systemService) ? AbstractC7019f.m5356j(systemService) : null;
            if (vibratorManagerM5356j != null) {
                defaultVibrator = vibratorManagerM5356j.getDefaultVibrator();
            }
        } else {
            Object systemService2 = context.getSystemService("vibrator");
            if (systemService2 instanceof Vibrator) {
                defaultVibrator = (Vibrator) systemService2;
            }
        }
        return defaultVibrator != null && defaultVibrator.hasVibrator();
    }

    @JvmStatic
    public static final void initDialogWindow(@NotNull Dialog dialog, int option, int height) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        addSystemUiVisibility(dialog.getWindow(), option);
        setWindowHeight(dialog.getWindow(), height);
    }

    @JvmStatic
    public static final boolean isAdaptiveColor(int color) {
        float[] fArr = new float[3];
        Color.colorToHSV(color, fArr);
        return INSTANCE.isAdaptiveColorInDayMode(fArr[0], fArr[1], fArr[2]);
    }

    private final boolean isAdaptiveColorInDayMode(float hue, float saturation, float value) {
        if (saturation < 0.1f) {
            return value >= 0.97f;
        }
        if (saturation >= 0.3f) {
            return false;
        }
        if (value >= 0.99f) {
            return true;
        }
        return value >= 0.88f && value < 0.93f;
    }

    private final boolean isAdaptiveColorInNightMode(float hue, float saturation, float value) {
        AbstractC0000a.m27x(AbstractC0622a.m1176v("s=", saturation, " v=", value, " isAdaptive="), saturation <= 0.25f && value <= 0.2f, "SpenSettingUtil");
        return saturation <= 0.25f && value < 0.2f;
    }

    @JvmStatic
    public static final boolean isNightMode(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    @JvmStatic
    public static final boolean needRecoilVI() {
        return Build.VERSION.SDK_INT > 34;
    }

    @JvmStatic
    public static final void performHapticFeedback(@NotNull View view, int pattern) {
        Intrinsics.checkNotNullParameter(view, "view");
        SpenSettingUtil spenSettingUtil = INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (spenSettingUtil.hasVibrator(context)) {
            try {
                ViewWrapper.create(view.getContext(), view).performHapticFeedback(pattern);
            } catch (PlatformException unused) {
            }
        }
    }

    @JvmStatic
    public static final boolean setShadowAlpha(@Nullable View view, float alpha) {
        if (view == null || Build.VERSION.SDK_INT < 28) {
            return false;
        }
        view.setOutlineSpotShadowColor((((int) (255 * alpha)) << 24) | (view.getOutlineSpotShadowColor() & 16777215));
        return true;
    }

    @JvmStatic
    public static final void setWindowHeight(@Nullable Window window, int height) {
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.height = height;
        }
        if (window != null) {
            window.setAttributes(attributes);
        }
    }

    @JvmStatic
    public static final int HSVToColor(int alpha, @NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        return SpenColorUtil.INSTANCE.HSVToColor(alpha, hsvColor);
    }

    @JvmStatic
    public static final boolean isAdaptiveColor(@NotNull Context context, int color) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.isAdaptiveColor(color, isNightMode(context));
    }

    private final boolean isAdaptiveColor(int color, boolean isNightMode) {
        float[] fArr = new float[3];
        Color.colorToHSV(color, fArr);
        if (!isNightMode) {
            return isAdaptiveColorInDayMode(fArr[0], fArr[1], fArr[2]);
        }
        return isAdaptiveColorInNightMode(fArr[0], fArr[1], fArr[2]);
    }
}
