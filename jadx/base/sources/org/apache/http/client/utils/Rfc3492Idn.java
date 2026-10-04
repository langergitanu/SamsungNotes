package org.apache.http.client.utils;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.StringTokenizer;
import org.apache.http.annotation.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class Rfc3492Idn implements Idn {
    private static final String ACE_PREFIX = "xn--";
    private static final int base = 36;
    private static final int damp = 700;
    private static final char delimiter = '-';
    private static final int initial_bias = 72;
    private static final int initial_n = 128;
    private static final int skew = 38;
    private static final int tmax = 26;
    private static final int tmin = 1;

    private int adapt(int i, int i2, boolean z) {
        int i4 = z ? i / 700 : i / 2;
        int i5 = (i4 / i2) + i4;
        int i6 = 0;
        while (i5 > 455) {
            i5 /= 35;
            i6 += 36;
        }
        return ((i5 * 36) / (i5 + 38)) + i6;
    }

    private int digit(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        }
        if (c >= '0' && c <= '9') {
            return c - 22;
        }
        throw new IllegalArgumentException("illegal digit: " + c);
    }

    public String decode(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int iLastIndexOf = str.lastIndexOf(45);
        int length = 128;
        int iAdapt = 72;
        if (iLastIndexOf != -1) {
            sb.append(str.subSequence(0, iLastIndexOf));
            str = str.substring(iLastIndexOf + 1);
        }
        int i = 0;
        while (str.length() > 0) {
            int i2 = 36;
            int i4 = i;
            int i5 = 1;
            while (str.length() != 0) {
                char cCharAt = str.charAt(0);
                str = str.substring(1);
                int iDigit = digit(cCharAt);
                i4 += iDigit * i5;
                int i6 = i2 <= iAdapt + 1 ? 1 : i2 >= iAdapt + 26 ? 26 : i2 - iAdapt;
                if (iDigit < i6) {
                    break;
                }
                i5 *= 36 - i6;
                i2 += 36;
            }
            iAdapt = adapt(i4 - i, sb.length() + 1, i == 0);
            length += i4 / (sb.length() + 1);
            int length2 = i4 % (sb.length() + 1);
            sb.insert(length2, (char) length);
            i = length2 + 1;
        }
        return sb.toString();
    }

    @Override // org.apache.http.client.utils.Idn
    public String toUnicode(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        StringTokenizer stringTokenizer = new StringTokenizer(str, Extension.DOT);
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            if (sb.length() > 0) {
                sb.append('.');
            }
            if (strNextToken.startsWith(ACE_PREFIX)) {
                strNextToken = decode(strNextToken.substring(4));
            }
            sb.append(strNextToken);
        }
        return sb.toString();
    }
}
