package com.samsung.android.support.senl.addons.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.widget.AbstractC0541b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010\t\u001a\u00020\u0007H\u0007J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0007J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0012H\u0007J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000bH\u0007J\"\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u0012H\u0007J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0016H\u0007J&\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0007J*\u0010\u0018\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0007J\"\u0010\u0018\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u000bH\u0007J\"\u0010\u001a\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u0012H\u0007J*\u0010\u001a\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000bH\u0007J\"\u0010\u001b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\u0016H\u0007J$\u0010\u001c\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\f\u001a\u00020\rH\u0007J\u001a\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u000bH\u0003J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/utils/PreferenceUtils;", "", "<init>", "()V", "mApplicationContext", "Landroid/content/Context;", "initialize", "", "context", "close", "getBoolean", "", "preferenceName", "", "key", "defaultValue", "includePackageName", "getInt", "", "getColor", "resId", "getFloat", "", "getString", "putBoolean", "value", "putInt", "putFloat", "putString", "getPreferenceEditor", "Landroid/content/SharedPreferences$Editor;", "getPreference", "Landroid/content/SharedPreferences;", "isSetPackage", "clearPreference", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PreferenceUtils {

    @NotNull
    public static final PreferenceUtils INSTANCE = new PreferenceUtils();

    @Nullable
    private static Context mApplicationContext;

    private PreferenceUtils() {
    }

    @JvmStatic
    public static final void clearPreference(@NotNull String preferenceName) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorClear;
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(preferenceName);
        if (preference == null || (editorEdit = preference.edit()) == null || (editorClear = editorEdit.clear()) == null) {
            return;
        }
        editorClear.apply();
    }

    @JvmStatic
    public static final void close() {
    }

    @JvmStatic
    public static final boolean getBoolean(@NotNull String preferenceName, @Nullable String key, boolean defaultValue, boolean includePackageName) {
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(preferenceName, includePackageName);
        return preference != null ? preference.getBoolean(key, defaultValue) : defaultValue;
    }

    @JvmStatic
    public static final int getColor(@NotNull String preferenceName, @Nullable String key, int resId) {
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        Context context = mApplicationContext;
        Intrinsics.checkNotNull(context);
        return getInt(preferenceName, key, context.getResources().getColor(resId, null));
    }

    @JvmStatic
    public static final float getFloat(@NotNull String preferenceName, @Nullable String key, float defaultValue) {
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(preferenceName);
        return preference != null ? preference.getFloat(key, defaultValue) : defaultValue;
    }

    @JvmStatic
    public static final int getInt(@NotNull String preferenceName, @Nullable String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(preferenceName);
        return preference != null ? preference.getInt(key, defaultValue) : defaultValue;
    }

    @JvmStatic
    @Nullable
    public static final SharedPreferences getPreference(@NotNull String preferenceName) {
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        Context context = mApplicationContext;
        if (context == null) {
            return null;
        }
        Intrinsics.checkNotNull(context);
        Context context2 = mApplicationContext;
        Intrinsics.checkNotNull(context2);
        return context.getSharedPreferences(context2.getPackageName() + preferenceName, 0);
    }

    @JvmStatic
    @Nullable
    public static final SharedPreferences.Editor getPreferenceEditor(@NotNull String preferenceName) {
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(preferenceName);
        if (preference != null) {
            return preference.edit();
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final String getString(@NotNull String preferenceName, @Nullable String key, @Nullable String defaultValue) {
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(preferenceName);
        return preference != null ? preference.getString(key, defaultValue) : defaultValue;
    }

    @JvmStatic
    public static final void initialize(@Nullable Context context) {
        mApplicationContext = context != null ? context.getApplicationContext() : null;
    }

    @JvmStatic
    public static final void putBoolean(@NotNull String preferenceName, @Nullable String key, boolean value, boolean includePackageName) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutBoolean;
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(preferenceName, includePackageName);
        if (preference == null || (editorEdit = preference.edit()) == null || (editorPutBoolean = editorEdit.putBoolean(key, value)) == null) {
            return;
        }
        editorPutBoolean.apply();
    }

    @JvmStatic
    public static final void putFloat(@NotNull String preferenceName, @Nullable String key, float value) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutFloat;
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(preferenceName);
        if (preference == null || (editorEdit = preference.edit()) == null || (editorPutFloat = editorEdit.putFloat(key, value)) == null) {
            return;
        }
        editorPutFloat.apply();
    }

    @JvmStatic
    public static final void putInt(@NotNull String preferenceName, @Nullable String key, int value) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutInt;
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(preferenceName);
        if (preference == null || (editorEdit = preference.edit()) == null || (editorPutInt = editorEdit.putInt(key, value)) == null) {
            return;
        }
        editorPutInt.apply();
    }

    @JvmStatic
    public static final void putString(@NotNull String preferenceName, @Nullable String key, @Nullable String value) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(preferenceName);
        if (preference == null || (editorEdit = preference.edit()) == null || (editorPutString = editorEdit.putString(key, value)) == null) {
            return;
        }
        editorPutString.apply();
    }

    @JvmStatic
    public static final boolean getBoolean(@NotNull String preferenceName, @Nullable String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(preferenceName);
        return preference != null ? preference.getBoolean(key, defaultValue) : defaultValue;
    }

    @JvmStatic
    public static final int getInt(@NotNull String preferenceName, @Nullable String key, int defaultValue, boolean includePackageName) {
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(preferenceName, includePackageName);
        return preference != null ? preference.getInt(key, defaultValue) : defaultValue;
    }

    @JvmStatic
    public static final void putBoolean(@NotNull String preferenceName, @Nullable String key, boolean value) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutBoolean;
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(preferenceName);
        if (preference == null || (editorEdit = preference.edit()) == null || (editorPutBoolean = editorEdit.putBoolean(key, value)) == null) {
            return;
        }
        editorPutBoolean.apply();
    }

    @JvmStatic
    public static final void putInt(@NotNull String preferenceName, @Nullable String key, int value, boolean includePackageName) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutInt;
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(preferenceName, includePackageName);
        if (preference == null || (editorEdit = preference.edit()) == null || (editorPutInt = editorEdit.putInt(key, value)) == null) {
            return;
        }
        editorPutInt.apply();
    }

    @JvmStatic
    private static final SharedPreferences getPreference(String preferenceName, boolean isSetPackage) {
        String packageName;
        Context context = mApplicationContext;
        if (context == null) {
            return null;
        }
        if (isSetPackage) {
            Intrinsics.checkNotNull(context);
            packageName = context.getPackageName();
        } else {
            packageName = "";
        }
        String strM756B = AbstractC0541b.m756B(packageName, preferenceName);
        Context context2 = mApplicationContext;
        Intrinsics.checkNotNull(context2);
        return context2.getSharedPreferences(strM756B, 0);
    }
}
