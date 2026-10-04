package androidx.picker.util;

import android.content.Context;
import android.graphics.Typeface;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.util.SeslMisc;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class SeslPickerBasicUtils {
    private static final String TAG = "SeslPickerBasicUtils";

    public static Typeface getOpenThemeTypeface(Context context) {
        String string = Settings.System.getString(context.getContentResolver(), "theme_font_clock");
        if (string != null) {
            try {
                if (!TextUtils.isEmpty(string) && SeslMisc.isLightTheme(context)) {
                    return Typeface.createFromFile(string);
                }
            } catch (Exception unused) {
                Log.e(TAG, "Open Theme Font not found");
            }
        }
        return null;
    }
}
