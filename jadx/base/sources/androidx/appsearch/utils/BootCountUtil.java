package androidx.appsearch.utils;

import android.content.Context;
import android.provider.Settings;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class BootCountUtil {
    private BootCountUtil() {
    }

    public static int getCurrentBootCount(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "boot_count", -1);
    }
}
