package com.nimbusds.jose.shaded.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PreJava9DateFormatProvider {
    private static String getDateFormatPattern(int i) {
        if (i == 0) {
            return "EEEE, MMMM d, y";
        }
        if (i == 1) {
            return "MMMM d, y";
        }
        if (i == 2) {
            return "MMM d, y";
        }
        if (i == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unknown DateFormat style: "));
    }

    private static String getDatePartOfDateTimePattern(int i) {
        if (i == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i == 1) {
            return "MMMM d, yyyy";
        }
        if (i == 2) {
            return "MMM d, yyyy";
        }
        if (i == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unknown DateFormat style: "));
    }

    private static String getTimePartOfDateTimePattern(int i) {
        if (i == 0 || i == 1) {
            return "h:mm:ss a z";
        }
        if (i == 2) {
            return "h:mm:ss a";
        }
        if (i == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unknown DateFormat style: "));
    }

    public static DateFormat getUSDateFormat(int i) {
        return new SimpleDateFormat(getDateFormatPattern(i), Locale.US);
    }

    public static DateFormat getUSDateTimeFormat(int i, int i2) {
        return new SimpleDateFormat(getDatePartOfDateTimePattern(i) + " " + getTimePartOfDateTimePattern(i2), Locale.US);
    }
}
