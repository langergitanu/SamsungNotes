package org.apache.commons.lang3.text;

import java.util.Formattable;
import java.util.Formatter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
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
        Validate.isTrue(charSequence2 == null || i4 < 0 || charSequence2.length() <= i4, "Specified ellipsis '%1$s' exceeds precision of %2$s", charSequence2, Integer.valueOf(i4));
        StringBuilder sb = new StringBuilder(charSequence);
        if (i4 >= 0 && i4 < charSequence.length()) {
            CharSequence charSequence3 = (CharSequence) ObjectUtils.getIfNull((String) charSequence2, "");
            sb.replace(i4 - charSequence3.length(), charSequence.length(), charSequence3.toString());
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
