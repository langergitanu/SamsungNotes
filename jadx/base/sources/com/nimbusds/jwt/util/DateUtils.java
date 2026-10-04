package com.nimbusds.jwt.util;

import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DateUtils {
    private DateUtils() {
    }

    public static Date fromSecondsSinceEpoch(long j) {
        return new Date(j * 1000);
    }

    public static boolean isAfter(Date date, Date date2, long j) {
        return new Date((j * 1000) + date.getTime()).after(date2);
    }

    public static boolean isBefore(Date date, Date date2, long j) {
        return new Date(date.getTime() - (j * 1000)).before(date2);
    }

    public static boolean isWithin(Date date, Date date2, long j) {
        long j2 = j * 1000;
        return date.getTime() > date2.getTime() - j2 && date.getTime() < date2.getTime() + j2;
    }

    public static Date nowWithSecondsPrecision() {
        return fromSecondsSinceEpoch(toSecondsSinceEpoch(new Date()));
    }

    public static long toSecondsSinceEpoch(Date date) {
        return date.getTime() / 1000;
    }
}
