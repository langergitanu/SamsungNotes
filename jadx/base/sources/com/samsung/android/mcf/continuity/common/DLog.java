package com.samsung.android.mcf.continuity.common;

import android.os.Debug;
import android.os.SemSystemProperties;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.Arrays;
import java.util.Locale;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DLog {
    private static final boolean PRINT_D_LOG;
    private static final boolean PRINT_SECURE_LOG;
    private static final String SEM_D_LOG_ENABLED = "0xFFFFFFFF";
    private static final String SEM_LOG_LEVEL = "persist.log.semlevel";
    private static final String TAG;

    static {
        Locale locale = Locale.US;
        TAG = "[ContinuitySDK_1.1.21]_";
        boolean zSemIsProductDev = Debug.semIsProductDev();
        PRINT_SECURE_LOG = zSemIsProductDev;
        String str = SemSystemProperties.get(SEM_LOG_LEVEL, (String) null);
        if (TextUtils.isEmpty(str)) {
            PRINT_D_LOG = zSemIsProductDev;
        } else {
            PRINT_D_LOG = str.equalsIgnoreCase(SEM_D_LOG_ENABLED);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m5607d(String str, String str2, String str3) {
        Log.d(AbstractC0622a.m1170p(TAG, str, new StringBuilder()), str2 + " - " + str3);
    }

    /* JADX INFO: renamed from: e */
    public static void m5609e(String str, String str2, String str3) {
        Log.e(AbstractC0622a.m1170p(TAG, str, new StringBuilder()), str2 + " - " + str3);
    }

    /* JADX INFO: renamed from: i */
    public static void m5610i(String str, String str2, String str3) {
        Log.i(AbstractC0622a.m1170p(TAG, str, new StringBuilder()), str2 + " - " + str3);
    }

    @NonNull
    public static String secureIp(@Nullable String str) {
        return str == null ? "" : PRINT_SECURE_LOG ? str : CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR;
    }

    @NonNull
    public static String secureMac(@Nullable String str) {
        if (str == null) {
            return "";
        }
        if (PRINT_SECURE_LOG || !Utils.isMac(str)) {
            return str;
        }
        return "($m)" + str.substring(9, 14);
    }

    /* JADX INFO: renamed from: w */
    public static void m5611w(String str, String str2, String str3) {
        Log.w(AbstractC0622a.m1170p(TAG, str, new StringBuilder()), str2 + " - " + str3);
    }

    @NonNull
    public static String secureMac(@Nullable byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        if (PRINT_SECURE_LOG) {
            return Utils.toHex(bArr);
        }
        if (bArr.length != 6) {
            return "";
        }
        return "($m)" + Utils.toHex(Arrays.copyOfRange(bArr, 3, 5));
    }

    /* JADX INFO: renamed from: d */
    public static void m5608d(String str, String str2, Supplier<String> supplier) {
        if (PRINT_D_LOG) {
            String strM1170p = AbstractC0622a.m1170p(TAG, str, new StringBuilder());
            StringBuilder sbM781w = AbstractC0541b.m781w(str2, " - ");
            sbM781w.append(supplier.get());
            Log.d(strM1170p, sbM781w.toString());
        }
    }
}
