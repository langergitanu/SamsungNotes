package com.samsung.android.sdk.mobileservice.util;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.FormatFlagsConversionMismatchException;
import java.util.Iterator;
import java.util.MissingFormatArgumentException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public enum SdkLog {
    INSTANCE;

    private static final boolean ENG = "eng".equals(Build.TYPE);
    private static final int LINE_LENGTH = 512;
    private static final String prefix = "SEMS-13.0.32_";
    private static final String version = "13.0.32_";

    private ArrayList<String> breakUpMsg(String str, int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        int length = str.length();
        if (length <= i) {
            arrayList.add(str);
            return arrayList;
        }
        int i2 = 0;
        while (true) {
            int i4 = i2 + 1;
            int i5 = i * i4;
            arrayList.add(str.substring(i * i2, i5));
            if (length <= (i2 + 2) * i) {
                arrayList.add(str.substring(i5, length));
                return arrayList;
            }
            i2 = i4;
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m5782d(String str, String str2) {
        Iterator<String> it = INSTANCE.breakUpMsg(str2, 512).iterator();
        while (it.hasNext()) {
            Log.d(prefix + str, it.next());
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m5783e(String str, String str2) {
        Iterator<String> it = INSTANCE.breakUpMsg(str2, 512).iterator();
        while (it.hasNext()) {
            Log.e(prefix + str, it.next());
        }
    }

    public static String getReference(Object obj) {
        try {
            return obj.toString().substring(obj.toString().lastIndexOf(com.samsung.android.sdk.scs.base.utils.Log.TAG_SEPARATOR));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m5784i(String str, String str2) {
        Iterator<String> it = INSTANCE.breakUpMsg(str2, 512).iterator();
        while (it.hasNext()) {
            Log.i(prefix + str, it.next());
        }
    }

    /* JADX INFO: renamed from: s */
    public static void m5787s(String str, String str2, String... strArr) {
        if (strArr == null) {
            strArr = new String[1];
        }
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == null) {
                strArr[i] = "null";
            }
            if (!ENG) {
                char[] cArr = new char[strArr[i].length()];
                Arrays.fill(cArr, '*');
                strArr[i] = new String(cArr);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                str2 = String.format(str2, strArr);
            } catch (FormatFlagsConversionMismatchException | MissingFormatArgumentException unused) {
            }
        }
        Iterator<String> it = INSTANCE.breakUpMsg(str2, 512).iterator();
        while (it.hasNext()) {
            Log.d(prefix + str, it.next());
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m5788v(String str, String str2) {
        Iterator<String> it = INSTANCE.breakUpMsg(str2, 512).iterator();
        while (it.hasNext()) {
            Log.v(prefix + str, it.next());
        }
    }

    /* JADX INFO: renamed from: s */
    public static void m5786s(String str, String str2) {
        if (ENG) {
            Iterator<String> it = INSTANCE.breakUpMsg(str2, 512).iterator();
            while (it.hasNext()) {
                Log.d(prefix + str, it.next());
            }
        }
    }

    /* JADX INFO: renamed from: s */
    public static void m5785s(Exception exc) {
        if (ENG) {
            exc.printStackTrace();
            return;
        }
        m5784i("SEMS_SDK", "fatal exception! Trace not allowed.\n" + exc.getMessage());
    }
}
