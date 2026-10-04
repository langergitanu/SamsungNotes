package org.apache.xmlbeans;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XmlCalendar extends GregorianCalendar {
    private static final int DEFAULT_DEFAULT_YEAR = 0;
    private static Date _beginningOfTime = new Date(Long.MIN_VALUE);
    private static int defaultYear = Integer.MIN_VALUE;

    public XmlCalendar(String str) {
        this((GDateSpecification) new GDate(str));
    }

    public static int getDefaultYear() {
        if (defaultYear == Integer.MIN_VALUE) {
            try {
                String property = SystemProperties.getProperty("user.defaultyear");
                if (property != null) {
                    defaultYear = Integer.parseInt(property);
                } else {
                    defaultYear = 0;
                }
            } catch (Throwable unused) {
                defaultYear = 0;
            }
        }
        return defaultYear;
    }

    public static void setDefaultYear(int i) {
        defaultYear = i;
    }

    @Override // java.util.GregorianCalendar, java.util.Calendar
    public void computeTime() {
        boolean zIsSet = isSet(1);
        if (!zIsSet) {
            set(1, getDefaultYear());
        }
        try {
            super.computeTime();
        } finally {
            if (!zIsSet) {
                clear(1);
            }
        }
    }

    @Override // java.util.Calendar
    public int get(int i) {
        return (!isSet(i) || ((GregorianCalendar) this).isTimeSet) ? super.get(i) : internalGet(i);
    }

    @Override // java.util.Calendar
    public String toString() {
        return new GDate(this).toString();
    }

    public XmlCalendar(GDateSpecification gDateSpecification) {
        this(GDate.timeZoneForGDate(gDateSpecification), gDateSpecification);
    }

    private XmlCalendar(TimeZone timeZone, GDateSpecification gDateSpecification) {
        super(timeZone);
        setGregorianChange(_beginningOfTime);
        clear();
        if (gDateSpecification.hasYear()) {
            int year = gDateSpecification.getYear();
            if (year > 0) {
                set(0, 1);
            } else {
                set(0, 0);
                year = -year;
            }
            set(1, year);
        }
        if (gDateSpecification.hasMonth()) {
            set(2, gDateSpecification.getMonth() - 1);
        }
        if (gDateSpecification.hasDay()) {
            set(5, gDateSpecification.getDay());
        }
        if (gDateSpecification.hasTime()) {
            set(11, gDateSpecification.getHour());
            set(12, gDateSpecification.getMinute());
            set(13, gDateSpecification.getSecond());
            if (gDateSpecification.getFraction().scale() > 0) {
                set(14, gDateSpecification.getMillisecond());
            }
        }
        if (gDateSpecification.hasTimeZone()) {
            set(15, (gDateSpecification.getTimeZoneMinute() + (gDateSpecification.getTimeZoneHour() * 60)) * gDateSpecification.getTimeZoneSign() * 60000);
            set(16, 0);
        }
    }

    public XmlCalendar(Date date) {
        this(TimeZone.getDefault(), new GDate(date));
        complete();
    }

    public XmlCalendar(int i, int i2, int i4, int i5, int i6, int i7, BigDecimal bigDecimal) {
        this(TimeZone.getDefault(), new GDate(i, i2, i4, i5, i6, i7, bigDecimal));
    }

    public XmlCalendar(int i, int i2, int i4, int i5, int i6, int i7, BigDecimal bigDecimal, int i8, int i9, int i10) {
        this((GDateSpecification) new GDate(i, i2, i4, i5, i6, i7, bigDecimal, i8, i9, i10));
    }

    public XmlCalendar() {
        setGregorianChange(_beginningOfTime);
        clear();
    }
}
