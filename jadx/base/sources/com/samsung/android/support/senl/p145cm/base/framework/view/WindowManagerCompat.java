package com.samsung.android.support.senl.p145cm.base.framework.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding;
import com.samsung.android.support.senl.p145cm.base.C7968R;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.WindowManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001HB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0010\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J \u0010\u0016\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007J \u0010\u0019\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007J4\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00142\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0007J4\u0010\"\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00142\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0007J\u0010\u0010#\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010$\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010%\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010&\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010'\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\"\u0010(\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u0010(\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010,\u001a\u00020-J\u0010\u0010.\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\"\u0010/\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u00100\u001a\u00020\u00072\b\b\u0002\u00101\u001a\u00020\u0007J\u000e\u00102\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u00103\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\"\u00104\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u00100\u001a\u00020\u00072\b\b\u0002\u00101\u001a\u00020\u0007H\u0002J$\u00105\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u00106\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u00020\u0007H\u0007J\u0016\u00107\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u00108\u001a\u00020\u000bJ\u0010\u00109\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010:\u001a\u00020\u000b2\b\u0010;\u001a\u0004\u0018\u00010<J\u0012\u0010=\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010>\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\tJ \u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u000b2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\u0007J \u0010D\u001a\u00020\u00072\b\u0010E\u001a\u0004\u0018\u00010+2\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/WindowManagerCompat;", "", "<init>", "()V", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsWindowManagerCompatImplFactory$IWindowManagerCompatImpl;", "isMultiWindowMode", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "getMultiWindowMode", "", "configuration", "Landroid/content/res/Configuration;", "isPairWindowingMode", "getPairWindowMode", "isFreeFormWindow", "setExtensionFlagDozeMode", "", "lp", "Landroid/view/WindowManager$LayoutParams;", "setExtensionFlagMultiWindowHandlerHidden", "setTurnScreenOn", "turnScreenOn", "needToUpdate", "setShowWhenLocked", "showWhenLocked", "addWindowFlag", "windowManager", "Landroid/view/WindowManager;", "view", "Landroid/view/View;", "windowAttributes", "flag", "clearWindowFlag", "exitMultiWindow", "setResizeFullscreenWindowOnSoftInput", "disableSystemBarInsets", "disableSystemBarInsetsNoDisplayCutout", "disableSystemBarInsetsWithIme", "updateSystemBarInsets", "typeMask", NotesConstants.KEY_CALLER, "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/core/view/OnApplyWindowInsetsListener;", "setForceHideFloatingMultiWindow", "setHideIndicatorBar", "enable", "useInsetApi", "canNotHideStatusBar", "isPopOver", "updateIndicatorBar", "controllIndicatorBar", "status", "shouldHideStatusBar", "orientation", "controlIndicatorBar", "getStatusBarHeight", "context", "Landroid/content/Context;", "getCaptionHeight", "setSensitivePalmRecognitionEnabled", "requestSystemKeyEvent", "keyCode", WidgetConstant.WIDGET_SAMSUNG_EXTRA_KEY, "Landroid/content/ComponentName;", "request", "canAllowByRegion", Bixby2Constants.BIXBY_PARAM_ACTIVITY_NAME, "x", "y", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WindowManagerCompat {
    public static final int APP_PAIR_NOT_SUPPORTED_ONEUI_VER = 5000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int MULTIWINDOW_MODE_FREEFORM = 1;
    public static final int MULTIWINDOW_MODE_NONE = 0;
    public static final int MULTIWINDOW_MODE_SPLIT_SCREEN = 2;

    @NotNull
    private static final String TAG = "WindowManagerCompat";

    @Nullable
    private static WindowManagerCompat mInstance;

    @NotNull
    private final AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/WindowManagerCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MULTIWINDOW_MODE_NONE", "", "MULTIWINDOW_MODE_FREEFORM", "MULTIWINDOW_MODE_SPLIT_SCREEN", "APP_PAIR_NOT_SUPPORTED_ONEUI_VER", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/view/WindowManagerCompat;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/view/WindowManagerCompat;", "isTabletLayout", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized WindowManagerCompat getInstance() {
            WindowManagerCompat windowManagerCompat;
            try {
                if (WindowManagerCompat.mInstance == null) {
                    WindowManagerCompat.mInstance = new WindowManagerCompat(null);
                }
                windowManagerCompat = WindowManagerCompat.mInstance;
                Intrinsics.checkNotNull(windowManagerCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.view.WindowManagerCompat");
            } catch (Throwable th) {
                throw th;
            }
            return windowManagerCompat;
        }

        public final boolean isTabletLayout(@Nullable Activity activity) {
            return activity != null && activity.getResources().getInteger(C7968R.integer.isTablet) == 1;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    public /* synthetic */ WindowManagerCompat(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ boolean controllIndicatorBar$default(WindowManagerCompat windowManagerCompat, Activity activity, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return windowManagerCompat.controllIndicatorBar(activity, i, z);
    }

    @NotNull
    public static final synchronized WindowManagerCompat getInstance() {
        return INSTANCE.getInstance();
    }

    public static /* synthetic */ boolean setHideIndicatorBar$default(WindowManagerCompat windowManagerCompat, Activity activity, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return windowManagerCompat.setHideIndicatorBar(activity, z, z2);
    }

    private final void updateIndicatorBar(Activity activity, boolean enable, boolean useInsetApi) {
        if (Build.VERSION.SDK_INT < 30 || !useInsetApi) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            if (enable) {
                attributes.flags &= -1025;
            } else {
                attributes.flags |= 1024;
            }
            activity.getWindow().setAttributes(attributes);
            return;
        }
        if (enable) {
            WindowInsetsController insetsController = activity.getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.show(WindowInsets.Type.statusBars());
                return;
            }
            return;
        }
        WindowInsetsController insetsController2 = activity.getWindow().getInsetsController();
        if (insetsController2 != null) {
            insetsController2.hide(WindowInsets.Type.statusBars());
        }
    }

    public static /* synthetic */ void updateIndicatorBar$default(WindowManagerCompat windowManagerCompat, Activity activity, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        windowManagerCompat.updateIndicatorBar(activity, z, z2);
    }

    private final void updateSystemBarInsets(View view, int typeMask, String caller) {
        updateSystemBarInsets(view, new C7975a(typeMask, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat updateSystemBarInsets$lambda$0(int i, View v, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insets = windowInsets.getInsets(i);
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.leftMargin = insets.left;
        marginLayoutParams.bottomMargin = insets.bottom;
        marginLayoutParams.rightMargin = insets.right;
        marginLayoutParams.topMargin = insets.top;
        v.setLayoutParams(marginLayoutParams);
        return WindowInsetsCompat.CONSUMED;
    }

    public final void addWindowFlag(@Nullable WindowManager windowManager, @Nullable View view, @Nullable WindowManager.LayoutParams windowAttributes, int flag, boolean needToUpdate) {
        if (windowManager == null || view == null || windowAttributes == null || (windowAttributes.flags & flag) != 0) {
            return;
        }
        LoggerBase.INSTANCE.m7132d(TAG, "addWindowFlag : " + flag);
        windowAttributes.flags = flag | windowAttributes.flags;
        if (needToUpdate) {
            windowManager.updateViewLayout(view, windowAttributes);
        }
    }

    public final boolean canAllowByRegion(@Nullable String activityName, int x, int y2) {
        return this.mImpl.canAllowByRegion(activityName, x, y2);
    }

    public final boolean canNotHideStatusBar(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return this.mImpl.isMultiWindowMode(activity) || this.mImpl.semIsPopOver(activity);
    }

    public final void clearWindowFlag(@Nullable WindowManager windowManager, @Nullable View view, @Nullable WindowManager.LayoutParams windowAttributes, int flag, boolean needToUpdate) {
        if (windowManager == null || view == null || windowAttributes == null || (windowAttributes.flags & flag) == 0) {
            return;
        }
        LoggerBase.INSTANCE.m7132d(TAG, "clearWindowFlag : " + flag);
        windowAttributes.flags = (~flag) & windowAttributes.flags;
        if (needToUpdate) {
            windowManager.updateViewLayout(view, windowAttributes);
        }
    }

    public final boolean controlIndicatorBar(@Nullable Activity activity) {
        if (activity == null) {
            return false;
        }
        return controllIndicatorBar$default(this, activity, activity.getResources().getConfiguration().orientation, false, 4, null);
    }

    @JvmOverloads
    public final boolean controllIndicatorBar(@Nullable Activity activity, int i) {
        return controllIndicatorBar$default(this, activity, i, false, 4, null);
    }

    public final void disableSystemBarInsets(@Nullable View view) {
        updateSystemBarInsets(view, WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout(), "disableSystemBarInsets");
    }

    public final void disableSystemBarInsetsNoDisplayCutout(@Nullable View view) {
        updateSystemBarInsets(view, WindowInsetsCompat.Type.systemBars(), "disableSystemBarInsetsNoDisplayCutout");
    }

    public final void disableSystemBarInsetsWithIme(@Nullable View view) {
        updateSystemBarInsets(view, WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout() | WindowInsetsCompat.Type.ime(), "disableSystemBarInsetsWithIme");
    }

    public final boolean exitMultiWindow(@Nullable Activity activity) {
        if (activity == null) {
            return false;
        }
        return this.mImpl.exitMultiWindow(activity);
    }

    @SuppressLint({"BlockedPrivateApi"})
    public final int getCaptionHeight(@Nullable Activity activity) {
        if (activity == null) {
            return 0;
        }
        try {
            Field declaredField = Class.forName("com.android.internal.policy.DecorView").getDeclaredField("mDecorCaptionView");
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("com.android.internal.widget.DecorCaptionView");
            Object obj = declaredField.get(activity.getWindow().getDecorView());
            if (obj != null && isFreeFormWindow(activity)) {
                Object objInvoke = cls.getMethod("getCaptionHeight", null).invoke(obj, null);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                return ((Integer) objInvoke).intValue();
            }
            return 0;
        } catch (ClassNotFoundException e) {
            LoggerBase.INSTANCE.m7134e(TAG, "getCaptionHeight", e);
            return 0;
        } catch (IllegalAccessException e2) {
            LoggerBase.INSTANCE.m7134e(TAG, "getCaptionHeight", e2);
            return 0;
        } catch (NoSuchFieldException e3) {
            LoggerBase.INSTANCE.m7134e(TAG, "getCaptionHeight", e3);
            return 0;
        } catch (NoSuchMethodException e5) {
            LoggerBase.INSTANCE.m7134e(TAG, "getCaptionHeight", e5);
            return 0;
        } catch (InvocationTargetException e6) {
            LoggerBase.INSTANCE.m7134e(TAG, "getCaptionHeight", e6);
            return 0;
        }
    }

    public final int getMultiWindowMode(@Nullable Activity activity) {
        if (activity == null) {
            return 0;
        }
        return this.mImpl.getMultiWindowMode(activity);
    }

    public final int getPairWindowMode(@Nullable Activity activity) {
        Intent intent;
        int iIntValue = 0;
        if (SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 5000 || activity == null || (intent = activity.getIntent()) == null) {
            return 0;
        }
        try {
            Object objInvoke = Intent.class.getMethod("getPairWindowingMode", null).invoke(intent, null);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
            iIntValue = ((Integer) objInvoke).intValue();
            LoggerBase.INSTANCE.m7137i(TAG, "check pair type : " + iIntValue);
            return iIntValue;
        } catch (IllegalAccessException e) {
            AbstractC0000a.m23t("check pair type : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            return iIntValue;
        } catch (NoSuchMethodException e2) {
            AbstractC0000a.m23t("check pair type : ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
            return iIntValue;
        } catch (InvocationTargetException e3) {
            AbstractC0000a.m23t("check pair type : ", e3.getMessage(), LoggerBase.INSTANCE, TAG);
            return iIntValue;
        }
    }

    public final int getStatusBarHeight(@Nullable Context context) {
        Resources resources;
        int identifier;
        if (context == null || (identifier = (resources = context.getResources()).getIdentifier("status_bar_height", AbsExecuteBinding.TYPE_DIMEN, TelemetryEventStrings.C6439Os.OS_NAME)) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public final boolean isFreeFormWindow(@Nullable Activity activity) {
        if (activity == null) {
            return false;
        }
        return this.mImpl.isFreeFormWindow(activity);
    }

    public final boolean isMultiWindowMode(@Nullable Activity activity) {
        if (activity == null) {
            return false;
        }
        return this.mImpl.isMultiWindowMode(activity);
    }

    public final boolean isPairWindowingMode(@Nullable Activity activity) {
        return getPairWindowMode(activity) != 0;
    }

    public final boolean isPopOver(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return this.mImpl.semIsPopOver(activity);
    }

    public final boolean requestSystemKeyEvent(int keyCode, @Nullable ComponentName componentName, boolean request) {
        return this.mImpl.requestSystemKeyEvent(keyCode, componentName, request);
    }

    public final void setExtensionFlagDozeMode(@Nullable WindowManager.LayoutParams lp) {
        if (lp == null) {
            return;
        }
        this.mImpl.setExtensionFlagDozeMode(lp);
    }

    public final void setExtensionFlagMultiWindowHandlerHidden(@Nullable WindowManager.LayoutParams lp) {
        if (lp == null) {
            return;
        }
        this.mImpl.setExtensionFlagMultiWindowHandlerHidden(lp);
    }

    public final boolean setForceHideFloatingMultiWindow(@Nullable Activity activity) {
        if (activity == null) {
            return false;
        }
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        if (!this.mImpl.setForceHideFloatingMultiWindow(attributes)) {
            return false;
        }
        activity.getWindow().setAttributes(attributes);
        return true;
    }

    public final boolean setHideIndicatorBar(@Nullable Activity activity, boolean enable, boolean useInsetApi) {
        if (activity == null) {
            return false;
        }
        if (!canNotHideStatusBar(activity)) {
            updateIndicatorBar(activity, enable, useInsetApi);
            return true;
        }
        if (Build.VERSION.SDK_INT > 27) {
            updateIndicatorBar(activity, true, useInsetApi);
        }
        return false;
    }

    public final boolean setResizeFullscreenWindowOnSoftInput(@Nullable Activity activity) {
        if (activity == null) {
            return false;
        }
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        if (!this.mImpl.setResizeFullscreenWindowOnSoftInput(attributes)) {
            return false;
        }
        activity.getWindow().setAttributes(attributes);
        return true;
    }

    public final void setSensitivePalmRecognitionEnabled(@Nullable Activity activity) {
        this.mImpl.setSensitivePalmRecognitionEnabled(activity);
    }

    public final void setShowWhenLocked(@Nullable Activity activity, boolean showWhenLocked, boolean needToUpdate) {
        if (activity == null || activity.getWindow() == null) {
            return;
        }
        LoggerBase.INSTANCE.m7132d(TAG, "setShowWhenLocked : " + showWhenLocked);
        if (Build.VERSION.SDK_INT >= 30) {
            activity.setShowWhenLocked(showWhenLocked);
        } else if (showWhenLocked) {
            addWindowFlag(activity.getWindowManager(), activity.getWindow().getDecorView(), activity.getWindow().getAttributes(), 524288, needToUpdate);
        } else {
            clearWindowFlag(activity.getWindowManager(), activity.getWindow().getDecorView(), activity.getWindow().getAttributes(), 524288, needToUpdate);
        }
    }

    public final void setTurnScreenOn(@Nullable Activity activity, boolean turnScreenOn, boolean needToUpdate) {
        if (activity == null || activity.getWindow() == null) {
            return;
        }
        LoggerBase.INSTANCE.m7132d(TAG, "setTurnScreenOn : " + turnScreenOn);
        if (Build.VERSION.SDK_INT >= 30) {
            activity.setTurnScreenOn(turnScreenOn);
        } else if (turnScreenOn) {
            addWindowFlag(activity.getWindowManager(), activity.getWindow().getDecorView(), activity.getWindow().getAttributes(), 2097152, needToUpdate);
        } else {
            clearWindowFlag(activity.getWindowManager(), activity.getWindow().getDecorView(), activity.getWindow().getAttributes(), 2097152, needToUpdate);
        }
    }

    public final boolean shouldHideStatusBar(@NotNull Activity activity, int orientation) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return orientation == 2 && !INSTANCE.isTabletLayout(activity);
    }

    private WindowManagerCompat() {
        this.mImpl = new WindowManagerCompatImplFactory().create(DeviceInfo.getDeviceType());
    }

    @JvmOverloads
    public final boolean controllIndicatorBar(@Nullable Activity activity, int status, boolean useInsetApi) {
        if (activity == null) {
            return false;
        }
        return shouldHideStatusBar(activity, status) ? setHideIndicatorBar(activity, false, useInsetApi) : setHideIndicatorBar(activity, true, useInsetApi);
    }

    public final int getMultiWindowMode(@Nullable Configuration configuration) {
        if (configuration == null) {
            return 0;
        }
        return this.mImpl.getMultiWindowMode(configuration);
    }

    public final void updateSystemBarInsets(@Nullable View view, @NotNull OnApplyWindowInsetsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (Build.VERSION.SDK_INT <= 34 || view == null) {
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(view, listener);
    }
}
