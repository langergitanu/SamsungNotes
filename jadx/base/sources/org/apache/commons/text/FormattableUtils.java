package org.apache.commons.text;

import java.util.Formattable;
import java.util.Formatter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FormattableUtils {
    private static final String SIMPLEST_FORMAT = "%s";

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i, int i2, int i4) {
        return append(charSequence, formatter, i, i2, i4, ' ', null);
    }

    public static String toString(Formattable formattable) {
        return String.format(SIMPLEST_FORMAT, formattable);
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i, int i2, int i4, char c) {
        return append(charSequence, formatter, i, i2, i4, c, null);
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i, int i2, int i4, char c, CharSequence charSequence2) {
        if (charSequence2 != null && i4 >= 0 && charSequence2.length() > i4) {
            throw new IllegalArgumentException(String.format("Specified ellipsis '%s' exceeds precision of %s", charSequence2, Integer.valueOf(i4)));
        }
        StringBuilder sb = new StringBuilder(charSequence);
        if (i4 >= 0 && i4 < charSequence.length()) {
            if (charSequence2 == null) {
                charSequence2 = "";
            }
            sb.replace(i4 - charSequence2.length(), charSequence.length(), charSequence2.toString());
        }
        boolean z = (i & 1) == 1;
        for (int length = sb.length(); length < i2; length++) {
            sb.insert(z ? length : 0, c);
        }
        formatter.format(sb.toString(), new Object[0]);
        return formatter;
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i, int i2, int i4, CharSequence charSequence2) {
        return append(charSequence, formatter, i, i2, i4, ' ', charSequence2);
    }
}
