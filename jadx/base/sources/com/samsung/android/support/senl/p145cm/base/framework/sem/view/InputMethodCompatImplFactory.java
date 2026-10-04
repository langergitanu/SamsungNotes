package com.samsung.android.support.senl.p145cm.base.framework.sem.view;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.RequiresApi;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.AbsInputMethodCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/InputMethodCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsInputMethodCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsInputMethodCompatImplFactory$IInputMethodCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "InputMethodCompatSemHoneyboardImpl", "InputMethodCompatSemPOSImpl", "InputMethodCompatSemImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InputMethodCompatImplFactory extends AbsInputMethodCompatImplFactory {

    @NotNull
    private static final String DEFAULT_SAMSUNGKEYBOARD_PKG_NAME = "com.sec.android.inputmethod";

    @NotNull
    private static final String HONEYBOARD_SETTINGS_PROVIDER = "content://com.samsung.android.honeyboard.provider.KeyboardSettingsProvider";

    @NotNull
    private static final String KEYBOARD_SETTINGS_PROVIDER = "content://com.sec.android.inputmethod.implement.setting.provider.KeyboardSettingsProvider";

    @NotNull
    private static final String SAMSUNG_HONEYBOARD_PKG_NAME = "com.samsung.android.honeyboard";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/InputMethodCompatImplFactory$InputMethodCompatSemHoneyboardImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/InputMethodCompatImplFactory$InputMethodCompatSemPOSImpl;", "<init>", "()V", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class InputMethodCompatSemHoneyboardImpl extends InputMethodCompatSemPOSImpl {
        public InputMethodCompatSemHoneyboardImpl() {
            setMSamsungKeyboardSettingsProvider(InputMethodCompatImplFactory.HONEYBOARD_SETTINGS_PROVIDER);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0012\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0013\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u001b\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\u001c\u0010\u001e\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!H\u0017J\u0012\u0010\"\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0017J\u0012\u0010#\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0014\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0017J\u001c\u0010%\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010&\u001a\u0004\u0018\u00010\u0015H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/InputMethodCompatImplFactory$InputMethodCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsInputMethodCompatImplFactory$IInputMethodCompatImpl;", "<init>", "()V", "mSamsungKeyboardSettingsProvider", "", "getMSamsungKeyboardSettingsProvider", "()Ljava/lang/String;", "setMSamsungKeyboardSettingsProvider", "(Ljava/lang/String;)V", "isEnabledMobileKeyboard", "", "context", "Landroid/content/Context;", "isInputMethodShown", "imm", "Landroid/view/inputmethod/InputMethodManager;", "forceHideSoftInput", "", "minimizeSoftInput", VPathDataCmd.RCurveTo, "Landroid/view/View;", "isKeyboardConnected", "configShowNavigationBar", "getNavigationBarHeight", "", "getNavigationBarHeightIgnoreHasSoftKey", "showNavigationBar", "rootView", "visibility", "hideNavigationBar", "hideNavigationBarForcibly", "window", "Landroid/view/Window;", "isPenDetectionSettingOn", "isNavigationBarHidden", "getKeyboardSettingsSelectedLanguage", "isHoneyBoardSIP", "view", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nInputMethodCompatImplFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InputMethodCompatImplFactory.kt\ncom/samsung/android/support/senl/cm/base/framework/sem/view/InputMethodCompatImplFactory$InputMethodCompatSemImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,277:1\n1#2:278\n*E\n"})
    public static class InputMethodCompatSemImpl implements AbsInputMethodCompatImplFactory.IInputMethodCompatImpl {

        @NotNull
        private static final String TAG = "InputMethodDelegateSemImpl";

        @NotNull
        private String mSamsungKeyboardSettingsProvider = InputMethodCompatImplFactory.KEYBOARD_SETTINGS_PROVIDER;

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public boolean configShowNavigationBar(@Nullable Context context) {
            Resources resources = context != null ? context.getResources() : null;
            Integer numValueOf = resources != null ? Integer.valueOf(resources.getIdentifier("config_showNavigationBar", "bool", TelemetryEventStrings.C6439Os.OS_NAME)) : null;
            if (numValueOf == null) {
                return false;
            }
            LoggerBase.INSTANCE.m7132d(TAG, "configShowNavigationBar id/res.getBoolean(id) : " + numValueOf + "/" + resources.getBoolean(numValueOf.intValue()));
            return numValueOf.intValue() > 0 && resources.getBoolean(numValueOf.intValue());
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public void forceHideSoftInput(@Nullable InputMethodManager imm) {
            if (imm != null) {
                try {
                    imm.semForceHideSoftInput();
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("forceHideSoftInput: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:62:? A[SYNTHETIC] */
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        @SuppressLint({"Range"})
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String getKeyboardSettingsSelectedLanguage(@Nullable Context context) throws Throwable {
            Exception exc;
            Cursor cursor;
            Throwable th;
            String string;
            String[] strArr = {"selected_language_list"};
            Cursor cursor2 = null;
            string = null;
            string = null;
            String string2 = null;
            if (context != null) {
                try {
                    ContentResolver contentResolver = context.getContentResolver();
                    Cursor cursorQuery = contentResolver != null ? contentResolver.query(Uri.parse(this.mSamsungKeyboardSettingsProvider), null, null, strArr, null) : null;
                    if (cursorQuery != null) {
                        while (cursorQuery.moveToNext()) {
                            try {
                                int columnIndex = cursorQuery.getColumnIndex("NAME");
                                if (columnIndex != -1 && (string = cursorQuery.getString(columnIndex)) != null && string.length() != 0 && Intrinsics.areEqual(cursorQuery.getString(cursorQuery.getColumnIndex("NAME")), "selected_language_list")) {
                                    string2 = cursorQuery.getString(cursorQuery.getColumnIndex("VALUE"));
                                }
                            } catch (Exception e) {
                                cursor = cursorQuery;
                                exc = e;
                                try {
                                    LoggerBase.INSTANCE.m7133e(TAG, "getKeyboardSettingsSelectedLanguage: error while get SIP setting] " + exc.getMessage());
                                    if (cursor != null) {
                                    }
                                    return string2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    cursor2 = cursor;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                cursor2 = cursorQuery;
                                th = th;
                                if (cursor2 == null) {
                                }
                            }
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    LoggerBase.INSTANCE.m7132d(TAG, "getKeyboardSettingsSelectedLanguage, result " + string2);
                    return string2;
                } catch (Exception e2) {
                    exc = e2;
                    cursor = null;
                    LoggerBase.INSTANCE.m7133e(TAG, "getKeyboardSettingsSelectedLanguage: error while get SIP setting] " + exc.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                    return string2;
                } catch (Throwable th4) {
                    th = th4;
                    th = th;
                    if (cursor2 == null) {
                    }
                }
            }
            if (cursor2 == null) {
                throw th;
            }
            cursor2.close();
            throw th;
        }

        @NotNull
        public final String getMSamsungKeyboardSettingsProvider() {
            return this.mSamsungKeyboardSettingsProvider;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public int getNavigationBarHeight(@Nullable Context context) {
            if (!AbsInputMethodCompatImplFactory.INSTANCE.hasSoftKey()) {
                return 0;
            }
            Resources resources = context != null ? context.getResources() : null;
            Integer numValueOf = resources != null ? Integer.valueOf(resources.getIdentifier("navigation_bar_height", AbsExecuteBinding.TYPE_DIMEN, TelemetryEventStrings.C6439Os.OS_NAME)) : null;
            if (numValueOf != null) {
                return resources.getDimensionPixelSize(numValueOf.intValue());
            }
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public int getNavigationBarHeightIgnoreHasSoftKey(@Nullable Context context) {
            Resources resources = context != null ? context.getResources() : null;
            Integer numValueOf = resources != null ? Integer.valueOf(resources.getIdentifier("navigation_bar_height", AbsExecuteBinding.TYPE_DIMEN, TelemetryEventStrings.C6439Os.OS_NAME)) : null;
            if (numValueOf != null) {
                return resources.getDimensionPixelSize(numValueOf.intValue());
            }
            return 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public void hideNavigationBar(@Nullable Context context, @Nullable View rootView) {
            LoggerBase.Companion companion = LoggerBase.INSTANCE;
            companion.m7132d(TAG, "hideNavigationBar");
            if (configShowNavigationBar(context) && rootView != null && (rootView.getSystemUiVisibility() & 2) == 0) {
                companion.m7132d(TAG, "hideNavigationBar " + rootView);
                rootView.setSystemUiVisibility(rootView.getSystemUiVisibility() | 23070722);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        @RequiresApi(api = 30)
        public void hideNavigationBarForcibly(@Nullable Window window) {
            WindowInsetsController insetsController;
            LoggerBase.INSTANCE.m7132d(TAG, "hideNavigationBarForcibly");
            if (window != null) {
                try {
                    insetsController = window.getInsetsController();
                } catch (Exception e) {
                    AbstractC0000a.m23t("hideNavigationBarForcibly: error ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                    return;
                }
            } else {
                insetsController = null;
            }
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.navigationBars());
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public boolean isEnabledMobileKeyboard(@Nullable Context context) {
            Resources resources;
            Configuration configuration = (context == null || (resources = context.getResources()) == null) ? null : resources.getConfiguration();
            if (configuration == null) {
                return false;
            }
            try {
                return configuration.semMobileKeyboardCovered == 1;
            } catch (NoSuchFieldError e) {
                AbstractC0000a.m23t("isEnabledMobileKeyboard: NoSuchFieldError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public boolean isHoneyBoardSIP(@Nullable Context context, @Nullable View view) {
            if (!Intrinsics.areEqual(ClipboardManagerCompat.METHOD_ID_HONEYBOARD, Settings.Secure.getString(context != null ? context.getContentResolver() : null, "default_input_method"))) {
                LoggerBase.INSTANCE.m7137i(TAG, "isHoneyBoardSIP# defaultIME is not com.samsung.android.honeyboard/.service.HoneyBoardService");
                return false;
            }
            int semAPIVersionInt = DeviceInfo.getSemAPIVersionInt(0);
            if (semAPIVersionInt >= 2903) {
                return true;
            }
            LoggerBase.INSTANCE.m7137i(TAG, "isHoneyBoardSIP# SemAPIVersion does not support Honeyboard. " + semAPIVersionInt);
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public boolean isInputMethodShown(@Nullable InputMethodManager imm) {
            if (imm == null) {
                return false;
            }
            try {
                return imm.semIsInputMethodShown();
            } catch (NoClassDefFoundError e) {
                AbstractC0000a.m23t("isInputMethodShown: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                return false;
            } catch (NoSuchMethodError e2) {
                AbstractC0000a.m23t("isInputMethodShown: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public boolean isKeyboardConnected(@Nullable InputMethodManager imm) {
            boolean zSemIsAccessoryKeyboard = false;
            if (imm != null) {
                try {
                    zSemIsAccessoryKeyboard = imm.semIsAccessoryKeyboard();
                    LoggerBase.INSTANCE.m7132d(TAG, "semIsAccessoryKeyboard " + zSemIsAccessoryKeyboard);
                    return zSemIsAccessoryKeyboard;
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("isKeyboardConnected: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                }
            }
            return zSemIsAccessoryKeyboard;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public boolean isNavigationBarHidden(@Nullable Context context) {
            return Settings.Global.getInt(context != null ? context.getContentResolver() : null, "navigationbar_hide_bar_enabled", 0) == 1;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        @SuppressLint({"Range"})
        public boolean isPenDetectionSettingOn(@Nullable Context context) {
            boolean z;
            String string;
            String[] strArr = {"pen_detection_on"};
            boolean z2 = false;
            Cursor cursorQuery = null;
            try {
                if (context != null) {
                    try {
                        ContentResolver contentResolver = context.getContentResolver();
                        if (contentResolver != null) {
                            cursorQuery = contentResolver.query(Uri.parse(this.mSamsungKeyboardSettingsProvider), null, null, strArr, null);
                        }
                    } catch (Exception e) {
                        LoggerBase.INSTANCE.m7133e(TAG, "isPenDetectionSettingOn: error while get SIP setting] " + e.getMessage());
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return false;
                    }
                }
                if (cursorQuery != null) {
                    loop0: while (true) {
                        z = false;
                        while (cursorQuery.moveToNext()) {
                            int columnIndex = cursorQuery.getColumnIndex("NAME");
                            if (columnIndex != -1 && (string = cursorQuery.getString(columnIndex)) != null && string.length() != 0 && Intrinsics.areEqual(cursorQuery.getString(cursorQuery.getColumnIndex("NAME")), "pen_detection_on")) {
                                if (cursorQuery.getInt(cursorQuery.getColumnIndex("VALUE")) != 0) {
                                    z = true;
                                }
                            }
                        }
                    }
                    z2 = z;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                LoggerBase.INSTANCE.m7132d(TAG, "isPenDetectionSettingOn, result " + z2);
                return z2;
            } finally {
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public boolean minimizeSoftInput(@Nullable InputMethodManager imm, @Nullable View v) throws IllegalAccessException {
            if (imm == null || !imm.isActive() || v == null) {
                return false;
            }
            try {
                return imm.semMinimizeSoftInput(v.getWindowToken(), 22);
            } catch (NoSuchMethodError e) {
                LoggerBase.INSTANCE.m7133e(TAG, "minimizeSoftInput: NoSuchMethodError] " + e.getMessage());
                throw new IllegalAccessException();
            }
        }

        public final void setMSamsungKeyboardSettingsProvider(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mSamsungKeyboardSettingsProvider = str;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public void showNavigationBar(@Nullable Context context, @Nullable View rootView, int visibility) {
            LoggerBase.Companion companion = LoggerBase.INSTANCE;
            companion.m7132d(TAG, "showNavigationBar");
            if (configShowNavigationBar(context)) {
                companion.m7132d(TAG, "showNavigationBar " + rootView);
                if (rootView != null) {
                    rootView.setSystemUiVisibility(visibility);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/InputMethodCompatImplFactory$InputMethodCompatSemPOSImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/InputMethodCompatImplFactory$InputMethodCompatSemImpl;", "<init>", "()V", "isNavigationBarHidden", "", "context", "Landroid/content/Context;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class InputMethodCompatSemPOSImpl extends InputMethodCompatSemImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.InputMethodCompatImplFactory.InputMethodCompatSemImpl, com.samsung.android.support.senl.cm.base.framework.sem.view.AbsInputMethodCompatImplFactory.IInputMethodCompatImpl
        public boolean isNavigationBarHidden(@Nullable Context context) {
            return false;
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.view.AbsInputMethodCompatImplFactory
    @NotNull
    public AbsInputMethodCompatImplFactory.IInputMethodCompatImpl create(int deviceType) {
        if (deviceType != 2) {
            return super.create(deviceType);
        }
        int i = Build.VERSION.SDK_INT;
        return i >= 29 ? Intrinsics.areEqual("com.samsung.android.honeyboard", FloatingFeature.INSTANCE.getInstance().getString("SEC_FLOATING_FEATURE_SIP_CONFIG_PACKAGE_NAME", "com.sec.android.inputmethod")) ? new InputMethodCompatSemHoneyboardImpl() : new InputMethodCompatSemPOSImpl() : i >= 28 ? new InputMethodCompatSemPOSImpl() : new InputMethodCompatSemImpl();
    }
}
