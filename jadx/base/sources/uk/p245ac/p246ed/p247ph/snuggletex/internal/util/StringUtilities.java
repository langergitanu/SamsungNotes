package uk.p245ac.p246ed.p247ph.snuggletex.internal.util;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.Iterator;
import org.apache.commons.lang3.BooleanUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class StringUtilities {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static String emptyIfNull(String str) {
        return str != null ? str : "";
    }

    public static boolean fromBinaryValues(String str, String str2, String str3) {
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
            if (str.equals(str3)) {
                return false;
            }
        }
        throw new IllegalArgumentException(AbstractC0541b.m774p("Argument must be ", str2, " or ", str3));
    }

    public static boolean fromTrueFalse(String str) {
        return fromBinaryValues(str, "true", "false");
    }

    public static boolean fromYesNo(String str) {
        return fromBinaryValues(str, BooleanUtils.YES, BooleanUtils.f9757NO);
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String join(Iterable<? extends Object> iterable, CharSequence charSequence) {
        StringBuilder sb = new StringBuilder();
        Iterator<? extends Object> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(charSequence);
            }
        }
        return sb.toString();
    }

    public static String nullIfEmpty(String str) {
        if (isNullOrEmpty(str)) {
            return null;
        }
        return str;
    }

    public static String toTrueFalse(boolean z) {
        return z ? "true" : "false";
    }

    public static String toYesNo(boolean z) {
        return z ? BooleanUtils.YES : BooleanUtils.f9757NO;
    }

    public static String join(Object[] objArr, CharSequence charSequence) {
        return join(objArr, charSequence, 0, objArr.length);
    }

    public static void join(StringBuilder sb, Object[] objArr, CharSequence charSequence) {
        join(sb, objArr, charSequence, 0, objArr.length);
    }

    public static String join(Object[] objArr, CharSequence charSequence, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        join(sb, objArr, charSequence, i, i2);
        return sb.toString();
    }

    public static void join(StringBuilder sb, Object[] objArr, CharSequence charSequence, int i, int i2) {
        boolean z = false;
        while (i < i2) {
            if (z) {
                sb.append(charSequence);
            }
            sb.append(objArr[i].toString());
            i++;
            z = true;
        }
    }
}
