package com.samsung.android.support.senl.p145cm.base.framework.sem.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.SemMultiWindowManager;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.sdk.multiwindow.SMultiWindowActivity;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.tsp.SemTspStateManager;
import com.samsung.android.view.SemWindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0005\b\t\n\u000b\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/WindowManagerCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsWindowManagerCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsWindowManagerCompatImplFactory$IWindowManagerCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "WindowManagerCompatSemFromN20Impl", "WindowManagerCompatSemPostOImpl", "WindowManagerCompatSemImpl", "WindowManagerCompatSdlImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WindowManagerCompatImplFactory extends AbsWindowManagerCompatImplFactory {
    private static final int EXTENSION_FLAG_MULTI_WINDOW_HANDLER_HIDDEN = 16777216;

    @NotNull
    private static final String TAG = "WindowManagerCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\"\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0016¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/WindowManagerCompatImplFactory$WindowManagerCompatSdlImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsWindowManagerCompatImplFactory$IWindowManagerCompatImpl;", "<init>", "()V", "isMultiWindowMode", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "isFreeFormWindow", "getMultiWindowMode", "", "configuration", "Landroid/content/res/Configuration;", "semIsPopOver", "exitMultiWindow", "setExtensionFlagDozeMode", "", "lp", "Landroid/view/WindowManager$LayoutParams;", "setExtensionFlagMultiWindowHandlerHidden", "setResizeFullscreenWindowOnSoftInput", "setForceHideFloatingMultiWindow", "setSensitivePalmRecognitionEnabled", "requestSystemKeyEvent", "keyCode", WidgetConstant.WIDGET_SAMSUNG_EXTRA_KEY, "Landroid/content/ComponentName;", "request", "canAllowByRegion", Bixby2Constants.BIXBY_PARAM_ACTIVITY_NAME, "", "x", "y", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class WindowManagerCompatSdlImpl implements AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean canAllowByRegion(@Nullable String activityName, int x, int y2) {
            return true;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean exitMultiWindow(@Nullable Activity activity) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public int getMultiWindowMode(@Nullable Configuration configuration) {
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean isFreeFormWindow(@Nullable Activity activity) {
            SMultiWindowActivity sMultiWindowActivity = new SMultiWindowActivity(activity);
            return sMultiWindowActivity.isMultiWindow() && sMultiWindowActivity.isScaleWindow();
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean isMultiWindowMode(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return new SMultiWindowActivity(activity).isMultiWindow();
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean requestSystemKeyEvent(int keyCode, @Nullable ComponentName componentName, boolean request) {
            LoggerBase.Companion companion = LoggerBase.INSTANCE;
            StringBuilder sbM1629s = AbstractC2322a.m1629s("requestSystemKeyEvent keyCode/componentName/request ", keyCode, "/", componentName != null ? componentName.getClassName() : null, "/");
            sbM1629s.append(request);
            companion.m7132d(WindowManagerCompatImplFactory.TAG, sbM1629s.toString());
            try {
                return SemWindowManager.getInstance().requestSystemKeyEvent(keyCode, componentName, request);
            } catch (NoClassDefFoundError e) {
                AbstractC0000a.m23t("requestSystemKeyEvent: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, WindowManagerCompatImplFactory.TAG);
                return false;
            } catch (NoSuchMethodError e2) {
                AbstractC0000a.m23t("requestSystemKeyEvent: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, WindowManagerCompatImplFactory.TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean semIsPopOver(@Nullable Activity activity) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean setForceHideFloatingMultiWindow(@Nullable WindowManager.LayoutParams lp) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean setResizeFullscreenWindowOnSoftInput(@Nullable WindowManager.LayoutParams lp) {
            try {
                Field field = WindowManager.LayoutParams.class.getField("SAMSUNG_FLAG_SOFT_INPUT_ADJUST_RESIZE_FULLSCREEN");
                Field field2 = WindowManager.LayoutParams.class.getField("samsungFlags");
                if (field != null) {
                    field2.setInt(lp, field.getInt(field));
                    return true;
                }
                LoggerBase.INSTANCE.m7132d(WindowManagerCompatImplFactory.TAG, "setResizeFullscreenWindowOnSoftInput - 'SAMSUNG_FLAG_SOFT_INPUT_ADJUST_RESIZE_FULLSCREEN, samsungFlag =" + field2);
                return true;
            } catch (IllegalAccessException unused) {
                LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "setResizeFullscreenWindowOnSoftInput : SAMSUNG_FLAG_SOFT_INPUT_ADJUST_RESIZE_FULLSCREEN");
                return false;
            } catch (IllegalArgumentException unused2) {
                LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "setResizeFullscreenWindowOnSoftInput : SAMSUNG_FLAG_SOFT_INPUT_ADJUST_RESIZE_FULLSCREEN");
                return false;
            } catch (NoSuchFieldException unused3) {
                LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "setResizeFullscreenWindowOnSoftInput : SAMSUNG_FLAG_SOFT_INPUT_ADJUST_RESIZE_FULLSCREEN");
                return false;
            } catch (NullPointerException unused4) {
                LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "setResizeFullscreenWindowOnSoftInput : SAMSUNG_FLAG_SOFT_INPUT_ADJUST_RESIZE_FULLSCREEN");
                return false;
            } catch (SecurityException unused5) {
                LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "setResizeFullscreenWindowOnSoftInput : SAMSUNG_FLAG_SOFT_INPUT_ADJUST_RESIZE_FULLSCREEN");
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public int getMultiWindowMode(@Nullable Activity activity) {
            SMultiWindowActivity sMultiWindowActivity = new SMultiWindowActivity(activity);
            if (sMultiWindowActivity.isMultiWindow()) {
                return sMultiWindowActivity.isScaleWindow() ? 1 : 2;
            }
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public void setExtensionFlagDozeMode(@Nullable WindowManager.LayoutParams lp) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public void setExtensionFlagMultiWindowHandlerHidden(@Nullable WindowManager.LayoutParams lp) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public void setSensitivePalmRecognitionEnabled(@Nullable Activity activity) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/WindowManagerCompatImplFactory$WindowManagerCompatSemFromN20Impl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/WindowManagerCompatImplFactory$WindowManagerCompatSemPostOImpl;", "<init>", "()V", "setSensitivePalmRecognitionEnabled", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "semIsPopOver", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class WindowManagerCompatSemFromN20Impl extends WindowManagerCompatSemPostOImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.WindowManagerCompatImplFactory.WindowManagerCompatSemImpl, com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean semIsPopOver(@Nullable Activity activity) {
            return Build.VERSION.SDK_INT >= 33 && activity != null && activity.getResources().getConfiguration().semIsPopOver();
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.WindowManagerCompatImplFactory.WindowManagerCompatSemImpl, com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public void setSensitivePalmRecognitionEnabled(@Nullable Activity activity) {
            Window window;
            if (!Settings.System.canWrite(activity)) {
                LoggerBase.INSTANCE.m7137i(WindowManagerCompatImplFactory.TAG, "WRITE_SETTINGS permission is needed");
                return;
            }
            LoggerBase.INSTANCE.m7137i(WindowManagerCompatImplFactory.TAG, "setSensitivePalmRecognitionEnabled#");
            try {
                SemTspStateManager.class.getDeclaredMethod("setSensitivePalmRecognitionEnabled", View.class, Boolean.TYPE).invoke(null, (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView(), Boolean.TRUE);
            } catch (IllegalAccessException e) {
                LoggerBase.INSTANCE.m7132d(WindowManagerCompatImplFactory.TAG, "e: " + e.getMessage());
                Unit unit = Unit.INSTANCE;
            } catch (NoSuchMethodException e2) {
                LoggerBase.INSTANCE.m7132d(WindowManagerCompatImplFactory.TAG, "e: " + e2.getMessage());
                Unit unit2 = Unit.INSTANCE;
            } catch (InvocationTargetException e3) {
                LoggerBase.INSTANCE.m7132d(WindowManagerCompatImplFactory.TAG, "e: " + e3.getMessage());
                Unit unit3 = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/WindowManagerCompatImplFactory$WindowManagerCompatSemPostOImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/WindowManagerCompatImplFactory$WindowManagerCompatSemImpl;", "<init>", "()V", "isFreeFormWindow", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class WindowManagerCompatSemPostOImpl extends WindowManagerCompatSemImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.WindowManagerCompatImplFactory.WindowManagerCompatSemImpl, com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean isFreeFormWindow(@Nullable Activity activity) {
            return getMultiWindowMode(activity) == 1;
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory
    @NotNull
    public AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl create(int deviceType) {
        return deviceType != 2 ? deviceType != 3 ? super.create(deviceType) : new WindowManagerCompatSdlImpl() : DeviceInfo.getSemPlatformVersionInt(0) >= 110500 ? new WindowManagerCompatSemFromN20Impl() : Build.VERSION.SDK_INT > 27 ? new WindowManagerCompatSemPostOImpl() : new WindowManagerCompatSemImpl();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0017J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\"\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0016¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/WindowManagerCompatImplFactory$WindowManagerCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsWindowManagerCompatImplFactory$IWindowManagerCompatImpl;", "<init>", "()V", "isMultiWindowMode", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "isFreeFormWindow", "getMultiWindowMode", "", "newConfig", "Landroid/content/res/Configuration;", "convertWindowMode", "type", "semIsPopOver", "exitMultiWindow", "setExtensionFlagDozeMode", "", "lp", "Landroid/view/WindowManager$LayoutParams;", "setExtensionFlagMultiWindowHandlerHidden", "setResizeFullscreenWindowOnSoftInput", "setForceHideFloatingMultiWindow", "setSensitivePalmRecognitionEnabled", "requestSystemKeyEvent", "keyCode", WidgetConstant.WIDGET_SAMSUNG_EXTRA_KEY, "Landroid/content/ComponentName;", "request", "canAllowByRegion", Bixby2Constants.BIXBY_PARAM_ACTIVITY_NAME, "", "x", "y", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nWindowManagerCompatImplFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WindowManagerCompatImplFactory.kt\ncom/samsung/android/support/senl/cm/base/framework/sem/view/WindowManagerCompatImplFactory$WindowManagerCompatSemImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,436:1\n1#2:437\n*E\n"})
    public static class WindowManagerCompatSemImpl implements AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl {
        private final int convertWindowMode(int type) {
            if (type == 3 || type == 4) {
                return 2;
            }
            if (type != 5) {
                return type != 6 ? 0 : 2;
            }
            return 1;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean canAllowByRegion(@Nullable String activityName, int x, int y2) {
            Region region = new Region();
            try {
                Class<?> cls = Class.forName("com.samsung.android.multiwindow.MultiWindowManager");
                Object objInvoke = cls.getMethod("getVisibleTasks", null).invoke(cls.getDeclaredConstructor(null).newInstance(null), null);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.collections.List<android.app.ActivityManager.RunningTaskInfo>");
                for (ActivityManager.RunningTaskInfo runningTaskInfo : (List) objInvoke) {
                    if (runningTaskInfo.topActivity != null) {
                        ComponentName componentName = runningTaskInfo.topActivity;
                        if (Intrinsics.areEqual(activityName, componentName != null ? componentName.getShortClassName() : null)) {
                            Object obj = runningTaskInfo.getClass().getField("configuration").get(runningTaskInfo);
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.content.res.Configuration");
                            Object obj2 = Configuration.class.getField("windowConfiguration").get((Configuration) obj);
                            Class<?> cls2 = Class.forName("android.app.WindowConfiguration");
                            Object objInvoke2 = cls2.getMethod("getWindowingMode", null).invoke(obj2, null);
                            Intrinsics.checkNotNull(objInvoke2, "null cannot be cast to non-null type kotlin.Int");
                            if (((Integer) objInvoke2).intValue() == 1) {
                                LoggerBase.INSTANCE.m7137i(WindowManagerCompatImplFactory.TAG, "canAllowByRegion WINDOWING_MODE_FULLSCREEN ");
                                return false;
                            }
                            Object objInvoke3 = cls2.getMethod("getAppBounds", null).invoke(obj2, null);
                            if (objInvoke3 != null) {
                                region.union((Rect) objInvoke3);
                            }
                        }
                    }
                }
                boolean z = !region.contains(x, y2);
                LoggerBase.INSTANCE.m7137i(WindowManagerCompatImplFactory.TAG, "canAllowByRegion result " + z);
                return z;
            } catch (ClassNotFoundException e) {
                LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "canAllowByRegion e :" + e);
                return true;
            } catch (IllegalAccessException e2) {
                LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "canAllowByRegion e :" + e2);
                return true;
            } catch (IllegalArgumentException e3) {
                LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "canAllowByRegion e :" + e3);
                return true;
            } catch (InstantiationException e5) {
                LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "canAllowByRegion e :" + e5);
                return true;
            } catch (NoSuchFieldException e6) {
                LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "canAllowByRegion e :" + e6);
                return true;
            } catch (NoSuchMethodException e7) {
                LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "canAllowByRegion e :" + e7);
                return true;
            } catch (InvocationTargetException e8) {
                LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "canAllowByRegion e :" + e8);
                return true;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean exitMultiWindow(@Nullable Activity activity) {
            if (activity == null || !isMultiWindowMode(activity)) {
                return false;
            }
            try {
                return activity.semExitMultiWindowMode();
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("exitMultiWindow: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, WindowManagerCompatImplFactory.TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public int getMultiWindowMode(@Nullable Activity activity) {
            if (activity == null) {
                return 0;
            }
            try {
                if (!isMultiWindowMode(activity)) {
                    return 0;
                }
                int multiWindowMode = getMultiWindowMode(activity.getResources().getConfiguration());
                return multiWindowMode == 0 ? new SemMultiWindowManager().getMode() : multiWindowMode;
            } catch (NoClassDefFoundError e) {
                AbstractC0000a.m23t("getMultiWindowMode: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, WindowManagerCompatImplFactory.TAG);
                return 0;
            } catch (NoSuchMethodError e2) {
                AbstractC0000a.m23t("getMultiWindowMode: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, WindowManagerCompatImplFactory.TAG);
                return 0;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean isFreeFormWindow(@Nullable Activity activity) {
            if (activity == null || !isMultiWindowMode(activity)) {
                return false;
            }
            try {
                Method method = Activity.class.getMethod("getWindowStackId", null);
                method.setAccessible(true);
                Object objInvoke = method.invoke(activity, null);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                int iIntValue = ((Integer) objInvoke).intValue();
                Field field = Class.forName("android.app.ActivityManager$StackId").getField("FREEFORM_WORKSPACE_STACK_ID");
                field.setAccessible(true);
                return iIntValue == field.getInt(null);
            } catch (ClassNotFoundException e) {
                LoggerBase.INSTANCE.m7134e(WindowManagerCompatImplFactory.TAG, "isFreeFormWindow", e);
                return false;
            } catch (IllegalAccessException e2) {
                LoggerBase.INSTANCE.m7134e(WindowManagerCompatImplFactory.TAG, "isFreeFormWindow", e2);
                return false;
            } catch (NoSuchFieldException e3) {
                LoggerBase.INSTANCE.m7134e(WindowManagerCompatImplFactory.TAG, "isFreeFormWindow", e3);
                return false;
            } catch (NoSuchMethodException e5) {
                LoggerBase.INSTANCE.m7134e(WindowManagerCompatImplFactory.TAG, "isFreeFormWindow", e5);
                return false;
            } catch (InvocationTargetException e6) {
                LoggerBase.INSTANCE.m7134e(WindowManagerCompatImplFactory.TAG, "isFreeFormWindow", e6);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean isMultiWindowMode(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return activity.isInMultiWindowMode();
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean requestSystemKeyEvent(int keyCode, @Nullable ComponentName componentName, boolean request) {
            LoggerBase.Companion companion = LoggerBase.INSTANCE;
            StringBuilder sbM1629s = AbstractC2322a.m1629s("requestSystemKeyEvent keyCode/componentName/request ", keyCode, "/", componentName != null ? componentName.getClassName() : null, "/");
            sbM1629s.append(request);
            companion.m7132d(WindowManagerCompatImplFactory.TAG, sbM1629s.toString());
            try {
                if (Build.VERSION.SDK_INT <= 36) {
                    return SemWindowManager.getInstance().requestSystemKeyEvent(keyCode, componentName, request);
                }
                return false;
            } catch (NoClassDefFoundError e) {
                AbstractC0000a.m23t("requestSystemKeyEvent: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, WindowManagerCompatImplFactory.TAG);
                return false;
            } catch (NoSuchMethodError e2) {
                AbstractC0000a.m23t("requestSystemKeyEvent: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, WindowManagerCompatImplFactory.TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean semIsPopOver(@Nullable Activity activity) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public void setExtensionFlagDozeMode(@Nullable WindowManager.LayoutParams lp) {
            if (lp != null) {
                try {
                    lp.semAddExtensionFlags(262144);
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("setExtensionFlagDozeMode: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, WindowManagerCompatImplFactory.TAG);
                }
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public void setExtensionFlagMultiWindowHandlerHidden(@Nullable WindowManager.LayoutParams lp) {
            if (lp != null) {
                try {
                    lp.semAddExtensionFlags(WindowManagerCompatImplFactory.EXTENSION_FLAG_MULTI_WINDOW_HANDLER_HIDDEN);
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("setExtensionFlagMultiWindowHandlerHidden: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, WindowManagerCompatImplFactory.TAG);
                }
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean setForceHideFloatingMultiWindow(@Nullable WindowManager.LayoutParams lp) {
            try {
                Field field = WindowManager.LayoutParams.class.getField("SEM_EXTENSION_FLAG_FORCE_HIDE_FLOATING_MULTIWINDOW");
                Field field2 = WindowManager.LayoutParams.class.getField("samsungFlags");
                if (field != null) {
                    field2.setInt(lp, field.getInt(field));
                    return true;
                }
                LoggerBase.INSTANCE.m7132d(WindowManagerCompatImplFactory.TAG, "setForceHideFloatingMultiWindow - 'SEM_EXTENSION_FLAG_FORCE_HIDE_FLOATING_MULTIWINDOW, samsungFlag =" + field2);
                return true;
            } catch (IllegalAccessException unused) {
                LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "setForceHideFloatingMultiWindow : SEM_EXTENSION_FLAG_FORCE_HIDE_FLOATING_MULTIWINDOW");
                return false;
            } catch (IllegalArgumentException unused2) {
                LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "setForceHideFloatingMultiWindow : SEM_EXTENSION_FLAG_FORCE_HIDE_FLOATING_MULTIWINDOW");
                return false;
            } catch (NoSuchFieldException unused3) {
                LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "setForceHideFloatingMultiWindow : SEM_EXTENSION_FLAG_FORCE_HIDE_FLOATING_MULTIWINDOW");
                return false;
            } catch (NullPointerException unused4) {
                LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "setForceHideFloatingMultiWindow : SEM_EXTENSION_FLAG_FORCE_HIDE_FLOATING_MULTIWINDOW");
                return false;
            } catch (SecurityException unused5) {
                LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "setForceHideFloatingMultiWindow : SEM_EXTENSION_FLAG_FORCE_HIDE_FLOATING_MULTIWINDOW");
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public boolean setResizeFullscreenWindowOnSoftInput(@Nullable WindowManager.LayoutParams lp) {
            if (lp != null) {
                lp.semAddExtensionFlags(1);
            }
            return true;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        @SuppressLint({"BlockedPrivateApi"})
        public int getMultiWindowMode(@Nullable Configuration newConfig) {
            Field field;
            int iIntValue = 0;
            if (newConfig != null) {
                try {
                    field = newConfig.getClass().getField("windowConfiguration");
                } catch (Exception e) {
                    AbstractC0000a.m23t("can't access window mode : ", e.getMessage(), LoggerBase.INSTANCE, WindowManagerCompatImplFactory.TAG);
                }
            } else {
                field = null;
            }
            if (field != null) {
                field.setAccessible(true);
            }
            Object objInvoke = Class.forName("android.app.WindowConfiguration").getDeclaredMethod("getWindowingMode", null).invoke(field != null ? field.get(newConfig) : null, null);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
            iIntValue = ((Integer) objInvoke).intValue();
            LoggerBase.INSTANCE.m7133e(WindowManagerCompatImplFactory.TAG, "windowingMode : " + iIntValue);
            LoggerBase.INSTANCE.m7132d(WindowManagerCompatImplFactory.TAG, "onMultiWindowModeChanged " + iIntValue);
            return convertWindowMode(iIntValue);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsWindowManagerCompatImplFactory.IWindowManagerCompatImpl
        public void setSensitivePalmRecognitionEnabled(@Nullable Activity activity) {
        }
    }
}
