package com.samsung.android.support.senl.p145cm.base.framework.sem.desktopmode;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.Display;
import com.samsung.android.desktopmode.SemDesktopModeManager;
import com.samsung.android.desktopmode.SemDesktopModeState;
import com.samsung.android.settings.search.provider.SecSearchIndexablesContract;
import com.samsung.android.support.senl.p145cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0006\b\t\n\u000b\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/DesktopModeCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/AbsDesktopModeCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/AbsDesktopModeCompatImplFactory$IDesktopModeCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "DexModeCompatSem80100Impl", "DexModeCompatSem80200Impl", "DexModeCompatSem90000Impl", "DexModeCompatSem90500Impl", "DexModeCompatSem170000mpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DesktopModeCompatImplFactory extends AbsDesktopModeCompatImplFactory {
    private static final int FLAG_EXTERNAL_DESKTOP_WINDOWING = 131072;

    @NotNull
    private static final String TAG = "DesktopModeCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/DesktopModeCompatImplFactory$DexModeCompatSem170000mpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/DesktopModeCompatImplFactory$DexModeCompatSem90500Impl;", "<init>", "()V", SecSearchIndexablesContract.ExtraInfo.EXTRA_KEY_DEX_MODE, "", "context", "Landroid/content/Context;", "getScreenLocation", "", "hasDesktopWindowingOnExternalDisplay", "isSupportedWindowingMode", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DexModeCompatSem170000mpl extends DexModeCompatSem90500Impl {
        private final boolean hasDesktopWindowingOnExternalDisplay(Context context) {
            if (context != null && Build.VERSION.SDK_INT >= 30) {
                if (!(context instanceof Activity)) {
                    LoggerBase.INSTANCE.m7132d(DesktopModeCompatImplFactory.TAG, "hasDesktopWindowingOnExternalDisplay. not activity context");
                    return false;
                }
                Display display = ((Activity) context).getDisplay();
                Intrinsics.checkNotNullExpressionValue(display, "getDisplay(...)");
                if (display.getDisplayId() != -1 && display.getDisplayId() != 0 && (display.getFlags() & 131072) != 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.DesktopModeCompatImplFactory.DexModeCompatSem90500Impl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.DesktopModeCompatImplFactory.DexModeCompatSem80100Impl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.DexModeCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl
        public int getScreenLocation(@Nullable Context context) {
            return hasDesktopWindowingOnExternalDisplay(context) ? 256 : 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.DesktopModeCompatImplFactory.DexModeCompatSem90500Impl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.DesktopModeCompatImplFactory.DexModeCompatSem80200Impl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.DesktopModeCompatImplFactory.DexModeCompatSem80100Impl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.DexModeCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl
        public boolean isDexMode(@Nullable Context context) {
            return hasDesktopWindowingOnExternalDisplay(context);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.DexModeCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl
        public boolean isSupportedWindowingMode() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\r\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/DesktopModeCompatImplFactory$DexModeCompatSem80100Impl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/AbsDesktopModeCompatImplFactory$DexModeCompatPureImpl;", "<init>", "()V", "getDesktopManager", "Lcom/samsung/android/desktopmode/SemDesktopModeManager;", "context", "Landroid/content/Context;", SecSearchIndexablesContract.ExtraInfo.EXTRA_KEY_DEX_MODE, "", "getDexModeType", "", "getScreenLocation", "isDexModeType", "type", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class DexModeCompatSem80100Impl extends AbsDesktopModeCompatImplFactory.DexModeCompatPureImpl {
        @SuppressLint({"WrongConstant"})
        @Nullable
        public final SemDesktopModeManager getDesktopManager(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Object systemService = context.getSystemService("desktopmode");
                if (systemService instanceof SemDesktopModeManager) {
                    return (SemDesktopModeManager) systemService;
                }
                return null;
            } catch (NoClassDefFoundError e) {
                AbstractC0000a.m23t("isDesktopMode: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, DesktopModeCompatImplFactory.TAG);
                return null;
            } catch (NoSuchMethodError e2) {
                AbstractC0000a.m23t("isDesktopMode: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, DesktopModeCompatImplFactory.TAG);
                return null;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.DexModeCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl
        public int getDexModeType(@Nullable Context context) {
            return isDexMode(context) ? 32768 : 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.DexModeCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl
        public int getScreenLocation(@Nullable Context context) {
            return isDexMode(context) ? 256 : 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.DexModeCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl
        public boolean isDexMode(@Nullable Context context) {
            if (context == null) {
                LoggerBase.INSTANCE.m7132d(DesktopModeCompatImplFactory.TAG, "context is null");
                return false;
            }
            SemDesktopModeManager desktopManager = getDesktopManager(context);
            if (desktopManager != null) {
                try {
                    Object objInvoke = SemDesktopModeManager.class.getMethod("isDesktopMode", null).invoke(desktopManager, null);
                    Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
                    if (((Boolean) objInvoke).booleanValue()) {
                        LoggerBase.INSTANCE.m7132d(DesktopModeCompatImplFactory.TAG, "NOW IN KNOX DESKTOP MODE!");
                        return true;
                    }
                } catch (Exception e) {
                    AbstractC0000a.m23t("Failed isDesktopMode : ", e.getMessage(), LoggerBase.INSTANCE, DesktopModeCompatImplFactory.TAG);
                }
                try {
                    Object objInvoke2 = SemDesktopModeManager.class.getMethod("isDesktopDockConnected", null).invoke(desktopManager, null);
                    Intrinsics.checkNotNull(objInvoke2, "null cannot be cast to non-null type kotlin.Boolean");
                    if (((Boolean) objInvoke2).booleanValue()) {
                        LoggerBase.INSTANCE.m7132d(DesktopModeCompatImplFactory.TAG, "DESKTOP DOCK CONNECTED!");
                        return false;
                    }
                } catch (Exception e2) {
                    AbstractC0000a.m23t("Failed isDesktopDockConnected : ", e2.getMessage(), LoggerBase.INSTANCE, DesktopModeCompatImplFactory.TAG);
                }
            }
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.DexModeCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl
        public boolean isDexModeType(@Nullable Context context, int type) {
            return isDexMode(context) && type == 32768;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/DesktopModeCompatImplFactory$DexModeCompatSem80200Impl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/DesktopModeCompatImplFactory$DexModeCompatSem80100Impl;", "<init>", "()V", SecSearchIndexablesContract.ExtraInfo.EXTRA_KEY_DEX_MODE, "", "context", "Landroid/content/Context;", "getDexState", "Lcom/samsung/android/desktopmode/SemDesktopModeState;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class DexModeCompatSem80200Impl extends DexModeCompatSem80100Impl {
        @Nullable
        public final SemDesktopModeState getDexState(@Nullable Context context) {
            SemDesktopModeManager desktopManager;
            if (context == null || (desktopManager = getDesktopManager(context)) == null) {
                return null;
            }
            return desktopManager.getDesktopModeState();
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.DesktopModeCompatImplFactory.DexModeCompatSem80100Impl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.DexModeCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl
        public boolean isDexMode(@Nullable Context context) {
            Class<?> cls;
            Field field;
            Field field2;
            Resources resources;
            Integer numValueOf = null;
            Configuration configuration = (context == null || (resources = context.getResources()) == null) ? null : resources.getConfiguration();
            if (configuration != null) {
                try {
                    cls = configuration.getClass();
                } catch (IllegalAccessException e) {
                    AbstractC0000a.m23t("Failed isDexMode : ", e.getMessage(), LoggerBase.INSTANCE, DesktopModeCompatImplFactory.TAG);
                } catch (IllegalArgumentException e2) {
                    AbstractC0000a.m23t("Failed isDexMode : ", e2.getMessage(), LoggerBase.INSTANCE, DesktopModeCompatImplFactory.TAG);
                } catch (NoSuchFieldException e3) {
                    AbstractC0000a.m23t("Failed isDexMode : ", e3.getMessage(), LoggerBase.INSTANCE, DesktopModeCompatImplFactory.TAG);
                }
            } else {
                cls = null;
            }
            Integer numValueOf2 = (cls == null || (field2 = cls.getField("SEM_DESKTOP_MODE_ENABLED")) == null) ? null : Integer.valueOf(field2.getInt(cls));
            if (cls != null && (field = cls.getField("semDesktopModeEnabled")) != null) {
                numValueOf = Integer.valueOf(field.getInt(configuration));
            }
            if (Intrinsics.areEqual(numValueOf2, numValueOf)) {
                return true;
            }
            return super.isDexMode(context);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/DesktopModeCompatImplFactory$DexModeCompatSem90000Impl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/DesktopModeCompatImplFactory$DexModeCompatSem80200Impl;", "<init>", "()V", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class DexModeCompatSem90000Impl extends DexModeCompatSem80200Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\tH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/DesktopModeCompatImplFactory$DexModeCompatSem90500Impl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/desktopmode/DesktopModeCompatImplFactory$DexModeCompatSem90000Impl;", "<init>", "()V", SecSearchIndexablesContract.ExtraInfo.EXTRA_KEY_DEX_MODE, "", "context", "Landroid/content/Context;", "getDexModeType", "", "getScreenLocation", "isDexModeType", "type", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class DexModeCompatSem90500Impl extends DexModeCompatSem90000Impl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.DesktopModeCompatImplFactory.DexModeCompatSem80100Impl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.DexModeCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl
        public int getDexModeType(@Nullable Context context) {
            Class<?> cls;
            Field field;
            Field field2;
            Resources resources;
            SemDesktopModeState dexState = getDexState(context);
            if (dexState != null) {
                try {
                    try {
                        Class<?> cls2 = dexState.getClass();
                        Object objInvoke = cls2.getDeclaredMethod("getEnabled", null).invoke(dexState, null);
                        Integer num = objInvoke instanceof Integer ? (Integer) objInvoke : null;
                        boolean z = num != null && num.intValue() == cls2.getDeclaredField("ENABLED").getInt(cls2);
                        Method declaredMethod = cls2.getDeclaredMethod("getDisplayType", null);
                        if (z) {
                            Object objInvoke2 = declaredMethod.invoke(dexState, null);
                            numValueOf = objInvoke2 instanceof Integer ? (Integer) objInvoke2 : null;
                            int i = cls2.getDeclaredField("DISPLAY_TYPE_DUAL").getInt(cls2);
                            if (numValueOf != null && numValueOf.intValue() == i) {
                                LoggerBase.INSTANCE.m7132d(DesktopModeCompatImplFactory.TAG, "getDexModeType : DUAL");
                                return 36864;
                            }
                            int i2 = cls2.getDeclaredField("DISPLAY_TYPE_STANDALONE").getInt(cls2);
                            if (numValueOf != null && numValueOf.intValue() == i2) {
                                LoggerBase.INSTANCE.m7132d(DesktopModeCompatImplFactory.TAG, "getDexModeType : STAND_ALONE");
                                return 32768;
                            }
                            LoggerBase.INSTANCE.m7132d(DesktopModeCompatImplFactory.TAG, "getDexModeType : NONE");
                        } else {
                            Configuration configuration = (context == null || (resources = context.getResources()) == null) ? null : resources.getConfiguration();
                            if (configuration != null) {
                                try {
                                    cls = configuration.getClass();
                                } catch (IllegalAccessException e) {
                                    LoggerBase.INSTANCE.m7133e(DesktopModeCompatImplFactory.TAG, "Failed isDexMode : " + e.getMessage());
                                } catch (IllegalArgumentException e2) {
                                    LoggerBase.INSTANCE.m7133e(DesktopModeCompatImplFactory.TAG, "Failed isDexMode : " + e2.getMessage());
                                } catch (NoSuchFieldException e3) {
                                    LoggerBase.INSTANCE.m7133e(DesktopModeCompatImplFactory.TAG, "Failed isDexMode : " + e3.getMessage());
                                }
                            } else {
                                cls = null;
                            }
                            Integer numValueOf = (cls == null || (field2 = cls.getField("DEX_MODE_NEXT_GEN")) == null) ? null : Integer.valueOf(field2.getInt(cls));
                            if (cls != null && (field = cls.getField("dexMode")) != null) {
                                numValueOf = Integer.valueOf(field.getInt(configuration));
                            }
                            if (Intrinsics.areEqual(numValueOf, numValueOf)) {
                                LoggerBase.INSTANCE.m7132d(DesktopModeCompatImplFactory.TAG, "getDexModeType : NEW DEX");
                                return 40960;
                            }
                        }
                    } catch (NoSuchMethodException e5) {
                        AbstractC0000a.m23t("Failed getDexModeType : ", e5.getMessage(), LoggerBase.INSTANCE, DesktopModeCompatImplFactory.TAG);
                    } catch (InvocationTargetException e6) {
                        AbstractC0000a.m23t("Failed getDexModeType : ", e6.getMessage(), LoggerBase.INSTANCE, DesktopModeCompatImplFactory.TAG);
                    }
                } catch (IllegalAccessException e7) {
                    AbstractC0000a.m23t("Failed getDexModeType : ", e7.getMessage(), LoggerBase.INSTANCE, DesktopModeCompatImplFactory.TAG);
                } catch (NoSuchFieldException e8) {
                    AbstractC0000a.m23t("Failed getDexModeType : ", e8.getMessage(), LoggerBase.INSTANCE, DesktopModeCompatImplFactory.TAG);
                }
            }
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.DesktopModeCompatImplFactory.DexModeCompatSem80100Impl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.DexModeCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl
        public int getScreenLocation(@Nullable Context context) {
            int dexModeType = getDexModeType(context);
            if (super.isDexMode(context)) {
                LoggerBase.INSTANCE.m7132d(DesktopModeCompatImplFactory.TAG, "getScreenLocation. : DEX_ON_SCREEN");
                return 256;
            }
            if (dexModeType == 36864) {
                LoggerBase.INSTANCE.m7132d(DesktopModeCompatImplFactory.TAG, "getScreenLocation. : DEX_ON_DEVICE");
                return 512;
            }
            LoggerBase.INSTANCE.m7132d(DesktopModeCompatImplFactory.TAG, "getScreenLocation. : DEX_OFF_MODE");
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.DesktopModeCompatImplFactory.DexModeCompatSem80200Impl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.DesktopModeCompatImplFactory.DexModeCompatSem80100Impl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.DexModeCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl
        public boolean isDexMode(@Nullable Context context) {
            return getScreenLocation(context) == 256;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.DesktopModeCompatImplFactory.DexModeCompatSem80100Impl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.DexModeCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl
        public boolean isDexModeType(@Nullable Context context, int type) {
            return getDexModeType(context) == type;
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.desktopmode.AbsDesktopModeCompatImplFactory
    @NotNull
    public AbsDesktopModeCompatImplFactory.IDesktopModeCompatImpl create(int deviceType) {
        int semPlatformVersionInt = DeviceInfo.getSemPlatformVersionInt(0);
        return (deviceType != 2 || semPlatformVersionInt < 80100) ? super.create(deviceType) : semPlatformVersionInt < 80200 ? new DexModeCompatSem80100Impl() : semPlatformVersionInt < 90000 ? new DexModeCompatSem80200Impl() : semPlatformVersionInt < 90500 ? new DexModeCompatSem90000Impl() : semPlatformVersionInt < 170000 ? new DexModeCompatSem90500Impl() : new DexModeCompatSem170000mpl();
    }
}
