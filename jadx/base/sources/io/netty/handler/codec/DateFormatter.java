package io.netty.handler.codec;

import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.netty.util.AsciiString;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectUtil;
import java.util.BitSet;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class DateFormatter {
    private static final String[] CALENDAR_MONTH_TO_SHORT_NAME;
    private static final String[] DAY_OF_WEEK_TO_SHORT_NAME;
    private static final BitSet DELIMITERS;
    private static final FastThreadLocal<DateFormatter> INSTANCES;
    private final GregorianCalendar cal;
    private int dayOfMonth;
    private boolean dayOfMonthFound;
    private int hours;
    private int minutes;
    private int month;
    private boolean monthFound;

    /* JADX INFO: renamed from: sb */
    private final StringBuilder f8872sb;
    private int seconds;
    private boolean timeFound;
    private int year;
    private boolean yearFound;

    static {
        BitSet bitSet = new BitSet();
        DELIMITERS = bitSet;
        bitSet.set(9);
        for (char c = ' '; c <= '/'; c = (char) (c + 1)) {
            DELIMITERS.set(c);
        }
        for (char c2 = SQLKeyword.DELIMITER; c2 <= '@'; c2 = (char) (c2 + 1)) {
            DELIMITERS.set(c2);
        }
        for (char c4 = PropertyUtils.INDEXED_DELIM; c4 <= '`'; c4 = (char) (c4 + 1)) {
            DELIMITERS.set(c4);
        }
        for (char c5 = '{'; c5 <= '~'; c5 = (char) (c5 + 1)) {
            DELIMITERS.set(c5);
        }
        DAY_OF_WEEK_TO_SHORT_NAME = new String[]{CoverStickerConstants.Category.SUN.NAME, "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        CALENDAR_MONTH_TO_SHORT_NAME = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        INSTANCES = new FastThreadLocal<DateFormatter>() { // from class: io.netty.handler.codec.DateFormatter.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public DateFormatter initialValue() {
                return new DateFormatter();
            }
        };
    }

    public static StringBuilder append(Date date, StringBuilder sb) {
        return formatter().append0((Date) ObjectUtil.checkNotNull(date, "date"), (StringBuilder) ObjectUtil.checkNotNull(sb, "sb"));
    }

    private StringBuilder append0(Date date, StringBuilder sb) {
        this.cal.setTime(date);
        sb.append(DAY_OF_WEEK_TO_SHORT_NAME[this.cal.get(7) - 1]);
        sb.append(SQLKeyword.COMMA);
        appendZeroLeftPadded(this.cal.get(5), sb).append(' ');
        sb.append(CALENDAR_MONTH_TO_SHORT_NAME[this.cal.get(2)]);
        sb.append(' ');
        sb.append(this.cal.get(1));
        sb.append(' ');
        appendZeroLeftPadded(this.cal.get(11), sb).append(':');
        appendZeroLeftPadded(this.cal.get(12), sb).append(':');
        StringBuilder sbAppendZeroLeftPadded = appendZeroLeftPadded(this.cal.get(13), sb);
        sbAppendZeroLeftPadded.append(" GMT");
        return sbAppendZeroLeftPadded;
    }

    private static StringBuilder appendZeroLeftPadded(int i, StringBuilder sb) {
        if (i < 10) {
            sb.append('0');
        }
        sb.append(i);
        return sb;
    }

    private Date computeDate() {
        this.cal.set(5, this.dayOfMonth);
        this.cal.set(2, this.month);
        this.cal.set(1, this.year);
        this.cal.set(11, this.hours);
        this.cal.set(12, this.minutes);
        this.cal.set(13, this.seconds);
        return this.cal.getTime();
    }

    public static String format(Date date) {
        return formatter().format0((Date) ObjectUtil.checkNotNull(date, "date"));
    }

    private String format0(Date date) {
        append0(date, this.f8872sb);
        return this.f8872sb.toString();
    }

    private static DateFormatter formatter() {
        DateFormatter dateFormatter = INSTANCES.get();
        dateFormatter.reset();
        return dateFormatter;
    }

    private static int getNumericalValue(char c) {
        return c - '0';
    }

    private static boolean isDelim(char c) {
        return DELIMITERS.get(c);
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean normalizeAndValidate() {
        int i = this.dayOfMonth;
        if (i < 1 || i > 31 || this.hours > 23 || this.minutes > 59 || this.seconds > 59) {
            return false;
        }
        int i2 = this.year;
        if (i2 >= 70 && i2 <= 99) {
            this.year = i2 + 1900;
        } else if (i2 >= 0 && i2 < 70) {
            this.year = i2 + 2000;
        } else if (i2 < 1601) {
            return false;
        }
        return true;
    }

    private Date parse0(CharSequence charSequence, int i, int i2) {
        if (parse1(charSequence, i, i2) && normalizeAndValidate()) {
            return computeDate();
        }
        return null;
    }

    private boolean parse1(CharSequence charSequence, int i, int i2) {
        int i4 = -1;
        while (i < i2) {
            if (isDelim(charSequence.charAt(i))) {
                if (i4 == -1) {
                    continue;
                } else {
                    if (parseToken(charSequence, i4, i)) {
                        return true;
                    }
                    i4 = -1;
                }
            } else if (i4 == -1) {
                i4 = i;
            }
            i++;
        }
        return i4 != -1 && parseToken(charSequence, i4, charSequence.length());
    }

    public static Date parseHttpDate(CharSequence charSequence) {
        return parseHttpDate(charSequence, 0, charSequence.length());
    }

    private boolean parseToken(CharSequence charSequence, int i, int i2) {
        if (!this.timeFound) {
            boolean zTryParseTime = tryParseTime(charSequence, i, i2);
            this.timeFound = zTryParseTime;
            if (zTryParseTime) {
                return this.dayOfMonthFound && this.monthFound && this.yearFound;
            }
        }
        if (!this.dayOfMonthFound) {
            boolean zTryParseDayOfMonth = tryParseDayOfMonth(charSequence, i, i2);
            this.dayOfMonthFound = zTryParseDayOfMonth;
            if (zTryParseDayOfMonth) {
                return this.timeFound && this.monthFound && this.yearFound;
            }
        }
        if (!this.monthFound) {
            boolean zTryParseMonth = tryParseMonth(charSequence, i, i2);
            this.monthFound = zTryParseMonth;
            if (zTryParseMonth) {
                return this.timeFound && this.dayOfMonthFound && this.yearFound;
            }
        }
        if (!this.yearFound) {
            this.yearFound = tryParseYear(charSequence, i, i2);
        }
        return this.timeFound && this.dayOfMonthFound && this.monthFound && this.yearFound;
    }

    private boolean tryParseDayOfMonth(CharSequence charSequence, int i, int i2) {
        int i4 = i2 - i;
        if (i4 == 1) {
            char cCharAt = charSequence.charAt(i);
            if (!isDigit(cCharAt)) {
                return false;
            }
            this.dayOfMonth = getNumericalValue(cCharAt);
            return true;
        }
        if (i4 != 2) {
            return false;
        }
        char cCharAt2 = charSequence.charAt(i);
        char cCharAt3 = charSequence.charAt(i + 1);
        if (!isDigit(cCharAt2) || !isDigit(cCharAt3)) {
            return false;
        }
        this.dayOfMonth = (getNumericalValue(cCharAt2) * 10) + getNumericalValue(cCharAt3);
        return true;
    }

    private boolean tryParseMonth(CharSequence charSequence, int i, int i2) {
        if (i2 - i != 3) {
            return false;
        }
        char lowerCase = AsciiString.toLowerCase(charSequence.charAt(i));
        char lowerCase2 = AsciiString.toLowerCase(charSequence.charAt(i + 1));
        char lowerCase3 = AsciiString.toLowerCase(charSequence.charAt(i + 2));
        if (lowerCase == 'j' && lowerCase2 == 'a' && lowerCase3 == 'n') {
            this.month = 0;
        } else if (lowerCase == 'f' && lowerCase2 == 'e' && lowerCase3 == 'b') {
            this.month = 1;
        } else if (lowerCase == 'm' && lowerCase2 == 'a' && lowerCase3 == 'r') {
            this.month = 2;
        } else if (lowerCase == 'a' && lowerCase2 == 'p' && lowerCase3 == 'r') {
            this.month = 3;
        } else if (lowerCase == 'm' && lowerCase2 == 'a' && lowerCase3 == 'y') {
            this.month = 4;
        } else if (lowerCase == 'j' && lowerCase2 == 'u' && lowerCase3 == 'n') {
            this.month = 5;
        } else if (lowerCase == 'j' && lowerCase2 == 'u' && lowerCase3 == 'l') {
            this.month = 6;
        } else if (lowerCase == 'a' && lowerCase2 == 'u' && lowerCase3 == 'g') {
            this.month = 7;
        } else if (lowerCase == 's' && lowerCase2 == 'e' && lowerCase3 == 'p') {
            this.month = 8;
        } else if (lowerCase == 'o' && lowerCase2 == 'c' && lowerCase3 == 't') {
            this.month = 9;
        } else if (lowerCase == 'n' && lowerCase2 == 'o' && lowerCase3 == 'v') {
            this.month = 10;
        } else {
            if (lowerCase != 'd' || lowerCase2 != 'e' || lowerCase3 != 'c') {
                return false;
            }
            this.month = 11;
        }
        return true;
    }

    private boolean tryParseTime(CharSequence charSequence, int i, int i2) {
        int i4 = i2 - i;
        if (i4 >= 5 && i4 <= 8) {
            int i5 = -1;
            int i6 = -1;
            int i7 = 0;
            int numericalValue = 0;
            int i8 = 0;
            while (i < i2) {
                char cCharAt = charSequence.charAt(i);
                if (isDigit(cCharAt)) {
                    numericalValue = (numericalValue * 10) + getNumericalValue(cCharAt);
                    i7++;
                    if (i7 > 2) {
                        return false;
                    }
                } else {
                    if (cCharAt != ':' || i7 == 0) {
                        return false;
                    }
                    if (i8 != 0) {
                        if (i8 != 1) {
                            return false;
                        }
                        i6 = numericalValue;
                        numericalValue = i5;
                    }
                    i8++;
                    i7 = 0;
                    i5 = numericalValue;
                    numericalValue = 0;
                }
                i++;
            }
            int i9 = i7 > 0 ? numericalValue : -1;
            if (i5 >= 0 && i6 >= 0 && i9 >= 0) {
                this.hours = i5;
                this.minutes = i6;
                this.seconds = i9;
                return true;
            }
        }
        return false;
    }

    private boolean tryParseYear(CharSequence charSequence, int i, int i2) {
        int i4 = i2 - i;
        if (i4 == 2) {
            char cCharAt = charSequence.charAt(i);
            char cCharAt2 = charSequence.charAt(i + 1);
            if (!isDigit(cCharAt) || !isDigit(cCharAt2)) {
                return false;
            }
            this.year = (getNumericalValue(cCharAt) * 10) + getNumericalValue(cCharAt2);
            return true;
        }
        if (i4 != 4) {
            return false;
        }
        char cCharAt3 = charSequence.charAt(i);
        char cCharAt4 = charSequence.charAt(i + 1);
        char cCharAt5 = charSequence.charAt(i + 2);
        char cCharAt6 = charSequence.charAt(i + 3);
        if (!isDigit(cCharAt3) || !isDigit(cCharAt4) || !isDigit(cCharAt5) || !isDigit(cCharAt6)) {
            return false;
        }
        this.year = (getNumericalValue(cCharAt5) * 10) + (getNumericalValue(cCharAt4) * 100) + (getNumericalValue(cCharAt3) * 1000) + getNumericalValue(cCharAt6);
        return true;
    }

    public void reset() {
        this.timeFound = false;
        this.hours = -1;
        this.minutes = -1;
        this.seconds = -1;
        this.dayOfMonthFound = false;
        this.dayOfMonth = -1;
        this.monthFound = false;
        this.month = -1;
        this.yearFound = false;
        this.year = -1;
        this.cal.clear();
        this.f8872sb.setLength(0);
    }

    private DateFormatter() {
        this.cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        this.f8872sb = new StringBuilder(29);
        reset();
    }

    public static Date parseHttpDate(CharSequence charSequence, int i, int i2) {
        int i4 = i2 - i;
        if (i4 == 0) {
            return null;
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Can't have end < start");
        }
        if (i4 <= 64) {
            return formatter().parse0((CharSequence) ObjectUtil.checkNotNull(charSequence, Constants.TEXT_EXTENSION), i, i2);
        }
        throw new IllegalArgumentException("Can't parse more than 64 chars, looks like a user error or a malformed header");
    }
}
