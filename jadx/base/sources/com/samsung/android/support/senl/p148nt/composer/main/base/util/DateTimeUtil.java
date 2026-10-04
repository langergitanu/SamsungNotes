package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DateTimeUtil {
    private static final String TAG = Logger.createTag("DateTimeUtil");

    public static String convertFormattedDateTime(Context context, long j, boolean z, boolean z2) {
        String strM773o;
        if (z2 && DateUtils.isToday(j)) {
            strM773o = DateFormat.getTimeFormat(context).format(Long.valueOf(j));
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                strM773o = AbstractC0541b.m773o("\u202a", strM773o, "\u202c");
            }
        } else {
            Locale locale = LocaleUtils.getLocale(context.getResources().getConfiguration());
            strM773o = new SimpleDateFormat(DateFormat.getBestDateTimePattern(locale, z ? getTimePatternWIthTime(context) : "yyyyMMMd"), locale).format(Long.valueOf(j));
        }
        Logger.m10999d(TAG, "convertFormattedTime - " + strM773o);
        return RTLUtil.supportRTL(strM773o);
    }

    public static String convertFormattedMMDD(Context context, long j) {
        Locale locale = LocaleUtils.getLocale(context.getResources().getConfiguration());
        return RTLUtil.supportRTL(new SimpleDateFormat(DateFormat.getBestDateTimePattern(locale, "MMMd"), locale).format(Long.valueOf(j)));
    }

    public static String convertFormattedTime(Context context, long j) {
        Locale locale = LocaleUtils.getLocale(context.getResources().getConfiguration());
        return new SimpleDateFormat(DateFormat.getBestDateTimePattern(locale, getTimePatternWIthTime(context)), locale).format(Long.valueOf(j));
    }

    private static String getTimePatternWIthTime(Context context) {
        return isTimeDisplayFor24hour(context) ? "yyyyMMMd, HH:mm" : "yyyyMMMd, hh:mm";
    }

    public static boolean isTimeDisplayFor24hour(Context context) {
        String string = Settings.System.getString(context.getContentResolver(), "time_12_24");
        return string != null && Integer.parseInt(string) == 24;
    }
}
