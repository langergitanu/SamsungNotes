package com.adobe.internal.xmp;

import com.adobe.internal.xmp.impl.XMPDateTimeImpl;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class XMPDateTimeFactory {
    private static final TimeZone UTC = TimeZone.getTimeZone("UTC");

    private XMPDateTimeFactory() {
    }

    public static XMPDateTime convertToLocalTime(XMPDateTime xMPDateTime) {
        long timeInMillis = xMPDateTime.getCalendar().getTimeInMillis();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(timeInMillis);
        return new XMPDateTimeImpl(gregorianCalendar);
    }

    public static XMPDateTime convertToUTCTime(XMPDateTime xMPDateTime) {
        long timeInMillis = xMPDateTime.getCalendar().getTimeInMillis();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(UTC);
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        gregorianCalendar.setTimeInMillis(timeInMillis);
        return new XMPDateTimeImpl(gregorianCalendar);
    }

    public static XMPDateTime create() {
        return new XMPDateTimeImpl();
    }

    public static XMPDateTime createFromCalendar(Calendar calendar) {
        return new XMPDateTimeImpl(calendar);
    }

    public static XMPDateTime createFromISO8601(String str) {
        return new XMPDateTimeImpl(str);
    }

    public static XMPDateTime getCurrentDateTime() {
        return new XMPDateTimeImpl(new GregorianCalendar());
    }

    public static XMPDateTime setLocalTimeZone(XMPDateTime xMPDateTime) {
        Calendar calendar = xMPDateTime.getCalendar();
        calendar.setTimeZone(TimeZone.getDefault());
        return new XMPDateTimeImpl(calendar);
    }

    public static XMPDateTime create(int i, int i2, int i4) {
        XMPDateTimeImpl xMPDateTimeImpl = new XMPDateTimeImpl();
        xMPDateTimeImpl.setYear(i);
        xMPDateTimeImpl.setMonth(i2);
        xMPDateTimeImpl.setDay(i4);
        return xMPDateTimeImpl;
    }

    public static XMPDateTime create(int i, int i2, int i4, int i5, int i6, int i7, int i8) {
        XMPDateTimeImpl xMPDateTimeImpl = new XMPDateTimeImpl();
        xMPDateTimeImpl.setYear(i);
        xMPDateTimeImpl.setMonth(i2);
        xMPDateTimeImpl.setDay(i4);
        xMPDateTimeImpl.setHour(i5);
        xMPDateTimeImpl.setMinute(i6);
        xMPDateTimeImpl.setSecond(i7);
        xMPDateTimeImpl.setNanoSecond(i8);
        return xMPDateTimeImpl;
    }
}
