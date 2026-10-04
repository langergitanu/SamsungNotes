package com.adobe.internal.xmp;

import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface XMPDateTime extends Comparable {
    Calendar getCalendar();

    int getDay();

    int getHour();

    String getISO8601String();

    int getMinute();

    int getMonth();

    int getNanoSecond();

    int getSecond();

    TimeZone getTimeZone();

    int getYear();

    boolean hasDate();

    boolean hasTime();

    boolean hasTimeZone();

    void setDay(int i);

    void setHour(int i);

    void setMinute(int i);

    void setMonth(int i);

    void setNanoSecond(int i);

    void setSecond(int i);

    void setTimeZone(TimeZone timeZone);

    void setYear(int i);
}
