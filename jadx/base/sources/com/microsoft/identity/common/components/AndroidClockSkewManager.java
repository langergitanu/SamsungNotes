package com.microsoft.identity.common.components;

import android.content.Context;
import com.microsoft.identity.common.internal.cache.SharedPreferencesFileManager;
import com.microsoft.identity.common.internal.util.SharedPreferenceLongStorage;
import com.microsoft.identity.common.java.util.ClockSkewManager;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AndroidClockSkewManager extends ClockSkewManager {
    private static final String SKEW_PREFERENCES_FILENAME = "com.microsoft.identity.client.clock_correction";

    public AndroidClockSkewManager(@NonNull Context context) {
        super(new SharedPreferenceLongStorage(SharedPreferencesFileManager.getSharedPreferences(context, SKEW_PREFERENCES_FILENAME, null)));
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
    }
}
