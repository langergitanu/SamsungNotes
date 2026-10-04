package com.samsung.android.sdk.smp.common.util;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.sdk.smp.common.constants.Constants;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class TimeUtil {
    private static final String TAG = "TimeUtil";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Time {
        private int mHour;
        private int mMin;

        public Time(int i, int i2) {
            this.mHour = i;
            this.mMin = i2;
        }

        public int getHour() {
            return this.mHour;
        }

        public int getMin() {
            return this.mMin;
        }

        public String toString() {
            return TimeUtil.timeToString(this.mHour, this.mMin);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TimeRange {
        private Time mEndTime;
        private Time mStartTime;

        public TimeRange(Time time, Time time2) {
            this.mStartTime = time;
            this.mEndTime = time2;
        }

        public Time getEndTime() {
            return this.mEndTime;
        }

        public Time getStartTime() {
            return this.mStartTime;
        }

        public String toString() {
            return this.mStartTime.toString() + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + this.mEndTime.toString();
        }
    }

    public static long adjustLocalTimeToUtc0(long j) {
        return j - ((long) TimeZone.getDefault().getOffset(System.currentTimeMillis()));
    }

    public static Time adjustUtc0ToLocalTime(Time time) {
        int rawOffset = TimeZone.getDefault().getRawOffset();
        String str = TAG;
        StringBuilder sb = new StringBuilder("timezone offset : ");
        long j = rawOffset;
        sb.append(j / Constants.MINMILLIS);
        sb.append("(min)");
        SmpLog.m6498i(str, sb.toString());
        return shiftTime(time, j);
    }

    public static boolean equals(Time time, Time time2) {
        return timeToMin(time) == timeToMin(time2);
    }

    public static long getRandomMillis(long j, long j2) {
        long j3 = Constants.SECMILLIS;
        int i = (int) ((j2 - j) / j3);
        return i <= 0 ? j : (((long) new Random().nextInt(i)) * j3) + j;
    }

    public static String getString(long j) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            return calendar.getTime().toString();
        } catch (Error unused) {
            return AbstractC0622a.m1169o("", j);
        } catch (Exception unused2) {
            return AbstractC0622a.m1169o("", j);
        }
    }

    public static int getTimeDiffMin(Time time, Time time2) {
        int iTimeToMin = timeToMin(time2) - timeToMin(time);
        return iTimeToMin < 0 ? iTimeToMin + 1440 : iTimeToMin;
    }

    public static boolean isInvalidHour(int i) {
        return i < 0 || i > 24;
    }

    public static boolean isInvalidMinute(int i) {
        return i < 0 || i > 59;
    }

    public static boolean isInvalidRandom(int i) {
        return i < 0 || i > 1440;
    }

    public static boolean isTimeInBetween(Time time, Time time2, int i, int i2) {
        if (time.getHour() >= 0 && time2.getHour() >= 0) {
            int iTimeToMin = timeToMin(time);
            int iTimeToMin2 = timeToMin(time2);
            int iTimeToMin3 = timeToMin(i, i2);
            if (iTimeToMin > iTimeToMin2) {
                return iTimeToMin2 > iTimeToMin3 || iTimeToMin3 >= iTimeToMin;
            }
            if (iTimeToMin <= iTimeToMin3 && iTimeToMin3 < iTimeToMin2) {
                return true;
            }
        }
        return false;
    }

    public static void setTime(Calendar calendar, int i, int i2, int i4) {
        if (calendar != null && i >= 0 && i < 24 && i2 >= 0 && i2 < 60 && i4 >= 0 && i4 < 60) {
            calendar.set(11, i);
            calendar.set(12, i2);
            calendar.set(13, i4);
        }
    }

    public static Time shiftTime(Time time, long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, time.getHour());
        calendar.set(12, time.getMin());
        calendar.setTimeInMillis(calendar.getTimeInMillis() + j);
        return new Time(calendar.get(11), calendar.get(12));
    }

    private static int timeToMin(int i, int i2) {
        return (i * 60) + i2;
    }

    public static String timeToString(int i, int i2) {
        StringBuilder sbM1322o = AbstractC1974b.m1322o(i, ":");
        sbM1322o.append(i2 < 10 ? "0" : "");
        sbM1322o.append(i2);
        return sbM1322o.toString();
    }

    private static int timeToMin(Time time) {
        return timeToMin(time.getHour(), time.getMin());
    }

    public static Time adjustUtc0ToLocalTime(int i, int i2) {
        return adjustUtc0ToLocalTime(new Time(i, i2));
    }

    public static boolean isTimeInBetween(Time time, Time time2, Time time3) {
        return isTimeInBetween(time, time2, time3.getHour(), time3.getMin());
    }

    public static boolean isTimeInBetween(Time time, Time time2, long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return isTimeInBetween(time, time2, calendar.get(11), calendar.get(12));
    }

    public static boolean isTimeInBetween(Time time, Time time2, Time time3, Time time4, long j) {
        if (isTimeInBetween(time3, time4, j)) {
            return false;
        }
        return isTimeInBetween(time, time2, j);
    }
}
