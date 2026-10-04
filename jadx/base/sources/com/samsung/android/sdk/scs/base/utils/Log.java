package com.samsung.android.sdk.scs.base.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.compose.runtime.AbstractC1974b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Log {
    public static final String TAG_PREFIX = "ScsApi@";
    public static final String TAG_SEPARATOR = "@";

    @NonNull
    private static String concatPrefixTag(@Nullable String str) {
        return TAG_PREFIX.concat(filterPrefixTag(str));
    }

    /* JADX INFO: renamed from: d */
    public static void m6485d(@Nullable String str, @NonNull String str2) {
        android.util.Log.d(concatPrefixTag(str), str2);
    }

    /* JADX INFO: renamed from: e */
    public static void m6487e(@Nullable String str, @NonNull String str2) {
        android.util.Log.e(concatPrefixTag(str), str2);
    }

    @NonNull
    private static String filterPrefixTag(@Nullable String str) {
        return str == null ? "" : str.replace(TAG_PREFIX, "");
    }

    /* JADX INFO: renamed from: i */
    public static void m6489i(@Nullable String str, @NonNull String str2) {
        android.util.Log.i(concatPrefixTag(str), str2);
    }

    public static void objectInfo(@Nullable String str, @Nullable String str2, @Nullable Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        StringBuilder sb = new StringBuilder(str2);
        for (Object obj : objArr) {
            if (obj != null) {
                String simpleName = obj.getClass().getSimpleName();
                String hexString = Integer.toHexString(obj.hashCode());
                if (sb.length() > 0) {
                    sb.append(" >> ");
                }
                AbstractC1974b.m1332y(sb, simpleName, TAG_SEPARATOR, hexString);
            }
        }
        m6489i(str, sb.toString());
    }

    /* JADX INFO: renamed from: w */
    public static void m6490w(@Nullable String str, @NonNull String str2) {
        android.util.Log.w(concatPrefixTag(str), str2);
    }

    /* JADX INFO: renamed from: d */
    public static void m6486d(@Nullable String str, @NonNull String str2, @Nullable Throwable th) {
        android.util.Log.d(concatPrefixTag(str), str2, th);
    }

    /* JADX INFO: renamed from: e */
    public static void m6488e(@Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        android.util.Log.e(concatPrefixTag(str), str2, th);
    }

    /* JADX INFO: renamed from: w */
    public static void m6491w(@Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        android.util.Log.w(concatPrefixTag(str), str2, th);
    }
}
