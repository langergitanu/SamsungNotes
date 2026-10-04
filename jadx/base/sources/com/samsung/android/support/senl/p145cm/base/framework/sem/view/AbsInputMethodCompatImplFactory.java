package com.samsung.android.support.senl.p145cm.base.framework.sem.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000 \n2\u00020\u0001:\u0003\b\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsInputMethodCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsInputMethodCompatImplFactory$IInputMethodCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "IInputMethodCompatImpl", "InputMethodCompatPureImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsInputMethodCompatImplFactory {

    @NotNull
    private static final String TAG = "InputMethodCompatImpl";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static int sHasSoftKey = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsInputMethodCompatImplFactory$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "sHasSoftKey", "", "hasSoftKey", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean hasSoftKey() {
            int i;
            Resources resources;
            if (AbsInputMethodCompatImplFactory.sHasSoftKey == -1) {
                Context applicationContext = BaseUtils.getApplicationContext();
                Integer numValueOf = (applicationContext == null || (resources = applicationContext.getResources()) == null) ? null : Integer.valueOf(resources.getIdentifier("config_showNavigationBar", "bool", TelemetryEventStrings.C6439Os.OS_NAME));
                if (numValueOf != null) {
                    if (numValueOf.intValue() > 0) {
                        i = applicationContext.getResources().getBoolean(numValueOf.intValue()) ? 1 : 0;
                    } else {
                        try {
                            i = !KeyCharacterMap.deviceHasKey(4) ? 1 : 0;
                        } catch (Exception unused) {
                            return false;
                        }
                    }
                    AbsInputMethodCompatImplFactory.sHasSoftKey = i;
                }
            }
            LoggerBase.INSTANCE.m7132d(AbsInputMethodCompatImplFactory.TAG, "hasSoftKey " + AbsInputMethodCompatImplFactory.sHasSoftKey);
            return AbsInputMethodCompatImplFactory.sHasSoftKey == 1;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J$\u0010\u0013\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u0011H&J\u001c\u0010\u0016\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u001e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\rH&¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsInputMethodCompatImplFactory$IInputMethodCompatImpl;", "", "isEnabledMobileKeyboard", "", "context", "Landroid/content/Context;", "isInputMethodShown", "imm", "Landroid/view/inputmethod/InputMethodManager;", "forceHideSoftInput", "", "minimizeSoftInput", VPathDataCmd.RCurveTo, "Landroid/view/View;", "isKeyboardConnected", "configShowNavigationBar", "getNavigationBarHeight", "", "getNavigationBarHeightIgnoreHasSoftKey", "showNavigationBar", "rootView", "visibility", "hideNavigationBar", "hideNavigationBarForcibly", "window", "Landroid/view/Window;", "isPenDetectionSettingOn", "isNavigationBarHidden", "getKeyboardSettingsSelectedLanguage", "", "isHoneyBoardSIP", "view", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IInputMethodCompatImpl {
        boolean configShowNavigationBar(@Nullable Context context);

        void forceHideSoftInput(@Nullable InputMethodManager imm);

        @Nullable
        String getKeyboardSettingsSelectedLanguage(@Nullable Context context);

        int getNavigationBarHeight(@Nullable Context context);

        int getNavigationBarHeightIgnoreHasSoftKey(@Nullable Context context);

        void hideNavigationBar(@Nullable Context context, @Nullable View rootView);

        void hideNavigationBarForcibly(@Nullable Window window);

        boolean isEnabledMobileKeyboard(@Nullable Context context);

        boolean isHoneyBoardSIP(@Nullable Context context, @Nullable View view);

        boolean isInputMethodShown(@Nullable InputMethodManager imm);

        boolean isKeyboardConnected(@Nullable InputMethodManager imm);

        boolean isNavigationBarHidden(@Nullable Context context);

        boolean isPenDetectionSettingOn(@Nullable Context context);

        boolean minimizeSoftInput(@Nullable InputMethodManager imm, @Nullable View v);

        void showNavigationBar(@Nullable Context context, @Nullable View rootView, int visibility);
    }

    @JvmStatic
    public static final boolean hasSoftKey() {
        return INSTANCE.hasSoftKey();
    }

    @NotNull
    public IInputMethodCompatImpl create(int deviceType) {
        return new InputMethodCompatPureImpl();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0015\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u001c\u0010\u0018\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0019\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010 \u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsInputMethodCompatImplFactory$InputMethodCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsInputMethodCompatImplFactory$IInputMethodCompatImpl;", "<init>", "()V", "isEnabledMobileKeyboard", "", "context", "Landroid/content/Context;", "isInputMethodShown", "imm", "Landroid/view/inputmethod/InputMethodManager;", "forceHideSoftInput", "", "minimizeSoftInput", VPathDataCmd.RCurveTo, "Landroid/view/View;", "isKeyboardConnected", "configShowNavigationBar", "getNavigationBarHeight", "", "getNavigationBarHeightIgnoreHasSoftKey", "showNavigationBar", "rootView", "visibility", "hideNavigationBar", "hideNavigationBarForcibly", "window", "Landroid/view/Window;", "isPenDetectionSettingOn", "isNavigationBarHidden", "getKeyboardSettingsSelectedLanguage", "", "isHoneyBoardSIP", "view", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nAbsInputMethodCompatImplFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbsInputMethodCompatImplFactory.kt\ncom/samsung/android/support/senl/cm/base/framework/sem/view/AbsInputMethodCompatImplFactory$InputMethodCompatPureImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,229:1\n1#2:230\n*E\n"})
    public static final class InputMethodCompatPureImpl implements IInputMethodCompatImpl {
        private static final int KEYBOARD_BT = 2;
        private static final int KEYBOARD_USB = 4;
        private static final int MOBILEKEYBOARD_COVERED_YES = 1;

        @NotNull
        private static final String TAG = "InputMethodDelegatePureImpl";

        @Nullable
        private static Method forceHideSoftInput;

        @Nullable
        private static Method isAccessoryKeyboardState;

        @Nullable
        private static Method isInputMethodShown;

        @Nullable
        private static Method minimizeSoftInput;

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public boolean configShowNavigationBar(@Nullable Context context) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public void forceHideSoftInput(@Nullable InputMethodManager imm) {
            if (imm != null) {
                try {
                    if (forceHideSoftInput == null) {
                        forceHideSoftInput = imm.getClass().getMethod("forceHideSoftInput", null);
                    }
                    Method method = forceHideSoftInput;
                    if (method != null) {
                        method.invoke(method, null);
                    }
                } catch (Exception e) {
                    LoggerBase.INSTANCE.m7132d(TAG, "Exception: " + e.getMessage());
                }
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        @Nullable
        public String getKeyboardSettingsSelectedLanguage(@Nullable Context context) {
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public int getNavigationBarHeight(@Nullable Context context) {
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public int getNavigationBarHeightIgnoreHasSoftKey(@Nullable Context context) {
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public boolean isEnabledMobileKeyboard(@Nullable Context context) {
            Resources resources;
            Configuration configuration = (context == null || (resources = context.getResources()) == null) ? null : resources.getConfiguration();
            try {
                Field field = Configuration.class.getField("mobileKeyboardCovered");
                if (field != null && field.getInt(configuration) == 1) {
                    LoggerBase.INSTANCE.m7132d(TAG, "isEnabledMobileKeyboard return true");
                    return true;
                }
            } catch (IllegalAccessException unused) {
                LoggerBase.INSTANCE.m7132d(TAG, "isEnabledMobileKeyboard does not support mobileKeyboardCoverd field");
            } catch (NoSuchFieldException unused2) {
                LoggerBase.INSTANCE.m7132d(TAG, "isEnabledMobileKeyboard does not support mobileKeyboardCoverd field");
            }
            LoggerBase.INSTANCE.m7132d(TAG, "isEnabledMobileKeyboard return false");
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public boolean isHoneyBoardSIP(@Nullable Context context, @Nullable View view) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public boolean isInputMethodShown(@Nullable InputMethodManager imm) {
            if (imm == null) {
                return false;
            }
            try {
                if (isInputMethodShown == null) {
                    isInputMethodShown = imm.getClass().getMethod("isInputMethodShown", null);
                }
                Method method = isInputMethodShown;
                Object objInvoke = method != null ? method.invoke(imm, null) : null;
                return Intrinsics.areEqual(objInvoke instanceof Boolean ? (Boolean) objInvoke : null, Boolean.TRUE);
            } catch (IllegalAccessException e) {
                AbstractC0000a.m23t("isInputMethodShown, e : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                return false;
            } catch (NoSuchMethodException e2) {
                AbstractC0000a.m23t("isInputMethodShown, e : ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
                return false;
            } catch (InvocationTargetException e3) {
                AbstractC0000a.m23t("isInputMethodShown, e : ", e3.getMessage(), LoggerBase.INSTANCE, TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public boolean isKeyboardConnected(@Nullable InputMethodManager imm) {
            if (imm == null) {
                return false;
            }
            try {
                if (isAccessoryKeyboardState == null) {
                    isAccessoryKeyboardState = imm.getClass().getMethod("isAccessoryKeyboardState", null);
                }
                Method method = isAccessoryKeyboardState;
                if (!((method != null ? method.invoke(imm, null) : null) instanceof Integer)) {
                    return false;
                }
                Method method2 = isAccessoryKeyboardState;
                Object objInvoke = method2 != null ? method2.invoke(imm, null) : null;
                Integer num = objInvoke instanceof Integer ? (Integer) objInvoke : null;
                LoggerBase.INSTANCE.m7132d(TAG, "isAccessoryKeyboardState " + (num == null ? "null" : num));
                if (num != null && num.intValue() == 2) {
                    return true;
                }
                if (num == null) {
                    return false;
                }
                return num.intValue() == 4;
            } catch (IllegalAccessException unused) {
                LoggerBase.INSTANCE.m7133e(TAG, "Fail to invoke isAccessoryKeyboardState");
                return false;
            } catch (IllegalArgumentException unused2) {
                LoggerBase.INSTANCE.m7133e(TAG, "Fail to invoke isAccessoryKeyboardState");
                return false;
            } catch (NoSuchMethodException unused3) {
                LoggerBase.INSTANCE.m7133e(TAG, "Fail to invoke isAccessoryKeyboardState");
                return false;
            } catch (InvocationTargetException unused4) {
                LoggerBase.INSTANCE.m7133e(TAG, "Fail to invoke isAccessoryKeyboardState");
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public boolean isNavigationBarHidden(@Nullable Context context) {
            return (context != null && ViewConfiguration.get(context).hasPermanentMenuKey()) || KeyCharacterMap.deviceHasKey(4);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public boolean isPenDetectionSettingOn(@Nullable Context context) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public boolean minimizeSoftInput(@Nullable InputMethodManager imm, @Nullable View v) throws IllegalAccessException {
            if (imm == null || !imm.isActive()) {
                return false;
            }
            try {
                if (minimizeSoftInput == null) {
                    minimizeSoftInput = imm.getClass().getMethod("minimizeSoftInput", IBinder.class, Integer.TYPE);
                }
                Method method = minimizeSoftInput;
                if (method == null) {
                    return true;
                }
                method.invoke(imm, v != null ? v.getWindowToken() : null, 22);
                return true;
            } catch (Exception e) {
                LoggerBase.INSTANCE.m7134e(TAG, "minimizeSoftInput", e);
                throw new IllegalAccessException();
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public void hideNavigationBarForcibly(@Nullable Window window) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public void hideNavigationBar(@Nullable Context context, @Nullable View rootView) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public void showNavigationBar(@Nullable Context context, @Nullable View rootView, int visibility) {
        }
    }
}
