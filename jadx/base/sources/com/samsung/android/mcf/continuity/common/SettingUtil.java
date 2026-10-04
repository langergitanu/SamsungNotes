package com.samsung.android.mcf.continuity.common;

import android.content.Context;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SettingUtil {

    @VisibleForTesting
    public static final String SETTING_ID_CONTINUITY = "mcf_continuity";

    public static boolean isContinuitySettingEnabled(@NonNull Context context) {
        return isSystemEnabled(context, SETTING_ID_CONTINUITY);
    }

    private static boolean isSystemEnabled(@NonNull Context context, @NonNull String str) {
        return Settings.System.getInt(context.getContentResolver(), str, 0) == 1;
    }
}
