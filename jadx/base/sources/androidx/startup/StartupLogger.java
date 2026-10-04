package androidx.startup;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class StartupLogger {
    static final boolean DEBUG = false;
    private static final String TAG = "StartupLogger";

    private StartupLogger() {
    }

    /* JADX INFO: renamed from: e */
    public static void m2393e(@NonNull String str, @Nullable Throwable th) {
        Log.e(TAG, str, th);
    }

    /* JADX INFO: renamed from: i */
    public static void m2394i(@NonNull String str) {
        Log.i(TAG, str);
    }

    /* JADX INFO: renamed from: w */
    public static void m2395w(@NonNull String str) {
        Log.w(TAG, str);
    }
}
