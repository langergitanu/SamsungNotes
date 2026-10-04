package io.netty.handler.codec.http.cookie;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.netty.util.internal.InternalThreadLocalMap;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class CookieUtil {
    private static final BitSet VALID_COOKIE_NAME_OCTETS = validCookieNameOctets();
    private static final BitSet VALID_COOKIE_VALUE_OCTETS = validCookieValueOctets();
    private static final BitSet VALID_COOKIE_ATTRIBUTE_VALUE_OCTETS = validCookieAttributeValueOctets();

    private CookieUtil() {
    }

    public static void add(StringBuilder sb, String str, long j) {
        sb.append(str);
        sb.append('=');
        sb.append(j);
        sb.append(SQLKeyword.DELIMITER);
        sb.append(' ');
    }

    public static void addQuoted(StringBuilder sb, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str);
        sb.append('=');
        sb.append('\"');
        sb.append(str2);
        sb.append('\"');
        sb.append(SQLKeyword.DELIMITER);
        sb.append(' ');
    }

    public static int firstInvalidCookieNameOctet(CharSequence charSequence) {
        return firstInvalidOctet(charSequence, VALID_COOKIE_NAME_OCTETS);
    }

    public static int firstInvalidCookieValueOctet(CharSequence charSequence) {
        return firstInvalidOctet(charSequence, VALID_COOKIE_VALUE_OCTETS);
    }

    public static int firstInvalidOctet(CharSequence charSequence, BitSet bitSet) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (!bitSet.get(charSequence.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public static StringBuilder stringBuilder() {
        return InternalThreadLocalMap.get().stringBuilder();
    }

    public static String stripTrailingSeparator(StringBuilder sb) {
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    public static String stripTrailingSeparatorOrNull(StringBuilder sb) {
        if (sb.length() == 0) {
            return null;
        }
        return stripTrailingSeparator(sb);
    }

    public static CharSequence unwrapValue(CharSequence charSequence) {
        int length = charSequence.length();
        if (length <= 0 || charSequence.charAt(0) != '\"') {
            return charSequence;
        }
        if (length >= 2) {
            int i = length - 1;
            if (charSequence.charAt(i) == '\"') {
                return length == 2 ? "" : charSequence.subSequence(1, i);
            }
        }
        return null;
    }

    private static BitSet validCookieAttributeValueOctets() {
        BitSet bitSet = new BitSet();
        for (int i = 32; i < 127; i++) {
            bitSet.set(i);
        }
        bitSet.set(59, false);
        return bitSet;
    }

    private static BitSet validCookieNameOctets() {
        BitSet bitSet = new BitSet();
        for (int i = 32; i < 127; i++) {
            bitSet.set(i);
        }
        int[] iArr = {40, 41, 60, 62, 64, 44, 59, 58, 92, 34, 47, 91, 93, 63, 61, 123, 125, 32, 9};
        for (int i2 = 0; i2 < 19; i2++) {
            bitSet.set(iArr[i2], false);
        }
        return bitSet;
    }

    private static BitSet validCookieValueOctets() {
        BitSet bitSet = new BitSet();
        bitSet.set(33);
        for (int i = 35; i <= 43; i++) {
            bitSet.set(i);
        }
        for (int i2 = 45; i2 <= 58; i2++) {
            bitSet.set(i2);
        }
        for (int i4 = 60; i4 <= 91; i4++) {
            bitSet.set(i4);
        }
        for (int i5 = 93; i5 <= 126; i5++) {
            bitSet.set(i5);
        }
        return bitSet;
    }

    public static String validateAttributeValue(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        String strTrim = str2.trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        int iFirstInvalidOctet = firstInvalidOctet(strTrim, VALID_COOKIE_ATTRIBUTE_VALUE_OCTETS);
        if (iFirstInvalidOctet == -1) {
            return strTrim;
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(str, " contains the prohibited characters: ");
        sbM781w.append(strTrim.charAt(iFirstInvalidOctet));
        throw new IllegalArgumentException(sbM781w.toString());
    }

    public static void add(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append('=');
        sb.append(str2);
        sb.append(SQLKeyword.DELIMITER);
        sb.append(' ');
    }

    public static void add(StringBuilder sb, String str) {
        sb.append(str);
        sb.append(SQLKeyword.DELIMITER);
        sb.append(' ');
    }
}
