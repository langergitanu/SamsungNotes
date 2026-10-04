package androidx.appcompat.util;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslMisc {
    public static boolean isDefaultTheme(@NonNull Context context) {
        return TextUtils.isEmpty(Settings.System.getString(context.getContentResolver(), "current_sec_active_themepackage"));
    }

    public static boolean isLightTheme(@NonNull Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0419R.attr.isLightTheme, typedValue, true);
        return typedValue.data != 0;
    }
}
