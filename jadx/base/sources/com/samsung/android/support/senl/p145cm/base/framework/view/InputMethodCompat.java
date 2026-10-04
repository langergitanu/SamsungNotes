package com.samsung.android.support.senl.p145cm.base.framework.view;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.app.KeyguardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.AbsInputMethodCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.InputMethodCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BOOLEAN;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0001/B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\"\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\bJ\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\rJ$\u0010\u000f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0013\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\"\u0010\u0014\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\bJ\u0010\u0010\u0016\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J$\u0010\u0018\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\bH\u0007J$\u0010\u0018\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\"\u0010\u0018\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u001f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010 \u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010!\u001a\u00020\u001e2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\"\u001a\u00020\u001e2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\"\u0010#\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010$\u001a\u0004\u0018\u00010\r2\u0006\u0010%\u001a\u00020\u001eJ\u001a\u0010&\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010$\u001a\u0004\u0018\u00010\rJ\u0010\u0010'\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010*\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010+\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0012\u0010,\u001a\u0004\u0018\u00010-2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u001a\u0010.\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/InputMethodCompat;", "", "impl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsInputMethodCompatImplFactory$IInputMethodCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsInputMethodCompatImplFactory$IInputMethodCompatImpl;)V", "mImpl", "isEnabledMobileKeyboard", "", "context", "Landroid/content/Context;", "isInputMethodShown", "view", "Landroid/view/View;", "mobileKeyboard", "hideSoftInput", VPathDataCmd.RCurveTo, "receiver", "Landroid/os/ResultReceiver;", "forceHideSoftInput", "minimizeSoftInput", "forceHide", "isShowImeWithHardKeyboardEnabled", "isShowImeWithHardKeyboardEnabledForDexDualMode", "showSoftInput", "isDexDualMode", "", "sipBundle", "Landroid/os/Bundle;", "getInputMethodWindowVisibleHeight", "", "isKeyboardConnected", "configShowNavigationBar", "getNavigationBarHeight", "getNavigationBarHeightIgnoreHasSoftKey", "showNavigationBar", "rootView", "visibility", "hideNavigationBar", "hideNavigationBarForcibly", "window", "Landroid/view/Window;", "isPenDetectionSettingOn", "isNavigationBarHidden", "getKeyboardSettingsSelectedLanguage", "", "canShowHoneyBoardSIP", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InputMethodCompat {

    @NotNull
    public static final String ACTION_SHOW_BOARD = "com.samsung.android.honeyboard.action.SHOW_BOARD";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EXTRA_KEY_BOARD = "board";

    @NotNull
    public static final String EXTRA_VALUE_BOARD_EAGLE_EYE = "eagle_eye";

    @NotNull
    public static final String EXTRA_VALUE_BOARD_HBD_TRANSLATE = "translation";

    @NotNull
    public static final String TAG = "InputMethodCompat";

    @Nullable
    private static InputMethodCompat sInstance;

    @Nullable
    private AbsInputMethodCompatImplFactory.IInputMethodCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/InputMethodCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "ACTION_SHOW_BOARD", "EXTRA_KEY_BOARD", "EXTRA_VALUE_BOARD_EAGLE_EYE", "EXTRA_VALUE_BOARD_HBD_TRANSLATE", "sInstance", "Lcom/samsung/android/support/senl/cm/base/framework/view/InputMethodCompat;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/view/InputMethodCompat;", "hasSoftKey", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized InputMethodCompat getInstance() {
            InputMethodCompat inputMethodCompat;
            try {
                if (InputMethodCompat.sInstance == null) {
                    InputMethodCompat.sInstance = new InputMethodCompat(new InputMethodCompatImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                inputMethodCompat = InputMethodCompat.sInstance;
                Intrinsics.checkNotNull(inputMethodCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.view.InputMethodCompat");
            } catch (Throwable th) {
                throw th;
            }
            return inputMethodCompat;
        }

        public final boolean hasSoftKey() {
            return AbsInputMethodCompatImplFactory.INSTANCE.hasSoftKey();
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    public /* synthetic */ InputMethodCompat(AbsInputMethodCompatImplFactory.IInputMethodCompatImpl iInputMethodCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iInputMethodCompatImpl);
    }

    @NotNull
    public static final synchronized InputMethodCompat getInstance() {
        return INSTANCE.getInstance();
    }

    private final boolean isShowImeWithHardKeyboardEnabledForDexDualMode(Context context) {
        BOOLEAN booleanIsShowImeWithHardKeyboardEnabledForDex = SettingsCompat.INSTANCE.getInstance().isShowImeWithHardKeyboardEnabledForDex(context);
        if (booleanIsShowImeWithHardKeyboardEnabledForDex == null || !isKeyboardConnected(context)) {
            return true;
        }
        return booleanIsShowImeWithHardKeyboardEnabledForDex.getValue();
    }

    public static /* synthetic */ boolean showSoftInput$default(InputMethodCompat inputMethodCompat, Context context, View view, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return inputMethodCompat.showSoftInput(context, view, z);
    }

    public final boolean canShowHoneyBoardSIP(@Nullable Context context, @Nullable View view) {
        if (context != null && view != null) {
            if (KeyguardManagerCompat.INSTANCE.getInstance().isKeyguardLocked(context)) {
                LoggerBase.INSTANCE.m7137i(TAG, "canShowHoneyBoardSIP# cannot show clipboard, caused by isKeyguardLocked is true.");
                return false;
            }
            if (!isShowImeWithHardKeyboardEnabled(context)) {
                LoggerBase.INSTANCE.m7137i(TAG, "canShowHoneyBoardSIP# isShowImeWithHardKeyboardEnabled is false");
                return false;
            }
            Object systemService = context.getSystemService("input_method");
            InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
            if (view.requestFocus() && inputMethodManager != null && inputMethodManager.isActive()) {
                AbsInputMethodCompatImplFactory.IInputMethodCompatImpl iInputMethodCompatImpl = this.mImpl;
                if (iInputMethodCompatImpl != null) {
                    return iInputMethodCompatImpl.isHoneyBoardSIP(context, view);
                }
                return false;
            }
            LoggerBase.INSTANCE.m7137i(TAG, "canShowHoneyBoardSIP# view focus or imm.isActive() has problem.");
        }
        return false;
    }

    public final boolean configShowNavigationBar(@Nullable Context context) {
        AbsInputMethodCompatImplFactory.IInputMethodCompatImpl iInputMethodCompatImpl;
        if (context == null || (iInputMethodCompatImpl = this.mImpl) == null) {
            return false;
        }
        return iInputMethodCompatImpl.configShowNavigationBar(context);
    }

    public final boolean forceHideSoftInput(@Nullable Context context) {
        if (context == null) {
            return false;
        }
        AbsInputMethodCompatImplFactory.IInputMethodCompatImpl iInputMethodCompatImpl = this.mImpl;
        if (iInputMethodCompatImpl == null) {
            return true;
        }
        Object systemService = context.getSystemService("input_method");
        iInputMethodCompatImpl.forceHideSoftInput(systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null);
        return true;
    }

    public final int getInputMethodWindowVisibleHeight(@Nullable Context context) {
        Method method;
        Object objInvoke = null;
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            try {
                method = inputMethodManager.getClass().getMethod("getInputMethodWindowVisibleHeight", null);
            } catch (NoSuchMethodException unused) {
                LoggerBase.INSTANCE.m7133e(TAG, "getCurrentSIPHeight() : NoSuchMethodException");
                return 0;
            }
        } else {
            method = null;
        }
        if (method != null) {
            try {
                objInvoke = method.invoke(inputMethodManager, null);
            } catch (IllegalAccessException unused2) {
                LoggerBase.INSTANCE.m7133e(TAG, "getCurrentSIPHeight() : IllegalAccessException");
                return 0;
            } catch (InvocationTargetException unused3) {
                LoggerBase.INSTANCE.m7133e(TAG, "getCurrentSIPHeight() : InvocationTargetException");
                return 0;
            }
        }
        Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objInvoke).intValue();
    }

    @Nullable
    public final String getKeyboardSettingsSelectedLanguage(@Nullable Context context) {
        AbsInputMethodCompatImplFactory.IInputMethodCompatImpl iInputMethodCompatImpl;
        if (context == null || (iInputMethodCompatImpl = this.mImpl) == null) {
            return null;
        }
        return iInputMethodCompatImpl.getKeyboardSettingsSelectedLanguage(context);
    }

    public final int getNavigationBarHeight(@Nullable Context context) {
        AbsInputMethodCompatImplFactory.IInputMethodCompatImpl iInputMethodCompatImpl;
        if (context == null || (iInputMethodCompatImpl = this.mImpl) == null) {
            return 0;
        }
        return iInputMethodCompatImpl.getNavigationBarHeight(context);
    }

    public final int getNavigationBarHeightIgnoreHasSoftKey(@Nullable Context context) {
        AbsInputMethodCompatImplFactory.IInputMethodCompatImpl iInputMethodCompatImpl;
        if (context == null || !configShowNavigationBar(context) || (iInputMethodCompatImpl = this.mImpl) == null) {
            return 0;
        }
        return iInputMethodCompatImpl.getNavigationBarHeightIgnoreHasSoftKey(context);
    }

    public final boolean hideNavigationBar(@Nullable Context context, @Nullable View rootView) {
        if (context == null || rootView == null) {
            return false;
        }
        AbsInputMethodCompatImplFactory.IInputMethodCompatImpl iInputMethodCompatImpl = this.mImpl;
        if (iInputMethodCompatImpl == null) {
            return true;
        }
        iInputMethodCompatImpl.hideNavigationBar(context, rootView);
        return true;
    }

    public final void hideNavigationBarForcibly(@Nullable Window window) {
        AbsInputMethodCompatImplFactory.IInputMethodCompatImpl iInputMethodCompatImpl;
        if (window == null || (iInputMethodCompatImpl = this.mImpl) == null) {
            return;
        }
        iInputMethodCompatImpl.hideNavigationBarForcibly(window);
    }

    public final boolean hideSoftInput(@Nullable Context context, @Nullable View v) {
        LoggerBase.INSTANCE.m7137i(TAG, "hideSoftInput");
        if (context != null && v != null) {
            Object systemService = context.getSystemService("input_method");
            InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                return true;
            }
        }
        return false;
    }

    public final boolean isEnabledMobileKeyboard(@Nullable Context context) {
        AbsInputMethodCompatImplFactory.IInputMethodCompatImpl iInputMethodCompatImpl;
        if (context == null || (iInputMethodCompatImpl = this.mImpl) == null) {
            return false;
        }
        return iInputMethodCompatImpl.isEnabledMobileKeyboard(context);
    }

    public final boolean isInputMethodShown(@Nullable Context context, @Nullable View view, boolean mobileKeyboard) {
        if (context == null || view == null || (mobileKeyboard && isEnabledMobileKeyboard(context))) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 36) {
            WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
            if (rootWindowInsets != null) {
                return rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime());
            }
            return false;
        }
        AbsInputMethodCompatImplFactory.IInputMethodCompatImpl iInputMethodCompatImpl = this.mImpl;
        if (iInputMethodCompatImpl == null) {
            return false;
        }
        Object systemService = context.getSystemService("input_method");
        return iInputMethodCompatImpl.isInputMethodShown(systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null);
    }

    public final boolean isKeyboardConnected(@Nullable Context context) {
        AbsInputMethodCompatImplFactory.IInputMethodCompatImpl iInputMethodCompatImpl;
        if (context == null || (iInputMethodCompatImpl = this.mImpl) == null) {
            return false;
        }
        Object systemService = context.getSystemService("input_method");
        return iInputMethodCompatImpl.isKeyboardConnected(systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null);
    }

    public final boolean isNavigationBarHidden(@Nullable Context context) {
        AbsInputMethodCompatImplFactory.IInputMethodCompatImpl iInputMethodCompatImpl;
        if (context == null || (iInputMethodCompatImpl = this.mImpl) == null) {
            return false;
        }
        return iInputMethodCompatImpl.isNavigationBarHidden(context);
    }

    public final boolean isPenDetectionSettingOn(@Nullable Context context) {
        AbsInputMethodCompatImplFactory.IInputMethodCompatImpl iInputMethodCompatImpl;
        if (context == null || (iInputMethodCompatImpl = this.mImpl) == null) {
            return false;
        }
        return iInputMethodCompatImpl.isPenDetectionSettingOn(context);
    }

    public final boolean isShowImeWithHardKeyboardEnabled(@Nullable Context context) {
        BOOLEAN booleanIsShowImeWithHardKeyboardEnabled = SettingsCompat.INSTANCE.getInstance().isShowImeWithHardKeyboardEnabled(context);
        if (booleanIsShowImeWithHardKeyboardEnabled == null || !isKeyboardConnected(context)) {
            return true;
        }
        return booleanIsShowImeWithHardKeyboardEnabled.getValue();
    }

    public final boolean minimizeSoftInput(@Nullable Context context, @Nullable View v, boolean forceHide) {
        if (context != null && v != null) {
            try {
                AbsInputMethodCompatImplFactory.IInputMethodCompatImpl iInputMethodCompatImpl = this.mImpl;
                if (iInputMethodCompatImpl == null) {
                    return false;
                }
                Object systemService = context.getSystemService("input_method");
                return iInputMethodCompatImpl.minimizeSoftInput(systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null, v);
            } catch (IllegalAccessException unused) {
                if (forceHide) {
                    hideSoftInput(context, v);
                }
            }
        }
        return false;
    }

    public final boolean showNavigationBar(@Nullable Context context, @Nullable View rootView, int visibility) {
        if (context == null || rootView == null) {
            return false;
        }
        AbsInputMethodCompatImplFactory.IInputMethodCompatImpl iInputMethodCompatImpl = this.mImpl;
        if (iInputMethodCompatImpl == null) {
            return true;
        }
        iInputMethodCompatImpl.showNavigationBar(context, rootView, visibility);
        return true;
    }

    @JvmOverloads
    public final boolean showSoftInput(@Nullable Context context, @NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        return showSoftInput$default(this, context, v, false, 4, null);
    }

    private InputMethodCompat(AbsInputMethodCompatImplFactory.IInputMethodCompatImpl iInputMethodCompatImpl) {
        this.mImpl = iInputMethodCompatImpl;
    }

    @JvmOverloads
    public final boolean showSoftInput(@Nullable Context context, @NotNull View v, boolean isDexDualMode) {
        Intrinsics.checkNotNullParameter(v, "v");
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7137i(TAG, "showSoftInput# " + v);
        int i = 0;
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager == null) {
            companion.m7133e(TAG, "showSoftInput# InputMethodManager is null");
            return false;
        }
        if (!isDexDualMode ? !isShowImeWithHardKeyboardEnabled(context) : !isShowImeWithHardKeyboardEnabledForDexDualMode(context)) {
            i = 1;
        }
        return inputMethodManager.showSoftInput(v, i);
    }

    public final boolean hideSoftInput(@Nullable Context context, @Nullable View v, @Nullable ResultReceiver receiver) {
        LoggerBase.INSTANCE.m7137i(TAG, "HideSoftInput");
        if (context != null && v != null) {
            Object systemService = context.getSystemService("input_method");
            InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0, receiver);
                return true;
            }
        }
        return false;
    }

    public final boolean showSoftInput(@Nullable Context context, @Nullable View v, @Nullable ResultReceiver receiver) {
        LoggerBase.INSTANCE.m7137i(TAG, "ShowSoftInput# ResultReceiver");
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            return inputMethodManager.showSoftInput(v, !isShowImeWithHardKeyboardEnabled(context) ? 1 : 0, receiver);
        }
        return false;
    }

    public final void showSoftInput(@NotNull Context context, @Nullable View view, @Nullable Bundle sipBundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7137i(TAG, "ShowSoftInput# Bundle");
        Object systemService = context.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager == null) {
            companion.m7133e(TAG, "ShowSoftInput# Bundle# InputMethodManager is null");
        } else {
            inputMethodManager.sendAppPrivateCommand(view, "com.samsung.android.honeyboard.action.SHOW_BOARD", sipBundle);
            inputMethodManager.showSoftInput(view, 0);
        }
    }
}
