package com.google.api.client.util;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.TimeZones;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class DateTime implements Serializable {
    private static final TimeZone GMT = TimeZone.getTimeZone(TimeZones.GMT_ID);
    private static final Pattern RFC3339_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d+)?)?([Zz]|([+-])(\\d{2}):(\\d{2}))?");
    private static final long serialVersionUID = 1;
    private final boolean dateOnly;
    private final int tzShift;
    private final long value;

    public DateTime(Date date, TimeZone timeZone) {
        this(false, date.getTime(), timeZone == null ? null : Integer.valueOf(timeZone.getOffset(date.getTime()) / 60000));
    }

    private static void appendInt(StringBuilder sb, int i, int i2) {
        if (i < 0) {
            sb.append('-');
            i = -i;
        }
        int i4 = i;
        while (i4 > 0) {
            i4 /= 10;
            i2--;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            sb.append('0');
        }
        if (i != 0) {
            sb.append(i);
        }
    }

    public static DateTime parseRfc3339(String str) {
        boolean z;
        int i;
        int i2;
        int i4;
        int i5;
        Integer numValueOf;
        int i6;
        Matcher matcher = RFC3339_PATTERN.matcher(str);
        if (!matcher.matches()) {
            throw new NumberFormatException(AbstractC0541b.m772n("Invalid date/time format: ", str));
        }
        int i7 = Integer.parseInt(matcher.group(1));
        int i8 = Integer.parseInt(matcher.group(2)) - 1;
        int i9 = Integer.parseInt(matcher.group(3));
        boolean z2 = matcher.group(4) != null;
        String strGroup = matcher.group(9);
        boolean z3 = strGroup != null;
        if (z3 && !z2) {
            throw new NumberFormatException(AbstractC0541b.m772n("Invalid date/time format, cannot specify time zone shift without specifying time: ", str));
        }
        if (z2) {
            int i10 = Integer.parseInt(matcher.group(5));
            int i11 = Integer.parseInt(matcher.group(6));
            int i12 = Integer.parseInt(matcher.group(7));
            if (matcher.group(8) != null) {
                z = z2;
                i = (int) (((double) Integer.parseInt(matcher.group(8).substring(1))) / Math.pow(10.0d, matcher.group(8).substring(1).length() - 3));
                i4 = i11;
                i5 = i12;
            } else {
                z = z2;
                i4 = i11;
                i5 = i12;
                i = 0;
            }
            i2 = i10;
        } else {
            z = z2;
            i = 0;
            i2 = 0;
            i4 = 0;
            i5 = 0;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(GMT);
        gregorianCalendar.set(i7, i8, i9, i2, i4, i5);
        gregorianCalendar.set(14, i);
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        if (z && z3) {
            if (Character.toUpperCase(strGroup.charAt(0)) == 'Z') {
                i6 = 0;
            } else {
                int i13 = Integer.parseInt(matcher.group(12)) + (Integer.parseInt(matcher.group(11)) * 60);
                i6 = matcher.group(10).charAt(0) == '-' ? -i13 : i13;
                timeInMillis -= ((long) i6) * 60000;
            }
            numValueOf = Integer.valueOf(i6);
        } else {
            numValueOf = null;
        }
        return new DateTime(!z, timeInMillis, numValueOf);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DateTime)) {
            return false;
        }
        DateTime dateTime = (DateTime) obj;
        return this.dateOnly == dateTime.dateOnly && this.value == dateTime.value && this.tzShift == dateTime.tzShift;
    }

    public int getTimeZoneShift() {
        return this.tzShift;
    }

    public long getValue() {
        return this.value;
    }

    public int hashCode() {
        return Arrays.hashCode(new long[]{this.value, this.dateOnly ? 1L : 0L, this.tzShift});
    }

    public boolean isDateOnly() {
        return this.dateOnly;
    }

    public String toString() {
        return toStringRfc3339();
    }

    public String toStringRfc3339() {
        StringBuilder sb = new StringBuilder();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(GMT);
        gregorianCalendar.setTimeInMillis((((long) this.tzShift) * 60000) + this.value);
        appendInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        appendInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        appendInt(sb, gregorianCalendar.get(5), 2);
        if (!this.dateOnly) {
            sb.append('T');
            appendInt(sb, gregorianCalendar.get(11), 2);
            sb.append(':');
            appendInt(sb, gregorianCalendar.get(12), 2);
            sb.append(':');
            appendInt(sb, gregorianCalendar.get(13), 2);
            if (gregorianCalendar.isSet(14)) {
                sb.append('.');
                appendInt(sb, gregorianCalendar.get(14), 3);
            }
            int i = this.tzShift;
            if (i == 0) {
                sb.append('Z');
            } else {
                if (i > 0) {
                    sb.append('+');
                } else {
                    sb.append('-');
                    i = -i;
                }
                appendInt(sb, i / 60, 2);
                sb.append(':');
                appendInt(sb, i % 60, 2);
            }
        }
        return sb.toString();
    }

    public DateTime(long j) {
        this(false, j, null);
    }

    public DateTime(Date date) {
        this(date.getTime());
    }

    public DateTime(long j, int i) {
        this(false, j, Integer.valueOf(i));
    }

    public DateTime(boolean z, long j, Integer num) {
        int offset;
        this.dateOnly = z;
        this.value = j;
        if (z) {
            offset = 0;
        } else {
            offset = num == null ? TimeZone.getDefault().getOffset(j) / 60000 : num.intValue();
        }
        this.tzShift = offset;
    }

    public DateTime(String str) {
        DateTime rfc3339 = parseRfc3339(str);
        this.dateOnly = rfc3339.dateOnly;
        this.value = rfc3339.value;
        this.tzShift = rfc3339.tzShift;
    }
}
