package com.samsung.android.sdk.pen.setting.util;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J$\u0010\u000e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u001c\u0010\u000f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J.\u0010\u000e\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u001c\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilSIP;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "showSoftInput", "", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "flags", "", "hideSoftInput", "forceHideSoftInput", "isSIPShowing", "imm", "Landroid/view/inputmethod/InputMethodManager;", "windowManager", "Landroid/view/WindowManager;", "getSIPVisibleHeight", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingUtilSIP {

    @NotNull
    public static final SpenSettingUtilSIP INSTANCE = new SpenSettingUtilSIP();

    @NotNull
    private static final String TAG = "SpenSettingUtilSIP";

    private SpenSettingUtilSIP() {
    }

    @JvmStatic
    public static final boolean forceHideSoftInput(@Nullable Context context, @Nullable View view) {
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        Object systemService2 = context.getSystemService("window");
        WindowManager windowManager = systemService2 instanceof WindowManager ? (WindowManager) systemService2 : null;
        if (inputMethodManager == null || windowManager == null || !INSTANCE.isSIPShowing(inputMethodManager, windowManager)) {
            return false;
        }
        try {
            return inputMethodManager.semForceHideSoftInput();
        } catch (NoSuchMethodError unused) {
            return INSTANCE.hideSoftInput(inputMethodManager, windowManager, view, 1);
        }
    }

    private final int getSIPVisibleHeight(InputMethodManager imm) {
        if (imm == null) {
            return 0;
        }
        try {
            try {
                try {
                    Object objInvoke = imm.getClass().getMethod("getSIPVisibleHeight", null).invoke(imm, null);
                    Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                    return ((Integer) objInvoke).intValue();
                } catch (IllegalAccessException unused) {
                    Log.e(TAG, "getCurrentSIPHeight() : IllegalAccessException");
                    try {
                        try {
                            Object objInvoke2 = imm.getClass().getMethod("getInputMethodWindowVisibleHeight", null).invoke(imm, null);
                            Intrinsics.checkNotNull(objInvoke2, "null cannot be cast to non-null type kotlin.Int");
                            return ((Integer) objInvoke2).intValue();
                        } catch (IllegalAccessException unused2) {
                            Log.e(TAG, "getInputMethodWindowVisibleHeight() : IllegalAccessException");
                            return 0;
                        } catch (InvocationTargetException unused3) {
                            Log.e(TAG, "getInputMethodWindowVisibleHeight() : InvocationTargetException");
                            return 0;
                        }
                    } catch (NoSuchMethodException unused4) {
                        Log.e(TAG, "getInputMethodWindowVisibleHeight() : NoSuchMethodException");
                    }
                }
            } catch (InvocationTargetException unused5) {
                Log.e(TAG, "getCurrentSIPHeight() : InvocationTargetException");
                Object objInvoke22 = imm.getClass().getMethod("getInputMethodWindowVisibleHeight", null).invoke(imm, null);
                Intrinsics.checkNotNull(objInvoke22, "null cannot be cast to non-null type kotlin.Int");
                return ((Integer) objInvoke22).intValue();
            }
        } catch (NoSuchMethodException unused6) {
            Log.e(TAG, "getCurrentSIPHeight() : NoSuchMethodException");
        }
    }

    @JvmStatic
    public static final boolean hideSoftInput(@Nullable Context context, @Nullable View view, int flags) {
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        Object systemService2 = context.getSystemService("window");
        return INSTANCE.hideSoftInput(inputMethodManager, systemService2 instanceof WindowManager ? (WindowManager) systemService2 : null, view, flags);
    }

    @JvmStatic
    public static final boolean isSIPShowing(@Nullable Context context) {
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        Object systemService2 = context.getSystemService("window");
        return INSTANCE.isSIPShowing(inputMethodManager, systemService2 instanceof WindowManager ? (WindowManager) systemService2 : null);
    }

    @JvmStatic
    public static final boolean showSoftInput(@Nullable Context context, @Nullable View view, int flags) {
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return ((InputMethodManager) systemService).showSoftInput(view, flags);
    }

    private final boolean hideSoftInput(InputMethodManager imm, WindowManager windowManager, View view, int flags) {
        if (imm == null || windowManager == null || !isSIPShowing(imm, windowManager)) {
            return false;
        }
        if (view != null) {
            return imm.hideSoftInputFromWindow(view.getRootView().getWindowToken(), flags);
        }
        imm.toggleSoftInput(0, 0);
        return true;
    }

    private final boolean isSIPShowing(InputMethodManager imm, WindowManager windowManager) {
        if (imm == null || windowManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            return windowManager.getCurrentWindowMetrics().getWindowInsets().isVisible(WindowInsets.Type.ime());
        }
        return getSIPVisibleHeight(imm) > 0;
    }
}
