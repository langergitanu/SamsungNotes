package com.adobe.internal.xmp.impl;

import com.adobe.internal.xmp.XMPDateTime;
import com.adobe.internal.xmp.XMPException;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.HandoffLaunchManager;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class XMPDateTimeImpl implements XMPDateTime {
    private int day;
    private boolean hasDate;
    private boolean hasTime;
    private boolean hasTimeZone;
    private int hour;
    private int minute;
    private int month;
    private int nanoSeconds;
    private int second;
    private TimeZone timeZone;
    private int year;

    public XMPDateTimeImpl() {
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
        this.timeZone = null;
        this.hasDate = false;
        this.hasTime = false;
        this.hasTimeZone = false;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        long timeInMillis = getCalendar().getTimeInMillis() - ((XMPDateTime) obj).getCalendar().getTimeInMillis();
        return (int) (timeInMillis != 0 ? Math.signum(timeInMillis) : Math.signum(this.nanoSeconds - r5.getNanoSecond()));
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public Calendar getCalendar() {
        GregorianCalendar gregorianCalendar = (GregorianCalendar) Calendar.getInstance(Locale.US);
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        if (this.hasTimeZone) {
            gregorianCalendar.setTimeZone(this.timeZone);
        }
        gregorianCalendar.set(1, this.year);
        gregorianCalendar.set(2, this.month - 1);
        gregorianCalendar.set(5, this.day);
        gregorianCalendar.set(11, this.hour);
        gregorianCalendar.set(12, this.minute);
        gregorianCalendar.set(13, this.second);
        gregorianCalendar.set(14, this.nanoSeconds / 1000000);
        return gregorianCalendar;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public int getDay() {
        return this.day;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public int getHour() {
        return this.hour;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public String getISO8601String() {
        return ISO8601Converter.render(this);
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public int getMinute() {
        return this.minute;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public int getMonth() {
        return this.month;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public int getNanoSecond() {
        return this.nanoSeconds;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public int getSecond() {
        return this.second;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public int getYear() {
        return this.year;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public boolean hasDate() {
        return this.hasDate;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public boolean hasTime() {
        return this.hasTime;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public boolean hasTimeZone() {
        return this.hasTimeZone;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public void setDay(int i) {
        if (i < 1) {
            this.day = 1;
        } else if (i > 31) {
            this.day = 31;
        } else {
            this.day = i;
        }
        this.hasDate = true;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public void setHour(int i) {
        this.hour = Math.min(Math.abs(i), 23);
        this.hasTime = true;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public void setMinute(int i) {
        this.minute = Math.min(Math.abs(i), 59);
        this.hasTime = true;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public void setMonth(int i) {
        if (i < 1) {
            this.month = 1;
        } else if (i > 12) {
            this.month = 12;
        } else {
            this.month = i;
        }
        this.hasDate = true;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public void setNanoSecond(int i) {
        this.nanoSeconds = i;
        this.hasTime = true;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public void setSecond(int i) {
        this.second = Math.min(Math.abs(i), 59);
        this.hasTime = true;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
        this.hasTime = true;
        this.hasTimeZone = true;
    }

    @Override // com.adobe.internal.xmp.XMPDateTime
    public void setYear(int i) {
        this.year = Math.min(Math.abs(i), HandoffLaunchManager.SYNC_PERMISSION_REQUEST_CODE);
        this.hasDate = true;
    }

    public String toString() {
        return getISO8601String();
    }

    public XMPDateTimeImpl(Calendar calendar) {
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
        this.timeZone = null;
        this.hasDate = false;
        this.hasTime = false;
        this.hasTimeZone = false;
        Date time = calendar.getTime();
        TimeZone timeZone = calendar.getTimeZone();
        GregorianCalendar gregorianCalendar = (GregorianCalendar) Calendar.getInstance(Locale.US);
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        gregorianCalendar.setTimeZone(timeZone);
        gregorianCalendar.setTime(time);
        this.year = gregorianCalendar.get(1);
        this.month = gregorianCalendar.get(2) + 1;
        this.day = gregorianCalendar.get(5);
        this.hour = gregorianCalendar.get(11);
        this.minute = gregorianCalendar.get(12);
        this.second = gregorianCalendar.get(13);
        this.nanoSeconds = gregorianCalendar.get(14) * 1000000;
        this.timeZone = gregorianCalendar.getTimeZone();
        this.hasTimeZone = true;
        this.hasTime = true;
        this.hasDate = true;
    }

    public XMPDateTimeImpl(Date date, TimeZone timeZone) {
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
        this.timeZone = null;
        this.hasDate = false;
        this.hasTime = false;
        this.hasTimeZone = false;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
        gregorianCalendar.setTime(date);
        this.year = gregorianCalendar.get(1);
        this.month = gregorianCalendar.get(2) + 1;
        this.day = gregorianCalendar.get(5);
        this.hour = gregorianCalendar.get(11);
        this.minute = gregorianCalendar.get(12);
        this.second = gregorianCalendar.get(13);
        this.nanoSeconds = gregorianCalendar.get(14) * 1000000;
        this.timeZone = timeZone;
        this.hasTimeZone = true;
        this.hasTime = true;
        this.hasDate = true;
    }

    public XMPDateTimeImpl(String str) throws XMPException {
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
        this.timeZone = null;
        this.hasDate = false;
        this.hasTime = false;
        this.hasTimeZone = false;
        ISO8601Converter.parse(str, this);
    }
}
