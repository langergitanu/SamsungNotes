package com.samsung.android.support.senl.p148nt.data.sync.resolver;

import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MaxObjectLimitHelper {
    public static final int STROKE_GROUP_LEVEL_0 = 0;
    public static final int STROKE_GROUP_LEVEL_0_LIMIT = 100000;
    public static final int STROKE_GROUP_LEVEL_1 = 1;
    public static final int STROKE_GROUP_LEVEL_1_LIMIT = 200000;
    public static final int SUPPORTED_STROKE_GROUP_LEVEL = 1;
    private static final String USER_CONFIRM_CONVERTING_NAME = "userConfirmConvertingName";

    private static int getTotalObjectCount(int i, int i2) {
        return AbstractC1974b.m1304A(i, i2, 4, i2);
    }

    public static boolean getUserConfirmConverting(String str) {
        return SharedPreferencesCompat.getInstance(USER_CONFIRM_CONVERTING_NAME).getBoolean(str, false);
    }

    public static boolean isMaxStrokeObjectLimit(int i, int i2, int i4) {
        int totalObjectCount = getTotalObjectCount(i2, i4);
        int i5 = 100000;
        if (i != 0 && i == 1) {
            i5 = STROKE_GROUP_LEVEL_1_LIMIT;
        }
        return totalObjectCount > i5;
    }

    public static boolean isStrokeGroupingNeeded(int i, int i2) {
        return getTotalObjectCount(i, i2) > 100000;
    }

    public static void removeConfirmConverting(String str) {
        SharedPreferencesCompat.getInstance(USER_CONFIRM_CONVERTING_NAME).remove(str);
    }

    public static void setUserConfirmConverting(String str, boolean z) {
        SharedPreferencesCompat.getInstance(USER_CONFIRM_CONVERTING_NAME).putBoolean(str, z);
    }
}
