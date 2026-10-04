package com.samsung.android.support.senl.p148nt.stt.picker.utils;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tJ,\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\tJ(\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u0011J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0011¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/utils/PreferenceUtils;", "", "<init>", "()V", "getPreference", "Landroid/content/SharedPreferences;", "mContext", "Landroid/content/Context;", "preferenceName", "", "putString", "", "key", "value", "getString", "defaultValue", "putInt", "", "getInt", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PreferenceUtils {

    @NotNull
    public static final PreferenceUtils INSTANCE = new PreferenceUtils();

    private PreferenceUtils() {
    }

    private final SharedPreferences getPreference(Context mContext, String preferenceName) {
        return mContext.getSharedPreferences(mContext.getPackageName() + preferenceName, 0);
    }

    public final int getInt(@NotNull Context mContext, @NotNull String preferenceName, @Nullable String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(mContext, preferenceName);
        return preference != null ? preference.getInt(key, defaultValue) : defaultValue;
    }

    @Nullable
    public final String getString(@NotNull Context mContext, @NotNull String preferenceName, @Nullable String key, @Nullable String defaultValue) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(mContext, preferenceName);
        return preference != null ? preference.getString(key, defaultValue) : defaultValue;
    }

    public final void putInt(@NotNull Context mContext, @NotNull String preferenceName, @Nullable String key, int value) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutInt;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(mContext, preferenceName);
        if (preference == null || (editorEdit = preference.edit()) == null || (editorPutInt = editorEdit.putInt(key, value)) == null) {
            return;
        }
        editorPutInt.apply();
    }

    public final void putString(@NotNull Context mContext, @NotNull String preferenceName, @Nullable String key, @Nullable String value) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
        SharedPreferences preference = getPreference(mContext, preferenceName);
        if (preference == null || (editorEdit = preference.edit()) == null || (editorPutString = editorEdit.putString(key, value)) == null) {
            return;
        }
        editorPutString.apply();
    }
}
