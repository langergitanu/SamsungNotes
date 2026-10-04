package com.google.api.client.extensions.android;

import android.os.Build;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public class AndroidUtils {
    private AndroidUtils() {
    }

    public static void checkMinimumSdkLevel(int i) {
        Preconditions.checkArgument(isMinimumSdkLevel(i), "running on Android SDK level %s but requires minimum %s", Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i));
    }

    public static boolean isMinimumSdkLevel(int i) {
        return Build.VERSION.SDK_INT >= i;
    }
}
