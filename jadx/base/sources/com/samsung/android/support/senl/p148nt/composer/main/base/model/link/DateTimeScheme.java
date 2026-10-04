package com.samsung.android.support.senl.p148nt.composer.main.base.model.link;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class DateTimeScheme {
    static final String ENGLISH_DATE_TIME_1_SCHEME = "english_date_time_1://";
    static final String ENGLISH_DATE_TIME_2_SCHEME = "english_date_time_2://";
    static final String ENGLISH_DATE_TIME_3_SCHEME = "english_date_time_3://";
    static final String ENGLISH_DATE_TIME_4_SCHEME = "english_date_time_4://";
    static final String ENGLISH_DATE_TIME_5_SCHEME = "english_date_time_5://";
    static final String KOREAN_DATE_TIME_1_SCHEME = "korean_date_time_1://";
    static final String KOREAN_DATE_TIME_2_SCHEME = "korean_date_time_2://";
    static final String KOREAN_DATE_TIME_3_SCHEME = "korean_date_time_3://";
    static final String KOREAN_DATE_TIME_4_SCHEME = "korean_date_time_4://";
    static final String KOREAN_DATE_TIME_5_SCHEME = "korean_date_time_5://";
    static final String KOREAN_DATE_TIME_6_SCHEME = "korean_date_time_6://";
    static final String STANDARD_DATE_TIME_1_SCHEME = "standard_date_time_1://";
    static final String STANDARD_DATE_TIME_2_SCHEME = "standard_data_time_2://";
    static final String STANDARD_DATE_TIME_3_SCHEME = "standard_date_time_3://";
    static final String STANDARD_DATE_TIME_4_SCHEME = "standard_date_time_4://";
    static final String WESTERN_DATE_TIME_1_SCHEME = "western_date_time_1://";
    static final String WESTERN_DATE_TIME_2_SCHEME = "western_date_time_2://";
    static final String WESTERN_DATE_TIME_3_SCHEME = "western_date_time_3://";
    static final String WESTERN_DATE_TIME_4_SCHEME = "western_date_time_4://";
    static final String WESTERN_DATE_TIME_5_SCHEME = "western_date_time_5://";

    private static String adjustTime(String str, SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2, long j) {
        long millis;
        String str2 = simpleDateFormat2.format(Long.valueOf(j));
        int length = DateTimeString.mArrDayOfWeek.length;
        int i = -1;
        int i2 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            Locale locale = Locale.US;
            if (str.toLowerCase(locale).equals(DateTimeString.mArrDayOfWeek[i4])) {
                i = i4;
            }
            if (DateTimeString.mArrDayOfWeek[i4].startsWith(str2.toLowerCase(locale))) {
                i2 = i4;
            }
        }
        long j2 = i - i2;
        if (j2 <= 0) {
            if (j2 < 0) {
                millis = TimeUnit.DAYS.toMillis(j2 + 7);
            }
            return simpleDateFormat.format(Long.valueOf(j));
        }
        millis = TimeUnit.DAYS.toMillis(j2);
        j += millis;
        return simpleDateFormat.format(Long.valueOf(j));
    }

    private static String dataTime3Scheme(String str, int i) {
        int i2;
        String string;
        String strM1614d;
        String[] strArrSplit = str.substring(i).split(" ");
        int length = strArrSplit.length - 2;
        while (true) {
            if (length <= 0) {
                string = "";
                strM1614d = "";
                break;
            }
            if (DateTimeString.getMonth(strArrSplit[length]) > 0) {
                string = Integer.toString(DateTimeString.getMonth(strArrSplit[length]));
                strM1614d = strArrSplit[Math.abs(length - strArrSplit.length)];
                if (strM1614d.length() >= 3) {
                    strM1614d = AbstractC2322a.m1614d(2, 0, strM1614d);
                }
            } else {
                length--;
            }
        }
        StringBuffer stringBuffer = new StringBuffer(AbstractC2322a.m1622l(strArrSplit[strArrSplit.length - 1], "/", string, "/", strM1614d));
        int length2 = strArrSplit.length - 3;
        for (i2 = 0; i2 < length2; i2++) {
            stringBuffer.append(' ');
            stringBuffer.append(strArrSplit[i2]);
        }
        return stringBuffer.toString();
    }

    private static String dateTime2Scheme(String str, int i) {
        String[] strArrSplit = str.substring(i).split(" ");
        String[] strArrExtractDate = DateTimeString.extractDate(strArrSplit);
        StringBuffer stringBuffer = new StringBuffer(strArrExtractDate[0] + "/" + strArrExtractDate[1] + "/" + strArrExtractDate[2]);
        int length = strArrSplit.length;
        for (int i2 = 3; i2 < length; i2++) {
            stringBuffer.append(' ');
            stringBuffer.append(strArrSplit[i2]);
        }
        return stringBuffer.toString();
    }

    public static String englishDateTime2Scheme(String str) {
        return dateTime2Scheme(str, 22);
    }

    public static String englishDateTime3Scheme(String str) {
        return dataTime3Scheme(str, 22);
    }

    public static String englishDateTime5Scheme(String str, SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2, long j) {
        String[] strArrSplit = str.substring(22).split(" ");
        StringBuffer stringBuffer = new StringBuffer(adjustTime(strArrSplit[0], simpleDateFormat, simpleDateFormat2, j));
        if (strArrSplit[1].equalsIgnoreCase("morning")) {
            stringBuffer.append(' ');
            stringBuffer.append(strArrSplit[2]);
            return stringBuffer.toString();
        }
        if (strArrSplit[1].equalsIgnoreCase("afternoon") || strArrSplit[1].equalsIgnoreCase("evening") || strArrSplit[1].equalsIgnoreCase("night")) {
            stringBuffer.append(' ');
            return AbstractC8014b.m7199a(stringBuffer, strArrSplit[2], "pm");
        }
        int length = strArrSplit.length;
        for (int i = 1; i < length; i++) {
            stringBuffer.append(' ');
            stringBuffer.append(strArrSplit[i]);
        }
        return stringBuffer.toString();
    }

    public static String koreanDateTime5Scheme(String str, SimpleDateFormat simpleDateFormat, long j) {
        String[] strArrSplit = str.substring(21).replace(DateTimeString.mHour + " ", ":").replace(DateTimeString.mMinute, "").replace(DateTimeString.mHour, "").split(" ");
        String englishWeekDay = DateTimeString.getEnglishWeekDay(strArrSplit[0]);
        String str2 = simpleDateFormat.format(Long.valueOf(j));
        int i = 1;
        if (englishWeekDay.equals(DateTimeString.mMorning) || englishWeekDay.equals(DateTimeString.mKrMorning2) || englishWeekDay.equals(DateTimeString.mKrMorning3)) {
            StringBuffer stringBuffer = new StringBuffer(str2);
            int length = strArrSplit.length;
            while (i < length) {
                stringBuffer.append(' ');
                stringBuffer.append(strArrSplit[i]);
                i++;
            }
            return stringBuffer.toString();
        }
        if (!englishWeekDay.equals(DateTimeString.mAfternoon) && !englishWeekDay.equals(DateTimeString.mEvening) && !englishWeekDay.equals(DateTimeString.mTonight)) {
            return str2;
        }
        int length2 = strArrSplit.length;
        StringBuilder sb = new StringBuilder(str2);
        while (i < length2) {
            sb.append(' ');
            sb.append(strArrSplit[i]);
            i++;
        }
        sb.append(" pm");
        return sb.toString();
    }

    public static String westernDateTime2Scheme(String str) {
        return dateTime2Scheme(str, 22);
    }

    public static String westernDateTime3Scheme(String str) {
        return dataTime3Scheme(str, 22);
    }

    public static String westernDateTime5Scheme(String str, SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2, long j) {
        String[] strArrSplit = str.substring(22).split(" ");
        String strAdjustTime = adjustTime(DateTimeString.getEnglishWeekDay(strArrSplit[0]), simpleDateFormat, simpleDateFormat2, j);
        if (strArrSplit[1].equalsIgnoreCase(DateTimeString.mMorning)) {
            StringBuilder sbM781w = AbstractC0541b.m781w(strAdjustTime, " ");
            sbM781w.append(strArrSplit[2]);
            return sbM781w.toString();
        }
        if (strArrSplit[1].equalsIgnoreCase(DateTimeString.mAfternoon) || strArrSplit[1].equalsIgnoreCase(DateTimeString.mEvening) || strArrSplit[1].equalsIgnoreCase(DateTimeString.mNight)) {
            return AbstractC0622a.m1170p(strArrSplit[2], "pm", AbstractC0541b.m781w(strAdjustTime, " "));
        }
        StringBuffer stringBuffer = new StringBuffer(strAdjustTime);
        int length = strArrSplit.length;
        for (int i = 1; i < length; i++) {
            stringBuffer.append(' ');
            stringBuffer.append(strArrSplit[i]);
        }
        return stringBuffer.toString();
    }
}
