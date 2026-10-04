package com.samsung.android.support.senl.p148nt.model.utils;

import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DocumentTimeUtils {
    static final int EXPIRED_DAYS_IN_RECYCLE_BIN = 30;
    static final long MILLISECOND_FOR_1_DAY = 86400000;
    private static final String TAG = ModelLogger.createTag("DocumentTimeUtils");

    public static long getPastTime(long j, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(calendar.getTimeZone());
        gregorianCalendar.set(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5), gregorianCalendar.get(11), gregorianCalendar.get(12));
        gregorianCalendar.add(5, i * (-1));
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        DataLogger.m12307i(TAG, "getPastTime: " + timeInMillis);
        return timeInMillis;
    }

    public static int getRecycleBinDueDate(long j) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar2.setTimeInMillis(System.currentTimeMillis());
        int i = 0;
        while (i < 30 && calendar.getTimeInMillis() < calendar2.getTimeInMillis() && !isSameDay(calendar, calendar2)) {
            i++;
            calendar.setTimeInMillis((((long) i) * 86400000) + j);
        }
        return 30 - i;
    }

    public static long getRecycleBinExpiredTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        GregorianCalendar gregorianCalendar = new GregorianCalendar(calendar.getTimeZone());
        gregorianCalendar.set(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5), 0, 0);
        gregorianCalendar.add(5, -30);
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        DataLogger.m12307i(TAG, "getRecycleBinExpiredTime: " + timeInMillis);
        return timeInMillis;
    }

    private static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        return calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    public static void setDisplayTimes(@NonNull String str, long j, long j2) {
        SpenWNoteFile.setDisplayCreatedTime(str, j);
        SpenWNoteFile.setDisplayModifiedTime(str, j2);
    }
}
