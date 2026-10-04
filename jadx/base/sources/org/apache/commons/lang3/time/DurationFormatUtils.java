package org.apache.commons.lang3.time;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.TimeZone;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Strings;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.time.DurationFormatUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DurationFormatUtils {

    /* JADX INFO: renamed from: H */
    static final String f9938H = "H";
    private static final int HOURS_PER_DAY = 24;
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";

    /* JADX INFO: renamed from: M */
    static final String f9939M = "M";
    private static final int MINUTES_PER_HOUR = 60;

    /* JADX INFO: renamed from: S */
    static final String f9940S = "S";
    private static final int SECONDS_PER_MINUTES = 60;

    /* JADX INFO: renamed from: d */
    static final String f9941d = "d";

    /* JADX INFO: renamed from: m */
    static final String f9942m = "m";

    /* JADX INFO: renamed from: s */
    static final String f9943s = "s";

    /* JADX INFO: renamed from: y */
    static final String f9944y = "y";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Token {
        private static final Token[] EMPTY_ARRAY = new Token[0];
        private int count;
        private int optionalIndex;
        private final CharSequence value;

        public Token(CharSequence charSequence, boolean z, int i) {
            this.optionalIndex = -1;
            Objects.requireNonNull(charSequence, "value");
            this.value = charSequence;
            this.count = 1;
            if (z) {
                this.optionalIndex = i;
            }
        }

        public static boolean containsTokenWithValue(Token[] tokenArr, final Object obj) {
            return Stream.of((Object[]) tokenArr).anyMatch(new Predicate() { // from class: org.apache.commons.lang3.time.d
                @Override // java.util.function.Predicate
                public final boolean test(Object obj2) {
                    return DurationFormatUtils.Token.lambda$containsTokenWithValue$0(obj, (DurationFormatUtils.Token) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$containsTokenWithValue$0(Object obj, Token token) {
            return token.getValue() == obj;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Token) {
                Token token = (Token) obj;
                if (this.value.getClass() != token.value.getClass() || this.count != token.count) {
                    return false;
                }
                CharSequence charSequence = this.value;
                if (charSequence instanceof StringBuilder) {
                    return charSequence.toString().equals(token.value.toString());
                }
                if (charSequence instanceof Number) {
                    return charSequence.equals(token.value);
                }
                if (charSequence == token.value) {
                    return true;
                }
            }
            return false;
        }

        public int getCount() {
            return this.count;
        }

        public Object getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public void increment() {
            this.count++;
        }

        public String toString() {
            return StringUtils.repeat(this.value.toString(), this.count);
        }
    }

    @Deprecated
    public DurationFormatUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x017c A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016d A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String format(Token[] tokenArr, long j, long j2, long j3, long j5, long j6, long j7, long j8, boolean z) {
        int length;
        boolean z2;
        boolean z3;
        long j9 = j;
        long j10 = j2;
        StringBuilder sb = new StringBuilder();
        int length2 = tokenArr.length;
        int i = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i2 = -1;
        int i4 = -1;
        while (i < length2) {
            Token token = tokenArr[i];
            int i5 = i;
            Object value = token.getValue();
            boolean z8 = z4;
            boolean z9 = value instanceof StringBuilder;
            int count = token.getCount();
            int i6 = length2;
            if (i2 != token.optionalIndex) {
                i2 = token.optionalIndex;
                if (i2 > -1) {
                    z5 = false;
                    z6 = false;
                    length = sb.length();
                    z8 = true;
                    if (z9) {
                        if (value.equals("y")) {
                            z3 = j9 == 0;
                            if (!z8 || !z3) {
                                sb.append(paddedValue(j9, z, count));
                            }
                        } else if (value.equals("M")) {
                            z3 = j10 == 0;
                            if (!z8 || !z3) {
                                sb.append(paddedValue(j10, z, count));
                            }
                        } else if (value.equals("d")) {
                            z3 = j3 == 0;
                            if (!z8 || !z3) {
                                sb.append(paddedValue(j3, z, count));
                            }
                        } else if (value.equals(f9938H)) {
                            z3 = j5 == 0;
                            if (!z8 || !z3) {
                                sb.append(paddedValue(j5, z, count));
                            }
                        } else if (value.equals("m")) {
                            z3 = j6 == 0;
                            if (!z8 || !z3) {
                                sb.append(paddedValue(j6, z, count));
                            }
                            z5 = z3;
                            z7 = false;
                            z2 = true;
                            if (z8 && !z9 && !z6) {
                                if (z5) {
                                    sb.delete(length, sb.length());
                                }
                                z6 = z2;
                            }
                            i = i5 + 1;
                            j9 = j;
                            j10 = j2;
                            i4 = length;
                            z4 = z8;
                            length2 = i6;
                        } else {
                            if (value.equals("s")) {
                                boolean z10 = j7 == 0;
                                if (!z8 || !z10) {
                                    sb.append(paddedValue(j7, z, count));
                                }
                                z5 = z10;
                                z2 = true;
                                z7 = true;
                            } else if (value.equals("S")) {
                                boolean z11 = j8 == 0;
                                if (z8 && z11) {
                                    z2 = true;
                                } else if (z7) {
                                    z2 = true;
                                    sb.append(paddedValue(j8, true, z ? Math.max(3, count) : 3));
                                } else {
                                    z2 = true;
                                    sb.append(paddedValue(j8, z, count));
                                }
                                z5 = z11;
                                z7 = false;
                            }
                            if (z8) {
                            }
                            i = i5 + 1;
                            j9 = j;
                            j10 = j2;
                            i4 = length;
                            z4 = z8;
                            length2 = i6;
                        }
                        z5 = z3;
                        z7 = false;
                        z2 = true;
                        if (z8) {
                        }
                        i = i5 + 1;
                        j9 = j;
                        j10 = j2;
                        i4 = length;
                        z4 = z8;
                        length2 = i6;
                    } else if (!z8 || !z5) {
                        sb.append(value.toString());
                    }
                    z2 = true;
                    if (z8) {
                    }
                    i = i5 + 1;
                    j9 = j;
                    j10 = j2;
                    i4 = length;
                    z4 = z8;
                    length2 = i6;
                } else {
                    z8 = false;
                }
            }
            length = i4;
            if (z9) {
            }
            z2 = true;
            if (z8) {
            }
            i = i5 + 1;
            j9 = j;
            j10 = j2;
            i4 = length;
            z4 = z8;
            length2 = i6;
        }
        return sb.toString();
    }

    public static String formatDuration(long j, String str) {
        return formatDuration(j, str, true);
    }

    public static String formatDurationHMS(long j) {
        return formatDuration(j, "HH:mm:ss.SSS");
    }

    public static String formatDurationISO(long j) {
        return formatDuration(j, ISO_EXTENDED_FORMAT_PATTERN, false);
    }

    public static String formatDurationWords(long j, boolean z, boolean z2) {
        String duration = formatDuration(j, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (z) {
            duration = AbstractC0541b.m772n(" ", duration);
            Strings strings = Strings.f9764CS;
            String strReplaceOnce = strings.replaceOnce(duration, " 0 days", "");
            if (strReplaceOnce.length() != duration.length()) {
                String strReplaceOnce2 = strings.replaceOnce(strReplaceOnce, " 0 hours", "");
                duration = strReplaceOnce2.length() != strReplaceOnce.length() ? strings.replaceOnce(strReplaceOnce2, " 0 minutes", "") : strReplaceOnce;
            }
            if (!duration.isEmpty()) {
                duration = duration.substring(1);
            }
        }
        if (z2) {
            Strings strings2 = Strings.f9764CS;
            String strReplaceOnce3 = strings2.replaceOnce(duration, " 0 seconds", "");
            if (strReplaceOnce3.length() != duration.length()) {
                duration = strings2.replaceOnce(strReplaceOnce3, " 0 minutes", "");
                if (duration.length() != strReplaceOnce3.length()) {
                    String strReplaceOnce4 = strings2.replaceOnce(duration, " 0 hours", "");
                    if (strReplaceOnce4.length() != duration.length()) {
                        duration = strings2.replaceOnce(strReplaceOnce4, " 0 days", "");
                    }
                } else {
                    duration = strReplaceOnce3;
                }
            }
        }
        String strM772n = AbstractC0541b.m772n(" ", duration);
        Strings strings3 = Strings.f9764CS;
        return strings3.replaceOnce(strings3.replaceOnce(strings3.replaceOnce(strings3.replaceOnce(strM772n, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String formatPeriod(long j, long j2, String str) {
        return formatPeriod(j, j2, str, true, TimeZone.getDefault());
    }

    public static String formatPeriodISO(long j, long j2) {
        return formatPeriod(j, j2, ISO_EXTENDED_FORMAT_PATTERN, false, TimeZone.getDefault());
    }

    public static Token[] lexx(String str) {
        String str2;
        ArrayList arrayList = new ArrayList(str.length());
        int i = -1;
        boolean z = false;
        boolean z2 = false;
        StringBuilder sb = null;
        Token token = null;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (!z || cCharAt == '\'') {
                if (cCharAt != '\'') {
                    if (cCharAt == 'H') {
                        str2 = f9938H;
                    } else if (cCharAt == 'M') {
                        str2 = "M";
                    } else if (cCharAt == 'S') {
                        str2 = "S";
                    } else if (cCharAt != '[') {
                        if (cCharAt == ']') {
                            if (!z2) {
                                throw new IllegalArgumentException(AbstractC0000a.m11h(i2, "Attempting to close unopened optional block at index: "));
                            }
                            z2 = false;
                        } else if (cCharAt == 'd') {
                            str2 = "d";
                        } else if (cCharAt == 'm') {
                            str2 = "m";
                        } else if (cCharAt == 's') {
                            str2 = "s";
                        } else if (cCharAt != 'y') {
                            if (sb == null) {
                                sb = new StringBuilder();
                                arrayList.add(new Token(sb, z2, i));
                            }
                            sb.append(cCharAt);
                        } else {
                            str2 = "y";
                        }
                        str2 = null;
                    } else {
                        if (z2) {
                            throw new IllegalArgumentException(AbstractC0000a.m11h(i2, "Nested optional block at index: "));
                        }
                        i++;
                        str2 = null;
                        z2 = true;
                    }
                } else if (z) {
                    z = false;
                    sb = null;
                    str2 = null;
                } else {
                    sb = new StringBuilder();
                    arrayList.add(new Token(sb, z2, i));
                    str2 = null;
                    z = true;
                }
                if (str2 != null) {
                    if (token == null || !token.getValue().equals(str2)) {
                        token = new Token(str2, z2, i);
                        arrayList.add(token);
                    } else {
                        token.increment();
                    }
                    sb = null;
                }
            } else {
                sb.append(cCharAt);
            }
        }
        if (z) {
            throw new IllegalArgumentException("Unmatched quote in format: ".concat(str));
        }
        if (z2) {
            throw new IllegalArgumentException("Unmatched optional in format: ".concat(str));
        }
        return (Token[]) arrayList.toArray(Token.EMPTY_ARRAY);
    }

    private static String paddedValue(long j, boolean z, int i) {
        String string = Long.toString(j);
        return z ? StringUtils.leftPad(string, i, '0') : string;
    }

    public static String formatDuration(long j, String str, boolean z) {
        long j2;
        long j3;
        long j5;
        long j6;
        long j7;
        Validate.inclusiveBetween(0L, Long.MAX_VALUE, j, "durationMillis must not be negative");
        Token[] tokenArrLexx = lexx(str);
        if (Token.containsTokenWithValue(tokenArrLexx, "d")) {
            j3 = j / 86400000;
            j2 = j - (86400000 * j3);
        } else {
            j2 = j;
            j3 = 0;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, f9938H)) {
            long j8 = j2 / 3600000;
            j2 -= 3600000 * j8;
            j5 = j8;
        } else {
            j5 = 0;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, "m")) {
            long j9 = j2 / 60000;
            j2 -= 60000 * j9;
            j6 = j9;
        } else {
            j6 = 0;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, "s")) {
            j7 = j2 / 1000;
            j2 -= 1000 * j7;
        } else {
            j7 = 0;
        }
        return format(tokenArrLexx, 0L, 0L, j3, j5, j6, j7, j2, z);
    }

    public static String formatPeriod(long j, long j2, String str, boolean z, TimeZone timeZone) {
        int i;
        Validate.isTrue(j <= j2, "startMillis must not be greater than endMillis", new Object[0]);
        Token[] tokenArrLexx = lexx(str);
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(new Date(j));
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTime(new Date(j2));
        long j3 = calendar2.get(14) - calendar.get(14);
        int i2 = calendar2.get(13) - calendar.get(13);
        int i4 = calendar2.get(12) - calendar.get(12);
        int i5 = calendar2.get(11) - calendar.get(11);
        int actualMaximum = calendar2.get(5) - calendar.get(5);
        int i6 = calendar2.get(2) - calendar.get(2);
        int i7 = calendar2.get(1) - calendar.get(1);
        while (j3 < 0) {
            j3 += 1000;
            i2--;
        }
        while (i2 < 0) {
            i2 += 60;
            i4--;
        }
        while (i4 < 0) {
            i4 += 60;
            i5--;
        }
        while (i5 < 0) {
            i5 += 24;
            actualMaximum--;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, "M")) {
            while (actualMaximum < 0) {
                actualMaximum += calendar.getActualMaximum(5);
                i6--;
                calendar.add(2, 1);
            }
            while (i6 < 0) {
                i6 += 12;
                i7--;
            }
            if (!Token.containsTokenWithValue(tokenArrLexx, "y") && i7 != 0) {
                while (i7 != 0) {
                    i6 += i7 * 12;
                    i7 = 0;
                }
            }
        } else {
            if (!Token.containsTokenWithValue(tokenArrLexx, "y")) {
                int i8 = calendar2.get(1);
                if (i6 < 0) {
                    i8--;
                }
                while (calendar.get(1) != i8) {
                    int actualMaximum2 = (calendar.getActualMaximum(6) - calendar.get(6)) + actualMaximum;
                    if ((calendar instanceof GregorianCalendar) && calendar.get(2) == 1 && calendar.get(5) == 29) {
                        actualMaximum2++;
                    }
                    calendar.add(1, 1);
                    actualMaximum = calendar.get(6) + actualMaximum2;
                }
                i7 = 0;
            }
            while (calendar.get(2) != calendar2.get(2)) {
                actualMaximum += calendar.getActualMaximum(5);
                calendar.add(2, 1);
            }
            i6 = 0;
            while (actualMaximum < 0) {
                actualMaximum += calendar.getActualMaximum(5);
                i6--;
                calendar.add(2, 1);
            }
        }
        if (!Token.containsTokenWithValue(tokenArrLexx, "d")) {
            i5 += actualMaximum * 24;
            actualMaximum = 0;
        }
        if (!Token.containsTokenWithValue(tokenArrLexx, f9938H)) {
            i4 += i5 * 60;
            i5 = 0;
        }
        if (!Token.containsTokenWithValue(tokenArrLexx, "m")) {
            i2 += i4 * 60;
            i4 = 0;
        }
        if (Token.containsTokenWithValue(tokenArrLexx, "s")) {
            i = i2;
        } else {
            j3 += ((long) i2) * 1000;
            i = 0;
        }
        return format(tokenArrLexx, i7, i6, actualMaximum, i5, i4, i, j3, z);
    }
}
