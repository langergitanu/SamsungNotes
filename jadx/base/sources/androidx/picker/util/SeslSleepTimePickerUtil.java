package androidx.picker.util;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class SeslSleepTimePickerUtil {
    private static final float DEGREE_BIAS = 2.5f;
    private static final int INTERNAL_INDEX_OFFSET = 50024;
    private static final float POP_VIEW_NORMAL_HEIGHT = 420.0f;
    private static final String TAG = "SeslSleepPickerUtil";
    private static final float TOTAL_DEGREE = 360.0f;
    private static final float TOTAL_MINUTES = 1440.0f;

    public static float convertToTime(float f) {
        return (((((((int) (f / 2.5f)) * 2.5f) - 270.0f) + 360.0f) % 360.0f) * TOTAL_MINUTES) / 360.0f;
    }

    private static double getDensity(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Display defaultDisplay = windowManager == null ? null : windowManager.getDefaultDisplay();
        if (defaultDisplay != null) {
            defaultDisplay.getRealMetrics(displayMetrics);
        }
        if (defaultDisplay == null) {
            return 1.0d;
        }
        return ((double) configuration.densityDpi) / ((double) displayMetrics.densityDpi);
    }

    public static Typeface getFontFromOpenTheme(Context context) {
        String string = Settings.System.getString(context.getContentResolver(), "theme_font_clock");
        if (string != null) {
            try {
                if (!TextUtils.isEmpty(string)) {
                    return Typeface.createFromFile(string);
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static boolean getHourFormatData(boolean z) {
        String bestDateTimePattern = DateFormat.getBestDateTimePattern(Locale.getDefault(), z ? "Hm" : "hm");
        int length = bestDateTimePattern.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = bestDateTimePattern.charAt(i);
            if (cCharAt == 'H' || cCharAt == 'h' || cCharAt == 'K' || cCharAt == 'k') {
                int i2 = i + 1;
                return i2 < length && cCharAt == bestDateTimePattern.charAt(i2);
            }
        }
    }

    public static String getTimeSeparatorText(Context context) {
        String string;
        String bestDateTimePattern = DateFormat.getBestDateTimePattern(Locale.getDefault(), DateFormat.is24HourFormat(context) ? "Hm" : "hm");
        int iLastIndexOf = bestDateTimePattern.lastIndexOf(72);
        if (iLastIndexOf == -1) {
            iLastIndexOf = bestDateTimePattern.lastIndexOf(104);
        }
        if (iLastIndexOf == -1) {
            string = ":";
        } else {
            int i = iLastIndexOf + 1;
            int iIndexOf = bestDateTimePattern.indexOf(109, i);
            string = iIndexOf == -1 ? Character.toString(bestDateTimePattern.charAt(i)) : bestDateTimePattern.substring(i, iIndexOf);
        }
        return Locale.getDefault().equals(Locale.CANADA_FRENCH) ? ":" : string.replace("'", "");
    }

    public static boolean isLeftAmPm() {
        return DateFormat.getBestDateTimePattern(Locale.getDefault(), "hm").startsWith("a");
    }

    public static boolean needBedTimePickerAdjustment(float f) {
        return f < POP_VIEW_NORMAL_HEIGHT;
    }

    public static void performHapticFeedback(View view, int i) {
        if (Build.VERSION.SDK_INT > 28) {
            view.performHapticFeedback(i + INTERNAL_INDEX_OFFSET);
        } else {
            view.performHapticFeedback(50025);
        }
    }

    public static void setDefaultTextSize(@NonNull Context context, @NonNull TextView textView, float f) {
        setTextSize(context, textView, f, 1.0f);
    }

    public static void setLargeTextSize(@NonNull Context context, @NonNull TextView[] textViewArr, float f) {
        if (context.getResources().getConfiguration().fontScale > f) {
            for (TextView textView : textViewArr) {
                if (textView != null) {
                    textView.setTextSize(1, (textView.getTextSize() / context.getResources().getDisplayMetrics().scaledDensity) * f);
                }
            }
        }
    }

    private static void setTextSize(Context context, TextView textView, float f, float f4) {
        if (textView != null) {
            float f5 = context.getResources().getConfiguration().fontScale;
            float f6 = f / f5;
            StringBuilder sbM1176v = AbstractC0622a.m1176v("setLargeTextSize fontScale : ", f5, SQLKeyword.COMMA, f, SQLKeyword.COMMA);
            sbM1176v.append(f6);
            Log.d(TAG, sbM1176v.toString());
            if (f5 <= f4) {
                f4 = f5;
            }
            setTextSize(textView, f6 * f4);
        }
    }

    public static String toDigitString(int i) {
        return String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i));
    }

    public static String toTwoDigitString(int i) {
        return String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i));
    }

    public static void setTextSize(@NonNull TextView textView, float f) {
        try {
            textView.setTextSize(0, (float) Math.ceil(f));
        } catch (Exception unused) {
            Log.e(TAG, "Exception");
        }
    }
}
